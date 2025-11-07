package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.RelativeLayout;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FullScreenMode0.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class FullScreenMode0 extends FullScreenMode {
    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16528a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo16574b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 + 90;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16575d(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return DcsMsgData.FULL;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_11 */
    public boolean mo16577n() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        this.f16005b = ScreenModeConst.f16034a;
        this.f16006c = ScreenModeConst.f16035b;
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16553a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3, LayoutItem c2949c4) {
        super.mo16553a(activity, new LayoutItem(new int[]{11, 0}, new int[]{0, 0, 0, 0}), new LayoutItem(new int[]{11, 0, 15, 0}, new int[]{0, 0, Util.m24460i(R.dimen.fold_full_professional_params_bar_margin_right), 0}), new LayoutItem(new int[]{10, 0, 11, 0}, new int[]{0, Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_top), Util.m24460i(R.dimen.fold_full_professional_params_slide_bar_panel_margin_right), 0}), new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_top), Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16562c(Activity activity, LayoutItem c2949c) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        LayoutItem c2949c2 = new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{(-dimensionPixelSize) / 2, 0, 0, resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_full_margin_bottom) + (dimensionPixelSize / 2)});
        c2949c2.f16021d = 90;
        super.mo16562c(activity, c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16551a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        activity.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_right);
        super.mo16551a(activity, new LayoutItem(new int[]{11, 0}, null), new LayoutItem(new int[]{11, 0}, null));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16527a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2, ScreenModeFacade.PlatformImplementations.kt_3 aVar3) {
        Float fValueOf = Float.valueOf(0.0f);
        aVar2.call(fValueOf, Float.valueOf(this.f16010e));
        aVar3.call(fValueOf, Float.valueOf(this.f16010e));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo16576e(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16524a(View view, BasicOptionItemList basicOptionItemList, Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.mo16524a(view, basicOptionItemList, context, OplusGLSurfaceView_13);
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_width_full);
        int dimensionPixelSize2 = (dimensionPixelSize * OplusGLSurfaceView_13) + (resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_item_space_full) * (OplusGLSurfaceView_13 - 1)) + resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_item_layout_bottom_offset);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_top_margin) - dimensionPixelSize2;
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.fold_tool_second_level_left_margin);
        if (view != null && this.f16013h != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.topMargin = dimensionPixelSize3;
            layoutParams.leftMargin = dimensionPixelSize4;
            this.f16013h.addView(basicOptionItemList, layoutParams);
        }
        m16503a(basicOptionItemList);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16499a(activity, new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelSize(R.dimen.vertical_headline_margin_right), resources.getDimensionPixelSize(R.dimen.vertical_headline_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16563c(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {20, 0, 10, 0};
        super.mo16563c(activity, new LayoutItem(iArr, new int[]{resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_left), resources.getDimensionPixelSize(R.dimen.fold_screen_mode_switch_button_margin_top), 0, 0}), new LayoutItem(iArr, new int[]{resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_left), resources.getDimensionPixelSize(R.dimen.fold_out_screen_preview_switch_button_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo16566d(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16566d(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_start), 0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo16567e(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16567e(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_start), 0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16552a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_start);
        super.mo16552a(activity, new LayoutItem(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_blur_button_margin_bottom)}), new LayoutItem(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(R.dimen.vertical_effect_button_margin_bottom)}), new LayoutItem(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(R.dimen.fold_full_professional_guide_entry_margin_top), resources.getDimensionPixelOffset(R.dimen.fold_full_professional_guide_entry_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16560b(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {20, 0};
        resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_full_margin_top);
        resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_full_margin_bottom);
        Util.m24198Z();
        if (Util.m24198Z() > 0) {
            resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_full_rotate_margin_top);
        }
        super.mo16560b(activity, new LayoutItem(iArr, new int[]{0, 0, 0, 0}), c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16569f(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16569f(activity, new LayoutItem(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.vertical_effect_menu_margin_left), resources.getDimensionPixelOffset(R.dimen.vertical_effect_menu_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16559b(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16559b(activity, new LayoutItem(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_left), resources.getDimensionPixelOffset(R.dimen.full_screen_multi_video_select_view_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RotableTextView mo16550a(Activity activity, RelativeLayout relativeLayout, int OplusGLSurfaceView_13) {
        activity.getLayoutInflater().inflate(R.layout.burst_fold, relativeLayout);
        RotableTextView rotableTextView = (RotableTextView) activity.findViewById(R.id_renamed.burst_num_view_fold);
        rotableTextView.setBackground(activity.getResources().getDrawable(R.drawable.burst_num_bg_fold_black, null));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.fold_full_first_level_burst_num_view_margin_bottom);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: a_ */
    public void mo16573a_(Activity activity) throws Resources.NotFoundException {
        mo16566d(activity, (LayoutItem) null);
        mo16567e(activity, (LayoutItem) null);
        mo16562c(activity, (LayoutItem) null);
        mo16552a(activity, (LayoutItem) null, (LayoutItem) null, (LayoutItem) null);
        mo16560b(activity, null, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_container));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_click));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(Integer.valueOf(R.id_renamed.face_beauty_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.effect_menu_back_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.time_lapse_pro_record_layout));
        View[] viewArr = new View[arrayList.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            viewArr[OplusGLSurfaceView_13] = activity.findViewById(((Integer) arrayList.get(OplusGLSurfaceView_13)).intValue());
        }
        m16503a(viewArr);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 > this.f16009d && OplusGLSurfaceView_13 < this.f16005b - this.f16009d;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, true);
            Util.m24256a(activity, R.id_renamed.effect_menu_back_button, true);
            Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, true);
            Util.m24256a(activity, R.id_renamed.screen_mode_switch_button, true);
            Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, false);
            Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.recording_cap_button, R.drawable.switch_camera_button_gray_bg);
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, true);
            Util.m24256a(activity, R.id_renamed.effect_menu_back_button, true);
            Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, true);
            Util.m24256a(activity, R.id_renamed.screen_mode_switch_button, true);
            Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, true);
            Util.m24256a(activity, R.id_renamed.time_lapse_pro_template_button, true);
            Util.m24256a(activity, R.id_renamed.time_lapse_pro_setting_button, true);
            Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.recording_cap_button, R.drawable.switch_camera_button_gray_bg);
            return;
        }
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 6) {
            Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, false);
            Util.m24256a(activity, R.id_renamed.effect_menu_back_button, false);
            Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, false);
            Util.m24256a(activity, R.id_renamed.screen_mode_switch_button, false);
            Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, false);
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.recording_cap_button, R.drawable.switch_camera_button_bg);
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16501a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2) {
        Size sizeM24180I = Util.m24180I();
        Rect rectB = mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
        int iM24460i = Util.m24460i(R.dimen.professional_histogram_margin_start);
        int iM24460i2 = Util.m24460i(R.dimen.fold_full_professional_histogram_margin_left);
        aVar.f14812b = Util.m24460i(R.dimen.fold_full_professional_histogram_margin_top);
        aVar.f14815e = 0;
        if (rectB.left > iM24460i2) {
            aVar.f14814d = rectB.left + iM24460i;
        } else {
            aVar.f14814d = iM24460i2;
        }
    }

    @Override // com.oplus.camera.screen.p164b.FullScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        if (1 == Util.m24178H()) {
            layoutParams.rightMargin = Util.m24460i(R.dimen.fold_full_16_9_professional_params_container_margin_right);
        }
        return layoutParams;
    }
}
