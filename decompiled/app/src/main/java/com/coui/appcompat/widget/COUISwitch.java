package com.coui.appcompat.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUISoundLoadUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISwitch extends CompoundButton {

    /* renamed from: A */
    private float f7788A;

    /* renamed from: B */
    private float f7789B;

    /* renamed from: C */
    private int f7790C;

    /* renamed from: D */
    private float f7791D;

    /* renamed from: E */
    private float f7792E;

    /* renamed from: F */
    private float f7793F;

    /* renamed from: G */
    private boolean f7794G;

    /* renamed from: H */
    private boolean f7795H;

    /* renamed from: I */
    private boolean f7796I;

    /* renamed from: J */
    private boolean f7797J;

    /* renamed from: K */
    private boolean f7798K;

    /* renamed from: L */
    private boolean f7799L;

    /* renamed from: M */
    private Paint f7800M;

    /* renamed from: N */
    private Paint f7801N;

    /* renamed from: O */
    private Paint f7802O;

    /* renamed from: P */
    private Drawable f7803P;

    /* renamed from: Q */
    private Drawable f7804Q;

    /* renamed from: R */
    private Drawable f7805R;

    /* renamed from: S */
    private Drawable f7806S;

    /* renamed from: T */
    private Drawable f7807T;

    /* renamed from: U */
    private Drawable f7808U;

    /* renamed from: V */
    private AnimatorSet f7809V;

    /* renamed from: W */
    private AnimatorSet f7810W;

    /* renamed from: PlatformImplementations.kt_3 */
    private String f7811a;

    /* renamed from: aa */
    private AnimatorSet f7812aa;

    /* renamed from: ab */
    private AnimatorSet f7813ab;

    /* renamed from: ac */
    private COUISoundLoadUtil f7814ac;

    /* renamed from: ad */
    private int f7815ad;

    /* renamed from: ae */
    private int f7816ae;

    /* renamed from: af */
    private boolean f7817af;

    /* renamed from: ag */
    private boolean f7818ag;

    /* renamed from: ah */
    private AccessibilityManager f7819ah;

    /* renamed from: ai */
    private InterfaceC1430a f7820ai;

    /* renamed from: aj */
    private int f7821aj;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f7822b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f7823c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f7824d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7825e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f7826f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7827g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7828h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7829i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7830j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7831k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f7832l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7833m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f7834n;

    /* renamed from: o */
    private int f7835o;

    /* renamed from: p */
    private int f7836p;

    /* renamed from: q */
    private int f7837q;

    /* renamed from: r */
    private int f7838r;

    /* renamed from: s */
    private int f7839s;

    /* renamed from: t */
    private int f7840t;

    /* renamed from: u */
    private int f7841u;

    /* renamed from: v */
    private RectF f7842v;

    /* renamed from: w */
    private RectF f7843w;

    /* renamed from: x */
    private int f7844x;

    /* renamed from: y */
    private int f7845y;

    /* renamed from: z */
    private float f7846z;

    /* renamed from: com.coui.appcompat.widget.COUISwitch$PlatformImplementations.kt_3 */
    public interface InterfaceC1430a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7470a();
    }

    public COUISwitch(Context context) {
        this(context, null);
    }

    public COUISwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiSwitchStyle);
    }

    public COUISwitch(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7842v = new RectF();
        this.f7843w = new RectF();
        this.f7846z = 1.0f;
        this.f7788A = 1.0f;
        this.f7794G = false;
        this.f7795H = false;
        this.f7809V = new AnimatorSet();
        this.f7818ag = false;
        setSoundEffectsEnabled(false);
        COUIDarkModeUtil.m6400a(this, false);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7821aj = attributeSet.getStyleAttribute();
        } else {
            this.f7821aj = OplusGLSurfaceView_13;
        }
        this.f7819ah = (AccessibilityManager) getContext().getSystemService("accessibility");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUISwitch, OplusGLSurfaceView_13, 0);
        this.f7824d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISwitch_barWidth, 0);
        this.f7825e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISwitch_barHeight, 0);
        this.f7829i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISwitch_outerCircleStrokeWidth, 0);
        this.f7827g = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_barUncheckedColor, 0);
        this.f7826f = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_barCheckedColor, 0);
        this.f7828h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.COUISwitch_outerCircleWidth, 0);
        this.f7830j = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_outerCircleColor, 0);
        this.f7831k = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_outerUnCheckedCircleColor, 0);
        this.f7832l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISwitch_innerCircleWidth, 0);
        this.f7833m = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_innerCircleColor, 0);
        this.f7840t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISwitch_circlePadding, 0);
        this.f7803P = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_loadingDrawable);
        this.f7834n = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_barUncheckedDisabledColor, 0);
        this.f7835o = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_barCheckedDisabledColor, 0);
        this.f7836p = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_innerCircleUncheckedDisabledColor, 0);
        this.f7837q = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_innerCircleCheckedDisabledColor, 0);
        this.f7838r = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_outerCircleUncheckedDisabledColor, 0);
        this.f7839s = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISwitch_outerCircleCheckedDisabledColor, 0);
        this.f7804Q = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_themedCheckedDrawable);
        this.f7805R = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_themedUncheckedDrawable);
        this.f7806S = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_themedLoadingCheckedBackground);
        this.f7807T = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_themedLoadingUncheckedBackground);
        this.f7808U = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISwitch_themedLoadingDrawable);
        this.f7845y = (this.f7824d - (this.f7840t * 2)) - this.f7828h;
        typedArrayObtainStyledAttributes.recycle();
        this.f7841u = getContext().getResources().getDimensionPixelSize(R.dimen.coui_switch_padding);
        this.f7799L = getContext().getResources().getBoolean(R.bool.coui_switch_theme_enable);
        m7453e();
        m7455f();
        this.f7814ac = COUISoundLoadUtil.m6460a();
        this.f7815ad = this.f7814ac.m6463a(context, R.raw.coui_switch_sound_on);
        this.f7816ae = this.f7814ac.m6463a(context, R.raw.coui_switch_sound_off);
        this.f7811a = getResources().getString(R.string.switch_on);
        this.f7822b = getResources().getString(R.string.switch_off);
        this.f7823c = getResources().getString(R.string.switch_loading);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7453e() {
        this.f7800M = new Paint(1);
        this.f7801N = new Paint(1);
        this.f7802O = new Paint(1);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7455f() {
        m7457g();
        m7458h();
        m7459i();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7457g() {
        Interpolator interpolatorM2772a = PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f);
        this.f7810W = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "circleScale", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(interpolatorM2772a);
        objectAnimatorOfFloat.setDuration(433L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "loadingScale", 0.5f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorM2772a);
        objectAnimatorOfFloat2.setDuration(550L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "loadingAlpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(interpolatorM2772a);
        objectAnimatorOfFloat3.setDuration(550L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setDuration(800L);
        objectAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        this.f7810W.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat4);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m7458h() {
        Interpolator interpolatorM2772a = PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f);
        this.f7812aa = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "loadingAlpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(interpolatorM2772a);
        objectAnimatorOfFloat.setDuration(100L);
        this.f7812aa.play(objectAnimatorOfFloat);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m7459i() {
        this.f7813ab = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f7813ab.play(objectAnimatorOfFloat);
    }

    public void setOnLoadingStateChangedListener(InterfaceC1430a interfaceC1430a) {
        this.f7820ai = interfaceC1430a;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7448a(boolean z) {
        this.f7814ac.m6464a(getContext(), z ? this.f7815ad : this.f7816ae, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7460j() {
        if (m7466a()) {
            performHapticFeedback(302);
            setTactileFeedbackEnabled(false);
        }
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f7798K = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7466a() {
        return this.f7798K;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (z == isChecked()) {
            return;
        }
        super.setChecked(z);
        if (!this.f7799L) {
            z = isChecked();
            AnimatorSet animatorSet = this.f7809V;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f7809V.end();
            }
            if (this.f7796I && this.f7797J) {
                m7450b(z);
            } else {
                if (m7465o()) {
                    setCircleTranslation(z ? 0 : this.f7845y);
                } else {
                    setCircleTranslation(z ? this.f7845y : 0);
                }
                setInnerCircleAlpha(z ? 0.0f : 1.0f);
                setBarColor(z ? this.f7826f : this.f7827g);
            }
        }
        if (this.f7817af) {
            m7448a(z);
            this.f7817af = false;
        }
        m7460j();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0041  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m7450b(boolean r11) {
        /*
            r10 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r2 = 1050253722(0x3e99999a, float:0.3)
            r3 = 1036831949(0x3dcccccd, float:0.1)
            android.view.animation.Interpolator r2 = androidx.core.p036h.p038b.PathInterpolatorCompat_2.m2772a(r2, r1, r3, r0)
            android.animation.AnimatorSet r3 = r10.f7809V
            r3.setInterpolator(r2)
            r2 = 2
            float[] r3 = new float[r2]
            r3 = {x00ac: FILL_ARRAY_DATA , data: [1065353216, 1067869798} // fill-array
            java.lang.String r4 = "circleScaleX"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r10, r4, r3)
            r5 = 133(0x85, double:6.57E-322)
            r3.setDuration(r5)
            float[] r7 = new float[r2]
            r7 = {x00b4: FILL_ARRAY_DATA , data: [1067869798, 1065353216} // fill-array
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r10, r4, r7)
            r4.setStartDelay(r5)
            r5 = 250(0xfa, double:1.235E-321)
            r4.setDuration(r5)
            int r5 = r10.getCircleTranslation()
            boolean r6 = r10.m7465o()
            r7 = 0
            if (r6 == 0) goto L46
            if (r11 == 0) goto L43
        L41:
            r6 = r7
            goto L4a
        L43:
            int r6 = r10.f7845y
            goto L4a
        L46:
            if (r11 == 0) goto L41
            int r6 = r10.f7845y
        L4a:
            int[] r8 = new int[r2]
            r8[r7] = r5
            r5 = 1
            r8[r5] = r6
            java.lang.String r6 = "circleTranslation"
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r10, r6, r8)
            r8 = 383(0x17f, double:1.89E-321)
            r6.setDuration(r8)
            float r8 = r10.getInnerCircleAlpha()
            if (r11 == 0) goto L63
            r0 = r1
        L63:
            float[] r1 = new float[r2]
            r1[r7] = r8
            r1[r5] = r0
            java.lang.String r0 = "innerCircleAlpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r10, r0, r1)
            r8 = 100
            r0.setDuration(r8)
            int r1 = r10.getBarColor()
            if (r11 == 0) goto L7d
            int r11 = r10.f7826f
            goto L7f
        L7d:
            int r11 = r10.f7827g
        L7f:
            int[] r2 = new int[r2]
            r2[r7] = r1
            r2[r5] = r11
            java.lang.String r11 = "barColor"
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofArgb(r10, r11, r2)
            r1 = 450(0x1c2, double:2.223E-321)
            r11.setDuration(r1)
            android.animation.AnimatorSet r1 = r10.f7809V
            android.animation.AnimatorSet$Builder r1 = r1.play(r3)
            android.animation.AnimatorSet$Builder r1 = r1.with(r4)
            android.animation.AnimatorSet$Builder r1 = r1.with(r6)
            android.animation.AnimatorSet$Builder r0 = r1.with(r0)
            r0.with(r11)
            android.animation.AnimatorSet r10 = r10.f7809V
            r10.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUISwitch.m7450b(boolean):void");
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7799L) {
            m7447a(canvas);
            m7456f(canvas);
            return;
        }
        m7463m();
        m7464n();
        m7449b(canvas);
        m7454e(canvas);
        m7451c(canvas);
        m7452d(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7447a(Canvas canvas) {
        canvas.save();
        Drawable drawableM7462l = m7462l();
        drawableM7462l.setAlpha(m7461k());
        int OplusGLSurfaceView_13 = this.f7841u;
        drawableM7462l.setBounds(OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f7824d + OplusGLSurfaceView_13, this.f7825e + OplusGLSurfaceView_13);
        m7462l().draw(canvas);
        canvas.restore();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private int m7461k() {
        return (int) ((isEnabled() ? 1.0f : 0.5f) * 255.0f);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private Drawable m7462l() {
        return m7468c() ? isChecked() ? this.f7806S : this.f7807T : isChecked() ? this.f7804Q : this.f7805R;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7449b(Canvas canvas) {
        canvas.save();
        this.f7800M.setColor(this.f7790C);
        if (!isEnabled()) {
            this.f7800M.setColor(isChecked() ? this.f7835o : this.f7834n);
        }
        float COUIBaseListPopupWindow_12 = this.f7825e / 2.0f;
        int OplusGLSurfaceView_13 = this.f7841u;
        canvas.drawRoundRect(OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f7824d + OplusGLSurfaceView_13, r0 + OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f7800M);
        canvas.restore();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7451c(Canvas canvas) {
        canvas.save();
        float COUIBaseListPopupWindow_12 = this.f7788A;
        canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f7842v.centerX(), this.f7842v.centerY());
        this.f7801N.setColor(isChecked() ? this.f7830j : this.f7831k);
        if (!isEnabled()) {
            this.f7801N.setColor(isChecked() ? this.f7839s : this.f7838r);
        }
        float f2 = this.f7828h / 2.0f;
        canvas.drawRoundRect(this.f7842v, f2, f2, this.f7801N);
        canvas.restore();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m7463m() {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float f4;
        if (isChecked()) {
            if (m7465o()) {
                COUIBaseListPopupWindow_12 = this.f7840t + this.f7844x + this.f7841u;
                f2 = this.f7828h;
                f3 = this.f7846z;
                f4 = (f2 * f3) + COUIBaseListPopupWindow_12;
            } else {
                f4 = ((this.f7824d - this.f7840t) - (this.f7845y - this.f7844x)) + this.f7841u;
                COUIBaseListPopupWindow_12 = f4 - (this.f7828h * this.f7846z);
            }
        } else if (m7465o()) {
            int OplusGLSurfaceView_13 = (this.f7824d - this.f7840t) - (this.f7845y - this.f7844x);
            int i2 = this.f7841u;
            float f5 = OplusGLSurfaceView_13 + i2;
            float f6 = i2 + (f5 - (this.f7828h * this.f7846z));
            f4 = f5;
            COUIBaseListPopupWindow_12 = f6;
        } else {
            COUIBaseListPopupWindow_12 = this.f7840t + this.f7844x + this.f7841u;
            f2 = this.f7828h;
            f3 = this.f7846z;
            f4 = (f2 * f3) + COUIBaseListPopupWindow_12;
        }
        int i3 = this.f7825e;
        float f7 = ((i3 - r3) / 2.0f) + this.f7841u;
        this.f7842v.set(COUIBaseListPopupWindow_12, f7, f4, this.f7828h + f7);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7452d(Canvas canvas) {
        canvas.save();
        float COUIBaseListPopupWindow_12 = this.f7788A;
        canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f7842v.centerX(), this.f7842v.centerY());
        float f2 = this.f7832l / 2.0f;
        this.f7802O.setColor(this.f7833m);
        if (!isEnabled()) {
            this.f7802O.setColor(isChecked() ? this.f7837q : this.f7836p);
        }
        float f3 = this.f7789B;
        if (f3 == 0.0f) {
            this.f7802O.setAlpha((int) (f3 * 255.0f));
        }
        canvas.drawRoundRect(this.f7843w, f2, f2, this.f7802O);
        canvas.restore();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m7464n() {
        this.f7843w.set(this.f7842v.left + this.f7829i, this.f7842v.top + this.f7829i, this.f7842v.right - this.f7829i, this.f7842v.bottom - this.f7829i);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7454e(Canvas canvas) {
        canvas.save();
        float COUIBaseListPopupWindow_12 = this.f7791D;
        canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f7842v.centerX(), this.f7842v.centerY());
        canvas.rotate(this.f7793F, this.f7842v.centerX(), this.f7842v.centerY());
        Drawable drawable = this.f7803P;
        if (drawable != null) {
            drawable.setBounds((int) this.f7842v.left, (int) this.f7842v.top, (int) this.f7842v.right, (int) this.f7842v.bottom);
            this.f7803P.setAlpha((int) (this.f7792E * 255.0f));
            this.f7803P.draw(canvas);
        }
        canvas.restore();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7456f(Canvas canvas) {
        if (this.f7794G) {
            int width = (getWidth() - this.f7828h) / 2;
            int width2 = (getWidth() + this.f7828h) / 2;
            int height = (getHeight() - this.f7828h) / 2;
            int height2 = (getHeight() + this.f7828h) / 2;
            int width3 = getWidth() / 2;
            int height3 = getHeight() / 2;
            canvas.save();
            canvas.rotate(this.f7793F, width3, height3);
            this.f7808U.setBounds(width, height, width2, height2);
            this.f7808U.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f7817af = true;
            this.f7798K = true;
        }
        if (this.f7795H && motionEvent.getAction() == 1 && isEnabled()) {
            m7467b();
            return false;
        }
        if (this.f7794G) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7467b() {
        if (this.f7794G) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f7819ah;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            announceForAccessibility(this.f7823c);
        }
        this.f7794G = true;
        if (this.f7799L) {
            this.f7813ab.start();
        } else {
            this.f7810W.start();
        }
        InterfaceC1430a interfaceC1430a = this.f7820ai;
        if (interfaceC1430a != null) {
            interfaceC1430a.m7470a();
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7796I = true;
        this.f7797J = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        int i3 = this.f7824d;
        int i4 = this.f7841u;
        setMeasuredDimension(i3 + (i4 * 2), this.f7825e + (i4 * 2));
        if (this.f7818ag) {
            return;
        }
        this.f7818ag = true;
        if (m7465o()) {
            this.f7844x = isChecked() ? 0 : this.f7845y;
        } else {
            this.f7844x = isChecked() ? this.f7845y : 0;
        }
        this.f7789B = isChecked() ? 0.0f : 1.0f;
        this.f7790C = isChecked() ? this.f7826f : this.f7827g;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f7796I = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7797J = false;
        this.f7796I = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        AnimatorSet animatorSet = this.f7809V;
        if (animatorSet == null || !animatorSet.isStarted()) {
            return;
        }
        this.f7809V.end();
    }

    public void setShouldPlaySound(boolean z) {
        this.f7817af = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m7468c() {
        return this.f7794G;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7469d() {
        this.f7796I = true;
    }

    public void setLoadingStyle(boolean z) {
        this.f7795H = z;
    }

    public void setCircleTranslation(int OplusGLSurfaceView_13) {
        this.f7844x = OplusGLSurfaceView_13;
        invalidate();
    }

    public int getCircleTranslation() {
        return this.f7844x;
    }

    public void setCircleScaleX(float COUIBaseListPopupWindow_12) {
        this.f7846z = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getCircleScaleX() {
        return this.f7846z;
    }

    public void setInnerCircleAlpha(float COUIBaseListPopupWindow_12) {
        this.f7789B = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getInnerCircleAlpha() {
        return this.f7789B;
    }

    public void setBarColor(int OplusGLSurfaceView_13) {
        this.f7790C = OplusGLSurfaceView_13;
        invalidate();
    }

    public int getBarColor() {
        return this.f7790C;
    }

    public void setCircleScale(float COUIBaseListPopupWindow_12) {
        this.f7788A = COUIBaseListPopupWindow_12;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public float getCircleScale() {
        return this.f7788A;
    }

    public void setLoadingScale(float COUIBaseListPopupWindow_12) {
        this.f7791D = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getLoadingScale() {
        return this.f7791D;
    }

    public void setLoadingAlpha(float COUIBaseListPopupWindow_12) {
        this.f7792E = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getLoadingAlpha() {
        return this.f7792E;
    }

    public void setLoadingRotation(float COUIBaseListPopupWindow_12) {
        this.f7793F = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getLoadingRotation() {
        return this.f7793F;
    }

    @Override // android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Switch.class.getName();
    }

    /* renamed from: o */
    private boolean m7465o() {
        return Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f7795H) {
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setText(isChecked() ? this.f7811a : this.f7822b);
        } else {
            accessibilityNodeInfo.setText(isChecked() ? this.f7811a : this.f7822b);
        }
    }

    public void setBarWidth(int OplusGLSurfaceView_13) {
        this.f7824d = OplusGLSurfaceView_13;
    }

    public void setBarHeight(int OplusGLSurfaceView_13) {
        this.f7825e = OplusGLSurfaceView_13;
    }

    public void setOuterCircleStrokeWidth(int OplusGLSurfaceView_13) {
        this.f7829i = OplusGLSurfaceView_13;
    }

    public void setOuterCircleWidth(int OplusGLSurfaceView_13) {
        this.f7828h = OplusGLSurfaceView_13;
    }

    public void setInnerCircleWidth(int OplusGLSurfaceView_13) {
        this.f7832l = OplusGLSurfaceView_13;
    }

    public void setCirclePadding(int OplusGLSurfaceView_13) {
        this.f7840t = OplusGLSurfaceView_13;
    }

    public void setBarUnCheckedColor(int OplusGLSurfaceView_13) {
        this.f7827g = OplusGLSurfaceView_13;
        setBarColor(isChecked() ? this.f7826f : this.f7827g);
    }

    public void setBarCheckedColor(int OplusGLSurfaceView_13) {
        this.f7826f = OplusGLSurfaceView_13;
        setBarColor(isChecked() ? this.f7826f : this.f7827g);
    }

    public void setInnerCircleColor(int OplusGLSurfaceView_13) {
        this.f7833m = OplusGLSurfaceView_13;
    }

    public void setOuterCircleColor(int OplusGLSurfaceView_13) {
        this.f7830j = OplusGLSurfaceView_13;
    }

    public void setBarUncheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7834n = OplusGLSurfaceView_13;
    }

    public void setBarCheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7835o = OplusGLSurfaceView_13;
    }

    public void setInnerCircleUncheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7836p = OplusGLSurfaceView_13;
    }

    public void setInnerCircleCheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7837q = OplusGLSurfaceView_13;
    }

    public void setOuterCircleUncheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7838r = OplusGLSurfaceView_13;
    }

    public void setOuterCircleCheckedDisabledColor(int OplusGLSurfaceView_13) {
        this.f7839s = OplusGLSurfaceView_13;
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.f7803P = drawable;
    }

    public void setCheckedDrawable(Drawable drawable) {
        this.f7804Q = drawable;
    }

    public void setUncheckedDrawable(Drawable drawable) {
        this.f7805R = drawable;
    }

    public void setThemedLoadingCheckedBackground(Drawable drawable) {
        this.f7806S = drawable;
    }

    public void setThemedLoadingUncheckedBackground(Drawable drawable) {
        this.f7807T = drawable;
    }

    public void setThemedLoadingDrawable(Drawable drawable) {
        this.f7808U = drawable;
    }
}
