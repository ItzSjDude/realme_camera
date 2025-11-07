package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
class HlsChunkSource {
    private final com.google.android.exoplayer2.upstream.DataSource encryptionDataSource;
    private byte[] encryptionIv;
    private java.lang.String encryptionIvString;
    private byte[] encryptionKey;
    private android.net.Uri encryptionKeyUri;
    private com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
    private final com.google.android.exoplayer2.source.hls.HlsExtractorFactory extractorFactory;
    private java.io.IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private long liveEdgeInPeriodTimeUs = -9223372036854775807L;
    private final com.google.android.exoplayer2.upstream.DataSource mediaDataSource;
    private final java.util.List<com.google.android.exoplayer2.Format> muxedCaptionFormats;
    private final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker playlistTracker;
    private byte[] scratchSpace;
    private boolean seenExpectedPlaylistError;
    private final com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider timestampAdjusterProvider;
    private final com.google.android.exoplayer2.source.TrackGroup trackGroup;
    private com.google.android.exoplayer2.trackselection.TrackSelection trackSelection;
    private final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[] variants;

    public static final class HlsChunkHolder {
        public com.google.android.exoplayer2.source.chunk.Chunk chunk;
        public boolean endOfStream;
        public com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlist = null;
        }
    }

    public HlsChunkSource(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl[] hlsUrlArr, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider timestampAdjusterProvider, java.util.List<com.google.android.exoplayer2.Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i_renamed = 0; i_renamed < hlsUrlArr.length; i_renamed++) {
            formatArr[i_renamed] = hlsUrlArr[i_renamed].format;
            iArr[i_renamed] = i_renamed;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        if (transferListener != null) {
            this.mediaDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
        this.trackSelection = new com.google.android.exoplayer2.source.hls.HlsChunkSource.InitializationTrackSelection(this.trackGroup, iArr);
    }

    public void maybeThrowError() throws java.io.IOException {
        java.io.IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = this.expectedPlaylistUrl;
        if (hlsUrl == null || !this.seenExpectedPlaylistError) {
            return;
        }
        this.playlistTracker.maybeThrowPlaylistRefreshError(hlsUrl);
    }

    public com.google.android.exoplayer2.source.TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public com.google.android.exoplayer2.trackselection.TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean z_renamed) {
        this.isTimestampMaster = z_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0055 A_renamed[PHI: r2
      0x0055: PHI (r2v2 long) = (r2v1 long), (r2v1 long), (r2v19 long) binds: [B_renamed:10:0x0032, B_renamed:12:0x0036, B_renamed:14:0x004a] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getNextChunk(long r40, long r42, java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r44, com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder r45) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsChunkSource.getNextChunk(long, long, java.util.List, com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder):void");
    }

    public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        if (chunk instanceof com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk) {
            com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk encryptionKeyChunk = (com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.iv_renamed, encryptionKeyChunk.getResult());
        }
    }

    public boolean maybeBlacklistTrack(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed) {
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.trackSelection;
        return trackSelection.blacklist(trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j_renamed);
    }

    public boolean onPlaylistError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, long j_renamed) {
        int iIndexOf;
        int iIndexOf2 = this.trackGroup.indexOf(hlsUrl.format);
        if (iIndexOf2 == -1 || (iIndexOf = this.trackSelection.indexOf(iIndexOf2)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError = (this.expectedPlaylistUrl == hlsUrl) | this.seenExpectedPlaylistError;
        return j_renamed == -9223372036854775807L || this.trackSelection.blacklist(iIndexOf, j_renamed);
    }

    public com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] createMediaChunkIterators(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, long j_renamed) {
        int iIndexOf = hlsMediaChunk == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[this.trackSelection.length()];
        for (int i_renamed = 0; i_renamed < mediaChunkIteratorArr.length; i_renamed++) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i_renamed);
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = this.variants[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(hlsUrl)) {
                mediaChunkIteratorArr[i_renamed] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
            } else {
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl, false);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                long chunkMediaSequence = getChunkMediaSequence(hlsMediaChunk, indexInTrackGroup != iIndexOf, playlistSnapshot, initialStartTimeUs, j_renamed);
                if (chunkMediaSequence < playlistSnapshot.mediaSequence) {
                    mediaChunkIteratorArr[i_renamed] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i_renamed] = new com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsMediaPlaylistSegmentIterator(playlistSnapshot, initialStartTimeUs, (int) (chunkMediaSequence - playlistSnapshot.mediaSequence));
                }
            }
        }
        return mediaChunkIteratorArr;
    }

    private long getChunkMediaSequence(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, boolean z_renamed, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, long j_renamed, long j2) {
        long jBinarySearchFloor;
        long size;
        if (hlsMediaChunk == null || z_renamed) {
            long j3 = hlsMediaPlaylist.durationUs + j_renamed;
            if (hlsMediaChunk != null && !this.independentSegments) {
                j2 = hlsMediaChunk.startTimeUs;
            }
            if (!hlsMediaPlaylist.hasEndTag && j2 >= j3) {
                jBinarySearchFloor = hlsMediaPlaylist.mediaSequence;
                size = hlsMediaPlaylist.segments.size();
            } else {
                jBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor((java.util.List<? extends java.lang.Comparable<? super java.lang.Long>>) hlsMediaPlaylist.segments, java.lang.Long.valueOf(j2 - j_renamed), true, !this.playlistTracker.isLive() || hlsMediaChunk == null);
                size = hlsMediaPlaylist.mediaSequence;
            }
            return jBinarySearchFloor + size;
        }
        return hlsMediaChunk.getNextChunkIndex();
    }

    private long resolveTimeToLiveEdgeUs(long j_renamed) {
        if (this.liveEdgeInPeriodTimeUs != -9223372036854775807L) {
            return this.liveEdgeInPeriodTimeUs - j_renamed;
        }
        return -9223372036854775807L;
    }

    private void updateLiveEdgeTimeUs(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        this.liveEdgeInPeriodTimeUs = hlsMediaPlaylist.hasEndTag ? -9223372036854775807L : hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }

    private com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk newEncryptionKeyChunk(android.net.Uri uri, java.lang.String str, int i_renamed, int i2, java.lang.Object obj) {
        return new com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk(this.encryptionDataSource, new com.google.android.exoplayer2.upstream.DataSpec(uri, 0L, -1L, null, 1), this.variants[i_renamed].format, i2, obj, this.scratchSpace, str);
    }

    private void setEncryptionData(android.net.Uri uri, java.lang.String str, byte[] bArr) {
        byte[] byteArray = new java.math.BigInteger(com.google.android.exoplayer2.util.Util.toLowerInvariant(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        java.lang.System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    private static final class InitializationTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
        private int selectedIndex;

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public java.lang.Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j_renamed, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, jElapsedRealtime)) {
                for (int i_renamed = this.length - 1; i_renamed >= 0; i_renamed--) {
                    if (!isBlacklisted(i_renamed, jElapsedRealtime)) {
                        this.selectedIndex = i_renamed;
                        return;
                    }
                }
                throw new java.lang.IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    private static final class EncryptionKeyChunk extends com.google.android.exoplayer2.source.chunk.DataChunk {
        public final java.lang.String iv_renamed;
        private byte[] result;

        public EncryptionKeyChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, byte[] bArr, java.lang.String str) {
            super(dataSource, dataSpec, 3, format, i_renamed, obj, bArr);
            this.iv_renamed = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i_renamed) throws java.io.IOException {
            this.result = java.util.Arrays.copyOf(bArr, i_renamed);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    private static final class HlsMediaPlaylistSegmentIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        private final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlist;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, long j_renamed, int i_renamed) {
            super(i_renamed, hlsMediaPlaylist.segments.size() - 1);
            this.playlist = hlsMediaPlaylist;
            this.startOfPlaylistInPeriodUs = j_renamed;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(this.playlist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null);
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.playlist.segments.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segment.relativeStartTimeUs + segment.durationUs;
        }
    }
}
