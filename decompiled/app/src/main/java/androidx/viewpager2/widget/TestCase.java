package androidx.viewpager2.widget;

/* compiled from: ScrollEventAdapter.java */
/* loaded from: classes.dex */
final class e_renamed extends androidx.recyclerview.widget.RecyclerView.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.viewpager2.widget.ViewPager2.e_renamed f1858a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.viewpager2.widget.ViewPager2 f1859b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.recyclerview.widget.RecyclerView f1860c;
    private final androidx.recyclerview.widget.LinearLayoutManager d_renamed;
    private int e_renamed;
    private int f_renamed;
    private androidx.viewpager2.widget.e_renamed.a_renamed g_renamed = new androidx.viewpager2.widget.e_renamed.a_renamed();
    private int h_renamed;
    private int i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;

    e_renamed(androidx.viewpager2.widget.ViewPager2 viewPager2) {
        this.f1859b = viewPager2;
        this.f1860c = this.f1859b.e_renamed;
        this.d_renamed = (androidx.recyclerview.widget.LinearLayoutManager) this.f1860c.getLayoutManager();
        f_renamed();
    }

    private void f_renamed() {
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed.a_renamed();
        this.h_renamed = -1;
        this.i_renamed = -1;
        this.j_renamed = false;
        this.k_renamed = false;
        this.m_renamed = false;
        this.l_renamed = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
        boolean z_renamed = true;
        if ((this.e_renamed != 1 || this.f_renamed != 1) && i_renamed == 1) {
            a_renamed(false);
            return;
        }
        if (h_renamed() && i_renamed == 2) {
            if (this.k_renamed) {
                a_renamed(2);
                this.j_renamed = true;
                return;
            }
            return;
        }
        if (h_renamed() && i_renamed == 0) {
            g_renamed();
            if (!this.k_renamed) {
                if (this.g_renamed.f1861a != -1) {
                    a_renamed(this.g_renamed.f1861a, 0.0f, 0);
                }
            } else if (this.g_renamed.f1863c != 0) {
                z_renamed = false;
            } else if (this.h_renamed != this.g_renamed.f1861a) {
                b_renamed(this.g_renamed.f1861a);
            }
            if (z_renamed) {
                a_renamed(0);
                f_renamed();
            }
        }
        if (this.e_renamed == 2 && i_renamed == 0 && this.l_renamed) {
            g_renamed();
            if (this.g_renamed.f1863c == 0) {
                if (this.i_renamed != this.g_renamed.f1861a) {
                    b_renamed(this.g_renamed.f1861a == -1 ? 0 : this.g_renamed.f1861a);
                }
                a_renamed(0);
                f_renamed();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x003d  */
    @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k_renamed = r4
            r3.g_renamed()
            boolean r0 = r3.j_renamed
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L41
            r3.j_renamed = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f1859b
            boolean r6 = r6.b_renamed()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = r2
            goto L23
        L22:
            r5 = r4
        L23:
            if (r5 == 0) goto L31
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1863c
            if (r5 == 0) goto L31
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
            int r5 = r5 + r4
            goto L35
        L31:
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
        L35:
            r3.i_renamed = r5
            int r5 = r3.h_renamed
            int r6 = r3.i_renamed
            if (r5 == r6) goto L4f
            r3.b_renamed(r6)
            goto L4f
        L41:
            int r5 = r3.e_renamed
            if (r5 != 0) goto L4f
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
            if (r5 != r1) goto L4c
            r5 = r2
        L4c:
            r3.b_renamed(r5)
        L4f:
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
            if (r5 != r1) goto L57
            r5 = r2
            goto L5b
        L57:
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
        L5b:
            androidx.viewpager2.widget.e_renamed$a_renamed r6 = r3.g_renamed
            float r6 = r6.f1862b
            androidx.viewpager2.widget.e_renamed$a_renamed r0 = r3.g_renamed
            int r0 = r0.f1863c
            r3.a_renamed(r5, r6, r0)
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1861a
            int r6 = r3.i_renamed
            if (r5 == r6) goto L70
            if (r6 != r1) goto L80
        L70:
            androidx.viewpager2.widget.e_renamed$a_renamed r5 = r3.g_renamed
            int r5 = r5.f1863c
            if (r5 != 0) goto L80
            int r5 = r3.f_renamed
            if (r5 == r4) goto L80
            r3.a_renamed(r2)
            r3.f_renamed()
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e_renamed.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void g_renamed() {
        int top;
        androidx.viewpager2.widget.e_renamed.a_renamed aVar = this.g_renamed;
        aVar.f1861a = this.d_renamed.findFirstVisibleItemPosition();
        if (aVar.f1861a == -1) {
            aVar.a_renamed();
            return;
        }
        android.view.View viewFindViewByPosition = this.d_renamed.findViewByPosition(aVar.f1861a);
        if (viewFindViewByPosition == null) {
            aVar.a_renamed();
            return;
        }
        int leftDecorationWidth = this.d_renamed.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.d_renamed.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.d_renamed.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.d_renamed.getBottomDecorationHeight(viewFindViewByPosition);
        android.view.ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + viewFindViewByPosition.getWidth() + leftDecorationWidth;
        if (this.d_renamed.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f1860c.getPaddingLeft();
            if (this.f1859b.b_renamed()) {
                top = -top;
            }
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f1860c.getPaddingTop();
            width = height;
        }
        aVar.f1863c = -top;
        if (aVar.f1863c < 0) {
            if (new androidx.viewpager2.widget.a_renamed(this.d_renamed).a_renamed()) {
                throw new java.lang.IllegalStateException("Page(s_renamed) contain a_renamed ViewGroup with a_renamed LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on_renamed all ViewGroups with a_renamed LayoutTransition before an_renamed animation is_renamed started.");
            }
            throw new java.lang.IllegalStateException(java.lang.String.format(java.util.Locale.US, "Page can only be_renamed offset by_renamed a_renamed positive amount, not by_renamed %d_renamed", java.lang.Integer.valueOf(aVar.f1863c)));
        }
        aVar.f1862b = width == 0 ? 0.0f : aVar.f1863c / width;
    }

    private void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
        this.e_renamed = z_renamed ? 4 : 1;
        int i_renamed = this.i_renamed;
        if (i_renamed != -1) {
            this.h_renamed = i_renamed;
            this.i_renamed = -1;
        } else if (this.h_renamed == -1) {
            this.h_renamed = i_renamed();
        }
        a_renamed(1);
    }

    void a_renamed() {
        this.l_renamed = true;
    }

    void a_renamed(int i_renamed, boolean z_renamed) {
        this.e_renamed = z_renamed ? 2 : 3;
        this.m_renamed = false;
        boolean z2 = this.i_renamed != i_renamed;
        this.i_renamed = i_renamed;
        a_renamed(2);
        if (z2) {
            b_renamed(i_renamed);
        }
    }

    void a_renamed(androidx.viewpager2.widget.ViewPager2.e_renamed eVar) {
        this.f1858a = eVar;
    }

    int b_renamed() {
        return this.f_renamed;
    }

    boolean c_renamed() {
        return this.f_renamed == 0;
    }

    boolean d_renamed() {
        return this.m_renamed;
    }

    private boolean h_renamed() {
        int i_renamed = this.e_renamed;
        return i_renamed == 1 || i_renamed == 4;
    }

    double e_renamed() {
        g_renamed();
        return this.g_renamed.f1861a + this.g_renamed.f1862b;
    }

    private void a_renamed(int i_renamed) {
        if ((this.e_renamed == 3 && this.f_renamed == 0) || this.f_renamed == i_renamed) {
            return;
        }
        this.f_renamed = i_renamed;
        androidx.viewpager2.widget.ViewPager2.e_renamed eVar = this.f1858a;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i_renamed);
        }
    }

    private void b_renamed(int i_renamed) {
        androidx.viewpager2.widget.ViewPager2.e_renamed eVar = this.f1858a;
        if (eVar != null) {
            eVar.onPageSelected(i_renamed);
        }
    }

    private void a_renamed(int i_renamed, float f_renamed, int i2) {
        androidx.viewpager2.widget.ViewPager2.e_renamed eVar = this.f1858a;
        if (eVar != null) {
            eVar.onPageScrolled(i_renamed, f_renamed, i2);
        }
    }

    private int i_renamed() {
        return this.d_renamed.findFirstVisibleItemPosition();
    }

    /* compiled from: ScrollEventAdapter.java */
    private static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1861a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f1862b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1863c;

        a_renamed() {
        }

        void a_renamed() {
            this.f1861a = -1;
            this.f1862b = 0.0f;
            this.f1863c = 0;
        }
    }
}
