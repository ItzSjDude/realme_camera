package com.coui.appcompat.widget;

/* compiled from: COUIPanelConstraintLayout.java */
/* loaded from: classes.dex */
public class l_renamed extends androidx.constraintlayout.widget.ConstraintLayout {
    private boolean g_renamed;
    private boolean h_renamed;
    private android.graphics.drawable.Drawable i_renamed;
    private int j_renamed;
    private androidx.constraintlayout.widget.c_renamed k_renamed;
    private android.widget.ImageView l_renamed;
    private android.view.View m_renamed;
    private android.view.View n_renamed;
    private com.coui.appcompat.widget.COUIButtonBarLayout o_renamed;
    private android.widget.Button p_renamed;
    private android.widget.Button q_renamed;
    private android.widget.Button r_renamed;
    private java.lang.String s_renamed;
    private java.lang.String t_renamed;
    private java.lang.String u_renamed;
    private android.view.View.OnClickListener v_renamed;
    private android.view.View.OnClickListener w_renamed;
    private android.view.View.OnClickListener x_renamed;
    private int y_renamed;
    private android.content.res.ColorStateList z_renamed;

    public l_renamed(android.content.Context context) {
        this(context, null);
    }

    public l_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.h_renamed = true;
        c_renamed();
    }

    private void c_renamed() throws android.content.res.Resources.NotFoundException {
        this.k_renamed = new androidx.constraintlayout.widget.c_renamed();
        this.k_renamed.a_renamed(this);
        d_renamed();
        this.k_renamed.b_renamed(this);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.z_renamed = getContext().getResources().getColorStateList(coui.support.appcompat.R_renamed.color.coui_bottom_sheet_bottom_btn_text_color, getContext().getTheme());
        } else {
            this.y_renamed = com.coui.appcompat.a_renamed.d_renamed.a_renamed(getContext(), coui.support.appcompat.R_renamed.attr.couiTintControlNormal, getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.couiGreenTintControlNormal));
        }
    }

    private void d_renamed() {
        int dimension = (int) getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_panel_drag_view_width);
        int dimension2 = (int) getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_panel_drag_view_height);
        this.i_renamed = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), coui.support.appcompat.R_renamed.drawable.coui_panel_drag_view);
        this.j_renamed = getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_drag_view_color);
        android.graphics.drawable.Drawable drawable = this.i_renamed;
        if (drawable != null) {
            drawable.setTint(this.j_renamed);
        }
        this.l_renamed = new android.widget.ImageView(getContext());
        this.l_renamed.setId(android.view.View.generateViewId());
        this.l_renamed.setImageDrawable(this.i_renamed);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.l_renamed.setForceDarkAllowed(false);
        }
        addView(this.l_renamed);
        this.k_renamed.b_renamed(this.l_renamed.getId(), dimension);
        this.k_renamed.a_renamed(this.l_renamed.getId(), dimension2);
        a_renamed(this.l_renamed.getId(), true);
    }

    public void b_renamed() {
        android.view.View view;
        if (android.text.TextUtils.isEmpty(this.s_renamed) && android.text.TextUtils.isEmpty(this.t_renamed) && android.text.TextUtils.isEmpty(this.u_renamed)) {
            return;
        }
        if (this.o_renamed == null) {
            this.o_renamed = (com.coui.appcompat.widget.COUIButtonBarLayout) android.view.LayoutInflater.from(getContext()).inflate(coui.support.appcompat.R_renamed.layout.coui_alert_dialog_button_panel, (android.view.ViewGroup) null);
        }
        com.coui.appcompat.widget.COUIButtonBarLayout cOUIButtonBarLayout = this.o_renamed;
        if (cOUIButtonBarLayout != null) {
            cOUIButtonBarLayout.setVerButDividerVerMargin(getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_panel_bottom_bar_padding_top));
            this.o_renamed.setVerButVerPadding(getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_panel_bottom_button_vertical_padding));
            this.o_renamed.setVerPaddingBottom(getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_panel_bottom_bar_padding_bottom));
            this.o_renamed.setVerButPaddingOffset(0);
            this.p_renamed = (android.widget.Button) this.o_renamed.findViewById(android.R_renamed.id_renamed.button2);
            this.q_renamed = (android.widget.Button) this.o_renamed.findViewById(android.R_renamed.id_renamed.button3);
            this.r_renamed = (android.widget.Button) this.o_renamed.findViewById(android.R_renamed.id_renamed.button1);
            a_renamed(this.p_renamed, this.s_renamed, this.v_renamed);
            a_renamed(this.q_renamed, this.t_renamed, this.w_renamed);
            a_renamed(this.r_renamed, this.u_renamed, this.x_renamed);
            if (this.o_renamed.getParent() == null) {
                addView(this.o_renamed);
                this.k_renamed.b_renamed(this.o_renamed.getId(), -1);
                this.k_renamed.a_renamed(this.o_renamed.getId(), -2);
                a_renamed(this.o_renamed.getId(), false);
                e_renamed();
                androidx.constraintlayout.widget.c_renamed cVar = this.k_renamed;
                if (cVar == null || this.n_renamed == null || (view = this.m_renamed) == null) {
                    return;
                }
                cVar.a_renamed(view.getId(), 4, this.n_renamed.getId(), 3);
                this.k_renamed.b_renamed(this);
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) this.m_renamed.getLayoutParams();
                aVar.U_renamed = true;
                aVar.A_renamed = 0.0f;
                this.m_renamed.setLayoutParams(aVar);
            }
        }
    }

    private void e_renamed() {
        if (this.o_renamed != null) {
            this.n_renamed = new android.view.View(getContext());
            com.coui.appcompat.a_renamed.e_renamed.a_renamed(this.n_renamed, false);
            this.n_renamed.setId(android.view.View.generateViewId());
            if (this.h_renamed) {
                this.n_renamed.setBackground(new android.graphics.drawable.ColorDrawable(getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_divider_background_color)));
            }
            addView(this.n_renamed);
            this.k_renamed.b_renamed(this.n_renamed.getId(), -1);
            this.k_renamed.a_renamed(this.n_renamed.getId(), 1);
            this.k_renamed.a_renamed(this.n_renamed.getId(), 6, 0, 6);
            this.k_renamed.a_renamed(this.n_renamed.getId(), 7, 0, 7);
            this.k_renamed.a_renamed(this.n_renamed.getId(), 4, this.o_renamed.getId(), 3);
        }
    }

    public void b_renamed(android.view.View view) {
        if (view != null) {
            this.m_renamed = view;
            if (this.m_renamed.getId() == -1) {
                this.m_renamed.setId(android.view.View.generateViewId());
            }
            addView(this.m_renamed);
            this.k_renamed.b_renamed(this.m_renamed.getId(), -1);
            this.k_renamed.a_renamed(this.m_renamed.getId(), -2);
            this.k_renamed.a_renamed(this.m_renamed.getId(), 6, 0, 6);
            this.k_renamed.a_renamed(this.m_renamed.getId(), 7, 0, 7);
            this.k_renamed.a_renamed(this.m_renamed.getId(), 3, this.l_renamed.getId(), 4);
            if (this.n_renamed != null) {
                this.k_renamed.a_renamed(this.m_renamed.getId(), 4, this.n_renamed.getId(), 3);
            } else if (this.o_renamed != null) {
                this.k_renamed.a_renamed(this.m_renamed.getId(), 4, this.o_renamed.getId(), 3);
            } else {
                this.k_renamed.a_renamed(this.m_renamed.getId(), 4, 0, 4);
            }
            this.k_renamed.b_renamed(this);
            androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) this.m_renamed.getLayoutParams();
            aVar.U_renamed = true;
            aVar.A_renamed = 0.0f;
            this.m_renamed.setLayoutParams(aVar);
        }
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        androidx.constraintlayout.widget.c_renamed cVar = this.k_renamed;
        if (cVar == null || i_renamed == -1) {
            return;
        }
        cVar.a_renamed(i_renamed, 6, 0, 6);
        this.k_renamed.a_renamed(i_renamed, 7, 0, 7);
        if (z_renamed) {
            this.k_renamed.a_renamed(i_renamed, 3, 0, 3);
        } else {
            this.k_renamed.a_renamed(i_renamed, 4, 0, 4);
        }
    }

    private void a_renamed(android.widget.Button button, java.lang.String str, android.view.View.OnClickListener onClickListener) {
        if (button != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                button.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            button.setText(str);
            button.setTextSize(0, getContext().getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.TD07));
            button.setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
            button.setSingleLine(false);
            button.setOnClickListener(onClickListener);
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                button.setTextColor(this.z_renamed);
            } else {
                button.setTextColor(this.y_renamed);
            }
            button.setGravity(17);
            button.setTextAlignment(4);
        }
    }

    public void setDragViewDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.i_renamed = drawable;
            this.l_renamed.setImageDrawable(this.i_renamed);
        }
    }

    public void setDragViewDrawableTintColor(int i_renamed) {
        android.graphics.drawable.Drawable drawable = this.i_renamed;
        if (drawable == null || this.j_renamed == i_renamed) {
            return;
        }
        this.j_renamed = i_renamed;
        drawable.setTint(this.j_renamed);
        this.l_renamed.setImageDrawable(this.i_renamed);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getMaxHeight() {
        return com.coui.appcompat.a_renamed.m_renamed.a_renamed(getContext(), (android.content.res.Configuration) null);
    }

    public void a_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.s_renamed = str;
        this.v_renamed = onClickListener;
        a_renamed(this.p_renamed, this.s_renamed, this.v_renamed);
    }

    public void b_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.t_renamed = str;
        this.w_renamed = onClickListener;
        a_renamed(this.q_renamed, this.t_renamed, this.w_renamed);
    }

    public void c_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.u_renamed = str;
        this.x_renamed = onClickListener;
        a_renamed(this.r_renamed, this.u_renamed, this.x_renamed);
    }

    public void setLayoutAtMaxHeight(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public boolean getLayoutAtMaxHeight() {
        return this.g_renamed;
    }

    public void setDividerVisibility(boolean z_renamed) {
        this.h_renamed = z_renamed;
        android.view.View view = this.n_renamed;
        if (view != null) {
            if (z_renamed) {
                view.setBackground(new android.graphics.drawable.ColorDrawable(getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_divider_background_color)));
            } else {
                view.setBackground(null);
            }
        }
    }

    public android.widget.ImageView getDragView() {
        return this.l_renamed;
    }

    public android.view.View getDivider() {
        return this.n_renamed;
    }

    public com.coui.appcompat.widget.COUIButtonBarLayout getBtnBarLayout() {
        return this.o_renamed;
    }
}
