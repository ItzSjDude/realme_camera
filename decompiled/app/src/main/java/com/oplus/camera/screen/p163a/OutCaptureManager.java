package com.oplus.camera.screen.p163a;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OutCaptureGuideView;
import com.oplus.camera.screen.FolderAngleDetectService;
import com.oplus.camera.screen.out.InnerPresentation;
import com.oplus.camera.screen.out.ReEntryPresentation;
import com.oplus.camera.screen.p163a.IScreenSwitchInterface;
import com.oplus.camera.util.DeviceUtil;
import com.oplus.camera.util.Util;

/* compiled from: OutCaptureManager.java */
/* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class OutCaptureManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f15965a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f15966b;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f15972h;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OutCaptureGuideView f15967c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InnerPresentation f15968d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ReEntryPresentation f15969e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private IScreenSwitchInterface.PlatformImplementations.kt_3 f15970f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private IntrinsicsJvm.kt_4 f15971g = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private IntrinsicsJvm.kt_3 f15973i = IntrinsicsJvm.kt_3.idle;

    /* compiled from: OutCaptureManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16439a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo16440a(boolean z);
    }

    /* compiled from: OutCaptureManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    private enum IntrinsicsJvm.kt_3 {
        idle,
        guide,
        expand
    }

    public OutCaptureManager() {
        this.f15972h = null;
        this.f15972h = new PlatformImplementations.kt_3();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16431a(Activity activity, IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12959b("OutCaptureManager", "requestDeviceFolded");
        this.f15971g = bVar;
        if (!Util.m24498u()) {
            CameraLog.m12959b("OutCaptureManager", "requestDeviceFolded, show guide");
            m16422c(activity);
            DeviceUtil.m24533a(0, false, System.currentTimeMillis());
            this.f15973i = IntrinsicsJvm.kt_3.guide;
            FolderAngleDetectService.m16408a(m16421b(activity));
        } else {
            CameraLog.m12959b("OutCaptureManager", "requestDeviceFolded, without guide");
            DeviceUtil.m24533a(0, false, System.currentTimeMillis());
        }
        CameraLog.m12959b("OutCaptureManager", "requestDeviceFolded X");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16434b(Activity activity, IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12959b("OutCaptureManager", "checkIntent");
        this.f15971g = bVar;
        if (m16423g()) {
            this.f15973i = IntrinsicsJvm.kt_3.expand;
            m16418a(activity, true);
            FolderAngleDetectService.m16408a(m16421b(activity));
        } else if (m16425i()) {
            m16416a(activity);
        }
        CameraLog.m12959b("OutCaptureManager", "checkIntent X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16416a(Activity activity) {
        CameraLog.m12959b("OutCaptureManager", "showReEntryPresentation");
        DeviceUtil.m24533a(-1, true, System.currentTimeMillis());
        this.f15969e = new ReEntryPresentation(activity, ((DisplayManager) activity.getSystemService("display")).getDisplay(4096));
        this.f15969e.m16711a(new ReEntryPresentation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$nGdUUjD7cF6fHgRHnT8tfiO39MU
            @Override // com.oplus.camera.screen.out.ReEntryPresentation.PlatformImplementations.kt_3
            public final void onExitButtonClick() {
                this.COUIBaseListPopupWindow_12$0.m16429m();
            }
        });
        this.f15969e.show();
        CameraLog.m12959b("OutCaptureManager", "showReEntryPresentation X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public /* synthetic */ void m16429m() {
        m16430a();
        IntrinsicsJvm.kt_4 bVar = this.f15971g;
        if (bVar != null) {
            bVar.mo16439a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16418a(Activity activity, boolean z) {
        CameraLog.m12959b("OutCaptureManager", "showPresentation");
        DeviceUtil.m24533a(0, true, System.currentTimeMillis());
        this.f15968d = new InnerPresentation(activity, ((DisplayManager) activity.getSystemService("display")).getDisplay(4096));
        this.f15968d.m16695a(z);
        this.f15968d.m16694a(new InnerPresentation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$wgPYxMIY-NcZGFN6D4UFh5gAoQo
            @Override // com.oplus.camera.screen.out.InnerPresentation.PlatformImplementations.kt_3
            public final void onExitButtonClick() {
                this.COUIBaseListPopupWindow_12$0.m16428l();
            }
        });
        this.f15968d.show();
        CameraLog.m12959b("OutCaptureManager", "showPresentation X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public /* synthetic */ void m16428l() {
        m16432a(true, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IScreenSwitchInterface.PlatformImplementations.kt_3 m16421b(final Activity activity) {
        if (this.f15970f == null) {
            this.f15970f = new IScreenSwitchInterface.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$S0HKtrgJhum0svMeZDFkvxA2Hf0
                @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface.PlatformImplementations.kt_3
                public final void onEvent(int OplusGLSurfaceView_13) {
                    this.COUIBaseListPopupWindow_12$0.m16417a(activity, OplusGLSurfaceView_13);
                }
            };
        }
        return this.f15970f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16417a(Activity activity, int OplusGLSurfaceView_13) {
        if (this.f15973i == IntrinsicsJvm.kt_3.guide) {
            if (OplusGLSurfaceView_13 > 30) {
                CameraLog.m12959b("OutCaptureManager", "onEvent, to expand");
                this.f15973i = IntrinsicsJvm.kt_3.expand;
                m16418a(activity, false);
                m16420a(true);
                return;
            }
            return;
        }
        if (this.f15973i == IntrinsicsJvm.kt_3.expand) {
            if (OplusGLSurfaceView_13 < 10 && !m16423g()) {
                CameraLog.m12959b("OutCaptureManager", "onEvent, to idle");
                m16433b();
                m16420a(false);
            } else {
                if (OplusGLSurfaceView_13 < 30) {
                    CameraLog.m12959b("OutCaptureManager", "onEvent, send msg");
                    this.f15972h.removeMessages(1);
                    Handler handler = this.f15972h;
                    handler.sendMessageDelayed(handler.obtainMessage(1), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    return;
                }
                this.f15972h.removeMessages(1);
            }
        }
    }

    /* compiled from: OutCaptureManager.java */
    /* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends Handler {
        public PlatformImplementations.kt_3() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12959b("OutCaptureManager", "handleMessage, msg: " + message.what);
            if (1 == message.what && OutCaptureManager.this.f15973i == IntrinsicsJvm.kt_3.expand && !OutCaptureManager.m16423g()) {
                CameraLog.m12959b("OutCaptureManager", "handleMessage, to idle");
                OutCaptureManager.this.m16433b();
                OutCaptureManager.this.m16420a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16420a(boolean z) {
        m16427k();
        IntrinsicsJvm.kt_4 bVar = this.f15971g;
        if (bVar != null) {
            bVar.mo16440a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16430a() {
        CameraLog.m12959b("OutCaptureManager", "checkHideReEntry");
        ReEntryPresentation presentationC2960f = this.f15969e;
        if (presentationC2960f != null) {
            if (presentationC2960f.isShowing()) {
                this.f15969e.dismiss();
            }
            this.f15969e = null;
            DeviceUtil.m24533a(-1, false, System.currentTimeMillis());
        }
        CameraLog.m12959b("OutCaptureManager", "checkHideReEntry X");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16433b() {
        m16432a(false, false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16435c() {
        FolderAngleDetectService.m16410b(this.f15970f);
        this.f15970f = null;
        this.f15972h.removeCallbacksAndMessages(null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16432a(boolean z, boolean z2) {
        CameraLog.m12959b("OutCaptureManager", "checkHideOutCapture");
        f15966b = z;
        f15965a = z2;
        this.f15973i = IntrinsicsJvm.kt_3.idle;
        m16427k();
        m16426j();
        FolderAngleDetectService.m16410b(this.f15970f);
        DeviceUtil.m24533a(-1, false, System.currentTimeMillis());
        CameraLog.m12959b("OutCaptureManager", "checkHideOutCapture X");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16426j() {
        InnerPresentation presentationC2957c = this.f15968d;
        if (presentationC2957c != null) {
            if (presentationC2957c.isShowing()) {
                this.f15968d.dismiss();
            }
            this.f15968d = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m16422c(Activity activity) {
        if (this.f15967c == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id_renamed.camera_root);
            activity.getLayoutInflater().inflate(R.layout.out_capture_guide, viewGroup);
            this.f15967c = (OutCaptureGuideView) viewGroup.findViewById(R.id_renamed.out_capture_guide);
            this.f15967c.setListener(new OutCaptureGuideView.InterfaceC3104a() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.-$$Lambda$EpeFfsufbbAxvy7Q9ggJfyHahMs
                @Override // com.oplus.camera.p172ui.OutCaptureGuideView.InterfaceC3104a
                public final void onExitButtonClick() {
                    this.COUIBaseListPopupWindow_12$0.m16433b();
                }
            });
        }
        this.f15967c.m18334a();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m16427k() {
        if (this.f15967c != null) {
            CameraLog.m12959b("OutCaptureManager", "hideOutCaptureGuide");
            this.f15967c.m18335b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16436d() {
        CameraLog.m12959b("OutCaptureManager", "onPause, mStatus: " + this.f15973i.name());
        if (this.f15973i == IntrinsicsJvm.kt_3.guide) {
            m16433b();
        }
        m16426j();
        m16430a();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m16437e() {
        return this.f15973i == IntrinsicsJvm.kt_3.expand;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m16438f() {
        return this.f15973i == IntrinsicsJvm.kt_3.guide;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m16423g() {
        int iM24457h = Util.m24457h();
        CameraLog.m12959b("OutCaptureManager", "isIntentOutCapture, foldStatus: " + iM24457h);
        return iM24457h == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean m16424h() {
        boolean z = f15966b;
        f15966b = false;
        return z;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static boolean m16425i() {
        boolean z = f15965a;
        f15965a = false;
        return z;
    }
}
