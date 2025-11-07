package com.oplus.camera.screen.a_renamed;

/* compiled from: OutCaptureManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f5342a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f5343b;
    private android.os.Handler h_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.OutCaptureGuideView f5344c = null;
    private com.oplus.camera.screen.out.c_renamed d_renamed = null;
    private com.oplus.camera.screen.out.f_renamed e_renamed = null;
    private com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2 f_renamed = null;
    private com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 g_renamed = null;
    private com.oplus.camera.screen.a_renamed.b_renamed.c_renamed i_renamed = com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.idle;

    /* compiled from: OutCaptureManager.java */
    /* renamed from: com.oplus.camera.screen.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public interface OutCaptureManager_2 {
        void a_renamed();

        void a_renamed(boolean z_renamed);
    }

    /* compiled from: OutCaptureManager.java */
    private enum c_renamed {
        idle,
        guide,
        expand
    }

    public b_renamed() {
        this.h_renamed = null;
        this.h_renamed = new com.oplus.camera.screen.a_renamed.b_renamed.a_renamed();
    }

    public void a_renamed(android.app.Activity activity, com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 interfaceC0113b) {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "requestDeviceFolded");
        this.g_renamed = interfaceC0113b;
        if (!com.oplus.camera.util.Util.u_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "requestDeviceFolded, show guide");
            c_renamed(activity);
            com.oplus.camera.util.e_renamed.a_renamed(0, false, java.lang.System.currentTimeMillis());
            this.i_renamed = com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.guide;
            com.oplus.camera.screen.FolderAngleDetectService.a_renamed(b_renamed(activity));
        } else {
            com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "requestDeviceFolded, without guide");
            com.oplus.camera.util.e_renamed.a_renamed(0, false, java.lang.System.currentTimeMillis());
        }
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "requestDeviceFolded X_renamed");
    }

    public void b_renamed(android.app.Activity activity, com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 interfaceC0113b) {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkIntent");
        this.g_renamed = interfaceC0113b;
        if (g_renamed()) {
            this.i_renamed = com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.expand;
            a_renamed(activity, true);
            com.oplus.camera.screen.FolderAngleDetectService.a_renamed(b_renamed(activity));
        } else if (i_renamed()) {
            a_renamed(activity);
        }
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkIntent X_renamed");
    }

    private void a_renamed(android.app.Activity activity) {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "showReEntryPresentation");
        com.oplus.camera.util.e_renamed.a_renamed(-1, true, java.lang.System.currentTimeMillis());
        this.e_renamed = new com.oplus.camera.screen.out.f_renamed(activity, ((android.hardware.display.DisplayManager) activity.getSystemService("display")).getDisplay(4096));
        this.e_renamed.a_renamed(new com.oplus.camera.screen.out.f_renamed.a_renamed() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$b_renamed$nGdUUjD7cF6fHgRHnT8tfiO39MU
            @Override // com.oplus.camera.screen.out.f_renamed.a_renamed
            public final void onExitButtonClick() {
                this.f_renamed$0.m_renamed();
            }
        });
        this.e_renamed.show();
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "showReEntryPresentation X_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m_renamed() {
        a_renamed();
        com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 interfaceC0113b = this.g_renamed;
        if (interfaceC0113b != null) {
            interfaceC0113b.a_renamed();
        }
    }

    private void a_renamed(android.app.Activity activity, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "showPresentation");
        com.oplus.camera.util.e_renamed.a_renamed(0, true, java.lang.System.currentTimeMillis());
        this.d_renamed = new com.oplus.camera.screen.out.c_renamed(activity, ((android.hardware.display.DisplayManager) activity.getSystemService("display")).getDisplay(4096));
        this.d_renamed.a_renamed(z_renamed);
        this.d_renamed.a_renamed(new com.oplus.camera.screen.out.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$b_renamed$wgPYxMIY-NcZGFN6D4UFh5gAoQo
            @Override // com.oplus.camera.screen.out.c_renamed.a_renamed
            public final void onExitButtonClick() {
                this.f_renamed$0.l_renamed();
            }
        });
        this.d_renamed.show();
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "showPresentation X_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l_renamed() {
        a_renamed(true, false);
    }

    private com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2 b_renamed(final android.app.Activity activity) {
        if (this.f_renamed == null) {
            this.f_renamed = new com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$b_renamed$S0HKtrgJhum0svMeZDFkvxA2Hf0
                @Override // com.oplus.camera.screen.a_renamed.a_renamed.IScreenSwitchInterface_2
                public final void onEvent(int i_renamed) {
                    this.f_renamed$0.a_renamed(activity, i_renamed);
                }
            };
        }
        return this.f_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed) {
        if (this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.guide) {
            if (i_renamed > 30) {
                com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "onEvent, to expand");
                this.i_renamed = com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.expand;
                a_renamed(activity, false);
                a_renamed(true);
                return;
            }
            return;
        }
        if (this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.expand) {
            if (i_renamed < 10 && !g_renamed()) {
                com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "onEvent, to idle");
                b_renamed();
                a_renamed(false);
            } else {
                if (i_renamed < 30) {
                    com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "onEvent, send msg");
                    this.h_renamed.removeMessages(1);
                    android.os.Handler handler = this.h_renamed;
                    handler.sendMessageDelayed(handler.obtainMessage(1), com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    return;
                }
                this.h_renamed.removeMessages(1);
            }
        }
    }

    /* compiled from: OutCaptureManager.java */
    public class a_renamed extends android.os.Handler {
        public a_renamed() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "handleMessage, msg: " + message.what);
            if (1 == message.what && com.oplus.camera.screen.a_renamed.b_renamed.this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.expand && !com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
                com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "handleMessage, to idle");
                com.oplus.camera.screen.a_renamed.b_renamed.this.b_renamed();
                com.oplus.camera.screen.a_renamed.b_renamed.this.a_renamed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        k_renamed();
        com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 interfaceC0113b = this.g_renamed;
        if (interfaceC0113b != null) {
            interfaceC0113b.a_renamed(z_renamed);
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkHideReEntry");
        com.oplus.camera.screen.out.f_renamed fVar = this.e_renamed;
        if (fVar != null) {
            if (fVar.isShowing()) {
                this.e_renamed.dismiss();
            }
            this.e_renamed = null;
            com.oplus.camera.util.e_renamed.a_renamed(-1, false, java.lang.System.currentTimeMillis());
        }
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkHideReEntry X_renamed");
    }

    public void b_renamed() {
        a_renamed(false, false);
    }

    public void c_renamed() {
        com.oplus.camera.screen.FolderAngleDetectService.b_renamed(this.f_renamed);
        this.f_renamed = null;
        this.h_renamed.removeCallbacksAndMessages(null);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkHideOutCapture");
        f5343b = z_renamed;
        f5342a = z2;
        this.i_renamed = com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.idle;
        k_renamed();
        j_renamed();
        com.oplus.camera.screen.FolderAngleDetectService.b_renamed(this.f_renamed);
        com.oplus.camera.util.e_renamed.a_renamed(-1, false, java.lang.System.currentTimeMillis());
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "checkHideOutCapture X_renamed");
    }

    private void j_renamed() {
        com.oplus.camera.screen.out.c_renamed cVar = this.d_renamed;
        if (cVar != null) {
            if (cVar.isShowing()) {
                this.d_renamed.dismiss();
            }
            this.d_renamed = null;
        }
    }

    private void c_renamed(android.app.Activity activity) {
        if (this.f5344c == null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root);
            activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.out_capture_guide, viewGroup);
            this.f5344c = (com.oplus.camera.ui.OutCaptureGuideView) viewGroup.findViewById(com.oplus.camera.R_renamed.id_renamed.out_capture_guide);
            this.f5344c.setListener(new com.oplus.camera.ui.OutCaptureGuideView.a_renamed() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$EpeFfsufbbAxvy7Q9ggJfyHahMs
                @Override // com.oplus.camera.ui.OutCaptureGuideView.a_renamed
                public final void onExitButtonClick() {
                    this.f_renamed$0.b_renamed();
                }
            });
        }
        this.f5344c.a_renamed();
    }

    private void k_renamed() {
        if (this.f5344c != null) {
            com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "hideOutCaptureGuide");
            this.f5344c.b_renamed();
        }
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "onPause, mStatus: " + this.i_renamed.name());
        if (this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.guide) {
            b_renamed();
        }
        j_renamed();
        a_renamed();
    }

    public boolean e_renamed() {
        return this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.expand;
    }

    public boolean f_renamed() {
        return this.i_renamed == com.oplus.camera.screen.a_renamed.b_renamed.c_renamed.guide;
    }

    public static boolean g_renamed() {
        int iH = com.oplus.camera.util.Util.h_renamed();
        com.oplus.camera.e_renamed.b_renamed("OutCaptureManager", "isIntentOutCapture, foldStatus: " + iH);
        return iH == 0;
    }

    public static boolean h_renamed() {
        boolean z_renamed = f5343b;
        f5343b = false;
        return z_renamed;
    }

    public static boolean i_renamed() {
        boolean z_renamed = f5342a;
        f5342a = false;
        return z_renamed;
    }
}
