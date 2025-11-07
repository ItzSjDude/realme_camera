package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIButtonBarLayout extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f2696a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.Button f2697b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.Button f2698c;
    private android.widget.Button d_renamed;
    private android.view.View e_renamed;
    private android.view.View f_renamed;
    private android.view.View g_renamed;
    private android.view.View h_renamed;
    private android.view.View i_renamed;
    private android.view.View j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private boolean w_renamed;

    public COUIButtonBarLayout(android.content.Context context) {
        super(context, null);
    }

    public COUIButtonBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIButtonBarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.f2696a = context;
        this.k_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_button_horizontal_padding);
        this.l_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_button_vertical_padding);
        this.o_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_delete_alert_dialog_divider_height);
        this.p_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_delete_alert_dialog_button_height);
        this.q_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.alert_dialog_item_padding_offset);
        this.m_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.alert_dialog_list_item_padding_top);
        this.r_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_vertical_button_divider_horizontal_margin);
        this.s_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_vertical_button_divider_vertical_margin);
        this.t_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_horizontal_button_divider_vertical_margin);
        this.u_renamed = this.f2696a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_alert_dialog_button_height);
    }

    public void setForceVertical(boolean z_renamed) {
        this.w_renamed = z_renamed;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        a_renamed();
        if (this.w_renamed || a_renamed(getMeasuredWidth())) {
            if (!t_renamed()) {
                b_renamed();
            }
            n_renamed();
            o_renamed();
            p_renamed();
            r_renamed();
            super.onMeasure(i_renamed, i2);
            return;
        }
        if (t_renamed()) {
            h_renamed();
        }
        q_renamed();
        s_renamed();
        super.onMeasure(i_renamed, i2);
    }

    private void a_renamed() {
        if (this.f2697b == null || this.f2698c == null || this.d_renamed == null || this.e_renamed == null || this.f_renamed == null || this.g_renamed == null || this.h_renamed == null || this.i_renamed == null || this.j_renamed == null) {
            this.f2697b = (android.widget.Button) findViewById(android.R_renamed.id_renamed.button1);
            this.f2698c = (android.widget.Button) findViewById(android.R_renamed.id_renamed.button2);
            this.d_renamed = (android.widget.Button) findViewById(android.R_renamed.id_renamed.button3);
            this.e_renamed = findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_dialog_button_divider_1);
            this.f_renamed = findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_dialog_button_divider_2);
            this.g_renamed = (android.view.View) getParent();
            this.h_renamed = this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.topPanel);
            this.i_renamed = this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.contentPanel);
            this.j_renamed = this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.customPanel);
        }
    }

    private boolean a_renamed(int i_renamed) {
        int buttonCount = getButtonCount();
        if (buttonCount == 0) {
            return false;
        }
        int i2 = ((i_renamed - ((buttonCount - 1) * this.o_renamed)) / buttonCount) - (this.k_renamed * 2);
        return a_renamed(this.f2697b) > i2 || a_renamed(this.f2698c) > i2 || a_renamed(this.d_renamed) > i2;
    }

    private int a_renamed(android.widget.Button button) {
        float fMeasureText;
        if (button == null || button.getVisibility() != 0) {
            return 0;
        }
        if (android.os.Build.VERSION.SDK_INT >= 28 && button.isAllCaps()) {
            fMeasureText = button.getPaint().measureText(button.getText().toString().toUpperCase());
        } else {
            fMeasureText = button.getPaint().measureText(button.getText().toString());
        }
        return (int) fMeasureText;
    }

    private void b_renamed() {
        setOrientation(1);
        setMinimumHeight(0);
        e_renamed();
        g_renamed();
        d_renamed();
        f_renamed();
        c_renamed();
    }

    private void c_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f2697b.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f2697b.setLayoutParams(layoutParams);
        android.widget.Button button = this.f2697b;
        int i_renamed = this.l_renamed;
        int i2 = this.m_renamed;
        button.setPaddingRelative(i_renamed, this.q_renamed + i2, i_renamed, i2);
        this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
    }

    private void d_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f2698c.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f2698c.setLayoutParams(layoutParams);
        android.widget.Button button = this.f2698c;
        int i_renamed = this.l_renamed;
        int i2 = this.m_renamed;
        button.setPaddingRelative(i_renamed, i2, i_renamed, this.q_renamed + i2);
        this.f2698c.setMinHeight(this.p_renamed + this.q_renamed);
        bringChildToFront(this.f2698c);
    }

    private void e_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.d_renamed.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.d_renamed.setLayoutParams(layoutParams);
        android.widget.Button button = this.d_renamed;
        int i_renamed = this.l_renamed;
        int i2 = this.m_renamed;
        button.setPaddingRelative(i_renamed, i2, i_renamed, i2);
        this.d_renamed.setMinHeight(this.p_renamed);
        bringChildToFront(this.d_renamed);
    }

    private void f_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.e_renamed.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.o_renamed;
        layoutParams.setMarginStart(this.r_renamed);
        layoutParams.setMarginEnd(this.r_renamed);
        layoutParams.topMargin = this.s_renamed;
        layoutParams.bottomMargin = 0;
        this.e_renamed.setLayoutParams(layoutParams);
    }

    private void g_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.o_renamed;
        layoutParams.setMarginStart(this.r_renamed);
        layoutParams.setMarginEnd(this.r_renamed);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f_renamed.setLayoutParams(layoutParams);
        bringChildToFront(this.f_renamed);
    }

    private void h_renamed() {
        setOrientation(0);
        setMinimumHeight(this.u_renamed);
        l_renamed();
        k_renamed();
        m_renamed();
        i_renamed();
        j_renamed();
    }

    private void i_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f2697b.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f2697b.setLayoutParams(layoutParams);
        android.widget.Button button = this.f2697b;
        int i_renamed = this.k_renamed;
        button.setPaddingRelative(i_renamed, 0, i_renamed, 0);
        this.f2697b.setMinHeight(0);
        bringChildToFront(this.f2697b);
    }

    private void j_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f2698c.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f2698c.setLayoutParams(layoutParams);
        android.widget.Button button = this.f2698c;
        int i_renamed = this.k_renamed;
        button.setPaddingRelative(i_renamed, 0, i_renamed, 0);
        this.f2698c.setMinHeight(0);
    }

    private void k_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.d_renamed.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.d_renamed.setLayoutParams(layoutParams);
        android.widget.Button button = this.d_renamed;
        int i_renamed = this.k_renamed;
        button.setPaddingRelative(i_renamed, 0, i_renamed, 0);
        this.d_renamed.setMinHeight(0);
        bringChildToFront(this.d_renamed);
    }

    private void l_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.e_renamed.getLayoutParams();
        layoutParams.width = this.o_renamed;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int i_renamed = this.t_renamed;
        layoutParams.topMargin = i_renamed;
        layoutParams.bottomMargin = i_renamed;
        this.e_renamed.setLayoutParams(layoutParams);
        bringChildToFront(this.e_renamed);
    }

    private void m_renamed() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams.width = this.o_renamed;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int i_renamed = this.t_renamed;
        layoutParams.topMargin = i_renamed;
        layoutParams.bottomMargin = i_renamed;
        this.f_renamed.setLayoutParams(layoutParams);
        bringChildToFront(this.f_renamed);
    }

    private void n_renamed() {
        if (this.w_renamed) {
            if (a_renamed((android.view.View) this.f2698c)) {
                if (a_renamed((android.view.View) this.f2697b) || a_renamed((android.view.View) this.d_renamed) || a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
                    android.widget.Button button = this.f2698c;
                    int i_renamed = this.l_renamed;
                    int i2 = this.m_renamed;
                    int i3 = this.n_renamed;
                    button.setPaddingRelative(i_renamed, i2 + i3, i_renamed, i2 + i3);
                    this.f2698c.setMinHeight(this.p_renamed + (this.n_renamed * 2));
                } else {
                    android.widget.Button button2 = this.f2698c;
                    int i4 = this.l_renamed;
                    int i5 = this.m_renamed;
                    button2.setPaddingRelative(i4, this.q_renamed + i5, i4, i5);
                    this.f2698c.setMinHeight(this.p_renamed + this.q_renamed);
                }
            }
            if (a_renamed((android.view.View) this.d_renamed)) {
                if (a_renamed((android.view.View) this.f2698c)) {
                    if (a_renamed((android.view.View) this.f2697b) || a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
                        android.widget.Button button3 = this.d_renamed;
                        int i6 = this.l_renamed;
                        int i7 = this.m_renamed;
                        button3.setPaddingRelative(i6, i7, i6, this.q_renamed + i7);
                        this.d_renamed.setMinHeight(this.p_renamed + this.q_renamed);
                    } else {
                        android.widget.Button button4 = this.d_renamed;
                        int i8 = this.l_renamed;
                        int i9 = this.m_renamed;
                        int i10 = this.q_renamed;
                        button4.setPaddingRelative(i8, i9 + i10, i8, i9 + i10);
                        this.d_renamed.setMinHeight(this.p_renamed + (this.q_renamed * 2));
                    }
                } else if (a_renamed((android.view.View) this.f2697b) || a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
                    android.widget.Button button5 = this.d_renamed;
                    int i11 = this.l_renamed;
                    int i12 = this.m_renamed;
                    button5.setPaddingRelative(i11, i12, i11, i12);
                    this.d_renamed.setMinHeight(this.p_renamed);
                } else {
                    android.widget.Button button6 = this.d_renamed;
                    int i13 = this.l_renamed;
                    int i14 = this.m_renamed;
                    button6.setPaddingRelative(i13, this.q_renamed + i14, i13, i14);
                    this.d_renamed.setMinHeight(this.p_renamed + this.q_renamed);
                }
            }
            if (a_renamed((android.view.View) this.f2697b)) {
                if (a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
                    if (a_renamed((android.view.View) this.f2698c)) {
                        if (a_renamed((android.view.View) this.d_renamed)) {
                            android.widget.Button button7 = this.f2697b;
                            int i15 = this.l_renamed;
                            int i16 = this.m_renamed;
                            button7.setPaddingRelative(i15, i16, i15, i16);
                            this.f2697b.setMinHeight(this.p_renamed);
                            return;
                        }
                        android.widget.Button button8 = this.f2697b;
                        int i17 = this.l_renamed;
                        int i18 = this.m_renamed;
                        button8.setPaddingRelative(i17, i18, i17, this.q_renamed + i18);
                        this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
                        return;
                    }
                    if (a_renamed((android.view.View) this.d_renamed)) {
                        android.widget.Button button9 = this.f2697b;
                        int i19 = this.l_renamed;
                        int i20 = this.m_renamed;
                        button9.setPaddingRelative(i19, i20, i19, this.q_renamed + i20);
                        this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
                        return;
                    }
                    android.widget.Button button10 = this.f2697b;
                    int i21 = this.l_renamed;
                    int i22 = this.m_renamed;
                    button10.setPaddingRelative(i21, i22, i21, i22);
                    this.f2697b.setMinHeight(this.p_renamed);
                    return;
                }
                if (a_renamed((android.view.View) this.f2698c)) {
                    if (a_renamed((android.view.View) this.d_renamed)) {
                        android.widget.Button button11 = this.f2697b;
                        int i23 = this.l_renamed;
                        int i24 = this.m_renamed;
                        button11.setPaddingRelative(i23, this.q_renamed + i24, i23, i24);
                        this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
                        return;
                    }
                    android.widget.Button button12 = this.f2697b;
                    int i25 = this.l_renamed;
                    int i26 = this.m_renamed;
                    int i27 = this.q_renamed;
                    button12.setPaddingRelative(i25, i26 + i27, i25, i26 + i27);
                    this.f2697b.setMinHeight(this.p_renamed + (this.q_renamed * 2));
                    return;
                }
                if (a_renamed((android.view.View) this.d_renamed)) {
                    android.widget.Button button13 = this.f2697b;
                    int i28 = this.l_renamed;
                    int i29 = this.m_renamed;
                    int i30 = this.q_renamed;
                    button13.setPaddingRelative(i28, i29 + i30, i28, i29 + i30);
                    this.f2697b.setMinHeight(this.p_renamed + (this.q_renamed * 2));
                    return;
                }
                android.widget.Button button14 = this.f2697b;
                int i31 = this.l_renamed;
                int i32 = this.m_renamed;
                button14.setPaddingRelative(i31, this.q_renamed + i32, i31, i32);
                this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
                return;
            }
            return;
        }
        if (a_renamed((android.view.View) this.f2697b)) {
            if (a_renamed((android.view.View) this.d_renamed) || a_renamed((android.view.View) this.f2698c)) {
                android.widget.Button button15 = this.f2697b;
                int i33 = this.l_renamed;
                int i34 = this.m_renamed;
                button15.setPaddingRelative(i33, i34, i33, i34);
                this.f2697b.setMinHeight(this.p_renamed);
            } else {
                android.widget.Button button16 = this.f2697b;
                int i35 = this.l_renamed;
                int i36 = this.m_renamed;
                button16.setPaddingRelative(i35, i36, i35, this.q_renamed + i36);
                this.f2697b.setMinHeight(this.p_renamed + this.q_renamed);
            }
        }
        if (a_renamed((android.view.View) this.d_renamed)) {
            if (a_renamed((android.view.View) this.f2697b)) {
                if (a_renamed((android.view.View) this.f2698c)) {
                    android.widget.Button button17 = this.d_renamed;
                    int i37 = this.l_renamed;
                    int i38 = this.m_renamed;
                    button17.setPaddingRelative(i37, i38, i37, i38);
                    this.d_renamed.setMinHeight(this.p_renamed);
                } else {
                    android.widget.Button button18 = this.d_renamed;
                    int i39 = this.l_renamed;
                    int i40 = this.m_renamed;
                    button18.setPaddingRelative(i39, i40, i39, this.q_renamed + i40);
                    this.d_renamed.setMinHeight(this.p_renamed + this.q_renamed);
                }
            } else if (a_renamed((android.view.View) this.f2698c)) {
                android.widget.Button button19 = this.d_renamed;
                int i41 = this.l_renamed;
                int i42 = this.m_renamed;
                button19.setPaddingRelative(i41, i42, i41, i42);
                this.d_renamed.setMinHeight(this.p_renamed);
            } else {
                android.widget.Button button20 = this.d_renamed;
                int i43 = this.l_renamed;
                int i44 = this.m_renamed;
                button20.setPaddingRelative(i43, i44, i43, this.q_renamed + i44);
                this.d_renamed.setMinHeight(this.p_renamed + this.q_renamed);
            }
        }
        if (a_renamed((android.view.View) this.f2698c)) {
            android.widget.Button button21 = this.f2698c;
            int i45 = this.l_renamed;
            int i46 = this.m_renamed;
            button21.setPaddingRelative(i45, i46, i45, this.q_renamed + i46);
            this.f2698c.setMinHeight(this.p_renamed + this.q_renamed);
        }
    }

    private void o_renamed() {
        android.widget.Button button;
        if (!this.w_renamed || a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
            return;
        }
        if (getButtonCount() == 1) {
            if (a_renamed((android.view.View) this.f2697b)) {
                button = this.f2697b;
            } else {
                button = a_renamed((android.view.View) this.d_renamed) ? this.d_renamed : this.f2698c;
            }
            button.setBackgroundResource(coui.support.appcompat.R_renamed.drawable.coui_alert_bottom_dialog_corner_button_background);
            return;
        }
        if (getButtonCount() == 2) {
            (a_renamed((android.view.View) this.f2697b) ? this.f2697b : this.d_renamed).setBackgroundResource(coui.support.appcompat.R_renamed.drawable.coui_alert_bottom_dialog_corner_button_background);
        } else if (getButtonCount() == 3) {
            this.f2697b.setBackgroundResource(coui.support.appcompat.R_renamed.drawable.coui_alert_bottom_dialog_corner_button_background);
        }
    }

    private void p_renamed() {
        if (this.w_renamed) {
            if (getButtonCount() != 0) {
                if (a_renamed((android.view.View) this.f2698c)) {
                    if (a_renamed((android.view.View) this.d_renamed) || a_renamed((android.view.View) this.f2697b) || a_renamed(this.h_renamed) || a_renamed(this.i_renamed) || a_renamed(this.j_renamed)) {
                        this.e_renamed.setVisibility(8);
                        this.f_renamed.setVisibility(0);
                        return;
                    } else {
                        this.e_renamed.setVisibility(8);
                        this.f_renamed.setVisibility(8);
                        return;
                    }
                }
                this.e_renamed.setVisibility(8);
                this.f_renamed.setVisibility(8);
                return;
            }
            this.e_renamed.setVisibility(8);
            this.f_renamed.setVisibility(8);
            return;
        }
        if (getButtonCount() != 0) {
            this.e_renamed.setVisibility(4);
            this.f_renamed.setVisibility(8);
        } else {
            this.e_renamed.setVisibility(8);
            this.f_renamed.setVisibility(8);
        }
    }

    private void q_renamed() {
        if (getButtonCount() == 2) {
            if (a_renamed((android.view.View) this.f2697b)) {
                this.e_renamed.setVisibility(8);
                this.f_renamed.setVisibility(0);
                return;
            } else {
                this.e_renamed.setVisibility(0);
                this.f_renamed.setVisibility(8);
                return;
            }
        }
        if (getButtonCount() == 3) {
            this.e_renamed.setVisibility(0);
            this.f_renamed.setVisibility(0);
        } else {
            this.e_renamed.setVisibility(8);
            this.f_renamed.setVisibility(8);
        }
    }

    private void r_renamed() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.v_renamed);
    }

    private void s_renamed() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), 0);
    }

    private int getButtonCount() {
        int i_renamed = a_renamed((android.view.View) this.f2697b) ? 1 : 0;
        if (a_renamed((android.view.View) this.f2698c)) {
            i_renamed++;
        }
        return a_renamed((android.view.View) this.d_renamed) ? i_renamed + 1 : i_renamed;
    }

    private boolean t_renamed() {
        return getOrientation() == 1;
    }

    private boolean a_renamed(android.view.View view) {
        return view.getVisibility() == 0;
    }

    public void setVerButDividerVerMargin(int i_renamed) {
        this.s_renamed = i_renamed;
    }

    public void setVerButVerPadding(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    public void setVerNegButVerPaddingOffset(int i_renamed) {
        this.n_renamed = i_renamed;
    }

    public void setVerPaddingBottom(int i_renamed) {
        this.v_renamed = i_renamed;
    }

    public void setVerButPaddingOffset(int i_renamed) {
        this.q_renamed = i_renamed;
    }
}
