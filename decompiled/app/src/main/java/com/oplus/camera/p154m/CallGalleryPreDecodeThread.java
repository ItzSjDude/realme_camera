package com.oplus.camera.p154m;

import com.oplus.camera.CameraLog;
import com.oplus.camera.GalleryPreCodeClient;
import com.oplus.camera.Storage;
import com.oplus.camera.util.Util;

/* compiled from: CallGalleryPreDecodeThread.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_6.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CallGalleryPreDecodeThread extends ProcessQueueThread {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static CallGalleryPreDecodeThread f14697c;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private GalleryPreCodeClient f14698b = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static CallGalleryPreDecodeThread m14689a() {
        CallGalleryPreDecodeThread c2809a;
        synchronized (CallGalleryPreDecodeThread.class) {
            if (f14697c == null) {
                f14697c = new CallGalleryPreDecodeThread();
            }
            c2809a = f14697c;
        }
        return c2809a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14692a(Storage.CameraPicture cameraPicture) {
        m14708d();
        if (cameraPicture == null || !cameraPicture.f12105C) {
            return;
        }
        m14707c(cameraPicture);
    }

    @Override // com.oplus.camera.p154m.ProcessQueueThread
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo14693b() {
        synchronized (this) {
            if (this.f14698b == null) {
                this.f14698b = new GalleryPreCodeClient();
                this.f14698b.m14717a(Util.m24472l());
            }
        }
    }

    @Override // com.oplus.camera.p154m.ProcessQueueThread
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo14694b(Storage.CameraPicture cameraPicture) throws Exception {
        CameraLog.m12954a("CallGalleryPreDecodeThread", "handlePicture, callGallery");
        GalleryPreCodeClient c2813n = this.f14698b;
        if (c2813n != null) {
            c2813n.m14718a(Util.m24472l(), cameraPicture.f12130c, cameraPicture.mPath, cameraPicture.f12139l, cameraPicture.f12104B);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14695c() {
        if (this.f14713a != null) {
            this.f14713a.submit(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_6.PlatformImplementations.kt_3.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CallGalleryPreDecodeThread.this) {
                        if (CallGalleryPreDecodeThread.this.f14698b != null) {
                            CallGalleryPreDecodeThread.this.f14698b.m14719b(Util.m24472l());
                            CallGalleryPreDecodeThread.this.f14698b = null;
                        }
                    }
                }
            });
        }
    }
}
