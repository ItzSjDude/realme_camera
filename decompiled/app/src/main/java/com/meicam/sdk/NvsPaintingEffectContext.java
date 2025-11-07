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

    private native void nativeAddStroke(long OplusGLSurfaceView_15, float[] fArr);

    private native void nativeAppendStroke(long OplusGLSurfaceView_15, float[] fArr);

    private native void nativeCleanup(long OplusGLSurfaceView_15);

    private native void nativeRemoveAllStroke(long OplusGLSurfaceView_15);

    private native void nativeRemoveLastStroke(long OplusGLSurfaceView_15);

    private native void nativeSetStrokeAnalogAmplitude(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetStrokeAnalogPeriod(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetStrokeAnalogType(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStrokeAnimated(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetStrokeAnimationSpeed(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetStrokeCapStyle(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStrokeFillMode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStrokeGradient(long OplusGLSurfaceView_15, NvsColor nvsColor);

    private native void nativeSetStrokeJointStyle(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStrokeTextureFilePath(long OplusGLSurfaceView_15, String str);

    private native void nativeSetStrokeTextureRepeatTimes(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native void nativeSetStrokeTextureWarpType(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStrokeWidth(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    public void SetStrokeWidth(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeWidth(this.m_contextInterface, COUIBaseListPopupWindow_12);
    }

    public void SetStrokeCapStyle(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeCapStyle(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void SetStrokeJointStyle(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeJointStyle(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void SetStrokeGradient(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeGradient(this.m_contextInterface, nvsColor);
    }

    public void SetStrokeTextureFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureFilePath(this.m_contextInterface, str);
    }

    public void SetStrokeTextureWarpType(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureWarpType(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void SetStrokeTextureRepeatTimes(int OplusGLSurfaceView_13, int i2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeTextureRepeatTimes(this.m_contextInterface, OplusGLSurfaceView_13, i2);
    }

    public void SetStrokeFillMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeFillMode(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void SetStrokeAnimated(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnimated(this.m_contextInterface, z);
    }

    public void SetStrokeAnimationSpeed(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnimationSpeed(this.m_contextInterface, COUIBaseListPopupWindow_12);
    }

    public void SetStrokeAnalogType(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogType(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void SetStrokeAnalogAmplitude(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogAmplitude(this.m_contextInterface, COUIBaseListPopupWindow_12);
    }

    public void SetStrokeAnalogPeriod(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStrokeAnalogPeriod(this.m_contextInterface, COUIBaseListPopupWindow_12);
    }

    public void RemoveAllStroke() {
        NvsUtils.checkFunctionInMainThread();
        nativeRemoveAllStroke(this.m_contextInterface);
    }

    public void RemoveLastStroke() {
        NvsUtils.checkFunctionInMainThread();
        nativeRemoveLastStroke(this.m_contextInterface);
    }

    public void AddStroke(float[] fArr) {
        NvsUtils.checkFunctionInMainThread();
        nativeAddStroke(this.m_contextInterface, fArr);
    }

    public void AppendStroke(float[] fArr) {
        NvsUtils.checkFunctionInMainThread();
        nativeAppendStroke(this.m_contextInterface, fArr);
    }

    protected void setContextInterface(long OplusGLSurfaceView_15) {
        this.m_contextInterface = OplusGLSurfaceView_15;
    }

    protected void finalize() throws Throwable {
        long OplusGLSurfaceView_15 = this.m_contextInterface;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_contextInterface = 0L;
        }
        super.finalize();
    }
}
