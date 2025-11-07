package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: RackScreenMode270.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class RackScreenMode270 extends RackScreenMode {
    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: OplusGLSurfaceView_5 */
    public int mo16570k() {
        return 270;
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        super.mo16502a(screenRelativeLayout);
        screenRelativeLayout.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Rect mo16558b(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        Rect rect;
        this.f16005b = Util.getScreenHeight();
        this.f16006c = Util.getScreenWidth() / 2;
        float COUIBaseListPopupWindow_12 = i2 / OplusGLSurfaceView_13;
        if (COUIBaseListPopupWindow_12 > this.f16005b / this.f16006c) {
            int dimensionPixelOffset = MyApplication.m11092d().getResources().getDimensionPixelOffset(R.dimen.rack_mode_movie_mode_margin_top);
            int iRound = Math.round(this.f16005b / COUIBaseListPopupWindow_12);
            if (this.f16014d) {
                dimensionPixelOffset = (Util.getScreenWidth() - dimensionPixelOffset) - iRound;
            }
            rect = new Rect(dimensionPixelOffset, 0, iRound + dimensionPixelOffset, this.f16005b);
        } else {
            int i3 = this.f16006c;
            int iRound2 = Math.round(i3 * COUIBaseListPopupWindow_12);
            int i4 = (this.f16005b - iRound2) / 2;
            int screenWidth = this.f16014d ? Util.getScreenWidth() / 2 : 0;
            rect = new Rect(screenWidth, i4, i3 + screenWidth, iRound2 + i4);
        }
        this.f16016f = rect;
        return rect;
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16629f(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        LayoutItem c2949c2 = new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelSize(R.dimen.rack_mode_out_screen_preview_switch_button_margin_right), 0, 0, resources.getDimensionPixelSize(R.dimen.rack_mode_out_screen_preview_switch_button_margin_top)});
        c2949c2.f16021d = 270;
        super.mo16629f(activity, c2949c2);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16556a(Activity activity, boolean z, float COUIBaseListPopupWindow_12, float f2) {
        return ((float) ScreenModeConst.f16034a) - COUIBaseListPopupWindow_12 > ((float) activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height));
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public float[] mo16530a(View view, float COUIBaseListPopupWindow_12, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {r3[1] - f2, COUIBaseListPopupWindow_12 - r3[0]};
        fArr[0] = Math.min(Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = Math.min(Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16621a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2) {
        super.mo16621a(activity, c2949c, new LayoutItem(new int[]{11, 0, 12, 0}, new int[]{0, 0, activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_control_panel_button_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo16626d(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16626d(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_start) + Util.m24198Z(), 0, 0, resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo16623b(Activity activity, LayoutItem c2949c) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rack_mode_zoom_arc_seekbar_bg_circle_radius_offset) / 2;
        super.mo16623b(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{((-dimensionPixelSize) / 2) + dimensionPixelSize2 + Util.m24198Z(), 0, 0, ((dimensionPixelSize / 2) - resources.getDimensionPixelSize(R.dimen.rack_mode_zoom_focus_circle_margin_bottom)) - dimensionPixelSize2}));
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16622a(Activity activity, LayoutItem c2949c, LayoutItem c2949c2, LayoutItem c2949c3) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_start) + Util.m24198Z();
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

    @Override // com.oplus.camera.screen.p164b.RackScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo16625c(Activity activity, LayoutItem c2949c) {
        Resources resources = activity.getResources();
        super.mo16625c(activity, new LayoutItem(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(R.dimen.rack_mode_effect_button_margin_start) + Util.m24198Z(), 0, 0, resources.getDimensionPixelOffset(R.dimen.rack_mode_blur_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.p164b.RackScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListMo16509c = super.mo16509c();
        arrayListMo16509c.add("movie");
        return arrayListMo16509c;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return this.f16014d ? "low270" : "rack270";
    }
}
