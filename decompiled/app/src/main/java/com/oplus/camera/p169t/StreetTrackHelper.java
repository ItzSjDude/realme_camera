package com.oplus.camera.p169t;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p169t.StreetTrackLayout;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: StreetTrackHelper.java */
/* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class StreetTrackHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f16619a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraUIInterface f16621c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f16622d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FixFocusControl f16623e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SharedPreferences f16625g;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StreetTrackLayout f16620b = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f16624f = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private StreetTraceGuideLayout f16626h = null;

    /* compiled from: StreetTrackHelper.java */
    /* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17314a(int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo17318g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        void mo17319h();

        /* renamed from: OplusGLSurfaceView_13 */
        void mo17320i();

        /* renamed from: OplusGLSurfaceView_15 */
        boolean mo17321j();

        /* renamed from: OplusGLSurfaceView_5 */
        boolean mo17322k();
    }

    public StreetTrackHelper(Activity activity, CameraUIInterface cameraUIInterface, CameraInterface interfaceC2646a, OneCamera interfaceC2694d) {
        this.f16619a = null;
        this.f16621c = null;
        this.f16622d = null;
        this.f16623e = null;
        this.f16625g = null;
        this.f16619a = activity;
        this.f16621c = cameraUIInterface;
        this.f16622d = interfaceC2646a;
        this.f16625g = this.f16622d.mo10590t();
        this.f16623e = new FixFocusControl(interfaceC2694d, interfaceC2646a, activity, cameraUIInterface);
        m17337g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17354a() {
        return this.f16620b.m17380f();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m17355b() {
        return this.f16623e.m17226g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17356c() {
        this.f16620b.m17377c();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17357d() {
        StreetTrackLayout viewOnClickListenerC3028h = this.f16620b;
        if (viewOnClickListenerC3028h != null) {
            viewOnClickListenerC3028h.setVisibility(4);
            this.f16620b.removeAllViewsInLayout();
            this.f16620b = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17337g() {
        this.f16620b = new StreetTrackLayout(this.f16619a);
        this.f16620b.m17376b();
        this.f16620b.setTrackListener(new StreetTrackLayout.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.t.COUIBaseListPopupWindow_11.1
            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17360a() {
                StreetTrackHelper.this.m17346l();
                if (StreetTrackHelper.this.f16624f != null) {
                    StreetTrackHelper.this.f16624f.mo17322k();
                }
            }

            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo17362b() {
                if (StreetTrackHelper.this.f16624f != null) {
                    return StreetTrackHelper.this.f16624f.mo17321j();
                }
                return StreetTrackHelper.this.f16622d.mo10445A();
            }

            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo17363c() {
                if (StreetTrackHelper.this.f16621c != null) {
                    StreetTrackHelper.this.f16621c.mo18255p(false);
                    StreetTrackHelper.this.f16621c.mo18223h(false, false);
                    StreetTrackHelper.this.f16622d.mo10492a(true, false);
                }
                if (StreetTrackHelper.this.f16624f != null) {
                    StreetTrackHelper.this.f16624f.mo17318g();
                }
                StreetTrackHelper.this.m17346l();
                StreetTrackHelper.this.m17340i();
                StreetTrackHelper.this.m17350n();
                StreetTrackHelper c3027g = StreetTrackHelper.this;
                c3027g.m17328a(c3027g.f16620b.getY());
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void mo17361a(int r3) {
                /*
                    r2 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "onTouch: motionEvent onTracKMove:"
                    r0.append(r1)
                    r0.append(r3)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "StreetTrackHelp"
                    com.oplus.camera.CameraLog.m12954a(r1, r0)
                    if (r3 == 0) goto L3f
                    r0 = 1
                    if (r3 == r0) goto L30
                    r0 = 2
                    if (r3 == r0) goto L29
                    r0 = 3
                    if (r3 == r0) goto L22
                    goto L4e
                L22:
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = r0.m17359f()
                    goto L4f
                L29:
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = com.oplus.camera.p169t.StreetTrackHelper.m17343j(r0)
                    goto L4f
                L30:
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = com.oplus.camera.p169t.StreetTrackHelper.m17339h(r0)
                    if (r0 != 0) goto L4e
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = com.oplus.camera.p169t.StreetTrackHelper.m17341i(r0)
                    goto L4f
                L3f:
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = com.oplus.camera.p169t.StreetTrackHelper.m17339h(r0)
                    if (r0 != 0) goto L4e
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    boolean r0 = r0.m17358e()
                    goto L4f
                L4e:
                    r0 = 0
                L4f:
                    if (r0 == 0) goto L56
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    com.oplus.camera.p169t.StreetTrackHelper.m17329a(r0)
                L56:
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.p169t.StreetTrackHelper.this
                    com.oplus.camera.t.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 r0 = com.oplus.camera.p169t.StreetTrackHelper.m17331b(r0)
                    if (r0 == 0) goto L67
                    com.oplus.camera.t.COUIBaseListPopupWindow_11 r2 = com.oplus.camera.p169t.StreetTrackHelper.this
                    com.oplus.camera.t.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 r2 = com.oplus.camera.p169t.StreetTrackHelper.m17331b(r2)
                    r2.mo17314a(r3)
                L67:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p169t.StreetTrackHelper.COUIBaseListPopupWindow_2.mo17361a(int):void");
            }

            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo17364d() {
                StreetTrackHelper.this.m17338h();
                if (StreetTrackHelper.this.f16624f != null) {
                    StreetTrackHelper.this.f16624f.mo17319h();
                }
                StreetTrackHelper.this.m17352p();
                StreetTrackHelper.this.f16623e.m17224e();
            }

            @Override // com.oplus.camera.p169t.StreetTrackLayout.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo17365e() {
                if (StreetTrackHelper.this.f16624f != null) {
                    StreetTrackHelper.this.f16624f.mo17320i();
                }
            }
        });
        if (this.f16625g.getBoolean(CameraUIInterface.KEY_STREET_TRACE_GUIDE, true)) {
            this.f16626h = new StreetTraceGuideLayout(this.f16619a, this.f16620b.getTrackMaxRadius());
            this.f16621c.mo18087a((View) this.f16626h, ApsConstant.CAPTURE_MODE_STREET, 5, true);
        }
        this.f16621c.mo18087a((View) this.f16620b, ApsConstant.CAPTURE_MODE_STREET, 3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17328a(float COUIBaseListPopupWindow_12) {
        if (this.f16626h == null || !this.f16625g.getBoolean(CameraUIInterface.KEY_STREET_TRACE_GUIDE, true)) {
            return;
        }
        this.f16626h.m17327a(COUIBaseListPopupWindow_12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m17338h() {
        StreetTraceGuideLayout c3026f = this.f16626h;
        if (c3026f != null) {
            c3026f.m17326a();
            this.f16625g.edit().putBoolean(CameraUIInterface.KEY_STREET_TRACE_GUIDE, false).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m17340i() {
        SharedPreferences sharedPreferences;
        if (this.f16622d == null || (sharedPreferences = this.f16625g) == null || !sharedPreferences.getBoolean(CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER, true)) {
            return;
        }
        this.f16621c.mo18210f(20, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m17342j() {
        CameraLog.m12954a("StreetTrackHelp", "zoomIn");
        if (m17349m()) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 2; OplusGLSurfaceView_13++) {
            this.f16622d.mo10497a(false, 0.03f);
        }
        return this.f16622d.mo10497a(false, 0.03f);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m17358e() {
        CameraLog.m12954a("StreetTrackHelp", "zoomOut");
        if (m17349m()) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 2; OplusGLSurfaceView_13++) {
            this.f16622d.mo10497a(true, 0.03f);
        }
        return this.f16622d.mo10497a(true, 0.03f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m17345k() {
        CameraLog.m12954a("StreetTrackHelp", "fixFocusIn");
        if (m17349m()) {
            return false;
        }
        return this.f16623e.m17221b();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m17359f() {
        CameraLog.m12954a("StreetTrackHelp", "fixFocusOut");
        if (m17349m()) {
            return false;
        }
        return this.f16623e.m17222c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m17346l() {
        VibrateManager c2613aeMo10528ad = this.f16622d.mo10528ad();
        if (c2613aeMo10528ad != null) {
            c2613aeMo10528ad.m11292d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17353a(PlatformImplementations.kt_3 aVar) {
        this.f16624f = aVar;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m17349m() {
        Activity activity;
        SharedPreferences sharedPreferences = this.f16625g;
        if (sharedPreferences == null || (activity = this.f16619a) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, activity.getString(R.string.ultra_wide_angle_default_value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m17350n() {
        if (this.f16622d.mo10454J()) {
            this.f16622d.mo10452H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m17351o() {
        return "on".equals(this.f16625g.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m17352p() {
        CameraUIInterface cameraUIInterface = this.f16621c;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18036H();
            this.f16621c.mo18240l(true, false);
            this.f16621c.mo18228i(true, false);
            if (this.f16623e.m17226g()) {
                return;
            }
            this.f16621c.mo18068a(0, 1);
        }
    }
}
