package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimelineCompoundCaption extends com.meicam.sdk.NvsFx {
    public static final int BOUNDING_TYPE_FRAME = 2;
    public static final int BOUNDING_TYPE_TEXT = 0;
    public static final int BOUNDING_TYPE_TEXT_FRAME = 1;

    private native long nativeChangeInPoint(long j_renamed, long j2);

    private native long nativeChangeOutPoint(long j_renamed, long j2);

    private native android.graphics.PointF nativeGetAnchorPoint(long j_renamed);

    private native java.util.List<android.graphics.PointF> nativeGetCaptionBoundingVertices(long j_renamed, int i_renamed, int i2, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters);

    private native int nativeGetCaptionCount(long j_renamed);

    private native android.graphics.PointF nativeGetCaptionTranslation(long j_renamed);

    private native boolean nativeGetClipAffinityEnabled(long j_renamed);

    private native java.util.List<android.graphics.PointF> nativeGetCompoundBoundingVertices(long j_renamed, int i_renamed, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters);

    private native java.lang.String nativeGetFontFamily(long j_renamed, int i_renamed);

    private native long nativeGetInPoint(long j_renamed);

    private native long nativeGetOutPoint(long j_renamed);

    private native float nativeGetRotationZ(long j_renamed);

    private native float nativeGetScaleX(long j_renamed);

    private native float nativeGetScaleY(long j_renamed);

    private native java.lang.String nativeGetText(long j_renamed, int i_renamed);

    private native com.meicam.sdk.NvsColor nativeGetTextColor(long j_renamed, int i_renamed);

    private native float nativeGetZValue(long j_renamed);

    private native void nativeMovePosition(long j_renamed, long j2);

    private native void nativeRotateCaption(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeScaleCaption(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeSetAnchorPoint(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetCaptionTranslation(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetClipAffinityEnabled(long j_renamed, boolean z_renamed);

    private native void nativeSetFontFamily(long j_renamed, int i_renamed, java.lang.String str);

    private native void nativeSetRotationZ(long j_renamed, float f_renamed);

    private native void nativeSetScaleX(long j_renamed, float f_renamed);

    private native void nativeSetScaleY(long j_renamed, float f_renamed);

    private native void nativeSetText(long j_renamed, int i_renamed, java.lang.String str);

    private native void nativeSetTextColor(long j_renamed, int i_renamed, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetZValue(long j_renamed, float f_renamed);

    private native void nativeTranslateCaption(long j_renamed, android.graphics.PointF pointF);

    public int getCaptionCount() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionCount(this.m_internalObject);
    }

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

    public void setText(int i_renamed, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetText(this.m_internalObject, i_renamed, str);
    }

    public java.lang.String getText(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetText(this.m_internalObject, i_renamed);
    }

    public void setFontFamily(int i_renamed, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetFontFamily(this.m_internalObject, i_renamed, str);
    }

    public java.lang.String getFontFamily(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFamily(this.m_internalObject, i_renamed);
    }

    public void setTextColor(int i_renamed, com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetTextColor(this.m_internalObject, i_renamed, nvsColor);
    }

    public com.meicam.sdk.NvsColor getTextColor(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTextColor(this.m_internalObject, i_renamed);
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

    public void rotateCaptionAroundCenter(float f_renamed, int i_renamed) {
        java.util.List<android.graphics.PointF> compoundBoundingVertices = getCompoundBoundingVertices(i_renamed);
        if (compoundBoundingVertices == null || compoundBoundingVertices.size() != 4) {
            return;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            android.graphics.PointF pointF = compoundBoundingVertices.get(i2);
            f2 += pointF.x_renamed;
            f3 += pointF.y_renamed;
        }
        rotateCaption(f_renamed, new android.graphics.PointF(f2 / 4.0f, f3 / 4.0f));
    }

    public java.util.List<android.graphics.PointF> getCaptionBoundingVertices(int i_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, i_renamed, i2, null);
    }

    public java.util.List<android.graphics.PointF> getCompoundBoundingVertices(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundBoundingVertices(this.m_internalObject, i_renamed, null);
    }

    public java.util.List<android.graphics.PointF> getCaptionBoundingVertices(int i_renamed, int i2, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, i_renamed, i2, motionParameters);
    }

    public java.util.List<android.graphics.PointF> getCompoundBoundingVertices(int i_renamed, com.meicam.sdk.NvsTimelineCaption.MotionParameters motionParameters) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundBoundingVertices(this.m_internalObject, i_renamed, motionParameters);
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
