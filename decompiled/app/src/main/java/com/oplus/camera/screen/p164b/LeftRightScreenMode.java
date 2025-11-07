package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.preview.ZoomArcSeekBar;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: LeftRightScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public abstract class LeftRightScreenMode extends BaseScreenMode {
    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16495a(boolean z) {
        return z ? 21 : 2;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16504a() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16528a(int OplusGLSurfaceView_13) {
        return 6 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected abstract void mo16596i(Activity activity);

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo16539j() {
        return 3;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: o */
    public boolean mo16599o() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        this.f16005b = ScreenModeConst.f16034a / 2;
        this.f16006c = ScreenModeConst.f16035b;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(Activity activity) throws Resources.NotFoundException {
        super.mo16506b(activity);
        m16592o(activity);
        m16595h(activity);
        m16590m(activity);
        m16591n(activity);
        mo16594f(activity);
        mo16596i(activity);
        mo16499a(activity, (LayoutItem) null);
        m16593p(activity);
        m16589l(activity);
        m16597j(activity);
        m16598k(activity);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m16589l(final Activity activity) {
        RelativeLayout.LayoutParams layoutParamsMo16512e = mo16512e();
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsMo16512e.bottomMargin});
        c2949c.f16020c = new int[]{layoutParamsMo16512e.width, layoutParamsMo16512e.height};
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_params_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, 0});
        c2949c2.f16020c = new int[]{-1, Util.m24460i(R.dimen.main_mode_bar_height)};
        c2949c2.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_10$3bjrjhuMhcCf96jYvgIYYqKxHKE
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m16586a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.main_bar_id), c2949c2);
        RelativeLayout.LayoutParams layoutParamsMo16515g = mo16515g();
        LayoutItem c2949c3 = new LayoutItem(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, layoutParamsMo16515g.bottomMargin});
        c2949c3.f16020c = new int[]{layoutParamsMo16515g.width, layoutParamsMo16515g.height};
        final int iK = mo16570k();
        c2949c3.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_10$pAjpg81eNS7jrgoNC1s_SQDrk58
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                LeftRightScreenMode.m16585a(activity, iK, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_param_slide_bar_container), c2949c3);
        LayoutItem c2949c4 = new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, Util.m24460i(R.dimen.fold_split_professional_guide_entry_margin_top), Util.m24460i(R.dimen.fold_split_professional_guide_entry_margin_right), 0});
        c2949c4.f16020c = new int[]{-2, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_parameter_bottom_guide_entry), c2949c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16586a(Activity activity, View view) throws Resources.NotFoundException {
        ListProfessionalModeBar listProfessionalModeBar = (ListProfessionalModeBar) activity.findViewById(R.id_renamed.main_bar_id);
        if (listProfessionalModeBar == null) {
            return;
        }
        listProfessionalModeBar.m15391b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16585a(Activity activity, int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        PanelContainer c2898p = (PanelContainer) activity.findViewById(R.id_renamed.professional_param_slide_bar_container);
        if (c2898p == null) {
            return;
        }
        c2898p.m15830d(3, OplusGLSurfaceView_13);
        int childCount = c2898p.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c2898p.getChildAt(i2);
            if (childAt instanceof LevelPanel) {
                LevelPanel levelPanel = (LevelPanel) childAt;
                levelPanel.m15355a(3, OplusGLSurfaceView_13);
                levelPanel.m15363e();
            }
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        super.mo16499a(activity, new LayoutItem(new int[]{14, 0, 10, 0}, new int[]{0, 0, 0, 0}));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16594f(Activity activity) {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.control_panel_margin_top);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.fold_left_right_preview_shutter_button_margin_top);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(R.dimen.fold_out_switch_camera_button_margin_top);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(R.dimen.fold_out_thumbnail_margin_top);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(R.dimen.control_button_margin_edge);
        int dimensionPixelOffset7 = resources.getDimensionPixelOffset(R.dimen.thumbnail_view_padding);
        int dimensionPixelOffset8 = resources.getDimensionPixelOffset(R.dimen.thumbnail_margin_start);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.switch_camera_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{10, 0}, new int[]{0, dimensionPixelOffset2, 0, 0});
        c2949c.f16020c = new int[]{-1, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_button_layout), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.shutter_button), new LayoutItem(new int[]{14, 0}, new int[]{0, dimensionPixelOffset3, 0, 0}));
        LayoutItem c2949c2 = new LayoutItem(new int[]{21, 0}, new int[]{0, dimensionPixelOffset4, dimensionPixelOffset6, 0});
        c2949c2.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f16004a.put(Integer.valueOf(R.id_renamed.switch_camera_button), c2949c2);
        LayoutItem c2949c3 = new LayoutItem(new int[]{21, 0}, new int[]{0, dimensionPixelOffset4, dimensionPixelOffset6, 0});
        c2949c3.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f16004a.put(Integer.valueOf(R.id_renamed.video_pause_resume), c2949c3);
        LayoutItem c2949c4 = new LayoutItem(new int[]{20, 0}, new int[]{dimensionPixelOffset8, dimensionPixelOffset5, 0, 0});
        c2949c4.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_10$tH4ChxzoJva0B9-qZfmLmMgUa5U
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                LeftRightScreenMode.m16587a(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.thumbnail), c2949c4);
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_from_other_app_close_btn), c2949c4);
        LayoutItem c2949c5 = new LayoutItem(new int[]{20, 0}, new int[]{dimensionPixelOffset8 + dimensionPixelOffset7, dimensionPixelOffset4, 0, 0});
        c2949c5.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f16004a.put(Integer.valueOf(R.id_renamed.recording_cap_button), c2949c5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16587a(View view) {
        if (view instanceof ThumbImageView) {
            ((ThumbImageView) view).setPaddingPlus(0);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m16590m(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_effect_button_margin_bottom);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.horizontal_common_effect_button_margin_end);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout, 21, 0}, new int[]{0, 0, dimensionPixelOffset2, dimensionPixelOffset});
        c2949c.f16020c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f16004a.put(Integer.valueOf(R.id_renamed.face_beauty_enter_button), c2949c);
        activity.findViewById(R.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m16595h(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {20, 0, 10, 0};
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_left);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_top);
        LayoutItem c2949c = new LayoutItem(iArr, new int[]{dimensionPixelSize, dimensionPixelSize2, 0, 0});
        LayoutItem c2949c2 = new LayoutItem(iArr, new int[]{dimensionPixelSize3, dimensionPixelSize4, 0, 0});
        this.f16004a.put(Integer.valueOf(R.id_renamed.screen_mode_switch_button), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.out_screen_preview_switch_button), c2949c2);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m16591n(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_blur_button_margin_start);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_effect_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout, 20, 0}, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        c2949c.f16020c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button), c2949c);
    }

    /* renamed from: o */
    private void m16592o(final Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelSize = (-resources.getDimensionPixelSize(R.dimen.zoom_mark_button_size)) - resources.getDimensionPixelSize(R.dimen.zoom_click_margin_top);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.control_panel_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.zoom_click_margin_top);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_center_y);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
        final int dimensionPixelSize7 = dimensionPixelSize4 != 0 ? resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius) : 0;
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout}, new int[]{0, 0, 0, dimensionPixelSize});
        c2949c.f16020c = new int[]{-1, -2};
        c2949c.f16021d = 0;
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_10$LxtM6OUd9RX9OMS2YZG9XP9J_B4
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                this.COUIBaseListPopupWindow_12$0.m16584a(activity, dimensionPixelSize4, dimensionPixelSize7, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize2, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{3, R.id_renamed.zoom_seek_bar}, new int[]{0, dimensionPixelSize3, 0, 0});
        c2949c2.f16020c = new int[]{-1, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_click), c2949c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16584a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, View view) {
        ZoomArcSeekBar c3435af = (ZoomArcSeekBar) activity.findViewById(R.id_renamed.zoom_seek_bar);
        c3435af.getLayoutParams().width = -1;
        c3435af.getLayoutParams().height = OplusGLSurfaceView_13;
        c3435af.m23077a(this.f16005b, i2, i3, i4, (Util.m24188P() + i5) / 2.0f, 1.0f, 0.0f);
    }

    /* renamed from: p */
    private void m16593p(final Activity activity) throws Resources.NotFoundException {
        Resources resources = Util.m24472l().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.menu_panel_layout_height);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
        LayoutItem c2949c = new LayoutItem(new int[]{10, 0}, new int[]{0, 0, 0, 0});
        c2949c.f16020c = new int[]{-1, -2};
        c2949c.f16021d = 0;
        final CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = dimensionPixelSize;
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_10$5ZXwuuFfvx8V3j5t_DTfLx6OGqg
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                LeftRightScreenMode.m16588a(cameraSettingMenuPanel, dimensionPixelSize2, activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.oplus_slide_downward), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16588a(CameraSettingMenuPanel cameraSettingMenuPanel, int OplusGLSurfaceView_13, Activity activity, View view) {
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setTranslationY(0.0f);
        cameraSettingMenuPanel.setTranslationX(0.0f);
        cameraSettingMenuPanel.setTag(R.id_renamed.animating_view_translation, new PointF(0.0f, 0.0f));
        cameraSettingMenuPanel.setPaddingLeftRight(OplusGLSurfaceView_13);
        CameraSettingMenuPanel cameraSettingMenuPanel2 = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16554a(Activity activity, CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.setRotation(0.0f);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16525a(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16527a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2, ScreenModeFacade.PlatformImplementations.kt_3 aVar3) {
        aVar.call(2);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16526a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16534b(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo16535c(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public float[] mo16530a(View view, float COUIBaseListPopupWindow_12, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {COUIBaseListPopupWindow_12 - r3[0], f2 - r3[1]};
        fArr[0] = Math.min(Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = Math.min(Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16536d(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16531a(int OplusGLSurfaceView_13, int i2) {
        return new int[]{OplusGLSurfaceView_13, i2};
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16532a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return new int[]{OplusGLSurfaceView_13, i2};
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        return new int[]{(int) (this.f16005b * (size.getWidth() / size.getHeight())), this.f16005b, (int) (this.f16005b * (size2.getWidth() / size2.getHeight())), this.f16005b};
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16494a(Activity activity, int OplusGLSurfaceView_13) {
        return activity.getResources().getDimensionPixelSize(R.dimen.fold_split_screen_record_time_margin_top);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo16508c(Activity activity) {
        return activity.getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top_split_screen);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16523a(Activity activity, ViewGroup viewGroup) {
        Resources resources = activity.getResources();
        ConstraintLayout.C0398a c0398a = new ConstraintLayout.C0398a(-1, resources.getDimensionPixelSize(R.dimen.head_line_height));
        c0398a.f2510s = 0;
        c0398a.f2508q = 0;
        c0398a.f2499h = 0;
        c0398a.topMargin = resources.getDimensionPixelSize(R.dimen.head_line_view_margin_top);
        viewGroup.setLayoutParams(c0398a);
        viewGroup.setVerticalFadingEdgeEnabled(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16583a(float COUIBaseListPopupWindow_12) {
        Resources resources = MyApplication.m11092d().getResources();
        double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.0d) < 0.01d) {
            return resources.getDimensionPixelOffset(R.dimen.fold_split_screen_center_offset_y_1_1);
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 1.3333333333333333d) < 0.01d) {
            return resources.getDimensionPixelOffset(R.dimen.fold_split_screen_center_offset_y_4_3);
        }
        if (Math.abs(IntrinsicsJvm.kt_5 - 0.9333333333333333d) < 0.01d) {
            return resources.getDimensionPixelOffset(R.dimen.fold_split_screen_center_offset_y_14_15);
        }
        return resources.getDimensionPixelOffset(R.dimen.fold_split_screen_center_offset_y_16_9);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListMo16509c = super.mo16509c();
        arrayListMo16509c.add(ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
        arrayListMo16509c.add("movie");
        arrayListMo16509c.add(ApsConstant.CAPTURE_MODE_PANORAMA);
        arrayListMo16509c.add("superText");
        return arrayListMo16509c;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, false);
        Util.m24256a(activity, R.id_renamed.effect_menu_back_button, false);
        Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, false);
        Util.m24256a(activity, R.id_renamed.screen_mode_switch_button, true);
        Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, true);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_template_button, false);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_setting_button, false);
        if (OplusGLSurfaceView_13 == 1) {
            Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.recording_cap_button, R.drawable.switch_camera_button_bg);
            return;
        }
        Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_gray_bg);
        Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_gray_bg);
        Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_gray_bg);
        Util.m24255a(activity, R.id_renamed.recording_cap_button, R.drawable.switch_camera_button_gray_bg);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m16597j(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {9, 0, 2, R.id_renamed.control_panel_layout};
        int[] iArr2 = {11, 0, 2, R.id_renamed.control_panel_layout};
        LayoutItem c2949c = new LayoutItem(iArr, new int[]{resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom)});
        LayoutItem c2949c2 = new LayoutItem(iArr2, new int[]{0, 0, resources.getDimensionPixelSize(R.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(R.dimen.face_beauty_enter_button_margin_bottom)});
        LayoutItem c2949c3 = new LayoutItem(new int[]{10, 0, 11, 0}, new int[]{0, resources.getDimensionPixelOffset(R.dimen.fold_split_professional_guide_entry_margin_top), resources.getDimensionPixelOffset(R.dimen.fold_split_professional_guide_entry_margin_right), 0});
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        c2949c2.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button), c2949c2);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_guide_button), c2949c3);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void m16598k(Activity activity) throws Resources.NotFoundException {
        int[] iArr = {12, 0};
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        LayoutItem c2949c = new LayoutItem(iArr, new int[]{0, 0, 0, dimensionPixelOffset});
        LayoutItem c2949c2 = new LayoutItem(iArr, new int[]{0, 0, 0, dimensionPixelOffset});
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_layout), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_record_layout), c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f16005b);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_split_professional_params_bar_container_margin_bottom);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RelativeLayout.LayoutParams mo16514f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.m24460i(R.dimen.main_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.sub_mode_bar_height);
        int iM24460i2 = Util.m24460i(R.dimen.main_mode_bar_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f16005b, iM24460i);
        layoutParams.setMargins(0, 0, 0, iM24460i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16501a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2) {
        Size sizeM24180I = Util.m24180I();
        Rect rectB = mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
        int iM24460i = Util.m24460i(R.dimen.professional_histogram_margin_top);
        int iM24460i2 = Util.m24460i(R.dimen.professional_histogram_margin_start);
        int iM24460i3 = Util.m24460i(R.dimen.fold_split_professional_histogram_margin_top);
        aVar.f14814d = iM24460i2;
        aVar.f14815e = 0;
        if (rectB.top + iM24460i > iM24460i3) {
            aVar.f14812b = rectB.top + iM24460i;
        } else {
            aVar.f14812b = iM24460i3;
        }
    }
}
