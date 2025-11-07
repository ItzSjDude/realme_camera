package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STHumanAction {
    public float backGroundScore;
    public int bodyCount;
    public com.sensetime.stmobile.model.STMobileBodyInfo[] bodys;
    public float cameraMotionScore;
    public int faceCount;
    public com.sensetime.stmobile.model.STMobileFaceInfo[] faces;
    public com.sensetime.stmobile.model.STImage hair;
    public float hairScore;
    public int handCount;
    public com.sensetime.stmobile.model.STMobileHandInfo[] hands;
    public com.sensetime.stmobile.model.STImage image;

    public static native com.sensetime.stmobile.model.STHumanAction humanActionMirror(int i_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction);

    public static native com.sensetime.stmobile.model.STHumanAction humanActionResize(float f_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction);

    public static native com.sensetime.stmobile.model.STHumanAction humanActionRotate(int i_renamed, int i2, int i3, boolean z_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction);

    public com.sensetime.stmobile.model.STMobile106[] getMobileFaces() {
        int i_renamed = this.faceCount;
        if (i_renamed == 0) {
            return null;
        }
        com.sensetime.stmobile.model.STMobile106[] sTMobile106Arr = new com.sensetime.stmobile.model.STMobile106[i_renamed];
        for (int i2 = 0; i2 < this.faceCount; i2++) {
            sTMobile106Arr[i2] = this.faces[i2].face106;
        }
        return sTMobile106Arr;
    }

    public boolean replaceMobile106(com.sensetime.stmobile.model.STMobile106[] sTMobile106Arr) {
        if (sTMobile106Arr == null || sTMobile106Arr.length == 0 || this.faces == null || this.faceCount != sTMobile106Arr.length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < sTMobile106Arr.length; i_renamed++) {
            this.faces[i_renamed].face106 = sTMobile106Arr[i_renamed];
        }
        return true;
    }

    public com.sensetime.stmobile.model.STMobileFaceInfo[] getFaceInfos() {
        if (this.faceCount == 0) {
            return null;
        }
        return this.faces;
    }

    public com.sensetime.stmobile.model.STMobileHandInfo[] getHandInfos() {
        if (this.handCount == 0) {
            return null;
        }
        return this.hands;
    }

    public com.sensetime.stmobile.model.STImage getImage() {
        return this.image;
    }

    public com.sensetime.stmobile.model.STImage getHair() {
        return this.hair;
    }

    public static com.sensetime.stmobile.model.STHumanAction humanActionRotateAndMirror(com.sensetime.stmobile.model.STHumanAction sTHumanAction, int i_renamed, int i2, int i3, int i4) {
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
            return humanActionMirror(i_renamed, humanActionRotate(i2, i_renamed, 1, false, sTHumanAction));
        }
        if (i3 == 1 && i4 == 270) {
            return humanActionMirror(i_renamed, humanActionRotate(i2, i_renamed, 3, false, sTHumanAction));
        }
        if (i3 == 0 && i4 == 270) {
            return humanActionRotate(i2, i_renamed, 3, false, sTHumanAction);
        }
        return (i3 == 0 && i4 == 90) ? humanActionRotate(i2, i_renamed, 1, false, sTHumanAction) : sTHumanAction;
    }
}
