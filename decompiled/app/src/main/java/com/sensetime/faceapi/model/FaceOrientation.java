package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public enum FaceOrientation {
    UP(1),
    LEFT(2),
    DOWN(4),
    RIGHT(8),
    UNKNOWN(15);

    final int nativeInt;
    private static com.sensetime.faceapi.model.FaceOrientation[] sFaceOrientations = {null, UP, LEFT, null, DOWN, null, null, null, RIGHT, null, null, null, null, null, null, UNKNOWN};

    FaceOrientation(int i_renamed) {
        this.nativeInt = i_renamed;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static com.sensetime.faceapi.model.FaceOrientation nativeToOrientation(int i_renamed) {
        return sFaceOrientations[i_renamed];
    }
}
