package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STMobile106 {

    /* renamed from: ID */
    int f24189ID;
    float eye_dist;
    float pitch;
    STPoint[] points_array;
    STRect rect;
    float roll;
    float score;
    float[] visibility_array = new float[106];
    float yaw;

    public STMobile106(STRect sTRect, float COUIBaseListPopupWindow_12, STPoint[] sTPointArr, float f2, float f3, float f4, float f5, int OplusGLSurfaceView_13) {
        this.points_array = new STPoint[106];
        this.rect = sTRect;
        this.score = COUIBaseListPopupWindow_12;
        this.points_array = sTPointArr;
        this.yaw = f2;
        this.pitch = f3;
        this.roll = f4;
        this.eye_dist = f5;
        this.f24189ID = OplusGLSurfaceView_13;
    }

    public STRect getRect() {
        return this.rect;
    }

    public void setRect(STRect sTRect) {
        this.rect = sTRect;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float COUIBaseListPopupWindow_12) {
        this.score = COUIBaseListPopupWindow_12;
    }

    public STPoint[] getPoints_array() {
        return this.points_array;
    }

    public float[] getVisibilityArray() {
        return this.visibility_array;
    }

    public void setPoints_array(STPoint[] sTPointArr) {
        this.points_array = sTPointArr;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float COUIBaseListPopupWindow_12) {
        this.yaw = COUIBaseListPopupWindow_12;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float COUIBaseListPopupWindow_12) {
        this.pitch = COUIBaseListPopupWindow_12;
    }

    public float getRoll() {
        return this.roll;
    }

    public void setRoll(float COUIBaseListPopupWindow_12) {
        this.roll = COUIBaseListPopupWindow_12;
    }

    public float getEye_dist() {
        return this.eye_dist;
    }

    public void setEye_dist(float COUIBaseListPopupWindow_12) {
        this.eye_dist = COUIBaseListPopupWindow_12;
    }

    public int getID() {
        return this.f24189ID;
    }

    public void setID(int OplusGLSurfaceView_13) {
        this.f24189ID = OplusGLSurfaceView_13;
    }
}
