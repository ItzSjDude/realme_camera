package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.oplus.camera.CameraLog;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.GalleryBottomMenuLayout;
import com.oplus.camera.p172ui.inverse.InverseRelativeLayout;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.preview.PreviewLayoutInfo;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseScreenMode extends ScreenModeFacade {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Map<Integer, LayoutItem> f16004a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f16005b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f16006c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f16007d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ScreenRelativeLayout f16008e = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public int mo16494a(Activity activity, int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo16495a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo16502a(ScreenRelativeLayout screenRelativeLayout);

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16504a() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo16517i() {
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16497a(Activity activity) {
        if (this.f16007d) {
            return;
        }
        mo16506b(activity);
        this.f16007d = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16499a(Activity activity, LayoutItem c2949c) {
        c2949c.f16020c = new int[]{-1, Util.m24192T()};
        this.f16004a.put(Integer.valueOf(R.id_renamed.headline_view), c2949c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16503a(View... viewArr) {
        LayoutItem c2949c;
        for (View view : viewArr) {
            if (view != null && (c2949c = this.f16004a.get(Integer.valueOf(view.getId()))) != null) {
                LayoutUtil.m16635a(view, c2949c);
                view.requestLayout();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16498a(Activity activity, ScreenRelativeLayout screenRelativeLayout) {
        ScreenModeConst.f16034a = Util.getScreenWidth();
        ScreenModeConst.f16035b = Util.getScreenHeight();
        CameraLog.m12959b("BaseScreenMode", "sScreenWidth: " + ScreenModeConst.f16034a + ", sScreenHeight: " + ScreenModeConst.f16035b);
        LayoutUtil.m16634a(screenRelativeLayout);
        screenRelativeLayout.setRotation(0.0f);
        mo16502a(screenRelativeLayout);
        screenRelativeLayout.getLayoutParams().width = this.f16005b;
        screenRelativeLayout.getLayoutParams().height = this.f16006c;
        screenRelativeLayout.requestLayout();
        m16497a(activity);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16506b(Activity activity) {
        if (Util.m24495t()) {
            m16511d(activity);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m16505b() {
        return this.f16005b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (Util.m24495t()) {
            arrayList.add(ApsConstant.CAPTURE_MODE_ID_PHOTO);
            arrayList.add(ApsConstant.CAPTURE_MODE_STICKER);
            arrayList.add(ApsConstant.CAPTURE_MODE_BREENO_SCAN);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PreviewLayoutInfo mo16496a(Context context) {
        return new PreviewLayoutInfo(Util.getScreenWidth(), Util.getScreenHeight());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo16508c(Activity activity) {
        return activity.getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16511d(Activity activity) {
        if (activity.findViewById(R.id_renamed.gallery_container) != null) {
            return;
        }
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id_renamed.camera_root);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        this.f16008e = new ScreenRelativeLayout(activity);
        this.f16008e.setId(R.id_renamed.gallery_container);
        this.f16008e.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f16008e, 5);
        this.f16008e.setVisibility(8);
        InverseRelativeLayout inverseRelativeLayout = new InverseRelativeLayout(activity);
        inverseRelativeLayout.setId(R.id_renamed.gallery_pager_inverse_layout);
        inverseRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        inverseRelativeLayout.setBackgroundResource(R.color.gallery_preview_inverse_bg);
        this.f16008e.addView(inverseRelativeLayout);
        ViewPager2 viewPager2 = new ViewPager2(activity);
        viewPager2.setId(R.id_renamed.gallery_pager);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(14);
        viewPager2.setLayoutParams(layoutParams2);
        viewPager2.setHorizontalFadingEdgeEnabled(true);
        viewPager2.setOverScrollMode(0);
        viewPager2.setSaveEnabled(false);
        inverseRelativeLayout.addView(viewPager2);
        GalleryBottomMenuLayout c3229j = new GalleryBottomMenuLayout(activity);
        c3229j.setId(R.id_renamed.gallery_menu_panel);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.gallery_bottom_menu_bar_width), resources.getDimensionPixelOffset(R.dimen.gallery_bottom_menu_bar_height));
        layoutParams3.bottomMargin = resources.getDimensionPixelOffset(R.dimen.gallery_menu_panel_bottom_margin);
        layoutParams3.setMarginStart(resources.getDimensionPixelOffset(R.dimen.gallery_menu_panel_left_margin));
        layoutParams3.addRule(12);
        c3229j.setLayoutParams(layoutParams3);
        c3229j.setOrientation(0);
        c3229j.setBackgroundResource(R.drawable.bg_gallery_menu_panel);
        this.f16008e.addView(c3229j);
        InverseTextView inverseTextView = new InverseTextView(activity);
        inverseTextView.setId(R.id_renamed.gallery_preview_empty_view);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(R.dimen.gallery_preview_no_content_view_width), resources.getDimensionPixelOffset(R.dimen.gallery_preview_no_content_view_height));
        layoutParams4.addRule(15);
        layoutParams4.addRule(14);
        inverseTextView.setLayoutParams(layoutParams4);
        inverseTextView.setText(R.string.camera_gallery_preview_no_content);
        inverseTextView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.gallery_preview_no_content_text_size));
        inverseTextView.setTextColor(activity.getColor(R.color.color_white_with_30_percent_transparency));
        inverseTextView.setGravity(17);
        this.f16008e.addView(inverseTextView);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public RelativeLayout.LayoutParams mo16510d() throws Resources.NotFoundException {
        Resources resources = MyApplication.m11092d().getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelOffset(R.dimen.multicamera_type_layout_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, Util.m24187O() + resources.getDimensionPixelOffset(R.dimen.control_pane_margin_bottom_offset));
        return layoutParams;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public RelativeLayout.LayoutParams mo16512e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Util.getScreenWidth());
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = Util.m24187O();
        return layoutParams;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public RelativeLayout.LayoutParams mo16514f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) Util.m24456h(R.dimen.main_mode_bar_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout.LayoutParams mo16515g() {
        int iM24460i = Util.m24460i(R.dimen.sub_mode_bar_height);
        int iM24460i2 = Util.m24460i(R.dimen.main_mode_bar_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), iM24460i + Util.m24460i(R.dimen.professional_mode_panel_container_margin_bottom));
        layoutParams.setMargins(0, 0, 0, iM24460i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16501a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2) {
        int iM24460i = Util.m24460i(R.dimen.professional_histogram_margin_top);
        int iM24460i2 = Util.m24460i(R.dimen.professional_histogram_margin_start);
        int iM24460i3 = Util.m24460i(R.dimen.histogram_graph_view_width);
        int iM24460i4 = Util.m24460i(R.dimen.histogram_graph_view_height);
        if (i2 % 180 == 0) {
            aVar.f14812b = OplusGLSurfaceView_13 + iM24460i;
            aVar.f14814d = iM24460i2;
            aVar.f14815e = i2;
        } else {
            aVar.f14812b = ((iM24460i3 - iM24460i4) / 2) + OplusGLSurfaceView_13 + iM24460i;
            aVar.f14814d = ((iM24460i4 - iM24460i3) / 2) + iM24460i2;
            aVar.f14815e = (i2 + 180) % 360;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16500a(HistogramProcessorManager.PlatformImplementations.kt_3 aVar) {
        aVar.f14815e = 90;
        aVar.f14811a = 12;
        aVar.f14813c = Util.m24460i(R.dimen.movie_histogram_margin_bottom) + Util.m24318aG();
        aVar.f14814d = Util.m24460i(R.dimen.movie_histogram_margin_left);
        aVar.f14815e = 90;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16507b(Activity activity, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 0) {
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_gray_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_gray_bg);
        } else {
            Util.m24255a(activity, R.id_renamed.switch_camera_button, R.drawable.switch_camera_button_bg);
            Util.m24255a(activity, R.id_renamed.camera_from_other_app_close_btn, R.drawable.switch_camera_button_bg);
        }
    }

    public String toString() {
        return mo16516h();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16513e(Activity activity) {
        View viewFindViewById;
        if (activity == null || (viewFindViewById = activity.findViewById(R.id_renamed.frame_layout)) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParamsA = mo16549a(Util.m24180I());
        if (layoutParamsA != null) {
            viewFindViewById.setLayoutParams(layoutParamsA);
        } else {
            CameraLog.m12959b("BaseScreenMode", "relayoutPreviewFrame, layoutParams is null");
        }
    }
}
