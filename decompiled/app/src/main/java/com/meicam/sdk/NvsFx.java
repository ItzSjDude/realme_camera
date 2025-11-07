package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsFx extends NvsObject {
    private native NvsARFaceContext nativeGetARFaceContext(long OplusGLSurfaceView_15);

    private native NvsARSceneManipulate nativeGetARSceneManipulate(long OplusGLSurfaceView_15);

    private native boolean nativeGetBooleanVal(long OplusGLSurfaceView_15, String str);

    private native NvsColor nativeGetColorVal(long OplusGLSurfaceView_15, String str);

    private native NvsFxDescription nativeGetDescription(long OplusGLSurfaceView_15);

    private native float nativeGetFilterIntensity(long OplusGLSurfaceView_15);

    private native double nativeGetFloatVal(long OplusGLSurfaceView_15, String str);

    private native int nativeGetIntVal(long OplusGLSurfaceView_15, String str);

    private native String nativeGetMenuVal(long OplusGLSurfaceView_15, String str);

    private native NvsPaintingEffectContext nativeGetPaintingEffectContext(long OplusGLSurfaceView_15);

    private native NvsParticleSystemContext nativeGetParticleSystemContext(long OplusGLSurfaceView_15);

    private native NvsPosition2D nativeGetPosition2DVal(long OplusGLSurfaceView_15, String str);

    private native NvsPosition3D nativeGetPosition3DVal(long OplusGLSurfaceView_15, String str);

    private native String nativeGetStringVal(long OplusGLSurfaceView_15, String str);

    private native void nativeSetBooleanVal(long OplusGLSurfaceView_15, String str, boolean z);

    private native void nativeSetColorVal(long OplusGLSurfaceView_15, String str, NvsColor nvsColor);

    private native void nativeSetFilterIntensity(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetFloatVal(long OplusGLSurfaceView_15, String str, double IntrinsicsJvm.kt_5);

    private native void nativeSetIntVal(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native void nativeSetMenuVal(long OplusGLSurfaceView_15, String str, String str2);

    private native void nativeSetPosition2DVal(long OplusGLSurfaceView_15, String str, NvsPosition2D nvsPosition2D);

    private native void nativeSetPosition3DVal(long OplusGLSurfaceView_15, String str, NvsPosition3D nvsPosition3D);

    private native void nativeSetStringVal(long OplusGLSurfaceView_15, String str, String str2);

    public NvsFxDescription getDescription() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDescription(this.m_internalObject);
    }

    public void setIntVal(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetIntVal(getInternalObject(), str, OplusGLSurfaceView_13);
    }

    public int getIntVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIntVal(getInternalObject(), str);
    }

    public void setFloatVal(String str, double IntrinsicsJvm.kt_5) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFloatVal(getInternalObject(), str, IntrinsicsJvm.kt_5);
    }

    public double getFloatVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFloatVal(getInternalObject(), str);
    }

    public void setBooleanVal(String str, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetBooleanVal(getInternalObject(), str, z);
    }

    public boolean getBooleanVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBooleanVal(getInternalObject(), str);
    }

    public void setStringVal(String str, String str2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStringVal(getInternalObject(), str, str2);
    }

    public String getStringVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetStringVal(getInternalObject(), str);
    }

    public void setColorVal(String str, NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetColorVal(getInternalObject(), str, nvsColor);
    }

    public NvsColor getColorVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetColorVal(getInternalObject(), str);
    }

    public void setPosition2DVal(String str, NvsPosition2D nvsPosition2D) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPosition2DVal(getInternalObject(), str, nvsPosition2D);
    }

    public NvsPosition2D getPosition2DVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPosition2DVal(getInternalObject(), str);
    }

    public void setPosition3DVal(String str, NvsPosition3D nvsPosition3D) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPosition3DVal(getInternalObject(), str, nvsPosition3D);
    }

    public NvsPosition3D getPosition3DVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPosition3DVal(getInternalObject(), str);
    }

    public void setMenuVal(String str, String str2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetMenuVal(getInternalObject(), str, str2);
    }

    public String getMenuVal(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetMenuVal(getInternalObject(), str);
    }

    public void setFilterIntensity(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFilterIntensity(getInternalObject(), COUIBaseListPopupWindow_12);
    }

    public float getFilterIntensity() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFilterIntensity(getInternalObject());
    }

    public NvsParticleSystemContext getParticleSystemContext() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetParticleSystemContext(this.m_internalObject);
    }

    public NvsARFaceContext getARFaceContext() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetARFaceContext(this.m_internalObject);
    }

    public NvsPaintingEffectContext getPaintingEffectContext() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPaintingEffectContext(this.m_internalObject);
    }

    public NvsARSceneManipulate getARSceneManipulate() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneManipulate(this.m_internalObject);
    }
}
