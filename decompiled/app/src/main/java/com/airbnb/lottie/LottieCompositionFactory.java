package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.p084c.LottieCompositionCache;
import com.airbnb.lottie.p089e.LottieCompositionMoshiParser;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.Utils_4;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class LottieCompositionFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<String, LottieTask<LottieComposition>> f5728a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final byte[] f5729b = {80, 75, 3, 4};

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieTask<LottieComposition> m5886a(Context context, String str) {
        return m5887a(context, str, "url_" + str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieTask<LottieComposition> m5887a(final Context context, final String str, final String str2) {
        return m5889a(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.1
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public LottieResult<LottieComposition> call() {
                LottieResult<LottieComposition> c1206lM5878a = L_2.m5636a(context).m5878a(str, str2);
                if (str2 != null && c1206lM5878a.m6179a() != null) {
                    LottieCompositionCache.m5834a().m5836a(str2, c1206lM5878a.m6179a());
                }
                return c1206lM5878a;
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static LottieTask<LottieComposition> m5897b(Context context, String str) {
        return m5898b(context, str, "asset_" + str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static LottieTask<LottieComposition> m5898b(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return m5889a(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.4
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.m5900c(applicationContext, str, str2);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static LottieResult<LottieComposition> m5899c(Context context, String str) {
        return m5900c(context, str, "asset_" + str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static LottieResult<LottieComposition> m5900c(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return m5895b(context.getAssets().open(str), str2);
            }
            return m5883a(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new LottieResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieTask<LottieComposition> m5884a(Context context, int OplusGLSurfaceView_13) {
        return m5885a(context, OplusGLSurfaceView_13, m5901c(context, OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieTask<LottieComposition> m5885a(Context context, final int OplusGLSurfaceView_13, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return m5889a(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.5
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public LottieResult<LottieComposition> call() {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return LottieCompositionFactory.m5894b(context2, OplusGLSurfaceView_13, str);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static LottieResult<LottieComposition> m5893b(Context context, int OplusGLSurfaceView_13) {
        return m5894b(context, OplusGLSurfaceView_13, m5901c(context, OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static LottieResult<LottieComposition> m5894b(Context context, int OplusGLSurfaceView_13, String str) {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(OplusGLSurfaceView_13)));
            if (m5890a(bufferedSourceBuffer).booleanValue()) {
                return m5883a(new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            return m5895b(bufferedSourceBuffer.inputStream(), str);
        } catch (Resources.NotFoundException COUIBaseListPopupWindow_8) {
            return new LottieResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String m5901c(Context context, int OplusGLSurfaceView_13) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(m5892a(context) ? "_night_" : "_day_");
        sb.append(OplusGLSurfaceView_13);
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5892a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieTask<LottieComposition> m5888a(final InputStream inputStream, final String str) {
        return m5889a(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.6
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.m5895b(inputStream, str);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static LottieResult<LottieComposition> m5895b(InputStream inputStream, String str) {
        return m5882a(inputStream, str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static LottieResult<LottieComposition> m5882a(InputStream inputStream, String str, boolean z) throws IOException {
        try {
            return m5880a(JsonReader.m5909a(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                Utils_4.m6149a(inputStream);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieResult<LottieComposition> m5880a(JsonReader abstractC1149c, String str) {
        return m5881a(abstractC1149c, str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static LottieResult<LottieComposition> m5881a(JsonReader abstractC1149c, String str, boolean z) throws IOException {
        try {
            try {
                LottieComposition c1136dM6007a = LottieCompositionMoshiParser.m6007a(abstractC1149c);
                if (str != null) {
                    LottieCompositionCache.m5834a().m5836a(str, c1136dM6007a);
                }
                LottieResult<LottieComposition> c1206l = new LottieResult<>(c1136dM6007a);
                if (z) {
                    Utils_4.m6149a(abstractC1149c);
                }
                return c1206l;
            } catch (Exception COUIBaseListPopupWindow_8) {
                LottieResult<LottieComposition> c1206l2 = new LottieResult<>(COUIBaseListPopupWindow_8);
                if (z) {
                    Utils_4.m6149a(abstractC1149c);
                }
                return c1206l2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils_4.m6149a(abstractC1149c);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieResult<LottieComposition> m5883a(ZipInputStream zipInputStream, String str) {
        try {
            return m5896b(zipInputStream, str);
        } finally {
            Utils_4.m6149a(zipInputStream);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static LottieResult<LottieComposition> m5896b(ZipInputStream zipInputStream, String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition c1136dM6179a = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    c1136dM6179a = m5881a(JsonReader.m5909a(Okio.buffer(Okio.source(zipInputStream))), (String) null, false).m6179a();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c1136dM6179a == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                LottieImageAsset c1196gM5879a = m5879a(c1136dM6179a, (String) entry.getKey());
                if (c1196gM5879a != null) {
                    c1196gM5879a.m6158a(Utils_4.m6143a((Bitmap) entry.getValue(), c1196gM5879a.m6157a(), c1196gM5879a.m6159b()));
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : c1136dM6179a.m5859l().entrySet()) {
                if (entry2.getValue().m6162e() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().m6161d()));
                }
            }
            if (str != null) {
                LottieCompositionCache.m5834a().m5836a(str, c1136dM6179a);
            }
            return new LottieResult<>(c1136dM6179a);
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new LottieResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Boolean m5890a(BufferedSource bufferedSource) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : f5729b) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return false;
                }
            }
            bufferedSourcePeek.close();
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Logger_3.m6101b("Failed to check zip file header", COUIBaseListPopupWindow_8);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static LottieImageAsset m5879a(LottieComposition c1136d, String str) {
        for (LottieImageAsset c1196g : c1136d.m5859l().values()) {
            if (c1196g.m6161d().equals(str)) {
                return c1196g;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static LottieTask<LottieComposition> m5889a(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition c1136dM5835a = str == null ? null : LottieCompositionCache.m5834a().m5835a(str);
        if (c1136dM5835a != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.7
                @Override // java.util.concurrent.Callable
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public LottieResult<LottieComposition> call() {
                    return new LottieResult<>(c1136dM5835a);
                }
            });
        }
        if (str != null && f5728a.containsKey(str)) {
            return f5728a.get(str);
        }
        LottieTask<LottieComposition> c1207m = new LottieTask<>(callable);
        if (str != null) {
            c1207m.m6189a(new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.2
                @Override // com.airbnb.lottie.LottieListener
                /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo5520a(LottieComposition c1136d) {
                    LottieCompositionFactory.f5728a.remove(str);
                }
            });
            c1207m.m6191c(new LottieListener<Throwable>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_8.3
                @Override // com.airbnb.lottie.LottieListener
                /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo5520a(Throwable th) {
                    LottieCompositionFactory.f5728a.remove(str);
                }
            });
            f5728a.put(str, c1207m);
        }
        return c1207m;
    }
}
