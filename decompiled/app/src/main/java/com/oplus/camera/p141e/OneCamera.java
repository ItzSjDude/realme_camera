package com.oplus.camera.p141e;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.p180v.TemperatureProvider;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.ocs.camera.CameraRecordingCallback;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: OneCamera.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public interface OneCamera extends CameraConstant {

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final byte[] f13432g = {0};

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final byte[] f13433h = {1};

    /* renamed from: OplusGLSurfaceView_13 */
    public static final byte[] f13434i = {2};

    /* renamed from: OplusGLSurfaceView_15 */
    public static final byte[] f13435j = {0};

    /* renamed from: OplusGLSurfaceView_5 */
    public static final byte[] f13436k = {1};

    /* renamed from: OplusGLSurfaceView_14 */
    public static final byte[] f13437l = {2};

    /* renamed from: OplusGLSurfaceView_6 */
    public static final byte[] f13438m = {3};

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void checkIfLockAutoExposure();

        void onCaptureCanceled(CameraRequestTag c2693c);

        void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c);

        void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c);

        void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult);

        void onCapturePrepared();

        void onCaptureProgressed(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c);

        void onCaptureSequenceCompleted();

        void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long OplusGLSurfaceView_15, long j2);

        void onFirstCaptureFrameAdd();
    }

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10946a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10947a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10948a(boolean z, int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10949b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo10950c(int OplusGLSurfaceView_13);
    }

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10430a(long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10431a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10432a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10433a(CaptureResult captureResult);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10434a(CaptureResult captureResult, int OplusGLSurfaceView_13, String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10435a(Image image);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10436a(CameraApsResult cameraApsResult);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10437a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult);

        /* renamed from: IntrinsicsJvm.kt_4 */
        Map<String, Object> mo10438b(Image image);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10439b(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult);
    }

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11043a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11044a(CameraRequestTag c2693c, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11045a(CameraDeviceConfig.Builder builder);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11046a(LinkedHashMap<String, Surface> linkedHashMap, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo11047a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11048b(int OplusGLSurfaceView_13);
    }

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10951a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10952a(CaptureResult captureResult, CameraRequestTag c2693c);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10953a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10954b();
    }

    /* renamed from: A */
    void mo13008A();

    /* renamed from: A */
    void mo13009A(int OplusGLSurfaceView_13);

    /* renamed from: A */
    void mo13010A(boolean z);

    /* renamed from: B */
    void mo13011B();

    /* renamed from: B */
    void mo13012B(boolean z);

    /* renamed from: C */
    void mo13013C();

    /* renamed from: C */
    void mo13014C(boolean z);

    /* renamed from: D */
    void mo13015D(boolean z);

    /* renamed from: E */
    void mo13016E(boolean z);

    /* renamed from: F */
    void mo13017F(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    Bitmap mo13018a(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3);

    /* renamed from: PlatformImplementations.kt_3 */
    CameraDeviceInfo mo13019a(String str, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13020a(byte b2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13021a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13022a(float COUIBaseListPopupWindow_12, float f2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13023a(float COUIBaseListPopupWindow_12, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13024a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13025a(int OplusGLSurfaceView_13, RectF rectF, RectF rectF2, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13026a(int OplusGLSurfaceView_13, CameraRequestTag c2693c, PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13027a(int OplusGLSurfaceView_13, IntrinsicsJvm.kt_4 bVar, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13028a(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13029a(int OplusGLSurfaceView_13, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13030a(long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13031a(long OplusGLSurfaceView_15, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    <T> void mo13032a(CaptureRequest.Key<T> key, T t);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13033a(Bundle bundle);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13034a(Range range);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13035a(IntrinsicsJvm.kt_3 cVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13036a(COUIBaseListPopupWindow_8 eVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13037a(OplusCameraCharacteristics c2698h);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13038a(OplusMeteringRectangle c2699i);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13039a(TemperatureProvider c3559c);

    /* renamed from: PlatformImplementations.kt_3 */
    <T> void mo13040a(CameraParameter.PreviewKey<T> previewKey, T t);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13041a(CameraPictureCallback cameraPictureCallback);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13042a(CameraRecordingCallback cameraRecordingCallback, Handler handler);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13043a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13044a(String str, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13045a(String str, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13046a(String str, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13047a(String str, int[] iArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13048a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13049a(boolean z, int OplusGLSurfaceView_13, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13050a(boolean z, CameraDevice cameraDevice, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13051a(boolean z, Bundle bundle);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13052a(boolean z, CameraRequestTag c2693c, PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13053a(boolean z, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13054a(boolean z, String str, long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13055a(boolean z, String str, int[] iArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13056a(boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13057a(byte[] bArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13058a(int[] iArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo13059a(String[] strArr);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo13060a();

    /* renamed from: PlatformImplementations.kt_3 */
    int[] mo13061a(CaptureResult.Key<?> key, CaptureResult captureResult);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13062b(byte b2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13063b(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13064b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13065b(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13066b(long OplusGLSurfaceView_15);

    /* renamed from: IntrinsicsJvm.kt_4 */
    <T> void mo13067b(CaptureRequest.Key<T> key, T t);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13068b(OplusMeteringRectangle c2699i);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13069b(String str);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13070b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13071b(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13072b(byte[] bArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo13073b(int[] iArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo13074b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    int mo13075c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo13076c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo13077c(long OplusGLSurfaceView_15);

    /* renamed from: IntrinsicsJvm.kt_3 */
    <T> void mo13078c(CaptureRequest.Key key, T t);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo13079c(String str);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo13080c(boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo13081d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo13082d(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo13083d(long OplusGLSurfaceView_15);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo13084d(boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean mo13085d(String str);

    /* renamed from: COUIBaseListPopupWindow_8 */
    OplusCameraCharacteristics mo13086e();

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo13087e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo13088e(String str);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo13089e(boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo13090f();

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo13091f(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo13092f(String str);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo13093f(boolean z);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo13094g();

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo13095g(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo13096g(String str);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo13097g(boolean z);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo13098h();

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo13099h(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo13100h(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo13101i();

    /* renamed from: OplusGLSurfaceView_13 */
    void mo13102i(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo13103i(boolean z);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo13104j(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo13105j(boolean z);

    /* renamed from: OplusGLSurfaceView_15 */
    boolean mo13106j();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo13107k();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo13108k(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo13109k(boolean z);

    /* renamed from: OplusGLSurfaceView_14 */
    Handler mo13110l();

    /* renamed from: OplusGLSurfaceView_14 */
    void mo13111l(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo13112l(boolean z);

    /* renamed from: OplusGLSurfaceView_6 */
    void mo13113m();

    /* renamed from: OplusGLSurfaceView_6 */
    void mo13114m(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_6 */
    void mo13115m(boolean z);

    /* renamed from: OplusGLSurfaceView_11 */
    void mo13116n();

    /* renamed from: OplusGLSurfaceView_11 */
    void mo13117n(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_11 */
    void mo13118n(boolean z);

    /* renamed from: o */
    void mo13119o();

    /* renamed from: o */
    void mo13120o(int OplusGLSurfaceView_13);

    /* renamed from: o */
    void mo13121o(boolean z);

    /* renamed from: p */
    int mo13122p();

    /* renamed from: p */
    void mo13123p(int OplusGLSurfaceView_13);

    /* renamed from: p */
    void mo13124p(boolean z);

    /* renamed from: q */
    String mo13125q();

    /* renamed from: q */
    void mo13126q(int OplusGLSurfaceView_13);

    /* renamed from: q */
    void mo13127q(boolean z);

    /* renamed from: r */
    void mo13128r();

    /* renamed from: r */
    void mo13129r(int OplusGLSurfaceView_13);

    /* renamed from: r */
    void mo13130r(boolean z);

    /* renamed from: s */
    void mo13131s();

    /* renamed from: s */
    void mo13132s(int OplusGLSurfaceView_13);

    /* renamed from: s */
    void mo13133s(boolean z);

    /* renamed from: t */
    int mo13134t();

    /* renamed from: t */
    void mo13135t(int OplusGLSurfaceView_13);

    /* renamed from: t */
    void mo13136t(boolean z);

    /* renamed from: u */
    void mo13137u(int OplusGLSurfaceView_13);

    /* renamed from: u */
    void mo13138u(boolean z);

    /* renamed from: u */
    boolean mo13139u();

    /* renamed from: v */
    CameraRequestTag mo13140v();

    /* renamed from: v */
    void mo13141v(int OplusGLSurfaceView_13);

    /* renamed from: v */
    void mo13142v(boolean z);

    /* renamed from: w */
    void mo13143w();

    /* renamed from: w */
    void mo13144w(int OplusGLSurfaceView_13);

    /* renamed from: w */
    void mo13145w(boolean z);

    /* renamed from: x */
    void mo13146x();

    /* renamed from: x */
    void mo13147x(int OplusGLSurfaceView_13);

    /* renamed from: x */
    void mo13148x(boolean z);

    /* renamed from: y */
    CameraDeviceConfig.Builder mo13149y();

    /* renamed from: y */
    void mo13150y(int OplusGLSurfaceView_13);

    /* renamed from: y */
    void mo13151y(boolean z);

    /* renamed from: z */
    void mo13152z();

    /* renamed from: z */
    void mo13153z(int OplusGLSurfaceView_13);

    /* renamed from: z */
    void mo13154z(boolean z);
}
