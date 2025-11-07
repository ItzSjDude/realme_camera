package com.oplus.camera.professional;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Size;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.exif.OplusExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: PanelContainer.java */
/* renamed from: com.oplus.camera.professional.p */
/* loaded from: classes2.dex */
public class PanelContainer extends RelativeLayout implements PanelInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    protected CameraInterface f15632a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected CameraUIInterface f15633b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected OplusCameraCharacteristics f15634c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Map<Integer, LevelPanel> f15635d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected Map<LevelPanel, Animator> f15636e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final RelativeLayout.LayoutParams f15637f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f15638g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Activity f15639h;

    /* renamed from: OplusGLSurfaceView_13 */
    private IntrinsicsJvm.kt_3 f15640i;

    /* renamed from: OplusGLSurfaceView_15 */
    private IntrinsicsJvm.kt_4 f15641j;

    /* renamed from: OplusGLSurfaceView_5 */
    private PlatformImplementations.kt_3 f15642k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15643l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15644m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15645n;

    /* compiled from: PanelContainer.java */
    /* renamed from: com.oplus.camera.professional.p$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13566a(int OplusGLSurfaceView_13, String str, boolean z);
    }

    /* compiled from: PanelContainer.java */
    /* renamed from: com.oplus.camera.professional.p$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15383a(int OplusGLSurfaceView_13, String str, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo15390b(int OplusGLSurfaceView_13, boolean z);
    }

    @Override // android.view.View
    public void clearAnimation() {
    }

    public PanelContainer(Context context, CameraInterface interfaceC2646a) {
        super(context);
        this.f15637f = new RelativeLayout.LayoutParams(-2, -2);
        this.f15632a = null;
        this.f15633b = null;
        this.f15634c = null;
        this.f15635d = new HashMap();
        this.f15636e = new HashMap();
        this.f15638g = true;
        this.f15639h = null;
        this.f15640i = null;
        this.f15641j = null;
        this.f15642k = new PlatformImplementations.kt_3();
        this.f15643l = false;
        this.f15644m = 0;
        this.f15645n = 0;
        this.f15639h = (Activity) context;
        this.f15632a = interfaceC2646a;
        this.f15637f.addRule(14);
    }

    public PanelContainer(Context context, CameraInterface interfaceC2646a, int OplusGLSurfaceView_13, int i2) {
        super(context);
        this.f15637f = new RelativeLayout.LayoutParams(-2, -2);
        this.f15632a = null;
        this.f15633b = null;
        this.f15634c = null;
        this.f15635d = new HashMap();
        this.f15636e = new HashMap();
        this.f15638g = true;
        this.f15639h = null;
        this.f15640i = null;
        this.f15641j = null;
        this.f15642k = new PlatformImplementations.kt_3();
        this.f15643l = false;
        this.f15644m = 0;
        this.f15645n = 0;
        this.f15644m = OplusGLSurfaceView_13;
        this.f15645n = i2;
        this.f15639h = (Activity) context;
        this.f15632a = interfaceC2646a;
        this.f15637f.addRule(14);
    }

    public void setCameraUIInterface(CameraUIInterface cameraUIInterface) {
        this.f15633b = cameraUIInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15806a(int OplusGLSurfaceView_13, int i2) {
        this.f15644m = OplusGLSurfaceView_13;
        this.f15645n = i2;
    }

    public void setSettleListener(IntrinsicsJvm.kt_3 cVar) {
        this.f15640i = cVar;
    }

    public void setMotionListener(IntrinsicsJvm.kt_4 bVar) {
        this.f15641j = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15808a(int OplusGLSurfaceView_13, int i2, int i3, Handler handler) {
        m15813a(this.f15637f, 1, false, m15781a(OplusGLSurfaceView_13, i2, i3), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15812a(long OplusGLSurfaceView_15, long j2, List<Size> list, Handler handler) {
        m15813a(this.f15637f, 2, false, m15782a(OplusGLSurfaceView_15, j2, list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15816a(List<Integer> list, Handler handler) {
        m15813a(this.f15637f, 5, false, m15791b(list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15805a(float COUIBaseListPopupWindow_12, float f2, Handler handler) {
        m15813a(this.f15637f, 4, false, m15779a(COUIBaseListPopupWindow_12, f2), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15807a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, Handler handler) {
        m15813a(this.f15637f, 3, false, m15780a(OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12), 2, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15728a(OplusCameraCharacteristics c2698h, Handler handler, PlatformImplementations.kt_3 aVar) {
        m15808a(c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w(), handler);
        m15812a((aVar == null || aVar.f15649a <= 0) ? c2698h.m13289x() : aVar.f15649a, c2698h.m13290y(), c2698h.m13258a(256), handler);
        m15816a(c2698h.m13245B(), handler);
        m15805a(c2698h.m13279n(), c2698h.m13278m(), handler);
        m15807a(c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r(), handler);
        m15832e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15777a(SubModeBarData c2908z) {
        return c2908z.m16152f();
    }

    public String getFocusValue() {
        if (m15836g(4)) {
            return ProfessionalUtil.m16135a(this.f15639h, 4);
        }
        return this.f15635d.get(4).mo13485a(this.f15632a.mo10590t());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayList<HashMap<String, Object>> m15803a(boolean z) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        if (z) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("mainTitle", Integer.valueOf(R.drawable.professional_mode_ic_reset));
            map.put("main_item_key", getResources().getString(R.string.camera_face_beauty_menu_reset));
            map.put("main_item_index", 0);
            map.put("main_item_animation", Integer.valueOf(R.raw.pro_reset_animation));
            arrayList.add(map);
        }
        for (Map.Entry<Integer, LevelPanel> entry : this.f15635d.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            LevelPanel value = entry.getValue();
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("mainTitle", Integer.valueOf(m15777a(value.getSubModeBarData())));
            map2.put("main_item_key", value.mo13485a(this.f15632a.mo10590t()));
            map2.put("main_item_index", Integer.valueOf(iIntValue));
            arrayList.add(map2);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15815a(OplusCameraCharacteristics c2698h, PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException, NumberFormatException {
        Map<Integer, LevelPanel> map = this.f15635d;
        if (map == null || map.size() == 0) {
            return;
        }
        m15797d(c2698h);
        m15793b(c2698h, aVar);
        m15796c(c2698h);
        m15792b(c2698h);
        m15783a(c2698h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15783a(OplusCameraCharacteristics c2698h) {
        if (m15828d(3).size() == 0) {
            m15786a(this.f15635d.get(3).getSubModeBarData(), c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r());
            this.f15635d.get(3).m15362d();
            if (this.f15640i != null) {
                this.f15640i.mo15383a(3, this.f15635d.get(3).mo13485a(this.f15632a.mo10590t()), m15836g(3));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15792b(OplusCameraCharacteristics c2698h) {
        if (m15828d(4).size() == 0) {
            m15785a(this.f15635d.get(4).getSubModeBarData(), c2698h.m13279n(), c2698h.m13278m());
            this.f15635d.get(4).m15362d();
            if (this.f15640i != null) {
                this.f15640i.mo15383a(4, this.f15635d.get(4).mo13485a(this.f15632a.mo10590t()), m15836g(4));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15796c(OplusCameraCharacteristics c2698h) {
        if (m15828d(5).size() == 0) {
            m15788a(this.f15635d.get(5).getSubModeBarData(), c2698h.m13245B());
            this.f15635d.get(5).m15362d();
            if (this.f15640i != null) {
                this.f15640i.mo15383a(5, this.f15635d.get(5).mo13485a(this.f15632a.mo10590t()), m15836g(5));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15814a(OplusCameraCharacteristics c2698h, long OplusGLSurfaceView_15) throws Resources.NotFoundException, NumberFormatException {
        SubModeBarData subModeBarData = this.f15635d.get(2).getSubModeBarData();
        subModeBarData.m16147c().clear();
        subModeBarData.m16145b().clear();
        subModeBarData.m16150e(R.array.professional_exposure_time_values);
        subModeBarData.m16153f(R.array.professional_exposure_time_names);
        mo15729a(subModeBarData, OplusGLSurfaceView_15, c2698h.m13290y(), c2698h.m13258a(256));
        this.f15635d.get(2).m15362d();
        if (this.f15640i != null) {
            this.f15640i.mo15383a(2, this.f15635d.get(2).mo13485a(this.f15632a.mo10590t()), m15836g(2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15793b(OplusCameraCharacteristics c2698h, PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException, NumberFormatException {
        SubModeBarData subModeBarData = this.f15635d.get(2).getSubModeBarData();
        subModeBarData.m16147c().clear();
        subModeBarData.m16145b().clear();
        subModeBarData.m16150e(R.array.professional_exposure_time_values);
        subModeBarData.m16153f(R.array.professional_exposure_time_names);
        mo15729a(subModeBarData, (aVar == null || aVar.f15649a <= 0) ? c2698h.m13289x() : aVar.f15649a, c2698h.m13290y(), c2698h.m13258a(256));
        this.f15635d.get(2).m15362d();
        if (this.f15640i != null) {
            this.f15640i.mo15383a(2, this.f15635d.get(2).mo13485a(this.f15632a.mo10590t()), m15836g(2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m15797d(OplusCameraCharacteristics c2698h) {
        m15787a(this.f15635d.get(1).getSubModeBarData(), c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w());
        this.f15635d.get(1).m15362d();
        if (this.f15640i != null) {
            this.f15640i.mo15383a(1, this.f15635d.get(1).mo13485a(this.f15632a.mo10590t()), m15836g(1));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> m15824c(int OplusGLSurfaceView_13) {
        return this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ArrayList<String> m15828d(int OplusGLSurfaceView_13) {
        return this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)) != null ? this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList() : new ArrayList<>();
    }

    @Override // android.view.View
    public void scrollTo(int OplusGLSurfaceView_13, int i2) {
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).m15356a(i2, this.f15639h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15820b(int OplusGLSurfaceView_13, int i2) {
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).m15361b(i2, this.f15639h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15809a(int OplusGLSurfaceView_13, int i2, String str) {
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).m15357a(i2, this.f15639h, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15804a() {
        for (LevelPanel levelPanel : this.f15635d.values()) {
            levelPanel.m15360b(levelPanel.m15359b(this.f15632a.mo10590t()));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m15827c(int OplusGLSurfaceView_13, int i2) {
        return this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).m15358a(i2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m15831e(int OplusGLSurfaceView_13) {
        return this.f15632a.mo10590t().getString(ProfessionalUtil.m16138b(OplusGLSurfaceView_13), ProfessionalUtil.m16135a(this.f15639h, OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15810a(int OplusGLSurfaceView_13, String str, int i2) {
        if (this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            ArrayList<String> parameterValueList = this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
            if (i2 < parameterValueList.size()) {
                SharedPreferences.Editor editorEdit = this.f15632a.mo10590t().edit();
                editorEdit.putString(str, parameterValueList.get(i2));
                editorEdit.putInt(str + "_manual", i2);
                editorEdit.apply();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15819b() {
        Map<Integer, LevelPanel> map = this.f15635d;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f15632a.mo10590t().edit();
        Iterator<Integer> it = this.f15635d.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            editorEdit.putInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", -1);
            editorEdit.putBoolean(ProfessionalUtil.m16138b(iIntValue) + "_manual_state", false);
            editorEdit.putString(ProfessionalUtil.m16138b(iIntValue), ProfessionalUtil.m16135a(this.f15639h, iIntValue));
            editorEdit.putInt(ProfessionalUtil.m16134a(iIntValue, null, "off") + "_manual", -1);
        }
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15818a(String str, String str2) {
        Map<Integer, LevelPanel> map = this.f15635d;
        if (map != null && map.size() != 0) {
            Iterator<Integer> it = this.f15635d.keySet().iterator();
            while (it.hasNext()) {
                if (!m15790a(str, str2, it.next().intValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m15790a(String str, String str2, int OplusGLSurfaceView_13) {
        SharedPreferences sharedPreferencesMo10590t = this.f15632a.mo10590t();
        int i2 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16134a(OplusGLSurfaceView_13, str, str2) + "_manual", -1);
        int i3 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual", -1);
        if (ProfessionalUtil.m16137a(OplusGLSurfaceView_13)) {
            boolean zM15836g = m15836g(OplusGLSurfaceView_13);
            if (!zM15836g || -1 == i2) {
                return zM15836g || i2 == i3;
            }
            return false;
        }
        int iIndexOf = m15824c(OplusGLSurfaceView_13).indexOf(ProfessionalUtil.m16135a(this.f15639h, OplusGLSurfaceView_13));
        if (i2 == i3) {
            return true;
        }
        return (i2 == iIndexOf && -1 == i3) || (i3 == iIndexOf && -1 == i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15822b(String str, String str2) {
        Map<Integer, LevelPanel> map = this.f15635d;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15632a.mo10590t();
        SharedPreferences.Editor editorEdit = sharedPreferencesMo10590t.edit();
        Iterator<Integer> it = this.f15635d.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int OplusGLSurfaceView_13 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", -1);
            if (ProfessionalUtil.m16137a(iIntValue) && m15836g(iIntValue)) {
                OplusGLSurfaceView_13 = -1;
            }
            editorEdit.putInt(ProfessionalUtil.m16134a(iIntValue, str, str2) + "_manual", OplusGLSurfaceView_13);
        }
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15825c(String str, String str2) {
        Map<Integer, LevelPanel> map = this.f15635d;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15632a.mo10590t();
        SharedPreferences.Editor editorEdit = sharedPreferencesMo10590t.edit();
        Iterator<Integer> it = this.f15635d.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int iIndexOf = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16134a(iIntValue, str, str2) + "_manual", -1);
            if (!ProfessionalUtil.m16137a(iIntValue) && -1 == iIndexOf) {
                iIndexOf = m15824c(iIntValue).indexOf(ProfessionalUtil.m16135a(this.f15639h, iIntValue));
            }
            if (iIndexOf >= m15824c(iIntValue).size()) {
                iIndexOf = m15824c(iIntValue).indexOf(ProfessionalUtil.m16135a(this.f15639h, iIntValue));
            }
            editorEdit.putInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", iIndexOf);
        }
        editorEdit.apply();
        Iterator<Integer> it2 = this.f15635d.keySet().iterator();
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (!ProfessionalUtil.m16137a(iIntValue2)) {
                m15817a(false, iIntValue2);
                editorEdit.putBoolean(ProfessionalUtil.m16138b(iIntValue2) + "_manual_state", false);
                editorEdit.apply();
            }
        }
        Iterator<Integer> it3 = this.f15635d.keySet().iterator();
        while (it3.hasNext()) {
            int iIntValue3 = it3.next().intValue();
            if (ProfessionalUtil.m16137a(iIntValue3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(ProfessionalUtil.m16138b(iIntValue3));
                sb.append("_manual");
                m15817a(!(-1 != sharedPreferencesMo10590t.getInt(sb.toString(), -1)), iIntValue3);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15799a(String str) {
        return this.f15632a.mo10590t().getInt(str + "_manual", -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15802a(int OplusGLSurfaceView_13, String str) {
        int iM15799a = m15799a(str);
        if (iM15799a < 0) {
            return null;
        }
        ArrayList<String> parameterNamesList = this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList();
        if (iM15799a > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(iM15799a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15786a(SubModeBarData c2908z, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("PanelContainer", "generateExposureCompensationValues, minIndex: " + OplusGLSurfaceView_13 + ", maxValue: " + i2 + ", step: " + COUIBaseListPopupWindow_12);
        if ((OplusGLSurfaceView_13 == -1 && i2 == -1) || OplusGLSurfaceView_13 > i2 || Float.compare(COUIBaseListPopupWindow_12, 0.0f) == 0) {
            CameraLog.m12967f("PanelContainer", "generateExposureCompensationValues, return, minIndex: " + OplusGLSurfaceView_13 + ", maxIndex: " + i2);
            return;
        }
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        while (OplusGLSurfaceView_13 <= i2) {
            arrayListM16145b.add(String.valueOf(OplusGLSurfaceView_13));
            arrayListM16147c.add(m15801a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12));
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15801a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float f2 = OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12;
        if (f2 <= 0.0f) {
            return String.format(Locale.US, "%.2f", Float.valueOf(f2));
        }
        return "+" + String.format(Locale.US, "%.2f", Float.valueOf(f2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15788a(SubModeBarData c2908z, List<Integer> list) {
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (list == null || list.size() <= 0) {
            CameraLog.m12967f("PanelContainer", "generateWhiteBalanceValues, return, range: " + list);
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

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m15826c() {
        Iterator<LevelPanel> it = this.f15635d.values().iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m15800a(List<Size> list) {
        long width = 0;
        for (Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        CameraLog.m12954a("PanelContainer", "getMaxPictureSize, max: " + width);
        return width;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo15729a(SubModeBarData c2908z, long OplusGLSurfaceView_15, long j2, List<Size> list) throws NumberFormatException {
        double IntrinsicsJvm.kt_5;
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (arrayListM16147c != null && arrayListM16147c.size() > 0 && arrayListM16145b != null && arrayListM16145b.size() > 0 && Math.abs(1.0f - (m15800a(list) / Long.valueOf(BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            arrayListM16147c.remove(arrayListM16147c.size() - 1);
            arrayListM16145b.remove(arrayListM16145b.size() - 1);
        }
        CameraLog.m12959b("PanelContainer", "generateShutterValues, max: " + OplusGLSurfaceView_15 + ", min: " + j2 + ", before filtering, parameterNamesList: " + arrayListM16147c);
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
        CameraLog.m12959b("PanelContainer", "generateShutterValues, after filtering, parameterValuesList: " + arrayListM16145b + ", parameterNamesList: " + arrayListM16147c);
        if (m15799a("pref_professional_exposure_time_key") >= arrayListM16145b.size()) {
            this.f15632a.mo10590t().edit().remove("pref_professional_exposure_time_key_manual").apply();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15785a(SubModeBarData c2908z, float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 < f2) {
            f2 = COUIBaseListPopupWindow_12;
            COUIBaseListPopupWindow_12 = f2;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) <= 0.0f || Float.compare(COUIBaseListPopupWindow_12, f2) == 0) {
            CameraLog.m12967f("PanelContainer", "generateFocusValues, return, minFocusDistance: " + COUIBaseListPopupWindow_12);
            return;
        }
        float f3 = (COUIBaseListPopupWindow_12 - f2) / 50.0f;
        CameraLog.m12954a("PanelContainer", "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + COUIBaseListPopupWindow_12);
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
    private void m15787a(SubModeBarData c2908z, int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 > OplusGLSurfaceView_13) {
            OplusGLSurfaceView_13 = i2;
        }
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (OplusGLSurfaceView_13 <= 0 || i3 <= 0 || OplusGLSurfaceView_13 == i3) {
            CameraLog.m12967f("PanelContainer", "generateIsoValues, return null, maxISOValue: " + OplusGLSurfaceView_13 + ", minISOValue: " + i3 + ", maxISOValue: " + OplusGLSurfaceView_13);
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SubModeBarData m15791b(List<Integer> list) {
        SubModeBarData c2908zM16148d = new SubModeBarData(this.f15639h).m16140a(R.string.camera_whitebalance_professional_title).m16143b(R.drawable.professional_mode_ic_wb).m16146c(R.id_renamed.awb_controller).m16141a("awb_mode_key").m16144b("pref_professional_whitebalance_key").m16148d(R.string.camera_whitebalance_default_value);
        m15788a(c2908zM16148d, list);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m15780a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        SubModeBarData c2908zM16148d = new SubModeBarData(this.f15639h).m16140a(R.string.camera_exposure_compensation_professional_title).m16143b(R.drawable.professional_mode_ic_ev).m16146c(R.id_renamed.exposure_controller).m16141a("iso_mode_key").m16144b("pref_professional_exposure_compensation_key").m16148d(R.string.camera_exposure_compensation_default_value);
        m15786a(c2908zM16148d, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m15781a(int OplusGLSurfaceView_13, int i2, int i3) {
        SubModeBarData c2908zM16148d = new SubModeBarData(this.f15639h).m16140a(R.string.camera_iso_professional_title).m16143b(R.drawable.professional_mode_ic_iso).m16146c(R.id_renamed.iso_controller).m16141a("exposure_mode_key").m16144b("pref_professional_iso_key").m16148d(R.string.camera_iso_default_value);
        m15787a(c2908zM16148d, OplusGLSurfaceView_13, i2, i3);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m15782a(long OplusGLSurfaceView_15, long j2, List<Size> list) throws Resources.NotFoundException, NumberFormatException {
        SubModeBarData c2908zM16153f = new SubModeBarData(this.f15639h).m16140a(R.string.camera_exposure_time_title).m16143b(R.drawable.professional_mode_ic_s).m16146c(R.id_renamed.shutter_controller).m16141a("shutter_mode_key").m16144b("pref_professional_exposure_time_key").m16148d(R.string.camera_exposure_time_default_value).m16150e(R.array.professional_exposure_time_values).m16153f(R.array.professional_exposure_time_names);
        mo15729a(c2908zM16153f, OplusGLSurfaceView_15, j2, list);
        return c2908zM16153f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SubModeBarData m15779a(float COUIBaseListPopupWindow_12, float f2) {
        SubModeBarData c2908zM16148d = new SubModeBarData(this.f15639h).m16140a(R.string.camera_focus_mode_title).m16143b(R.drawable.professional_mode_ic_af).m16146c(R.id_renamed.manual_focus_controller).m16141a("manual_focus_mode_key").m16144b("pref_professional_focus_mode_key").m16148d(R.string.camera_focus_mode_default_value);
        m15785a(c2908zM16148d, COUIBaseListPopupWindow_12, f2);
        return c2908zM16148d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15817a(boolean z, int OplusGLSurfaceView_13) {
        if (z) {
            setAuto(OplusGLSurfaceView_13);
        } else {
            setManual(OplusGLSurfaceView_13);
        }
        IntrinsicsJvm.kt_3 cVar = this.f15640i;
        if (cVar != null) {
            cVar.mo15390b(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15829d() {
        Iterator<LevelPanel> it = this.f15635d.values().iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.f15635d.clear();
        this.f15636e.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15813a(RelativeLayout.LayoutParams layoutParams, final int OplusGLSurfaceView_13, boolean z, SubModeBarData c2908z, int i2, Handler handler) {
        if (this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            CameraLog.m12967f("PanelContainer", "addControllerPanel, return, size: " + this.f15635d.size());
            return;
        }
        final LevelPanel levelPanel = new LevelPanel(this.f15639h, true, handler, z, ProfessionalUtil.m16137a(OplusGLSurfaceView_13), this.f15644m, this.f15645n, c2908z, this.f15632a.mo10590t());
        levelPanel.setLayoutParams(layoutParams);
        levelPanel.setAlign(i2);
        addView(levelPanel);
        levelPanel.setValueChangeListener(new LevelPanel.ValueChangeListener() { // from class: com.oplus.camera.professional.p.1
            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onManualValueChange(int i3) {
                if (levelPanel.getVisibility() == 0 && 1.0f == levelPanel.getAlpha()) {
                    PanelContainer.this.m15798i(i3);
                    PanelContainer c2898p = PanelContainer.this;
                    int i4 = OplusGLSurfaceView_13;
                    c2898p.m15810a(i4, ProfessionalUtil.m16138b(i4), i3);
                    PanelContainer.this.f15640i.mo15383a(OplusGLSurfaceView_13, levelPanel.mo13485a(PanelContainer.this.f15632a.mo10590t()), false);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoValueChange(int i3) {
                PanelContainer.this.f15640i.mo15383a(OplusGLSurfaceView_13, levelPanel.mo13485a(PanelContainer.this.f15632a.mo10590t()), true);
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onAutoButtonClick() {
                if (PanelContainer.this.f15643l) {
                    return;
                }
                if (PanelContainer.this.m15836g(OplusGLSurfaceView_13)) {
                    PanelContainer.this.m15817a(false, OplusGLSurfaceView_13);
                    PanelContainer.this.f15641j.mo13566a(OplusGLSurfaceView_13, MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                } else {
                    PanelContainer.this.m15817a(true, OplusGLSurfaceView_13);
                    PanelContainer.this.f15641j.mo13566a(OplusGLSurfaceView_13, "auto", true);
                }
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onBarScrolling(boolean z2) {
                if (PanelContainer.this.f15643l && !z2) {
                    PanelContainer.this.f15641j.mo13566a(OplusGLSurfaceView_13, levelPanel.mo13485a(PanelContainer.this.f15632a.mo10590t()), false);
                }
                PanelContainer.this.f15643l = z2;
            }

            @Override // com.oplus.camera.professional.LevelPanel.ValueChangeListener
            public void onActionUp() {
                if (PanelContainer.this.f15643l) {
                    return;
                }
                PanelContainer.this.f15641j.mo13566a(OplusGLSurfaceView_13, levelPanel.mo13485a(PanelContainer.this.f15632a.mo10590t()), false);
            }
        });
        this.f15635d.put(Integer.valueOf(OplusGLSurfaceView_13), levelPanel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m15798i(int OplusGLSurfaceView_13) {
        VibrateManager c2613aeMo10528ad;
        if (this.f15638g && (c2613aeMo10528ad = this.f15632a.mo10528ad()) != null) {
            if (OplusGLSurfaceView_13 % 10 == 0) {
                c2613aeMo10528ad.m11294f();
            } else {
                c2613aeMo10528ad.m11292d();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15823b(boolean z) {
        this.f15638g = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15834f(int OplusGLSurfaceView_13) {
        m15811a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15811a(int OplusGLSurfaceView_13, boolean z) {
        boolean zM15826c = m15826c();
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            setAllPopupInvisibility(aVar);
        } else {
            setAllPopupInvisibility(null);
        }
        LevelPanel levelPanel = this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13));
        Animator animatorRemove = this.f15636e.remove(levelPanel);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        levelPanel.setScaleBarTouchable(true);
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar2 = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar2.f15706a = true;
            aVar2.f15707b = 150;
            aVar2.f15708c = zM15826c ? 250 : 400;
            aVar2.f15709d = zM15826c ? 0.0f : this.f15639h.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
            aVar2.f15710e = 0.0f;
            aVar2.f15711f = zM15826c ? 0 : 150;
            aVar2.f15712g = zM15826c ? 0 : 400;
            aVar2.f15713h = 1 == this.f15644m ? "translationX" : "translationY";
            this.f15636e.put(levelPanel, ProfessionalAnimUtil.m15922a(levelPanel, aVar2));
            return;
        }
        levelPanel.setVisibility(0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m15836g(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)) == null) {
            return false;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15632a.mo10590t();
        StringBuilder sb = new StringBuilder();
        sb.append(ProfessionalUtil.m16138b(OplusGLSurfaceView_13));
        sb.append("_manual_state");
        return m15831e(OplusGLSurfaceView_13).equals(ProfessionalUtil.m16135a(this.f15639h, OplusGLSurfaceView_13)) && !sharedPreferencesMo10590t.getBoolean(sb.toString(), false);
    }

    public void setPreference(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f15632a.mo10590t().edit();
        editorEdit.putString(ProfessionalUtil.m16138b(OplusGLSurfaceView_13), ProfessionalUtil.m16135a(this.f15639h, OplusGLSurfaceView_13));
        editorEdit.putBoolean(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual_state", false);
        editorEdit.apply();
    }

    public void setPanelsBarAuto(int OplusGLSurfaceView_13) {
        m15821b(OplusGLSurfaceView_13, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15821b(int OplusGLSurfaceView_13, boolean z) {
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(z);
    }

    public void setAuto(int OplusGLSurfaceView_13) {
        setPreference(OplusGLSurfaceView_13);
        setPanelsBarAuto(OplusGLSurfaceView_13);
    }

    public void setManual(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f15632a.mo10590t().edit();
        editorEdit.putBoolean(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual_state", true);
        editorEdit.apply();
        int iM15799a = m15799a(ProfessionalUtil.m16138b(OplusGLSurfaceView_13));
        if (iM15799a >= 0) {
            m15809a(OplusGLSurfaceView_13, iM15799a, m15802a(OplusGLSurfaceView_13, ProfessionalUtil.m16138b(OplusGLSurfaceView_13)));
        } else {
            int currentIndex = this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getCurrentIndex();
            m15809a(OplusGLSurfaceView_13, currentIndex, this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList().get(currentIndex));
        }
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(false);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m15838h(int OplusGLSurfaceView_13) {
        if (m15836g(OplusGLSurfaceView_13)) {
            this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(true);
            return true;
        }
        this.f15635d.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(false);
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m15832e() {
        setAllPopupInvisibility(null);
    }

    public void setAllPopupInvisibility(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) {
        for (LevelPanel levelPanel : this.f15635d.values()) {
            Animator animatorRemove = this.f15636e.remove(levelPanel);
            if (animatorRemove != null) {
                animatorRemove.cancel();
            }
            levelPanel.setScaleBarTouchable(false);
            if (levelPanel.getVisibility() == 0 && aVar != null) {
                aVar.f15713h = 1 == this.f15644m ? "translationX" : "translationY";
                this.f15636e.put(levelPanel, ProfessionalAnimUtil.m15922a(levelPanel, aVar));
            } else {
                levelPanel.setVisibility(4);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15833f() {
        Iterator<LevelPanel> it = this.f15635d.values().iterator();
        while (it.hasNext()) {
            it.next().setValueChangeListener(null);
        }
        this.f15639h = null;
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13576a(int OplusGLSurfaceView_13) {
        return m15836g(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13582b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return (m15836g(1) && m15836g(2) && m15836g(3) && m15836g(4) && m15836g(5)) ? false : true;
        }
        if (3 == OplusGLSurfaceView_13) {
            return m15836g(1) || m15836g(2);
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m15835g() {
        return this.f15643l;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m15837h() {
        this.f15643l = false;
    }

    public PlatformImplementations.kt_3 getConfigData() {
        return this.f15642k;
    }

    /* compiled from: PanelContainer.java */
    /* renamed from: com.oplus.camera.professional.p$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f15649a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long f15650b = 0;

        public PlatformImplementations.kt_3() {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15830d(int OplusGLSurfaceView_13, int i2) {
        CameraInterface interfaceC2646a = this.f15632a;
        if (interfaceC2646a != null && !interfaceC2646a.mo10451G()) {
            this.f15632a.mo10492a(true, false);
            CameraUIInterface cameraUIInterface = this.f15633b;
            if (cameraUIInterface != null) {
                cameraUIInterface.mo18215g(0);
            }
        }
        m15832e();
        m15806a(OplusGLSurfaceView_13, i2);
    }
}
