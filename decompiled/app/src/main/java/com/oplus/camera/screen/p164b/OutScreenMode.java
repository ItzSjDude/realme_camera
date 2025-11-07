package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.RelativeLayout;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: OutScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class OutScreenMode extends CommonScreenMode {
    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16495a(boolean z) {
        return 1;
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16528a(int OplusGLSurfaceView_13) {
        return 2 == OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return "out";
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo16539j() {
        return 2;
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16526a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16534b(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public float[] mo16530a(View view, float COUIBaseListPopupWindow_12, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {COUIBaseListPopupWindow_12 - r3[0], f2 - r3[1]};
        fArr[0] = Math.min(Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = Math.min(Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RelativeLayout.LayoutParams mo16549a(Size size) {
        if (size == null) {
            return null;
        }
        Rect rectMo16558b = mo16558b(size.getHeight(), size.getWidth());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectMo16558b.width(), rectMo16558b.height());
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        layoutParams.leftMargin = rectMo16558b.left;
        layoutParams.topMargin = rectMo16558b.top;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Rect mo16558b(int OplusGLSurfaceView_13, int i2) {
        this.f16005b = Util.getScreenWidth();
        this.f16006c = Util.getScreenHeight();
        int iM24426d = Util.m24426d(i2, OplusGLSurfaceView_13);
        float COUIBaseListPopupWindow_12 = i2 / OplusGLSurfaceView_13;
        if (7 == iM24426d) {
            int iRound = Math.round(this.f16006c / COUIBaseListPopupWindow_12);
            int i3 = (this.f16005b - iRound) / 2;
            return new Rect(i3, 0, iRound + i3, this.f16006c);
        }
        int iRound2 = Math.round(COUIBaseListPopupWindow_12 * this.f16005b);
        int iM16605c = ((this.f16006c - iRound2) / 2) + m16605c(iM24426d);
        return new Rect(0, iM16605c, this.f16005b, iRound2 + iM16605c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m16605c(int OplusGLSurfaceView_13) {
        Resources resources = MyApplication.m11092d().getResources();
        if (OplusGLSurfaceView_13 == 0) {
            return resources.getDimensionPixelOffset(R.dimen.fold_out_screen_center_offset_y_4_3);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return resources.getDimensionPixelOffset(R.dimen.fold_out_screen_center_offset_y_16_9);
        }
        if (OplusGLSurfaceView_13 != 2) {
            return 0;
        }
        return resources.getDimensionPixelOffset(R.dimen.fold_out_screen_center_offset_y_1_1);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        int[] iArr = new int[4];
        float width = size.getWidth() / size.getHeight();
        if (7 == Util.m24426d(size.getWidth(), size.getHeight())) {
            iArr[0] = this.f16006c;
            iArr[1] = Math.round(this.f16006c / width);
        } else {
            iArr[0] = (int) (this.f16005b * width);
            iArr[1] = this.f16005b;
        }
        float width2 = size2.getWidth() / size2.getHeight();
        if (7 == Util.m24426d(size2.getWidth(), size2.getHeight())) {
            iArr[2] = this.f16006c;
            iArr[3] = Math.round(this.f16006c / width2);
        } else {
            iArr[2] = (int) (this.f16005b * width2);
            iArr[3] = this.f16005b;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ApsConstant.CAPTURE_MODE_ID_PHOTO);
        arrayList.add(ApsConstant.CAPTURE_MODE_STICKER);
        return arrayList;
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, false);
        Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, false);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_template_button, false);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_setting_button, false);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.sub_mode_bar_height);
        int iM24460i2 = Util.m24460i(R.dimen.main_mode_bar_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), iM24460i);
        layoutParams.setMargins(0, 0, 0, iM24460i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.CommonScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(Activity activity) throws Resources.NotFoundException {
        super.mo16506b(activity);
        m16607i(activity);
        mo16499a(activity, (LayoutItem) null);
        m16608j(activity);
        m16606h(activity);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m16606h(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{9, 0, 2, R.id_renamed.control_panel_layout}, new int[]{resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom)});
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{11, 0, 2, R.id_renamed.control_panel_layout}, new int[]{0, 0, resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom)});
        c2949c2.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button), c2949c2);
        LayoutItem c2949c3 = new LayoutItem(new int[]{12, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(R.dimen.time_lapse_pro_panel_margin_bottom_vertical)});
        c2949c3.f16020c = new int[]{-1, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_layout), c2949c3);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m16607i(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_out_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.control_panel_margin_top);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.fold_out_main_shutter_button_margin_top);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(R.dimen.control_button_margin_edge);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(R.dimen.fold_out_switch_camera_button_margin_top);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(R.dimen.fold_out_thumbnail_margin_top);
        int dimensionPixelOffset7 = resources.getDimensionPixelOffset(R.dimen.thumbnail_view_padding);
        int dimensionPixelOffset8 = resources.getDimensionPixelOffset(R.dimen.thumbnail_margin_start);
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0}, new int[]{0, 0, 0, 0});
        c2949c.f16020c = new int[]{-1, Util.m24187O()};
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_layout), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{10, 0}, new int[]{0, dimensionPixelOffset2, 0, 0});
        c2949c2.f16020c = new int[]{-1, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_button_layout), c2949c2);
        this.f16004a.put(Integer.valueOf(R.id_renamed.shutter_button), new LayoutItem(new int[]{14, 0}, new int[]{0, dimensionPixelOffset3, 0, 0}));
        this.f16004a.put(Integer.valueOf(R.id_renamed.switch_camera_button), new LayoutItem(new int[]{21, 0}, new int[]{0, dimensionPixelOffset5, dimensionPixelOffset4, 0}));
        this.f16004a.put(Integer.valueOf(R.id_renamed.video_pause_resume), new LayoutItem(new int[]{21, 0}, new int[]{0, dimensionPixelOffset5, dimensionPixelOffset4, 0}));
        LayoutItem c2949c3 = new LayoutItem(new int[]{20, 0}, new int[]{dimensionPixelOffset8, dimensionPixelOffset6, 0, 0});
        this.f16004a.put(Integer.valueOf(R.id_renamed.thumbnail), c2949c3);
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_from_other_app_close_btn), c2949c3);
        this.f16004a.put(Integer.valueOf(R.id_renamed.recording_cap_button), new LayoutItem(new int[]{20, 0}, new int[]{dimensionPixelOffset8 + dimensionPixelOffset7, dimensionPixelOffset5, 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        super.mo16499a(activity, new LayoutItem(new int[]{14, 0, 10, 0}, new int[]{0, 0, 0, 0}));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16608j(final Activity activity) {
        RelativeLayout.LayoutParams layoutParamsE = mo16512e();
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsE.bottomMargin});
        c2949c.f16020c = new int[]{layoutParamsE.width, layoutParamsE.height};
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_params_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, 0});
        c2949c2.f16020c = new int[]{-1, Util.m24460i(R.dimen.main_mode_bar_height)};
        c2949c2.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_15$p-74yuUwNzNumCHd4oe_NutrJsY
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m16604a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.main_bar_id), c2949c2);
        RelativeLayout.LayoutParams layoutParamsMo16515g = mo16515g();
        LayoutItem c2949c3 = new LayoutItem(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, layoutParamsMo16515g.bottomMargin});
        c2949c3.f16020c = new int[]{layoutParamsMo16515g.width, layoutParamsMo16515g.height};
        final int iK = mo16570k();
        c2949c3.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_15$P1JFmQ8nHG5Qc63VPLwcK9u2FxM
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                OutScreenMode.m16603a(activity, iK, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_param_slide_bar_container), c2949c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16604a(Activity activity, View view) throws Resources.NotFoundException {
        ListProfessionalModeBar listProfessionalModeBar = (ListProfessionalModeBar) activity.findViewById(R.id_renamed.main_bar_id);
        if (listProfessionalModeBar == null) {
            return;
        }
        listProfessionalModeBar.m15391b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16603a(Activity activity, int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        PanelContainer c2898p = (PanelContainer) activity.findViewById(R.id_renamed.professional_param_slide_bar_container);
        if (c2898p == null) {
            return;
        }
        c2898p.m15830d(2, OplusGLSurfaceView_13);
        int childCount = c2898p.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c2898p.getChildAt(i2);
            if (childAt instanceof LevelPanel) {
                LevelPanel levelPanel = (LevelPanel) childAt;
                levelPanel.m15355a(2, OplusGLSurfaceView_13);
                levelPanel.m15363e();
            }
        }
    }
}
