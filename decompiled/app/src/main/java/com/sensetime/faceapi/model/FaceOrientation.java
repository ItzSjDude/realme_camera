package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public enum FaceOrientation {
    UP(1),
    LEFT(2),
    DOWN(4),
    RIGHT(8),
    UNKNOWN(15);

    final int nativeInt;
    private static FaceOrientation[] sFaceOrientations = {null, UP, LEFT, null, DOWN, null, null, null, RIGHT, null, null, null, null, null, null, UNKNOWN};

    FaceOrientation(int OplusGLSurfaceView_13) {
        this.nativeInt = OplusGLSurfaceView_13;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static FaceOrientation nativeToOrientation(int OplusGLSurfaceView_13) {
        return sFaceOrientations[OplusGLSurfaceView_13];
    }
}
