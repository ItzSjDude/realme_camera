package com.oplus.camera.p172ui.menu.setting;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.setting.down.DrawerLayout;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CameraDrawerSettingUI.java */
/* renamed from: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class CameraDrawerSettingUI extends CameraSettingUI implements DrawerLayout.InterfaceC3323b {

    /* renamed from: o */
    private DrawerLayout f20124o;

    /* renamed from: p */
    private AnimatorSet f20125p;

    /* renamed from: q */
    private boolean f20126q;

    /* renamed from: r */
    private float f20127r;

    /* renamed from: s */
    private PlatformImplementations.kt_3 f20128s;

    /* renamed from: t */
    private int f20129t;

    /* renamed from: u */
    private boolean f20130u;

    /* compiled from: CameraDrawerSettingUI.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo21431a(boolean z);
    }

    public CameraDrawerSettingUI(Activity activity, ComboPreferences comboPreferences, CameraUIListener cameraUIListener, boolean z) {
        super(activity, comboPreferences, cameraUIListener, z);
        this.f20124o = null;
        this.f20125p = null;
        this.f20126q = false;
        this.f20127r = 1.0f;
        this.f20128s = null;
        this.f20129t = 0;
        this.f20130u = false;
        this.f20124o = (DrawerLayout) this.f20252g.findViewById(R.id_renamed.oplus_slide_downward);
        this.f20124o.setOnDrawerListener(this);
        this.f20124o.setPreferences(comboPreferences);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21405a(int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        if (3 == this.f20129t) {
            m21411b(1 == OplusGLSurfaceView_13);
        }
        super.mo21405a(OplusGLSurfaceView_13, z, z2, z3);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21402a() {
        CameraLog.m12954a("CameraDrawerSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.f20256k);
        CameraLog.m12952a("CameraDrawerSettingUI.initializeCameraSettingMenu");
        if (this.f20256k != null) {
            ViewStub viewStub = (ViewStub) this.f20252g.findViewById(R.id_renamed.viewstub_drawer_menu);
            if (viewStub != null) {
                this.f20255j = (CameraSettingMenuPanel) viewStub.inflate().findViewById(R.id_renamed.oplus_subsetting_bar);
                this.f20254i.mo10769bL().mo16554a(this.f20252g, this.f20255j);
            } else {
                this.f20255j = (CameraSettingMenuPanel) this.f20252g.findViewById(R.id_renamed.oplus_subsetting_bar);
            }
            DrawerLayout drawerLayout = this.f20124o;
            if (drawerLayout != null) {
                drawerLayout.m21373a();
            }
            this.f20255j.mo21051a(this.f20253h, this.f20254i, this.f20256k, this.f20257l, true);
        }
        if (this.f20254i != null) {
            this.f20254i.mo10717aV();
        }
        CameraLog.m12958b("CameraDrawerSettingUI.initializeCameraSettingMenu");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21403a(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("CameraDrawerSettingUI", "setCameraDrawerSettingOpenAndClose, isOpen: " + OplusGLSurfaceView_13);
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.setOpenAndClose(OplusGLSurfaceView_13 == 0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21410b() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21379d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m21413c() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.m21380e();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21414d() {
        if (this.f20255j != null) {
            this.f20255j.mo21050a();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo21392e() {
        if (this.f20254i != null) {
            this.f20254i.mo10872p("3");
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21393f() {
        m21421n();
        if (!mo21394k()) {
            CameraLog.m12959b("CameraDrawerSettingUI", "onArrowClick, can't response arrow click, so return");
            return;
        }
        if (this.f20253h != null) {
            this.f20253h.edit().putString(CameraUIInterface.KEY_SUB_SETTING, mo21419j() ? "off" : "on").apply();
        }
        if (this.f20254i != null) {
            this.f20254i.mo10872p("1");
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo21416g() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21381f();
            m21421n();
        }
        AnimatorSet animatorSet = this.f20125p;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f20125p.removeAllListeners();
        }
        this.f20126q = false;
        PlatformImplementations.kt_3 aVar = this.f20128s;
        if (aVar != null) {
            aVar.mo21431a(false);
        }
        super.mo21416g();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21417h() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21377b();
        }
        super.mo21417h();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo21418i() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21382g();
        }
        super.mo21418i();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21390a(boolean z) {
        if (this.f20253h != null) {
            String string = this.f20253h.getString(CameraUIInterface.KEY_SUB_SETTING, "off");
            CameraLog.m12959b("CameraDrawerSettingUI", "onShowAndHide, value: " + string + ", isOpen: " + z);
            if ("on".equals(string) != z) {
                if (this.f20259n != null) {
                    this.f20259n.mo19717ap(z);
                }
                this.f20253h.edit().putString(CameraUIInterface.KEY_SUB_SETTING, z ? "on" : "off").apply();
            }
            if (z) {
                this.f20253h.edit().putBoolean(CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, false).apply();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo21419j() {
        return this.f20253h.getString(CameraUIInterface.KEY_SUB_SETTING, "off").equals("on");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21408a(long OplusGLSurfaceView_15) {
        DrawerLayout drawerLayout = this.f20124o;
        return drawerLayout != null && drawerLayout.m21375a(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21389a(float COUIBaseListPopupWindow_12) {
        if (this.f20252g == null) {
            return;
        }
        InverseManager.INS.setMaskAlpha(this.f20252g, COUIBaseListPopupWindow_12);
        if (1.0f > COUIBaseListPopupWindow_12) {
            m21421n();
        }
        if (0.85f < COUIBaseListPopupWindow_12 && this.f20126q && COUIBaseListPopupWindow_12 > this.f20127r) {
            this.f20126q = false;
            PlatformImplementations.kt_3 aVar = this.f20128s;
            if (aVar != null) {
                aVar.mo21431a(false);
            }
        } else if (0.95f > COUIBaseListPopupWindow_12 && !this.f20126q && COUIBaseListPopupWindow_12 < this.f20127r) {
            this.f20126q = true;
            PlatformImplementations.kt_3 aVar2 = this.f20128s;
            if (aVar2 != null) {
                aVar2.mo21431a(true);
            }
        }
        this.f20127r = COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean mo21394k() {
        if (this.f20254i != null) {
            return (2 == this.f20254i.mo10868n() || m21427t() || this.f20254i.mo10720aY() || !this.f20254i.mo10881w() || !this.f20254i.mo10767bJ()) ? false : true;
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21391a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        if (this.f20259n != null) {
            this.f20259n.mo19694a(z, z2, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo21395l() {
        super.mo21425r();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21404a(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f20129t = OplusGLSurfaceView_13;
        this.f20130u = z;
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21374a(OplusGLSurfaceView_13, i2, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21411b(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f20124o.getLayoutParams();
        if (z) {
            marginLayoutParams.topMargin = this.f20252g.getResources().getDimensionPixelSize(R.dimen.fold_split_screen_front_setting_topMargin_offset);
        } else {
            marginLayoutParams.topMargin = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21406a(PlatformImplementations.kt_3 aVar) {
        this.f20128s = aVar;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21407a(boolean z, boolean z2) {
        if (this.f20124o != null) {
            CameraLog.m12959b("CameraDrawerSettingUI", "enableCameraSettingMenu, enable: " + z);
            this.f20124o.setEnabled(z);
        }
        if (this.f20255j != null) {
            this.f20255j.m21227a(z, true);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo21412c(boolean z) {
        if (this.f20124o != null) {
            CameraLog.m12959b("CameraDrawerSettingUI", "hideCameraSettingMenu, isEnabled: " + z);
            this.f20124o.setRollVisibility(4);
            this.f20124o.setEnabled(z);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo21420m() {
        if (this.f20124o != null) {
            CameraLog.m12959b("CameraDrawerSettingUI", "showCameraSettingMenu");
            this.f20124o.setRollVisibility(0);
            this.f20124o.setEnabled(true);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m21421n() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21378c();
        }
    }

    /* renamed from: o */
    public boolean m21422o() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.m21383h();
        }
        return false;
    }

    /* renamed from: p */
    public boolean m21423p() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.m21384i();
        }
        return false;
    }

    /* renamed from: q */
    public boolean m21424q() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.getEnableTouch();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingUI
    /* renamed from: r */
    public void mo21425r() {
        if (m21427t() || this.f20124o.m21385j()) {
            return;
        }
        super.mo21425r();
    }

    /* renamed from: s */
    public boolean m21426s() {
        boolean z;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayListJ = m21532J();
        if (copyOnWriteArrayListJ != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayListJ.iterator();
            while (it.hasNext()) {
                if (m21553a(it.next().mo20300a())) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        CameraLog.m12959b("CameraDrawerSettingUI", "willSubMenuShow: " + z);
        return z;
    }

    /* renamed from: t */
    public boolean m21427t() {
        AnimatorSet animatorSet = this.f20125p;
        return animatorSet != null && animatorSet.isRunning();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: u */
    public boolean mo21396u() {
        return this.f20254i != null && this.f20254i.mo10800bq();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: v */
    public void mo21397v() {
        if (this.f20254i != null) {
            this.f20254i.mo10696aA();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3323b
    /* renamed from: w */
    public void mo21398w() {
        if (this.f20254i != null) {
            this.f20254i.mo10697aB();
        }
    }

    /* renamed from: x */
    public void m21428x() {
        AnimatorSet animatorSet = this.f20125p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21415d(boolean z) {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.setEnableTouch(z);
        }
    }

    /* renamed from: y */
    public boolean m21429y() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.m21386k();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21409a(MotionEvent motionEvent) {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            return drawerLayout.m21376a(motionEvent);
        }
        return false;
    }

    /* renamed from: z */
    public void m21430z() {
        DrawerLayout drawerLayout = this.f20124o;
        if (drawerLayout != null) {
            drawerLayout.m21387l();
        }
    }
}
