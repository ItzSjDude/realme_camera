package com.oplus.camera.ui.control;

/* loaded from: classes2.dex */
public class ShutterButton extends com.oplus.camera.ui.RotateImageView implements com.oplus.camera.ui.inverse.a_renamed, com.oplus.camera.ui.n_renamed {
    protected com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener m_renamed;
    protected boolean n_renamed;
    private java.lang.String o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private android.animation.ValueAnimator r_renamed;
    private android.view.animation.PathInterpolator s_renamed;
    private com.oplus.camera.ui.CameraUIListener t_renamed;
    private boolean u_renamed;
    private int v_renamed;

    public interface OnShutterButtonListener {
        boolean L_renamed();

        void a_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton);

        void a_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton, boolean z_renamed);

        void b_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton);

        void c_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton);

        void d_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton);

        void e_renamed(com.oplus.camera.ui.control.ShutterButton shutterButton);
    }

    public ShutterButton(android.content.Context context) {
        super(context);
        this.q_renamed = false;
        this.n_renamed = false;
        this.r_renamed = null;
        this.s_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.t_renamed = null;
        this.u_renamed = false;
        this.v_renamed = getVisibility();
        this.o_renamed = getClass().getSimpleName();
    }

    public ShutterButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q_renamed = false;
        this.n_renamed = false;
        this.r_renamed = null;
        this.s_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.t_renamed = null;
        this.u_renamed = false;
        this.v_renamed = getVisibility();
        this.o_renamed = getClass().getSimpleName();
    }

    public ShutterButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.q_renamed = false;
        this.n_renamed = false;
        this.r_renamed = null;
        this.s_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.t_renamed = null;
        this.u_renamed = false;
        this.v_renamed = getVisibility();
        this.o_renamed = getClass().getSimpleName();
    }

    public void setOnShutterButtonListener(com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener) {
        this.m_renamed = onShutterButtonListener;
    }

    public void setCameraUIListener(com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.t_renamed = cameraUIListener;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final boolean zIsPressed = isPressed();
        if (zIsPressed != this.p_renamed) {
            if (!zIsPressed) {
                post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.control.ShutterButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.control.ShutterButton.this.a_renamed(zIsPressed);
                    }
                });
            } else {
                a_renamed(zIsPressed);
            }
            this.p_renamed = zIsPressed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener = this.m_renamed;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.a_renamed(this, z_renamed);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener = this.m_renamed;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.a_renamed(this);
        }
        return zPerformClick;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.q_renamed = true;
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener = this.m_renamed;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.b_renamed(this);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener;
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener2;
        com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "onTouchEvent, isEnabled: " + isEnabled() + ", event.getAction: " + motionEvent.getAction() + ", getY: " + motionEvent.getY() + ", getRawY: " + motionEvent.getRawY());
        com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener3 = this.m_renamed;
        if (onShutterButtonListener3 != null && !onShutterButtonListener3.L_renamed()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a_renamed()) {
            com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "onTouchEvent, ignore the touch event when animating");
            return false;
        }
        if ((motionEvent.getAction() == 0 || 5 == motionEvent.getAction()) && !a_renamed(motionEvent)) {
            com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "onTouchEvent, not in_renamed the target area, so return!");
            return false;
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.q_renamed) {
            com.oplus.camera.ui.control.ShutterButton.OnShutterButtonListener onShutterButtonListener4 = this.m_renamed;
            if (onShutterButtonListener4 != null) {
                onShutterButtonListener4.c_renamed(this);
            }
            this.q_renamed = false;
        }
        if (motionEvent.getAction() == 0 && (onShutterButtonListener2 = this.m_renamed) != null) {
            onShutterButtonListener2.d_renamed(this);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (onShutterButtonListener = this.m_renamed) != null) {
            onShutterButtonListener.e_renamed(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_shutter_button_touch_offset);
        android.graphics.Rect rect = new android.graphics.Rect();
        getDrawingRect(rect);
        rect.inset(dimensionPixelSize, dimensionPixelSize);
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // com.oplus.camera.ui.RotateImageView, android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.oplus.camera.ui.RotateImageView, android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.n_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.ui.RotateImageView, com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.n_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    public void b_renamed(final boolean z_renamed, final boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "showShutterButtonVisibility, isBackgroundAlpha: " + z_renamed + ", isDrawableScale: " + z2);
        android.animation.ValueAnimator valueAnimator = this.r_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.r_renamed.cancel();
        }
        this.r_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.r_renamed.setDuration(500L);
        this.r_renamed.setInterpolator(this.s_renamed);
        this.r_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                float fFloatValue = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (z2) {
                    com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(fFloatValue);
                    com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(fFloatValue);
                }
                if (z_renamed) {
                    com.oplus.camera.ui.control.ShutterButton.this.setAlpha(fFloatValue);
                }
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        this.r_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.control.ShutterButton.3
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setVisibility(0);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setVisibility(0);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        setDrawableScale(1.0f);
        setDrawableAlpha(1.0f);
        setAlpha(1.0f);
        setVisibility(0);
        invalidate();
        this.r_renamed.start();
    }

    public void c_renamed(final boolean z_renamed, final boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "hideShutterButtonVisibility, isBackgroundAlpha: " + z_renamed + ", isDrawableScale: " + z2);
        android.animation.ValueAnimator valueAnimator = this.r_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.r_renamed.cancel();
        }
        if (this.u_renamed) {
            setVisibility(4);
            return;
        }
        this.r_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r_renamed.setDuration(500L);
        this.r_renamed.setInterpolator(this.s_renamed);
        this.r_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                float fFloatValue = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (z2) {
                    com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(fFloatValue);
                    com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(fFloatValue);
                }
                if (z_renamed) {
                    com.oplus.camera.ui.control.ShutterButton.this.setAlpha(fFloatValue);
                }
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        this.r_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.control.ShutterButton.5
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setVisibility(4);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setVisibility(4);
            }
        });
        this.r_renamed.start();
    }

    public void i_renamed() {
        android.animation.ValueAnimator valueAnimator = this.r_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.r_renamed.cancel();
    }

    private boolean a_renamed() {
        android.animation.ValueAnimator valueAnimator = this.r_renamed;
        if (valueAnimator == null) {
            return false;
        }
        return valueAnimator.isStarted();
    }

    public boolean j_renamed() {
        return this.u_renamed;
    }

    public void setForceHide(boolean z_renamed) {
        this.u_renamed = z_renamed;
        super.setVisibility(z_renamed ? 4 : this.v_renamed);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i_renamed) {
        this.v_renamed = i_renamed;
        if (this.u_renamed) {
            super.setVisibility(4);
        } else {
            super.setVisibility(i_renamed);
        }
    }

    public void setResIdWithAnimation(final int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(this.o_renamed, "videoPauseResumeWithAnimation");
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(this.s_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(fFloatValue);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(fFloatValue);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.control.ShutterButton.7
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setImageResource(i_renamed);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setImageResource(i_renamed);
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(250L);
        valueAnimatorOfFloat2.setInterpolator(this.s_renamed);
        valueAnimatorOfFloat2.setStartDelay(250L);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(fFloatValue);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(fFloatValue);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        animatorSet.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.control.ShutterButton.9
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setImageResource(i_renamed);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableScale(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setDrawableAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setAlpha(1.0f);
                com.oplus.camera.ui.control.ShutterButton.this.setImageResource(i_renamed);
                com.oplus.camera.ui.control.ShutterButton.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.start();
    }

    @Override // com.oplus.camera.ui.RotateImageView, com.oplus.camera.ui.n_renamed
    public void setLightBackground(boolean z_renamed) {
        if (z_renamed) {
            setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_foldproject_gray_bg);
        } else {
            setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
        }
    }
}
