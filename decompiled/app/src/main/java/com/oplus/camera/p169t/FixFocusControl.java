package com.oplus.camera.p169t;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: FixFocusControl.java */
/* renamed from: com.oplus.camera.t.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class FixFocusControl {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private OneCamera f16496g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private SharedPreferences f16497h;

    /* renamed from: OplusGLSurfaceView_14 */
    private Activity f16501l;

    /* renamed from: OplusGLSurfaceView_6 */
    private CameraUIInterface f16502m;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f16490a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f16491b = "1";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f16492c = "28";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f16493d = "169";

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String[] f16494e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f16495f = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private ArrayList<String> f16498i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ArrayList<String> f16499j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private StreetHelperTextView f16500k = null;

    public FixFocusControl(OneCamera interfaceC2694d, CameraInterface interfaceC2646a, Activity activity, CameraUIInterface cameraUIInterface) {
        this.f16496g = null;
        this.f16497h = null;
        this.f16501l = null;
        this.f16502m = null;
        this.f16496g = interfaceC2694d;
        this.f16497h = interfaceC2646a.mo10590t();
        this.f16502m = cameraUIInterface;
        this.f16501l = activity;
        OplusCameraCharacteristics c2698hM12971a = CameraCharacteristicsUtil.m12971a(ApsConstant.CAPTURE_MODE_STREET, interfaceC2646a.mo10547aw());
        m17213a(c2698hM12971a.m13279n(), c2698hM12971a.m13278m());
        m17216h();
        m17223d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17213a(float COUIBaseListPopupWindow_12, float f2) {
        this.f16498i = new ArrayList<>();
        this.f16499j = new ArrayList<>();
        if (COUIBaseListPopupWindow_12 < f2) {
            f2 = COUIBaseListPopupWindow_12;
            COUIBaseListPopupWindow_12 = f2;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) <= 0 || Float.compare(COUIBaseListPopupWindow_12, f2) == 0) {
            CameraLog.m12966e("FixFocusCtrol", "generateFocusValues, return, minFocusDistance: " + COUIBaseListPopupWindow_12);
            return;
        }
        float f3 = (COUIBaseListPopupWindow_12 - f2) / 50.0f;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 <= 50) {
            float f4 = OplusGLSurfaceView_13;
            this.f16498i.add(Float.toString(COUIBaseListPopupWindow_12 - (f3 * f4)));
            String str = String.format(Locale.US, "%.2f", Float.valueOf((OplusGLSurfaceView_13 < 0 || f4 > 45.0f) ? 1.0f + ((f4 - 45.0f) * 0.8f) : 0.02f * f4));
            if (f4 == 45.0f) {
                this.f16499j.add("1.00m");
            } else {
                this.f16499j.add(str + "OplusGLSurfaceView_6");
            }
            OplusGLSurfaceView_13++;
        }
        this.f16490a = m17217a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17218a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FixFocusCtrol", "onValueChange value: " + OplusGLSurfaceView_13);
        String strM17215d = m17215d(OplusGLSurfaceView_13);
        this.f16500k.setText(m17214c(OplusGLSurfaceView_13));
        if (strM17215d != null) {
            m17220b(OplusGLSurfaceView_13);
            OneCamera interfaceC2694d = this.f16496g;
            if (interfaceC2694d != null) {
                interfaceC2694d.mo13023a(Float.valueOf(strM17215d).floatValue(), true);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String m17214c(int OplusGLSurfaceView_13) {
        return this.f16499j.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17220b(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f16497h.edit();
        editorEdit.putInt(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, OplusGLSurfaceView_13);
        editorEdit.putBoolean(CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, true);
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m17217a() {
        return this.f16497h.getInt(CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, 10);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String m17215d(int OplusGLSurfaceView_13) {
        ArrayList<String> arrayList;
        if (OplusGLSurfaceView_13 <= -1 || (arrayList = this.f16498i) == null || arrayList.size() <= OplusGLSurfaceView_13) {
            return null;
        }
        return this.f16498i.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m17221b() {
        m17225f();
        int OplusGLSurfaceView_13 = this.f16490a;
        if (OplusGLSurfaceView_13 <= 0) {
            return false;
        }
        this.f16490a = OplusGLSurfaceView_13 - 1;
        m17219a(true);
        m17218a(this.f16490a);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m17222c() {
        m17225f();
        int OplusGLSurfaceView_13 = this.f16490a;
        if (OplusGLSurfaceView_13 >= 50) {
            return false;
        }
        this.f16490a = OplusGLSurfaceView_13 + 1;
        m17219a(true);
        m17218a(this.f16490a);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17219a(boolean z) {
        this.f16495f = z;
        this.f16496g.mo13016E(this.f16495f);
        this.f16496g.mo13059a(this.f16494e);
        this.f16496g.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m17216h() {
        String[] strArrM24402b;
        this.f16491b = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_EDGE_FILTER_LINE_SIZE);
        int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_EDGE_FILTER_COLOR);
        if (configIntArrayValue != null && 3 == configIntArrayValue.length && (strArrM24402b = Util.m24402b(configIntArrayValue[0], configIntArrayValue[1], configIntArrayValue[2])) != null && 2 == strArrM24402b.length) {
            this.f16492c = strArrM24402b[0];
            this.f16493d = strArrM24402b[1];
        }
        this.f16494e = new String[]{this.f16491b, this.f16492c, this.f16493d};
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17223d() {
        this.f16500k = new StreetHelperTextView(this.f16501l.getApplicationContext());
        Resources resources = this.f16501l.getApplicationContext().getResources();
        this.f16500k.setVerticalDraw(true);
        this.f16500k.setIncludeFontPadding(false);
        this.f16500k.setTextSize(0, resources.getDimensionPixelSize(R.dimen.street_main_mode_bar_item_text_size));
        this.f16500k.setTypeface(Util.m24473l(this.f16501l.getApplicationContext()));
        this.f16500k.setGravity(80);
        this.f16500k.setTextColor(resources.getColor(R.color.main_item_title_text_color));
        this.f16500k.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.street_mode_trace_height) + (resources.getDimensionPixelSize(R.dimen.street_mode_trace_button_size) / 2);
        this.f16500k.setLayoutParams(layoutParams);
        this.f16502m.mo18087a((View) this.f16500k, ApsConstant.CAPTURE_MODE_STREET, 4, true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17224e() {
        StreetHelperTextView c3024d = this.f16500k;
        if (c3024d != null) {
            c3024d.setVisibility(8);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17225f() {
        StreetHelperTextView c3024d = this.f16500k;
        if (c3024d == null || c3024d.getVisibility() == 0) {
            return;
        }
        this.f16490a = m17217a();
        this.f16500k.setText(m17214c(this.f16490a));
        this.f16500k.setVisibility(0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m17226g() {
        return this.f16497h.getBoolean(CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, false);
    }
}
