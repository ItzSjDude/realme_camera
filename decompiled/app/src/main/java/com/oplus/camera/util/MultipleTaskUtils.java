package com.oplus.camera.util;

import com.oplus.camera.CameraLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: MultipleTaskUtils.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class MultipleTaskUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 f23082a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ScheduledThreadPoolExecutor f23083b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ConcurrentHashMap<String, ScheduledFuture> f23084c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static MultipleTaskUtils m24579a() {
        return PlatformImplementations.kt_3.f23085a;
    }

    private MultipleTaskUtils() {
        this.f23082a = new IntrinsicsJvm.kt_4();
        this.f23083b = null;
        this.f23084c = new ConcurrentHashMap<>();
        this.f23083b = new ScheduledThreadPoolExecutor(1, this.f23082a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24580a(long OplusGLSurfaceView_15, String str, Runnable runnable) {
        this.f23082a.m24584a(str);
        if (this.f23084c.containsKey(str)) {
            this.f23084c.get(str).cancel(true);
        }
        this.f23084c.put(str, this.f23083b.schedule(runnable, OplusGLSurfaceView_15, TimeUnit.MILLISECONDS));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24581a(String str) {
        if (this.f23084c.containsKey(str)) {
            this.f23084c.get(str).cancel(true);
        }
    }

    /* compiled from: MultipleTaskUtils.java */
    /* renamed from: com.oplus.camera.util.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final MultipleTaskUtils f23085a = new MultipleTaskUtils();
    }

    /* compiled from: MultipleTaskUtils.java */
    /* renamed from: com.oplus.camera.util.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements ThreadFactory {

        /* renamed from: PlatformImplementations.kt_3 */
        String f23086a;

        private IntrinsicsJvm.kt_4() {
            this.f23086a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m24584a(String str) {
            this.f23086a = str;
            CameraLog.m12954a("MultipleTaskUtils", "setName，name: " + str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.f23086a == null) {
                CameraLog.m12967f("MultipleTaskUtils", "newThread，mName is null");
                this.f23086a = "MultipleTaskUtils";
            }
            Thread thread = new Thread(runnable, this.f23086a);
            thread.setPriority(5);
            return thread;
        }
    }
}
