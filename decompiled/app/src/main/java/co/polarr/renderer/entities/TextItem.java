package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class TextItem {
    public java.lang.String align;
    public float angle;
    public float blendMix;
    public float blendMode;
    public float[] color;
    public boolean disabled;
    public java.lang.String fontFamily;
    public java.lang.String fontName;
    public float fontSize;
    public java.lang.String fontStyle;
    public java.lang.String fontWeight;
    public float letterSpacing;
    public float lineHeight;
    public java.lang.String mode;
    public float opacity;
    public float orientation;
    public float[] position;
    public float[] scale;
    public float shadowBlur;
    public float[] shadowColor;
    public float[] shadowOffset;
    public float shadowOpacity;
    public float strokeSize;
    public java.lang.String text;
    public java.lang.String type;
    public float wrap;

    public static co_renamed.polarr.renderer.entities.TextItem fromDecodedHashMap(java.util.HashMap<java.lang.String, java.lang.Object> map) {
        return fromJSON(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(map));
    }

    public static co_renamed.polarr.renderer.entities.TextItem fromJSON(java.lang.String str) {
        return (co_renamed.polarr.renderer.entities.TextItem) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(str, co_renamed.polarr.renderer.entities.TextItem.class);
    }
}
