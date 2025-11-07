package com.sensetime.faceapi.utils;

/* loaded from: classes2.dex */
public class FaceRotationUtil {
    public static void rotateFaceInfos(com.sensetime.faceapi.model.FaceInfo[] faceInfoArr, int i_renamed, int i2, boolean z_renamed, int i3) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return;
        }
        for (com.sensetime.faceapi.model.FaceInfo faceInfo : faceInfoArr) {
            rotateFaceInfo(faceInfo, i_renamed, i2, z_renamed, i3);
        }
    }

    public static void rotateFaceInfo(com.sensetime.faceapi.model.FaceInfo faceInfo, int i_renamed, int i2, boolean z_renamed, int i3) {
        if (faceInfo == null) {
            return;
        }
        rotateFaceRect(faceInfo.faceRect, i_renamed, i2, z_renamed, i3);
        for (android.graphics.PointF pointF : faceInfo.facePoints) {
            rotatePoints(pointF, i_renamed, i2, z_renamed, i3);
        }
    }

    public static android.graphics.Rect rotateFaceRect(android.graphics.Rect rect, int i_renamed, int i2, boolean z_renamed, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                int i4 = rect.left;
                rect.left = i2 - rect.bottom;
                rect.bottom = rect.right;
                rect.right = i2 - rect.top;
                rect.top = i4;
                if (z_renamed) {
                    int i5 = rect.top;
                    rect.top = i_renamed - rect.bottom;
                    rect.bottom = i_renamed - i5;
                }
            } else if (i3 == 180) {
                rect.top = i2 - rect.top;
                rect.bottom = i2 - rect.bottom;
                if (!z_renamed) {
                    rect.left = i_renamed - rect.left;
                    rect.right = i_renamed - rect.right;
                }
            } else if (i3 == 270) {
                int i6 = rect.left;
                rect.left = i2 - rect.bottom;
                rect.bottom = rect.right;
                rect.right = i2 - rect.top;
                rect.top = i6;
                int i7 = rect.left;
                rect.left = i2 - rect.right;
                rect.right = i2 - i7;
                if (!z_renamed) {
                    int i8 = rect.top;
                    rect.top = i_renamed - rect.bottom;
                    rect.bottom = i_renamed - i8;
                }
            }
        } else if (z_renamed) {
            rect.left = i_renamed - rect.left;
            rect.right = i_renamed - rect.right;
        }
        return rect;
    }

    public static android.graphics.PointF rotatePoints(android.graphics.PointF pointF, int i_renamed, int i2, boolean z_renamed, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                float f_renamed = pointF.x_renamed;
                pointF.x_renamed = i2 - pointF.y_renamed;
                pointF.y_renamed = f_renamed;
                if (z_renamed) {
                    pointF.y_renamed = i_renamed - pointF.y_renamed;
                }
            } else if (i3 == 180) {
                pointF.y_renamed = i2 - pointF.y_renamed;
                if (!z_renamed) {
                    pointF.x_renamed = i_renamed - pointF.x_renamed;
                }
            } else if (i3 == 270) {
                float f2 = pointF.y_renamed;
                pointF.y_renamed = pointF.x_renamed;
                pointF.x_renamed = f2;
                if (!z_renamed) {
                    pointF.y_renamed = i_renamed - pointF.y_renamed;
                }
            }
        } else if (z_renamed) {
            pointF.x_renamed = i_renamed - pointF.x_renamed;
        }
        return pointF;
    }
}
