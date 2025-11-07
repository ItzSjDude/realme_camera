package com.oplus.camera.algovisualization;

/* compiled from: ThreadUtils.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.os.Handler f4165a = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.concurrent.Executor f4166b = java.util.concurrent.Executors.newSingleThreadExecutor();

    public static void a_renamed(java.lang.Runnable runnable) {
        f4166b.execute(runnable);
    }

    public static void b_renamed(java.lang.Runnable runnable) {
        f4165a.post(runnable);
    }
}
