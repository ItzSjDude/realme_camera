package com.oplus.camera.filmvideomode;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Size;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.filmvideomode.FilmParamsContainer;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.professional.ProfessionalUtil;
import com.oplus.camera.professional.SubModeBarData;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: FilmSlideBarContainer.java */
/* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class FilmSlideBarContainer extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f13691a = "OplusGLSurfaceView_14";

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Map<Integer, FilmLevelPanel> f13692b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Map<LevelPanel, Animator> f13693c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f13694d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SharedPreferences f13695e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RelativeLayout.LayoutParams f13696f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f13697g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PanelContainer.IntrinsicsJvm.kt_4 f13698h;

    /* renamed from: OplusGLSurfaceView_13 */
    private FilmParamsContainer.PlatformImplementations.kt_3 f13699i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f13700j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13701k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f13702l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f13703m;

    /* compiled from: FilmSlideBarContainer.java */
    /* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13565a(int OplusGLSurfaceView_13, int i2, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo13579b(int OplusGLSurfaceView_13, boolean z);
    }

    public FilmSlideBarContainer(Context context, CameraInterface interfaceC2646a) {
        super(context);
        this.f13694d = null;
        this.f13695e = null;
        this.f13692b = new HashMap();
        this.f13693c = new HashMap();
        this.f13696f = new RelativeLayout.LayoutParams(-2, -2);
        this.f13697g = null;
        this.f13698h = null;
        this.f13699i = null;
        this.f13700j = false;
        this.f13701k = 0;
        this.f13702l = true;
        this.f13703m = false;
        this.f13696f.addRule(14);
        this.f13696f.height = getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height);
        if (Util.m24498u()) {
            this.f13696f.width = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_width);
            this.f13696f.bottomMargin = 0;
        } else {
            this.f13696f.bottomMargin = getResources().getDimensionPixelSize(R.dimen.movie_mode_params_slide_bar_margin_bottom);
        }
        this.f13694d = interfaceC2646a;
        this.f13695e = interfaceC2646a.mo10590t();
        this.f13701k = getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_touch_rect_height);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13629a(OplusCameraCharacteristics c2698h, Handler handler) {
        m13622a(c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w(), handler);
        m13626a(Math.min(125000000L, c2698h.m13289x()), c2698h.m13290y(), c2698h.m13258a(256), handler);
        m13631a(c2698h.m13245B(), handler);
        m13620a(c2698h.m13279n(), c2698h.m13278m(), handler);
        m13621a(c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r(), handler);
        m13635b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13622a(int OplusGLSurfaceView_13, int i2, int i3, Handler handler) {
        m13627a(this.f13696f, 1, false, m13596a(OplusGLSurfaceView_13, i2, i3), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13626a(long OplusGLSurfaceView_15, long j2, List<Size> list, Handler handler) {
        m13627a(this.f13696f, 2, false, m13597a(OplusGLSurfaceView_15, j2, list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13631a(List<Integer> list, Handler handler) {
        m13627a(this.f13696f, 5, false, m13604b(list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13620a(float COUIBaseListPopupWindow_12, float f2, Handler handler) {
        m13627a(this.f13696f, 4, false, m13594a(COUIBaseListPopupWindow_12, f2), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13621a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, Handler handler) {
        m13627a(this.f13696f, 3, false, m13595a(OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12), 2, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13627a(RelativeLayout.LayoutParams layoutParams, final int OplusGLSurfaceView_13, boolean z, SubModeBarData c2908z, int i2, Handler handler) {
        if (this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            CameraLog.m12967f(f13691a, "addControllerPanel, return, size: " + this.f13692b.size());
            return;
        }
        final FilmLevelPanel c2708c = new FilmLevelPanel(getContext(), true, handler, z, ProfessionalUtil.m16137a(OplusGLSurfaceView_13), c2908z, this.f13694d.mo10590t());
        c2708c.setLayoutParams(layoutParams);
        c2708c.setAlign(i2);
        addView(c2708c);
        c2708c.setValueChangeListener(new LevelPanel.ValueChangeListener() { // from class: com.oplus.camera.filmvideomode.OplusGLSurfaceView_14.1
            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onManualValueChange(int i3) {
                FilmSlideBarContainer.this.m13613i(i3);
                FilmSlideBarContainer.this.m13624a(OplusGLSurfaceView_13, c2708c.getPreferencesKey(), i3);
                FilmSlideBarContainer.this.f13697g.mo13565a(OplusGLSurfaceView_13, i3, false);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoValueChange(int i3) {
                FilmSlideBarContainer.this.f13697g.mo13565a(OplusGLSurfaceView_13, i3, true);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoButtonClick() {
                if (FilmSlideBarContainer.this.f13700j) {
                    return;
                }
                if (FilmSlideBarContainer.this.m13642e(OplusGLSurfaceView_13)) {
                    FilmSlideBarContainer.this.m13632a(false, OplusGLSurfaceView_13);
                    FilmSlideBarContainer.this.f13698h.mo13566a(OplusGLSurfaceView_13, MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                } else {
                    FilmSlideBarContainer.this.m13632a(true, OplusGLSurfaceView_13);
                    FilmSlideBarContainer.this.f13698h.mo13566a(OplusGLSurfaceView_13, "auto", true);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onBarScrolling(boolean z2) {
                if (FilmSlideBarContainer.this.f13700j && !z2) {
                    FilmSlideBarContainer.this.f13698h.mo13566a(OplusGLSurfaceView_13, c2708c.mo13485a(FilmSlideBarContainer.this.f13694d.mo10590t()), false);
                }
                FilmSlideBarContainer.this.f13700j = z2;
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onActionUp() {
                if (FilmSlideBarContainer.this.f13700j) {
                    return;
                }
                FilmSlideBarContainer.this.f13698h.mo13566a(OplusGLSurfaceView_13, c2708c.mo13485a(FilmSlideBarContainer.this.f13694d.mo10590t()), false);
            }
        });
        this.f13692b.put(Integer.valueOf(OplusGLSurfaceView_13), c2708c);
    }

    public Map<Integer, FilmLevelPanel> getPanelMap() {
        return this.f13692b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13616a(int OplusGLSurfaceView_13) {
        ArrayList<String> parameterValueList;
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c != null && (parameterValueList = c2708c.getParameterValueList()) != null && parameterValueList.size() > 0) {
            int currentIndex = c2708c.getCurrentIndex();
            if (currentIndex >= 0 && currentIndex < parameterValueList.size()) {
                return parameterValueList.get(currentIndex);
            }
            String strM13639d = m13639d(OplusGLSurfaceView_13);
            if (!"".equals(strM13639d) && !"auto".equals(strM13639d)) {
                return strM13639d;
            }
        }
        return "0";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13618a(int OplusGLSurfaceView_13, int i2) {
        ArrayList<String> parameterValueList;
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c != null && (parameterValueList = c2708c.getParameterValueList()) != null && parameterValueList.size() > 0) {
            if (i2 >= 0 && i2 < parameterValueList.size()) {
                return parameterValueList.get(i2);
            }
            String strM13639d = m13639d(OplusGLSurfaceView_13);
            if (!"".equals(strM13639d) && !"auto".equals(strM13639d)) {
                return strM13639d;
            }
        }
        return "0";
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<String> m13634b(int OplusGLSurfaceView_13) {
        return this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> m13637c(int OplusGLSurfaceView_13) {
        return this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)) != null ? this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList() : new ArrayList<>();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13624a(int OplusGLSurfaceView_13, String str, int i2) {
        if (this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            ArrayList<String> parameterValueList = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
            if (i2 < parameterValueList.size()) {
                SharedPreferences.Editor editorEdit = this.f13694d.mo10590t().edit();
                editorEdit.putString(str, parameterValueList.get(i2));
                editorEdit.putInt(str + "_manual", i2);
                editorEdit.apply();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SubModeBarData m13604b(List<Integer> list) {
        SubModeBarData c2908zM16148d = new SubModeBarData(getContext()).m16140a(R.string.camera_whitebalance_professional_title).m16143b(R.drawable.professional_mode_ic_wb).m16146c(R.id_renamed.awb_controller).m16141a("awb_mode_key").m16144b(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE).m16148d(R.string.camera_whitebalance_default_value);
        m13602a(c2908zM16148d, list);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m13595a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        SubModeBarData c2908zM16148d = new SubModeBarData(getContext()).m16140a(R.string.camera_exposure_compensation_professional_title).m16143b(R.drawable.professional_mode_ic_ev).m16146c(R.id_renamed.exposure_controller).m16141a("iso_mode_key").m16144b(CameraUIInterface.KEY_FILM_MODE_EXPOSURE).m16148d(R.string.camera_exposure_compensation_default_value);
        m13600a(c2908zM16148d, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m13596a(int OplusGLSurfaceView_13, int i2, int i3) {
        SubModeBarData c2908zM16148d = new SubModeBarData(getContext()).m16140a(R.string.camera_iso_professional_title).m16143b(R.drawable.professional_mode_ic_iso).m16146c(R.id_renamed.iso_controller).m16141a("exposure_mode_key").m16144b(CameraUIInterface.KEY_FILM_MODE_ISO).m16148d(R.string.camera_iso_default_value);
        m13601a(c2908zM16148d, OplusGLSurfaceView_13, i2, i3);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m13597a(long OplusGLSurfaceView_15, long j2, List<Size> list) throws Resources.NotFoundException, NumberFormatException {
        SubModeBarData c2908zM16153f = new SubModeBarData(getContext()).m16140a(R.string.camera_exposure_time_title).m16143b(R.drawable.professional_mode_ic_s).m16146c(R.id_renamed.shutter_controller).m16141a("shutter_mode_key").m16144b(CameraUIInterface.KEY_FILM_MODE_SHUTTER).m16148d(R.string.camera_exposure_time_default_value_auto).m16150e(R.array.professional_exposure_time_values).m16153f(R.array.professional_exposure_time_names);
        m13630a(c2908zM16153f, OplusGLSurfaceView_15, j2, list);
        return c2908zM16153f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m13594a(float COUIBaseListPopupWindow_12, float f2) {
        SubModeBarData c2908zM16148d = new SubModeBarData(getContext()).m16140a(R.string.camera_focus_mode_title).m16143b(R.drawable.professional_mode_ic_af).m16146c(R.id_renamed.manual_focus_controller).m16141a("manual_focus_mode_key").m16144b(CameraUIInterface.KEY_FILM_MODE_FOCUS).m16148d(R.string.camera_focus_mode_default_value);
        m13599a(c2908zM16148d, COUIBaseListPopupWindow_12, f2);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13600a(SubModeBarData c2908z, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        if ((OplusGLSurfaceView_13 == -1 && i2 == -1) || OplusGLSurfaceView_13 > i2 || Float.compare(COUIBaseListPopupWindow_12, 0.0f) == 0) {
            CameraLog.m12967f(f13691a, "generateExposureCompensationValues, return, minIndex: " + OplusGLSurfaceView_13 + ", maxIndex: " + i2);
            return;
        }
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        while (OplusGLSurfaceView_13 <= i2) {
            arrayListM16145b.add(String.valueOf(OplusGLSurfaceView_13));
            arrayListM16147c.add(m13617a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12));
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13602a(SubModeBarData c2908z, List<Integer> list) {
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (list == null || list.size() <= 0) {
            CameraLog.m12967f(f13691a, "generateWhiteBalanceValues, return, range: " + list);
            return;
        }
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            int iIntValue = list.get(OplusGLSurfaceView_13).intValue();
            arrayListM16145b.add(Integer.toString(iIntValue));
            arrayListM16147c.add(iIntValue + OplusExifInterface.GpsSpeedRef.KILOMETERS);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13630a(SubModeBarData c2908z, long OplusGLSurfaceView_15, long j2, List<Size> list) throws NumberFormatException {
        double IntrinsicsJvm.kt_5;
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (arrayListM16147c != null && arrayListM16147c.size() > 0 && arrayListM16145b != null && arrayListM16145b.size() > 0 && Math.abs(1.0f - (m13615a(list) / Long.valueOf(BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            arrayListM16147c.remove(arrayListM16147c.size() - 1);
            arrayListM16145b.remove(arrayListM16145b.size() - 1);
        }
        CameraLog.m12959b(f13691a, "generateShutterValues, max: " + OplusGLSurfaceView_15 + ", min: " + j2 + ", before filtering, parameterNamesList: " + arrayListM16147c);
        if (arrayListM16147c == null || arrayListM16145b == null) {
            return;
        }
        Iterator<String> it = arrayListM16147c.iterator();
        long j3 = -1;
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split("/");
            if (strArrSplit.length > 1) {
                IntrinsicsJvm.kt_5 = Double.parseDouble(strArrSplit[0]) / Double.parseDouble(strArrSplit[1].split("s")[0]);
            } else {
                if (strArrSplit.length == 1) {
                    IntrinsicsJvm.kt_5 = Double.parseDouble(strArrSplit[0].split("s")[0]);
                }
                if (j3 >= j2 || j3 > OplusGLSurfaceView_15) {
                    it.remove();
                } else {
                    arrayListM16145b.add(String.valueOf(j3));
                }
            }
            j3 = (long) (IntrinsicsJvm.kt_5 * 1.0E9d);
            if (j3 >= j2) {
            }
            it.remove();
        }
        long j4 = Long.parseLong(arrayListM16145b.get(arrayListM16145b.size() - 1)) / C1547C.NANOS_PER_SECOND;
        long j5 = OplusGLSurfaceView_15 / C1547C.NANOS_PER_SECOND;
        if (j4 < j5) {
            arrayListM16145b.add(String.valueOf(OplusGLSurfaceView_15));
            arrayListM16147c.add(j5 + "s");
        }
        CameraLog.m12959b(f13691a, "generateShutterValues, after filtering, parameterValuesList: " + arrayListM16145b + ", parameterNamesList: " + arrayListM16147c);
        if (m13614a(CameraUIInterface.KEY_FILM_MODE_SHUTTER) >= arrayListM16145b.size()) {
            this.f13694d.mo10590t().edit().remove("pref_film_mode_shutter_manual").apply();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13599a(SubModeBarData c2908z, float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 < f2) {
            f2 = COUIBaseListPopupWindow_12;
            COUIBaseListPopupWindow_12 = f2;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) <= 0.0f || Float.compare(COUIBaseListPopupWindow_12, f2) == 0) {
            CameraLog.m12967f(f13691a, "generateFocusValues, return, minFocusDistance: " + COUIBaseListPopupWindow_12);
            return;
        }
        float f3 = (COUIBaseListPopupWindow_12 - f2) / 50.0f;
        CameraLog.m12954a(f13691a, "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + COUIBaseListPopupWindow_12);
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 50; OplusGLSurfaceView_13++) {
            float f4 = OplusGLSurfaceView_13;
            arrayListM16145b.add(Float.toString(COUIBaseListPopupWindow_12 - (f3 * f4)));
            arrayListM16147c.add(String.format(Locale.US, "%.2f", Float.valueOf(f4 * 0.02f)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13601a(SubModeBarData c2908z, int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 > OplusGLSurfaceView_13) {
            OplusGLSurfaceView_13 = i2;
        }
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (OplusGLSurfaceView_13 <= 0 || i3 <= 0 || OplusGLSurfaceView_13 == i3) {
            CameraLog.m12967f(f13691a, "generateIsoValues, return null, maxISOValue: " + OplusGLSurfaceView_13 + ", minISOValue: " + i3 + ", maxISOValue: " + OplusGLSurfaceView_13);
            return;
        }
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        while (i3 <= OplusGLSurfaceView_13) {
            arrayListM16145b.add(Integer.toString(i3));
            arrayListM16147c.add(Integer.toString(i3));
            i3 += 100;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13617a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float f2 = OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12;
        if (f2 <= 0.0f) {
            return String.format(Locale.US, "%.2f", Float.valueOf(f2));
        }
        return "+" + String.format(Locale.US, "%.2f", Float.valueOf(f2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m13615a(List<Size> list) {
        long width = 0;
        for (Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        CameraLog.m12954a(f13691a, "getMaxPictureSize, max: " + width);
        return width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m13613i(int OplusGLSurfaceView_13) {
        VibrateManager c2613aeMo10528ad;
        if (!this.f13702l || this.f13703m || (c2613aeMo10528ad = this.f13694d.mo10528ad()) == null) {
            return;
        }
        if (OplusGLSurfaceView_13 % 10 == 0) {
            c2613aeMo10528ad.m11294f();
        } else {
            c2613aeMo10528ad.m11292d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13625a(int OplusGLSurfaceView_13, boolean z) {
        boolean zM13633a = m13633a();
        FilmParamsContainer.PlatformImplementations.kt_3 aVar = this.f13699i;
        if (aVar != null) {
            aVar.mo13435e(true);
        }
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar2 = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar2.f15706a = false;
            aVar2.f15708c = 250;
            setAllPopupInvisibility(aVar2);
        } else {
            setAllPopupInvisibility(null);
        }
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        Animator animatorRemove = this.f13693c.remove(c2708c);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        if (c2708c == null) {
            return;
        }
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar3 = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar3.f15706a = true;
            aVar3.f15707b = 150;
            aVar3.f15708c = zM13633a ? 250 : 400;
            aVar3.f15709d = zM13633a ? 0.0f : getContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
            aVar3.f15710e = 0.0f;
            aVar3.f15711f = zM13633a ? 0 : 150;
            aVar3.f15712g = zM13633a ? 0 : 400;
            this.f13693c.put(c2708c, ProfessionalAnimUtil.m15922a(c2708c, aVar3));
            return;
        }
        c2708c.setVisibility(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13633a() {
        Iterator<FilmLevelPanel> it = this.f13692b.values().iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public int getVisibilityPanelIndex() {
        for (Map.Entry<Integer, FilmLevelPanel> entry : this.f13692b.entrySet()) {
            if (entry.getValue().getVisibility() == 0) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13635b() {
        setAllPopupInvisibility(null);
    }

    public void setAllPopupInvisibility(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) {
        for (FilmLevelPanel c2708c : this.f13692b.values()) {
            Animator animatorRemove = this.f13693c.remove(c2708c);
            if (animatorRemove != null) {
                animatorRemove.cancel();
            }
            if (c2708c.getVisibility() == 0 && aVar != null) {
                this.f13693c.put(c2708c, ProfessionalAnimUtil.m15922a(c2708c, aVar));
            } else {
                c2708c.setVisibility(4);
            }
        }
    }

    public void setParamsStateListener(FilmParamsContainer.PlatformImplementations.kt_3 aVar) {
        this.f13699i = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13632a(boolean z, int OplusGLSurfaceView_13) {
        if (m13642e(OplusGLSurfaceView_13) == z) {
            CameraLog.m12959b(f13691a, "onManualClick, no change, isAuto: " + z);
            return;
        }
        if (z) {
            setAuto(OplusGLSurfaceView_13);
        } else {
            setManual(OplusGLSurfaceView_13);
        }
        PlatformImplementations.kt_3 aVar = this.f13697g;
        if (aVar != null) {
            aVar.mo13579b(OplusGLSurfaceView_13, z);
        }
    }

    public void setPanelsBarAuto(int OplusGLSurfaceView_13) {
        this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(true);
    }

    public void setAuto(int OplusGLSurfaceView_13) {
        setPreferenceAuto(OplusGLSurfaceView_13);
        setPanelsBarAuto(OplusGLSurfaceView_13);
    }

    public void setManual(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f13694d.mo10590t().edit();
        editorEdit.putBoolean(c2708c.getPreferencesKey() + "_manual_state", true);
        editorEdit.apply();
        int iM13614a = m13614a(c2708c.getPreferencesKey());
        if (iM13614a >= 0) {
            m13623a(OplusGLSurfaceView_13, iM13614a, m13619a(OplusGLSurfaceView_13, c2708c.getPreferencesKey()));
        } else {
            int currentIndex = c2708c.getCurrentIndex();
            m13623a(OplusGLSurfaceView_13, currentIndex, c2708c.getParameterNamesList().get(currentIndex));
        }
        c2708c.setBarAuto(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13614a(String str) {
        return this.f13694d.mo10590t().getInt(str + "_manual", -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13619a(int OplusGLSurfaceView_13, String str) {
        int iM13614a = m13614a(str);
        if (iM13614a < 0) {
            return null;
        }
        ArrayList<String> parameterNamesList = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList();
        if (iM13614a > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(iM13614a);
    }

    public void setPreferenceAuto(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f13694d.mo10590t().edit();
        editorEdit.putString(c2708c.getPreferencesKey(), c2708c.getDefaultValue());
        editorEdit.putBoolean(c2708c.getPreferencesKey() + "_manual_state", false);
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m13639d(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        return c2708c == null ? "" : this.f13694d.mo10590t().getString(c2708c.getPreferencesKey(), c2708c.getDefaultValue());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13636b(int OplusGLSurfaceView_13, int i2) {
        this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).m15361b(i2, (Activity) getContext());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13623a(int OplusGLSurfaceView_13, int i2, String str) {
        this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13)).m15357a(i2, (Activity) getContext(), str);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m13642e(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c == null) {
            return false;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f13694d.mo10590t();
        StringBuilder sb = new StringBuilder();
        sb.append(c2708c.getPreferencesKey());
        sb.append("_manual_state");
        return m13639d(OplusGLSurfaceView_13).equals(c2708c.getDefaultValue()) && !sharedPreferencesMo10590t.getBoolean(sb.toString(), false);
    }

    public void setMotionListener(PanelContainer.IntrinsicsJvm.kt_4 bVar) {
        this.f13698h = bVar;
    }

    public void setValueListener(PlatformImplementations.kt_3 aVar) {
        this.f13697g = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13638c() {
        Map<Integer, FilmLevelPanel> map = this.f13692b;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f13694d.mo10590t().edit();
        for (FilmLevelPanel c2708c : this.f13692b.values()) {
            editorEdit.putInt(c2708c.getPreferencesKey() + "_manual", -1);
            editorEdit.putBoolean(c2708c.getPreferencesKey() + "_manual_state", false);
            editorEdit.putString(c2708c.getPreferencesKey(), c2708c.getDefaultValue());
        }
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13628a(OplusCameraCharacteristics c2698h) {
        Map<Integer, FilmLevelPanel> map = this.f13692b;
        if (map == null || map.size() == 0) {
            return;
        }
        m13612f(c2698h);
        m13611e(c2698h);
        m13610d(c2698h);
        m13608c(c2698h);
        m13605b(c2698h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13605b(OplusCameraCharacteristics c2698h) {
        m13600a(this.f13692b.get(3).getSubModeBarData(), c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r());
        this.f13692b.get(3).m15362d();
        if (this.f13697g != null) {
            this.f13697g.mo13565a(3, this.f13692b.get(3).m15359b(this.f13694d.mo10590t()), m13642e(3));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13608c(OplusCameraCharacteristics c2698h) {
        m13599a(this.f13692b.get(4).getSubModeBarData(), c2698h.m13279n(), c2698h.m13278m());
        this.f13692b.get(4).m15362d();
        this.f13692b.get(4).setBarAuto(m13642e(4));
        if (this.f13697g != null) {
            this.f13697g.mo13565a(4, this.f13692b.get(4).m15359b(this.f13694d.mo10590t()), m13642e(4));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m13610d(OplusCameraCharacteristics c2698h) {
        m13602a(this.f13692b.get(5).getSubModeBarData(), c2698h.m13245B());
        this.f13692b.get(5).m15362d();
        this.f13692b.get(5).setBarAuto(m13642e(5));
        if (this.f13697g != null) {
            this.f13697g.mo13565a(5, this.f13692b.get(5).m15359b(this.f13694d.mo10590t()), m13642e(5));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m13611e(OplusCameraCharacteristics c2698h) throws Resources.NotFoundException, NumberFormatException {
        SubModeBarData subModeBarData = this.f13692b.get(2).getSubModeBarData();
        subModeBarData.m16147c().clear();
        subModeBarData.m16145b().clear();
        subModeBarData.m16150e(R.array.professional_exposure_time_values);
        subModeBarData.m16153f(R.array.professional_exposure_time_names);
        m13630a(subModeBarData, Math.min(125000000L, c2698h.m13289x()), c2698h.m13290y(), c2698h.m13258a(256));
        this.f13692b.get(2).m15362d();
        this.f13692b.get(2).setBarAuto(m13642e(2));
        if (this.f13697g != null) {
            this.f13697g.mo13565a(2, this.f13692b.get(2).m15359b(this.f13694d.mo10590t()), m13642e(2));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m13612f(OplusCameraCharacteristics c2698h) {
        m13601a(this.f13692b.get(1).getSubModeBarData(), c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w());
        this.f13692b.get(1).m15362d();
        this.f13692b.get(1).setBarAuto(m13642e(1));
        if (this.f13697g != null) {
            this.f13697g.mo13565a(1, this.f13692b.get(1).m15359b(this.f13694d.mo10590t()), m13642e(1));
        }
    }

    @Override // android.view.View
    public void scrollTo(int OplusGLSurfaceView_13, int i2) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (!(getContext() instanceof Activity) || c2708c == null) {
            return;
        }
        c2708c.m15356a(i2, (Activity) getContext());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m13643f(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c != null) {
            return c2708c.mo13485a(this.f13695e);
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m13645g(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c != null) {
            return c2708c.m13486a(m13643f(OplusGLSurfaceView_13));
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public String m13646h(int OplusGLSurfaceView_13) {
        FilmLevelPanel c2708c = this.f13692b.get(Integer.valueOf(OplusGLSurfaceView_13));
        if (c2708c != null) {
            return c2708c.getSubModeBarData().m16149d();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13640d() {
        for (FilmLevelPanel c2708c : this.f13692b.values()) {
            c2708c.m15360b(c2708c.m15359b(this.f13694d.mo10590t()));
        }
    }

    public Rect getTouchAreaRect() {
        return new Rect(getLeft(), getBottom() - this.f13701k, getRight(), getBottom());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13641e() {
        this.f13703m = true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m13644f() {
        this.f13703m = false;
    }
}
