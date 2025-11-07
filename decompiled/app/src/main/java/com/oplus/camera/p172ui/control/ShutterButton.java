package com.oplus.camera.p172ui.control;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.ILightBackgroundView;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.inverse.InverseAble;

/* loaded from: classes2.dex */
public class ShutterButton extends RotateImageView implements InverseAble, ILightBackgroundView {

    /* renamed from: OplusGLSurfaceView_6 */
    protected OnShutterButtonListener f18080m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected boolean f18081n;

    /* renamed from: o */
    private String f18082o;

    /* renamed from: p */
    private boolean f18083p;

    /* renamed from: q */
    private boolean f18084q;

    /* renamed from: r */
    private ValueAnimator f18085r;

    /* renamed from: s */
    private PathInterpolator f18086s;

    /* renamed from: t */
    private CameraUIListener f18087t;

    /* renamed from: u */
    private boolean f18088u;

    /* renamed from: v */
    private int f18089v;

    public interface OnShutterButtonListener {
        /* renamed from: L */
        boolean mo18968L();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo18969a(ShutterButton shutterButton);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo18970a(ShutterButton shutterButton, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo18971b(ShutterButton shutterButton);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo18972c(ShutterButton shutterButton);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo18973d(ShutterButton shutterButton);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo18974e(ShutterButton shutterButton);
    }

    public ShutterButton(Context context) {
        super(context);
        this.f18084q = false;
        this.f18081n = false;
        this.f18085r = null;
        this.f18086s = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18087t = null;
        this.f18088u = false;
        this.f18089v = getVisibility();
        this.f18082o = getClass().getSimpleName();
    }

    public ShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18084q = false;
        this.f18081n = false;
        this.f18085r = null;
        this.f18086s = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18087t = null;
        this.f18088u = false;
        this.f18089v = getVisibility();
        this.f18082o = getClass().getSimpleName();
    }

    public ShutterButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18084q = false;
        this.f18081n = false;
        this.f18085r = null;
        this.f18086s = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18087t = null;
        this.f18088u = false;
        this.f18089v = getVisibility();
        this.f18082o = getClass().getSimpleName();
    }

    public void setOnShutterButtonListener(OnShutterButtonListener onShutterButtonListener) {
        this.f18080m = onShutterButtonListener;
    }

    public void setCameraUIListener(CameraUIListener cameraUIListener) {
        this.f18087t = cameraUIListener;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final boolean zIsPressed = isPressed();
        if (zIsPressed != this.f18083p) {
            if (!zIsPressed) {
                post(new Runnable() { // from class: com.oplus.camera.ui.control.ShutterButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShutterButton.this.m18961a(zIsPressed);
                    }
                });
            } else {
                m18961a(zIsPressed);
            }
            this.f18083p = zIsPressed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18961a(boolean z) {
        OnShutterButtonListener onShutterButtonListener = this.f18080m;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.mo18970a(this, z);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        OnShutterButtonListener onShutterButtonListener = this.f18080m;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.mo18969a(this);
        }
        return zPerformClick;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.f18084q = true;
        OnShutterButtonListener onShutterButtonListener = this.f18080m;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.mo18971b(this);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnShutterButtonListener onShutterButtonListener;
        OnShutterButtonListener onShutterButtonListener2;
        CameraLog.m12954a(this.f18082o, "onTouchEvent, isEnabled: " + isEnabled() + ", event.getAction: " + motionEvent.getAction() + ", getY: " + motionEvent.getY() + ", getRawY: " + motionEvent.getRawY());
        OnShutterButtonListener onShutterButtonListener3 = this.f18080m;
        if (onShutterButtonListener3 != null && !onShutterButtonListener3.mo18968L()) {
            return super.onTouchEvent(motionEvent);
        }
        if (m18962a()) {
            CameraLog.m12954a(this.f18082o, "onTouchEvent, ignore the touch event when animating");
            return false;
        }
        if ((motionEvent.getAction() == 0 || 5 == motionEvent.getAction()) && !m18963a(motionEvent)) {
            CameraLog.m12954a(this.f18082o, "onTouchEvent, not in the target area, so return!");
            return false;
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.f18084q) {
            OnShutterButtonListener onShutterButtonListener4 = this.f18080m;
            if (onShutterButtonListener4 != null) {
                onShutterButtonListener4.mo18972c(this);
            }
            this.f18084q = false;
        }
        if (motionEvent.getAction() == 0 && (onShutterButtonListener2 = this.f18080m) != null) {
            onShutterButtonListener2.mo18973d(this);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (onShutterButtonListener = this.f18080m) != null) {
            onShutterButtonListener.mo18974e(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m18963a(MotionEvent motionEvent) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.main_shutter_button_touch_offset);
        Rect rect = new Rect();
        getDrawingRect(rect);
        rect.inset(dimensionPixelSize, dimensionPixelSize);
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // com.oplus.camera.p172ui.RotateImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.oplus.camera.p172ui.RotateImageView, android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f18081n) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.p172ui.RotateImageView, com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f18081n = z;
        refreshDrawableState();
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18964b(final boolean z, final boolean z2) {
        CameraLog.m12954a(this.f18082o, "showShutterButtonVisibility, isBackgroundAlpha: " + z + ", isDrawableScale: " + z2);
        ValueAnimator valueAnimator = this.f18085r;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f18085r.cancel();
        }
        this.f18085r = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f18085r.setDuration(500L);
        this.f18085r.setInterpolator(this.f18086s);
        this.f18085r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (z2) {
                    ShutterButton.this.setDrawableScale(fFloatValue);
                    ShutterButton.this.setDrawableAlpha(fFloatValue);
                }
                if (z) {
                    ShutterButton.this.setAlpha(fFloatValue);
                }
                ShutterButton.this.invalidate();
            }
        });
        this.f18085r.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.control.ShutterButton.3
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setVisibility(0);
                ShutterButton.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setVisibility(0);
                ShutterButton.this.invalidate();
            }
        });
        setDrawableScale(1.0f);
        setDrawableAlpha(1.0f);
        setAlpha(1.0f);
        setVisibility(0);
        invalidate();
        this.f18085r.start();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18965c(final boolean z, final boolean z2) {
        CameraLog.m12954a(this.f18082o, "hideShutterButtonVisibility, isBackgroundAlpha: " + z + ", isDrawableScale: " + z2);
        ValueAnimator valueAnimator = this.f18085r;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f18085r.cancel();
        }
        if (this.f18088u) {
            setVisibility(4);
            return;
        }
        this.f18085r = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f18085r.setDuration(500L);
        this.f18085r.setInterpolator(this.f18086s);
        this.f18085r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (z2) {
                    ShutterButton.this.setDrawableScale(fFloatValue);
                    ShutterButton.this.setDrawableAlpha(fFloatValue);
                }
                if (z) {
                    ShutterButton.this.setAlpha(fFloatValue);
                }
                ShutterButton.this.invalidate();
            }
        });
        this.f18085r.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.control.ShutterButton.5
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setVisibility(4);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setVisibility(4);
            }
        });
        this.f18085r.start();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m18966i() {
        ValueAnimator valueAnimator = this.f18085r;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f18085r.cancel();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m18962a() {
        ValueAnimator valueAnimator = this.f18085r;
        if (valueAnimator == null) {
            return false;
        }
        return valueAnimator.isStarted();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m18967j() {
        return this.f18088u;
    }

    public void setForceHide(boolean z) {
        this.f18088u = z;
        super.setVisibility(z ? 4 : this.f18089v);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        this.f18089v = OplusGLSurfaceView_13;
        if (this.f18088u) {
            super.setVisibility(4);
        } else {
            super.setVisibility(OplusGLSurfaceView_13);
        }
    }

    public void setResIdWithAnimation(final int OplusGLSurfaceView_13) {
        CameraLog.m12954a(this.f18082o, "videoPauseResumeWithAnimation");
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(this.f18086s);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShutterButton.this.setDrawableScale(fFloatValue);
                ShutterButton.this.setDrawableAlpha(fFloatValue);
                ShutterButton.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.control.ShutterButton.7
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ShutterButton.this.setImageResource(OplusGLSurfaceView_13);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ShutterButton.this.setImageResource(OplusGLSurfaceView_13);
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(250L);
        valueAnimatorOfFloat2.setInterpolator(this.f18086s);
        valueAnimatorOfFloat2.setStartDelay(250L);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ShutterButton.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShutterButton.this.setDrawableScale(fFloatValue);
                ShutterButton.this.setDrawableAlpha(fFloatValue);
                ShutterButton.this.invalidate();
            }
        });
        animatorSet.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.control.ShutterButton.9
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setImageResource(OplusGLSurfaceView_13);
                ShutterButton.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ShutterButton.this.setDrawableScale(1.0f);
                ShutterButton.this.setDrawableAlpha(1.0f);
                ShutterButton.this.setAlpha(1.0f);
                ShutterButton.this.setImageResource(OplusGLSurfaceView_13);
                ShutterButton.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.start();
    }

    @Override // com.oplus.camera.p172ui.RotateImageView, com.oplus.camera.p172ui.ILightBackgroundView
    public void setLightBackground(boolean z) {
        if (z) {
            setBackgroundResource(R.drawable.switch_camera_button_foldproject_gray_bg);
        } else {
            setBackgroundResource(R.drawable.switch_camera_button_bg);
        }
    }
}
