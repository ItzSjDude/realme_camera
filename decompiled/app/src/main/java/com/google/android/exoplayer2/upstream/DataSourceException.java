package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DataSourceException extends java.io.IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public DataSourceException(int i_renamed) {
        this.reason = i_renamed;
    }
}
