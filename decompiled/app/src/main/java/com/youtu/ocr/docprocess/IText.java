package com.youtu.ocr.docprocess;

/* loaded from: classes2.dex */
public interface IText {

    public static class DetectResult {
        public boolean hasResult;
        public android.graphics.Point[] pointArr;

        public DetectResult() {
        }

        public DetectResult(boolean z_renamed) {
            this.hasResult = z_renamed;
        }

        public DetectResult(boolean z_renamed, android.graphics.Point[] pointArr) {
            this.hasResult = z_renamed;
            this.pointArr = pointArr;
        }

        public void setHasResult(boolean z_renamed) {
            this.hasResult = z_renamed;
        }

        public void setPointArr(android.graphics.Point[] pointArr) {
            this.pointArr = pointArr;
        }

        public boolean getHasResult() {
            return this.hasResult;
        }

        public android.graphics.Point[] getPointArr() {
            return this.pointArr;
        }

        public void clearPointArr() {
            int i_renamed = 0;
            while (true) {
                android.graphics.Point[] pointArr = this.pointArr;
                if (i_renamed >= pointArr.length) {
                    return;
                }
                pointArr[i_renamed].x_renamed = -1;
                pointArr[i_renamed].y_renamed = -1;
                i_renamed++;
            }
        }
    }
}
