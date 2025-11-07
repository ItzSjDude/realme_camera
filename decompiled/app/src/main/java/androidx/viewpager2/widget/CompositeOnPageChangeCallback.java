package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositeOnPageChangeCallback.java */
/* renamed from: androidx.viewpager2.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.AbstractC0845e {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<ViewPager2.AbstractC0845e> f4925a;

    CompositeOnPageChangeCallback(int OplusGLSurfaceView_13) {
        this.f4925a = new ArrayList(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5086a(ViewPager2.AbstractC0845e abstractC0845e) {
        this.f4925a.add(abstractC0845e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5087b(ViewPager2.AbstractC0845e abstractC0845e) {
        this.f4925a.remove(abstractC0845e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        try {
            Iterator<ViewPager2.AbstractC0845e> it = this.f4925a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
            }
        } catch (ConcurrentModificationException COUIBaseListPopupWindow_8) {
            m5085a(COUIBaseListPopupWindow_8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageSelected(int OplusGLSurfaceView_13) {
        try {
            Iterator<ViewPager2.AbstractC0845e> it = this.f4925a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(OplusGLSurfaceView_13);
            }
        } catch (ConcurrentModificationException COUIBaseListPopupWindow_8) {
            m5085a(COUIBaseListPopupWindow_8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
    public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
        try {
            Iterator<ViewPager2.AbstractC0845e> it = this.f4925a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(OplusGLSurfaceView_13);
            }
        } catch (ConcurrentModificationException COUIBaseListPopupWindow_8) {
            m5085a(COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5085a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
