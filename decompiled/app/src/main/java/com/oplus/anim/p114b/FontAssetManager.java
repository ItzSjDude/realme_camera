package com.oplus.anim.p114b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.oplus.anim.FontAssetDelegate;
import com.oplus.anim.p115c.MutablePair;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class FontAssetManager {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AssetManager f10090d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FontAssetDelegate f10091e;

    /* renamed from: PlatformImplementations.kt_3 */
    private final MutablePair<String> f10087a = new MutablePair<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Map<MutablePair<String>, Typeface> f10088b = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Map<String, Typeface> f10089c = new HashMap();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f10092f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate c2417i) {
        this.f10091e = c2417i;
        if (!(callback instanceof View)) {
            Log.w("EffectiveAnimation", "EffectiveAnimationDrawable must be inside of PlatformImplementations.kt_3 view for images to work.");
            this.f10090d = null;
        } else {
            this.f10090d = ((View) callback).getContext().getAssets();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8946a(FontAssetDelegate c2417i) {
        this.f10091e = c2417i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface m8945a(String str, String str2) {
        this.f10087a.m9143a(str, str2);
        Typeface typeface = this.f10088b.get(this.f10087a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceM8943a = m8943a(m8944a(str), str2);
        this.f10088b.put(this.f10087a, typefaceM8943a);
        return typefaceM8943a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Typeface m8944a(String str) {
        String strM9345b;
        Typeface typeface = this.f10089c.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate c2417i = this.f10091e;
        Typeface typefaceM9344a = c2417i != null ? c2417i.m9344a(str) : null;
        FontAssetDelegate c2417i2 = this.f10091e;
        if (c2417i2 != null && typefaceM9344a == null && (strM9345b = c2417i2.m9345b(str)) != null) {
            typefaceM9344a = Typeface.createFromAsset(this.f10090d, strM9345b);
        }
        if (typefaceM9344a == null) {
            typefaceM9344a = Typeface.createFromAsset(this.f10090d, "fonts/" + str + this.f10092f);
        }
        this.f10089c.put(str, typefaceM9344a);
        return typefaceM9344a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Typeface m8943a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int OplusGLSurfaceView_13 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == OplusGLSurfaceView_13 ? typeface : Typeface.create(typeface, OplusGLSurfaceView_13);
    }
}
