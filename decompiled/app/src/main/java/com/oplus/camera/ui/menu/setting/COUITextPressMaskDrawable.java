package com.oplus.camera.ui.menu.setting;

/* compiled from: ExpandableMenuPanel.java */
/* loaded from: classes2.dex */
public class q_renamed extends android.view.View {
    public static final java.lang.String DEFALUT_MENU = "DefaultExpandPanel";
    public static final int EXPAND_MENU_HIDE = 0;
    public static final int EXPAND_MENU_SHOW = 1;
    private static final java.lang.String TAG = "ExpandableMenuPanel";
    public static java.lang.String mCurrentMenuKey = "DefaultExpandPanel";
    public com.oplus.camera.ui.menu.setting.q_renamed.b_renamed mExpandMenuListener;
    protected int mMenuTranslateY;
    public boolean mbEnterAnimationRunning;
    public boolean mbExitAnimationRunning;
    private boolean mbViewExpand;

    /* compiled from: ExpandableMenuPanel.java */
    public interface b_renamed {
        void a_renamed(java.lang.String str);

        void a_renamed(java.lang.String str, boolean z_renamed, boolean z2);
    }

    public void hideWithoutAnim(boolean z_renamed, boolean z2) {
    }

    public boolean openMenuCanDisableHighLight() {
        return false;
    }

    public void scrollToNext() {
    }

    public void scrollToPrevious() {
    }

    public q_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.mbViewExpand = false;
        this.mMenuTranslateY = 0;
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        this.mExpandMenuListener = null;
    }

    public q_renamed(android.app.Activity activity) {
        super(activity.getApplicationContext());
        this.mbViewExpand = false;
        this.mMenuTranslateY = 0;
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        this.mExpandMenuListener = null;
        this.mMenuTranslateY = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
    }

    public void showMenuPanel(java.lang.String str, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "showMenuPanel");
        this.mbViewExpand = true;
        setCurrentMenuKey(str);
        com.oplus.camera.ui.menu.setting.q_renamed.b_renamed bVar = this.mExpandMenuListener;
        if (bVar != null) {
            bVar.a_renamed(mCurrentMenuKey);
        }
    }

    public void hideMenuPanel(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "hideMenuPanel");
        this.mbViewExpand = false;
        com.oplus.camera.ui.menu.setting.q_renamed.b_renamed bVar = this.mExpandMenuListener;
        if (bVar != null) {
            bVar.a_renamed(mCurrentMenuKey, z_renamed, z2);
        }
        setCurrentMenuKey(DEFALUT_MENU);
    }

    public void setExpandMenuListener(com.oplus.camera.ui.menu.setting.q_renamed.b_renamed bVar) {
        this.mExpandMenuListener = bVar;
    }

    public int respondSingleTouchEventY() {
        return com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed();
    }

    public boolean onSingleTapUp(int i_renamed, int i2) {
        if (!this.mbViewExpand || i2 >= respondSingleTouchEventY() || isAnimationRunning()) {
            return false;
        }
        hideMenuPanel(true, false);
        return true;
    }

    public boolean onBackPressed() {
        if (!this.mbViewExpand || isAnimationRunning()) {
            return false;
        }
        hideMenuPanel(true, false);
        return true;
    }

    public boolean isAnimationRunning() {
        return this.mbEnterAnimationRunning || this.mbExitAnimationRunning;
    }

    public void setCurrentMenuKey(java.lang.String str) {
        mCurrentMenuKey = str;
    }

    public java.lang.String getCurrentMenuKey() {
        return mCurrentMenuKey;
    }

    public boolean isEffectMenuOpen() {
        return this.mbViewExpand || this.mbEnterAnimationRunning;
    }

    public boolean isEffectOpen() {
        return this.mbViewExpand || this.mbEnterAnimationRunning;
    }

    public void setExpandMenuAnimation(android.view.View view, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (z_renamed) {
            if (i_renamed == 0) {
                com.oplus.camera.util.Util.a_renamed(view, i_renamed, com.oplus.camera.R_renamed.anim.expand_menu_enter, true, true, (android.view.animation.Animation.AnimationListener) new com.oplus.camera.ui.menu.setting.q_renamed.a_renamed(view, i_renamed));
                return;
            } else {
                com.oplus.camera.util.Util.a_renamed(view, i_renamed, com.oplus.camera.R_renamed.anim.expand_menu_exit, true, true, (android.view.animation.Animation.AnimationListener) new com.oplus.camera.ui.menu.setting.q_renamed.a_renamed(view, i_renamed));
                return;
            }
        }
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i_renamed);
            this.mbEnterAnimationRunning = false;
            this.mbExitAnimationRunning = false;
        }
    }

    public void setExpandTextAnimation(android.view.View view, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (z_renamed) {
            if (i_renamed == 0) {
                com.oplus.camera.util.Util.a_renamed(view, i_renamed, com.oplus.camera.R_renamed.anim.expand_text_show, true, true, (android.view.animation.Animation.AnimationListener) new com.oplus.camera.ui.menu.setting.q_renamed.a_renamed(view, i_renamed));
                return;
            } else {
                com.oplus.camera.util.Util.a_renamed(view, i_renamed, com.oplus.camera.R_renamed.anim.expand_text_hide, true, true, (android.view.animation.Animation.AnimationListener) new com.oplus.camera.ui.menu.setting.q_renamed.a_renamed(view, i_renamed));
                return;
            }
        }
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i_renamed);
        }
    }

    /* compiled from: ExpandableMenuPanel.java */
    public class a_renamed implements android.view.animation.Animation.AnimationListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.view.View f6671b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f6672c;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        public a_renamed(android.view.View view, int i_renamed) {
            this.f6671b = null;
            this.f6672c = 4;
            this.f6671b = view;
            this.f6672c = i_renamed;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            int i_renamed = this.f6672c;
            if (i_renamed == 0) {
                this.f6671b.setVisibility(i_renamed);
                com.oplus.camera.ui.menu.setting.q_renamed.this.mbEnterAnimationRunning = true;
            } else {
                com.oplus.camera.ui.menu.setting.q_renamed.this.mbExitAnimationRunning = true;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            int i_renamed = this.f6672c;
            if (i_renamed != 0) {
                this.f6671b.setVisibility(i_renamed);
            }
            if (this.f6672c == 0) {
                com.oplus.camera.ui.menu.setting.q_renamed.this.mbEnterAnimationRunning = false;
            } else {
                com.oplus.camera.ui.menu.setting.q_renamed.this.mbExitAnimationRunning = false;
            }
        }
    }
}
