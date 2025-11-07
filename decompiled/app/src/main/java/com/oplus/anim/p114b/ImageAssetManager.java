package com.oplus.anim.p114b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.oplus.anim.EffectiveImageAsset;
import com.oplus.anim.ImageAssetDelegate;
import com.oplus.anim.p121f.OplusLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ImageAssetManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f10093a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Context f10094b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Map<String, EffectiveImageAsset> f10095c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f10096d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ImageAssetDelegate f10097e;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate interfaceC2418j, Map<String, EffectiveImageAsset> map) {
        this.f10096d = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f10096d.charAt(r4.length() - 1) != '/') {
                this.f10096d += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w("EffectiveAnimation", "EffectiveAnimationDrawable must be inside of PlatformImplementations.kt_3 view for images to work.");
            this.f10095c = new HashMap();
            this.f10094b = null;
        } else {
            this.f10094b = ((View) callback).getContext();
            this.f10095c = map;
            m8949a(interfaceC2418j);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8949a(ImageAssetDelegate interfaceC2418j) {
        this.f10097e = interfaceC2418j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m8948a(String str) throws IOException {
        EffectiveImageAsset c2416h = this.f10095c.get(str);
        if (c2416h == null) {
            return null;
        }
        Bitmap bitmapM9343c = c2416h.m9343c();
        if (bitmapM9343c != null) {
            return bitmapM9343c;
        }
        ImageAssetDelegate interfaceC2418j = this.f10097e;
        if (interfaceC2418j != null) {
            Bitmap bitmapM9346a = interfaceC2418j.m9346a(c2416h);
            if (bitmapM9346a != null) {
                m8947a(str, bitmapM9346a);
            }
            return bitmapM9346a;
        }
        String strM9342b = c2416h.m9342b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strM9342b.startsWith("data:") && strM9342b.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strM9342b.substring(strM9342b.indexOf(44) + 1), 0);
                return m8947a(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                Log.w("EffectiveAnimation", "data URL did not have correct base64 format.", COUIBaseListPopupWindow_8);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f10096d)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with EffectiveAnimationComposition#setImagesFolder or EffectiveAnimationDrawable#setImagesFolder");
            }
            if (OplusLog.f10385a) {
                OplusLog.m9287c("bitmapForId filename = " + strM9342b + ";imagesFolder = " + this.f10096d);
            }
            InputStream inputStreamOpen = this.f10094b.getAssets().open(this.f10096d + strM9342b);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
            inputStreamOpen.close();
            return m8947a(str, bitmapDecodeStream);
        } catch (IOException e2) {
            Log.w("EffectiveAnimation", "Unable to open asset.", e2);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m8950a(Context context) {
        return (context == null && this.f10094b == null) || this.f10094b.equals(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m8947a(String str, Bitmap bitmap) {
        synchronized (f10093a) {
            if (OplusLog.f10385a) {
                OplusLog.m9287c("putBitmap key = " + str);
            }
            this.f10095c.get(str).m9341a(bitmap);
        }
        return bitmap;
    }
}
