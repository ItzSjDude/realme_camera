package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
final class SingleSampleMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
    private final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final long durationUs;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    final com.google.android.exoplayer2.Format format;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    boolean loadingFinished;
    boolean loadingSucceeded;
    boolean notifiedReadingStarted;
    byte[] sampleData;
    int sampleSize;
    private final com.google.android.exoplayer2.source.TrackGroupArray tracks;
    private final com.google.android.exoplayer2.upstream.TransferListener transferListener;
    final boolean treatLoadErrorsAsEndOfStream;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl> sampleStreams = new java.util.ArrayList<>();
    final com.google.android.exoplayer2.upstream.Loader loader = new com.google.android.exoplayer2.upstream.Loader("Loader:SingleSampleMediaPeriod");

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long j_renamed, boolean z_renamed) {
        return false;
    }

    public SingleSampleMediaPeriod(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.Format format, long j_renamed, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z_renamed) {
        this.dataSpec = dataSpec;
        this.dataSourceFactory = factory;
        this.transferListener = transferListener;
        this.format = format;
        this.durationUs = j_renamed;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.treatLoadErrorsAsEndOfStream = z_renamed;
        this.tracks = new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup(format));
        eventDispatcher.mediaPeriodCreated();
    }

    public void release() {
        this.loader.release();
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed) {
        for (int i_renamed = 0; i_renamed < trackSelectionArr.length; i_renamed++) {
            if (sampleStreamArr[i_renamed] != null && (trackSelectionArr[i_renamed] == null || !zArr[i_renamed])) {
                this.sampleStreams.remove(sampleStreamArr[i_renamed]);
                sampleStreamArr[i_renamed] = null;
            }
            if (sampleStreamArr[i_renamed] == null && trackSelectionArr[i_renamed] != null) {
                com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl sampleStreamImpl = new com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i_renamed] = sampleStreamImpl;
                zArr2[i_renamed] = true;
            }
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.transferListener;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, this.loader.startLoading(new com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable(this.dataSpec, dataSourceCreateDataSource), this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1)));
        return true;
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
    public long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        for (int i_renamed = 0; i_renamed < this.sampleStreams.size(); i_renamed++) {
            this.sampleStreams.get(i_renamed).reset();
        }
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j_renamed, long j2) {
        this.sampleSize = (int) sourceLoadable.dataSource.getBytesRead();
        this.sampleData = sourceLoadable.sampleData;
        this.loadingFinished = true;
        this.loadingSucceeded = true;
        this.eventDispatcher.loadCompleted(sourceLoadable.dataSpec, sourceLoadable.dataSource.getLastOpenedUri(), sourceLoadable.dataSource.getLastResponseHeaders(), 1, -1, this.format, 0, null, 0L, this.durationUs, j_renamed, j2, this.sampleSize);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j_renamed, long j2, boolean z_renamed) {
        this.eventDispatcher.loadCanceled(sourceLoadable.dataSpec, sourceLoadable.dataSource.getLastOpenedUri(), sourceLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, 0L, this.durationUs, j_renamed, j2, sourceLoadable.dataSource.getBytesRead());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(1, this.durationUs, iOException, i_renamed);
        boolean z_renamed = retryDelayMsFor == -9223372036854775807L || i_renamed >= this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
        if (this.treatLoadErrorsAsEndOfStream && z_renamed) {
            this.loadingFinished = true;
            loadErrorActionCreateRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        } else {
            loadErrorActionCreateRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        this.eventDispatcher.loadError(sourceLoadable.dataSpec, sourceLoadable.dataSource.getLastOpenedUri(), sourceLoadable.dataSource.getLastResponseHeaders(), 1, -1, this.format, 0, null, 0L, this.durationUs, j_renamed, j2, sourceLoadable.dataSource.getBytesRead(), iOException, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    private final class SampleStreamImpl implements com.google.android.exoplayer2.source.SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean notifiedDownstreamFormat;
        private int streamState;

        private SampleStreamImpl() {
        }

        public void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.loadingFinished;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            if (com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.treatLoadErrorsAsEndOfStream) {
                return;
            }
            com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.loader.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
            maybeNotifyDownstreamFormat();
            int i_renamed = this.streamState;
            if (i_renamed == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if (z_renamed || i_renamed == 0) {
                formatHolder.format = com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            }
            if (!com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.loadingFinished) {
                return -3;
            }
            if (com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.loadingSucceeded) {
                decoderInputBuffer.timeUs = 0L;
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.ensureSpaceForWrite(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.sampleSize);
                decoderInputBuffer.data.put(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.sampleData, 0, com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.sampleSize);
            } else {
                decoderInputBuffer.addFlag(4);
            }
            this.streamState = 2;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j_renamed) {
            maybeNotifyDownstreamFormat();
            if (j_renamed <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            return 1;
        }

        private void maybeNotifyDownstreamFormat() {
            if (this.notifiedDownstreamFormat) {
                return;
            }
            com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(com.google.android.exoplayer2.util.MimeTypes.getTrackType(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.format.sampleMimeType), com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.format, 0, null, 0L);
            this.notifiedDownstreamFormat = true;
        }
    }

    static final class SourceLoadable implements com.google.android.exoplayer2.upstream.Loader.Loadable {
        private final com.google.android.exoplayer2.upstream.StatsDataSource dataSource;
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        private byte[] sampleData;

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        public SourceLoadable(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSource dataSource) {
            this.dataSpec = dataSpec;
            this.dataSource = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws java.lang.InterruptedException, java.io.IOException {
            this.dataSource.resetBytesRead();
            try {
                this.dataSource.open(this.dataSpec);
                int i_renamed = 0;
                while (i_renamed != -1) {
                    int bytesRead = (int) this.dataSource.getBytesRead();
                    if (this.sampleData == null) {
                        this.sampleData = new byte[1024];
                    } else if (bytesRead == this.sampleData.length) {
                        this.sampleData = java.util.Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
                    }
                    i_renamed = this.dataSource.read(this.sampleData, bytesRead, this.sampleData.length - bytesRead);
                }
            } finally {
                com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            }
        }
    }
}
