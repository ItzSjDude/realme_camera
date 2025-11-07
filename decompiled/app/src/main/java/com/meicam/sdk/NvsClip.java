package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsClip extends com.meicam.sdk.NvsObject {
    public static final int CLIP_TYPE_AUDIO = 1;
    public static final int CLIP_TYPE_VIDEO = 0;

    private native void nativeChangeSpeed(long j_renamed, double d_renamed, boolean z_renamed);

    private native long nativeChangeTrimInPoint(long j_renamed, long j2, boolean z_renamed);

    private native long nativeChangeTrimOutPoint(long j_renamed, long j2, boolean z_renamed);

    private native java.lang.String nativeGetFilePath(long j_renamed);

    private native int nativeGetFxCount(long j_renamed);

    private native long nativeGetInPoint(long j_renamed);

    private native int nativeGetIndex(long j_renamed);

    private native boolean nativeGetLoopAudio(long j_renamed);

    private native long nativeGetOutPoint(long j_renamed);

    private native double nativeGetSpeed(long j_renamed);

    private native long nativeGetTrimIn(long j_renamed);

    private native long nativeGetTrimOut(long j_renamed);

    private native int nativeGetType(long j_renamed);

    private native com.meicam.sdk.NvsVolume nativeGetVolumeGain(long j_renamed);

    private native void nativeSetLoopAudio(long j_renamed, boolean z_renamed);

    private native void nativeSetVolumeGain(long j_renamed, float f_renamed, float f2);

    public long getTrimIn() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTrimIn(this.m_internalObject);
    }

    public long getTrimOut() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTrimOut(this.m_internalObject);
    }

    public long getInPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public int getType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetType(this.m_internalObject);
    }

    public int getIndex() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public java.lang.String getFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFilePath(this.m_internalObject);
    }

    public int getFxCount() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFxCount(this.m_internalObject);
    }

    public long changeTrimInPoint(long j_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeTrimInPoint(this.m_internalObject, j_renamed, z_renamed);
    }

    public long changeTrimOutPoint(long j_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeTrimOutPoint(this.m_internalObject, j_renamed, z_renamed);
    }

    public double getSpeed() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetSpeed(this.m_internalObject);
    }

    public void changeSpeed(double d_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeChangeSpeed(this.m_internalObject, d_renamed, false);
    }

    public void changeSpeed(double d_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeChangeSpeed(this.m_internalObject, d_renamed, z_renamed);
    }

    public void setVolumeGain(float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, f_renamed, f2);
    }

    public com.meicam.sdk.NvsVolume getVolumeGain() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }

    public void setLoopAudio(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetLoopAudio(this.m_internalObject, z_renamed);
    }

    public boolean getLoopAudio() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetLoopAudio(this.m_internalObject);
    }
}
