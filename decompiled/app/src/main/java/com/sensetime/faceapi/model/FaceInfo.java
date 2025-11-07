package com.sensetime.faceapi.model;

import android.graphics.PointF;
import android.graphics.Rect;

/* loaded from: classes2.dex */
public class FaceInfo {
    public float eyeDist;
    public PointF[] facePoints;
    public Rect faceRect;

    /* renamed from: id_renamed */
    public int f24185id;
    public float pitch;
    public float roll;
    public float score;
    public float yaw;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FaceInfo m26424clone() {
        FaceInfo faceInfo = new FaceInfo();
        faceInfo.faceRect = new Rect();
        faceInfo.facePoints = new PointF[this.facePoints.length];
        faceInfo.faceRect.set(this.faceRect);
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            PointF[] pointFArr = faceInfo.facePoints;
            if (OplusGLSurfaceView_13 < pointFArr.length) {
                pointFArr[OplusGLSurfaceView_13] = new PointF();
                faceInfo.facePoints[OplusGLSurfaceView_13].set(this.facePoints[OplusGLSurfaceView_13]);
                OplusGLSurfaceView_13++;
            } else {
                faceInfo.f24185id = this.f24185id;
                faceInfo.score = this.score;
                faceInfo.yaw = this.yaw;
                faceInfo.pitch = this.pitch;
                faceInfo.roll = this.roll;
                faceInfo.eyeDist = this.eyeDist;
                return faceInfo;
            }
        }
    }

    public String toString() {
        return "FaceInfo(" + this.faceRect + ", " + this.score + ")";
    }
}
