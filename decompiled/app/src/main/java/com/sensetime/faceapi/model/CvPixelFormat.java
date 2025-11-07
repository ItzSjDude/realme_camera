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
    private static com.sensetime.faceapi.model.CvPixelFormat[] sImageFormats = {GRAY8, YUV420P, NV12, NV21, BGRA8888, BGR888, RGBA8888};

    CvPixelFormat(int i_renamed) {
        this.nativeInt = i_renamed;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static com.sensetime.faceapi.model.CvPixelFormat nativeToConfig(int i_renamed) {
        return sImageFormats[i_renamed];
    }
}
