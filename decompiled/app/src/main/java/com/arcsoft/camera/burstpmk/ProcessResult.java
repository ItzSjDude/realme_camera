package com.arcsoft.camera.burstpmk;

/* loaded from: classes.dex */
public class ProcessResult {
    public byte[] smallImageData;
    public int width = 0;
    public int height = 0;
    public int format = -1;
    public int direction = -1;
    public int progress = 0;
    public byte[] imageData = null;
    public byte[] rotatedImageData = null;
    public int[] pitchs = null;
    public android.graphics.Rect updateRect = null;
    public android.graphics.Rect updateSmallImageRect = null;
    public android.graphics.Point outputOffset = null;
    public byte[] smallPreviewData = null;
    public int smallPreviewW = 0;
    public int smallPreviewH = 0;
}
