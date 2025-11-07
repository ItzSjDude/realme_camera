package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioTrack extends com.meicam.sdk.NvsTrack {
    private native com.meicam.sdk.NvsAudioClip nativeAddClip(long j_renamed, java.lang.String str, long j2);

    private native com.meicam.sdk.NvsAudioClip nativeAddClip(long j_renamed, java.lang.String str, long j2, long j3, long j4);

    private native com.meicam.sdk.NvsAudioClip nativeGetClipByIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsAudioClip nativeGetClipByTimelinePosition(long j_renamed, long j2);

    private native com.meicam.sdk.NvsAudioTransition nativeGetTransitionWithSourceClipIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsAudioClip nativeInsertClip(long j_renamed, java.lang.String str, int i_renamed);

    private native com.meicam.sdk.NvsAudioClip nativeInsertClip(long j_renamed, java.lang.String str, long j2, long j3, int i_renamed);

    private native com.meicam.sdk.NvsAudioTransition nativeSetBuiltinTransition(long j_renamed, int i_renamed, java.lang.String str);

    public com.meicam.sdk.NvsAudioClip appendClip(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertClip(str, getClipCount());
    }

    public com.meicam.sdk.NvsAudioClip appendClip(java.lang.String str, long j_renamed, long j2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertClip(str, j_renamed, j2, getClipCount());
    }

    public com.meicam.sdk.NvsAudioClip insertClip(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, i_renamed);
    }

    public com.meicam.sdk.NvsAudioClip insertClip(java.lang.String str, long j_renamed, long j2, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, j_renamed, j2, i_renamed);
    }

    public com.meicam.sdk.NvsAudioClip addClip(java.lang.String str, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, j_renamed);
    }

    public com.meicam.sdk.NvsAudioClip addClip(java.lang.String str, long j_renamed, long j2, long j3) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, j_renamed, j2, j3);
    }

    public com.meicam.sdk.NvsAudioClip getClipByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByIndex(this.m_internalObject, i_renamed);
    }

    public com.meicam.sdk.NvsAudioClip getClipByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsAudioTransition setBuiltinTransition(int i_renamed, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetBuiltinTransition(this.m_internalObject, i_renamed, str);
    }

    public com.meicam.sdk.NvsAudioTransition getTransitionWithSourceClipIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTransitionWithSourceClipIndex(this.m_internalObject, i_renamed);
    }
}
