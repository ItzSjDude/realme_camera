package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    private final boolean allowDynamicClippingUpdates;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private Object manifest;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        private static String getReasonDescription(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }

        public IllegalClippingException(int OplusGLSurfaceView_13) {
            super("Illegal clipping: " + getReasonDescription(OplusGLSurfaceView_13));
            this.reason = OplusGLSurfaceView_13;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long OplusGLSurfaceView_15, long j2) {
        this(mediaSource, OplusGLSurfaceView_15, j2, true, false, false);
    }

    @Deprecated
    public ClippingMediaSource(MediaSource mediaSource, long OplusGLSurfaceView_15, long j2, boolean z) {
        this(mediaSource, OplusGLSurfaceView_15, j2, z, false, false);
    }

    public ClippingMediaSource(MediaSource mediaSource, long OplusGLSurfaceView_15) {
        this(mediaSource, 0L, OplusGLSurfaceView_15, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource, long OplusGLSurfaceView_15, long j2, boolean z, boolean z2, boolean z3) {
        Assertions.checkArgument(OplusGLSurfaceView_15 >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.startUs = OplusGLSurfaceView_15;
        this.endUs = j2;
        this.enableInitialDiscontinuity = z;
        this.allowDynamicClippingUpdates = z2;
        this.relativeToDefaultPosition = z3;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long OplusGLSurfaceView_15) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator, OplusGLSurfaceView_15), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            return;
        }
        refreshClippedTimeline(this.clippingTimeline.timeline);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(Void r1, MediaSource mediaSource, Timeline timeline, Object obj) {
        if (this.clippingError != null) {
            return;
        }
        this.manifest = obj;
        refreshClippedTimeline(timeline);
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long OplusGLSurfaceView_15;
        long j2;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j3 = this.startUs;
            long j4 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j3 += defaultPositionUs;
                j4 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j3;
            this.periodEndUs = this.endUs != Long.MIN_VALUE ? positionInFirstPeriodUs + j4 : Long.MIN_VALUE;
            int size = this.mediaPeriods.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.mediaPeriods.get(OplusGLSurfaceView_13).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            OplusGLSurfaceView_15 = j3;
            j2 = j4;
        } else {
            long j5 = this.periodStartUs - positionInFirstPeriodUs;
            j2 = this.endUs != Long.MIN_VALUE ? this.periodEndUs - positionInFirstPeriodUs : Long.MIN_VALUE;
            OplusGLSurfaceView_15 = j5;
        }
        try {
            this.clippingTimeline = new ClippingTimeline(timeline, OplusGLSurfaceView_15, j2);
            refreshSourceInfo(this.clippingTimeline, this.manifest);
        } catch (IllegalClippingException COUIBaseListPopupWindow_8) {
            this.clippingError = COUIBaseListPopupWindow_8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public long getMediaTimeForChildMediaTime(Void r7, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jUsToMs = C1547C.usToMs(this.startUs);
        long jMax = Math.max(0L, OplusGLSurfaceView_15 - jUsToMs);
        long j2 = this.endUs;
        return j2 != Long.MIN_VALUE ? Math.min(C1547C.usToMs(j2) - jUsToMs, jMax) : jMax;
    }

    private static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long OplusGLSurfaceView_15, long j2) throws IllegalClippingException {
            super(timeline);
            boolean z = false;
            if (timeline.getPeriodCount() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
            long jMax = Math.max(0L, OplusGLSurfaceView_15);
            long jMax2 = j2 == Long.MIN_VALUE ? window.durationUs : Math.max(0L, j2);
            if (window.durationUs != -9223372036854775807L) {
                jMax2 = jMax2 > window.durationUs ? window.durationUs : jMax2;
                if (jMax != 0 && !window.isSeekable) {
                    throw new IllegalClippingException(1);
                }
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.startUs = jMax;
            this.endUs = jMax2;
            this.durationUs = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (window.isDynamic && (jMax2 == -9223372036854775807L || (window.durationUs != -9223372036854775807L && jMax2 == window.durationUs))) {
                z = true;
            }
            this.isDynamic = z;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int OplusGLSurfaceView_13, Timeline.Window window, boolean z, long OplusGLSurfaceView_15) {
            this.timeline.getWindow(0, window, z, 0L);
            window.positionInFirstPeriodUs += this.startUs;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            if (window.defaultPositionUs != -9223372036854775807L) {
                window.defaultPositionUs = Math.max(window.defaultPositionUs, this.startUs);
                window.defaultPositionUs = this.endUs == -9223372036854775807L ? window.defaultPositionUs : Math.min(window.defaultPositionUs, this.endUs);
                window.defaultPositionUs -= this.startUs;
            }
            long jUsToMs = C1547C.usToMs(this.startUs);
            if (window.presentationStartTimeMs != -9223372036854775807L) {
                window.presentationStartTimeMs += jUsToMs;
            }
            if (window.windowStartTimeMs != -9223372036854775807L) {
                window.windowStartTimeMs += jUsToMs;
            }
            return window;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int OplusGLSurfaceView_13, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(0, period, z);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long OplusGLSurfaceView_15 = this.durationUs;
            return period.set(period.f8981id, period.uid, 0, OplusGLSurfaceView_15 == -9223372036854775807L ? -9223372036854775807L : OplusGLSurfaceView_15 - positionInWindowUs, positionInWindowUs);
        }
    }
}
