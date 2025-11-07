package com.meicam.sdk;

import android.graphics.RectF;
import com.meicam.sdk.NvsCustomVideoFx;

/* loaded from: classes2.dex */
public class NvsVideoClip extends NvsClip {
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

    private native NvsVideoFx nativeAppendBeautyFx(long OplusGLSurfaceView_15);

    private native NvsVideoFx nativeAppendBuiltinFx(long OplusGLSurfaceView_15, String str);

    private native NvsVideoFx nativeAppendPackagedFx(long OplusGLSurfaceView_15, String str);

    private native void nativeDisableAmbiguousCrop(long OplusGLSurfaceView_15, boolean z);

    private native void nativeEnableVideoClipROI(long OplusGLSurfaceView_15, boolean z);

    private native int nativeGetClipWrapMode(long OplusGLSurfaceView_15);

    private native RectF nativeGetEndROI(long OplusGLSurfaceView_15);

    private native int nativeGetExtraVideoRotation(long OplusGLSurfaceView_15);

    private native NvsVideoFx nativeGetFxByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native RectF nativeGetImageMaskROI(long OplusGLSurfaceView_15);

    private native boolean nativeGetImageMotionAnimationEnabled(long OplusGLSurfaceView_15);

    private native int nativeGetImageMotionMode(long OplusGLSurfaceView_15);

    private native NvsPanAndScan nativeGetPanAndScan(long OplusGLSurfaceView_15);

    private native boolean nativeGetPlayInReverse(long OplusGLSurfaceView_15);

    private native int nativeGetRoleInTheme(long OplusGLSurfaceView_15);

    private native int nativeGetSourceBackgroundMode(long OplusGLSurfaceView_15);

    private native RectF nativeGetStartROI(long OplusGLSurfaceView_15);

    private native int nativeGetVideoType(long OplusGLSurfaceView_15);

    private native NvsVideoFx nativeInsertBeautyFx(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsVideoFx nativeInsertBuiltinFx(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native NvsVideoFx nativeInsertCustomFx(long OplusGLSurfaceView_15, NvsCustomVideoFx.Renderer renderer, int OplusGLSurfaceView_13);

    private native NvsVideoFx nativeInsertPackagedFx(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native boolean nativeIsAmbiguousCropDisabled(long OplusGLSurfaceView_15);

    private native boolean nativeIsClipHDREnabled(long OplusGLSurfaceView_15);

    private native boolean nativeIsSoftWareDeocdingUsed(long OplusGLSurfaceView_15);

    private native boolean nativeIsVideoClipROIEnabled(long OplusGLSurfaceView_15);

    private native boolean nativeRemoveAllFx(long OplusGLSurfaceView_15);

    private native boolean nativeRemoveFx(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetClipHDREnable(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetClipWrapMode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetDecodeTemporalLayer(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetExtraVideoRotation(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetExtraVideoRotation2(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z);

    private native void nativeSetImageMaskROI(long OplusGLSurfaceView_15, RectF rectF);

    private native void nativeSetImageMotionAnimationEnabled(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetImageMotionMode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetImageMotionROI(long OplusGLSurfaceView_15, RectF rectF, RectF rectF2);

    private native void nativeSetPanAndScan(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2);

    private native void nativeSetPlayInReverse(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetSoftWareDecoding(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetSourceBackgroundMode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    public int getVideoType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoType(this.m_internalObject);
    }

    public int getRoleInTheme() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetRoleInTheme(this.m_internalObject);
    }

    public void setPlayInReverse(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPlayInReverse(this.m_internalObject, z);
    }

    public boolean getPlayInReverse() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPlayInReverse(this.m_internalObject);
    }

    public void setExtraVideoRotation(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetExtraVideoRotation(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setExtraVideoRotation(int OplusGLSurfaceView_13, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetExtraVideoRotation2(this.m_internalObject, OplusGLSurfaceView_13, z);
    }

    public int getExtraVideoRotation() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetExtraVideoRotation(this.m_internalObject);
    }

    public void setSoftWareDecoding(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetSoftWareDecoding(this.m_internalObject, z);
    }

    public boolean isSoftWareDeocedUsed() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsSoftWareDeocdingUsed(this.m_internalObject);
    }

    public void disableAmbiguousCrop(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeDisableAmbiguousCrop(this.m_internalObject, z);
    }

    public boolean isAmbiguousCropDisabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsAmbiguousCropDisabled(this.m_internalObject);
    }

    public void setPanAndScan(float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPanAndScan(this.m_internalObject, COUIBaseListPopupWindow_12, f2);
    }

    public NvsPanAndScan getPanAndScan() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPanAndScan(this.m_internalObject);
    }

    public void enableVideoClipROI(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeEnableVideoClipROI(this.m_internalObject, z);
    }

    public boolean isVideoClipROIEnabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsVideoClipROIEnabled(this.m_internalObject);
    }

    public int getSourceBackgroundMode() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetSourceBackgroundMode(this.m_internalObject);
    }

    public void setSourceBackgroundMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetSourceBackgroundMode(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int getImageMotionMode() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMotionMode(this.m_internalObject);
    }

    public void setImageMotionMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionMode(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean getImageMotionAnimationEnabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMotionAnimationEnabled(this.m_internalObject);
    }

    public void setImageMotionAnimationEnabled(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionAnimationEnabled(this.m_internalObject, z);
    }

    public RectF getStartROI() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetStartROI(this.m_internalObject);
    }

    public RectF getEndROI() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetEndROI(this.m_internalObject);
    }

    public void setImageMotionROI(RectF rectF, RectF rectF2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetImageMotionROI(this.m_internalObject, rectF, rectF2);
    }

    public RectF getImageMaskROI() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetImageMaskROI(this.m_internalObject);
    }

    public void setImageMaskROI(RectF rectF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetImageMaskROI(this.m_internalObject, rectF);
    }

    public void setClipWrapMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 2) {
            return;
        }
        nativeSetClipWrapMode(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int getClipWrapMode() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipWrapMode(this.m_internalObject);
    }

    public void setClipHDREnable(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetClipHDREnable(this.m_internalObject, z);
    }

    public boolean isClipHDREnabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsClipHDREnabled(this.m_internalObject);
    }

    public NvsVideoFx appendBuiltinFx(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendBuiltinFx(this.m_internalObject, str);
    }

    public NvsVideoFx insertBuiltinFx(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertBuiltinFx(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public NvsVideoFx appendPackagedFx(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendPackagedFx(this.m_internalObject, str);
    }

    public NvsVideoFx insertPackagedFx(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertPackagedFx(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public NvsVideoFx appendCustomFx(NvsCustomVideoFx.Renderer renderer) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomFx(this.m_internalObject, renderer, getFxCount());
    }

    public NvsVideoFx insertCustomFx(NvsCustomVideoFx.Renderer renderer, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomFx(this.m_internalObject, renderer, OplusGLSurfaceView_13);
    }

    public NvsVideoFx appendBeautyFx() {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendBeautyFx(this.m_internalObject);
    }

    public NvsVideoFx insertBeautyFx(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertBeautyFx(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean removeFx(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveFx(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean removeAllFx() {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAllFx(this.m_internalObject);
    }

    public NvsVideoFx getFxByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFxByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setDecodeTemporalLayer(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetDecodeTemporalLayer(this.m_internalObject, OplusGLSurfaceView_13);
    }
}
