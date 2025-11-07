package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimelineCaption extends com.meicam.sdk.NvsFx {
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

    private native boolean nativeApplyCaptionStyle(long j_renamed, java.lang.String str, int i_renamed);

    private native long nativeChangeInPoint(long j_renamed, long j2);

    private native long nativeChangeOutPoint(long j_renamed, long j2);

    private native android.graphics.PointF nativeGetAnchorPoint(long j_renamed);

    private native boolean nativeGetBold(long j_renamed);

    private native java.util.List<android.graphics.PointF> nativeGetBoundingRectangleVertices(long j_renamed);

    private native java.util.List<android.graphics.PointF> nativeGetCaptionBoundingVertices(long j_renamed, int i_renamed, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters);

    private native java.lang.String nativeGetCaptionStylePackageId(long j_renamed);

    private native android.graphics.PointF nativeGetCaptionTranslation(long j_renamed);

    private native int nativeGetCategory(long j_renamed);

    private native float nativeGetCenterAzimuthAngle(long j_renamed);

    private native float nativeGetCenterPolarAngle(long j_renamed);

    private native boolean nativeGetClipAffinityEnabled(long j_renamed);

    private native boolean nativeGetDrawOutline(long j_renamed);

    private native boolean nativeGetDrawShadow(long j_renamed);

    private native java.lang.String nativeGetFontFamily(long j_renamed);

    private native java.lang.String nativeGetFontFilePath(long j_renamed);

    private native float nativeGetFontSize(long j_renamed);

    private native long nativeGetInPoint(long j_renamed);

    private native boolean nativeGetItalic(long j_renamed);

    private native float nativeGetLetterSpacing(long j_renamed);

    private native float nativeGetOrthoAngleRange(long j_renamed);

    private native long nativeGetOutPoint(long j_renamed);

    private native com.meicam.sdk.NvsColor nativeGetOutlineColor(long j_renamed);

    private native float nativeGetOutlineWidth(long j_renamed);

    private native float nativeGetPanoramicRotationAngle(long j_renamed);

    private native float nativeGetPanoramicScaleX(long j_renamed);

    private native float nativeGetPanoramicScaleY(long j_renamed);

    private native float nativeGetPolarAngleRange(long j_renamed);

    private native int nativeGetRoleInTheme(long j_renamed);

    private native float nativeGetRotationZ(long j_renamed);

    private native float nativeGetScaleX(long j_renamed);

    private native float nativeGetScaleY(long j_renamed);

    private native com.meicam.sdk.NvsColor nativeGetShadowColor(long j_renamed);

    private native float nativeGetShadowFeather(long j_renamed);

    private native android.graphics.PointF nativeGetShadowOffset(long j_renamed);

    private native java.lang.String nativeGetText(long j_renamed);

    private native int nativeGetTextAlignment(long j_renamed);

    private native android.graphics.RectF nativeGetTextBoundingRect(long j_renamed);

    private native float nativeGetTextCenterAzimuthAngle(long j_renamed);

    private native float nativeGetTextCenterPolarAngle(long j_renamed);

    private native com.meicam.sdk.NvsColor nativeGetTextColor(long j_renamed);

    private native float nativeGetTextOrthoAngleRange(long j_renamed);

    private native float nativeGetTextPolarAngleRange(long j_renamed);

    private native int nativeGetWeight(long j_renamed);

    private native float nativeGetZValue(long j_renamed);

    private native boolean nativeIsPanoramic(long j_renamed);

    private native void nativeMovePosition(long j_renamed, long j2);

    private native void nativeRotateCaption(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeScaleCaption(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeSetAnchorPoint(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetBold(long j_renamed, boolean z_renamed);

    private native void nativeSetCaptionTranslation(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetCenterAzimuthAngle(long j_renamed, float f_renamed);

    private native void nativeSetCenterPolarAngle(long j_renamed, float f_renamed);

    private native void nativeSetClipAffinityEnabled(long j_renamed, boolean z_renamed);

    private native void nativeSetDrawOutline(long j_renamed, boolean z_renamed);

    private native void nativeSetDrawShadow(long j_renamed, boolean z_renamed);

    private native void nativeSetFontByFilePath(long j_renamed, java.lang.String str);

    private native void nativeSetFontFamily(long j_renamed, java.lang.String str);

    private native void nativeSetFontSize(long j_renamed, float f_renamed);

    private native void nativeSetItalic(long j_renamed, boolean z_renamed);

    private native void nativeSetLetterSpacing(long j_renamed, float f_renamed);

    private native void nativeSetOutlineColor(long j_renamed, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetOutlineWidth(long j_renamed, float f_renamed);

    private native void nativeSetPanoramicRotationAngle(long j_renamed, float f_renamed);

    private native void nativeSetPanoramicScaleX(long j_renamed, float f_renamed);

    private native void nativeSetPanoramicScaleY(long j_renamed, float f_renamed);

    private native void nativeSetPolarAngleRange(long j_renamed, float f_renamed);

    private native void nativeSetRotationZ(long j_renamed, float f_renamed);

    private native void nativeSetScaleX(long j_renamed, float f_renamed);

    private native void nativeSetScaleY(long j_renamed, float f_renamed);

    private native void nativeSetShadowColor(long j_renamed, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetShadowFeather(long j_renamed, float f_renamed);

    private native void nativeSetShadowOffset(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetText(long j_renamed, java.lang.String str);

    private native void nativeSetTextAlignment(long j_renamed, int i_renamed);

    private native void nativeSetTextColor(long j_renamed, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetWeight(long j_renamed, int i_renamed);

    private native void nativeSetZValue(long j_renamed, float f_renamed);

    private native void nativeTranslateCaption(long j_renamed, android.graphics.PointF pointF);

    public void setClipAffinityEnabled(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetClipAffinityEnabled(this.m_internalObject, z_renamed);
    }

    public boolean getClipAffinityEnabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipAffinityEnabled(this.m_internalObject);
    }

    public long getInPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public long changeInPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, j_renamed);
    }

    public long changeOutPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, j_renamed);
    }

    public void movePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, j_renamed);
    }

    public int getRoleInTheme() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetRoleInTheme(this.m_internalObject);
    }

    public int getCategory() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCategory(this.m_internalObject);
    }

    public java.lang.String getCaptionStylePackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionStylePackageId(this.m_internalObject);
    }

    public boolean applyCaptionStyle(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptionStyle(this.m_internalObject, str, 1);
    }

    public boolean applyCaptionStyle(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptionStyle(this.m_internalObject, str, i_renamed);
    }

    public void setText(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetText(this.m_internalObject, str);
    }

    public java.lang.String getText() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetText(this.m_internalObject);
    }

    public void setTextAlignment(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetTextAlignment(this.m_internalObject, i_renamed);
    }

    public int getTextAlignment() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextAlignment(this.m_internalObject);
    }

    public void setBold(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetBold(this.m_internalObject, z_renamed);
    }

    public boolean getBold() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBold(this.m_internalObject);
    }

    public void setWeight(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetWeight(this.m_internalObject, i_renamed);
    }

    public int getWeight() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetWeight(this.m_internalObject);
    }

    public void setItalic(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetItalic(this.m_internalObject, z_renamed);
    }

    public boolean getItalic() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetItalic(this.m_internalObject);
    }

    public void setLetterSpacing(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetLetterSpacing(this.m_internalObject, f_renamed);
    }

    public float getLetterSpacing() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetLetterSpacing(this.m_internalObject);
    }

    public void setTextColor(com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetTextColor(this.m_internalObject, nvsColor);
    }

    public com.meicam.sdk.NvsColor getTextColor() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextColor(this.m_internalObject);
    }

    public void setDrawOutline(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetDrawOutline(this.m_internalObject, z_renamed);
    }

    public boolean getDrawOutline() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDrawOutline(this.m_internalObject);
    }

    public void setOutlineColor(com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetOutlineColor(this.m_internalObject, nvsColor);
    }

    public com.meicam.sdk.NvsColor getOutlineColor() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutlineColor(this.m_internalObject);
    }

    public void setOutlineWidth(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetOutlineWidth(this.m_internalObject, f_renamed);
    }

    public float getOutlineWidth() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutlineWidth(this.m_internalObject);
    }

    public void setDrawShadow(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetDrawShadow(this.m_internalObject, z_renamed);
    }

    public boolean getDrawShadow() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDrawShadow(this.m_internalObject);
    }

    public void setShadowColor(com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetShadowColor(this.m_internalObject, nvsColor);
    }

    public com.meicam.sdk.NvsColor getShadowColor() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowColor(this.m_internalObject);
    }

    public void setShadowOffset(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetShadowOffset(this.m_internalObject, pointF);
    }

    public android.graphics.PointF getShadowOffset() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowOffset(this.m_internalObject);
    }

    public void setShadowFeather(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetShadowFeather(this.m_internalObject, f_renamed);
    }

    public float getShadowFeather() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetShadowFeather(this.m_internalObject);
    }

    public void setFontSize(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFontSize(this.m_internalObject, f_renamed);
    }

    public float getFontSize() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFontSize(this.m_internalObject);
    }

    public void setFontByFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFontByFilePath(this.m_internalObject, str);
    }

    public java.lang.String getFontFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFilePath(this.m_internalObject);
    }

    public void setFontFamily(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFontFamily(this.m_internalObject, str);
    }

    public java.lang.String getFontFamily() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFamily(this.m_internalObject);
    }

    public void setCaptionTranslation(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCaptionTranslation(this.m_internalObject, pointF);
    }

    public android.graphics.PointF getCaptionTranslation() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionTranslation(this.m_internalObject);
    }

    public void translateCaption(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeTranslateCaption(this.m_internalObject, pointF);
    }

    public void setAnchorPoint(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetAnchorPoint(this.m_internalObject, pointF);
    }

    public android.graphics.PointF getAnchorPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAnchorPoint(this.m_internalObject);
    }

    public void setScaleX(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetScaleX(this.m_internalObject, f_renamed);
    }

    public float getScaleX() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleX(this.m_internalObject);
    }

    public void setScaleY(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetScaleY(this.m_internalObject, f_renamed);
    }

    public float getScaleY() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleY(this.m_internalObject);
    }

    public void scaleCaption(float f_renamed, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeScaleCaption(this.m_internalObject, f_renamed, pointF);
    }

    public void setRotationZ(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetRotationZ(this.m_internalObject, f_renamed);
    }

    public float getRotationZ() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetRotationZ(this.m_internalObject);
    }

    public void rotateCaption(float f_renamed, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRotateCaption(this.m_internalObject, f_renamed, pointF);
    }

    public void rotateCaption(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        android.graphics.RectF textBoundingRect = getTextBoundingRect();
        rotateCaption(f_renamed, new android.graphics.PointF((textBoundingRect.left + textBoundingRect.right) / 2.0f, (textBoundingRect.top + textBoundingRect.bottom) / 2.0f));
    }

    public android.graphics.RectF getTextBoundingRect() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextBoundingRect(this.m_internalObject);
    }

    public java.util.List<android.graphics.PointF> getBoundingRectangleVertices() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBoundingRectangleVertices(this.m_internalObject);
    }

    public java.util.List<android.graphics.PointF> getCaptionBoundingVertices(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, i_renamed, null);
    }

    public java.util.List<android.graphics.PointF> getCaptionBoundingVertices(int i_renamed, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, i_renamed, motionParameters);
    }

    public boolean isPanoramic() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsPanoramic(this.m_internalObject);
    }

    public void setCenterPolarAngle(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCenterPolarAngle(this.m_internalObject, f_renamed);
    }

    public float getCenterPolarAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterPolarAngle(this.m_internalObject);
    }

    public float getTextCenterPolarAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextCenterPolarAngle(this.m_internalObject);
    }

    public void setCenterAzimuthAngle(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCenterAzimuthAngle(this.m_internalObject, f_renamed);
    }

    public float getCenterAzimuthAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterAzimuthAngle(this.m_internalObject);
    }

    public float getTextCenterAzimuthAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextCenterAzimuthAngle(this.m_internalObject);
    }

    public void setPolarAngleRange(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPolarAngleRange(this.m_internalObject, f_renamed);
    }

    public float getPolarAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPolarAngleRange(this.m_internalObject);
    }

    public float getOrthoAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOrthoAngleRange(this.m_internalObject);
    }

    public float getTextPolarAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextPolarAngleRange(this.m_internalObject);
    }

    public float getTextOrthoAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextOrthoAngleRange(this.m_internalObject);
    }

    public void setPanoramicScaleX(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicScaleX(this.m_internalObject, f_renamed);
    }

    public float getPanoramicScaleX() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicScaleX(this.m_internalObject);
    }

    public void setPanoramicScaleY(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicScaleY(this.m_internalObject, f_renamed);
    }

    public float getPanoramicScaleY() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicScaleY(this.m_internalObject);
    }

    public void setPanoramicRotation(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPanoramicRotationAngle(this.m_internalObject, f_renamed);
    }

    public float getPanoramicRotation() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPanoramicRotationAngle(this.m_internalObject);
    }

    public void setZValue(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetZValue(this.m_internalObject, f_renamed);
    }

    public float getZValue() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetZValue(this.m_internalObject);
    }
}
