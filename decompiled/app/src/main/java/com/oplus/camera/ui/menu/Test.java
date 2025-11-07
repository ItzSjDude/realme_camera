package com.oplus.camera.ui.menu;

/* compiled from: OptionItemIconTextList.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.ui.menu.BasicOptionItemList implements com.oplus.camera.ui.inverse.a_renamed {
    private com.oplus.camera.ui.RotateImageView B_renamed;
    private com.oplus.camera.ui.r_renamed C_renamed;
    private com.oplus.camera.ui.CameraUIListener D_renamed;
    private com.oplus.camera.ui.menu.j_renamed E_renamed;
    private java.lang.String F_renamed;
    private android.view.animation.PathInterpolator G_renamed;
    private android.view.animation.PathInterpolator H_renamed;
    private int I_renamed;
    private int J_renamed;

    public d_renamed(android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        super(context);
        this.B_renamed = null;
        this.C_renamed = null;
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = "";
        this.G_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.H_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.I_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_fade_out_y);
        this.J_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_fade_out_x);
        this.D_renamed = cameraUIListener;
        setClipChildren(false);
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void a_renamed(android.view.View view, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        super.a_renamed(view, i_renamed, i2);
        if (view == null || this.v_renamed == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, java.lang.Math.max(getItemsMeasureHeight(), a_renamed(this.q_renamed)));
        layoutParams.topMargin = i2;
        layoutParams.leftMargin = this.f6321b;
        i_renamed();
        this.v_renamed.addView(this, layoutParams);
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void i_renamed() throws android.content.res.Resources.NotFoundException {
        int iC;
        int iB;
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption;
        if (this.E_renamed != null) {
            return;
        }
        int screenWidth = com.oplus.camera.util.Util.getScreenWidth();
        if (com.oplus.camera.util.Util.u_renamed()) {
            screenWidth = this.D_renamed.bL_renamed().b_renamed();
        }
        int childCount = getChildCount();
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_item_second_space);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_title_margin_right);
        if (4 == this.D_renamed.ca_renamed()) {
            screenWidth = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_width);
            dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_second_level_item_space);
        }
        if (this.r_renamed.isEmpty() || (cameraMenuOption = this.r_renamed.get(0)) == null) {
            iC = 0;
            iB = 0;
        } else {
            iB = cameraMenuOption.B_renamed();
            iC = cameraMenuOption.C_renamed();
        }
        this.E_renamed = new com.oplus.camera.ui.menu.j_renamed(getContext(), null);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(((((screenWidth - (iB * childCount)) - ((childCount - 1) * dimensionPixelSize)) - dimensionPixelSize2) - this.o_renamed) - this.p_renamed, iC);
        this.E_renamed.setGravity(16);
        this.E_renamed.setLayoutParams(layoutParams);
        this.E_renamed.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_item_second_text_size));
        this.E_renamed.setMaxLines(2);
        this.E_renamed.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.E_renamed.setTextColor(this.q_renamed.getColorStateList(com.oplus.camera.R_renamed.color.menu_item_text_color_selector));
        this.E_renamed.setItemText(this.F_renamed);
        this.E_renamed.setContentDescription(this.F_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.q_renamed, this.E_renamed);
        if (1 != this.D_renamed.ca_renamed()) {
            addView(this.E_renamed);
        }
        this.E_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.d_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.ui.menu.d_renamed.this.e_renamed();
            }
        });
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void b_renamed() throws android.content.res.Resources.NotFoundException {
        super.b_renamed();
        com.oplus.camera.ui.menu.j_renamed jVar = this.E_renamed;
        if (jVar != null) {
            removeView(jVar);
            this.E_renamed = null;
        }
        i_renamed();
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void setTitleName(java.lang.String str) {
        this.F_renamed = str;
    }

    private int a_renamed(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return com.oplus.camera.util.Util.getSettingMenuPanelHeight();
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    protected void c_renamed() {
        this.w_renamed = new android.view.animation.AnimationSet(false);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(this.G_renamed);
        alphaAnimation.setStartOffset(150L);
        this.w_renamed.addAnimation(alphaAnimation);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, this.I_renamed, 0.0f);
        if (1 == this.D_renamed.ca_renamed()) {
            translateAnimation = new android.view.animation.TranslateAnimation(this.J_renamed, 0.0f, 0.0f, 0.0f);
        }
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(this.H_renamed);
        translateAnimation.setStartOffset(150L);
        this.w_renamed.addAnimation(translateAnimation);
        if (this.z_renamed == null) {
            this.z_renamed = new com.oplus.camera.ui.menu.BasicOptionItemList.PopUpFadeInAnimationListener();
        }
        this.w_renamed.setAnimationListener(this.z_renamed);
        this.y_renamed = new android.view.animation.AnimationSet(false);
        android.view.animation.AlphaAnimation alphaAnimation2 = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(250L);
        alphaAnimation2.setInterpolator(this.G_renamed);
        this.y_renamed.addAnimation(alphaAnimation2);
        android.view.animation.TranslateAnimation translateAnimation2 = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, this.I_renamed);
        if (1 == this.D_renamed.ca_renamed()) {
            translateAnimation2 = new android.view.animation.TranslateAnimation(0.0f, this.J_renamed, 0.0f, 0.0f);
        }
        translateAnimation2.setDuration(300L);
        translateAnimation2.setInterpolator(this.H_renamed);
        this.y_renamed.addAnimation(translateAnimation2);
        if (this.A_renamed == null) {
            this.A_renamed = new com.oplus.camera.ui.menu.BasicOptionItemList.PopUpFadeOutAnimationListener();
        }
        this.y_renamed.setAnimationListener(this.A_renamed);
    }

    private void j_renamed() {
        if (this.C_renamed == null) {
            this.C_renamed = new com.oplus.camera.ui.r_renamed(1.0f, 0.0f);
            this.C_renamed.a_renamed(new com.oplus.camera.ui.menu.d_renamed.a_renamed());
            this.C_renamed.setDuration(300L);
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public boolean a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption == null || this.r_renamed == null || this.r_renamed.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.a_renamed(this.s_renamed);
        this.r_renamed.add(cameraMenuOption);
        cameraMenuOption.a_renamed((android.view.ViewGroup) this);
        return true;
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public boolean a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed) {
        if (cameraMenuOption == null || this.r_renamed.contains(cameraMenuOption)) {
            return false;
        }
        if (i_renamed < 0) {
            i_renamed = 0;
        }
        if (i_renamed >= this.r_renamed.size()) {
            i_renamed = this.r_renamed.size();
        }
        this.r_renamed.add(i_renamed, cameraMenuOption);
        cameraMenuOption.a_renamed(this.s_renamed);
        cameraMenuOption.a_renamed((android.view.ViewGroup) this);
        return true;
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void f_renamed() {
        clearAnimation();
        setVisibility(8);
        if (this.t_renamed != null) {
            com.oplus.camera.ui.menu.g_renamed.c_renamed(this.t_renamed.a_renamed());
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void setOptionItemIcon(android.graphics.Bitmap bitmap) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.B_renamed;
        if (rotateImageView != null) {
            rotateImageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void a_renamed(int i_renamed) {
        super.a_renamed(i_renamed);
        if (1 == this.D_renamed.ca_renamed()) {
            if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.q_renamed.hashCode())) {
                setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.q_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_black));
            } else if (i_renamed == 0 || 1 == i_renamed) {
                setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.q_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_white));
            } else {
                setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.q_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_black));
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        b_renamed(b_renamed(z_renamed), z2, i_renamed);
    }

    private boolean b_renamed(boolean z_renamed) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            if (2 == this.D_renamed.ca_renamed()) {
                if ((5 == this.D_renamed.bP_renamed() || 1 == this.D_renamed.bP_renamed()) && !z_renamed) {
                    return false;
                }
            } else {
                if (3 != this.D_renamed.ca_renamed()) {
                    return false;
                }
                if ((this.D_renamed.bP_renamed() == 0 || 1 == this.D_renamed.bP_renamed()) && !z_renamed) {
                    return false;
                }
            }
        } else if (5 == this.D_renamed.bP_renamed() && !z_renamed) {
            return false;
        }
        return true;
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void b_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        if (this.r_renamed == null || this.r_renamed.size() < 1) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.r_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(z_renamed, z2, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void setSelectItemIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed == this.k_renamed) {
            return;
        }
        this.k_renamed = i_renamed;
        if (this.r_renamed == null || this.r_renamed.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (i2 < this.r_renamed.size()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.r_renamed.get(i2);
            if (cameraMenuOption != null) {
                cameraMenuOption.d_renamed(i2 == this.k_renamed);
            }
            i2++;
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (this.C_renamed == null) {
            j_renamed();
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.r_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(i_renamed, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public int getItemsMeasureWidth() {
        int iB = 0;
        if (this.r_renamed == null || this.r_renamed.size() <= 0) {
            return 0;
        }
        for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
            if (cameraMenuOption != null) {
                iB += cameraMenuOption.B_renamed();
            }
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.B_renamed;
        return rotateImageView != null ? iB + rotateImageView.getMeasuredWidth() : iB;
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public int getItemsMeasureHeight() {
        int iC;
        int i_renamed = 0;
        if (this.r_renamed == null || this.r_renamed.size() <= 0) {
            return 0;
        }
        for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
            if (cameraMenuOption != null && i_renamed <= (iC = cameraMenuOption.C_renamed())) {
                i_renamed = iC;
            }
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.B_renamed;
        return (rotateImageView == null || i_renamed > rotateImageView.getMeasuredHeight()) ? i_renamed : this.B_renamed.getMeasuredHeight();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        try {
            super.onMeasure(i_renamed, i2);
            if (this.B_renamed != null) {
                this.B_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) throws android.content.res.Resources.NotFoundException {
        if (1 == this.D_renamed.ca_renamed() && this.r_renamed != null && this.r_renamed.size() > 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_space_full);
            int i5 = 0;
            for (int i6 = 0; i6 <= this.r_renamed.size() - 1; i6++) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.r_renamed.get(i6);
                if (cameraMenuOption != null) {
                    int iB = cameraMenuOption.B_renamed();
                    cameraMenuOption.a_renamed(0, i5, iB, cameraMenuOption.C_renamed() + i5);
                    i5 += iB + dimensionPixelSize;
                }
            }
            return;
        }
        if (4 == this.D_renamed.ca_renamed() && this.r_renamed != null && this.r_renamed.size() > 0 && this.E_renamed != null) {
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_second_level_item_space);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_second_level_item_textview_left);
            int dimensionPixelSize4 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_second_level_item_top);
            int i7 = (i3 - i_renamed) - dimensionPixelSize3;
            com.oplus.camera.ui.menu.j_renamed jVar = this.E_renamed;
            jVar.layout(dimensionPixelSize3, dimensionPixelSize4, jVar.getMeasuredWidth() + dimensionPixelSize3, this.E_renamed.getMeasuredHeight() + dimensionPixelSize4);
            for (int size = this.r_renamed.size() - 1; size >= 0; size--) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption2 = this.r_renamed.get(size);
                if (cameraMenuOption2 != null) {
                    int iB2 = cameraMenuOption2.B_renamed();
                    cameraMenuOption2.a_renamed(i7 - iB2, dimensionPixelSize4, i7, cameraMenuOption2.C_renamed() + dimensionPixelSize4);
                    i7 -= iB2 + dimensionPixelSize2;
                }
            }
            return;
        }
        if (this.r_renamed == null || this.r_renamed.size() <= 0 || this.E_renamed == null) {
            return;
        }
        int i8 = i4 - i2;
        int i9 = i3 - i_renamed;
        int dimensionPixelSize5 = com.oplus.camera.util.Util.ai_renamed() ? this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.ear_screen_menu_item_offset) : 0;
        int dimensionPixelSize6 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_item_second_space);
        com.oplus.camera.ui.menu.j_renamed jVar2 = this.E_renamed;
        jVar2.layout(0, ((i8 - jVar2.getMeasuredHeight()) / 2) + dimensionPixelSize5, this.E_renamed.getMeasuredWidth() + 0, ((this.E_renamed.getMeasuredHeight() + i8) / 2) + dimensionPixelSize5);
        for (int size2 = this.r_renamed.size() - 1; size2 >= 0; size2--) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption3 = this.r_renamed.get(size2);
            if (cameraMenuOption3 != null) {
                int iB3 = cameraMenuOption3.B_renamed();
                int iC = cameraMenuOption3.C_renamed();
                int i10 = ((i8 - iC) / 2) + dimensionPixelSize5;
                cameraMenuOption3.a_renamed(i9 - iB3, i10, i9, iC + i10);
                i9 -= iB3 + dimensionPixelSize6;
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList
    public void h_renamed() {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.B_renamed;
        if (rotateImageView != null) {
            removeView(rotateImageView);
            this.B_renamed = null;
        }
        this.C_renamed = null;
        super.h_renamed();
    }

    /* compiled from: OptionItemIconTextList.java */
    private class a_renamed implements com.oplus.camera.ui.r_renamed.a_renamed {
        private a_renamed() {
        }

        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public void a_renamed(float f_renamed) {
            if (com.oplus.camera.ui.menu.d_renamed.this.B_renamed != null) {
                com.oplus.camera.ui.menu.d_renamed.this.B_renamed.setAlpha(f_renamed);
            }
            if (com.oplus.camera.ui.menu.d_renamed.this.r_renamed == null || com.oplus.camera.ui.menu.d_renamed.this.r_renamed.size() <= 0) {
                return;
            }
            for (int i_renamed = 0; i_renamed < com.oplus.camera.ui.menu.d_renamed.this.r_renamed.size(); i_renamed++) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = com.oplus.camera.ui.menu.d_renamed.this.r_renamed.get(i_renamed);
                if (cameraMenuOption != null) {
                    cameraMenuOption.a_renamed(f_renamed);
                }
            }
        }

        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.menu.d_renamed.this.B_renamed != null) {
                com.oplus.camera.ui.menu.d_renamed.this.B_renamed.a_renamed(i_renamed, false);
            }
            if (com.oplus.camera.ui.menu.d_renamed.this.r_renamed != null && com.oplus.camera.ui.menu.d_renamed.this.r_renamed.size() > 0) {
                for (int i2 = 0; i2 < com.oplus.camera.ui.menu.d_renamed.this.r_renamed.size(); i2++) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = com.oplus.camera.ui.menu.d_renamed.this.r_renamed.get(i2);
                    if (cameraMenuOption != null) {
                        cameraMenuOption.a_renamed(i_renamed, false);
                    }
                }
            }
            com.oplus.camera.ui.menu.d_renamed dVar = com.oplus.camera.ui.menu.d_renamed.this;
            dVar.l_renamed = i_renamed;
            dVar.requestLayout();
        }

        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public boolean a_renamed() {
            return com.oplus.camera.ui.menu.d_renamed.this.isShown();
        }
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        if (z_renamed) {
            setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.q_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_black));
        } else {
            a_renamed(this.n_renamed);
        }
    }
}
