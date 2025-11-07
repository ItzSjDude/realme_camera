package com.oplus.camera.p172ui.menu.setting;

import android.animation.Animator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.OnKeyEventManager;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.RotationOptionItemView;
import com.oplus.camera.p172ui.widget.SuperColorToolTips;
import com.oplus.camera.util.AnimUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraMenuOptionFirstLevel.java */
/* renamed from: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class CameraMenuOptionFirstLevel extends CameraMenuOption implements View.OnClickListener, View.OnTouchListener, OnKeyEventManager.PlatformImplementations.kt_3 {

    /* renamed from: A */
    private String f20141A;

    /* renamed from: B */
    private String f20142B;

    /* renamed from: C */
    private boolean f20143C;

    /* renamed from: r */
    private RotationOptionItemView f20144r;

    /* renamed from: s */
    private String f20145s;

    /* renamed from: t */
    private boolean f20146t;

    /* renamed from: u */
    private boolean f20147u;

    /* renamed from: v */
    private SuperColorToolTips f20148v;

    /* renamed from: w */
    private String f20149w;

    /* renamed from: x */
    private CameraMenuOptionInfo f20150x;

    /* renamed from: y */
    private boolean f20151y;

    /* renamed from: z */
    private ViewTreeObserver.OnGlobalLayoutListener f20152z;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: z */
    public int mo21188z() {
        return 0;
    }

    public CameraMenuOptionFirstLevel(ComboPreferences comboPreferences, Context context, CameraMenuOptionInfo c3240b, CameraMenuOptionListener interfaceC3329i, CameraUIListener cameraUIListener, int OplusGLSurfaceView_13, String str, boolean z) {
        super(comboPreferences, context, c3240b, interfaceC3329i, cameraUIListener, OplusGLSurfaceView_13, str);
        this.f20144r = null;
        this.f20145s = null;
        this.f20146t = false;
        this.f20147u = false;
        this.f20148v = null;
        this.f20149w = null;
        this.f20150x = null;
        this.f20151y = false;
        this.f20152z = null;
        this.f20141A = null;
        this.f20142B = null;
        this.f20143C = false;
        this.f20150x = c3240b;
        this.f19918a = comboPreferences;
        this.f20146t = z;
        this.f20147u = false;
        m21446ak();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21132b() {
        this.f20144r = new RotationOptionItemView(this.f19928k, this.f19931n, this.f20146t, m21131ag(), m21090S(), this.f20147u, this.f19918a);
        InverseManager.INS.registerInverse(this.f19928k, this.f20144r);
        this.f20144r.setOnClickListener(this);
        this.f20144r.setOnTouchListener(this);
        this.f20144r.setSizeRatioType(this.f19927j);
        this.f20144r.setMenuName(this.f20145s);
        this.f20144r.setImageDrawable(m21088Q());
        this.f20144r.setForceDarkAllowed(false);
        this.f20144r.setSwitchIconNeedAnim(this.f20150x.getSwitchIconNeedAnim());
        this.f20144r.setOffAnimIcon(m21130af());
        this.f20144r.setLottieIconNeedAnim(this.f20150x.getLottieIconNeedAnim());
        this.f20144r.setKey(mo20300a());
        this.f20152z = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_10.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (CameraMenuOptionFirstLevel.this.f20144r != null) {
                    CameraMenuOptionFirstLevel.this.f20144r.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    CameraMenuOptionFirstLevel.this.f20151y = true;
                }
            }
        };
        this.f20144r.getViewTreeObserver().addOnGlobalLayoutListener(this.f20152z);
        super.mo21132b();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: M */
    public void mo21084M() {
        this.f20144r.m20743j();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21109a(String str, OptionItemInfo c3243e) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d) || CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d) || CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d) || CameraUIInterface.KEY_RAW_CONTROL.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strM13305d) || CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(strM13305d) || CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(strM13305d) || CameraUIInterface.KEY_PI_AI.equals(strM13305d)) {
            this.f20144r.setItemText(null);
            m21445aj();
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            this.f20144r.setImageTintList(ColorStateList.valueOf(this.f19928k.getColor(R.color.color_white_with_full_percent_transparency)));
        }
    }

    /* renamed from: ai */
    private void m21444ai() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        TypedArray typedArrayObtainTypedArray;
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(mo20300a())) {
            CameraLog.m12954a("CameraMenuOptionFirstLevel", "initDynamicIcons");
            if (TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.f19931n.mo10653G()) / 100;
                double dM24199a = configIntValue > 0 ? configIntValue : Util.m24199a(this.f19928k, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.f19931n.mo10653G()));
                if (0.0d == dM24199a) {
                    return;
                }
                this.f20149w = this.f19928k.getString(R.string.camera_picture_size_standard_high_hint, Double.valueOf(dM24199a));
                OplusGLSurfaceView_13 = (int) dM24199a;
                if (CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null && Double.compare(dM24199a, Util.m24199a(this.f19928k, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.f19931n.mo10653G()))) != 0) {
                    OplusGLSurfaceView_13 = 0;
                }
            } else {
                OplusGLSurfaceView_13 = -1;
            }
            if (44 == OplusGLSurfaceView_13) {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_44M);
            } else if (48 == OplusGLSurfaceView_13) {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_48M);
            } else if (50 == OplusGLSurfaceView_13) {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_50M);
            } else if (64 == OplusGLSurfaceView_13) {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_64M);
            } else if (OplusGLSurfaceView_13 == 0) {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_normal);
            } else {
                typedArrayObtainTypedArray = this.f19928k.getResources().obtainTypedArray(R.array.high_resolution_icons_48M);
            }
            if (typedArrayObtainTypedArray != null) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    if (m21449ah() != null && m21449ah().get(i2) != null) {
                        m21449ah().get(i2).m20478a(this.f19928k.getDrawable(typedArrayObtainTypedArray.getResourceId(i2, -1)));
                    }
                }
                typedArrayObtainTypedArray.recycle();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: u */
    protected void mo21183u() {
        super.mo21183u();
        if (this.f19929l != null) {
            this.f19929l.mo21241c(mo20300a());
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: v */
    protected void mo21184v() {
        super.mo21184v();
        if (this.f19929l != null) {
            this.f19929l.mo21247d(mo20300a());
        }
    }

    /* renamed from: ah */
    public List<OptionItemInfo> m21449ah() {
        CameraMenuOptionInfo c3240b = this.f20150x;
        if (c3240b != null) {
            return c3240b.getOptionItems();
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21114a(boolean z, int OplusGLSurfaceView_13, int i2) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.m20739a(z, OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21111a(final String str, String str2, int OplusGLSurfaceView_13, int i2, final int i3) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        SuperColorToolTips c3520c = this.f20148v;
        if (c3520c != null && c3520c.isShowing() && TextUtils.equals(this.f20142B, str2)) {
            return;
        }
        if (this.f20148v != null) {
            mo21185w();
        }
        if (this.f20144r != null) {
            this.f20148v = new SuperColorToolTips(this.f19928k);
            this.f20148v.m8139a(true);
            this.f20148v.setFocusable(false);
            this.f20148v.m8138a(str2);
            this.f20141A = str;
            this.f20142B = str2;
            OnKeyEventManager.m17945a().m17947a(this);
            this.f20148v.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$COUIBaseListPopupWindow_10$MJSc_ua70o1_bsxwP2T3O9fdz2s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.COUIBaseListPopupWindow_12$0.m21443a(str, view, motionEvent);
                }
            });
            if (this.f20148v.isShowing() || m21075D()) {
                return;
            }
            try {
                this.f20148v.m24102a(OplusGLSurfaceView_13, i2);
                this.f20144r.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_10.2
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (CameraMenuOptionFirstLevel.this.f20144r == null || CameraMenuOptionFirstLevel.this.f20144r.getWidth() <= 0) {
                            return false;
                        }
                        CameraMenuOptionFirstLevel.this.f20144r.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (CameraMenuOptionFirstLevel.this.f20148v == null) {
                            return false;
                        }
                        CameraMenuOptionFirstLevel.this.f20148v.m8135a(CameraMenuOptionFirstLevel.this.f20144r, i3);
                        return false;
                    }
                });
                this.f20144r.invalidate();
            } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
                CameraLog.m12966e("CameraMenuOptionFirstLevel", "showMenuOptionTipsBubble, exception: " + COUIBaseListPopupWindow_8.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ boolean m21443a(String str, View view, MotionEvent motionEvent) {
        CameraLog.m12954a("CameraMenuOptionFirstLevel", "onTouch");
        mo21185w();
        if (this.f19918a != null && str != null) {
            SharedPreferences.Editor editorEdit = this.f19918a.edit();
            editorEdit.putBoolean(str, false);
            editorEdit.apply();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo21144c(boolean z, boolean z2) {
        int iM20481b;
        Drawable drawableM20476a;
        if (this.f20144r == null || mo20300a() == null || !CameraUIInterface.KEY_SUB_SETTING.equals(mo20300a())) {
            return;
        }
        if (z2) {
            this.f19926i = z;
            return;
        }
        ArrayList<OptionItemInfo> arrayListY = m21096Y();
        final Drawable drawable = null;
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayListY.size(); i2++) {
            OptionItemInfo c3243e = arrayListY.get(i2);
            if ("on".equals(c3243e.m20483c()) && z) {
                iM20481b = c3243e.m20481b();
                drawableM20476a = c3243e.m20476a();
            } else if ("off".equals(c3243e.m20483c()) && !z) {
                iM20481b = c3243e.m20481b();
                drawableM20476a = c3243e.m20476a();
            }
            Drawable drawable2 = drawableM20476a;
            OplusGLSurfaceView_13 = iM20481b;
            drawable = drawable2;
        }
        this.f19926i = true;
        AnimUtil.m24520a(this.f19928k, this.f20144r, OplusGLSurfaceView_13, new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_10.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CameraMenuOptionFirstLevel.this.f19926i = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraMenuOptionFirstLevel viewOnClickListenerC3328h = CameraMenuOptionFirstLevel.this;
                viewOnClickListenerC3328h.f19926i = false;
                if (drawable != null) {
                    viewOnClickListenerC3328h.f20144r.setImageDrawable(drawable);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                CameraMenuOptionFirstLevel viewOnClickListenerC3328h = CameraMenuOptionFirstLevel.this;
                viewOnClickListenerC3328h.f19926i = false;
                viewOnClickListenerC3328h.mo21179q();
            }
        });
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21116a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.m20740a(!z, z2, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo21152e(boolean z) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.setShadowOn(z);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: L */
    public boolean mo21083L() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            return c3264i.getShadowOn();
        }
        return this.f20147u;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo21153e(String str) {
        SuperColorToolTips c3520c = this.f20148v;
        return c3520c != null && c3520c.isShowing();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: w */
    public void mo21185w() {
        SuperColorToolTips c3520c = this.f20148v;
        if (c3520c != null) {
            if (c3520c.isShowing()) {
                this.f20148v.dismiss();
            }
            this.f20148v = null;
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21105a(View view) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null && view == null && this.f20152z != null) {
            c3264i.getViewTreeObserver().removeOnGlobalLayoutListener(this.f20152z);
        }
        this.f20144r = (RotationOptionItemView) view;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: J */
    public View mo21081J() {
        return this.f20144r;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: K */
    public float mo21082K() {
        return this.f20144r.getPivotYScaleValue();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21135b(boolean z) {
        m21445aj();
        String string = this.f19918a.getString(CameraUIInterface.KEY_SUB_SETTING, "off");
        if (this.f19919b != null) {
            this.f19919b.setDrawShadow(this.f20147u && "off".equals(string));
        }
    }

    /* renamed from: aj */
    private void m21445aj() {
        if (this.f19926i) {
            return;
        }
        mo21104a(m21089R(), m21090S());
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: q */
    public void mo21179q() throws Resources.NotFoundException {
        this.f20147u = mo21083L();
        m21444ai();
        if (m21095X() > 0) {
            if (m21125aa() && m21089R() != null && !TextUtils.isEmpty(m21093V())) {
                m21445aj();
                mo21163h(m21093V());
            } else if (m21091T() != null && m21077F() == 1) {
                mo21163h((String) null);
                mo21104a(m21091T(), m21090S());
            } else if (m21089R() != null) {
                mo21163h((String) null);
                m21445aj();
            } else if (!TextUtils.isEmpty(m21093V())) {
                mo21163h(m21093V());
                mo21104a((Drawable) null, false);
            }
        } else {
            mo21104a((Drawable) null, false);
        }
        if (this.f20144r != null) {
            if (mo20300a() != null && CameraUIInterface.KEY_SUB_SETTING.equals(mo20300a()) && !this.f19926i) {
                this.f20144r.setImageDrawable(m21088Q());
            }
            this.f20144r.invalidate();
            RotationOptionItemView c3264i = this.f20144r;
            StringBuilder sb = new StringBuilder();
            sb.append(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(mo20300a()) ? this.f20149w : this.f20145s);
            sb.append(m21092U());
            c3264i.setContentDescription(sb.toString());
        }
        if (m21126ab()) {
            mo21149d(m21128ad() != 0);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: r */
    public void mo21180r() throws Resources.NotFoundException {
        int iW = m21094W();
        if (iW <= 0) {
            mo21179q();
        } else {
            AnimUtil.m24520a(this.f19928k, this.f20144r, iW, new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_10.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                    CameraMenuOptionFirstLevel.this.mo21179q();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                    CameraMenuOptionFirstLevel.this.mo21179q();
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (this.f19929l != null) {
            CameraLog.m12954a("CameraMenuOptionFirstLevel", "onClick, Key: " + mo20300a());
            if (mo21081J() == null || mo21081J().isClickable()) {
                if (this.f19923f) {
                    CameraLog.m12954a("CameraMenuOptionFirstLevel", "onClick, mbMenuItemRemoved: " + this.f19923f);
                    return;
                }
                if (this.f19919b == null) {
                    m21171k();
                }
                if (this.f19931n != null && 1 == this.f19931n.mo10816ca() && this.f19931n.mo10776bS() && !CameraUIInterface.KEY_SUB_SETTING.equals(mo20300a())) {
                    this.f19931n.mo10775bR();
                }
                int OplusGLSurfaceView_13 = 0;
                if (this.f19919b != null) {
                    String string = this.f19918a.getString(CameraUIInterface.KEY_SUB_SETTING, "off");
                    if (Util.m24495t()) {
                        m21448o(string);
                    } else if (5 == this.f19927j && "off".equals(string)) {
                        this.f19919b.mo20290b(false, false, 0);
                    } else {
                        this.f19919b.mo20290b(true, false, 0);
                    }
                }
                boolean zMo21231a = this.f19929l.mo21231a(mo20300a(), false, false);
                RotationOptionItemView c3264i = this.f20144r;
                StringBuilder sb = new StringBuilder();
                sb.append(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(mo20300a()) ? this.f20149w : this.f20145s);
                sb.append(m21092U());
                c3264i.setContentDescription(sb.toString());
                if (!zMo21231a) {
                    CameraLog.m12954a("CameraMenuOptionFirstLevel", "onClick, onMenuButtonClick(Key): " + mo20300a() + " return false.");
                    mo21098a(1.0f);
                    return;
                }
                if (2 == m21127ac()) {
                    return;
                }
                if (m21097Z() || 2 == m21095X()) {
                    int iX = m21095X();
                    if (PopUpWindowManager.m20706a()) {
                        PopUpWindowManager.m20712d();
                    }
                    int i2 = this.f19932o;
                    if (iX < 2) {
                        OplusGLSurfaceView_13 = i2;
                    } else if (i2 < iX - 1) {
                        OplusGLSurfaceView_13 = i2 + 1;
                    }
                    m21165i(OplusGLSurfaceView_13);
                    if (!CameraUIInterface.KEY_FILTER_MENU.equals(mo20300a()) && !CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(mo20300a()) && !CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(mo20300a()) && !CameraUIInterface.KEY_SUB_SETTING.equals(mo20300a())) {
                        mo21180r();
                    }
                } else if (m21164h()) {
                    m21178p();
                } else {
                    m21177o();
                }
                mo21098a(1.0f);
            }
        }
    }

    /* renamed from: o */
    private void m21448o(String str) {
        if (3 == this.f19931n.mo10816ca()) {
            if ("off".equals(str) && (this.f19927j == 0 || 1 == this.f19927j)) {
                this.f19919b.mo20290b(false, false, 0);
                return;
            } else {
                this.f19919b.mo20290b(true, false, 0);
                return;
            }
        }
        if ("off".equals(str) && (5 == this.f19927j || 1 == this.f19927j)) {
            this.f19919b.mo20290b(false, false, 0);
        } else {
            this.f19919b.mo20290b(true, false, 0);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21107a(ViewGroup viewGroup) {
        super.mo21107a(viewGroup);
        this.f20144r.setContentDescription(this.f20145s);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: B */
    public int mo21073B() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            return c3264i.getViewWidth();
        }
        return super.mo21073B();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: C */
    public int mo21074C() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            return c3264i.getViewHeight();
        }
        return super.mo21074C();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21163h(String str) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.setItemText(str);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: y */
    public void mo21187y() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.setAnimation(R.raw.camera_video_ai_option_guide_anim);
            this.f20144r.m5507a();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21104a(Drawable drawable, boolean z) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            if (c3264i.m5517d() && !this.f20144r.m20741h()) {
                this.f20144r.m5518e();
                this.f20144r.setProgress(0.0f);
            }
            this.f20144r.m20738a(drawable, z);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21103a(int OplusGLSurfaceView_13, boolean z) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.m20737a(OplusGLSurfaceView_13, z);
        }
        super.mo21103a(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: A */
    protected void mo21072A() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.m20742i();
            super.mo21072A();
            mo21105a((View) null);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21154f() {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.refreshDrawableState();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21155f(int OplusGLSurfaceView_13) {
        super.mo21155f(OplusGLSurfaceView_13);
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i != null) {
            c3264i.setSizeRatioType(this.f19927j);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m21450n(String str) {
        CameraMenuOptionInfo c3240b;
        if (!TextUtils.isEmpty(str) && (c3240b = this.f20150x) != null && c3240b.getOptionItems() != null && 1 <= this.f20150x.getOptionItems().size()) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f20150x.getOptionItems().size(); OplusGLSurfaceView_13++) {
                if (str.equals(this.f20150x.getOptionItems().get(OplusGLSurfaceView_13).m20483c())) {
                    return OplusGLSurfaceView_13;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0198  */
    /* renamed from: ak */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21446ak() {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraMenuOptionFirstLevel.m21446ak():void");
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21149d(boolean z) {
        RotationOptionItemView c3264i = this.f20144r;
        if (c3264i == null || !this.f20146t) {
            return;
        }
        c3264i.setSelected(z);
    }

    @Override // com.oplus.camera.OnKeyEventManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17949a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        CameraLog.m12954a("CameraMenuOptionFirstLevel", "onKeyDown - keyCode: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 24 || OplusGLSurfaceView_13 == 25) {
            mo21185w();
            if (this.f19918a != null && this.f20141A != null) {
                SharedPreferences.Editor editorEdit = this.f19918a.edit();
                editorEdit.putBoolean(this.f20141A, false);
                editorEdit.apply();
            }
            OnKeyEventManager.m17945a().m17948b(this);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21106a(View view, MotionEvent motionEvent) {
        super.mo21106a(view, motionEvent);
        CameraLog.m12959b("CameraMenuOptionFirstLevel", "onTouchEvent, view: " + view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        CameraLog.m12959b("CameraMenuOptionFirstLevel", "onTouch, view: " + view + ", mbSubMenu: " + this.f20146t);
        if (!this.f20146t) {
            Rect rect = new Rect();
            if (view instanceof RotationOptionItemView) {
                rect = (Rect) view.getTag(R.id_renamed.touch_area_tag);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    view.getDrawingRect(rect);
                    if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.f20143C = true;
                        return false;
                    }
                }
            } else if (action == 1 && this.f20143C) {
                this.f20143C = false;
                return false;
            }
        }
        super.mo21106a(view, motionEvent);
        return false;
    }
}
