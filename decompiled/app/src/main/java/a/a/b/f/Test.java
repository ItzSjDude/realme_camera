package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.Map<java.lang.String, co_renamed.polarr.renderer.entities.FontItem> f81a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final java.util.Map<java.lang.String, co_renamed.polarr.renderer.entities.FontItem> f82b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static final android.util.LruCache<co_renamed.polarr.renderer.entities.FontItem, android.graphics.Typeface> f83c;
    public static final android.util.LruCache<java.lang.String, android.graphics.Typeface> d_renamed;

    static {
        f81a.put("Abril Fatface", new co_renamed.polarr.renderer.entities.FontItem("Abril Fatface", "AbrilFatface-Regular.ttf"));
        f81a.put("Amatica SC", new co_renamed.polarr.renderer.entities.FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f81a.put("Audiowide", new co_renamed.polarr.renderer.entities.FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f81a.put("Bangers", new co_renamed.polarr.renderer.entities.FontItem("'Bangers'", "Bangers.ttf"));
        f81a.put("BioRhyme", new co_renamed.polarr.renderer.entities.FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
        f81a.put("Cinzel", new co_renamed.polarr.renderer.entities.FontItem("Cinzel", "Cinzel-Regular.ttf"));
        f81a.put("GUERRILLA", new co_renamed.polarr.renderer.entities.FontItem("GUERRILLA", "GUERRILLA-Normal.otf"));
        f81a.put("Intro Inline", new co_renamed.polarr.renderer.entities.FontItem("Intro Inline", "Intro Inline.otf"));
        f81a.put("Intro", new co_renamed.polarr.renderer.entities.FontItem("Intro", "Intro.otf"));
        f81a.put("Monoton", new co_renamed.polarr.renderer.entities.FontItem("Monoton", "Monoton-Regular.ttf"));
        f81a.put("Pahnto", new co_renamed.polarr.renderer.entities.FontItem("Pahnto", "pahnto.ttf"));
        f81a.put("Panton B_renamed", new co_renamed.polarr.renderer.entities.FontItem("Panton", com.oplus.tblplayer.IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, "Panton-BlackCaps.otf"));
        f81a.put("Panton B_renamed I_renamed", new co_renamed.polarr.renderer.entities.FontItem("Panton", com.oplus.tblplayer.IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, com.google.android.exoplayer2.text.ttml.TtmlNode.ITALIC, "Panton-BlackitalicCaps.otf"));
        f81a.put("Panton L_renamed", new co_renamed.polarr.renderer.entities.FontItem("Panton", 300, "Panton-LightCaps.otf"));
        f81a.put("Panton L_renamed I_renamed", new co_renamed.polarr.renderer.entities.FontItem("Panton", 300, com.google.android.exoplayer2.text.ttml.TtmlNode.ITALIC, "Panton-LightitalicCaps.otf"));
        f81a.put("Sensa Brush", new co_renamed.polarr.renderer.entities.FontItem("Sensa Brush", "SensaBrush-Fill.otf"));
        f81a.put("Special Elite", new co_renamed.polarr.renderer.entities.FontItem("Special Elite", "SpecialElite.ttf"));
        f81a.put("Sprite Graffiti", new co_renamed.polarr.renderer.entities.FontItem("Sprite Graffiti", "Sprite Graffiti.otf"));
        f81a.put("Sunday", new co_renamed.polarr.renderer.entities.FontItem("Sunday", "Sunday-Regular.otf"));
        f81a.put("Unkempt", new co_renamed.polarr.renderer.entities.FontItem("Unkempt", "Unkempt-Regular.ttf"));
        f82b = new java.util.HashMap();
        f82b.put("Artwork", new co_renamed.polarr.renderer.entities.FontItem("Artwork", "PolarrArtwork.otf"));
        f82b.put("Amatica SC", new co_renamed.polarr.renderer.entities.FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f82b.put("Audiowide", new co_renamed.polarr.renderer.entities.FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f82b.put("Bangers", new co_renamed.polarr.renderer.entities.FontItem("'Bangers'", "Bangers.ttf"));
        f82b.put("BioRhyme", new co_renamed.polarr.renderer.entities.FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
        f83c = new android.util.LruCache<>(5);
        d_renamed = new android.util.LruCache<>(20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static android.graphics.Typeface a_renamed(android.content.Context context, android.content.res.AssetManager assetManager, co_renamed.polarr.renderer.entities.TextItem textItem, int i_renamed) {
        android.graphics.Typeface typefaceCreate;
        android.graphics.Typeface typeface;
        java.lang.String str;
        android.graphics.Typeface typefaceCreateFromFile;
        android.graphics.Typeface typefaceCreate2;
        if ("Artwork".equalsIgnoreCase(textItem.type)) {
            co_renamed.polarr.renderer.entities.FontItem fontItem = f82b.get("Artwork");
            android.graphics.Typeface typeface2 = f83c.get(fontItem);
            if (typeface2 != null) {
                return typeface2;
            }
            try {
                typefaceCreate2 = android.graphics.Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem.src);
            } catch (java.lang.Exception unused) {
                typefaceCreate2 = android.graphics.Typeface.create(textItem.fontFamily, i_renamed);
            }
            android.graphics.Typeface typeface3 = typefaceCreate2;
            f83c.put(fontItem, typeface3);
            return typeface3;
        }
        try {
            if (f81a.containsKey(textItem.fontName)) {
                co_renamed.polarr.renderer.entities.FontItem fontItem2 = f81a.get(textItem.fontName);
                android.graphics.Typeface typeface4 = f83c.get(fontItem2);
                if (typeface4 != null) {
                    return typeface4;
                }
                typefaceCreate = android.graphics.Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem2.src);
                context = fontItem2;
            } else {
                if (!f82b.containsKey(textItem.fontName)) {
                    try {
                        typeface = d_renamed.get(textItem.fontName);
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed.printStackTrace();
                        typeface = null;
                    }
                    android.graphics.Typeface typeface5 = typeface;
                    if (typeface5 != null || (str = textItem.fontName) == null) {
                        return typeface5;
                    }
                    java.io.File fileA = a_renamed(context, str);
                    if (fileA != null) {
                        try {
                            try {
                                typefaceCreateFromFile = android.graphics.Typeface.createFromFile(fileA);
                            } catch (java.lang.Exception unused2) {
                            }
                        } catch (java.lang.Exception unused3) {
                            fileA.delete();
                        }
                    } else {
                        typefaceCreateFromFile = android.graphics.Typeface.create(textItem.fontFamily, i_renamed);
                    }
                    android.graphics.Typeface typeface6 = typefaceCreateFromFile;
                    if (typeface6 == null) {
                        return typeface6;
                    }
                    d_renamed.put(textItem.fontName, typeface6);
                    return typeface6;
                }
                co_renamed.polarr.renderer.entities.FontItem fontItem3 = f82b.get(textItem.fontName);
                android.graphics.Typeface typeface7 = f83c.get(fontItem3);
                if (typeface7 != null) {
                    return typeface7;
                }
                typefaceCreate = android.graphics.Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem3.src);
                context = fontItem3;
            }
        } catch (java.lang.Exception unused4) {
            typefaceCreate = android.graphics.Typeface.create(textItem.fontFamily, i_renamed);
        }
        f83c.put(context, typefaceCreate);
        return typefaceCreate;
    }

    public static java.io.File a_renamed(android.content.Context context, java.lang.String str) {
        return null;
    }
}
