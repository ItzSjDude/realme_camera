package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class TrafficControlConfig {
    public static final java.lang.String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    public static final java.lang.String KEY_SHOW_LOG = "key_show_log";
    public static final java.lang.String KEY_TC_DELAY_TIME = "key_tc_delay_time";
    public static final java.lang.String KEY_TC_STRATEGY = "key_tc_strategy";
    public static final java.lang.String KEY_TC_SWITCH = "key_tc_switch";
    private boolean mEnable;
    private int mHandleMsgTime;
    private int mMaxWindowSize;
    private boolean mShowLog;
    private int mStrategy;

    public int getHandleMsgTime() {
        return this.mHandleMsgTime;
    }

    public void setHandleMsgTime(int i_renamed) {
        this.mHandleMsgTime = i_renamed;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean z_renamed) {
        this.mEnable = z_renamed;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setStrategy(int i_renamed) {
        this.mStrategy = i_renamed;
    }

    public int getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public void setMaxWindowSize(int i_renamed) {
        this.mMaxWindowSize = i_renamed;
    }

    public boolean isShowLog() {
        return this.mShowLog;
    }

    public void setShowLog(boolean z_renamed) {
        this.mShowLog = z_renamed;
    }

    public android.os.Bundle getBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(KEY_TC_DELAY_TIME, this.mHandleMsgTime);
        bundle.putBoolean(KEY_TC_SWITCH, this.mEnable);
        bundle.putInt(KEY_TC_STRATEGY, this.mStrategy);
        bundle.putInt(KEY_MAX_WINDOW_SIZE, this.mMaxWindowSize);
        bundle.putBoolean(KEY_SHOW_LOG, this.mShowLog);
        return bundle;
    }

    public static com.heytap.accessory.bean.TrafficControlConfig createFromBundle(android.os.Bundle bundle) {
        int i_renamed = bundle.getInt(KEY_TC_DELAY_TIME);
        boolean z_renamed = bundle.getBoolean(KEY_TC_SWITCH);
        int i2 = bundle.getInt(KEY_TC_STRATEGY);
        int i3 = bundle.getInt(KEY_MAX_WINDOW_SIZE);
        boolean z2 = bundle.getBoolean(KEY_SHOW_LOG);
        com.heytap.accessory.bean.TrafficControlConfig trafficControlConfig = new com.heytap.accessory.bean.TrafficControlConfig();
        trafficControlConfig.setHandleMsgTime(i_renamed);
        trafficControlConfig.setEnable(z_renamed);
        trafficControlConfig.setStrategy(i2);
        trafficControlConfig.setMaxWindowSize(i3);
        trafficControlConfig.setShowLog(z2);
        return trafficControlConfig;
    }

    public java.lang.String toString() {
        return "TrafficControlConfig{mHandleMsgTime=" + this.mHandleMsgTime + ", mEnable=" + this.mEnable + ", mStrategy=" + this.mStrategy + ", mMaxWindowSize=" + this.mMaxWindowSize + ", mShowLog=" + this.mShowLog + '}';
    }
}
