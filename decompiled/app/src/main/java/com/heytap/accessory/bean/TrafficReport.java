package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class TrafficReport {
    private static final java.lang.String KEY_DELAY_TIME = "key_delay_time";
    private static final java.lang.String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    private static final java.lang.String KEY_TENDENCY = "key_tendency";
    private static final java.lang.String KEY_USED_SIZE = "key_used_size";
    private long mMaxWindowSize;
    private long mUsedSize;
    private com.heytap.accessory.bean.TrafficReport.Tendency mTendency = com.heytap.accessory.bean.TrafficReport.Tendency.UNKNOWN;
    private int mDelayTime = 0;

    public enum Tendency {
        UNKNOWN,
        INCREASING,
        STABLE,
        DECREASING
    }

    public TrafficReport(long j_renamed, long j2) {
        this.mMaxWindowSize = 0L;
        this.mUsedSize = 0L;
        this.mMaxWindowSize = j_renamed;
        this.mUsedSize = j2;
    }

    public long getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public void setMaxWindowSize(long j_renamed) {
        this.mMaxWindowSize = j_renamed;
    }

    public long getUsedSize() {
        return this.mUsedSize;
    }

    public void setUsedSize(long j_renamed) {
        this.mUsedSize = j_renamed;
    }

    public float getUsedPercent() {
        return (this.mUsedSize / this.mMaxWindowSize) * 100.0f;
    }

    public java.lang.String getUsedPercentString(int i_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.String.format(java.util.Locale.CHINA, "%." + i_renamed + "f_renamed", java.lang.Float.valueOf(getUsedPercent())));
        sb.append("%");
        return sb.toString();
    }

    public long getLeftWindowSize() {
        return this.mMaxWindowSize - this.mUsedSize;
    }

    public com.heytap.accessory.bean.TrafficReport.Tendency getTendency() {
        return this.mTendency;
    }

    public void setTendency(com.heytap.accessory.bean.TrafficReport.Tendency tendency) {
        this.mTendency = tendency;
    }

    public int getDelayTime() {
        return this.mDelayTime;
    }

    public void setDelayTime(int i_renamed) {
        this.mDelayTime = i_renamed;
    }

    public android.os.Bundle getBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("key_max_window_size", this.mMaxWindowSize);
        bundle.putLong(KEY_USED_SIZE, this.mUsedSize);
        bundle.putInt(KEY_TENDENCY, this.mTendency.ordinal());
        bundle.putInt(KEY_DELAY_TIME, this.mDelayTime);
        return bundle;
    }

    public static com.heytap.accessory.bean.TrafficReport createFromBundle(android.os.Bundle bundle) {
        long j_renamed = bundle.getLong("key_max_window_size");
        long j2 = bundle.getLong(KEY_USED_SIZE);
        int i_renamed = bundle.getInt(KEY_TENDENCY);
        int i2 = bundle.getInt(KEY_DELAY_TIME);
        com.heytap.accessory.bean.TrafficReport trafficReport = new com.heytap.accessory.bean.TrafficReport(j_renamed, j2);
        if (com.heytap.accessory.bean.TrafficReport.Tendency.values().length > i_renamed) {
            trafficReport.setTendency(com.heytap.accessory.bean.TrafficReport.Tendency.values()[i_renamed]);
        }
        trafficReport.setDelayTime(i2);
        return trafficReport;
    }
}
