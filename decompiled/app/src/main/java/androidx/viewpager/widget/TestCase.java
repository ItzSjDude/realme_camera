package androidx.viewpager.widget;

/* loaded from: classes.dex */
public class ViewPager extends android.view.ViewGroup {
    private int A_renamed;
    private boolean B_renamed;
    private boolean C_renamed;
    private int D_renamed;
    private int E_renamed;
    private int F_renamed;
    private float G_renamed;
    private float H_renamed;
    private float I_renamed;
    private float J_renamed;
    private int K_renamed;
    private android.view.VelocityTracker L_renamed;
    private int M_renamed;
    private int N_renamed;
    private int O_renamed;
    private int P_renamed;
    private boolean Q_renamed;
    private android.widget.EdgeEffect R_renamed;
    private android.widget.EdgeEffect S_renamed;
    private boolean T_renamed;
    private boolean U_renamed;
    private boolean V_renamed;
    private int W_renamed;
    private java.util.List<androidx.viewpager.widget.ViewPager.f_renamed> aa_renamed;
    private androidx.viewpager.widget.ViewPager.f_renamed ab_renamed;
    private androidx.viewpager.widget.ViewPager.f_renamed ac_renamed;
    private java.util.List<androidx.viewpager.widget.ViewPager.e_renamed> ad_renamed;
    private androidx.viewpager.widget.ViewPager.g_renamed ae_renamed;
    private int af_renamed;
    private int ag_renamed;
    private java.util.ArrayList<android.view.View> ah_renamed;
    private final java.lang.Runnable aj_renamed;
    private int ak_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.viewpager.widget.a_renamed f1799b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1800c;
    private int d_renamed;
    private final java.util.ArrayList<androidx.viewpager.widget.ViewPager.b_renamed> g_renamed;
    private final androidx.viewpager.widget.ViewPager.b_renamed h_renamed;
    private final android.graphics.Rect i_renamed;
    private int j_renamed;
    private android.os.Parcelable k_renamed;
    private java.lang.ClassLoader l_renamed;
    private android.widget.Scroller m_renamed;
    private boolean n_renamed;
    private androidx.viewpager.widget.ViewPager.h_renamed o_renamed;
    private int p_renamed;
    private android.graphics.drawable.Drawable q_renamed;
    private int r_renamed;
    private int s_renamed;
    private float t_renamed;
    private float u_renamed;
    private int v_renamed;
    private int w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private boolean z_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    static final int[] f1798a = {android.R_renamed.attr.layout_gravity};
    private static final java.util.Comparator<androidx.viewpager.widget.ViewPager.b_renamed> e_renamed = new java.util.Comparator<androidx.viewpager.widget.ViewPager.b_renamed>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.viewpager.widget.ViewPager.b_renamed bVar, androidx.viewpager.widget.ViewPager.b_renamed bVar2) {
            return bVar.f1805b - bVar2.f1805b;
        }
    };
    private static final android.view.animation.Interpolator f_renamed = new android.view.animation.Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final androidx.viewpager.widget.ViewPager.i_renamed ai_renamed = new androidx.viewpager.widget.ViewPager.i_renamed();

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Inherited
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface a_renamed {
    }

    public interface e_renamed {
        void onAdapterChanged(androidx.viewpager.widget.ViewPager viewPager, androidx.viewpager.widget.a_renamed aVar, androidx.viewpager.widget.a_renamed aVar2);
    }

    public interface f_renamed {
        void onPageScrollStateChanged(int i_renamed);

        void onPageScrolled(int i_renamed, float f_renamed, int i2);

        void onPageSelected(int i_renamed);
    }

    public interface g_renamed {
        void a_renamed(android.view.View view, float f_renamed);
    }

    static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.Object f1804a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1805b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1806c;
        float d_renamed;
        float e_renamed;

        b_renamed() {
        }
    }

    public ViewPager(android.content.Context context) {
        super(context);
        this.g_renamed = new java.util.ArrayList<>();
        this.h_renamed = new androidx.viewpager.widget.ViewPager.b_renamed();
        this.i_renamed = new android.graphics.Rect();
        this.j_renamed = -1;
        this.k_renamed = null;
        this.l_renamed = null;
        this.t_renamed = -3.4028235E38f;
        this.u_renamed = Float.MAX_VALUE;
        this.A_renamed = 1;
        this.K_renamed = -1;
        this.T_renamed = true;
        this.U_renamed = false;
        this.aj_renamed = new java.lang.Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                androidx.viewpager.widget.ViewPager.this.setScrollState(0);
                androidx.viewpager.widget.ViewPager.this.c_renamed();
            }
        };
        this.ak_renamed = 0;
        a_renamed();
    }

    public ViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g_renamed = new java.util.ArrayList<>();
        this.h_renamed = new androidx.viewpager.widget.ViewPager.b_renamed();
        this.i_renamed = new android.graphics.Rect();
        this.j_renamed = -1;
        this.k_renamed = null;
        this.l_renamed = null;
        this.t_renamed = -3.4028235E38f;
        this.u_renamed = Float.MAX_VALUE;
        this.A_renamed = 1;
        this.K_renamed = -1;
        this.T_renamed = true;
        this.U_renamed = false;
        this.aj_renamed = new java.lang.Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                androidx.viewpager.widget.ViewPager.this.setScrollState(0);
                androidx.viewpager.widget.ViewPager.this.c_renamed();
            }
        };
        this.ak_renamed = 0;
        a_renamed();
    }

    void a_renamed() {
        setWillNotDraw(false);
        setDescendantFocusability(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        setFocusable(true);
        android.content.Context context = getContext();
        this.m_renamed = new android.widget.Scroller(context, f_renamed);
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F_renamed = viewConfiguration.getScaledPagingTouchSlop();
        this.M_renamed = (int) (400.0f * f2);
        this.N_renamed = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R_renamed = new android.widget.EdgeEffect(context);
        this.S_renamed = new android.widget.EdgeEffect(context);
        this.O_renamed = (int) (25.0f * f2);
        this.P_renamed = (int) (2.0f * f2);
        this.D_renamed = (int) (f2 * 16.0f);
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.viewpager.widget.ViewPager.d_renamed());
        if (androidx.core.h_renamed.v_renamed.f_renamed(this) == 0) {
            androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.core.h_renamed.q_renamed() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: b_renamed, reason: collision with root package name */
            private final android.graphics.Rect f1803b = new android.graphics.Rect();

            @Override // androidx.core.h_renamed.q_renamed
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar) {
                androidx.core.h_renamed.ad_renamed adVarA = androidx.core.h_renamed.v_renamed.a_renamed(view, adVar);
                if (adVarA.f_renamed()) {
                    return adVarA;
                }
                android.graphics.Rect rect = this.f1803b;
                rect.left = adVarA.a_renamed();
                rect.top = adVarA.b_renamed();
                rect.right = adVarA.c_renamed();
                rect.bottom = adVarA.d_renamed();
                int childCount = androidx.viewpager.widget.ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    androidx.core.h_renamed.ad_renamed adVarB = androidx.core.h_renamed.v_renamed.b_renamed(androidx.viewpager.widget.ViewPager.this.getChildAt(i2), adVarA);
                    rect.left = java.lang.Math.min(adVarB.a_renamed(), rect.left);
                    rect.top = java.lang.Math.min(adVarB.b_renamed(), rect.top);
                    rect.right = java.lang.Math.min(adVarB.c_renamed(), rect.right);
                    rect.bottom = java.lang.Math.min(adVarB.d_renamed(), rect.bottom);
                }
                return adVarA.a_renamed(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj_renamed);
        android.widget.Scroller scroller = this.m_renamed;
        if (scroller != null && !scroller.isFinished()) {
            this.m_renamed.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i2) {
        if (this.ak_renamed == i2) {
            return;
        }
        this.ak_renamed = i2;
        if (this.ae_renamed != null) {
            b_renamed(i2 != 0);
        }
        f_renamed(i2);
    }

    public void setAdapter(androidx.viewpager.widget.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        androidx.viewpager.widget.a_renamed aVar2 = this.f1799b;
        if (aVar2 != null) {
            aVar2.c_renamed(null);
            this.f1799b.a_renamed((android.view.ViewGroup) this);
            for (int i2 = 0; i2 < this.g_renamed.size(); i2++) {
                androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(i2);
                this.f1799b.a_renamed((android.view.ViewGroup) this, bVar.f1805b, bVar.f1804a);
            }
            this.f1799b.b_renamed((android.view.ViewGroup) this);
            this.g_renamed.clear();
            f_renamed();
            this.f1800c = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a_renamed aVar3 = this.f1799b;
        this.f1799b = aVar;
        this.d_renamed = 0;
        if (this.f1799b != null) {
            if (this.o_renamed == null) {
                this.o_renamed = new androidx.viewpager.widget.ViewPager.h_renamed();
            }
            this.f1799b.c_renamed(this.o_renamed);
            this.z_renamed = false;
            boolean z_renamed = this.T_renamed;
            this.T_renamed = true;
            this.d_renamed = this.f1799b.a_renamed();
            if (this.j_renamed >= 0) {
                this.f1799b.a_renamed(this.k_renamed, this.l_renamed);
                a_renamed(this.j_renamed, false, true);
                this.j_renamed = -1;
                this.k_renamed = null;
                this.l_renamed = null;
            } else if (!z_renamed) {
                c_renamed();
            } else {
                requestLayout();
            }
        }
        java.util.List<androidx.viewpager.widget.ViewPager.e_renamed> list = this.ad_renamed;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.ad_renamed.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.ad_renamed.get(i3).onAdapterChanged(this, aVar3, aVar);
        }
    }

    private void f_renamed() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((androidx.viewpager.widget.ViewPager.c_renamed) getChildAt(i2).getLayoutParams()).f1807a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public androidx.viewpager.widget.a_renamed getAdapter() {
        return this.f1799b;
    }

    public void a_renamed(androidx.viewpager.widget.ViewPager.e_renamed eVar) {
        if (this.ad_renamed == null) {
            this.ad_renamed = new java.util.ArrayList();
        }
        this.ad_renamed.add(eVar);
    }

    public void b_renamed(androidx.viewpager.widget.ViewPager.e_renamed eVar) {
        java.util.List<androidx.viewpager.widget.ViewPager.e_renamed> list = this.ad_renamed;
        if (list != null) {
            list.remove(eVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) throws android.content.res.Resources.NotFoundException {
        this.z_renamed = false;
        a_renamed(i2, !this.T_renamed, false);
    }

    public void a_renamed(int i2, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.z_renamed = false;
        a_renamed(i2, z_renamed, false);
    }

    public int getCurrentItem() {
        return this.f1800c;
    }

    void a_renamed(int i2, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        a_renamed(i2, z_renamed, z2, 0);
    }

    void a_renamed(int i2, boolean z_renamed, boolean z2, int i3) throws android.content.res.Resources.NotFoundException {
        androidx.viewpager.widget.a_renamed aVar = this.f1799b;
        if (aVar == null || aVar.a_renamed() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f1800c == i2 && this.g_renamed.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f1799b.a_renamed()) {
            i2 = this.f1799b.a_renamed() - 1;
        }
        int i4 = this.A_renamed;
        int i5 = this.f1800c;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.g_renamed.size(); i6++) {
                this.g_renamed.get(i6).f1806c = true;
            }
        }
        boolean z3 = this.f1800c != i2;
        if (this.T_renamed) {
            this.f1800c = i2;
            if (z3) {
                e_renamed(i2);
            }
            requestLayout();
            return;
        }
        a_renamed(i2);
        a_renamed(i2, z_renamed, i3, z3);
    }

    private void a_renamed(int i2, boolean z_renamed, int i3, boolean z2) throws android.content.res.Resources.NotFoundException {
        androidx.viewpager.widget.ViewPager.b_renamed bVarB = b_renamed(i2);
        int clientWidth = bVarB != null ? (int) (getClientWidth() * java.lang.Math.max(this.t_renamed, java.lang.Math.min(bVarB.e_renamed, this.u_renamed))) : 0;
        if (z_renamed) {
            a_renamed(clientWidth, 0, i3);
            if (z2) {
                e_renamed(i2);
                return;
            }
            return;
        }
        if (z2) {
            e_renamed(i2);
        }
        a_renamed(false);
        scrollTo(clientWidth, 0);
        d_renamed(clientWidth);
    }

    @java.lang.Deprecated
    public void setOnPageChangeListener(androidx.viewpager.widget.ViewPager.f_renamed fVar) {
        this.ab_renamed = fVar;
    }

    public void a_renamed(androidx.viewpager.widget.ViewPager.f_renamed fVar) {
        if (this.aa_renamed == null) {
            this.aa_renamed = new java.util.ArrayList();
        }
        this.aa_renamed.add(fVar);
    }

    public void b_renamed(androidx.viewpager.widget.ViewPager.f_renamed fVar) {
        java.util.List<androidx.viewpager.widget.ViewPager.f_renamed> list = this.aa_renamed;
        if (list != null) {
            list.remove(fVar);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.ag_renamed == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((androidx.viewpager.widget.ViewPager.c_renamed) this.ah_renamed.get(i3).getLayoutParams()).f_renamed;
    }

    public int getOffscreenPageLimit() {
        return this.A_renamed;
    }

    public void setOffscreenPageLimit(int i2) throws android.content.res.Resources.NotFoundException {
        if (i2 < 1) {
            android.util.Log.w_renamed("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.A_renamed) {
            this.A_renamed = i2;
            c_renamed();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.p_renamed;
        this.p_renamed = i2;
        int width = getWidth();
        a_renamed(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p_renamed;
    }

    public void setPageMarginDrawable(android.graphics.drawable.Drawable drawable) {
        this.q_renamed = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q_renamed;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        android.graphics.drawable.Drawable drawable = this.q_renamed;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float a_renamed(float f2) {
        return (float) java.lang.Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void a_renamed(int i2, int i3, int i4) throws android.content.res.Resources.NotFoundException {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        android.widget.Scroller scroller = this.m_renamed;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.n_renamed ? this.m_renamed.getCurrX() : this.m_renamed.getStartX();
            this.m_renamed.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a_renamed(false);
            c_renamed();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fA_renamed = f3 + (a_renamed(java.lang.Math.min(1.0f, (java.lang.Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs2 = java.lang.Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = java.lang.Math.round(java.lang.Math.abs(fA_renamed / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((java.lang.Math.abs(i6) / ((f2 * this.f1799b.b_renamed(this.f1800c)) + this.p_renamed)) + 1.0f) * 100.0f);
        }
        int iMin = java.lang.Math.min(iAbs, 600);
        this.n_renamed = false;
        this.m_renamed.startScroll(i5, scrollY, i6, i7, iMin);
        androidx.core.h_renamed.v_renamed.e_renamed(this);
    }

    androidx.viewpager.widget.ViewPager.b_renamed a_renamed(int i2, int i3) {
        androidx.viewpager.widget.ViewPager.b_renamed bVar = new androidx.viewpager.widget.ViewPager.b_renamed();
        bVar.f1805b = i2;
        bVar.f1804a = this.f1799b.a_renamed((android.view.ViewGroup) this, i2);
        bVar.d_renamed = this.f1799b.b_renamed(i2);
        if (i3 < 0 || i3 >= this.g_renamed.size()) {
            this.g_renamed.add(bVar);
        } else {
            this.g_renamed.add(i3, bVar);
        }
        return bVar;
    }

    void b_renamed() throws android.content.res.Resources.NotFoundException {
        int iA = this.f1799b.a_renamed();
        this.d_renamed = iA;
        boolean z_renamed = this.g_renamed.size() < (this.A_renamed * 2) + 1 && this.g_renamed.size() < iA;
        int iMax = this.f1800c;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.g_renamed.size()) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(i2);
            int iA2 = this.f1799b.a_renamed(bVar.f1804a);
            if (iA2 != -1) {
                if (iA2 == -2) {
                    this.g_renamed.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f1799b.a_renamed((android.view.ViewGroup) this);
                        z2 = true;
                    }
                    this.f1799b.a_renamed((android.view.ViewGroup) this, bVar.f1805b, bVar.f1804a);
                    if (this.f1800c == bVar.f1805b) {
                        iMax = java.lang.Math.max(0, java.lang.Math.min(this.f1800c, iA - 1));
                    }
                } else if (bVar.f1805b != iA2) {
                    if (bVar.f1805b == this.f1800c) {
                        iMax = iA2;
                    }
                    bVar.f1805b = iA2;
                }
                z_renamed = true;
            }
            i2++;
        }
        if (z2) {
            this.f1799b.b_renamed((android.view.ViewGroup) this);
        }
        java.util.Collections.sort(this.g_renamed, e_renamed);
        if (z_renamed) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                androidx.viewpager.widget.ViewPager.c_renamed cVar = (androidx.viewpager.widget.ViewPager.c_renamed) getChildAt(i3).getLayoutParams();
                if (!cVar.f1807a) {
                    cVar.f1809c = 0.0f;
                }
            }
            a_renamed(iMax, false, true);
            requestLayout();
        }
    }

    void c_renamed() throws android.content.res.Resources.NotFoundException {
        a_renamed(this.f1800c);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:28:0x006a, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x00fe A_renamed[PHI: r7 r10 r15
      0x00fe: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B_renamed:63:0x00f3, B_renamed:60:0x00dd, B_renamed:54:0x00c7] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r10v4 int) = (r10v3 int), (r10v2 int), (r10v7 int) binds: [B_renamed:63:0x00f3, B_renamed:60:0x00dd, B_renamed:54:0x00c7] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r15v6 int) = (r15v4 int), (r15v5 int), (r15v9 int) binds: [B_renamed:63:0x00f3, B_renamed:60:0x00dd, B_renamed:54:0x00c7] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a_renamed(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a_renamed(int):void");
    }

    private void g_renamed() {
        if (this.ag_renamed != 0) {
            java.util.ArrayList<android.view.View> arrayList = this.ah_renamed;
            if (arrayList == null) {
                this.ah_renamed = new java.util.ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ah_renamed.add(getChildAt(i2));
            }
            java.util.Collections.sort(this.ah_renamed, ai_renamed);
        }
    }

    private void a_renamed(androidx.viewpager.widget.ViewPager.b_renamed bVar, int i2, androidx.viewpager.widget.ViewPager.b_renamed bVar2) {
        androidx.viewpager.widget.ViewPager.b_renamed bVar3;
        androidx.viewpager.widget.ViewPager.b_renamed bVar4;
        int iA = this.f1799b.a_renamed();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.p_renamed / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f1805b;
            if (i3 < bVar.f1805b) {
                float fB_renamed = bVar2.e_renamed + bVar2.d_renamed + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f1805b && i5 < this.g_renamed.size()) {
                    androidx.viewpager.widget.ViewPager.b_renamed bVar5 = this.g_renamed.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.f1805b || i5 >= this.g_renamed.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.g_renamed.get(i5);
                    }
                    while (i4 < bVar4.f1805b) {
                        fB_renamed += this.f1799b.b_renamed(i4) + f2;
                        i4++;
                    }
                    bVar4.e_renamed = fB_renamed;
                    fB_renamed += bVar4.d_renamed + f2;
                    i4++;
                }
            } else if (i3 > bVar.f1805b) {
                int size = this.g_renamed.size() - 1;
                float fB2 = bVar2.e_renamed;
                while (true) {
                    i3--;
                    if (i3 < bVar.f1805b || size < 0) {
                        break;
                    }
                    androidx.viewpager.widget.ViewPager.b_renamed bVar6 = this.g_renamed.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i3 >= bVar3.f1805b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.g_renamed.get(size);
                    }
                    while (i3 > bVar3.f1805b) {
                        fB2 -= this.f1799b.b_renamed(i3) + f2;
                        i3--;
                    }
                    fB2 -= bVar3.d_renamed + f2;
                    bVar3.e_renamed = fB2;
                }
            }
        }
        int size2 = this.g_renamed.size();
        float fB3 = bVar.e_renamed;
        int i6 = bVar.f1805b - 1;
        this.t_renamed = bVar.f1805b == 0 ? bVar.e_renamed : -3.4028235E38f;
        int i7 = iA - 1;
        this.u_renamed = bVar.f1805b == i7 ? (bVar.e_renamed + bVar.d_renamed) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar7 = this.g_renamed.get(i8);
            while (i6 > bVar7.f1805b) {
                fB3 -= this.f1799b.b_renamed(i6) + f2;
                i6--;
            }
            fB3 -= bVar7.d_renamed + f2;
            bVar7.e_renamed = fB3;
            if (bVar7.f1805b == 0) {
                this.t_renamed = fB3;
            }
            i8--;
            i6--;
        }
        float fB4 = bVar.e_renamed + bVar.d_renamed + f2;
        int i9 = bVar.f1805b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar8 = this.g_renamed.get(i10);
            while (i9 < bVar8.f1805b) {
                fB4 += this.f1799b.b_renamed(i9) + f2;
                i9++;
            }
            if (bVar8.f1805b == i7) {
                this.u_renamed = (bVar8.d_renamed + fB4) - 1.0f;
            }
            bVar8.e_renamed = fB4;
            fB4 += bVar8.d_renamed + f2;
            i10++;
            i9++;
        }
        this.U_renamed = false;
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.viewpager.widget.ViewPager.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.viewpager.widget.ViewPager.SavedState>() { // from class: androidx.viewpager.widget.ViewPager.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.viewpager.widget.ViewPager.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.viewpager.widget.ViewPager.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.viewpager.widget.ViewPager.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.viewpager.widget.ViewPager.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.viewpager.widget.ViewPager.SavedState[] newArray(int i_renamed) {
                return new androidx.viewpager.widget.ViewPager.SavedState[i_renamed];
            }
        };
        android.os.Parcelable adapterState;
        java.lang.ClassLoader loader;
        int position;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i_renamed);
        }

        public java.lang.String toString() {
            return "FragmentPager.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        androidx.viewpager.widget.ViewPager.SavedState savedState = new androidx.viewpager.widget.ViewPager.SavedState(super.onSaveInstanceState());
        savedState.position = this.f1800c;
        androidx.viewpager.widget.a_renamed aVar = this.f1799b;
        if (aVar != null) {
            savedState.adapterState = aVar.b_renamed();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) throws android.content.res.Resources.NotFoundException {
        if (!(parcelable instanceof androidx.viewpager.widget.ViewPager.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.viewpager.widget.ViewPager.SavedState savedState = (androidx.viewpager.widget.ViewPager.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a_renamed aVar = this.f1799b;
        if (aVar != null) {
            aVar.a_renamed(savedState.adapterState, savedState.loader);
            a_renamed(savedState.position, false, true);
        } else {
            this.j_renamed = savedState.position;
            this.k_renamed = savedState.adapterState;
            this.l_renamed = savedState.loader;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i2, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        androidx.viewpager.widget.ViewPager.c_renamed cVar = (androidx.viewpager.widget.ViewPager.c_renamed) layoutParams;
        cVar.f1807a |= c_renamed(view);
        if (this.x_renamed) {
            if (cVar != null && cVar.f1807a) {
                throw new java.lang.IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.d_renamed = true;
            addViewInLayout(view, i2, layoutParams);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    private static boolean c_renamed(android.view.View view) {
        return view.getClass().getAnnotation(androidx.viewpager.widget.ViewPager.a_renamed.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(android.view.View view) {
        if (this.x_renamed) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    androidx.viewpager.widget.ViewPager.b_renamed a_renamed(android.view.View view) {
        for (int i2 = 0; i2 < this.g_renamed.size(); i2++) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(i2);
            if (this.f1799b.a_renamed(view, bVar.f1804a)) {
                return bVar;
            }
        }
        return null;
    }

    androidx.viewpager.widget.ViewPager.b_renamed b_renamed(android.view.View view) {
        while (true) {
            java.lang.Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof android.view.View)) {
                    return null;
                }
                view = (android.view.View) parent;
            } else {
                return a_renamed(view);
            }
        }
    }

    androidx.viewpager.widget.ViewPager.b_renamed b_renamed(int i2) {
        for (int i3 = 0; i3 < this.g_renamed.size(); i3++) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(i3);
            if (bVar.f1805b == i2) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T_renamed = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) throws android.content.res.Resources.NotFoundException {
        androidx.viewpager.widget.ViewPager.c_renamed cVar;
        androidx.viewpager.widget.ViewPager.c_renamed cVar2;
        int i4;
        int i5;
        int i6;
        boolean z_renamed = false;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.E_renamed = java.lang.Math.min(measuredWidth / 10, this.D_renamed);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int measuredHeight2 = measuredHeight;
        int measuredWidth2 = paddingLeft;
        int i7 = 0;
        while (true) {
            boolean z2 = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            android.view.View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (androidx.viewpager.widget.ViewPager.c_renamed) childAt.getLayoutParams()) != null && cVar2.f1807a) {
                int i9 = cVar2.f1808b & 7;
                int i10 = cVar2.f1808b & 112;
                boolean z3 = (i10 == 48 || i10 == 80) ? true : z_renamed;
                if (i9 != 3 && i9 != 5) {
                    z2 = z_renamed;
                }
                int i11 = Integer.MIN_VALUE;
                if (z3) {
                    i4 = Integer.MIN_VALUE;
                    i11 = 1073741824;
                } else {
                    i4 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (cVar2.width != -2) {
                    i5 = cVar2.width != -1 ? cVar2.width : measuredWidth2;
                    i11 = 1073741824;
                } else {
                    i5 = measuredWidth2;
                }
                if (cVar2.height != -2) {
                    i6 = cVar2.height != -1 ? cVar2.height : measuredHeight2;
                } else {
                    i6 = measuredHeight2;
                    i8 = i4;
                }
                childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(i5, i11), android.view.View.MeasureSpec.makeMeasureSpec(i6, i8));
                if (z3) {
                    measuredHeight2 -= childAt.getMeasuredHeight();
                } else if (z2) {
                    measuredWidth2 -= childAt.getMeasuredWidth();
                }
            }
            i7++;
            z_renamed = false;
        }
        this.v_renamed = android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
        this.w_renamed = android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
        this.x_renamed = true;
        c_renamed();
        this.x_renamed = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            android.view.View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (androidx.viewpager.widget.ViewPager.c_renamed) childAt2.getLayoutParams()) == null || !cVar.f1807a)) {
                childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec((int) (measuredWidth2 * cVar.f1809c), 1073741824), this.w_renamed);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.p_renamed;
            a_renamed(i2, i4, i6, i6);
        }
    }

    private void a_renamed(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.g_renamed.isEmpty()) {
            if (!this.m_renamed.isFinished()) {
                this.m_renamed.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        androidx.viewpager.widget.ViewPager.b_renamed bVarB = b_renamed(this.f1800c);
        int iMin = (int) ((bVarB != null ? java.lang.Math.min(bVarB.e_renamed, this.u_renamed) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            a_renamed(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i2, int i3, int i4, int i5) throws android.content.res.Resources.NotFoundException {
        boolean z2;
        androidx.viewpager.widget.ViewPager.b_renamed bVarA;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i8 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            android.view.View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                androidx.viewpager.widget.ViewPager.c_renamed cVar = (androidx.viewpager.widget.ViewPager.c_renamed) childAt.getLayoutParams();
                if (cVar.f1807a) {
                    int i10 = cVar.f1808b & 7;
                    int i11 = cVar.f1808b & 112;
                    if (i10 == 1) {
                        iMax = java.lang.Math.max((i6 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i10 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i10 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i11 == 16) {
                        iMax2 = java.lang.Math.max((i7 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i11 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i11 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i7 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i12 = iMax + scrollX;
                    childAt.layout(i12, iMax2, childAt.getMeasuredWidth() + i12, iMax2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i13 = (i6 - measuredWidth) - paddingRight;
        for (int i14 = 0; i14 < childCount; i14++) {
            android.view.View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                androidx.viewpager.widget.ViewPager.c_renamed cVar2 = (androidx.viewpager.widget.ViewPager.c_renamed) childAt2.getLayoutParams();
                if (!cVar2.f1807a && (bVarA = a_renamed(childAt2)) != null) {
                    float f2 = i13;
                    int i15 = ((int) (bVarA.e_renamed * f2)) + measuredWidth;
                    if (cVar2.d_renamed) {
                        cVar2.d_renamed = false;
                        childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f1809c), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec((i7 - measuredHeight2) - measuredHeight, 1073741824));
                    }
                    childAt2.layout(i15, measuredHeight2, childAt2.getMeasuredWidth() + i15, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.r_renamed = measuredHeight2;
        this.s_renamed = i7 - measuredHeight;
        this.W_renamed = i8;
        if (this.T_renamed) {
            z2 = false;
            a_renamed(this.f1800c, false, 0, false);
        } else {
            z2 = false;
        }
        this.T_renamed = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.n_renamed = true;
        if (!this.m_renamed.isFinished() && this.m_renamed.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m_renamed.getCurrX();
            int currY = this.m_renamed.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d_renamed(currX)) {
                    this.m_renamed.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            androidx.core.h_renamed.v_renamed.e_renamed(this);
            return;
        }
        a_renamed(true);
    }

    private boolean d_renamed(int i2) {
        if (this.g_renamed.size() == 0) {
            if (this.T_renamed) {
                return false;
            }
            this.V_renamed = false;
            a_renamed(0, 0.0f, 0);
            if (this.V_renamed) {
                return false;
            }
            throw new java.lang.IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        androidx.viewpager.widget.ViewPager.b_renamed bVarI = i_renamed();
        int clientWidth = getClientWidth();
        int i3 = this.p_renamed;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = bVarI.f1805b;
        float f3 = ((i2 / f2) - bVarI.e_renamed) / (bVarI.d_renamed + (i3 / f2));
        this.V_renamed = false;
        a_renamed(i5, f3, (int) (i4 * f3));
        if (this.V_renamed) {
            return true;
        }
        throw new java.lang.IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a_renamed(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W_renamed
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = r1
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c_renamed r9 = (androidx.viewpager.widget.ViewPager.c_renamed) r9
            boolean r10 = r9.f1807a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f1808b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.b_renamed(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$g_renamed r13 = r12.ae_renamed
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c_renamed r0 = (androidx.viewpager.widget.ViewPager.c_renamed) r0
            boolean r0 = r0.f1807a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$g_renamed r3 = r12.ae_renamed
            r3.a_renamed(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.V_renamed = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a_renamed(int, float, int):void");
    }

    private void b_renamed(int i2, float f2, int i3) {
        androidx.viewpager.widget.ViewPager.f_renamed fVar = this.ab_renamed;
        if (fVar != null) {
            fVar.onPageScrolled(i2, f2, i3);
        }
        java.util.List<androidx.viewpager.widget.ViewPager.f_renamed> list = this.aa_renamed;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                androidx.viewpager.widget.ViewPager.f_renamed fVar2 = this.aa_renamed.get(i4);
                if (fVar2 != null) {
                    fVar2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        androidx.viewpager.widget.ViewPager.f_renamed fVar3 = this.ac_renamed;
        if (fVar3 != null) {
            fVar3.onPageScrolled(i2, f2, i3);
        }
    }

    private void e_renamed(int i2) {
        androidx.viewpager.widget.ViewPager.f_renamed fVar = this.ab_renamed;
        if (fVar != null) {
            fVar.onPageSelected(i2);
        }
        java.util.List<androidx.viewpager.widget.ViewPager.f_renamed> list = this.aa_renamed;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                androidx.viewpager.widget.ViewPager.f_renamed fVar2 = this.aa_renamed.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageSelected(i2);
                }
            }
        }
        androidx.viewpager.widget.ViewPager.f_renamed fVar3 = this.ac_renamed;
        if (fVar3 != null) {
            fVar3.onPageSelected(i2);
        }
    }

    private void f_renamed(int i2) {
        androidx.viewpager.widget.ViewPager.f_renamed fVar = this.ab_renamed;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i2);
        }
        java.util.List<androidx.viewpager.widget.ViewPager.f_renamed> list = this.aa_renamed;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                androidx.viewpager.widget.ViewPager.f_renamed fVar2 = this.aa_renamed.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageScrollStateChanged(i2);
                }
            }
        }
        androidx.viewpager.widget.ViewPager.f_renamed fVar3 = this.ac_renamed;
        if (fVar3 != null) {
            fVar3.onPageScrollStateChanged(i2);
        }
    }

    private void a_renamed(boolean z_renamed) {
        boolean z2 = this.ak_renamed == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.m_renamed.isFinished()) {
                this.m_renamed.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m_renamed.getCurrX();
                int currY = this.m_renamed.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d_renamed(currX);
                    }
                }
            }
        }
        this.z_renamed = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.g_renamed.size(); i2++) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(i2);
            if (bVar.f1806c) {
                bVar.f1806c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z_renamed) {
                androidx.core.h_renamed.v_renamed.a_renamed(this, this.aj_renamed);
            } else {
                this.aj_renamed.run();
            }
        }
    }

    private boolean a_renamed(float f2, float f3) {
        return (f2 < ((float) this.E_renamed) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.E_renamed)) && f3 < 0.0f);
    }

    private void b_renamed(boolean z_renamed) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z_renamed ? this.af_renamed : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h_renamed();
            return false;
        }
        if (action != 0) {
            if (this.B_renamed) {
                return true;
            }
            if (this.C_renamed) {
                return false;
            }
        }
        if (action == 0) {
            float x_renamed = motionEvent.getX();
            this.I_renamed = x_renamed;
            this.G_renamed = x_renamed;
            float y_renamed = motionEvent.getY();
            this.J_renamed = y_renamed;
            this.H_renamed = y_renamed;
            this.K_renamed = motionEvent.getPointerId(0);
            this.C_renamed = false;
            this.n_renamed = true;
            this.m_renamed.computeScrollOffset();
            if (this.ak_renamed == 2 && java.lang.Math.abs(this.m_renamed.getFinalX() - this.m_renamed.getCurrX()) > this.P_renamed) {
                this.m_renamed.abortAnimation();
                this.z_renamed = false;
                c_renamed();
                this.B_renamed = true;
                c_renamed(true);
                setScrollState(1);
            } else {
                a_renamed(false);
                this.B_renamed = false;
            }
        } else if (action == 2) {
            int i2 = this.K_renamed;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.G_renamed;
                float fAbs = java.lang.Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = java.lang.Math.abs(y2 - this.J_renamed);
                if (f2 != 0.0f && !a_renamed(this.G_renamed, f2) && a_renamed(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.G_renamed = x2;
                    this.H_renamed = y2;
                    this.C_renamed = true;
                    return false;
                }
                if (fAbs > this.F_renamed && fAbs * 0.5f > fAbs2) {
                    this.B_renamed = true;
                    c_renamed(true);
                    setScrollState(1);
                    this.G_renamed = f2 > 0.0f ? this.I_renamed + this.F_renamed : this.I_renamed - this.F_renamed;
                    this.H_renamed = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.F_renamed) {
                    this.C_renamed = true;
                }
                if (this.B_renamed && b_renamed(x2)) {
                    androidx.core.h_renamed.v_renamed.e_renamed(this);
                }
            }
        } else if (action == 6) {
            a_renamed(motionEvent);
        }
        if (this.L_renamed == null) {
            this.L_renamed = android.view.VelocityTracker.obtain();
        }
        this.L_renamed.addMovement(motionEvent);
        return this.B_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean h_renamed() {
        this.K_renamed = -1;
        j_renamed();
        this.R_renamed.onRelease();
        this.S_renamed.onRelease();
        return this.R_renamed.isFinished() || this.S_renamed.isFinished();
    }

    private void c_renamed(boolean z_renamed) {
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z_renamed);
        }
    }

    private boolean b_renamed(float f2) {
        boolean z_renamed;
        boolean z2;
        float f3 = this.G_renamed - f2;
        this.G_renamed = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.t_renamed * clientWidth;
        float f5 = this.u_renamed * clientWidth;
        boolean z3 = false;
        androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(0);
        java.util.ArrayList<androidx.viewpager.widget.ViewPager.b_renamed> arrayList = this.g_renamed;
        androidx.viewpager.widget.ViewPager.b_renamed bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f1805b != 0) {
            f4 = bVar.e_renamed * clientWidth;
            z_renamed = false;
        } else {
            z_renamed = true;
        }
        if (bVar2.f1805b != this.f1799b.a_renamed() - 1) {
            f5 = bVar2.e_renamed * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z_renamed) {
                this.R_renamed.onPull(java.lang.Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.S_renamed.onPull(java.lang.Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.G_renamed += scrollX - i2;
        scrollTo(i2, getScrollY());
        d_renamed(i2);
        return z3;
    }

    private androidx.viewpager.widget.ViewPager.b_renamed i_renamed() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.p_renamed / clientWidth : 0.0f;
        androidx.viewpager.widget.ViewPager.b_renamed bVar = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        boolean z_renamed = true;
        while (i3 < this.g_renamed.size()) {
            androidx.viewpager.widget.ViewPager.b_renamed bVar2 = this.g_renamed.get(i3);
            if (!z_renamed && bVar2.f1805b != (i2 = i4 + 1)) {
                bVar2 = this.h_renamed;
                bVar2.e_renamed = f3 + f4 + f2;
                bVar2.f1805b = i2;
                bVar2.d_renamed = this.f1799b.b_renamed(bVar2.f1805b);
                i3--;
            }
            f3 = bVar2.e_renamed;
            float f5 = bVar2.d_renamed + f3 + f2;
            if (!z_renamed && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.g_renamed.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f1805b;
            f4 = bVar2.d_renamed;
            i3++;
            z_renamed = false;
            bVar = bVar2;
        }
        return bVar;
    }

    private int a_renamed(int i2, float f2, int i3, int i4) {
        if (java.lang.Math.abs(i4) <= this.O_renamed || java.lang.Math.abs(i3) <= this.M_renamed) {
            i2 += (int) (f2 + (i2 >= this.f1800c ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.g_renamed.size() <= 0) {
            return i2;
        }
        return java.lang.Math.max(this.g_renamed.get(0).f1805b, java.lang.Math.min(i2, this.g_renamed.get(r1.size() - 1).f1805b));
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        androidx.viewpager.widget.a_renamed aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f1799b) != null && aVar.a_renamed() > 1)) {
            if (!this.R_renamed.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.t_renamed * width);
                this.R_renamed.setSize(height, width);
                zDraw = false | this.R_renamed.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.S_renamed.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.u_renamed + 1.0f)) * width2);
                this.S_renamed.setSize(height2, width2);
                zDraw |= this.S_renamed.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.R_renamed.finish();
            this.S_renamed.finish();
        }
        if (zDraw) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.p_renamed <= 0 || this.q_renamed == null || this.g_renamed.size() <= 0 || this.f1799b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f5 = this.p_renamed / width;
        int i2 = 0;
        androidx.viewpager.widget.ViewPager.b_renamed bVar = this.g_renamed.get(0);
        float f6 = bVar.e_renamed;
        int size = this.g_renamed.size();
        int i3 = bVar.f1805b;
        int i4 = this.g_renamed.get(size - 1).f1805b;
        while (i3 < i4) {
            while (i3 > bVar.f1805b && i2 < size) {
                i2++;
                bVar = this.g_renamed.get(i2);
            }
            if (i3 == bVar.f1805b) {
                f3 = (bVar.e_renamed + bVar.d_renamed) * width;
                f2 = bVar.e_renamed + bVar.d_renamed + f5;
            } else {
                float fB_renamed = this.f1799b.b_renamed(i3);
                float f7 = (f6 + fB_renamed) * width;
                f2 = f6 + fB_renamed + f5;
                f3 = f7;
            }
            if (this.p_renamed + f3 > scrollX) {
                f4 = f5;
                this.q_renamed.setBounds(java.lang.Math.round(f3), this.r_renamed, java.lang.Math.round(this.p_renamed + f3), this.s_renamed);
                this.q_renamed.draw(canvas);
            } else {
                f4 = f5;
            }
            if (f3 > scrollX + r2) {
                return;
            }
            i3++;
            f6 = f2;
            f5 = f4;
        }
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K_renamed) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.G_renamed = motionEvent.getX(i2);
            this.K_renamed = motionEvent.getPointerId(i2);
            android.view.VelocityTracker velocityTracker = this.L_renamed;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void j_renamed() {
        this.B_renamed = false;
        this.C_renamed = false;
        android.view.VelocityTracker velocityTracker = this.L_renamed;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L_renamed = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z_renamed) {
        if (this.y_renamed != z_renamed) {
            this.y_renamed = z_renamed;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f1799b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.t_renamed)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.u_renamed));
    }

    protected boolean a_renamed(android.view.View view, boolean z_renamed, int i2, int i3, int i4) {
        int i5;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a_renamed(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z_renamed && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a_renamed(keyEvent);
    }

    public boolean a_renamed(android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return d_renamed();
                }
                return c_renamed(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return e_renamed();
                }
                return c_renamed(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return c_renamed(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return c_renamed(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c_renamed(int r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto La
            goto L69
        La:
            if (r0 == 0) goto L68
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r6) goto L18
            r4 = r1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = r2
        L1e:
            if (r4 != 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on_renamed non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e_renamed(r4, r0)
            goto L69
        L68:
            r3 = r0
        L69:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r0 = r0.findNextFocus(r6, r3, r7)
            r4 = 66
            r5 = 17
            if (r0 == 0) goto Lba
            if (r0 == r3) goto Lba
            if (r7 != r5) goto L9a
            android.graphics.Rect r1 = r6.i_renamed
            android.graphics.Rect r1 = r6.a_renamed(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.i_renamed
            android.graphics.Rect r2 = r6.a_renamed(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto L94
            if (r1 < r2) goto L94
            boolean r0 = r6.d_renamed()
            goto L98
        L94:
            boolean r0 = r0.requestFocus()
        L98:
            r2 = r0
            goto Lcd
        L9a:
            if (r7 != r4) goto Lcd
            android.graphics.Rect r1 = r6.i_renamed
            android.graphics.Rect r1 = r6.a_renamed(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.i_renamed
            android.graphics.Rect r2 = r6.a_renamed(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto Lb5
            if (r1 > r2) goto Lb5
            boolean r0 = r6.e_renamed()
            goto L98
        Lb5:
            boolean r0 = r0.requestFocus()
            goto L98
        Lba:
            if (r7 == r5) goto Lc9
            if (r7 != r1) goto Lbf
            goto Lc9
        Lbf:
            if (r7 == r4) goto Lc4
            r0 = 2
            if (r7 != r0) goto Lcd
        Lc4:
            boolean r2 = r6.e_renamed()
            goto Lcd
        Lc9:
            boolean r2 = r6.d_renamed()
        Lcd:
            if (r2 == 0) goto Ld6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c_renamed(int):boolean");
    }

    private android.graphics.Rect a_renamed(android.graphics.Rect rect, android.view.View view) {
        if (rect == null) {
            rect = new android.graphics.Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        android.view.ViewParent parent = view.getParent();
        while ((parent instanceof android.view.ViewGroup) && parent != this) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean d_renamed() throws android.content.res.Resources.NotFoundException {
        int i2 = this.f1800c;
        if (i2 <= 0) {
            return false;
        }
        a_renamed(i2 - 1, true);
        return true;
    }

    boolean e_renamed() throws android.content.res.Resources.NotFoundException {
        androidx.viewpager.widget.a_renamed aVar = this.f1799b;
        if (aVar == null || this.f1800c >= aVar.a_renamed() - 1) {
            return false;
        }
        a_renamed(this.f1800c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(java.util.ArrayList<android.view.View> arrayList, int i2, int i3) {
        androidx.viewpager.widget.ViewPager.b_renamed bVarA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                android.view.View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarA = a_renamed(childAt)) != null && bVarA.f1805b == this.f1800c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(java.util.ArrayList<android.view.View> arrayList) {
        androidx.viewpager.widget.ViewPager.b_renamed bVarA;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a_renamed(childAt)) != null && bVarA.f1805b == this.f1800c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, android.graphics.Rect rect) {
        int i3;
        int i4;
        androidx.viewpager.widget.ViewPager.b_renamed bVarA;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            android.view.View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarA = a_renamed(childAt)) != null && bVarA.f1805b == this.f1800c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        androidx.viewpager.widget.ViewPager.b_renamed bVarA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a_renamed(childAt)) != null && bVarA.f1805b == this.f1800c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new androidx.viewpager.widget.ViewPager.c_renamed();
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.viewpager.widget.ViewPager.c_renamed) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.viewpager.widget.ViewPager.c_renamed(getContext(), attributeSet);
    }

    class d_renamed extends androidx.core.h_renamed.a_renamed {
        d_renamed() {
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(androidx.viewpager.widget.ViewPager.class.getName());
            accessibilityEvent.setScrollable(a_renamed());
            if (accessibilityEvent.getEventType() != 4096 || androidx.viewpager.widget.ViewPager.this.f1799b == null) {
                return;
            }
            accessibilityEvent.setItemCount(androidx.viewpager.widget.ViewPager.this.f1799b.a_renamed());
            accessibilityEvent.setFromIndex(androidx.viewpager.widget.ViewPager.this.f1800c);
            accessibilityEvent.setToIndex(androidx.viewpager.widget.ViewPager.this.f1800c);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b_renamed((java.lang.CharSequence) androidx.viewpager.widget.ViewPager.class.getName());
            dVar.i_renamed(a_renamed());
            if (androidx.viewpager.widget.ViewPager.this.canScrollHorizontally(1)) {
                dVar.a_renamed(4096);
            }
            if (androidx.viewpager.widget.ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a_renamed(8192);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i_renamed, bundle)) {
                return true;
            }
            if (i_renamed == 4096) {
                if (!androidx.viewpager.widget.ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                androidx.viewpager.widget.ViewPager viewPager = androidx.viewpager.widget.ViewPager.this;
                viewPager.setCurrentItem(viewPager.f1800c + 1);
                return true;
            }
            if (i_renamed != 8192 || !androidx.viewpager.widget.ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            androidx.viewpager.widget.ViewPager viewPager2 = androidx.viewpager.widget.ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f1800c - 1);
            return true;
        }

        private boolean a_renamed() {
            return androidx.viewpager.widget.ViewPager.this.f1799b != null && androidx.viewpager.widget.ViewPager.this.f1799b.a_renamed() > 1;
        }
    }

    private class h_renamed extends android.database.DataSetObserver {
        h_renamed() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws android.content.res.Resources.NotFoundException {
            androidx.viewpager.widget.ViewPager.this.b_renamed();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws android.content.res.Resources.NotFoundException {
            androidx.viewpager.widget.ViewPager.this.b_renamed();
        }
    }

    public static class c_renamed extends android.view.ViewGroup.LayoutParams {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f1807a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f1808b;

        /* renamed from: c_renamed, reason: collision with root package name */
        float f1809c;
        boolean d_renamed;
        int e_renamed;
        int f_renamed;

        public c_renamed() {
            super(-1, -1);
            this.f1809c = 0.0f;
        }

        public c_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1809c = 0.0f;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.viewpager.widget.ViewPager.f1798a);
            this.f1808b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class i_renamed implements java.util.Comparator<android.view.View> {
        i_renamed() {
        }

        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(android.view.View view, android.view.View view2) {
            androidx.viewpager.widget.ViewPager.c_renamed cVar = (androidx.viewpager.widget.ViewPager.c_renamed) view.getLayoutParams();
            androidx.viewpager.widget.ViewPager.c_renamed cVar2 = (androidx.viewpager.widget.ViewPager.c_renamed) view2.getLayoutParams();
            if (cVar.f1807a != cVar2.f1807a) {
                return cVar.f1807a ? 1 : -1;
            }
            return cVar.e_renamed - cVar2.e_renamed;
        }
    }
}
