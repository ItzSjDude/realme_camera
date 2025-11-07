package com.oplus.camera.professional;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.view.MotionEvent;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.professional.ProMenuManager;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NightPro.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class NightPro {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Activity f15618a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected CameraUIInterface f15619b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected CameraInterface f15620c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OneCamera f15623f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private SharedPreferences f15625h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f15626i;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ProMenuManager f15621d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ProSwitchButtonManager f15622e = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f15624g = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ArrayList f15627j = null;

    /* compiled from: NightPro.java */
    /* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo12587a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo12588a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo12589b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        int mo12590c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        MainShutterButtonInfo mo12591d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean mo12592e();
    }

    public NightPro(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, String str, OneCamera interfaceC2694d) {
        this.f15618a = activity;
        this.f15619b = cameraUIInterface;
        this.f15620c = interfaceC2646a;
        this.f15625h = this.f15620c.mo10590t();
        this.f15626i = str;
        this.f15623f = interfaceC2694d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15745a() {
        return m15731a(CameraUIInterface.KEY_NIGHT_PRO_MODE) && !(1 == Integer.parseInt(this.f15625h.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0))));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m15731a(String str) {
        SharedPreferences sharedPreferences;
        if (this.f15624g.mo12588a(str) && (sharedPreferences = this.f15625h) != null) {
            return "on".equals(sharedPreferences.getString(str, "off"));
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15748b() {
        CameraLog.m12954a("NightPro", "onDeInitCameraMode");
        this.f15619b.mo18067a(R.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.f15619b.mo18108a(true, true, false);
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            c2900r.m15883g();
            this.f15621d.m15868a((ProMenuManager.IntrinsicsJvm.kt_4) null);
            this.f15621d = null;
        }
        ProSwitchButtonManager c2901s = this.f15622e;
        if (c2901s != null) {
            c2901s.m15911a();
            this.f15622e = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15751c() {
        this.f15619b.mo18067a(R.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.f15619b.mo18108a(true, true, false);
        if (this.f15621d == null || !m15745a()) {
            return;
        }
        this.f15621d.m15889m();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15754d() {
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            return c2900r.m15885i();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m15756e() {
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            return c2900r.m15884h();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m15757f() {
        ProMenuManager c2900r = this.f15621d;
        return c2900r != null && c2900r.m15885i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15743a(boolean z) {
        CameraLog.m12959b("NightPro", "onBeforePreview");
        OneCamera interfaceC2694d = this.f15623f;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(this.f15620c.mo10535ak()));
        }
        if (this.f15621d == null || !m15745a()) {
            return;
        }
        this.f15621d.m15878c(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15747a(CameraRequestTag c2693c, boolean z) {
        boolean zMo12589b = this.f15624g.mo12589b();
        if (this.f15621d != null && m15745a() && !this.f15621d.mo15774a(zMo12589b)) {
            return false;
        }
        if (zMo12589b) {
            this.f15618a.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.OplusGLSurfaceView_11.1
                @Override // java.lang.Runnable
                public void run() {
                    NightPro.this.f15620c.mo10507aI();
                }
            });
        }
        if (this.f15622e == null) {
            return true;
        }
        if (!z && !c2693c.f13396Y) {
            return true;
        }
        this.f15622e.m15912a(8, false);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15744a(byte[] bArr, boolean z, boolean z2) {
        CameraLog.m12954a("NightPro", "onAfterPictureTaken");
        if (m15745a()) {
            this.f15619b.mo18245n();
            this.f15620c.mo10508aJ();
        }
        if (this.f15621d != null && m15745a()) {
            this.f15621d.mo15715a(bArr, z, z2);
        }
        if (this.f15622e == null || !this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE) || m15736v() || this.f15619b.mo18023A() || this.f15619b.mo18159aw() || m15757f()) {
            return;
        }
        this.f15622e.m15912a(0, true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m15758g() {
        if (this.f15622e != null && this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE) && m15736v()) {
            this.f15622e.m15912a(0, true);
        }
    }

    /* renamed from: v */
    private boolean m15736v() {
        Activity activity;
        SharedPreferences sharedPreferences = this.f15625h;
        if (sharedPreferences == null || (activity = this.f15618a) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, activity.getString(R.string.camera_night_tripod_mode_default_value)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15741a(CaptureResult captureResult) {
        if (this.f15621d == null || !m15745a()) {
            return;
        }
        this.f15621d.m15867a(captureResult);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15750b(boolean z) {
        ProMenuManager c2900r;
        CameraLog.m12967f("NightPro", "onResume");
        if (!m15745a() || (c2900r = this.f15621d) == null) {
            return;
        }
        c2900r.mo15776e();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m15759h() {
        if (m15745a()) {
            m15735c(0, false);
        }
        this.f15622e = new ProSwitchButtonManager(this.f15618a, this.f15620c, this.f15619b);
        this.f15622e.m15913a(CameraUIInterface.KEY_NIGHT_PRO_MODE);
        m15733b(this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE) ? 0 : 8, false);
        this.f15619b.mo18288z(false);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m15760i() {
        if (this.f15621d != null && m15745a()) {
            this.f15621d.m15897u();
        }
        if (this.f15622e != null && !m15757f()) {
            this.f15622e.m15916c();
        }
        if (m15745a()) {
            m15735c(0, false);
            this.f15619b.mo18288z(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15733b(int OplusGLSurfaceView_13, boolean z) {
        if (this.f15622e == null) {
            if (OplusGLSurfaceView_13 != 0) {
                return;
            }
            this.f15622e = new ProSwitchButtonManager(this.f15618a, this.f15620c, this.f15619b);
            this.f15622e.m15913a(CameraUIInterface.KEY_NIGHT_PRO_MODE);
        }
        this.f15622e.m15912a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15740a(SharedPreferences sharedPreferences, String str) {
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            c2900r.m15866a(sharedPreferences, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15735c(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("NightPro", "setProMenuVisibility visibility: " + OplusGLSurfaceView_13);
        if (this.f15621d == null) {
            if (OplusGLSurfaceView_13 != 0) {
                return;
            } else {
                m15761j();
            }
        }
        this.f15621d.m15865a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15738a(int OplusGLSurfaceView_13) {
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            c2900r.m15864a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m15761j() {
        this.f15621d = new NightProMenuManager(this.f15618a, this.f15620c, this.f15619b, this.f15626i);
        this.f15621d.m15868a(new ProMenuManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.OplusGLSurfaceView_11.2
            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo12476b() {
                return NightPro.this.m15745a();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12470a() {
                return NightPro.this.f15624g.mo12587a();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12471a(String str) {
                return NightPro.this.f15624g.mo12588a(str);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public int mo12477c() {
                return NightPro.this.f15624g.mo12590c();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12474b(String str) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13069b(str);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12467a(int OplusGLSurfaceView_13) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13028a(OplusGLSurfaceView_13, true);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo12479d() {
                if (NightPro.this.f15623f != null) {
                    return NightPro.this.f15623f.mo13122p();
                }
                return 1;
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12472b(int OplusGLSurfaceView_13) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13029a(OplusGLSurfaceView_13, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12466a(float COUIBaseListPopupWindow_12) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13023a(COUIBaseListPopupWindow_12, true);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12468a(long OplusGLSurfaceView_15) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13066b(OplusGLSurfaceView_15);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12469a(boolean z) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13112l(z);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo12478c(int OplusGLSurfaceView_13) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13147x(OplusGLSurfaceView_13);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo12481e() {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13103i(true);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo12480d(int OplusGLSurfaceView_13) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo12482e(int OplusGLSurfaceView_13) {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_12 */
            public void mo12483f() {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_11 */
            public void mo12484g() {
                if (NightPro.this.f15623f != null) {
                    NightPro.this.f15623f.mo13105j(true);
                }
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_10 */
            public MainShutterButtonInfo mo12485h() {
                return NightPro.this.f15624g.mo12591d();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: OplusGLSurfaceView_13 */
            public boolean mo12486i() {
                return NightPro.this.f15624g.mo12592e();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12475b(boolean z) {
                if (NightPro.this.f15622e == null || !NightPro.this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
                    return;
                }
                NightPro.this.f15622e.m15912a(z ? 0 : 8, false);
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m15762k() {
        if (this.f15621d == null || !m15745a()) {
            return false;
        }
        return this.f15621d.mo15717c();
    }

    /* renamed from: w */
    private void m15737w() throws Resources.NotFoundException {
        if (this.f15621d == null || this.f15625h == null || !m15745a() || !this.f15625h.getBoolean(CameraUIInterface.KEY_RESTORE_NIGHT_PRO_PARAMS, false)) {
            return;
        }
        this.f15625h.edit().remove(CameraUIInterface.KEY_RESTORE_NIGHT_PRO_PARAMS).apply();
        this.f15621d.m15890n();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m15763l() {
        CameraLog.m12954a("NightPro", "onMoreModeShown");
        if (m15745a()) {
            m15735c(8, false);
        }
        m15733b(8, false);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m15764m() {
        CameraLog.m12954a("NightPro", "onMoreModeHidden");
        if (m15745a()) {
            m15735c(0, false);
        }
        m15733b((!this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE) || m15757f()) ? 8 : 0, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15746a(MotionEvent motionEvent) {
        if (this.f15621d == null || !m15745a()) {
            return false;
        }
        return this.f15621d.m15870a(motionEvent);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m15765n() {
        if (this.f15621d != null && m15745a()) {
            this.f15621d.m15895s();
        }
        if (this.f15622e == null || !this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE) || this.f15624g.mo12587a() || this.f15620c.mo10445A() || this.f15619b.mo18023A() || m15757f()) {
            return;
        }
        this.f15622e.m15912a(0, true);
    }

    /* renamed from: o */
    public void m15766o() {
        if (this.f15621d != null && m15745a()) {
            this.f15621d.m15896t();
        }
        if (this.f15622e == null || !this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            return;
        }
        this.f15622e.m15912a(4, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15749b(int OplusGLSurfaceView_13) {
        if (this.f15621d == null || !m15745a()) {
            return;
        }
        this.f15621d.m15872b(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15752c(boolean z) {
        m15735c(z ? 0 : 8, false);
        this.f15622e.m15914a(z);
        m15737w();
        if (this.f15620c.mo10454J()) {
            this.f15619b.mo18033F(true);
            if (this.f15624g.mo12592e()) {
                this.f15619b.mo18077a(0, true);
            } else {
                this.f15619b.mo18068a(0, 1);
            }
        }
        this.f15620c.mo10506aH();
        this.f15619b.mo18288z(false);
        if (!z) {
            this.f15621d.m15890n();
            this.f15621d.m15874b(false);
            if (!this.f15619b.mo18201d() && !this.f15619b.mo18023A() && !this.f15624g.mo12592e()) {
                this.f15619b.mo18068a(0, 1);
            }
            this.f15619b.mo18193d(0);
            this.f15619b.mo18175b(true, false);
            return;
        }
        this.f15621d.m15874b(true);
        this.f15621d.m15900x();
        this.f15620c.mo10472a();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15753d(boolean z) {
        this.f15619b.mo18108a(true, true, false);
        if (z) {
            ProSwitchButtonManager c2901s = this.f15622e;
            if (c2901s != null) {
                c2901s.m15912a(8, false);
            }
            if (this.f15621d != null) {
                m15735c(8, false);
            }
        }
        ProMenuManager c2900r = this.f15621d;
        if (c2900r != null) {
            c2900r.m15879d(true);
        }
    }

    /* renamed from: p */
    public void m15767p() {
        if (!"off".equals(this.f15625h.getString(CameraUIInterface.KEY_NIGHT_PRO_MODE, "off"))) {
            this.f15625h.edit().putString(CameraUIInterface.KEY_NIGHT_PRO_MODE, "off").apply();
        }
        ProSwitchButtonManager c2901s = this.f15622e;
        if (c2901s != null) {
            c2901s.m15914a(false);
            boolean z = 1 == Integer.parseInt(this.f15625h.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)));
            if (this.f15622e.m15915b() || z || this.f15619b.mo18159aw() || this.f15619b.mo18023A()) {
                return;
            }
            this.f15622e.m15912a(0, false);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: q */
    public void m15768q() {
        if (m15745a()) {
            if (!m15757f()) {
                this.f15619b.mo18070a(R.string.camera_scene_night_pro_fixed_tips_oplus_r, -1, false, false, true);
            }
            String string = this.f15625h.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.f15618a.getString(R.string.camera_photo_ratio_default_value));
            char c2 = 65535;
            switch (string.hashCode()) {
                case -1993005596:
                    if (string.equals("standard_high")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -894674659:
                    if (string.equals("square")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1514655:
                    if (string.equals("16_9")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3154575:
                    if (string.equals(DcsMsgData.FULL)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1312628413:
                    if (string.equals("standard")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                this.f15619b.mo18067a(R.string.hint_ratio_4_3);
                return;
            }
            if (c2 == 2) {
                this.f15619b.mo18067a(R.string.hint_ratio_full);
                return;
            } else if (c2 == 3) {
                this.f15619b.mo18067a(R.string.hint_ratio_16_9);
                return;
            } else {
                if (c2 != 4) {
                    return;
                }
                this.f15619b.mo18067a(R.string.hint_ratio_1_1);
                return;
            }
        }
        this.f15619b.mo18067a(R.string.camera_scene_night_pro_fixed_tips_oplus_r);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15739a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("NightPro", "changeModeAllView animationType: " + OplusGLSurfaceView_13 + ", isShow: " + z);
        if (3 == OplusGLSurfaceView_13 && this.f15624g.mo12588a(CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            if (this.f15621d != null) {
                this.f15621d.m15874b((z && this.f15624g.mo12587a()) ? false : z);
            }
            if (z) {
                if (m15745a()) {
                    m15735c(m15745a() ? 0 : 8, true);
                }
                m15733b(0, false);
            } else {
                if (m15745a()) {
                    m15735c(8, true);
                }
                m15733b(8, false);
            }
        }
    }

    /* renamed from: r */
    public List<Integer> m15769r() {
        ArrayList arrayList = this.f15627j;
        if (arrayList != null) {
            return arrayList;
        }
        this.f15627j = new ArrayList();
        this.f15627j.add(Integer.valueOf(R.string.camera_scene_night_tips));
        this.f15627j.add(Integer.valueOf(R.string.camera_scene_night_light_collect_tips_oplus_r));
        this.f15627j.add(Integer.valueOf(R.string.camera_scene_night_low_exposure_time_tips_oplus_r));
        this.f15627j.add(Integer.valueOf(R.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.f15627j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15742a(PlatformImplementations.kt_3 aVar) {
        this.f15624g = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m15755e(boolean z) {
        if (this.f15621d == null || !m15745a()) {
            return;
        }
        this.f15621d.m15879d(true);
    }

    /* renamed from: s */
    public void m15770s() {
        ProSwitchButtonManager c2901s = this.f15622e;
        if (c2901s != null) {
            c2901s.m15917d();
        }
    }

    /* renamed from: t */
    public void m15771t() {
        ProSwitchButtonManager c2901s = this.f15622e;
        if (c2901s != null) {
            c2901s.m15918e();
        }
    }

    /* renamed from: u */
    public void m15772u() {
        ProSwitchButtonManager c2901s = this.f15622e;
        if (c2901s != null) {
            c2901s.m15919f();
        }
    }
}
