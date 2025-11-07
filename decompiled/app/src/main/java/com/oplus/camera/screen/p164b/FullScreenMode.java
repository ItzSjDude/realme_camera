package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.inverse.InverseColorRelativeLayout;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.preview.ZoomArcSeekBar;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.professional.ProfessionalCapMode;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FullScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class FullScreenMode extends BaseScreenMode {

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f16009d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float f16010e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f16011f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected float f16012g = 20.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected ViewGroup f16013h;

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16495a(boolean z) {
        return z ? 31 : 3;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RotableTextView mo16550a(Activity activity, RelativeLayout relativeLayout, int OplusGLSurfaceView_13) {
        return null;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16504a() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo16539j() {
        return 1;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_5 */
    public int mo16570k() {
        return 0;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo16571l() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo16572m() {
        return 7;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(Activity activity) throws Resources.NotFoundException {
        super.mo16506b(activity);
        Resources resources = activity.getResources();
        this.f16010e = resources.getDimensionPixelSize(R.dimen.zoom_linkage_translate);
        this.f16011f = resources.getDimensionPixelSize(R.dimen.full_camera_up_hint_margin_top);
        mo16562c(activity, (LayoutItem) null);
        mo16551a(activity, (LayoutItem) null, (LayoutItem) null);
        mo16568f(activity);
        m16548h(activity);
        mo16499a(activity, (LayoutItem) null);
        mo16563c(activity, null, null);
        mo16566d(activity, (LayoutItem) null);
        mo16569f(activity, null);
        mo16567e(activity, (LayoutItem) null);
        mo16559b(activity, (LayoutItem) null);
        mo16553a(activity, null, null, null, null);
        mo16552a(activity, (LayoutItem) null, (LayoutItem) null, (LayoutItem) null);
        mo16560b(activity, null, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16559b(Activity activity, LayoutItem c2949c) {
        c2949c.f16020c = new int[]{activity.getResources().getDimensionPixelOffset(R.dimen.vertical_multicamera_type_layout_width), -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.multivideo_type_select_view), c2949c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16553a(final Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3, LayoutItem c2949c4) {
        c2949c.f16020c = new int[]{-2, -1};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$IGePNhGjYtSyAd-1wlDoXGiQf6Y
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                this.COUIBaseListPopupWindow_12$0.m16547c(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_params_bar_container), c2949c);
        c2949c2.f16020c = new int[]{Util.m24460i(R.dimen.fold_full_professional_params_item_width), -1};
        c2949c2.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$VYvn82MIvFRTUFSh36CSed-2Bnw
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m16546b(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.main_bar_id), c2949c2);
        c2949c3.f16020c = new int[]{Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_width), Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_height)};
        final int iMo16570k = mo16570k();
        c2949c3.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$zSuyYc5N9XJ28OjDxHWUvPMbD3g
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                FullScreenMode.m16543a(activity, iMo16570k, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_param_slide_bar_container), c2949c3);
        c2949c4.f16020c = new int[]{-2, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_parameter_bottom_guide_entry), c2949c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m16547c(Activity activity, View view) {
        ProfessionalCapMode.PlatformImplementations.kt_3 aVar = (ProfessionalCapMode.PlatformImplementations.kt_3) activity.findViewById(R.id_renamed.professional_params_bar_container);
        if (aVar != null) {
            aVar.setLayoutParams(mo16512e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m16546b(Activity activity, View view) throws Resources.NotFoundException {
        ListProfessionalModeBar listProfessionalModeBar = (ListProfessionalModeBar) activity.findViewById(R.id_renamed.main_bar_id);
        if (listProfessionalModeBar == null) {
            return;
        }
        listProfessionalModeBar.m15391b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16543a(Activity activity, int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        PanelContainer c2898p = (PanelContainer) activity.findViewById(R.id_renamed.professional_param_slide_bar_container);
        if (c2898p == null) {
            return;
        }
        c2898p.m15830d(1, OplusGLSurfaceView_13);
        int childCount = c2898p.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c2898p.getChildAt(i2);
            if (childAt instanceof LevelPanel) {
                LevelPanel levelPanel = (LevelPanel) childAt;
                levelPanel.m15355a(1, OplusGLSurfaceView_13);
                levelPanel.m15363e();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16562c(final Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius_full);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.zoom_focus_circle_margin_bottom);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.zoom_focus_circle_width);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.zoom_mark_button_size);
        c2949c.f16020c = new int[]{dimensionPixelSize * 2, dimensionPixelSize};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$fs8ZxGTk7h1dR34uAq_8woW7eXo
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                this.COUIBaseListPopupWindow_12$0.m16542a(activity, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{3, R.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, (-dimensionPixelSize5) - dimensionPixelSize3, 0, 0});
        c2949c2.f16020c = new int[]{-2, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_click), c2949c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16542a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, int i4, View view) {
        ZoomArcSeekBar c3435af = (ZoomArcSeekBar) activity.findViewById(R.id_renamed.zoom_seek_bar);
        c3435af.getLayoutParams().width = -1;
        c3435af.getLayoutParams().height = OplusGLSurfaceView_13;
        c3435af.m23077a(OplusGLSurfaceView_13 * 2, OplusGLSurfaceView_13, i2, (OplusGLSurfaceView_13 - (i3 / 2)) - i4, 0.0f, 2.0f, this.f16012g);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m16548h(final Activity activity) {
        LayoutItem c2949c = new LayoutItem(null, null);
        c2949c.f16020c = new int[]{0, 0};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$AdZtnvmVnJu8jLKSCpuYaaOp92g
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode.m16544a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.gallery_container), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16544a(Activity activity, View view) {
        ((RelativeLayout) activity.findViewById(R.id_renamed.gallery_container)).setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16551a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) {
        Resources resources = activity.getResources();
        resources.getDimensionPixelSize(R.dimen.control_panel_margin_right);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.control_panel_width_full);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.control_panel_width_full);
        resources.getDimensionPixelSize(R.dimen.shutter_button_length);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.switch_camera_margin_bottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.thumbnail_vertical_margin_top);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.video_cap_margin_top);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.thumbnail_view_padding_plus);
        int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.switch_camera_button_width_full);
        c2949c.f16020c = new int[]{dimensionPixelSize, -1};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$GHRKJPYD08BlDp1Z0enwXPrbbIU
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode.m16545a(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_layout), c2949c);
        c2949c2.f16020c = new int[]{dimensionPixelSize2, -1};
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_button_layout), c2949c2);
        this.f16004a.put(Integer.valueOf(R.id_renamed.shutter_button), new LayoutItem(new int[]{13, 0}, new int[]{0, 0, 0, 0}));
        LayoutItem c2949c3 = new LayoutItem(new int[]{14, 0, 2, R.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        c2949c3.f16020c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f16004a.put(Integer.valueOf(R.id_renamed.switch_camera_button), c2949c3);
        LayoutItem c2949c4 = new LayoutItem(new int[]{14, 0, 2, R.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        c2949c4.f16020c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f16004a.put(Integer.valueOf(R.id_renamed.video_pause_resume), c2949c4);
        LayoutItem c2949c5 = new LayoutItem(new int[]{14, 0, 3, R.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        c2949c5.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$OOGEV7H5hZGH4UCl1-IGH_wEOoU
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode.m16540a(dimensionPixelSize6, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.thumbnail), c2949c5);
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_from_other_app_close_btn), c2949c5);
        LayoutItem c2949c6 = new LayoutItem(new int[]{14, 0, 3, R.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize5, 0, 0});
        c2949c6.f16020c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f16004a.put(Integer.valueOf(R.id_renamed.recording_cap_button), c2949c6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16545a(View view) {
        if (view instanceof InverseColorRelativeLayout) {
            ((InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16540a(int OplusGLSurfaceView_13, View view) {
        if (view instanceof ThumbImageView) {
            ((ThumbImageView) view).setPaddingPlus(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16568f(final Activity activity) throws Resources.NotFoundException {
        final Resources resources = Util.m24472l().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_width);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_top_margin);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_left_margin);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_pivot_y);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_pivot_x);
        final int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.menu_panel_layout_height);
        final int dimensionPixelSize8 = resources.getDimensionPixelSize(R.dimen.fold_full_mode_menu_panel_padding_left_right);
        final int dimensionPixelSize9 = resources.getDimensionPixelSize(R.dimen.fold_full_first_level_translation_x);
        final int dimensionPixelSize10 = resources.getDimensionPixelSize(R.dimen.fold_full_first_level_translation_y);
        LayoutItem c2949c = new LayoutItem(new int[]{9, 0, 10, 0}, new int[]{dimensionPixelSize4, dimensionPixelSize3, 0, 0});
        c2949c.f16021d = 270;
        c2949c.f16022e = new int[]{dimensionPixelSize6, dimensionPixelSize5};
        c2949c.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_3$ZhjdO6cm4r2na2LW7eQl0DZFCwk
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode.m16541a(activity, dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize10, dimensionPixelSize9, resources, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.oplus_slide_downward), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16541a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, int i4, Resources resources, View view) {
        CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = OplusGLSurfaceView_13;
        cameraSettingMenuPanel.setRotation(180.0f);
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        float COUIBaseListPopupWindow_12 = i3;
        cameraSettingMenuPanel.setTranslationY(COUIBaseListPopupWindow_12);
        float f2 = i4;
        cameraSettingMenuPanel.setTranslationX(f2);
        cameraSettingMenuPanel.setTag(R.id_renamed.animating_view_translation, new PointF(f2, COUIBaseListPopupWindow_12));
        CameraSettingMenuPanel cameraSettingMenuPanel2 = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = resources.getDimensionPixelSize(R.dimen.fold_tool_draw_panel_width);
            cameraSettingMenuPanel2.setPivotX(resources.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_x));
            cameraSettingMenuPanel2.setPivotY(resources.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_y));
            cameraSettingMenuPanel2.setRotation(90.0f);
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        c2949c.f16020c = new int[]{resources.getDimensionPixelSize(R.dimen.vertical_headline_width), resources.getDimensionPixelSize(R.dimen.vertical_headline_height)};
        this.f16004a.put(Integer.valueOf(R.id_renamed.headline_view), c2949c);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo16566d(Activity activity, LayoutItem c2949c) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.vertical_effect_button_size);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.face_beauty_enter_button), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.effect_menu_back_button), c2949c);
        activity.findViewById(R.id_renamed.effect_menu_back_button).setVisibility(0);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo16567e(Activity activity, LayoutItem c2949c) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.vertical_effect_button_size);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button), c2949c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16552a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.vertical_effect_button_size);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        c2949c2.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button), c2949c2);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_guide_button), c2949c3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16560b(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) {
        LayoutItem c2949c3 = new LayoutItem(new int[]{12, 0}, new int[]{0, 0, 0, activity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_record_margin_bottom_full_screen)});
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_layout), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_record_layout), c2949c3);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16569f(Activity activity, LayoutItem c2949c) {
        c2949c.f16020c = new int[]{activity.getResources().getDimensionPixelOffset(R.dimen.vertical_effect_menu_width), -1};
        this.f16004a.put(Integer.valueOf(R.id_renamed.effects_menu_panel), c2949c);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16524a(View view, BasicOptionItemList basicOptionItemList, Context context, int OplusGLSurfaceView_13) {
        if (view != null) {
            this.f16013h = (ViewGroup) view.getRootView().findViewById(R.id_renamed.camera);
        }
        basicOptionItemList.setScreenLayoutMode(mo16539j());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16563c(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) {
        this.f16004a.put(Integer.valueOf(R.id_renamed.screen_mode_switch_button), c2949c);
        this.f16004a.put(Integer.valueOf(R.id_renamed.out_screen_preview_switch_button), c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16554a(Activity activity, CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = activity.getResources().getDimensionPixelSize(R.dimen.fold_tool_draw_panel_width);
        cameraSettingMenuPanel.setPivotX(activity.getResources().getDimensionPixelSize(R.dimen.fold_full_sub_pivot_x));
        cameraSettingMenuPanel.setPivotY(activity.getResources().getDimensionPixelSize(R.dimen.fold_full_sub_pivot_y));
        cameraSettingMenuPanel.setRotation(90.0f);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RelativeLayout.LayoutParams mo16549a(Size size) {
        if (size == null) {
            CameraLog.m12967f("FullScreenMode", "layoutPreviewFrame, previewSize is null.");
            return null;
        }
        Rect rectMo16558b = mo16558b(size.getHeight(), size.getWidth());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectMo16558b.width(), rectMo16558b.height());
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = rectMo16558b.left;
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f16009d = rectMo16558b.left;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Rect mo16558b(int OplusGLSurfaceView_13, int i2) {
        this.f16005b = Util.getScreenWidth();
        this.f16006c = Util.getScreenHeight();
        Rect rect = new Rect(0, 0, 0, this.f16006c);
        rect.left = (this.f16005b - Math.round(this.f16006c / (i2 / OplusGLSurfaceView_13))) / 2;
        rect.right = this.f16005b - rect.left;
        return rect;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        return new int[]{this.f16006c, (int) (this.f16006c / (size.getWidth() / size.getHeight())), this.f16006c, (int) (this.f16006c / (size2.getWidth() / size2.getHeight()))};
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16526a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16523a(Activity activity, ViewGroup viewGroup) {
        Resources resources = activity.getResources();
        ConstraintLayout.C0398a c0398a = new ConstraintLayout.C0398a(resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_width), resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_height));
        c0398a.f2510s = 0;
        c0398a.f2502k = 0;
        c0398a.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_bottom_margin);
        c0398a.rightMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_right_margin);
        viewGroup.setLayoutParams(c0398a);
        viewGroup.setVerticalFadingEdgeEnabled(true);
        viewGroup.setFadingEdgeLength(resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_fading_edge));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16556a(Activity activity, boolean z, float COUIBaseListPopupWindow_12, float f2) {
        Resources resources = activity.getResources();
        return COUIBaseListPopupWindow_12 <= ((float) ((ScreenModeConst.f16034a - resources.getDimensionPixelSize(R.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(R.dimen.shutter_button_length)));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16555a(Activity activity, Rect rect) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        return ((float) rect.right) <= ((float) ((ScreenModeConst.f16034a - resources.getDimensionPixelSize(R.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(R.dimen.shutter_button_length)));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16561b(Activity activity, Rect rect) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        return ((float) rect.centerX()) >= ((float) ((ScreenModeConst.f16034a - resources.getDimensionPixelSize(R.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(R.dimen.shutter_button_length)));
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
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16534b(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16533b(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo16564c(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo16535c(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16536d(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
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

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListMo16509c = super.mo16509c();
        arrayListMo16509c.add("movie");
        return arrayListMo16509c;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int[] mo16565c(Activity activity, int OplusGLSurfaceView_13) {
        Resources resources = activity.getResources();
        int[] iArr = new int[3];
        if (OplusGLSurfaceView_13 == 7) {
            iArr[0] = resources.getDimensionPixelSize(R.dimen.bubble_ai_enhancement_video_offsetX_full);
            iArr[1] = resources.getDimensionPixelSize(R.dimen.bubble_ai_enhancement_video_offsetY_full);
            iArr[2] = 8;
        } else if (OplusGLSurfaceView_13 == 9) {
            iArr[0] = resources.getDimensionPixelSize(R.dimen.bubble_zoom_ultra_offsetX_full);
            iArr[1] = resources.getDimensionPixelSize(R.dimen.bubble_zoom_ultra_offsetY_full);
            iArr[2] = 8;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    public RelativeLayout.LayoutParams mo16510d() throws Resources.NotFoundException {
        Resources resources = MyApplication.m11092d().getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.vertical_multicamera_type_layout_width), -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.setMargins(resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_left), resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_top), 0, 0);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16494a(Activity activity, int OplusGLSurfaceView_13) {
        return activity.getResources().getDimensionPixelSize(R.dimen.fold_full_screen_record_time_margin_top);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16525a(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        if (aVar != null) {
            aVar.call(new Object[0]);
        } else {
            CameraLog.m12967f("FullScreenMode", "updateZoomMargin, callBack is null");
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RelativeLayout.LayoutParams mo16514f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.fold_full_professional_params_item_width), -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = Util.m24460i(R.dimen.fold_full_professional_params_bar_margin_right);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_width);
        int iM24460i2 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_height);
        int iM24460i3 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_top);
        int iM24460i4 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_right);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iM24460i, iM24460i2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = iM24460i3;
        layoutParams.rightMargin = iM24460i4;
        return layoutParams;
    }
}
