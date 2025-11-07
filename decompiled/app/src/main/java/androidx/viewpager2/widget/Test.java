package androidx.viewpager2.widget;

/* compiled from: PageTransformerAdapter.java */
/* loaded from: classes.dex */
final class d_renamed extends androidx.viewpager2.widget.ViewPager2.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.recyclerview.widget.LinearLayoutManager f1856a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.viewpager2.widget.ViewPager2.g_renamed f1857b;

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageScrollStateChanged(int i_renamed) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageSelected(int i_renamed) {
    }

    d_renamed(androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        this.f1856a = linearLayoutManager;
    }

    androidx.viewpager2.widget.ViewPager2.g_renamed a_renamed() {
        return this.f1857b;
    }

    void a_renamed(androidx.viewpager2.widget.ViewPager2.g_renamed gVar) {
        this.f1857b = gVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
        if (this.f1857b == null) {
            return;
        }
        float f2 = -f_renamed;
        for (int i3 = 0; i3 < this.f1856a.getChildCount(); i3++) {
            android.view.View childAt = this.f1856a.getChildAt(i3);
            if (childAt == null) {
                throw new java.lang.IllegalStateException(java.lang.String.format(java.util.Locale.US, "LayoutManager returned a_renamed null child at_renamed pos %d_renamed/%d_renamed while transforming pages", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(this.f1856a.getChildCount())));
            }
            this.f1857b.a_renamed(childAt, (this.f1856a.getPosition(childAt) - i_renamed) + f2);
        }
    }
}
