package androidx.viewpager2.widget;

/* compiled from: CompositeOnPageChangeCallback.java */
/* loaded from: classes.dex */
final class b_renamed extends androidx.viewpager2.widget.ViewPager2.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<androidx.viewpager2.widget.ViewPager2.e_renamed> f1852a;

    b_renamed(int i_renamed) {
        this.f1852a = new java.util.ArrayList(i_renamed);
    }

    void a_renamed(androidx.viewpager2.widget.ViewPager2.e_renamed eVar) {
        this.f1852a.add(eVar);
    }

    void b_renamed(androidx.viewpager2.widget.ViewPager2.e_renamed eVar) {
        this.f1852a.remove(eVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
        try {
            java.util.Iterator<androidx.viewpager2.widget.ViewPager2.e_renamed> it = this.f1852a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i_renamed, f_renamed, i2);
            }
        } catch (java.util.ConcurrentModificationException e_renamed) {
            a_renamed(e_renamed);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageSelected(int i_renamed) {
        try {
            java.util.Iterator<androidx.viewpager2.widget.ViewPager2.e_renamed> it = this.f1852a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i_renamed);
            }
        } catch (java.util.ConcurrentModificationException e_renamed) {
            a_renamed(e_renamed);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
    public void onPageScrollStateChanged(int i_renamed) {
        try {
            java.util.Iterator<androidx.viewpager2.widget.ViewPager2.e_renamed> it = this.f1852a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i_renamed);
            }
        } catch (java.util.ConcurrentModificationException e_renamed) {
            a_renamed(e_renamed);
        }
    }

    private void a_renamed(java.util.ConcurrentModificationException concurrentModificationException) {
        throw new java.lang.IllegalStateException("Adding and removing callbacks during dispatch to callbacks is_renamed not supported", concurrentModificationException);
    }
}
