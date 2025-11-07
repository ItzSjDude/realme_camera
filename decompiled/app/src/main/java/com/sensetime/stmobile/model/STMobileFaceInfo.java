package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STMobileFaceInfo {
    public com.sensetime.stmobile.model.STPoint[] extraFacePoints;
    public int extraFacePointsCount;
    public com.sensetime.stmobile.model.STPoint[] eyeballCenter;
    public int eyeballCenterPointsCount;
    public com.sensetime.stmobile.model.STPoint[] eyeballContour;
    public int eyeballContourPointsCount;
    public com.sensetime.stmobile.model.STMobile106 face106;
    public long faceAction;
    public float leftEyeballScore;
    public float rightEyeballScore;

    public com.sensetime.stmobile.model.STMobile106 getFace() {
        return this.face106;
    }

    public void setFace(com.sensetime.stmobile.model.STMobile106 sTMobile106) {
        this.face106 = sTMobile106;
    }

    public long getFaceAction() {
        return this.faceAction;
    }

    public void setFaceAction(long j_renamed) {
        this.faceAction = j_renamed;
    }

    public int getExtraFacePointsCount() {
        return this.extraFacePointsCount;
    }

    public com.sensetime.stmobile.model.STPoint[] getExtraFacePoints() {
        return this.extraFacePoints;
    }

    public int getEyeballCenterPointsCount() {
        return this.eyeballCenterPointsCount;
    }

    public com.sensetime.stmobile.model.STPoint[] getEyeballCenter() {
        return this.eyeballCenter;
    }

    public int getEyeballContourPointsCount() {
        return this.eyeballContourPointsCount;
    }

    public com.sensetime.stmobile.model.STPoint[] getEyeballContour() {
        return this.eyeballContour;
    }
}
