package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: FakeDrag.java */
/* renamed from: androidx.viewpager2.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
final class FakeDrag {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ViewPager2 f4926a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ScrollEventAdapter f4927b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RecyclerView f4928c;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter c0855e, RecyclerView recyclerView) {
        this.f4926a = viewPager2;
        this.f4927b = c0855e;
        this.f4928c = recyclerView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m5088a() {
        return this.f4927b.m5104d();
    }
}
