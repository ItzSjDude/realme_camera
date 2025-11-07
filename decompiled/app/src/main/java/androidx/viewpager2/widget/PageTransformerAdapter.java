package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: PageTransformerAdapter.java */
/* renamed from: androidx.viewpager2.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.AbstractC0845e {

    /* renamed from: PlatformImplementations.kt_3 */
    private final LinearLayoutManager f4929a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ViewPager2.InterfaceC0847g f4930b;

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageSelected(int OplusGLSurfaceView_13) {
    }

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f4929a = linearLayoutManager;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ViewPager2.InterfaceC0847g m5089a() {
        return this.f4930b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5090a(ViewPager2.InterfaceC0847g interfaceC0847g) {
        this.f4930b = interfaceC0847g;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        if (this.f4930b == null) {
            return;
        }
        float f2 = -COUIBaseListPopupWindow_12;
        for (int i3 = 0; i3 < this.f4929a.getChildCount(); i3++) {
            View childAt = this.f4929a.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned PlatformImplementations.kt_3 null child at pos %IntrinsicsJvm.kt_5/%IntrinsicsJvm.kt_5 while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f4929a.getChildCount())));
            }
            this.f4930b.m5079a(childAt, (this.f4929a.getPosition(childAt) - OplusGLSurfaceView_13) + f2);
        }
    }
}
