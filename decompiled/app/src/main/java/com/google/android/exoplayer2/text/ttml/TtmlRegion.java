package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
final class TtmlRegion {

    /* renamed from: id_renamed */
    public final String f9014id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2, float f3, int i3, float f4) {
        this.f9014id = str;
        this.position = COUIBaseListPopupWindow_12;
        this.line = f2;
        this.lineType = OplusGLSurfaceView_13;
        this.lineAnchor = i2;
        this.width = f3;
        this.textSizeType = i3;
        this.textSize = f4;
    }
}
