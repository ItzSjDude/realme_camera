package com.oplus.camera.algovisualization;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ThreadUtils.java */
/* renamed from: com.oplus.camera.algovisualization.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class ThreadUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Handler f12532a = new Handler(Looper.getMainLooper());

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Executor f12533b = Executors.newSingleThreadExecutor();

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11634a(Runnable runnable) {
        f12533b.execute(runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m11635b(Runnable runnable) {
        f12532a.post(runnable);
    }
}
