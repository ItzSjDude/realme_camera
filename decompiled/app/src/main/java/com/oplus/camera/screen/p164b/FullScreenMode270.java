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
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.preview.PreviewLayoutInfo;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FullScreenMode270.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FullScreenMode270 extends FullScreenModeRotate {
    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo16574b(int OplusGLSurfaceView_13) {
        return 270;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return "full270";
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_5 */
    public int mo16570k() {
        return 270;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo16572m() {
        return 5;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenModeRotate, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        super.mo16502a(screenRelativeLayout);
        screenRelativeLayout.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16553a(final Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3, LayoutItem c2949c4) {
        LayoutItem c2949c5 = new LayoutItem(new int[]{9, 0}, new int[]{0, 0, 0, 0});
        LayoutItem c2949c6 = new LayoutItem(new int[]{9, 0, 15, 0}, new int[]{(int) Util.m24456h(R.dimen.fold_full_professional_params_bar_margin_right), 0, 0, 0});
        LayoutItem c2949c7 = new LayoutItem(new int[]{10, 0, 9, 0}, new int[]{Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_right), Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_top), 0, 0});
        LayoutItem c2949c8 = new LayoutItem(new int[]{9, 0, 10, 0}, new int[]{Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_right), Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_top), 0, 0});
        c2949c8.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_8$zmi065lb-FTXdxWAq552Wn8-gug
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode270.m16580a(activity, view);
            }
        };
        super.mo16553a(activity, c2949c5, c2949c6, c2949c7, c2949c8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16580a(Activity activity, View view) {
        View viewFindViewById = activity.findViewById(R.id_renamed.professional_parameter_bottom_guide_entry);
        if (viewFindViewById != null) {
            viewFindViewById.setRotation(90.0f);
        }
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16562c(Activity activity, LayoutItem c2949c) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        LayoutItem c2949c2 = new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, (-dimensionPixelSize) / 2, resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90) + (dimensionPixelSize / 2)});
        c2949c2.f16021d = 270;
        super.mo16562c(activity, c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16551a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_right);
        super.mo16551a(activity, new LayoutItem(new int[]{9, 0}, null), new LayoutItem(new int[]{9, 0}, null));
        this.f16004a.put(Integer.valueOf(R.id_renamed.review_control_layout), new LayoutItem(new int[]{9, 0}, new int[]{dimensionPixelSize, 0, 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenModeRotate, com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16499a(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelSize(R.dimen.vertical_headline_margin_right), 0, 0, resources.getDimensionPixelSize(R.dimen.vertical_headline_rotate_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16563c(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {20, 0, 12, 0};
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_left);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_top);
        LayoutItem c2949c3 = new LayoutItem(iArr, new int[]{dimensionPixelSize2, 0, 0, dimensionPixelSize});
        c2949c3.f16021d = 270;
        LayoutItem c2949c4 = new LayoutItem(iArr, new int[]{dimensionPixelSize4, 0, 0, dimensionPixelSize3});
        c2949c4.f16021d = 270;
        super.mo16563c(activity, c2949c3, c2949c4);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo16566d(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16566d(activity, new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_start), resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo16567e(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16567e(activity, new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_start), resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16552a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_start);
        int[] iArr = {11, 0, 12, 0};
        super.mo16552a(activity, new LayoutItem(iArr, new int[]{0, 0, dimensionPixelOffset, resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_bottom_rotate_90)}), new LayoutItem(iArr, new int[]{0, 0, dimensionPixelOffset, resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_bottom_rotate_90)}), new LayoutItem(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.fold_full_professional_guide_entry_margin_right), resources.getDimensionPixelOffset(R.dimen.fold_full_professional_guide_entry_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16560b(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_full_rotate_margin_top);
        resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_full_rotate_margin_bottom);
        super.mo16560b(activity, new LayoutItem(new int[]{21, 0}, new int[]{0, 0, 0, 0}), c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16569f(Activity activity, LayoutItem c2949c) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        super.mo16569f(activity, new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(R.dimen.vertical_effect_menu_margin_top), resources.getDimensionPixelOffset(R.dimen.vertical_effect_menu_margin_left), 0}));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16527a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2, ScreenModeFacade.PlatformImplementations.kt_3 aVar3) {
        Float fValueOf = Float.valueOf(0.0f);
        aVar2.call(fValueOf, Float.valueOf(this.f16010e));
        aVar3.call(fValueOf, Float.valueOf(-this.f16010e));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo16576e(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar2.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16568f(final Activity activity) throws Resources.NotFoundException {
        final Resources resources = Util.m24472l().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_width_270);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_tool_first_level_bar_left_margin_270);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.menu_panel_layout_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.fold_full_mode_menu_panel_padding_left_right);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_top_margin_270);
        int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.fold_tool_setting_layout_right_margin);
        final int dimensionPixelSize8 = resources.getDimensionPixelSize(R.dimen.fold_full_first_level_translation_x_270);
        final int dimensionPixelSize9 = resources.getDimensionPixelSize(R.dimen.fold_full_first_level_translation_y_270);
        LayoutItem c2949c = new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, dimensionPixelSize6, dimensionPixelSize7, 0});
        c2949c.f16021d = 90;
        c2949c.f16022e = new int[]{dimensionPixelSize3, dimensionPixelSize3};
        c2949c.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$COUIBaseListPopupWindow_8$sfXUhs7JEwsOecDtR1xJfPaCseg
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                FullScreenMode270.m16579a(activity, dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize9, dimensionPixelSize8, resources, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.oplus_slide_downward), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16579a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, int i4, Resources resources, View view) {
        CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = OplusGLSurfaceView_13;
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        float COUIBaseListPopupWindow_12 = i3;
        cameraSettingMenuPanel.setTranslationY(COUIBaseListPopupWindow_12);
        float f2 = i4;
        cameraSettingMenuPanel.setTranslationX(f2);
        cameraSettingMenuPanel.setTag(R.id_renamed.animating_view_translation, new PointF(f2, COUIBaseListPopupWindow_12));
        CameraSettingMenuPanel cameraSettingMenuPanel2 = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = resources.getDimensionPixelSize(R.dimen.fold_tool_draw_panel_width);
            cameraSettingMenuPanel2.setPivotX(resources.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_x_270));
            cameraSettingMenuPanel2.setPivotY(resources.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_y_270));
            cameraSettingMenuPanel2.setRotation(270.0f);
        }
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16559b(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16559b(activity, new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_top), resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_left), 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16554a(Activity activity, CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = activity.getResources().getDimensionPixelSize(R.dimen.fold_tool_draw_panel_width);
        cameraSettingMenuPanel.setPivotX(r1.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_x_270));
        cameraSettingMenuPanel.setPivotY(r1.getDimensionPixelSize(R.dimen.fold_full_sub_pivot_y_270));
        cameraSettingMenuPanel.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16524a(View view, BasicOptionItemList basicOptionItemList, Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.mo16524a(view, basicOptionItemList, context, OplusGLSurfaceView_13);
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_width_full);
        int dimensionPixelSize2 = (dimensionPixelSize * OplusGLSurfaceView_13) + (resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_item_space_full) * (OplusGLSurfaceView_13 - 1)) + resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_item_layout_bottom_offset);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_top_margin) - dimensionPixelSize2;
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_left_margin_270);
        if (view != null && this.f16013h != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.topMargin = dimensionPixelSize3;
            layoutParams.leftMargin = dimensionPixelSize4;
            this.f16013h.addView(basicOptionItemList, layoutParams);
        }
        m16503a(basicOptionItemList);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16523a(Activity activity, ViewGroup viewGroup) {
        Resources resources = activity.getResources();
        ConstraintLayout.C0398a c0398a = new ConstraintLayout.C0398a(resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_width), resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_height));
        c0398a.f2508q = 0;
        c0398a.f2502k = 0;
        c0398a.bottomMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_bottom_margin);
        c0398a.leftMargin = resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_right_margin);
        viewGroup.setLayoutParams(c0398a);
        viewGroup.setVerticalFadingEdgeEnabled(true);
        viewGroup.setFadingEdgeLength(resources.getDimensionPixelSize(R.dimen.mode_edit_head_line_vertical_fading_edge));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public float[] mo16530a(View view, float COUIBaseListPopupWindow_12, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {r3[1] - f2, COUIBaseListPopupWindow_12 - r3[0]};
        fArr[0] = Math.min(Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = Math.min(Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenModeRotate, com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16555a(Activity activity, Rect rect) {
        return super.mo16555a(activity, m16578a(rect));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenModeRotate, com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16561b(Activity activity, Rect rect) {
        return super.mo16561b(activity, m16578a(rect));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect m16578a(Rect rect) {
        return new Rect(rect.left, rect.top - rect.width(), rect.left + rect.height(), rect.top);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16531a(int OplusGLSurfaceView_13, int i2) {
        return new int[]{ScreenModeConst.f16035b - i2, OplusGLSurfaceView_13};
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16532a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return new int[]{i2, (ScreenModeConst.f16035b - OplusGLSurfaceView_13) - i3};
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public PreviewLayoutInfo mo16496a(Context context) {
        PreviewLayoutInfo c3460wA = super.mo16496a(context);
        c3460wA.m23886b(mo16570k());
        return c3460wA;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenModeRotate, com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        return new int[]{this.f16005b, (int) (this.f16005b / (size.getWidth() / size.getHeight())), this.f16005b, (int) (this.f16005b / (size2.getWidth() / size2.getHeight()))};
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Rect mo16558b(int OplusGLSurfaceView_13, int i2) {
        this.f16005b = Util.getScreenHeight();
        this.f16006c = Util.getScreenWidth();
        int screenHeight = Util.getScreenHeight();
        int iRound = Math.round(screenHeight / (i2 / OplusGLSurfaceView_13));
        int i3 = (this.f16006c - iRound) / 2;
        return new Rect(i3, 0, iRound + i3, screenHeight);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListC = super.mo16509c();
        arrayListC.add(ApsConstant.CAPTURE_MODE_PANORAMA);
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    public RelativeLayout.LayoutParams mo16510d() {
        Resources resources = MyApplication.m11092d().getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.vertical_multicamera_type_layout_width), -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_top);
        layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_left);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RelativeLayout.LayoutParams mo16514f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.fold_full_professional_params_item_width), -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = Util.m24460i(R.dimen.fold_full_professional_params_bar_margin_right);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_width);
        int iM24460i2 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_height);
        int iM24460i3 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_top);
        int iM24460i4 = Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_right);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iM24460i, iM24460i2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = iM24460i3;
        layoutParams.leftMargin = iM24460i4;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16501a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2) {
        Size sizeM24180I = Util.m24180I();
        Rect rectMo16558b = mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
        int iM24460i = Util.m24460i(R.dimen.histogram_graph_view_width);
        int iM24460i2 = Util.m24460i(R.dimen.professional_histogram_margin_top);
        int iM24460i3 = Util.m24460i(R.dimen.fold_full_professional_histogram_margin_top);
        aVar.f14814d = (this.f16005b - iM24460i) - Util.m24460i(R.dimen.fold_full_professional_histogram_margin_left);
        aVar.f14815e = 0;
        if (rectMo16558b.left > iM24460i3) {
            aVar.f14812b = rectMo16558b.left + iM24460i2;
        } else {
            aVar.f14812b = iM24460i3;
        }
    }
}
