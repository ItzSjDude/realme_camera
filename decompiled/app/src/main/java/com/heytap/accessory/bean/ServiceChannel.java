package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class ServiceChannel {
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int RELIABILITY_DISABLE = 4;
    public static final int RELIABILITY_ENABLE = 5;
    private int mChannelId;
    private int mClassType;
    private int mPriority;
    private int mReliability;

    public ServiceChannel(int i_renamed, int i2, int i3, int i4) {
        this.mChannelId = i_renamed;
        this.mPriority = i2;
        this.mReliability = i3;
        this.mClassType = i4;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getReliability() {
        return this.mReliability;
    }

    public int getClassType() {
        return this.mClassType;
    }

    public java.lang.String toString() {
        return "ServiceChannel{mChannelId=" + this.mChannelId + ", mPriority=" + this.mPriority + ", mReliability=" + this.mReliability + ", mClassType=" + this.mClassType + '}';
    }
}
