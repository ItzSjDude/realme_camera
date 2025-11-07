package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoTransition extends NvsFx {
    public static final int VIDEO_TRANSITION_TYPE_BUILTIN = 0;
    public static final int VIDEO_TRANSITION_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinVideoTransitionName(long OplusGLSurfaceView_15);

    private native float nativeGetVideoTransitionDurationScaleFactor(long OplusGLSurfaceView_15);

    private native String nativeGetVideoTransitionPackageId(long OplusGLSurfaceView_15);

    private native int nativeGetVideoTransitionType(long OplusGLSurfaceView_15);

    private native void nativeSetVideoTransitionDurationScaleFactor(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    public int getVideoTransitionType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionType(this.m_internalObject);
    }

    public String getBuiltinVideoTransitionName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinVideoTransitionName(this.m_internalObject);
    }

    public String getVideoTransitionPackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionPackageId(this.m_internalObject);
    }

    public void setVideoTransitionDurationScaleFactor(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetVideoTransitionDurationScaleFactor(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getVideoTransitionDurationScaleFactor() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTransitionDurationScaleFactor(this.m_internalObject);
    }
}
