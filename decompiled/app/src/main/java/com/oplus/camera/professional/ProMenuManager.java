package com.oplus.camera.professional;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProMenuManager.java */
/* renamed from: com.oplus.camera.professional.r */
/* loaded from: classes2.dex */
public class ProMenuManager implements ListProfessionalModeBar.OnItemClickListener {

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Activity f15654c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected CameraUIInterface f15655d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected CameraInterface f15656e;

    /* renamed from: OplusGLSurfaceView_5 */
    protected String f15662k;

    /* renamed from: r */
    private Resources f15669r;

    /* renamed from: s */
    private SharedPreferences f15670s;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15663l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15664m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f15665n = false;

    /* renamed from: o */
    private boolean f15666o = false;

    /* renamed from: p */
    private boolean f15667p = false;

    /* renamed from: q */
    private boolean f15668q = false;

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f15652a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f15653b = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected Handler f15657f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected PanelContainer f15658g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected IntrinsicsJvm.kt_4 f15659h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    protected ListProfessionalModeBar f15660i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    protected PlatformImplementations.kt_3 f15661j = null;

    /* renamed from: t */
    private PanelContainer.IntrinsicsJvm.kt_4 f15671t = new PanelContainer.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.r.3
        @Override // com.oplus.camera.professional.PanelContainer.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo13566a(int OplusGLSurfaceView_13, String str, boolean z) {
        }
    };

    /* compiled from: ProMenuManager.java */
    /* renamed from: com.oplus.camera.professional.r$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12466a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12467a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12468a(long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12469a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo12470a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo12471a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12472b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12474b(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12475b(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo12476b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        int mo12477c();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo12478c(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_5 */
        int mo12479d();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo12480d(int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo12481e();

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo12482e(int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo12483f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo12484g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        MainShutterButtonInfo mo12485h();

        /* renamed from: OplusGLSurfaceView_13 */
        boolean mo12486i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15864a(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo15716b() {
    }

    public ProMenuManager(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, String str) {
        this.f15654c = null;
        this.f15655d = null;
        this.f15656e = null;
        this.f15662k = null;
        this.f15669r = null;
        this.f15670s = null;
        this.f15654c = activity;
        this.f15655d = cameraUIInterface;
        this.f15656e = interfaceC2646a;
        this.f15669r = this.f15654c.getResources();
        this.f15670s = this.f15656e.mo10590t();
        this.f15662k = str;
        m15882f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15882f() {
        this.f15657f = new Handler();
        LevelPanel.setAutoValueMap(mo15713a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public HashMap<String, String> mo15713a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("pref_professional_iso_key", "100");
        map.put("pref_professional_exposure_time_key", "1/50s");
        map.put("pref_professional_whitebalance_key", "2000");
        map.put("pref_professional_exposure_compensation_key", "0.00");
        map.put("pref_professional_focus_mode_key", "0.00");
        return map;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15867a(CaptureResult captureResult) {
        CaptureResult.Key<int[]> key;
        int iM15853a;
        int iM15854a;
        int iM15854a2;
        int iM15854a3;
        if (this.f15658g == null) {
            return;
        }
        Integer num = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        Long OplusGLSurfaceView_14 = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        Float COUIBaseListPopupWindow_12 = (Float) captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
        if (Util.m24169C()) {
            key = CameraMetadataKey.f13254T;
        } else {
            key = CameraMetadataKey.f13295ah;
        }
        int OplusGLSurfaceView_13 = 0;
        if (key != null) {
            try {
                OplusGLSurfaceView_13 = ((int[]) captureResult.get(key))[0];
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (num != null && this.f15658g.m15836g(1) && (iM15854a3 = m15854a(num.intValue(), this.f15658g.m15824c(1))) > -1 && (!this.f15658g.m15827c(1, iM15854a3) || !this.f15665n)) {
            CameraLog.m12959b("ProMenuManager", "onPreviewCaptureResult, iso: " + num);
            LevelPanel.m15348a("pref_professional_iso_key", this.f15658g.m15828d(1).get(iM15854a3));
            this.f15658g.scrollTo(1, iM15854a3);
        }
        if (OplusGLSurfaceView_14 != null && this.f15658g.m15836g(2) && (iM15854a2 = m15854a(OplusGLSurfaceView_14.longValue(), this.f15658g.m15824c(2))) > -1 && (!this.f15658g.m15827c(2, iM15854a2) || !this.f15665n)) {
            CameraLog.m12959b("ProMenuManager", "onPreviewCaptureResult, exposureTime: " + OplusGLSurfaceView_14);
            LevelPanel.m15348a("pref_professional_exposure_time_key", this.f15658g.m15828d(2).get(iM15854a2));
            this.f15658g.scrollTo(2, iM15854a2);
        }
        if (this.f15658g.m15836g(5) && (iM15854a = m15854a(OplusGLSurfaceView_13, this.f15658g.m15824c(5))) > -1 && (!this.f15658g.m15827c(5, iM15854a) || !this.f15665n)) {
            CameraLog.m12959b("ProMenuManager", "onPreviewCaptureResult, cct: " + OplusGLSurfaceView_13);
            LevelPanel.m15348a("pref_professional_whitebalance_key", this.f15658g.m15828d(5).get(iM15854a));
            this.f15658g.scrollTo(5, iM15854a);
        }
        if (COUIBaseListPopupWindow_12 != null && this.f15658g.m15836g(4) && (iM15853a = m15853a(COUIBaseListPopupWindow_12.floatValue(), this.f15658g.m15824c(4))) > -1 && (!this.f15658g.m15827c(4, iM15853a) || !this.f15665n)) {
            CameraLog.m12959b("ProMenuManager", "onPreviewCaptureResult, focusDistance: " + COUIBaseListPopupWindow_12);
            LevelPanel.m15348a("pref_professional_focus_mode_key", this.f15658g.m15828d(4).get(iM15853a));
            this.f15658g.scrollTo(4, iM15853a);
        }
        this.f15665n = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15853a(float COUIBaseListPopupWindow_12, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = Math.abs(Float.valueOf(arrayList.get(0)).floatValue() - COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float fFloatValue = Float.valueOf(arrayList.get(i2)).floatValue() - COUIBaseListPopupWindow_12;
            if (Math.abs(fFloatValue) < fAbs) {
                fAbs = Math.abs(fFloatValue);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15854a(long OplusGLSurfaceView_15, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = Math.abs(Long.valueOf(arrayList.get(0)).longValue() - OplusGLSurfaceView_15);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long jLongValue = Long.valueOf(arrayList.get(i2)).longValue() - OplusGLSurfaceView_15;
            if (Math.abs(jLongValue) < jAbs) {
                jAbs = Math.abs(jLongValue);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m15883g() throws Resources.NotFoundException {
        m15890n();
        m15865a(8, false);
        m15888l();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15865a(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("ProMenuManager", "setVisibility, visibility: " + OplusGLSurfaceView_13);
        if (this.f15661j == null) {
            m15886j();
        }
        if (OplusGLSurfaceView_13 == 0) {
            ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        if (m15885i() && !z) {
            if (!this.f15655d.mo18201d() && !this.f15659h.mo12486i()) {
                this.f15655d.mo18068a(0, 1);
            }
            if (this.f15659h.mo12471a(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
                this.f15660i.m15381a();
                this.f15655d.mo18193d(0);
                this.f15655d.mo18175b(true, false);
            }
        }
        ListProfessionalModeBar listProfessionalModeBar2 = this.f15660i;
        if (listProfessionalModeBar2 != null) {
            listProfessionalModeBar2.m15381a();
            this.f15660i.setItemPressed(false);
            this.f15660i.setVisibility(OplusGLSurfaceView_13);
        }
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null) {
            c2898p.m15832e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m15884h() {
        PlatformImplementations.kt_3 aVar;
        ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
        return listProfessionalModeBar != null && listProfessionalModeBar.getVisibility() == 0 && (aVar = this.f15661j) != null && aVar.getVisibility() == 0;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m15885i() {
        PanelContainer c2898p = this.f15658g;
        return c2898p != null && c2898p.m15826c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15874b(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f15661j;
        if (aVar == null) {
            return;
        }
        aVar.setTouchState(z);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m15886j() throws Resources.NotFoundException {
        this.f15653b = this.f15656e.mo10543as();
        this.f15665n = false;
        m15843E();
        mo15775d();
        m15844F();
        m15863z();
        this.f15658g.setSettleListener(this.f15660i);
        this.f15658g.setMotionListener(this.f15671t);
        m15887k();
    }

    /* renamed from: y */
    private PanelContainer.PlatformImplementations.kt_3 m15862y() {
        PanelContainer.PlatformImplementations.kt_3 configData = this.f15658g.getConfigData();
        configData.f15650b = 15625000L;
        return configData;
    }

    /* renamed from: z */
    private void m15863z() throws Resources.NotFoundException {
        this.f15660i = new ListProfessionalModeBar(this.f15654c, m15893q());
        this.f15660i.setPanelInterface(this.f15658g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f15669r.getDimensionPixelSize(R.dimen.main_mode_bar_height));
        layoutParams.setMargins(0, 0, 0, this.f15669r.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        ListModeBarAdapter listModeBarAdapter = new ListModeBarAdapter(this.f15654c, this.f15658g.m15803a(false));
        listModeBarAdapter.m15371a((PanelInterface) this.f15658g);
        m15855a(this.f15660i, R.id_renamed.main_bar_id, listModeBarAdapter, this);
        this.f15661j.addView(this.f15660i, layoutParams);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m15887k() {
        if (this.f15660i.isSelected()) {
            int selectedPosition = this.f15660i.getSelectedPosition();
            this.f15660i.m15384a(selectedPosition, true);
            View childAt = this.f15660i.getChildAt(selectedPosition);
            int iM15379a = this.f15660i.m15379a(childAt);
            if (childAt != null && this.f15658g.m15836g(iM15379a)) {
                this.f15660i.getAdapter().m15367a(childAt, 0, true);
            }
        }
        this.f15658g.m15804a();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m15888l() throws Resources.NotFoundException {
        m15865a(8, false);
        m15891o();
        m15842D();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15868a(IntrinsicsJvm.kt_4 bVar) {
        this.f15659h = bVar;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo15776e() {
        this.f15667p = false;
        PlatformImplementations.kt_3 aVar = this.f15661j;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
        this.f15656e.mo10563d(true);
        m15887k();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m15889m() {
        this.f15667p = true;
        PlatformImplementations.kt_3 aVar = this.f15661j;
        if (aVar != null) {
            aVar.setTouchState(false);
        }
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null) {
            c2898p.m15837h();
        }
        this.f15655d.mo18200d(true, false);
        PanelContainer c2898p2 = this.f15658g;
        if (c2898p2 != null) {
            c2898p2.setAuto(4);
        }
        m15841C();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m15890n() throws Resources.NotFoundException {
        IntrinsicsJvm.kt_4 bVar = this.f15659h;
        if (bVar == null) {
            return;
        }
        bVar.mo12480d(0);
        m15869a(this.f15654c.getResources().getString(R.string.camera_iso_default_value));
        m15873b(this.f15654c.getResources().getString(R.string.camera_exposure_compensation_default_value));
        this.f15659h.mo12468a(Long.valueOf(this.f15654c.getResources().getString(R.string.camera_exposure_time_default_value)).longValue());
        m15840B();
        this.f15659h.mo12481e();
        this.f15659h.mo12483f();
        m15845G();
        m15839A();
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null) {
            c2898p.m15819b();
        }
    }

    /* renamed from: A */
    private void m15839A() {
        PanelContainer c2898p;
        if (this.f15660i == null || (c2898p = this.f15658g) == null) {
            return;
        }
        c2898p.setPreference(5);
    }

    /* renamed from: B */
    private void m15840B() {
        PanelContainer c2898p;
        if (this.f15660i == null || (c2898p = this.f15658g) == null) {
            return;
        }
        c2898p.setPreference(1);
        this.f15658g.setPreference(2);
    }

    /* renamed from: C */
    private void m15841C() {
        CameraLog.m12954a("ProMenuManager", "restoreFocusMode");
        IntrinsicsJvm.kt_4 bVar = this.f15659h;
        if (bVar != null) {
            bVar.mo12472b(bVar.mo12477c());
            this.f15659h.mo12482e(AEAFHelp.m11155c());
            this.f15659h.mo12483f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15869a(String str) throws Resources.NotFoundException {
        String string = this.f15654c.getResources().getString(R.string.camera_iso_default_value);
        if (str == null) {
            str = this.f15670s.getString("pref_professional_iso_key", string);
        }
        if (!this.f15670s.getString("pref_professional_iso_key", string).equals(str)) {
            SharedPreferences.Editor editorEdit = this.f15670s.edit();
            editorEdit.putString("pref_professional_iso_key", string);
            editorEdit.apply();
        }
        if (string.equals(str)) {
            this.f15659h.mo12478c(-1);
        } else {
            m15846H();
            this.f15659h.mo12474b("off");
            this.f15659h.mo12478c(Integer.valueOf(str).intValue());
        }
        CameraLog.m12954a("ProMenuManager", "setISOValue, iso: " + str);
    }

    /* renamed from: D */
    private void m15842D() {
        PlatformImplementations.kt_3 aVar = this.f15661j;
        if (aVar != null) {
            aVar.setTouchState(false);
            ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.f15661j.removeView(this.f15660i);
                this.f15660i = null;
            }
        }
        this.f15661j = null;
    }

    /* renamed from: o */
    protected void m15891o() {
        this.f15658g.scrollTo(1, 0);
        this.f15658g.scrollTo(2, 0);
        this.f15658g.scrollTo(5, 0);
        this.f15658g.scrollTo(4, 0);
    }

    /* renamed from: E */
    private void m15843E() {
        this.f15661j = new PlatformImplementations.kt_3(this.f15654c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Util.getScreenWidth());
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        if (this.f15656e != null) {
            layoutParams.bottomMargin = this.f15655d.mo18261r() - this.f15669r.getDimensionPixelSize(R.dimen.sub_mode_bar_height);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.f15661j.setLayoutParams(layoutParams);
        this.f15661j.setTouchState(true);
        this.f15661j.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.r.1
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z) {
                if (ProMenuManager.this.f15660i != null) {
                    CameraLog.m12954a("ProMenuManager", "onWindowFocusChanged, SelectedPosition: " + ProMenuManager.this.f15660i.getSelectedPosition() + ", hasFocus: " + z);
                    ProMenuManager.this.f15660i.m15384a(ProMenuManager.this.f15660i.getSelectedPosition(), true);
                }
            }
        });
        this.f15655d.mo18087a((View) this.f15661j, this.f15662k, 2, true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo15775d() {
        this.f15658g = new PanelContainer(this.f15654c, this.f15656e);
        this.f15658g.mo15728a(CameraCharacteristicsUtil.m12971a(this.f15662k, this.f15653b), this.f15657f, m15862y());
    }

    /* renamed from: F */
    private void m15844F() {
        this.f15658g.setGravity(17);
        this.f15658g.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), this.f15669r.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
        layoutParams.setMargins(0, 0, 0, this.f15669r.getDimensionPixelSize(R.dimen.main_mode_bar_height) + this.f15669r.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f15661j.addView(this.f15658g, layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15855a(ListProfessionalModeBar listProfessionalModeBar, int OplusGLSurfaceView_13, ListModeBarAdapter listModeBarAdapter, ListProfessionalModeBar.OnItemClickListener onItemClickListener) throws Resources.NotFoundException {
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setId(OplusGLSurfaceView_13);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    /* renamed from: G */
    private void m15845G() {
        PanelContainer c2898p;
        if (this.f15660i == null || (c2898p = this.f15658g) == null) {
            return;
        }
        c2898p.setPreference(4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15873b(String str) throws Resources.NotFoundException {
        String string = this.f15654c.getResources().getString(R.string.camera_exposure_compensation_default_value);
        if (str == null) {
            str = this.f15670s.getString("pref_professional_exposure_compensation_key", string);
        }
        if (!this.f15670s.getString("pref_professional_exposure_compensation_key", string).equals(str)) {
            SharedPreferences.Editor editorEdit = this.f15670s.edit();
            editorEdit.putString("pref_professional_exposure_compensation_key", string);
            editorEdit.apply();
        }
        try {
            int iIntValue = Integer.valueOf(str).intValue();
            this.f15659h.mo12482e(iIntValue);
            CameraLog.m12954a("ProMenuManager", "setExposureCompensation, evValue: " + iIntValue);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("ProMenuManager", "setExposureCompensation, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: p */
    public void m15892p() throws NumberFormatException {
        Activity activity;
        if (this.f15659h == null || (activity = this.f15654c) == null) {
            return;
        }
        String string = this.f15670s.getString("pref_professional_exposure_time_key", activity.getResources().getString(R.string.camera_exposure_time_default_value));
        long jLongValue = Long.valueOf(this.f15654c.getResources().getString(R.string.camera_exposure_time_default_value)).longValue();
        long OplusGLSurfaceView_15 = Long.parseLong(string);
        CameraLog.m12954a("ProMenuManager", "setExposureTime, exposureTimeValue: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 != jLongValue) {
            m15846H();
        }
        mo15714a(OplusGLSurfaceView_15);
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.2
            @Override // java.lang.Runnable
            public void run() {
                MainShutterButtonInfo c3200bMo12485h = ProMenuManager.this.f15659h.mo12485h();
                if (ProMenuManager.this.f15663l || ProMenuManager.this.f15656e.mo10445A()) {
                    return;
                }
                ProMenuManager.this.f15655d.mo18091a(c3200bMo12485h);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo15714a(long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 < 40000000) {
            CameraLog.m12954a("ProMenuManager", "setExposureTime, back exposureTimeValue: " + OplusGLSurfaceView_15);
            this.f15659h.mo12469a(false);
            this.f15659h.mo12468a(OplusGLSurfaceView_15);
            return;
        }
        CameraLog.m12954a("ProMenuManager", "setExposureTime, slow shutter");
        this.f15659h.mo12469a(true);
        this.f15659h.mo12468a(40000000L);
    }

    /* renamed from: H */
    private void m15846H() {
        if ("off".equals(this.f15670s.getString(CameraUIInterface.KEY_FLASH_MODE, this.f15654c.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f15670s.edit();
        editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.f15655d.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
    }

    /* compiled from: ProMenuManager.java */
    /* renamed from: com.oplus.camera.professional.r$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends RelativeLayout {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f15681b;

        public PlatformImplementations.kt_3(Context context) {
            super(context);
            this.f15681b = true;
        }

        public void setTouchState(boolean z) {
            this.f15681b = z;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!this.f15681b || ProMenuManager.this.f15656e == null || ProMenuManager.this.f15664m) {
                if (!this.f15681b) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                }
                return false;
            }
            if (ProMenuManager.this.f15656e.mo10447C()) {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                motionEventObtain2.setAction(3);
                super.dispatchTouchEvent(motionEventObtain2);
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15392a(View view, View view2, long OplusGLSurfaceView_15) {
        if (this.f15656e.mo10445A()) {
            return;
        }
        int iM15379a = this.f15660i.m15379a(view2);
        if (ListProfessionalModeBar.ModePressState.NO_PRESSED == this.f15660i.getModePressState() && this.f15660i.isSelected()) {
            mo15717c();
            return;
        }
        this.f15659h.mo12475b(false);
        this.f15656e.mo10452H();
        m15847I();
        CameraLog.m12967f("ProMenuManager", "onItemClick, index: " + iM15379a + ", id_renamed: " + OplusGLSurfaceView_15);
        this.f15655d.mo18067a(R.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.f15656e.mo10479a((AnimatorListenerAdapter) null, true, true);
        this.f15655d.mo18202e(4);
        this.f15658g.setVisibility(0);
        this.f15658g.m15834f(iM15379a);
        if (this.f15658g.m15836g(iM15379a)) {
            this.f15660i.getAdapter().m15367a(view2, 0, true);
            this.f15658g.m15821b(iM15379a, true);
        } else {
            this.f15660i.getAdapter().m15367a(view2, 8, false);
            this.f15658g.m15821b(iM15379a, false);
        }
    }

    /* renamed from: I */
    private void m15847I() {
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null) {
            c2898p.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m15848J() {
        m15845G();
        this.f15658g.setPanelsBarAuto(4);
    }

    /* renamed from: q */
    public int m15893q() {
        return this.f15656e.mo10591u();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15866a(SharedPreferences sharedPreferences, String str) throws Resources.NotFoundException, NumberFormatException {
        if ("pref_professional_whitebalance_key".equals(str)) {
            if (5 == this.f15660i.getSelectedIndex()) {
                this.f15658g.m15838h(5);
            }
            m15894r();
            return;
        }
        if ("pref_professional_iso_key".equals(str)) {
            if (this.f15660i.getSelectedIndex() == 1) {
                this.f15658g.m15838h(1);
            }
            m15869a((String) null);
            return;
        }
        if ("pref_professional_exposure_compensation_key".equals(str)) {
            if (this.f15659h.mo12476b() && !this.f15658g.m15836g(1)) {
                this.f15658g.setAuto(1);
            }
            if (this.f15659h.mo12476b() && !this.f15658g.m15836g(2)) {
                this.f15658g.setAuto(2);
            }
            m15873b((String) null);
            this.f15659h.mo12483f();
            return;
        }
        if ("pref_professional_exposure_time_key".equals(str)) {
            ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
            if (listProfessionalModeBar != null && 2 == listProfessionalModeBar.getSelectedIndex()) {
                this.f15658g.m15838h(2);
            }
            m15892p();
            return;
        }
        if ("pref_professional_focus_mode_key".equals(str)) {
            this.f15658g.m15838h(4);
            if (!this.f15658g.m15836g(4)) {
                m15877c((String) null);
                this.f15668q = true;
                return;
            }
            if (this.f15659h.mo12479d() == 0) {
                this.f15668q = false;
            }
            if (4 != this.f15659h.mo12479d() || this.f15668q) {
                this.f15659h.mo12472b(4);
                this.f15659h.mo12483f();
            }
            if (4 == this.f15659h.mo12479d() || 1 == this.f15659h.mo12479d()) {
                m15848J();
                return;
            }
            return;
        }
        if (!CameraUIInterface.KEY_FLASH_MODE.equals(str) || this.f15654c.getString(R.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.f15654c.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        m15849K();
    }

    /* renamed from: K */
    private void m15849K() {
        if ("off".equals(this.f15670s.getString(CameraUIInterface.KEY_FLASH_MODE, this.f15654c.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        String string = this.f15670s.getString("pref_professional_exposure_time_key", this.f15654c.getResources().getString(R.string.camera_exposure_time_default_value));
        String string2 = this.f15670s.getString("pref_professional_iso_key", this.f15654c.getResources().getString(R.string.camera_iso_default_value));
        if (Long.parseLong(string) != -1) {
            this.f15658g.setAuto(2);
            if (this.f15660i.isSelected()) {
                View viewM15380a = this.f15660i.m15380a(2);
                if (2 == this.f15660i.getSelectedIndex()) {
                    this.f15660i.getAdapter().m15367a(viewM15380a, 0, true);
                } else {
                    this.f15660i.getAdapter().m15367a(viewM15380a, 0, false);
                }
            }
        }
        if (this.f15654c.getResources().getString(R.string.camera_exposure_time_default_value).equals(string2)) {
            return;
        }
        this.f15658g.setAuto(1);
        if (this.f15660i.isSelected()) {
            View viewM15380a2 = this.f15660i.m15380a(1);
            if (1 == this.f15660i.getSelectedIndex()) {
                this.f15660i.getAdapter().m15367a(viewM15380a2, 0, true);
            } else {
                this.f15660i.getAdapter().m15367a(viewM15380a2, 0, false);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15877c(String str) {
        if (str == null) {
            str = this.f15670s.getString("pref_professional_focus_mode_key", "0");
        }
        CameraLog.m12954a("ProMenuManager", "setFocusValue, focusValue: " + str);
        this.f15656e.mo10527ac();
        if (this.f15656e.mo10596z()) {
            this.f15656e.mo10556b(false, false);
        }
        this.f15659h.mo12466a(Float.parseFloat(str));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo15717c() {
        CameraLog.m12954a("ProMenuManager", "onBackPressed");
        ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
        if (listProfessionalModeBar == null || !listProfessionalModeBar.isSelected()) {
            return false;
        }
        this.f15660i.m15381a();
        this.f15656e.mo10492a(true, true);
        this.f15656e.mo10563d(true);
        this.f15655d.mo18193d(0);
        this.f15655d.mo18200d(true, false);
        this.f15658g.m15832e();
        this.f15659h.mo12484g();
        return true;
    }

    /* renamed from: r */
    public void m15894r() {
        String string = this.f15670s.getString("pref_professional_whitebalance_key", this.f15654c.getResources().getString(R.string.camera_whitebalance_default_value));
        if (this.f15669r.getString(R.string.camera_whitebalance_default_value).equals(string)) {
            this.f15659h.mo12467a(-1);
        }
        if (m15871a(string, this.f15658g.m15824c(5))) {
            try {
                this.f15659h.mo12467a(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                this.f15659h.mo12481e();
            }
        } else {
            this.f15659h.mo12481e();
        }
        CameraLog.m12954a("ProMenuManager", "setWhiteBalance, whiteBalance: " + string);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15871a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15870a(MotionEvent motionEvent) {
        CameraLog.m12954a("ProMenuManager", "onSingleTapUp");
        if (m15875b(motionEvent) && this.f15660i.isSelected() && !this.f15656e.mo10445A()) {
            mo15717c();
        }
        m15858c(motionEvent);
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m15875b(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f15655d.mo18253p().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15858c(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f15655d.mo18253p().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == this.f15659h.mo12477c() || 4 == this.f15659h.mo12477c()) {
                m15848J();
            }
        }
    }

    /* renamed from: s */
    public void m15895s() {
        if (!this.f15656e.mo10445A() && !this.f15659h.mo12470a()) {
            this.f15661j.setEnabled(true);
        } else {
            this.f15652a = true;
        }
    }

    /* renamed from: t */
    public void m15896t() {
        this.f15661j.setEnabled(false);
        mo15717c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15872b(int OplusGLSurfaceView_13) {
        ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(BackgroundUtil.m24523a(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15878c(boolean z) throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("ProMenuManager", "onBeforePreview");
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.4
            @Override // java.lang.Runnable
            public void run() {
                if (ProMenuManager.this.f15660i == null || !ProMenuManager.this.f15660i.isSelected()) {
                    return;
                }
                ProMenuManager.this.f15656e.mo10479a((AnimatorListenerAdapter) null, false, false);
            }
        });
        if (this.f15666o) {
            CameraLog.m12954a("ProMenuManager", "onBeforePreview, initParamToAuto");
            m15851M();
        } else if (z) {
            m15850L();
        }
    }

    /* renamed from: L */
    private void m15850L() throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("ProMenuManager", "initParam");
        if (this.f15659h == null || this.f15658g == null) {
            return;
        }
        String strM16135a = ProfessionalUtil.m16135a(this.f15654c, 5);
        if (this.f15670s.getString("pref_professional_whitebalance_key", strM16135a).equals(strM16135a)) {
            this.f15659h.mo12481e();
        } else {
            m15894r();
        }
        m15869a((String) null);
        m15873b((String) null);
        m15892p();
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.5
            @Override // java.lang.Runnable
            public void run() {
                if (ProMenuManager.this.f15667p) {
                    return;
                }
                ProMenuManager.this.m15848J();
                ProMenuManager.this.m15852N();
            }
        });
    }

    /* renamed from: M */
    private void m15851M() {
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.6
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ProMenuManager.this.m15890n();
                ProMenuManager.this.m15852N();
            }
        });
        this.f15666o = false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15879d(boolean z) {
        this.f15666o = z;
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null) {
            c2898p.m15819b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m15852N() {
        this.f15658g.m15838h(5);
        this.f15658g.m15838h(1);
        this.f15658g.m15838h(2);
        this.f15658g.m15838h(4);
    }

    /* renamed from: u */
    public void m15897u() {
        CameraLog.m12959b("ProMenuManager", "onAfterStartPreview");
        PlatformImplementations.kt_3 aVar = this.f15661j;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo15774a(boolean z) {
        PanelContainer c2898p = this.f15658g;
        if (c2898p != null && c2898p.m15835g()) {
            CameraLog.m12962c("ProMenuManager", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.7
            @Override // java.lang.Runnable
            public void run() {
                ProMenuManager c2900r = ProMenuManager.this;
                if (c2900r.m15881d(c2900r.m15899w())) {
                    if (ProMenuManager.this.f15655d != null) {
                        ProMenuManager.this.f15655d.mo18215g(4);
                        ProMenuManager.this.f15655d.mo18209f(4);
                        ProMenuManager.this.f15655d.mo18077a(4, true);
                        ProMenuManager.this.f15655d.mo18068a(4, 1);
                        ProMenuManager.this.f15656e.mo10479a((AnimatorListenerAdapter) null, true, false);
                    }
                    Util.m24270a(ProMenuManager.this.f15661j, 4, (Animation.AnimationListener) null, 300L);
                    if (ProMenuManager.this.f15655d != null) {
                        ProMenuManager.this.f15655d.mo18221h((int) (Long.valueOf(ProMenuManager.this.m15899w()).longValue() / 1000000));
                    }
                }
                ProMenuManager.this.f15661j.setTouchState(false);
            }
        });
        return true;
    }

    /* renamed from: v */
    public boolean m15898v() {
        CameraLog.m12954a("ProMenuManager", "onAfterSnapping");
        if (this.f15656e.mo10575i() && Long.parseLong(m15899w()) >= C1547C.NANOS_PER_SECOND) {
            this.f15656e.mo10558c(4);
        }
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.r.8
            @Override // java.lang.Runnable
            public void run() {
                ProMenuManager c2900r = ProMenuManager.this;
                if (c2900r.m15881d(c2900r.m15899w())) {
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    if (ProMenuManager.this.f15655d.mo18265s() == 9) {
                        c3200b.m19226a(3);
                        c3200b.m19227a("button_color_inside_none");
                    } else {
                        c3200b.m19226a(7);
                        c3200b.m19227a("button_color_inside_none");
                    }
                    ProMenuManager.this.f15655d.mo18091a(c3200b);
                }
            }
        });
        CameraLog.m12954a("ProMenuManager", "onAfterSnapping X");
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15881d(String str) {
        return str != null && Long.valueOf(str).longValue() >= C1547C.NANOS_PER_SECOND;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15715a(byte[] bArr, boolean z, boolean z2) {
        CameraLog.m12954a("ProMenuManager", "onAfterPictureTaken");
        if (m15881d(m15899w())) {
            this.f15655d.mo18091a(new MainShutterButtonInfo(11, "button_color_inside_none"));
            if (this.f15655d.mo18265s() == 4 || this.f15655d.mo18265s() == 3 || !m15885i()) {
                this.f15655d.mo18068a(0, 1);
            }
            m15876c(0);
            Util.m24270a(this.f15661j, 0, (Animation.AnimationListener) null, 300L);
            this.f15656e.mo10492a(true, false);
        }
        this.f15655d.mo18200d(true, false);
        if (this.f15652a) {
            Util.m24270a(this.f15661j, 0, (Animation.AnimationListener) null, 300L);
            this.f15652a = false;
        }
        this.f15661j.setTouchState(true);
    }

    /* renamed from: w */
    public String m15899w() {
        return this.f15670s.getString("pref_professional_exposure_time_key", this.f15654c.getResources().getString(R.string.camera_exposure_time_default_value));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m15876c(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ProMenuManager", "setCameraMenuControlViewVisibility, visibility: " + OplusGLSurfaceView_13);
        CameraUIInterface cameraUIInterface = this.f15655d;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18215g(OplusGLSurfaceView_13);
            this.f15655d.mo18209f(OplusGLSurfaceView_13);
            this.f15655d.mo18184c(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15880d(int OplusGLSurfaceView_13) {
        PanelContainer c2898p = this.f15658g;
        return c2898p != null && c2898p.m15836g(OplusGLSurfaceView_13);
    }

    /* renamed from: x */
    public void m15900x() {
        ListProfessionalModeBar listProfessionalModeBar = this.f15660i;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.m15389b();
        }
    }
}
