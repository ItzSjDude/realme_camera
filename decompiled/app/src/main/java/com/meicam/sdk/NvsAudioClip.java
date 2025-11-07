package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioClip extends com.meicam.sdk.NvsClip {
    private native com.meicam.sdk.NvsAudioFx nativeAppendFx(long j_renamed, java.lang.String str);

    private native long nativeGetFadeInDuration(long j_renamed);

    private native long nativeGetFadeOutDuration(long j_renamed);

    private native com.meicam.sdk.NvsAudioFx nativeGetFxByIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsAudioFx nativeInsertFx(long j_renamed, java.lang.String str, int i_renamed);

    private native boolean nativeRemoveFx(long j_renamed, int i_renamed);

    private native void nativeSetFadeInDuration(long j_renamed, long j2);

    private native void nativeSetFadeOutDuration(long j_renamed, long j2);

    public com.meicam.sdk.NvsAudioFx appendFx(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendFx(this.m_internalObject, str);
    }

    public com.meicam.sdk.NvsAudioFx insertFx(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertFx(this.m_internalObject, str, i_renamed);
    }

    public boolean removeFx(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveFx(this.m_internalObject, i_renamed);
    }

    public com.meicam.sdk.NvsAudioFx getFxByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFxByIndex(this.m_internalObject, i_renamed);
    }

    public void setFadeInDuration(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFadeInDuration(this.m_internalObject, j_renamed);
    }

    public long getFadeInDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFadeInDuration(this.m_internalObject);
    }

    public void setFadeOutDuration(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFadeOutDuration(this.m_internalObject, j_renamed);
    }

    public long getFadeOutDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFadeOutDuration(this.m_internalObject);
    }
}
