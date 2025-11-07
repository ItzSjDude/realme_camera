package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidInterruptionChecker {
    private static final java.lang.String TAG = "Meicam";
    private boolean m_interruptionFlag = false;

    public boolean isInterrupted() {
        return this.m_interruptionFlag;
    }

    public void setInterruptionFlag(boolean z_renamed) {
        this.m_interruptionFlag = z_renamed;
    }
}
