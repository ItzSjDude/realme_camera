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
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.professional.HSLevelPanel;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: HSPanelContainer.java */
/* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class HSPanelContainer extends RelativeLayout implements PanelInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    protected CameraInterface f15467a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected OplusCameraCharacteristics f15468b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Map<Integer, HSLevelPanel> f15469c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Map<HSLevelPanel, Animator> f15470d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RelativeLayout.LayoutParams f15471e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f15472f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Activity f15473g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private IntrinsicsJvm.kt_3 f15474h;

    /* renamed from: OplusGLSurfaceView_13 */
    private IntrinsicsJvm.kt_4 f15475i;

    /* renamed from: OplusGLSurfaceView_15 */
    private PlatformImplementations.kt_3 f15476j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f15477k;

    /* compiled from: HSPanelContainer.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15510a(int OplusGLSurfaceView_13, String str, boolean z);
    }

    /* compiled from: HSPanelContainer.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15434a(int OplusGLSurfaceView_13, String str, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo15439b(int OplusGLSurfaceView_13, boolean z);
    }

    @Override // android.view.View
    public void clearAnimation() {
    }

    public HSPanelContainer(Context context, CameraInterface interfaceC2646a) {
        super(context);
        this.f15471e = new RelativeLayout.LayoutParams(-2, -2);
        this.f15467a = null;
        this.f15468b = null;
        this.f15469c = new HashMap();
        this.f15470d = new HashMap();
        this.f15472f = true;
        this.f15473g = null;
        this.f15474h = null;
        this.f15475i = null;
        this.f15476j = new PlatformImplementations.kt_3();
        this.f15477k = false;
        this.f15473g = (Activity) context;
        this.f15467a = interfaceC2646a;
        this.f15471e.addRule(14);
    }

    public void setSettleListener(IntrinsicsJvm.kt_3 cVar) {
        this.f15474h = cVar;
    }

    public void setMotionListener(IntrinsicsJvm.kt_4 bVar) {
        this.f15475i = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15479a(int OplusGLSurfaceView_13, int i2, int i3, Handler handler) {
        m15484a(this.f15471e, 1, false, m15452a(OplusGLSurfaceView_13, i2, i3), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15483a(long OplusGLSurfaceView_15, long j2, List<Size> list, Handler handler) {
        m15484a(this.f15471e, 2, false, m15453a(OplusGLSurfaceView_15, j2, list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15489a(List<Integer> list, Handler handler) {
        m15484a(this.f15471e, 5, false, m15463b(list), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15477a(float COUIBaseListPopupWindow_12, float f2, Handler handler) {
        m15484a(this.f15471e, 4, false, m15450a(COUIBaseListPopupWindow_12, f2), 1, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15478a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, Handler handler) {
        m15484a(this.f15471e, 3, false, m15451a(OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12), 2, handler);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15486a(OplusCameraCharacteristics c2698h, Handler handler, PlatformImplementations.kt_3 aVar) {
        m15479a(c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w(), handler);
        m15483a((aVar == null || aVar.f15481a <= 0) ? c2698h.m13289x() : aVar.f15481a, c2698h.m13290y(), c2698h.m13258a(256), handler);
        m15489a(c2698h.m13245B(), handler);
        m15477a(c2698h.m13279n(), c2698h.m13278m(), handler);
        m15478a(c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r(), handler);
        m15503e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m15454a(HSSubModeBarData c2891i) {
        return c2891i.m15712e();
    }

    public String getFocusValue() {
        if (m15507g(4)) {
            return ProfessionalUtil.m16135a(this.f15473g, 4);
        }
        return this.f15469c.get(4).m15402a(this.f15467a.mo10590t());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayList<HashMap<String, Object>> m15475a(boolean z) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        if (z) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("mainTitle", Integer.valueOf(R.drawable.professional_mode_ic_reset));
            map.put("main_item_key", " ");
            map.put("main_item_index", 0);
            map.put("main_item_animation", Integer.valueOf(R.raw.pro_reset_animation));
            arrayList.add(map);
        }
        for (Map.Entry<Integer, HSLevelPanel> entry : this.f15469c.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            HSLevelPanel value = entry.getValue();
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("mainTitle", m15454a(value.getHSSubModeBarData()));
            map2.put("main_item_key", value.m15402a(this.f15467a.mo10590t()));
            map2.put("main_item_index", Integer.valueOf(iIntValue));
            arrayList.add(map2);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15487a(OplusCameraCharacteristics c2698h, PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException, NumberFormatException {
        Map<Integer, HSLevelPanel> map = this.f15469c;
        if (map == null || map.size() == 0) {
            return;
        }
        m15469d(c2698h);
        m15465b(c2698h, aVar);
        m15468c(c2698h);
        m15464b(c2698h);
        m15455a(c2698h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15455a(OplusCameraCharacteristics c2698h) {
        if (m15500d(3).size() == 0) {
            m15458a(this.f15469c.get(3).getHSSubModeBarData(), c2698h.m13281p(), c2698h.m13282q(), c2698h.m13283r());
            this.f15469c.get(3).m15408b();
            if (this.f15474h != null) {
                this.f15474h.mo15434a(3, this.f15469c.get(3).m15402a(this.f15467a.mo10590t()), m15507g(3));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15464b(OplusCameraCharacteristics c2698h) {
        if (m15500d(4).size() == 0) {
            m15457a(this.f15469c.get(4).getHSSubModeBarData(), c2698h.m13279n(), c2698h.m13278m());
            this.f15469c.get(4).m15408b();
            if (this.f15474h != null) {
                this.f15474h.mo15434a(4, this.f15469c.get(4).m15402a(this.f15467a.mo10590t()), m15507g(4));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15468c(OplusCameraCharacteristics c2698h) {
        if (m15500d(5).size() == 0) {
            m15460a(this.f15469c.get(5).getHSSubModeBarData(), c2698h.m13245B());
            this.f15469c.get(5).m15408b();
            if (this.f15474h != null) {
                this.f15474h.mo15434a(5, this.f15469c.get(5).m15402a(this.f15467a.mo10590t()), m15507g(5));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15485a(OplusCameraCharacteristics c2698h, long OplusGLSurfaceView_15) throws Resources.NotFoundException, NumberFormatException {
        HSSubModeBarData hSSubModeBarData = this.f15469c.get(2).getHSSubModeBarData();
        hSSubModeBarData.m15708c().clear();
        hSSubModeBarData.m15705b().clear();
        hSSubModeBarData.m15709d(R.array.professional_exposure_time_values);
        hSSubModeBarData.m15711e(R.array.hs_professional_exposure_time_names);
        m15488a(hSSubModeBarData, OplusGLSurfaceView_15, c2698h.m13290y(), c2698h.m13258a(256));
        this.f15469c.get(2).m15408b();
        if (this.f15474h != null) {
            this.f15474h.mo15434a(2, this.f15469c.get(2).m15402a(this.f15467a.mo10590t()), m15507g(2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15465b(OplusCameraCharacteristics c2698h, PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException, NumberFormatException {
        HSSubModeBarData hSSubModeBarData = this.f15469c.get(2).getHSSubModeBarData();
        hSSubModeBarData.m15708c().clear();
        hSSubModeBarData.m15705b().clear();
        hSSubModeBarData.m15709d(R.array.professional_exposure_time_values);
        hSSubModeBarData.m15711e(R.array.hs_professional_exposure_time_names);
        m15488a(hSSubModeBarData, (aVar == null || aVar.f15481a <= 0) ? c2698h.m13289x() : aVar.f15481a, c2698h.m13290y(), c2698h.m13258a(256));
        this.f15469c.get(2).m15408b();
        if (this.f15474h != null) {
            this.f15474h.mo15434a(2, this.f15469c.get(2).m15402a(this.f15467a.mo10590t()), m15507g(2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m15469d(OplusCameraCharacteristics c2698h) {
        m15459a(this.f15469c.get(1).getHSSubModeBarData(), c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w());
        this.f15469c.get(1).m15408b();
        if (this.f15474h != null) {
            this.f15474h.mo15434a(1, this.f15469c.get(1).m15402a(this.f15467a.mo10590t()), m15507g(1));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> m15497c(int OplusGLSurfaceView_13) {
        return this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public ArrayList<String> m15500d(int OplusGLSurfaceView_13) {
        return this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)) != null ? this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList() : new ArrayList<>();
    }

    @Override // android.view.View
    public void scrollTo(int OplusGLSurfaceView_13, int i2) {
        this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).m15404a(i2, this.f15473g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15480a(int OplusGLSurfaceView_13, int i2, String str) {
        this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).m15405a(i2, this.f15473g, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15476a() {
        for (HSLevelPanel c2885c : this.f15469c.values()) {
            c2885c.m15409b(c2885c.m15407b(this.f15467a.mo10590t()));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15491a(int OplusGLSurfaceView_13, int i2) {
        return this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).m15406a(i2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m15502e(int OplusGLSurfaceView_13) {
        return this.f15467a.mo10590t().getString(ProfessionalUtil.m16138b(OplusGLSurfaceView_13), ProfessionalUtil.m16135a(this.f15473g, OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15481a(int OplusGLSurfaceView_13, String str, int i2) {
        if (this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            ArrayList<String> parameterValueList = this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterValueList();
            if (i2 < parameterValueList.size()) {
                SharedPreferences.Editor editorEdit = this.f15467a.mo10590t().edit();
                editorEdit.putString(str, parameterValueList.get(i2));
                editorEdit.putInt(str + "_manual", i2);
                editorEdit.apply();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15493b() {
        Map<Integer, HSLevelPanel> map = this.f15469c;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f15467a.mo10590t().edit();
        Iterator<Integer> it = this.f15469c.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            editorEdit.putInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", -1);
            editorEdit.putBoolean(ProfessionalUtil.m16138b(iIntValue) + "_manual_state", false);
            editorEdit.putString(ProfessionalUtil.m16138b(iIntValue), ProfessionalUtil.m16135a(this.f15473g, iIntValue));
            editorEdit.putInt(ProfessionalUtil.m16134a(iIntValue, null, "off") + "_manual", -1);
        }
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15492a(String str, String str2) {
        Map<Integer, HSLevelPanel> map = this.f15469c;
        if (map != null && map.size() != 0) {
            Iterator<Integer> it = this.f15469c.keySet().iterator();
            while (it.hasNext()) {
                if (!m15462a(str, str2, it.next().intValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m15462a(String str, String str2, int OplusGLSurfaceView_13) {
        SharedPreferences sharedPreferencesMo10590t = this.f15467a.mo10590t();
        int i2 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16134a(OplusGLSurfaceView_13, str, str2) + "_manual", -1);
        int i3 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual", -1);
        if (ProfessionalUtil.m16137a(OplusGLSurfaceView_13)) {
            boolean zM15507g = m15507g(OplusGLSurfaceView_13);
            if (!zM15507g || -1 == i2) {
                return zM15507g || i2 == i3;
            }
            return false;
        }
        int iIndexOf = m15497c(OplusGLSurfaceView_13).indexOf(ProfessionalUtil.m16135a(this.f15473g, OplusGLSurfaceView_13));
        if (i2 == i3) {
            return true;
        }
        return (i2 == iIndexOf && -1 == i3) || (i3 == iIndexOf && -1 == i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15495b(String str, String str2) {
        Map<Integer, HSLevelPanel> map = this.f15469c;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15467a.mo10590t();
        SharedPreferences.Editor editorEdit = sharedPreferencesMo10590t.edit();
        Iterator<Integer> it = this.f15469c.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int OplusGLSurfaceView_13 = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", -1);
            if (ProfessionalUtil.m16137a(iIntValue) && m15507g(iIntValue)) {
                OplusGLSurfaceView_13 = -1;
            }
            editorEdit.putInt(ProfessionalUtil.m16134a(iIntValue, str, str2) + "_manual", OplusGLSurfaceView_13);
        }
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15498c(String str, String str2) {
        Map<Integer, HSLevelPanel> map = this.f15469c;
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15467a.mo10590t();
        SharedPreferences.Editor editorEdit = sharedPreferencesMo10590t.edit();
        Iterator<Integer> it = this.f15469c.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            int iIndexOf = sharedPreferencesMo10590t.getInt(ProfessionalUtil.m16134a(iIntValue, str, str2) + "_manual", -1);
            if (!ProfessionalUtil.m16137a(iIntValue) && -1 == iIndexOf) {
                iIndexOf = m15497c(iIntValue).indexOf(ProfessionalUtil.m16135a(this.f15473g, iIntValue));
            }
            if (iIndexOf >= m15497c(iIntValue).size()) {
                iIndexOf = m15497c(iIntValue).indexOf(ProfessionalUtil.m16135a(this.f15473g, iIntValue));
            }
            editorEdit.putInt(ProfessionalUtil.m16138b(iIntValue) + "_manual", iIndexOf);
        }
        editorEdit.apply();
        Iterator<Integer> it2 = this.f15469c.keySet().iterator();
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (!ProfessionalUtil.m16137a(iIntValue2)) {
                m15490a(false, iIntValue2);
                editorEdit.putBoolean(ProfessionalUtil.m16138b(iIntValue2) + "_manual_state", false);
                editorEdit.apply();
            }
        }
        Iterator<Integer> it3 = this.f15469c.keySet().iterator();
        while (it3.hasNext()) {
            int iIntValue3 = it3.next().intValue();
            if (ProfessionalUtil.m16137a(iIntValue3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(ProfessionalUtil.m16138b(iIntValue3));
                sb.append("_manual");
                m15490a(!(-1 != sharedPreferencesMo10590t.getInt(sb.toString(), -1)), iIntValue3);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m15471a(String str) {
        return this.f15467a.mo10590t().getInt(str + "_manual", -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15474a(int OplusGLSurfaceView_13, String str) {
        int iM15471a = m15471a(str);
        if (iM15471a < 0) {
            return null;
        }
        ArrayList<String> parameterNamesList = this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList();
        if (iM15471a > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(iM15471a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15458a(HSSubModeBarData c2891i, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("HSPanelContainer", "generateExposureCompensationValues, minIndex: " + OplusGLSurfaceView_13 + ", maxValue: " + i2 + ", step: " + COUIBaseListPopupWindow_12);
        if ((OplusGLSurfaceView_13 == -1 && i2 == -1) || OplusGLSurfaceView_13 > i2 || Float.compare(COUIBaseListPopupWindow_12, 0.0f) == 0) {
            CameraLog.m12967f("HSPanelContainer", "generateExposureCompensationValues, return, minIndex: " + OplusGLSurfaceView_13 + ", maxIndex: " + i2);
            return;
        }
        ArrayList<String> arrayListM15705b = c2891i.m15705b();
        ArrayList<String> arrayListM15708c = c2891i.m15708c();
        arrayListM15705b.clear();
        arrayListM15708c.clear();
        while (OplusGLSurfaceView_13 <= i2) {
            arrayListM15705b.add(String.valueOf(OplusGLSurfaceView_13));
            arrayListM15708c.add(m15473a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12));
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15473a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float f2 = OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12;
        if (f2 <= 0.0f) {
            return String.format(Locale.US, "%.2f", Float.valueOf(f2));
        }
        return "+" + String.format(Locale.US, "%.2f", Float.valueOf(f2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15460a(HSSubModeBarData c2891i, List<Integer> list) {
        ArrayList<String> arrayListM15705b = c2891i.m15705b();
        ArrayList<String> arrayListM15708c = c2891i.m15708c();
        if (list == null || list.size() <= 0) {
            CameraLog.m12967f("HSPanelContainer", "generateWhiteBalanceValues, return, range: " + list);
            return;
        }
        arrayListM15705b.clear();
        arrayListM15708c.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            int iIntValue = list.get(OplusGLSurfaceView_13).intValue();
            arrayListM15705b.add(Integer.toString(iIntValue));
            arrayListM15708c.add(Integer.toString(iIntValue));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m15499c() {
        Iterator<HSLevelPanel> it = this.f15469c.values().iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m15472a(List<Size> list) {
        long width = 0;
        for (Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        CameraLog.m12954a("HSPanelContainer", "getMaxPictureSize, max: " + width);
        return width;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m15488a(HSSubModeBarData c2891i, long OplusGLSurfaceView_15, long j2, List<Size> list) throws NumberFormatException {
        double IntrinsicsJvm.kt_5;
        double d2;
        ArrayList<String> arrayListM15705b = c2891i.m15705b();
        ArrayList<String> arrayListM15708c = c2891i.m15708c();
        if (arrayListM15708c != null && arrayListM15708c.size() > 0 && arrayListM15705b != null && arrayListM15705b.size() > 0 && Math.abs(1.0f - (m15472a(list) / Long.valueOf(BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            arrayListM15708c.remove(arrayListM15708c.size() - 1);
            arrayListM15705b.remove(arrayListM15705b.size() - 1);
        }
        CameraLog.m12959b("HSPanelContainer", "generateShutterValues, max: " + OplusGLSurfaceView_15 + ", min: " + j2 + ", before filtering, parameterNamesList: " + arrayListM15708c);
        if (arrayListM15708c == null || arrayListM15705b == null) {
            return;
        }
        Iterator<String> it = arrayListM15708c.iterator();
        long j3 = -1;
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split("/");
            if (strArrSplit.length > 1) {
                d2 = Double.parseDouble(strArrSplit[0]) / Double.parseDouble(strArrSplit[1].split("s")[0]);
                IntrinsicsJvm.kt_5 = 1.0E9d;
            } else {
                IntrinsicsJvm.kt_5 = 1.0E9d;
                if (strArrSplit.length == 1) {
                    d2 = Double.parseDouble(strArrSplit[0].split("s")[0]);
                }
                if (j3 >= j2 || j3 > OplusGLSurfaceView_15) {
                    it.remove();
                } else {
                    arrayListM15705b.add(String.valueOf(j3));
                }
            }
            j3 = (long) (d2 * IntrinsicsJvm.kt_5);
            if (j3 >= j2) {
            }
            it.remove();
        }
        long j4 = Long.parseLong(arrayListM15705b.get(arrayListM15705b.size() - 1)) / C1547C.NANOS_PER_SECOND;
        long j5 = OplusGLSurfaceView_15 / C1547C.NANOS_PER_SECOND;
        if (j4 < j5) {
            arrayListM15705b.add(String.valueOf(OplusGLSurfaceView_15));
            arrayListM15708c.add(j5 + "");
        }
        CameraLog.m12959b("HSPanelContainer", "generateShutterValues, after filtering, parameterValuesList: " + arrayListM15705b + ", parameterNamesList: " + arrayListM15708c);
        if (m15471a("pref_professional_exposure_time_key") >= arrayListM15705b.size()) {
            this.f15467a.mo10590t().edit().remove("pref_professional_exposure_time_key_manual").apply();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15457a(HSSubModeBarData c2891i, float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 < f2) {
            f2 = COUIBaseListPopupWindow_12;
            COUIBaseListPopupWindow_12 = f2;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) <= 0.0f || Float.compare(COUIBaseListPopupWindow_12, f2) == 0) {
            CameraLog.m12967f("HSPanelContainer", "generateFocusValues, return, minFocusDistance: " + COUIBaseListPopupWindow_12);
            return;
        }
        float f3 = (COUIBaseListPopupWindow_12 - f2) / 50.0f;
        CameraLog.m12954a("HSPanelContainer", "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + COUIBaseListPopupWindow_12);
        ArrayList<String> arrayListM15705b = c2891i.m15705b();
        ArrayList<String> arrayListM15708c = c2891i.m15708c();
        arrayListM15705b.clear();
        arrayListM15708c.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 50; OplusGLSurfaceView_13++) {
            float f4 = OplusGLSurfaceView_13;
            arrayListM15705b.add(Float.toString(COUIBaseListPopupWindow_12 - (f3 * f4)));
            arrayListM15708c.add(String.format(Locale.US, "%.2f", Float.valueOf(f4 * 0.02f)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15459a(HSSubModeBarData c2891i, int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 > OplusGLSurfaceView_13) {
            OplusGLSurfaceView_13 = i2;
        }
        ArrayList<String> arrayListM15705b = c2891i.m15705b();
        ArrayList<String> arrayListM15708c = c2891i.m15708c();
        if (OplusGLSurfaceView_13 <= 0 || i3 <= 0 || OplusGLSurfaceView_13 == i3) {
            CameraLog.m12967f("HSPanelContainer", "generateIsoValues, return null, maxISOValue: " + OplusGLSurfaceView_13 + ", minISOValue: " + i3 + ", maxISOValue: " + OplusGLSurfaceView_13);
            return;
        }
        arrayListM15705b.clear();
        arrayListM15708c.clear();
        while (i3 <= OplusGLSurfaceView_13) {
            arrayListM15705b.add(Integer.toString(i3));
            arrayListM15708c.add(Integer.toString(i3));
            i3 += 100;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HSSubModeBarData m15463b(List<Integer> list) {
        HSSubModeBarData c2891iM15706c = new HSSubModeBarData(this.f15473g).m15700a(R.string.camera_whitebalance_professional_title).m15701a("WB").m15703b(R.id_renamed.awb_controller).m15704b("awb_mode_key").m15707c("pref_professional_whitebalance_key").m15706c(R.string.camera_whitebalance_default_value);
        m15460a(c2891iM15706c, list);
        return c2891iM15706c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HSSubModeBarData m15451a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        HSSubModeBarData c2891iM15706c = new HSSubModeBarData(this.f15473g).m15700a(R.string.camera_exposure_compensation_professional_title).m15701a("EV").m15703b(R.id_renamed.exposure_controller).m15704b("iso_mode_key").m15707c("pref_professional_exposure_compensation_key").m15706c(R.string.camera_exposure_compensation_default_value);
        m15458a(c2891iM15706c, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12);
        return c2891iM15706c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HSSubModeBarData m15452a(int OplusGLSurfaceView_13, int i2, int i3) {
        HSSubModeBarData c2891iM15706c = new HSSubModeBarData(this.f15473g).m15700a(R.string.camera_iso_professional_title).m15701a("ISO").m15703b(R.id_renamed.iso_controller).m15704b("exposure_mode_key").m15707c("pref_professional_iso_key").m15706c(R.string.camera_iso_default_value);
        m15459a(c2891iM15706c, OplusGLSurfaceView_13, i2, i3);
        return c2891iM15706c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HSSubModeBarData m15453a(long OplusGLSurfaceView_15, long j2, List<Size> list) throws Resources.NotFoundException, NumberFormatException {
        HSSubModeBarData c2891iM15711e = new HSSubModeBarData(this.f15473g).m15700a(R.string.camera_exposure_time_title).m15701a("Shutter").m15703b(R.id_renamed.shutter_controller).m15704b("shutter_mode_key").m15707c("pref_professional_exposure_time_key").m15706c(R.string.camera_exposure_time_default_value).m15709d(R.array.professional_exposure_time_values).m15711e(R.array.hs_professional_exposure_time_names);
        m15488a(c2891iM15711e, OplusGLSurfaceView_15, j2, list);
        return c2891iM15711e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private HSSubModeBarData m15450a(float COUIBaseListPopupWindow_12, float f2) {
        HSSubModeBarData c2891iM15706c = new HSSubModeBarData(this.f15473g).m15700a(R.string.camera_focus_mode_title).m15701a("Focus").m15703b(R.id_renamed.manual_focus_controller).m15704b("manual_focus_mode_key").m15707c("pref_professional_focus_mode_key").m15706c(R.string.camera_focus_mode_default_value);
        m15457a(c2891iM15706c, COUIBaseListPopupWindow_12, f2);
        return c2891iM15706c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15490a(boolean z, int OplusGLSurfaceView_13) {
        if (z) {
            setAuto(OplusGLSurfaceView_13);
        } else {
            setManual(OplusGLSurfaceView_13);
        }
        IntrinsicsJvm.kt_3 cVar = this.f15474h;
        if (cVar != null) {
            cVar.mo15439b(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15501d() {
        Iterator<HSLevelPanel> it = this.f15469c.values().iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.f15469c.clear();
        this.f15470d.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15484a(RelativeLayout.LayoutParams layoutParams, final int OplusGLSurfaceView_13, boolean z, HSSubModeBarData c2891i, int i2, Handler handler) {
        if (this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            CameraLog.m12967f("HSPanelContainer", "addControllerPanel, return, size: " + this.f15469c.size());
            return;
        }
        final HSLevelPanel c2885c = new HSLevelPanel(this.f15473g, true, handler, z, ProfessionalUtil.m16137a(OplusGLSurfaceView_13), c2891i, this.f15467a.mo10590t());
        c2885c.setLayoutParams(layoutParams);
        c2885c.setAlign(i2);
        addView(c2885c);
        c2885c.setValueChangeListener(new HSLevelPanel.PlatformImplementations.kt_3() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_11.1
            @Override // com.oplus.camera.professional.HSLevelPanel.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15411a(int i3) {
                if (c2885c.getVisibility() == 0 && 1.0f == c2885c.getAlpha()) {
                    HSPanelContainer.this.m15470i(i3);
                    HSPanelContainer c2889g = HSPanelContainer.this;
                    int i4 = OplusGLSurfaceView_13;
                    c2889g.m15481a(i4, ProfessionalUtil.m16138b(i4), i3);
                    HSPanelContainer.this.f15474h.mo15434a(OplusGLSurfaceView_13, c2885c.m15402a(HSPanelContainer.this.f15467a.mo10590t()), false);
                }
            }

            @Override // com.oplus.camera.professional.HSLevelPanel.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo15414b(int i3) {
                HSPanelContainer.this.f15474h.mo15434a(OplusGLSurfaceView_13, c2885c.m15402a(HSPanelContainer.this.f15467a.mo10590t()), true);
            }

            @Override // com.oplus.camera.professional.HSLevelPanel.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15410a() {
                if (HSPanelContainer.this.f15477k) {
                    return;
                }
                if (HSPanelContainer.this.m15507g(OplusGLSurfaceView_13)) {
                    HSPanelContainer.this.m15490a(false, OplusGLSurfaceView_13);
                    HSPanelContainer.this.f15475i.mo15510a(OplusGLSurfaceView_13, MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                } else {
                    HSPanelContainer.this.m15490a(true, OplusGLSurfaceView_13);
                    HSPanelContainer.this.f15475i.mo15510a(OplusGLSurfaceView_13, "auto", true);
                }
            }

            @Override // com.oplus.camera.professional.HSLevelPanel.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15412a(boolean z2) {
                if (HSPanelContainer.this.f15477k && !z2) {
                    HSPanelContainer.this.f15475i.mo15510a(OplusGLSurfaceView_13, c2885c.m15402a(HSPanelContainer.this.f15467a.mo10590t()), false);
                }
                HSPanelContainer.this.f15477k = z2;
            }

            @Override // com.oplus.camera.professional.HSLevelPanel.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo15413b() {
                if (HSPanelContainer.this.f15477k) {
                    return;
                }
                HSPanelContainer.this.f15475i.mo15510a(OplusGLSurfaceView_13, c2885c.m15402a(HSPanelContainer.this.f15467a.mo10590t()), false);
            }
        });
        this.f15469c.put(Integer.valueOf(OplusGLSurfaceView_13), c2885c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m15470i(int OplusGLSurfaceView_13) {
        VibrateManager c2613aeMo10528ad;
        if (this.f15472f && (c2613aeMo10528ad = this.f15467a.mo10528ad()) != null) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                c2613aeMo10528ad.m11293e();
            } else if (OplusGLSurfaceView_13 % 10 == 0) {
                c2613aeMo10528ad.m11294f();
            } else {
                c2613aeMo10528ad.m11292d();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15496b(boolean z) {
        this.f15472f = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15505f(int OplusGLSurfaceView_13) {
        m15482a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15482a(int OplusGLSurfaceView_13, boolean z) {
        boolean zM15499c = m15499c();
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            setAllPopupInvisibility(aVar);
        } else {
            setAllPopupInvisibility(null);
        }
        HSLevelPanel c2885c = this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13));
        Animator animatorRemove = this.f15470d.remove(c2885c);
        if (animatorRemove != null) {
            animatorRemove.cancel();
        }
        if (z) {
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar2 = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar2.f15706a = true;
            aVar2.f15707b = 150;
            aVar2.f15708c = zM15499c ? 250 : 400;
            aVar2.f15709d = zM15499c ? 0.0f : this.f15473g.getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_animation_offset);
            aVar2.f15710e = 0.0f;
            aVar2.f15711f = zM15499c ? 0 : 150;
            aVar2.f15712g = zM15499c ? 0 : 400;
            this.f15470d.put(c2885c, ProfessionalAnimUtil.m15922a(c2885c, aVar2));
            return;
        }
        c2885c.setVisibility(0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m15507g(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)) == null) {
            return false;
        }
        SharedPreferences sharedPreferencesMo10590t = this.f15467a.mo10590t();
        StringBuilder sb = new StringBuilder();
        sb.append(ProfessionalUtil.m16138b(OplusGLSurfaceView_13));
        sb.append("_manual_state");
        return m15502e(OplusGLSurfaceView_13).equals(ProfessionalUtil.m16135a(this.f15473g, OplusGLSurfaceView_13)) && !sharedPreferencesMo10590t.getBoolean(sb.toString(), false);
    }

    public void setPreference(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f15467a.mo10590t().edit();
        editorEdit.putString(ProfessionalUtil.m16138b(OplusGLSurfaceView_13), ProfessionalUtil.m16135a(this.f15473g, OplusGLSurfaceView_13));
        editorEdit.putBoolean(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual_state", false);
        editorEdit.apply();
    }

    public void setPanelsBarAuto(int OplusGLSurfaceView_13) {
        m15494b(OplusGLSurfaceView_13, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15494b(int OplusGLSurfaceView_13, boolean z) {
        this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(z);
    }

    public void setAuto(int OplusGLSurfaceView_13) {
        setPreference(OplusGLSurfaceView_13);
        setPanelsBarAuto(OplusGLSurfaceView_13);
    }

    public void setManual(int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = this.f15467a.mo10590t().edit();
        editorEdit.putBoolean(ProfessionalUtil.m16138b(OplusGLSurfaceView_13) + "_manual_state", true);
        editorEdit.apply();
        int iM15471a = m15471a(ProfessionalUtil.m16138b(OplusGLSurfaceView_13));
        if (iM15471a >= 0) {
            m15480a(OplusGLSurfaceView_13, iM15471a, m15474a(OplusGLSurfaceView_13, ProfessionalUtil.m16138b(OplusGLSurfaceView_13)));
        } else {
            int currentIndex = this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getCurrentIndex();
            m15480a(OplusGLSurfaceView_13, currentIndex, this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).getParameterNamesList().get(currentIndex));
        }
        this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(false);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m15509h(int OplusGLSurfaceView_13) {
        if (m15507g(OplusGLSurfaceView_13)) {
            this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(true);
            return true;
        }
        this.f15469c.get(Integer.valueOf(OplusGLSurfaceView_13)).setBarAuto(false);
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m15503e() {
        setAllPopupInvisibility(null);
    }

    public void setAllPopupInvisibility(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) {
        for (HSLevelPanel c2885c : this.f15469c.values()) {
            Animator animatorRemove = this.f15470d.remove(c2885c);
            if (animatorRemove != null) {
                animatorRemove.cancel();
            }
            if (c2885c.getVisibility() == 0 && aVar != null) {
                this.f15470d.put(c2885c, ProfessionalAnimUtil.m15922a(c2885c, aVar));
            } else {
                c2885c.setVisibility(4);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15504f() {
        Iterator<HSLevelPanel> it = this.f15469c.values().iterator();
        while (it.hasNext()) {
            it.next().setValueChangeListener(null);
        }
        this.f15473g = null;
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13576a(int OplusGLSurfaceView_13) {
        return m15507g(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13582b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return (m15507g(1) && m15507g(2) && m15507g(3) && m15507g(4) && m15507g(5)) ? false : true;
        }
        if (3 == OplusGLSurfaceView_13) {
            return m15507g(1) || m15507g(2);
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m15506g() {
        return this.f15477k;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m15508h() {
        this.f15477k = false;
    }

    public PlatformImplementations.kt_3 getConfigData() {
        return this.f15476j;
    }

    /* compiled from: HSPanelContainer.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f15481a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long f15482b = 0;

        public PlatformImplementations.kt_3() {
        }
    }
}
