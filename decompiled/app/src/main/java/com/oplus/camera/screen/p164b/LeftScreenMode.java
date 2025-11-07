package com.oplus.camera.screen.p164b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.GalleryBottomMenuLayout;
import com.oplus.camera.p172ui.GalleryPreviewAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.inverse.InverseColorRelativeLayout;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.preview.PreviewLayoutInfo;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: LeftScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class LeftScreenMode extends LeftRightScreenMode {
    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return TtmlNode.LEFT;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: p */
    public int mo16602p() {
        return 0;
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        super.mo16502a(screenRelativeLayout);
        ((RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams()).addRule(9);
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16594f(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.control_panel_margin_top);
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0}, null);
        c2949c.f16020c = new int[]{-1, dimensionPixelOffset + dimensionPixelOffset2};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_13$LqrCmmCWkQrrk6nplIHginwUK1E
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                LeftScreenMode.m16601a(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_layout), c2949c);
        super.mo16594f(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16601a(View view) {
        ((InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(true);
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode
    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo16596i(final Activity activity) {
        LayoutItem c2949c = new LayoutItem(new int[]{11, 0}, null);
        c2949c.f16020c = new int[]{this.f16005b, this.f16006c};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_13$6xrt5IqO6u0YhJxyrMuXYZ9qP0A
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                LeftScreenMode.m16600a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.gallery_container), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16600a(Activity activity, View view) {
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id_renamed.gallery_container);
        ViewPager2 viewPager2 = (ViewPager2) relativeLayout.findViewById(R.id_renamed.gallery_pager);
        viewPager2.setLayoutAnimation(null);
        GalleryPreviewAdapter c3230k = (GalleryPreviewAdapter) viewPager2.getAdapter();
        if (c3230k == null || !c3230k.m20247a()) {
            return;
        }
        viewPager2.m5042a(c3230k.getItemCount() - 1, false);
        if (c3230k.getItemCount() == 0) {
            ((InverseTextView) activity.findViewById(R.id_renamed.gallery_preview_empty_view)).setVisibility(0);
            ((GalleryBottomMenuLayout) activity.findViewById(R.id_renamed.gallery_menu_panel)).setVisibility(4);
        }
        relativeLayout.setVisibility(0);
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        return i2 >= cameraUIInterface.mo18149am() && i2 <= cameraUIInterface.mo18150an() && OplusGLSurfaceView_13 <= this.f16005b;
    }

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public PreviewLayoutInfo mo16496a(Context context) {
        return new PreviewLayoutInfo(Util.getScreenWidth() / 2, Util.getScreenHeight());
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayList<String> mo16509c() {
        ArrayList<String> arrayListMo16509c = super.mo16509c();
        arrayListMo16509c.add(ApsConstant.REC_MODE_SLOW_VIDEO);
        arrayListMo16509c.add(ApsConstant.CAPTURE_MODE_PROFESSIONAL);
        return arrayListMo16509c;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RelativeLayout.LayoutParams mo16549a(Size size) throws Resources.NotFoundException {
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
    public Rect mo16558b(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        this.f16005b = Util.getScreenWidth() / 2;
        this.f16006c = Util.getScreenHeight();
        float COUIBaseListPopupWindow_12 = i2 / OplusGLSurfaceView_13;
        int iRound = Math.round(this.f16005b * COUIBaseListPopupWindow_12);
        int iA = (((this.f16006c - iRound) / 2) + m16583a(COUIBaseListPopupWindow_12)) - Util.m24472l().getResources().getDimensionPixelSize(R.dimen.fold_split_screen_front_preview_topMargin_offset);
        return new Rect(0, iA, this.f16005b, iRound + iA);
    }
}
