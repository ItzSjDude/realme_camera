package org.andresoviedo.p225a.p226a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContentUtils.java */
/* renamed from: org.andresoviedo.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ContentUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, Uri> f24801a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ThreadLocal<Context> f24802b = new ThreadLocal<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static File f24803c = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m26074a(Context context) {
        Log.OplusGLSurfaceView_13("ContentUtils", "Current activity thread: " + Thread.currentThread().getName());
        f24802b.set(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m26075a(File file) {
        f24803c = file;
    }
}
