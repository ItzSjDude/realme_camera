package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx;
import java.util.List;

/* loaded from: classes2.dex */
public class NvsTimeline extends NvsObject {
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

    private native NvsTimelineAnimatedSticker nativeAddAnimatedSticker(long OplusGLSurfaceView_15, long j2, long j3, String str, boolean z, boolean z2, String str2);

    private native NvsTimelineVideoFx nativeAddBuiltinTimelineVideoFx(long OplusGLSurfaceView_15, long j2, long j3, String str);

    private native NvsTimelineCaption nativeAddCaption(long OplusGLSurfaceView_15, String str, long j2, long j3, String str2, boolean z);

    private native NvsTimelineCompoundCaption nativeAddCompoundCaption(long OplusGLSurfaceView_15, long j2, long j3, String str);

    private native NvsTimelineVideoFx nativeAddCustomTimelineVideoFx(long OplusGLSurfaceView_15, long j2, long j3, NvsCustomVideoFx.Renderer renderer);

    private native NvsTimelineVideoFx nativeAddPackagedTimelineVideoFx(long OplusGLSurfaceView_15, long j2, long j3, String str);

    private native boolean nativeAddWatermark(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, int i3, int i4, int i5);

    private native NvsAudioTrack nativeAppendAudioTrack(long OplusGLSurfaceView_15);

    private native NvsVideoTrack nativeAppendVideoTrack(long OplusGLSurfaceView_15);

    private native boolean nativeApplyTheme(long OplusGLSurfaceView_15, String str);

    private native int nativeAudioTrackCount(long OplusGLSurfaceView_15);

    private native void nativeCaptureCaptionParameters(long OplusGLSurfaceView_15, NvsTimelineCaption nvsTimelineCaption);

    private native void nativeCaptureCompoundCaptionParameters(long OplusGLSurfaceView_15, NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native boolean nativeChangeVideoSize(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native void nativeDeleteWatermark(long OplusGLSurfaceView_15);

    private native List<NvsTimelineAnimatedSticker> nativeGetAnimatedStickersByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native long nativeGetAudioFadeOutDuration(long OplusGLSurfaceView_15);

    private native NvsAudioResolution nativeGetAudioRes(long OplusGLSurfaceView_15);

    private native NvsAudioTrack nativeGetAudioTrackByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native List<NvsTimelineCaption> nativeGetCaptionsByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native List<NvsTimelineCompoundCaption> nativeGetCompoundCaptionsByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native String nativeGetCurrentThemeId(long OplusGLSurfaceView_15);

    private native long nativeGetDuration(long OplusGLSurfaceView_15);

    private native NvsTimelineAnimatedSticker nativeGetFirstAnimatedSticker(long OplusGLSurfaceView_15);

    private native NvsTimelineVideoFx nativeGetFirstTimelineVideoFx(long OplusGLSurfaceView_15);

    private native NvsTimelineAnimatedSticker nativeGetLastAnimatedSticker(long OplusGLSurfaceView_15);

    private native NvsTimelineVideoFx nativeGetLastTimelineVideoFx(long OplusGLSurfaceView_15);

    private native NvsTimelineAnimatedSticker nativeGetNextAnimatedSticker(long OplusGLSurfaceView_15, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native NvsTimelineCaption nativeGetNextCaption(long OplusGLSurfaceView_15, NvsTimelineCaption nvsTimelineCaption);

    private native NvsTimelineCompoundCaption nativeGetNextCompoundCaption(long OplusGLSurfaceView_15, NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native NvsTimelineVideoFx nativeGetNextTimelineVideoFx(long OplusGLSurfaceView_15, NvsTimelineVideoFx nvsTimelineVideoFx);

    private native PlaybackRateControlRegion[] nativeGetPlaybackRateControl(long OplusGLSurfaceView_15);

    private native NvsTimelineAnimatedSticker nativeGetPrevAnimatedSticker(long OplusGLSurfaceView_15, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native NvsTimelineCaption nativeGetPrevCaption(long OplusGLSurfaceView_15, NvsTimelineCaption nvsTimelineCaption);

    private native NvsTimelineCompoundCaption nativeGetPrevCompoundCaption(long OplusGLSurfaceView_15, NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native NvsTimelineVideoFx nativeGetPrevTimelineVideoFx(long OplusGLSurfaceView_15, NvsTimelineVideoFx nvsTimelineVideoFx);

    private native NvsVolume nativeGetThemeMusicVolumeGain(long OplusGLSurfaceView_15);

    private native List<NvsTimelineVideoFx> nativeGetTimelineVideoFxByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native NvsRational nativeGetVideoFps(long OplusGLSurfaceView_15);

    private native NvsVideoResolution nativeGetVideoRes(long OplusGLSurfaceView_15);

    private native NvsVideoTrack nativeGetVideoTrackByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsTimelineAnimatedSticker nativeRemoveAnimatedSticker(long OplusGLSurfaceView_15, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker);

    private native boolean nativeRemoveAudioTrack(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsTimelineCaption nativeRemoveCaption(long OplusGLSurfaceView_15, NvsTimelineCaption nvsTimelineCaption);

    private native NvsTimelineCompoundCaption nativeRemoveCompoundCaption(long OplusGLSurfaceView_15, NvsTimelineCompoundCaption nvsTimelineCompoundCaption);

    private native void nativeRemoveCurrentTheme(long OplusGLSurfaceView_15);

    private native void nativeRemoveTimelineEndingLogo(long OplusGLSurfaceView_15);

    private native NvsTimelineVideoFx nativeRemoveTimelineVideoFx(long OplusGLSurfaceView_15, NvsTimelineVideoFx nvsTimelineVideoFx);

    private native boolean nativeRemoveVideoTrack(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetAudioFadeOutDuration(long OplusGLSurfaceView_15, long j2);

    private native void nativeSetCaptionBoundingRectMode(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetPlaybackRateControl(long OplusGLSurfaceView_15, PlaybackRateControlRegion[] playbackRateControlRegionArr);

    private native void nativeSetThemeMusicVolumeGain(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2);

    private native void nativeSetThemeTitleCaptionText(long OplusGLSurfaceView_15, String str);

    private native void nativeSetThemeTrailerCaptionText(long OplusGLSurfaceView_15, String str);

    private native boolean nativeSetTimelineEndingLogo(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13, int i2, int i3, int i4);

    private native boolean nativeSetWatermarkOpacity(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetupInputCacheForCaption(long OplusGLSurfaceView_15, NvsTimelineCaption nvsTimelineCaption, long j2);

    private native int nativeVideoTrackCount(long OplusGLSurfaceView_15);

    private native NvsTimelineCaption natvieGetFirstCaption(long OplusGLSurfaceView_15);

    private native NvsTimelineCompoundCaption natvieGetFirstCompoundCaption(long OplusGLSurfaceView_15);

    private native NvsTimelineCaption natvieGetLastCaption(long OplusGLSurfaceView_15);

    private native NvsTimelineCompoundCaption natvieGetLastCompoundCaption(long OplusGLSurfaceView_15);

    public NvsVideoResolution getVideoRes() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoRes(this.m_internalObject);
    }

    public NvsAudioResolution getAudioRes() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioRes(this.m_internalObject);
    }

    public NvsRational getVideoFps() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFps(this.m_internalObject);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDuration(this.m_internalObject);
    }

    public NvsVideoTrack appendVideoTrack() {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendVideoTrack(this.m_internalObject);
    }

    public NvsAudioTrack appendAudioTrack() {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendAudioTrack(this.m_internalObject);
    }

    public boolean removeVideoTrack(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveVideoTrack(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean removeAudioTrack(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAudioTrack(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int videoTrackCount() {
        NvsUtils.checkFunctionInMainThread();
        return nativeVideoTrackCount(this.m_internalObject);
    }

    public int audioTrackCount() {
        NvsUtils.checkFunctionInMainThread();
        return nativeAudioTrackCount(this.m_internalObject);
    }

    public NvsVideoTrack getVideoTrackByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoTrackByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public NvsAudioTrack getAudioTrackByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioTrackByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean changeVideoSize(int OplusGLSurfaceView_13, int i2) {
        return nativeChangeVideoSize(this.m_internalObject, OplusGLSurfaceView_13, i2);
    }

    public void setCaptionBoundingRectInActualMode(boolean z) {
        nativeSetCaptionBoundingRectMode(this.m_internalObject, z);
    }

    public NvsTimelineCaption getFirstCaption() {
        NvsUtils.checkFunctionInMainThread();
        return natvieGetFirstCaption(this.m_internalObject);
    }

    public NvsTimelineCaption getLastCaption() {
        NvsUtils.checkFunctionInMainThread();
        return natvieGetLastCaption(this.m_internalObject);
    }

    public NvsTimelineCaption getPrevCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public NvsTimelineCaption getNextCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetNextCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public List<NvsTimelineCaption> getCaptionsByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionsByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsTimelineCaption addCaption(String str, long OplusGLSurfaceView_15, long j2, String str2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddCaption(this.m_internalObject, str, OplusGLSurfaceView_15, j2, str2, false);
    }

    public NvsTimelineCaption addPanoramicCaption(String str, long OplusGLSurfaceView_15, long j2, String str2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddCaption(this.m_internalObject, str, OplusGLSurfaceView_15, j2, str2, true);
    }

    public NvsTimelineCaption removeCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCaption(this.m_internalObject, nvsTimelineCaption);
    }

    public void captureCaptionParameters(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        nativeCaptureCaptionParameters(this.m_internalObject, nvsTimelineCaption);
    }

    public NvsTimelineCompoundCaption getFirstCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        return natvieGetFirstCompoundCaption(this.m_internalObject);
    }

    public NvsTimelineCompoundCaption getLastCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        return natvieGetLastCompoundCaption(this.m_internalObject);
    }

    public NvsTimelineCompoundCaption getPrevCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public NvsTimelineCompoundCaption getNextCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetNextCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public List<NvsTimelineCompoundCaption> getCompoundCaptionsByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundCaptionsByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsTimelineCompoundCaption addCompoundCaption(long OplusGLSurfaceView_15, long j2, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddCompoundCaption(this.m_internalObject, OplusGLSurfaceView_15, j2, str);
    }

    public NvsTimelineCompoundCaption removeCompoundCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCompoundCaption(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public void captureCompoundCaptionParameters(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        nativeCaptureCompoundCaptionParameters(this.m_internalObject, nvsTimelineCompoundCaption);
    }

    public NvsTimelineAnimatedSticker getFirstAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFirstAnimatedSticker(this.m_internalObject);
    }

    public NvsTimelineAnimatedSticker getLastAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetLastAnimatedSticker(this.m_internalObject);
    }

    public NvsTimelineAnimatedSticker getPrevAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public NvsTimelineAnimatedSticker getNextAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetNextAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public List<NvsTimelineAnimatedSticker> getAnimatedStickersByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAnimatedStickersByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsTimelineAnimatedSticker addAnimatedSticker(long OplusGLSurfaceView_15, long j2, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, OplusGLSurfaceView_15, j2, str, false, false, new String());
    }

    public NvsTimelineAnimatedSticker addPanoramicAnimatedSticker(long OplusGLSurfaceView_15, long j2, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, OplusGLSurfaceView_15, j2, str, true, false, new String());
    }

    public NvsTimelineAnimatedSticker addCustomAnimatedSticker(long OplusGLSurfaceView_15, long j2, String str, String str2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, OplusGLSurfaceView_15, j2, str, false, true, str2);
    }

    public NvsTimelineAnimatedSticker addCustomPanoramicAnimatedSticker(long OplusGLSurfaceView_15, long j2, String str, String str2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddAnimatedSticker(this.m_internalObject, OplusGLSurfaceView_15, j2, str, true, true, str2);
    }

    public NvsTimelineAnimatedSticker removeAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAnimatedSticker(this.m_internalObject, nvsTimelineAnimatedSticker);
    }

    public NvsTimelineVideoFx getFirstTimelineVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFirstTimelineVideoFx(this.m_internalObject);
    }

    public NvsTimelineVideoFx getLastTimelineVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetLastTimelineVideoFx(this.m_internalObject);
    }

    public NvsTimelineVideoFx getPrevTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPrevTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public NvsTimelineVideoFx getNextTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetNextTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public List<NvsTimelineVideoFx> getTimelineVideoFxByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsTimelineVideoFx addBuiltinTimelineVideoFx(long OplusGLSurfaceView_15, long j2, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddBuiltinTimelineVideoFx(this.m_internalObject, OplusGLSurfaceView_15, j2, str);
    }

    public NvsTimelineVideoFx addPackagedTimelineVideoFx(long OplusGLSurfaceView_15, long j2, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddPackagedTimelineVideoFx(this.m_internalObject, OplusGLSurfaceView_15, j2, str);
    }

    public NvsTimelineVideoFx addCustomTimelineVideoFx(long OplusGLSurfaceView_15, long j2, NvsCustomVideoFx.Renderer renderer) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddCustomTimelineVideoFx(this.m_internalObject, OplusGLSurfaceView_15, j2, renderer);
    }

    public NvsTimelineVideoFx removeTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveTimelineVideoFx(this.m_internalObject, nvsTimelineVideoFx);
    }

    public String getCurrentThemeId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCurrentThemeId(this.m_internalObject);
    }

    public boolean applyTheme(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeApplyTheme(this.m_internalObject, str);
    }

    public void removeCurrentTheme() {
        NvsUtils.checkFunctionInMainThread();
        nativeRemoveCurrentTheme(this.m_internalObject);
    }

    public void setThemeTitleCaptionText(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetThemeTitleCaptionText(this.m_internalObject, str);
    }

    public void setThemeTrailerCaptionText(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetThemeTrailerCaptionText(this.m_internalObject, str);
    }

    public void setThemeMusicVolumeGain(float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetThemeMusicVolumeGain(this.m_internalObject, COUIBaseListPopupWindow_12, f2);
    }

    public NvsVolume getThemeMusicVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetThemeMusicVolumeGain(this.m_internalObject);
    }

    public boolean addWatermark(String str, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, int i3, int i4, int i5) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddWatermark(this.m_internalObject, str, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12, i3, i4, i5);
    }

    public void deleteWatermark() {
        NvsUtils.checkFunctionInMainThread();
        nativeDeleteWatermark(this.m_internalObject);
    }

    public boolean setWatermarkOpacity(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetWatermarkOpacity(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public boolean setTimelineEndingLogo(String str, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetTimelineEndingLogo(this.m_internalObject, str, OplusGLSurfaceView_13, i2, i3, i4);
    }

    public void removeTimelineEndingLogo() {
        NvsUtils.checkFunctionInMainThread();
        nativeRemoveTimelineEndingLogo(this.m_internalObject);
    }

    public void setAudioFadeOutDuration(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetAudioFadeOutDuration(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long getAudioFadeOutDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioFadeOutDuration(this.m_internalObject);
    }

    public void setPlaybackRateControl(PlaybackRateControlRegion[] playbackRateControlRegionArr) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPlaybackRateControl(this.m_internalObject, playbackRateControlRegionArr);
    }

    public PlaybackRateControlRegion[] getPlaybackRateControl() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPlaybackRateControl(this.m_internalObject);
    }

    public void setupInputCacheForCaption(NvsTimelineCaption nvsTimelineCaption, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetupInputCacheForCaption(this.m_internalObject, nvsTimelineCaption, OplusGLSurfaceView_15);
    }
}
