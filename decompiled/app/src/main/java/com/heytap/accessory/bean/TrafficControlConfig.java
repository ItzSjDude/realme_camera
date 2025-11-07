package com.heytap.accessory.bean;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class TrafficControlConfig {
    public static final String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    public static final String KEY_SHOW_LOG = "key_show_log";
    public static final String KEY_TC_DELAY_TIME = "key_tc_delay_time";
    public static final String KEY_TC_STRATEGY = "key_tc_strategy";
    public static final String KEY_TC_SWITCH = "key_tc_switch";
    private boolean mEnable;
    private int mHandleMsgTime;
    private int mMaxWindowSize;
    private boolean mShowLog;
    private int mStrategy;

    public int getHandleMsgTime() {
        return this.mHandleMsgTime;
    }

    public void setHandleMsgTime(int OplusGLSurfaceView_13) {
        this.mHandleMsgTime = OplusGLSurfaceView_13;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setStrategy(int OplusGLSurfaceView_13) {
        this.mStrategy = OplusGLSurfaceView_13;
    }

    public int getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public void setMaxWindowSize(int OplusGLSurfaceView_13) {
        this.mMaxWindowSize = OplusGLSurfaceView_13;
    }

    public boolean isShowLog() {
        return this.mShowLog;
    }

    public void setShowLog(boolean z) {
        this.mShowLog = z;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TC_DELAY_TIME, this.mHandleMsgTime);
        bundle.putBoolean(KEY_TC_SWITCH, this.mEnable);
        bundle.putInt(KEY_TC_STRATEGY, this.mStrategy);
        bundle.putInt(KEY_MAX_WINDOW_SIZE, this.mMaxWindowSize);
        bundle.putBoolean(KEY_SHOW_LOG, this.mShowLog);
        return bundle;
    }

    public static TrafficControlConfig createFromBundle(Bundle bundle) {
        int OplusGLSurfaceView_13 = bundle.getInt(KEY_TC_DELAY_TIME);
        boolean z = bundle.getBoolean(KEY_TC_SWITCH);
        int i2 = bundle.getInt(KEY_TC_STRATEGY);
        int i3 = bundle.getInt(KEY_MAX_WINDOW_SIZE);
        boolean z2 = bundle.getBoolean(KEY_SHOW_LOG);
        TrafficControlConfig trafficControlConfig = new TrafficControlConfig();
        trafficControlConfig.setHandleMsgTime(OplusGLSurfaceView_13);
        trafficControlConfig.setEnable(z);
        trafficControlConfig.setStrategy(i2);
        trafficControlConfig.setMaxWindowSize(i3);
        trafficControlConfig.setShowLog(z2);
        return trafficControlConfig;
    }

    public String toString() {
        return "TrafficControlConfig{mHandleMsgTime=" + this.mHandleMsgTime + ", mEnable=" + this.mEnable + ", mStrategy=" + this.mStrategy + ", mMaxWindowSize=" + this.mMaxWindowSize + ", mShowLog=" + this.mShowLog + '}';
    }
}
