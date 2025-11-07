package com.oplus.camera.p172ui;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.EffectType;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;

/* loaded from: classes2.dex */
public interface CameraUIListener {
    /* renamed from: A */
    void mo10647A();

    /* renamed from: B */
    boolean mo10648B();

    /* renamed from: C */
    boolean mo10649C();

    /* renamed from: D */
    void mo10650D();

    /* renamed from: E */
    void mo10651E();

    /* renamed from: F */
    int mo10652F();

    /* renamed from: G */
    int mo10653G();

    /* renamed from: H */
    int mo10654H();

    /* renamed from: I */
    int mo10655I();

    /* renamed from: J */
    boolean mo10656J();

    /* renamed from: K */
    boolean mo10657K();

    /* renamed from: L */
    boolean mo10658L();

    /* renamed from: M */
    void mo10659M();

    /* renamed from: N */
    boolean mo10660N();

    /* renamed from: O */
    boolean mo10661O();

    /* renamed from: P */
    boolean mo10662P();

    /* renamed from: Q */
    boolean mo10663Q();

    /* renamed from: R */
    boolean mo10664R();

    /* renamed from: S */
    void mo10665S();

    /* renamed from: T */
    void mo10666T();

    /* renamed from: U */
    void mo10667U();

    /* renamed from: V */
    void mo10668V();

    /* renamed from: W */
    void mo10669W();

    /* renamed from: X */
    boolean mo10670X();

    /* renamed from: Y */
    boolean mo10671Y();

    /* renamed from: Z */
    int mo10672Z();

    /* renamed from: PlatformImplementations.kt_3 */
    float mo10673a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    Size mo10674a(double IntrinsicsJvm.kt_5);

    /* renamed from: PlatformImplementations.kt_3 */
    String mo10675a(String str, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10676a();

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10677a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10678a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10679a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10680a(int OplusGLSurfaceView_13, String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10681a(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10682a(int OplusGLSurfaceView_13, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10683a(MediaItem.kt c2436a, Bitmap bitmap);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10684a(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10685a(EffectType c2687f);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10686a(DetectResult c3077a);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10687a(String str, Object obj, boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10688a(String str, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10689a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo10690a(boolean z, boolean z2);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10691a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10692a(int OplusGLSurfaceView_13, KeyEvent keyEvent);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10693a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10694a(String str, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo10695a(String str, boolean z, boolean z2);

    /* renamed from: aA */
    void mo10696aA();

    /* renamed from: aB */
    void mo10697aB();

    /* renamed from: aC */
    void mo10698aC();

    /* renamed from: aD */
    String mo10699aD();

    /* renamed from: aE */
    String mo10700aE();

    /* renamed from: aF */
    String mo10701aF();

    /* renamed from: aG */
    void mo10702aG();

    /* renamed from: aH */
    void mo10703aH();

    /* renamed from: aI */
    boolean mo10704aI();

    /* renamed from: aJ */
    boolean mo10705aJ();

    /* renamed from: aK */
    void mo10706aK();

    /* renamed from: aL */
    int mo10707aL();

    /* renamed from: aM */
    void mo10708aM();

    /* renamed from: aN */
    boolean mo10709aN();

    /* renamed from: aO */
    boolean mo10710aO();

    /* renamed from: aP */
    boolean mo10711aP();

    /* renamed from: aQ */
    boolean mo10712aQ();

    /* renamed from: aR */
    HintManager mo10713aR();

    /* renamed from: aS */
    int mo10714aS();

    /* renamed from: aT */
    boolean mo10715aT();

    /* renamed from: aU */
    boolean mo10716aU();

    /* renamed from: aV */
    void mo10717aV();

    /* renamed from: aW */
    void mo10718aW();

    /* renamed from: aX */
    boolean mo10719aX();

    /* renamed from: aY */
    boolean mo10720aY();

    /* renamed from: aZ */
    boolean mo10721aZ();

    /* renamed from: aa */
    int mo10722aa();

    /* renamed from: ab */
    int mo10723ab();

    /* renamed from: ac */
    int[] mo10724ac();

    /* renamed from: ad */
    int[] mo10725ad();

    /* renamed from: ae */
    int mo10726ae();

    /* renamed from: af */
    boolean mo10727af();

    /* renamed from: ag */
    boolean mo10728ag();

    /* renamed from: ah */
    boolean mo10729ah();

    /* renamed from: ai */
    boolean mo10730ai();

    /* renamed from: aj */
    boolean mo10731aj();

    /* renamed from: ak */
    void mo10732ak();

    /* renamed from: al */
    void mo10733al();

    /* renamed from: am */
    boolean mo10734am();

    /* renamed from: an */
    void mo10735an();

    /* renamed from: ao */
    String mo10736ao();

    /* renamed from: ap */
    boolean mo10737ap();

    /* renamed from: aq */
    boolean mo10738aq();

    /* renamed from: ar */
    boolean mo10739ar();

    /* renamed from: as */
    boolean mo10740as();

    /* renamed from: at */
    boolean mo10741at();

    /* renamed from: au */
    void mo10742au();

    /* renamed from: av */
    boolean mo10743av();

    /* renamed from: aw */
    String mo10744aw();

    /* renamed from: ax */
    Size mo10745ax();

    /* renamed from: ay */
    void mo10746ay();

    /* renamed from: az */
    boolean mo10747az();

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10748b(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10749b(DetectResult c3077a);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10750b(String str, String str2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10751b(String str, boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10752b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo10753b(boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo10754b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo10755b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo10756b(int OplusGLSurfaceView_13, KeyEvent keyEvent);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo10757b(String str);

    /* renamed from: bA */
    boolean mo10758bA();

    /* renamed from: bB */
    boolean mo10759bB();

    /* renamed from: bC */
    void mo10760bC();

    /* renamed from: bD */
    void mo10761bD();

    /* renamed from: bE */
    void mo10762bE();

    /* renamed from: bF */
    boolean mo10763bF();

    /* renamed from: bG */
    boolean mo10764bG();

    /* renamed from: bH */
    void mo10765bH();

    /* renamed from: bI */
    void mo10766bI();

    /* renamed from: bJ */
    boolean mo10767bJ();

    /* renamed from: bK */
    boolean mo10768bK();

    /* renamed from: bL */
    BaseScreenMode mo10769bL();

    /* renamed from: bM */
    int mo10770bM();

    /* renamed from: bN */
    int mo10771bN();

    /* renamed from: bO */
    int mo10772bO();

    /* renamed from: bP */
    int mo10773bP();

    /* renamed from: bQ */
    int mo10774bQ();

    /* renamed from: bR */
    void mo10775bR();

    /* renamed from: bS */
    boolean mo10776bS();

    /* renamed from: bT */
    boolean mo10777bT();

    /* renamed from: bU */
    boolean mo10778bU();

    /* renamed from: bV */
    boolean mo10779bV();

    /* renamed from: bW */
    boolean mo10780bW();

    /* renamed from: bX */
    void mo10781bX();

    /* renamed from: bY */
    void mo10782bY();

    /* renamed from: bZ */
    void mo10783bZ();

    /* renamed from: ba */
    boolean mo10784ba();

    /* renamed from: bb */
    void mo10785bb();

    /* renamed from: bc */
    CameraEntry mo10786bc();

    /* renamed from: bd */
    boolean mo10787bd();

    /* renamed from: be */
    boolean mo10788be();

    /* renamed from: bf */
    String mo10789bf();

    /* renamed from: bg_renamed */
    String mo10790bg();

    /* renamed from: bh */
    boolean mo10791bh();

    /* renamed from: bi */
    float mo10792bi();

    /* renamed from: bj */
    boolean mo10793bj();

    /* renamed from: bl */
    boolean mo10795bl();

    /* renamed from: bm */
    boolean mo10796bm();

    /* renamed from: bn */
    boolean mo10797bn();

    /* renamed from: bo */
    void mo10798bo();

    /* renamed from: bp */
    boolean mo10799bp();

    /* renamed from: bq */
    boolean mo10800bq();

    /* renamed from: br */
    void mo10801br();

    /* renamed from: bs */
    void mo10802bs();

    /* renamed from: bt */
    boolean mo10803bt();

    /* renamed from: bu */
    boolean mo10804bu();

    /* renamed from: bv */
    void mo10805bv();

    /* renamed from: bw */
    void mo10806bw();

    /* renamed from: bx */
    boolean mo10807bx();

    /* renamed from: by */
    boolean mo10808by();

    /* renamed from: bz */
    View mo10809bz();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10810c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10811c(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10812c(String str);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo10813c(boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean mo10814c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean mo10815c(String str, boolean z);

    /* renamed from: ca */
    int mo10816ca();

    /* renamed from: cb */
    void mo10817cb();

    /* renamed from: cc */
    void mo10818cc();

    /* renamed from: cd */
    void mo10819cd();

    /* renamed from: ce */
    void mo10820ce();

    /* renamed from: cf */
    void mo10821cf();

    /* renamed from: cg */
    boolean mo10822cg();

    /* renamed from: ch */
    void mo10823ch();

    /* renamed from: ci */
    OplusViewOutlineProvider mo10824ci();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10825d(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10826d(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10827d(String str);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo10828d(boolean z);

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean mo10829d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    int mo10830e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10831e();

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10832e(String str);

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo10833e(boolean z);

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo10834e(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10835f(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10836f(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo10837f(boolean z);

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean mo10838f();

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean mo10839f(String str);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo10840g(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo10841g(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo10842g(boolean z);

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean mo10843g();

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean mo10844g(String str);

    int getFaceBeautyItemValue(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo10845h(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_10 */
    void mo10846h(boolean z);

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean mo10847h();

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean mo10848h(String str);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo10849i(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo10850i(String str);

    /* renamed from: OplusGLSurfaceView_13 */
    void mo10851i(boolean z);

    /* renamed from: OplusGLSurfaceView_13 */
    boolean mo10852i();

    /* renamed from: OplusGLSurfaceView_15 */
    void mo10853j(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo10854j(String str);

    /* renamed from: OplusGLSurfaceView_15 */
    void mo10855j(boolean z);

    /* renamed from: OplusGLSurfaceView_15 */
    boolean mo10856j();

    /* renamed from: OplusGLSurfaceView_5 */
    void mo10857k(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_5 */
    void mo10858k(boolean z);

    /* renamed from: OplusGLSurfaceView_5 */
    boolean mo10859k();

    /* renamed from: OplusGLSurfaceView_5 */
    boolean mo10860k(String str);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo10861l(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo10862l(String str);

    /* renamed from: OplusGLSurfaceView_14 */
    void mo10863l(boolean z);

    /* renamed from: OplusGLSurfaceView_14 */
    boolean mo10864l();

    /* renamed from: OplusGLSurfaceView_6 */
    void mo10865m();

    /* renamed from: OplusGLSurfaceView_6 */
    void mo10866m(int OplusGLSurfaceView_13);

    /* renamed from: OplusGLSurfaceView_6 */
    boolean mo10867m(String str);

    /* renamed from: OplusGLSurfaceView_11 */
    int mo10868n();

    /* renamed from: OplusGLSurfaceView_11 */
    void mo10869n(String str);

    /* renamed from: o */
    void mo10870o();

    /* renamed from: o */
    void mo10871o(String str);

    void onEffectItemChange(int OplusGLSurfaceView_13, boolean z, boolean z2);

    void onFaceBeautyItemChange(int OplusGLSurfaceView_13);

    void onFaceBeautyItemValueChange(int OplusGLSurfaceView_13, int i2, boolean z);

    void onMakeupTypeChanged(int OplusGLSurfaceView_13, boolean z);

    void onMakeupValueChanged(int OplusGLSurfaceView_13, int i2, boolean z);

    void onMultiCameraTypeChanged(int OplusGLSurfaceView_13);

    /* renamed from: p */
    void mo10872p(String str);

    /* renamed from: p */
    boolean mo10873p();

    /* renamed from: q */
    void mo10874q();

    /* renamed from: q */
    void mo10875q(String str);

    /* renamed from: r */
    void mo10876r();

    void resetFaceBeautyValues();

    /* renamed from: s */
    float mo10877s();

    void setBlurIndex(int OplusGLSurfaceView_13, boolean z);

    /* renamed from: t */
    boolean mo10878t();

    /* renamed from: u */
    boolean mo10879u();

    /* renamed from: v */
    int mo10880v();

    /* renamed from: w */
    boolean mo10881w();

    /* renamed from: x */
    boolean mo10882x();

    /* renamed from: y */
    void mo10883y();

    /* renamed from: z */
    boolean mo10884z();
}
