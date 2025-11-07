package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.location.Location;
import android.net.Uri;
import android.util.Size;
import com.oplus.camera.SloganUtil;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.MagShellResponseStatus;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.service.ThumbnailProcessor;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraPictureCallback;
import java.util.List;

/* compiled from: CameraInterface.java */
/* renamed from: com.oplus.camera.capmode.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public interface CameraInterface {
    /* renamed from: A */
    boolean mo10445A();

    /* renamed from: B */
    void mo10446B();

    /* renamed from: C */
    boolean mo10447C();

    /* renamed from: D */
    void mo10448D();

    /* renamed from: E */
    boolean mo10449E();

    /* renamed from: F */
    boolean mo10450F();

    /* renamed from: G */
    boolean mo10451G();

    /* renamed from: H */
    boolean mo10452H();

    /* renamed from: I */
    boolean mo10453I();

    /* renamed from: J */
    boolean mo10454J();

    /* renamed from: K */
    boolean mo10455K();

    /* renamed from: L */
    void mo10456L();

    /* renamed from: M */
    void mo10457M();

    /* renamed from: N */
    void mo10458N();

    /* renamed from: O */
    void mo10459O();

    /* renamed from: P */
    boolean mo10460P();

    /* renamed from: Q */
    void mo10461Q();

    /* renamed from: R */
    boolean mo10462R();

    /* renamed from: S */
    boolean mo10463S();

    /* renamed from: T */
    void mo10464T();

    /* renamed from: U */
    void mo10465U();

    /* renamed from: V */
    int mo10466V();

    /* renamed from: W */
    void mo10467W();

    /* renamed from: X */
    void mo10468X();

    /* renamed from: Y */
    boolean mo10469Y();

    /* renamed from: Z */
    void mo10470Z();

    /* renamed from: PlatformImplementations.kt_3 */
    Uri mo10471a(ThumbnailProcessor.DataRequest dataRequest);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10472a();

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10473a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10474a(int OplusGLSurfaceView_13, int i2, int i3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10475a(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10476a(long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10477a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10478a(long OplusGLSurfaceView_15, String str, boolean z, boolean z2, boolean z3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10479a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10480a(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10481a(Size size);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10482a(Storage.CameraPicture cameraPicture);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10483a(Storage.CameraPicture cameraPicture, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10484a(Thumbnail.IntrinsicsJvm.kt_5 dVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10485a(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10486a(Thumbnail c3203e);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10487a(CameraPictureCallback cameraPictureCallback);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10488a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10489a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10490a(boolean z, int OplusGLSurfaceView_13, boolean z2, int i2, boolean z3);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10491a(boolean z, List<String> list, String str, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10492a(boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10493a(byte[] bArr);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10494a(byte[] bArr, boolean z, int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10495a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10496a(float COUIBaseListPopupWindow_12, float f2);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10497a(boolean z, float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    int[] mo10498a(Activity activity, int OplusGLSurfaceView_13);

    /* renamed from: aA */
    boolean mo10499aA();

    /* renamed from: aB */
    boolean mo10500aB();

    /* renamed from: aC */
    void mo10501aC();

    /* renamed from: aD */
    boolean mo10502aD();

    /* renamed from: aE */
    CameraDeviceInfo mo10503aE();

    /* renamed from: aF */
    boolean mo10504aF();

    /* renamed from: aG */
    String mo10505aG();

    /* renamed from: aH */
    void mo10506aH();

    /* renamed from: aI */
    void mo10507aI();

    /* renamed from: aJ */
    void mo10508aJ();

    /* renamed from: aK */
    float[] mo10509aK();

    /* renamed from: aL */
    void mo10510aL();

    /* renamed from: aM */
    TiltShiftParam mo10511aM();

    /* renamed from: aN */
    boolean mo10512aN();

    /* renamed from: aO */
    void mo10513aO();

    /* renamed from: aP */
    MagShellResponseStatus mo10514aP();

    /* renamed from: aQ */
    boolean mo10515aQ();

    /* renamed from: aR */
    void mo10516aR();

    /* renamed from: aS */
    void mo10517aS();

    /* renamed from: aT */
    HintManager mo10518aT();

    /* renamed from: aU */
    BaseScreenMode mo10519aU();

    /* renamed from: aV */
    BaseScreenMode mo10520aV();

    /* renamed from: aW */
    void mo10521aW();

    /* renamed from: aX */
    boolean mo10522aX();

    /* renamed from: aY */
    boolean mo10523aY();

    /* renamed from: aZ */
    void mo10524aZ();

    /* renamed from: aa */
    void mo10525aa();

    /* renamed from: ab */
    void mo10526ab();

    /* renamed from: ac */
    void mo10527ac();

    /* renamed from: ad */
    VibrateManager mo10528ad();

    /* renamed from: ae */
    boolean mo10529ae();

    /* renamed from: af */
    String mo10530af();

    /* renamed from: ag */
    String mo10531ag();

    /* renamed from: ah */
    String mo10532ah();

    /* renamed from: ai */
    int mo10533ai();

    /* renamed from: aj */
    int mo10534aj();

    /* renamed from: ak */
    float mo10535ak();

    /* renamed from: al */
    float mo10536al();

    /* renamed from: am */
    float mo10537am();

    /* renamed from: an */
    void mo10538an();

    /* renamed from: ao */
    boolean mo10539ao();

    /* renamed from: ap */
    boolean mo10540ap();

    /* renamed from: aq */
    SloganUtil mo10541aq();

    /* renamed from: ar */
    BaseSloganUtil.PlatformImplementations.kt_3 mo10542ar();

    /* renamed from: as */
    int mo10543as();

    /* renamed from: at */
    boolean mo10544at();

    /* renamed from: au */
    void mo10545au();

    /* renamed from: av */
    void mo10546av();

    /* renamed from: aw */
    int mo10547aw();

    /* renamed from: ax */
    int mo10548ax();

    /* renamed from: ay */
    boolean mo10549ay();

    /* renamed from: az */
    void mo10550az();

    /* renamed from: IntrinsicsJvm.kt_4 */
    CameraEntry mo10551b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10552b(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10553b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10554b(Size size);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10555b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10556b(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10557c(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10558c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10559c(boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean mo10560c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10561d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10562d(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10563d(boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10564e();

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10565e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10566e(boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10567f();

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10568f(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10569f(boolean z);

    /* renamed from: COUIBaseListPopupWindow_11 */
    int mo10570g();

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo10571g(boolean z);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo10572h();

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo10573h(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo10574i(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    boolean mo10575i();

    /* renamed from: OplusGLSurfaceView_15 */
    int mo10576j();

    /* renamed from: OplusGLSurfaceView_15 */
    void mo10577j(boolean z);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo10578k(boolean z);

    /* renamed from: OplusGLSurfaceView_5 */
    boolean mo10579k();

    /* renamed from: OplusGLSurfaceView_14 */
    int mo10580l();

    /* renamed from: OplusGLSurfaceView_14 */
    void mo10581l(boolean z);

    /* renamed from: OplusGLSurfaceView_6 */
    void mo10582m(boolean z);

    /* renamed from: OplusGLSurfaceView_6 */
    boolean mo10583m();

    /* renamed from: OplusGLSurfaceView_11 */
    void mo10584n();

    /* renamed from: o */
    void mo10585o();

    /* renamed from: p */
    boolean mo10586p();

    /* renamed from: q */
    boolean mo10587q();

    /* renamed from: r */
    boolean mo10588r();

    /* renamed from: s */
    boolean mo10589s();

    /* renamed from: t */
    SharedPreferences mo10590t();

    /* renamed from: u */
    int mo10591u();

    /* renamed from: v */
    int mo10592v();

    /* renamed from: w */
    String mo10593w();

    /* renamed from: x */
    long mo10594x();

    /* renamed from: y */
    Location mo10595y();

    /* renamed from: z */
    boolean mo10596z();
}
