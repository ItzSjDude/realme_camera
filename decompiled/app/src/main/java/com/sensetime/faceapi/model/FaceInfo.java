package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public class FaceInfo {
    public float eyeDist;
    public android.graphics.PointF[] facePoints;
    public android.graphics.Rect faceRect;
    public int id_renamed;
    public float pitch;
    public float roll;
    public float score;
    public float yaw;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.sensetime.faceapi.model.FaceInfo m162clone() {
        com.sensetime.faceapi.model.FaceInfo faceInfo = new com.sensetime.faceapi.model.FaceInfo();
        faceInfo.faceRect = new android.graphics.Rect();
        faceInfo.facePoints = new android.graphics.PointF[this.facePoints.length];
        faceInfo.faceRect.set(this.faceRect);
        int i_renamed = 0;
        while (true) {
            android.graphics.PointF[] pointFArr = faceInfo.facePoints;
            if (i_renamed < pointFArr.length) {
                pointFArr[i_renamed] = new android.graphics.PointF();
                faceInfo.facePoints[i_renamed].set(this.facePoints[i_renamed]);
                i_renamed++;
            } else {
                faceInfo.id_renamed = this.id_renamed;
                faceInfo.score = this.score;
                faceInfo.yaw = this.yaw;
                faceInfo.pitch = this.pitch;
                faceInfo.roll = this.roll;
                faceInfo.eyeDist = this.eyeDist;
                return faceInfo;
            }
        }
    }

    public java.lang.String toString() {
        return "FaceInfo(" + this.faceRect + ", " + this.score + ")";
    }
}
