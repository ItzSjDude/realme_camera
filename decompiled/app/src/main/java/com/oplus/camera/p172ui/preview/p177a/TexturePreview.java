package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.doubleexposure.DecodeVideoRequest;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p171u.DetectResult;

/* compiled from: TexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.y */
/* loaded from: classes2.dex */
public abstract class TexturePreview {

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected String f21541e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f21542f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean f21543g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected GLRootView f21544h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    protected IntrinsicsJvm.kt_4 f21545i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    protected Context f21546j;

    /* compiled from: TexturePreview.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.y$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo22924a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        DetectResult mo22925a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22926a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22927a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22928a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22929a(DetectResult c3077a);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22930a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        Rect[] mo22931b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22957a(long OplusGLSurfaceView_15) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22523a(Size size, boolean z) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22279a(DecodeVideoRequest c2684c) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo22280a(GLCanvas interfaceC2757h);

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo22281a(TexturePreviewRequest c3397aa);

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22524a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22558a(byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo22282a();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo22283a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo22284a(PlatformImplementations.kt_3 aVar);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo22285b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo22287c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract int mo22289d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22457d(int OplusGLSurfaceView_13) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract void mo22290e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract RawTexture mo22291f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract RawTexture mo22292g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    public abstract boolean mo22293h();

    /* renamed from: OplusGLSurfaceView_13 */
    public abstract void mo22294i();

    /* renamed from: OplusGLSurfaceView_15 */
    public abstract void mo22295j();

    /* renamed from: OplusGLSurfaceView_5 */
    public int mo22559k() {
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public int mo22560l() {
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void mo22958m() {
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void mo22959n() {
    }

    /* renamed from: o */
    public void mo22960o() {
    }

    /* renamed from: p */
    public void mo22961p() {
    }

    /* renamed from: u */
    public void mo22296u() {
    }

    /* renamed from: v */
    public void mo22297v() {
    }

    /* renamed from: w */
    public void mo22298w() {
    }

    /* renamed from: x */
    public void mo22299x() {
    }

    /* renamed from: y */
    public boolean mo22428y() {
        return false;
    }

    /* renamed from: z */
    public int[] mo22437z() {
        return null;
    }

    /* renamed from: s */
    public void m22966s() {
        this.f21546j = null;
    }

    /* renamed from: a_ */
    public boolean mo22673a_(int OplusGLSurfaceView_13) {
        return (CameraCharacteristicsUtil.m12971a(this.f21541e, this.f21542f).m13249F().isPreviewAlgoDisable(mo22289d()) || (mo22289d() & OplusGLSurfaceView_13) == 0) ? false : true;
    }

    /* compiled from: TexturePreview.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.y$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public GLCanvas f21547a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ExtTexture f21548b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public RawTexture f21549c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public RawTexture f21550d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public CameraApsResult f21551e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean f21552f = false;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean f21553g = false;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean f21554h = false;

        /* renamed from: OplusGLSurfaceView_13 */
        public float[] f21555i = null;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f21556j = 0;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f21557k = 0;

        /* renamed from: OplusGLSurfaceView_14 */
        public int f21558l = 0;

        /* renamed from: OplusGLSurfaceView_6 */
        public int f21559m = 0;

        /* renamed from: OplusGLSurfaceView_11 */
        public int f21560n = 0;

        /* renamed from: o */
        public int f21561o = 0;

        public PlatformImplementations.kt_3() {
        }

        public String toString() {
            return "FrameInfo: mExtTexture: " + this.f21548b + ", mInTexture: " + this.f21549c + ", mWidth: " + this.f21556j + ", mHeight: " + this.f21557k + ", mRequestRenderType: " + this.f21560n + ", mOrientation: " + this.f21561o + ", mbApsAlgoInitFinish: " + this.f21554h;
        }
    }

    /* renamed from: t */
    public PlatformImplementations.kt_3 m22967t() {
        return new PlatformImplementations.kt_3();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22533a(IntrinsicsJvm.kt_4 bVar) {
        this.f21545i = bVar;
    }

    public TexturePreview(Context context) {
        this.f21546j = null;
        this.f21546j = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22964a(GLRootView gLRootView) {
        this.f21544h = gLRootView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22965a(String str, int OplusGLSurfaceView_13) {
        this.f21541e = str;
        this.f21542f = OplusGLSurfaceView_13;
        this.f21543g = CameraCharacteristicsUtil.m12974a(this.f21542f);
    }
}
