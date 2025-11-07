package com.oplus.anim;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.oplus.anim.p115c.EffectiveCompositionCache;
import com.oplus.anim.p119d.NetworkFetcher;
import com.oplus.anim.p120e.EffectiveCompositionParser;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p121f.Utils_2;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: EffectiveCompositionFactory.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class EffectiveCompositionFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<String, EffectiveAnimationTask<EffectiveAnimationComposition>> f10395a = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9304a(final Context context, final String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromUrl url = " + str.toString());
        }
        return m9307a("url_" + str, new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.1
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                return NetworkFetcher.m9149a(context, str);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9314b(Context context, final String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromAsset fileName = " + str.toString());
        }
        final Context applicationContext = context.getApplicationContext();
        return m9307a(str, new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.5
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                return EffectiveCompositionFactory.m9316c(applicationContext, str);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9305a(final AssetManager assetManager, final String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromAsset fileName = " + str.toString());
        }
        return m9307a(str, new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.6
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                return EffectiveCompositionFactory.m9311b(assetManager, str);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9316c(Context context, String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromAssetSync fileName = " + str.toString());
        }
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return m9301a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return m9299a(context.getAssets().open(str), str2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new EffectiveAnimationResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9311b(AssetManager assetManager, String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromAssetSync fileName = " + str.toString());
        }
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return m9301a(new ZipInputStream(assetManager.open(str)), str2);
            }
            return m9299a(assetManager.open(str), str2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new EffectiveAnimationResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9303a(Context context, final int OplusGLSurfaceView_13) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromRawRes.");
        }
        final Context applicationContext = context.getApplicationContext();
        return m9307a(m9309a(OplusGLSurfaceView_13), new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.7
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                return EffectiveCompositionFactory.m9315c(applicationContext, OplusGLSurfaceView_13);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9313b(Context context, final int OplusGLSurfaceView_13) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromRawResUsingActivityContext.");
        }
        final WeakReference weakReference = new WeakReference(context);
        return m9307a(m9309a(OplusGLSurfaceView_13), new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.8
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                WeakReference weakReference2 = weakReference;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return null;
                }
                return EffectiveCompositionFactory.m9315c((Context) weakReference.get(), OplusGLSurfaceView_13);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9315c(Context context, int OplusGLSurfaceView_13) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromRawResSync.");
        }
        try {
            return m9299a(context.getResources().openRawResource(OplusGLSurfaceView_13), m9309a(OplusGLSurfaceView_13));
        } catch (Resources.NotFoundException COUIBaseListPopupWindow_8) {
            return new EffectiveAnimationResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m9309a(int OplusGLSurfaceView_13) {
        return "rawRes_" + OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9299a(InputStream inputStream, String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromJsonInputStreamSync cacheKey = " + str);
        }
        return m9300a(inputStream, str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static EffectiveAnimationResult<EffectiveAnimationComposition> m9300a(InputStream inputStream, String str, boolean z) throws IOException {
        try {
            return m9312b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                Utils_2.m9295a(inputStream);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationTask<EffectiveAnimationComposition> m9306a(final JsonReader jsonReader, final String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromJsonReader cacheKey = " + str);
        }
        return m9307a(str, new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.9
            @Override // java.util.concurrent.Callable
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                return EffectiveCompositionFactory.m9312b(jsonReader, str);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9312b(JsonReader jsonReader, String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromJsonReaderSync cacheKey = " + str);
        }
        return m9298a(jsonReader, str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static EffectiveAnimationResult<EffectiveAnimationComposition> m9298a(JsonReader jsonReader, String str, boolean z) throws IOException {
        try {
            try {
                EffectiveAnimationComposition c2272aM9192a = EffectiveCompositionParser.m9192a(jsonReader);
                EffectiveCompositionCache.m9062a().m9064a(str, c2272aM9192a);
                EffectiveAnimationResult<EffectiveAnimationComposition> c2365e = new EffectiveAnimationResult<>(c2272aM9192a);
                if (z) {
                    Utils_2.m9295a(jsonReader);
                }
                return c2365e;
            } catch (Exception COUIBaseListPopupWindow_8) {
                EffectiveAnimationResult<EffectiveAnimationComposition> c2365e2 = new EffectiveAnimationResult<>(COUIBaseListPopupWindow_8);
                if (z) {
                    Utils_2.m9295a(jsonReader);
                }
                return c2365e2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils_2.m9295a(jsonReader);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9301a(ZipInputStream zipInputStream, String str) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromZipStreamSync cacheKey = " + str);
        }
        try {
            return m9302a(zipInputStream, str, (BitmapFactory.Options) null);
        } finally {
            Utils_2.m9295a(zipInputStream);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static EffectiveAnimationResult<EffectiveAnimationComposition> m9302a(ZipInputStream zipInputStream, String str, BitmapFactory.Options options) throws IOException {
        HashMap map = new HashMap();
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveCompositionFactory::fromZipStreamSyncInternal cacheKey = " + str);
        }
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (OplusLog.f10386b) {
                StringBuilder sb = new StringBuilder();
                sb.append("EffectiveCompositionFactory::fromZipStreamSyncInternal entry == null ? ");
                sb.append(nextEntry == null);
                OplusLog.m9286b(sb.toString());
            }
            EffectiveAnimationComposition c2272aM9154a = null;
            while (nextEntry != null) {
                if (OplusLog.f10386b) {
                    OplusLog.m9286b("EffectiveCompositionFactory::fromZipStreamSyncInternal entry.getName() = " + nextEntry.getName());
                }
                if (nextEntry.getName().contains("__MACOSX") || nextEntry.getName().contains("../")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    c2272aM9154a = m9298a(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).m9154a();
                } else if (nextEntry.getName().endsWith(".png")) {
                    String[] strArrSplit = nextEntry.getName().split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream, null, options));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c2272aM9154a == null) {
                return new EffectiveAnimationResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                EffectiveImageAsset c2416hM9308a = m9308a(c2272aM9154a, (String) entry.getKey());
                if (c2416hM9308a != null) {
                    c2416hM9308a.m9341a((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, EffectiveImageAsset> entry2 : c2272aM9154a.m8801l().entrySet()) {
                if (entry2.getValue().m9343c() == null) {
                    return new EffectiveAnimationResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().m9342b()));
                }
            }
            EffectiveCompositionCache.m9062a().m9064a(str, c2272aM9154a);
            return new EffectiveAnimationResult<>(c2272aM9154a);
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new EffectiveAnimationResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static EffectiveImageAsset m9308a(EffectiveAnimationComposition c2272a, String str) {
        for (EffectiveImageAsset c2416h : c2272a.m8801l().values()) {
            if (c2416h.m9342b().equals(str)) {
                return c2416h;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static EffectiveAnimationTask<EffectiveAnimationComposition> m9307a(final String str, Callable<EffectiveAnimationResult<EffectiveAnimationComposition>> callable) {
        final EffectiveAnimationComposition c2272aM9063a = str == null ? null : EffectiveCompositionCache.m9062a().m9063a(str);
        float COUIBaseListPopupWindow_12 = Resources.getSystem().getDisplayMetrics().density;
        if (c2272aM9063a != null && c2272aM9063a.m8803n() == COUIBaseListPopupWindow_12) {
            OplusLog.m9286b("EffectiveCompositionFactory::cached Composition isn't null, cacheKey is " + str);
            return new EffectiveAnimationTask<>(new Callable<EffectiveAnimationResult<EffectiveAnimationComposition>>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.2
                @Override // java.util.concurrent.Callable
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public EffectiveAnimationResult<EffectiveAnimationComposition> call() {
                    return new EffectiveAnimationResult<>(c2272aM9063a);
                }
            }, true);
        }
        if (c2272aM9063a != null && c2272aM9063a.m8803n() != COUIBaseListPopupWindow_12) {
            Utils_2.m9297b();
            OplusLog.m9286b("EffectiveCompositionFactory::cachedComposition density = " + c2272aM9063a.m8803n() + "; curDensity = " + COUIBaseListPopupWindow_12);
        }
        if (str != null && f10395a.containsKey(str)) {
            return f10395a.get(str);
        }
        EffectiveAnimationTask<EffectiveAnimationComposition> c2402f = new EffectiveAnimationTask<>(callable);
        c2402f.m9238a(new EffectiveAnimationListener<EffectiveAnimationComposition>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.3
            @Override // com.oplus.anim.EffectiveAnimationListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo8781a(EffectiveAnimationComposition c2272a) {
                EffectiveCompositionFactory.f10395a.remove(str);
            }
        });
        c2402f.m9240b(new EffectiveAnimationListener<Throwable>() { // from class: com.oplus.anim.COUIBaseListPopupWindow_11.4
            @Override // com.oplus.anim.EffectiveAnimationListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo8781a(Throwable th) {
                EffectiveCompositionFactory.f10395a.remove(str);
            }
        });
        f10395a.put(str, c2402f);
        return c2402f;
    }
}
