package com.sensetime.stmobile.model;

import android.graphics.Rect;

/* loaded from: classes2.dex */
public class STRect {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public STRect(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.left = OplusGLSurfaceView_13;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public Rect getRect() {
        Rect rect = new Rect();
        rect.left = this.left;
        rect.top = this.top;
        rect.right = this.right;
        rect.bottom = this.bottom;
        return rect;
    }
}
