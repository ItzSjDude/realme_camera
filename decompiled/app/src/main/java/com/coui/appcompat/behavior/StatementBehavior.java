package com.coui.appcompat.behavior;

/* loaded from: classes.dex */
public class StatementBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f2421a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.View f2422b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.View f2423c;
    private android.view.View d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int[] h_renamed;
    private android.view.ViewGroup.LayoutParams i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private float q_renamed;
    private float r_renamed;
    private android.content.res.Resources s_renamed;

    public StatementBehavior() {
        this.h_renamed = new int[2];
    }

    public StatementBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h_renamed = new int[2];
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.s_renamed = context.getResources();
        this.j_renamed = this.s_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_margin_horizontal) * 2;
        this.m_renamed = this.s_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_line_alpha_range_change_offset);
        this.p_renamed = this.s_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_width_change_offset);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2, android.view.View view3, int i_renamed, int i2) {
        if (this.k_renamed <= 0) {
            view.getLocationOnScreen(this.h_renamed);
            this.k_renamed = this.h_renamed[1];
            this.f2423c = view3;
            this.f2422b = view.findViewById(coui.support.appcompat.R_renamed.id_renamed.divider_line);
            this.f2421a = this.f2422b.getWidth();
            this.i_renamed = this.f2422b.getLayoutParams();
            int i3 = this.k_renamed;
            this.l_renamed = i3 - this.m_renamed;
            this.o_renamed = i3 - this.s_renamed.getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.preference_divider_width_start_count_offset);
            this.n_renamed = this.o_renamed - this.p_renamed;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return false;
        }
        view3.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.StatementBehavior.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(android.view.View view4, int i4, int i5, int i6, int i7) {
                com.coui.appcompat.behavior.StatementBehavior.this.a_renamed();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed() {
        this.d_renamed = null;
        android.view.View view = this.f2423c;
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
            this.d_renamed = this.f2423c;
        }
        this.d_renamed.getLocationOnScreen(this.h_renamed);
        this.e_renamed = this.h_renamed[1];
        this.f_renamed = 0;
        int i2 = this.e_renamed;
        if (i2 < this.l_renamed) {
            this.f_renamed = this.m_renamed;
        } else {
            int i3 = this.k_renamed;
            if (i2 > i3) {
                this.f_renamed = 0;
            } else {
                this.f_renamed = i3 - i2;
            }
        }
        this.g_renamed = this.f_renamed;
        if (this.q_renamed <= 1.0f) {
            this.q_renamed = java.lang.Math.abs(this.g_renamed) / this.m_renamed;
            this.f2422b.setAlpha(this.q_renamed);
        }
        int i4 = this.e_renamed;
        if (i4 < this.n_renamed) {
            this.f_renamed = this.p_renamed;
        } else {
            int i5 = this.o_renamed;
            if (i4 > i5) {
                this.f_renamed = 0;
            } else {
                this.f_renamed = i5 - i4;
            }
        }
        this.g_renamed = this.f_renamed;
        this.r_renamed = java.lang.Math.abs(this.g_renamed) / this.p_renamed;
        android.view.ViewGroup.LayoutParams layoutParams = this.i_renamed;
        layoutParams.width = (int) (this.f2421a - (this.j_renamed * (1.0f - this.r_renamed)));
        this.f2422b.setLayoutParams(layoutParams);
    }
}
