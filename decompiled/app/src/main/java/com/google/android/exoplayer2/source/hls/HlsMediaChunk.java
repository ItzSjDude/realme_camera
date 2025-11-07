package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
final class HlsMediaChunk extends com.google.android.exoplayer2.source.chunk.MediaChunk {
    public static final java.lang.String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    private static final java.util.concurrent.atomic.AtomicInteger uidSource = new java.util.concurrent.atomic.AtomicInteger();
    public final int discontinuitySequenceNumber;
    private final com.google.android.exoplayer2.drm.DrmInitData drmInitData;
    private com.google.android.exoplayer2.extractor.Extractor extractor;
    private final com.google.android.exoplayer2.source.hls.HlsExtractorFactory extractorFactory;
    private final boolean hasGapTag;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl;
    private final com.google.android.exoplayer2.util.ParsableByteArray id3Data;
    private final com.google.android.exoplayer2.metadata.id3.Id3Decoder id3Decoder;
    private final com.google.android.exoplayer2.upstream.DataSource initDataSource;
    private final com.google.android.exoplayer2.upstream.DataSpec initDataSpec;
    private boolean initLoadCompleted;
    private int initSegmentBytesLoaded;
    private final boolean isEncrypted;
    private final boolean isMasterTimestampSource;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final java.util.List<com.google.android.exoplayer2.Format> muxedCaptionFormats;
    private int nextLoadPosition;
    private com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper output;
    private final com.google.android.exoplayer2.extractor.Extractor previousExtractor;
    private final boolean shouldSpliceIn;
    private final com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
    public final int uid;

    public HlsMediaChunk(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSpec dataSpec2, com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, java.util.List<com.google.android.exoplayer2.Format> list, int i_renamed, java.lang.Object obj, long j_renamed, long j2, long j3, int i2, boolean z_renamed, boolean z2, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, com.google.android.exoplayer2.drm.DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(buildDataSource(dataSource, bArr, bArr2), dataSpec, hlsUrl.format, i_renamed, obj, j_renamed, j2, j3);
        this.discontinuitySequenceNumber = i2;
        this.initDataSpec = dataSpec2;
        this.hlsUrl = hlsUrl;
        this.isMasterTimestampSource = z2;
        this.timestampAdjuster = timestampAdjuster;
        boolean z3 = true;
        this.isEncrypted = bArr != null;
        this.hasGapTag = z_renamed;
        this.extractorFactory = hlsExtractorFactory;
        this.muxedCaptionFormats = list;
        this.drmInitData = drmInitData;
        com.google.android.exoplayer2.extractor.Extractor extractor = null;
        if (hlsMediaChunk != null) {
            this.id3Decoder = hlsMediaChunk.id3Decoder;
            this.id3Data = hlsMediaChunk.id3Data;
            if (hlsMediaChunk.hlsUrl == hlsUrl && hlsMediaChunk.loadCompleted) {
                z3 = false;
            }
            this.shouldSpliceIn = z3;
            if (hlsMediaChunk.discontinuitySequenceNumber == i2 && !this.shouldSpliceIn) {
                extractor = hlsMediaChunk.extractor;
            }
        } else {
            this.id3Decoder = new com.google.android.exoplayer2.metadata.id3.Id3Decoder();
            this.id3Data = new com.google.android.exoplayer2.util.ParsableByteArray(10);
            this.shouldSpliceIn = false;
        }
        this.previousExtractor = extractor;
        this.initDataSource = dataSource;
        this.uid = uidSource.getAndIncrement();
    }

    public void init(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.output = hlsSampleStreamWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws java.lang.InterruptedException, java.io.IOException {
        maybeLoadInitData();
        if (this.loadCanceled) {
            return;
        }
        if (!this.hasGapTag) {
            loadMedia();
        }
        this.loadCompleted = true;
    }

    private void maybeLoadInitData() throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        if (this.initLoadCompleted || (dataSpec = this.initDataSpec) == null) {
            return;
        }
        try {
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInputPrepareExtraction = prepareExtraction(this.initDataSource, dataSpec.subrange(this.initSegmentBytesLoaded));
            int i_renamed = 0;
            while (i_renamed == 0) {
                try {
                    if (this.loadCanceled) {
                        break;
                    } else {
                        i_renamed = this.extractor.read(defaultExtractorInputPrepareExtraction, null);
                    }
                } finally {
                    this.initSegmentBytesLoaded = (int) (defaultExtractorInputPrepareExtraction.getPosition() - this.initDataSpec.absoluteStreamPosition);
                }
            }
            com.google.android.exoplayer2.util.Util.closeQuietly(this.initDataSource);
            this.initLoadCompleted = true;
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.initDataSource);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x003f A_renamed[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #1 {all -> 0x0072, blocks: (B_renamed:15:0x0037, B_renamed:17:0x003f, B_renamed:26:0x0060, B_renamed:24:0x0053, B_renamed:25:0x005f, B_renamed:19:0x0046, B_renamed:21:0x004a), top: B_renamed:34:0x0037, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0046 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadMedia() throws java.lang.InterruptedException, java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.isEncrypted
            r1 = 0
            if (r0 == 0) goto Ld
            com.google.android.exoplayer2.upstream.DataSpec r0 = r7.dataSpec
            int r2 = r7.nextLoadPosition
            if (r2 == 0) goto L16
            r2 = 1
            goto L17
        Ld:
            com.google.android.exoplayer2.upstream.DataSpec r0 = r7.dataSpec
            int r2 = r7.nextLoadPosition
            long r2 = (long) r2
            com.google.android.exoplayer2.upstream.DataSpec r0 = r0.subrange(r2)
        L16:
            r2 = r1
        L17:
            boolean r3 = r7.isMasterTimestampSource
            if (r3 != 0) goto L21
            com.google.android.exoplayer2.util.TimestampAdjuster r3 = r7.timestampAdjuster
            r3.waitUntilInitialized()
            goto L37
        L21:
            com.google.android.exoplayer2.util.TimestampAdjuster r3 = r7.timestampAdjuster
            long r3 = r3.getFirstSampleTimestampUs()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L37
            com.google.android.exoplayer2.util.TimestampAdjuster r3 = r7.timestampAdjuster
            long r4 = r7.startTimeUs
            r3.setFirstSampleTimestampUs(r4)
        L37:
            com.google.android.exoplayer2.upstream.StatsDataSource r3 = r7.dataSource     // Catch: java.lang.Throwable -> L72
            com.google.android.exoplayer2.extractor.DefaultExtractorInput r0 = r7.prepareExtraction(r3, r0)     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto L44
            int r2 = r7.nextLoadPosition     // Catch: java.lang.Throwable -> L72
            r0.skipFully(r2)     // Catch: java.lang.Throwable -> L72
        L44:
            if (r1 != 0) goto L60
            boolean r1 = r7.loadCanceled     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L60
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.extractor     // Catch: java.lang.Throwable -> L52
            r2 = 0
            int r1 = r1.read(r0, r2)     // Catch: java.lang.Throwable -> L52
            goto L44
        L52:
            r1 = move-exception
            long r2 = r0.getPosition()     // Catch: java.lang.Throwable -> L72
            com.google.android.exoplayer2.upstream.DataSpec r0 = r7.dataSpec     // Catch: java.lang.Throwable -> L72
            long r4 = r0.absoluteStreamPosition     // Catch: java.lang.Throwable -> L72
            long r2 = r2 - r4
            int r0 = (int) r2     // Catch: java.lang.Throwable -> L72
            r7.nextLoadPosition = r0     // Catch: java.lang.Throwable -> L72
            throw r1     // Catch: java.lang.Throwable -> L72
        L60:
            long r0 = r0.getPosition()     // Catch: java.lang.Throwable -> L72
            com.google.android.exoplayer2.upstream.DataSpec r2 = r7.dataSpec     // Catch: java.lang.Throwable -> L72
            long r2 = r2.absoluteStreamPosition     // Catch: java.lang.Throwable -> L72
            long r0 = r0 - r2
            int r0 = (int) r0     // Catch: java.lang.Throwable -> L72
            r7.nextLoadPosition = r0     // Catch: java.lang.Throwable -> L72
            com.google.android.exoplayer2.upstream.StatsDataSource r7 = r7.dataSource
            com.google.android.exoplayer2.util.Util.closeQuietly(r7)
            return
        L72:
            r0 = move-exception
            com.google.android.exoplayer2.upstream.StatsDataSource r7 = r7.dataSource
            com.google.android.exoplayer2.util.Util.closeQuietly(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaChunk.loadMedia():void");
    }

    private com.google.android.exoplayer2.extractor.DefaultExtractorInput prepareExtraction(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(dataSource, dataSpec.absoluteStreamPosition, dataSource.open(dataSpec));
        if (this.extractor != null) {
            return defaultExtractorInput;
        }
        long jPeekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
        defaultExtractorInput.resetPeekPosition();
        android.util.Pair<com.google.android.exoplayer2.extractor.Extractor, java.lang.Boolean> pairCreateExtractor = this.extractorFactory.createExtractor(this.previousExtractor, dataSpec.uri, this.trackFormat, this.muxedCaptionFormats, this.drmInitData, this.timestampAdjuster, dataSource.getResponseHeaders(), defaultExtractorInput);
        this.extractor = (com.google.android.exoplayer2.extractor.Extractor) pairCreateExtractor.first;
        boolean z_renamed = this.extractor == this.previousExtractor;
        if (((java.lang.Boolean) pairCreateExtractor.second).booleanValue()) {
            this.output.setSampleOffsetUs(jPeekId3PrivTimestamp != -9223372036854775807L ? this.timestampAdjuster.adjustTsTimestamp(jPeekId3PrivTimestamp) : this.startTimeUs);
        }
        this.initLoadCompleted = z_renamed && this.initDataSpec != null;
        this.output.init(this.uid, this.shouldSpliceIn, z_renamed);
        if (z_renamed) {
            return defaultExtractorInput;
        }
        this.extractor.init(this.output);
        return defaultExtractorInput;
    }

    private long peekId3PrivTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.resetPeekPosition();
        try {
            extractorInput.peekFully(this.id3Data.data, 0, 10);
            this.id3Data.reset(10);
        } catch (java.io.EOFException unused) {
        }
        if (this.id3Data.readUnsignedInt24() != com.google.android.exoplayer2.metadata.id3.Id3Decoder.ID3_TAG) {
            return -9223372036854775807L;
        }
        this.id3Data.skipBytes(3);
        int synchSafeInt = this.id3Data.readSynchSafeInt();
        int i_renamed = synchSafeInt + 10;
        if (i_renamed > this.id3Data.capacity()) {
            byte[] bArr = this.id3Data.data;
            this.id3Data.reset(i_renamed);
            java.lang.System.arraycopy(bArr, 0, this.id3Data.data, 0, 10);
        }
        extractorInput.peekFully(this.id3Data.data, 10, synchSafeInt);
        com.google.android.exoplayer2.metadata.Metadata metadataDecode = this.id3Decoder.decode(this.id3Data.data, synchSafeInt);
        if (metadataDecode == null) {
            return -9223372036854775807L;
        }
        int length = metadataDecode.length();
        for (int i2 = 0; i2 < length; i2++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadataDecode.get(i2);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.PrivFrame) {
                com.google.android.exoplayer2.metadata.id3.PrivFrame privFrame = (com.google.android.exoplayer2.metadata.id3.PrivFrame) entry;
                if (PRIV_TIMESTAMP_FRAME_OWNER.equals(privFrame.owner)) {
                    java.lang.System.arraycopy(privFrame.privateData, 0, this.id3Data.data, 0, 8);
                    this.id3Data.reset(8);
                    return this.id3Data.readLong() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    private static com.google.android.exoplayer2.upstream.DataSource buildDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, byte[] bArr, byte[] bArr2) {
        return bArr != null ? new com.google.android.exoplayer2.source.hls.Aes128DataSource(dataSource, bArr, bArr2) : dataSource;
    }
}
