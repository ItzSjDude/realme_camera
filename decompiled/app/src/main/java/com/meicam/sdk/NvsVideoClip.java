package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoClip extends com.meicam.sdk.NvsClip {
    public static final int CLIP_MOTIONMODE_LETTERBOX_ZOOMIN = 0;
    public static final int CLIP_WRAPMODE_REPEAT_LASTFRAME = 0;
    public static final int ClIP_BACKGROUNDMODE_BLUR = 1;
    public static final int ClIP_BACKGROUNDMODE_COLOR_SOLID = 0;
    public static final int ClIP_EXTRAVIDEOROTATION_0 = 0;
    public static final int ClIP_EXTRAVIDEOROTATION_180 = 2;
    public static final int ClIP_EXTRAVIDEOROTATION_270 = 3;
    public static final int ClIP_EXTRAVIDEOROTATION_90 = 1;
    public static final int ClIP_MOTIONMODE_LETTERBOX_ZOOMOUT = 1;
    public static final int ClIP_WRAPMODE_REPEAT = 2;
    public static final int ClIP_WRAPMODE_REPEAT_FIRSTFRAME = 1;
    public static final int IMAGE_CLIP_MOTIONMMODE_ROI = 2;
    public static final int ROLE_IN_THEME_GENERAL = 0;
    public static final int ROLE_IN_THEME_TITLE = 1;
    public static final int ROLE_IN_THEME_TRAILER = 2;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_1 = 1;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_2 = 2;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_3 = 3;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_BASE = 0;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_NONE = -1;
    public static final int VIDEO_CLIP_TYPE_AV = 0;
    public static final int VIDEO_CLIP_TYPE_IMAGE = 1;

    private native com.meicam.sdk.NvsVideoFx nativeAppendBeautyFx(long j_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeAppendBuiltinFx(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsVideoFx nativeAppendPackagedFx(long j_renamed, java.lang.String str);

    private native void nativeDisableAmbiguousCrop(long j_renamed, boolean z_renamed);

    private native void nativeEnableVideoClipROI(long j_renamed, boolean z_renamed);

    private native int nativeGetClipWrapMode(long j_renamed);

    private native android.graphics.RectF nativeGetEndROI(long j_renamed);

    private native int nativeGetExtraVideoRotation(long j_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeGetFxByIndex(long j_renamed, int i_renamed);

    private native android.graphics.RectF nativeGetImageMaskROI(long j_renamed);

    private native boolean nativeGetImageMotionAnimationEnabled(long j_renamed);

    private native int nativeGetImageMotionMode(long j_renamed);

    private native com.meicam.sdk.NvsPanAndScan nativeGetPanAndScan(long j_renamed);

    private native boolean nativeGetPlayInReverse(long j_renamed);

    private native int nativeGetRoleInTheme(long j_renamed);

    private native int nativeGetSourceBackgroundMode(long j_renamed);

    private native android.graphics.RectF nativeGetStartROI(long j_renamed);

    private native int nativeGetVideoType(long j_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeInsertBeautyFx(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeInsertBuiltinFx(long j_renamed, java.lang.String str, int i_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeInsertCustomFx(long j_renamed, com.meicam.sdk.NvsCustomVideoFx.Renderer renderer, int i_renamed);

    private native com.meicam.sdk.NvsVideoFx nativeInsertPackagedFx(long j_renamed, java.lang.String str, int i_renamed);

    private native boolean nativeIsAmbiguousCropDisabled(long j_renamed);

    private native boolean nativeIsClipHDREnabled(long j_renamed);

    private native boolean nativeIsSoftWareDeocdingUsed(long j_renamed);

    private native boolean nativeIsVideoClipROIEnabled(long j_renamed);

    private native boolean nativeRemoveAllFx(long j_renamed);

    private native boolean nativeRemoveFx(long j_renamed, int i_renamed);

    private native void nativeSetClipHDREnable(long j_renamed, boolean z_renamed);

    private native void nativeSetClipWrapMode(long j_renamed, int i_renamed);

    private native void nativeSetDecodeTemporalLayer(long j_renamed, int i_renamed);

    private native void nativeSetExtraVideoRotation(long j_renamed, int i_renamed);

    private native void nativeSetExtraVideoRotation2(long j_renamed, int i_renamed, boolean z_renamed);

    private native void nativeSetImageMaskROI(long j_renamed, android.graphics.RectF rectF);

    private native void nativeSetImageMotionAnimationEnabled(long j_renamed, boolean z_renamed);

    private native void nativeSetImageMotionMode(long j_renamed, int i_renamed);

    private native void nativeSetImageMotionROI(long j_renamed, android.graphics.RectF rectF, android.graphics.RectF rectF2);

    private native void nativeSetPanAndScan(long j_renamed, float f_renamed, float f2);

    private native void nativeSetPlayInReverse(long j_renamed, boolean z_renamed);

    private native void nativeSetSoftWareDecoding(long j_renamed, boolean z_renamed);

    private native void nativeSetSourceBackgroundMode(long j_renamed, int i_renamed);

    public int getVideoType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoType(this.m_internalObject);
    }

    public int getRoleInTheme() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetRoleInTheme(this.m_internalObject);
    }

    public void setPlayInReverse(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPlayInReverse(this.m_internalObject, z_renamed);
    }

    public boolean getPlayInReverse() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPlayInReverse(this.m_internalObject);
    }

    public void setExtraVideoRotation(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetExtraVideoRotation(this.m_internalObject, i_renamed);
    }

    public void setExtraVideoRotation(int i_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetExtraVideoRotation2(this.m_internalObject, i_renamed, z_renamed);
    }

    public int getExtraVideoRotation() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetExtraVideoRotation(this.m_internalObject);
    }

    public void setSoftWareDecoding(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetSoftWareDecoding(this.m_internalObject, z_renamed);
    }

    public boolean isSoftWareDeocedUsed() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsSoftWareDeocdingUsed(this.m_internalObject);
    }

    public void disableAmbiguousCrop(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeDisableAmbiguousCrop(this.m_internalObject, z_renamed);
    }

    public boolean isAmbiguousCropDisabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsAmbiguousCropDisabled(this.m_internalObject);
    }

    public void setPanAndScan(float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPanAndScan(this.m_internalObject, f_renamed, f2);
    }

    public com.meicam.sdk.NvsPanAndScan getPanAndScan() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPanAndScan(this.m_internalObject);
    }

    public void enableVideoClipROI(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeEnableVideoClipROI(this.m_internalObject, z_renamed);
    }

    public boolean isVideoClipROIEnabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsVideoClipROIEnabled(this.m_internalObject);
    }

    public int getSourceBackgroundMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetSourceBackgroundMode(this.m_internalObject);
    }

    public void setSourceBackgroundMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetSourceBackgroundMode(this.m_internalObject, i_renamed);
    }

    public int getImageMotionMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMotionMode(this.m_internalObject);
    }

    public void setImageMotionMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionMode(this.m_internalObject, i_renamed);
    }

    public boolean getImageMotionAnimationEnabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMotionAnimationEnabled(this.m_internalObject);
    }

    public void setImageMotionAnimationEnabled(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionAnimationEnabled(this.m_internalObject, z_renamed);
    }

    public android.graphics.RectF getStartROI() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetStartROI(this.m_internalObject);
    }

    public android.graphics.RectF getEndROI() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetEndROI(this.m_internalObject);
    }

    public void setImageMotionROI(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionROI(this.m_internalObject, rectF, rectF2);
    }

    public android.graphics.RectF getImageMaskROI() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMaskROI(this.m_internalObject);
    }

    public void setImageMaskROI(android.graphics.RectF rectF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetImageMaskROI(this.m_internalObject, rectF);
    }

    public void setClipWrapMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed < 0 || i_renamed > 2) {
            return;
        }
        nativeSetClipWrapMode(this.m_internalObject, i_renamed);
    }

    public int getClipWrapMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipWrapMode(this.m_internalObject);
    }

    public void setClipHDREnable(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetClipHDREnable(this.m_internalObject, z_renamed);
    }

    public boolean isClipHDREnabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsClipHDREnabled(this.m_internalObject);
    }

    public com.meicam.sdk.NvsVideoFx appendBuiltinFx(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendBuiltinFx(this.m_internalObject, str);
    }

    public com.meicam.sdk.NvsVideoFx insertBuiltinFx(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertBuiltinFx(this.m_internalObject, str, i_renamed);
    }

    public com.meicam.sdk.NvsVideoFx appendPackagedFx(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendPackagedFx(this.m_internalObject, str);
    }

    public com.meicam.sdk.NvsVideoFx insertPackagedFx(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertPackagedFx(this.m_internalObject, str, i_renamed);
    }

    public com.meicam.sdk.NvsVideoFx appendCustomFx(com.meicam.sdk.NvsCustomVideoFx.Renderer renderer) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomFx(this.m_internalObject, renderer, getFxCount());
    }

    public com.meicam.sdk.NvsVideoFx insertCustomFx(com.meicam.sdk.NvsCustomVideoFx.Renderer renderer, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomFx(this.m_internalObject, renderer, i_renamed);
    }

    public com.meicam.sdk.NvsVideoFx appendBeautyFx() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAppendBeautyFx(this.m_internalObject);
    }

    public com.meicam.sdk.NvsVideoFx insertBeautyFx(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertBeautyFx(this.m_internalObject, i_renamed);
    }

    public boolean removeFx(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveFx(this.m_internalObject, i_renamed);
    }

    public boolean removeAllFx() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAllFx(this.m_internalObject);
    }

    public com.meicam.sdk.NvsVideoFx getFxByIndex(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFxByIndex(this.m_internalObject, i_renamed);
    }

    public void setDecodeTemporalLayer(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetDecodeTemporalLayer(this.m_internalObject, i_renamed);
    }
}
