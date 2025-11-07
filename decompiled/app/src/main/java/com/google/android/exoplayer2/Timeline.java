package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public abstract class Timeline {
    public static final com.google.android.exoplayer2.Timeline EMPTY = new com.google.android.exoplayer2.Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
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
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i_renamed) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    };

    public abstract int getIndexOfPeriod(java.lang.Object obj);

    public abstract com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed);

    public abstract int getPeriodCount();

    public abstract java.lang.Object getUidOfPeriod(int i_renamed);

    public abstract com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed);

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
        public java.lang.Object tag;
        public long windowStartTimeMs;

        public com.google.android.exoplayer2.Timeline.Window set(java.lang.Object obj, long j_renamed, long j2, boolean z_renamed, boolean z2, long j3, long j4, int i_renamed, int i2, long j5) {
            this.tag = obj;
            this.presentationStartTimeMs = j_renamed;
            this.windowStartTimeMs = j2;
            this.isSeekable = z_renamed;
            this.isDynamic = z2;
            this.defaultPositionUs = j3;
            this.durationUs = j4;
            this.firstPeriodIndex = i_renamed;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j5;
            return this;
        }

        public long getDefaultPositionMs() {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }
    }

    public static final class Period {
        private com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState;
        public long durationUs;
        public java.lang.Object id_renamed;
        private long positionInWindowUs;
        public java.lang.Object uid;
        public int windowIndex;

        public com.google.android.exoplayer2.Timeline.Period set(java.lang.Object obj, java.lang.Object obj2, int i_renamed, long j_renamed, long j2) {
            return set(obj, obj2, i_renamed, j_renamed, j2, com.google.android.exoplayer2.source.ads.AdPlaybackState.NONE);
        }

        public com.google.android.exoplayer2.Timeline.Period set(java.lang.Object obj, java.lang.Object obj2, int i_renamed, long j_renamed, long j2, com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            this.id_renamed = obj;
            this.uid = obj2;
            this.windowIndex = i_renamed;
            this.durationUs = j_renamed;
            this.positionInWindowUs = j2;
            this.adPlaybackState = adPlaybackState;
            return this;
        }

        public long getDurationMs() {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInWindowMs() {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public long getAdGroupTimeUs(int i_renamed) {
            return this.adPlaybackState.adGroupTimesUs[i_renamed];
        }

        public int getFirstAdIndexToPlay(int i_renamed) {
            return this.adPlaybackState.adGroups[i_renamed].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i_renamed, int i2) {
            return this.adPlaybackState.adGroups[i_renamed].getNextAdIndexToPlay(i2);
        }

        public boolean hasPlayedAdGroup(int i_renamed) {
            return !this.adPlaybackState.adGroups[i_renamed].hasUnplayedAds();
        }

        public int getAdGroupIndexForPositionUs(long j_renamed) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j_renamed);
        }

        public int getAdGroupIndexAfterPositionUs(long j_renamed) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j_renamed);
        }

        public int getAdCountInAdGroup(int i_renamed) {
            return this.adPlaybackState.adGroups[i_renamed].count;
        }

        public boolean isAdAvailable(int i_renamed, int i2) {
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i_renamed];
            return (adGroup.count == -1 || adGroup.states[i2] == 0) ? false : true;
        }

        public long getAdDurationUs(int i_renamed, int i2) {
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i_renamed];
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

    public int getNextWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        if (i2 == 0) {
            if (i_renamed == getLastWindowIndex(z_renamed)) {
                return -1;
            }
            return i_renamed + 1;
        }
        if (i2 == 1) {
            return i_renamed;
        }
        if (i2 == 2) {
            return i_renamed == getLastWindowIndex(z_renamed) ? getFirstWindowIndex(z_renamed) : i_renamed + 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public int getPreviousWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        if (i2 == 0) {
            if (i_renamed == getFirstWindowIndex(z_renamed)) {
                return -1;
            }
            return i_renamed - 1;
        }
        if (i2 == 1) {
            return i_renamed;
        }
        if (i2 == 2) {
            return i_renamed == getFirstWindowIndex(z_renamed) ? getLastWindowIndex(z_renamed) : i_renamed - 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public int getLastWindowIndex(boolean z_renamed) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public int getFirstWindowIndex(boolean z_renamed) {
        return isEmpty() ? -1 : 0;
    }

    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window) {
        return getWindow(i_renamed, window, false);
    }

    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed) {
        return getWindow(i_renamed, window, z_renamed, 0L);
    }

    public final int getNextPeriodIndex(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, com.google.android.exoplayer2.Timeline.Window window, int i2, boolean z_renamed) {
        int i3 = getPeriod(i_renamed, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex != i_renamed) {
            return i_renamed + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i3, i2, z_renamed);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public final boolean isLastPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, com.google.android.exoplayer2.Timeline.Window window, int i2, boolean z_renamed) {
        return getNextPeriodIndex(i_renamed, period, window, i2, z_renamed) == -1;
    }

    public final android.util.Pair<java.lang.Object, java.lang.Long> getPeriodPosition(com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period, int i_renamed, long j_renamed) {
        return getPeriodPosition(window, period, i_renamed, j_renamed, 0L);
    }

    public final android.util.Pair<java.lang.Object, java.lang.Long> getPeriodPosition(com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period, int i_renamed, long j_renamed, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, getWindowCount());
        getWindow(i_renamed, window, false, j2);
        if (j_renamed == -9223372036854775807L) {
            j_renamed = window.getDefaultPositionUs();
            if (j_renamed == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j_renamed;
        long durationUs = getPeriod(i2, period, true).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i2++;
            durationUs = getPeriod(i2, period, true).getDurationUs();
        }
        return android.util.Pair.create(period.uid, java.lang.Long.valueOf(positionInFirstPeriodUs));
    }

    public com.google.android.exoplayer2.Timeline.Period getPeriodByUid(java.lang.Object obj, com.google.android.exoplayer2.Timeline.Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public final com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period) {
        return getPeriod(i_renamed, period, false);
    }
}
