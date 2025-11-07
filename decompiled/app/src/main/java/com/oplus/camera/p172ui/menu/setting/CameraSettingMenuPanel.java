package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.PreferenceMenuOptionGroup;
import com.oplus.camera.p172ui.menu.RotationOptionItemView;
import com.oplus.camera.util.BackgroundUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class CameraSettingMenuPanel extends LinearLayout implements InverseAble, CameraMenuOptionListener {

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean f19959a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean f19960b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CopyOnWriteArrayList<CameraMenuOption> f19961c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public CameraUIListener f19962d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ComboPreferences f19963e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Context f19964f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f19965g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Object f19966h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f19967i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f19968j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f19969k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f19970l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19971m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f19972n;

    /* renamed from: o */
    private int f19973o;

    /* renamed from: p */
    private List<C3308a> f19974p;

    /* renamed from: q */
    private List<CameraMenuOption> f19975q;

    /* renamed from: r */
    private List<CameraMenuOption> f19976r;

    /* renamed from: s */
    private C3309b f19977s;

    /* renamed from: t */
    private C3309b f19978t;

    public void setPendingDrawerGuideAni(Runnable runnable) {
    }

    public CameraSettingMenuPanel(Context context) {
        super(context);
        this.f19966h = new Object();
        this.f19959a = false;
        this.f19960b = true;
        this.f19961c = null;
        this.f19962d = null;
        this.f19963e = null;
        this.f19964f = null;
        this.f19965g = 0;
        this.f19967i = 0;
        this.f19968j = 0;
        this.f19969k = true;
        this.f19970l = false;
        this.f19971m = false;
        this.f19972n = false;
        this.f19973o = 0;
        this.f19974p = null;
        this.f19975q = new ArrayList();
        this.f19976r = new ArrayList();
        this.f19977s = new C3309b();
        this.f19978t = new C3309b();
        this.f19964f = context;
        this.f19967i = this.f19964f.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
    }

    public CameraSettingMenuPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19966h = new Object();
        this.f19959a = false;
        this.f19960b = true;
        this.f19961c = null;
        this.f19962d = null;
        this.f19963e = null;
        this.f19964f = null;
        this.f19965g = 0;
        this.f19967i = 0;
        this.f19968j = 0;
        this.f19969k = true;
        this.f19970l = false;
        this.f19971m = false;
        this.f19972n = false;
        this.f19973o = 0;
        this.f19974p = null;
        this.f19975q = new ArrayList();
        this.f19976r = new ArrayList();
        this.f19977s = new C3309b();
        this.f19978t = new C3309b();
        this.f19964f = context;
        this.f19967i = this.f19964f.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
    }

    public void setCameraMenuLayout(boolean z) {
        CameraLog.m12954a("CameraSettingMenuPanel", "setCameraMenuLayout(), " + this.f19960b + " => " + z);
        if (z && this.f19960b) {
            return;
        }
        this.f19960b = z;
        if (this.f19960b) {
            m21213p();
            requestLayout();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21232b() {
        List<C3308a> list = this.f19974p;
        if (list != null) {
            list.clear();
        }
    }

    public void setInitState(boolean z) {
        this.f19959a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21222a(String str, String str2, String str3, int OplusGLSurfaceView_13, int i2, int i3) {
        CameraMenuOption cameraMenuOptionM21211n = m21211n(str);
        if (cameraMenuOptionM21211n != null) {
            cameraMenuOptionM21211n.mo21111a(str2, str3, OplusGLSurfaceView_13, i2, i3);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21249e(String str) {
        CameraMenuOption cameraMenuOptionM21211n = m21211n(str);
        if (cameraMenuOptionM21211n != null) {
            cameraMenuOptionM21211n.mo21185w();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m21251f(String str) {
        CameraMenuOption cameraMenuOptionM21211n = m21211n(str);
        if (cameraMenuOptionM21211n != null) {
            return cameraMenuOptionM21211n.mo21153e(str);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21223a(String str, String str2, String str3, String str4, int OplusGLSurfaceView_13, int i2) {
        CameraMenuOption cameraMenuOptionM20291c;
        BasicOptionItemList basicOptionItemList = null;
        int iM21450n = -1;
        try {
            CameraMenuOptionFirstLevel viewOnClickListenerC3328h = (CameraMenuOptionFirstLevel) m21211n(str);
            if (viewOnClickListenerC3328h != null) {
                iM21450n = viewOnClickListenerC3328h.m21450n(str3);
                basicOptionItemList = viewOnClickListenerC3328h.f19919b;
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (basicOptionItemList == null || basicOptionItemList.isShown() || (cameraMenuOptionM20291c = basicOptionItemList.m20291c(iM21450n)) == null) {
            return;
        }
        cameraMenuOptionM20291c.mo21112a(str2, str4, str3, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21225a(String str, boolean z, int OplusGLSurfaceView_13, int i2) {
        CameraMenuOption cameraMenuOptionM21211n = m21211n(str);
        if (cameraMenuOptionM21211n != null) {
            cameraMenuOptionM21211n.mo21114a(z, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private CameraMenuOption m21211n(String str) {
        if (str != null && !str.isEmpty()) {
            Iterator<CameraMenuOption> it = this.f19961c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (str.equals(next.mo20300a())) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: p */
    private void m21213p() {
        List<C3308a> list = this.f19974p;
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (this.f19966h) {
            CameraLog.m12954a("CameraSettingMenuPanel", "executeOptions(), length: " + this.f19974p.size());
            for (C3308a c3308a : this.f19974p) {
                if (c3308a != null && 1 == c3308a.f19981a) {
                    m21212o(c3308a.f19982b);
                }
            }
            for (C3308a c3308a2 : this.f19974p) {
                if (c3308a2 != null && c3308a2.f19981a == 0) {
                    m21258j(c3308a2.f19982b);
                }
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19974p.size(); OplusGLSurfaceView_13++) {
                C3308a c3308a3 = this.f19974p.get(OplusGLSurfaceView_13);
                if (c3308a3 != null) {
                    int i2 = c3308a3.f19981a;
                    if (i2 == 2) {
                        m21224a(c3308a3.f19982b, c3308a3.f19984d);
                    } else if (i2 == 5) {
                        m21237b(c3308a3.f19982b, c3308a3.f19985e);
                    } else if (i2 == 6) {
                        m21226a(c3308a3.f19982b, c3308a3.f19985e);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f19974p.size(); i3++) {
                C3308a c3308a4 = this.f19974p.get(i3);
                if (c3308a4 != null) {
                    int i4 = c3308a4.f19981a;
                    if (i4 == 3) {
                        m21243c(c3308a4.f19982b, c3308a4.f19983c);
                    } else if (i4 == 4) {
                        m21234b(c3308a4.f19982b, c3308a4.f19983c);
                    }
                }
            }
            this.f19974p.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21051a(ComboPreferences comboPreferences, CameraUIListener cameraUIListener, PreferenceMenuOptionGroup c3263h, int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("CameraSettingMenuPanel", "initialize, sizeRatioType: " + OplusGLSurfaceView_13);
        this.f19971m = z;
        this.f19963e = comboPreferences;
        m21266n();
        this.f19961c = new CopyOnWriteArrayList<>();
        this.f19962d = cameraUIListener;
        this.f19965g = OplusGLSurfaceView_13;
        List<String> menuPanelOptionList = CameraConfig.getMenuPanelOptionList();
        if (this.f19971m) {
            this.f19967i = this.f19964f.getResources().getDimensionPixelSize(R.dimen.submenu_panel_padding_left_right);
        }
        if (menuPanelOptionList == null || menuPanelOptionList.size() <= 0) {
            return;
        }
        for (String str : menuPanelOptionList) {
            CameraMenuOptionInfo c3240bM20718a = c3263h.m20718a(CameraEntry.m13299b(str, this.f19962d.mo10786bc().m13317J()));
            if (c3240bM20718a != null) {
                CameraMenuOptionFirstLevel viewOnClickListenerC3328h = new CameraMenuOptionFirstLevel(this.f19963e, this.f19964f, c3240bM20718a, this, this.f19962d, this.f19965g, CameraConfig.getOptionKeyDefaultValue(str, getCameraId()), z);
                viewOnClickListenerC3328h.mo21132b();
                this.f19961c.add(viewOnClickListenerC3328h);
                viewOnClickListenerC3328h.mo21107a((ViewGroup) this);
                viewOnClickListenerC3328h.mo21081J().setContentDescription(c3240bM20718a.getOptionTitle());
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21240c() {
        CameraLog.m12954a("CameraSettingMenuPanel", "updateAfterCameraResume(), mMenuList: " + this.f19961c);
        setCameraMenuLayout(true);
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.m21140c();
                }
            }
        }
        m21215q();
    }

    /* renamed from: q */
    private void m21215q() {
        ComboPreferences comboPreferences = this.f19963e;
        if (comboPreferences == null || this.f19962d == null) {
            return;
        }
        boolean zEquals = "on".equals(comboPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_FPS_SETTING_SUPPORT);
        if (1 == this.f19962d.mo10786bc().m13317J() && !this.f19962d.mo10648B() && !TextUtils.isEmpty(this.f19962d.mo10736ao()) && zEquals && !CameraCharacteristicsUtil.m12974a(this.f19962d.mo10653G()) && !configBooleanValue) {
            m21257i(CameraUIInterface.KEY_VIDEO_SIZE);
            return;
        }
        if (this.f19962d.mo10815c(CameraUIInterface.KEY_VIDEO_SIZE, this.f19962d.mo10839f(CameraUIInterface.KEY_VIDEO_SIZE))) {
            m21255h(CameraUIInterface.KEY_VIDEO_SIZE);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21246d() {
        CameraLog.m12954a("CameraSettingMenuPanel", "updateImageIconShadow");
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.mo21135b(next.mo21083L());
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21248e() {
        CameraLog.m12954a("CameraSettingMenuPanel", "updateAfterCameraPause");
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.m21145d();
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21250f() {
        CameraLog.m12954a("CameraSettingMenuPanel", "saveLastMenuPanelState");
        setCameraMenuLayout(false);
        this.f19976r.clear();
        this.f19977s.m21278e();
        this.f19977s.f19987a = this.f19978t.f19987a;
        if (this.f19978t.m21276c() != null) {
            this.f19977s.m21276c().addAll(this.f19978t.m21276c());
            this.f19975q.clear();
            this.f19975q.addAll(this.f19978t.m21276c());
        }
        if (this.f19978t.m21272b() != null) {
            this.f19977s.m21272b().addAll(this.f19978t.m21272b());
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            next.m21076E();
            next.mo21081J().clearAnimation();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21252g() {
        CameraLog.m12954a("CameraSettingMenuPanel", "resetLastMenuPanelState");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19961c.size(); OplusGLSurfaceView_13++) {
            CameraMenuOption cameraMenuOption = this.f19961c.get(OplusGLSurfaceView_13);
            if (cameraMenuOption.m21078G() == 0) {
                cameraMenuOption.m21138b(cameraMenuOption.mo20300a(), false);
            }
        }
        this.f19976r.clear();
        this.f19977s.m21278e();
        this.f19977s.f19987a = 0.0f;
        this.f19975q.clear();
        this.f19978t.m21278e();
        this.f19978t.f19987a = 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21195a(float COUIBaseListPopupWindow_12, boolean z) {
        int width;
        CameraLog.m12954a("CameraSettingMenuPanel", "initMenuViewLeftVisibility, itemSpace: " + COUIBaseListPopupWindow_12 + ", isRightToLeft: " + z);
        float fMo21073B = (float) this.f19967i;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19978t.m21276c().size(); OplusGLSurfaceView_13++) {
            CameraMenuOption cameraMenuOption = this.f19978t.m21276c().get(OplusGLSurfaceView_13);
            if (1 == this.f19978t.m21276c().size()) {
                if (m21209d(cameraMenuOption.mo20300a(), z)) {
                    width = this.f19967i;
                } else if (m21210e(cameraMenuOption.mo20300a(), z)) {
                    width = (getWidth() + this.f19967i) - cameraMenuOption.mo21073B();
                }
                fMo21073B = width;
            }
            this.f19978t.m21272b().add(Integer.valueOf((int) fMo21073B));
            fMo21073B += cameraMenuOption.mo21073B() + COUIBaseListPopupWindow_12;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21194a(float COUIBaseListPopupWindow_12, float f2) {
        CameraLog.m12954a("CameraSettingMenuPanel", "initMenuLayoutLeftForFull, itemSpace: " + COUIBaseListPopupWindow_12 + " firstLeft: " + f2);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19978t.m21276c().size(); OplusGLSurfaceView_13++) {
            CameraMenuOption cameraMenuOption = this.f19978t.m21276c().get(OplusGLSurfaceView_13);
            this.f19978t.m21272b().add(Integer.valueOf((int) f2));
            f2 += cameraMenuOption.mo21073B() + COUIBaseListPopupWindow_12;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m21254h() {
        CameraLog.m12954a("CameraSettingMenuPanel", "removeSecondMenuAfterChangeScreenMode");
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.m21150e();
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m21256i() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.mo21154f();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (this.f19959a && (copyOnWriteArrayList = this.f19961c) != null && copyOnWriteArrayList.size() > 0 && this.f19960b) {
            CameraUIListener cameraUIListener = this.f19962d;
            if (1 == (cameraUIListener != null ? cameraUIListener.mo10816ca() : 0)) {
                m21199a(z, OplusGLSurfaceView_13, i2, i3, i4);
            } else {
                m21204b(z, OplusGLSurfaceView_13, i2, i3, i4);
            }
        }
        CameraUIListener cameraUIListener2 = this.f19962d;
        if (cameraUIListener2 != null) {
            cameraUIListener2.mo10863l(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21199a(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        boolean z2;
        int i5 = i4 - i2;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fold_full_first_level_item_space);
        this.f19978t.m21278e();
        int i6 = 0;
        for (int i7 = 0; i7 < this.f19961c.size(); i7++) {
            CameraMenuOption cameraMenuOption = this.f19961c.get(i7);
            cameraMenuOption.mo21084M();
            if (!cameraMenuOption.m21166i()) {
                i6++;
                this.f19978t.m21276c().add(cameraMenuOption);
            }
        }
        float fMo21073B = (5 - i6) * (this.f19961c.get(0).mo21073B() + dimensionPixelSize);
        if (this.f19978t.f19987a != dimensionPixelSize) {
            this.f19978t.f19987a = dimensionPixelSize;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f19978t.m21272b().size() == 0) {
            m21194a(dimensionPixelSize, fMo21073B);
        }
        int i8 = 0;
        float COUIBaseListPopupWindow_12 = fMo21073B;
        for (int i9 = 0; i9 < this.f19961c.size(); i9++) {
            CameraMenuOption cameraMenuOption2 = this.f19961c.get(i9);
            if (cameraMenuOption2 != null && 8 != cameraMenuOption2.m21078G()) {
                int iMo21073B = cameraMenuOption2.mo21073B();
                int measuredHeight = getMeasuredHeight();
                int i10 = (i5 - measuredHeight) / 2;
                if (1 == cameraMenuOption2.m21077F()) {
                    return;
                }
                if (!this.f19976r.contains(cameraMenuOption2) && this.f19978t.m21276c().contains(cameraMenuOption2)) {
                    CameraMenuOption cameraMenuOptionM21270a = this.f19977s.m21270a(COUIBaseListPopupWindow_12);
                    if (cameraMenuOptionM21270a != null) {
                        if (!m21200a(cameraMenuOptionM21270a, cameraMenuOption2)) {
                            cameraMenuOption2.m21134b(0, true);
                        }
                    } else if (!z2) {
                        cameraMenuOption2.m21134b(0, false);
                    }
                    this.f19976r.add(cameraMenuOption2);
                }
                if (i8 < 5 && this.f19978t.m21276c().contains(cameraMenuOption2)) {
                    int i11 = (int) COUIBaseListPopupWindow_12;
                    cameraMenuOption2.m21102a(i11, i10, i11 + iMo21073B, measuredHeight + i10);
                    COUIBaseListPopupWindow_12 = COUIBaseListPopupWindow_12 + iMo21073B + dimensionPixelSize;
                    i8++;
                }
            } else if (cameraMenuOption2 != null && 8 == cameraMenuOption2.m21078G()) {
                CameraMenuOption cameraMenuOptionM21270a2 = this.f19978t.m21270a(this.f19977s.m21269a(cameraMenuOption2));
                if (cameraMenuOptionM21270a2 != null && this.f19975q.contains(cameraMenuOption2) && !m21200a(cameraMenuOptionM21270a2, cameraMenuOption2)) {
                    cameraMenuOption2.m21134b(8, true);
                }
                this.f19975q.remove(cameraMenuOption2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02f1  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21204b(boolean r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel.m21204b(boolean, int, int, int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21198a(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12, float f2) {
        float fAbs;
        float fAbs2;
        float fM21268a = this.f19977s.m21268a() - COUIBaseListPopupWindow_12;
        float f3 = OplusGLSurfaceView_13 + (f2 * 2.0f);
        if (getMeasuredWidth() <= f3) {
            if (getMeasuredWidth() == f3) {
                if (0.0f > fM21268a) {
                    fAbs2 = Math.abs(fM21268a);
                    fAbs = f2 - fAbs2;
                }
            } else if (getMeasuredWidth() < f3) {
                if (0.0f < fM21268a) {
                    fAbs = f2 - Math.abs(fM21268a);
                } else {
                    fAbs = Math.abs(fM21268a) + f2;
                }
                if ((getMeasuredWidth() - OplusGLSurfaceView_13) / 2.0f >= fAbs) {
                }
            }
            fAbs = f2;
        } else if (0.0f < fM21268a) {
            fAbs = Math.abs(fM21268a) + f2;
        } else {
            fAbs2 = Math.abs(fM21268a);
            fAbs = f2 - fAbs2;
        }
        int i4 = (int) fAbs;
        int i5 = (int) f2;
        if (i4 != i5) {
            double IntrinsicsJvm.kt_5 = fAbs;
            if ((this.f19977s.m21274b((int) Math.ceil(IntrinsicsJvm.kt_5)) || this.f19977s.m21274b((int) Math.floor(IntrinsicsJvm.kt_5))) && 0.0f == this.f19978t.m21269a(this.f19977s.m21270a(fAbs))) {
                cameraMenuOption.m21101a(i4, i5, 0);
                return;
            }
        }
        cameraMenuOption.m21102a(i5, i3, OplusGLSurfaceView_13 + i5, i2 + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009a A[PHI: r2
      0x009a: PHI (r2v27 float) = (r2v24 float), (r2v24 float), (r2v30 float) binds: [B:33:0x00c1, B:35:0x00c4, B:22:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21197a(com.oplus.camera.p172ui.menu.setting.CameraMenuOption r12, float r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel.m21197a(com.oplus.camera.ui.menu.setting.CameraMenuOption, float):void");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m21259j() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.m21160g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m21260k() {
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && !next.m21166i() && ((this.f19962d.mo10848h(CameraUIInterface.KEY_FLASH_MODE) && CameraUIInterface.KEY_FLASH_MODE.equals(next.mo20300a())) || (this.f19962d.mo10848h(CameraUIInterface.KEY_TORCH_MODE) && CameraUIInterface.KEY_TORCH_MODE.equals(next.mo20300a())))) {
                next.m21151e(0);
                next.mo21115a(true, true);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21050a() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && !next.m21166i()) {
                if (this.f19962d.mo10848h(CameraUIInterface.KEY_VIDEO_FLASH_MODE) && CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(next.mo20300a())) {
                    next.m21151e(0);
                } else if (this.f19962d.mo10848h(CameraUIInterface.KEY_TORCH_MODE) && CameraUIInterface.KEY_TORCH_MODE.equals(next.mo20300a()) && !this.f19962d.mo10716aU()) {
                    next.m21151e(0);
                } else {
                    if (1 == next.m21077F()) {
                        next.m21099a(4);
                    } else {
                        if (next.m21075D()) {
                            next.m21076E();
                        }
                        if (next.mo21081J() != null && next.mo21081J().getAnimation() != null && next.mo21081J().getAnimation().hasStarted()) {
                            m21196a(next);
                            next.m21099a(4);
                        } else {
                            m21196a(next);
                            next.m21151e(4);
                        }
                    }
                    next.mo21115a(false, false);
                    if (3 == next.m21077F()) {
                        next.m21146d(0);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21196a(CameraMenuOption cameraMenuOption) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(0L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillBefore(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        cameraMenuOption.mo21081J().clearAnimation();
        cameraMenuOption.mo21081J().startAnimation(animationSet);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m21262l() {
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null) {
                if (next.m21166i()) {
                    next.m21099a(8);
                } else {
                    next.m21151e(0);
                }
            }
        }
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        super.setAlpha(COUIBaseListPopupWindow_12);
        CameraLog.m12954a("CameraSettingMenuPanel", "setAlpha, alpha : " + COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        super.setVisibility(OplusGLSurfaceView_13);
        CameraLog.m12954a("CameraSettingMenuPanel", "setVisibility, visibility : " + OplusGLSurfaceView_13);
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null && cameraUIListener.mo10814c() && (1 == this.f19962d.mo10816ca() || 4 == this.f19962d.mo10816ca())) {
            CameraLog.m12954a("CameraSettingMenuPanel", "setVisibility, set cameraSettingMenu flash item visible while isVideoRecording");
            mo21050a();
            return;
        }
        if (OplusGLSurfaceView_13 == 0 && (copyOnWriteArrayList = this.f19961c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.m21166i()) {
                        next.m21099a(8);
                    } else {
                        next.m21151e(0);
                    }
                }
            }
        }
        if (OplusGLSurfaceView_13 == 0 || this.f19961c == null || !PopUpWindowManager.m20706a()) {
            return;
        }
        Iterator<CameraMenuOption> it2 = this.f19961c.iterator();
        while (it2.hasNext()) {
            CameraMenuOption next2 = it2.next();
            if (next2 != null) {
                next2.m21178p();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21227a(boolean z, boolean z2) {
        this.f19969k = z;
        this.f19970l = z2;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && (!z || !next.m21166i())) {
                    next.mo21115a(z, z2);
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m21253g(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener == null) {
            return false;
        }
        String strM13299b = CameraEntry.m13299b(str, cameraUIListener.mo10786bc().m13317J());
        if (TextUtils.isEmpty(strM13299b) || (copyOnWriteArrayList = this.f19961c) == null) {
            return false;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.mo20300a().equals(strM13299b)) {
                return next.m21182t();
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21234b(String str, String str2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        if (this.f19960b) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && next.m21121a(str, CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(next.mo20300a()), getCameraId()), str2)) {
                    return;
                }
            }
            return;
        }
        if (this.f19974p == null) {
            this.f19974p = new ArrayList();
        }
        synchronized (this.f19966h) {
            C3308a c3308aM21208d = m21208d(str, 4);
            if (c3308aM21208d == null) {
                c3308aM21208d = m21208d(str, 3);
            }
            if (c3308aM21208d == null) {
                c3308aM21208d = new C3308a(this, null);
            } else {
                this.f19974p.remove(c3308aM21208d);
            }
            c3308aM21208d.f19982b = str;
            c3308aM21208d.f19981a = 4;
            c3308aM21208d.f19983c = str2;
            this.f19974p.add(c3308aM21208d);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21243c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null && !cameraUIListener.mo10693a(str)) {
            CameraLog.m12954a("CameraSettingMenuPanel", "enableCameraSettingMenuOption(), this cap mod can not enable key : " + str);
            return;
        }
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            if (this.f19960b) {
                Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    CameraMenuOption next = it.next();
                    if (next != null && !next.m21166i() && next.m21137b(str, CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(next.mo20300a()), getCameraId()), str2)) {
                        return;
                    }
                }
                return;
            }
            if (this.f19974p == null) {
                this.f19974p = new ArrayList();
            }
            synchronized (this.f19966h) {
                C3308a c3308aM21208d = m21208d(str, 3);
                if (c3308aM21208d == null) {
                    c3308aM21208d = m21208d(str, 4);
                }
                if (c3308aM21208d == null) {
                    c3308aM21208d = new C3308a(this, null);
                } else {
                    this.f19974p.remove(c3308aM21208d);
                }
                c3308aM21208d.f19982b = str;
                c3308aM21208d.f19981a = 3;
                c3308aM21208d.f19983c = str2;
                this.f19974p.add(c3308aM21208d);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21226a(String str, String... strArr) {
        if (str == null || str.equals("") || strArr == null || strArr.length <= 0 || this.f19961c == null) {
            return;
        }
        if (!this.f19960b && this.f19974p != null) {
            synchronized (this.f19966h) {
                C3308a c3308a = new C3308a(this, null);
                c3308a.f19982b = str;
                c3308a.f19985e = strArr;
                c3308a.f19981a = 6;
                this.f19974p.add(c3308a);
            }
            return;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.mo21123a(str, strArr)) {
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21221a(String str, String str2, String str3) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (str == null || str.equals("") || str2 == null || str2.equals("") || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if ((next instanceof CameraMenuOptionFirstLevel) && str.equals(next.mo20300a())) {
                List<OptionItemInfo> listM21449ah = ((CameraMenuOptionFirstLevel) next).m21449ah();
                if (listM21449ah != null) {
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM21449ah.size(); OplusGLSurfaceView_13++) {
                        if (str2.equals(listM21449ah.get(OplusGLSurfaceView_13).m20483c())) {
                            listM21449ah.get(OplusGLSurfaceView_13).m20484c(str3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21237b(String str, String... strArr) {
        if (str == null || str.equals("") || strArr == null || strArr.length <= 0 || this.f19961c == null) {
            return;
        }
        if (!this.f19960b && this.f19974p != null) {
            synchronized (this.f19966h) {
                C3308a c3308a = new C3308a(this, null);
                c3308a.f19982b = str;
                c3308a.f19985e = strArr;
                c3308a.f19981a = 5;
                this.f19974p.add(c3308a);
            }
            return;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.m21139b(str, strArr)) {
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21229a(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13) {
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.m21127ac() == OplusGLSurfaceView_13 && next.m21078G() == 0 && !cameraMenuOption.mo20300a().equals(next.mo20300a())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m21255h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null && !cameraUIListener.mo10757b(str)) {
            CameraLog.m12954a("CameraSettingMenuPanel", "addContainMenuOption, the current mode can not add option: " + str);
            return;
        }
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            if (this.f19960b) {
                Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (m21202a(str, it.next())) {
                        requestLayout();
                    }
                }
                return;
            }
            if (this.f19974p == null) {
                this.f19974p = new ArrayList();
            }
            synchronized (this.f19966h) {
                C3308a c3308aM21208d = m21208d(str, 1);
                if (c3308aM21208d == null) {
                    c3308aM21208d = m21208d(str, 0);
                }
                if (c3308aM21208d == null) {
                    C3308a c3308a = new C3308a(this, null);
                    c3308a.f19982b = str;
                    c3308a.f19981a = 1;
                    this.f19974p.add(c3308a);
                } else if (c3308aM21208d.f19981a != 1) {
                    this.f19974p.remove(c3308aM21208d);
                    c3308aM21208d.f19982b = str;
                    c3308aM21208d.f19981a = 1;
                    this.f19974p.add(c3308aM21208d);
                }
            }
        }
    }

    /* renamed from: o */
    private void m21212o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null && !cameraUIListener.mo10757b(str)) {
            CameraLog.m12954a("CameraSettingMenuPanel", "executeAddContainMenuOption, the current mode can not add option: " + str);
            return;
        }
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList == null || !this.f19960b) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            m21202a(str, it.next());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21202a(String str, CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption != null) {
            return cameraMenuOption.m21120a(str, CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(cameraMenuOption.mo20300a()), getCameraId()), getVisibility(), !str.equals(cameraMenuOption.mo20300a()) || 1 != cameraMenuOption.m21127ac() || !m21229a(cameraMenuOption, 1));
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m21257i(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        if (this.f19960b) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.m21138b(str, this.f19959a && !this.f19971m)) {
                        requestLayout();
                        return;
                    }
                }
            }
            return;
        }
        if (this.f19974p == null) {
            this.f19974p = new ArrayList();
        }
        synchronized (this.f19966h) {
            C3308a c3308aM21208d = m21208d(str, 0);
            if (c3308aM21208d == null) {
                c3308aM21208d = m21208d(str, 1);
            }
            if (c3308aM21208d == null) {
                C3308a c3308a = new C3308a(this, null);
                c3308a.f19982b = str;
                c3308a.f19981a = 0;
                this.f19974p.add(c3308a);
            } else if (c3308aM21208d.f19981a != 0) {
                this.f19974p.remove(c3308aM21208d);
                c3308aM21208d.f19982b = str;
                c3308aM21208d.f19981a = 0;
                this.f19974p.add(c3308aM21208d);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m21258j(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null || !this.f19960b) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null) {
                if (next.m21138b(str, this.f19959a && !this.f19971m)) {
                    return;
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private C3308a m21208d(String str, int OplusGLSurfaceView_13) {
        List<C3308a> list;
        if (str == null || str.equals("") || (list = this.f19974p) == null || list.isEmpty()) {
            return null;
        }
        for (C3308a c3308a : this.f19974p) {
            if (str.equals(c3308a.f19982b) && c3308a.f19981a == OplusGLSurfaceView_13) {
                return c3308a;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21220a(String str, int OplusGLSurfaceView_13) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.m21119a(str, OplusGLSurfaceView_13)) {
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21224a(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null) {
            return;
        }
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener == null || cameraUIListener.mo10839f(str) || this.f19962d.mo10844g(str)) {
            CameraUIListener cameraUIListener2 = this.f19962d;
            if (cameraUIListener2 != null) {
                str = CameraEntry.m13299b(str, cameraUIListener2.mo10786bc().m13317J());
            }
            CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
            if (copyOnWriteArrayList != null) {
                if (this.f19960b) {
                    Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        CameraMenuOption next = it.next();
                        if (next != null && next.m21122a(str, CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(next.mo20300a()), getCameraId()), list)) {
                            return;
                        }
                    }
                    return;
                }
                if (this.f19974p == null) {
                    this.f19974p = new ArrayList();
                }
                synchronized (this.f19966h) {
                    C3308a c3308aM21208d = m21208d(str, 2);
                    if (c3308aM21208d == null) {
                        c3308aM21208d = new C3308a(this, null);
                    } else {
                        this.f19974p.remove(c3308aM21208d);
                    }
                    c3308aM21208d.f19982b = str;
                    c3308aM21208d.f19981a = 2;
                    c3308aM21208d.f19984d = list;
                    this.f19974p.add(c3308aM21208d);
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m21261k(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && str.equals(next.mo20300a())) {
                next.m21156f(CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(next.mo20300a()), getCameraId()));
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21233b(String str, int OplusGLSurfaceView_13) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && str.equals(next.mo20300a()) && m21205b(next, OplusGLSurfaceView_13)) {
                m21203b(next);
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m21205b(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13) {
        if (cameraMenuOption.m21128ad() == 0 && OplusGLSurfaceView_13 == 0) {
            return true;
        }
        return cameraMenuOption.m21128ad() != 0 && 8 == OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21203b(CameraMenuOption cameraMenuOption) {
        Object objM21088Q = cameraMenuOption.m21088Q();
        View viewMo21081J = cameraMenuOption.mo21081J();
        if (objM21088Q == null || viewMo21081J == null) {
            CameraLog.m12959b("CameraSettingMenuPanel", "showCameraSubSettingMenuWithAnimation view: " + viewMo21081J + "drawable: " + objM21088Q);
            return;
        }
        if (objM21088Q instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) objM21088Q;
            Object stateDrawable = stateListDrawable.getStateDrawable(stateListDrawable.findStateDrawableIndex(viewMo21081J.getDrawableState()));
            if (stateDrawable instanceof Animatable) {
                ((Animatable) stateDrawable).start();
                return;
            }
            return;
        }
        if (objM21088Q instanceof Animatable) {
            ((Animatable) objM21088Q).start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21235b(String str, boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f19961c) == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && str.equals(next.mo20300a())) {
                next.mo21149d(z);
                return;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m21264m() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (this.f19960b && (copyOnWriteArrayList = this.f19961c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.m21156f(CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(next.mo20300a()), getCameraId()));
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21238b(boolean z, boolean z2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.m21136b(z, z2);
                }
            }
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel$1 */
    class AnimationAnimationListenerC33071 implements Animation.AnimationListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ boolean f19979a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ CameraMenuOption f19980b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CameraMenuOption cameraMenuOption;
            if (!this.f19979a || (cameraMenuOption = this.f19980b) == null) {
                return;
            }
            cameraMenuOption.m21133b(cameraMenuOption.m21186x());
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m21266n() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().m21176n();
            }
            this.f19961c.clear();
            this.f19961c = null;
        }
    }

    /* renamed from: o */
    public void m21267o() {
        clearAnimation();
        m21266n();
        removeAllViews();
        if (this.f19974p != null) {
            synchronized (this.f19966h) {
                this.f19974p.clear();
            }
            this.f19974p = null;
        }
        this.f19964f = null;
        this.f19962d = null;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    public SharedPreferences getSharedPreferences() {
        return this.f19963e;
    }

    public int getCameraId() {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10653G();
        }
        return 0;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    public boolean getMenuPanelEnable() {
        return this.f19969k;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    public boolean getMenuPanelAshed() {
        return this.f19970l;
    }

    @Override // android.widget.LinearLayout, com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    public int getOrientation() {
        return this.f19968j;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f19968j = OplusGLSurfaceView_13;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            it.next().mo21103a(OplusGLSurfaceView_13, true);
        }
    }

    public int getUnremovedMenuNum() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        int OplusGLSurfaceView_13 = 0;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CameraMenuOption> it = this.f19961c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && !next.m21166i()) {
                    OplusGLSurfaceView_13++;
                }
            }
        }
        return OplusGLSurfaceView_13;
    }

    public CopyOnWriteArrayList<CameraMenuOption> getMenuList() {
        return this.f19961c;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21231a(String str, boolean z, boolean z2) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10695a(str, z, z2);
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21230a(String str, boolean z) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10694a(str, z);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo21218a(String str, int OplusGLSurfaceView_13, int i2) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10675a(str, OplusGLSurfaceView_13, i2);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21052a(String str, String str2) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            cameraUIListener.mo10688a(str, str2);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21219a(String str) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            cameraUIListener.mo10832e(str);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo21239b(String str) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10757b(str);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo21241c(String str) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            cameraUIListener.mo10869n(str);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21247d(String str) {
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null) {
            cameraUIListener.mo10871o(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m21209d(String str, boolean z) {
        if (z) {
            return m21265m(str);
        }
        return m21263l(str);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m21210e(String str, boolean z) {
        if (z) {
            return m21263l(str);
        }
        return m21265m(str);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m21263l(String str) {
        return CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || CameraUIInterface.KEY_TORCH_MODE.equals(str);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m21265m(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        return CameraUIInterface.KEY_SETTING.equals(strM13305d) || CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public boolean m21214p(String str) {
        return CameraEntry.m13299b(CameraUIInterface.KEY_FLASH_MODE, this.f19962d.mo10786bc().m13317J()).equals(str) || CameraEntry.m13299b(CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.f19962d.mo10786bc().m13317J()).equals(str) || CameraEntry.m13299b(CameraUIInterface.KEY_TORCH_MODE, this.f19962d.mo10786bc().m13317J()).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public boolean m21216q(String str) {
        return CameraEntry.m13299b(CameraUIInterface.KEY_FILTER_MENU, this.f19962d.mo10786bc().m13317J()).equals(str) || CameraEntry.m13299b(CameraUIInterface.KEY_VIDEO_FILTER_MENU, this.f19962d.mo10786bc().m13317J()).equals(str) || CameraEntry.m13299b(CameraUIInterface.KEY_NIGHT_FILTER_MENU, this.f19962d.mo10786bc().m13317J()).equals(str) || CameraEntry.m13299b(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.f19962d.mo10786bc().m13317J()).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m21217r(String str) {
        return CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str) || CameraUIInterface.KEY_PI_AI.equals(str);
    }

    public void setSizeRatioType(int OplusGLSurfaceView_13) {
        this.f19965g = OplusGLSurfaceView_13;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.mo21155f(this.f19965g);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21245c(boolean z, boolean z2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.mo21144c(z, z2);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21228a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.mo21116a(z, z2, OplusGLSurfaceView_13);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21236b(String str, boolean z, boolean z2) {
        String strM13299b = CameraEntry.m13299b(str, this.f19962d.mo10786bc().m13317J());
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && strM13299b.equals(next.mo20300a()) && (z2 || z != next.m21128ad())) {
                    next.m21165i(z ? 1 : 0);
                    next.mo21104a(next.m21158g(z), next.m21090S());
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21242c(String str, int OplusGLSurfaceView_13) {
        String strM13299b = CameraEntry.m13299b(str, this.f19962d.mo10786bc().m13317J());
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && strM13299b.equals(next.mo20300a()) && OplusGLSurfaceView_13 != next.m21128ad()) {
                    next.m21165i(OplusGLSurfaceView_13);
                }
            }
        }
    }

    public void setShadowOn(boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().mo21152e(z);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19972n = z;
        setBackgroundColor(this.f19973o);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int OplusGLSurfaceView_13) {
        this.f19973o = OplusGLSurfaceView_13;
        super.setBackgroundColor(this.f19972n ? 0 : BackgroundUtil.m24523a(OplusGLSurfaceView_13));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        CameraUIListener cameraUIListener = this.f19962d;
        if (cameraUIListener != null && cameraUIListener.mo10873p() && 3 != (actionMasked = motionEvent.getActionMasked()) && 2 != actionMasked) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21244c(String str, boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.f19961c;
        if (copyOnWriteArrayList == null || str == null) {
            return;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (str.equals(next.mo20300a())) {
                ((RotationOptionItemView) next.mo21081J()).setStateSecond(z);
            }
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel$PlatformImplementations.kt_3 */
    private class C3308a {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f19981a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String f19982b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String f19983c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public List<String> f19984d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public String[] f19985e;

        private C3308a() {
            this.f19981a = -1;
            this.f19983c = null;
            this.f19984d = null;
            this.f19985e = null;
        }

        /* synthetic */ C3308a(CameraSettingMenuPanel cameraSettingMenuPanel, AnimationAnimationListenerC33071 animationAnimationListenerC33071) {
            this();
        }

        public String toString() {
            return new Gson().toJson(this);
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel$IntrinsicsJvm.kt_4 */
    private class C3309b {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f19987a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public List<Integer> f19988b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public List<CameraMenuOption> f19989c;

        /* renamed from: PlatformImplementations.kt_3 */
        public float m21268a() {
            return this.f19987a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public List<Integer> m21272b() {
            return this.f19988b;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public List<CameraMenuOption> m21276c() {
            return this.f19989c;
        }

        public C3309b() {
            if (this.f19988b == null) {
                this.f19988b = new ArrayList();
            }
            if (this.f19989c == null) {
                this.f19989c = new ArrayList();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m21277d() {
            List<CameraMenuOption> list = this.f19989c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m21278e() {
            List<Integer> list = this.f19988b;
            if (list == null) {
                this.f19988b = new ArrayList();
            } else {
                list.clear();
            }
            List<CameraMenuOption> list2 = this.f19989c;
            if (list2 == null) {
                this.f19989c = new ArrayList();
            } else {
                list2.clear();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public CameraMenuOption m21271a(int OplusGLSurfaceView_13) {
            List<CameraMenuOption> list;
            int iIndexOf;
            if (this.f19988b == null || (list = this.f19989c) == null || list.size() != this.f19988b.size() || (iIndexOf = this.f19988b.indexOf(Integer.valueOf(OplusGLSurfaceView_13))) < 0) {
                return null;
            }
            return this.f19989c.get(iIndexOf);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public CameraMenuOption m21270a(float COUIBaseListPopupWindow_12) {
            List<CameraMenuOption> list;
            if (this.f19988b == null || (list = this.f19989c) == null || list.size() != this.f19988b.size()) {
                return null;
            }
            double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
            int iIndexOf = this.f19988b.indexOf(Integer.valueOf((int) Math.ceil(IntrinsicsJvm.kt_5)));
            if (iIndexOf < 0) {
                iIndexOf = this.f19988b.indexOf(Integer.valueOf((int) Math.floor(IntrinsicsJvm.kt_5)));
            }
            if (iIndexOf >= 0) {
                return this.f19989c.get(iIndexOf);
            }
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m21274b(int OplusGLSurfaceView_13) {
            List<Integer> list = this.f19988b;
            if (list != null) {
                return list.contains(Integer.valueOf(OplusGLSurfaceView_13));
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m21273b(float COUIBaseListPopupWindow_12) {
            List<Integer> list = this.f19988b;
            if (list == null) {
                return false;
            }
            double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
            return list.contains(Integer.valueOf((int) Math.ceil(IntrinsicsJvm.kt_5))) || this.f19988b.contains(Integer.valueOf((int) Math.floor(IntrinsicsJvm.kt_5)));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public float m21269a(CameraMenuOption cameraMenuOption) {
            int iIntValue;
            CameraMenuOption cameraMenuOption2;
            if (this.f19988b != null && this.f19989c != null && cameraMenuOption != null) {
                boolean z = 1 == CameraSettingMenuPanel.this.getLayoutDirection();
                if (this.f19989c.contains(cameraMenuOption)) {
                    iIntValue = cameraMenuOption.mo21081J().getLeft();
                } else {
                    String strMo20300a = cameraMenuOption.mo20300a();
                    if (TextUtils.isEmpty(strMo20300a)) {
                        return 0.0f;
                    }
                    if (CameraSettingMenuPanel.this.m21214p(strMo20300a)) {
                        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19989c.size(); OplusGLSurfaceView_13++) {
                            if (z) {
                                int size = (this.f19989c.size() - OplusGLSurfaceView_13) - 1;
                                cameraMenuOption2 = size >= 0 ? this.f19989c.get(size) : this.f19989c.get(0);
                            } else {
                                cameraMenuOption2 = this.f19989c.get(OplusGLSurfaceView_13);
                            }
                            if (CameraSettingMenuPanel.this.m21214p(cameraMenuOption2.mo20300a())) {
                                iIntValue = this.f19988b.get(OplusGLSurfaceView_13).intValue();
                                break;
                            }
                        }
                    }
                    if (CameraSettingMenuPanel.this.m21217r(strMo20300a)) {
                        for (int i2 = 0; i2 < this.f19989c.size(); i2++) {
                            if (CameraSettingMenuPanel.this.m21217r(this.f19989c.get(i2).mo20300a())) {
                                iIntValue = this.f19988b.get(i2).intValue();
                                break;
                            }
                        }
                    }
                    if (CameraSettingMenuPanel.this.m21216q(strMo20300a)) {
                        for (int i3 = 0; i3 < this.f19989c.size(); i3++) {
                            if (CameraSettingMenuPanel.this.m21216q(this.f19989c.get(i3).mo20300a())) {
                                iIntValue = this.f19988b.get(i3).intValue();
                            }
                        }
                    }
                }
                return iIntValue;
            }
            return 0.0f;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m21275b(CameraMenuOption cameraMenuOption) {
            List<CameraMenuOption> list = this.f19989c;
            return (list == null || cameraMenuOption == null || !list.contains(cameraMenuOption)) ? false : true;
        }
    }

    public void setPaddingLeftRight(int OplusGLSurfaceView_13) {
        this.f19967i = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21200a(CameraMenuOption cameraMenuOption, CameraMenuOption cameraMenuOption2) {
        String strMo20300a = cameraMenuOption.mo20300a();
        String strMo20300a2 = cameraMenuOption2.mo20300a();
        if (!TextUtils.isEmpty(strMo20300a) && !TextUtils.isEmpty(strMo20300a2)) {
            if (strMo20300a.equals(strMo20300a2)) {
                return true;
            }
            if ((m21214p(strMo20300a) && m21214p(strMo20300a2)) || ((m21217r(strMo20300a) && m21217r(strMo20300a2)) || (m21216q(strMo20300a) && m21216q(strMo20300a2)))) {
                return true;
            }
        }
        return false;
    }
}
