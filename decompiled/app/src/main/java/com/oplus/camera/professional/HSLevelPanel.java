package com.oplus.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CommonComponent.HSScaleBar;
import com.oplus.camera.p172ui.menu.OplusTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: HSLevelPanel.java */
/* renamed from: com.oplus.camera.professional.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class HSLevelPanel extends RelativeLayout implements HSScaleBar.ScaleBarValueChangeListener {

    /* renamed from: PlatformImplementations.kt_3 */
    protected static HashMap<String, String> f15394a = new HashMap<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static HashMap<String, Boolean> f15395g = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected HSSubModeBarData f15396b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected HSAutoImageView f15397c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected HSScaleBar f15398d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected ProfessionalTextView f15399e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected TextView f15400f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f15401h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f15402i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f15403j;

    /* renamed from: OplusGLSurfaceView_5 */
    private PlatformImplementations.kt_3 f15404k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ArrayList<OplusTextView> f15405l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15406m;

    /* renamed from: OplusGLSurfaceView_11 */
    private SharedPreferences f15407n;

    /* renamed from: o */
    private Pattern f15408o;

    /* renamed from: p */
    private boolean f15409p;

    /* renamed from: q */
    private boolean f15410q;

    /* renamed from: r */
    private boolean f15411r;

    /* renamed from: s */
    private String[] f15412s;

    /* renamed from: t */
    private String[] f15413t;

    /* renamed from: u */
    private String[] f15414u;

    /* renamed from: v */
    private String[] f15415v;

    /* compiled from: HSLevelPanel.java */
    /* renamed from: com.oplus.camera.professional.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15410a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo15411a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo15412a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo15413b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo15414b(int OplusGLSurfaceView_13);
    }

    public HSLevelPanel(Context context, boolean z, Handler handler, boolean z2, boolean z3, HSSubModeBarData c2891i, SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        super(context);
        this.f15396b = null;
        this.f15397c = null;
        this.f15398d = null;
        this.f15399e = null;
        this.f15400f = null;
        this.f15401h = "[一-龥]";
        this.f15402i = 0;
        this.f15404k = null;
        this.f15405l = new ArrayList<>();
        this.f15406m = false;
        this.f15407n = null;
        this.f15408o = Pattern.compile(this.f15401h);
        this.f15409p = true;
        this.f15410q = true;
        this.f15411r = false;
        this.f15412s = new String[]{"100", "400", "800", "1600", "3200", "6400"};
        this.f15413t = new String[]{"1/8000", "1/1000", "1/125", "1/15", "1/2", "4", VideoMode.VIDEO_DEFAULT_FPS, "32"};
        this.f15414u = new String[]{"2300", "3600", "4900", "6200", "7500"};
        this.f15415v = new String[]{"-2.00", "-1.00", "0.00", "+1.00", "+2.00"};
        this.f15403j = context;
        this.f15407n = sharedPreferences;
        this.f15396b = c2891i;
        this.f15410q = z;
        this.f15411r = z3;
        this.f15406m = z2;
        m15399a(handler);
    }

    public HSSubModeBarData getHSSubModeBarData() {
        return this.f15396b;
    }

    public String getDefaultValue() {
        return this.f15396b.m15710d();
    }

    public ArrayList<String> getParameterValueList() {
        return this.f15396b.m15705b();
    }

    public ArrayList<String> getParameterNamesList() {
        return this.f15396b.m15708c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15400a(String str, String str2) {
        f15394a.put(str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15398a() {
        f15394a.put("pref_professional_whitebalance_key", "2000");
        f15394a.put("pref_professional_iso_key", "100");
        f15394a.put("pref_professional_exposure_compensation_key", "0.00");
        f15394a.put("pref_professional_exposure_time_key", "1/50s");
        f15394a.put("pref_professional_focus_mode_key", "0.00");
        f15394a.put(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "2000");
        f15394a.put(CameraUIInterface.KEY_FILM_MODE_ISO, "100");
        f15394a.put(CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "0.00");
        f15394a.put(CameraUIInterface.KEY_FILM_MODE_SHUTTER, "1/50s");
        f15394a.put(CameraUIInterface.KEY_FILM_MODE_FOCUS, "0.00");
    }

    public static void setAutoValueMap(HashMap<String, String> map) {
        f15394a.clear();
        f15394a = map;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m15397a(String str) {
        return f15394a.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected String m15403a(HSSubModeBarData c2891i, String str) {
        if (c2891i == null) {
            return null;
        }
        return c2891i.m15705b().indexOf(str) < 0 ? "" : c2891i.m15708c().get(c2891i.m15705b().indexOf(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15402a(SharedPreferences sharedPreferences) {
        String strM15710d;
        String strM15397a;
        String strM15702a = this.f15396b.m15702a();
        String string = sharedPreferences.getString(strM15702a, this.f15396b.m15710d());
        if (!string.equals(this.f15396b.m15710d()) || "pref_professional_exposure_compensation_key".equals(strM15702a)) {
            String strM15403a = m15403a(this.f15396b, string);
            if (!"".equals(strM15403a)) {
                return strM15403a;
            }
            if ("pref_professional_exposure_compensation_key".equals(strM15702a)) {
                strM15710d = getDefaultValue();
                strM15397a = m15403a(this.f15396b, strM15710d);
            } else {
                strM15710d = this.f15396b.m15710d();
                strM15397a = m15397a(strM15702a);
            }
            if (this.f15396b.m15705b() != null && this.f15396b.m15705b().size() != 0 && m15401b(strM15702a, strM15710d)) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strM15702a, strM15710d);
                editorEdit.apply();
            }
            return strM15397a;
        }
        return m15397a(strM15702a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15401b(String str, String str2) {
        if ("pref_professional_exposure_time_key".equals(str)) {
            return (TextUtils.isEmpty(str2) || this.f15403j.getString(R.string.camera_exposure_time_default_value).equals(str2)) ? false : true;
        }
        return true;
    }

    public int getCurrentIndex() {
        return this.f15398d.getCurrentIndex();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15406a(int OplusGLSurfaceView_13) {
        return this.f15398d.getCurrentIndex() == OplusGLSurfaceView_13;
    }

    public void setValueChangeListener(PlatformImplementations.kt_3 aVar) {
        this.f15404k = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15404a(final int OplusGLSurfaceView_13, Activity activity) {
        if (this.f15398d.getCurrentIndex() != OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) {
            this.f15398d.setCurrentIndex(OplusGLSurfaceView_13);
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.IntrinsicsJvm.kt_3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HSLevelPanel.this.f15398d.scrollTo(OplusGLSurfaceView_13);
                        if (HSLevelPanel.this.f15404k != null) {
                            HSLevelPanel.this.f15404k.mo15414b(OplusGLSurfaceView_13);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15405a(final int OplusGLSurfaceView_13, Activity activity, String str) {
        this.f15398d.setCurrentIndex(OplusGLSurfaceView_13);
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.IntrinsicsJvm.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    HSLevelPanel.this.f15398d.scrollTo(OplusGLSurfaceView_13);
                    if (HSLevelPanel.this.f15404k != null) {
                        HSLevelPanel.this.f15404k.mo15411a(OplusGLSurfaceView_13);
                    }
                }
            });
        }
    }

    public void setBarAuto(boolean z) {
        this.f15410q = z;
        HSScaleBar hSScaleBar = this.f15398d;
        if (hSScaleBar != null) {
            hSScaleBar.setAuto(this.f15410q, true);
        }
        HSAutoImageView c2884b = this.f15397c;
        if (c2884b != null) {
            c2884b.setAuto(this.f15410q);
        }
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        HSScaleBar hSScaleBar = this.f15398d;
        if (hSScaleBar != null) {
            hSScaleBar.setAlign(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f15409p) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        HSScaleBar hSScaleBar = this.f15398d;
        if (hSScaleBar != null) {
            hSScaleBar.invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15408b() {
        HSSubModeBarData c2891i;
        HSScaleBar hSScaleBar = this.f15398d;
        if (hSScaleBar == null || (c2891i = this.f15396b) == null) {
            return;
        }
        hSScaleBar.setLevelNum(c2891i.m15708c().size());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m15399a(android.os.Handler r14) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.HSLevelPanel.m15399a(android.os.Handler):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m15407b(SharedPreferences sharedPreferences) {
        String strM15702a = this.f15396b.m15702a();
        ArrayList<String> arrayListM15705b = this.f15396b.m15705b();
        String strM15710d = this.f15396b.m15710d();
        if (sharedPreferences != null) {
            strM15710d = sharedPreferences.getString(strM15702a, this.f15396b.m15710d());
        }
        return arrayListM15705b.indexOf(strM15710d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15409b(int OplusGLSurfaceView_13) {
        HSScaleBar hSScaleBar = this.f15398d;
        if (hSScaleBar != null) {
            hSScaleBar.initDataIndex(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onValueChange(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("HSLevelPanel", "onValueChange, value: " + OplusGLSurfaceView_13);
        PlatformImplementations.kt_3 aVar = this.f15404k;
        if (aVar != null) {
            aVar.mo15411a(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onBarMoving() {
        if (this.f15410q) {
            setBarAuto(false);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onBarScrolling(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f15404k;
        if (aVar != null) {
            aVar.mo15412a(z);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onActionUp() {
        PlatformImplementations.kt_3 aVar = this.f15404k;
        if (aVar != null) {
            aVar.mo15413b();
        }
    }
}
