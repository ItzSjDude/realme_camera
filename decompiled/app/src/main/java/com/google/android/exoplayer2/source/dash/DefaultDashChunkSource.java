package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public class DefaultDashChunkSource implements com.google.android.exoplayer2.source.dash.DashChunkSource {
    private final int[] adaptationSetIndices;
    private final com.google.android.exoplayer2.upstream.DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private java.io.IOException fatalError;
    private long liveEdgeTimeUs;
    private com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
    private final com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder[] representationHolders;
    private final com.google.android.exoplayer2.trackselection.TrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements com.google.android.exoplayer2.source.dash.DashChunkSource.Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i_renamed) {
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = i_renamed;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public com.google.android.exoplayer2.source.dash.DashChunkSource createDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, long j_renamed, boolean z_renamed, boolean z2, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
            com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                dataSourceCreateDataSource.addTransferListener(transferListener);
            }
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource(loaderErrorThrower, dashManifest, i_renamed, iArr, trackSelection, i2, dataSourceCreateDataSource, j_renamed, this.maxSegmentsPerLoad, z_renamed, z2, playerTrackEmsgHandler);
        }
    }

    public DefaultDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, com.google.android.exoplayer2.upstream.DataSource dataSource, long j_renamed, int i3, boolean z_renamed, boolean z2, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection;
        this.trackType = i2;
        this.dataSource = dataSource;
        this.periodIndex = i_renamed;
        this.elapsedRealtimeOffsetMs = j_renamed;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i_renamed);
        this.liveEdgeTimeUs = -9223372036854775807L;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> representations = getRepresentations();
        this.representationHolders = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder[trackSelection.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(periodDurationUs, i2, representations.get(trackSelection.getIndexInTrackGroup(i4)), z_renamed, z2, playerTrackEmsgHandler);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j_renamed);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return com.google.android.exoplayer2.util.Util.resolveSeekPositionUs(j_renamed, seekParameters, segmentStartTimeUs, (segmentStartTimeUs >= j_renamed || segmentNum >= ((long) (representationHolder.getSegmentCount() + (-1)))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i_renamed;
            long periodDurationUs = this.manifest.getPeriodDurationUs(this.periodIndex);
            java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                this.representationHolders[i2] = this.representationHolders[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (com.google.android.exoplayer2.source.BehindLiveWindowException e_renamed) {
            this.fatalError = e_renamed;
        }
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
    public void getNextChunk(long j_renamed, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder) {
        int i_renamed;
        if (this.fatalError != null) {
            return;
        }
        long j3 = j2 - j_renamed;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j_renamed);
        long jMsToUs = com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.availabilityStartTimeMs) + com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j2;
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(jMsToUs)) {
            long nowUnixTimeUs = getNowUnixTimeUs();
            com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[this.trackSelection.length()];
            int i2 = 0;
            while (i2 < mediaChunkIteratorArr.length) {
                com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder = this.representationHolders[i2];
                if (representationHolder.segmentIndex == null) {
                    mediaChunkIteratorArr[i2] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                    i_renamed = i2;
                } else {
                    long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                    long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                    i_renamed = i2;
                    long segmentNum = getSegmentNum(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                    if (segmentNum < firstAvailableSegmentNum) {
                        mediaChunkIteratorArr[i_renamed] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                    } else {
                        mediaChunkIteratorArr[i_renamed] = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationSegmentIterator(representationHolder, segmentNum, lastAvailableSegmentNum);
                    }
                }
                i2 = i_renamed + 1;
            }
            this.trackSelection.updateSelectedTrack(j_renamed, j3, jResolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.getSelectedIndex()];
            if (representationHolder2.extractorWrapper != null) {
                com.google.android.exoplayer2.source.dash.manifest.Representation representation = representationHolder2.representation;
                com.google.android.exoplayer2.source.dash.manifest.RangedUri initializationUri = representationHolder2.extractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri = representationHolder2.segmentIndex == null ? representation.getIndexUri() : null;
                if (initializationUri != null || indexUri != null) {
                    chunkHolder.chunk = newInitializationChunk(representationHolder2, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                    return;
                }
            }
            long j4 = representationHolder2.periodDurationUs;
            boolean z_renamed = j4 != -9223372036854775807L;
            if (representationHolder2.getSegmentCount() == 0) {
                chunkHolder.endOfStream = z_renamed;
                return;
            }
            long firstAvailableSegmentNum2 = representationHolder2.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
            long lastAvailableSegmentNum2 = representationHolder2.getLastAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
            updateLiveEdgeTimeUs(representationHolder2, lastAvailableSegmentNum2);
            boolean z2 = z_renamed;
            long segmentNum2 = getSegmentNum(representationHolder2, mediaChunk, j2, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
            if (segmentNum2 < firstAvailableSegmentNum2) {
                this.fatalError = new com.google.android.exoplayer2.source.BehindLiveWindowException();
                return;
            }
            if (segmentNum2 > lastAvailableSegmentNum2 || (this.missingLastSegment && segmentNum2 >= lastAvailableSegmentNum2)) {
                chunkHolder.endOfStream = z2;
                return;
            }
            if (z2 && representationHolder2.getSegmentStartTimeUs(segmentNum2) >= j4) {
                chunkHolder.endOfStream = true;
                return;
            }
            int iMin = (int) java.lang.Math.min(this.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
            if (j4 != -9223372036854775807L) {
                while (iMin > 1 && representationHolder2.getSegmentStartTimeUs((iMin + segmentNum2) - 1) >= j4) {
                    iMin--;
                }
            }
            chunkHolder.chunk = newMediaChunk(representationHolder2, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, iMin, list.isEmpty() ? j2 : -9223372036854775807L);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        com.google.android.exoplayer2.extractor.SeekMap seekMap;
        if (chunk instanceof com.google.android.exoplayer2.source.chunk.InitializationChunk) {
            int iIndexOf = this.trackSelection.indexOf(((com.google.android.exoplayer2.source.chunk.InitializationChunk) chunk).trackFormat);
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder = this.representationHolders[iIndexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                this.representationHolders[iIndexOf] = representationHolder.copyWithNewSegmentIndex(new com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex((com.google.android.exoplayer2.extractor.ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z_renamed, java.lang.Exception exc, long j_renamed) {
        com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder;
        int segmentCount;
        if (!z_renamed) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof com.google.android.exoplayer2.source.chunk.MediaChunk) && (exc instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) && ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((com.google.android.exoplayer2.source.chunk.MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                this.missingLastSegment = true;
                return true;
            }
        }
        if (j_renamed == -9223372036854775807L) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.trackSelection;
        return trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j_renamed);
    }

    private long getSegmentNum(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk, long j_renamed, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return com.google.android.exoplayer2.util.Util.constrainValue(representationHolder.getSegmentNum(j_renamed), j2, j3);
    }

    private java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> getRepresentations() {
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> arrayList = new java.util.ArrayList<>();
        for (int i_renamed : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i_renamed).representations);
        }
        return arrayList;
    }

    private void updateLiveEdgeTimeUs(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, long j_renamed) {
        this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(j_renamed) : -9223372036854775807L;
    }

    private long getNowUnixTimeUs() {
        long jCurrentTimeMillis;
        if (this.elapsedRealtimeOffsetMs != 0) {
            jCurrentTimeMillis = android.os.SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs;
        } else {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        }
        return jCurrentTimeMillis * 1000;
    }

    private long resolveTimeToLiveEdgeUs(long j_renamed) {
        if (this.manifest.dynamic && this.liveEdgeTimeUs != -9223372036854775807L) {
            return this.liveEdgeTimeUs - j_renamed;
        }
        return -9223372036854775807L;
    }

    protected com.google.android.exoplayer2.source.chunk.Chunk newInitializationChunk(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri2) {
        java.lang.String str = representationHolder.representation.baseUrl;
        if (rangedUri != null && (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) == null) {
            rangedUri2 = rangedUri;
        }
        return new com.google.android.exoplayer2.source.chunk.InitializationChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(rangedUri2.resolveUri(str), rangedUri2.start, rangedUri2.length, representationHolder.representation.getCacheKey()), format, i_renamed, obj, representationHolder.extractorWrapper);
    }

    protected com.google.android.exoplayer2.source.chunk.Chunk newMediaChunk(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed, com.google.android.exoplayer2.Format format, int i2, java.lang.Object obj, long j_renamed, int i3, long j2) {
        com.google.android.exoplayer2.source.dash.manifest.Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(j_renamed);
        com.google.android.exoplayer2.source.dash.manifest.RangedUri segmentUrl = representationHolder.getSegmentUrl(j_renamed);
        java.lang.String str = representation.baseUrl;
        if (representationHolder.extractorWrapper == null) {
            return new com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(j_renamed), j_renamed, i_renamed, format);
        }
        int i4 = 1;
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = segmentUrl;
        int i5 = 1;
        while (i4 < i3) {
            com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUriAttemptMerge = rangedUri.attemptMerge(representationHolder.getSegmentUrl(i4 + j_renamed), str);
            if (rangedUriAttemptMerge == null) {
                break;
            }
            i5++;
            i4++;
            rangedUri = rangedUriAttemptMerge;
        }
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs((i5 + j_renamed) - 1);
        long j3 = representationHolder.periodDurationUs;
        return new com.google.android.exoplayer2.source.chunk.ContainerMediaChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j2, (j3 == -9223372036854775807L || j3 > segmentEndTimeUs) ? -9223372036854775807L : j3, j_renamed, i5, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper);
    }

    protected static final class RepresentationSegmentIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        private final com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, long j_renamed, long j2) {
            super(j_renamed, j2);
            this.representationHolder = representationHolder;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            com.google.android.exoplayer2.source.dash.manifest.Representation representation = this.representationHolder.representation;
            com.google.android.exoplayer2.source.dash.manifest.RangedUri segmentUrl = this.representationHolder.getSegmentUrl(getCurrentIndex());
            return new com.google.android.exoplayer2.upstream.DataSpec(segmentUrl.resolveUri(representation.baseUrl), segmentUrl.start, segmentUrl.length, representation.getCacheKey());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    protected static final class RepresentationHolder {
        final com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper extractorWrapper;
        private final long periodDurationUs;
        public final com.google.android.exoplayer2.source.dash.manifest.Representation representation;
        public final com.google.android.exoplayer2.source.dash.DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        RepresentationHolder(long j_renamed, int i_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z_renamed, boolean z2, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this(j_renamed, representation, createExtractorWrapper(i_renamed, representation, z_renamed, z2, trackOutput), 0L, representation.getIndex());
        }

        private RepresentationHolder(long j_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper, long j2, com.google.android.exoplayer2.source.dash.DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j_renamed;
            this.representation = representation;
            this.segmentNumShift = j2;
            this.extractorWrapper = chunkExtractorWrapper;
            this.segmentIndex = dashSegmentIndex;
        }

        com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder copyWithNewRepresentation(long j_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws com.google.android.exoplayer2.source.BehindLiveWindowException {
            long segmentNum;
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index = this.representation.getIndex();
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index2 = representation.getIndex();
            if (index == null) {
                return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j_renamed, representation, this.extractorWrapper, this.segmentNumShift, index);
            }
            if (!index.isExplicit()) {
                return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j_renamed, representation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            int segmentCount = index.getSegmentCount(j_renamed);
            if (segmentCount == 0) {
                return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j_renamed, representation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            long firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
            long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, j_renamed);
            long firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs2 = index2.getTimeUs(firstSegmentNum2);
            long j2 = this.segmentNumShift;
            if (timeUs == timeUs2) {
                segmentNum = j2 + ((firstSegmentNum + 1) - firstSegmentNum2);
            } else {
                if (timeUs < timeUs2) {
                    throw new com.google.android.exoplayer2.source.BehindLiveWindowException();
                }
                segmentNum = j2 + (index.getSegmentNum(timeUs2, j_renamed) - firstSegmentNum2);
            }
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j_renamed, representation, this.extractorWrapper, segmentNum, index2);
        }

        com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder copyWithNewSegmentIndex(com.google.android.exoplayer2.source.dash.DashSegmentIndex dashSegmentIndex) {
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(this.periodDurationUs, this.representation, this.extractorWrapper, this.segmentNumShift, dashSegmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long j_renamed) {
            return this.segmentIndex.getTimeUs(j_renamed - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long j_renamed) {
            return getSegmentStartTimeUs(j_renamed) + this.segmentIndex.getDurationUs(j_renamed - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j_renamed) {
            return this.segmentIndex.getSegmentNum(j_renamed, this.periodDurationUs) + this.segmentNumShift;
        }

        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j_renamed) {
            return this.segmentIndex.getSegmentUrl(j_renamed - this.segmentNumShift);
        }

        public long getFirstAvailableSegmentNum(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed, long j_renamed) {
            if (getSegmentCount() == -1 && dashManifest.timeShiftBufferDepthMs != -9223372036854775807L) {
                return java.lang.Math.max(getFirstSegmentNum(), getSegmentNum(((j_renamed - com.google.android.exoplayer2.C_renamed.msToUs(dashManifest.availabilityStartTimeMs)) - com.google.android.exoplayer2.C_renamed.msToUs(dashManifest.getPeriod(i_renamed).startMs)) - com.google.android.exoplayer2.C_renamed.msToUs(dashManifest.timeShiftBufferDepthMs)));
            }
            return getFirstSegmentNum();
        }

        public long getLastAvailableSegmentNum(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed, long j_renamed) {
            long firstSegmentNum;
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                firstSegmentNum = getSegmentNum((j_renamed - com.google.android.exoplayer2.C_renamed.msToUs(dashManifest.availabilityStartTimeMs)) - com.google.android.exoplayer2.C_renamed.msToUs(dashManifest.getPeriod(i_renamed).startMs));
            } else {
                firstSegmentNum = getFirstSegmentNum() + segmentCount;
            }
            return firstSegmentNum - 1;
        }

        private static boolean mimeTypeIsWebm(java.lang.String str) {
            return str.startsWith(com.google.android.exoplayer2.util.MimeTypes.VIDEO_WEBM) || str.startsWith(com.google.android.exoplayer2.util.MimeTypes.AUDIO_WEBM) || str.startsWith(com.google.android.exoplayer2.util.MimeTypes.APPLICATION_WEBM);
        }

        private static boolean mimeTypeIsRawText(java.lang.String str) {
            return com.google.android.exoplayer2.util.MimeTypes.isText(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TTML.equals(str);
        }

        private static com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper createExtractorWrapper(int i_renamed, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z_renamed, boolean z2, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            java.util.List listEmptyList;
            com.google.android.exoplayer2.extractor.Extractor fragmentedMp4Extractor;
            java.lang.String str = representation.format.containerMimeType;
            if (mimeTypeIsRawText(str)) {
                return null;
            }
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_RAWCC.equals(str)) {
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor(representation.format);
            } else if (mimeTypeIsWebm(str)) {
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor(1);
            } else {
                int i2 = z_renamed ? 4 : 0;
                if (z2) {
                    listEmptyList = java.util.Collections.singletonList(com.google.android.exoplayer2.Format.createTextSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608, 0, null));
                } else {
                    listEmptyList = java.util.Collections.emptyList();
                }
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(i2, null, null, null, listEmptyList, trackOutput);
            }
            return new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper(fragmentedMp4Extractor, i_renamed, representation.format);
        }
    }
}
