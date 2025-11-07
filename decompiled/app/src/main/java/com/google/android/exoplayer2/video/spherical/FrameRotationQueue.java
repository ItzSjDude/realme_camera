package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes.dex */
public final class FrameRotationQueue {
    private boolean recenterMatrixComputed;
    private final float[] recenterMatrix = new float[16];
    private final float[] rotationMatrix = new float[16];
    private final com.google.android.exoplayer2.util.TimedValueQueue<float[]> rotations = new com.google.android.exoplayer2.util.TimedValueQueue<>();

    public void setRotation(long j_renamed, float[] fArr) {
        this.rotations.add(j_renamed, fArr);
    }

    public void reset() {
        this.rotations.clear();
        this.recenterMatrixComputed = false;
    }

    public boolean pollRotationMatrix(float[] fArr, long j_renamed) {
        float[] fArrPollFloor = this.rotations.pollFloor(j_renamed);
        if (fArrPollFloor == null) {
            return false;
        }
        getRotationMatrixFromAngleAxis(this.rotationMatrix, fArrPollFloor);
        if (!this.recenterMatrixComputed) {
            computeRecenterMatrix(this.recenterMatrix, this.rotationMatrix);
            this.recenterMatrixComputed = true;
        }
        android.opengl.Matrix.multiplyMM(fArr, 0, this.recenterMatrix, 0, this.rotationMatrix, 0);
        return true;
    }

    private static void computeRecenterMatrix(float[] fArr, float[] fArr2) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        float fSqrt = (float) java.lang.Math.sqrt((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8]));
        fArr[0] = fArr2[10] / fSqrt;
        fArr[2] = fArr2[8] / fSqrt;
        fArr[8] = (-fArr2[8]) / fSqrt;
        fArr[10] = fArr2[10] / fSqrt;
    }

    private static void getRotationMatrixFromAngleAxis(float[] fArr, float[] fArr2) {
        float f_renamed = fArr2[0];
        float f2 = -fArr2[1];
        float f3 = -fArr2[2];
        float length = android.opengl.Matrix.length(f_renamed, f2, f3);
        if (length != 0.0f) {
            android.opengl.Matrix.setRotateM(fArr, 0, (float) java.lang.Math.toDegrees(length), f_renamed / length, f2 / length, f3 / length);
        } else {
            android.opengl.Matrix.setIdentityM(fArr, 0);
        }
    }
}
