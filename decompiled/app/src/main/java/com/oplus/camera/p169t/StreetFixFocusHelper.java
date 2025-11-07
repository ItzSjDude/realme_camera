package com.oplus.camera.p169t;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p169t.ScaleBar;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.menu.levelcontrol.CameraImageButton;
import com.oplus.camera.util.Util;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: StreetFixFocusHelper.java */
/* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class StreetFixFocusHelper implements ScaleBar.IntrinsicsJvm.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f16548b = "StreetFixFocusHelper";

    /* renamed from: A */
    private RelativeLayout f16549A;

    /* renamed from: C */
    private RelativeLayout f16551C;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f16555d;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f16558g;

    /* renamed from: OplusGLSurfaceView_6 */
    private SharedPreferences f16564m;

    /* renamed from: OplusGLSurfaceView_11 */
    private OneCamera f16565n;

    /* renamed from: r */
    private Activity f16569r;

    /* renamed from: t */
    private CameraInterface f16571t;

    /* renamed from: u */
    private PlatformImplementations.kt_3 f16572u;

    /* renamed from: v */
    private CameraUIInterface f16573v;

    /* renamed from: x */
    private ArrayList<String> f16575x;

    /* renamed from: y */
    private ArrayList<String> f16576y;

    /* renamed from: z */
    private OplusCameraCharacteristics f16577z;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f16554c = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f16556e = true;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f16557f = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f16559h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f16560i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f16561j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f16562k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f16563l = 50;

    /* renamed from: PlatformImplementations.kt_3 */
    protected CameraImageButton f16553a = null;

    /* renamed from: o */
    private StreetHelperTextView f16566o = null;

    /* renamed from: p */
    private IntrinsicsJvm.kt_4 f16567p = null;

    /* renamed from: q */
    private ArrayList<OplusTextView> f16568q = new ArrayList<>();

    /* renamed from: s */
    private ScaleBar f16570s = null;

    /* renamed from: B */
    private TextView f16550B = null;

    /* renamed from: D */
    private boolean f16552D = true;

    /* renamed from: w */
    private Handler f16574w = new Handler(Looper.getMainLooper());

    /* compiled from: StreetFixFocusHelper.java */
    /* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17298a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17299a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo17300b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo17301c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo17302d();
    }

    @Override // com.oplus.camera.p169t.ScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17242b() {
    }

    public StreetFixFocusHelper(Activity activity, CameraUIInterface cameraUIInterface, CameraInterface interfaceC2646a, boolean z, OneCamera interfaceC2694d) throws Resources.NotFoundException {
        this.f16555d = false;
        this.f16558g = true;
        this.f16564m = null;
        this.f16565n = null;
        this.f16569r = null;
        this.f16571t = null;
        this.f16572u = null;
        this.f16569r = activity;
        this.f16573v = cameraUIInterface;
        this.f16571t = interfaceC2646a;
        this.f16555d = false;
        this.f16572u = new PlatformImplementations.kt_3(activity);
        this.f16565n = interfaceC2694d;
        this.f16564m = this.f16571t.mo10590t();
        this.f16577z = CameraCharacteristicsUtil.m12971a(ApsConstant.CAPTURE_MODE_STREET, this.f16571t.mo10547aw());
        m17247a(this.f16577z.m13279n(), this.f16577z.m13278m());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f16569r.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.street_mode_fixfocus_menu_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        m17265z();
        layoutParams.bottomMargin = this.f16573v.mo18261r() - this.f16569r.getResources().getDimensionPixelSize(R.dimen.street_mode_bar_height);
        this.f16572u.setLayoutParams(layoutParams);
        this.f16572u.setTouchState(true);
        this.f16558g = z;
        this.f16551C = (RelativeLayout) this.f16569r.findViewById(R.id_renamed.control_panel_layout);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17253d(int OplusGLSurfaceView_13) {
        VibrateManager c2613aeMo10528ad;
        if (this.f16556e && (c2613aeMo10528ad = this.f16571t.mo10528ad()) != null) {
            if (OplusGLSurfaceView_13 % 10 == 0) {
                c2613aeMo10528ad.m11294f();
            } else {
                c2613aeMo10528ad.m11292d();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17266a(float COUIBaseListPopupWindow_12) {
        int iM17246a;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            int iM17246a2 = m17246a(COUIBaseListPopupWindow_12, this.f16575x);
            SharedPreferences.Editor editorEdit = this.f16564m.edit();
            editorEdit.putInt(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, iM17246a2);
            editorEdit.apply();
            return;
        }
        if (m17282f() || this.f16570s == null || (iM17246a = m17246a(COUIBaseListPopupWindow_12, this.f16575x)) <= -1 || this.f16576y == null || this.f16575x.size() <= iM17246a) {
            return;
        }
        String str = this.f16576y.get(iM17246a);
        m17267a(iM17246a, str, this.f16569r);
        m17250b(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17250b(final String str) {
        Activity activity = this.f16569r;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.t.IntrinsicsJvm.kt_3.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 != null) {
                        StreetFixFocusHelper.this.m17269a(str2);
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17246a(float COUIBaseListPopupWindow_12, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = Math.abs(Float.parseFloat(arrayList.get(0)) - COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float f2 = Float.parseFloat(arrayList.get(i2)) - COUIBaseListPopupWindow_12;
            if (Math.abs(f2) < fAbs) {
                fAbs = Math.abs(f2);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17274c() {
        m17261v();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m17278d() {
        return "on".equals(this.f16564m.getString(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off"));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17273b(boolean z) {
        m17270a(m17278d(), z);
    }

    /* renamed from: v */
    private void m17261v() {
        Resources resources = this.f16569r.getApplicationContext().getResources();
        this.f16549A = new RelativeLayout(this.f16569r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), resources.getDimensionPixelSize(R.dimen.street_mode_fixfocus_menu_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f16572u.addView(this.f16549A, layoutParams);
        this.f16566o = new StreetHelperTextView(this.f16569r.getApplicationContext());
        this.f16566o.setVerticalDraw(true);
        this.f16566o.setIncludeFontPadding(false);
        this.f16566o.setTextSize(0, resources.getDimensionPixelSize(R.dimen.street_main_mode_bar_item_text_size));
        this.f16566o.setTypeface(Util.m24473l(this.f16569r.getApplicationContext()));
        this.f16566o.setGravity(17);
        this.f16566o.setTextColor(resources.getColor(R.color.main_item_title_text_color));
        this.f16566o.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = resources.getDimensionPixelSize(R.dimen.street_mode_text_top_margin);
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(R.dimen.street_mode_text_bottom_margin);
        this.f16566o.setLayoutParams(layoutParams2);
        this.f16549A.addView(this.f16566o);
        this.f16570s = new ScaleBar(this.f16569r, this.f16563l, this.f16574w);
        this.f16570s.setForceBigScaleAlphaPosition(45);
        this.f16570s.setScaleBarValueChangeListener(this);
        this.f16570s.setId(View.generateViewId());
        this.f16570s.setLevelNum(this.f16576y.size());
        this.f16570s.setAuto(this.f16558g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Util.getScreenWidth() / (this.f16555d ? 2 : 1), resources.getDimensionPixelSize(R.dimen.street_main_seekbar_height));
        layoutParams3.addRule(3, this.f16566o.getId());
        this.f16570s.setScaleBarValueChangeListener(this);
        this.f16549A.addView(this.f16570s, layoutParams3);
        this.f16573v.mo18087a((View) this.f16572u, ApsConstant.CAPTURE_MODE_STREET, 2, true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17279e() {
        CameraLog.m12954a(f16548b, "deinitFixFocus");
        PlatformImplementations.kt_3 aVar = this.f16572u;
        if (aVar != null) {
            aVar.setVisibility(4);
            this.f16572u.removeAllViewsInLayout();
            this.f16572u = null;
            this.f16557f = false;
            this.f16550B = null;
            CameraImageButton c3280e = this.f16553a;
            if (c3280e != null) {
                c3280e.setVisibility(4);
            }
        }
    }

    @Override // com.oplus.camera.p169t.ScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17240a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(f16548b, "onValueChange value: " + OplusGLSurfaceView_13);
        m17253d(OplusGLSurfaceView_13);
        this.f16566o.setText(m17256f(OplusGLSurfaceView_13));
        String strM17255e = m17255e(OplusGLSurfaceView_13);
        if (this.f16567p == null || strM17255e == null || !m17282f()) {
            return;
        }
        m17272b(OplusGLSurfaceView_13);
        this.f16571t.mo10527ac();
        OneCamera interfaceC2694d = this.f16565n;
        if (interfaceC2694d != null) {
            this.f16562k = true;
            interfaceC2694d.mo13023a(Float.valueOf(strM17255e).floatValue(), true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m17282f() {
        return this.f16564m.getBoolean(CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, false);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m17283g() {
        IntrinsicsJvm.kt_4 bVar = this.f16567p;
        if (bVar != null) {
            bVar.mo17302d();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            m17276c(true);
        }
        if (!this.f16559h) {
            m17288l();
            m17284h();
            this.f16559h = true;
        }
        if (m17278d()) {
            return;
        }
        this.f16571t.mo10590t().edit().putString(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "on").apply();
        this.f16573v.mo18211f(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m17284h() {
        m17262w();
        m17259g(m17282f());
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17259g(boolean z) {
        CameraImageButton c3280e = this.f16553a;
        if (c3280e != null) {
            if (z) {
                c3280e.m20844a(false, null, this.f16569r.getResources().getDrawable(R.drawable.pro_btn_mode_change_a));
                this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_my);
                return;
            }
            c3280e.m20844a(true, null, Util.m24376b(this.f16569r, R.drawable.pro_btn_mode_change_light_a));
            if (m17278d()) {
                this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_ay);
            } else {
                this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_aw);
            }
        }
    }

    /* renamed from: w */
    private void m17262w() {
        this.f16570s.setAuto(!m17282f());
        this.f16570s.m17235a(m17287k());
        this.f16570s.m17236b();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m17285i() {
        if (this.f16559h) {
            m17289m();
            this.f16559h = false;
        }
        if (!m17282f()) {
            this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_aw);
        }
        if (m17278d()) {
            this.f16571t.mo10590t().edit().putString(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off").apply();
            this.f16573v.mo18211f(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
        }
        IntrinsicsJvm.kt_4 bVar = this.f16567p;
        if (bVar != null) {
            bVar.mo17301c();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            m17276c(false);
            m17245C();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m17286j() {
        if (this.f16559h) {
            m17289m();
            this.f16559h = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17276c(boolean z) {
        SharedPreferences.Editor editorEdit = this.f16571t.mo10590t().edit();
        editorEdit.putBoolean(CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, z);
        editorEdit.apply();
        m17259g(z);
        ScaleBar c3022b = this.f16570s;
        if (c3022b != null) {
            c3022b.setAuto(!z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17270a(boolean z, boolean z2) {
        CameraLog.m12954a(f16548b, "showOrHide isShow:" + z);
        this.f16560i = z;
        if (this.f16552D) {
            m17277d(z2);
        }
        if (z) {
            m17283g();
            m17264y();
            m17263x();
            return;
        }
        m17285i();
    }

    /* renamed from: x */
    private void m17263x() {
        if (this.f16571t.mo10454J()) {
            this.f16571t.mo10452H();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17277d(boolean z) {
        boolean zMo18023A = this.f16573v.mo18023A();
        if (z) {
            if (!zMo18023A && !this.f16560i && !this.f16561j) {
                this.f16573v.mo18105a(true);
                this.f16573v.mo18077a(0, false);
                return;
            } else {
                this.f16573v.mo18077a(4, false);
                return;
            }
        }
        if (!zMo18023A && !this.f16560i && !this.f16561j) {
            this.f16573v.mo18068a(0, 0);
        } else {
            this.f16573v.mo18068a(8, 0);
        }
    }

    /* renamed from: y */
    private void m17264y() {
        if (this.f16573v.mo18023A()) {
            this.f16573v.mo18109a(true, true, true, true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String m17255e(int OplusGLSurfaceView_13) {
        ArrayList<String> arrayList;
        CameraLog.m12954a(f16548b, "getFocusValue:" + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 <= -1 || (arrayList = this.f16575x) == null || arrayList.size() <= OplusGLSurfaceView_13) {
            return null;
        }
        return this.f16575x.get(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String m17256f(int OplusGLSurfaceView_13) {
        return this.f16576y.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17268a(IntrinsicsJvm.kt_4 bVar) {
        this.f16567p = bVar;
    }

    @Override // com.oplus.camera.p169t.ScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17239a() {
        m17276c(true);
        this.f16553a.setEnabled(false);
        this.f16573v.mo18200d(false, false);
        this.f16567p.mo17298a();
    }

    @Override // com.oplus.camera.p169t.ScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17241a(boolean z) {
        this.f16553a.setEnabled(!z);
        this.f16573v.mo18200d(!z, false);
        this.f16567p.mo17299a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17272b(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f16564m.edit();
        editorEdit.putInt(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, OplusGLSurfaceView_13);
        editorEdit.apply();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m17287k() {
        return this.f16564m.getInt(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, 10);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m17288l() {
        CameraLog.m12954a(f16548b, "showLevelPanel");
        if (!this.f16557f) {
            m17274c();
        }
        if (this.f16571t != null) {
            this.f16573v.mo18210f(20, true);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            this.f16553a.setVisibility(0);
        }
        this.f16572u.setVisibility(0);
        this.f16557f = true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m17289m() {
        CameraLog.m12954a(f16548b, "hideLevelPanel");
        this.f16572u.setVisibility(8);
        this.f16553a.setVisibility(4);
        this.f16553a.setEnabled(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17271a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f16551C.getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        m17285i();
        if (!m17282f()) {
            return false;
        }
        m17244B();
        return false;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m17290n() {
        m17285i();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17280e(boolean z) {
        m17277d(z);
    }

    /* renamed from: o */
    public boolean m17291o() {
        CameraLog.m12954a(f16548b, "isShowFixFocusMenu, mbShowFixFocusMenu:" + this.f16560i);
        return this.f16560i;
    }

    /* renamed from: p */
    public boolean m17292p() {
        return this.f16562k;
    }

    /* renamed from: q */
    public void m17293q() {
        OneCamera interfaceC2694d;
        if (m17282f()) {
            String strM17255e = m17255e(m17287k());
            if (this.f16567p == null || strM17255e == null || (interfaceC2694d = this.f16565n) == null) {
                return;
            }
            this.f16562k = true;
            interfaceC2694d.mo13023a(Float.valueOf(strM17255e).floatValue(), true);
            this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_my);
        }
    }

    /* renamed from: r */
    public void m17294r() {
        this.f16561j = true;
        m17285i();
    }

    /* renamed from: s */
    public void m17295s() {
        this.f16561j = false;
    }

    /* renamed from: t */
    public void m17296t() {
        this.f16560i = false;
        this.f16561j = false;
    }

    /* compiled from: StreetFixFocusHelper.java */
    /* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends RelativeLayout {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f16589b;

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public PlatformImplementations.kt_3(Activity activity) {
            super(activity.getApplicationContext());
            this.f16589b = true;
        }

        public void setTouchState(boolean z) {
            this.f16589b = z;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.f16589b && !StreetFixFocusHelper.this.f16554c) {
                if (StreetFixFocusHelper.this.f16571t.mo10447C()) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return false;
                }
                if (1 == motionEvent.getAction()) {
                    StreetFixFocusHelper.this.f16553a.setEnabled(true);
                    StreetFixFocusHelper.this.f16573v.mo18200d(true, false);
                    if (StreetFixFocusHelper.this.f16567p != null) {
                        StreetFixFocusHelper.this.f16567p.mo17300b();
                    }
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!this.f16589b) {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                motionEventObtain2.setAction(3);
                super.dispatchTouchEvent(motionEventObtain2);
            }
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17267a(final int OplusGLSurfaceView_13, final String str, Activity activity) {
        ScaleBar c3022b = this.f16570s;
        if (c3022b == null) {
            return;
        }
        if (c3022b.getCurrentIndex() != OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) {
            this.f16570s.setCurrentIndex(OplusGLSurfaceView_13);
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.t.IntrinsicsJvm.kt_3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StreetFixFocusHelper.this.f16570s.m17235a(OplusGLSurfaceView_13);
                        if (str != null) {
                            StreetFixFocusHelper.this.f16566o.setText((CharSequence) StreetFixFocusHelper.this.f16576y.get(OplusGLSurfaceView_13));
                        } else {
                            StreetFixFocusHelper.this.f16566o.setText(str);
                        }
                        if (StreetFixFocusHelper.this.f16567p != null) {
                            StreetFixFocusHelper c3023c = StreetFixFocusHelper.this;
                            c3023c.m17269a((String) c3023c.f16576y.get(OplusGLSurfaceView_13));
                        }
                    }
                });
            }
        }
    }

    /* renamed from: z */
    private void m17265z() throws Resources.NotFoundException {
        if (this.f16553a == null) {
            Resources resources = this.f16569r.getApplicationContext().getResources();
            this.f16553a = new CameraImageButton(this.f16569r);
            this.f16553a.setEnabled(true);
            this.f16553a.setFocusable(false);
            this.f16553a.setClickable(true);
            this.f16553a.setNormalShape(true);
            this.f16553a.setVisibility(4);
            this.f16553a.setContentDescription(resources.getString(R.string.camera_description_professional_auto));
            Drawable drawable = resources.getDrawable(R.drawable.pro_btn_mode_change_light_a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(R.dimen.control_button_margin_edge));
            this.f16553a.setLayoutParams(layoutParams);
            ((RelativeLayout) this.f16569r.findViewById(R.id_renamed.control_panel_button_layout)).addView(this.f16553a);
            this.f16553a.m20843a(this.f16571t.mo10591u(), false);
            m17243A();
        }
        this.f16553a.m20843a(this.f16571t.mo10591u(), false);
    }

    /* renamed from: A */
    private void m17243A() {
        Spring c1032fB = SpringSystem.m5492c().m5449b();
        c1032fB.m5472a(SpringConfig.m5490b(10.0d, 20.0d));
        final Spring c1032fM5473a = c1032fB.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.t.IntrinsicsJvm.kt_3.3
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                float fM5478c = (float) c1032f.m5478c();
                StreetFixFocusHelper.this.f16553a.setScaleX(fM5478c);
                StreetFixFocusHelper.this.f16553a.setScaleY(fM5478c);
            }
        });
        final Spring c1032fM5473a2 = c1032fB.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.t.IntrinsicsJvm.kt_3.4
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                StreetFixFocusHelper.this.f16553a.setAlpha((float) c1032f.m5478c());
            }
        });
        c1032fM5473a.m5470a(1.0d);
        c1032fM5473a2.m5470a(1.0d);
        this.f16553a.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.t.IntrinsicsJvm.kt_3.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    c1032fM5473a.m5476b(0.8999999761581421d);
                    c1032fM5473a2.m5476b(0.6000000238418579d);
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                c1032fM5473a.m5476b(1.0d);
                c1032fM5473a2.m5476b(1.0d);
                StreetFixFocusHelper.this.m17244B();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m17244B() {
        if (!m17282f()) {
            if (m17278d()) {
                this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_ay);
            } else {
                this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_aw);
            }
            m17276c(true);
            this.f16570s.m17236b();
            return;
        }
        if (m17278d()) {
            this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_my);
        } else {
            this.f16573v.mo18170b(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, R.drawable.menu_fix_focus_aw);
        }
        m17276c(false);
        m17245C();
    }

    /* renamed from: C */
    private void m17245C() {
        CameraLog.m12954a(f16548b, "setContinueAFMode");
        if (4 != this.f16565n.mo13122p()) {
            this.f16562k = false;
            this.f16565n.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            this.f16565n.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17269a(String str) {
        StreetHelperTextView c3024d = this.f16566o;
        if (c3024d == null) {
            return;
        }
        c3024d.setText(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17247a(float COUIBaseListPopupWindow_12, float f2) {
        CameraLog.m12959b(f16548b, "generateFocusValues");
        this.f16575x = new ArrayList<>();
        this.f16576y = new ArrayList<>();
        if (COUIBaseListPopupWindow_12 < f2) {
            f2 = COUIBaseListPopupWindow_12;
            COUIBaseListPopupWindow_12 = f2;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) <= 0.0f || Float.compare(COUIBaseListPopupWindow_12, f2) == 0) {
            CameraLog.m12966e(f16548b, "generateFocusValues, return, minFocusDistance: " + COUIBaseListPopupWindow_12);
            return;
        }
        float f3 = (COUIBaseListPopupWindow_12 - f2) / this.f16563l;
        CameraLog.m12954a(f16548b, "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 <= this.f16563l) {
            float f4 = OplusGLSurfaceView_13;
            float f5 = COUIBaseListPopupWindow_12 - (f3 * f4);
            float f6 = (OplusGLSurfaceView_13 < 0 || f4 > 45.0f) ? 1.0f + ((f4 - 45.0f) * 0.8f) : 0.02f * f4;
            this.f16575x.add(Float.toString(f5));
            String str = String.format(Locale.US, "%.2f", Float.valueOf(f6));
            if (f4 == 45.0f) {
                this.f16550B = new AppCompatTextView(this.f16569r.getApplicationContext());
                this.f16550B.setText("1.00m");
                this.f16550B.setTypeface(Typeface.defaultFromStyle(1));
                this.f16576y.add(this.f16550B.getText().toString());
            } else {
                this.f16576y.add(str + "OplusGLSurfaceView_6");
            }
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17275c(int OplusGLSurfaceView_13) {
        CameraImageButton c3280e = this.f16553a;
        if (c3280e != null) {
            c3280e.m20843a(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17281f(boolean z) {
        this.f16552D = z;
    }

    /* renamed from: u */
    public void m17297u() {
        m17270a(true, false);
    }
}
