package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STMobileBodyInfo {
    public long bodyAction;
    public float bodyActionScore;
    public com.sensetime.stmobile.model.STPoint[] contourPoints;
    public int contourPointsCount;
    public float[] contourPointsScore;
    public int id_renamed;
    public com.sensetime.stmobile.model.STPoint[] keyPoints;
    public int keyPointsCount;
    public float[] keyPointsScore;

    public com.sensetime.stmobile.model.STPoint[] getKeyPoints() {
        return this.keyPoints;
    }

    public float[] getKeyPointsScore() {
        return this.keyPointsScore;
    }

    public com.sensetime.stmobile.model.STPoint[] getContourPoints() {
        return this.contourPoints;
    }

    public float[] getContourPointsScore() {
        return this.contourPointsScore;
    }
}
