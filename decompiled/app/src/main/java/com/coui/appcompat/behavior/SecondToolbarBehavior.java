package com.coui.appcompat.behavior;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.appbar.AppBarLayout> implements android.widget.AbsListView.OnScrollListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f2417a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.View f2418b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.View f2419c;
    private android.view.View d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int[] h_renamed;
    private int i_renamed;
    private android.view.ViewGroup.LayoutParams j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private float r_renamed;
    private float s_renamed;
    private android.content.res.Resources t_renamed;
    private boolean u_renamed;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i_renamed) {
    }

    public SecondToolbarBehavior() {
        this.h_renamed = new int[2];
    }

    public SecondToolbarBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h_renamed = new int[2];
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.t_renamed = context.getResources();
        this.k_renamed = this.t_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_margin_horizontal) * 2;
        this.n_renamed = this.t_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_line_alpha_range_change_offset);
        this.q_renamed = this.t_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_width_change_offset);
        this.u_renamed = this.t_renamed.getBoolean(coui.support.appcompat.R_renamed.bool.is_dialog_preference_immersive);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        boolean z_renamed = (i_renamed & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (!this.u_renamed && z_renamed) {
            if (this.l_renamed <= 0) {
                this.l_renamed = appBarLayout.getMeasuredHeight();
                this.f2419c = view2;
                this.f2418b = appBarLayout.findViewById(coui.support.appcompat.R_renamed.id_renamed.divider_line);
                this.f2417a = this.f2418b.getWidth();
                this.j_renamed = this.f2418b.getLayoutParams();
                this.i_renamed = appBarLayout.getMeasuredWidth();
                int i3 = this.l_renamed;
                this.m_renamed = i3 - this.n_renamed;
                this.p_renamed = i3 - this.t_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_width_start_count_offset);
                this.o_renamed = this.p_renamed - this.q_renamed;
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.SecondToolbarBehavior.1
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(android.view.View view3, int i4, int i5, int i6, int i7) {
                        com.coui.appcompat.behavior.SecondToolbarBehavior.this.a_renamed();
                    }
                });
            } else if (view2 instanceof android.widget.AbsListView) {
                ((android.widget.AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i_renamed, int i2, int i3) {
        a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed() {
        this.d_renamed = null;
        android.view.View view = this.f2419c;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i_renamed).getVisibility() == 0) {
                        this.d_renamed = viewGroup.getChildAt(i_renamed);
                        break;
                    }
                    i_renamed++;
                }
            }
        }
        if (this.d_renamed == null) {
            this.d_renamed = this.f2419c;
        }
        this.d_renamed.getLocationOnScreen(this.h_renamed);
        this.e_renamed = this.h_renamed[1];
        this.f_renamed = 0;
        int i2 = this.e_renamed;
        if (i2 < this.m_renamed) {
            this.f_renamed = this.n_renamed;
        } else {
            int i3 = this.l_renamed;
            if (i2 > i3) {
                this.f_renamed = 0;
            } else {
                this.f_renamed = i3 - i2;
            }
        }
        this.g_renamed = this.f_renamed;
        if (this.r_renamed <= 1.0f) {
            this.r_renamed = java.lang.Math.abs(this.g_renamed) / this.n_renamed;
            this.f2418b.setAlpha(this.r_renamed);
        }
        int i4 = this.e_renamed;
        if (i4 < this.o_renamed) {
            this.f_renamed = this.q_renamed;
        } else {
            int i5 = this.p_renamed;
            if (i4 > i5) {
                this.f_renamed = 0;
            } else {
                this.f_renamed = i5 - i4;
            }
        }
        this.g_renamed = this.f_renamed;
        this.s_renamed = java.lang.Math.abs(this.g_renamed) / this.q_renamed;
        android.view.ViewGroup.LayoutParams layoutParams = this.j_renamed;
        layoutParams.width = (int) (this.f2417a + (this.k_renamed * this.s_renamed));
        this.f2418b.setLayoutParams(layoutParams);
    }
}
