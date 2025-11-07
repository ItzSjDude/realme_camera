package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
final class DashMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>>, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<com.google.android.exoplayer2.source.dash.DashChunkSource> {
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory chunkSourceFactory;
    private com.google.android.exoplayer2.source.SequenceableLoader compositeSequenceableLoader;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final long elapsedRealtimeOffset;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> eventStreams;
    final int id_renamed;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
    private final com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoaderErrorThrower;
    private boolean notifiedReadingStarted;
    private int periodIndex;
    private final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler playerEmsgHandler;
    private final com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfos;
    private final com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final com.google.android.exoplayer2.upstream.TransferListener transferListener;
    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private com.google.android.exoplayer2.source.dash.EventSampleStream[] eventSampleStreams = new com.google.android.exoplayer2.source.dash.EventSampleStream[0];
    private final java.util.IdentityHashMap<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new java.util.IdentityHashMap<>();

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

    public DashMediaPeriod(int i_renamed, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i2, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, long j_renamed, com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback) {
        this.id_renamed = i_renamed;
        this.manifest = dashManifest;
        this.periodIndex = i2;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.elapsedRealtimeOffset = j_renamed;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.playerEmsgHandler = new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        com.google.android.exoplayer2.source.dash.manifest.Period period = dashManifest.getPeriod(i2);
        this.eventStreams = period.eventStreams;
        android.util.Pair<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]> pairBuildTrackGroups = buildTrackGroups(period.adaptationSets, this.eventStreams);
        this.trackGroups = (com.google.android.exoplayer2.source.TrackGroupArray) pairBuildTrackGroups.first;
        this.trackGroupInfos = (com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]) pairBuildTrackGroups.second;
        eventDispatcher.mediaPeriodCreated();
    }

    public void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed) {
        this.manifest = dashManifest;
        this.periodIndex = i_renamed;
        this.playerEmsgHandler.updateManifest(dashManifest);
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                ((com.google.android.exoplayer2.source.dash.DashChunkSource) chunkSampleStream.getChunkSource()).updateManifest(dashManifest, i_renamed);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = dashManifest.getPeriod(i_renamed).eventStreams;
        for (com.google.android.exoplayer2.source.dash.EventSampleStream eventSampleStream : this.eventSampleStreams) {
            java.util.Iterator<com.google.android.exoplayer2.source.dash.manifest.EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.google.android.exoplayer2.source.dash.manifest.EventStream next = it.next();
                    if (next.id_renamed().equals(eventSampleStream.eventStreamId())) {
                        eventSampleStream.updateEventStream(next, dashManifest.dynamic && i_renamed == dashManifest.getPeriodCount() - 1);
                    }
                }
            }
        }
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release(this);
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void onSampleStreamReleased(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream) {
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerRemove = this.trackEmsgHandlerBySampleStream.remove(chunkSampleStream);
        if (playerTrackEmsgHandlerRemove != null) {
            playerTrackEmsgHandlerRemove.release();
        }
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
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(trackSelectionArr);
        releaseDisabledStreams(trackSelectionArr, zArr, sampleStreamArr);
        releaseOrphanEmbeddedStreams(trackSelectionArr, sampleStreamArr, streamIndexToTrackGroupIndex);
        selectNewStreams(trackSelectionArr, sampleStreamArr, zArr2, j_renamed, streamIndexToTrackGroupIndex);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.google.android.exoplayer2.source.SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream) {
                arrayList.add((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof com.google.android.exoplayer2.source.dash.EventSampleStream) {
                arrayList2.add((com.google.android.exoplayer2.source.dash.EventSampleStream) sampleStream);
            }
        }
        this.sampleStreams = newSampleStreamArray(arrayList.size());
        arrayList.toArray(this.sampleStreams);
        this.eventSampleStreams = new com.google.android.exoplayer2.source.dash.EventSampleStream[arrayList2.size()];
        arrayList2.toArray(this.eventSampleStreams);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.sampleStreams) {
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
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(j_renamed);
        }
        for (com.google.android.exoplayer2.source.dash.EventSampleStream eventSampleStream : this.eventSampleStreams) {
            eventSampleStream.seekToUs(j_renamed);
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j_renamed, seekParameters);
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private int[] getStreamIndexToTrackGroupIndex(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr) {
        int[] iArr = new int[trackSelectionArr.length];
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if (trackSelectionArr[i_renamed] != null) {
                iArr[i_renamed] = this.trackGroups.indexOf(trackSelectionArr[i_renamed].getTrackGroup());
            } else {
                iArr[i_renamed] = -1;
            }
        }
        return iArr;
    }

    private void releaseDisabledStreams(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if (trackSelectionArr[i_renamed] == null || !zArr[i_renamed]) {
                if (sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream) {
                    ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStreamArr[i_renamed]).release(this);
                } else if (sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) {
                    ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i_renamed]).release();
                }
                sampleStreamArr[i_renamed] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z_renamed;
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if ((sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.EmptySampleStream) || (sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i_renamed, iArr);
                if (primaryStreamIndex == -1) {
                    z_renamed = sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.EmptySampleStream;
                } else {
                    z_renamed = (sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) && ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i_renamed]).parent == sampleStreamArr[primaryStreamIndex];
                }
                if (!z_renamed) {
                    if (sampleStreamArr[i_renamed] instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) {
                        ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i_renamed]).release();
                    }
                    sampleStreamArr[i_renamed] = null;
                }
            }
        }
    }

    private void selectNewStreams(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr, long j_renamed, int[] iArr) {
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if (sampleStreamArr[i_renamed] == null && trackSelectionArr[i_renamed] != null) {
                zArr[i_renamed] = true;
                com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo = this.trackGroupInfos[iArr[i_renamed]];
                if (trackGroupInfo.trackGroupCategory == 0) {
                    sampleStreamArr[i_renamed] = buildSampleStream(trackGroupInfo, trackSelectionArr[i_renamed], j_renamed);
                } else if (trackGroupInfo.trackGroupCategory == 2) {
                    sampleStreamArr[i_renamed] = new com.google.android.exoplayer2.source.dash.EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), trackSelectionArr[i_renamed].getTrackGroup().getFormat(0), this.manifest.dynamic);
                }
            }
        }
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[iArr[i2]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i2, iArr);
                    if (primaryStreamIndex == -1) {
                        sampleStreamArr[i2] = new com.google.android.exoplayer2.source.EmptySampleStream();
                    } else {
                        sampleStreamArr[i2] = ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStreamArr[primaryStreamIndex]).selectEmbeddedTrack(j_renamed, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    private int getPrimaryStreamIndex(int i_renamed, int[] iArr) {
        int i2 = iArr[i_renamed];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.trackGroupInfos[i2].primaryTrackGroupIndex;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.trackGroupInfos[i5].trackGroupCategory == 0) {
                return i4;
            }
        }
        return -1;
    }

    private static android.util.Pair<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]> buildTrackGroups(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int iIdentifyEmbeddedTracks = identifyEmbeddedTracks(length, list, groupedAdaptationSetIndices, zArr, zArr2) + length + list2.size();
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[iIdentifyEmbeddedTracks];
        com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr = new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[iIdentifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(list2, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(list, groupedAdaptationSetIndices, length, zArr, zArr2, trackGroupArr, trackGroupInfoArr));
        return android.util.Pair.create(new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static int[][] getGroupedAdaptationSetIndices(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list) {
        int size = list.size();
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray(size);
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            sparseIntArray.put(list.get(i_renamed).id_renamed, i_renamed);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (!zArr[i3]) {
                zArr[i3] = true;
                com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptorFindAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(list.get(i3).supplementalProperties);
                if (descriptorFindAdaptationSetSwitchingProperty == null) {
                    iArr[i2] = new int[]{i3};
                    i2++;
                } else {
                    java.lang.String[] strArrSplit = com.google.android.exoplayer2.util.Util.split(descriptorFindAdaptationSetSwitchingProperty.value, ",");
                    int[] iArrCopyOf = new int[strArrSplit.length + 1];
                    iArrCopyOf[0] = i3;
                    int i4 = 1;
                    for (java.lang.String str : strArrSplit) {
                        int i5 = sparseIntArray.get(java.lang.Integer.parseInt(str), -1);
                        if (i5 != -1) {
                            zArr[i5] = true;
                            iArrCopyOf[i4] = i5;
                            i4++;
                        }
                    }
                    if (i4 < iArrCopyOf.length) {
                        iArrCopyOf = java.util.Arrays.copyOf(iArrCopyOf, i4);
                    }
                    iArr[i2] = iArrCopyOf;
                    i2++;
                }
            }
        }
        return i2 < size ? (int[][]) java.util.Arrays.copyOf(iArr, i2) : iArr;
    }

    private static int identifyEmbeddedTracks(int i_renamed, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[][] iArr, boolean[] zArr, boolean[] zArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            if (hasEventMessageTrack(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            if (hasCea608Track(list, iArr[i3])) {
                zArr2[i3] = true;
                i2++;
            }
        }
        return i2;
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[][] iArr, int i_renamed, boolean[] zArr, boolean[] zArr2, com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i_renamed) {
            int[] iArr2 = iArr[i4];
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(list.get(i6).representations);
            }
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[arrayList.size()];
            for (int i7 = 0; i7 < formatArr.length; i7++) {
                formatArr[i7] = ((com.google.android.exoplayer2.source.dash.manifest.Representation) arrayList.get(i7)).format;
            }
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(iArr2[0]);
            int i8 = i5 + 1;
            if (zArr[i4]) {
                i2 = i8 + 1;
            } else {
                i2 = i8;
                i8 = -1;
            }
            if (zArr2[i4]) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            trackGroupArr[i5] = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
            trackGroupInfoArr[i5] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.primaryTrack(adaptationSet.type, iArr2, i5, i8, i2);
            if (i8 != -1) {
                trackGroupArr[i8] = new com.google.android.exoplayer2.source.TrackGroup(com.google.android.exoplayer2.Format.createSampleFormat(adaptationSet.id_renamed + ":emsg", com.google.android.exoplayer2.util.MimeTypes.APPLICATION_EMSG, null, -1, null));
                trackGroupInfoArr[i8] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.embeddedEmsgTrack(iArr2, i5);
            }
            if (i2 != -1) {
                trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(com.google.android.exoplayer2.Format.createTextSampleFormat(adaptationSet.id_renamed + ":cea608", com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608, 0, null));
                trackGroupInfoArr[i2] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.embeddedCea608Track(iArr2, i5);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    private static void buildManifestEventTrackGroupInfos(java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list, com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr, int i_renamed) {
        int i2 = i_renamed;
        int i3 = 0;
        while (i3 < list.size()) {
            trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(com.google.android.exoplayer2.Format.createSampleFormat(list.get(i3).id_renamed(), com.google.android.exoplayer2.util.MimeTypes.APPLICATION_EMSG, null, -1, null));
            trackGroupInfoArr[i2] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.mpdEventTrack(i3);
            i3++;
            i2++;
        }
    }

    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> buildSampleStream(com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, long j_renamed) {
        int i_renamed;
        int[] iArrCopyOf = new int[2];
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[2];
        boolean z_renamed = trackGroupInfo.embeddedEventMessageTrackGroupIndex != -1;
        if (z_renamed) {
            formatArr[0] = this.trackGroups.get(trackGroupInfo.embeddedEventMessageTrackGroupIndex).getFormat(0);
            iArrCopyOf[0] = 4;
            i_renamed = 1;
        } else {
            i_renamed = 0;
        }
        boolean z2 = trackGroupInfo.embeddedCea608TrackGroupIndex != -1;
        if (z2) {
            formatArr[i_renamed] = this.trackGroups.get(trackGroupInfo.embeddedCea608TrackGroupIndex).getFormat(0);
            iArrCopyOf[i_renamed] = 3;
            i_renamed++;
        }
        if (i_renamed < iArrCopyOf.length) {
            formatArr = (com.google.android.exoplayer2.Format[]) java.util.Arrays.copyOf(formatArr, i_renamed);
            iArrCopyOf = java.util.Arrays.copyOf(iArrCopyOf, i_renamed);
        }
        com.google.android.exoplayer2.Format[] formatArr2 = formatArr;
        int[] iArr = iArrCopyOf;
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerNewPlayerTrackEmsgHandler = (this.manifest.dynamic && z_renamed) ? this.playerEmsgHandler.newPlayerTrackEmsgHandler() : null;
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream = new com.google.android.exoplayer2.source.chunk.ChunkSampleStream<>(trackGroupInfo.trackType, iArr, formatArr2, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.periodIndex, trackGroupInfo.adaptationSetIndices, trackSelection, trackGroupInfo.trackType, this.elapsedRealtimeOffset, z_renamed, z2, playerTrackEmsgHandlerNewPlayerTrackEmsgHandler, this.transferListener), this, this.allocator, j_renamed, this.loadErrorHandlingPolicy, this.eventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandlerNewPlayerTrackEmsgHandler);
        }
        return chunkSampleStream;
    }

    private static com.google.android.exoplayer2.source.dash.manifest.Descriptor findAdaptationSetSwitchingProperty(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i_renamed);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    private static boolean hasEventMessageTrack(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[] iArr) {
        for (int i_renamed : iArr) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list2 = list.get(i_renamed).representations;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCea608Track(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[] iArr) {
        for (int i_renamed : iArr) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2 = list.get(i_renamed).accessibilityDescriptors;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc_renamed:cea-608:2015".equals(list2.get(i2).schemeIdUri)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] newSampleStreamArray(int i_renamed) {
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream[i_renamed];
    }

    private static final class TrackGroupInfo {
        private static final int CATEGORY_EMBEDDED = 1;
        private static final int CATEGORY_MANIFEST_EVENTS = 2;
        private static final int CATEGORY_PRIMARY = 0;
        public final int[] adaptationSetIndices;
        public final int embeddedCea608TrackGroupIndex;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo primaryTrack(int i_renamed, int[] iArr, int i2, int i3, int i4) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(i_renamed, 0, iArr, i2, i3, i4, -1);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo embeddedEmsgTrack(int[] iArr, int i_renamed) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(4, 1, iArr, i_renamed, -1, -1, -1);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo embeddedCea608Track(int[] iArr, int i_renamed) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(3, 1, iArr, i_renamed, -1, -1, -1);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo mpdEventTrack(int i_renamed) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(4, 2, null, -1, -1, -1, i_renamed);
        }

        private TrackGroupInfo(int i_renamed, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.trackType = i_renamed;
            this.adaptationSetIndices = iArr;
            this.trackGroupCategory = i2;
            this.primaryTrackGroupIndex = i3;
            this.embeddedEventMessageTrackGroupIndex = i4;
            this.embeddedCea608TrackGroupIndex = i5;
            this.eventStreamGroupIndex = i6;
        }
    }
}
