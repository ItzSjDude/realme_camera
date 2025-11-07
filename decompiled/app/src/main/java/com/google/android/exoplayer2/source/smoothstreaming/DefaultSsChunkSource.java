package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes.dex */
public class DefaultSsChunkSource implements com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource {
    private int currentManifestChunkOffset;
    private final com.google.android.exoplayer2.upstream.DataSource dataSource;
    private final com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper[] extractorWrappers;
    private java.io.IOException fatalError;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest manifest;
    private final com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private final com.google.android.exoplayer2.trackselection.TrackSelection trackSelection;

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
    }

    public static final class Factory implements com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource createChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, int i_renamed, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
            com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                dataSourceCreateDataSource.addTransferListener(transferListener);
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource(loaderErrorThrower, ssManifest, i_renamed, trackSelection, dataSourceCreateDataSource);
        }
    }

    public DefaultSsChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, int i_renamed, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest;
        this.streamElementIndex = i_renamed;
        this.trackSelection = trackSelection;
        this.dataSource = dataSource;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = ssManifest.streamElements[i_renamed];
        this.extractorWrappers = new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper[trackSelection.length()];
        int i2 = 0;
        while (i2 < this.extractorWrappers.length) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i2);
            com.google.android.exoplayer2.Format format = streamElement.formats[indexInTrackGroup];
            int i3 = i2;
            this.extractorWrappers[i3] = new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper(new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(3, null, new com.google.android.exoplayer2.extractor.mp4.Track(indexInTrackGroup, streamElement.type, streamElement.timescale, -9223372036854775807L, ssManifest.durationUs, format, 0, format.drmInitData != null ? ssManifest.protectionElement.trackEncryptionBoxes : null, streamElement.type == 2 ? 4 : 0, null, null), null), streamElement.type, format);
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(j_renamed);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return com.google.android.exoplayer2.util.Util.resolveSeekPositionUs(j_renamed, seekParameters, startTimeUs, (startTimeUs >= j_renamed || chunkIndex >= streamElement.chunkCount + (-1)) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i_renamed = streamElement.chunkCount;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement2 = ssManifest.streamElements[this.streamElementIndex];
        if (i_renamed == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i_renamed;
        } else {
            int i2 = i_renamed - 1;
            long startTimeUs = streamElement.getStartTimeUs(i2) + streamElement.getChunkDurationUs(i2);
            long startTimeUs2 = streamElement2.getStartTimeUs(0);
            if (startTimeUs <= startTimeUs2) {
                this.currentManifestChunkOffset += i_renamed;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs2);
            }
        }
        this.manifest = ssManifest;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws java.io.IOException {
        java.io.IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j_renamed, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j_renamed, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(long j_renamed, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder) {
        int nextChunkIndex;
        long j3 = j2;
        if (this.fatalError != null) {
            return;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        if (streamElement.chunkCount == 0) {
            chunkHolder.endOfStream = !this.manifest.isLive;
            return;
        }
        if (list.isEmpty()) {
            nextChunkIndex = streamElement.getChunkIndex(j3);
        } else {
            nextChunkIndex = (int) (list.get(list.size() - 1).getNextChunkIndex() - this.currentManifestChunkOffset);
            if (nextChunkIndex < 0) {
                this.fatalError = new com.google.android.exoplayer2.source.BehindLiveWindowException();
                return;
            }
        }
        if (nextChunkIndex >= streamElement.chunkCount) {
            chunkHolder.endOfStream = !this.manifest.isLive;
            return;
        }
        long j4 = j3 - j_renamed;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j_renamed);
        com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[this.trackSelection.length()];
        for (int i_renamed = 0; i_renamed < mediaChunkIteratorArr.length; i_renamed++) {
            mediaChunkIteratorArr[i_renamed] = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource.StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i_renamed), nextChunkIndex);
        }
        this.trackSelection.updateSelectedTrack(j_renamed, j4, jResolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
        long startTimeUs = streamElement.getStartTimeUs(nextChunkIndex);
        long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(nextChunkIndex);
        if (!list.isEmpty()) {
            j3 = -9223372036854775807L;
        }
        long j5 = j3;
        int i2 = nextChunkIndex + this.currentManifestChunkOffset;
        int selectedIndex = this.trackSelection.getSelectedIndex();
        chunkHolder.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), nextChunkIndex), null, i2, startTimeUs, chunkDurationUs, j5, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.extractorWrappers[selectedIndex]);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z_renamed, java.lang.Exception exc, long j_renamed) {
        if (z_renamed && j_renamed != -9223372036854775807L) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.trackSelection;
            if (trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j_renamed)) {
                return true;
            }
        }
        return false;
    }

    private static com.google.android.exoplayer2.source.chunk.MediaChunk newMediaChunk(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri, java.lang.String str, int i_renamed, long j_renamed, long j2, long j3, int i2, java.lang.Object obj, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper) {
        return new com.google.android.exoplayer2.source.chunk.ContainerMediaChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(uri, 0L, -1L, str), format, i2, obj, j_renamed, j2, j3, -9223372036854775807L, i_renamed, 1, j_renamed, chunkExtractorWrapper);
    }

    private long resolveTimeToLiveEdgeUs(long j_renamed) {
        if (!this.manifest.isLive) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i_renamed = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i_renamed) + streamElement.getChunkDurationUs(i_renamed)) - j_renamed;
    }

    private static final class StreamElementIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        private final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement, int i_renamed, int i2) {
            super(i2, streamElement.chunkCount - 1);
            this.streamElement = streamElement;
            this.trackIndex = i_renamed;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            return new com.google.android.exoplayer2.upstream.DataSpec(this.streamElement.buildRequestUri(this.trackIndex, (int) getCurrentIndex()));
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.streamElement.getStartTimeUs((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.streamElement.getChunkDurationUs((int) getCurrentIndex());
        }
    }
}
