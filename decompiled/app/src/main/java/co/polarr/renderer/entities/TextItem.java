package co.polarr.renderer.entities;

import java.util.HashMap;
import p000a.p001a.p003b.p010f.C0109b;

/* loaded from: classes.dex */
public class TextItem {
    public String align;
    public float angle;
    public float blendMix;
    public float blendMode;
    public float[] color;
    public boolean disabled;
    public String fontFamily;
    public String fontName;
    public float fontSize;
    public String fontStyle;
    public String fontWeight;
    public float letterSpacing;
    public float lineHeight;
    public String mode;
    public float opacity;
    public float orientation;
    public float[] position;
    public float[] scale;
    public float shadowBlur;
    public float[] shadowColor;
    public float[] shadowOffset;
    public float shadowOpacity;
    public float strokeSize;
    public String text;
    public String type;
    public float wrap;

    public static TextItem fromDecodedHashMap(HashMap<String, Object> map) {
        return fromJSON(C0109b.m466a(map));
    }

    public static TextItem fromJSON(String str) {
        return (TextItem) C0109b.m465a(str, TextItem.class);
    }
}
