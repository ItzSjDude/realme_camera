package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsParticleSystemContext {
    private long m_contextInterface;

    private native void nativeAppendPositionToEmitterPositionCurve(long j_renamed, java.lang.String str, float f_renamed, float f2, float f3);

    private native void nativeCleanup(long j_renamed);

    private native void nativeSetEmitterEnabled(long j_renamed, java.lang.String str, boolean z_renamed);

    private native void nativeSetEmitterParticleSizeGain(long j_renamed, java.lang.String str, float f_renamed);

    private native void nativeSetEmitterPosition(long j_renamed, java.lang.String str, float f_renamed, float f2);

    private native void nativeSetEmitterRateGain(long j_renamed, java.lang.String str, float f_renamed);

    public void setEmitterEnabled(java.lang.String str, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterEnabled(this.m_contextInterface, str, z_renamed);
    }

    public void setEmitterPosition(java.lang.String str, float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterPosition(this.m_contextInterface, str, f_renamed, f2);
    }

    public void appendPositionToEmitterPositionCurve(java.lang.String str, float f_renamed, float f2, float f3) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeAppendPositionToEmitterPositionCurve(this.m_contextInterface, str, f_renamed, f2, f3);
    }

    public void setEmitterRateGain(java.lang.String str, float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterRateGain(this.m_contextInterface, str, f_renamed);
    }

    public void setEmitterParticleSizeGain(java.lang.String str, float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetEmitterParticleSizeGain(this.m_contextInterface, str, f_renamed);
    }

    protected void setContextInterface(long j_renamed) {
        this.m_contextInterface = j_renamed;
    }

    protected void finalize() throws java.lang.Throwable {
        long j_renamed = this.m_contextInterface;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_contextInterface = 0L;
        }
        super.finalize();
    }
}
