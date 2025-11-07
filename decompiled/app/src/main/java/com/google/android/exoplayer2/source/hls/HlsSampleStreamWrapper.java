package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
final class HlsSampleStreamWrapper implements com.google.android.exoplayer2.extractor.ExtractorOutput, com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener, com.google.android.exoplayer2.source.SequenceableLoader, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.chunk.Chunk>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback {
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_FATAL = -2;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_NON_FATAL = -3;
    public static final int SAMPLE_QUEUE_INDEX_PENDING = -1;
    private static final java.lang.String TAG = "HlsSampleStreamWrapper";
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private boolean audioSampleQueueMappingDone;
    private final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback;
    private final com.google.android.exoplayer2.source.hls.HlsChunkSource chunkSource;
    private int chunkUid;
    private com.google.android.exoplayer2.Format downstreamTrackFormat;
    private int enabledTrackGroupCount;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private boolean haveAudioVideoSampleQueues;
    private long lastSeekPositionUs;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean loadingFinished;
    private final com.google.android.exoplayer2.Format muxedAudioFormat;
    private com.google.android.exoplayer2.source.TrackGroupArray optionalTrackGroups;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private boolean released;
    private long sampleOffsetUs;
    private boolean sampleQueuesBuilt;
    private boolean seenFirstTrackSelection;
    private int[] trackGroupToSampleQueueIndex;
    private com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private com.google.android.exoplayer2.Format upstreamTrackFormat;
    private boolean videoSampleQueueMappingDone;
    private final com.google.android.exoplayer2.upstream.Loader loader = new com.google.android.exoplayer2.upstream.Loader("Loader:HlsSampleStreamWrapper");
    private final com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder nextChunkHolder = new com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder();
    private int[] sampleQueueTrackIds = new int[0];
    private int audioSampleQueueIndex = -1;
    private int videoSampleQueueIndex = -1;
    private com.google.android.exoplayer2.source.SampleQueue[] sampleQueues = new com.google.android.exoplayer2.source.SampleQueue[0];
    private boolean[] sampleQueueIsAudioVideoFlags = new boolean[0];
    private boolean[] sampleQueuesEnabledStates = new boolean[0];
    private final java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> mediaChunks = new java.util.ArrayList<>();
    private final java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> readOnlyMediaChunks = java.util.Collections.unmodifiableList(this.mediaChunks);
    private final java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsSampleStream> hlsSampleStreams = new java.util.ArrayList<>();
    private final java.lang.Runnable maybeFinishPrepareRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.hls.-$$Lambda$HlsSampleStreamWrapper$8JyeEr0irIOShv9LlAxAmgzl5vY
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.maybeFinishPrepare();
        }
    };
    private final java.lang.Runnable onTracksEndedRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.hls.-$$Lambda$HlsSampleStreamWrapper$afhkI3tagC_-MAOTh7FzBWzQsno
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.onTracksEnded();
        }
    };
    private final android.os.Handler handler = new android.os.Handler();

    public interface Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl);

        void onPrepared();
    }

    private static int getTrackTypeScore(int i_renamed) {
        if (i_renamed == 1) {
            return 2;
        }
        if (i_renamed != 2) {
            return i_renamed != 3 ? 0 : 1;
        }
        return 3;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
    }

    public HlsSampleStreamWrapper(int i_renamed, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback, com.google.android.exoplayer2.source.hls.HlsChunkSource hlsChunkSource, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.trackType = i_renamed;
        this.callback = callback;
        this.chunkSource = hlsChunkSource;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.lastSeekPositionUs = j_renamed;
        this.pendingResetPositionUs = j_renamed;
    }

    public void continuePreparing() {
        if (this.prepared) {
            return;
        }
        continueLoading(this.lastSeekPositionUs);
    }

    public void prepareWithMasterPlaylistInfo(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int i_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2) {
        this.prepared = true;
        this.trackGroups = trackGroupArray;
        this.optionalTrackGroups = trackGroupArray2;
        this.primaryTrackGroupIndex = i_renamed;
        this.callback.onPrepared();
    }

    public void maybeThrowPrepareError() throws java.io.IOException {
        maybeThrowError();
    }

    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public int bindSampleQueueToSampleStream(int i_renamed) {
        int i2 = this.trackGroupToSampleQueueIndex[i_renamed];
        if (i2 == -1) {
            return this.optionalTrackGroups.indexOf(this.trackGroups.get(i_renamed)) == -1 ? -2 : -3;
        }
        boolean[] zArr = this.sampleQueuesEnabledStates;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public void unbindSampleQueue(int i_renamed) {
        int i2 = this.trackGroupToSampleQueueIndex[i_renamed];
        com.google.android.exoplayer2.util.Assertions.checkState(this.sampleQueuesEnabledStates[i2]);
        this.sampleQueuesEnabledStates[i2] = false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:70:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:73:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:75:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void discardBuffer(long j_renamed, boolean z_renamed) {
        if (!this.sampleQueuesBuilt || isPendingReset()) {
            return;
        }
        int length = this.sampleQueues.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.sampleQueues[i_renamed].discardTo(j_renamed, z_renamed, this.sampleQueuesEnabledStates[i_renamed]);
        }
    }

    public boolean seekToUs(long j_renamed, boolean z_renamed) {
        this.lastSeekPositionUs = j_renamed;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j_renamed;
            return true;
        }
        if (this.sampleQueuesBuilt && !z_renamed && seekInsideBufferUs(j_renamed)) {
            return false;
        }
        this.pendingResetPositionUs = j_renamed;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            resetSampleQueues();
        }
        return true;
    }

    public void release() {
        if (this.prepared) {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        resetSampleQueues();
    }

    public void setIsTimestampMaster(boolean z_renamed) {
        this.chunkSource.setIsTimestampMaster(z_renamed);
    }

    public boolean onPlaylistError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, long j_renamed) {
        return this.chunkSource.onPlaylistError(hlsUrl, j_renamed);
    }

    public boolean isReady(int i_renamed) {
        return this.loadingFinished || (!isPendingReset() && this.sampleQueues[i_renamed].hasNextSample());
    }

    public void maybeThrowError() throws java.io.IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public int readData(int i_renamed, com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        if (isPendingReset()) {
            return -3;
        }
        int i2 = 0;
        if (!this.mediaChunks.isEmpty()) {
            int i3 = 0;
            while (i3 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i3))) {
                i3++;
            }
            com.google.android.exoplayer2.util.Util.removeRange(this.mediaChunks, 0, i3);
            com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            com.google.android.exoplayer2.Format format = hlsMediaChunk.trackFormat;
            if (!format.equals(this.downstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.trackType, format, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format;
        }
        int i4 = this.sampleQueues[i_renamed].read(formatHolder, decoderInputBuffer, z_renamed, this.loadingFinished, this.lastSeekPositionUs);
        if (i4 == -5 && i_renamed == this.primarySampleQueueIndex) {
            int iPeekSourceId = this.sampleQueues[i_renamed].peekSourceId();
            while (i2 < this.mediaChunks.size() && this.mediaChunks.get(i2).uid != iPeekSourceId) {
                i2++;
            }
            formatHolder.format = formatHolder.format.copyWithManifestFormatInfo(i2 < this.mediaChunks.size() ? this.mediaChunks.get(i2).trackFormat : this.upstreamTrackFormat);
        }
        return i4;
    }

    public int skipData(int i_renamed, long j_renamed) {
        if (isPendingReset()) {
            return 0;
        }
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
        if (this.loadingFinished && j_renamed > sampleQueue.getLargestQueuedTimestampUs()) {
            return sampleQueue.advanceToEnd();
        }
        int iAdvanceTo = sampleQueue.advanceTo(j_renamed, true, true);
        if (iAdvanceTo == -1) {
            return 0;
        }
        return iAdvanceTo;
    }

    /*  JADX ERROR: NullPointerException in_renamed pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is_renamed null
        	at_renamed jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at_renamed jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        /*
            r6 = this;
            boolean r0 = r6.loadingFinished
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r6.isPendingReset()
            if (r0 == 0) goto L10
            long r0 = r6.pendingResetPositionUs
            return r0
        L10:
            long r0 = r6.lastSeekPositionUs
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = r6.getLastMediaChunk()
            boolean r3 = r2.isLoadCompleted()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r6.mediaChunks
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r6.mediaChunks
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.endTimeUs
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r6.sampleQueuesBuilt
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.SampleQueue[] r6 = r6.sampleQueues
            int r2 = r6.length
            r3 = 0
        L46:
            if (r3 >= r2) goto L55
            r4 = r6[r3]
            long r4 = r4.getLargestQueuedTimestampUs()
            long r0 = java.lang.Math.max(r0, r4)
            int r3 = r3 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.getBufferedPositionUs():long");
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> listEmptyList;
        long jMax;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        if (isPendingReset()) {
            listEmptyList = java.util.Collections.emptyList();
            jMax = this.pendingResetPositionUs;
        } else {
            listEmptyList = this.readOnlyMediaChunks;
            com.google.android.exoplayer2.source.hls.HlsMediaChunk lastMediaChunk = getLastMediaChunk();
            jMax = lastMediaChunk.isLoadCompleted() ? lastMediaChunk.endTimeUs : java.lang.Math.max(this.lastSeekPositionUs, lastMediaChunk.startTimeUs);
        }
        this.chunkSource.getNextChunk(j_renamed, jMax, listEmptyList, this.nextChunkHolder);
        boolean z_renamed = this.nextChunkHolder.endOfStream;
        com.google.android.exoplayer2.source.chunk.Chunk chunk = this.nextChunkHolder.chunk;
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = this.nextChunkHolder.playlist;
        this.nextChunkHolder.clear();
        if (z_renamed) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            if (hlsUrl != null) {
                this.callback.onPlaylistRefreshRequired(hlsUrl);
            }
            return false;
        }
        if (isMediaChunk(chunk)) {
            this.pendingResetPositionUs = -9223372036854775807L;
            com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) chunk;
            hlsMediaChunk.init(this);
            this.mediaChunks.add(hlsMediaChunk);
            this.upstreamTrackFormat = hlsMediaChunk.trackFormat;
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type)));
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, chunk.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2, boolean z_renamed) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, chunk.bytesLoaded());
        if (z_renamed) {
            return;
        }
        resetSampleQueues();
        if (this.enabledTrackGroupCount > 0) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long jBytesLoaded = chunk.bytesLoaded();
        boolean zIsMediaChunk = isMediaChunk(chunk);
        long blacklistDurationMsFor = this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(chunk.type, j2, iOException, i_renamed);
        boolean zMaybeBlacklistTrack = blacklistDurationMsFor != -9223372036854775807L ? this.chunkSource.maybeBlacklistTrack(chunk, blacklistDurationMsFor) : false;
        if (zMaybeBlacklistTrack) {
            if (zIsMediaChunk && jBytesLoaded == 0) {
                java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> arrayList = this.mediaChunks;
                com.google.android.exoplayer2.util.Assertions.checkState(arrayList.remove(arrayList.size() - 1) == chunk);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            loadErrorActionCreateRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(chunk.type, j2, iOException, i_renamed);
            loadErrorActionCreateRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorAction = loadErrorActionCreateRetryAction;
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, jBytesLoaded, iOException, !loadErrorAction.isRetry());
        if (zMaybeBlacklistTrack) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction;
    }

    public void init(int i_renamed, boolean z_renamed, boolean z2) {
        if (!z2) {
            this.audioSampleQueueMappingDone = false;
            this.videoSampleQueueMappingDone = false;
        }
        this.chunkUid = i_renamed;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.sourceId(i_renamed);
        }
        if (z_renamed) {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue2 : this.sampleQueues) {
                sampleQueue2.splice();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i_renamed, int i2) {
        com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.sampleQueues;
        int length = sampleQueueArr.length;
        if (i2 == 1) {
            int i3 = this.audioSampleQueueIndex;
            if (i3 != -1) {
                if (this.audioSampleQueueMappingDone) {
                    return this.sampleQueueTrackIds[i3] == i_renamed ? sampleQueueArr[i3] : createDummyTrackOutput(i_renamed, i2);
                }
                this.audioSampleQueueMappingDone = true;
                this.sampleQueueTrackIds[i3] = i_renamed;
                return sampleQueueArr[i3];
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i_renamed, i2);
            }
        } else if (i2 == 2) {
            int i4 = this.videoSampleQueueIndex;
            if (i4 != -1) {
                if (this.videoSampleQueueMappingDone) {
                    return this.sampleQueueTrackIds[i4] == i_renamed ? sampleQueueArr[i4] : createDummyTrackOutput(i_renamed, i2);
                }
                this.videoSampleQueueMappingDone = true;
                this.sampleQueueTrackIds[i4] = i_renamed;
                return sampleQueueArr[i4];
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i_renamed, i2);
            }
        } else {
            for (int i5 = 0; i5 < length; i5++) {
                if (this.sampleQueueTrackIds[i5] == i_renamed) {
                    return this.sampleQueues[i5];
                }
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i_renamed, i2);
            }
        }
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.PrivTimestampStrippingSampleQueue privTimestampStrippingSampleQueue = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.PrivTimestampStrippingSampleQueue(this.allocator);
        privTimestampStrippingSampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        privTimestampStrippingSampleQueue.sourceId(this.chunkUid);
        privTimestampStrippingSampleQueue.setUpstreamFormatChangeListener(this);
        int i6 = length + 1;
        this.sampleQueueTrackIds = java.util.Arrays.copyOf(this.sampleQueueTrackIds, i6);
        this.sampleQueueTrackIds[length] = i_renamed;
        this.sampleQueues = (com.google.android.exoplayer2.source.SampleQueue[]) java.util.Arrays.copyOf(this.sampleQueues, i6);
        this.sampleQueues[length] = privTimestampStrippingSampleQueue;
        this.sampleQueueIsAudioVideoFlags = java.util.Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i6);
        this.sampleQueueIsAudioVideoFlags[length] = i2 == 1 || i2 == 2;
        this.haveAudioVideoSampleQueues |= this.sampleQueueIsAudioVideoFlags[length];
        if (i2 == 1) {
            this.audioSampleQueueMappingDone = true;
            this.audioSampleQueueIndex = length;
        } else if (i2 == 2) {
            this.videoSampleQueueMappingDone = true;
            this.videoSampleQueueIndex = length;
        }
        if (getTrackTypeScore(i2) > getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = length;
            this.primarySampleQueueType = i2;
        }
        this.sampleQueuesEnabledStates = java.util.Arrays.copyOf(this.sampleQueuesEnabledStates, i6);
        return privTimestampStrippingSampleQueue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void setSampleOffsetUs(long j_renamed) {
        this.sampleOffsetUs = j_renamed;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.setSampleOffsetUs(j_renamed);
        }
    }

    private void updateSampleStreams(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        this.hlsSampleStreams.clear();
        for (com.google.android.exoplayer2.source.SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.hlsSampleStreams.add((com.google.android.exoplayer2.source.hls.HlsSampleStream) sampleStream);
            }
        }
    }

    private boolean finishedReadingChunk(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk) {
        int i_renamed = hlsMediaChunk.uid;
        int length = this.sampleQueues.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.sampleQueuesEnabledStates[i2] && this.sampleQueues[i2].peekSourceId() == i_renamed) {
                return false;
            }
        }
        return true;
    }

    private void resetSampleQueues() {
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracksFromSampleStreams();
            this.prepared = true;
            this.callback.onPrepared();
        }
    }

    private void mapSampleQueuesToMatchTrackGroups() {
        int i_renamed = this.trackGroups.length;
        this.trackGroupToSampleQueueIndex = new int[i_renamed];
        java.util.Arrays.fill(this.trackGroupToSampleQueueIndex, -1);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            int i3 = 0;
            while (true) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.sampleQueues;
                if (i3 >= sampleQueueArr.length) {
                    break;
                }
                if (formatsMatch(sampleQueueArr[i3].getUpstreamFormat(), this.trackGroups.get(i2).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        java.util.Iterator<com.google.android.exoplayer2.source.hls.HlsSampleStream> it = this.hlsSampleStreams.iterator();
        while (it.hasNext()) {
            it.next().bindSampleQueue();
        }
    }

    private void buildTracksFromSampleStreams() {
        int length = this.sampleQueues.length;
        int i_renamed = 6;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = 2;
            if (i3 >= length) {
                break;
            }
            java.lang.String str = this.sampleQueues[i3].getUpstreamFormat().sampleMimeType;
            if (!com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
                if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
                    i4 = 1;
                } else {
                    i4 = com.google.android.exoplayer2.util.MimeTypes.isText(str) ? 3 : 6;
                }
            }
            if (getTrackTypeScore(i4) > getTrackTypeScore(i_renamed)) {
                i2 = i3;
                i_renamed = i4;
            } else if (i4 == i_renamed && i2 != -1) {
                i2 = -1;
            }
            i3++;
        }
        com.google.android.exoplayer2.source.TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i5 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.trackGroupToSampleQueueIndex[i6] = i6;
        }
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[length];
        for (int i7 = 0; i7 < length; i7++) {
            com.google.android.exoplayer2.Format upstreamFormat = this.sampleQueues[i7].getUpstreamFormat();
            if (i7 == i2) {
                com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[i5];
                if (i5 == 1) {
                    formatArr[0] = upstreamFormat.copyWithManifestFormatInfo(trackGroup.getFormat(0));
                } else {
                    for (int i8 = 0; i8 < i5; i8++) {
                        formatArr[i8] = deriveFormat(trackGroup.getFormat(i8), upstreamFormat, true);
                    }
                }
                trackGroupArr[i7] = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i7;
            } else {
                trackGroupArr[i7] = new com.google.android.exoplayer2.source.TrackGroup(deriveFormat((i_renamed == 2 && com.google.android.exoplayer2.util.MimeTypes.isAudio(upstreamFormat.sampleMimeType)) ? this.muxedAudioFormat : null, upstreamFormat, false));
            }
        }
        this.trackGroups = new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
        com.google.android.exoplayer2.util.Assertions.checkState(this.optionalTrackGroups == null);
        this.optionalTrackGroups = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
    }

    private com.google.android.exoplayer2.source.hls.HlsMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r1.size() - 1);
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private boolean seekInsideBufferUs(long j_renamed) {
        int length = this.sampleQueues.length;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                return true;
            }
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
            sampleQueue.rewind();
            if (!(sampleQueue.advanceTo(j_renamed, true, false) != -1) && (this.sampleQueueIsAudioVideoFlags[i_renamed] || !this.haveAudioVideoSampleQueues)) {
                break;
            }
            i_renamed++;
        }
        return false;
    }

    private static com.google.android.exoplayer2.Format deriveFormat(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2, boolean z_renamed) {
        if (format == null) {
            return format2;
        }
        int i_renamed = z_renamed ? format.bitrate : -1;
        java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, com.google.android.exoplayer2.util.MimeTypes.getTrackType(format2.sampleMimeType));
        java.lang.String mediaMimeType = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType);
        if (mediaMimeType == null) {
            mediaMimeType = format2.sampleMimeType;
        }
        return format2.copyWithContainerInfo(format.id_renamed, format.label, mediaMimeType, codecsOfType, i_renamed, format.width, format.height, format.selectionFlags, format.language);
    }

    private static boolean isMediaChunk(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.hls.HlsMediaChunk;
    }

    private static boolean formatsMatch(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        java.lang.String str = format.sampleMimeType;
        java.lang.String str2 = format2.sampleMimeType;
        int trackType = com.google.android.exoplayer2.util.MimeTypes.getTrackType(str);
        if (trackType != 3) {
            return trackType == com.google.android.exoplayer2.util.MimeTypes.getTrackType(str2);
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(str, str2)) {
            return !(com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708.equals(str)) || format.accessibilityChannel == format2.accessibilityChannel;
        }
        return false;
    }

    private static com.google.android.exoplayer2.extractor.DummyTrackOutput createDummyTrackOutput(int i_renamed, int i2) {
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unmapped track with id_renamed " + i_renamed + " of_renamed type " + i2);
        return new com.google.android.exoplayer2.extractor.DummyTrackOutput();
    }

    private static final class PrivTimestampStrippingSampleQueue extends com.google.android.exoplayer2.source.SampleQueue {
        public PrivTimestampStrippingSampleQueue(com.google.android.exoplayer2.upstream.Allocator allocator) {
            super(allocator);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue, com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            super.format(format.copyWithMetadata(getAdjustedMetadata(format.metadata)));
        }

        private com.google.android.exoplayer2.metadata.Metadata getAdjustedMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i_renamed = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof com.google.android.exoplayer2.metadata.id3.PrivFrame) && com.google.android.exoplayer2.source.hls.HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(((com.google.android.exoplayer2.metadata.id3.PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            com.google.android.exoplayer2.metadata.Metadata.Entry[] entryArr = new com.google.android.exoplayer2.metadata.Metadata.Entry[length - 1];
            while (i_renamed < length) {
                if (i_renamed != i2) {
                    entryArr[i_renamed < i2 ? i_renamed : i_renamed - 1] = metadata.get(i_renamed);
                }
                i_renamed++;
            }
            return new com.google.android.exoplayer2.metadata.Metadata(entryArr);
        }
    }
}
