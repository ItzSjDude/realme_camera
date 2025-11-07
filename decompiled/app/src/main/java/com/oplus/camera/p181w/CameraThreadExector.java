package com.oplus.camera.p181w;

import com.oplus.camera.CameraLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CameraThreadExector.java */
/* renamed from: com.oplus.camera.w.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CameraThreadExector {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f23145a = Runtime.getRuntime().availableProcessors();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int f23146b = Math.max(2, Math.min(f23145a - 1, 4));

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int f23147c = (f23145a * 2) + 1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static volatile CameraThreadExector f23148f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f23149d = new PlatformImplementations.kt_3();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final ThreadPoolExecutor f23150e = new ThreadPoolExecutor(f23146b, f23147c, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), this.f23149d);

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraThreadExector m24695a() {
        if (f23148f == null) {
            synchronized (CameraThreadExector.class) {
                if (f23148f == null) {
                    f23148f = new CameraThreadExector();
                }
            }
        }
        return f23148f;
    }

    private CameraThreadExector() {
        this.f23150e.allowCoreThreadTimeOut(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ThreadPoolExecutor m24697b() {
        return this.f23150e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24696a(Runnable runnable, String str) {
        this.f23149d.m24700a(str);
        this.f23150e.execute(runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24698c() {
        this.f23150e.shutdown();
    }

    /* compiled from: CameraThreadExector.java */
    /* renamed from: com.oplus.camera.w.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements ThreadFactory {

        /* renamed from: PlatformImplementations.kt_3 */
        String f23151a;

        private PlatformImplementations.kt_3() {
            this.f23151a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m24700a(String str) {
            CameraLog.m12954a("CameraThreadExector", "thread name: " + str);
            this.f23151a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.f23151a == null) {
                CameraLog.m12967f("CameraThreadExector", "thread name is null");
                this.f23151a = "CameraThreadExector";
            }
            Thread thread = new Thread(runnable, this.f23151a);
            thread.setPriority(5);
            return thread;
        }
    }
}
