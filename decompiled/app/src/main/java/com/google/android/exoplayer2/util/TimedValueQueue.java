package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class TimedValueQueue<V_renamed> {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private V_renamed[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int i_renamed) {
        this.timestamps = new long[i_renamed];
        this.values = (V_renamed[]) newArray(i_renamed);
    }

    public synchronized void add(long j_renamed, V_renamed v_renamed) {
        clearBufferOnTimeDiscontinuity(j_renamed);
        doubleCapacityIfFull();
        addUnchecked(j_renamed, v_renamed);
    }

    public synchronized void clear() {
        this.first = 0;
        this.size = 0;
        java.util.Arrays.fill(this.values, (java.lang.Object) null);
    }

    public synchronized int size() {
        return this.size;
    }

    public synchronized V_renamed pollFloor(long j_renamed) {
        return poll(j_renamed, true);
    }

    public synchronized V_renamed poll(long j_renamed) {
        return poll(j_renamed, false);
    }

    private V_renamed poll(long j_renamed, boolean z_renamed) {
        long j2 = Long.MAX_VALUE;
        V_renamed v_renamed = null;
        while (this.size > 0) {
            long j3 = j_renamed - this.timestamps[this.first];
            if (j3 < 0 && (z_renamed || (-j3) >= j2)) {
                break;
            }
            V_renamed[] vArr = this.values;
            int i_renamed = this.first;
            v_renamed = vArr[i_renamed];
            vArr[i_renamed] = null;
            this.first = (i_renamed + 1) % vArr.length;
            this.size--;
            j2 = j3;
        }
        return v_renamed;
    }

    private void clearBufferOnTimeDiscontinuity(long j_renamed) {
        if (this.size > 0) {
            if (j_renamed <= this.timestamps[((this.first + r0) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size < length) {
            return;
        }
        int i_renamed = length * 2;
        long[] jArr = new long[i_renamed];
        V_renamed[] vArr = (V_renamed[]) newArray(i_renamed);
        int i2 = this.first;
        int i3 = length - i2;
        java.lang.System.arraycopy(this.timestamps, i2, jArr, 0, i3);
        java.lang.System.arraycopy(this.values, this.first, vArr, 0, i3);
        int i4 = this.first;
        if (i4 > 0) {
            java.lang.System.arraycopy(this.timestamps, 0, jArr, i3, i4);
            java.lang.System.arraycopy(this.values, 0, vArr, i3, this.first);
        }
        this.timestamps = jArr;
        this.values = vArr;
        this.first = 0;
    }

    private void addUnchecked(long j_renamed, V_renamed v_renamed) {
        int i_renamed = this.first;
        int i2 = this.size;
        V_renamed[] vArr = this.values;
        int length = (i_renamed + i2) % vArr.length;
        this.timestamps[length] = j_renamed;
        vArr[length] = v_renamed;
        this.size = i2 + 1;
    }

    private static <V_renamed> V_renamed[] newArray(int i_renamed) {
        return (V_renamed[]) new java.lang.Object[i_renamed];
    }
}
