package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.filmvideomode.FilmSlideBarContainer;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.professional.ProfessionalUtil;
import com.oplus.camera.professional.PanelInterface;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: FilmParamsContainer.java */
/* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class FilmParamsContainer extends RelativeLayout implements FilmSlideBarContainer.PlatformImplementations.kt_3, PanelContainer.IntrinsicsJvm.kt_4, PanelInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f13673a = "OplusGLSurfaceView_5";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f13674b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OplusCameraCharacteristics f13675c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private FilmModeBarRecyclerView f13676d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FilmModeBarAdapter f13677e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private FilmSlideBarContainer f13678f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f13679g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraInterface f13680h;

    /* renamed from: OplusGLSurfaceView_13 */
    private IntrinsicsJvm.kt_4 f13681i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Activity f13682j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_3 f13683k;

    /* renamed from: OplusGLSurfaceView_14 */
    private PlatformImplementations.kt_3 f13684l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f13685m;

    /* compiled from: FilmParamsContainer.java */
    /* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo13435e(boolean z);
    }

    /* compiled from: FilmParamsContainer.java */
    /* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13407a(int OplusGLSurfaceView_13, String str, boolean z);
    }

    /* compiled from: FilmParamsContainer.java */
    /* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13406a(int OplusGLSurfaceView_13);
    }

    /* compiled from: FilmParamsContainer.java */
    /* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13411a(View view, View view2, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo13412a(View view, View view2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo13424a(View view);
    }

    public FilmParamsContainer(Activity activity, CameraInterface interfaceC2646a, IntrinsicsJvm.kt_4 bVar, OplusCameraCharacteristics c2698h) {
        super(activity);
        this.f13674b = null;
        this.f13675c = null;
        this.f13676d = null;
        this.f13677e = null;
        this.f13678f = null;
        this.f13679g = false;
        this.f13680h = null;
        this.f13681i = null;
        this.f13682j = null;
        this.f13683k = null;
        this.f13684l = null;
        this.f13685m = false;
        this.f13682j = activity;
        this.f13680h = interfaceC2646a;
        this.f13675c = c2698h;
        this.f13674b = interfaceC2646a.mo10590t();
        this.f13681i = bVar;
        LevelPanel.m15353c();
        m13562k();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m13562k() {
        RelativeLayout.LayoutParams layoutParams;
        this.f13678f = new FilmSlideBarContainer(getContext(), this.f13680h);
        this.f13678f.m13629a(this.f13675c, new Handler(Looper.getMainLooper()));
        this.f13678f.setMotionListener(this);
        this.f13678f.setValueListener(this);
        this.f13678f.setId(R.id_renamed.movie_slide_bar_id);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height));
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(Util.m24498u() ? R.dimen.movie_mode_params_item_height_rack : R.dimen.movie_mode_params_item_height);
        layoutParams2.addRule(12);
        this.f13676d = new FilmModeBarRecyclerView(getContext());
        this.f13676d.setClipChildren(false);
        this.f13676d.setClipToPadding(false);
        this.f13677e = new FilmModeBarAdapter((Activity) getContext(), this.f13676d, getItemData());
        this.f13676d.setAdapter(this.f13677e);
        this.f13677e.m13538a((PanelInterface) this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f13676d.setLayoutManager(linearLayoutManager);
        this.f13676d.setHasFixedSize(true);
        linearLayoutManager.setStackFromEnd(true);
        if (Util.m24498u()) {
            layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_height_rack));
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMarginStart(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_height));
            layoutParams3.addRule(12);
            layoutParams3.addRule(15);
            layoutParams3.setMarginStart(getResources().getDimensionPixelOffset(R.dimen.movie_mode_params_mode_bar_margin_start));
            layoutParams = layoutParams3;
        }
        addView(this.f13676d, layoutParams);
        this.f13676d.setHorizontalFadingEdgeEnabled(true);
        addView(this.f13678f, layoutParams2);
    }

    public void setFilmParamsStateChangeListener(PlatformImplementations.kt_3 aVar) {
        this.f13684l = aVar;
        this.f13678f.setParamsStateListener(aVar);
    }

    public void setParamsBarEnable(final boolean z) {
        if (this.f13676d != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f13676d.setEnabled(z);
            } else {
                this.f13676d.post(new Runnable() { // from class: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FilmParamsContainer.this.f13676d.setEnabled(z);
                    }
                });
            }
        }
    }

    public void setAFEnable(boolean z) {
        this.f13685m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13567a(final int OplusGLSurfaceView_13, final boolean z) {
        this.f13685m = z;
        Activity activity = this.f13682j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.OplusGLSurfaceView_5.2
            @Override // java.lang.Runnable
            public void run() {
                FilmModeItemBarData c2715jM13530a = FilmParamsContainer.this.f13677e.m13530a(OplusGLSurfaceView_13);
                if (c2715jM13530a != null) {
                    c2715jM13530a.m13553c(z);
                }
                FilmParamsContainer.this.m13583c(OplusGLSurfaceView_13);
                if (z || FilmParamsContainer.this.f13678f.getVisibilityPanelIndex() != OplusGLSurfaceView_13) {
                    return;
                }
                FilmParamsContainer.this.f13678f.m13625a(OplusGLSurfaceView_13, true);
                FilmParamsContainer.this.m13586d();
                FilmParamsContainer.this.m13574a(false);
                if (FilmParamsContainer.this.f13684l != null) {
                    FilmParamsContainer.this.f13684l.mo13435e(false);
                }
            }
        });
    }

    public void setSlideSelected(int OplusGLSurfaceView_13) {
        this.f13678f.m13625a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13574a(boolean z) {
        FilmSlideBarContainer c2717l = this.f13678f;
        if (c2717l == null || 8 == c2717l.getVisibility()) {
            return;
        }
        PlatformImplementations.kt_3 aVar = this.f13684l;
        if (aVar != null) {
            aVar.mo13435e(false);
        }
        ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar2 = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
        aVar2.f15706a = false;
        aVar2.f15708c = 250;
        aVar2.f15712g = 400;
        aVar2.f15709d = 0.0f;
        aVar2.f15710e = getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
        this.f13678f.setAllPopupInvisibility(aVar2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13575a() {
        return this.f13679g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13581b(boolean z) {
        m13574a(z);
        FilmModeBarRecyclerView c2714i = this.f13676d;
        if (c2714i != null) {
            FilmAnimatorUtil.m13480b(this, c2714i);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13578b() {
        setVisibility(0);
        FilmModeBarRecyclerView c2714i = this.f13676d;
        if (c2714i != null) {
            FilmAnimatorUtil.m13472a(this, c2714i);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13585c() {
        return getVisibility() == 0;
    }

    public void setOnItemClickListener(IntrinsicsJvm.kt_5 dVar) {
        FilmModeBarRecyclerView c2714i = this.f13676d;
        if (c2714i != null) {
            c2714i.setOnItemClickListener(dVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13586d() {
        FilmModeBarAdapter c2713h = this.f13677e;
        if (c2713h != null) {
            c2713h.m13531a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13587e() {
        FilmModeBarAdapter c2713h = this.f13677e;
        if (c2713h != null) {
            c2713h.notifyDataSetChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13569a(View view, View view2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (view2 == null || !view2.isEnabled()) {
            return;
        }
        this.f13678f.m13625a((int) OplusGLSurfaceView_15, true);
    }

    public int getModeBarCount() {
        FilmModeBarAdapter c2713h = this.f13677e;
        if (c2713h != null) {
            return c2713h.getItemCount();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13572a(Integer num) {
        int iM16132a;
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(1);
        ArrayList<String> arrayListM13634b = this.f13678f.m13634b(1);
        ArrayList<String> arrayListM13637c = this.f13678f.m13637c(1);
        if (num == null || c2715jM13530a == null || arrayListM13634b == null || arrayListM13637c == null || !this.f13678f.m13642e(1) || (iM16132a = ProfessionalUtil.m16132a(num.intValue(), arrayListM13634b)) < 0 || iM16132a >= arrayListM13634b.size() || arrayListM13637c.size() <= iM16132a) {
            return;
        }
        String str = arrayListM13637c.get(iM16132a);
        LevelPanel.m15348a(CameraUIInterface.KEY_FILM_MODE_ISO, str);
        this.f13678f.scrollTo(1, iM16132a);
        c2715jM13530a.m13547a(str);
        this.f13676d.m13542a(1, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13573a(Long OplusGLSurfaceView_14) {
        int iM16133a;
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(2);
        ArrayList<String> arrayListM13634b = this.f13678f.m13634b(2);
        ArrayList<String> arrayListM13637c = this.f13678f.m13637c(2);
        if (OplusGLSurfaceView_14 == null || c2715jM13530a == null || arrayListM13634b == null || arrayListM13637c == null || !this.f13678f.m13642e(2) || (iM16133a = ProfessionalUtil.m16133a(OplusGLSurfaceView_14.longValue(), arrayListM13634b)) < 0 || iM16133a >= arrayListM13634b.size() || arrayListM13637c.size() <= iM16133a) {
            return;
        }
        String str = arrayListM13637c.get(iM16133a);
        LevelPanel.m15348a(CameraUIInterface.KEY_FILM_MODE_SHUTTER, str);
        this.f13678f.scrollTo(2, iM16133a);
        c2715jM13530a.m13547a(str);
        this.f13676d.m13542a(2, str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13580b(Integer num) {
        int iM16132a;
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(5);
        ArrayList<String> arrayListM13634b = this.f13678f.m13634b(5);
        ArrayList<String> arrayListM13637c = this.f13678f.m13637c(5);
        if (num == null || c2715jM13530a == null || arrayListM13634b == null || arrayListM13637c == null || !this.f13678f.m13642e(5) || (iM16132a = ProfessionalUtil.m16132a(num.intValue(), arrayListM13634b)) < 0 || iM16132a >= arrayListM13634b.size() || arrayListM13637c.size() <= iM16132a) {
            return;
        }
        String str = arrayListM13637c.get(iM16132a);
        LevelPanel.m15348a(CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, str);
        this.f13678f.scrollTo(5, iM16132a);
        c2715jM13530a.m13547a(str);
        this.f13676d.m13542a(5, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13571a(Float COUIBaseListPopupWindow_12) {
        int iM16131a;
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(4);
        ArrayList<String> arrayListM13634b = this.f13678f.m13634b(4);
        ArrayList<String> arrayListM13637c = this.f13678f.m13637c(4);
        if (COUIBaseListPopupWindow_12 == null || c2715jM13530a == null || arrayListM13634b == null || arrayListM13637c == null || !this.f13678f.m13642e(4) || (iM16131a = ProfessionalUtil.m16131a(COUIBaseListPopupWindow_12.floatValue(), arrayListM13634b)) < 0 || iM16131a >= arrayListM13634b.size() || arrayListM13637c == null || arrayListM13637c.size() <= iM16131a) {
            return;
        }
        String str = arrayListM13637c.get(iM16131a);
        LevelPanel.m15348a(CameraUIInterface.KEY_FILM_MODE_FOCUS, str);
        this.f13678f.scrollTo(4, iM16131a);
        c2715jM13530a.m13547a(str);
        this.f13676d.m13542a(4, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13570a(OplusCameraCharacteristics c2698h) {
        this.f13678f.m13628a(c2698h);
        m13588f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m13588f() {
        this.f13678f.m13640d();
    }

    private List<FilmModeItemBarData> getItemData() {
        if (this.f13680h == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, FilmLevelPanel> entry : this.f13678f.getPanelMap().entrySet()) {
            int iIntValue = entry.getKey().intValue();
            FilmLevelPanel value = entry.getValue();
            arrayList.add(new FilmModeItemBarData().m13552c(iIntValue).m13546a(value.getSubModeBarData().m16152f()).m13547a(value.mo13485a(this.f13674b)));
        }
        if (!Util.m24498u()) {
            Collections.reverse(arrayList);
        }
        arrayList.add(Util.m24498u() ? 0 : arrayList.size(), new FilmModeItemBarData().m13546a(R.drawable.professional_mode_ic_reset).m13547a(getResources().getString(R.string.camera_face_beauty_menu_reset)).m13552c(0).m13550b(R.raw.pro_reset_animation));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13564a(int OplusGLSurfaceView_13, String str, String str2) {
        if (this.f13678f == null) {
            return "";
        }
        if ("auto".equals(str) && !"0".equals(str2)) {
            return str2;
        }
        String strM13643f = this.f13678f.m13643f(OplusGLSurfaceView_13);
        return TextUtils.isEmpty(strM13643f) ? str2 : strM13643f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m13577b(int OplusGLSurfaceView_13, String str, String str2) {
        if (this.f13678f == null) {
            return "";
        }
        if ("auto".equals(str) && !"0".equals(str2)) {
            return str2;
        }
        String strM13645g = this.f13678f.m13645g(OplusGLSurfaceView_13);
        return TextUtils.isEmpty(strM13645g) ? str2 : strM13645g.replace("+", "");
    }

    @Override // com.oplus.camera.filmvideomode.FilmSlideBarContainer.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13565a(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f13676d.m13543a(OplusGLSurfaceView_13, this.f13678f.m13643f(OplusGLSurfaceView_13), z);
        IntrinsicsJvm.kt_4 bVar = this.f13681i;
        if (bVar == null || z) {
            return;
        }
        bVar.mo13407a(OplusGLSurfaceView_13, this.f13678f.m13618a(OplusGLSurfaceView_13, i2), z);
    }

    @Override // com.oplus.camera.filmvideomode.FilmSlideBarContainer.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13579b(int OplusGLSurfaceView_13, boolean z) {
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(OplusGLSurfaceView_13);
        if (c2715jM13530a != null) {
            c2715jM13530a.m13548a(z);
        }
        IntrinsicsJvm.kt_4 bVar = this.f13681i;
        if (bVar != null) {
            bVar.mo13407a(OplusGLSurfaceView_13, this.f13678f.m13616a(OplusGLSurfaceView_13), z);
        }
    }

    @Override // com.oplus.camera.professional.PanelContainer.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13566a(int OplusGLSurfaceView_13, String str, boolean z) {
        IntrinsicsJvm.kt_3 cVar = this.f13683k;
        if (cVar != null) {
            cVar.mo13406a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13584c(int OplusGLSurfaceView_13, boolean z) {
        this.f13678f.m13632a(z, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m13589g() {
        this.f13678f.setPanelsBarAuto(4);
        this.f13678f.m13638c();
        m13563l();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private synchronized void m13563l() {
        ArrayList<String> arrayListM13637c = this.f13678f.m13637c(3);
        int iIndexOf = this.f13678f.m13634b(3).indexOf(this.f13678f.m13646h(3));
        this.f13678f.scrollTo(3, iIndexOf);
        this.f13678f.m13636b(3, iIndexOf);
        if (arrayListM13637c != null && arrayListM13637c.size() > iIndexOf) {
            this.f13676d.m13542a(3, arrayListM13637c.get(iIndexOf));
        }
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13576a(int OplusGLSurfaceView_13) {
        return this.f13678f.m13642e(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.professional.PanelInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13582b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return (this.f13678f.m13642e(1) && this.f13678f.m13642e(2) && this.f13678f.m13642e(3) && this.f13678f.m13642e(4) && this.f13678f.m13642e(5)) ? false : true;
        }
        if (3 == OplusGLSurfaceView_13) {
            return this.f13678f.m13642e(1) || this.f13678f.m13642e(2);
        }
        if (4 == OplusGLSurfaceView_13) {
            return this.f13685m;
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13583c(int OplusGLSurfaceView_13) {
        FilmModeItemBarData c2715jM13530a = this.f13677e.m13530a(OplusGLSurfaceView_13);
        if (c2715jM13530a != null) {
            this.f13676d.m13544a(OplusGLSurfaceView_13, mo13582b(OplusGLSurfaceView_13) && c2715jM13530a.m13557f(), ProfessionalUtil.m16137a(OplusGLSurfaceView_13) && mo13576a(OplusGLSurfaceView_13));
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f13676d.isSelected();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13568a(Rect rect) {
        if (rect == null || getVisibility() != 0) {
            return;
        }
        if (Util.m24498u()) {
            this.f13676d.getGlobalVisibleRect(rect);
            return;
        }
        int top = this.f13676d.getTop() + getTop();
        if (this.f13678f.m13633a()) {
            top -= this.f13678f.getTouchAreaRect().height();
        }
        rect.set(getLeft(), top, Util.getScreenWidth(), Util.m24193U());
    }

    public void setStatisticDataWriter(IntrinsicsJvm.kt_3 cVar) {
        this.f13683k = cVar;
    }

    public IntrinsicsJvm.kt_3 getStatisticDataWriter() {
        return this.f13683k;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m13590h() {
        FilmSlideBarContainer c2717l = this.f13678f;
        if (c2717l != null) {
            c2717l.m13641e();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m13591i() {
        FilmSlideBarContainer c2717l = this.f13678f;
        if (c2717l != null) {
            c2717l.m13644f();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m13592j() {
        FilmSlideBarContainer c2717l = this.f13678f;
        if (c2717l != null) {
            return c2717l.m13633a();
        }
        return false;
    }
}
