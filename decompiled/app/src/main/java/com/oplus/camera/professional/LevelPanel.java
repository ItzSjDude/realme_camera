package com.oplus.camera.professional;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CommonComponent.ScaleBar;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class LevelPanel extends RelativeLayout implements ScaleBar.ScaleBarValueChangeListener {

    /* renamed from: PlatformImplementations.kt_3 */
    protected static HashMap<String, String> f15336a = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected SubModeBarData f15337b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected ProfessionalTextView f15338c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected TextView f15339d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected AutoTextView f15340e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected ScaleBar f15341f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f15342g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f15343h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f15344i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ValueChangeListener f15345j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<OplusTextView> f15346k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15347l;

    /* renamed from: OplusGLSurfaceView_6 */
    private SharedPreferences f15348m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Pattern f15349n;

    /* renamed from: o */
    private boolean f15350o;

    /* renamed from: p */
    private boolean f15351p;

    /* renamed from: q */
    private boolean f15352q;

    /* renamed from: r */
    private int f15353r;

    /* renamed from: s */
    private int f15354s;

    /* renamed from: t */
    private ObjectAnimator f15355t;

    public interface ValueChangeListener {
        void onActionUp();

        void onAutoButtonClick();

        void onAutoValueChange(int OplusGLSurfaceView_13);

        void onBarScrolling(boolean z);

        void onManualValueChange(int OplusGLSurfaceView_13);
    }

    public LevelPanel(Context context, boolean z, Handler handler, boolean z2, boolean z3, SubModeBarData c2908z, SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        super(context);
        this.f15337b = null;
        this.f15338c = null;
        this.f15339d = null;
        this.f15340e = null;
        this.f15341f = null;
        this.f15342g = "[一-龥]";
        this.f15343h = 0;
        this.f15345j = null;
        this.f15346k = new ArrayList<>();
        this.f15347l = false;
        this.f15348m = null;
        this.f15349n = Pattern.compile(this.f15342g);
        this.f15350o = true;
        this.f15351p = true;
        this.f15352q = false;
        this.f15353r = 0;
        this.f15354s = 0;
        this.f15355t = null;
        this.f15344i = context;
        this.f15348m = sharedPreferences;
        this.f15337b = c2908z;
        this.f15351p = z;
        this.f15352q = z3;
        this.f15347l = z2;
        m15346a(handler);
    }

    public LevelPanel(Context context, boolean z, Handler handler, boolean z2, boolean z3, int OplusGLSurfaceView_13, int i2, SubModeBarData c2908z, SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        super(context);
        this.f15337b = null;
        this.f15338c = null;
        this.f15339d = null;
        this.f15340e = null;
        this.f15341f = null;
        this.f15342g = "[一-龥]";
        this.f15343h = 0;
        this.f15345j = null;
        this.f15346k = new ArrayList<>();
        this.f15347l = false;
        this.f15348m = null;
        this.f15349n = Pattern.compile(this.f15342g);
        this.f15350o = true;
        this.f15351p = true;
        this.f15352q = false;
        this.f15353r = 0;
        this.f15354s = 0;
        this.f15355t = null;
        this.f15353r = OplusGLSurfaceView_13;
        this.f15354s = i2;
        this.f15344i = context;
        this.f15348m = sharedPreferences;
        this.f15337b = c2908z;
        this.f15351p = z;
        this.f15352q = z3;
        this.f15347l = z2;
        m15346a(handler);
    }

    public SubModeBarData getSubModeBarData() {
        return this.f15337b;
    }

    public String getDefaultValue() {
        return this.f15337b.m16149d();
    }

    public ArrayList<String> getParameterValueList() {
        return this.f15337b.m16145b();
    }

    public ArrayList<String> getParameterNamesList() {
        return this.f15337b.m16147c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15348a(String str, String str2) {
        f15336a.put(str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m15353c() {
        f15336a.put("pref_professional_whitebalance_key", "2000");
        f15336a.put("pref_professional_iso_key", "100");
        f15336a.put("pref_professional_exposure_compensation_key", "0.00");
        f15336a.put("pref_professional_exposure_time_key", "1/50s");
        f15336a.put("pref_professional_focus_mode_key", "0.00");
        f15336a.put(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "2000");
        f15336a.put(CameraUIInterface.KEY_FILM_MODE_ISO, "100");
        f15336a.put(CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "0.00");
        f15336a.put(CameraUIInterface.KEY_FILM_MODE_SHUTTER, "1/50s");
        f15336a.put(CameraUIInterface.KEY_FILM_MODE_FOCUS, "0.00");
    }

    public static void setAutoValueMap(HashMap<String, String> map) {
        f15336a.clear();
        f15336a = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public String m15344a(String str) {
        return f15336a.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected String m15354a(SubModeBarData c2908z, String str) {
        if (c2908z == null) {
            return null;
        }
        return c2908z.m16145b().indexOf(str) < 0 ? "" : c2908z.m16147c().get(c2908z.m16145b().indexOf(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String mo13485a(SharedPreferences sharedPreferences) {
        String strM16149d;
        String strM15344a;
        String strM16142a = this.f15337b.m16142a();
        String string = sharedPreferences.getString(strM16142a, this.f15337b.m16149d());
        if (!string.equals(this.f15337b.m16149d()) || "pref_professional_exposure_compensation_key".equals(strM16142a)) {
            String strM15354a = m15354a(this.f15337b, string);
            if (!"".equals(strM15354a)) {
                return strM15354a;
            }
            if ("pref_professional_exposure_compensation_key".equals(strM16142a)) {
                strM16149d = getDefaultValue();
                strM15344a = m15354a(this.f15337b, strM16149d);
            } else {
                strM16149d = this.f15337b.m16149d();
                strM15344a = m15344a(strM16142a);
            }
            if (this.f15337b.m16145b() != null && this.f15337b.m16145b().size() != 0 && m15352b(strM16142a, strM16149d)) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strM16142a, strM16149d);
                editorEdit.apply();
            }
            return strM15344a;
        }
        return m15344a(strM16142a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemValueText(String str) {
        if (this.f15338c != null) {
            this.f15338c.setText(ProfessionalUtil.m16136a(str));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15352b(String str, String str2) {
        if ("pref_professional_exposure_time_key".equals(str)) {
            return (TextUtils.isEmpty(str2) || this.f15344i.getString(R.string.camera_exposure_time_default_value).equals(str2)) ? false : true;
        }
        return true;
    }

    public int getCurrentIndex() {
        return this.f15341f.getCurrentIndex();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15358a(int OplusGLSurfaceView_13) {
        return this.f15341f.getCurrentIndex() == OplusGLSurfaceView_13;
    }

    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.f15345j = valueChangeListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15356a(final int OplusGLSurfaceView_13, Activity activity) {
        if (this.f15341f.getCurrentIndex() != OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) {
            this.f15341f.setCurrentIndex(OplusGLSurfaceView_13);
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.LevelPanel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LevelPanel.this.f15341f.scrollTo(OplusGLSurfaceView_13);
                        LevelPanel levelPanel = LevelPanel.this;
                        levelPanel.setItemValueText(levelPanel.m15344a(levelPanel.f15337b.m16142a()));
                        if (LevelPanel.this.f15345j != null) {
                            LevelPanel.this.f15345j.onAutoValueChange(OplusGLSurfaceView_13);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15361b(final int OplusGLSurfaceView_13, Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.LevelPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    LevelPanel levelPanel = LevelPanel.this;
                    levelPanel.setItemValueText(levelPanel.f15337b.m16147c().get(OplusGLSurfaceView_13));
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15357a(final int OplusGLSurfaceView_13, Activity activity, final String str) {
        this.f15341f.setCurrentIndex(OplusGLSurfaceView_13);
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.LevelPanel.3
                @Override // java.lang.Runnable
                public void run() {
                    LevelPanel.this.f15341f.scrollTo(OplusGLSurfaceView_13);
                    String str2 = str;
                    if (str2 != null) {
                        LevelPanel.this.setItemValueText(str2);
                    } else {
                        LevelPanel levelPanel = LevelPanel.this;
                        levelPanel.setItemValueText(levelPanel.f15337b.m16147c().get(OplusGLSurfaceView_13));
                    }
                    if (LevelPanel.this.f15345j != null) {
                        LevelPanel.this.f15345j.onManualValueChange(OplusGLSurfaceView_13);
                    }
                }
            });
        }
    }

    public void setBarAuto(boolean z) {
        TextView textView;
        this.f15351p = z;
        if (!z && (textView = this.f15339d) != null && textView.getVisibility() == 0) {
            m15349a(false, true);
        }
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar != null) {
            scaleBar.setAuto(this.f15351p, true);
        }
        AutoTextView c2883a = this.f15340e;
        if (c2883a != null) {
            c2883a.setAuto(this.f15351p);
        }
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar != null) {
            scaleBar.setAlign(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f15350o) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar != null) {
            scaleBar.invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        boolean z = OplusGLSurfaceView_13 != getVisibility();
        super.setVisibility(OplusGLSurfaceView_13);
        if (this.f15339d != null) {
            if (OplusGLSurfaceView_13 == 0 && z) {
                m15349a(true, false);
                return;
            }
            if (4 == OplusGLSurfaceView_13 || 8 == OplusGLSurfaceView_13) {
                ObjectAnimator objectAnimator = this.f15355t;
                if (objectAnimator != null && objectAnimator.isStarted()) {
                    this.f15355t.cancel();
                }
                ProfessionalTextView c2905w = this.f15338c;
                if (c2905w != null) {
                    c2905w.animate().cancel();
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15362d() {
        SubModeBarData c2908z;
        if (this.f15338c != null) {
            setItemValueText(mo13485a(this.f15348m));
        }
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar == null || (c2908z = this.f15337b) == null) {
            return;
        }
        scaleBar.setLevelNum(c2908z.m16147c().size());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15355a(int OplusGLSurfaceView_13, int i2) {
        this.f15353r = OplusGLSurfaceView_13;
        this.f15354s = i2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m15363e() throws Resources.NotFoundException {
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar == null) {
            return;
        }
        if (1 == this.f15353r) {
            if (270 == this.f15354s) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_margin_right_270);
                this.f15341f.setRotation(90.0f);
                this.f15341f.setTranslationX(dimensionPixelOffset);
            } else {
                int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_margin_left);
                this.f15341f.setRotation(270.0f);
                this.f15341f.setTranslationX(dimensionPixelOffset2);
            }
        } else {
            scaleBar.setTranslationX(0.0f);
            this.f15341f.setRotation(0.0f);
        }
        this.f15341f.setLayoutParams(getScaleBarLayoutParams());
        AutoTextView c2883a = this.f15340e;
        if (c2883a != null) {
            c2883a.setLayoutParams(getAutoTextLayoutParams());
            int OplusGLSurfaceView_13 = this.f15353r;
            if (1 == OplusGLSurfaceView_13) {
                this.f15340e.setTranslationY(-Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_auto_text_margin_bottom));
                this.f15340e.setBackgroundResource(R.drawable.profession_mode_auto_button_bg);
            } else if (4 == OplusGLSurfaceView_13) {
                this.f15340e.setBackgroundResource(R.drawable.profession_mode_auto_button_bg_light);
            }
        }
        if (Util.m24495t()) {
            ProfessionalTextView c2905w = this.f15338c;
            if (c2905w != null) {
                c2905w.setLayoutParams(getValueTextLayoutParams());
                this.f15338c.setTextAlignment(4);
            }
            TextView textView = this.f15339d;
            if (textView != null) {
                textView.setLayoutParams(getHintTextLayoutParams());
            }
        }
    }

    public RelativeLayout.LayoutParams getScaleBarLayoutParams() {
        int OplusGLSurfaceView_13 = this.f15353r;
        if (1 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.fold_full_professional_params_slide_bar_width), getResources().getDimensionPixelSize(R.dimen.fold_full_professional_params_slide_bar_height));
            layoutParams.addRule(9);
            return layoutParams;
        }
        if (3 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((Util.getScreenWidth() / 2) / (this.f15347l ? 2 : 1), this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height) + this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_panel_container_margin_bottom));
            layoutParams2.leftMargin = this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_outside_margin);
            layoutParams2.rightMargin = this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_outside_margin);
            layoutParams2.addRule(12);
            return layoutParams2;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Util.getScreenWidth() / (this.f15347l ? 2 : 1), this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height) + this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_panel_container_margin_bottom) + ((int) (Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a) * 2.0f)));
        layoutParams3.leftMargin = this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_outside_margin);
        layoutParams3.rightMargin = this.f15344i.getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_outside_margin);
        layoutParams3.addRule(12);
        return layoutParams3;
    }

    public RelativeLayout.LayoutParams getAutoTextLayoutParams() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_button_width), getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_button_height));
        int OplusGLSurfaceView_13 = this.f15353r;
        if (1 == OplusGLSurfaceView_13) {
            layoutParams.addRule(12);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_auto_text_margin_right);
            if (270 == this.f15354s) {
                layoutParams.addRule(9);
                layoutParams.leftMargin = dimensionPixelOffset;
                return layoutParams;
            }
            layoutParams.addRule(11);
            layoutParams.rightMargin = dimensionPixelOffset;
            return layoutParams;
        }
        if (4 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.main_mode_bar_item_auto_button_width), Util.m24460i(R.dimen.main_mode_bar_item_auto_button_height));
            layoutParams2.addRule(11);
            layoutParams2.addRule(2, this.f15341f.getId());
            layoutParams2.bottomMargin = Util.m24460i(R.dimen.fold_rack_main_mode_bar_item_auto_button_margin_bottom);
            layoutParams2.rightMargin = Util.m24460i(R.dimen.fold_rack_main_mode_bar_item_auto_button_margin_end);
            return layoutParams2;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.main_mode_bar_item_auto_button_width), Util.m24460i(R.dimen.main_mode_bar_item_auto_button_height));
        layoutParams3.addRule(11);
        layoutParams3.addRule(2, this.f15341f.getId());
        layoutParams3.bottomMargin = Util.m24460i(R.dimen.main_mode_bar_item_auto_button_margin_bottom);
        layoutParams3.rightMargin = Util.m24460i(R.dimen.main_mode_bar_item_auto_button_margin_end);
        return layoutParams3;
    }

    public RelativeLayout.LayoutParams getValueTextLayoutParams() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13 = this.f15353r;
        if (1 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_value_text_margin_top);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_value_text_margin_right);
            if (270 == this.f15354s) {
                layoutParams.addRule(9);
                layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, 0, 0);
                return layoutParams;
            }
            layoutParams.addRule(11);
            layoutParams.setMargins(0, dimensionPixelOffset, dimensionPixelOffset2, 0);
            return layoutParams;
        }
        if (OplusGLSurfaceView_13 == 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            return layoutParams2;
        }
        if (4 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, Util.m24460i(R.dimen.fold_professional_param_slide_bar_value_text_height));
            layoutParams3.addRule(10);
            layoutParams3.addRule(14);
            layoutParams3.topMargin = getResources().getDimensionPixelOffset(R.dimen.fold_rack_professional_params_slide_bar_value_text_margin_top);
            return layoutParams3;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, Util.m24460i(R.dimen.fold_professional_param_slide_bar_value_text_height));
        layoutParams4.addRule(14);
        return layoutParams4;
    }

    public RelativeLayout.LayoutParams getHintTextLayoutParams() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (1 == this.f15353r) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_value_text_margin_top);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.fold_full_professional_params_slide_bar_value_text_margin_right);
            if (270 == this.f15354s) {
                layoutParams.addRule(9);
                layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, 0, 0);
            } else {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, dimensionPixelOffset, dimensionPixelOffset2, 0);
            }
        } else {
            layoutParams.addRule(14);
        }
        return layoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15346a(Handler handler) throws Resources.NotFoundException {
        this.f15338c = new ProfessionalTextView(this.f15344i);
        this.f15338c.setVerticalDraw(true);
        setItemValueText(mo13485a(this.f15348m));
        m15347a(this.f15338c);
        addView(this.f15338c);
        this.f15338c.setVisibility(4);
        this.f15339d = new TextView(this.f15344i);
        this.f15339d.setText(this.f15337b.m16151e());
        m15347a(this.f15339d);
        Util.m24275a(this.f15339d);
        this.f15339d.setVisibility(0);
        addView(this.f15339d);
        float fM24202a = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        this.f15341f = new ScaleBar(this.f15344i, this.f15337b.m16147c().size(), handler);
        this.f15341f.setId(View.generateViewId());
        this.f15341f.setScaleBarValueChangeListener(this);
        this.f15341f.setAuto(this.f15351p, false);
        this.f15341f.setShadowLayer();
        int OplusGLSurfaceView_13 = (int) fM24202a;
        this.f15341f.setPadding(OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13);
        this.f15341f.setId(generateViewId());
        addView(this.f15341f);
        Resources resources = this.f15344i.getApplicationContext().getResources();
        this.f15340e = new AutoTextView(this.f15344i);
        this.f15340e.setAuto(this.f15351p);
        this.f15340e.setId(generateViewId());
        this.f15340e.setIncludeFontPadding(false);
        this.f15340e.setTextSize(0, resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_button_text_size));
        this.f15340e.setTypeface(Util.m24473l(this.f15344i));
        this.f15340e.setGravity(17);
        this.f15340e.setVisibility(this.f15352q ? 0 : 8);
        this.f15340e.setBackgroundResource(R.drawable.profession_mode_auto_button_bg);
        this.f15340e.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.professional.LevelPanel.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LevelPanel.this.f15345j != null) {
                    LevelPanel.this.f15345j.onAutoButtonClick();
                }
            }
        });
        addView(this.f15340e);
        m15363e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15347a(TextView textView) throws Resources.NotFoundException {
        Resources resources = this.f15344i.getApplicationContext().getResources();
        textView.setHeight(resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_text_height));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_text_size));
        textView.setTypeface(Util.m24411c(false));
        textView.setTextColor(resources.getColor(R.color.main_item_title_text_color));
        Util.m24275a(textView);
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15349a(boolean z, boolean z2) {
        TextView textView = this.f15339d;
        if (textView != null) {
            if (this.f15355t == null) {
                this.f15355t = ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0.0f);
                this.f15355t.setDuration(250L);
                this.f15355t.setInterpolator(ProfessionalAnimConstant.f15694a);
                this.f15355t.setStartDelay(1L);
                this.f15355t.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.LevelPanel.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        CameraLog.m12959b("LevelPanel", "animateHintTextView, cancel.");
                        LevelPanel.this.f15339d.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        CameraLog.m12959b("LevelPanel", "animateHintTextView, end.");
                        LevelPanel.this.f15339d.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        CameraLog.m12959b("LevelPanel", "animateHintTextView, start.");
                        LevelPanel.this.m15345a();
                    }
                });
            }
            int OplusGLSurfaceView_13 = z ? 3000 : 0;
            if (z2 && OplusGLSurfaceView_13 == this.f15355t.getStartDelay()) {
                CameraLog.m12959b("LevelPanel", "animateHintTextView, abort duplicate animation.");
                return;
            }
            this.f15355t.cancel();
            this.f15355t.setStartDelay(OplusGLSurfaceView_13);
            this.f15355t.start();
            this.f15339d.setAlpha(1.0f);
            this.f15339d.setVisibility(0);
            ProfessionalTextView c2905w = this.f15338c;
            if (c2905w != null) {
                c2905w.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15345a() {
        ProfessionalTextView c2905w = this.f15338c;
        if (c2905w != null) {
            c2905w.setAlpha(0.0f);
            this.f15338c.animate().alpha(1.0f).setStartDelay(150L).setDuration(250L).setInterpolator(ProfessionalAnimConstant.f15694a).setListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.LevelPanel.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    CameraLog.m12959b("LevelPanel", "animateValueTextView, cancel.");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraLog.m12959b("LevelPanel", "animateValueTextView, end.");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CameraLog.m12959b("LevelPanel", "animateValueTextView, start.");
                    LevelPanel.this.f15338c.setVisibility(0);
                }
            }).start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m15359b(SharedPreferences sharedPreferences) {
        String strM16142a = this.f15337b.m16142a();
        ArrayList<String> arrayListM16145b = this.f15337b.m16145b();
        String strM16149d = this.f15337b.m16149d();
        if (sharedPreferences != null) {
            strM16149d = sharedPreferences.getString(strM16142a, this.f15337b.m16149d());
        }
        return arrayListM16145b.indexOf(strM16149d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15360b(int OplusGLSurfaceView_13) {
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar != null) {
            scaleBar.initDataIndex(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onValueChange(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("LevelPanel", "onValueChange, value: " + OplusGLSurfaceView_13);
        ValueChangeListener valueChangeListener = this.f15345j;
        if (valueChangeListener != null) {
            valueChangeListener.onManualValueChange(OplusGLSurfaceView_13);
            setItemValueText(mo13485a(this.f15348m));
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onBarMoving() {
        if (this.f15351p) {
            setBarAuto(false);
            return;
        }
        TextView textView = this.f15339d;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        m15349a(false, true);
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onBarScrolling(boolean z) {
        ValueChangeListener valueChangeListener = this.f15345j;
        if (valueChangeListener != null) {
            valueChangeListener.onBarScrolling(z);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onActionUp() {
        ValueChangeListener valueChangeListener = this.f15345j;
        if (valueChangeListener != null) {
            valueChangeListener.onActionUp();
        }
    }

    public void setScaleBarTouchable(boolean z) {
        ScaleBar scaleBar = this.f15341f;
        if (scaleBar != null) {
            scaleBar.setTouchable(z);
        }
    }
}
