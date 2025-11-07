package com.airbnb.lottie.b_renamed;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f2045a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.Context f2046b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f2047c;
    private com.airbnb.lottie.b_renamed d_renamed;
    private final java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> e_renamed;

    public b_renamed(android.graphics.drawable.Drawable.Callback callback, java.lang.String str, com.airbnb.lottie.b_renamed bVar, java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> map) {
        this.f2047c = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (this.f2047c.charAt(r4.length() - 1) != '/') {
                this.f2047c += '/';
            }
        }
        if (!(callback instanceof android.view.View)) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("LottieDrawable must be_renamed inside of_renamed a_renamed view for images to work.");
            this.e_renamed = new java.util.HashMap();
            this.f2046b = null;
        } else {
            this.f2046b = ((android.view.View) callback).getContext();
            this.e_renamed = map;
            a_renamed(bVar);
        }
    }

    public void a_renamed(com.airbnb.lottie.b_renamed bVar) {
        this.d_renamed = bVar;
    }

    public android.graphics.Bitmap a_renamed(java.lang.String str) {
        com.airbnb.lottie.g_renamed gVar = this.e_renamed.get(str);
        if (gVar == null) {
            return null;
        }
        android.graphics.Bitmap bitmapE = gVar.e_renamed();
        if (bitmapE != null) {
            return bitmapE;
        }
        com.airbnb.lottie.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            android.graphics.Bitmap bitmapA = bVar.a_renamed(gVar);
            if (bitmapA != null) {
                a_renamed(str, bitmapA);
            }
            return bitmapA;
        }
        java.lang.String strD = gVar.d_renamed();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strD.startsWith("data:") && strD.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = android.util.Base64.decode(strD.substring(strD.indexOf(44) + 1), 0);
                return a_renamed(str, android.graphics.BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (java.lang.IllegalArgumentException e_renamed) {
                com.airbnb.lottie.f_renamed.d_renamed.a_renamed("data URL did not have correct base64 format.", e_renamed);
                return null;
            }
        }
        try {
            if (android.text.TextUtils.isEmpty(this.f2047c)) {
                throw new java.lang.IllegalStateException("You must set an_renamed images folder before loading an_renamed image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return a_renamed(str, com.airbnb.lottie.f_renamed.h_renamed.a_renamed(android.graphics.BitmapFactory.decodeStream(this.f2046b.getAssets().open(this.f2047c + strD), null, options), gVar.a_renamed(), gVar.b_renamed()));
            } catch (java.lang.IllegalArgumentException e2) {
                com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Unable to decode image.", e2);
                return null;
            }
        } catch (java.io.IOException e3) {
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean a_renamed(android.content.Context context) {
        return (context == null && this.f2046b == null) || this.f2046b.equals(context);
    }

    private android.graphics.Bitmap a_renamed(java.lang.String str, android.graphics.Bitmap bitmap) {
        synchronized (f2045a) {
            this.e_renamed.get(str).a_renamed(bitmap);
        }
        return bitmap;
    }
}
