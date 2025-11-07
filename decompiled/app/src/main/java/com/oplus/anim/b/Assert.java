package com.oplus.anim.b_renamed;

/* compiled from: FontAssetManager.java */
/* loaded from: classes2.dex */
public class a_renamed {
    private final android.content.res.AssetManager d_renamed;
    private com.oplus.anim.i_renamed e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.i_renamed<java.lang.String> f3544a = new com.oplus.anim.c_renamed.i_renamed<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Map<com.oplus.anim.c_renamed.i_renamed<java.lang.String>, android.graphics.Typeface> f3545b = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, android.graphics.Typeface> f3546c = new java.util.HashMap();
    private java.lang.String f_renamed = ".ttf";

    public a_renamed(android.graphics.drawable.Drawable.Callback callback, com.oplus.anim.i_renamed iVar) {
        this.e_renamed = iVar;
        if (!(callback instanceof android.view.View)) {
            android.util.Log.w_renamed("EffectiveAnimation", "EffectiveAnimationDrawable must be_renamed inside of_renamed a_renamed view for images to work.");
            this.d_renamed = null;
        } else {
            this.d_renamed = ((android.view.View) callback).getContext().getAssets();
        }
    }

    public void a_renamed(com.oplus.anim.i_renamed iVar) {
        this.e_renamed = iVar;
    }

    public android.graphics.Typeface a_renamed(java.lang.String str, java.lang.String str2) {
        this.f3544a.a_renamed(str, str2);
        android.graphics.Typeface typeface = this.f3545b.get(this.f3544a);
        if (typeface != null) {
            return typeface;
        }
        android.graphics.Typeface typefaceA = a_renamed(a_renamed(str), str2);
        this.f3545b.put(this.f3544a, typefaceA);
        return typefaceA;
    }

    private android.graphics.Typeface a_renamed(java.lang.String str) {
        java.lang.String strB;
        android.graphics.Typeface typeface = this.f3546c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.oplus.anim.i_renamed iVar = this.e_renamed;
        android.graphics.Typeface typefaceA = iVar != null ? iVar.a_renamed(str) : null;
        com.oplus.anim.i_renamed iVar2 = this.e_renamed;
        if (iVar2 != null && typefaceA == null && (strB = iVar2.b_renamed(str)) != null) {
            typefaceA = android.graphics.Typeface.createFromAsset(this.d_renamed, strB);
        }
        if (typefaceA == null) {
            typefaceA = android.graphics.Typeface.createFromAsset(this.d_renamed, "fonts/" + str + this.f_renamed);
        }
        this.f3546c.put(str, typefaceA);
        return typefaceA;
    }

    private android.graphics.Typeface a_renamed(android.graphics.Typeface typeface, java.lang.String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i_renamed = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i_renamed ? typeface : android.graphics.Typeface.create(typeface, i_renamed);
    }
}
