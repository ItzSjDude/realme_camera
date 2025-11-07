package com.oplus.camera.p141e;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import com.oplus.camera.capmode.p139a.MultiCameraDecision;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p180v.TemperatureProvider;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraRecordingCallback;

/* compiled from: OneCameraProxy.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class OneCameraProxy implements OneCamera {

    /* renamed from: OplusGLSurfaceView_11 */
    private OneCameraImpl f13505n;

    /* renamed from: o */
    private MultiCameraDecision f13506o;

    public OneCameraProxy() {
        this.f13505n = null;
        this.f13506o = null;
        this.f13505n = new OneCameraImpl(1);
        this.f13506o = new MultiCameraDecision();
    }

    /* renamed from: D */
    public MultiCameraDecision m13224D() {
        return this.f13506o;
    }

    /* renamed from: B */
    public boolean m13222B(int OplusGLSurfaceView_13) {
        return this.f13506o != null && 2 == OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13024a(int OplusGLSurfaceView_13) {
        this.f13505n.mo13024a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13064b(int OplusGLSurfaceView_13) {
        if (1 == OplusGLSurfaceView_13) {
            this.f13505n.mo13064b(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13076c(int OplusGLSurfaceView_13) {
        this.f13505n.mo13076c(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13030a(long OplusGLSurfaceView_15) {
        this.f13505n.mo13030a(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13048a(boolean z) {
        this.f13505n.mo13048a(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13027a(int OplusGLSurfaceView_13, OneCamera.IntrinsicsJvm.kt_4 bVar, int i2) {
        this.f13505n.mo13027a(OplusGLSurfaceView_13, bVar, i2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13070b(boolean z) {
        this.f13505n.mo13070b(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13060a() {
        return this.f13505n.mo13060a();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13074b() {
        return this.f13505n.mo13074b();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo13075c() {
        return this.f13505n.mo13075c();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13050a(boolean z, CameraDevice cameraDevice, boolean z2) {
        this.f13505n.mo13050a(z, cameraDevice, z2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13081d() {
        this.f13505n.mo13081d();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public OplusCameraCharacteristics mo13086e() {
        return this.f13505n.mo13086e();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13037a(OplusCameraCharacteristics c2698h) {
        this.f13505n.mo13037a(c2698h);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13090f() {
        this.f13505n.mo13090f();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13094g() {
        this.f13505n.mo13094g();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13098h() {
        this.f13505n.mo13098h();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13035a(OneCamera.IntrinsicsJvm.kt_3 cVar) {
        this.f13505n.mo13035a(cVar);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13026a(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) {
        this.f13505n.mo13026a(OplusGLSurfaceView_13, c2693c, aVar);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13101i() {
        this.f13505n.mo13101i();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13052a(boolean z, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) {
        this.f13505n.mo13052a(z, c2693c, aVar);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo13032a(CaptureRequest.Key<T> key, T t) {
        this.f13505n.mo13032a((CaptureRequest.Key<CaptureRequest.Key<T>>) key, (CaptureRequest.Key<T>) t);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo13040a(CameraParameter.PreviewKey<T> previewKey, T t) {
        this.f13505n.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<T>>) previewKey, (CameraParameter.PreviewKey<T>) t);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T> void mo13067b(CaptureRequest.Key<T> key, T t) {
        this.f13505n.mo13067b((CaptureRequest.Key<CaptureRequest.Key<T>>) key, (CaptureRequest.Key<T>) t);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13043a(String str) {
        this.f13505n.mo13043a(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13107k() {
        this.f13505n.mo13107k();
    }

    /* renamed from: C */
    public void m13223C(int OplusGLSurfaceView_13) {
        if (m13222B(OplusGLSurfaceView_13)) {
            this.f13505n.m13216h(this.f13506o.m12156e());
        } else {
            this.f13505n.mo13107k();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public Handler mo13110l() {
        return this.f13505n.mo13110l();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13113m() {
        this.f13505n.mo13113m();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13023a(float COUIBaseListPopupWindow_12, boolean z) {
        this.f13505n.mo13023a(COUIBaseListPopupWindow_12, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13029a(int OplusGLSurfaceView_13, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z) {
        this.f13505n.mo13029a(OplusGLSurfaceView_13, meteringRectangleArr, meteringRectangleArr2, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13025a(int OplusGLSurfaceView_13, RectF rectF, RectF rectF2, boolean z) {
        this.f13505n.mo13025a(OplusGLSurfaceView_13, rectF, rectF2, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13038a(OplusMeteringRectangle c2699i) {
        this.f13505n.mo13038a(c2699i);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13068b(OplusMeteringRectangle c2699i) {
        this.f13505n.mo13068b(c2699i);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13116n() {
        this.f13505n.mo13116n();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13119o() {
        this.f13505n.mo13119o();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13082d(int OplusGLSurfaceView_13) {
        this.f13505n.mo13082d(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public int mo13122p() {
        return this.f13505n.mo13122p();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public String mo13125q() {
        return this.f13505n.mo13125q();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public void mo13138u(boolean z) {
        this.f13505n.mo13138u(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13069b(String str) {
        this.f13505n.mo13069b(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13080c(boolean z) {
        this.f13505n.mo13080c(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13084d(boolean z) {
        this.f13505n.mo13084d(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public <T> void mo13078c(CaptureRequest.Key key, T t) {
        this.f13505n.mo13078c(key, (CaptureRequest.Key) t);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo13061a(CaptureResult.Key<?> key, CaptureResult captureResult) {
        return this.f13505n.mo13061a(key, captureResult);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13087e(int OplusGLSurfaceView_13) {
        this.f13505n.mo13087e(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13046a(String str, boolean z, boolean z2) {
        this.f13505n.mo13046a(str, z, z2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13091f(int OplusGLSurfaceView_13) {
        this.f13505n.mo13091f(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13089e(boolean z) {
        this.f13505n.mo13089e(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13093f(boolean z) {
        this.f13505n.mo13093f(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13097g(boolean z) {
        this.f13505n.mo13097g(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13055a(boolean z, String str, int[] iArr) {
        this.f13505n.mo13055a(z, str, iArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13049a(boolean z, int OplusGLSurfaceView_13, String str) {
        this.f13505n.mo13049a(z, OplusGLSurfaceView_13, str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13100h(boolean z) {
        this.f13505n.mo13100h(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13054a(boolean z, String str, long OplusGLSurfaceView_15) {
        this.f13505n.mo13054a(z, str, OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13051a(boolean z, Bundle bundle) {
        this.f13505n.mo13051a(z, bundle);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13095g(int OplusGLSurfaceView_13) {
        this.f13505n.mo13095g(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13099h(int OplusGLSurfaceView_13) {
        this.f13505n.mo13099h(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13044a(String str, int OplusGLSurfaceView_13) {
        this.f13505n.mo13044a(str, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13227a(int OplusGLSurfaceView_13, int i2) {
        if (m13222B(i2)) {
            this.f13505n.m13214b(this.f13506o.m12156e(), OplusGLSurfaceView_13);
        } else {
            this.f13505n.mo13099h(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13058a(int[] iArr) {
        this.f13505n.mo13058a(iArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13036a(OneCamera.COUIBaseListPopupWindow_8 eVar) {
        this.f13505n.mo13036a(eVar);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13103i(boolean z) {
        this.f13505n.mo13103i(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13028a(int OplusGLSurfaceView_13, boolean z) {
        this.f13505n.mo13028a(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13102i(int OplusGLSurfaceView_13) {
        this.f13505n.mo13102i(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13065b(int OplusGLSurfaceView_13, boolean z) {
        this.f13505n.mo13065b(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13031a(long OplusGLSurfaceView_15, boolean z) {
        this.f13505n.mo13031a(OplusGLSurfaceView_15, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13056a(boolean z, boolean z2) {
        this.f13505n.mo13056a(z, z2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13128r() {
        this.f13505n.mo13128r();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13105j(boolean z) {
        this.f13505n.mo13105j(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13104j(int OplusGLSurfaceView_13) {
        this.f13505n.mo13104j(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13033a(Bundle bundle) {
        this.f13505n.mo13033a(bundle);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13020a(byte b2) {
        this.f13505n.mo13020a(b2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13062b(byte b2) {
        this.f13505n.mo13062b(b2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13109k(boolean z) {
        this.f13505n.mo13109k(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13079c(String str) {
        this.f13505n.mo13079c(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13071b(boolean z, boolean z2) {
        this.f13505n.mo13071b(z, z2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13112l(boolean z) {
        this.f13505n.mo13112l(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13115m(boolean z) {
        this.f13505n.mo13115m(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13108k(int OplusGLSurfaceView_13) {
        this.f13505n.mo13108k(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13111l(int OplusGLSurfaceView_13) {
        this.f13505n.mo13111l(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13047a(String str, int[] iArr) {
        this.f13505n.mo13047a(str, iArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13045a(String str, boolean z) {
        this.f13505n.mo13045a(str, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo13106j() {
        return this.f13505n.mo13106j();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13114m(int OplusGLSurfaceView_13) {
        this.f13505n.mo13114m(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo13085d(String str) {
        return this.f13505n.mo13085d(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13118n(boolean z) {
        this.f13505n.mo13118n(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13088e(String str) {
        this.f13505n.mo13088e(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13121o(boolean z) {
        this.f13505n.mo13121o(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13117n(int OplusGLSurfaceView_13) {
        this.f13505n.mo13117n(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13057a(byte[] bArr) {
        this.f13505n.mo13057a(bArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13021a(float COUIBaseListPopupWindow_12) {
        this.f13505n.mo13021a(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13120o(int OplusGLSurfaceView_13) {
        this.f13505n.mo13120o(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public void mo13123p(int OplusGLSurfaceView_13) {
        this.f13505n.mo13123p(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public void mo13126q(int OplusGLSurfaceView_13) {
        this.f13505n.mo13126q(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13129r(int OplusGLSurfaceView_13) {
        this.f13505n.mo13129r(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13132s(int OplusGLSurfaceView_13) {
        this.f13505n.mo13132s(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public void mo13135t(int OplusGLSurfaceView_13) {
        this.f13505n.mo13135t(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public void mo13124p(boolean z) {
        this.f13505n.mo13124p(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public void mo13127q(boolean z) {
        this.f13505n.mo13127q(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public void mo13137u(int OplusGLSurfaceView_13) {
        this.f13505n.mo13137u(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public void mo13141v(int OplusGLSurfaceView_13) {
        this.f13505n.mo13141v(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13130r(boolean z) {
        this.f13505n.mo13130r(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13133s(boolean z) {
        this.f13505n.mo13133s(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public void mo13136t(boolean z) {
        this.f13505n.mo13136t(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13131s() {
        this.f13505n.mo13131s();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13072b(byte[] bArr) {
        this.f13505n.mo13072b(bArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public void mo13142v(boolean z) {
        this.f13505n.mo13142v(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public int mo13134t() {
        return this.f13505n.mo13134t();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public CameraRequestTag mo13140v() {
        return this.f13505n.mo13140v();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13143w() {
        this.f13505n.mo13143w();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13053a(boolean z, String str) {
        this.f13505n.mo13053a(z, str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13034a(Range range) {
        this.f13505n.mo13034a(range);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13144w(int OplusGLSurfaceView_13) {
        this.f13505n.mo13144w(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13148x(boolean z) {
        this.f13505n.mo13148x(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13146x() {
        this.f13505n.mo13146x();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public void mo13151y(boolean z) {
        this.f13505n.mo13151y(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13063b(float COUIBaseListPopupWindow_12) {
        this.f13505n.mo13063b(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13154z(boolean z) {
        this.f13505n.mo13154z(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13039a(TemperatureProvider c3559c) {
        this.f13505n.mo13039a(c3559c);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13092f(String str) {
        this.f13505n.mo13092f(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13010A(boolean z) {
        this.f13505n.mo13010A(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13073b(int[] iArr) {
        this.f13505n.mo13073b(iArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13147x(int OplusGLSurfaceView_13) {
        this.f13505n.mo13147x(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13066b(long OplusGLSurfaceView_15) {
        this.f13505n.mo13066b(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public void mo13150y(int OplusGLSurfaceView_13) {
        this.f13505n.mo13150y(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13077c(long OplusGLSurfaceView_15) {
        this.f13505n.mo13077c(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: B */
    public void mo13012B(boolean z) {
        this.f13505n.mo13012B(z);
    }

    /* renamed from: E */
    public boolean m13225E() {
        return this.f13505n.m13238I();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: C */
    public void mo13014C(boolean z) {
        this.f13505n.mo13014C(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: D */
    public void mo13015D(boolean z) {
        this.f13505n.mo13015D(z);
    }

    /* renamed from: F */
    public void m13226F() {
        this.f13505n.m13236G();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13153z(int OplusGLSurfaceView_13) {
        this.f13505n.mo13153z(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13096g(String str) {
        this.f13505n.mo13096g(str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public CameraDeviceInfo mo13019a(String str, String str2) {
        return this.f13505n.mo13019a(str, str2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public CameraDeviceConfig.Builder mo13149y() {
        return this.f13505n.mo13149y();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13228a(CameraDeviceConfig.Builder builder, OneCamera.IntrinsicsJvm.kt_5 dVar, int OplusGLSurfaceView_13) {
        this.f13505n.m13241b(builder, dVar, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13041a(CameraPictureCallback cameraPictureCallback) {
        this.f13505n.mo13041a(cameraPictureCallback);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: E */
    public void mo13016E(boolean z) {
        this.f13505n.mo13016E(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13059a(String[] strArr) {
        this.f13505n.mo13059a(strArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13022a(float COUIBaseListPopupWindow_12, float f2) {
        this.f13505n.mo13022a(COUIBaseListPopupWindow_12, f2);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13042a(CameraRecordingCallback cameraRecordingCallback, Handler handler) {
        this.f13505n.mo13042a(cameraRecordingCallback, handler);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public boolean mo13139u() {
        return this.f13505n.mo13139u();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13145w(boolean z) {
        this.f13505n.mo13145w(z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13152z() {
        this.f13505n.mo13152z();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13008A() {
        this.f13505n.mo13008A();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: B */
    public void mo13011B() {
        this.f13505n.mo13011B();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap mo13018a(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3) {
        return this.f13505n.mo13018a(bitmap, captureResult, OplusGLSurfaceView_13, i2, i3);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13083d(long OplusGLSurfaceView_15) {
        this.f13505n.mo13083d(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13009A(int OplusGLSurfaceView_13) {
        this.f13505n.mo13009A(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: C */
    public void mo13013C() {
        this.f13505n.mo13013C();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: F */
    public void mo13017F(boolean z) {
        this.f13505n.mo13017F(z);
    }
}
