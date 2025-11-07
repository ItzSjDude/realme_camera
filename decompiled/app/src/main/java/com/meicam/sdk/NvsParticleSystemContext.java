package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsParticleSystemContext {
    private long m_contextInterface;

    private native void nativeAppendPositionToEmitterPositionCurve(long OplusGLSurfaceView_15, String str, float COUIBaseListPopupWindow_12, float f2, float f3);

    private native void nativeCleanup(long OplusGLSurfaceView_15);

    private native void nativeSetEmitterEnabled(long OplusGLSurfaceView_15, String str, boolean z);

    private native void nativeSetEmitterParticleSizeGain(long OplusGLSurfaceView_15, String str, float COUIBaseListPopupWindow_12);

    private native void nativeSetEmitterPosition(long OplusGLSurfaceView_15, String str, float COUIBaseListPopupWindow_12, float f2);

    private native void nativeSetEmitterRateGain(long OplusGLSurfaceView_15, String str, float COUIBaseListPopupWindow_12);

    public void setEmitterEnabled(String str, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterEnabled(this.m_contextInterface, str, z);
    }

    public void setEmitterPosition(String str, float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterPosition(this.m_contextInterface, str, COUIBaseListPopupWindow_12, f2);
    }

    public void appendPositionToEmitterPositionCurve(String str, float COUIBaseListPopupWindow_12, float f2, float f3) {
        NvsUtils.checkFunctionInMainThread();
        nativeAppendPositionToEmitterPositionCurve(this.m_contextInterface, str, COUIBaseListPopupWindow_12, f2, f3);
    }

    public void setEmitterRateGain(String str, float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterRateGain(this.m_contextInterface, str, COUIBaseListPopupWindow_12);
    }

    public void setEmitterParticleSizeGain(String str, float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterParticleSizeGain(this.m_contextInterface, str, COUIBaseListPopupWindow_12);
    }

    protected void setContextInterface(long OplusGLSurfaceView_15) {
        this.m_contextInterface = OplusGLSurfaceView_15;
    }

    protected void finalize() throws Throwable {
        long OplusGLSurfaceView_15 = this.m_contextInterface;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_contextInterface = 0L;
        }
        super.finalize();
    }
}
