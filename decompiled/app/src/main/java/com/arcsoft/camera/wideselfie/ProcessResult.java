package com.arcsoft.camera.wideselfie;

/* loaded from: classes.dex */
public class ProcessResult {
    public int direction;
    public boolean hasCapture;
    public int maxResultWidth;
    public int progress;
    public byte[] progressBarThumbArray;
    public int progressBarThumbImageHeight;
    public int progressBarThumbImageWidth;
    public android.graphics.Point progressBarThumbOffset;
    public android.graphics.Point progressBarThumbOffsetCapture;
    public android.graphics.Rect progressBarThumbRect;
    public int[] progressBarThumbRgbPixels;
    public com.arcsoft.camera.wideselfie.ProcessResult.ProjectGuide projectGuide;
    public byte[] resultImageArray;
    public int resultImageHeight;
    public int resultImageWidth;
    public byte[] rotateResultImageArray;

    public static class ProjectGuide {
        public android.graphics.Point leftBottomOffset;
        public android.graphics.Point leftTopOffset;
        public android.graphics.Point rightBottomOffset;
        public android.graphics.Point rightTopOffset;
    }
}
