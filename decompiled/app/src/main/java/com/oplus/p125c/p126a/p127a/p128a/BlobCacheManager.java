package com.oplus.p125c.p126a.p127a.p128a;

import android.content.Context;
import com.oplus.p125c.p126a.LightGalleryConfig.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: BlobCacheManager.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class BlobCacheManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final HashMap<String, BlobCache> f10496a = new HashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public static BlobCache m9402a(Context context, String str, int OplusGLSurfaceView_13, int i2, int i3) {
        synchronized (f10496a) {
            if (f10496a.get(str) == null) {
                Debugger.kt.m9503a("CacheManager", "getCacheDir, filename:" + str);
                long jCurrentTimeMillis = System.currentTimeMillis();
                File fileM9403a = m9403a(context);
                if (fileM9403a != null) {
                    String str2 = fileM9403a.getAbsolutePath() + "/" + str;
                    Debugger.kt.m9503a("CacheManager", "getCacheDir:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    try {
                        BlobCache c2429a = new BlobCache(str2, OplusGLSurfaceView_13, i2, false, i3);
                        f10496a.put(str, c2429a);
                        return c2429a;
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        Debugger.kt.m9508c("CacheManager", "Cannot instantiate cache!", COUIBaseListPopupWindow_8);
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static File m9403a(Context context) {
        File fileM9439a = LightGalleryConfig.kt.m9439a();
        if (fileM9439a != null) {
            return m9404a(fileM9439a);
        }
        return m9404a(context.getExternalCacheDir());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9405a(Context context, String str) {
        BlobCache.m9384a(m9403a(context) + "/" + str);
        f10496a.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static File m9404a(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
