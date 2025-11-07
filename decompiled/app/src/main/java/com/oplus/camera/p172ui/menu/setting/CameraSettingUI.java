package com.oplus.camera.p172ui.menu.setting;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIAttributes;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.PreferenceMenuOptionGroup;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CameraSettingUI.java */
/* renamed from: com.oplus.camera.ui.menu.setting.o */
/* loaded from: classes2.dex */
public class CameraSettingUI implements CameraConstant {

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Activity f20252g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public ComboPreferences f20253h;

    /* renamed from: OplusGLSurfaceView_13 */
    public CameraUIListener f20254i;

    /* renamed from: q */
    private boolean f20262q;

    /* renamed from: OplusGLSurfaceView_15 */
    public CameraSettingMenuPanel f20255j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    public PreferenceMenuOptionGroup f20256k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    public int f20257l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    protected boolean f20258m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    protected PlatformImplementations.kt_3 f20259n = null;

    /* renamed from: o */
    private IntrinsicsJvm.kt_4 f20260o = null;

    /* renamed from: p */
    private boolean f20261p = false;

    /* renamed from: r */
    private int f20263r = 1;

    /* renamed from: s */
    private int f20264s = 0;

    /* renamed from: t */
    private ArrayList<String> f20265t = new ArrayList<>();

    /* renamed from: u */
    private PathInterpolator f20266u = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: v */
    private PathInterpolator f20267v = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: w */
    private int f20268w = 0;

    /* compiled from: CameraSettingUI.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.o$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo19694a(boolean z, boolean z2, int OplusGLSurfaceView_13);

        /* renamed from: ap */
        void mo19717ap(boolean z);

        /* renamed from: dg */
        ArrayList<String> mo19889dg();

        /* renamed from: OplusGLSurfaceView_6 */
        void mo19971m(String str);

        /* renamed from: OplusGLSurfaceView_11 */
        void mo19973n(String str);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo21419j() {
        return false;
    }

    public CameraSettingUI(Activity activity, ComboPreferences comboPreferences, CameraUIListener cameraUIListener, boolean z) {
        this.f20252g = null;
        this.f20253h = null;
        this.f20254i = null;
        this.f20262q = false;
        this.f20252g = activity;
        this.f20253h = comboPreferences;
        this.f20254i = cameraUIListener;
        this.f20262q = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21542a(PlatformImplementations.kt_3 aVar) {
        this.f20259n = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21563b(MotionEvent motionEvent) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || !cameraSettingMenuPanel.isShown() || !m21520a(this.f20255j, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        CameraLog.m12954a("CameraSettingUI", "needTouchEvent, mCameraSettingMenu is show and dispatchTouchEvent");
        return true;
    }

    /* renamed from: A */
    public void m21523A() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setTranslationY(0.0f);
            this.f20255j.setRotation(0.0f);
        }
    }

    /* renamed from: B */
    public CameraSettingMenuPanel m21524B() {
        return this.f20255j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21520a(View view, int OplusGLSurfaceView_13, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && OplusGLSurfaceView_13 >= i3 && OplusGLSurfaceView_13 <= view.getMeasuredWidth() + i3;
    }

    /* renamed from: C */
    public void m21525C() {
        this.f20260o = new IntrinsicsJvm.kt_4();
        this.f20260o.setName("ParseXmlThread");
        this.f20260o.start();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void mo21418i() {
        CameraLog.m12954a("CameraSettingUI", "onResumeMessage");
        this.f20258m = false;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21240c();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo21416g() {
        CameraLog.m12954a("CameraSettingUI", "onPause");
        this.f20261p = false;
        this.f20258m = true;
        m21575e(false);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21248e();
            this.f20255j.clearAnimation();
            CameraUIListener cameraUIListener = this.f20254i;
            if (cameraUIListener != null && cameraUIListener.mo10848h(CameraUIInterface.KEY_SETTING_SUPPORT) && !this.f20262q) {
                this.f20255j.setAlpha(1.0f);
            }
            this.f20255j.setInitState(false);
        }
        ComboPreferences comboPreferences = this.f20253h;
        if (comboPreferences != null && this.f20262q) {
            comboPreferences.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
            m21577f(CameraUIInterface.KEY_SUB_SETTING);
        }
        PopUpWindowManager.m20714f();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21417h() {
        CameraLog.m12954a("CameraSettingUI", "onDestroy");
        IntrinsicsJvm.kt_4 bVar = this.f20260o;
        if (bVar != null) {
            try {
                bVar.m21585a();
                this.f20260o = null;
            } catch (Exception unused) {
            }
        }
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21267o();
            this.f20255j = null;
        }
        PreferenceMenuOptionGroup c3263h = this.f20256k;
        if (c3263h != null) {
            c3263h.m20719a();
            this.f20256k = null;
        }
        this.f20252g = null;
        this.f20254i = null;
    }

    /* renamed from: D */
    public boolean m21526D() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.m21259j();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21555b(int OplusGLSurfaceView_13) {
        this.f20257l = OplusGLSurfaceView_13;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setSizeRatioType(this.f20257l);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21561b(boolean z, boolean z2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21245c(z, z2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21562b(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21228a(z, z2, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21575e(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setCameraMenuLayout(z);
        }
    }

    /* renamed from: E */
    public void m21527E() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21232b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21405a(int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        IntrinsicsJvm.kt_4 bVar = this.f20260o;
        if (bVar != null) {
            try {
                bVar.join();
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        this.f20261p = true;
        if (this.f20255j == null) {
            mo21402a();
        }
        CameraUIListener cameraUIListener = this.f20254i;
        if (cameraUIListener != null && !cameraUIListener.mo10848h(CameraUIInterface.KEY_FILTER_MENU_UPDATED)) {
            mo21425r();
        }
        m21517a(OplusGLSurfaceView_13, z2, z3);
    }

    /* renamed from: F */
    public void m21528F() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21260k();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21414d() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.mo21050a();
            if (Util.m24190R() == 0) {
                Util.m24269a(this.f20255j, CameraUIAttributes.m18766a(this.f20252g, 3), 300, (Interpolator) null, (Animator.AnimatorListener) null);
            }
        }
    }

    /* renamed from: G */
    public void m21529G() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21262l();
            this.f20255j.setOrientation(this.f20264s);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21554b(float COUIBaseListPopupWindow_12) {
        m21540a(COUIBaseListPopupWindow_12, false, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21540a(float COUIBaseListPopupWindow_12, boolean z, long OplusGLSurfaceView_15) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(COUIBaseListPopupWindow_12 <= 0.0f ? 1.0f : 0.0f, COUIBaseListPopupWindow_12);
                alphaAnimation.setDuration(OplusGLSurfaceView_15);
                alphaAnimation.setInterpolator(this.f20266u);
                this.f20255j.startAnimation(alphaAnimation);
                return;
            }
            cameraSettingMenuPanel.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: H */
    public float m21530H() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getAlpha();
        }
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21565c(int OplusGLSurfaceView_13) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || this.f20262q) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21570d(int OplusGLSurfaceView_13) {
        m21541a(OplusGLSurfaceView_13, 0.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21541a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
        boolean z = (Float.compare(COUIBaseListPopupWindow_12, 0.0f) == 0 && Float.compare(f2, 0.0f) == 0) ? false : true;
        long OplusGLSurfaceView_15 = z ? 400L : 0L;
        if (OplusGLSurfaceView_13 == 0) {
            Util.m24267a(this.f20255j, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, f2, this.f20266u, 400L, this.f20267v, OplusGLSurfaceView_15, (Animation.AnimationListener) null, z ? 150L : 0L);
        } else {
            Util.m24267a(this.f20255j, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, f2, this.f20266u, 250L, this.f20267v, OplusGLSurfaceView_15, (Animation.AnimationListener) null, 0L);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21552a(boolean z, float COUIBaseListPopupWindow_12, float f2, TimeInterpolator timeInterpolator, long OplusGLSurfaceView_15, TimeInterpolator timeInterpolator2, long j2, long j3) {
        Util.m24274a(this.f20255j, z, COUIBaseListPopupWindow_12, f2, timeInterpolator, OplusGLSurfaceView_15, timeInterpolator2, j2, (Animator.AnimatorListener) null, j3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21543a(String str, int OplusGLSurfaceView_13) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21233b(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21548a(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21235b(str, z);
        }
    }

    /* renamed from: I */
    public boolean m21531I() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || cameraSettingMenuPanel.getVisibility() == 0) {
            return true;
        }
        CameraLog.m12959b("CameraSettingUI", "isCameraSettingMenuVisible, mCameraSettingMenu not visible");
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21573e(int OplusGLSurfaceView_13) {
        this.f20263r = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21576f(int OplusGLSurfaceView_13) {
        this.f20264s = OplusGLSurfaceView_13;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setOrientation(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21556b(int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        mo21405a(OplusGLSurfaceView_13, z, z2, z3);
        m21578f(true);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21578f(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setInitState(z);
        }
    }

    /* renamed from: J */
    public CopyOnWriteArrayList<CameraMenuOption> m21532J() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuList();
        }
        return null;
    }

    /* renamed from: K */
    public ArrayList<String> m21533K() {
        return this.f20265t;
    }

    /* renamed from: r */
    public void mo21425r() {
        this.f20265t.clear();
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayListM21532J = m21532J();
        CameraLog.m12954a("CameraSettingUI", "updateSettingMenu, mbCameraOpened: " + this.f20261p + ", this: " + this);
        if (copyOnWriteArrayListM21532J == null || !this.f20261p) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayListM21532J.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (this.f20262q) {
                if (m21553a(next.mo20300a())) {
                    m21571d(next.mo20300a());
                    if (!this.f20254i.mo10867m(next.mo20300a())) {
                        m21544a(next.mo20300a(), next.m21174m(null));
                    } else {
                        m21558b(next.mo20300a(), (String) null);
                    }
                } else {
                    m21574e(next.mo20300a());
                }
            } else if (m21564b(next.mo20300a())) {
                m21571d(next.mo20300a());
                if (!this.f20254i.mo10867m(next.mo20300a())) {
                    m21544a(next.mo20300a(), next.m21174m(null));
                } else {
                    m21558b(next.mo20300a(), (String) null);
                }
            } else if (!m21522j(next.mo20300a())) {
                m21574e(next.mo20300a());
            }
        }
        if (this.f20262q) {
            if (this.f20265t.isEmpty()) {
                this.f20259n.mo19973n(CameraEntry.m13299b(CameraUIInterface.KEY_SUB_SETTING, this.f20263r));
                CameraUIListener cameraUIListener = this.f20254i;
                if (cameraUIListener != null && cameraUIListener.mo10839f(CameraEntry.m13299b(CameraUIInterface.KEY_SETTING, this.f20263r))) {
                    this.f20259n.mo19971m(CameraEntry.m13299b(CameraUIInterface.KEY_SETTING, this.f20263r));
                    return;
                } else {
                    this.f20259n.mo19973n(CameraEntry.m13299b(CameraUIInterface.KEY_SETTING, this.f20263r));
                    return;
                }
            }
            this.f20259n.mo19973n(CameraEntry.m13299b(CameraUIInterface.KEY_SETTING, this.f20263r));
            CameraUIListener cameraUIListener2 = this.f20254i;
            if (cameraUIListener2 == null || !cameraUIListener2.mo10839f(CameraEntry.m13299b(CameraUIInterface.KEY_SUB_SETTING, this.f20263r)) || this.f20254i.mo10814c()) {
                return;
            }
            this.f20259n.mo19971m(CameraEntry.m13299b(CameraUIInterface.KEY_SUB_SETTING, this.f20263r));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21553a(String str) {
        CameraUIListener cameraUIListener = this.f20254i;
        return cameraUIListener != null && cameraUIListener.mo10844g(str) && !this.f20259n.mo19889dg().contains(str) && !(CameraUIInterface.KEY_SETTING.equals(str) && this.f20265t.size() == 0) && (!CameraUIInterface.KEY_VIDEO_FPS.equals(str) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21564b(String str) {
        return this.f20254i.mo10839f(str) && this.f20265t.size() < 4 && this.f20254i.mo10757b(str) && !m21522j(str);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m21522j(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        return CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d) || CameraUIInterface.KEY_SETTING.equals(strM13305d);
    }

    /* renamed from: L */
    public boolean m21534L() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuPanelEnable();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21407a(boolean z, boolean z2) {
        CameraLog.m12954a("CameraSettingUI", "enableCameraSettingMenu(), enable: " + z + ", ashed: " + z2);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21227a(z, z2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo21412c(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || this.f20262q) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(4);
        this.f20255j.setClickable(false);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void mo21420m() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || this.f20262q) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(0);
        this.f20255j.setClickable(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m21569c(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.m21253g(str);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21544a(String str, String str2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21234b(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21558b(String str, String str2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21243c(str, str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21551a(String str, String... strArr) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21226a(str, strArr);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21545a(String str, String str2, String str3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21221a(str, str2, str3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21560b(String str, String... strArr) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21237b(str, strArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21571d(String str) {
        if (!this.f20265t.contains(str) && this.f20254i.mo10757b(str)) {
            if (this.f20262q) {
                PlatformImplementations.kt_3 aVar = this.f20259n;
                if (aVar != null && !aVar.mo19889dg().contains(str)) {
                    this.f20265t.add(str);
                }
            } else {
                this.f20265t.add(str);
            }
        }
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21255h(str);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21574e(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21257i(str);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21577f(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21261k(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21568c(boolean z, boolean z2) {
        CameraLog.m12954a("CameraSettingUI", "resetMenuState, resetVisibility:" + z + ", resetLayout:" + z2);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21238b(z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21402a() {
        CameraLog.m12954a("CameraSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.f20256k);
        CameraLog.m12952a("CameraSettingUI.initializeCameraSettingMenu");
        if (this.f20256k != null) {
            this.f20255j = (CameraSettingMenuPanel) this.f20252g.findViewById(R.id_renamed.oplus_setting_bar);
            InverseManager.INS.registerInverse(this.f20252g, this.f20255j);
            if (2 == this.f20263r) {
                this.f20255j.setInverseColor(false);
            }
            this.f20255j.mo21051a(this.f20253h, this.f20254i, this.f20256k, this.f20257l, false);
        }
        CameraUIListener cameraUIListener = this.f20254i;
        if (cameraUIListener != null) {
            cameraUIListener.mo10717aV();
        }
        CameraLog.m12958b("CameraSettingUI.initializeCameraSettingMenu");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public CameraMenuOption m21579g(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            Iterator<CameraMenuOption> it = cameraSettingMenuPanel.f19961c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (str.equals(next.mo20300a())) {
                    return next;
                }
            }
            return null;
        }
        CameraLog.m12966e("CameraSettingUI", "getSettingMenu, mCameraSettingMenu has not initialize");
        return null;
    }

    /* renamed from: M */
    public void m21535M() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21246d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21517a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraLog.m12954a("CameraSettingUI", "updateSupportedOptionItems");
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel == null || this.f20254i == null || !this.f20261p) {
            return;
        }
        cameraSettingMenuPanel.m21264m();
        if (this.f20263r != 3) {
            List<String> supportedList = CameraConfig.getSupportedList(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, OplusGLSurfaceView_13);
            if (supportedList != null) {
                this.f20255j.m21224a(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, supportedList);
            }
            this.f20255j.m21224a(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, CameraConfig.getSupportedList(CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, OplusGLSurfaceView_13));
        }
        this.f20255j.m21224a(CameraUIInterface.KEY_TORCH_MODE, CameraConfig.getSupportedList(CameraUIInterface.KEY_TORCH_MODE, OplusGLSurfaceView_13));
        this.f20255j.m21224a(CameraUIInterface.KEY_VIDEO_SIZE, Util.m24414c(this.f20252g, OplusGLSurfaceView_13));
        this.f20255j.m21224a(CameraUIInterface.KEY_VIDEO_FPS, new ArrayList(Arrays.asList(this.f20252g.getResources().getStringArray(R.array.video_fps_values))));
        if (z && !this.f20262q && !z2) {
            this.f20255j.setVisibility(0);
            this.f20255j.setAlpha(1.0f);
        }
        this.f20255j.setOrientation(this.f20264s);
        this.f20254i.mo10883y();
    }

    /* renamed from: N */
    public void m21536N() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21250f();
        }
    }

    /* renamed from: O */
    public void m21537O() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21252g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21518a(Context context) throws Resources.NotFoundException {
        CameraMenuOptionInfo c3240bM20718a;
        ArrayList<OptionItemInfo> optionItems;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f20262q) {
            if (CameraEntry.m13302b(this.f20254i.mo10786bc().m13317J())) {
                this.f20256k = new PreferenceMenuOptionGroup(context, R.xml.camera_submenu_settings_from_other_app, true);
            } else {
                this.f20256k = new PreferenceMenuOptionGroup(context, R.xml.camera_submenu_settings, true);
            }
        } else if (CameraEntry.m13302b(this.f20254i.mo10786bc().m13317J())) {
            this.f20256k = new PreferenceMenuOptionGroup(context, R.xml.camera_preferences_from_other_app, false);
        } else {
            this.f20256k = new PreferenceMenuOptionGroup(context, R.xml.camera_preferences, false);
        }
        CameraMenuOptionInfo c3240bM20718a2 = this.f20256k.m20718a(CameraUIInterface.KEY_SWITCH_CAMERA);
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE);
        if (c3240bM20718a2 != null && configIntValue != 0) {
            ArrayList<OptionItemInfo> optionItems2 = c3240bM20718a2.getOptionItems();
            String[] stringArray = context.getResources().getStringArray(R.array.switch_camera_values);
            if (optionItems2 != null) {
                Iterator<OptionItemInfo> it = optionItems2.iterator();
                while (it.hasNext()) {
                    String strM20483c = it.next().m20483c();
                    if (strM20483c != null) {
                        if (strM20483c.equals(stringArray[2]) && (configIntValue & 4) == 0) {
                            it.remove();
                        } else if (strM20483c.equals(stringArray[3]) && (configIntValue & 8) == 0) {
                            it.remove();
                        } else if (strM20483c.equals(stringArray[1]) && (configIntValue & 2) == 0) {
                            it.remove();
                        } else if (strM20483c.equals(stringArray[0]) && (configIntValue & 1) == 0) {
                            it.remove();
                        }
                    }
                }
            }
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) && (c3240bM20718a = this.f20256k.m20718a(CameraUIInterface.KEY_TORCH_MODE)) != null && (optionItems = c3240bM20718a.getOptionItems()) != null) {
            for (OptionItemInfo c3243e : optionItems) {
                if ("on".equals(c3243e.m20483c())) {
                    c3243e.m20484c(context.getString(R.string.camera_flash_mode_torch));
                }
            }
        }
        CameraLog.m12954a("CameraSettingUI", "parseCameraMenuConfig, use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21581g(boolean z) {
        CameraMenuOptionInfo c3240bM20718a;
        ArrayList<OptionItemInfo> optionItems;
        PreferenceMenuOptionGroup c3263h = this.f20256k;
        if (c3263h == null || (c3240bM20718a = c3263h.m20718a(CameraUIInterface.KEY_FILTER_MENU)) == null || (optionItems = c3240bM20718a.getOptionItems()) == null) {
            return;
        }
        for (OptionItemInfo c3243e : optionItems) {
            if ("off".equals(c3243e.m20486e())) {
                int OplusGLSurfaceView_13 = R.drawable.menu_effect_off_selector;
                if (z) {
                    OplusGLSurfaceView_13 = R.drawable.fuji_filter_icon;
                } else if (FilterHelper.m22633g() && !this.f20253h.getBoolean(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) && this.f20254i.mo10848h(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
                    OplusGLSurfaceView_13 = R.drawable.menu_effect_grandtour_recommend;
                }
                c3243e.m20478a(this.f20252g.getDrawable(OplusGLSurfaceView_13));
            } else if ("on".equals(c3243e.m20486e())) {
                c3243e.m20478a(this.f20252g.getDrawable(z ? R.drawable.fuji_filter_highlight_icon : R.drawable.menu_effect_on_selector));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21557b(String str, int OplusGLSurfaceView_13) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21220a(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21572d(boolean z, boolean z2) {
        CameraUIListener cameraUIListener;
        CameraLog.m12954a("CameraSettingUI", "updateSettingBarBg, halfOpaque: " + z + ", needAnimation: " + z2);
        if (this.f20255j == null || !this.f20261p || (cameraUIListener = this.f20254i) == null || cameraUIListener.mo10791bh() || !z2) {
            return;
        }
        if (z) {
            Util.m24269a(this.f20255j, CameraUIAttributes.m18766a(this.f20252g, 1), 200, (Interpolator) null, (Animator.AnimatorListener) null);
        } else {
            Util.m24269a(this.f20255j, this.f20252g.getResources().getColor(R.color.background_color), 200, (Interpolator) null, (Animator.AnimatorListener) null);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m21583h(boolean z) {
        if (this.f20255j == null) {
            return;
        }
        int color = this.f20252g.getColor(R.color.beauty3d_guide_background);
        if (z) {
            Util.m24269a(this.f20255j, color, 200, (Interpolator) null, (Animator.AnimatorListener) null);
        }
    }

    /* renamed from: P */
    public int m21538P() {
        return Util.getSettingMenuPanelHeight();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21559b(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21236b(str, z, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21566c(String str, int OplusGLSurfaceView_13) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21242c(str, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21550a(String str, boolean z, boolean z2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21236b(str, z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21549a(String str, boolean z, int OplusGLSurfaceView_13, int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21225a(str, z, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21546a(String str, String str2, String str3, int OplusGLSurfaceView_13, int i2, int i3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21222a(str, str2, str3, OplusGLSurfaceView_13, i2, i3);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m21582h(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21249e(str);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m21584i(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.m21251f(str);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21547a(String str, String str2, String str3, String str4, int OplusGLSurfaceView_13, int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21223a(str, str2, str3, str4, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21567c(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21244c(str, z);
        }
    }

    /* compiled from: CameraSettingUI.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.o$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Thread {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f20270b;

        public IntrinsicsJvm.kt_4() {
            this.f20270b = false;
            this.f20270b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (this.f20270b) {
                return;
            }
            CameraSettingUI c3335o = CameraSettingUI.this;
            c3335o.m21518a(c3335o.f20252g);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m21585a() {
            this.f20270b = true;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21580g(int OplusGLSurfaceView_13) {
        this.f20268w = OplusGLSurfaceView_13;
        m21539Q();
        if (InverseManager.INS.isInverseColor(this.f20252g.hashCode())) {
            m21521b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21521b() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21256i();
        }
    }

    /* renamed from: Q */
    public void m21539Q() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.f20255j;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.m21254h();
        }
    }
}
