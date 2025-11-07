package com.oplus.camera.ui.menu.facebeauty;

/* compiled from: FaceBeautyBaseMenu.java */
/* loaded from: classes2.dex */
public abstract class d_renamed implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.widget.LinearLayout f6417a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected android.view.ViewGroup f6418b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.view.ViewGroup f6419c = null;
    protected android.view.ViewGroup d_renamed = null;
    protected int e_renamed = 0;
    protected int f_renamed = 0;
    protected int g_renamed = 150;
    protected boolean h_renamed = false;
    protected boolean i_renamed = false;
    protected boolean j_renamed = false;
    protected boolean k_renamed = true;
    protected boolean l_renamed = true;
    protected boolean m_renamed = false;
    protected com.oplus.camera.ui.preview.a_renamed.f_renamed n_renamed = null;
    protected com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed o_renamed = null;
    protected android.animation.Animator p_renamed = null;
    protected android.animation.Animator q_renamed = null;
    protected android.animation.Animator r_renamed = null;
    protected android.animation.Animator s_renamed = null;
    protected android.view.animation.PathInterpolator t_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    protected android.view.animation.PathInterpolator u_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    protected int v_renamed = 0;
    protected int w_renamed = 0;
    protected int x_renamed = 0;
    protected android.app.Activity y_renamed = null;

    /* compiled from: FaceBeautyBaseMenu.java */
    interface a_renamed {
        int a_renamed(int i_renamed, boolean z_renamed);

        void a_renamed(int i_renamed);

        void a_renamed(java.lang.String str, int i_renamed, boolean z_renamed);

        int[] a_renamed(boolean z_renamed);

        int b_renamed();

        void b_renamed(boolean z_renamed);

        boolean c_renamed();
    }

    public boolean a_renamed(int i_renamed) {
        return i_renamed == 1;
    }

    public boolean b_renamed(int i_renamed) {
        return i_renamed == 2;
    }

    public boolean c_renamed(int i_renamed) {
        return i_renamed == 3;
    }

    protected void e_renamed(boolean z_renamed) {
    }

    protected void f_renamed(boolean z_renamed) {
    }

    protected void g_renamed(boolean z_renamed) {
    }

    protected void h_renamed(boolean z_renamed) {
    }

    protected void i_renamed(boolean z_renamed) {
    }

    protected void j_renamed(boolean z_renamed) {
    }

    public boolean b_renamed() {
        android.animation.Animator animator;
        android.animation.Animator animator2;
        android.animation.Animator animator3;
        android.animation.Animator animator4;
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        return (fVar != null && fVar.b_renamed()) || ((animator = this.p_renamed) != null && animator.isStarted()) || (((animator2 = this.q_renamed) != null && animator2.isStarted()) || (((animator3 = this.r_renamed) != null && animator3.isStarted()) || ((animator4 = this.s_renamed) != null && animator4.isStarted())));
    }

    protected void c_renamed() {
        int i_renamed;
        int i2;
        android.view.ViewGroup viewGroup;
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "initTabLayout");
        this.f_renamed = 0;
        com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed aVar = this.o_renamed;
        if (aVar != null) {
            this.f_renamed = aVar.b_renamed();
        }
        this.f6417a.removeAllViews();
        if (this.h_renamed) {
            this.f6418b = a_renamed(com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_beauty, com.oplus.camera.R_renamed.string.camera_face_beauty_custom_tab_title_beauty, true, 0);
            viewGroup = this.f6418b;
            if (this.f_renamed == 0) {
                this.f_renamed = 1;
            }
            i_renamed = 1;
            i2 = 1;
        } else {
            if (this.f6418b != null) {
                this.f6418b = null;
            }
            if (1 == this.f_renamed) {
                this.f_renamed = 0;
            }
            i_renamed = 0;
            i2 = 0;
            viewGroup = null;
        }
        if (this.i_renamed) {
            int i3 = i_renamed + 1;
            this.f6419c = a_renamed(com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_makeup, com.oplus.camera.R_renamed.string.camera_face_beauty_custom_tab_title_makeup, viewGroup == null, i_renamed);
            if (viewGroup == null) {
                viewGroup = this.f6419c;
                i2 = 2;
            }
            if (this.f_renamed == 0) {
                this.f_renamed = 2;
            }
            i_renamed = i3;
        } else {
            if (this.f6419c != null) {
                this.f6419c = null;
            }
            if (2 == this.f_renamed) {
                this.f_renamed = 0;
            }
        }
        if (this.j_renamed) {
            this.d_renamed = a_renamed(com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_filter_effect, com.oplus.camera.R_renamed.string.camera_filter, viewGroup == null, i_renamed);
            if (viewGroup == null) {
                viewGroup = this.d_renamed;
                i2 = 3;
            }
            if (this.f_renamed == 0) {
                this.f_renamed = 3;
            }
        } else {
            if (this.d_renamed != null) {
                this.d_renamed = null;
            }
            if (3 == this.f_renamed) {
                this.f_renamed = 0;
            }
        }
        if (!this.l_renamed && this.d_renamed != null && this.f_renamed == 1) {
            this.f_renamed = 3;
        }
        boolean z_renamed = this.f6417a.getChildCount() > 1;
        a_renamed(z_renamed);
        int i4 = this.f_renamed;
        if (i4 == 1) {
            android.view.ViewGroup viewGroup2 = this.f6418b;
            if (viewGroup2 != null) {
                viewGroup2.getChildAt(0).setSelected(z_renamed);
                return;
            }
            return;
        }
        if (i4 == 2) {
            android.view.ViewGroup viewGroup3 = this.f6419c;
            if (viewGroup3 != null) {
                viewGroup3.getChildAt(0).setSelected(z_renamed);
                return;
            }
            return;
        }
        if (i4 != 3) {
            if (viewGroup != null) {
                viewGroup.getChildAt(0).setSelected(z_renamed);
                this.f_renamed = i2;
                return;
            }
            return;
        }
        android.view.ViewGroup viewGroup4 = this.d_renamed;
        if (viewGroup4 != null) {
            viewGroup4.getChildAt(0).setSelected(z_renamed);
        }
    }

    protected void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "cleanTabBackground, needBackground: " + z_renamed);
        if (z_renamed || this.f6417a == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.f6417a.getChildCount(); i_renamed++) {
            ((android.widget.FrameLayout) this.f6417a.getChildAt(i_renamed)).getChildAt(0).setBackgroundResource(0);
        }
    }

    protected void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "setTabFaceViewEnable, enable: " + z_renamed);
        this.l_renamed = z_renamed;
    }

    protected void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "disableFaceView, mbFaceBeautyEnable: " + this.l_renamed);
        if (this.f6418b != null) {
            if (k_renamed() && !this.l_renamed) {
                e_renamed();
            }
            if (this.l_renamed) {
                this.f6418b.setAlpha(1.0f);
            } else {
                this.f6418b.setAlpha(0.5f);
            }
        }
    }

    public void e_renamed() {
        android.widget.LinearLayout linearLayout;
        int childCount;
        if (this.d_renamed == null || m_renamed() || (linearLayout = this.f6417a) == null || (childCount = linearLayout.getChildCount()) == 1) {
            return;
        }
        j_renamed();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = ((android.widget.FrameLayout) this.f6417a.getChildAt(i_renamed)).getChildAt(0);
            childAt.setSelected(this.d_renamed.getChildAt(0).equals(childAt));
        }
    }

    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "showFilterTabRedDot");
        android.view.ViewGroup viewGroup = this.d_renamed;
        if (viewGroup != null) {
            ((com.coui.appcompat.widget.COUIHintRedDot) viewGroup.getChildAt(1)).setPointMode(1);
        }
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "hideFilterTabRedDot");
        android.view.ViewGroup viewGroup = this.d_renamed;
        if (viewGroup != null) {
            ((com.coui.appcompat.widget.COUIHintRedDot) viewGroup.getChildAt(1)).setPointMode(0);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.f_renamed fVar) {
        this.n_renamed = fVar;
    }

    protected android.view.ViewGroup a_renamed(int i_renamed, int i2, boolean z_renamed, int i3) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        android.widget.LinearLayout linearLayout = this.f6417a;
        if (linearLayout == null) {
            return null;
        }
        android.content.Context context = linearLayout.getContext();
        android.content.res.Resources resources = context.getResources();
        android.content.res.ColorStateList colorStateList = context.getColorStateList(com.oplus.camera.R_renamed.color.face_beauty_text_color);
        if (r_renamed() == 0) {
            dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_left_right_spacing);
            dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_margin_start);
        } else {
            dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_face_beauty_custom_tab_text_left_right_spacing);
            dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_face_beauty_custom_tab_text_margin_top);
        }
        float dimension = resources.getDimension(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_size);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_top_bottom_spacing);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_top_spacing);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_tab_text_height);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_custom_red_dot_diameter);
        com.oplus.camera.ui.menu.facebeauty.TabContainerTextView tabContainerTextView = new com.oplus.camera.ui.menu.facebeauty.TabContainerTextView(context);
        tabContainerTextView.setId(i_renamed);
        tabContainerTextView.setText(i2);
        tabContainerTextView.setTextColor(colorStateList);
        tabContainerTextView.setBackgroundResource(com.oplus.camera.R_renamed.drawable.face_beauty_custom_tab_text_bg);
        tabContainerTextView.setTextSize(0, dimension);
        tabContainerTextView.setGravity(17);
        tabContainerTextView.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        if (1 == this.w_renamed) {
            tabContainerTextView.setMaxLines(2);
        } else {
            tabContainerTextView.setSingleLine(true);
        }
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, tabContainerTextView);
        if (1 == this.w_renamed) {
            dimensionPixelOffset5 = -2;
        }
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, dimensionPixelOffset5);
        tabContainerTextView.setPadding(dimensionPixelOffset, dimensionPixelOffset4, dimensionPixelOffset, dimensionPixelOffset3);
        tabContainerTextView.setOnClickListener(this);
        if (!z_renamed) {
            if (r_renamed() == 0) {
                layoutParams.setMarginStart(dimensionPixelOffset2);
            } else {
                layoutParams.topMargin = dimensionPixelOffset2;
            }
        }
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
        frameLayout.addView(tabContainerTextView);
        com.coui.appcompat.widget.COUIHintRedDot cOUIHintRedDot = new com.coui.appcompat.widget.COUIHintRedDot(context);
        cOUIHintRedDot.setPointMode(0);
        cOUIHintRedDot.setDotDiameter(dimensionPixelOffset6);
        frameLayout.addView(cOUIHintRedDot, new android.widget.FrameLayout.LayoutParams(-2, -2, com.google.android.material.badge.BadgeDrawable.TOP_END));
        this.f6417a.addView(frameLayout, i3, layoutParams);
        return frameLayout;
    }

    protected void h_renamed() {
        if (k_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyBaseMenu", "tabBeautyClick");
        this.o_renamed.c_renamed();
        n_renamed();
        this.g_renamed = 200;
        e_renamed(true);
        this.o_renamed.a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_SMOOTH, 0, false);
        this.o_renamed.a_renamed(this.e_renamed);
    }

    protected void i_renamed() {
        if (l_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyBaseMenu", "tabMakeupClick");
        n_renamed();
        this.g_renamed = 200;
        h_renamed(true);
        this.o_renamed.a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_MAKEUP, 0, false);
        this.o_renamed.a_renamed(this.e_renamed);
    }

    protected void j_renamed() {
        if (m_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyBaseMenu", "tabFilterClick");
        n_renamed();
        this.g_renamed = 200;
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        if (fVar != null) {
            fVar.a_renamed(200);
        }
        k_renamed(true);
        this.o_renamed.a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER, 0, false);
        this.o_renamed.a_renamed(this.e_renamed);
    }

    protected android.animation.Animator a_renamed(final android.view.View view, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "showViews, view: " + view + ", needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z_renamed) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.t_renamed);
            objectAnimatorOfFloat.setDuration(350L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, o_renamed(), p_renamed(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.u_renamed);
            objectAnimatorOfFloat2.setDuration(350L);
            animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            animatorSet.setStartDelay(this.g_renamed);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.d_renamed.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
        view.setEnabled(true);
        return animatorSet;
    }

    protected android.animation.Animator b_renamed(final android.view.View view, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "hideViews, view: " + view + ", needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z_renamed) {
            view.setAlpha(1.0f);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.t_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f);
            objectAnimatorOfFloat2.setInterpolator(this.u_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            objectAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.d_renamed.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    view.postInvalidate();
                }
            });
            android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f);
            objectAnimatorOfFloat3.setInterpolator(this.u_renamed);
            objectAnimatorOfFloat3.setDuration(400L);
            animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.d_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    view.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    view.setVisibility(8);
                    view.setScaleY(1.0f);
                    view.setScaleX(1.0f);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(8);
            view.setScaleY(1.0f);
            view.setScaleX(1.0f);
        }
        a_renamed(view);
        view.setEnabled(false);
        return animatorSet;
    }

    protected android.animation.Animator c_renamed(final android.view.View view, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "hideViews, view: " + view + ", needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z_renamed) {
            view.setAlpha(1.0f);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, o_renamed(), 0.0f, p_renamed());
            objectAnimatorOfFloat.setInterpolator(this.u_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.t_renamed);
            objectAnimatorOfFloat2.setDuration(250L);
            animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.d_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.d_renamed.this.k_renamed = false;
                    view.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.d_renamed.this.k_renamed = true;
                    view.setVisibility(8);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(8);
        }
        a_renamed(view);
        view.setEnabled(false);
        return animatorSet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int childCount;
        android.widget.LinearLayout linearLayout = this.f6417a;
        if (linearLayout != null && (childCount = linearLayout.getChildCount()) != 1 && this.m_renamed && this.k_renamed) {
            switch (view.getId()) {
                case com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_beauty /* 2131296414 */:
                    if (this.l_renamed) {
                        h_renamed();
                        break;
                    } else {
                        return;
                    }
                case com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_filter_effect /* 2131296415 */:
                    j_renamed();
                    break;
                case com.oplus.camera.R_renamed.id_renamed.camera_face_beauty_custom_tab_title_makeup /* 2131296416 */:
                    i_renamed();
                    break;
            }
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = ((android.widget.FrameLayout) this.f6417a.getChildAt(i_renamed)).getChildAt(0);
                childAt.setSelected(view.equals(childAt));
            }
        }
    }

    public boolean k_renamed() {
        return a_renamed(this.e_renamed);
    }

    public boolean l_renamed() {
        boolean zB = b_renamed(this.e_renamed);
        com.oplus.camera.e_renamed.c_renamed("FaceBeautyBaseMenu", "isMakeupShown, " + zB);
        return zB;
    }

    public boolean m_renamed() {
        return c_renamed(this.e_renamed);
    }

    protected void n_renamed() {
        android.animation.Animator animator = this.p_renamed;
        if (animator != null && animator.isStarted()) {
            this.p_renamed.cancel();
        }
        android.animation.Animator animator2 = this.q_renamed;
        if (animator2 != null && animator2.isStarted()) {
            this.q_renamed.cancel();
        }
        android.animation.Animator animator3 = this.r_renamed;
        if (animator3 != null && animator3.isStarted()) {
            this.r_renamed.cancel();
        }
        android.animation.Animator animator4 = this.s_renamed;
        if (animator4 == null || !animator4.isStarted()) {
            return;
        }
        this.s_renamed.cancel();
    }

    protected void a_renamed(android.view.View view) {
        if ((view instanceof com.oplus.camera.ui.OplusNumSeekBar) && ((com.oplus.camera.ui.OplusNumSeekBar) view).c_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "moving seekBar dispatchTouchEvent cancel");
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            view.dispatchTouchEvent(android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
        }
    }

    public void c_renamed(boolean z_renamed) {
        this.m_renamed = true;
        n_renamed();
        this.g_renamed = 150;
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        if (fVar != null) {
            fVar.a_renamed(150);
        }
        int i_renamed = this.f_renamed;
        if (i_renamed == 1) {
            e_renamed(z_renamed);
        } else if (i_renamed == 2) {
            h_renamed(z_renamed);
        } else if (i_renamed == 3) {
            k_renamed(z_renamed);
        }
        android.view.ViewGroup viewGroup = this.f6418b;
        if (viewGroup != null) {
            if (this.l_renamed) {
                viewGroup.setAlpha(1.0f);
            } else {
                viewGroup.setAlpha(0.5f);
            }
        }
    }

    public void d_renamed(boolean z_renamed) {
        this.m_renamed = false;
        n_renamed();
        if (k_renamed()) {
            g_renamed(z_renamed);
        }
        if (l_renamed()) {
            j_renamed(z_renamed);
        }
        if (m_renamed()) {
            m_renamed(z_renamed);
        }
    }

    protected java.lang.String o_renamed() {
        return 1 == this.w_renamed ? "translationX" : "translationY";
    }

    protected int p_renamed() {
        if (1 == this.w_renamed && 270 != this.x_renamed) {
            return -this.v_renamed;
        }
        return this.v_renamed;
    }

    protected void k_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyBaseMenu", "showFilterEffect, needAnimation: " + z_renamed);
        if (l_renamed()) {
            i_renamed(z_renamed);
        }
        if (k_renamed()) {
            f_renamed(z_renamed);
        }
        this.e_renamed = 3;
        this.o_renamed.b_renamed(l_renamed());
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        if (fVar != null) {
            fVar.a_renamed(z_renamed);
        }
    }

    protected void l_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        if (fVar != null) {
            fVar.b_renamed(z_renamed);
        }
    }

    protected void m_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar = this.n_renamed;
        if (fVar != null) {
            fVar.c_renamed(z_renamed);
        }
    }

    public android.view.View q_renamed() {
        return this.f6417a;
    }

    protected int r_renamed() {
        return this.w_renamed != 1 ? 0 : 1;
    }

    public void n_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }
}
