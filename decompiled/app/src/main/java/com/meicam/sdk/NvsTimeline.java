package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimeline extends com.meicam.sdk.NvsObject {
    public static final int NvsTimelineWatermarkPosition_BottomLeft = 2;
    public static final int NvsTimelineWatermarkPosition_BottomRight = 3;
    public static final int NvsTimelineWatermarkPosition_TopLeft = 1;
    public static final int NvsTimelineWatermarkPosition_TopRight = 0;

    public static class PlaybackRateControlRegion {
        public float audioGain = 1.0f;
        public long endTime;
        public float playbackRate;
        public long startTime;
    }

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeAddAnimatedSticker(long j_renamed, long j2, long j3, java.lang.String str, boolean z_renamed, boolean z2, java.lang.String str2);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeAddBuiltinTimelineVideoFx(long j_renamed, long j2, long j3, java.lang.String str);

    private native com.meicam.sdk.NvsTimelineCaption nativeAddCaption(long j_renamed, java.lang.String str, long j2, long j3, java.lang.String str2, boolean z_renamed);

    private native com.meicam.sdk.NvsTimelineCompoundCaption nativeAddCompoundCaption(long j_renamed, long j2, long j3, java.lang.String str);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeAddCustomTimelineVideoFx(long j_renamed, long j2, long j3, com.meicam.sdk.NvsCustomVideoFx.Renderer renderer);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeAddPackagedTimelineVideoFx(long j_renamed, long j2, long j3, java.lang.String str);

    private native boolean nativeAddWatermark(long j_renamed, java.lang.String str, int i_renamed, int i2, float f_renamed, int i3, int i4, int i5);

    private native com.meicam.sdk.NvsAudioTrack nativeAppendAudioTrack(long j_renamed);

    private native com.meicam.sdk.NvsVideoTrack nativeAppendVideoTrack(long j_renamed);

    private native boolean nativeApplyTheme(long j_renamed, java.lang.String str);

    private native int nativeAudioTrackCount(long j_renamed);

    private native void nativeCaptureCaptionParameters(long j_renamed, com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption);

    private native void nativeCaptureCompoundCaptionParameters(long j_renamed, com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native boolean nativeChangeVideoSize(long j_renamed, int i_renamed, int i2);

    private native void nativeDeleteWatermark(long j_renamed);

    private native java.util.List<com.meicam.sdk.NvsTimelineAnimatedSticker> nativeGetAnimatedStickersByTimelinePosition(long j_renamed, long j2);

    private native long nativeGetAudioFadeOutDuration(long j_renamed);

    private native com.meicam.sdk.NvsAudioResolution nativeGetAudioRes(long j_renamed);

    private native com.meicam.sdk.NvsAudioTrack nativeGetAudioTrackByIndex(long j_renamed, int i_renamed);

    private native java.util.List<com.meicam.sdk.NvsTimelineCaption> nativeGetCaptionsByTimelinePosition(long j_renamed, long j2);

    private native java.util.List<com.meicam.sdk.NvsTimelineCompoundCaption> nativeGetCompoundCaptionsByTimelinePosition(long j_renamed, long j2);

    private native java.lang.String nativeGetCurrentThemeId(long j_renamed);

    private native long nativeGetDuration(long j_renamed);

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeGetFirstAnimatedSticker(long j_renamed);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeGetFirstTimelineVideoFx(long j_renamed);

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeGetLastAnimatedSticker(long j_renamed);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeGetLastTimelineVideoFx(long j_renamed);

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeGetNextAnimatedSticker(long j_renamed, com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native com.meicam.sdk.NvsTimelineCaption nativeGetNextCaption(long j_renamed, com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption);

    private native com.meicam.sdk.NvsTimelineCompoundCaption nativeGetNextCompoundCaption(long j_renamed, com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeGetNextTimelineVideoFx(long j_renamed, com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx);

    private native com.meicam.sdk.NvsTimeline.PlaybackRateControlRegion[] nativeGetPlaybackRateControl(long j_renamed);

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeGetPrevAnimatedSticker(long j_renamed, com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native com.meicam.sdk.NvsTimelineCaption nativeGetPrevCaption(long j_renamed, com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption);

    private native com.meicam.sdk.NvsTimelineCompoundCaption nativeGetPrevCompoundCaption(long j_renamed, com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeGetPrevTimelineVideoFx(long j_renamed, com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx);

    private native com.meicam.sdk.NvsVolume nativeGetThemeMusicVolumeGain(long j_renamed);

    private native java.util.List<com.meicam.sdk.NvsTimelineVideoFx> nativeGetTimelineVideoFxByTimelinePosition(long j_renamed, long j2);

    private native com.meicam.sdk.NvsRational nativeGetVideoFps(long j_renamed);

    private native com.meicam.sdk.NvsVideoResolution nativeGetVideoRes(long j_renamed);

    private native com.meicam.sdk.NvsVideoTrack nativeGetVideoTrackByIndex(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsTimelineAnimatedSticker nativeRemoveAnimatedSticker(long j_renamed, com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native boolean nativeRemoveAudioTrack(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsTimelineCaption nativeRemoveCaption(long j_renamed, com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption);

    private native com.meicam.sdk.NvsTimelineCompoundCaption nativeRemoveCompoundCaption(long j_renamed, com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native void nativeRemoveCurrentTheme(long j_renamed);

    private native void nativeRemoveTimelineEndingLogo(long j_renamed);

    private native com.meicam.sdk.NvsTimelineVideoFx nativeRemoveTimelineVideoFx(long j_renamed, com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx);

    private native boolean nativeRemoveVideoTrack(long j_renamed, int i_renamed);

    private native void nativeSetAudioFadeOutDuration(long j_renamed, long j2);

    private native void nativeSetCaptionBoundingRectMode(long j_renamed, boolean z_renamed);

    private native void nativeSetPlaybackRateControl(long j_renamed, com.meicam.sdk.NvsTimeline.PlaybackRateControlRegion[] playbackRateControlRegionArr);

    private native void nativeSetThemeMusicVolumeGain(long j_renamed, float f_renamed, float f2);

    private native void nativeSetThemeTitleCaptionText(long j_renamed, java.lang.String str);

    private native void nativeSetThemeTrailerCaptionText(long j_renamed, java.lang.String str);

    private native boolean nativeSetTimelineEndingLogo(long j_renamed, java.lang.String str, int i_renamed, int i2, int i3, int i4);

    private native boolean nativeSetWatermarkOpacity(long j_renamed, float f_renamed);

    private native void nativeSetupInputCacheForCaption(long j_renamed, com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption, long j2);

    private native int nativeVideoTrackCount(long j_renamed);

    private native com.meicam.sdk.NvsTimelineCaption natvieGetFirstCaption(long j_renamed);

    private native com.meicam.sdk.NvsTimelineCompoundCaption natvieGetFirstCompoundCaption(long j_renamed);

    private native com.meicam.sdk.NvsTimelineCaption natvieGetLastCaption(long j_renamed);

    private native com.meicam.sdk.NvsTimelineCompoundCaption natvieGetLastCompoundCaption(long j_renamed);

    public com.meicam.sdk.NvsVideoResolution getVideoRes() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoRes(this.m_internalObject);
    }

    public com.meicam.sdk.NvsAudioResolution getAudioRes() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioRes(this.m_internalObject);
    }

    public com.meicam.sdk.NvsRational getVideoFps() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFps(this.m_internalObject);
    }

    public long getDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDuration(this.m_internalObject);
    }

    public com.meicam.sdk.NvsVideoTrack appendVideoTrack() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendVideoTrack(this.m_internalObject);
    }

    public com.meicam.sdk.NvsAudioTrack appendAudioTrack() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendAudioTrack(this.m_internalObject);
    }

    public boolean removeVideoTrack(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveVideoTrack(this.m_internalObject, i_renamed);
    }

    public boolean removeAudioTrack(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAudioTrack(this.m_internalObject, i_renamed);
    }

    public int videoTrackCount() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeVideoTrackCount(this.m_internalObject);
    }

    public int audioTrackCount() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAudioTrackCount(this.m_internalObject);
    }

    public com.meicam.sdk.NvsVideoTrack getVideoTrackByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTrackByIndex(this.m_internalObject, i_renamed);
    }

    public com.meicam.sdk.NvsAudioTrack getAudioTrackByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioTrackByIndex(this.m_internalObject, i_renamed);
    }

    public boolean changeVideoSize(int i_renamed, int i2) {
        return nativeChangeVideoSize(this.m_internalObject, i_renamed, i2);
    }

    public void setCaptionBoundingRectInActualMode(boolean z_renamed) {
        nativeSetCaptionBoundingRectMode(this.m_internalObject, z_renamed);
    }

    public com.meicam.sdk.NvsTimelineCaption getFirstCaption() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return natvieGetFirstCaption(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineCaption getLastCaption() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return natvieGetLastCaption(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineCaption getPrevCaption(com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public com.meicam.sdk.NvsTimelineCaption getNextCaption(com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetNextCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public java.util.List<com.meicam.sdk.NvsTimelineCaption> getCaptionsByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionsByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsTimelineCaption addCaption(java.lang.String str, long j_renamed, long j2, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddCaption(this.m_internalObject, str, j_renamed, j2, str2, false);
    }

    public com.meicam.sdk.NvsTimelineCaption addPanoramicCaption(java.lang.String str, long j_renamed, long j2, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddCaption(this.m_internalObject, str, j_renamed, j2, str2, true);
    }

    public com.meicam.sdk.NvsTimelineCaption removeCaption(com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public void captureCaptionParameters(com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeCaptureCaptionParameters(this.m_internalObject, nvsTimelineCaption);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption getFirstCompoundCaption() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return natvieGetFirstCompoundCaption(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption getLastCompoundCaption() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return natvieGetLastCompoundCaption(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption getPrevCaption(com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption getNextCaption(com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetNextCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public java.util.List<com.meicam.sdk.NvsTimelineCompoundCaption> getCompoundCaptionsByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundCaptionsByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption addCompoundCaption(long j_renamed, long j2, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddCompoundCaption(this.m_internalObject, j_renamed, j2, str);
    }

    public com.meicam.sdk.NvsTimelineCompoundCaption removeCompoundCaption(com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public void captureCompoundCaptionParameters(com.meicam.sdk.NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeCaptureCompoundCaptionParameters(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker getFirstAnimatedSticker() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFirstAnimatedSticker(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker getLastAnimatedSticker() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetLastAnimatedSticker(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker getPrevAnimatedSticker(com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker getNextAnimatedSticker(com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetNextAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public java.util.List<com.meicam.sdk.NvsTimelineAnimatedSticker> getAnimatedStickersByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAnimatedStickersByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker addAnimatedSticker(long j_renamed, long j2, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, j_renamed, j2, str, false, false, new java.lang.String());
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker addPanoramicAnimatedSticker(long j_renamed, long j2, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, j_renamed, j2, str, true, false, new java.lang.String());
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker addCustomAnimatedSticker(long j_renamed, long j2, java.lang.String str, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, j_renamed, j2, str, false, true, str2);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker addCustomPanoramicAnimatedSticker(long j_renamed, long j2, java.lang.String str, java.lang.String str2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, j_renamed, j2, str, true, true, str2);
    }

    public com.meicam.sdk.NvsTimelineAnimatedSticker removeAnimatedSticker(com.meicam.sdk.NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public com.meicam.sdk.NvsTimelineVideoFx getFirstTimelineVideoFx() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFirstTimelineVideoFx(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineVideoFx getLastTimelineVideoFx() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetLastTimelineVideoFx(this.m_internalObject);
    }

    public com.meicam.sdk.NvsTimelineVideoFx getPrevTimelineVideoFx(com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public com.meicam.sdk.NvsTimelineVideoFx getNextTimelineVideoFx(com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetNextTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public java.util.List<com.meicam.sdk.NvsTimelineVideoFx> getTimelineVideoFxByTimelinePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxByTimelinePosition(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsTimelineVideoFx addBuiltinTimelineVideoFx(long j_renamed, long j2, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddBuiltinTimelineVideoFx(this.m_internalObject, j_renamed, j2, str);
    }

    public com.meicam.sdk.NvsTimelineVideoFx addPackagedTimelineVideoFx(long j_renamed, long j2, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddPackagedTimelineVideoFx(this.m_internalObject, j_renamed, j2, str);
    }

    public com.meicam.sdk.NvsTimelineVideoFx addCustomTimelineVideoFx(long j_renamed, long j2, com.meicam.sdk.NvsCustomVideoFx.Renderer renderer) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddCustomTimelineVideoFx(this.m_internalObject, j_renamed, j2, renderer);
    }

    public com.meicam.sdk.NvsTimelineVideoFx removeTimelineVideoFx(com.meicam.sdk.NvsTimelineVideoFx nvsTimelineVideoFx) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public java.lang.String getCurrentThemeId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCurrentThemeId(this.m_internalObject);
    }

    public boolean applyTheme(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeApplyTheme(this.m_internalObject, str);
    }

    public void removeCurrentTheme() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRemoveCurrentTheme(this.m_internalObject);
    }

    public void setThemeTitleCaptionText(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetThemeTitleCaptionText(this.m_internalObject, str);
    }

    public void setThemeTrailerCaptionText(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetThemeTrailerCaptionText(this.m_internalObject, str);
    }

    public void setThemeMusicVolumeGain(float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetThemeMusicVolumeGain(this.m_internalObject, f_renamed, f2);
    }

    public com.meicam.sdk.NvsVolume getThemeMusicVolumeGain() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetThemeMusicVolumeGain(this.m_internalObject);
    }

    public boolean addWatermark(java.lang.String str, int i_renamed, int i2, float f_renamed, int i3, int i4, int i5) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAddWatermark(this.m_internalObject, str, i_renamed, i2, f_renamed, i3, i4, i5);
    }

    public void deleteWatermark() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeDeleteWatermark(this.m_internalObject);
    }

    public boolean setWatermarkOpacity(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetWatermarkOpacity(this.m_internalObject, f_renamed);
    }

    public boolean setTimelineEndingLogo(java.lang.String str, int i_renamed, int i2, int i3, int i4) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetTimelineEndingLogo(this.m_internalObject, str, i_renamed, i2, i3, i4);
    }

    public void removeTimelineEndingLogo() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRemoveTimelineEndingLogo(this.m_internalObject);
    }

    public void setAudioFadeOutDuration(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetAudioFadeOutDuration(this.m_internalObject, j_renamed);
    }

    public long getAudioFadeOutDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioFadeOutDuration(this.m_internalObject);
    }

    public void setPlaybackRateControl(com.meicam.sdk.NvsTimeline.PlaybackRateControlRegion[] playbackRateControlRegionArr) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPlaybackRateControl(this.m_internalObject, playbackRateControlRegionArr);
    }

    public com.meicam.sdk.NvsTimeline.PlaybackRateControlRegion[] getPlaybackRateControl() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPlaybackRateControl(this.m_internalObject);
    }

    public void setupInputCacheForCaption(com.meicam.sdk.NvsTimelineCaption nvsTimelineCaption, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetupInputCacheForCaption(this.m_internalObject, nvsTimelineCaption, j_renamed);
    }
}
