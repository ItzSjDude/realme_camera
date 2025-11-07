package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
abstract class AbstractConcatenatedTimeline extends com.google.android.exoplayer2.Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder;

    protected abstract int getChildIndexByChildUid(java.lang.Object obj);

    protected abstract int getChildIndexByPeriodIndex(int i_renamed);

    protected abstract int getChildIndexByWindowIndex(int i_renamed);

    protected abstract java.lang.Object getChildUidByChildIndex(int i_renamed);

    protected abstract int getFirstPeriodIndexByChildIndex(int i_renamed);

    protected abstract int getFirstWindowIndexByChildIndex(int i_renamed);

    protected abstract com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i_renamed);

    public static java.lang.Object getChildTimelineUidFromConcatenatedUid(java.lang.Object obj) {
        return ((android.util.Pair) obj).first;
    }

    public static java.lang.Object getChildPeriodUidFromConcatenatedUid(java.lang.Object obj) {
        return ((android.util.Pair) obj).second;
    }

    public static java.lang.Object getConcatenatedUid(java.lang.Object obj, java.lang.Object obj2) {
        return android.util.Pair.create(obj, obj2);
    }

    public AbstractConcatenatedTimeline(boolean z_renamed, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.isAtomic = z_renamed;
        this.shuffleOrder = shuffleOrder;
        this.childCount = shuffleOrder.getLength();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        if (this.isAtomic) {
            if (i2 == 1) {
                i2 = 2;
            }
            z_renamed = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i_renamed);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int nextWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getNextWindowIndex(i_renamed - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z_renamed);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z_renamed);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z_renamed);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z_renamed);
        }
        if (i2 == 2) {
            return getFirstWindowIndex(z_renamed);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        if (this.isAtomic) {
            if (i2 == 1) {
                i2 = 2;
            }
            z_renamed = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i_renamed);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int previousWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getPreviousWindowIndex(i_renamed - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z_renamed);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z_renamed);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z_renamed);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z_renamed);
        }
        if (i2 == 2) {
            return getLastWindowIndex(z_renamed);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z_renamed) {
        if (this.childCount == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z_renamed = false;
        }
        int lastIndex = z_renamed ? this.shuffleOrder.getLastIndex() : this.childCount - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = getPreviousChildIndex(lastIndex, z_renamed);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).getLastWindowIndex(z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z_renamed) {
        if (this.childCount == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z_renamed = false;
        }
        int firstIndex = z_renamed ? this.shuffleOrder.getFirstIndex() : 0;
        while (getTimelineByChildIndex(firstIndex).isEmpty()) {
            firstIndex = getNextChildIndex(firstIndex, z_renamed);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(firstIndex) + getTimelineByChildIndex(firstIndex).getFirstWindowIndex(z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i_renamed);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i_renamed - firstWindowIndexByChildIndex, window, z_renamed, j_renamed);
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Period getPeriodByUid(java.lang.Object obj, com.google.android.exoplayer2.Timeline.Period period) {
        java.lang.Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        java.lang.Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i_renamed);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i_renamed - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z_renamed);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z_renamed) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(java.lang.Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof android.util.Pair)) {
            return -1;
        }
        java.lang.Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        java.lang.Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final java.lang.Object getUidOfPeriod(int i_renamed) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i_renamed);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i_renamed - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    private int getNextChildIndex(int i_renamed, boolean z_renamed) {
        if (z_renamed) {
            return this.shuffleOrder.getNextIndex(i_renamed);
        }
        if (i_renamed < this.childCount - 1) {
            return i_renamed + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i_renamed, boolean z_renamed) {
        if (z_renamed) {
            return this.shuffleOrder.getPreviousIndex(i_renamed);
        }
        if (i_renamed > 0) {
            return i_renamed - 1;
        }
        return -1;
    }
}
