package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Checkable;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class SwitchButton extends View implements Checkable {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f17286a = m18362b(58.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int f17287b = m18362b(36.0f);

    /* renamed from: A */
    private Bitmap f17288A;

    /* renamed from: B */
    private C3113b f17289B;

    /* renamed from: C */
    private C3113b f17290C;

    /* renamed from: D */
    private C3113b f17291D;

    /* renamed from: E */
    private int f17292E;

    /* renamed from: F */
    private ValueAnimator f17293F;

    /* renamed from: G */
    private final ArgbEvaluator f17294G;

    /* renamed from: H */
    private InterfaceC3112a f17295H;

    /* renamed from: I */
    private InterfaceC3114c f17296I;

    /* renamed from: J */
    private ValueAnimator.AnimatorUpdateListener f17297J;

    /* renamed from: K */
    private Animator.AnimatorListener f17298K;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f17299c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f17300d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f17301e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f17302f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f17303g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f17304h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f17305i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f17306j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f17307k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f17308l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f17309m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f17310n;

    /* renamed from: o */
    private int f17311o;

    /* renamed from: p */
    private int f17312p;

    /* renamed from: q */
    private float f17313q;

    /* renamed from: r */
    private float f17314r;

    /* renamed from: s */
    private boolean f17315s;

    /* renamed from: t */
    private boolean f17316t;

    /* renamed from: u */
    private boolean f17317u;

    /* renamed from: v */
    private boolean f17318v;

    /* renamed from: w */
    private Paint f17319w;

    /* renamed from: x */
    private Paint f17320x;

    /* renamed from: y */
    private Bitmap f17321y;

    /* renamed from: z */
    private Bitmap f17322z;

    /* renamed from: com.oplus.camera.ui.SwitchButton$PlatformImplementations.kt_3 */
    public interface InterfaceC3112a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15921a(SwitchButton switchButton, boolean z);
    }

    /* renamed from: com.oplus.camera.ui.SwitchButton$IntrinsicsJvm.kt_3 */
    public interface InterfaceC3114c {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo15920a();
    }

    public SwitchButton(Context context) {
        super(context);
        this.f17299c = 0.0f;
        this.f17300d = 0.0f;
        this.f17301e = 0.0f;
        this.f17302f = 0.0f;
        this.f17303g = 0.0f;
        this.f17304h = 0.0f;
        this.f17305i = 0.0f;
        this.f17306j = 0.0f;
        this.f17307k = 0.0f;
        this.f17308l = 0;
        this.f17309m = 0;
        this.f17310n = 0;
        this.f17311o = 0;
        this.f17312p = 0;
        this.f17313q = 0.0f;
        this.f17314r = 0.0f;
        this.f17315s = false;
        this.f17316t = false;
        this.f17317u = false;
        this.f17318v = false;
        this.f17319w = null;
        this.f17320x = null;
        this.f17321y = null;
        this.f17322z = null;
        this.f17288A = null;
        this.f17289B = null;
        this.f17290C = null;
        this.f17291D = null;
        this.f17292E = 0;
        this.f17293F = null;
        this.f17294G = new ArgbEvaluator();
        this.f17295H = null;
        this.f17296I = null;
        this.f17297J = new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int OplusGLSurfaceView_13 = SwitchButton.this.f17292E;
                if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 == 1) {
                    SwitchButton.this.f17289B.f17325a = SwitchButton.this.f17290C.f17325a + ((SwitchButton.this.f17291D.f17325a - SwitchButton.this.f17290C.f17325a) * fFloatValue);
                    float COUIBaseListPopupWindow_12 = (SwitchButton.this.f17289B.f17325a - SwitchButton.this.f17313q) / (SwitchButton.this.f17314r - SwitchButton.this.f17313q);
                    SwitchButton.this.f17289B.f17327c = ((Integer) SwitchButton.this.f17294G.evaluate(COUIBaseListPopupWindow_12, Integer.valueOf(SwitchButton.this.f17309m), Integer.valueOf(SwitchButton.this.f17310n))).intValue();
                }
                SwitchButton.this.postInvalidate();
            }
        };
        this.f17298K = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.SwitchButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchButton.this.f17315s = !r2.f17315s;
                SwitchButton.this.m18367c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int OplusGLSurfaceView_13 = SwitchButton.this.f17292E;
                if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 != 1) {
                    return;
                }
                SwitchButton.this.f17292E = 0;
                SwitchButton.this.postInvalidate();
            }
        };
        m18360a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17299c = 0.0f;
        this.f17300d = 0.0f;
        this.f17301e = 0.0f;
        this.f17302f = 0.0f;
        this.f17303g = 0.0f;
        this.f17304h = 0.0f;
        this.f17305i = 0.0f;
        this.f17306j = 0.0f;
        this.f17307k = 0.0f;
        this.f17308l = 0;
        this.f17309m = 0;
        this.f17310n = 0;
        this.f17311o = 0;
        this.f17312p = 0;
        this.f17313q = 0.0f;
        this.f17314r = 0.0f;
        this.f17315s = false;
        this.f17316t = false;
        this.f17317u = false;
        this.f17318v = false;
        this.f17319w = null;
        this.f17320x = null;
        this.f17321y = null;
        this.f17322z = null;
        this.f17288A = null;
        this.f17289B = null;
        this.f17290C = null;
        this.f17291D = null;
        this.f17292E = 0;
        this.f17293F = null;
        this.f17294G = new ArgbEvaluator();
        this.f17295H = null;
        this.f17296I = null;
        this.f17297J = new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int OplusGLSurfaceView_13 = SwitchButton.this.f17292E;
                if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 == 1) {
                    SwitchButton.this.f17289B.f17325a = SwitchButton.this.f17290C.f17325a + ((SwitchButton.this.f17291D.f17325a - SwitchButton.this.f17290C.f17325a) * fFloatValue);
                    float COUIBaseListPopupWindow_12 = (SwitchButton.this.f17289B.f17325a - SwitchButton.this.f17313q) / (SwitchButton.this.f17314r - SwitchButton.this.f17313q);
                    SwitchButton.this.f17289B.f17327c = ((Integer) SwitchButton.this.f17294G.evaluate(COUIBaseListPopupWindow_12, Integer.valueOf(SwitchButton.this.f17309m), Integer.valueOf(SwitchButton.this.f17310n))).intValue();
                }
                SwitchButton.this.postInvalidate();
            }
        };
        this.f17298K = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.SwitchButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchButton.this.f17315s = !r2.f17315s;
                SwitchButton.this.m18367c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int OplusGLSurfaceView_13 = SwitchButton.this.f17292E;
                if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 != 1) {
                    return;
                }
                SwitchButton.this.f17292E = 0;
                SwitchButton.this.postInvalidate();
            }
        };
        m18360a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17299c = 0.0f;
        this.f17300d = 0.0f;
        this.f17301e = 0.0f;
        this.f17302f = 0.0f;
        this.f17303g = 0.0f;
        this.f17304h = 0.0f;
        this.f17305i = 0.0f;
        this.f17306j = 0.0f;
        this.f17307k = 0.0f;
        this.f17308l = 0;
        this.f17309m = 0;
        this.f17310n = 0;
        this.f17311o = 0;
        this.f17312p = 0;
        this.f17313q = 0.0f;
        this.f17314r = 0.0f;
        this.f17315s = false;
        this.f17316t = false;
        this.f17317u = false;
        this.f17318v = false;
        this.f17319w = null;
        this.f17320x = null;
        this.f17321y = null;
        this.f17322z = null;
        this.f17288A = null;
        this.f17289B = null;
        this.f17290C = null;
        this.f17291D = null;
        this.f17292E = 0;
        this.f17293F = null;
        this.f17294G = new ArgbEvaluator();
        this.f17295H = null;
        this.f17296I = null;
        this.f17297J = new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = SwitchButton.this.f17292E;
                if (i2 != 0 && i2 == 1) {
                    SwitchButton.this.f17289B.f17325a = SwitchButton.this.f17290C.f17325a + ((SwitchButton.this.f17291D.f17325a - SwitchButton.this.f17290C.f17325a) * fFloatValue);
                    float COUIBaseListPopupWindow_12 = (SwitchButton.this.f17289B.f17325a - SwitchButton.this.f17313q) / (SwitchButton.this.f17314r - SwitchButton.this.f17313q);
                    SwitchButton.this.f17289B.f17327c = ((Integer) SwitchButton.this.f17294G.evaluate(COUIBaseListPopupWindow_12, Integer.valueOf(SwitchButton.this.f17309m), Integer.valueOf(SwitchButton.this.f17310n))).intValue();
                }
                SwitchButton.this.postInvalidate();
            }
        };
        this.f17298K = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.SwitchButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchButton.this.f17315s = !r2.f17315s;
                SwitchButton.this.m18367c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i2 = SwitchButton.this.f17292E;
                if (i2 == 0 || i2 != 1) {
                    return;
                }
                SwitchButton.this.f17292E = 0;
                SwitchButton.this.postInvalidate();
            }
        };
        m18360a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f17299c = 0.0f;
        this.f17300d = 0.0f;
        this.f17301e = 0.0f;
        this.f17302f = 0.0f;
        this.f17303g = 0.0f;
        this.f17304h = 0.0f;
        this.f17305i = 0.0f;
        this.f17306j = 0.0f;
        this.f17307k = 0.0f;
        this.f17308l = 0;
        this.f17309m = 0;
        this.f17310n = 0;
        this.f17311o = 0;
        this.f17312p = 0;
        this.f17313q = 0.0f;
        this.f17314r = 0.0f;
        this.f17315s = false;
        this.f17316t = false;
        this.f17317u = false;
        this.f17318v = false;
        this.f17319w = null;
        this.f17320x = null;
        this.f17321y = null;
        this.f17322z = null;
        this.f17288A = null;
        this.f17289B = null;
        this.f17290C = null;
        this.f17291D = null;
        this.f17292E = 0;
        this.f17293F = null;
        this.f17294G = new ArgbEvaluator();
        this.f17295H = null;
        this.f17296I = null;
        this.f17297J = new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.SwitchButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i22 = SwitchButton.this.f17292E;
                if (i22 != 0 && i22 == 1) {
                    SwitchButton.this.f17289B.f17325a = SwitchButton.this.f17290C.f17325a + ((SwitchButton.this.f17291D.f17325a - SwitchButton.this.f17290C.f17325a) * fFloatValue);
                    float COUIBaseListPopupWindow_12 = (SwitchButton.this.f17289B.f17325a - SwitchButton.this.f17313q) / (SwitchButton.this.f17314r - SwitchButton.this.f17313q);
                    SwitchButton.this.f17289B.f17327c = ((Integer) SwitchButton.this.f17294G.evaluate(COUIBaseListPopupWindow_12, Integer.valueOf(SwitchButton.this.f17309m), Integer.valueOf(SwitchButton.this.f17310n))).intValue();
                }
                SwitchButton.this.postInvalidate();
            }
        };
        this.f17298K = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.SwitchButton.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SwitchButton.this.f17315s = !r2.f17315s;
                SwitchButton.this.m18367c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i22 = SwitchButton.this.f17292E;
                if (i22 == 0 || i22 != 1) {
                    return;
                }
                SwitchButton.this.f17292E = 0;
                SwitchButton.this.postInvalidate();
            }
        };
        m18360a(context, attributeSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18360a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        this.f17309m = typedArrayObtainStyledAttributes.getColor(16, context.getColor(R.color.super_eis_switch_thumb_unchecked_color));
        this.f17310n = typedArrayObtainStyledAttributes.getColor(5, Util.m24164A(context));
        this.f17308l = typedArrayObtainStyledAttributes.getColor(1, context.getColor(R.color.super_eis_switch_border_color));
        this.f17311o = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, getResources().getDimensionPixelSize(R.dimen.super_eis_switch_border_width));
        this.f17312p = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, getResources().getDimensionPixelSize(R.dimen.super_eis_switch_thumb_padding));
        this.f17315s = typedArrayObtainStyledAttributes.getBoolean(4, false);
        this.f17316t = typedArrayObtainStyledAttributes.getBoolean(8, true);
        typedArrayObtainStyledAttributes.recycle();
        m18364b();
        this.f17289B = new C3113b();
        this.f17290C = new C3113b();
        this.f17291D = new C3113b();
        this.f17321y = BitmapFactory.decodeResource(getResources(), R.drawable.switch_button_bg);
        CameraLog.m12959b("SwitchButton", "init, mBgBitmap, w: " + this.f17321y.getWidth() + ", COUIBaseListPopupWindow_10: " + this.f17321y.getHeight() + ", density: " + this.f17321y.getDensity());
        this.f17322z = Util.m24216a(getContext(), R.drawable.switch_button_pro);
        this.f17288A = Util.m24216a(getContext(), R.drawable.switch_button_eis);
        this.f17293F = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17293F.setDuration(300L);
        this.f17293F.setRepeatCount(0);
        this.f17293F.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
        this.f17293F.addUpdateListener(this.f17297J);
        this.f17293F.addListener(this.f17298K);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18364b() {
        this.f17320x = new Paint(1);
        this.f17320x.setStrokeWidth(this.f17311o);
        this.f17320x.setStyle(Paint.Style.STROKE);
        this.f17320x.setColor(this.f17308l);
        this.f17319w = new Paint(1);
        this.f17319w.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(f17286a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f17287b, 1073741824);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        int i5 = this.f17311o;
        float COUIBaseListPopupWindow_12 = i5;
        float f2 = i2 - COUIBaseListPopupWindow_12;
        this.f17301e = f2 - COUIBaseListPopupWindow_12;
        float f3 = OplusGLSurfaceView_13 - COUIBaseListPopupWindow_12;
        this.f17302f = f3 - COUIBaseListPopupWindow_12;
        this.f17299c = this.f17301e / 2.0f;
        float f4 = this.f17299c;
        this.f17300d = (f4 - i5) - this.f17312p;
        this.f17303g = COUIBaseListPopupWindow_12;
        this.f17304h = COUIBaseListPopupWindow_12;
        this.f17305i = f3;
        this.f17306j = f2;
        this.f17307k = (this.f17304h + this.f17306j) / 2.0f;
        this.f17313q = this.f17303g + f4;
        this.f17314r = this.f17305i - f4;
        if (isChecked()) {
            setCheckedViewState(this.f17289B);
        } else {
            setUncheckViewState(this.f17289B);
        }
        this.f17317u = true;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float COUIBaseListPopupWindow_12 = this.f17303g;
        float f2 = this.f17304h;
        float f3 = this.f17305i;
        float f4 = this.f17306j;
        float f5 = this.f17299c;
        canvas.drawRoundRect(COUIBaseListPopupWindow_12, f2, f3, f4, f5, f5, this.f17320x);
        int width = (this.f17321y.getWidth() - this.f17288A.getWidth()) - this.f17322z.getWidth();
        int height = (this.f17321y.getHeight() - this.f17288A.getHeight()) / 2;
        Bitmap bitmap = this.f17321y;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), this.f17321y.getHeight()), (Paint) null);
        if (this.f17291D.f17328d) {
            canvas.drawBitmap(this.f17288A, width / 3, height, (Paint) null);
        } else {
            canvas.drawBitmap(this.f17288A, ((width / 3) * 2) + r2.getWidth(), height, (Paint) null);
        }
        this.f17319w.setColor(this.f17289B.f17327c);
        canvas.drawCircle(this.f17289B.f17325a, this.f17307k, this.f17300d, this.f17319w);
        canvas.drawBitmap(this.f17322z, this.f17289B.f17325a - (this.f17322z.getWidth() / 2), this.f17307k - (this.f17322z.getHeight() / 2.0f), (Paint) null);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (!this.f17296I.mo15920a() || m18379a()) {
            return false;
        }
        toggle();
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        m18378a(z, true);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f17315s;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        m18377a(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18377a(boolean z) {
        m18365b(z, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18365b(boolean z, boolean z2) {
        if (isEnabled()) {
            if (this.f17318v) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            }
            if (!this.f17317u) {
                this.f17315s = !this.f17315s;
                if (z2) {
                    m18367c();
                    return;
                }
                return;
            }
            if (this.f17293F.isRunning()) {
                this.f17293F.cancel();
            }
            if (!this.f17316t || !z) {
                this.f17315s = !this.f17315s;
                if (isChecked()) {
                    setCheckedViewState(this.f17289B);
                } else {
                    setUncheckViewState(this.f17289B);
                }
                postInvalidate();
                if (z2) {
                    m18367c();
                    return;
                }
                return;
            }
            this.f17292E = 1;
            this.f17290C.m18380a(this.f17289B);
            if (isChecked()) {
                setUncheckViewState(this.f17291D);
            } else {
                setCheckedViewState(this.f17291D);
            }
            this.f17293F.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18367c() {
        InterfaceC3112a interfaceC3112a = this.f17295H;
        if (interfaceC3112a != null) {
            this.f17318v = true;
            interfaceC3112a.mo15921a(this, isChecked());
        }
        this.f17318v = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18378a(boolean z, boolean z2) {
        if (z == isChecked()) {
            postInvalidate();
            return;
        }
        m18365b(z2, false);
        if (z) {
            setCheckedViewState(this.f17291D);
        } else {
            setUncheckViewState(this.f17291D);
        }
        postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18379a() {
        return this.f17292E != 0;
    }

    public void setOnCheckedChangeListener(InterfaceC3112a interfaceC3112a) {
        this.f17295H = interfaceC3112a;
    }

    public void setSwitchClickableListener(InterfaceC3114c interfaceC3114c) {
        this.f17296I = interfaceC3114c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18376a(Bitmap bitmap, Bitmap bitmap2) {
        this.f17322z = bitmap;
        this.f17288A = bitmap2;
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m18357a(float COUIBaseListPopupWindow_12) {
        return TypedValue.applyDimension(1, COUIBaseListPopupWindow_12, Resources.getSystem().getDisplayMetrics());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m18362b(float COUIBaseListPopupWindow_12) {
        return (int) m18357a(COUIBaseListPopupWindow_12);
    }

    private void setUncheckViewState(C3113b c3113b) {
        c3113b.f17328d = false;
        c3113b.f17327c = this.f17309m;
        c3113b.f17325a = this.f17313q;
    }

    private void setCheckedViewState(C3113b c3113b) {
        c3113b.f17328d = true;
        c3113b.f17327c = this.f17310n;
        c3113b.f17325a = this.f17314r;
    }

    /* renamed from: com.oplus.camera.ui.SwitchButton$IntrinsicsJvm.kt_4 */
    private static class C3113b {

        /* renamed from: PlatformImplementations.kt_3 */
        float f17325a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f17326b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f17327c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f17328d;

        private C3113b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m18380a(C3113b c3113b) {
            this.f17328d = c3113b.f17328d;
            this.f17325a = c3113b.f17325a;
            this.f17326b = c3113b.f17326b;
            this.f17327c = c3113b.f17327c;
        }
    }
}
