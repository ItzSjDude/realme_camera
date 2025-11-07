package com.oplus.camera.watch;

import android.util.Size;
import com.oplus.camera.CameraLog;

/* compiled from: WatchAgentHolder.java */
/* renamed from: com.oplus.camera.watch.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
class WatchAgentHolder {

    /* renamed from: PlatformImplementations.kt_3 */
    private Size f23175a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Size f23176b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f23177c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f23178d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f23179e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f23180f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f23181g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f23182h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f23183i = false;

    WatchAgentHolder() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m24735a() {
        return this.f23176b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24737a(Size size) {
        CameraLog.m12954a("WatchAgentHolder", "setCameraPreviewSize, cameraPreviewSize: " + size);
        this.f23176b = size;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24741b(Size size) {
        CameraLog.m12954a("WatchAgentHolder", "setWatchPreviewSize, watchPreviewSize: " + size);
        this.f23175a = size;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Size m24739b() {
        return this.f23175a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Size m24742c() {
        int height;
        int height2;
        if (this.f23175a == null || this.f23176b == null) {
            CameraLog.m12954a("WatchAgentHolder", "createCodecSize, mWatchSize or mCameraSize is null");
            return null;
        }
        float height3 = r0.getHeight() / this.f23175a.getWidth();
        float width = this.f23176b.getWidth() / this.f23176b.getHeight();
        if (height3 > width) {
            height = this.f23175a.getWidth();
            height2 = (int) ((this.f23176b.getHeight() / this.f23176b.getWidth()) * this.f23175a.getWidth());
        } else {
            height = (int) ((this.f23176b.getHeight() / this.f23176b.getWidth()) * this.f23175a.getHeight());
            height2 = this.f23175a.getHeight();
        }
        if (height % 2 != 0) {
            height++;
        }
        if (height2 % 2 != 0) {
            height2++;
        }
        CameraLog.m12954a("WatchAgentHolder", "createCodecSize, watchRatio: " + height3 + ", cameraRatio: " + width + ", codecWidth: " + height + ", codecHeight: " + height2);
        return new Size(height, height2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m24744d() {
        return this.f23177c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24736a(int OplusGLSurfaceView_13) {
        this.f23177c = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m24746e() {
        return this.f23178d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24740b(int OplusGLSurfaceView_13) {
        this.f23178d = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m24748f() {
        return this.f23179e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24743c(int OplusGLSurfaceView_13) {
        this.f23179e = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m24750g() {
        return this.f23180f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24745d(int OplusGLSurfaceView_13) {
        this.f23180f = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m24751h() {
        return this.f23181g;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m24747e(int OplusGLSurfaceView_13) {
        this.f23181g = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m24752i() {
        return this.f23182h;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m24749f(int OplusGLSurfaceView_13) {
        this.f23182h = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24738a(boolean z) {
        this.f23183i = z;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m24753j() {
        return this.f23183i;
    }
}
