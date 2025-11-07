package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoTrack extends com.meicam.sdk.NvsTrack {
    private native com.meicam.sdk.NvsVideoClip nativeAddClip(long j_renamed, java.lang.String str, long j2);

    private native com.meicam.sdk.NvsVideoClip nativeAddClip(long j_renamed, java.lang.String str, long j2, long j3, long j4);

    private native com.meicam.sdk.NvsVideoClip nativeGetClipByIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsVideoClip nativeGetClipByTimelinePosition(long j_renamed, long j2);

    private native com.meicam.sdk.NvsVideoTransition nativeGetTransitionBySourceClipIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsVideoClip nativeInsertClip(long j_renamed, java.lang.String str, int i_renamed);

    private native com.meicam.sdk.NvsVideoClip nativeInsertClip(long j_renamed, java.lang.String str, long j2, long j3, int i_renamed);

    private native com.meicam.sdk.NvsVideoTransition nativeSetBuiltinTransition(long j_renamed, int i_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsVideoTransition nativeSetPackagedTransition(long j_renamed, int i_renamed, java.lang.String str);

    public com.meicam.sdk.NvsVideoClip appendClip(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertClip(str, getClipCount());
    }

    public com.meicam.sdk.NvsVideoClip appendClip(java.lang.String str, long j_renamed, long j2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertClip(str, j_renamed, j2, getClipCount());
    }

    public com.meicam.sdk.NvsVideoClip insertClip(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, i_renamed);
    }

    public com.meicam.sdk.NvsVideoClip insertClip(java.lang.String str, long j_renamed, long j2, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, j_renamed, j2, i_renamed);
    }

    public com.meicam.sdk.NvsVideoClip addClip(java.lang.String str, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, j_renamed);
    }

    public com.meicam.sdk.NvsVideoClip addClip(java.lang.String str, long j_renamed, long j2, long j3) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, j_renamed, j2, j3);
    }

    public com.meicam.sdk.NvsVideoClip getClipByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByIndex(this.m_internalObject, i_renamed);
    }

    public com.meicam.sdk.NvsVideoClip getClipByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsVideoTransition setBuiltinTransition(int i_renamed, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetBuiltinTransition(this.m_internalObject, i_renamed, str);
    }

    public com.meicam.sdk.NvsVideoTransition setPackagedTransition(int i_renamed, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetPackagedTransition(this.m_internalObject, i_renamed, str);
    }

    public com.meicam.sdk.NvsVideoTransition getTransitionBySourceClipIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTransitionBySourceClipIndex(this.m_internalObject, i_renamed);
    }
}
