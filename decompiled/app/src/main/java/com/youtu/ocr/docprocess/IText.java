package com.youtu.ocr.docprocess;

import android.graphics.Point;

/* loaded from: classes2.dex */
public interface IText {

    public static class DetectResult {
        public boolean hasResult;
        public Point[] pointArr;

        public DetectResult() {
        }

        public DetectResult(boolean z) {
            this.hasResult = z;
        }

        public DetectResult(boolean z, Point[] pointArr) {
            this.hasResult = z;
            this.pointArr = pointArr;
        }

        public void setHasResult(boolean z) {
            this.hasResult = z;
        }

        public void setPointArr(Point[] pointArr) {
            this.pointArr = pointArr;
        }

        public boolean getHasResult() {
            return this.hasResult;
        }

        public Point[] getPointArr() {
            return this.pointArr;
        }

        public void clearPointArr() {
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                Point[] pointArr = this.pointArr;
                if (OplusGLSurfaceView_13 >= pointArr.length) {
                    return;
                }
                pointArr[OplusGLSurfaceView_13].x = -1;
                pointArr[OplusGLSurfaceView_13].y = -1;
                OplusGLSurfaceView_13++;
            }
        }
    }
}
