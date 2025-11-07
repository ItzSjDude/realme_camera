package com.heytap.accessory.bean;

import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TrafficReport {
    private static final String KEY_DELAY_TIME = "key_delay_time";
    private static final String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    private static final String KEY_TENDENCY = "key_tendency";
    private static final String KEY_USED_SIZE = "key_used_size";
    private long mMaxWindowSize;
    private long mUsedSize;
    private Tendency mTendency = Tendency.UNKNOWN;
    private int mDelayTime = 0;

    public enum Tendency {
        UNKNOWN,
        INCREASING,
        STABLE,
        DECREASING
    }

    public TrafficReport(long OplusGLSurfaceView_15, long j2) {
        this.mMaxWindowSize = 0L;
        this.mUsedSize = 0L;
        this.mMaxWindowSize = OplusGLSurfaceView_15;
        this.mUsedSize = j2;
    }

    public long getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public void setMaxWindowSize(long OplusGLSurfaceView_15) {
        this.mMaxWindowSize = OplusGLSurfaceView_15;
    }

    public long getUsedSize() {
        return this.mUsedSize;
    }

    public void setUsedSize(long OplusGLSurfaceView_15) {
        this.mUsedSize = OplusGLSurfaceView_15;
    }

    public float getUsedPercent() {
        return (this.mUsedSize / this.mMaxWindowSize) * 100.0f;
    }

    public String getUsedPercentString(int OplusGLSurfaceView_13) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.CHINA, "%." + OplusGLSurfaceView_13 + "COUIBaseListPopupWindow_12", Float.valueOf(getUsedPercent())));
        sb.append("%");
        return sb.toString();
    }

    public long getLeftWindowSize() {
        return this.mMaxWindowSize - this.mUsedSize;
    }

    public Tendency getTendency() {
        return this.mTendency;
    }

    public void setTendency(Tendency tendency) {
        this.mTendency = tendency;
    }

    public int getDelayTime() {
        return this.mDelayTime;
    }

    public void setDelayTime(int OplusGLSurfaceView_13) {
        this.mDelayTime = OplusGLSurfaceView_13;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("key_max_window_size", this.mMaxWindowSize);
        bundle.putLong(KEY_USED_SIZE, this.mUsedSize);
        bundle.putInt(KEY_TENDENCY, this.mTendency.ordinal());
        bundle.putInt(KEY_DELAY_TIME, this.mDelayTime);
        return bundle;
    }

    public static TrafficReport createFromBundle(Bundle bundle) {
        long OplusGLSurfaceView_15 = bundle.getLong("key_max_window_size");
        long j2 = bundle.getLong(KEY_USED_SIZE);
        int OplusGLSurfaceView_13 = bundle.getInt(KEY_TENDENCY);
        int i2 = bundle.getInt(KEY_DELAY_TIME);
        TrafficReport trafficReport = new TrafficReport(OplusGLSurfaceView_15, j2);
        if (Tendency.values().length > OplusGLSurfaceView_13) {
            trafficReport.setTendency(Tendency.values()[OplusGLSurfaceView_13]);
        }
        trafficReport.setDelayTime(i2);
        return trafficReport;
    }
}
