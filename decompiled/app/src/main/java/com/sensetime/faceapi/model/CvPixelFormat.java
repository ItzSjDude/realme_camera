package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public enum CvPixelFormat {
    GRAY8(0),
    YUV420P(1),
    NV12(2),
    NV21(3),
    BGRA8888(4),
    BGR888(5),
    RGBA8888(6);

    final int nativeInt;
    private static CvPixelFormat[] sImageFormats = {GRAY8, YUV420P, NV12, NV21, BGRA8888, BGR888, RGBA8888};

    CvPixelFormat(int OplusGLSurfaceView_13) {
        this.nativeInt = OplusGLSurfaceView_13;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static CvPixelFormat nativeToConfig(int OplusGLSurfaceView_13) {
        return sImageFormats[OplusGLSurfaceView_13];
    }
}
