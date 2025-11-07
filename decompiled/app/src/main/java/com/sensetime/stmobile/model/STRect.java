package com.sensetime.stmobile.model;

/* loaded from: classes2.dex */
public class STRect {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public STRect(int i_renamed, int i2, int i3, int i4) {
        this.left = i_renamed;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public android.graphics.Rect getRect() {
        android.graphics.Rect rect = new android.graphics.Rect();
        rect.left = this.left;
        rect.top = this.top;
        rect.right = this.right;
        rect.bottom = this.bottom;
        return rect;
    }
}
