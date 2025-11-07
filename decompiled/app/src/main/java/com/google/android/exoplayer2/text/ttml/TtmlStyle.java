package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON_renamed = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int fontColor;
    private java.lang.String fontFamily;
    private float fontSize;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private java.lang.String id_renamed;
    private com.google.android.exoplayer2.text.ttml.TtmlStyle inheritableStyle;
    private android.text.Layout.Alignment textAlign;
    private int linethrough = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int fontSizeUnit = -1;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setLinethrough(boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.linethrough = z_renamed ? 1 : 0;
        return this;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setUnderline(boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.underline = z_renamed ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setBold(boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.bold = z_renamed ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setItalic(boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.italic = z_renamed ? 1 : 0;
        return this;
    }

    public java.lang.String getFontFamily() {
        return this.fontFamily;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setFontFamily(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.fontFamily = str;
        return this;
    }

    public int getFontColor() {
        if (!this.hasFontColor) {
            throw new java.lang.IllegalStateException("Font color has not been defined.");
        }
        return this.fontColor;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setFontColor(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.inheritableStyle == null);
        this.fontColor = i_renamed;
        this.hasFontColor = true;
        return this;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public int getBackgroundColor() {
        if (!this.hasBackgroundColor) {
            throw new java.lang.IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setBackgroundColor(int i_renamed) {
        this.backgroundColor = i_renamed;
        this.hasBackgroundColor = true;
        return this;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle inherit(com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle chain(com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    private com.google.android.exoplayer2.text.ttml.TtmlStyle inherit(com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, boolean z_renamed) {
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null) {
                this.fontFamily = ttmlStyle.fontFamily;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.textAlign == null) {
                this.textAlign = ttmlStyle.textAlign;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (z_renamed && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
        }
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setId(java.lang.String str) {
        this.id_renamed = str;
        return this;
    }

    public java.lang.String getId() {
        return this.id_renamed;
    }

    public android.text.Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setTextAlign(android.text.Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setFontSize(float f_renamed) {
        this.fontSize = f_renamed;
        return this;
    }

    public com.google.android.exoplayer2.text.ttml.TtmlStyle setFontSizeUnit(int i_renamed) {
        this.fontSizeUnit = i_renamed;
        return this;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public float getFontSize() {
        return this.fontSize;
    }
}
