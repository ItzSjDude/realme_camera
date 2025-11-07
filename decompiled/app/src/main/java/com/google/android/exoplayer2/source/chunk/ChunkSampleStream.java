package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public class ChunkSampleStream<T_renamed extends com.google.android.exoplayer2.source.chunk.ChunkSource> implements com.google.android.exoplayer2.source.SampleStream, com.google.android.exoplayer2.source.SequenceableLoader, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.chunk.Chunk>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback {
    private static final java.lang.String TAG = "ChunkSampleStream";
    private final com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed>> callback;
    private final T_renamed chunkSource;
    long decodeOnlyUntilPositionUs;
    private final com.google.android.exoplayer2.source.SampleQueue[] embeddedSampleQueues;
    private final com.google.android.exoplayer2.Format[] embeddedTrackFormats;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private long lastSeekPositionUs;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final com.google.android.exoplayer2.upstream.Loader loader;
    boolean loadingFinished;
    private final com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput mediaChunkOutput;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> mediaChunks;
    private final com.google.android.exoplayer2.source.chunk.ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private com.google.android.exoplayer2.Format primaryDownstreamTrackFormat;
    private final com.google.android.exoplayer2.source.SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> readOnlyMediaChunks;
    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T_renamed> releaseCallback;

    public interface ReleaseCallback<T_renamed extends com.google.android.exoplayer2.source.chunk.ChunkSource> {
        void onSampleStreamReleased(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed> chunkSampleStream);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @java.lang.Deprecated
    public ChunkSampleStream(int i_renamed, int[] iArr, com.google.android.exoplayer2.Format[] formatArr, T_renamed t_renamed, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed>> callback, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed, int i2, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher) {
        this(i_renamed, iArr, formatArr, t_renamed, callback, allocator, j_renamed, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i2), eventDispatcher);
    }

    public ChunkSampleStream(int i_renamed, int[] iArr, com.google.android.exoplayer2.Format[] formatArr, T_renamed t_renamed, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed>> callback, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.primaryTrackType = i_renamed;
        this.embeddedTrackTypes = iArr;
        this.embeddedTrackFormats = formatArr;
        this.chunkSource = t_renamed;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.loader = new com.google.android.exoplayer2.upstream.Loader("Loader:ChunkSampleStream");
        this.nextChunkHolder = new com.google.android.exoplayer2.source.chunk.ChunkHolder();
        this.mediaChunks = new java.util.ArrayList<>();
        this.readOnlyMediaChunks = java.util.Collections.unmodifiableList(this.mediaChunks);
        int i2 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.embeddedSampleQueues = new com.google.android.exoplayer2.source.SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = new com.google.android.exoplayer2.source.SampleQueue[i3];
        this.primarySampleQueue = new com.google.android.exoplayer2.source.SampleQueue(allocator);
        iArr2[0] = i_renamed;
        sampleQueueArr[0] = this.primarySampleQueue;
        while (i2 < length) {
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = new com.google.android.exoplayer2.source.SampleQueue(allocator);
            this.embeddedSampleQueues[i2] = sampleQueue;
            int i4 = i2 + 1;
            sampleQueueArr[i4] = sampleQueue;
            iArr2[i4] = iArr[i2];
            i2 = i4;
        }
        this.mediaChunkOutput = new com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j_renamed;
        this.lastSeekPositionUs = j_renamed;
    }

    public void discardBuffer(long j_renamed, boolean z_renamed) {
        if (isPendingReset()) {
            return;
        }
        int firstIndex = this.primarySampleQueue.getFirstIndex();
        this.primarySampleQueue.discardTo(j_renamed, z_renamed, true);
        int firstIndex2 = this.primarySampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
            int i_renamed = 0;
            while (true) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                if (i_renamed >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i_renamed].discardTo(firstTimestampUs, z_renamed, this.embeddedTracksSelected[i_renamed]);
                i_renamed++;
            }
        }
        discardDownstreamMediaChunks(firstIndex2);
    }

    public com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed>.EmbeddedSampleStream selectEmbeddedTrack(long j_renamed, int i_renamed) {
        for (int i2 = 0; i2 < this.embeddedSampleQueues.length; i2++) {
            if (this.embeddedTrackTypes[i2] == i_renamed) {
                com.google.android.exoplayer2.util.Assertions.checkState(!this.embeddedTracksSelected[i2]);
                this.embeddedTracksSelected[i2] = true;
                this.embeddedSampleQueues[i2].rewind();
                this.embeddedSampleQueues[i2].advanceTo(j_renamed, true, true);
                return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream(this, this.embeddedSampleQueues[i2], i2);
            }
        }
        throw new java.lang.IllegalStateException();
    }

    public T_renamed getChunkSource() {
        return this.chunkSource;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long jMax = this.lastSeekPositionUs;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                lastMediaChunk = this.mediaChunks.get(r2.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            jMax = java.lang.Math.max(jMax, lastMediaChunk.endTimeUs);
        }
        return java.lang.Math.max(jMax, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j_renamed, seekParameters);
    }

    public void seekToUs(long j_renamed) {
        boolean readPosition;
        this.lastSeekPositionUs = j_renamed;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j_renamed;
            return;
        }
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = null;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= this.mediaChunks.size()) {
                break;
            }
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk2 = this.mediaChunks.get(i_renamed);
            long j2 = baseMediaChunk2.startTimeUs;
            if (j2 == j_renamed && baseMediaChunk2.clippedStartTimeUs == -9223372036854775807L) {
                baseMediaChunk = baseMediaChunk2;
                break;
            } else if (j2 > j_renamed) {
                break;
            } else {
                i_renamed++;
            }
        }
        this.primarySampleQueue.rewind();
        if (baseMediaChunk != null) {
            readPosition = this.primarySampleQueue.setReadPosition(baseMediaChunk.getFirstSampleIndex(0));
            this.decodeOnlyUntilPositionUs = 0L;
        } else {
            readPosition = this.primarySampleQueue.advanceTo(j_renamed, true, (j_renamed > getNextLoadPositionUs() ? 1 : (j_renamed == getNextLoadPositionUs() ? 0 : -1)) < 0) != -1;
            this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
        }
        if (readPosition) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), 0);
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.embeddedSampleQueues) {
                sampleQueue.rewind();
                sampleQueue.advanceTo(j_renamed, true, false);
            }
            return;
        }
        this.pendingResetPositionUs = j_renamed;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.primarySampleQueue.reset();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
            sampleQueue2.reset();
        }
    }

    public void release() {
        release(null);
    }

    public void release(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T_renamed> releaseCallback) {
        this.releaseCallback = releaseCallback;
        this.primarySampleQueue.discardToEnd();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.discardToEnd();
        }
        this.loader.release(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T_renamed> releaseCallback = this.releaseCallback;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.loadingFinished || (!isPendingReset() && this.primarySampleQueue.hasNextSample());
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
        this.loader.maybeThrowError();
        if (this.loader.isLoading()) {
            return;
        }
        this.chunkSource.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        if (isPendingReset()) {
            return -3;
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z_renamed, this.loadingFinished, this.decodeOnlyUntilPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j_renamed) {
        int iAdvanceToEnd = 0;
        if (isPendingReset()) {
            return 0;
        }
        if (this.loadingFinished && j_renamed > this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            iAdvanceToEnd = this.primarySampleQueue.advanceToEnd();
        } else {
            int iAdvanceTo = this.primarySampleQueue.advanceTo(j_renamed, true, true);
            if (iAdvanceTo != -1) {
                iAdvanceToEnd = iAdvanceTo;
            }
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return iAdvanceToEnd;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, chunk.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2, boolean z_renamed) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, chunk.bytesLoaded());
        if (z_renamed) {
            return;
        }
        this.primarySampleQueue.reset();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        long jBytesLoaded = chunk.bytesLoaded();
        boolean zIsMediaChunk = isMediaChunk(chunk);
        int size = this.mediaChunks.size() - 1;
        boolean z_renamed = (jBytesLoaded != 0 && zIsMediaChunk && haveReadFromMediaChunk(size)) ? false : true;
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionCreateRetryAction = null;
        if (this.chunkSource.onChunkLoadError(chunk, z_renamed, iOException, z_renamed ? this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(chunk.type, j2, iOException, i_renamed) : -9223372036854775807L)) {
            if (z_renamed) {
                loadErrorActionCreateRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
                if (zIsMediaChunk) {
                    com.google.android.exoplayer2.util.Assertions.checkState(discardUpstreamMediaChunksFromIndex(size) == chunk);
                    if (this.mediaChunks.isEmpty()) {
                        this.pendingResetPositionUs = this.lastSeekPositionUs;
                    }
                }
            } else {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring attempt to cancel non-cancelable load.");
            }
        }
        if (loadErrorActionCreateRetryAction == null) {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(chunk.type, j2, iOException, i_renamed);
            loadErrorActionCreateRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorAction = loadErrorActionCreateRetryAction;
        boolean z2 = !loadErrorAction.isRetry();
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j_renamed, j2, jBytesLoaded, iOException, z2);
        if (z2) {
            this.callback.onContinueLoadingRequested(this);
        }
        return loadErrorAction;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> listEmptyList;
        long j2;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        boolean zIsPendingReset = isPendingReset();
        if (zIsPendingReset) {
            listEmptyList = java.util.Collections.emptyList();
            j2 = this.pendingResetPositionUs;
        } else {
            listEmptyList = this.readOnlyMediaChunks;
            j2 = getLastMediaChunk().endTimeUs;
        }
        this.chunkSource.getNextChunk(j_renamed, j2, listEmptyList, this.nextChunkHolder);
        boolean z_renamed = this.nextChunkHolder.endOfStream;
        com.google.android.exoplayer2.source.chunk.Chunk chunk = this.nextChunkHolder.chunk;
        this.nextChunkHolder.clear();
        if (z_renamed) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        if (isMediaChunk(chunk)) {
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = (com.google.android.exoplayer2.source.chunk.BaseMediaChunk) chunk;
            if (zIsPendingReset) {
                this.decodeOnlyUntilPositionUs = baseMediaChunk.startTimeUs == this.pendingResetPositionUs ? 0L : this.pendingResetPositionUs;
                this.pendingResetPositionUs = -9223372036854775807L;
            }
            baseMediaChunk.init(this.mediaChunkOutput);
            this.mediaChunks.add(baseMediaChunk);
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type)));
        return true;
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
    public void reevaluateBuffer(long j_renamed) {
        int size;
        int preferredQueueSize;
        if (this.loader.isLoading() || isPendingReset() || (size = this.mediaChunks.size()) <= (preferredQueueSize = this.chunkSource.getPreferredQueueSize(j_renamed, this.readOnlyMediaChunks))) {
            return;
        }
        while (true) {
            if (preferredQueueSize >= size) {
                preferredQueueSize = size;
                break;
            } else if (!haveReadFromMediaChunk(preferredQueueSize)) {
                break;
            } else {
                preferredQueueSize++;
            }
        }
        if (preferredQueueSize == size) {
            return;
        }
        long j2 = getLastMediaChunk().endTimeUs;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunkDiscardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(preferredQueueSize);
        if (this.mediaChunks.isEmpty()) {
            this.pendingResetPositionUs = this.lastSeekPositionUs;
        }
        this.loadingFinished = false;
        this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, baseMediaChunkDiscardUpstreamMediaChunksFromIndex.startTimeUs, j2);
    }

    private boolean isMediaChunk(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
    }

    private boolean haveReadFromMediaChunk(int i_renamed) {
        int readIndex;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i_renamed);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i2 = 0;
        do {
            com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i2].getReadIndex();
            i2++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i2));
        return true;
    }

    boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void discardDownstreamMediaChunks(int i_renamed) {
        int iMin = java.lang.Math.min(primarySampleIndexToMediaChunkIndex(i_renamed, 0), this.nextNotifyPrimaryFormatMediaChunkIndex);
        if (iMin > 0) {
            com.google.android.exoplayer2.util.Util.removeRange(this.mediaChunks, 0, iMin);
            this.nextNotifyPrimaryFormatMediaChunkIndex -= iMin;
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        int iPrimarySampleIndexToMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), this.nextNotifyPrimaryFormatMediaChunkIndex - 1);
        while (true) {
            int i_renamed = this.nextNotifyPrimaryFormatMediaChunkIndex;
            if (i_renamed > iPrimarySampleIndexToMediaChunkIndex) {
                return;
            }
            this.nextNotifyPrimaryFormatMediaChunkIndex = i_renamed + 1;
            maybeNotifyPrimaryTrackFormatChanged(i_renamed);
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i_renamed) {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i_renamed);
        com.google.android.exoplayer2.Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }

    private int primarySampleIndexToMediaChunkIndex(int i_renamed, int i2) {
        do {
            i2++;
            if (i2 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i2).getFirstSampleIndex(0) <= i_renamed);
        return i2 - 1;
    }

    private com.google.android.exoplayer2.source.chunk.BaseMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r1.size() - 1);
    }

    private com.google.android.exoplayer2.source.chunk.BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i_renamed) {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i_renamed);
        java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> arrayList = this.mediaChunks;
        com.google.android.exoplayer2.util.Util.removeRange(arrayList, i_renamed, arrayList.size());
        this.nextNotifyPrimaryFormatMediaChunkIndex = java.lang.Math.max(this.nextNotifyPrimaryFormatMediaChunkIndex, this.mediaChunks.size());
        int i2 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = sampleQueueArr[i2];
            i2++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i2));
        }
    }

    public final class EmbeddedSampleStream implements com.google.android.exoplayer2.source.SampleStream {
        private final int index;
        private boolean notifiedDownstreamFormat;
        public final com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed> parent;
        private final com.google.android.exoplayer2.source.SampleQueue sampleQueue;

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
        }

        public EmbeddedSampleStream(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T_renamed> chunkSampleStream, com.google.android.exoplayer2.source.SampleQueue sampleQueue, int i_renamed) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue;
            this.index = i_renamed;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.loadingFinished || (!com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.isPendingReset() && this.sampleQueue.hasNextSample());
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j_renamed) {
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.isPendingReset()) {
                return 0;
            }
            maybeNotifyDownstreamFormat();
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.loadingFinished && j_renamed > this.sampleQueue.getLargestQueuedTimestampUs()) {
                return this.sampleQueue.advanceToEnd();
            }
            int iAdvanceTo = this.sampleQueue.advanceTo(j_renamed, true, true);
            if (iAdvanceTo == -1) {
                return 0;
            }
            return iAdvanceTo;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            maybeNotifyDownstreamFormat();
            return this.sampleQueue.read(formatHolder, decoderInputBuffer, z_renamed, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.loadingFinished, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.decodeOnlyUntilPositionUs);
        }

        public void release() {
            com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        private void maybeNotifyDownstreamFormat() {
            if (this.notifiedDownstreamFormat) {
                return;
            }
            com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.embeddedTrackTypes[this.index], com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, null, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.lastSeekPositionUs);
            this.notifiedDownstreamFormat = true;
        }
    }
}
