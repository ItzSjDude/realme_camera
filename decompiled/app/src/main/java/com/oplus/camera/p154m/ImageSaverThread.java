package com.oplus.camera.p154m;

import android.app.Activity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageSaverThread.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_6.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ImageSaverThread extends ProcessQueueThread {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static ImageSaverThread f14700d;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private MemoryMonitor f14702c = new MemoryMonitor();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ExecutorService f14701b = Executors.newSingleThreadExecutor();

    @Override // com.oplus.camera.p154m.ProcessQueueThread
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo14693b() {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14698c() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ImageSaverThread m14696a() {
        ImageSaverThread c2810b;
        synchronized (ImageSaverThread.class) {
            if (f14700d == null) {
                f14700d = new ImageSaverThread();
            }
            c2810b = f14700d;
        }
        return c2810b;
    }

    private ImageSaverThread() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14697a(Activity activity, long OplusGLSurfaceView_15) {
        MemoryMonitor c2811c = this.f14702c;
        if (c2811c != null) {
            return c2811c.m14700a(activity, OplusGLSurfaceView_15);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x024f  */
    @Override // com.oplus.camera.p154m.ProcessQueueThread
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo14694b(final com.oplus.camera.Storage.CameraPicture r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p154m.ImageSaverThread.mo14694b(com.oplus.camera.Storage$CameraPicture):void");
    }
}
