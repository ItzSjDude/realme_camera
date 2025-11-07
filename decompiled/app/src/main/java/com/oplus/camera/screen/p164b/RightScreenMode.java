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
import com.oplus.camera.p172ui.GalleryBottomMenuLayout;
import com.oplus.camera.p172ui.GalleryPreviewAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.inverse.InverseColorRelativeLayout;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.preview.PreviewLayoutInfo;
import com.oplus.camera.screen.LayoutItem;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.util.Util;

/* compiled from: RightScreenMode.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class RightScreenMode extends LeftRightScreenMode {
    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public String mo16516h() {
        return TtmlNode.RIGHT;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: p */
    public int mo16602p() {
        return 1;
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode, com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16502a(ScreenRelativeLayout screenRelativeLayout) {
        super.mo16502a(screenRelativeLayout);
        ((RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams()).addRule(11);
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo16594f(Activity activity) throws Resources.NotFoundException {
        Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.control_panel_margin_top);
        LayoutItem c2949c = new LayoutItem(new int[]{12, 0}, null);
        c2949c.f16020c = new int[]{-1, dimensionPixelOffset + dimensionPixelOffset2};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_11$dgTbmGO4ZTzg0v8BKYws21Ks-dc
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RightScreenMode.m16633a(view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.control_panel_layout), c2949c);
        super.mo16594f(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16633a(View view) {
        ((InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(false);
    }

    @Override // com.oplus.camera.screen.p164b.LeftRightScreenMode
    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo16596i(final Activity activity) {
        LayoutItem c2949c = new LayoutItem(new int[]{9, 0}, null);
        c2949c.f16020c = new int[]{this.f16005b, this.f16006c};
        c2949c.f16023f = new LayoutItem.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_11$8GdaqbkcSHKdi7h2PO2SgwvancY
            @Override // com.oplus.camera.screen.LayoutItem.PlatformImplementations.kt_3
            public final void call(View view) {
                RightScreenMode.m16632a(activity, view);
            }
        };
        this.f16004a.put(Integer.valueOf(R.id_renamed.gallery_container), c2949c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m16632a(Activity activity, View view) {
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

    @Override // com.oplus.camera.screen.p164b.BaseScreenMode
    /* renamed from: PlatformImplementations.kt_3 */
    public PreviewLayoutInfo mo16496a(Context context) {
        Resources resources = context.getResources();
        PreviewLayoutInfo c3460w = new PreviewLayoutInfo(Util.getScreenWidth() / 2, Util.getScreenHeight());
        c3460w.m23885a(resources.getDimensionPixelOffset(R.dimen.fold_right_screen_start_x));
        return c3460w;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16529a(CameraUIInterface cameraUIInterface, int OplusGLSurfaceView_13, int i2) {
        return i2 >= cameraUIInterface.mo18149am() && i2 <= cameraUIInterface.mo18150an() && OplusGLSurfaceView_13 >= this.f16005b;
    }

    @Override // com.oplus.camera.screen.p164b.ScreenModeFacade
    /* renamed from: PlatformImplementations.kt_3 */
    public RelativeLayout.LayoutParams mo16549a(Size size) throws Resources.NotFoundException {
        if (size == null) {
            return null;
        }
        Rect rectMo16558b = mo16558b(size.getHeight(), size.getWidth());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectMo16558b.width(), rectMo16558b.height());
        layoutParams.addRule(11);
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
        int iA = (((this.f16006c - iRound) / 2) + m16583a(COUIBaseListPopupWindow_12)) - Util.m24472l().getResources().getDimensionPixelSize(R.dimen.fold_split_screen_back_preview_topMargin_offset);
        Rect rect = new Rect(0, iA, this.f16005b, iRound + iA);
        int screenWidth = Util.getScreenWidth() / 2;
        rect.left = screenWidth;
        rect.right += screenWidth;
        return rect;
    }
}
