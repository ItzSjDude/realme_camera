package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes.dex */
final class SsMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>> {
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory chunkSourceFactory;
    private com.google.android.exoplayer2.source.SequenceableLoader compositeSequenceableLoader;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest manifest;
    private final com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoaderErrorThrower;
    private boolean notifiedReadingStarted;
    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private final com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final com.google.android.exoplayer2.upstream.TransferListener transferListener;

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long j_renamed, boolean z_renamed) {
        return false;
    }

    public SsMediaPeriod(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.manifest = ssManifest;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.trackGroups = buildTrackGroups(ssManifest);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        eventDispatcher.mediaPeriodCreated();
    }

    public void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
        this.manifest = ssManifest;
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.sampleStreams) {
            ((com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource) chunkSampleStream.getChunkSource()).updateManifest(ssManifest);
        }
        this.callback.onContinueLoadingRequested(this);
    }

    public void release() {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release();
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        this.callback = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if (sampleStreamArr[i_renamed] != null) {
                com.google.android.exoplayer2.source.chunk.ChunkSampleStream chunkSampleStream = (com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStreamArr[i_renamed];
                if (trackSelectionArr[i_renamed] == null || !zArr[i_renamed]) {
                    chunkSampleStream.release();
                    sampleStreamArr[i_renamed] = null;
                } else {
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i_renamed] == null && trackSelectionArr[i_renamed] != null) {
                com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStreamBuildSampleStream = buildSampleStream(trackSelectionArr[i_renamed], j_renamed);
                arrayList.add(chunkSampleStreamBuildSampleStream);
                sampleStreamArr[i_renamed] = chunkSampleStreamBuildSampleStream;
                zArr2[i_renamed] = true;
            }
        }
        this.sampleStreams = newSampleStreamArray(arrayList.size());
        arrayList.toArray(this.sampleStreams);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.discardBuffer(j_renamed, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
        this.compositeSequenceableLoader.reevaluateBuffer(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        return this.compositeSequenceableLoader.continueLoading(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return -9223372036854775807L;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(j_renamed);
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j_renamed, seekParameters);
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> buildSampleStream(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, long j_renamed) {
        int iIndexOf = this.trackGroups.indexOf(trackSelection.getTrackGroup());
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream<>(this.manifest.streamElements[iIndexOf].type, (int[]) null, (com.google.android.exoplayer2.Format[]) null, this.chunkSourceFactory.createChunkSource(this.manifestLoaderErrorThrower, this.manifest, iIndexOf, trackSelection, this.transferListener), this, this.allocator, j_renamed, this.loadErrorHandlingPolicy, this.eventDispatcher);
    }

    private static com.google.android.exoplayer2.source.TrackGroupArray buildTrackGroups(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[ssManifest.streamElements.length];
        for (int i_renamed = 0; i_renamed < ssManifest.streamElements.length; i_renamed++) {
            trackGroupArr[i_renamed] = new com.google.android.exoplayer2.source.TrackGroup(ssManifest.streamElements[i_renamed].formats);
        }
        return new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
    }

    private static com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] newSampleStreamArray(int i_renamed) {
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream[i_renamed];
    }

    private static byte[] getProtectionElementKeyId(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed += 2) {
            sb.append((char) bArr[i_renamed]);
        }
        java.lang.String string = sb.toString();
        byte[] bArrDecode = android.util.Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
        swap(bArrDecode, 0, 3);
        swap(bArrDecode, 1, 2);
        swap(bArrDecode, 4, 5);
        swap(bArrDecode, 6, 7);
        return bArrDecode;
    }

    private static void swap(byte[] bArr, int i_renamed, int i2) {
        byte b2 = bArr[i_renamed];
        bArr[i_renamed] = bArr[i2];
        bArr[i2] = b2;
    }
}
