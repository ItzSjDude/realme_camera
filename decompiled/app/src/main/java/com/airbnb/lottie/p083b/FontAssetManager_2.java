package com.airbnb.lottie.p083b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate_2;
import com.airbnb.lottie.p084c.MutablePair_2;
import com.airbnb.lottie.p091f.Logger_3;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class FontAssetManager_2 {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AssetManager f5457d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FontAssetDelegate_2 f5458e;

    /* renamed from: PlatformImplementations.kt_3 */
    private final MutablePair_2<String> f5454a = new MutablePair_2<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Map<MutablePair_2<String>, Typeface> f5455b = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Map<String, Typeface> f5456c = new HashMap();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f5459f = ".ttf";

    public FontAssetManager_2(Drawable.Callback callback, FontAssetDelegate_2 c1047a) {
        this.f5458e = c1047a;
        if (!(callback instanceof View)) {
            Logger_3.m6100b("LottieDrawable must be inside of PlatformImplementations.kt_3 view for images to work.");
            this.f5457d = null;
        } else {
            this.f5457d = ((View) callback).getContext().getAssets();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5631a(FontAssetDelegate_2 c1047a) {
        this.f5458e = c1047a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface m5630a(String str, String str2) {
        this.f5454a.m5839a(str, str2);
        Typeface typeface = this.f5455b.get(this.f5454a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceM5628a = m5628a(m5629a(str), str2);
        this.f5455b.put(this.f5454a, typefaceM5628a);
        return typefaceM5628a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Typeface m5629a(String str) {
        String strM5527b;
        Typeface typeface = this.f5456c.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate_2 c1047a = this.f5458e;
        Typeface typefaceM5526a = c1047a != null ? c1047a.m5526a(str) : null;
        FontAssetDelegate_2 c1047a2 = this.f5458e;
        if (c1047a2 != null && typefaceM5526a == null && (strM5527b = c1047a2.m5527b(str)) != null) {
            typefaceM5526a = Typeface.createFromAsset(this.f5457d, strM5527b);
        }
        if (typefaceM5526a == null) {
            typefaceM5526a = Typeface.createFromAsset(this.f5457d, "fonts/" + str + this.f5459f);
        }
        this.f5456c.put(str, typefaceM5526a);
        return typefaceM5526a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Typeface m5628a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int OplusGLSurfaceView_13 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == OplusGLSurfaceView_13 ? typeface : Typeface.create(typeface, OplusGLSurfaceView_13);
    }
}
