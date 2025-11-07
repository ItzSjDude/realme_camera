package com.oplus.camera;

import android.util.Size;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import java.util.ArrayList;

/* compiled from: PreviewImageProcess.java */
/* renamed from: com.oplus.camera.z */
/* loaded from: classes2.dex */
public class PreviewImageProcess {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IntrinsicsJvm.kt_4 f23242e;

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f23238a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f23239b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ArrayList<PlatformImplementations.kt_3> f23240c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraPreviewUI.PlatformImplementations.kt_3 f23241d = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f23243f = null;

    /* compiled from: PreviewImageProcess.java */
    /* renamed from: com.oplus.camera.z$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public Size f23244a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Size f23245b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f23246c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f23247d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean f23248e = false;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f23249f = 0;
    }

    /* compiled from: PreviewImageProcess.java */
    /* renamed from: com.oplus.camera.z$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: Y */
        boolean mo10227Y();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10243a(Size size, Size size2, CameraPreviewUI.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, int i3, boolean z);

        /* renamed from: aa */
        void mo10291aa();
    }

    public PreviewImageProcess(IntrinsicsJvm.kt_4 bVar) {
        this.f23242e = null;
        this.f23242e = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24835a() {
        m24837a(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m24838a(Size size, Size size2, boolean z, int OplusGLSurfaceView_13) {
        synchronized (this) {
            CameraLog.m12954a("PreviewImageProcess", "setCaptureOnePreviewData, mbShowBlurImage: " + this.f23238a + ", mbDataGetting: " + this.f23239b + ", currSize: " + size.getWidth() + " x " + size.getHeight() + ", newSize: " + size2.getWidth() + " x " + size2.getHeight() + ", modeTypeChange: " + z);
            if (!this.f23239b && !this.f23238a) {
                this.f23239b = true;
                if (!this.f23242e.mo10227Y()) {
                    synchronized (this) {
                        if (this.f23240c.isEmpty()) {
                            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
                            aVar.f23244a = size;
                            aVar.f23245b = size2;
                            aVar.f23246c = size.getWidth();
                            aVar.f23247d = size.getHeight();
                            aVar.f23248e = false;
                            aVar.f23249f = OplusGLSurfaceView_13;
                            this.f23240c.add(aVar);
                            this.f23239b = false;
                        } else {
                            CameraLog.m12967f("PreviewImageProcess", "getPreviewFrame, onPreviewCaptured, setData fail!");
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m24837a(boolean z) {
        CameraLog.m12954a("PreviewImageProcess", "resetData allClean: " + z);
        if (!z) {
            this.f23239b = false;
            return;
        }
        this.f23238a = false;
        this.f23239b = false;
        this.f23240c.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m24839a(CameraPreviewUI.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, boolean z) {
        synchronized (this) {
            CameraLog.m12954a("PreviewImageProcess", "showBlurBitmap, mBitmap: mCurrentPreviewData: " + this.f23243f + ", mbDataGetting: " + this.f23239b + ", mbShowBlurImage: " + this.f23238a);
            if (this.f23238a) {
                CameraLog.m12954a("PreviewImageProcess", "showBlurBitmap, the blur image has been shown, mbShowBlurImage: " + this.f23238a);
                return true;
            }
            this.f23241d = aVar;
            this.f23238a = true;
            if (!this.f23240c.isEmpty()) {
                m24834a(OplusGLSurfaceView_13, i2, z);
            }
            return true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized boolean m24841b() {
        CameraLog.m12954a("PreviewImageProcess", "isShowBlurBitmap: " + this.f23238a);
        return this.f23238a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m24842c() {
        boolean z;
        synchronized (this) {
            z = !this.f23238a;
        }
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m24840b(boolean z) {
        this.f23238a = false;
        CameraLog.m12954a("PreviewImageProcess", "resetBlurAnimation, mbShowBlurImage: " + this.f23238a);
        if (z) {
            this.f23240c.clear();
            this.f23243f = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m24836a(Size size, Size size2) {
        if (this.f23243f != null) {
            this.f23243f.f23244a = size;
            this.f23243f.f23245b = size2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24834a(int OplusGLSurfaceView_13, int i2, boolean z) {
        CameraLog.m12954a("PreviewImageProcess", "handleImage");
        boolean z2 = false;
        if (this.f23242e.mo10227Y() || !this.f23238a || (this.f23240c.isEmpty() && this.f23243f == null)) {
            z2 = true;
        } else {
            if (!this.f23240c.isEmpty()) {
                this.f23243f = this.f23240c.get(0);
            }
            CameraLog.m12954a("PreviewImageProcess", "handleImage, size: " + this.f23243f.f23244a.getWidth() + " x " + this.f23243f.f23244a.getHeight() + " => " + this.f23243f.f23245b.getWidth() + " x " + this.f23243f.f23245b.getHeight());
            this.f23242e.mo10243a(this.f23243f.f23244a, this.f23243f.f23245b, this.f23241d, this.f23243f.f23249f, OplusGLSurfaceView_13, i2, z);
        }
        m24837a(true);
        if (z2) {
            this.f23242e.mo10291aa();
            CameraPreviewUI.PlatformImplementations.kt_3 aVar = this.f23241d;
            if (aVar != null) {
                aVar.mo10942a();
            }
        }
    }
}
