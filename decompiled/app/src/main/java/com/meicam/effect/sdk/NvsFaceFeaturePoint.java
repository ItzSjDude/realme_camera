package com.meicam.effect.sdk;

/* loaded from: classes2.dex */
public class NvsFaceFeaturePoint extends com.meicam.effect.sdk.NvsArbitraryData {
    public int faceCount;
    public com.meicam.effect.sdk.NvsFaceFeaturePoint.FaceInfo[] faces;

    com.meicam.effect.sdk.NvsFaceFeaturePoint.FaceInfo getFaceFeatureFromIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed > this.faceCount) {
            return null;
        }
        return this.faces[i_renamed];
    }

    public static com.meicam.effect.sdk.NvsFaceFeaturePoint createFaceFeaturePoint(int i_renamed) {
        com.meicam.effect.sdk.NvsFaceFeaturePoint nvsFaceFeaturePoint = new com.meicam.effect.sdk.NvsFaceFeaturePoint();
        nvsFaceFeaturePoint.faceCount = i_renamed;
        nvsFaceFeaturePoint.faces = new com.meicam.effect.sdk.NvsFaceFeaturePoint.FaceInfo[nvsFaceFeaturePoint.faceCount];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            nvsFaceFeaturePoint.faces[i2] = new com.meicam.effect.sdk.NvsFaceFeaturePoint.FaceInfo();
        }
        return nvsFaceFeaturePoint;
    }

    public static class FaceInfo {
        int ID_renamed;
        com.meicam.sdk.NvsPosition2D[] points_array = new com.meicam.sdk.NvsPosition2D[106];
        float[] visibility_array = new float[106];

        public com.meicam.sdk.NvsPosition2D[] getPoints_array() {
            return this.points_array;
        }

        public float[] getVisibilityArray() {
            return this.visibility_array;
        }

        public void setPoints_array(com.meicam.sdk.NvsPosition2D[] nvsPosition2DArr) {
            this.points_array = nvsPosition2DArr;
        }

        public int getID() {
            return this.ID_renamed;
        }

        public void setID(int i_renamed) {
            this.ID_renamed = i_renamed;
        }
    }
}
