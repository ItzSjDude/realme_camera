package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.preview.ZoomArcSeekBar;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: CommonScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CommonScreenMode extends BaseScreenMode {
    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16495a(boolean z) {
        return 0;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16524a(View view, BasicOptionItemList basicOptionItemList, Context context, int OplusGLSurfaceView_13) {
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16504a() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16528a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 || 2 == OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16533b(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo16517i() {
        return false;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo16539j() {
        return 0;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        this.f16005b = ScreenModeConst.f16034a;
        this.f16006c = ScreenModeConst.f16035b;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(final Activity activity) throws Resources.NotFoundException {
        super.mo16506b(activity);
        Resources resources = activity.getResources();
        int dimensionPixelSize = (-resources.getDimensionPixelSize(R.dimen.zoom_mark_button_size)) - resources.getDimensionPixelSize(R.dimen.zoom_click_margin_top);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.control_panel_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.zoom_click_margin_top);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_center_y);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout}, new int[]{0, 0, 0, dimensionPixelSize});
        c2949c.f16020c = new int[]{-1, -2};
        c2949c.f16021d = 0;
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_4$9A--AMwStlUnPFsbFFG16r6tn8M
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                this.COUIBaseListPopupWindow_12$0.m16518a(activity, dimensionPixelSize4, dimensionPixelSize6, dimensionPixelSize7, dimensionPixelSize5, dimensionPixelSize2, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{3, R.id_renamed.zoom_seek_bar}, new int[]{0, dimensionPixelSize3, 0, 0});
        c2949c2.f16020c = new int[]{-1, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_click), c2949c2);
        LayoutItem c2949c3 = new LayoutItem(new int[]{2, R.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom)});
        c2949c3.f16020c = new int[]{-2, resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_height)};
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_display_text), c2949c3);
        m16522i(activity);
        m16537f(activity);
        m16538g(activity);
        m16521h(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16518a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, View view) {
        ZoomArcSeekBar c3435af = (ZoomArcSeekBar) activity.findViewById(R.id_renamed.zoom_seek_bar);
        c3435af.getLayoutParams().width = -1;
        c3435af.getLayoutParams().height = OplusGLSurfaceView_13;
        c3435af.m23077a(this.f16005b, i2, i3, i4, (Util.m24188P() + i5) / 2.0f, 1.0f, 0.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m16521h(final Activity activity) throws Resources.NotFoundException {
        Resources resources = Util.m24472l().getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.menu_panel_layout_height);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
        LayoutItem c2949c = new LayoutItem(new int[]{10, 0}, new int[]{0, 0, 0, 0});
        c2949c.f16020c = new int[]{-1, -2};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_4$psDyPbhOpNS9vM2hrLp5KWtNY5A
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                CommonScreenMode.m16519a(activity, dimensionPixelSize, dimensionPixelSize2, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.oplus_slide_downward), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16519a(Activity activity, int OplusGLSurfaceView_13, int i2, View view) {
        CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = OplusGLSurfaceView_13;
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        CameraSettingMenuPanel cameraSettingMenuPanel2 = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m16537f(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_margin_bottom);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.horizontal_common_effect_button_margin_end);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout, 21, 0}, new int[]{0, 0, dimensionPixelOffset2, dimensionPixelOffset});
        c2949c.f16020c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f16004a.put(Integer.valueOf(R.id_renamed.face_beauty_enter_button), c2949c);
        activity.findViewById(R.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void m16538g(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_margin_right);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        LayoutItem c2949c = new LayoutItem(new int[]{2, R.id_renamed.control_panel_layout, 20, 0}, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        c2949c.f16020c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button), c2949c);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m16522i(final Activity activity) {
        LayoutItem c2949c = new LayoutItem(null, null);
        c2949c.f16020c = new int[]{0, 0};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$IntrinsicsJvm.kt_4$A5r_DQHHKX-F6pH9j0WMJ6sPPOw
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                CommonScreenMode.m16520a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.gallery_container), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16520a(Activity activity, View view) {
        ((RelativeLayout) activity.findViewById(R.id_renamed.gallery_container)).setVisibility(8);
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
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        return i2 >= cameraUIInterface.mo18149am() && i2 <= cameraUIInterface.mo18150an();
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
        return new ArrayList<>();
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 2) {
            Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, true);
            Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, true);
            return;
        }
        Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, false);
        Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, false);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_template_button, false);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_setting_button, false);
        Util.m24255a(activity, R.id_renamed.video_pause_resume, R.drawable.switch_camera_button_bg);
    }
}
