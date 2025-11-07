package com.coui.appcompat.preference;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class ListSelectedItemLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private ValueAnimator f7036a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ValueAnimator f7037b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7038c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f7039d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f7040e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f7041f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7042g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Interpolator f7043h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Interpolator f7044i;

    public ListSelectedItemLayout(Context context) {
        this(context, null);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f7038c = true;
        this.f7039d = false;
        this.f7040e = true;
        this.f7042g = 2;
        this.f7043h = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        this.f7044i = new LinearInterpolator();
        m6941a(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && isClickable() && this.f7038c) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m6946b();
            } else if (action == 1 || action == 3) {
                m6945a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6945a() {
        if (this.f7036a.isRunning()) {
            this.f7039d = true;
        } else {
            if (this.f7037b.isRunning() || this.f7042g != 1) {
                return;
            }
            this.f7037b.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6946b() {
        if (this.f7037b.isRunning()) {
            this.f7037b.cancel();
        }
        if (this.f7036a.isRunning()) {
            this.f7036a.cancel();
        }
        this.f7036a.start();
    }

    public void setBackgroundAnimationEnabled(boolean z) {
        this.f7038c = z;
    }

    public void setBackgroundAnimationDrawable(Drawable drawable) {
        this.f7041f = drawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6941a(Context context) {
        if (this.f7041f == null) {
            this.f7041f = new ColorDrawable(context.getResources().getColor(R.color.coui_list_color_pressed));
        }
        int iAlpha = Color.alpha(context.getResources().getColor(R.color.coui_list_selector_color_pressed));
        this.f7036a = ValueAnimator.ofInt(0, iAlpha);
        this.f7036a.setDuration(150L);
        this.f7036a.setInterpolator(this.f7044i);
        this.f7036a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ListSelectedItemLayout.this.f7041f.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                ListSelectedItemLayout listSelectedItemLayout = ListSelectedItemLayout.this;
                listSelectedItemLayout.setBackground(listSelectedItemLayout.f7041f);
                ListSelectedItemLayout.this.invalidate();
            }
        });
        this.f7036a.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ListSelectedItemLayout.this.f7042g = 1;
                if (ListSelectedItemLayout.this.f7039d) {
                    ListSelectedItemLayout.this.f7039d = false;
                    ListSelectedItemLayout.this.f7037b.start();
                }
            }
        });
        this.f7037b = ValueAnimator.ofInt(iAlpha, 0);
        this.f7037b.setDuration(367L);
        this.f7037b.setInterpolator(this.f7043h);
        this.f7037b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ListSelectedItemLayout.this.f7041f.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                ListSelectedItemLayout listSelectedItemLayout = ListSelectedItemLayout.this;
                listSelectedItemLayout.setBackground(listSelectedItemLayout.f7041f);
                ListSelectedItemLayout.this.invalidate();
            }
        });
        this.f7037b.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ListSelectedItemLayout.this.f7042g = 2;
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6941a(getContext().createConfigurationContext(configuration));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!z && isEnabled()) {
            m6945a();
        }
        super.setEnabled(z);
    }
}
