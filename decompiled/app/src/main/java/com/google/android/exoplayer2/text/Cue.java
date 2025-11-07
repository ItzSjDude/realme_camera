package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = Float.MIN_VALUE;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public final android.graphics.Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final java.lang.CharSequence text;
    public final android.text.Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    public Cue(android.graphics.Bitmap bitmap, float f_renamed, int i_renamed, float f2, int i2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, i2, f_renamed, i_renamed, Integer.MIN_VALUE, Float.MIN_VALUE, f3, f4, false, -16777216);
    }

    public Cue(java.lang.CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f_renamed, int i_renamed, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f_renamed, i_renamed, i2, f2, i3, f3, false, -16777216);
    }

    public Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f_renamed, int i_renamed, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, f_renamed, i_renamed, i2, f2, i3, i4, f4, f3, Float.MIN_VALUE, false, -16777216);
    }

    public Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f_renamed, int i_renamed, int i2, float f2, int i3, float f3, boolean z_renamed, int i4) {
        this(charSequence, alignment, null, f_renamed, i_renamed, i2, f2, i3, Integer.MIN_VALUE, Float.MIN_VALUE, f3, Float.MIN_VALUE, z_renamed, i4);
    }

    private Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, android.graphics.Bitmap bitmap, float f_renamed, int i_renamed, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z_renamed, int i5) {
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap;
        this.line = f_renamed;
        this.lineType = i_renamed;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z_renamed;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
    }
}
