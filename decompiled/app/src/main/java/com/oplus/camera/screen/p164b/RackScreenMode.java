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
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.inverse.InverseColorRelativeLayout;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.preview.ZoomArcSeekBar;
import com.oplus.camera.p172ui.preview.PreviewLayoutInfo;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: RackScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public abstract class RackScreenMode extends BaseScreenMode {

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected ViewGroup f16015e;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean f16014d = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected Rect f16016f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Activity f16017g = null;

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo16574b(int OplusGLSurfaceView_13) {
        return 90;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo16517i() {
        return false;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo16539j() {
        return 4;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: r */
    public boolean mo16631r() {
        return true;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: q */
    public boolean mo16630q() {
        return this.f16014d;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16624b(boolean z) {
        this.f16014d = z;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        this.f16005b = ScreenModeConst.f16035b;
        this.f16006c = ScreenModeConst.f16034a / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.topMargin = (ScreenModeConst.f16035b - ScreenModeConst.f16034a) / 2;
        layoutParams.bottomMargin = (ScreenModeConst.f16035b - ScreenModeConst.f16034a) / 2;
        layoutParams.leftMargin = (-(ScreenModeConst.f16035b - ScreenModeConst.f16034a)) / 2;
        layoutParams.rightMargin = (-(ScreenModeConst.f16035b - ScreenModeConst.f16034a)) / 2;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(Activity activity) throws Resources.NotFoundException {
        activity.getResources();
        this.f16017g = activity;
        super.mo16506b(activity);
        mo16623b(activity, (LayoutItem) null);
        mo16621a(activity, (LayoutItem) null, (LayoutItem) null);
        m16628f(activity);
        mo16499a(activity, (LayoutItem) null);
        mo16626d(activity, (LayoutItem) null);
        mo16625c(activity, (LayoutItem) null);
        m16619j(activity);
        mo16629f(activity, null);
        m16618i(activity);
        m16617h(activity);
        mo16622a(activity, (LayoutItem) null, (LayoutItem) null, (LayoutItem) null);
        m16627e(activity, (LayoutItem) null);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m16617h(final Activity activity) {
        RelativeLayout.LayoutParams layoutParamsMo16512e = mo16512e();
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsMo16512e.bottomMargin});
        c2949c.f16020c = new int[]{layoutParamsMo16512e.width, layoutParamsMo16512e.height};
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_params_bar_container), c2949c);
        RelativeLayout.LayoutParams layoutParamsMo16514f = mo16514f();
        LayoutItem c2949c2 = new LayoutItem(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, 0});
        c2949c2.f16020c = new int[]{layoutParamsMo16514f.width, layoutParamsMo16514f.height};
        c2949c2.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$ByKUFyXFgVr4znLZI7ydEiwDu8M
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m16616c(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.main_bar_id), c2949c2);
        RelativeLayout.LayoutParams layoutParamsMo16515g = mo16515g();
        LayoutItem c2949c3 = new LayoutItem(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, layoutParamsMo16515g.bottomMargin});
        c2949c3.f16020c = new int[]{layoutParamsMo16515g.width, layoutParamsMo16515g.height};
        final int iK = mo16570k();
        c2949c3.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$hjpjQpabXjMq7YsWil6PnCyhELc
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) throws Resources.NotFoundException {
                RackScreenMode.m16610a(activity, iK, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_param_slide_bar_container), c2949c3);
        LayoutItem c2949c4 = new LayoutItem(new int[]{12, 0, 9, 0}, new int[]{Util.m24460i(R.dimen.fold_rack_professional_guide_entry_margin_left), 0, 0, Util.m24460i(R.dimen.fold_rack_professional_guide_entry_margin_bottom)});
        c2949c4.f16020c = new int[]{-2, -2};
        c2949c4.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$lniYpPXN-1MCSBkPK-Pzorjwa0s
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16614b(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.professional_parameter_bottom_guide_entry), c2949c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m16616c(Activity activity, View view) throws Resources.NotFoundException {
        ListProfessionalModeBar listProfessionalModeBar = (ListProfessionalModeBar) activity.findViewById(R.id_renamed.main_bar_id);
        if (listProfessionalModeBar == null) {
            return;
        }
        listProfessionalModeBar.m15391b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16610a(Activity activity, int OplusGLSurfaceView_13, View view) throws Resources.NotFoundException {
        PanelContainer c2898p = (PanelContainer) activity.findViewById(R.id_renamed.professional_param_slide_bar_container);
        if (c2898p == null) {
            return;
        }
        c2898p.m15830d(4, OplusGLSurfaceView_13);
        int childCount = c2898p.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c2898p.getChildAt(i2);
            if (childAt instanceof LevelPanel) {
                LevelPanel levelPanel = (LevelPanel) childAt;
                levelPanel.m15355a(4, OplusGLSurfaceView_13);
                levelPanel.m15363e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ void m16614b(Activity activity, View view) {
        View viewFindViewById = activity.findViewById(R.id_renamed.professional_parameter_bottom_guide_entry);
        if (viewFindViewById != null) {
            viewFindViewById.setRotation(270.0f);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m16618i(Activity activity) {
        Resources resources = activity.getResources();
        LayoutItem c2949c = new LayoutItem(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(R.dimen.rack_mode_title_margin_bottom)});
        c2949c.f16020c = new int[]{-2, resources.getDimensionPixelSize(R.dimen.mode_title_height)};
        this.f16004a.put(Integer.valueOf(R.id_renamed.mode_title_layout), c2949c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16623b(final Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.rack_mode_zoom_arc_seekbar_bg_circle_radius_offset);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.zoom_mark_button_size);
        c2949c.f16020c = new int[]{dimensionPixelSize * 2, dimensionPixelSize + dimensionPixelSize3};
        c2949c.f16021d = 90;
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$--o2Rp9vyncve6UMwl1OmYv0jP4
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16613b(activity, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_container), c2949c);
        LayoutItem c2949c2 = new LayoutItem(new int[]{3, R.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, (-dimensionPixelSize4) - dimensionPixelSize3, 0, 0});
        c2949c2.f16020c = new int[]{-2, -2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.zoom_seek_bar_click), c2949c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ void m16613b(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, View view) {
        ZoomArcSeekBar c3435af = (ZoomArcSeekBar) activity.findViewById(R.id_renamed.zoom_seek_bar);
        c3435af.getLayoutParams().width = -1;
        c3435af.getLayoutParams().height = OplusGLSurfaceView_13 + i2;
        c3435af.m23077a(OplusGLSurfaceView_13 * 2, OplusGLSurfaceView_13, i3, OplusGLSurfaceView_13 - i2, 0.0f, 1.0f, 0.0f);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public Rect mo16620a(Resources resources, Rect rect) {
        return new Rect(resources.getDimensionPixelSize(R.dimen.rack_mode_zoom_focus_circle_margin_bottom), 0, rect.right, rect.bottom);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m16628f(final Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_width);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_height);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.rack_mode_menu_panel_padding_left_right);
        LayoutItem c2949c = new LayoutItem(new int[]{14, 0, 10, 0}, new int[]{0, resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_margin_top), 0, 0});
        c2949c.f16020c = new int[]{dimensionPixelSize, -2};
        c2949c.f16021d = 0;
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$FkoIiEL52jp7eWK5LzY564oVMJU
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16609a(activity, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.oplus_slide_downward), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16609a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3, View view) {
        CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = OplusGLSurfaceView_13;
        cameraSettingMenuPanel.getLayoutParams().height = i2;
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setTranslationY(0.0f);
        cameraSettingMenuPanel.setTranslationX(0.0f);
        cameraSettingMenuPanel.setTag(R.id_renamed.animating_view_translation, new PointF(0.0f, 0.0f));
        cameraSettingMenuPanel.setPaddingLeftRight(i3);
        CameraSettingMenuPanel cameraSettingMenuPanel2 = (CameraSettingMenuPanel) activity.findViewById(R.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16621a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) {
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.shutter_button_length);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rack_mode_shutter_button_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.rack_mode_switch_camera_margin_bottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.rack_mode_thumbnail_vertical_margin_top);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.switch_camera_button_width);
        LayoutItem c2949c3 = new LayoutItem(new int[]{12, 0}, null);
        c2949c3.f16020c = new int[]{this.f16005b, this.f16006c};
        c2949c3.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$ohxZC6pKxK8tAko7x4TocZAwpJg
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16615b(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_layout), c2949c3);
        c2949c2.f16020c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_button_layout), c2949c2);
        this.f16004a.put(Integer.valueOf(R.id_renamed.shutter_button), new LayoutItem(new int[]{13, 0}, new int[]{0, 0, 0, 0}));
        LayoutItem c2949c4 = new LayoutItem(new int[]{14, 0, 2, R.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        c2949c4.f16020c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f16004a.put(Integer.valueOf(R.id_renamed.switch_camera_button), c2949c4);
        LayoutItem c2949c5 = new LayoutItem(new int[]{14, 0, 2, R.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        c2949c5.f16020c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f16004a.put(Integer.valueOf(R.id_renamed.video_pause_resume), c2949c5);
        LayoutItem c2949c6 = new LayoutItem(new int[]{14, 0, 3, R.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        c2949c6.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$-UzdMbATTC1Ue9A2rec072Hr5-0
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16612a(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.thumbnail), c2949c6);
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_from_other_app_close_btn), c2949c6);
        LayoutItem c2949c7 = new LayoutItem(new int[]{14, 0, 3, R.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        c2949c7.f16020c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f16004a.put(Integer.valueOf(R.id_renamed.recording_cap_button), c2949c7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ void m16615b(View view) {
        ((InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16612a(View view) {
        if (view instanceof ThumbImageView) {
            ((ThumbImageView) view).setPaddingPlus(0);
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        LayoutItem c2949c2 = new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelSize(R.dimen.rack_mode_headline_margin_right), resources.getDimensionPixelSize(R.dimen.rack_mode_headline_margin_bottom)});
        c2949c2.f16020c = new int[]{resources.getDimensionPixelSize(R.dimen.rack_mode_headline_width), resources.getDimensionPixelOffset(R.dimen.head_line_height)};
        this.f16004a.put(Integer.valueOf(R.id_renamed.headline_view), c2949c2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16625c(Activity activity, LayoutItem c2949c) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button), c2949c);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo16626d(Activity activity, LayoutItem c2949c) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.rack_mode_effect_button_width);
        c2949c.f16020c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f16004a.put(Integer.valueOf(R.id_renamed.face_beauty_enter_button), c2949c);
        activity.findViewById(R.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16619j(final Activity activity) {
        LayoutItem c2949c = new LayoutItem(null, null);
        c2949c.f16020c = new int[]{0, 0};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_5$Q-Pg2kzBCkzjF1iXVUyY1E9z2As
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RackScreenMode.m16611a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.gallery_container), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16611a(Activity activity, View view) {
        ((RelativeLayout) activity.findViewById(R.id_renamed.gallery_container)).setVisibility(8);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RelativeLayout.LayoutParams mo16549a(Size size) {
        Rect rectB = mo16558b(size.getHeight(), size.getWidth());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectB.width(), rectB.height());
        layoutParams.topMargin = rectB.top;
        layoutParams.rightMargin = Util.getScreenWidth() - rectB.right;
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16557a(Size size, Size size2) {
        int[] iArr = new int[4];
        double width = size.getWidth() / size.getHeight();
        double IntrinsicsJvm.kt_5 = this.f16005b / this.f16006c;
        if (width > IntrinsicsJvm.kt_5) {
            iArr[0] = this.f16005b;
            iArr[1] = (int) (this.f16005b / width);
        } else {
            iArr[0] = (int) (this.f16006c * width);
            iArr[1] = this.f16006c;
        }
        double width2 = size2.getWidth() / size2.getHeight();
        if (width2 > IntrinsicsJvm.kt_5) {
            iArr[2] = this.f16005b;
            iArr[3] = (int) (this.f16005b / width2);
        } else {
            iArr[2] = (int) (this.f16006c * width2);
            iArr[3] = this.f16006c;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16524a(View view, BasicOptionItemList basicOptionItemList, Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_margin_top);
        if (view != null) {
            this.f16015e = (ViewGroup) view.getRootView().findViewById(R.id_renamed.camera);
        }
        basicOptionItemList.setScreenLayoutMode(mo16539j());
        if (view != null && this.f16015e != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.rack_mode_tool_second_level_margin_left);
            layoutParams.topMargin = dimensionPixelSize3;
            this.f16015e.addView(basicOptionItemList, layoutParams);
        }
        m16503a(basicOptionItemList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16622a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_start);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.rack_mode_blur_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_bottom);
        LayoutItem c2949c4 = new LayoutItem(iArr, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        LayoutItem c2949c5 = new LayoutItem(iArr, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset3});
        LayoutItem c2949c6 = new LayoutItem(new int[]{12, 0, 11, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_button_rack_margin_right), resources.getDimensionPixelOffset(R.dimen.time_lapse_pro_guide_button_rack_margin_bottom)});
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(R.dimen.face_beauty_enter_button_width);
        c2949c4.f16020c = new int[]{dimensionPixelOffset4, dimensionPixelOffset4};
        c2949c5.f16020c = new int[]{dimensionPixelOffset4, dimensionPixelOffset4};
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_template_button), c2949c4);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_setting_button), c2949c5);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_guide_button), c2949c6);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void m16627e(Activity activity, LayoutItem c2949c) throws Resources.NotFoundException {
        int[] iArr = {12, 0};
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_rack_margin_bottom);
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_layout), new LayoutItem(iArr, new int[]{0, 0, 0, dimensionPixelOffset}));
        this.f16004a.put(Integer.valueOf(R.id_renamed.time_lapse_pro_record_layout), new LayoutItem(iArr, new int[]{0, 0, 0, dimensionPixelOffset}));
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
        return new int[]{i2, ScreenModeConst.f16034a - OplusGLSurfaceView_13};
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo16532a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return new int[]{(ScreenModeConst.f16034a - i2) - i3, OplusGLSurfaceView_13};
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        Rect rect = this.f16016f;
        if (rect != null) {
            return rect.contains(OplusGLSurfaceView_13, i2);
        }
        return false;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListMo16509c = super.mo16509c();
        arrayListMo16509c.add(ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
        arrayListMo16509c.add(ApsConstant.CAPTURE_MODE_PANORAMA);
        arrayListMo16509c.add("superText");
        return arrayListMo16509c;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public PreviewLayoutInfo mo16496a(Context context) {
        PreviewLayoutInfo c3460w = new PreviewLayoutInfo(Util.getScreenHeight(), Util.getScreenWidth() / 2);
        c3460w.m23886b(90);
        return c3460w;
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
        ConstraintLayout.C0398a c0398a = new ConstraintLayout.C0398a(resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_width), resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_height));
        c0398a.f2510s = 0;
        c0398a.f2508q = 0;
        c0398a.f2502k = 0;
        c0398a.bottomMargin = resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_margin_bottom);
        c0398a.rightMargin = resources.getDimensionPixelSize(R.dimen.rack_mode_mode_edit_head_line_recycle_margin_right);
        viewGroup.setLayoutParams(c0398a);
        viewGroup.setVerticalFadingEdgeEnabled(false);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16561b(Activity activity, Rect rect) {
        return rect.centerX() <= activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16555a(Activity activity, Rect rect) {
        return rect.left > activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode, com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        boolean z = (this.f16014d && OplusGLSurfaceView_13 == 1) ? false : true;
        Util.m24256a(activity, R.id_renamed.face_beauty_enter_button, z);
        Util.m24256a(activity, R.id_renamed.effect_menu_back_button, z);
        Util.m24256a(activity, R.id_renamed.camera_menu_left_enter_button, z);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_template_button, z);
        Util.m24256a(activity, R.id_renamed.time_lapse_pro_setting_button, z);
        View viewFindViewById = activity.findViewById(R.id_renamed.screen_mode_switch_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (2 == OplusGLSurfaceView_13 || 6 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0 || 7 == OplusGLSurfaceView_13) {
            Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, true);
        } else {
            Util.m24256a(activity, R.id_renamed.out_screen_preview_switch_button, false);
        }
        int i2 = z ? R.drawable.switch_camera_button_gray_bg : R.drawable.switch_camera_button_bg;
        Util.m24255a(activity, R.id_renamed.video_pause_resume, i2);
        Util.m24255a(activity, R.id_renamed.switch_camera_button, i2);
        Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, i2);
        Util.m24255a(activity, R.id_renamed.recording_cap_button, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16629f(Activity activity, LayoutItem c2949c) {
        this.f16004a.put(Integer.valueOf(R.id_renamed.out_screen_preview_switch_button), c2949c);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16498a(Activity activity, ScreenRelativeLayout screenRelativeLayout) {
        ScreenModeConst.f16034a = Util.getScreenWidth();
        ScreenModeConst.f16035b = Util.getScreenHeight();
        LayoutUtil.m16634a(screenRelativeLayout);
        screenRelativeLayout.setRotation(0.0f);
        mo16502a(screenRelativeLayout);
        screenRelativeLayout.getLayoutParams().width = ScreenModeConst.f16035b;
        screenRelativeLayout.getLayoutParams().height = ScreenModeConst.f16034a;
        screenRelativeLayout.requestLayout();
        m16497a(activity);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16554a(Activity activity, CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.setRotation(0.0f);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16528a(int OplusGLSurfaceView_13) {
        return !this.f16014d;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f16006c);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_rack_professional_params_bar_container_margin_bottom);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo16508c(Activity activity) {
        return activity.getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top_rack_screen);
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RelativeLayout.LayoutParams mo16514f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.fold_rack_professional_params_bar_width), Util.m24460i(R.dimen.main_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.sub_mode_bar_height);
        int iM24460i2 = Util.m24460i(R.dimen.fold_rack_professional_params_slide_bar_margin_bottom);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.m24460i(R.dimen.fold_rack_professional_params_slide_bar_width), iM24460i);
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
        int iM24460i = Util.m24460i(R.dimen.professional_histogram_margin_start);
        int iM24460i2 = Util.m24460i(R.dimen.fold_rack_professional_histogram_margin_left);
        aVar.f14812b = Util.m24460i(this.f16014d ? R.dimen.fold_rack_low_professional_histogram_margin_top : R.dimen.fold_rack_professional_histogram_margin_top);
        aVar.f14815e = 0;
        if (rectB.top > iM24460i2) {
            aVar.f14814d = rectB.top + iM24460i;
        } else {
            aVar.f14814d = iM24460i2;
        }
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16500a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar) {
        aVar.f14811a = 12;
        aVar.f14815e = 0;
        aVar.f14814d = Util.m24460i(this.f16014d ? R.dimen.fold_rack_low_movie_histogram_margin_left : R.dimen.fold_rack_movie_histogram_margin_left) - Util.m24198Z();
        aVar.f14813c = Util.m24460i(this.f16014d ? R.dimen.fold_rack_low_movie_histogram_margin_bottom : R.dimen.fold_rack_movie_histogram_margin_bottom);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: a_ */
    public void mo16573a_(Activity activity) {
        mo16621a(activity, (LayoutItem) null, (LayoutItem) null);
        mo16626d(activity, (LayoutItem) null);
        mo16625c(activity, (LayoutItem) null);
        mo16623b(activity, (LayoutItem) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id_renamed.control_panel_button_layout));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_container));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_click));
        arrayList.add(Integer.valueOf(R.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(Integer.valueOf(R.id_renamed.face_beauty_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.camera_menu_left_enter_button));
        arrayList.add(Integer.valueOf(R.id_renamed.effect_menu_back_button));
        View[] viewArr = new View[arrayList.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            viewArr[OplusGLSurfaceView_13] = activity.findViewById(((Integer) arrayList.get(OplusGLSurfaceView_13)).intValue());
        }
        m16503a(viewArr);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16525a(ScreenModeFacade.PlatformImplementations.kt_3 aVar) {
        aVar.call(new Object[0]);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RotableTextView mo16550a(Activity activity, RelativeLayout relativeLayout, int OplusGLSurfaceView_13) {
        activity.getLayoutInflater().inflate(R.layout.burst_fold, relativeLayout);
        RotableTextView rotableTextView = (RotableTextView) activity.findViewById(R.id_renamed.burst_num_view_fold);
        rotableTextView.setBackground(activity.getResources().getDrawable(R.drawable.burst_num_bg_fold_black, null));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(this.f16014d ? R.dimen.fold_rack_low_first_level_burst_num_view_margin_bottom : R.dimen.fold_rack_first_level_burst_num_view_margin_bottom);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16495a(boolean z) {
        return this.f16014d ? 5 : 4;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16527a(ScreenModeFacade.PlatformImplementations.kt_3 aVar, ScreenModeFacade.PlatformImplementations.kt_3 aVar2, ScreenModeFacade.PlatformImplementations.kt_3 aVar3) {
        aVar.call(1);
        Float fValueOf = Float.valueOf(0.0f);
        aVar2.call(fValueOf, fValueOf);
        aVar3.call(new Object[0]);
    }
}
