package com.oplus.camera.p172ui.preview.p177a;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.doubleexposure.DecodeVideoRequest;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p146gl.p148b.OesDrawerEngine;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.tiltshift.TiltShiftParam;

/* compiled from: PreviewEffectProcess.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.t */
/* loaded from: classes2.dex */
public interface PreviewEffectProcess {

    /* compiled from: PreviewEffectProcess.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.t$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo10418a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        DetectResult mo10419a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10420a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10421a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10422a(DetectResult c3077a);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo10423a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        Rect[] mo10424a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10425b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10426b(String str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    RawTexture mo22775a(GLCanvas interfaceC2757h, ExtTexture c2756g, RawTexture c2768s, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22776a();

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22777a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22778a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22779a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22780a(long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22781a(Point point);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22782a(Size size, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22783a(BaseSloganUtil.PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22784a(DecodeVideoRequest c2684c);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22785a(GLRootView gLRootView);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22786a(SurfaceTextureScreenNail abstractC2769t);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22787a(StickerItem stickerItem);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22788a(TiltShiftParam tiltShiftParam);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22789a(TexturePreviewRequest.IntrinsicsJvm.kt_4 bVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22790a(FilterTexturePreview.PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22791a(PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22792a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22793a(String str, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22794a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22795a(boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22796a(byte[] bArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22797a(float[] fArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo22798a(int[] iArr);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22799a(ExtTexture c2756g, RawTexture c2768s);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22800a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22801a(GLCanvas interfaceC2757h, OesDrawerEngine c2749f, RawTexture c2768s, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22802a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22803a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, CameraApsResult cameraApsResult, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22804a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22805a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo22806a(byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2, int i3);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22807b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22808b(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22809b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22810b(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22811b(long OplusGLSurfaceView_15);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22812b(String str);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22813b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo22814b(int[] iArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo22815b(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo22816b(StickerItem stickerItem);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo22817c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo22818c(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo22819c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo22820c(boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo22821c(int[] iArr);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo22822d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo22823d(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo22824d(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo22825d(boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo22826e(float COUIBaseListPopupWindow_12);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo22827e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo22828e(boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo22829e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo22830f(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo22831f(boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean mo22832f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo22833g();

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo22834g(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo22835g(boolean z);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo22836h();

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo22837h(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo22838h(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo22839i();

    /* renamed from: OplusGLSurfaceView_13 */
    void mo22840i(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo22841i(boolean z);

    /* renamed from: OplusGLSurfaceView_15 */
    StickerItem mo22842j();

    /* renamed from: OplusGLSurfaceView_15 */
    TexturePreview mo22843j(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo22844j(boolean z);

    /* renamed from: OplusGLSurfaceView_5 */
    int mo22845k();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo22846k(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo22847k(boolean z);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo22848l(boolean z);

    /* renamed from: OplusGLSurfaceView_14 */
    boolean mo22849l();

    /* renamed from: OplusGLSurfaceView_6 */
    float mo22850m();

    /* renamed from: OplusGLSurfaceView_6 */
    void mo22851m(boolean z);

    /* renamed from: OplusGLSurfaceView_11 */
    float mo22852n();

    /* renamed from: OplusGLSurfaceView_11 */
    void mo22853n(boolean z);

    /* renamed from: o */
    void mo22854o();

    /* renamed from: p */
    void mo22855p();

    /* renamed from: q */
    void mo22856q();

    /* renamed from: r */
    void mo22857r();
}
