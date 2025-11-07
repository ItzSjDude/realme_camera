package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsFx extends com.meicam.sdk.NvsObject {
    private native com.meicam.sdk.NvsARFaceContext nativeGetARFaceContext(long j_renamed);

    private native com.meicam.sdk.NvsARSceneManipulate nativeGetARSceneManipulate(long j_renamed);

    private native boolean nativeGetBooleanVal(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsColor nativeGetColorVal(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsFxDescription nativeGetDescription(long j_renamed);

    private native float nativeGetFilterIntensity(long j_renamed);

    private native double nativeGetFloatVal(long j_renamed, java.lang.String str);

    private native int nativeGetIntVal(long j_renamed, java.lang.String str);

    private native java.lang.String nativeGetMenuVal(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsPaintingEffectContext nativeGetPaintingEffectContext(long j_renamed);

    private native com.meicam.sdk.NvsParticleSystemContext nativeGetParticleSystemContext(long j_renamed);

    private native com.meicam.sdk.NvsPosition2D nativeGetPosition2DVal(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsPosition3D nativeGetPosition3DVal(long j_renamed, java.lang.String str);

    private native java.lang.String nativeGetStringVal(long j_renamed, java.lang.String str);

    private native void nativeSetBooleanVal(long j_renamed, java.lang.String str, boolean z_renamed);

    private native void nativeSetColorVal(long j_renamed, java.lang.String str, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetFilterIntensity(long j_renamed, float f_renamed);

    private native void nativeSetFloatVal(long j_renamed, java.lang.String str, double d_renamed);

    private native void nativeSetIntVal(long j_renamed, java.lang.String str, int i_renamed);

    private native void nativeSetMenuVal(long j_renamed, java.lang.String str, java.lang.String str2);

    private native void nativeSetPosition2DVal(long j_renamed, java.lang.String str, com.meicam.sdk.NvsPosition2D nvsPosition2D);

    private native void nativeSetPosition3DVal(long j_renamed, java.lang.String str, com.meicam.sdk.NvsPosition3D nvsPosition3D);

    private native void nativeSetStringVal(long j_renamed, java.lang.String str, java.lang.String str2);

    public com.meicam.sdk.NvsFxDescription getDescription() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDescription(this.m_internalObject);
    }

    public void setIntVal(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetIntVal(getInternalObject(), str, i_renamed);
    }

    public int getIntVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIntVal(getInternalObject(), str);
    }

    public void setFloatVal(java.lang.String str, double d_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFloatVal(getInternalObject(), str, d_renamed);
    }

    public double getFloatVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFloatVal(getInternalObject(), str);
    }

    public void setBooleanVal(java.lang.String str, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetBooleanVal(getInternalObject(), str, z_renamed);
    }

    public boolean getBooleanVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBooleanVal(getInternalObject(), str);
    }

    public void setStringVal(java.lang.String str, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStringVal(getInternalObject(), str, str2);
    }

    public java.lang.String getStringVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetStringVal(getInternalObject(), str);
    }

    public void setColorVal(java.lang.String str, com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetColorVal(getInternalObject(), str, nvsColor);
    }

    public com.meicam.sdk.NvsColor getColorVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetColorVal(getInternalObject(), str);
    }

    public void setPosition2DVal(java.lang.String str, com.meicam.sdk.NvsPosition2D nvsPosition2D) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPosition2DVal(getInternalObject(), str, nvsPosition2D);
    }

    public com.meicam.sdk.NvsPosition2D getPosition2DVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPosition2DVal(getInternalObject(), str);
    }

    public void setPosition3DVal(java.lang.String str, com.meicam.sdk.NvsPosition3D nvsPosition3D) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPosition3DVal(getInternalObject(), str, nvsPosition3D);
    }

    public com.meicam.sdk.NvsPosition3D getPosition3DVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPosition3DVal(getInternalObject(), str);
    }

    public void setMenuVal(java.lang.String str, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetMenuVal(getInternalObject(), str, str2);
    }

    public java.lang.String getMenuVal(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetMenuVal(getInternalObject(), str);
    }

    public void setFilterIntensity(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFilterIntensity(getInternalObject(), f_renamed);
    }

    public float getFilterIntensity() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFilterIntensity(getInternalObject());
    }

    public com.meicam.sdk.NvsParticleSystemContext getParticleSystemContext() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetParticleSystemContext(this.m_internalObject);
    }

    public com.meicam.sdk.NvsARFaceContext getARFaceContext() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetARFaceContext(this.m_internalObject);
    }

    public com.meicam.sdk.NvsPaintingEffectContext getPaintingEffectContext() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPaintingEffectContext(this.m_internalObject);
    }

    public com.meicam.sdk.NvsARSceneManipulate getARSceneManipulate() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneManipulate(this.m_internalObject);
    }
}
