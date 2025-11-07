package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUITool;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemIconTextList;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.RotationOptionItemView;
import com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.util.Util;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import com.p078a.p079a.SpringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class CameraMenuOption implements BasicOptionItemList.OptionItemListListener, PopUpWindowAnimationListener {

    /* renamed from: A */
    private int f19907A;

    /* renamed from: C */
    private ArrayList<OptionItemInfo> f19909C;

    /* renamed from: D */
    private int f19910D;

    /* renamed from: PlatformImplementations.kt_3 */
    public ComboPreferences f19918a;

    /* renamed from: OplusGLSurfaceView_15 */
    protected int f19927j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected Context f19928k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected CameraMenuOptionListener f19929l;

    /* renamed from: OplusGLSurfaceView_11 */
    protected CameraUIListener f19931n;

    /* renamed from: p */
    protected CameraMenuOptionInfo f19933p;

    /* renamed from: z */
    private int f19943z;

    /* renamed from: r */
    private final PathInterpolator f19935r = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: s */
    private final PathInterpolator f19936s = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: t */
    private final PathInterpolator f19937t = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public BasicOptionItemList f19919b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ViewGroup f19920c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f19921d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f19922e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected boolean f19923f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean f19924g = true;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean f19925h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    protected boolean f19926i = false;

    /* renamed from: u */
    private boolean f19938u = false;

    /* renamed from: OplusGLSurfaceView_6 */
    protected OnItemClickListener f19930m = null;

    /* renamed from: o */
    protected int f19932o = 0;

    /* renamed from: q */
    protected boolean f19934q = true;

    /* renamed from: v */
    private boolean f19939v = false;

    /* renamed from: w */
    private LayoutTranslationAnimation f19940w = null;

    /* renamed from: x */
    private int f19941x = 0;

    /* renamed from: y */
    private int f19942y = 0;

    /* renamed from: B */
    private String f19908B = null;

    /* renamed from: E */
    private AnimationSet f19911E = null;

    /* renamed from: F */
    private AnimationSet f19912F = null;

    /* renamed from: G */
    private float f19913G = 0.5f;

    /* renamed from: H */
    private Spring f19914H = null;

    /* renamed from: I */
    private Spring f19915I = null;

    /* renamed from: J */
    private boolean f19916J = false;

    /* renamed from: K */
    private boolean f19917K = false;

    public interface OnItemClickListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20299a(CameraMenuOption cameraMenuOption);
    }

    /* renamed from: B */
    public int mo21073B() {
        return 0;
    }

    /* renamed from: C */
    public int mo21074C() {
        return 0;
    }

    /* renamed from: J */
    public View mo21081J() {
        return null;
    }

    /* renamed from: L */
    public boolean mo21083L() {
        return false;
    }

    /* renamed from: M */
    public void mo21084M() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21104a(Drawable drawable, boolean z) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21105a(View view) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21109a(String str, OptionItemInfo c3243e) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo21110a(String str, String str2, int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21111a(String str, String str2, int OplusGLSurfaceView_13, int i2, int i3) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21112a(String str, String str2, String str3, int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21114a(boolean z, int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21116a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21117a(boolean z, boolean z2, long OplusGLSurfaceView_15) {
    }

    @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo10887b(String str) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21135b(boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo21144c(boolean z, boolean z2) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21149d(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo21152e(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo21153e(String str) {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21154f() {
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m21160g() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21163h(String str) {
    }

    /* renamed from: u */
    protected void mo21183u() {
    }

    /* renamed from: v */
    protected void mo21184v() {
    }

    /* renamed from: w */
    public void mo21185w() {
    }

    /* renamed from: y */
    public void mo21187y() {
    }

    /* renamed from: z */
    protected int mo21188z() {
        return 0;
    }

    public CameraMenuOption(ComboPreferences comboPreferences, Context context, CameraMenuOptionInfo c3240b, CameraMenuOptionListener interfaceC3329i, CameraUIListener cameraUIListener, int OplusGLSurfaceView_13, String str) {
        this.f19918a = null;
        this.f19927j = 0;
        this.f19928k = null;
        this.f19929l = null;
        this.f19931n = null;
        this.f19933p = null;
        this.f19943z = 0;
        this.f19907A = 0;
        this.f19909C = null;
        this.f19910D = 0;
        this.f19928k = context;
        this.f19918a = comboPreferences;
        this.f19929l = interfaceC3329i;
        if (c3240b != null) {
            this.f19933p = c3240b;
            this.f19933p.setCameraUIListener(cameraUIListener);
            if (!CameraUITool.m20062a(this.f19933p)) {
                CameraLog.m12954a("CameraMenuOption", "CameraMenuOption, getOptionKey: " + c3240b.getOptionKey());
                return;
            }
            this.f19909C = new ArrayList<>(this.f19933p.getOptionItems());
            m21173l(m21174m(str));
        }
        this.f19943z = this.f19928k.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
        this.f19907A = this.f19928k.getResources().getDimensionPixelSize(R.dimen.menu_rec_mode_padding_left);
        this.f19910D = this.f19928k.getResources().getDimensionPixelSize(R.dimen.sub_menu_fade_out_y);
        this.f19931n = cameraUIListener;
        this.f19927j = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21132b() {
        mo21179q();
        mo21181s();
        m21140c();
        boolean z = this.f19934q;
        this.f19922e = !z;
        mo21115a(z, this.f19922e);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21140c() {
        if (this.f19921d) {
            return;
        }
        PopUpWindowManager.m20701a(this);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21145d() {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList != null) {
            basicOptionItemList.m20296g();
        }
        if (m21075D()) {
            m21076E();
        }
        m21136b(true, true);
        PopUpWindowManager.m20708b(this);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21150e() {
        m21175m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21099a(int OplusGLSurfaceView_13) {
        if (this.f19923f || m21095X() <= 0) {
            OplusGLSurfaceView_13 = 8;
        }
        if (mo21081J() == null || m21078G() == OplusGLSurfaceView_13) {
            return;
        }
        mo21081J().setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21115a(boolean z, boolean z2) {
        Spring c1032f;
        if (!this.f19922e && mo21181s()) {
            if (mo21081J() != null) {
                mo21081J().setEnabled(z);
                boolean z3 = z2 && !z;
                if (!z3 && (c1032f = this.f19914H) != null && !c1032f.m5486i()) {
                    this.f19914H.m5488k();
                    this.f19914H.m5487j();
                }
                mo21081J().setAlpha(z3 ? 0.5f : 1.0f);
                if (mo21081J() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) mo21081J();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < viewGroup.getChildCount(); OplusGLSurfaceView_13++) {
                        viewGroup.getChildAt(OplusGLSurfaceView_13).setEnabled(z);
                    }
                }
            }
            this.f19934q = z;
            BasicOptionItemList basicOptionItemList = this.f19919b;
            if (basicOptionItemList != null) {
                basicOptionItemList.m20284a(z, z2);
                return;
            }
            return;
        }
        if (mo21081J() != null) {
            mo21081J().setEnabled(false);
            mo21081J().setAlpha(0.5f);
            if (mo21081J() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) mo21081J();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    viewGroup2.getChildAt(i2).setEnabled(false);
                }
            }
        }
        this.f19934q = false;
        BasicOptionItemList basicOptionItemList2 = this.f19919b;
        if (basicOptionItemList2 != null) {
            basicOptionItemList2.m20284a(false, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo20301a(com.oplus.camera.p172ui.menu.setting.CameraMenuOption r5, int r6) {
        /*
            r4 = this;
            com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_13 r5 = r4.f19929l
            if (r5 == 0) goto L92
            java.lang.String r0 = r4.mo20300a()
            r1 = 0
            r2 = 1
            boolean r5 = r5.mo21231a(r0, r2, r1)
            if (r5 != 0) goto L30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onItemSelected, key: "
            r5.append(r6)
            java.lang.String r4 = r4.mo20300a()
            r5.append(r4)
            java.lang.String r4 = ", return"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "CameraMenuOption"
            com.oplus.camera.CameraLog.m12954a(r5, r4)
            return
        L30:
            com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_13 r5 = r4.f19929l
            java.lang.String r0 = r4.mo20300a()
            int r3 = r4.f19932o
            java.lang.String r5 = r5.mo21218a(r0, r3, r6)
            if (r5 == 0) goto L44
            java.util.ArrayList<com.oplus.camera.ui.menu.COUIBaseListPopupWindow_8> r6 = r4.f19909C
            int r6 = com.oplus.camera.p172ui.CameraUITool.m20061a(r5, r6)
        L44:
            int r5 = r4.f19932o
            if (r5 == r6) goto L5b
            r4.m21165i(r6)
            r4.mo21180r()
            com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_13 r5 = r4.f19929l
            java.lang.String r6 = r4.mo20300a()
            boolean r5 = r5.mo21230a(r6, r2)
            if (r5 == 0) goto L5b
            goto L5c
        L5b:
            r1 = r2
        L5c:
            com.oplus.camera.ui.menu.BasicOptionItemList r5 = r4.f19919b
            if (r5 == 0) goto L70
            com.oplus.camera.ui.menu.IntrinsicsJvm.kt_4 r6 = r4.f19933p
            android.graphics.Bitmap r6 = r6.getOptionSingleIcon()
            r5.setOptionItemIcon(r6)
            com.oplus.camera.ui.menu.BasicOptionItemList r5 = r4.f19919b
            int r6 = r4.f19932o
            r5.setSelectItemIndex(r6)
        L70:
            android.view.View r5 = r4.mo21081J()
            if (r5 == 0) goto L84
            r5 = 3
            int r6 = r4.m21127ac()
            if (r5 == r6) goto L84
            android.view.View r5 = r4.mo21081J()
            r5.invalidate()
        L84:
            if (r1 == 0) goto L89
            r4.m21178p()
        L89:
            com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_13 r5 = r4.f19929l
            java.lang.String r4 = r4.mo20300a()
            r5.mo21219a(r4)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraMenuOption.mo20301a(com.oplus.camera.ui.menu.setting.CameraMenuOption, int):void");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m21164h() {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        return basicOptionItemList != null && basicOptionItemList.isShown();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m21166i() {
        return this.f19923f;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m21169j() {
        return this.f19924g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21113a(boolean z) {
        this.f19924g = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21103a(int OplusGLSurfaceView_13, boolean z) {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList != null) {
            basicOptionItemList.mo20281a(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m21171k() {
        m21172l();
        if (this.f19919b != null) {
            this.f19931n.mo10769bL().mo16576e(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$U-iLBZn4BP4aQ9rJbPuE6YE_QkY
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m21071d(objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$-0L38qLLrCJsKmDCdwHbKVqY99k
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m21069c(objArr);
                }
            });
            this.f19919b.setVisibility(8);
            this.f19919b.mo20281a(this.f19929l.getOrientation(), false);
            this.f19919b.setOptionItemIcon(this.f19933p.getOptionSingleIcon());
            this.f19919b.setSelectItemIndex(this.f19932o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m21071d(Object[] objArr) {
        this.f19919b.mo20280a(this.f19927j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m21069c(Object[] objArr) {
        this.f19919b.setBackground(ContextCompat.m2248a(this.f19928k, R.drawable.bg_second_level_panel_black));
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m21172l() {
        int iM21095X;
        CameraLog.m12954a("CameraMenuOption", "initializeOptionItems");
        if (m21097Z() || (iM21095X = m21095X()) <= 0) {
            return;
        }
        this.f19919b = new OptionItemIconTextList(this.f19928k, this.f19931n);
        this.f19919b.setId(R.id_renamed.camera_setting_layout_second_level);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM21095X; OplusGLSurfaceView_13++) {
            CameraMenuOptionSecondLevel viewOnClickListenerC3330j = new CameraMenuOptionSecondLevel(this.f19918a, this.f19928k, this.f19931n, this.f19927j);
            viewOnClickListenerC3330j.mo21132b();
            OptionItemInfo c3243eM21162h = m21162h(OplusGLSurfaceView_13);
            if (c3243eM21162h != null) {
                if (m21127ac() == 3) {
                    if (DcsMsgData.FULL.equals(c3243eM21162h.m20483c()) && Util.m24498u()) {
                        viewOnClickListenerC3330j.m21455b(this.f19928k.getDrawable(R.drawable.photo_ratio_14_15_selector), false);
                    } else {
                        viewOnClickListenerC3330j.m21455b(c3243eM21162h.m20476a().getConstantState().newDrawable(), false);
                    }
                } else if (m21127ac() == 4) {
                    viewOnClickListenerC3330j.mo21163h(String.format(Locale.getDefault(), "%IntrinsicsJvm.kt_5", Integer.valueOf(c3243eM21162h.m20483c())) + "X");
                } else {
                    viewOnClickListenerC3330j.mo21163h(c3243eM21162h.m20486e());
                }
            }
            this.f19919b.mo20286a(viewOnClickListenerC3330j);
        }
        this.f19919b.setTitleName(m21085N());
        this.f19919b.setOptionItemIcon(this.f19933p.getOptionSingleIcon());
        this.f19919b.setSelectItemIndex(this.f19932o);
        this.f19919b.setOptionItemListListener(this);
        if (1 == this.f19931n.mo10816ca()) {
            this.f19931n.mo10769bL().mo16524a(mo21081J(), this.f19919b, this.f19928k, iM21095X);
        } else if (3 == this.f19931n.mo10816ca() && 1 == this.f19931n.mo10653G()) {
            this.f19919b.mo20282a(mo21081J(), 0, this.f19928k.getResources().getDimensionPixelSize(R.dimen.fold_split_screen_front_setting_topMargin_offset_20));
        } else if (4 == this.f19931n.mo10816ca()) {
            this.f19919b.mo20298i();
            this.f19931n.mo10769bL().mo16524a(mo21081J(), this.f19919b, this.f19928k, iM21095X);
        } else {
            this.f19919b.mo20282a(mo21081J(), 0, 2);
        }
        this.f19919b.setVisibility(8);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m21175m() {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList != null) {
            basicOptionItemList.mo20297h();
            this.f19919b = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m21176n() {
        m21136b(true, true);
        m21113a(true);
        CameraMenuOptionInfo c3240b = this.f19933p;
        if (c3240b != null) {
            c3240b.release();
            this.f19933p = null;
        }
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList != null) {
            Iterator<OptionItemInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                OptionItemInfo next = it.next();
                if (next != null) {
                    next.m20488g();
                }
            }
            this.f19909C.clear();
            this.f19909C = null;
        }
        this.f19929l = null;
        PopUpWindowManager.m20708b(this);
        m21175m();
        if (mo21081J() != null) {
            mo21081J().clearAnimation();
        }
        LayoutTranslationAnimation layoutTranslationAnimation = this.f19940w;
        if (layoutTranslationAnimation != null) {
            layoutTranslationAnimation.cancel();
            this.f19940w = null;
        }
        mo21072A();
        this.f19928k = null;
    }

    /* renamed from: o */
    public void m21177o() {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList != null) {
            PopUpWindowManager.m20700a(basicOptionItemList);
        }
    }

    /* renamed from: p */
    public void m21178p() {
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList == null || !basicOptionItemList.isShown()) {
            return;
        }
        this.f19919b.m20294e();
    }

    /* renamed from: q */
    public void mo21179q() {
        if (m21095X() > 0) {
            mo21104a(m21089R(), m21090S());
        } else {
            mo21104a((Drawable) null, false);
        }
        mo21163h(m21093V());
        if (mo21081J() != null) {
            mo21081J().invalidate();
        }
    }

    /* renamed from: r */
    public void mo21180r() {
        mo21179q();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21119a(String str, int OplusGLSurfaceView_13) {
        if (str == null || !str.equals(mo20300a())) {
            return false;
        }
        if (this.f19909C == null) {
            return true;
        }
        for (int i2 = 0; i2 < this.f19909C.size(); i2++) {
            OptionItemInfo c3243e = this.f19909C.get(i2);
            c3243e.m20478a(this.f19928k.getDrawable(OplusGLSurfaceView_13));
            mo21104a(c3243e.m20476a(), false);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21122a(String str, String str2, List<String> list) {
        if (str == null || !str.equals(mo20300a())) {
            return false;
        }
        if (mo21124a(list, m21174m(str2))) {
            if (this.f19919b != null) {
                m21175m();
            }
            mo21179q();
            if (m21095X() < 2) {
                mo21115a(false, true);
            } else if (!this.f19922e && this.f19929l.getMenuPanelEnable()) {
                mo21115a(true, false);
            }
            if (m21095X() <= 0) {
                m21099a(8);
            } else {
                m21156f(str2);
            }
        } else {
            m21156f(str2);
            mo21179q();
        }
        return true;
    }

    /* renamed from: s */
    protected boolean mo21181s() {
        return m21095X() >= 2;
    }

    /* renamed from: t */
    public boolean m21182t() {
        return this.f19934q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21121a(String str, String str2, String str3) {
        if (str != null && !str.equals(mo20300a())) {
            return false;
        }
        CameraLog.m12954a("CameraMenuOption", "disableMenuOption, key: " + str + ", keyValue: " + str3);
        if (mo21181s()) {
            this.f19922e = true;
            mo21115a(false, true);
            this.f19934q = !this.f19922e;
            if (str3 == null) {
                this.f19925h = false;
                m21156f(str2);
            } else if (m21167i(str3)) {
                mo21104a(m21089R(), m21090S());
            }
            if (mo21081J() != null) {
                mo21081J().invalidate();
            }
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21137b(String str, String str2, String str3) {
        if (str != null && !str.equals(mo20300a())) {
            return false;
        }
        CameraLog.m12954a("CameraMenuOption", "enableMenuOption, key: " + str + ", keyValue: " + str3);
        if (mo21181s()) {
            this.f19922e = false;
            mo21115a(true, false);
            this.f19934q = !this.f19922e;
            if (str3 == null) {
                this.f19925h = false;
                m21156f(str2);
            } else if (m21167i(str3)) {
                mo21104a(m21089R(), m21090S());
            }
            if (mo21081J() != null) {
                mo21081J().invalidate();
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21123a(String str, String... strArr) {
        if (str == null || !str.equals(mo20300a())) {
            return false;
        }
        CameraLog.m12954a("CameraMenuOption", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str2 : strArr) {
            int iM21170k = m21170k(str2);
            if (iM21170k >= 0 && this.f19919b != null) {
                CameraMenuOptionSecondLevel viewOnClickListenerC3330j = new CameraMenuOptionSecondLevel(this.f19918a, this.f19928k, this.f19931n, this.f19927j);
                viewOnClickListenerC3330j.mo21132b();
                OptionItemInfo c3243eM21162h = m21162h(iM21170k);
                if (c3243eM21162h != null) {
                    viewOnClickListenerC3330j.mo21163h(c3243eM21162h.m20486e());
                    viewOnClickListenerC3330j.mo21104a(c3243eM21162h.m20476a().getConstantState().newDrawable(), false);
                    this.f19919b.mo20287a(viewOnClickListenerC3330j, iM21170k);
                }
            }
        }
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList == null) {
            return true;
        }
        basicOptionItemList.setSelectItemIndex(this.f19932o);
        this.f19919b.setTitleName(m21085N());
        this.f19919b.mo20288b();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21139b(String str, String... strArr) {
        if (str == null || !str.equals(mo20300a())) {
            return false;
        }
        CameraLog.m12954a("CameraMenuOption", "removeMenuOptionItems, key: " + str + ", mOptionItemList: " + this.f19919b + ", remove keys: " + Arrays.toString(strArr));
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str2 : strArr) {
            int iMo21168j = mo21168j(str2);
            if (iMo21168j >= 0) {
                BasicOptionItemList basicOptionItemList = this.f19919b;
                if (basicOptionItemList != null) {
                    basicOptionItemList.m20289b(iMo21168j);
                    this.f19919b.setSelectItemIndex(this.f19932o);
                }
                mo21179q();
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21120a(String str, String str2, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        if (str != null && str.equals(mo20300a()) && m21166i()) {
            m21147d(str);
            CameraMenuOptionListener interfaceC3329i = this.f19929l;
            if (interfaceC3329i != null && interfaceC3329i.mo21239b(str)) {
                this.f19923f = false;
                m21113a(false);
                m21156f(str2);
                mo21115a(this.f19929l.getMenuPanelEnable(), this.f19929l.getMenuPanelAshed());
                if (OplusGLSurfaceView_13 == 0 && z) {
                    m21151e(OplusGLSurfaceView_13);
                } else {
                    m21099a(OplusGLSurfaceView_13);
                }
            }
            mo21183u();
            return true;
        }
        if (str == null || !str.equals(mo20300a()) || m21077F() != 0) {
            return false;
        }
        m21147d(str);
        if (OplusGLSurfaceView_13 == 0) {
            m21151e(OplusGLSurfaceView_13);
        }
        mo21183u();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21147d(String str) throws Resources.NotFoundException {
        Util.m24489q(this.f19928k);
        int iconsId = this.f19933p.getIconsId();
        if (this.f19916J || iconsId == 0) {
            return;
        }
        CameraLog.m12954a("CameraMenuOption", "addContainMenuOption, lazy load key: " + str + ", iconsId: " + iconsId);
        TypedArray typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(iconsId);
        if (typedArrayObtainTypedArray != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < typedArrayObtainTypedArray.length(); OplusGLSurfaceView_13++) {
                if (OplusGLSurfaceView_13 < this.f19933p.getOptionItems().size()) {
                    OptionItemInfo c3243e = this.f19933p.getOptionItems().get(OplusGLSurfaceView_13);
                    c3243e.m20478a(this.f19928k.getDrawable(typedArrayObtainTypedArray.getResourceId(OplusGLSurfaceView_13, -1)));
                    mo21109a(str, c3243e);
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        this.f19916J = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21138b(String str, boolean z) {
        if (str == null || !str.equals(mo20300a())) {
            return false;
        }
        this.f19923f = true;
        if (mo21081J() != null && m21078G() != 8) {
            if (z && 4 != mo21081J().getVisibility()) {
                m21134b(8, false);
            } else {
                m21099a(8);
            }
        }
        mo21184v();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21156f(String str) {
        if (this.f19922e) {
            return;
        }
        m21173l(m21174m(str));
        if (!m21166i()) {
            mo21179q();
        }
        BasicOptionItemList basicOptionItemList = this.f19919b;
        if (basicOptionItemList != null) {
            basicOptionItemList.setSelectItemIndex(this.f19932o);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo10885a(String str) {
        CameraLog.m12954a("CameraMenuOption", "showPopUpWindowBegin, key: " + str + ", option key: " + mo20300a());
        if (!m21079H() || m21166i() || mo21081J() == null) {
            return;
        }
        mo21081J().setClickable(false);
        m21159g(str);
    }

    @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo10886a(String str, boolean z) {
        CameraLog.m12954a("CameraMenuOption", "hidePopUpWindowBegin, key: " + str + ", option key: " + mo20300a());
        if (mo21081J() == null) {
            return;
        }
        if (1 == m21077F()) {
            mo21081J().setClickable(false);
        }
        if (3 == m21077F()) {
            mo21081J().clearAnimation();
            m21143c(z);
            return;
        }
        if (1 == m21077F()) {
            m21146d(2);
            mo21179q();
            mo21081J().clearAnimation();
            if (this.f19940w != null) {
                if (m21075D()) {
                    m21076E();
                }
                m21100a(mo21081J().getLeft(), this.f19941x);
            } else if (m21078G() != 0) {
                m21076E();
                m21133b(this.f19941x);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.PopUpWindowAnimationListener
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo10888c(String str) {
        if (mo21081J() != null) {
            mo21081J().setClickable(true);
            if (m21077F() != 0) {
                mo21098a(1.0f);
            }
            if (3 == m21077F() && !m21166i()) {
                mo21081J().setVisibility(0);
            } else if (1 == m21077F()) {
                m21146d(0);
                m21133b(this.f19941x);
            }
        }
        if (str.equals(mo20300a())) {
            mo21180r();
        } else {
            mo21179q();
        }
        m21146d(0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21159g(String str) {
        CameraLog.m12954a("CameraMenuOption", "hideMenu, option key: " + mo20300a() + ", remove: " + this.f19923f + ", state: " + m21077F() + ", itemView: " + mo21081J() + ", show: " + m21079H());
        if (!m21079H() || m21166i() || m21077F() != 0 || mo21081J() == null) {
            return;
        }
        m21146d(3);
        m21061ai();
        this.f19911E.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (CameraMenuOption.this.mo21081J() == null || 3 != CameraMenuOption.this.m21077F()) {
                    return;
                }
                CameraMenuOption.this.mo21081J().setVisibility(4);
            }
        });
        mo21081J().clearAnimation();
        mo21081J().startAnimation(this.f19911E);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21143c(boolean z) {
        CameraLog.m12954a("CameraMenuOption", "showMenu, option key: " + mo20300a() + ", remove: " + this.f19923f + ", state: " + m21077F() + ", itemView: " + mo21081J() + ", animation: " + z);
        if (this.f19912F == null) {
            m21060ah();
        }
        if (z) {
            mo21081J().clearAnimation();
            this.f19938u = true;
            mo21081J().startAnimation(this.f19912F);
        } else {
            mo21081J().setAlpha(1.0f);
        }
        this.f19917K = false;
    }

    /* renamed from: ah */
    private void m21060ah() {
        this.f19912F = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(this.f19935r);
        alphaAnimation.setStartOffset(150L);
        this.f19912F.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - this.f19910D, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(this.f19936s);
        translateAnimation.setStartOffset(150L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(true);
        this.f19912F.addAnimation(translateAnimation);
        this.f19912F.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                CameraMenuOption.this.f19938u = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CameraMenuOption.this.f19938u = false;
            }
        });
    }

    /* renamed from: ai */
    private void m21061ai() {
        if (this.f19911E == null) {
            this.f19911E = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            alphaAnimation.setInterpolator(this.f19935r);
            this.f19911E.addAnimation(alphaAnimation);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f - this.f19910D);
            translateAnimation.setDuration(300L);
            translateAnimation.setInterpolator(this.f19936s);
            translateAnimation.setFillBefore(true);
            translateAnimation.setFillEnabled(true);
            this.f19911E.addAnimation(translateAnimation);
        }
    }

    /* renamed from: x */
    public int m21186x() {
        return this.f19941x;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21133b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraMenuOption", "key: " + mo20300a() + " resetLayout left: " + OplusGLSurfaceView_13);
        if (mo21081J() != null) {
            mo21081J().layout(OplusGLSurfaceView_13, mo21081J().getTop(), mo21081J().getWidth() + OplusGLSurfaceView_13, mo21081J().getBottom());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21136b(boolean z, boolean z2) {
        if (m21077F() != 0) {
            if (mo21081J() != null) {
                mo21081J().setClickable(true);
                mo21081J().setAlpha(1.0f);
                if (3 == m21077F() && z) {
                    mo21081J().setVisibility(0);
                } else if (1 == m21077F() && z2) {
                    m21146d(0);
                    mo21179q();
                    m21133b(this.f19941x);
                }
            }
            m21146d(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21098a(float COUIBaseListPopupWindow_12) {
        if (mo21081J() != null) {
            View viewMo21081J = mo21081J();
            if (COUIBaseListPopupWindow_12 == 1.0f && !mo21081J().isEnabled()) {
                COUIBaseListPopupWindow_12 = mo21081J().getAlpha();
            }
            viewMo21081J.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21108a(OnItemClickListener onItemClickListener) {
        this.f19930m = onItemClickListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21107a(ViewGroup viewGroup) {
        if (viewGroup == null || mo21081J() == null) {
            return;
        }
        try {
            this.f19920c = viewGroup;
            viewGroup.addView(mo21081J());
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12954a("CameraMenuOption", "addItemViewToParent, Exception: " + COUIBaseListPopupWindow_8.toString());
        }
    }

    /* renamed from: A */
    protected void mo21072A() {
        if (this.f19920c != null && mo21081J() != null) {
            this.f19920c.removeView(mo21081J());
        }
        this.f19920c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21102a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (mo21081J() != null) {
            mo21081J().layout(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* renamed from: D */
    public boolean m21075D() {
        return this.f19939v;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21141c(int OplusGLSurfaceView_13) {
        LayoutTranslationAnimation layoutTranslationAnimation = this.f19940w;
        if (layoutTranslationAnimation != null) {
            if (-1 != OplusGLSurfaceView_13) {
                layoutTranslationAnimation.m21190a(OplusGLSurfaceView_13);
            }
            this.f19940w.cancel();
        }
    }

    /* renamed from: E */
    public void m21076E() {
        LayoutTranslationAnimation layoutTranslationAnimation = this.f19940w;
        if (layoutTranslationAnimation == null || !this.f19939v) {
            return;
        }
        layoutTranslationAnimation.onAnimationEnd(layoutTranslationAnimation);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21146d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraMenuOption", "key: " + mo20300a() + " setItemState, state( " + this.f19942y + " ==> " + OplusGLSurfaceView_13 + " )");
        this.f19942y = OplusGLSurfaceView_13;
    }

    /* renamed from: F */
    public int m21077F() {
        return this.f19942y;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21100a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("CameraMenuOption", "animationLayoutTranslationToX, startPos: " + OplusGLSurfaceView_13 + "endPos: " + i2 + " key: " + mo20300a());
        if (OplusGLSurfaceView_13 == i2 || mo21081J() == null) {
            return;
        }
        if (this.f19940w == null) {
            this.f19940w = new LayoutTranslationAnimation();
            this.f19940w.setInterpolator(this.f19936s);
            LayoutTranslationAnimation layoutTranslationAnimation = this.f19940w;
            layoutTranslationAnimation.setAnimationListener(layoutTranslationAnimation);
        }
        if (this.f19939v) {
            this.f19940w.m21190a(i2);
            return;
        }
        this.f19939v = true;
        this.f19940w.m21191a(OplusGLSurfaceView_13, i2);
        this.f19940w.setDuration(500L);
        mo21081J().clearAnimation();
        mo21081J().startAnimation(this.f19940w);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21101a(int OplusGLSurfaceView_13, int i2, int i3) {
        AlphaAnimation alphaAnimation;
        CameraLog.m12954a("CameraMenuOption", "layoutWithAnimationSet, startPos: " + OplusGLSurfaceView_13 + "endPos: " + i2 + " key: " + mo20300a());
        if (OplusGLSurfaceView_13 == i2 || mo21081J() == null) {
            return;
        }
        if (this.f19940w == null) {
            this.f19940w = new LayoutTranslationAnimation();
            this.f19940w.setInterpolator(this.f19936s);
            LayoutTranslationAnimation layoutTranslationAnimation = this.f19940w;
            layoutTranslationAnimation.setAnimationListener(layoutTranslationAnimation);
        }
        if (this.f19939v) {
            this.f19940w.m21190a(i2);
            return;
        }
        this.f19939v = true;
        this.f19940w.m21191a(OplusGLSurfaceView_13, i2);
        this.f19940w.setDuration(500L);
        AnimationSet animationSet = new AnimationSet(false);
        if (i3 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250L);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
        }
        alphaAnimation.setInterpolator(this.f19935r);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(this.f19940w);
        mo21081J().clearAnimation();
        mo21081J().startAnimation(animationSet);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21134b(int OplusGLSurfaceView_13, boolean z) {
        AlphaAnimation alphaAnimation;
        ScaleAnimation scaleAnimation;
        CameraLog.m12954a("CameraMenuOption", "viewVisibilityWithAnimationSet, visibility: " + OplusGLSurfaceView_13 + "isScale: " + z + " key: " + mo20300a());
        View viewMo21081J = mo21081J();
        if (viewMo21081J == null) {
            return;
        }
        if (this.f19938u) {
            this.f19938u = false;
            return;
        }
        if (8 == OplusGLSurfaceView_13 && 4 == viewMo21081J.getVisibility()) {
            return;
        }
        if (4 == OplusGLSurfaceView_13 && 8 == viewMo21081J.getVisibility()) {
            return;
        }
        if (OplusGLSurfaceView_13 != 0 && CameraUIInterface.KEY_SUB_SETTING.equals(mo20300a()) && (viewMo21081J instanceof RotationOptionItemView)) {
            RotationOptionItemView c3264i = (RotationOptionItemView) viewMo21081J;
            if (c3264i.m5517d()) {
                c3264i.m5518e();
            }
        }
        viewMo21081J.setVisibility(OplusGLSurfaceView_13);
        AnimationSet animationSet = new AnimationSet(false);
        if (OplusGLSurfaceView_13 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, mo21082K());
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, mo21082K());
        }
        if (z) {
            alphaAnimation.setDuration(500L);
        } else {
            alphaAnimation.setDuration(250L);
        }
        scaleAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(this.f19935r);
        scaleAnimation.setInterpolator(this.f19937t);
        ScaleAnimation scaleAnimation2 = !z ? new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, mo21082K()) : scaleAnimation;
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation2);
        viewMo21081J.clearAnimation();
        viewMo21081J.startAnimation(animationSet);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21151e(int OplusGLSurfaceView_13) {
        if (mo21081J() == null || m21078G() == OplusGLSurfaceView_13) {
            return;
        }
        m21134b(OplusGLSurfaceView_13, false);
    }

    /* renamed from: G */
    public int m21078G() {
        if (mo21081J() != null) {
            return mo21081J().getVisibility();
        }
        return 8;
    }

    /* renamed from: H */
    public boolean m21079H() {
        if (mo21081J() != null) {
            return mo21081J().isShown();
        }
        return false;
    }

    /* renamed from: I */
    public int m21080I() {
        LayoutTranslationAnimation layoutTranslationAnimation;
        if (this.f19939v && (layoutTranslationAnimation = this.f19940w) != null) {
            return layoutTranslationAnimation.m21189a();
        }
        if (mo21081J() != null) {
            return mo21081J().getLeft();
        }
        return 0;
    }

    /* renamed from: K */
    public float mo21082K() {
        return this.f19913G;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21155f(int OplusGLSurfaceView_13) {
        this.f19927j = OplusGLSurfaceView_13;
        if (this.f19919b != null) {
            this.f19931n.mo10769bL().mo16576e(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$0o8ITDEAaqoMbsfgTPMocVN-G5Q
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m21066b(objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$Gb8I-JFr70QtFYpJLtBDodvj-jQ
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m21057a(objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21066b(Object[] objArr) {
        this.f19919b.mo20280a(this.f19927j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21057a(Object[] objArr) {
        this.f19919b.setBackground(ContextCompat.m2248a(this.f19928k, R.drawable.bg_second_level_panel_black));
    }

    private class LayoutTranslationAnimation extends Animation implements Animation.AnimationListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f19951b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f19952c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f19953d;

        public LayoutTranslationAnimation() {
            this.f19953d = false;
            CameraMenuOption.this.f19939v = false;
            this.f19953d = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m21191a(int OplusGLSurfaceView_13, int i2) {
            this.f19951b = OplusGLSurfaceView_13;
            this.f19952c = i2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m21189a() {
            return this.f19952c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m21190a(int OplusGLSurfaceView_13) {
            this.f19952c = OplusGLSurfaceView_13;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
            if (CameraMenuOption.this.mo21081J() == null || this.f19953d || 1 == CameraMenuOption.this.f19931n.mo10816ca()) {
                return;
            }
            int OplusGLSurfaceView_13 = this.f19952c;
            int i2 = ((int) ((OplusGLSurfaceView_13 - r0) * COUIBaseListPopupWindow_12)) + this.f19951b;
            CameraMenuOption cameraMenuOption = CameraMenuOption.this;
            cameraMenuOption.m21102a(i2, cameraMenuOption.mo21081J().getTop(), CameraMenuOption.this.mo21081J().getWidth() + i2, CameraMenuOption.this.mo21081J().getBottom());
        }

        @Override // android.view.animation.Animation
        public void cancel() {
            this.f19953d = true;
            if (1 != CameraMenuOption.this.f19931n.mo10816ca()) {
                CameraMenuOption cameraMenuOption = CameraMenuOption.this;
                cameraMenuOption.m21102a(this.f19952c, cameraMenuOption.mo21081J().getTop(), this.f19952c + CameraMenuOption.this.mo21081J().getWidth(), CameraMenuOption.this.mo21081J().getBottom());
            }
            super.cancel();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CameraMenuOption.this.f19939v = false;
            this.f19953d = false;
            if (CameraMenuOption.this.mo21081J() != null) {
                if (1 != CameraMenuOption.this.f19931n.mo10816ca()) {
                    CameraMenuOption cameraMenuOption = CameraMenuOption.this;
                    cameraMenuOption.m21102a(this.f19952c, cameraMenuOption.mo21081J().getTop(), this.f19952c + CameraMenuOption.this.mo21081J().getWidth(), CameraMenuOption.this.mo21081J().getBottom());
                }
                if (1 == CameraMenuOption.this.m21077F()) {
                    CameraMenuOption.this.mo21081J().setClickable(true);
                    CameraMenuOption.this.mo21081J().setAlpha(1.0f);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            CameraMenuOption.this.f19939v = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (hasStarted() && !hasEnded()) {
                CameraMenuOption.this.f19939v = true;
            }
            this.f19953d = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21106a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f19917K = true;
            m21065b(view);
        }
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            m21068c(view);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21065b(final View view) {
        if (this.f19915I != null) {
            this.f19915I = null;
        }
        if (this.f19914H == null) {
            m21062aj();
        }
        this.f19914H.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.3
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                CameraMenuOption.this.m21054a(view, 1.0f, 0.9f, 1.0f, 0.6f, c1032f.m5478c());
            }
        }).m5470a(0.0d).m5476b(1.0d);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21068c(final View view) {
        if (this.f19914H != null) {
            this.f19914H = null;
        }
        if (this.f19915I == null) {
            m21063ak();
        }
        this.f19915I.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.4
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                double dM5478c = c1032f.m5478c();
                if (CameraMenuOption.this.f19917K) {
                    CameraMenuOption.this.m21054a(view, 0.9f, 1.0f, 0.6f, 1.0f, dM5478c);
                } else {
                    CameraMenuOption.this.m21070d(view);
                }
            }
        }).m5470a(0.0d).m5476b(1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21054a(View view, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, double IntrinsicsJvm.kt_5) {
        float fM5495a = (float) SpringUtil.m5495a(IntrinsicsJvm.kt_5, 0.0d, 1.0d, COUIBaseListPopupWindow_12, f2);
        float fM5495a2 = (float) SpringUtil.m5495a(IntrinsicsJvm.kt_5, 0.0d, 1.0d, f3, f4);
        if (view != null) {
            if (view instanceof RotationOptionItemView) {
                view.setPivotY(view.getHeight() * ((RotationOptionItemView) view).getPivotYScaleValue());
            }
            view.setScaleX(fM5495a);
            view.setScaleY(fM5495a);
            if (view.isEnabled()) {
                view.setAlpha(fM5495a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21070d(View view) {
        if (view != null) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            mo21098a(1.0f);
        }
    }

    /* renamed from: aj */
    private void m21062aj() {
        this.f19914H = SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(5.0d, 10.0d));
    }

    /* renamed from: ak */
    private void m21063ak() {
        this.f19915I = SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(5.0d, 10.0d));
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo20300a() {
        CameraMenuOptionInfo c3240b = this.f19933p;
        if (c3240b != null) {
            return c3240b.getOptionKey();
        }
        return null;
    }

    /* renamed from: N */
    protected String m21085N() {
        CameraMenuOptionInfo c3240b = this.f19933p;
        if (c3240b != null) {
            return c3240b.getOptionTitle();
        }
        return null;
    }

    /* renamed from: O */
    public int m21086O() {
        return this.f19933p.getOptionType();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21142c(String str, boolean z) {
        int iM20061a = CameraUITool.m20061a(str, this.f19909C);
        if (iM20061a >= 0) {
            this.f19932o = iM20061a;
            this.f19908B = str;
            this.f19925h = false;
            mo21148d(str, z);
            return;
        }
        CameraLog.m12967f("CameraMenuOption", "setOptionValue fail! index: " + iM20061a);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo21148d(String str, boolean z) {
        CameraUIListener cameraUIListener = this.f19931n;
        int iMo10653G = cameraUIListener != null ? cameraUIListener.mo10653G() : 0;
        if (CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(mo20300a())) {
            m21157f(z);
            m21064b(iMo10653G, str);
            m21087P();
        } else if (CameraUIInterface.KEY_VIDEO_SIZE.equals(mo20300a())) {
            m21157f(z);
            m21053a(iMo10653G, str);
            m21087P();
        } else {
            SharedPreferences.Editor editorEdit = this.f19929l.getSharedPreferences().edit();
            editorEdit.putString(this.f19933p.getOptionKey(), str);
            m21157f(z);
            editorEdit.apply();
            m21087P();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m21157f(boolean z) {
        CameraUIListener cameraUIListener;
        if (!z || (cameraUIListener = this.f19931n) == null) {
            return;
        }
        cameraUIListener.mo10713aR().m18488a(true);
        this.f19931n.mo10713aR().m18492b(this.f19933p.getOptionKey());
    }

    /* renamed from: P */
    protected void m21087P() {
        CameraUIListener cameraUIListener = this.f19931n;
        if (cameraUIListener != null) {
            cameraUIListener.mo10713aR().m18488a(false);
            this.f19931n.mo10713aR().m18492b((String) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21053a(int OplusGLSurfaceView_13, String str) {
        CameraUIListener cameraUIListener;
        String string = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, OplusGLSurfaceView_13));
        if (str == null || !str.equals(string)) {
            String string2 = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_FPS, this.f19928k.getString(R.string.camera_video_default_fps));
            boolean zM21161g = m21161g(OplusGLSurfaceView_13);
            SharedPreferences.Editor editorEdit = this.f19918a.edit();
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, str);
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            editorEdit.putBoolean(CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
            editorEdit.remove(CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE);
            if ("video_size_4kuhd".equals(str)) {
                String string3 = this.f19918a.getString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                if (!TextUtils.isEmpty(string3) && String.valueOf(60).equals(string3) && !Util.m24286a(OplusGLSurfaceView_13, str)) {
                    editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                    editorEdit.apply();
                }
                if (m21118a(OplusGLSurfaceView_13, (String) null, str) && (cameraUIListener = this.f19931n) != null && Float.compare(cameraUIListener.mo10877s(), ZoomManager.f12334a) == 0 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on");
                } else {
                    editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
                }
                editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
                editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
            } else if (zM21161g) {
                editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
                CameraUIListener cameraUIListener2 = this.f19931n;
                if (cameraUIListener2 != null) {
                    cameraUIListener2.mo10876r();
                }
            }
            if (!Util.m24479m(str) && !CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
                editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) && !"video_size_1080p".equals(str)) {
                editorEdit.putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
            }
            if (!Util.m24286a(OplusGLSurfaceView_13, str)) {
                editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                editorEdit.putBoolean(CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
                if (!String.valueOf(30).equals(string2)) {
                    editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
                }
            }
            if (String.valueOf(120).equals(string2) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) || !"video_size_4kuhd".equals(str))) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
            }
            CameraMenuOptionListener interfaceC3329i = this.f19929l;
            if (interfaceC3329i != null) {
                interfaceC3329i.mo21052a(mo20300a(), str);
            }
            editorEdit.apply();
            mo21110a(CameraUIInterface.KEY_VIDEO_SIZE, str, 0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21064b(int OplusGLSurfaceView_13, String str) {
        String string = this.f19918a.getString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, Util.m24485o(OplusGLSurfaceView_13));
        SharedPreferences.Editor editorEdit = this.f19918a.edit();
        editorEdit.putString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, str);
        if (!CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            if (!"video_size_1080p".equals(string) && "video_size_1080p".equals(str)) {
                editorEdit.putInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE));
            } else if (!"video_size_720p".equals(string) && "video_size_720p".equals(str)) {
                editorEdit.putInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE));
            }
        }
        editorEdit.apply();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean m21161g(int OplusGLSurfaceView_13) {
        return m21118a(OplusGLSurfaceView_13, (String) null, (String) null) && "on".equals(this.f19918a.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m21118a(int OplusGLSurfaceView_13, String str, String str2) {
        if (str == null) {
            str = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_FPS, this.f19928k.getString(R.string.camera_video_default_fps));
        }
        if (str2 == null) {
            str2 = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, OplusGLSurfaceView_13));
        }
        return "video_size_4kuhd".equals(str2) && String.valueOf(60).equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    /* renamed from: Q */
    public Drawable m21088Q() {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || this.f19932o >= arrayList.size()) {
            return null;
        }
        Drawable drawableM20476a = this.f19909C.get(this.f19932o).m20476a();
        return drawableM20476a == null ? this.f19909C.get(0).m20476a() : drawableM20476a;
    }

    /* renamed from: R */
    public Drawable m21089R() {
        Drawable drawableM20476a;
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || this.f19932o >= arrayList.size()) {
            return null;
        }
        if (Util.m24498u() && this.f19909C.get(this.f19932o).m20483c().equals(DcsMsgData.FULL)) {
            drawableM20476a = this.f19928k.getDrawable(R.drawable.photo_ratio_14_15_selector);
        } else {
            drawableM20476a = this.f19909C.get(this.f19932o).m20476a();
        }
        return drawableM20476a == null ? this.f19909C.get(0).m20476a() : drawableM20476a;
    }

    /* renamed from: S */
    public boolean m21090S() {
        return TextUtils.equals(this.f19908B, "on");
    }

    /* renamed from: T */
    public Drawable m21091T() {
        CameraMenuOptionInfo c3240b = this.f19933p;
        if (c3240b != null) {
            return c3240b.getOptionExpandIcon();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Drawable m21158g(boolean z) {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || this.f19932o >= arrayList.size()) {
            return null;
        }
        if (z) {
            return this.f19909C.get(1).m20476a();
        }
        return this.f19909C.get(0).m20476a();
    }

    /* renamed from: U */
    public String m21092U() {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        return (arrayList == null || this.f19932o >= arrayList.size() || TextUtils.isEmpty(this.f19909C.get(this.f19932o).m20485d())) ? "" : this.f19909C.get(this.f19932o).m20485d();
    }

    /* renamed from: V */
    public String m21093V() {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || this.f19932o >= arrayList.size()) {
            return null;
        }
        return this.f19909C.get(this.f19932o).m20486e();
    }

    /* renamed from: W */
    public int m21094W() {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || this.f19932o >= arrayList.size()) {
            return -1;
        }
        return this.f19909C.get(this.f19932o).m20481b();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public OptionItemInfo m21162h(int OplusGLSurfaceView_13) {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList == null || arrayList.size() <= OplusGLSurfaceView_13) {
            return null;
        }
        return this.f19909C.get(OplusGLSurfaceView_13);
    }

    /* renamed from: X */
    public int m21095X() {
        ArrayList<OptionItemInfo> arrayList = this.f19909C;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: Y */
    public ArrayList<OptionItemInfo> m21096Y() {
        return this.f19909C;
    }

    /* renamed from: Z */
    public boolean m21097Z() {
        return this.f19933p.getOptionOnOff();
    }

    /* renamed from: aa */
    public boolean m21125aa() {
        return this.f19933p.getImageTitleMode();
    }

    /* renamed from: ab */
    public boolean m21126ab() {
        CameraMenuOptionInfo c3240b = this.f19933p;
        if (c3240b != null) {
            return c3240b.getImageTitleColorChangeable();
        }
        CameraLog.m12959b("CameraMenuOption", "getImageTitleColorChangeable, mCameraMenuOptionInfo is null");
        return false;
    }

    /* renamed from: ac */
    public int m21127ac() {
        return this.f19933p.getGroupType();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m21167i(String str) {
        int iM20061a = CameraUITool.m20061a(str, this.f19909C);
        if (iM20061a < 0 || iM20061a == this.f19932o) {
            return false;
        }
        this.f19932o = iM20061a;
        this.f19908B = this.f19909C.get(this.f19932o).m20483c();
        this.f19925h = !str.equals(this.f19918a.getString(mo20300a(), ""));
        CameraLog.m12954a(str, "setOptionValueNoToPreferences, key: " + mo20300a() + ", mOptionValue: " + this.f19908B);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m21165i(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f19909C.size()) {
            return;
        }
        m21142c(this.f19909C.get(OplusGLSurfaceView_13).m20483c(), true);
    }

    /* renamed from: ad */
    public int m21128ad() {
        return this.f19932o;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public int mo21168j(String str) {
        if (!CameraUITool.m20064b(str, this.f19909C)) {
            return -1;
        }
        int iM20061a = CameraUITool.m20061a(str, this.f19909C);
        if (iM20061a >= 0) {
            this.f19909C.remove(iM20061a);
        }
        if (this.f19909C.size() <= 0) {
            CameraLog.m12954a("CameraMenuOption", "removeOptionItem, the remain item is 0, Error");
            return iM20061a;
        }
        if (this.f19908B.equals(str)) {
            this.f19908B = this.f19909C.get(m21129ae()).m20483c();
            this.f19932o = 0;
            m21142c(this.f19908B, false);
            return iM20061a;
        }
        this.f19932o = CameraUITool.m20061a(this.f19908B, this.f19909C);
        return iM20061a;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m21170k(String str) {
        int OplusGLSurfaceView_13;
        if (CameraUITool.m20064b(str, this.f19909C) || !CameraUITool.m20064b(str, this.f19933p.getOptionItems())) {
            return -1;
        }
        int iM20061a = CameraUITool.m20061a(str, this.f19933p.getOptionItems());
        if (iM20061a == 0) {
            OplusGLSurfaceView_13 = iM20061a;
        } else {
            OplusGLSurfaceView_13 = 0;
            int i2 = iM20061a - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                int iM20061a2 = CameraUITool.m20061a(this.f19933p.getOptionItems().get(i2).m20483c(), this.f19909C);
                if (iM20061a2 >= 0) {
                    OplusGLSurfaceView_13 = iM20061a2 + 1;
                    break;
                }
                i2--;
            }
        }
        this.f19909C.add(OplusGLSurfaceView_13, this.f19933p.getOptionItems().get(iM20061a));
        if (this.f19909C.size() <= 0) {
            CameraLog.m12954a("CameraMenuOption", "addOptionItem, the remain item is 0, Error");
            return OplusGLSurfaceView_13;
        }
        this.f19932o = CameraUITool.m20061a(this.f19908B, this.f19909C);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21124a(List<String> list, String str) {
        int size;
        if (list == null || list.size() <= 0) {
            size = this.f19909C.size();
            this.f19909C.clear();
        } else {
            ArrayList<OptionItemInfo> arrayList = new ArrayList<>();
            ArrayList<OptionItemInfo> optionItems = this.f19933p.getOptionItems();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < optionItems.size(); OplusGLSurfaceView_13++) {
                if (list.indexOf(optionItems.get(OplusGLSurfaceView_13).m20483c()) >= 0) {
                    arrayList.add(optionItems.get(OplusGLSurfaceView_13));
                }
            }
            size = Math.abs(this.f19909C.size() - arrayList.size());
            if (size == 0) {
                int i2 = size;
                for (int i3 = 0; i3 < this.f19909C.size(); i3++) {
                    if (!this.f19909C.get(i3).m20483c().equals(arrayList.get(i3).m20483c())) {
                        i2++;
                    }
                }
                size = i2;
            }
            this.f19909C.clear();
            this.f19909C = arrayList;
            m21173l(str);
        }
        return size > 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m21173l(String str) {
        OptionItemInfo c3243e;
        this.f19908B = this.f19929l.getSharedPreferences().getString(mo20300a(), str);
        if (this.f19909C.size() > 0 && (this.f19934q || CameraUITool.m20061a(this.f19908B, this.f19909C) < 0)) {
            if (!this.f19925h) {
                this.f19932o = CameraUITool.m20061a(this.f19908B, this.f19909C);
                if (this.f19932o >= 0 && this.f19909C.size() > 0 && (c3243e = this.f19909C.get(this.f19932o)) != null && !c3243e.m20487f()) {
                    c3243e.m20480a(true);
                }
            }
            if (this.f19932o < 0) {
                this.f19932o = m21129ae();
                if (this.f19909C.size() > 0) {
                    this.f19908B = this.f19909C.get(this.f19932o).m20483c();
                    return;
                }
                return;
            }
            return;
        }
        int iM20061a = CameraUITool.m20061a(this.f19908B, this.f19909C);
        if (iM20061a < 0 || iM20061a >= this.f19909C.size()) {
            this.f19932o = 0;
            if (this.f19909C.size() > 0) {
                this.f19908B = this.f19909C.get(this.f19932o).m20483c();
                return;
            }
            return;
        }
        if (this.f19932o != iM20061a) {
            this.f19932o = iM20061a;
        }
    }

    /* renamed from: ae */
    public int m21129ae() {
        return (!CameraUIInterface.KEY_PHOTO_RATIO.equals(mo20300a()) || this.f19909C.isEmpty()) ? 0 : 1;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public String m21174m(String str) {
        if (CameraUITool.m20064b(str, this.f19909C)) {
            return str;
        }
        String optionDefaultValue = this.f19933p.getOptionDefaultValue();
        return CameraUITool.m20064b(optionDefaultValue, this.f19909C) ? optionDefaultValue : this.f19909C.get(0).m20483c();
    }

    /* renamed from: af */
    protected Bitmap m21130af() {
        return this.f19933p.getOffAnimationIcon();
    }

    /* renamed from: ag */
    protected Bitmap m21131ag() {
        return this.f19933p.getOnAnimationIcon();
    }
}
