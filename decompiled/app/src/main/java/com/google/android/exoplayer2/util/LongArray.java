package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public LongArray(int OplusGLSurfaceView_13) {
        this.values = new long[OplusGLSurfaceView_13];
    }

    public void add(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = this.size;
        long[] jArr = this.values;
        if (OplusGLSurfaceView_13 == jArr.length) {
            this.values = Arrays.copyOf(jArr, OplusGLSurfaceView_13 * 2);
        }
        long[] jArr2 = this.values;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = OplusGLSurfaceView_15;
    }

    public long get(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + OplusGLSurfaceView_13 + ", size is " + this.size);
        }
        return this.values[OplusGLSurfaceView_13];
    }

    public int size() {
        return this.size;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }
}
