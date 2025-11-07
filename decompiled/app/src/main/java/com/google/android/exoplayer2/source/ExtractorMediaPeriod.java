package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
final class ExtractorMediaPeriod implements com.google.android.exoplayer2.extractor.ExtractorOutput, com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private static final java.lang.String TAG = "ExtractorMediaPeriod";
    private static boolean isNeedRetryExtractor;
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private final long continueLoadingCheckIntervalBytes;
    private final java.lang.String customCacheKey;
    private final com.google.android.exoplayer2.upstream.DataSource dataSource;
    private int enabledTrackCount;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder extractorHolder;
    private boolean haveAudioVideoTracks;
    private long lastSeekPositionUs;
    private final com.google.android.exoplayer2.source.ExtractorMediaPeriod.Listener listener;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean loadingFinished;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    private boolean pendingDeferredRetry;
    private boolean prepared;
    private com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState preparedState;
    private boolean released;
    private boolean sampleQueuesBuilt;
    private com.google.android.exoplayer2.extractor.SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private final android.net.Uri uri;
    private final com.google.android.exoplayer2.upstream.Loader loader = new com.google.android.exoplayer2.upstream.Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.ConditionVariable loadCondition = new com.google.android.exoplayer2.util.ConditionVariable();
    private final java.lang.Runnable maybeFinishPrepareRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$ExtractorMediaPeriod$Ll7lI30pD07GZk92Lo8XgkQMAAY
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.maybeFinishPrepare();
        }
    };
    private final java.lang.Runnable onContinueLoadingRequestedRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$ExtractorMediaPeriod$Hd-sBytb6cpkhM49l8dYCND3wmk
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.lambda$new$0$ExtractorMediaPeriod();
        }
    };
    private final android.os.Handler handler = new android.os.Handler();
    private int[] sampleQueueTrackIds = new int[0];
    private com.google.android.exoplayer2.source.SampleQueue[] sampleQueues = new com.google.android.exoplayer2.source.SampleQueue[0];
    private long pendingResetPositionUs = -9223372036854775807L;
    private long length = -1;
    private long durationUs = -9223372036854775807L;
    private int dataType = 1;

    interface Listener {
        void onSourceInfoRefreshed(long j_renamed, boolean z_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
    }

    public ExtractorMediaPeriod(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.extractor.Extractor[] extractorArr, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.ExtractorMediaPeriod.Listener listener, com.google.android.exoplayer2.upstream.Allocator allocator, java.lang.String str, int i_renamed) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i_renamed;
        this.extractorHolder = new com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder(extractorArr);
        eventDispatcher.mediaPeriodCreated();
    }

    public /* synthetic */ void lambda$new$0$ExtractorMediaPeriod() {
        if (this.released) {
            return;
        }
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void release() {
        if (this.prepared) {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        this.extractorHolder.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        this.callback = callback;
        this.loadCondition.open();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return getPreparedState().tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed) {
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState preparedState = getPreparedState();
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray = preparedState.tracks;
        boolean[] zArr3 = preparedState.trackEnabledStates;
        int i_renamed = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((com.google.android.exoplayer2.source.ExtractorMediaPeriod.SampleStreamImpl) sampleStreamArr[i3]).track;
                com.google.android.exoplayer2.util.Assertions.checkState(zArr3[i4]);
                this.enabledTrackCount--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z_renamed = !this.seenFirstTrackSelection ? j_renamed == 0 : i_renamed != 0;
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && trackSelectionArr[i5] != null) {
                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i5];
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelection.length() == 1);
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int iIndexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                com.google.android.exoplayer2.util.Assertions.checkState(!zArr3[iIndexOf]);
                this.enabledTrackCount++;
                zArr3[iIndexOf] = true;
                sampleStreamArr[i5] = new com.google.android.exoplayer2.source.ExtractorMediaPeriod.SampleStreamImpl(iIndexOf);
                zArr2[i5] = true;
                if (!z_renamed) {
                    com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[iIndexOf];
                    sampleQueue.rewind();
                    z_renamed = sampleQueue.advanceTo(j_renamed, true, true) == -1 && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.loader.cancelLoading();
            } else {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z_renamed) {
            j_renamed = seekToUs(j_renamed);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        if (isPendingReset()) {
            return;
        }
        boolean[] zArr = getPreparedState().trackEnabledStates;
        int length = this.sampleQueues.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.sampleQueues[i_renamed].discardTo(j_renamed, z_renamed, zArr[i_renamed]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        if (this.loadingFinished || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean zOpen = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return zOpen;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        int length = this.sampleQueues.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
            if (com.google.android.exoplayer2.util.MimeTypes.isVideo(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                return sampleQueue.getNextKeyFramePositionUs(j_renamed);
            }
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        int i2 = 0;
        if (i_renamed == 1) {
            while (true) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.sampleQueues;
                if (i2 >= sampleQueueArr.length) {
                    return -1L;
                }
                com.google.android.exoplayer2.source.SampleQueue sampleQueue = sampleQueueArr[i2];
                if (com.google.android.exoplayer2.util.MimeTypes.isAudio(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                    return sampleQueue.getLargestQueuedTimestampUs();
                }
                i2++;
            }
        } else {
            if (i_renamed != 2) {
                return -1L;
            }
            while (true) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                if (i2 >= sampleQueueArr2.length) {
                    return -1L;
                }
                com.google.android.exoplayer2.source.SampleQueue sampleQueue2 = sampleQueueArr2[i2];
                if (com.google.android.exoplayer2.util.MimeTypes.isVideo(sampleQueue2.getUpstreamFormat().sampleMimeType)) {
                    return sampleQueue2.getLargestQueuedTimestampUs();
                }
                i2++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if (!this.notifyDiscontinuity) {
            return -9223372036854775807L;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return -9223372036854775807L;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long largestQueuedTimestampUs;
        boolean[] zArr = getPreparedState().trackIsAudioVideoFlags;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length = this.sampleQueues.length;
            largestQueuedTimestampUs = Long.MAX_VALUE;
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                if (zArr[i_renamed] && !this.sampleQueues[i_renamed].isLastSampleQueued()) {
                    largestQueuedTimestampUs = java.lang.Math.min(largestQueuedTimestampUs, this.sampleQueues[i_renamed].getLargestQueuedTimestampUs());
                }
            }
        } else {
            largestQueuedTimestampUs = Long.MAX_VALUE;
        }
        if (largestQueuedTimestampUs == Long.MAX_VALUE) {
            largestQueuedTimestampUs = getLargestQueuedTimestampUs();
        }
        return largestQueuedTimestampUs == Long.MIN_VALUE ? this.lastSeekPositionUs : largestQueuedTimestampUs;
    }

    private boolean seekAudioInGop(boolean[] zArr, long j_renamed) {
        int length = this.sampleQueues.length;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                return true;
            }
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
            if (com.google.android.exoplayer2.util.MimeTypes.isAudio(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                sampleQueue.rewind();
                if (!(sampleQueue.advanceTo(j_renamed, true, false) != -1) && (zArr[i_renamed] || !this.haveAudioVideoTracks)) {
                    break;
                }
            }
            i_renamed++;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long j_renamed, boolean z_renamed) {
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState preparedState = getPreparedState();
        com.google.android.exoplayer2.extractor.SeekMap seekMap = preparedState.seekMap;
        boolean[] zArr = preparedState.trackIsAudioVideoFlags;
        if (!seekMap.isSeekable()) {
            j_renamed = 0;
        }
        this.lastSeekPositionUs = j_renamed;
        if (!z_renamed || this.dataType == 7) {
            return true;
        }
        return seekAudioInGop(zArr, j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState preparedState = getPreparedState();
        com.google.android.exoplayer2.extractor.SeekMap seekMap = preparedState.seekMap;
        boolean[] zArr = preparedState.trackIsAudioVideoFlags;
        if (!seekMap.isSeekable()) {
            j_renamed = 0;
        }
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = j_renamed;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j_renamed;
            return j_renamed;
        }
        if (this.dataType != 7 && seekInsideBufferUs(zArr, j_renamed)) {
            return j_renamed;
        }
        this.pendingDeferredRetry = false;
        this.pendingResetPositionUs = j_renamed;
        this.loadingFinished = false;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        com.google.android.exoplayer2.extractor.SeekMap seekMap = getPreparedState().seekMap;
        if (!seekMap.isSeekable()) {
            return 0L;
        }
        com.google.android.exoplayer2.extractor.SeekMap.SeekPoints seekPoints = seekMap.getSeekPoints(j_renamed);
        return com.google.android.exoplayer2.util.Util.resolveSeekPositionUs(j_renamed, seekParameters, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    boolean isReady(int i_renamed) {
        return !suppressRead() && (this.loadingFinished || this.sampleQueues[i_renamed].hasNextSample());
    }

    void maybeThrowError() throws java.io.IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }

    int readData(int i_renamed, com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(i_renamed);
        int i2 = this.sampleQueues[i_renamed].read(formatHolder, decoderInputBuffer, z_renamed, this.loadingFinished, this.lastSeekPositionUs);
        if (i2 == -3) {
            maybeStartDeferredRetry(i_renamed);
        }
        return i2;
    }

    int skipData(int i_renamed, long j_renamed) {
        int iAdvanceToEnd = 0;
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(i_renamed);
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
        if (this.loadingFinished && j_renamed > sampleQueue.getLargestQueuedTimestampUs()) {
            iAdvanceToEnd = sampleQueue.advanceToEnd();
        } else {
            int iAdvanceTo = sampleQueue.advanceTo(j_renamed, true, true);
            if (iAdvanceTo != -1) {
                iAdvanceToEnd = iAdvanceTo;
            }
        }
        if (iAdvanceToEnd == 0) {
            maybeStartDeferredRetry(i_renamed);
        }
        return iAdvanceToEnd;
    }

    private void maybeNotifyDownstreamFormat(int i_renamed) {
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState preparedState = getPreparedState();
        boolean[] zArr = preparedState.trackNotifiedDownstreamFormats;
        if (zArr[i_renamed]) {
            return;
        }
        com.google.android.exoplayer2.Format format = preparedState.tracks.get(i_renamed).getFormat(0);
        this.eventDispatcher.downstreamFormatChanged(com.google.android.exoplayer2.util.MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.lastSeekPositionUs);
        zArr[i_renamed] = true;
    }

    private void maybeStartDeferredRetry(int i_renamed) {
        boolean[] zArr = getPreparedState().trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[i_renamed] && !this.sampleQueues[i_renamed].hasNextSample()) {
            this.pendingResetPositionUs = 0L;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable, long j_renamed, long j2) {
        if (this.durationUs == -9223372036854775807L) {
            com.google.android.exoplayer2.extractor.SeekMap seekMap = (com.google.android.exoplayer2.extractor.SeekMap) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.seekMap);
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            this.durationUs = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + DEFAULT_LAST_SAMPLE_DURATION_US;
            this.listener.onSourceInfoRefreshed(this.durationUs, seekMap.isSeekable());
        }
        this.eventDispatcher.loadCompleted(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j_renamed, j2, extractingLoadable.dataSource.getBytesRead());
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable, long j_renamed, long j2, boolean z_renamed) {
        this.eventDispatcher.loadCanceled(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j_renamed, j2, extractingLoadable.dataSource.getBytesRead());
        if (z_renamed) {
            return;
        }
        copyLengthFromLoader(extractingLoadable);
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        if (this.enabledTrackCount > 0) {
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        boolean z_renamed;
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable2;
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        copyLengthFromLoader(extractingLoadable);
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(this.dataType, this.durationUs, iOException, i_renamed);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorActionCreateRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
                extractingLoadable2 = extractingLoadable;
                z_renamed = true;
            } else {
                z_renamed = false;
                extractingLoadable2 = extractingLoadable;
            }
            loadErrorActionCreateRetryAction = configureRetry(extractingLoadable2, extractedSamplesCount) ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(z_renamed, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        }
        this.eventDispatcher.loadError(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j_renamed, j2, extractingLoadable.dataSource.getBytesRead(), iOException, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i_renamed, int i2) {
        int length = this.sampleQueues.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.sampleQueueTrackIds[i3] == i_renamed) {
                return this.sampleQueues[i3];
            }
        }
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = new com.google.android.exoplayer2.source.SampleQueue(this.allocator);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i4 = length + 1;
        this.sampleQueueTrackIds = java.util.Arrays.copyOf(this.sampleQueueTrackIds, i4);
        this.sampleQueueTrackIds[length] = i_renamed;
        com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = (com.google.android.exoplayer2.source.SampleQueue[]) java.util.Arrays.copyOf(this.sampleQueues, i4);
        sampleQueueArr[length] = sampleQueue;
        this.sampleQueues = (com.google.android.exoplayer2.source.SampleQueue[]) com.google.android.exoplayer2.util.Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.seekMap = seekMap;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        com.google.android.exoplayer2.extractor.SeekMap seekMap = this.seekMap;
        if (this.released || this.prepared || !this.sampleQueuesBuilt || seekMap == null) {
            return;
        }
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        this.loadCondition.close();
        int length = this.sampleQueues.length;
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[length];
        boolean[] zArr = new boolean[length];
        this.durationUs = seekMap.getDurationUs();
        int i_renamed = 0;
        while (true) {
            boolean z_renamed = true;
            if (i_renamed >= length) {
                break;
            }
            com.google.android.exoplayer2.Format upstreamFormat = this.sampleQueues[i_renamed].getUpstreamFormat();
            trackGroupArr[i_renamed] = new com.google.android.exoplayer2.source.TrackGroup(upstreamFormat);
            java.lang.String str = upstreamFormat.sampleMimeType;
            if (!com.google.android.exoplayer2.util.MimeTypes.isVideo(str) && !com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
                z_renamed = false;
            }
            zArr[i_renamed] = z_renamed;
            this.haveAudioVideoTracks = z_renamed | this.haveAudioVideoTracks;
            i_renamed++;
        }
        this.dataType = (this.length == -1 && seekMap.getDurationUs() == -9223372036854775807L) ? 7 : 1;
        this.preparedState = new com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState(seekMap, new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr), zArr);
        this.prepared = true;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap.isSeekable());
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    private com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState getPreparedState() {
        return (com.google.android.exoplayer2.source.ExtractorMediaPeriod.PreparedState) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.preparedState);
    }

    private void copyLengthFromLoader(com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private void startLoading() {
        com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable = new com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this, this.loadCondition);
        if (this.prepared) {
            com.google.android.exoplayer2.extractor.SeekMap seekMap = getPreparedState().seekMap;
            com.google.android.exoplayer2.util.Assertions.checkState(isPendingReset());
            long j_renamed = this.durationUs;
            if (j_renamed != -9223372036854775807L && this.pendingResetPositionUs >= j_renamed) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            } else {
                extractingLoadable.setLoadPosition(seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = -9223372036854775807L;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, this.loader.startLoading(extractingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType)));
    }

    private boolean configureRetry(com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractingLoadable extractingLoadable, int i_renamed) {
        com.google.android.exoplayer2.extractor.SeekMap seekMap;
        if (this.length != -1 || ((seekMap = this.seekMap) != null && seekMap.getDurationUs() != -9223372036854775807L)) {
            this.extractedSamplesCountAtStartOfLoad = i_renamed;
            return true;
        }
        if (this.prepared && !suppressRead()) {
            this.pendingDeferredRetry = true;
            return false;
        }
        this.notifyDiscontinuity = this.prepared;
        this.lastSeekPositionUs = 0L;
        this.extractedSamplesCountAtStartOfLoad = 0;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        extractingLoadable.setLoadPosition(0L, 0L);
        return true;
    }

    private boolean seekInsideBufferUs(boolean[] zArr, long j_renamed) {
        int length = this.sampleQueues.length;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                return true;
            }
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.sampleQueues[i_renamed];
            sampleQueue.rewind();
            if (!(sampleQueue.advanceTo(j_renamed, true, false) != -1) && (zArr[i_renamed] || !this.haveAudioVideoTracks)) {
                break;
            }
            i_renamed++;
        }
        return false;
    }

    private int getExtractedSamplesCount() {
        int writeIndex = 0;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            writeIndex += sampleQueue.getWriteIndex();
        }
        return writeIndex;
    }

    private long getLargestQueuedTimestampUs() {
        long jMax = Long.MIN_VALUE;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.sampleQueues) {
            jMax = java.lang.Math.max(jMax, sampleQueue.getLargestQueuedTimestampUs());
        }
        return jMax;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private final class SampleStreamImpl implements com.google.android.exoplayer2.source.SampleStream {
        private final int track;

        public SampleStreamImpl(int i_renamed) {
            this.track = i_renamed;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.isReady(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
            return com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z_renamed);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j_renamed) {
            return com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.skipData(this.track, j_renamed);
        }
    }

    final class ExtractingLoadable implements com.google.android.exoplayer2.upstream.Loader.Loadable {
        private final com.google.android.exoplayer2.upstream.StatsDataSource dataSource;
        private com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        private final com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder extractorHolder;
        private final com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
        private volatile boolean loadCanceled;
        private final com.google.android.exoplayer2.util.ConditionVariable loadCondition;
        private long seekTimeUs;
        private final android.net.Uri uri;
        private final com.google.android.exoplayer2.extractor.PositionHolder positionHolder = new com.google.android.exoplayer2.extractor.PositionHolder();
        private boolean pendingExtractorSeek = true;
        private long length = -1;

        public ExtractingLoadable(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder extractorHolder, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.util.ConditionVariable conditionVariable) {
            this.uri = uri;
            this.dataSource = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
            this.extractorHolder = extractorHolder;
            this.extractorOutput = extractorOutput;
            this.loadCondition = conditionVariable;
            this.dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(uri, this.positionHolder.position, -1L, com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.customCacheKey);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws java.lang.Throwable {
            long j_renamed;
            int i_renamed = 0;
            while (i_renamed == 0 && !this.loadCanceled) {
                com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = null;
                try {
                    long position = this.positionHolder.position;
                    this.dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(this.uri, position, -1L, com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.customCacheKey);
                    this.length = this.dataSource.open(this.dataSpec);
                    if (this.length != -1) {
                        this.length += position;
                    }
                    android.net.Uri uri = (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.dataSource.getUri());
                    com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput2 = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, position, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.Extractor extractorSelectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.extractorOutput, uri);
                        if (this.pendingExtractorSeek) {
                            extractorSelectExtractor.seek(position, this.seekTimeUs);
                            this.pendingExtractorSeek = false;
                        }
                        android.net.Uri uri2 = uri;
                        com.google.android.exoplayer2.extractor.Extractor extractor = extractorSelectExtractor;
                        com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput3 = defaultExtractorInput2;
                        while (i_renamed == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            i_renamed = extractor.read(defaultExtractorInput3, this.positionHolder);
                            if (i_renamed == 2) {
                                boolean unused = com.google.android.exoplayer2.source.ExtractorMediaPeriod.isNeedRetryExtractor = true;
                                com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
                                long j2 = this.positionHolder.position;
                                this.dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(uri2, j2, -1L, com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.customCacheKey);
                                this.length = this.dataSource.open(this.dataSpec);
                                if (this.length != -1) {
                                    this.length += j2;
                                }
                                uri2 = (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.dataSource.getUri());
                                com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput4 = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, j2, this.length);
                                try {
                                    com.google.android.exoplayer2.extractor.Extractor extractorSelectExtractor2 = this.extractorHolder.selectExtractor(defaultExtractorInput4, this.extractorOutput, uri2);
                                    if (this.pendingExtractorSeek) {
                                        j_renamed = j2;
                                        extractorSelectExtractor2.seek(j_renamed, this.seekTimeUs);
                                        this.pendingExtractorSeek = false;
                                    } else {
                                        j_renamed = j2;
                                    }
                                    i_renamed = 0;
                                    position = j_renamed;
                                    extractor = extractorSelectExtractor2;
                                    defaultExtractorInput3 = defaultExtractorInput4;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    defaultExtractorInput = defaultExtractorInput4;
                                    if (i_renamed != 1 && defaultExtractorInput != null) {
                                        this.positionHolder.position = defaultExtractorInput.getPosition();
                                    }
                                    com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
                                    throw th;
                                }
                            } else if (defaultExtractorInput3.getPosition() > com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.continueLoadingCheckIntervalBytes + position) {
                                position = defaultExtractorInput3.getPosition();
                                this.loadCondition.close();
                                com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.handler.post(com.google.android.exoplayer2.source.ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                        if (i_renamed == 1) {
                            i_renamed = 0;
                        } else {
                            this.positionHolder.position = defaultExtractorInput3.getPosition();
                        }
                        com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        defaultExtractorInput = defaultExtractorInput2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoadPosition(long j_renamed, long j2) {
            this.positionHolder.position = j_renamed;
            this.seekTimeUs = j2;
            this.pendingExtractorSeek = true;
        }
    }

    private static final class ExtractorHolder {
        private com.google.android.exoplayer2.extractor.Extractor extractor;
        private final com.google.android.exoplayer2.extractor.Extractor[] extractors;

        public ExtractorHolder(com.google.android.exoplayer2.extractor.Extractor[] extractorArr) {
            this.extractors = extractorArr;
        }

        public com.google.android.exoplayer2.extractor.Extractor selectExtractor(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, android.net.Uri uri) throws java.lang.InterruptedException, java.io.IOException {
            if (this.extractor != null && !com.google.android.exoplayer2.source.ExtractorMediaPeriod.isNeedRetryExtractor) {
                return this.extractor;
            }
            com.google.android.exoplayer2.extractor.Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= length) {
                    break;
                }
                com.google.android.exoplayer2.extractor.Extractor extractor = extractorArr[i_renamed];
                try {
                    if (!extractor.sniff(extractorInput)) {
                        continue;
                    } else if (com.google.android.exoplayer2.source.ExtractorMediaPeriod.isNeedRetryExtractor && extractor.toString().contains("Ffmpeg")) {
                        boolean unused = com.google.android.exoplayer2.source.ExtractorMediaPeriod.isNeedRetryExtractor = false;
                    } else {
                        this.extractor = extractor;
                        extractorInput.resetPeekPosition();
                        break;
                    }
                } catch (java.io.EOFException unused2) {
                } catch (java.lang.Throwable th) {
                    extractorInput.resetPeekPosition();
                    throw th;
                }
                extractorInput.resetPeekPosition();
                i_renamed++;
            }
            com.google.android.exoplayer2.extractor.Extractor extractor2 = this.extractor;
            if (extractor2 == null) {
                throw new com.google.android.exoplayer2.source.UnrecognizedInputFormatException("None of_renamed the available extractors (" + com.google.android.exoplayer2.util.Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
            }
            extractor2.init(extractorOutput);
            return this.extractor;
        }

        public void release() {
            com.google.android.exoplayer2.extractor.Extractor extractor = this.extractor;
            if (extractor != null) {
                extractor.release();
                this.extractor = null;
            }
        }
    }

    private static final class PreparedState {
        public final com.google.android.exoplayer2.extractor.SeekMap seekMap;
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final com.google.android.exoplayer2.source.TrackGroupArray tracks;

        public PreparedState(com.google.android.exoplayer2.extractor.SeekMap seekMap, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.seekMap = seekMap;
            this.tracks = trackGroupArray;
            this.trackIsAudioVideoFlags = zArr;
            this.trackEnabledStates = new boolean[trackGroupArray.length];
            this.trackNotifiedDownstreamFormats = new boolean[trackGroupArray.length];
        }
    }
}
