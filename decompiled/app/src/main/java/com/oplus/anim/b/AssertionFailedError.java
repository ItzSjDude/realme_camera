package com.oplus.anim.b_renamed;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f3547a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.Context f3548b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, com.oplus.anim.h_renamed> f3549c;
    private java.lang.String d_renamed;
    private com.oplus.anim.j_renamed e_renamed;

    public b_renamed(android.graphics.drawable.Drawable.Callback callback, java.lang.String str, com.oplus.anim.j_renamed jVar, java.util.Map<java.lang.String, com.oplus.anim.h_renamed> map) {
        this.d_renamed = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (this.d_renamed.charAt(r4.length() - 1) != '/') {
                this.d_renamed += '/';
            }
        }
        if (!(callback instanceof android.view.View)) {
            android.util.Log.w_renamed("EffectiveAnimation", "EffectiveAnimationDrawable must be_renamed inside of_renamed a_renamed view for images to work.");
            this.f3549c = new java.util.HashMap();
            this.f3548b = null;
        } else {
            this.f3548b = ((android.view.View) callback).getContext();
            this.f3549c = map;
            a_renamed(jVar);
        }
    }

    public void a_renamed(com.oplus.anim.j_renamed jVar) {
        this.e_renamed = jVar;
    }

    public android.graphics.Bitmap a_renamed(java.lang.String str) throws java.io.IOException {
        com.oplus.anim.h_renamed hVar = this.f3549c.get(str);
        if (hVar == null) {
            return null;
        }
        android.graphics.Bitmap bitmapC = hVar.c_renamed();
        if (bitmapC != null) {
            return bitmapC;
        }
        com.oplus.anim.j_renamed jVar = this.e_renamed;
        if (jVar != null) {
            android.graphics.Bitmap bitmapA = jVar.a_renamed(hVar);
            if (bitmapA != null) {
                a_renamed(str, bitmapA);
            }
            return bitmapA;
        }
        java.lang.String strB = hVar.b_renamed();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = android.util.Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return a_renamed(str, android.graphics.BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (java.lang.IllegalArgumentException e_renamed) {
                android.util.Log.w_renamed("EffectiveAnimation", "data URL did not have correct base64 format.", e_renamed);
                return null;
            }
        }
        try {
            if (android.text.TextUtils.isEmpty(this.d_renamed)) {
                throw new java.lang.IllegalStateException("You must set an_renamed images folder before loading an_renamed image. Set it with EffectiveAnimationComposition#setImagesFolder or EffectiveAnimationDrawable#setImagesFolder");
            }
            if (com.oplus.anim.f_renamed.f_renamed.f3676a) {
                com.oplus.anim.f_renamed.f_renamed.c_renamed("bitmapForId filename = " + strB + ";imagesFolder = " + this.d_renamed);
            }
            java.io.InputStream inputStreamOpen = this.f3548b.getAssets().open(this.d_renamed + strB);
            android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStreamOpen, null, options);
            inputStreamOpen.close();
            return a_renamed(str, bitmapDecodeStream);
        } catch (java.io.IOException e2) {
            android.util.Log.w_renamed("EffectiveAnimation", "Unable to open asset.", e2);
            return null;
        }
    }

    public boolean a_renamed(android.content.Context context) {
        return (context == null && this.f3548b == null) || this.f3548b.equals(context);
    }

    private android.graphics.Bitmap a_renamed(java.lang.String str, android.graphics.Bitmap bitmap) {
        synchronized (f3547a) {
            if (com.oplus.anim.f_renamed.f_renamed.f3676a) {
                com.oplus.anim.f_renamed.f_renamed.c_renamed("putBitmap key = " + str);
            }
            this.f3549c.get(str).a_renamed(bitmap);
        }
        return bitmap;
    }
}
