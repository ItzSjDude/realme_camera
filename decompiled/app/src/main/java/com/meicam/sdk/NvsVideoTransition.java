package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoTransition extends com.meicam.sdk.NvsFx {
    public static final int VIDEO_TRANSITION_TYPE_BUILTIN = 0;
    public static final int VIDEO_TRANSITION_TYPE_PACKAGE = 1;

    private native java.lang.String nativeGetBuiltinVideoTransitionName(long j_renamed);

    private native float nativeGetVideoTransitionDurationScaleFactor(long j_renamed);

    private native java.lang.String nativeGetVideoTransitionPackageId(long j_renamed);

    private native int nativeGetVideoTransitionType(long j_renamed);

    private native void nativeSetVideoTransitionDurationScaleFactor(long j_renamed, float f_renamed);

    public int getVideoTransitionType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionType(this.m_internalObject);
    }

    public java.lang.String getBuiltinVideoTransitionName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinVideoTransitionName(this.m_internalObject);
    }

    public java.lang.String getVideoTransitionPackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionPackageId(this.m_internalObject);
    }

    public void setVideoTransitionDurationScaleFactor(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetVideoTransitionDurationScaleFactor(this.m_internalObject, f_renamed);
    }

    public float getVideoTransitionDurationScaleFactor() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionDurationScaleFactor(this.m_internalObject);
    }
}
