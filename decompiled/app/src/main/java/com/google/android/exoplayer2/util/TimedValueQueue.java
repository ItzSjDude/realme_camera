package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class TimedValueQueue<V> {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private V[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int OplusGLSurfaceView_13) {
        this.timestamps = new long[OplusGLSurfaceView_13];
        this.values = (V[]) newArray(OplusGLSurfaceView_13);
    }

    public synchronized void add(long OplusGLSurfaceView_15, V v) {
        clearBufferOnTimeDiscontinuity(OplusGLSurfaceView_15);
        doubleCapacityIfFull();
        addUnchecked(OplusGLSurfaceView_15, v);
    }

    public synchronized void clear() {
        this.first = 0;
        this.size = 0;
        Arrays.fill(this.values, (Object) null);
    }

    public synchronized int size() {
        return this.size;
    }

    public synchronized V pollFloor(long OplusGLSurfaceView_15) {
        return poll(OplusGLSurfaceView_15, true);
    }

    public synchronized V poll(long OplusGLSurfaceView_15) {
        return poll(OplusGLSurfaceView_15, false);
    }

    private V poll(long OplusGLSurfaceView_15, boolean z) {
        long j2 = Long.MAX_VALUE;
        V v = null;
        while (this.size > 0) {
            long j3 = OplusGLSurfaceView_15 - this.timestamps[this.first];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            V[] vArr = this.values;
            int OplusGLSurfaceView_13 = this.first;
            v = vArr[OplusGLSurfaceView_13];
            vArr[OplusGLSurfaceView_13] = null;
            this.first = (OplusGLSurfaceView_13 + 1) % vArr.length;
            this.size--;
            j2 = j3;
        }
        return v;
    }

    private void clearBufferOnTimeDiscontinuity(long OplusGLSurfaceView_15) {
        if (this.size > 0) {
            if (OplusGLSurfaceView_15 <= this.timestamps[((this.first + r0) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size < length) {
            return;
        }
        int OplusGLSurfaceView_13 = length * 2;
        long[] jArr = new long[OplusGLSurfaceView_13];
        V[] vArr = (V[]) newArray(OplusGLSurfaceView_13);
        int i2 = this.first;
        int i3 = length - i2;
        System.arraycopy(this.timestamps, i2, jArr, 0, i3);
        System.arraycopy(this.values, this.first, vArr, 0, i3);
        int i4 = this.first;
        if (i4 > 0) {
            System.arraycopy(this.timestamps, 0, jArr, i3, i4);
            System.arraycopy(this.values, 0, vArr, i3, this.first);
        }
        this.timestamps = jArr;
        this.values = vArr;
        this.first = 0;
    }

    private void addUnchecked(long OplusGLSurfaceView_15, V v) {
        int OplusGLSurfaceView_13 = this.first;
        int i2 = this.size;
        V[] vArr = this.values;
        int length = (OplusGLSurfaceView_13 + i2) % vArr.length;
        this.timestamps[length] = OplusGLSurfaceView_15;
        vArr[length] = v;
        this.size = i2 + 1;
    }

    private static <V> V[] newArray(int OplusGLSurfaceView_13) {
        return (V[]) new Object[OplusGLSurfaceView_13];
    }
}
