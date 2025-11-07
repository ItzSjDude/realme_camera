package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsPaintingEffectContext {
    public static final int STROKE_ANALOG_TYPE_COS = 3;
    public static final int STROKE_ANALOG_TYPE_INVERT_COS = 4;
    public static final int STROKE_ANALOG_TYPE_INVERT_SIN = 1;
    public static final int STROKE_ANALOG_TYPE_POSITIVE_COS = 5;
    public static final int STROKE_ANALOG_TYPE_POSITIVE_SIN = 2;
    public static final int STROKE_ANALOG_TYPE_SIN = 0;
    public static final int STROKE_CAP_STYLE_FLAT = 0;
    public static final int STROKE_CAP_STYLE_ITALIC = 3;
    public static final int STROKE_CAP_STYLE_ROUND = 2;
    public static final int STROKE_CAP_STYLE_SQUARE = 1;
    public static final int STROKE_FILL_MODE_GRADIENT = 0;
    public static final int STROKE_FILL_MODE_TEXTURE = 1;
    public static final int STROKE_JOINT_STYLE_BEVEL = 0;
    public static final int STROKE_JOINT_STYLE_MITER = 1;
    public static final int STROKE_JOINT_STYLE_ROUND = 2;
    public static final int STROKE_TEXTURE_WARP_CLAMP = 0;
    public static final int STROKE_TEXTURE_WARP_MIRRORED_REPEAT = 2;
    public static final int STROKE_TEXTURE_WARP_REPEAT = 1;
    private long m_contextInterface;

    private native void nativeAddStroke(long j_renamed, float[] fArr);

    private native void nativeAppendStroke(long j_renamed, float[] fArr);

    private native void nativeCleanup(long j_renamed);

    private native void nativeRemoveAllStroke(long j_renamed);

    private native void nativeRemoveLastStroke(long j_renamed);

    private native void nativeSetStrokeAnalogAmplitude(long j_renamed, float f_renamed);

    private native void nativeSetStrokeAnalogPeriod(long j_renamed, float f_renamed);

    private native void nativeSetStrokeAnalogType(long j_renamed, int i_renamed);

    private native void nativeSetStrokeAnimated(long j_renamed, boolean z_renamed);

    private native void nativeSetStrokeAnimationSpeed(long j_renamed, float f_renamed);

    private native void nativeSetStrokeCapStyle(long j_renamed, int i_renamed);

    private native void nativeSetStrokeFillMode(long j_renamed, int i_renamed);

    private native void nativeSetStrokeGradient(long j_renamed, com.meicam.sdk.NvsColor nvsColor);

    private native void nativeSetStrokeJointStyle(long j_renamed, int i_renamed);

    private native void nativeSetStrokeTextureFilePath(long j_renamed, java.lang.String str);

    private native void nativeSetStrokeTextureRepeatTimes(long j_renamed, int i_renamed, int i2);

    private native void nativeSetStrokeTextureWarpType(long j_renamed, int i_renamed);

    private native void nativeSetStrokeWidth(long j_renamed, float f_renamed);

    public void SetStrokeWidth(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeWidth(this.m_contextInterface, f_renamed);
    }

    public void SetStrokeCapStyle(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeCapStyle(this.m_contextInterface, i_renamed);
    }

    public void SetStrokeJointStyle(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeJointStyle(this.m_contextInterface, i_renamed);
    }

    public void SetStrokeGradient(com.meicam.sdk.NvsColor nvsColor) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeGradient(this.m_contextInterface, nvsColor);
    }

    public void SetStrokeTextureFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureFilePath(this.m_contextInterface, str);
    }

    public void SetStrokeTextureWarpType(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureWarpType(this.m_contextInterface, i_renamed);
    }

    public void SetStrokeTextureRepeatTimes(int i_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureRepeatTimes(this.m_contextInterface, i_renamed, i2);
    }

    public void SetStrokeFillMode(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeFillMode(this.m_contextInterface, i_renamed);
    }

    public void SetStrokeAnimated(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnimated(this.m_contextInterface, z_renamed);
    }

    public void SetStrokeAnimationSpeed(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnimationSpeed(this.m_contextInterface, f_renamed);
    }

    public void SetStrokeAnalogType(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogType(this.m_contextInterface, i_renamed);
    }

    public void SetStrokeAnalogAmplitude(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogAmplitude(this.m_contextInterface, f_renamed);
    }

    public void SetStrokeAnalogPeriod(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogPeriod(this.m_contextInterface, f_renamed);
    }

    public void RemoveAllStroke() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRemoveAllStroke(this.m_contextInterface);
    }

    public void RemoveLastStroke() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRemoveLastStroke(this.m_contextInterface);
    }

    public void AddStroke(float[] fArr) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeAddStroke(this.m_contextInterface, fArr);
    }

    public void AppendStroke(float[] fArr) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeAppendStroke(this.m_contextInterface, fArr);
    }

    protected void setContextInterface(long j_renamed) {
        this.m_contextInterface = j_renamed;
    }

    protected void finalize() throws java.lang.Throwable {
        long j_renamed = this.m_contextInterface;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_contextInterface = 0L;
        }
        super.finalize();
    }
}
