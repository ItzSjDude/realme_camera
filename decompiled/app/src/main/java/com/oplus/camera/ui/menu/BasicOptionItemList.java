package com.oplus.camera.ui.menu;

/* loaded from: classes2.dex */
public class BasicOptionItemList extends android.widget.RelativeLayout {
    protected android.view.animation.Animation.AnimationListener A_renamed;
    private boolean B_renamed;
    private boolean C_renamed;
    private boolean D_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected int f6320a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f6321b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f6322c;
    protected int d_renamed;
    protected int e_renamed;
    protected int f_renamed;
    protected int g_renamed;
    protected int h_renamed;
    protected int i_renamed;
    protected int j_renamed;
    protected int k_renamed;
    protected int l_renamed;
    protected int m_renamed;
    protected int n_renamed;
    protected int o_renamed;
    protected int p_renamed;
    protected android.content.Context q_renamed;
    protected java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> r_renamed;
    protected com.oplus.camera.ui.menu.BasicOptionItemList.ItemClickListener s_renamed;
    protected com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener t_renamed;
    protected com.oplus.camera.ui.menu.BasicOptionItemList.OnPopUpFadeOutAnimationStartListener u_renamed;
    protected android.view.ViewGroup v_renamed;
    protected android.view.animation.AnimationSet w_renamed;
    protected android.view.animation.AnimationSet x_renamed;
    protected android.view.animation.AnimationSet y_renamed;
    protected android.view.animation.Animation.AnimationListener z_renamed;

    public interface OnPopUpFadeOutAnimationStartListener {
        void onPopUpFadeOutAnimationEnd();
    }

    public interface OptionItemListListener {
        java.lang.String a_renamed();

        void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed);
    }

    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
    }

    public void b_renamed() {
    }

    public void b_renamed(boolean z_renamed, boolean z2, int i_renamed) {
    }

    protected void c_renamed() {
    }

    public void i_renamed() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public void setOptionItemIcon(android.graphics.Bitmap bitmap) {
    }

    public void setTitleName(java.lang.String str) {
    }

    public BasicOptionItemList(android.content.Context context) {
        super(context);
        this.f6320a = 0;
        this.f6321b = 0;
        this.f6322c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = -1;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = new com.oplus.camera.ui.menu.BasicOptionItemList.PopUpFadeInAnimationListener();
        this.A_renamed = new com.oplus.camera.ui.menu.BasicOptionItemList.PopUpFadeOutAnimationListener();
        this.B_renamed = false;
        this.C_renamed = false;
        this.D_renamed = false;
        this.q_renamed = context;
        this.r_renamed = new java.util.ArrayList();
        this.s_renamed = new com.oplus.camera.ui.menu.BasicOptionItemList.ItemClickListener();
        this.f6320a = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_setting_width);
        this.e_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_less_than_three_items_margin_left);
        this.f_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_less_than_two_items_margin_left);
        this.g_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_more_than_three_items_margin_left);
        this.h_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_less_than_three_items_padding_right);
        this.i_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_more_than_three_items_padding_right);
        this.j_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_min_items_margin);
        this.B_renamed = false;
        this.C_renamed = false;
        this.o_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_left_margin);
        this.p_renamed = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.itemlist_right_margin);
    }

    public void a_renamed(android.view.View view, int i_renamed, int i2) {
        if (view != null) {
            this.v_renamed = (android.view.ViewGroup) view.getRootView().findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
    }

    public void a_renamed() {
        int i_renamed;
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        if (list != null) {
            if (list.size() == 3 && getItemsMeasureWidth() <= ((com.oplus.camera.util.Util.getScreenWidth() - this.e_renamed) - this.h_renamed) - (this.j_renamed * (this.r_renamed.size() - 1))) {
                this.f6321b = this.e_renamed;
                this.d_renamed = this.h_renamed;
            } else if (this.r_renamed.size() == 2 && getItemsMeasureWidth() <= ((com.oplus.camera.util.Util.getScreenWidth() - this.f_renamed) - this.h_renamed) - (this.j_renamed * (this.r_renamed.size() - 1))) {
                this.f6321b = this.f_renamed;
                this.d_renamed = this.h_renamed;
            } else {
                this.f6321b = this.g_renamed;
                this.d_renamed = this.i_renamed;
            }
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null || 4 == (i_renamed = this.m_renamed) || 1 == i_renamed) {
            return;
        }
        layoutParams.leftMargin = this.o_renamed;
        layoutParams.rightMargin = this.p_renamed;
        setLayoutParams(layoutParams);
    }

    public int getMarginLeft() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width);
        return (this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_first_level_bar_width) - ((this.r_renamed.size() - 1) * (this.q_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_item_second_space) + dimensionPixelSize))) - dimensionPixelSize;
    }

    public void a_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
    }

    public boolean a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list;
        if (cameraMenuOption == null || (list = this.r_renamed) == null || list.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.a_renamed(this.s_renamed);
        this.r_renamed.add(cameraMenuOption);
        cameraMenuOption.a_renamed((android.view.ViewGroup) this);
        return true;
    }

    public void setDrawShadow(boolean z_renamed) {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        if (list != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = list.iterator();
            while (it.hasNext()) {
                it.next().b_renamed(z_renamed);
            }
        }
    }

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

    public void b_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.r_renamed.size()) {
            com.oplus.camera.e_renamed.a_renamed("BasicOptionItemList", "removeOptionItem(), exception: the index is_renamed error, index: " + i_renamed);
            return;
        }
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.r_renamed.get(i_renamed);
        this.r_renamed.remove(i_renamed);
        cameraMenuOption.n_renamed();
    }

    public com.oplus.camera.ui.menu.setting.CameraMenuOption c_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.r_renamed.size()) {
            com.oplus.camera.e_renamed.a_renamed("BasicOptionItemList", "getOptionItem(), exception: the index is_renamed error, index: " + i_renamed);
            return null;
        }
        return this.r_renamed.get(i_renamed);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        if (list == null || list.size() < 1) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.r_renamed.size(); i_renamed++) {
            this.r_renamed.get(i_renamed).a_renamed(z_renamed, z2);
        }
    }

    public void setSelectItemIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed == this.k_renamed) {
            return;
        }
        this.k_renamed = i_renamed;
    }

    public void setOptionItemListListener(com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener optionItemListListener) {
        this.t_renamed = optionItemListListener;
    }

    public void setOnPopUpFadeOutAnimationStartListener(com.oplus.camera.ui.menu.BasicOptionItemList.OnPopUpFadeOutAnimationStartListener onPopUpFadeOutAnimationStartListener) {
        this.u_renamed = onPopUpFadeOutAnimationStartListener;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (this.l_renamed != i_renamed) {
            this.l_renamed = i_renamed;
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
                if (cameraMenuOption != null) {
                    cameraMenuOption.a_renamed(i_renamed, z_renamed);
                }
            }
        }
    }

    public void d_renamed() {
        a_renamed();
        setVisibility(0);
        clearAnimation();
        if (this.w_renamed == null) {
            c_renamed();
        }
        android.view.animation.AnimationSet animationSet = this.w_renamed;
        if (animationSet != null) {
            startAnimation(animationSet);
        }
    }

    public void e_renamed() {
        a_renamed(true);
    }

    public void a_renamed(boolean z_renamed) {
        if (isShown()) {
            if (this.y_renamed == null) {
                c_renamed();
            }
            android.view.animation.AnimationSet animationSet = this.y_renamed;
            if (animationSet != null) {
                if (!animationSet.hasStarted() || this.y_renamed.hasEnded()) {
                    this.D_renamed = z_renamed;
                    clearAnimation();
                    startAnimation(this.y_renamed);
                }
            }
        }
    }

    public void f_renamed() {
        clearAnimation();
        setVisibility(8);
        com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener optionItemListListener = this.t_renamed;
        if (optionItemListListener != null) {
            com.oplus.camera.ui.menu.g_renamed.c_renamed(optionItemListListener.a_renamed());
        }
        this.B_renamed = false;
        this.C_renamed = false;
    }

    public boolean getPopUpWindowState() {
        return isShown();
    }

    public int getItemsMeasureWidth() {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        int iB = 0;
        if (list != null && list.size() > 0) {
            for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
                if (cameraMenuOption != null) {
                    iB += cameraMenuOption.B_renamed();
                }
            }
        }
        return iB;
    }

    public int getItemsMeasureHeight() {
        int iC;
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        int i_renamed = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
            if (cameraMenuOption != null && i_renamed < (iC = cameraMenuOption.C_renamed())) {
                i_renamed = iC;
            }
        }
        return i_renamed * this.r_renamed.size();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.r_renamed;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i5 = 0;
        for (com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption : this.r_renamed) {
            if (cameraMenuOption != null) {
                int iB = cameraMenuOption.B_renamed();
                int iC = cameraMenuOption.C_renamed() + i5;
                cameraMenuOption.a_renamed(0, i5, iB, iC);
                i5 = iC;
            }
        }
    }

    public void g_renamed() {
        if (isShown()) {
            clearAnimation();
            setVisibility(8);
        }
        this.B_renamed = false;
        this.C_renamed = false;
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BasicOptionItemList", "release()");
        if (this.r_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.r_renamed.size(); i_renamed++) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.r_renamed.get(i_renamed);
                if (cameraMenuOption != null) {
                    cameraMenuOption.n_renamed();
                }
            }
            this.r_renamed.clear();
            this.r_renamed = null;
        }
        removeAllViews();
        android.view.ViewGroup viewGroup = this.v_renamed;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.v_renamed = null;
        }
        this.q_renamed = null;
        this.t_renamed = null;
        this.s_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
    }

    public void setScreenLayoutMode(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ItemClickListener implements com.oplus.camera.ui.menu.setting.CameraMenuOption.OnItemClickListener {
        private ItemClickListener() {
        }

        @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption.OnItemClickListener
        public void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.r_renamed == null || com.oplus.camera.ui.menu.BasicOptionItemList.this.r_renamed.size() <= 0 || com.oplus.camera.ui.menu.BasicOptionItemList.this.C_renamed || com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed == null) {
                return;
            }
            int iIndexOf = com.oplus.camera.ui.menu.BasicOptionItemList.this.r_renamed.indexOf(cameraMenuOption);
            com.oplus.camera.e_renamed.a_renamed("BasicOptionItemList", "onItemClick, index: " + iIndexOf);
            com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed.a_renamed(cameraMenuOption, iIndexOf);
        }
    }

    protected final class PopUpFadeInAnimationListener implements android.view.animation.Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        protected PopUpFadeInAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.BasicOptionItemList.this.a_renamed(true, false);
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.isShown()) {
                if (com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed != null) {
                    com.oplus.camera.ui.menu.g_renamed.b_renamed(com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed.a_renamed());
                }
                if (com.oplus.camera.ui.menu.BasicOptionItemList.this.x_renamed == null || com.oplus.camera.ui.menu.BasicOptionItemList.this.B_renamed) {
                    return;
                }
                com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = com.oplus.camera.ui.menu.BasicOptionItemList.this;
                basicOptionItemList.startAnimation(basicOptionItemList.x_renamed);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.BasicOptionItemList.this.a_renamed(false, false);
            com.oplus.camera.ui.menu.BasicOptionItemList.this.C_renamed = false;
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed == null || com.oplus.camera.ui.menu.BasicOptionItemList.this.B_renamed) {
                return;
            }
            com.oplus.camera.ui.menu.g_renamed.a_renamed(com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed.a_renamed());
        }
    }

    protected final class PopUpFadeOutAnimationListener implements android.view.animation.Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        protected PopUpFadeOutAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.BasicOptionItemList.this.a_renamed(true, false);
            com.oplus.camera.ui.menu.BasicOptionItemList.this.setVisibility(8);
            com.oplus.camera.ui.menu.BasicOptionItemList.this.B_renamed = false;
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed != null) {
                com.oplus.camera.ui.menu.g_renamed.c_renamed(com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed.a_renamed());
            }
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.u_renamed != null) {
                com.oplus.camera.ui.menu.BasicOptionItemList.this.u_renamed.onPopUpFadeOutAnimationEnd();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.BasicOptionItemList.this.a_renamed(false, false);
            com.oplus.camera.ui.menu.BasicOptionItemList.this.B_renamed = true;
            com.oplus.camera.ui.menu.BasicOptionItemList.this.C_renamed = true;
            if (com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed != null) {
                com.oplus.camera.ui.menu.g_renamed.a_renamed(com.oplus.camera.ui.menu.BasicOptionItemList.this.t_renamed.a_renamed(), com.oplus.camera.ui.menu.BasicOptionItemList.this.D_renamed);
            }
        }
    }
}
