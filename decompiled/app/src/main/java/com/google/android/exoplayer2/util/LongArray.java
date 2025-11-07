package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public LongArray(int i_renamed) {
        this.values = new long[i_renamed];
    }

    public void add(long j_renamed) {
        int i_renamed = this.size;
        long[] jArr = this.values;
        if (i_renamed == jArr.length) {
            this.values = java.util.Arrays.copyOf(jArr, i_renamed * 2);
        }
        long[] jArr2 = this.values;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j_renamed;
    }

    public long get(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.size) {
            throw new java.lang.IndexOutOfBoundsException("Invalid index " + i_renamed + ", size is_renamed " + this.size);
        }
        return this.values[i_renamed];
    }

    public int size() {
        return this.size;
    }

    public long[] toArray() {
        return java.util.Arrays.copyOf(this.values, this.size);
    }
}
