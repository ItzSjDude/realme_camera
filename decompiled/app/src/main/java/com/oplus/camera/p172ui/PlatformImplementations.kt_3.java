package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.widget.SplitBackgroundView;

/* loaded from: classes2.dex */
public class OutScreenButtonBoxView extends RelativeLayout implements InverseAble, ILightBackgroundView {

    /* renamed from: PlatformImplementations.kt_3 */
    private SplitBackgroundView f17208a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SplitBackgroundView f17209b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private HighLightInverseTextView f17210c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Handler f17211d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ValueAnimator f17212e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f17213f;

    public OutScreenButtonBoxView(Context context) {
        super(context);
        this.f17208a = null;
        this.f17209b = null;
        this.f17210c = null;
        this.f17211d = null;
        this.f17212e = null;
        this.f17213f = false;
    }

    public OutScreenButtonBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17208a = null;
        this.f17209b = null;
        this.f17210c = null;
        this.f17211d = null;
        this.f17212e = null;
        this.f17213f = false;
    }

    public OutScreenButtonBoxView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17208a = null;
        this.f17209b = null;
        this.f17210c = null;
        this.f17211d = null;
        this.f17212e = null;
        this.f17213f = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f17208a = (SplitBackgroundView) findViewById(R.id_renamed.out_screen_preview_switch_image);
        this.f17209b = (SplitBackgroundView) findViewById(R.id_renamed.out_screen_preview_switch_bg);
        this.f17210c = (HighLightInverseTextView) findViewById(R.id_renamed.out_screen_preview_switch_tv);
        this.f17211d = new Handler();
    }

    public void setImageResource(int OplusGLSurfaceView_13) {
        this.f17208a.setImageResource(OplusGLSurfaceView_13);
    }

    public void setHighLight(boolean z) {
        this.f17208a.setHighLight(z);
        this.f17210c.setHighLight(z);
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f17208a.setInverseColor(z);
        this.f17210c.setInverseColor(z);
    }

    public SplitBackgroundView getBgView() {
        return this.f17209b;
    }

    @Override // com.oplus.camera.p172ui.ILightBackgroundView
    public void setLightBackground(boolean z) {
        this.f17209b.setLightBackground(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m18340b() {
        if (this.f17213f) {
            return false;
        }
        this.f17213f = true;
        this.f17210c.setVisibility(0);
        this.f17210c.setAlpha(0.0f);
        this.f17210c.requestLayout();
        this.f17211d.post(new Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$OutScreenButtonBoxView$IFX1LKrhS1JyHIwr86rx8hTUhZQ
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m18341c();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m18341c() {
        final int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        final int width = (getWidth() - getPaddingEnd()) - getPaddingStart();
        m18336a(height, width, 0, 1, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, new C3105a(new C3105a.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$OutScreenButtonBoxView$s3aHNYEElUZ6jhUPTwTg8eZ2Jpo
            @Override // com.oplus.camera.p172ui.OutScreenButtonBoxView.C3105a.PlatformImplementations.kt_3
            public final void call(Animator animator) {
                this.COUIBaseListPopupWindow_12$0.m18338a(width, height, animator);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18338a(int OplusGLSurfaceView_13, int i2, Animator animator) {
        m18336a(OplusGLSurfaceView_13, i2, 1, 0, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, new C3105a(new C3105a.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.-$$Lambda$OutScreenButtonBoxView$Mhq-sladbQT6Ynz0G3v59mov-3Y
            @Override // com.oplus.camera.p172ui.OutScreenButtonBoxView.C3105a.PlatformImplementations.kt_3
            public final void call(Animator animator2) {
                this.COUIBaseListPopupWindow_12$0.m18339a(animator2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18339a(Animator animator) {
        this.f17210c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.oplus.camera.ui.OutScreenButtonBoxView$PlatformImplementations.kt_3 */
    static class C3105a implements Animator.AnimatorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        private PlatformImplementations.kt_3 f17214a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f17215b = false;

        /* renamed from: com.oplus.camera.ui.OutScreenButtonBoxView$PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
        public interface PlatformImplementations.kt_3 {
            void call(Animator animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public C3105a(PlatformImplementations.kt_3 aVar) {
            this.f17214a = null;
            this.f17214a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f17215b) {
                return;
            }
            this.f17214a.call(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f17215b = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18336a(final int OplusGLSurfaceView_13, final int i2, final int i3, final int i4, long OplusGLSurfaceView_15, Animator.AnimatorListener animatorListener) {
        this.f17212e = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17212e.setDuration(400L);
        this.f17212e.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.out_preview_guide_interpolator));
        this.f17212e.setStartDelay(OplusGLSurfaceView_15);
        this.f17212e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.-$$Lambda$OutScreenButtonBoxView$7QfVFK_JGpcyDSaPLNsMoa1yyKU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m18337a(i3, i4, OplusGLSurfaceView_13, i2, valueAnimator);
            }
        });
        this.f17212e.addListener(animatorListener);
        this.f17212e.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18337a(int OplusGLSurfaceView_13, int i2, int i3, int i4, ValueAnimator valueAnimator) {
        this.f17210c.setAlpha(OplusGLSurfaceView_13 + ((i2 - OplusGLSurfaceView_13) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        this.f17209b.getLayoutParams().width = (int) (i3 + ((i4 - i3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        this.f17209b.requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18343a(ComboPreferences comboPreferences) {
        if (comboPreferences.getBoolean(CameraUIInterface.KEY_OUT_PREVIEW_GUIDE, true)) {
            return m18340b();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18342a() {
        ValueAnimator valueAnimator = this.f17212e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f17212e = null;
            this.f17210c.setAlpha(1.0f);
            this.f17210c.setVisibility(8);
            this.f17209b.getLayoutParams().width = this.f17209b.getLayoutParams().height;
            requestLayout();
        }
    }
}
