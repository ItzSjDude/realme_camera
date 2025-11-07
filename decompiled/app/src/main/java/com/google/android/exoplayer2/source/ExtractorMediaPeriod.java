package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class ExtractorMediaPeriod implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private static final String TAG = "ExtractorMediaPeriod";
    private static boolean isNeedRetryExtractor;
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final long continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource dataSource;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    private boolean haveAudioVideoTracks;
    private long lastSeekPositionUs;
    private final Listener listener;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean loadingFinished;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    private boolean pendingDeferredRetry;
    private boolean prepared;
    private PreparedState preparedState;
    private boolean released;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private final Uri uri;
    private final Loader loader = new Loader("Loader:ExtractorMediaPeriod");
    private final ConditionVariable loadCondition = new ConditionVariable();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$ExtractorMediaPeriod$Ll7lI30pD07GZk92Lo8XgkQMAAY
        @Override // java.lang.Runnable
        public final void run() {
            this.COUIBaseListPopupWindow_12$0.maybeFinishPrepare();
        }
    };
    private final Runnable onContinueLoadingRequestedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$ExtractorMediaPeriod$Hd-sBytb6cpkhM49l8dYCND3wmk
        @Override // java.lang.Runnable
        public final void run() {
            this.COUIBaseListPopupWindow_12$0.lambda$new$0$ExtractorMediaPeriod();
        }
    };
    private final Handler handler = new Handler();
    private int[] sampleQueueTrackIds = new int[0];
    private SampleQueue[] sampleQueues = new SampleQueue[0];
    private long pendingResetPositionUs = -9223372036854775807L;
    private long length = -1;
    private long durationUs = -9223372036854775807L;
    private int dataType = 1;

    interface Listener {
        void onSourceInfoRefreshed(long OplusGLSurfaceView_15, boolean z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long OplusGLSurfaceView_15) {
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, Listener listener, Allocator allocator, String str, int OplusGLSurfaceView_13) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = OplusGLSurfaceView_13;
        this.extractorHolder = new ExtractorHolder(extractorArr);
        eventDispatcher.mediaPeriodCreated();
    }

    public /* synthetic */ void lambda$new$0$ExtractorMediaPeriod() {
        if (this.released) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void release() {
        if (this.prepared) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
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
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        this.extractorHolder.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long OplusGLSurfaceView_15) {
        this.callback = callback;
        this.loadCondition.open();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return getPreparedState().tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long OplusGLSurfaceView_15) {
        PreparedState preparedState = getPreparedState();
        TrackGroupArray trackGroupArray = preparedState.tracks;
        boolean[] zArr3 = preparedState.trackEnabledStates;
        int OplusGLSurfaceView_13 = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((SampleStreamImpl) sampleStreamArr[i3]).track;
                Assertions.checkState(zArr3[i4]);
                this.enabledTrackCount--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.seenFirstTrackSelection ? OplusGLSurfaceView_15 == 0 : OplusGLSurfaceView_13 != 0;
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && trackSelectionArr[i5] != null) {
                TrackSelection trackSelection = trackSelectionArr[i5];
                Assertions.checkState(trackSelection.length() == 1);
                Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int iIndexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[iIndexOf]);
                this.enabledTrackCount++;
                zArr3[iIndexOf] = true;
                sampleStreamArr[i5] = new SampleStreamImpl(iIndexOf);
                zArr2[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.sampleQueues[iIndexOf];
                    sampleQueue.rewind();
                    z = sampleQueue.advanceTo(OplusGLSurfaceView_15, true, true) == -1 && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            OplusGLSurfaceView_15 = seekToUs(OplusGLSurfaceView_15);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.seenFirstTrackSelection = true;
        return OplusGLSurfaceView_15;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long OplusGLSurfaceView_15, boolean z) {
        if (isPendingReset()) {
            return;
        }
        boolean[] zArr = getPreparedState().trackEnabledStates;
        int length = this.sampleQueues.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.sampleQueues[OplusGLSurfaceView_13].discardTo(OplusGLSurfaceView_15, z, zArr[OplusGLSurfaceView_13]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long OplusGLSurfaceView_15) {
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
    public long getNextKeyFramePositionUs(long OplusGLSurfaceView_15) {
        int length = this.sampleQueues.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            SampleQueue sampleQueue = this.sampleQueues[OplusGLSurfaceView_13];
            if (MimeTypes.isVideo(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                return sampleQueue.getNextKeyFramePositionUs(OplusGLSurfaceView_15);
            }
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int OplusGLSurfaceView_13) {
        int i2 = 0;
        if (OplusGLSurfaceView_13 == 1) {
            while (true) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                if (i2 >= sampleQueueArr.length) {
                    return -1L;
                }
                SampleQueue sampleQueue = sampleQueueArr[i2];
                if (MimeTypes.isAudio(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                    return sampleQueue.getLargestQueuedTimestampUs();
                }
                i2++;
            }
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return -1L;
            }
            while (true) {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                if (i2 >= sampleQueueArr2.length) {
                    return -1L;
                }
                SampleQueue sampleQueue2 = sampleQueueArr2[i2];
                if (MimeTypes.isVideo(sampleQueue2.getUpstreamFormat().sampleMimeType)) {
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
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                if (zArr[OplusGLSurfaceView_13] && !this.sampleQueues[OplusGLSurfaceView_13].isLastSampleQueued()) {
                    largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.sampleQueues[OplusGLSurfaceView_13].getLargestQueuedTimestampUs());
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

    private boolean seekAudioInGop(boolean[] zArr, long OplusGLSurfaceView_15) {
        int length = this.sampleQueues.length;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[OplusGLSurfaceView_13];
            if (MimeTypes.isAudio(sampleQueue.getUpstreamFormat().sampleMimeType)) {
                sampleQueue.rewind();
                if (!(sampleQueue.advanceTo(OplusGLSurfaceView_15, true, false) != -1) && (zArr[OplusGLSurfaceView_13] || !this.haveAudioVideoTracks)) {
                    break;
                }
            }
            OplusGLSurfaceView_13++;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long OplusGLSurfaceView_15, boolean z) {
        PreparedState preparedState = getPreparedState();
        SeekMap seekMap = preparedState.seekMap;
        boolean[] zArr = preparedState.trackIsAudioVideoFlags;
        if (!seekMap.isSeekable()) {
            OplusGLSurfaceView_15 = 0;
        }
        this.lastSeekPositionUs = OplusGLSurfaceView_15;
        if (!z || this.dataType == 7) {
            return true;
        }
        return seekAudioInGop(zArr, OplusGLSurfaceView_15);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long OplusGLSurfaceView_15) {
        PreparedState preparedState = getPreparedState();
        SeekMap seekMap = preparedState.seekMap;
        boolean[] zArr = preparedState.trackIsAudioVideoFlags;
        if (!seekMap.isSeekable()) {
            OplusGLSurfaceView_15 = 0;
        }
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = OplusGLSurfaceView_15;
        if (isPendingReset()) {
            this.pendingResetPositionUs = OplusGLSurfaceView_15;
            return OplusGLSurfaceView_15;
        }
        if (this.dataType != 7 && seekInsideBufferUs(zArr, OplusGLSurfaceView_15)) {
            return OplusGLSurfaceView_15;
        }
        this.pendingDeferredRetry = false;
        this.pendingResetPositionUs = OplusGLSurfaceView_15;
        this.loadingFinished = false;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
        }
        return OplusGLSurfaceView_15;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long OplusGLSurfaceView_15, SeekParameters seekParameters) {
        SeekMap seekMap = getPreparedState().seekMap;
        if (!seekMap.isSeekable()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPoints = seekMap.getSeekPoints(OplusGLSurfaceView_15);
        return Util.resolveSeekPositionUs(OplusGLSurfaceView_15, seekParameters, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    boolean isReady(int OplusGLSurfaceView_13) {
        return !suppressRead() && (this.loadingFinished || this.sampleQueues[OplusGLSurfaceView_13].hasNextSample());
    }

    void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }

    int readData(int OplusGLSurfaceView_13, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(OplusGLSurfaceView_13);
        int i2 = this.sampleQueues[OplusGLSurfaceView_13].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (i2 == -3) {
            maybeStartDeferredRetry(OplusGLSurfaceView_13);
        }
        return i2;
    }

    int skipData(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        int iAdvanceToEnd = 0;
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(OplusGLSurfaceView_13);
        SampleQueue sampleQueue = this.sampleQueues[OplusGLSurfaceView_13];
        if (this.loadingFinished && OplusGLSurfaceView_15 > sampleQueue.getLargestQueuedTimestampUs()) {
            iAdvanceToEnd = sampleQueue.advanceToEnd();
        } else {
            int iAdvanceTo = sampleQueue.advanceTo(OplusGLSurfaceView_15, true, true);
            if (iAdvanceTo != -1) {
                iAdvanceToEnd = iAdvanceTo;
            }
        }
        if (iAdvanceToEnd == 0) {
            maybeStartDeferredRetry(OplusGLSurfaceView_13);
        }
        return iAdvanceToEnd;
    }

    private void maybeNotifyDownstreamFormat(int OplusGLSurfaceView_13) {
        PreparedState preparedState = getPreparedState();
        boolean[] zArr = preparedState.trackNotifiedDownstreamFormats;
        if (zArr[OplusGLSurfaceView_13]) {
            return;
        }
        Format format = preparedState.tracks.get(OplusGLSurfaceView_13).getFormat(0);
        this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.lastSeekPositionUs);
        zArr[OplusGLSurfaceView_13] = true;
    }

    private void maybeStartDeferredRetry(int OplusGLSurfaceView_13) {
        boolean[] zArr = getPreparedState().trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[OplusGLSurfaceView_13] && !this.sampleQueues[OplusGLSurfaceView_13].hasNextSample()) {
            this.pendingResetPositionUs = 0L;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long OplusGLSurfaceView_15, long j2) {
        if (this.durationUs == -9223372036854775807L) {
            SeekMap seekMap = (SeekMap) Assertions.checkNotNull(this.seekMap);
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            this.durationUs = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + DEFAULT_LAST_SAMPLE_DURATION_US;
            this.listener.onSourceInfoRefreshed(this.durationUs, seekMap.isSeekable());
        }
        this.eventDispatcher.loadCompleted(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, OplusGLSurfaceView_15, j2, extractingLoadable.dataSource.getBytesRead());
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long OplusGLSurfaceView_15, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, OplusGLSurfaceView_15, j2, extractingLoadable.dataSource.getBytesRead());
        if (z) {
            return;
        }
        copyLengthFromLoader(extractingLoadable);
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        if (this.enabledTrackCount > 0) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public Loader.LoadErrorAction onLoadError(ExtractingLoadable extractingLoadable, long OplusGLSurfaceView_15, long j2, IOException iOException, int OplusGLSurfaceView_13) {
        boolean z;
        ExtractingLoadable extractingLoadable2;
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        copyLengthFromLoader(extractingLoadable);
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(this.dataType, this.durationUs, iOException, OplusGLSurfaceView_13);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
                extractingLoadable2 = extractingLoadable;
                z = true;
            } else {
                z = false;
                extractingLoadable2 = extractingLoadable;
            }
            loadErrorActionCreateRetryAction = configureRetry(extractingLoadable2, extractedSamplesCount) ? Loader.createRetryAction(z, retryDelayMsFor) : Loader.DONT_RETRY;
        }
        this.eventDispatcher.loadError(extractingLoadable.dataSpec, extractingLoadable.dataSource.getLastOpenedUri(), extractingLoadable.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, OplusGLSurfaceView_15, j2, extractingLoadable.dataSource.getBytesRead(), iOException, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int OplusGLSurfaceView_13, int i2) {
        int length = this.sampleQueues.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.sampleQueueTrackIds[i3] == OplusGLSurfaceView_13) {
                return this.sampleQueues[i3];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i4 = length + 1;
        this.sampleQueueTrackIds = Arrays.copyOf(this.sampleQueueTrackIds, i4);
        this.sampleQueueTrackIds[length] = OplusGLSurfaceView_13;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i4);
        sampleQueueArr[length] = sampleQueue;
        this.sampleQueues = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        SeekMap seekMap = this.seekMap;
        if (this.released || this.prepared || !this.sampleQueuesBuilt || seekMap == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        this.loadCondition.close();
        int length = this.sampleQueues.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        this.durationUs = seekMap.getDurationUs();
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            boolean z = true;
            if (OplusGLSurfaceView_13 >= length) {
                break;
            }
            Format upstreamFormat = this.sampleQueues[OplusGLSurfaceView_13].getUpstreamFormat();
            trackGroupArr[OplusGLSurfaceView_13] = new TrackGroup(upstreamFormat);
            String str = upstreamFormat.sampleMimeType;
            if (!MimeTypes.isVideo(str) && !MimeTypes.isAudio(str)) {
                z = false;
            }
            zArr[OplusGLSurfaceView_13] = z;
            this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
            OplusGLSurfaceView_13++;
        }
        this.dataType = (this.length == -1 && seekMap.getDurationUs() == -9223372036854775807L) ? 7 : 1;
        this.preparedState = new PreparedState(seekMap, new TrackGroupArray(trackGroupArr), zArr);
        this.prepared = true;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap.isSeekable());
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    private PreparedState getPreparedState() {
        return (PreparedState) Assertions.checkNotNull(this.preparedState);
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this, this.loadCondition);
        if (this.prepared) {
            SeekMap seekMap = getPreparedState().seekMap;
            Assertions.checkState(isPendingReset());
            long OplusGLSurfaceView_15 = this.durationUs;
            if (OplusGLSurfaceView_15 != -9223372036854775807L && this.pendingResetPositionUs >= OplusGLSurfaceView_15) {
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

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int OplusGLSurfaceView_13) {
        SeekMap seekMap;
        if (this.length != -1 || ((seekMap = this.seekMap) != null && seekMap.getDurationUs() != -9223372036854775807L)) {
            this.extractedSamplesCountAtStartOfLoad = OplusGLSurfaceView_13;
            return true;
        }
        if (this.prepared && !suppressRead()) {
            this.pendingDeferredRetry = true;
            return false;
        }
        this.notifyDiscontinuity = this.prepared;
        this.lastSeekPositionUs = 0L;
        this.extractedSamplesCountAtStartOfLoad = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        extractingLoadable.setLoadPosition(0L, 0L);
        return true;
    }

    private boolean seekInsideBufferUs(boolean[] zArr, long OplusGLSurfaceView_15) {
        int length = this.sampleQueues.length;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[OplusGLSurfaceView_13];
            sampleQueue.rewind();
            if (!(sampleQueue.advanceTo(OplusGLSurfaceView_15, true, false) != -1) && (zArr[OplusGLSurfaceView_13] || !this.haveAudioVideoTracks)) {
                break;
            }
            OplusGLSurfaceView_13++;
        }
        return false;
    }

    private int getExtractedSamplesCount() {
        int writeIndex = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            writeIndex += sampleQueue.getWriteIndex();
        }
        return writeIndex;
    }

    private long getLargestQueuedTimestampUs() {
        long jMax = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            jMax = Math.max(jMax, sampleQueue.getLargestQueuedTimestampUs());
        }
        return jMax;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int OplusGLSurfaceView_13) {
            this.track = OplusGLSurfaceView_13;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ExtractorMediaPeriod.this.isReady(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            ExtractorMediaPeriod.this.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            return ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long OplusGLSurfaceView_15) {
            return ExtractorMediaPeriod.this.skipData(this.track, OplusGLSurfaceView_15);
        }
    }

    final class ExtractingLoadable implements Loader.Loadable {
        private final StatsDataSource dataSource;
        private DataSpec dataSpec;
        private final ExtractorHolder extractorHolder;
        private final ExtractorOutput extractorOutput;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private long seekTimeUs;
        private final Uri uri;
        private final PositionHolder positionHolder = new PositionHolder();
        private boolean pendingExtractorSeek = true;
        private long length = -1;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.uri = uri;
            this.dataSource = new StatsDataSource(dataSource);
            this.extractorHolder = extractorHolder;
            this.extractorOutput = extractorOutput;
            this.loadCondition = conditionVariable;
            this.dataSpec = new DataSpec(uri, this.positionHolder.position, -1L, ExtractorMediaPeriod.this.customCacheKey);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws Throwable {
            long OplusGLSurfaceView_15;
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 == 0 && !this.loadCanceled) {
                DefaultExtractorInput defaultExtractorInput = null;
                try {
                    long position = this.positionHolder.position;
                    this.dataSpec = new DataSpec(this.uri, position, -1L, ExtractorMediaPeriod.this.customCacheKey);
                    this.length = this.dataSource.open(this.dataSpec);
                    if (this.length != -1) {
                        this.length += position;
                    }
                    Uri uri = (Uri) Assertions.checkNotNull(this.dataSource.getUri());
                    DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, position, this.length);
                    try {
                        Extractor extractorSelectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.extractorOutput, uri);
                        if (this.pendingExtractorSeek) {
                            extractorSelectExtractor.seek(position, this.seekTimeUs);
                            this.pendingExtractorSeek = false;
                        }
                        Uri uri2 = uri;
                        Extractor extractor = extractorSelectExtractor;
                        DefaultExtractorInput defaultExtractorInput3 = defaultExtractorInput2;
                        while (OplusGLSurfaceView_13 == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            OplusGLSurfaceView_13 = extractor.read(defaultExtractorInput3, this.positionHolder);
                            if (OplusGLSurfaceView_13 == 2) {
                                boolean unused = ExtractorMediaPeriod.isNeedRetryExtractor = true;
                                Util.closeQuietly(this.dataSource);
                                long j2 = this.positionHolder.position;
                                this.dataSpec = new DataSpec(uri2, j2, -1L, ExtractorMediaPeriod.this.customCacheKey);
                                this.length = this.dataSource.open(this.dataSpec);
                                if (this.length != -1) {
                                    this.length += j2;
                                }
                                uri2 = (Uri) Assertions.checkNotNull(this.dataSource.getUri());
                                DefaultExtractorInput defaultExtractorInput4 = new DefaultExtractorInput(this.dataSource, j2, this.length);
                                try {
                                    Extractor extractorSelectExtractor2 = this.extractorHolder.selectExtractor(defaultExtractorInput4, this.extractorOutput, uri2);
                                    if (this.pendingExtractorSeek) {
                                        OplusGLSurfaceView_15 = j2;
                                        extractorSelectExtractor2.seek(OplusGLSurfaceView_15, this.seekTimeUs);
                                        this.pendingExtractorSeek = false;
                                    } else {
                                        OplusGLSurfaceView_15 = j2;
                                    }
                                    OplusGLSurfaceView_13 = 0;
                                    position = OplusGLSurfaceView_15;
                                    extractor = extractorSelectExtractor2;
                                    defaultExtractorInput3 = defaultExtractorInput4;
                                } catch (Throwable th) {
                                    th = th;
                                    defaultExtractorInput = defaultExtractorInput4;
                                    if (OplusGLSurfaceView_13 != 1 && defaultExtractorInput != null) {
                                        this.positionHolder.position = defaultExtractorInput.getPosition();
                                    }
                                    Util.closeQuietly(this.dataSource);
                                    throw th;
                                }
                            } else if (defaultExtractorInput3.getPosition() > ExtractorMediaPeriod.this.continueLoadingCheckIntervalBytes + position) {
                                position = defaultExtractorInput3.getPosition();
                                this.loadCondition.close();
                                ExtractorMediaPeriod.this.handler.post(ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                        if (OplusGLSurfaceView_13 == 1) {
                            OplusGLSurfaceView_13 = 0;
                        } else {
                            this.positionHolder.position = defaultExtractorInput3.getPosition();
                        }
                        Util.closeQuietly(this.dataSource);
                    } catch (Throwable th2) {
                        th = th2;
                        defaultExtractorInput = defaultExtractorInput2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoadPosition(long OplusGLSurfaceView_15, long j2) {
            this.positionHolder.position = OplusGLSurfaceView_15;
            this.seekTimeUs = j2;
            this.pendingExtractorSeek = true;
        }
    }

    private static final class ExtractorHolder {
        private Extractor extractor;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr) {
            this.extractors = extractorArr;
        }

        public Extractor selectExtractor(ExtractorInput extractorInput, ExtractorOutput extractorOutput, Uri uri) throws InterruptedException, IOException {
            if (this.extractor != null && !ExtractorMediaPeriod.isNeedRetryExtractor) {
                return this.extractor;
            }
            Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= length) {
                    break;
                }
                Extractor extractor = extractorArr[OplusGLSurfaceView_13];
                try {
                    if (!extractor.sniff(extractorInput)) {
                        continue;
                    } else if (ExtractorMediaPeriod.isNeedRetryExtractor && extractor.toString().contains("Ffmpeg")) {
                        boolean unused = ExtractorMediaPeriod.isNeedRetryExtractor = false;
                    } else {
                        this.extractor = extractor;
                        extractorInput.resetPeekPosition();
                        break;
                    }
                } catch (EOFException unused2) {
                } catch (Throwable th) {
                    extractorInput.resetPeekPosition();
                    throw th;
                }
                extractorInput.resetPeekPosition();
                OplusGLSurfaceView_13++;
            }
            Extractor extractor2 = this.extractor;
            if (extractor2 == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
            }
            extractor2.init(extractorOutput);
            return this.extractor;
        }

        public void release() {
            Extractor extractor = this.extractor;
            if (extractor != null) {
                extractor.release();
                this.extractor = null;
            }
        }
    }

    private static final class PreparedState {
        public final SeekMap seekMap;
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public PreparedState(SeekMap seekMap, TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.seekMap = seekMap;
            this.tracks = trackGroupArray;
            this.trackIsAudioVideoFlags = zArr;
            this.trackEnabledStates = new boolean[trackGroupArray.length];
            this.trackNotifiedDownstreamFormats = new boolean[trackGroupArray.length];
        }
    }
}
