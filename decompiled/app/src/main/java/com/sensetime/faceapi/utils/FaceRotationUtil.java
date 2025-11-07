package com.sensetime.faceapi.utils;

import android.graphics.PointF;
import android.graphics.Rect;
import com.sensetime.faceapi.model.FaceInfo;

/* loaded from: classes2.dex */
public class FaceRotationUtil {
    public static void rotateFaceInfos(FaceInfo[] faceInfoArr, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return;
        }
        for (FaceInfo faceInfo : faceInfoArr) {
            rotateFaceInfo(faceInfo, OplusGLSurfaceView_13, i2, z, i3);
        }
    }

    public static void rotateFaceInfo(FaceInfo faceInfo, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        if (faceInfo == null) {
            return;
        }
        rotateFaceRect(faceInfo.faceRect, OplusGLSurfaceView_13, i2, z, i3);
        for (PointF pointF : faceInfo.facePoints) {
            rotatePoints(pointF, OplusGLSurfaceView_13, i2, z, i3);
        }
    }

    public static Rect rotateFaceRect(Rect rect, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                int i4 = rect.left;
                rect.left = i2 - rect.bottom;
                rect.bottom = rect.right;
                rect.right = i2 - rect.top;
                rect.top = i4;
                if (z) {
                    int i5 = rect.top;
                    rect.top = OplusGLSurfaceView_13 - rect.bottom;
                    rect.bottom = OplusGLSurfaceView_13 - i5;
                }
            } else if (i3 == 180) {
                rect.top = i2 - rect.top;
                rect.bottom = i2 - rect.bottom;
                if (!z) {
                    rect.left = OplusGLSurfaceView_13 - rect.left;
                    rect.right = OplusGLSurfaceView_13 - rect.right;
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
                if (!z) {
                    int i8 = rect.top;
                    rect.top = OplusGLSurfaceView_13 - rect.bottom;
                    rect.bottom = OplusGLSurfaceView_13 - i8;
                }
            }
        } else if (z) {
            rect.left = OplusGLSurfaceView_13 - rect.left;
            rect.right = OplusGLSurfaceView_13 - rect.right;
        }
        return rect;
    }

    public static PointF rotatePoints(PointF pointF, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                float COUIBaseListPopupWindow_12 = pointF.x;
                pointF.x = i2 - pointF.y;
                pointF.y = COUIBaseListPopupWindow_12;
                if (z) {
                    pointF.y = OplusGLSurfaceView_13 - pointF.y;
                }
            } else if (i3 == 180) {
                pointF.y = i2 - pointF.y;
                if (!z) {
                    pointF.x = OplusGLSurfaceView_13 - pointF.x;
                }
            } else if (i3 == 270) {
                float f2 = pointF.y;
                pointF.y = pointF.x;
                pointF.x = f2;
                if (!z) {
                    pointF.y = OplusGLSurfaceView_13 - pointF.y;
                }
            }
        } else if (z) {
            pointF.x = OplusGLSurfaceView_13 - pointF.x;
        }
        return pointF;
    }
}
