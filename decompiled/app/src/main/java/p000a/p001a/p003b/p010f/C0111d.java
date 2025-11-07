package p000a.p001a.p003b.p010f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.LruCache;
import co.polarr.renderer.entities.FontItem;
import co.polarr.renderer.entities.TextItem;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.tblplayer.IMediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class C0111d {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Map<String, FontItem> f518a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Map<String, FontItem> f519b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final LruCache<FontItem, Typeface> f520c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final LruCache<String, Typeface> f521d;

    static {
        f518a.put("Abril Fatface", new FontItem("Abril Fatface", "AbrilFatface-Regular.ttf"));
        f518a.put("Amatica SC", new FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f518a.put("Audiowide", new FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f518a.put("Bangers", new FontItem("'Bangers'", "Bangers.ttf"));
        f518a.put("BioRhyme", new FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
        f518a.put("Cinzel", new FontItem("Cinzel", "Cinzel-Regular.ttf"));
        f518a.put("GUERRILLA", new FontItem("GUERRILLA", "GUERRILLA-Normal.otf"));
        f518a.put("Intro Inline", new FontItem("Intro Inline", "Intro Inline.otf"));
        f518a.put("Intro", new FontItem("Intro", "Intro.otf"));
        f518a.put("Monoton", new FontItem("Monoton", "Monoton-Regular.ttf"));
        f518a.put("Pahnto", new FontItem("Pahnto", "pahnto.ttf"));
        f518a.put("Panton B", new FontItem("Panton", IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, "Panton-BlackCaps.otf"));
        f518a.put("Panton B I", new FontItem("Panton", IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, TtmlNode.ITALIC, "Panton-BlackitalicCaps.otf"));
        f518a.put("Panton L", new FontItem("Panton", 300, "Panton-LightCaps.otf"));
        f518a.put("Panton L I", new FontItem("Panton", 300, TtmlNode.ITALIC, "Panton-LightitalicCaps.otf"));
        f518a.put("Sensa Brush", new FontItem("Sensa Brush", "SensaBrush-Fill.otf"));
        f518a.put("Special Elite", new FontItem("Special Elite", "SpecialElite.ttf"));
        f518a.put("Sprite Graffiti", new FontItem("Sprite Graffiti", "Sprite Graffiti.otf"));
        f518a.put("Sunday", new FontItem("Sunday", "Sunday-Regular.otf"));
        f518a.put("Unkempt", new FontItem("Unkempt", "Unkempt-Regular.ttf"));
        f519b = new HashMap();
        f519b.put("Artwork", new FontItem("Artwork", "PolarrArtwork.otf"));
        f519b.put("Amatica SC", new FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f519b.put("Audiowide", new FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f519b.put("Bangers", new FontItem("'Bangers'", "Bangers.ttf"));
        f519b.put("BioRhyme", new FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
        f520c = new LruCache<>(5);
        f521d = new LruCache<>(20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m470a(Context context, AssetManager assetManager, TextItem textItem, int OplusGLSurfaceView_13) {
        Typeface typefaceCreate;
        Typeface typeface;
        String str;
        Typeface typefaceCreateFromFile;
        Typeface typefaceCreate2;
        if ("Artwork".equalsIgnoreCase(textItem.type)) {
            FontItem fontItem = f519b.get("Artwork");
            Typeface typeface2 = f520c.get(fontItem);
            if (typeface2 != null) {
                return typeface2;
            }
            try {
                typefaceCreate2 = Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem.src);
            } catch (Exception unused) {
                typefaceCreate2 = Typeface.create(textItem.fontFamily, OplusGLSurfaceView_13);
            }
            Typeface typeface3 = typefaceCreate2;
            f520c.put(fontItem, typeface3);
            return typeface3;
        }
        try {
            if (f518a.containsKey(textItem.fontName)) {
                FontItem fontItem2 = f518a.get(textItem.fontName);
                Typeface typeface4 = f520c.get(fontItem2);
                if (typeface4 != null) {
                    return typeface4;
                }
                typefaceCreate = Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem2.src);
                context = fontItem2;
            } else {
                if (!f519b.containsKey(textItem.fontName)) {
                    try {
                        typeface = f521d.get(textItem.fontName);
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        typeface = null;
                    }
                    Typeface typeface5 = typeface;
                    if (typeface5 != null || (str = textItem.fontName) == null) {
                        return typeface5;
                    }
                    File fileM471a = m471a(context, str);
                    if (fileM471a != null) {
                        try {
                            try {
                                typefaceCreateFromFile = Typeface.createFromFile(fileM471a);
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            fileM471a.delete();
                        }
                    } else {
                        typefaceCreateFromFile = Typeface.create(textItem.fontFamily, OplusGLSurfaceView_13);
                    }
                    Typeface typeface6 = typefaceCreateFromFile;
                    if (typeface6 == null) {
                        return typeface6;
                    }
                    f521d.put(textItem.fontName, typeface6);
                    return typeface6;
                }
                FontItem fontItem3 = f519b.get(textItem.fontName);
                Typeface typeface7 = f520c.get(fontItem3);
                if (typeface7 != null) {
                    return typeface7;
                }
                typefaceCreate = Typeface.createFromAsset(assetManager, "editor/fonts/" + fontItem3.src);
                context = fontItem3;
            }
        } catch (Exception unused4) {
            typefaceCreate = Typeface.create(textItem.fontFamily, OplusGLSurfaceView_13);
        }
        f520c.put(context, typefaceCreate);
        return typefaceCreate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static File m471a(Context context, String str) {
        return null;
    }
}
