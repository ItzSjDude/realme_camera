package com.coui.appcompat.dialog.panel;

/* compiled from: COUIPanelAdjustResizeHelper.java */
/* loaded from: classes.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2546a = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2547b = new android.view.animation.PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
    private int m_renamed;
    private float n_renamed;
    private int o_renamed;
    private java.lang.ref.WeakReference<android.view.View> p_renamed;
    private android.animation.ValueAnimator q_renamed;
    private android.animation.ValueAnimator r_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2548c = 2;
    private boolean d_renamed = true;
    private boolean e_renamed = false;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private android.view.View j_renamed = null;
    private boolean k_renamed = false;
    private int l_renamed = -1;
    private int s_renamed = 2;

    public void a_renamed(android.content.Context context, android.view.ViewGroup viewGroup, android.view.WindowInsets windowInsets) throws android.content.res.Resources.NotFoundException {
        int iC = com.coui.appcompat.a_renamed.k_renamed.b_renamed(context) && !context.getResources().getBoolean(coui.support.appcompat.R_renamed.bool.is_ignore_nav_height_in_panel_ime_adjust) ? com.coui.appcompat.a_renamed.k_renamed.c_renamed(context) : 0;
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            a_renamed(viewGroup, java.lang.Math.max(0, windowInsets.getInsets(android.view.WindowInsets.Type.ime()).bottom - iC), windowInsets);
            return;
        }
        int iA = a_renamed(windowInsets.getSystemWindowInsetBottom(), iC);
        if (iA > 0) {
            a_renamed(viewGroup, true, iA);
        } else if (this.f2548c != 2) {
            a_renamed(viewGroup, false, this.g_renamed);
        }
    }

    private int a_renamed(int i_renamed, int i2) {
        return this.s_renamed == 2038 ? i_renamed : i_renamed - i2;
    }

    private void a_renamed(android.view.ViewGroup viewGroup, int i_renamed, android.view.WindowInsets windowInsets) throws android.content.res.Resources.NotFoundException {
        if (this.g_renamed == i_renamed) {
            return;
        }
        a_renamed(i_renamed > 0);
        a_renamed(viewGroup, i_renamed);
        a_renamed(viewGroup, java.lang.Boolean.valueOf(i_renamed > 0));
        if (viewGroup instanceof com.coui.appcompat.widget.l_renamed) {
            a_renamed((android.view.View) viewGroup, i_renamed);
            com.coui.appcompat.widget.l_renamed lVar = (com.coui.appcompat.widget.l_renamed) viewGroup;
            a_renamed((android.view.View) lVar.getBtnBarLayout(), 0.0f);
            a_renamed(lVar.getDivider(), 0.0f);
            return;
        }
        a_renamed((android.view.View) viewGroup, this.o_renamed, windowInsets);
    }

    private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed, int i_renamed) {
        a_renamed(z_renamed);
        a_renamed(viewGroup, i_renamed);
        a_renamed(viewGroup, java.lang.Boolean.valueOf(z_renamed));
        a_renamed(viewGroup, z_renamed);
        this.d_renamed = false;
    }

    private void a_renamed(boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            this.f2548c = 1;
        } else {
            this.f2548c = 2;
            if (!this.e_renamed && z_renamed) {
                this.f2548c = 0;
            } else if (this.e_renamed && z_renamed) {
                this.f2548c = 1;
            }
        }
        this.e_renamed = z_renamed;
    }

    private boolean a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        if (viewGroup == null) {
            return false;
        }
        b_renamed();
        if (viewGroup instanceof com.coui.appcompat.widget.l_renamed) {
            com.coui.appcompat.widget.l_renamed lVar = (com.coui.appcompat.widget.l_renamed) viewGroup;
            viewGroup.measure(android.view.View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(lVar.getMaxHeight(), lVar.getLayoutAtMaxHeight() ? 1073741824 : Integer.MIN_VALUE));
            a_renamed(viewGroup);
        }
        this.f_renamed = viewGroup.getMeasuredHeight();
        int i2 = this.f2548c;
        if (i2 == 0) {
            this.g_renamed = i_renamed;
            this.h_renamed = this.g_renamed;
        } else if (i2 == 1) {
            this.f_renamed -= i_renamed;
            this.h_renamed = i_renamed - this.g_renamed;
            this.g_renamed = i_renamed;
        } else if (i2 == 2 && !this.d_renamed) {
            this.g_renamed = i_renamed;
            this.h_renamed = this.g_renamed;
        }
        return true;
    }

    protected void a_renamed(android.view.ViewGroup viewGroup, java.lang.Boolean bool) {
        this.p_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0.0f;
        this.o_renamed = 0;
        if (viewGroup == null || this.h_renamed == 0) {
            return;
        }
        if (viewGroup instanceof com.coui.appcompat.widget.l_renamed) {
            a_renamed((com.coui.appcompat.widget.l_renamed) viewGroup, bool);
        } else {
            b_renamed(viewGroup, bool);
        }
    }

    private void a_renamed(com.coui.appcompat.widget.l_renamed lVar, java.lang.Boolean bool) {
        int i_renamed = this.f2548c == 2 ? -1 : 1;
        int maxHeight = lVar.getMaxHeight();
        int i2 = this.h_renamed * i_renamed;
        float translationY = lVar.getBtnBarLayout() != null ? lVar.getBtnBarLayout().getTranslationY() : 0.0f;
        this.p_renamed = new java.lang.ref.WeakReference<>(lVar);
        if ((this.k_renamed && maxHeight != 0) || (!com.coui.appcompat.a_renamed.m_renamed.e_renamed(lVar.getContext()) && translationY == 0.0f)) {
            android.view.View view = this.j_renamed;
            if (view != null) {
                android.view.View view2 = (android.view.View) view.getParent();
                if (view2 != null) {
                    this.l_renamed = view2.getPaddingBottom();
                    this.p_renamed = new java.lang.ref.WeakReference<>(view2);
                }
                this.n_renamed = -i2;
            } else {
                this.l_renamed = -1;
            }
            this.m_renamed = i2;
            return;
        }
        int i3 = this.f_renamed - this.i_renamed;
        int paddingBottom = lVar.getPaddingBottom();
        int height = lVar.getBtnBarLayout() != null ? lVar.getBtnBarLayout().getHeight() : 0;
        int height2 = lVar.getDivider() != null ? lVar.getDivider().getHeight() : 0;
        int i4 = this.f2548c;
        if (i4 == 1) {
            i3 += this.g_renamed;
        } else if (i4 == 2) {
            i3 -= this.g_renamed;
        }
        if (i3 >= this.g_renamed + height + height2 && paddingBottom == 0) {
            this.n_renamed = -i2;
            return;
        }
        int i5 = i_renamed * (((this.g_renamed + height) + height2) - i3);
        this.m_renamed = java.lang.Math.max(-paddingBottom, i5);
        if (this.f2548c == 1) {
            int iMax = java.lang.Math.max(0, paddingBottom + i5);
            int i6 = this.g_renamed;
            this.n_renamed = (-java.lang.Math.min(i6, java.lang.Math.max(-i6, i6 - iMax))) - translationY;
            return;
        }
        this.n_renamed = bool.booleanValue() ? -(i2 - r2) : -translationY;
    }

    private void b_renamed(android.view.ViewGroup viewGroup, java.lang.Boolean bool) {
        int i_renamed = (this.f2548c == 2 ? -1 : 1) * this.h_renamed;
        this.p_renamed = new java.lang.ref.WeakReference<>(viewGroup);
        this.o_renamed = i_renamed;
    }

    private void a_renamed(android.view.ViewGroup viewGroup) {
        android.view.View viewFindFocus;
        if (viewGroup == null || (viewFindFocus = viewGroup.findFocus()) == null) {
            return;
        }
        this.i_renamed = 0;
        this.k_renamed = false;
        this.j_renamed = null;
        if (b_renamed(viewFindFocus)) {
            this.k_renamed = true;
            this.j_renamed = viewFindFocus;
        }
        this.i_renamed = a_renamed(viewFindFocus) + viewFindFocus.getTop() + com.coui.appcompat.a_renamed.y_renamed.a_renamed(viewFindFocus, 3);
        for (android.view.View view = (android.view.View) viewFindFocus.getParent(); view != null && view != viewGroup.getParent(); view = (android.view.View) view.getParent()) {
            if (b_renamed(view)) {
                this.k_renamed = true;
                this.j_renamed = view;
            }
            this.i_renamed += view.getTop();
        }
    }

    private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) {
        float fAbs;
        float fAbs2;
        if (viewGroup == null || this.p_renamed == null) {
            return;
        }
        if (viewGroup instanceof com.coui.appcompat.widget.l_renamed) {
            com.coui.appcompat.widget.l_renamed lVar = (com.coui.appcompat.widget.l_renamed) viewGroup;
            int maxHeight = lVar.getMaxHeight();
            if (z_renamed) {
                fAbs2 = java.lang.Math.abs((this.h_renamed * 120.0f) / maxHeight) + 300.0f;
            } else {
                fAbs2 = java.lang.Math.abs((this.h_renamed * 50.0f) / maxHeight) + 200.0f;
            }
            long j_renamed = (long) fAbs2;
            a_renamed(this.p_renamed.get(), this.m_renamed, j_renamed);
            a_renamed(lVar, this.n_renamed, j_renamed);
            return;
        }
        int iB = com.coui.appcompat.a_renamed.m_renamed.b_renamed(viewGroup.getContext());
        if (z_renamed) {
            fAbs = java.lang.Math.abs((this.h_renamed * 120.0f) / iB) + 300.0f;
        } else {
            fAbs = java.lang.Math.abs((this.h_renamed * 50.0f) / iB) + 200.0f;
        }
        b_renamed(viewGroup, this.o_renamed, (long) fAbs);
    }

    private void a_renamed(final android.view.View view, int i_renamed, long j_renamed) {
        if (i_renamed == 0 || view == null) {
            return;
        }
        final int paddingLeft = view.getPaddingLeft();
        final int paddingRight = view.getPaddingRight();
        final int paddingTop = view.getPaddingTop();
        int iMax = java.lang.Math.max(0, view.getPaddingBottom());
        final int iMax2 = java.lang.Math.max(0, i_renamed + iMax);
        this.q_renamed = android.animation.ValueAnimator.ofInt(iMax, iMax2);
        this.q_renamed.setDuration(j_renamed);
        if (iMax < iMax2) {
            this.q_renamed.setInterpolator(f2546a);
        } else {
            this.q_renamed.setInterpolator(f2547b);
        }
        this.q_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.d_renamed.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, iMax2);
            }
        });
        this.q_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.d_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.q_renamed.start();
    }

    private void a_renamed(final com.coui.appcompat.widget.l_renamed lVar, float f_renamed, long j_renamed) {
        if (f_renamed == 0.0f || lVar == null || lVar.getBtnBarLayout() == null) {
            return;
        }
        float translationY = lVar.getBtnBarLayout().getTranslationY();
        final float fMin = java.lang.Math.min(0.0f, f_renamed + translationY);
        this.r_renamed = android.animation.ValueAnimator.ofFloat(translationY, fMin);
        this.r_renamed.setDuration(j_renamed);
        if (translationY < fMin) {
            this.r_renamed.setInterpolator(f2546a);
        } else {
            this.r_renamed.setInterpolator(f2547b);
        }
        this.r_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.d_renamed.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                lVar.getBtnBarLayout().setTranslationY(fMin);
                lVar.getDivider().setTranslationY(fMin);
            }
        });
        this.r_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.d_renamed.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (lVar.isAttachedToWindow()) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    lVar.getBtnBarLayout().setTranslationY(fFloatValue);
                    lVar.getDivider().setTranslationY(fFloatValue);
                }
            }
        });
        this.r_renamed.start();
    }

    private void b_renamed(final android.view.View view, int i_renamed, long j_renamed) {
        if (i_renamed == 0 || view == null) {
            return;
        }
        int iMax = java.lang.Math.max(0, com.coui.appcompat.a_renamed.y_renamed.a_renamed(view, 3));
        final int iMax2 = java.lang.Math.max(0, i_renamed + iMax);
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(iMax, iMax2);
        valueAnimatorOfInt.setDuration(j_renamed);
        if (iMax < iMax2) {
            valueAnimatorOfInt.setInterpolator(f2546a);
        } else {
            valueAnimatorOfInt.setInterpolator(f2547b);
        }
        valueAnimatorOfInt.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.d_renamed.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.a_renamed.y_renamed.a_renamed(view, iMax2, 3);
            }
        });
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.d_renamed.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    com.coui.appcompat.a_renamed.y_renamed.a_renamed(view, ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue(), 3);
                }
            }
        });
        valueAnimatorOfInt.start();
    }

    private void a_renamed(android.view.View view, int i_renamed) {
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i_renamed);
        }
    }

    private void a_renamed(android.view.View view, float f_renamed) {
        if (view != null) {
            view.setTranslationY(view.getTranslationY() + f_renamed);
        }
    }

    private void a_renamed(android.view.View view, int i_renamed, android.view.WindowInsets windowInsets) throws android.content.res.Resources.NotFoundException {
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_bottom_sheet_margin_bottom_if_need);
            android.graphics.Rect rect = new android.graphics.Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height() + windowInsets.getInsets(android.view.WindowInsets.Type.ime()).bottom;
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            int measuredHeight = view.getMeasuredHeight() + marginLayoutParams.bottomMargin + i_renamed;
            if (measuredHeight > iHeight) {
                i_renamed -= measuredHeight - iHeight;
            }
            if ((view instanceof com.coui.appcompat.widget.IgnoreWindowInsetsFrameLayout) && layoutParams.height > 0) {
                marginLayoutParams.bottomMargin = java.lang.Math.max(dimensionPixelSize, marginLayoutParams.bottomMargin + i_renamed);
                view.setLayoutParams(layoutParams);
            } else if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                marginLayoutParams.bottomMargin = java.lang.Math.max(dimensionPixelSize, marginLayoutParams.bottomMargin + i_renamed);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private int a_renamed(android.view.View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    private boolean b_renamed(android.view.View view) {
        return (view instanceof android.widget.ScrollView) || (view instanceof android.widget.AbsListView) || (view instanceof androidx.core.h_renamed.t_renamed);
    }

    private android.view.View f_renamed() {
        android.view.View view = this.j_renamed;
        if (view != null) {
            return (android.view.View) view.getParent();
        }
        return null;
    }

    public void a_renamed(com.coui.appcompat.widget.l_renamed lVar) {
        if (this.k_renamed) {
            android.view.View viewF = f_renamed();
            if (viewF != null && this.l_renamed >= 0) {
                viewF.setPadding(0, 0, 0, 0);
            }
        } else if (lVar != null) {
            lVar.setPadding(0, 0, 0, 0);
        }
        if (lVar != null) {
            com.coui.appcompat.widget.COUIButtonBarLayout btnBarLayout = lVar.getBtnBarLayout();
            android.view.View divider = lVar.getDivider();
            if (btnBarLayout != null) {
                btnBarLayout.setTranslationY(0.0f);
            }
            if (divider != null) {
                divider.setTranslationY(0.0f);
            }
            lVar.setPadding(0, 0, 0, 0);
        }
    }

    public void a_renamed() {
        this.g_renamed = 0;
    }

    public boolean b_renamed() {
        android.animation.ValueAnimator valueAnimator = this.q_renamed;
        boolean z_renamed = false;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.q_renamed.cancel();
                z_renamed = true;
            }
            this.q_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator2 = this.r_renamed;
        if (valueAnimator2 != null) {
            if (valueAnimator2.isRunning()) {
                this.r_renamed.cancel();
            }
            this.r_renamed = null;
        }
        return z_renamed;
    }

    public int c_renamed() {
        return this.m_renamed;
    }

    public float d_renamed() {
        return this.n_renamed;
    }

    public int e_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.s_renamed = i_renamed;
    }
}
