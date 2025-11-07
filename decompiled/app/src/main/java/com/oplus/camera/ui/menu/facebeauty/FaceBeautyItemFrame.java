package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class FaceBeautyItemFrame extends android.widget.RelativeLayout implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6379a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6380b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6381c;
    private android.animation.ObjectAnimator d_renamed;
    private android.animation.ObjectAnimator e_renamed;

    public FaceBeautyItemFrame(android.content.Context context) {
        this(context, null);
    }

    public FaceBeautyItemFrame(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceBeautyItemFrame(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6379a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f6380b = false;
        this.f6381c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.f6380b) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.f6380b = z_renamed;
        refreshDrawableState();
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (z2) {
            setSelected(z_renamed);
            return;
        }
        super.setSelected(z_renamed);
        android.graphics.drawable.Drawable background = getBackground();
        if (background != null) {
            background.setAlpha(255);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z_renamed) {
        boolean z2 = this.f6381c;
        this.f6381c = z_renamed;
        if (z2 != z_renamed) {
            android.animation.ObjectAnimator objectAnimator = this.d_renamed;
            if (objectAnimator != null && objectAnimator.isStarted()) {
                this.d_renamed.cancel();
            }
            android.animation.ObjectAnimator objectAnimator2 = this.e_renamed;
            if (objectAnimator2 != null && objectAnimator2.isStarted()) {
                this.e_renamed.cancel();
            }
            if (z_renamed) {
                super.setSelected(true);
                a_renamed();
            } else {
                b_renamed();
            }
        }
    }

    private void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyItemFrame", "executeShowAnimator");
        android.graphics.drawable.Drawable background = getBackground();
        if (background != null) {
            this.d_renamed = android.animation.ObjectAnimator.ofInt(background, "alpha", 0, 255);
            this.d_renamed.setInterpolator(this.f6379a);
            this.d_renamed.setDuration(180L);
            this.d_renamed.start();
        }
    }

    private void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyItemFrame", "executeHideAnimator");
        android.graphics.drawable.Drawable background = getBackground();
        if (background != null) {
            this.e_renamed = android.animation.ObjectAnimator.ofInt(background, "alpha", 255, 0);
            this.e_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.FaceBeautyItemFrame.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.FaceBeautyItemFrame.super.setSelected(false);
                }
            });
            this.e_renamed.setInterpolator(this.f6379a);
            this.e_renamed.setDuration(180L);
            this.e_renamed.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(getContext(), this);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        android.animation.ObjectAnimator objectAnimator = this.d_renamed;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.d_renamed.cancel();
            this.d_renamed.removeAllListeners();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.e_renamed;
        if (objectAnimator2 != null && objectAnimator2.isStarted()) {
            this.e_renamed.cancel();
            this.e_renamed.removeAllListeners();
            this.e_renamed.removeAllUpdateListeners();
        }
        this.d_renamed = null;
        this.e_renamed = null;
        com.oplus.camera.ui.inverse.e_renamed.INS.unRegisterInverse(getContext(), this);
        super.onDetachedFromWindow();
    }
}
