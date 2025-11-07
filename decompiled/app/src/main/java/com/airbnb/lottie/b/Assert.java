package com.airbnb.lottie.b_renamed;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a_renamed {
    private final android.content.res.AssetManager d_renamed;
    private com.airbnb.lottie.a_renamed e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.i_renamed<java.lang.String> f2042a = new com.airbnb.lottie.c_renamed.i_renamed<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Map<com.airbnb.lottie.c_renamed.i_renamed<java.lang.String>, android.graphics.Typeface> f2043b = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, android.graphics.Typeface> f2044c = new java.util.HashMap();
    private java.lang.String f_renamed = ".ttf";

    public a_renamed(android.graphics.drawable.Drawable.Callback callback, com.airbnb.lottie.a_renamed aVar) {
        this.e_renamed = aVar;
        if (!(callback instanceof android.view.View)) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("LottieDrawable must be_renamed inside of_renamed a_renamed view for images to work.");
            this.d_renamed = null;
        } else {
            this.d_renamed = ((android.view.View) callback).getContext().getAssets();
        }
    }

    public void a_renamed(com.airbnb.lottie.a_renamed aVar) {
        this.e_renamed = aVar;
    }

    public android.graphics.Typeface a_renamed(java.lang.String str, java.lang.String str2) {
        this.f2042a.a_renamed(str, str2);
        android.graphics.Typeface typeface = this.f2043b.get(this.f2042a);
        if (typeface != null) {
            return typeface;
        }
        android.graphics.Typeface typefaceA = a_renamed(a_renamed(str), str2);
        this.f2043b.put(this.f2042a, typefaceA);
        return typefaceA;
    }

    private android.graphics.Typeface a_renamed(java.lang.String str) {
        java.lang.String strB;
        android.graphics.Typeface typeface = this.f2044c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.a_renamed aVar = this.e_renamed;
        android.graphics.Typeface typefaceA = aVar != null ? aVar.a_renamed(str) : null;
        com.airbnb.lottie.a_renamed aVar2 = this.e_renamed;
        if (aVar2 != null && typefaceA == null && (strB = aVar2.b_renamed(str)) != null) {
            typefaceA = android.graphics.Typeface.createFromAsset(this.d_renamed, strB);
        }
        if (typefaceA == null) {
            typefaceA = android.graphics.Typeface.createFromAsset(this.d_renamed, "fonts/" + str + this.f_renamed);
        }
        this.f2044c.put(str, typefaceA);
        return typefaceA;
    }

    private android.graphics.Typeface a_renamed(android.graphics.Typeface typeface, java.lang.String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i_renamed = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i_renamed ? typeface : android.graphics.Typeface.create(typeface, i_renamed);
    }
}
