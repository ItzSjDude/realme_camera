package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ExploreByTouchHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUINumericKeyboard extends View {

    /* renamed from: A */
    private TextPaint f7584A;

    /* renamed from: B */
    private float f7585B;

    /* renamed from: C */
    private float f7586C;

    /* renamed from: D */
    private float f7587D;

    /* renamed from: E */
    private float f7588E;

    /* renamed from: F */
    private SideStyle f7589F;

    /* renamed from: G */
    private SideStyle f7590G;

    /* renamed from: H */
    private AnimatorSet f7591H;

    /* renamed from: I */
    private AnimatorSet f7592I;

    /* renamed from: J */
    private boolean f7593J;

    /* renamed from: K */
    private Animator.AnimatorListener f7594K;

    /* renamed from: L */
    private PatternExploreByTouchHelper f7595L;

    /* renamed from: M */
    private final AccessibilityManager f7596M;

    /* renamed from: N */
    private Context f7597N;

    /* renamed from: O */
    private int f7598O;

    /* renamed from: P */
    private int f7599P;

    /* renamed from: Q */
    private int f7600Q;

    /* renamed from: R */
    private int f7601R;

    /* renamed from: S */
    private float f7602S;

    /* renamed from: T */
    private int f7603T;

    /* renamed from: U */
    private int f7604U;

    /* renamed from: V */
    private float f7605V;

    /* renamed from: W */
    private Interpolator f7606W;

    /* renamed from: PlatformImplementations.kt_3 */
    public final SideStyle f7607a;

    /* renamed from: aa */
    private Interpolator f7608aa;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f7609b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f7610c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Cell f7611d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7612e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OnClickItemListener f7613f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7614g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7615h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7616i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7617j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f7618k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f7619l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Cell[][] f7620m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Drawable f7621n;

    /* renamed from: o */
    private Drawable f7622o;

    /* renamed from: p */
    private Drawable f7623p;

    /* renamed from: q */
    private int[] f7624q;

    /* renamed from: r */
    private TextPaint f7625r;

    /* renamed from: s */
    private Paint.FontMetricsInt f7626s;

    /* renamed from: t */
    private Paint.FontMetricsInt f7627t;

    /* renamed from: u */
    private Paint f7628u;

    /* renamed from: v */
    private float f7629v;

    /* renamed from: w */
    private float f7630w;

    /* renamed from: x */
    private float f7631x;

    /* renamed from: y */
    private int f7632y;

    /* renamed from: z */
    private int f7633z;

    public interface OnClickItemListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7361a();

        /* renamed from: PlatformImplementations.kt_3 */
        void m7362a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7363b();
    }

    @Deprecated
    public interface OnItemTouchListener {
    }

    @Deprecated
    public interface OnTouchTextListener {
    }

    @Deprecated
    public interface OnTouchUpListener {
    }

    @Deprecated
    public int getTouchIndex() {
        return 0;
    }

    @Deprecated
    public void setHasFinishButton(boolean z) {
    }

    @Deprecated
    public void setItemTouchListener(OnItemTouchListener onItemTouchListener) {
    }

    @Deprecated
    public void setTouchTextListener(OnTouchTextListener onTouchTextListener) {
    }

    @Deprecated
    public void setTouchUpListener(OnTouchUpListener onTouchUpListener) {
    }

    @Deprecated
    public void setType(int OplusGLSurfaceView_13) {
    }

    /* renamed from: com.coui.appcompat.widget.COUINumericKeyboard$1 */
    class C14141 extends AnimatorListenerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUINumericKeyboard f7634a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7634a.f7592I.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized Cell m7360a(int OplusGLSurfaceView_13, int i2) {
        m7346b(OplusGLSurfaceView_13, i2);
        return this.f7620m[OplusGLSurfaceView_13][i2];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7346b(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 3) {
            throw new IllegalArgumentException("row must be in range 0-3");
        }
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("column must be in range 0-2");
        }
    }

    public class Cell {

        /* renamed from: PlatformImplementations.kt_3 */
        int f7635a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f7636b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        String f7637c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f7638d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f7639e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f7640f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        final /* synthetic */ COUINumericKeyboard f7641g;

        public int getRow() {
            return this.f7635a;
        }

        public int getColumn() {
            return this.f7636b;
        }

        public void setCellNumberAlpha(float COUIBaseListPopupWindow_12) {
            this.f7638d = COUIBaseListPopupWindow_12;
            this.f7641g.invalidate();
        }

        public void setCellNumberTranslateX(int OplusGLSurfaceView_13) {
            this.f7639e = OplusGLSurfaceView_13;
            this.f7641g.invalidate();
        }

        public void setCellNumberTranslateY(int OplusGLSurfaceView_13) {
            this.f7640f = OplusGLSurfaceView_13;
            this.f7641g.invalidate();
        }

        public String toString() {
            return "row " + this.f7635a + "column " + this.f7636b;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int i3 = (this.f7617j + this.f7615h) * 3;
        int i4 = this.f7616i;
        setMeasuredDimension(i3 + i4, ((int) ((r4 * 4) + (this.f7630w * 5.0f))) + i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7329a() {
        Typeface typefaceM7326a;
        this.f7616i = this.f7615h / 2;
        this.f7610c = new Paint(5);
        this.f7610c.setColor(this.f7614g);
        this.f7610c.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
        this.f7610c.setAlpha(0);
        this.f7625r.setTextSize(this.f7631x);
        this.f7625r.setColor(this.f7632y);
        this.f7625r.setAntiAlias(true);
        try {
            typefaceM7326a = m7326a(getStatusAndVariation());
        } catch (Exception unused) {
            typefaceM7326a = Typeface.DEFAULT;
        }
        this.f7625r.setTypeface(typefaceM7326a);
        this.f7626s = this.f7625r.getFontMetricsInt();
        this.f7628u.setColor(this.f7633z);
        this.f7628u.setAntiAlias(true);
        this.f7628u.setStyle(Paint.Style.STROKE);
        this.f7628u.setStrokeWidth(this.f7630w);
        this.f7584A.setFakeBoldText(true);
        this.f7584A.setAntiAlias(true);
    }

    private int[] getStatusAndVariation() {
        int OplusGLSurfaceView_13 = Settings.System.getInt(this.f7597N.getContentResolver(), "font_variation_settings", 550);
        return new int[]{(61440 & OplusGLSurfaceView_13) >> 12, OplusGLSurfaceView_13 & 4095};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Typeface m7326a(int[] iArr) {
        this.f7598O = iArr[1];
        Typeface typeface = Typeface.DEFAULT;
        if (Build.VERSION.SDK_INT < 26) {
            return typeface;
        }
        if (iArr[0] != 0) {
            return new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf").setFontVariationSettings("'wght' " + iArr[1]).build();
        }
        return new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf").build();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int[] statusAndVariation = getStatusAndVariation();
        if (this.f7598O != statusAndVariation[1]) {
            this.f7625r.setTypeface(m7326a(statusAndVariation));
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7344b() {
        m7351c();
        m7355d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7351c() {
        this.f7591H = new AnimatorSet();
        this.f7591H.setDuration(100L);
        this.f7591H.setInterpolator(new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f));
        this.f7591H.play(ObjectAnimator.ofFloat(this, "normalScale", 1.0f, 2.0f)).with(ObjectAnimator.ofFloat(this, "normalAlpha", 0.0f, this.f7609b));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7355d() {
        PathInterpolator pathInterpolator = new PathInterpolator(0.0f, 0.0f, 0.6f, 1.0f);
        this.f7592I = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "normalScale", 2.0f, 2.5f);
        objectAnimatorOfFloat.setDuration(160L);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "normalAlpha", this.f7609b, 0.0f);
        objectAnimatorOfFloat2.setDuration(160L);
        objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("blurAlpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, this.f7609b), Keyframe.ofFloat(1.0f, 0.0f)));
        objectAnimatorOfPropertyValuesHolder.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "blurScale", 1.0f, 2.0f);
        objectAnimatorOfPropertyValuesHolder.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(pathInterpolator);
        this.f7592I.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfPropertyValuesHolder);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m7338a(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (!isEnabled()) {
            if (m7337a(action)) {
                m7359g();
            }
            return false;
        }
        if (action == 0) {
            this.f7619l = true;
            m7352c(motionEvent);
        } else if (action == 1) {
            this.f7619l = false;
            m7347b(motionEvent);
        } else if (action != 2 && (action == 3 || action == 6)) {
            this.f7619l = false;
            m7347b(motionEvent);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7337a(int OplusGLSurfaceView_13) {
        return this.f7586C > 0.0f && (1 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7338a(MotionEvent motionEvent) {
        return motionEvent.getPointerId(motionEvent.getActionIndex()) > 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7356e() {
        if (this.f7593J) {
            performHapticFeedback(302);
        } else {
            performHapticFeedback(301);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7358f() {
        playSoundEffect(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7347b(MotionEvent motionEvent) {
        if (this.f7596M.isTouchExplorationEnabled()) {
            this.f7611d = m7327a(motionEvent.getX(), motionEvent.getY());
            Cell cell = this.f7611d;
            if (cell != null) {
                int iM7324a = m7324a(cell);
                this.f7595L.invalidateRoot();
                if (this.f7618k && iM7324a != -1) {
                    m7356e();
                }
            } else {
                this.f7612e = -1;
            }
        }
        m7359g();
        if (m7323a(motionEvent.getY()) != -1 && m7342b(motionEvent.getX()) != -1) {
            m7345b(this.f7612e);
        }
        if (this.f7612e != -1 && isEnabled() && !hasOnClickListeners()) {
            m7358f();
        }
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7359g() {
        if (this.f7591H.isRunning()) {
            this.f7591H.addListener(this.f7594K);
        } else {
            this.f7592I.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7345b(int OplusGLSurfaceView_13) {
        OnClickItemListener onClickItemListener = this.f7613f;
        if (onClickItemListener != null) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 8) {
                onClickItemListener.m7362a(OplusGLSurfaceView_13 + 1);
            }
            if (OplusGLSurfaceView_13 == 10) {
                this.f7613f.m7362a(0);
            }
            if (OplusGLSurfaceView_13 == 9) {
                this.f7613f.m7361a();
            }
            if (OplusGLSurfaceView_13 == 11) {
                this.f7613f.m7363b();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7352c(MotionEvent motionEvent) {
        if (!this.f7596M.isTouchExplorationEnabled()) {
            this.f7611d = m7327a(motionEvent.getX(), motionEvent.getY());
            Cell cell = this.f7611d;
            if (cell != null) {
                int iM7324a = m7324a(cell);
                this.f7595L.invalidateRoot();
                if (this.f7618k && iM7324a != -1) {
                    m7356e();
                }
            } else {
                this.f7612e = -1;
            }
        }
        this.f7591H.removeAllListeners();
        if (this.f7592I.isRunning()) {
            this.f7592I.end();
        }
        if (this.f7591H.isRunning()) {
            this.f7591H.end();
        }
        this.f7591H.start();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7324a(Cell cell) {
        this.f7612e = (cell.getRow() * 3) + cell.getColumn();
        if (this.f7612e == 9 && m7339a(this.f7589F)) {
            this.f7612e = -1;
        }
        if (this.f7612e == 11 && m7339a(this.f7590G)) {
            this.f7612e = -1;
        }
        return this.f7612e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m7348c(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = this.f7615h + this.f7617j;
        return getPaddingLeft() + (COUIBaseListPopupWindow_12 / 2.0f) + (COUIBaseListPopupWindow_12 * OplusGLSurfaceView_13) + (this.f7616i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m7353d(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = this.f7615h;
        return getPaddingTop() + (COUIBaseListPopupWindow_12 / 2.0f) + (this.f7616i / 2) + (COUIBaseListPopupWindow_12 * OplusGLSurfaceView_13) + (this.f7630w * (OplusGLSurfaceView_13 + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public Cell m7327a(float COUIBaseListPopupWindow_12, float f2) {
        int iM7342b;
        int iM7323a = m7323a(f2);
        if (iM7323a >= 0 && (iM7342b = m7342b(COUIBaseListPopupWindow_12)) >= 0) {
            return m7360a(iM7323a, iM7342b);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7323a(float COUIBaseListPopupWindow_12) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            int iM7353d = (int) m7353d(OplusGLSurfaceView_13);
            int i2 = this.f7615h;
            float f2 = this.f7630w;
            int i3 = (int) ((iM7353d - (i2 / 2)) - (f2 / 2.0f));
            int i4 = (int) (iM7353d + (i2 / 2) + (f2 / 2.0f));
            if (i3 <= COUIBaseListPopupWindow_12 && COUIBaseListPopupWindow_12 <= i4) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m7342b(float COUIBaseListPopupWindow_12) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            int iM7348c = (int) m7348c(OplusGLSurfaceView_13);
            int i2 = this.f7615h;
            int i3 = this.f7617j;
            int i4 = (iM7348c - (i2 / 2)) - (i3 / 2);
            int i5 = iM7348c + (i2 / 2) + (i3 / 2);
            if (i4 <= COUIBaseListPopupWindow_12 && COUIBaseListPopupWindow_12 <= i5) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f7610c != null) {
            this.f7610c = null;
        }
        if (this.f7611d != null) {
            this.f7611d = null;
        }
        this.f7619l = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7330a(canvas);
        for (int OplusGLSurfaceView_13 = -1; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            m7331a(canvas, OplusGLSurfaceView_13);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                m7332a(canvas, i3, i2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7330a(Canvas canvas) {
        Cell cell = this.f7611d;
        if (cell != null) {
            float fM7348c = m7348c(cell.f7636b);
            float fM7353d = m7353d(this.f7611d.f7635a);
            if (m7324a(this.f7611d) != -1) {
                int OplusGLSurfaceView_13 = this.f7616i;
                int i2 = (int) (fM7348c - OplusGLSurfaceView_13);
                int i3 = (int) (fM7353d - OplusGLSurfaceView_13);
                int i4 = (int) (OplusGLSurfaceView_13 + fM7348c);
                int i5 = (int) (OplusGLSurfaceView_13 + fM7353d);
                canvas.save();
                float COUIBaseListPopupWindow_12 = this.f7588E;
                canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, fM7348c, fM7353d);
                this.f7622o.setAlpha((int) (this.f7586C * 255.0f));
                this.f7622o.setBounds(i2, i3, i4, i5);
                this.f7622o.draw(canvas);
                canvas.restore();
                canvas.save();
                float f2 = this.f7587D;
                canvas.scale(f2, f2, fM7348c, fM7353d);
                this.f7623p.setBounds(i2, i3, i4, i5);
                this.f7623p.setAlpha((int) (this.f7585B * 255.0f));
                this.f7623p.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7331a(Canvas canvas, int OplusGLSurfaceView_13) {
        float measuredWidth = getMeasuredWidth();
        float COUIBaseListPopupWindow_12 = this.f7629v;
        float f2 = (measuredWidth - COUIBaseListPopupWindow_12) / 2.0f;
        float f3 = (this.f7615h + this.f7617j) * (OplusGLSurfaceView_13 + 1);
        canvas.drawLine(f2, f3, f2 + COUIBaseListPopupWindow_12, f3, this.f7628u);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7332a(Canvas canvas, int OplusGLSurfaceView_13, int i2) {
        Cell cell = this.f7620m[i2][OplusGLSurfaceView_13];
        float fM7348c = m7348c(OplusGLSurfaceView_13);
        float fM7353d = m7353d(i2);
        int i3 = (i2 * 3) + OplusGLSurfaceView_13;
        if (i3 == 9) {
            m7334a(this.f7589F, canvas, fM7348c, fM7353d);
            return;
        }
        if (i3 == 11) {
            m7334a(this.f7590G, canvas, fM7348c, fM7353d);
        } else if (i3 != -1) {
            this.f7625r.setAlpha((int) (cell.f7638d * 255.0f));
            canvas.drawText(cell.f7637c, (fM7348c - (this.f7625r.measureText(cell.f7637c) / 2.0f)) + cell.f7639e, (fM7353d - ((this.f7626s.descent + this.f7626s.ascent) / 2)) + cell.f7640f, this.f7625r);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7334a(SideStyle sideStyle, Canvas canvas, float COUIBaseListPopupWindow_12, float f2) {
        if (m7339a(sideStyle)) {
            return;
        }
        if (sideStyle.f7644a != null) {
            int intrinsicWidth = (int) (COUIBaseListPopupWindow_12 - (sideStyle.f7644a.getIntrinsicWidth() / 2));
            int intrinsicWidth2 = sideStyle.f7644a.getIntrinsicWidth() + intrinsicWidth;
            int intrinsicHeight = (int) (f2 - (sideStyle.f7644a.getIntrinsicHeight() / 2));
            int intrinsicHeight2 = sideStyle.f7644a.getIntrinsicHeight() + intrinsicHeight;
            Drawable drawable = sideStyle.f7644a;
            int OplusGLSurfaceView_13 = this.f7600Q;
            int i2 = this.f7601R;
            drawable.setBounds(intrinsicWidth + OplusGLSurfaceView_13, intrinsicHeight + i2, intrinsicWidth2 + OplusGLSurfaceView_13, intrinsicHeight2 + i2);
            sideStyle.f7644a.setAlpha((int) (this.f7602S * 255.0f));
            sideStyle.f7644a.draw(canvas);
            return;
        }
        if (TextUtils.isEmpty(sideStyle.f7645b)) {
            return;
        }
        this.f7584A.setTextSize(sideStyle.f7647d);
        this.f7584A.setColor(sideStyle.f7646c);
        this.f7584A.setAlpha((int) (this.f7605V * 255.0f));
        float fMeasureText = this.f7584A.measureText(sideStyle.f7645b);
        this.f7627t = this.f7584A.getFontMetricsInt();
        canvas.drawText(sideStyle.f7645b, (COUIBaseListPopupWindow_12 - (fMeasureText / 2.0f)) + this.f7603T, (f2 - ((this.f7627t.descent + this.f7627t.ascent) / 2)) + this.f7604U, this.f7584A);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Paint paint;
        if (!z && this.f7619l && (paint = this.f7610c) != null) {
            paint.setAlpha(0);
            this.f7619l = false;
            invalidate();
        }
        super.setEnabled(z);
    }

    private void setBlurScale(float COUIBaseListPopupWindow_12) {
        this.f7587D = COUIBaseListPopupWindow_12;
        invalidate();
    }

    private void setNormalScale(float COUIBaseListPopupWindow_12) {
        this.f7588E = COUIBaseListPopupWindow_12;
        invalidate();
    }

    private void setBlurAlpha(float COUIBaseListPopupWindow_12) {
        this.f7585B = COUIBaseListPopupWindow_12;
        invalidate();
    }

    private void setNormalAlpha(float COUIBaseListPopupWindow_12) {
        this.f7586C = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public void setDrawableTranslateX(int OplusGLSurfaceView_13) {
        this.f7600Q = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setDrawableTranslateY(int OplusGLSurfaceView_13) {
        this.f7601R = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setDrawableAlpha(float COUIBaseListPopupWindow_12) {
        this.f7602S = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public void setTextTranslateX(int OplusGLSurfaceView_13) {
        this.f7603T = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setTextTranslateY(int OplusGLSurfaceView_13) {
        this.f7604U = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setTextAlpha(float COUIBaseListPopupWindow_12) {
        this.f7605V = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.f7613f = onClickItemListener;
    }

    public void setLeftStyle(SideStyle sideStyle) {
        this.f7589F = sideStyle;
        this.f7595L.invalidateVirtualView(9);
        invalidate();
    }

    public void setRightStyle(SideStyle sideStyle) {
        this.f7590G = sideStyle;
        this.f7595L.invalidateVirtualView(11);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7339a(SideStyle sideStyle) {
        return sideStyle == null || (sideStyle.f7644a == null && TextUtils.isEmpty(sideStyle.f7645b));
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f7618k = z;
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < 3; i2++) {
                Cell cellM7360a = m7360a(OplusGLSurfaceView_13, i2);
                int i3 = (OplusGLSurfaceView_13 * 3) + i2;
                if (i3 == 9) {
                    m7335a(this.f7589F, arrayList, i3);
                } else if (i3 == 11) {
                    SideStyle sideStyle = this.f7590G;
                    if (m7339a(this.f7589F)) {
                        i3--;
                    }
                    m7335a(sideStyle, arrayList, i3);
                } else {
                    m7333a(cellM7360a, arrayList, i3);
                }
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7335a(SideStyle sideStyle, List<Animator> list, int OplusGLSurfaceView_13) {
        if (m7339a(sideStyle)) {
            return;
        }
        if (sideStyle.f7644a != null) {
            setDrawableAlpha(0.0f);
            setDrawableTranslateY(this.f7599P);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "drawableAlpha", 0.0f, 1.0f);
            long OplusGLSurfaceView_15 = OplusGLSurfaceView_13 * 16;
            objectAnimatorOfFloat.setStartDelay(166 + OplusGLSurfaceView_15);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(this.f7606W);
            list.add(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "drawableTranslateY", this.f7599P, 0);
            objectAnimatorOfInt.setStartDelay(OplusGLSurfaceView_15);
            objectAnimatorOfInt.setDuration(500L);
            objectAnimatorOfInt.setInterpolator(this.f7608aa);
            list.add(objectAnimatorOfInt);
            return;
        }
        if (TextUtils.isEmpty(sideStyle.f7645b)) {
            return;
        }
        setTextAlpha(0.0f);
        setTextTranslateY(this.f7599P);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "textAlpha", 0.0f, 1.0f);
        long j2 = OplusGLSurfaceView_13 * 16;
        objectAnimatorOfFloat2.setStartDelay(166 + j2);
        objectAnimatorOfFloat2.setDuration(167L);
        objectAnimatorOfFloat2.setInterpolator(this.f7606W);
        list.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this, "textTranslateY", this.f7599P, 0);
        objectAnimatorOfInt2.setStartDelay(j2);
        objectAnimatorOfInt2.setDuration(500L);
        objectAnimatorOfInt2.setInterpolator(this.f7608aa);
        list.add(objectAnimatorOfInt2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7333a(Cell cell, List<Animator> list, int OplusGLSurfaceView_13) {
        cell.setCellNumberAlpha(0.0f);
        cell.setCellNumberTranslateY(this.f7599P);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cell, "cellNumberAlpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setStartDelay(166 + (((OplusGLSurfaceView_13 == 10 && m7339a(this.f7589F)) ? OplusGLSurfaceView_13 - 1 : OplusGLSurfaceView_13) * 16));
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(this.f7606W);
        list.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(cell, "cellNumberTranslateY", this.f7599P, 0);
        if (OplusGLSurfaceView_13 == 10 && m7339a(this.f7589F)) {
            OplusGLSurfaceView_13--;
        }
        objectAnimatorOfInt.setStartDelay(16 * OplusGLSurfaceView_13);
        objectAnimatorOfInt.setDuration(500L);
        objectAnimatorOfInt.setInterpolator(this.f7608aa);
        list.add(objectAnimatorOfInt);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.f7596M.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f7595L.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    private final class PatternExploreByTouchHelper extends ExploreByTouchHelper {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUINumericKeyboard f7642a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Rect f7643b;

        public int getItemCounts() {
            return 12;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2) {
            return m7364a(COUIBaseListPopupWindow_12, f2);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
        @Override // androidx.customview.p039a.ExploreByTouchHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void getVisibleVirtualViews(java.util.List<java.lang.Integer> r5) {
            /*
                r4 = this;
                r0 = 0
            L1:
                int r1 = r4.getItemCounts()
                if (r0 >= r1) goto L42
                r1 = 9
                r2 = -1
                if (r0 != r1) goto L20
                com.coui.appcompat.widget.COUINumericKeyboard r1 = r4.f7642a
                com.coui.appcompat.widget.COUINumericKeyboard$SideStyle r3 = com.coui.appcompat.widget.COUINumericKeyboard.m7343b(r1)
                boolean r1 = com.coui.appcompat.widget.COUINumericKeyboard.m7340a(r1, r3)
                if (r1 == 0) goto L20
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r5.add(r1)
                goto L3f
            L20:
                r1 = 11
                if (r0 != r1) goto L38
                com.coui.appcompat.widget.COUINumericKeyboard r1 = r4.f7642a
                com.coui.appcompat.widget.COUINumericKeyboard$SideStyle r3 = com.coui.appcompat.widget.COUINumericKeyboard.m7350c(r1)
                boolean r1 = com.coui.appcompat.widget.COUINumericKeyboard.m7340a(r1, r3)
                if (r1 == 0) goto L38
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r5.add(r1)
                goto L3f
            L38:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r5.add(r1)
            L3f:
                int r0 = r0 + 1
                goto L1
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUINumericKeyboard.PatternExploreByTouchHelper.getVisibleVirtualViews(java.util.List):void");
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int OplusGLSurfaceView_13, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(m7367b(OplusGLSurfaceView_13));
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d) {
            c0483d.m2702e(m7367b(OplusGLSurfaceView_13));
            c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3018e);
            c0483d.m2709g(true);
            c0483d.m2687b(m7365c(OplusGLSurfaceView_13));
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            return m7366a(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7366a(int OplusGLSurfaceView_13) {
            invalidateVirtualView(OplusGLSurfaceView_13);
            if (this.f7642a.isEnabled()) {
                this.f7642a.m7345b(OplusGLSurfaceView_13);
                this.f7642a.announceForAccessibility(m7367b(OplusGLSurfaceView_13));
            }
            sendEventForVirtualView(OplusGLSurfaceView_13, 1);
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Rect m7365c(int OplusGLSurfaceView_13) {
            int iM7353d;
            Rect rect = this.f7643b;
            int iM7348c = 0;
            if (OplusGLSurfaceView_13 != -1) {
                Cell cellM7360a = this.f7642a.m7360a(OplusGLSurfaceView_13 / 3, OplusGLSurfaceView_13 % 3);
                iM7348c = (int) this.f7642a.m7348c(cellM7360a.f7636b);
                iM7353d = (int) this.f7642a.m7353d(cellM7360a.f7635a);
            } else {
                iM7353d = 0;
            }
            rect.left = iM7348c - this.f7642a.f7616i;
            rect.right = iM7348c + this.f7642a.f7616i;
            rect.top = iM7353d - this.f7642a.f7616i;
            rect.bottom = iM7353d + this.f7642a.f7616i;
            return rect;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m7364a(float COUIBaseListPopupWindow_12, float f2) {
            Cell cellM7327a = this.f7642a.m7327a(COUIBaseListPopupWindow_12, f2);
            if (cellM7327a == null) {
                return -1;
            }
            int column = cellM7327a.getColumn() + (cellM7327a.getRow() * 3);
            if (column == 9) {
                COUINumericKeyboard cOUINumericKeyboard = this.f7642a;
                if (cOUINumericKeyboard.m7339a(cOUINumericKeyboard.f7589F)) {
                    column = -1;
                }
            }
            if (column != 11) {
                return column;
            }
            COUINumericKeyboard cOUINumericKeyboard2 = this.f7642a;
            if (cOUINumericKeyboard2.m7339a(cOUINumericKeyboard2.f7590G)) {
                return -1;
            }
            return column;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CharSequence m7367b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 9) {
                COUINumericKeyboard cOUINumericKeyboard = this.f7642a;
                if (!cOUINumericKeyboard.m7339a(cOUINumericKeyboard.f7589F)) {
                    return this.f7642a.f7589F.f7648e;
                }
            }
            if (OplusGLSurfaceView_13 == 11) {
                COUINumericKeyboard cOUINumericKeyboard2 = this.f7642a;
                if (!cOUINumericKeyboard2.m7339a(cOUINumericKeyboard2.f7590G)) {
                    return this.f7642a.f7590G.f7648e;
                }
            }
            if (OplusGLSurfaceView_13 == -1) {
                return getClass().getSimpleName();
            }
            return this.f7642a.f7624q[OplusGLSurfaceView_13] + "";
        }
    }

    public static class SideStyle {

        /* renamed from: PlatformImplementations.kt_3 */
        private Drawable f7644a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f7645b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f7646c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f7647d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private String f7648e;

        public static class Builder {
        }
    }

    public void setPressedColor(int OplusGLSurfaceView_13) {
        this.f7614g = OplusGLSurfaceView_13;
        this.f7622o.setTint(this.f7614g);
        this.f7623p.setTint(this.f7614g);
        m7329a();
    }

    public void setKeyboardNumberTextColor(int OplusGLSurfaceView_13) {
        this.f7632y = OplusGLSurfaceView_13;
        this.f7621n.setTint(this.f7632y);
    }

    public void setKeyboardLineColor(int OplusGLSurfaceView_13) {
        this.f7633z = OplusGLSurfaceView_13;
        m7329a();
    }

    public void setCircleMaxAlpha(int OplusGLSurfaceView_13) {
        this.f7609b = OplusGLSurfaceView_13;
        m7344b();
    }

    public void setWordTextNormalColor(int OplusGLSurfaceView_13) {
        this.f7607a.f7646c = OplusGLSurfaceView_13;
    }
}
