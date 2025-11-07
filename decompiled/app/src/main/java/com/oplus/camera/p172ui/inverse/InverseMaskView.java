package com.oplus.camera.p172ui.inverse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class InverseMaskView extends View implements InverseAble {

    /* renamed from: A */
    private AnimatorSet f18700A;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PointF f18701a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathInterpolator f18702b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18703c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f18704d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18705e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18706f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f18707g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f18708h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f18709i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f18710j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f18711k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f18712l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f18713m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f18714n;

    /* renamed from: o */
    private float f18715o;

    /* renamed from: p */
    private float f18716p;

    /* renamed from: q */
    private float f18717q;

    /* renamed from: r */
    private boolean f18718r;

    /* renamed from: s */
    private InverseChangeModeData f18719s;

    /* renamed from: t */
    private boolean f18720t;

    /* renamed from: u */
    private ValueAnimator f18721u;

    /* renamed from: v */
    private ValueAnimator f18722v;

    /* renamed from: w */
    private ValueAnimator f18723w;

    /* renamed from: x */
    private ValueAnimator f18724x;

    /* renamed from: y */
    private ValueAnimator f18725y;

    /* renamed from: z */
    private ValueAnimator f18726z;

    public InverseMaskView(Context context) {
        super(context);
        this.f18701a = new PointF();
        this.f18702b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18703c = 0;
        this.f18704d = false;
        this.f18705e = 0;
        this.f18706f = 0;
        this.f18707g = false;
        this.f18708h = 0;
        this.f18709i = 0;
        this.f18710j = 0.0f;
        this.f18711k = 0;
        this.f18712l = 0;
        this.f18713m = null;
        this.f18714n = 1.0f;
        this.f18715o = 1.0f;
        this.f18716p = 0.5f;
        this.f18717q = 0.5f;
        this.f18718r = true;
        this.f18719s = null;
        this.f18720t = false;
        this.f18721u = null;
        this.f18722v = null;
        this.f18723w = null;
        this.f18724x = null;
        this.f18725y = null;
        this.f18726z = null;
        this.f18700A = null;
        m20125a(context);
    }

    public InverseMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18701a = new PointF();
        this.f18702b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18703c = 0;
        this.f18704d = false;
        this.f18705e = 0;
        this.f18706f = 0;
        this.f18707g = false;
        this.f18708h = 0;
        this.f18709i = 0;
        this.f18710j = 0.0f;
        this.f18711k = 0;
        this.f18712l = 0;
        this.f18713m = null;
        this.f18714n = 1.0f;
        this.f18715o = 1.0f;
        this.f18716p = 0.5f;
        this.f18717q = 0.5f;
        this.f18718r = true;
        this.f18719s = null;
        this.f18720t = false;
        this.f18721u = null;
        this.f18722v = null;
        this.f18723w = null;
        this.f18724x = null;
        this.f18725y = null;
        this.f18726z = null;
        this.f18700A = null;
        m20125a(context);
    }

    public InverseMaskView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18701a = new PointF();
        this.f18702b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f18703c = 0;
        this.f18704d = false;
        this.f18705e = 0;
        this.f18706f = 0;
        this.f18707g = false;
        this.f18708h = 0;
        this.f18709i = 0;
        this.f18710j = 0.0f;
        this.f18711k = 0;
        this.f18712l = 0;
        this.f18713m = null;
        this.f18714n = 1.0f;
        this.f18715o = 1.0f;
        this.f18716p = 0.5f;
        this.f18717q = 0.5f;
        this.f18718r = true;
        this.f18719s = null;
        this.f18720t = false;
        this.f18721u = null;
        this.f18722v = null;
        this.f18723w = null;
        this.f18724x = null;
        this.f18725y = null;
        this.f18726z = null;
        this.f18700A = null;
        m20125a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20125a(Context context) {
        this.f18713m = new Paint();
        this.f18713m.setAntiAlias(true);
        this.f18708h = context.getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius);
        this.f18711k = context.getResources().getDimensionPixelSize(R.dimen.inverse_mask_radius_split_screen);
        this.f18712l = context.getResources().getDimensionPixelSize(R.dimen.inverse_mask_offset_split_screen);
    }

    public void setRadius(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("InverseMaskView", "radius: " + OplusGLSurfaceView_13);
        ValueAnimator valueAnimator = this.f18724x;
        if (valueAnimator != null && valueAnimator.isRunning() && this.f18709i == OplusGLSurfaceView_13) {
            return;
        }
        if (3 == this.f18705e) {
            this.f18711k = OplusGLSurfaceView_13;
        } else {
            this.f18708h = OplusGLSurfaceView_13;
        }
        postInvalidate();
    }

    public void setSplitScreenYOffset(float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("InverseMaskView", "setSplitScreenYOffset: " + COUIBaseListPopupWindow_12);
        this.f18712l = (int) COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(final boolean z) {
        this.f18704d = z;
        post(new Runnable() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.1
            @Override // java.lang.Runnable
            public void run() {
                InverseMaskView.this.setVisibility(z ? 0 : 8);
                InverseMaskView.this.invalidate();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f18704d) {
            int OplusGLSurfaceView_13 = this.f18703c;
            if (OplusGLSurfaceView_13 == 0) {
                m20126a(canvas);
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                m20133b(canvas);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20126a(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13 = this.f18705e;
        if (OplusGLSurfaceView_13 == 1) {
            this.f18713m.setColor(InverseManager.INS.getInverseColor());
            this.f18713m.setBlendMode(BlendMode.SRC_OVER);
            this.f18713m.setAlpha((int) (this.f18715o * 204.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f18713m);
            this.f18713m.setColor(-1);
            this.f18713m.setBlendMode(BlendMode.DST_OUT);
            COUIBaseListPopupWindow_12 = this.f18708h * this.f18714n;
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, COUIBaseListPopupWindow_12, this.f18713m);
            this.f18701a.set(getWidth() / 2.0f, getHeight() / 2.0f);
        } else if (OplusGLSurfaceView_13 == 3) {
            this.f18713m.setColor(InverseManager.INS.getInverseColor());
            this.f18713m.setBlendMode(BlendMode.SRC_OVER);
            this.f18713m.setAlpha((int) (this.f18715o * 204.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth() / 2.0f, getHeight(), this.f18713m);
            this.f18713m.setColor(-1);
            this.f18713m.setBlendMode(BlendMode.DST_OUT);
            COUIBaseListPopupWindow_12 = this.f18711k * this.f18714n;
            canvas.drawCircle(getWidth() / 4.0f, this.f18712l, COUIBaseListPopupWindow_12, this.f18713m);
            this.f18701a.set(getWidth() / 4.0f, this.f18712l);
        } else if (OplusGLSurfaceView_13 == 4) {
            int screenWidth = Util.getScreenWidth();
            this.f18713m.setColor(InverseManager.INS.getInverseColor());
            this.f18713m.setBlendMode(BlendMode.SRC_OVER);
            this.f18713m.setAlpha(204);
            float f2 = screenWidth;
            canvas.drawRect(0.0f, 0.0f, f2, Util.m24186N(), this.f18713m);
            this.f18713m.setAlpha((int) (this.f18715o * 204.0f));
            canvas.drawRect(0.0f, Util.m24186N(), f2, Util.getScreenHeight() - Util.m24187O(), this.f18713m);
            this.f18713m.setColor(-1);
            this.f18713m.setBlendMode(BlendMode.DST_OUT);
            COUIBaseListPopupWindow_12 = this.f18711k * this.f18714n;
            if ((this.f18707g && 90 == this.f18706f) || (!this.f18707g && 270 == this.f18706f)) {
                canvas.drawCircle(getWidth() / 4.0f, getHeight() / 2, COUIBaseListPopupWindow_12, this.f18713m);
                this.f18701a.set(getWidth() / 4.0f, getHeight() / 2);
            } else {
                canvas.drawCircle((getWidth() * 3) / 4.0f, getHeight() / 2, COUIBaseListPopupWindow_12, this.f18713m);
                this.f18701a.set((getWidth() * 3) / 4.0f, getHeight() / 2);
            }
        } else {
            int screenWidth2 = Util.getScreenWidth();
            this.f18713m.setColor(InverseManager.INS.getInverseColor());
            this.f18713m.setBlendMode(BlendMode.SRC_OVER);
            this.f18713m.setAlpha(204);
            float f3 = screenWidth2;
            canvas.drawRect(0.0f, 0.0f, f3, Util.m24186N(), this.f18713m);
            this.f18713m.setAlpha((int) (this.f18715o * 204.0f));
            canvas.drawRect(0.0f, Util.m24186N(), f3, Util.getScreenHeight() - Util.m24187O(), this.f18713m);
            this.f18713m.setColor(-1);
            this.f18713m.setBlendMode(BlendMode.DST_OUT);
            float f4 = f3 / 2.0f;
            COUIBaseListPopupWindow_12 = this.f18714n * f4;
            float screenHeight = (((Util.getScreenHeight() - Util.m24187O()) - Util.m24186N()) - screenWidth2) * this.f18716p;
            canvas.drawCircle(f4, Util.m24186N() + f4 + screenHeight, COUIBaseListPopupWindow_12, this.f18713m);
            this.f18701a.set(f4, Util.m24186N() + f4 + screenHeight);
        }
        this.f18710j = COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20133b(Canvas canvas) {
        this.f18713m.setColor(InverseManager.INS.getInverseColor());
        this.f18713m.setBlendMode(BlendMode.SRC_OVER);
        this.f18713m.setAlpha((int) (this.f18715o * 204.0f));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f18713m);
        this.f18713m.setColor(-1);
        this.f18713m.setBlendMode(BlendMode.DST_OUT);
        canvas.drawCircle(this.f18701a.x, this.f18701a.y, this.f18708h, this.f18713m);
        this.f18710j = this.f18708h;
    }

    public void setMaskAlpha(float COUIBaseListPopupWindow_12) {
        if (this.f18718r) {
            this.f18715o = COUIBaseListPopupWindow_12;
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20144a(final boolean z, boolean z2) {
        this.f18718r = z;
        if (z2) {
            ValueAnimator valueAnimator = this.f18721u;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f18721u.cancel();
            }
            if (z) {
                this.f18721u = ValueAnimator.ofFloat(0.0f, 1.0f);
            } else {
                this.f18721u = ValueAnimator.ofFloat(1.0f, 0.0f);
            }
            this.f18721u.setDuration(200L);
            this.f18721u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$-cEh4skNqqMiotN0_t5_iatUqkY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.COUIBaseListPopupWindow_12$0.m20128a(z, valueAnimator2);
                }
            });
            this.f18721u.start();
            return;
        }
        this.f18715o = z ? 1.0f : 0.0f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20128a(boolean z, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if ((!z || fFloatValue <= this.f18715o) && (z || fFloatValue >= this.f18715o)) {
            return;
        }
        this.f18715o = fFloatValue;
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20141a() {
        final ValueAnimator[] valueAnimatorArr = {ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(83L), ValueAnimator.ofFloat(0.0f, 0.0f).setDuration(65L), ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(185L)};
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(getContext(), R.anim.inverse_interpolator);
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < valueAnimatorArr.length) {
            ValueAnimator valueAnimator = valueAnimatorArr[OplusGLSurfaceView_13];
            valueAnimator.setInterpolator(interpolatorLoadInterpolator);
            final int i2 = OplusGLSurfaceView_13 < valueAnimatorArr.length - 1 ? OplusGLSurfaceView_13 + 1 : -1;
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int i3 = i2;
                    if (i3 > 0) {
                        InverseMaskView.this.f18722v = valueAnimatorArr[i3];
                        InverseMaskView.this.f18722v.start();
                    }
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$uIQM2DV3u9uuMvkpPWWqOdKk_Is
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.COUIBaseListPopupWindow_12$0.m20139e(valueAnimator2);
                }
            });
            OplusGLSurfaceView_13++;
        }
        this.f18722v = valueAnimatorArr[0];
        this.f18722v.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m20139e(ValueAnimator valueAnimator) {
        this.f18714n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20142a(float COUIBaseListPopupWindow_12, boolean z) {
        if (this.f18717q != COUIBaseListPopupWindow_12) {
            this.f18717q = COUIBaseListPopupWindow_12;
            if (z) {
                ValueAnimator valueAnimator = this.f18723w;
                if (valueAnimator == null) {
                    this.f18723w = ValueAnimator.ofFloat(this.f18716p, COUIBaseListPopupWindow_12).setDuration(300L);
                    this.f18723w.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.inverse_interpolator));
                    this.f18723w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$HbRBvKGdN9wI1nTI9DRRaqzf2yc
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            this.COUIBaseListPopupWindow_12$0.m20138d(valueAnimator2);
                        }
                    });
                } else {
                    if (valueAnimator.isRunning()) {
                        this.f18723w.cancel();
                    }
                    this.f18723w.setFloatValues(this.f18716p, COUIBaseListPopupWindow_12);
                }
                this.f18723w.start();
                return;
            }
            this.f18716p = COUIBaseListPopupWindow_12;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m20138d(ValueAnimator valueAnimator) {
        this.f18716p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20143a(int OplusGLSurfaceView_13, boolean z, int i2) {
        if (this.f18720t) {
            return;
        }
        this.f18705e = OplusGLSurfaceView_13;
        this.f18707g = z;
        this.f18706f = i2;
        setStatus(0);
        invalidate();
    }

    public void setMaskToLayoutMode(InverseChangeModeData c3224b) {
        CameraLog.m12954a("InverseMaskView", "setMaskToLayoutMode, data: " + c3224b + ", mbInverseColor: " + this.f18704d);
        if (!this.f18704d) {
            m20143a(c3224b.f18738a, c3224b.f18744g, c3224b.f18739b);
        } else {
            m20127a(c3224b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20127a(InverseChangeModeData c3224b) {
        if (this.f18720t && this.f18700A != null) {
            if (c3224b.equals(this.f18719s)) {
                return;
            } else {
                this.f18700A.cancel();
            }
        }
        this.f18719s = c3224b;
        this.f18709i = c3224b.f18740c;
        this.f18720t = true;
        PointF pointFM20123a = m20123a(c3224b.f18738a, c3224b.f18744g, c3224b.f18739b, c3224b.f18741d);
        float COUIBaseListPopupWindow_12 = this.f18710j;
        float f2 = this.f18701a.x;
        float f3 = this.f18701a.y;
        setStatus(1);
        if (this.f18700A == null) {
            this.f18700A = new AnimatorSet();
            this.f18725y = ValueAnimator.ofFloat(f2, pointFM20123a.x).setDuration(c3224b.f18742e);
            this.f18725y.setInterpolator(this.f18702b);
            this.f18725y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$ARqhe98tkIETS_f5E8_2eRxV7Fk
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m20136c(valueAnimator);
                }
            });
            this.f18726z = ValueAnimator.ofFloat(f3, pointFM20123a.y).setDuration(c3224b.f18742e);
            this.f18726z.setInterpolator(this.f18702b);
            this.f18726z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$yPv0dS_8ViUbUBd4kzyP2-iUM3I
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m20132b(valueAnimator);
                }
            });
            this.f18724x = ValueAnimator.ofFloat(COUIBaseListPopupWindow_12, c3224b.f18740c).setDuration(c3224b.f18742e);
            this.f18724x.setInterpolator(this.f18702b);
            this.f18724x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$L2mf3eWdcOfMgSpi1jXxGgmKM-8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m20124a(valueAnimator);
                }
            });
            this.f18700A.play(this.f18725y).with(this.f18726z).with(this.f18724x);
            this.f18700A.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (InverseMaskView.this.f18719s != null) {
                        InverseMaskView inverseMaskView = InverseMaskView.this;
                        inverseMaskView.f18705e = inverseMaskView.f18719s.f18738a;
                        InverseMaskView inverseMaskView2 = InverseMaskView.this;
                        inverseMaskView2.f18707g = inverseMaskView2.f18719s.f18744g;
                        InverseMaskView inverseMaskView3 = InverseMaskView.this;
                        inverseMaskView3.f18706f = inverseMaskView3.f18719s.f18739b;
                        InverseMaskView inverseMaskView4 = InverseMaskView.this;
                        inverseMaskView4.f18711k = inverseMaskView4.f18719s.f18740c;
                        InverseMaskView inverseMaskView5 = InverseMaskView.this;
                        inverseMaskView5.f18708h = inverseMaskView5.f18719s.f18740c;
                    }
                    InverseMaskView.this.setStatus(0);
                    InverseMaskView.this.f18720t = false;
                }
            });
        } else {
            this.f18725y.setFloatValues(this.f18701a.x, pointFM20123a.x);
            this.f18726z.setFloatValues(this.f18701a.y, pointFM20123a.y);
            this.f18724x.setFloatValues(this.f18708h, c3224b.f18740c);
            this.f18725y.setDuration(c3224b.f18742e);
            this.f18726z.setDuration(c3224b.f18742e);
            this.f18724x.setDuration(c3224b.f18742e);
        }
        this.f18700A.setCurrentPlayTime(Math.min(SystemClock.uptimeMillis() - c3224b.f18743f, c3224b.f18742e));
        this.f18700A.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m20136c(ValueAnimator valueAnimator) {
        this.f18701a.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m20132b(ValueAnimator valueAnimator) {
        this.f18701a.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20124a(ValueAnimator valueAnimator) {
        int iRound = Math.round(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f18711k = iRound;
        this.f18708h = iRound;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("InverseMaskView", "setStatus, " + this.f18703c + " -> " + OplusGLSurfaceView_13);
        this.f18703c = OplusGLSurfaceView_13;
        postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PointF m20123a(int OplusGLSurfaceView_13, boolean z, int i2, float COUIBaseListPopupWindow_12) {
        if (OplusGLSurfaceView_13 == 1) {
            return new PointF(getWidth() / 2.0f, getHeight() / 2.0f);
        }
        if (OplusGLSurfaceView_13 == 3) {
            return new PointF(getWidth() / 4.0f, COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 != 4) {
            int screenWidth = Util.getScreenWidth();
            float screenHeight = (((Util.getScreenHeight() - Util.m24187O()) - Util.m24186N()) - screenWidth) * this.f18716p;
            float f2 = screenWidth / 2.0f;
            return new PointF(f2, Util.m24186N() + f2 + screenHeight);
        }
        if ((z && 90 == i2) || (!z && 270 == i2)) {
            return new PointF(getWidth() / 4.0f, getHeight() / 2);
        }
        return new PointF((getWidth() * 3) / 4.0f, getHeight() / 2);
    }

    public static float getPositionRatioSquare() {
        return (Util.m24184L() * 1.0f) / (((Util.getScreenHeight() - Util.m24187O()) - Util.m24186N()) - Util.getScreenWidth());
    }
}
