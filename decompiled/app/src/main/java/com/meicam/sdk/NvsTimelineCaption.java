package com.meicam.sdk;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* loaded from: classes2.dex */
public class NvsTimelineCaption extends NvsFx {
    public static final int BOUNDING_TYPE_FRAME = 2;
    public static final int BOUNDING_TYPE_TEXT = 0;
    public static final int BOUNDING_TYPE_TEXT_FRAME = 1;
    public static final int DEFAULT_CATEGORY = 0;
    public static final int NOT_USE_ASSET_DEFAULT_PARAM = 1;
    public static final int ROLE_IN_THEME_GENERAL = 0;
    public static final int ROLE_IN_THEME_TITLE = 1;
    public static final int ROLE_IN_THEME_TRAILER = 2;
    public static final int TEXT_ALIGNMENT_CENTER = 1;
    public static final int TEXT_ALIGNMENT_LEFT = 0;
    public static final int TEXT_ALIGNMENT_RIGHT = 2;
    public static final int THEME_CATEGORY = 2;
    public static final int USER_CATEGORY = 1;
    public static final int USE_ASSET_DEFAULT_PARAM = 0;

    public static class MotionParameters {
        public float anchorX = 0.0f;
        public float anchorY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float rotationZ = 0.0f;
        public float transX = 0.0f;
        public float transY = 0.0f;
    }

    private native boolean nativeApplyCaptionStyle(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native long nativeChangeInPoint(long OplusGLSurfaceView_15, long j2);

    private native long nativeChangeOutPoint(long OplusGLSurfaceView_15, long j2);

    private native PointF nativeGetAnchorPoint(long OplusGLSurfaceView_15);

    private native boolean nativeGetBold(long OplusGLSurfaceView_15);

    private native List<PointF> nativeGetBoundingRectangleVertices(long OplusGLSurfaceView_15);

    private native List<PointF> nativeGetCaptionBoundingVertices(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, MotionParameters motionParameters);

    private native String nativeGetCaptionStylePackageId(long OplusGLSurfaceView_15);

    private native PointF nativeGetCaptionTranslation(long OplusGLSurfaceView_15);

    private native int nativeGetCategory(long OplusGLSurfaceView_15);

    private native float nativeGetCenterAzimuthAngle(long OplusGLSurfaceView_15);

    private native float nativeGetCenterPolarAngle(long OplusGLSurfaceView_15);

    private native boolean nativeGetClipAffinityEnabled(long OplusGLSurfaceView_15);

    private native boolean nativeGetDrawOutline(long OplusGLSurfaceView_15);

    private native boolean nativeGetDrawShadow(long OplusGLSurfaceView_15);

    private native String nativeGetFontFamily(long OplusGLSurfaceView_15);

    private native String nativeGetFontFilePath(long OplusGLSurfaceView_15);

    private native float nativeGetFontSize(long OplusGLSurfaceView_15);

    private native long nativeGetInPoint(long OplusGLSurfaceView_15);

    private native boolean nativeGetItalic(long OplusGLSurfaceView_15);

    private native float nativeGetLetterSpacing(long OplusGLSurfaceView_15);

    private native float nativeGetOrthoAngleRange(long OplusGLSurfaceView_15);

    private native long nativeGetOutPoint(long OplusGLSurfaceView_15);

    private native NvsColor nativeGetOutlineColor(long OplusGLSurfaceView_15);

    private native float nativeGetOutlineWidth(long OplusGLSurfaceView_15);

    private native float nativeGetPanoramicRotationAngle(long OplusGLSurfaceView_15);

    private native float nativeGetPanoramicScaleX(long OplusGLSurfaceView_15);

    private native float nativeGetPanoramicScaleY(long OplusGLSurfaceView_15);

    private native float nativeGetPolarAngleRange(long OplusGLSurfaceView_15);

    private native int nativeGetRoleInTheme(long OplusGLSurfaceView_15);

    private native float nativeGetRotationZ(long OplusGLSurfaceView_15);

    private native float nativeGetScaleX(long OplusGLSurfaceView_15);

    private native float nativeGetScaleY(long OplusGLSurfaceView_15);

    private native NvsColor nativeGetShadowColor(long OplusGLSurfaceView_15);

    private native float nativeGetShadowFeather(long OplusGLSurfaceView_15);

    private native PointF nativeGetShadowOffset(long OplusGLSurfaceView_15);

    private native String nativeGetText(long OplusGLSurfaceView_15);

    private native int nativeGetTextAlignment(long OplusGLSurfaceView_15);

    private native RectF nativeGetTextBoundingRect(long OplusGLSurfaceView_15);

    private native float nativeGetTextCenterAzimuthAngle(long OplusGLSurfaceView_15);

    private native float nativeGetTextCenterPolarAngle(long OplusGLSurfaceView_15);

    private native NvsColor nativeGetTextColor(long OplusGLSurfaceView_15);

    private native float nativeGetTextOrthoAngleRange(long OplusGLSurfaceView_15);

    private native float nativeGetTextPolarAngleRange(long OplusGLSurfaceView_15);

    private native int nativeGetWeight(long OplusGLSurfaceView_15);

    private native float nativeGetZValue(long OplusGLSurfaceView_15);

    private native boolean nativeIsPanoramic(long OplusGLSurfaceView_15);

    private native void nativeMovePosition(long OplusGLSurfaceView_15, long j2);

    private native void nativeRotateCaption(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeScaleCaption(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeSetAnchorPoint(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetBold(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetCaptionTranslation(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetCenterAzimuthAngle(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetCenterPolarAngle(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetClipAffinityEnabled(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetDrawOutline(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetDrawShadow(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetFontByFilePath(long OplusGLSurfaceView_15, String str);

    private native void nativeSetFontFamily(long OplusGLSurfaceView_15, String str);

    private native void nativeSetFontSize(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetItalic(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetLetterSpacing(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetOutlineColor(long OplusGLSurfaceView_15, NvsColor nvsColor);

    private native void nativeSetOutlineWidth(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetPanoramicRotationAngle(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetPanoramicScaleX(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetPanoramicScaleY(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetPolarAngleRange(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetRotationZ(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetScaleX(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetScaleY(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetShadowColor(long OplusGLSurfaceView_15, NvsColor nvsColor);

    private native void nativeSetShadowFeather(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetShadowOffset(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetText(long OplusGLSurfaceView_15, String str);

    private native void nativeSetTextAlignment(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetTextColor(long OplusGLSurfaceView_15, NvsColor nvsColor);

    private native void nativeSetWeight(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetZValue(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeTranslateCaption(long OplusGLSurfaceView_15, PointF pointF);

    public void setClipAffinityEnabled(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetClipAffinityEnabled(this.m_internalObject, z);
    }

    public boolean getClipAffinityEnabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipAffinityEnabled(this.m_internalObject);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public long changeInPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long changeOutPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public void movePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public int getRoleInTheme() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetRoleInTheme(this.m_internalObject);
    }

    public int getCategory() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCategory(this.m_internalObject);
    }

    public String getCaptionStylePackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionStylePackageId(this.m_internalObject);
    }

    public boolean applyCaptionStyle(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptionStyle(this.m_internalObject, str, 1);
    }

    public boolean applyCaptionStyle(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptionStyle(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public void setText(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetText(this.m_internalObject, str);
    }

    public String getText() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetText(this.m_internalObject);
    }

    public void setTextAlignment(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetTextAlignment(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int getTextAlignment() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextAlignment(this.m_internalObject);
    }

    public void setBold(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetBold(this.m_internalObject, z);
    }

    public boolean getBold() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBold(this.m_internalObject);
    }

    public void setWeight(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetWeight(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int getWeight() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetWeight(this.m_internalObject);
    }

    public void setItalic(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetItalic(this.m_internalObject, z);
    }

    public boolean getItalic() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetItalic(this.m_internalObject);
    }

    public void setLetterSpacing(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetLetterSpacing(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getLetterSpacing() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetLetterSpacing(this.m_internalObject);
    }

    public void setTextColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetTextColor(this.m_internalObject, nvsColor);
    }

    public NvsColor getTextColor() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextColor(this.m_internalObject);
    }

    public void setDrawOutline(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetDrawOutline(this.m_internalObject, z);
    }

    public boolean getDrawOutline() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDrawOutline(this.m_internalObject);
    }

    public void setOutlineColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetOutlineColor(this.m_internalObject, nvsColor);
    }

    public NvsColor getOutlineColor() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutlineColor(this.m_internalObject);
    }

    public void setOutlineWidth(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetOutlineWidth(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getOutlineWidth() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutlineWidth(this.m_internalObject);
    }

    public void setDrawShadow(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetDrawShadow(this.m_internalObject, z);
    }

    public boolean getDrawShadow() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDrawShadow(this.m_internalObject);
    }

    public void setShadowColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetShadowColor(this.m_internalObject, nvsColor);
    }

    public NvsColor getShadowColor() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowColor(this.m_internalObject);
    }

    public void setShadowOffset(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetShadowOffset(this.m_internalObject, pointF);
    }

    public PointF getShadowOffset() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowOffset(this.m_internalObject);
    }

    public void setShadowFeather(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetShadowFeather(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getShadowFeather() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowFeather(this.m_internalObject);
    }

    public void setFontSize(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFontSize(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getFontSize() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFontSize(this.m_internalObject);
    }

    public void setFontByFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFontByFilePath(this.m_internalObject, str);
    }

    public String getFontFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFilePath(this.m_internalObject);
    }

    public void setFontFamily(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFontFamily(this.m_internalObject, str);
    }

    public String getFontFamily() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFamily(this.m_internalObject);
    }

    public void setCaptionTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCaptionTranslation(this.m_internalObject, pointF);
    }

    public PointF getCaptionTranslation() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionTranslation(this.m_internalObject);
    }

    public void translateCaption(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeTranslateCaption(this.m_internalObject, pointF);
    }

    public void setAnchorPoint(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetAnchorPoint(this.m_internalObject, pointF);
    }

    public PointF getAnchorPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAnchorPoint(this.m_internalObject);
    }

    public void setScaleX(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetScaleX(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getScaleX() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleX(this.m_internalObject);
    }

    public void setScaleY(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetScaleY(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getScaleY() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleY(this.m_internalObject);
    }

    public void scaleCaption(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeScaleCaption(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void setRotationZ(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetRotationZ(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getRotationZ() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetRotationZ(this.m_internalObject);
    }

    public void rotateCaption(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeRotateCaption(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void rotateCaption(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        RectF textBoundingRect = getTextBoundingRect();
        rotateCaption(COUIBaseListPopupWindow_12, new PointF((textBoundingRect.left + textBoundingRect.right) / 2.0f, (textBoundingRect.top + textBoundingRect.bottom) / 2.0f));
    }

    public RectF getTextBoundingRect() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextBoundingRect(this.m_internalObject);
    }

    public List<PointF> getBoundingRectangleVertices() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBoundingRectangleVertices(this.m_internalObject);
    }

    public List<PointF> getCaptionBoundingVertices(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, null);
    }

    public List<PointF> getCaptionBoundingVertices(int OplusGLSurfaceView_13, MotionParameters motionParameters) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, motionParameters);
    }

    public boolean isPanoramic() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsPanoramic(this.m_internalObject);
    }

    public void setCenterPolarAngle(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCenterPolarAngle(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getCenterPolarAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterPolarAngle(this.m_internalObject);
    }

    public float getTextCenterPolarAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextCenterPolarAngle(this.m_internalObject);
    }

    public void setCenterAzimuthAngle(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCenterAzimuthAngle(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getCenterAzimuthAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterAzimuthAngle(this.m_internalObject);
    }

    public float getTextCenterAzimuthAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextCenterAzimuthAngle(this.m_internalObject);
    }

    public void setPolarAngleRange(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPolarAngleRange(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPolarAngleRange(this.m_internalObject);
    }

    public float getOrthoAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOrthoAngleRange(this.m_internalObject);
    }

    public float getTextPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextPolarAngleRange(this.m_internalObject);
    }

    public float getTextOrthoAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextOrthoAngleRange(this.m_internalObject);
    }

    public void setPanoramicScaleX(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicScaleX(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getPanoramicScaleX() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicScaleX(this.m_internalObject);
    }

    public void setPanoramicScaleY(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicScaleY(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getPanoramicScaleY() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicScaleY(this.m_internalObject);
    }

    public void setPanoramicRotation(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicRotationAngle(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getPanoramicRotation() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicRotationAngle(this.m_internalObject);
    }

    public void setZValue(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetZValue(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetZValue(this.m_internalObject);
    }
}
