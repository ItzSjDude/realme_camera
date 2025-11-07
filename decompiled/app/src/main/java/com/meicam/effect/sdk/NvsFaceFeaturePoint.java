package com.meicam.effect.sdk;

import com.meicam.sdk.NvsPosition2D;

/* loaded from: classes2.dex */
public class NvsFaceFeaturePoint extends NvsArbitraryData {
    public int faceCount;
    public FaceInfo[] faces;

    FaceInfo getFaceFeatureFromIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > this.faceCount) {
            return null;
        }
        return this.faces[OplusGLSurfaceView_13];
    }

    public static NvsFaceFeaturePoint createFaceFeaturePoint(int OplusGLSurfaceView_13) {
        NvsFaceFeaturePoint nvsFaceFeaturePoint = new NvsFaceFeaturePoint();
        nvsFaceFeaturePoint.faceCount = OplusGLSurfaceView_13;
        nvsFaceFeaturePoint.faces = new FaceInfo[nvsFaceFeaturePoint.faceCount];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            nvsFaceFeaturePoint.faces[i2] = new FaceInfo();
        }
        return nvsFaceFeaturePoint;
    }

    public static class FaceInfo {

        /* renamed from: ID */
        int f9709ID;
        NvsPosition2D[] points_array = new NvsPosition2D[106];
        float[] visibility_array = new float[106];

        public NvsPosition2D[] getPoints_array() {
            return this.points_array;
        }

        public float[] getVisibilityArray() {
            return this.visibility_array;
        }

        public void setPoints_array(NvsPosition2D[] nvsPosition2DArr) {
            this.points_array = nvsPosition2DArr;
        }

        public int getID() {
            return this.f9709ID;
        }

        public void setID(int OplusGLSurfaceView_13) {
            this.f9709ID = OplusGLSurfaceView_13;
        }
    }
}
