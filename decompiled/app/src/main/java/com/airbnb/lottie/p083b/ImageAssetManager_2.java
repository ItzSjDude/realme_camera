package com.airbnb.lottie.p083b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.ImageAssetDelegate_2;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.Utils_4;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class ImageAssetManager_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f5460a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Context f5461b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f5462c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ImageAssetDelegate_2 f5463d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Map<String, LottieImageAsset> f5464e;

    public ImageAssetManager_2(Drawable.Callback callback, String str, ImageAssetDelegate_2 interfaceC1084b, Map<String, LottieImageAsset> map) {
        this.f5462c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f5462c.charAt(r4.length() - 1) != '/') {
                this.f5462c += '/';
            }
        }
        if (!(callback instanceof View)) {
            Logger_3.m6100b("LottieDrawable must be inside of PlatformImplementations.kt_3 view for images to work.");
            this.f5464e = new HashMap();
            this.f5461b = null;
        } else {
            this.f5461b = ((View) callback).getContext();
            this.f5464e = map;
            m5634a(interfaceC1084b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5634a(ImageAssetDelegate_2 interfaceC1084b) {
        this.f5463d = interfaceC1084b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m5633a(String str) {
        LottieImageAsset c1196g = this.f5464e.get(str);
        if (c1196g == null) {
            return null;
        }
        Bitmap bitmapM6162e = c1196g.m6162e();
        if (bitmapM6162e != null) {
            return bitmapM6162e;
        }
        ImageAssetDelegate_2 interfaceC1084b = this.f5463d;
        if (interfaceC1084b != null) {
            Bitmap bitmapM5627a = interfaceC1084b.m5627a(c1196g);
            if (bitmapM5627a != null) {
                m5632a(str, bitmapM5627a);
            }
            return bitmapM5627a;
        }
        String strM6161d = c1196g.m6161d();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strM6161d.startsWith("data:") && strM6161d.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strM6161d.substring(strM6161d.indexOf(44) + 1), 0);
                return m5632a(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                Logger_3.m6099a("data URL did not have correct base64 format.", COUIBaseListPopupWindow_8);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f5462c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return m5632a(str, Utils_4.m6143a(BitmapFactory.decodeStream(this.f5461b.getAssets().open(this.f5462c + strM6161d), null, options), c1196g.m6157a(), c1196g.m6159b()));
            } catch (IllegalArgumentException e2) {
                Logger_3.m6099a("Unable to decode image.", e2);
                return null;
            }
        } catch (IOException e3) {
            Logger_3.m6099a("Unable to open asset.", e3);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5635a(Context context) {
        return (context == null && this.f5461b == null) || this.f5461b.equals(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m5632a(String str, Bitmap bitmap) {
        synchronized (f5460a) {
            this.f5464e.get(str).m6158a(bitmap);
        }
        return bitmap;
    }
}
