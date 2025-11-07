package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STHumanAction {
    public float backGroundScore;
    public int bodyCount;
    public STMobileBodyInfo[] bodys;
    public float cameraMotionScore;
    public int faceCount;
    public STMobileFaceInfo[] faces;
    public STImage hair;
    public float hairScore;
    public int handCount;
    public STMobileHandInfo[] hands;
    public STImage image;

    public static native STHumanAction humanActionMirror(int OplusGLSurfaceView_13, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionResize(float COUIBaseListPopupWindow_12, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionRotate(int OplusGLSurfaceView_13, int i2, int i3, boolean z, STHumanAction sTHumanAction);

    public STMobile106[] getMobileFaces() {
        int OplusGLSurfaceView_13 = this.faceCount;
        if (OplusGLSurfaceView_13 == 0) {
            return null;
        }
        STMobile106[] sTMobile106Arr = new STMobile106[OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < this.faceCount; i2++) {
            sTMobile106Arr[i2] = this.faces[i2].face106;
        }
        return sTMobile106Arr;
    }

    public boolean replaceMobile106(STMobile106[] sTMobile106Arr) {
        if (sTMobile106Arr == null || sTMobile106Arr.length == 0 || this.faces == null || this.faceCount != sTMobile106Arr.length) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sTMobile106Arr.length; OplusGLSurfaceView_13++) {
            this.faces[OplusGLSurfaceView_13].face106 = sTMobile106Arr[OplusGLSurfaceView_13];
        }
        return true;
    }

    public STMobileFaceInfo[] getFaceInfos() {
        if (this.faceCount == 0) {
            return null;
        }
        return this.faces;
    }

    public STMobileHandInfo[] getHandInfos() {
        if (this.handCount == 0) {
            return null;
        }
        return this.hands;
    }

    public STImage getImage() {
        return this.image;
    }

    public STImage getHair() {
        return this.hair;
    }

    public static STHumanAction humanActionRotateAndMirror(STHumanAction sTHumanAction, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (sTHumanAction == null) {
            return null;
        }
        if (i3 != 1 && i3 != 0) {
            return sTHumanAction;
        }
        if (i4 != 90 && i4 != 270) {
            return sTHumanAction;
        }
        if (i3 == 1 && i4 == 90) {
            return humanActionMirror(OplusGLSurfaceView_13, humanActionRotate(i2, OplusGLSurfaceView_13, 1, false, sTHumanAction));
        }
        if (i3 == 1 && i4 == 270) {
            return humanActionMirror(OplusGLSurfaceView_13, humanActionRotate(i2, OplusGLSurfaceView_13, 3, false, sTHumanAction));
        }
        if (i3 == 0 && i4 == 270) {
            return humanActionRotate(i2, OplusGLSurfaceView_13, 3, false, sTHumanAction);
        }
        return (i3 == 0 && i4 == 90) ? humanActionRotate(i2, OplusGLSurfaceView_13, 1, false, sTHumanAction) : sTHumanAction;
    }
}
