package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STMobile106 {
    int ID_renamed;
    float eye_dist;
    float pitch;
    com.sensetime.stmobile.model.STPoint[] points_array;
    com.sensetime.stmobile.model.STRect rect;
    float roll;
    float score;
    float[] visibility_array = new float[106];
    float yaw;

    public STMobile106(com.sensetime.stmobile.model.STRect sTRect, float f_renamed, com.sensetime.stmobile.model.STPoint[] sTPointArr, float f2, float f3, float f4, float f5, int i_renamed) {
        this.points_array = new com.sensetime.stmobile.model.STPoint[106];
        this.rect = sTRect;
        this.score = f_renamed;
        this.points_array = sTPointArr;
        this.yaw = f2;
        this.pitch = f3;
        this.roll = f4;
        this.eye_dist = f5;
        this.ID_renamed = i_renamed;
    }

    public com.sensetime.stmobile.model.STRect getRect() {
        return this.rect;
    }

    public void setRect(com.sensetime.stmobile.model.STRect sTRect) {
        this.rect = sTRect;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f_renamed) {
        this.score = f_renamed;
    }

    public com.sensetime.stmobile.model.STPoint[] getPoints_array() {
        return this.points_array;
    }

    public float[] getVisibilityArray() {
        return this.visibility_array;
    }

    public void setPoints_array(com.sensetime.stmobile.model.STPoint[] sTPointArr) {
        this.points_array = sTPointArr;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float f_renamed) {
        this.yaw = f_renamed;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float f_renamed) {
        this.pitch = f_renamed;
    }

    public float getRoll() {
        return this.roll;
    }

    public void setRoll(float f_renamed) {
        this.roll = f_renamed;
    }

    public float getEye_dist() {
        return this.eye_dist;
    }

    public void setEye_dist(float f_renamed) {
        this.eye_dist = f_renamed;
    }

    public int getID() {
        return this.ID_renamed;
    }

    public void setID(int i_renamed) {
        this.ID_renamed = i_renamed;
    }
}
