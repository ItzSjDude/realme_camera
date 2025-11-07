package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;

/* loaded from: classes2.dex */
public class TabContainerTextView extends TextView implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PathInterpolator f19200a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArgbEvaluator f19201b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f19202c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f19203d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19204e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f19205f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Animator f19206g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Animator f19207h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ColorStateList f19208i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ColorStateList f19209j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f19210k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f19211l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int[] f19212m;

    /* renamed from: OplusGLSurfaceView_11 */
    private GradientDrawable f19213n;

    /* renamed from: o */
    private boolean f19214o;

    /* renamed from: p */
    private float f19215p;

    /* renamed from: q */
    private float f19216q;

    /* renamed from: r */
    private Interpolator f19217r;

    /* renamed from: s */
    private boolean f19218s;

    /* renamed from: t */
    private float f19219t;

    /* renamed from: u */
    private ValueAnimator f19220u;

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f19214o) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m20516a(true);
            } else if (action == 1 || action == 3) {
                m20516a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20516a(final boolean z) {
        this.f19218s = false;
        m20522b(z);
        if (this.f19218s) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f19215p;
        fArr[1] = z ? this.f19216q : 1.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 1.0f : this.f19219t;
        fArr2[1] = z ? 0.92f : 1.0f;
        this.f19220u = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f19220u.setInterpolator(this.f19217r);
        this.f19220u.setDuration(z ? 200L : 340L);
        this.f19220u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TabContainerTextView.this.f19219t = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (TabContainerTextView.this.f19218s && z && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    TabContainerTextView.this.m20516a(false);
                } else {
                    TabContainerTextView.this.f19215p = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    TabContainerTextView tabContainerTextView = TabContainerTextView.this;
                    tabContainerTextView.setScale(tabContainerTextView.f19219t);
                }
            }
        });
        this.f19220u.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20522b(boolean z) {
        ValueAnimator valueAnimator = this.f19220u;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f19218s = !z && ((float) this.f19220u.getCurrentPlayTime()) < ((float) this.f19220u.getDuration()) * 0.4f;
        if (this.f19218s) {
            return;
        }
        this.f19220u.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    public TabContainerTextView(Context context) {
        this(context, null);
    }

    public TabContainerTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabContainerTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19200a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19201b = new ArgbEvaluator();
        this.f19202c = false;
        this.f19203d = false;
        this.f19204e = 0;
        this.f19205f = false;
        this.f19206g = null;
        this.f19207h = null;
        this.f19208i = null;
        this.f19209j = null;
        this.f19210k = 0;
        this.f19211l = null;
        this.f19212m = null;
        this.f19213n = null;
        this.f19214o = true;
        m20514a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20514a(Context context) {
        this.f19208i = context.getColorStateList(R.color.face_beauty_text_color);
        this.f19209j = context.getColorStateList(R.color.face_beauty_tab_bg_color_list);
        setTextColor(this.f19208i);
        this.f19210k = R.drawable.face_beauty_custom_tab_text_bg;
        setBackgroundResource(this.f19210k);
        InverseManager.INS.registerInverse(context, this);
        this.f19215p = 1.0f;
        this.f19219t = 1.0f;
        if (this.f19214o) {
            this.f19216q = 0.8f;
        }
        this.f19217r = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 2);
        if (this.f19202c && m20517a()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        if (this.f19203d) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20517a() {
        if (this.f19205f) {
            return true;
        }
        int OplusGLSurfaceView_13 = this.f19204e;
        return (OplusGLSurfaceView_13 == 90 || OplusGLSurfaceView_13 == 270) ? false : true;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19202c = z;
        refreshDrawableState();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        boolean zIsSelected = isSelected();
        this.f19211l = getDrawableState();
        super.setSelected(z);
        this.f19212m = getDrawableState();
        if (zIsSelected != z) {
            Animator animator = this.f19206g;
            if (animator != null && animator.isRunning()) {
                this.f19206g.cancel();
            }
            Animator animator2 = this.f19207h;
            if (animator2 != null && animator2.isRunning()) {
                this.f19207h.cancel();
            }
            if (z) {
                this.f19206g = m20521b();
            } else {
                this.f19207h = m20521b();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Animator m20521b() {
        CameraLog.m12954a("TabContainerTextView", "executeShowAnimator.");
        int colorForState = this.f19208i.getColorForState(this.f19211l, 0);
        int colorForState2 = this.f19208i.getColorForState(this.f19212m, 0);
        int colorForState3 = this.f19209j.getColorForState(this.f19211l, 0);
        int colorForState4 = this.f19209j.getColorForState(this.f19212m, 0);
        StateListDrawable stateListDrawable = (StateListDrawable) getBackground();
        AnimatorSet animatorSet = new AnimatorSet();
        if (stateListDrawable != null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f19201b, Integer.valueOf(colorForState), Integer.valueOf(colorForState2));
            valueAnimatorOfObject.setInterpolator(this.f19200a);
            valueAnimatorOfObject.setDuration(200L);
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabContainerTextView.this.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.f19213n = (GradientDrawable) stateListDrawable.getCurrent();
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(this.f19201b, Integer.valueOf(colorForState3), Integer.valueOf(colorForState4));
            valueAnimatorOfObject2.setInterpolator(this.f19200a);
            valueAnimatorOfObject2.setDuration(200L);
            valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabContainerTextView.this.f19213n.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            animatorSet.play(valueAnimatorOfObject).with(valueAnimatorOfObject2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TabContainerTextView tabContainerTextView = TabContainerTextView.this;
                    tabContainerTextView.setTextColor(tabContainerTextView.f19208i);
                    TabContainerTextView.this.setBackground(null);
                    TabContainerTextView tabContainerTextView2 = TabContainerTextView.this;
                    tabContainerTextView2.setBackgroundResource(tabContainerTextView2.f19210k);
                    InverseManager.INS.registerInverse(TabContainerTextView.this.getContext(), TabContainerTextView.this);
                }
            });
            animatorSet.start();
        }
        return animatorSet;
    }

    public void setLightBgColor(boolean z) {
        CameraLog.m12954a("TabContainerTextView", "setBackgroundRes, isLight: " + z);
        if (z == this.f19203d) {
            return;
        }
        this.f19203d = z;
        refreshDrawableState();
        invalidate();
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f19204e = OplusGLSurfaceView_13;
        refreshDrawableState();
        invalidate();
    }

    public void setHorizontalInverseAble(boolean z) {
        this.f19205f = z;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Animator animator = this.f19206g;
        if (animator != null && animator.isRunning()) {
            this.f19206g.cancel();
        }
        Animator animator2 = this.f19207h;
        if (animator2 != null && animator2.isRunning()) {
            this.f19207h.cancel();
        }
        this.f19213n = null;
        super.onDetachedFromWindow();
    }
}
