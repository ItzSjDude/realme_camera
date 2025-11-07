package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTrack extends com.meicam.sdk.NvsObject {
    public static final int TRACK_TYPE_AUDIO = 1;
    public static final int TRACK_TYPE_VIDEO = 0;

    private native long nativeChangeInPoint(long j_renamed, int i_renamed, long j2);

    private native long nativeChangeOutPoint(long j_renamed, int i_renamed, long j2);

    private native int nativeGetClipCount(long j_renamed);

    private native long nativeGetDuration(long j_renamed);

    private native int nativeGetIndex(long j_renamed);

    private native int nativeGetType(long j_renamed);

    private native com.meicam.sdk.NvsVolume nativeGetVolumeGain(long j_renamed);

    private native boolean nativeMoveClip(long j_renamed, int i_renamed, int i2);

    private native boolean nativeRemoveAllClips(long j_renamed);

    private native boolean nativeRemoveClip(long j_renamed, int i_renamed, boolean z_renamed);

    private native boolean nativeRemoveRange(long j_renamed, long j2, long j3, boolean z_renamed);

    private native void nativeSetVolumeGain(long j_renamed, float f_renamed, float f2);

    private native boolean nativeSplitClip(long j_renamed, int i_renamed, long j2);

    public int getType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetType(this.m_internalObject);
    }

    public int getIndex() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public long getDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDuration(this.m_internalObject);
    }

    public int getClipCount() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipCount(this.m_internalObject);
    }

    public long changeInPoint(int i_renamed, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, i_renamed, j_renamed);
    }

    public long changeOutPoint(int i_renamed, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, i_renamed, j_renamed);
    }

    public boolean splitClip(int i_renamed, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSplitClip(this.m_internalObject, i_renamed, j_renamed);
    }

    public boolean removeClip(int i_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveClip(this.m_internalObject, i_renamed, z_renamed);
    }

    public boolean removeRange(long j_renamed, long j2, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveRange(this.m_internalObject, j_renamed, j2, z_renamed);
    }

    public boolean moveClip(int i_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMoveClip(this.m_internalObject, i_renamed, i2);
    }

    public boolean removeAllClips() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAllClips(this.m_internalObject);
    }

    public void setVolumeGain(float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, f_renamed, f2);
    }

    public com.meicam.sdk.NvsVolume getVolumeGain() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }
}
