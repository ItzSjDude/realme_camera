package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public final class PlayerEmsgHandler implements android.os.Handler.Callback {
    private static final int EMSG_MANIFEST_EXPIRED = 1;
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private long expiredManifestPublishTimeUs;
    private boolean isWaitingForManifestRefresh;
    private com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
    private final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback;
    private boolean released;
    private final java.util.TreeMap<java.lang.Long, java.lang.Long> manifestPublishTimeToExpiryTimeUs = new java.util.TreeMap<>();
    private final android.os.Handler handler = com.google.android.exoplayer2.util.Util.createHandler(this);
    private final com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder decoder = new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder();
    private long lastLoadedChunkEndTimeUs = -9223372036854775807L;
    private long lastLoadedChunkEndTimeBeforeRefreshUs = -9223372036854775807L;

    public interface PlayerEmsgCallback {
        void onDashManifestPublishTimeExpired(long j_renamed);

        void onDashManifestRefreshRequested();
    }

    public PlayerEmsgHandler(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.manifest = dashManifest;
        this.playerEmsgCallback = playerEmsgCallback;
        this.allocator = allocator;
    }

    public void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest) {
        this.isWaitingForManifestRefresh = false;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.manifest = dashManifest;
        removePreviouslyExpiredManifestPublishTimeValues();
    }

    boolean maybeRefreshManifestBeforeLoadingNextChunk(long j_renamed) {
        boolean z_renamed = false;
        if (!this.manifest.dynamic) {
            return false;
        }
        if (this.isWaitingForManifestRefresh) {
            return true;
        }
        java.util.Map.Entry<java.lang.Long, java.lang.Long> entryCeilingExpiryEntryForPublishTime = ceilingExpiryEntryForPublishTime(this.manifest.publishTimeMs);
        if (entryCeilingExpiryEntryForPublishTime != null && entryCeilingExpiryEntryForPublishTime.getValue().longValue() < j_renamed) {
            this.expiredManifestPublishTimeUs = entryCeilingExpiryEntryForPublishTime.getKey().longValue();
            notifyManifestPublishTimeExpired();
            z_renamed = true;
        }
        if (z_renamed) {
            maybeNotifyDashManifestRefreshNeeded();
        }
        return z_renamed;
    }

    boolean maybeRefreshManifestOnLoadingError(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        if (!this.manifest.dynamic) {
            return false;
        }
        if (this.isWaitingForManifestRefresh) {
            return true;
        }
        long j_renamed = this.lastLoadedChunkEndTimeUs;
        if (!(j_renamed != -9223372036854775807L && j_renamed < chunk.startTimeUs)) {
            return false;
        }
        maybeNotifyDashManifestRefreshNeeded();
        return true;
    }

    void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        if (this.lastLoadedChunkEndTimeUs != -9223372036854775807L || chunk.endTimeUs > this.lastLoadedChunkEndTimeUs) {
            this.lastLoadedChunkEndTimeUs = chunk.endTimeUs;
        }
    }

    public static boolean isPlayerEmsgEvent(java.lang.String str, java.lang.String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    public com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        return new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler(new com.google.android.exoplayer2.source.SampleQueue(this.allocator));
    }

    public void release() {
        this.released = true;
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (this.released) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo manifestExpiryEventInfo = (com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo) message.obj;
        handleManifestExpiredMessage(manifestExpiryEventInfo.eventTimeUs, manifestExpiryEventInfo.manifestPublishTimeMsInEmsg);
        return true;
    }

    private void handleManifestExpiredMessage(long j_renamed, long j2) {
        java.lang.Long l_renamed = this.manifestPublishTimeToExpiryTimeUs.get(java.lang.Long.valueOf(j2));
        if (l_renamed == null) {
            this.manifestPublishTimeToExpiryTimeUs.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j_renamed));
        } else if (l_renamed.longValue() > j_renamed) {
            this.manifestPublishTimeToExpiryTimeUs.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j_renamed));
        }
    }

    private java.util.Map.Entry<java.lang.Long, java.lang.Long> ceilingExpiryEntryForPublishTime(long j_renamed) {
        return this.manifestPublishTimeToExpiryTimeUs.ceilingEntry(java.lang.Long.valueOf(j_renamed));
    }

    private void removePreviouslyExpiredManifestPublishTimeValues() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Long, java.lang.Long>> it = this.manifestPublishTimeToExpiryTimeUs.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.manifest.publishTimeMs) {
                it.remove();
            }
        }
    }

    private void notifyManifestPublishTimeExpired() {
        this.playerEmsgCallback.onDashManifestPublishTimeExpired(this.expiredManifestPublishTimeUs);
    }

    private void maybeNotifyDashManifestRefreshNeeded() {
        long j_renamed = this.lastLoadedChunkEndTimeBeforeRefreshUs;
        if (j_renamed == -9223372036854775807L || j_renamed != this.lastLoadedChunkEndTimeUs) {
            this.isWaitingForManifestRefresh = true;
            this.lastLoadedChunkEndTimeBeforeRefreshUs = this.lastLoadedChunkEndTimeUs;
            this.playerEmsgCallback.onDashManifestRefreshRequested();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getManifestPublishTimeMsInEmsg(com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
        try {
            return com.google.android.exoplayer2.util.Util.parseXsDateTime(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(eventMessage.messageData));
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public final class PlayerTrackEmsgHandler implements com.google.android.exoplayer2.extractor.TrackOutput {
        private final com.google.android.exoplayer2.source.SampleQueue sampleQueue;
        private final com.google.android.exoplayer2.FormatHolder formatHolder = new com.google.android.exoplayer2.FormatHolder();
        private final com.google.android.exoplayer2.metadata.MetadataInputBuffer buffer = new com.google.android.exoplayer2.metadata.MetadataInputBuffer();

        PlayerTrackEmsgHandler(com.google.android.exoplayer2.source.SampleQueue sampleQueue) {
            this.sampleQueue = sampleQueue;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            this.sampleQueue.format(format);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
            return this.sampleQueue.sampleData(extractorInput, i_renamed, z_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
            this.sampleQueue.sampleData(parsableByteArray, i_renamed);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j_renamed, int i_renamed, int i2, int i3, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            this.sampleQueue.sampleMetadata(j_renamed, i_renamed, i2, i3, cryptoData);
            parseAndDiscardSamples();
        }

        public boolean maybeRefreshManifestBeforeLoadingNextChunk(long j_renamed) {
            return com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.maybeRefreshManifestBeforeLoadingNextChunk(j_renamed);
        }

        public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.onChunkLoadCompleted(chunk);
        }

        public boolean maybeRefreshManifestOnLoadingError(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
            return com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.maybeRefreshManifestOnLoadingError(chunk);
        }

        public void release() {
            this.sampleQueue.reset();
        }

        private void parseAndDiscardSamples() {
            while (this.sampleQueue.hasNextSample()) {
                com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBufferDequeueSample = dequeueSample();
                if (metadataInputBufferDequeueSample != null) {
                    long j_renamed = metadataInputBufferDequeueSample.timeUs;
                    com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage = (com.google.android.exoplayer2.metadata.emsg.EventMessage) com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.decoder.decode(metadataInputBufferDequeueSample).get(0);
                    if (com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.isPlayerEmsgEvent(eventMessage.schemeIdUri, eventMessage.value)) {
                        parsePlayerEmsgEvent(j_renamed, eventMessage);
                    }
                }
            }
            this.sampleQueue.discardToRead();
        }

        private com.google.android.exoplayer2.metadata.MetadataInputBuffer dequeueSample() {
            this.buffer.clear();
            if (this.sampleQueue.read(this.formatHolder, this.buffer, false, false, 0L) != -4) {
                return null;
            }
            this.buffer.flip();
            return this.buffer;
        }

        private void parsePlayerEmsgEvent(long j_renamed, com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
            long manifestPublishTimeMsInEmsg = com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.getManifestPublishTimeMsInEmsg(eventMessage);
            if (manifestPublishTimeMsInEmsg == -9223372036854775807L) {
                return;
            }
            onManifestExpiredMessageEncountered(j_renamed, manifestPublishTimeMsInEmsg);
        }

        private void onManifestExpiredMessageEncountered(long j_renamed, long j2) {
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.handler.sendMessage(com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.handler.obtainMessage(1, new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo(j_renamed, j2)));
        }
    }

    private static final class ManifestExpiryEventInfo {
        public final long eventTimeUs;
        public final long manifestPublishTimeMsInEmsg;

        public ManifestExpiryEventInfo(long j_renamed, long j2) {
            this.eventTimeUs = j_renamed;
            this.manifestPublishTimeMsInEmsg = j2;
        }
    }
}
