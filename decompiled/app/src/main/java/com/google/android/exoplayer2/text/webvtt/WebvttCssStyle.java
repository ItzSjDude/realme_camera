package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
public final class WebvttCssStyle {
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
    private int bold;
    private int fontColor;
    private java.lang.String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private int italic;
    private int linethrough;
    private java.util.List<java.lang.String> targetClasses;
    private java.lang.String targetId;
    private java.lang.String targetTag;
    private java.lang.String targetVoice;
    private android.text.Layout.Alignment textAlign;
    private int underline;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public WebvttCssStyle() {
        reset();
    }

    public void reset() {
        this.targetId = "";
        this.targetTag = "";
        this.targetClasses = java.util.Collections.emptyList();
        this.targetVoice = "";
        this.fontFamily = null;
        this.hasFontColor = false;
        this.hasBackgroundColor = false;
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
        this.textAlign = null;
    }

    public void setTargetId(java.lang.String str) {
        this.targetId = str;
    }

    public void setTargetTagName(java.lang.String str) {
        this.targetTag = str;
    }

    public void setTargetClasses(java.lang.String[] strArr) {
        this.targetClasses = java.util.Arrays.asList(strArr);
    }

    public void setTargetVoice(java.lang.String str) {
        this.targetVoice = str;
    }

    public int getSpecificityScore(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String str3) {
        if (this.targetId.isEmpty() && this.targetTag.isEmpty() && this.targetClasses.isEmpty() && this.targetVoice.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int iUpdateScoreForMatch = updateScoreForMatch(updateScoreForMatch(updateScoreForMatch(0, this.targetId, str, 1073741824), this.targetTag, str2, 2), this.targetVoice, str3, 4);
        if (iUpdateScoreForMatch == -1 || !java.util.Arrays.asList(strArr).containsAll(this.targetClasses)) {
            return 0;
        }
        return iUpdateScoreForMatch + (this.targetClasses.size() * 4);
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

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setLinethrough(boolean z_renamed) {
        this.linethrough = z_renamed ? 1 : 0;
        return this;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setUnderline(boolean z_renamed) {
        this.underline = z_renamed ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setBold(boolean z_renamed) {
        this.bold = z_renamed ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setItalic(boolean z_renamed) {
        this.italic = z_renamed ? 1 : 0;
        return this;
    }

    public java.lang.String getFontFamily() {
        return this.fontFamily;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontFamily(java.lang.String str) {
        this.fontFamily = com.google.android.exoplayer2.util.Util.toLowerInvariant(str);
        return this;
    }

    public int getFontColor() {
        if (!this.hasFontColor) {
            throw new java.lang.IllegalStateException("Font color not defined");
        }
        return this.fontColor;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontColor(int i_renamed) {
        this.fontColor = i_renamed;
        this.hasFontColor = true;
        return this;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public int getBackgroundColor() {
        if (!this.hasBackgroundColor) {
            throw new java.lang.IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setBackgroundColor(int i_renamed) {
        this.backgroundColor = i_renamed;
        this.hasBackgroundColor = true;
        return this;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public android.text.Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setTextAlign(android.text.Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontSize(float f_renamed) {
        this.fontSize = f_renamed;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontSizeUnit(short s_renamed) {
        this.fontSizeUnit = s_renamed;
        return this;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public void cascadeFrom(com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle) {
        if (webvttCssStyle.hasFontColor) {
            setFontColor(webvttCssStyle.fontColor);
        }
        int i_renamed = webvttCssStyle.bold;
        if (i_renamed != -1) {
            this.bold = i_renamed;
        }
        int i2 = webvttCssStyle.italic;
        if (i2 != -1) {
            this.italic = i2;
        }
        java.lang.String str = webvttCssStyle.fontFamily;
        if (str != null) {
            this.fontFamily = str;
        }
        if (this.linethrough == -1) {
            this.linethrough = webvttCssStyle.linethrough;
        }
        if (this.underline == -1) {
            this.underline = webvttCssStyle.underline;
        }
        if (this.textAlign == null) {
            this.textAlign = webvttCssStyle.textAlign;
        }
        if (this.fontSizeUnit == -1) {
            this.fontSizeUnit = webvttCssStyle.fontSizeUnit;
            this.fontSize = webvttCssStyle.fontSize;
        }
        if (webvttCssStyle.hasBackgroundColor) {
            setBackgroundColor(webvttCssStyle.backgroundColor);
        }
    }

    private static int updateScoreForMatch(int i_renamed, java.lang.String str, java.lang.String str2, int i2) {
        if (str.isEmpty() || i_renamed == -1) {
            return i_renamed;
        }
        if (str.equals(str2)) {
            return i_renamed + i2;
        }
        return -1;
    }
}
