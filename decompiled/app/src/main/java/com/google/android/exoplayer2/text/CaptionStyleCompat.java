package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public final class CaptionStyleCompat {
    public static final com.google.android.exoplayer2.text.CaptionStyleCompat DEFAULT = new com.google.android.exoplayer2.text.CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int USE_TRACK_COLOR_SETTINGS = 1;
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final android.graphics.Typeface typeface;
    public final int windowColor;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    @android.annotation.TargetApi(19)
    public static com.google.android.exoplayer2.text.CaptionStyleCompat createFromCaptionStyle(android.view.accessibility.CaptioningManager.CaptionStyle captionStyle) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            return createFromCaptionStyleV21(captionStyle);
        }
        return createFromCaptionStyleV19(captionStyle);
    }

    public CaptionStyleCompat(int i_renamed, int i2, int i3, int i4, int i5, android.graphics.Typeface typeface) {
        this.foregroundColor = i_renamed;
        this.backgroundColor = i2;
        this.windowColor = i3;
        this.edgeType = i4;
        this.edgeColor = i5;
        this.typeface = typeface;
    }

    @android.annotation.TargetApi(19)
    private static com.google.android.exoplayer2.text.CaptionStyleCompat createFromCaptionStyleV19(android.view.accessibility.CaptioningManager.CaptionStyle captionStyle) {
        return new com.google.android.exoplayer2.text.CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @android.annotation.TargetApi(21)
    private static com.google.android.exoplayer2.text.CaptionStyleCompat createFromCaptionStyleV21(android.view.accessibility.CaptioningManager.CaptionStyle captionStyle) {
        return new com.google.android.exoplayer2.text.CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : DEFAULT.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : DEFAULT.backgroundColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : DEFAULT.windowColor, captionStyle.hasEdgeType() ? captionStyle.edgeType : DEFAULT.edgeType, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : DEFAULT.edgeColor, captionStyle.getTypeface());
    }
}
