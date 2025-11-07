package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Window getWindow(int OplusGLSurfaceView_13, Window window, boolean z, long OplusGLSurfaceView_15) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int OplusGLSurfaceView_13, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int getIndexOfPeriod(Object obj);

    public abstract Period getPeriod(int OplusGLSurfaceView_13, Period period, boolean z);

    public abstract int getPeriodCount();

    public abstract Object getUidOfPeriod(int OplusGLSurfaceView_13);

    public abstract Window getWindow(int OplusGLSurfaceView_13, Window window, boolean z, long OplusGLSurfaceView_15);

    public abstract int getWindowCount();

    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public long windowStartTimeMs;

        public Window set(Object obj, long OplusGLSurfaceView_15, long j2, boolean z, boolean z2, long j3, long j4, int OplusGLSurfaceView_13, int i2, long j5) {
            this.tag = obj;
            this.presentationStartTimeMs = OplusGLSurfaceView_15;
            this.windowStartTimeMs = j2;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.defaultPositionUs = j3;
            this.durationUs = j4;
            this.firstPeriodIndex = OplusGLSurfaceView_13;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j5;
            return this;
        }

        public long getDefaultPositionMs() {
            return C1547C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C1547C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C1547C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }
    }

    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;

        /* renamed from: id_renamed */
        public Object f8981id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public Period set(Object obj, Object obj2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            return set(obj, obj2, OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2, AdPlaybackState.NONE);
        }

        public Period set(Object obj, Object obj2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, AdPlaybackState adPlaybackState) {
            this.f8981id = obj;
            this.uid = obj2;
            this.windowIndex = OplusGLSurfaceView_13;
            this.durationUs = OplusGLSurfaceView_15;
            this.positionInWindowUs = j2;
            this.adPlaybackState = adPlaybackState;
            return this;
        }

        public long getDurationMs() {
            return C1547C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInWindowMs() {
            return C1547C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public long getAdGroupTimeUs(int OplusGLSurfaceView_13) {
            return this.adPlaybackState.adGroupTimesUs[OplusGLSurfaceView_13];
        }

        public int getFirstAdIndexToPlay(int OplusGLSurfaceView_13) {
            return this.adPlaybackState.adGroups[OplusGLSurfaceView_13].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int OplusGLSurfaceView_13, int i2) {
            return this.adPlaybackState.adGroups[OplusGLSurfaceView_13].getNextAdIndexToPlay(i2);
        }

        public boolean hasPlayedAdGroup(int OplusGLSurfaceView_13) {
            return !this.adPlaybackState.adGroups[OplusGLSurfaceView_13].hasUnplayedAds();
        }

        public int getAdGroupIndexForPositionUs(long OplusGLSurfaceView_15) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(OplusGLSurfaceView_15);
        }

        public int getAdGroupIndexAfterPositionUs(long OplusGLSurfaceView_15) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(OplusGLSurfaceView_15);
        }

        public int getAdCountInAdGroup(int OplusGLSurfaceView_13) {
            return this.adPlaybackState.adGroups[OplusGLSurfaceView_13].count;
        }

        public boolean isAdAvailable(int OplusGLSurfaceView_13, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[OplusGLSurfaceView_13];
            return (adGroup.count == -1 || adGroup.states[i2] == 0) ? false : true;
        }

        public long getAdDurationUs(int OplusGLSurfaceView_13, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[OplusGLSurfaceView_13];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i2];
            }
            return -9223372036854775807L;
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public int getNextWindowIndex(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (i2 == 0) {
            if (OplusGLSurfaceView_13 == getLastWindowIndex(z)) {
                return -1;
            }
            return OplusGLSurfaceView_13 + 1;
        }
        if (i2 == 1) {
            return OplusGLSurfaceView_13;
        }
        if (i2 == 2) {
            return OplusGLSurfaceView_13 == getLastWindowIndex(z) ? getFirstWindowIndex(z) : OplusGLSurfaceView_13 + 1;
        }
        throw new IllegalStateException();
    }

    public int getPreviousWindowIndex(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (i2 == 0) {
            if (OplusGLSurfaceView_13 == getFirstWindowIndex(z)) {
                return -1;
            }
            return OplusGLSurfaceView_13 - 1;
        }
        if (i2 == 1) {
            return OplusGLSurfaceView_13;
        }
        if (i2 == 2) {
            return OplusGLSurfaceView_13 == getFirstWindowIndex(z) ? getLastWindowIndex(z) : OplusGLSurfaceView_13 - 1;
        }
        throw new IllegalStateException();
    }

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public int getFirstWindowIndex(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public final Window getWindow(int OplusGLSurfaceView_13, Window window) {
        return getWindow(OplusGLSurfaceView_13, window, false);
    }

    public final Window getWindow(int OplusGLSurfaceView_13, Window window, boolean z) {
        return getWindow(OplusGLSurfaceView_13, window, z, 0L);
    }

    public final int getNextPeriodIndex(int OplusGLSurfaceView_13, Period period, Window window, int i2, boolean z) {
        int i3 = getPeriod(OplusGLSurfaceView_13, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex != OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i3, i2, z);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public final boolean isLastPeriod(int OplusGLSurfaceView_13, Period period, Window window, int i2, boolean z) {
        return getNextPeriodIndex(OplusGLSurfaceView_13, period, window, i2, z) == -1;
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return getPeriodPosition(window, period, OplusGLSurfaceView_13, OplusGLSurfaceView_15, 0L);
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
        Assertions.checkIndex(OplusGLSurfaceView_13, 0, getWindowCount());
        getWindow(OplusGLSurfaceView_13, window, false, j2);
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            OplusGLSurfaceView_15 = window.getDefaultPositionUs();
            if (OplusGLSurfaceView_15 == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + OplusGLSurfaceView_15;
        long durationUs = getPeriod(i2, period, true).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i2++;
            durationUs = getPeriod(i2, period, true).getDurationUs();
        }
        return Pair.create(period.uid, Long.valueOf(positionInFirstPeriodUs));
    }

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public final Period getPeriod(int OplusGLSurfaceView_13, Period period) {
        return getPeriod(OplusGLSurfaceView_13, period, false);
    }
}
