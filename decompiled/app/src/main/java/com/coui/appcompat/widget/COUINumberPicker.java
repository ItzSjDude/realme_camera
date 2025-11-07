package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIMathUtils;
import com.coui.appcompat.p099a.COUISoundLoadUtil;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUINumberPicker extends LinearLayout {

    /* renamed from: A */
    private InterfaceC1407c f7473A;

    /* renamed from: B */
    private long f7474B;

    /* renamed from: C */
    private int[] f7475C;

    /* renamed from: D */
    private int f7476D;

    /* renamed from: E */
    private int f7477E;

    /* renamed from: F */
    private int f7478F;

    /* renamed from: G */
    private int f7479G;

    /* renamed from: H */
    private RunnableC1406b f7480H;

    /* renamed from: I */
    private float f7481I;

    /* renamed from: J */
    private long f7482J;

    /* renamed from: K */
    private float f7483K;

    /* renamed from: L */
    private VelocityTracker f7484L;

    /* renamed from: M */
    private int f7485M;

    /* renamed from: N */
    private int f7486N;

    /* renamed from: O */
    private int f7487O;

    /* renamed from: P */
    private int f7488P;

    /* renamed from: Q */
    private boolean f7489Q;

    /* renamed from: R */
    private int f7490R;

    /* renamed from: S */
    private int f7491S;

    /* renamed from: T */
    private int f7492T;

    /* renamed from: U */
    private boolean f7493U;

    /* renamed from: V */
    private boolean f7494V;

    /* renamed from: W */
    private C1405a f7495W;

    /* renamed from: PlatformImplementations.kt_3 */
    int f7496a;

    /* renamed from: aA */
    private float f7497aA;

    /* renamed from: aB */
    private float f7498aB;

    /* renamed from: aC */
    private String f7499aC;

    /* renamed from: aD */
    private String f7500aD;

    /* renamed from: aE */
    private boolean f7501aE;

    /* renamed from: aF */
    private boolean f7502aF;

    /* renamed from: aG */
    private float f7503aG;

    /* renamed from: aH */
    private float f7504aH;

    /* renamed from: aI */
    private float f7505aI;

    /* renamed from: aJ */
    private int f7506aJ;

    /* renamed from: aK */
    private int f7507aK;

    /* renamed from: aL */
    private int f7508aL;

    /* renamed from: aM */
    private int f7509aM;

    /* renamed from: aN */
    private int f7510aN;

    /* renamed from: aO */
    private int f7511aO;

    /* renamed from: aP */
    private int f7512aP;

    /* renamed from: aQ */
    private int f7513aQ;

    /* renamed from: aR */
    private boolean f7514aR;

    /* renamed from: aS */
    private Paint f7515aS;

    /* renamed from: aa */
    private int f7516aa;

    /* renamed from: ab */
    private AccessibilityManager f7517ab;

    /* renamed from: ac */
    private COUISoundLoadUtil f7518ac;

    /* renamed from: ad */
    private HandlerThread f7519ad;

    /* renamed from: ae */
    private Handler f7520ae;

    /* renamed from: af */
    private long f7521af;

    /* renamed from: ag */
    private int f7522ag;

    /* renamed from: ah */
    private int f7523ah;

    /* renamed from: ai */
    private int f7524ai;

    /* renamed from: aj */
    private int f7525aj;

    /* renamed from: ak */
    private int f7526ak;

    /* renamed from: al */
    private int f7527al;

    /* renamed from: am */
    private int f7528am;

    /* renamed from: an */
    private int f7529an;

    /* renamed from: ao */
    private int f7530ao;

    /* renamed from: ap */
    private int f7531ap;

    /* renamed from: aq */
    private int f7532aq;

    /* renamed from: ar */
    private int f7533ar;

    /* renamed from: as */
    private int f7534as;

    /* renamed from: at */
    private int f7535at;

    /* renamed from: au */
    private int f7536au;

    /* renamed from: av */
    private int f7537av;

    /* renamed from: aw */
    private int f7538aw;

    /* renamed from: ax */
    private int f7539ax;

    /* renamed from: ay */
    private int f7540ay;

    /* renamed from: az */
    private int f7541az;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f7542b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f7543c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f7544d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f7545e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f7546f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f7547g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final SparseArray<String> f7548h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Paint f7549i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final Paint f7550j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Paint f7551k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final Scroller f7552l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final Scroller f7553m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final RunnableC1411g f7554n;

    /* renamed from: o */
    private int f7555o;

    /* renamed from: p */
    private int f7556p;

    /* renamed from: q */
    private String[] f7557q;

    /* renamed from: r */
    private int f7558r;

    /* renamed from: s */
    private int f7559s;

    /* renamed from: t */
    private int f7560t;

    /* renamed from: u */
    private InterfaceC1410f f7561u;

    /* renamed from: v */
    private InterfaceC1409e f7562v;

    /* renamed from: w */
    private InterfaceC1408d f7563w;

    /* renamed from: x */
    private C1413i f7564x;

    /* renamed from: y */
    private boolean f7565y;

    /* renamed from: z */
    private boolean f7566z;

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1407c {
        /* renamed from: PlatformImplementations.kt_3 */
        String mo7062a(int OplusGLSurfaceView_13);
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$IntrinsicsJvm.kt_5 */
    public interface InterfaceC1408d {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7316a(COUINumberPicker cOUINumberPicker, int OplusGLSurfaceView_13);
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$COUIBaseListPopupWindow_8 */
    public interface InterfaceC1409e {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7317a();
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$COUIBaseListPopupWindow_12 */
    public interface InterfaceC1410f {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7059a(COUINumberPicker cOUINumberPicker, int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7247a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return i2 - ((int) (((i2 - OplusGLSurfaceView_13) * 2) * COUIBaseListPopupWindow_12));
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public COUINumberPicker(Context context) {
        this(context, null);
    }

    public COUINumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiNumberPickerStyle);
    }

    public COUINumberPicker(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUINumberPicker(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f7548h = new SparseArray<>();
        this.f7565y = true;
        this.f7474B = 300L;
        this.f7477E = Integer.MIN_VALUE;
        this.f7488P = 0;
        this.f7516aa = -1;
        this.f7514aR = false;
        COUIDarkModeUtil.m6400a(this, false);
        this.f7517ab = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f7518ac = COUISoundLoadUtil.m6460a();
        this.f7525aj = this.f7518ac.m6463a(context, R.raw.coui_numberpicker_click);
        if (attributeSet != null) {
            this.f7496a = attributeSet.getStyleAttribute();
        }
        if (this.f7496a == 0) {
            this.f7496a = OplusGLSurfaceView_13;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUINumberPicker, OplusGLSurfaceView_13, 0);
        this.f7523ah = typedArrayObtainStyledAttributes.getInteger(R.styleable.COUINumberPicker_couiPickerRowNumber, 5);
        int i5 = this.f7523ah;
        this.f7524ai = i5 / 2;
        this.f7475C = new int[i5];
        this.f7544d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_internalMinHeight, -1);
        this.f7545e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_internalMaxHeight, -1);
        int i6 = this.f7544d;
        if (i6 != -1 && (i4 = this.f7545e) != -1 && i6 > i4) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.f7546f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_internalMinWidth, -1);
        this.f7555o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_internalMaxWidth, -1);
        int i7 = this.f7546f;
        if (i7 != -1 && (i3 = this.f7555o) != -1 && i7 > i3) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.f7537av = typedArrayObtainStyledAttributes.getInteger(R.styleable.COUINumberPicker_couiPickerAlignPosition, -1);
        this.f7538aw = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_focusTextSize, -1);
        this.f7547g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_startTextSize, -1);
        this.f7536au = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_couiPickerVisualWidth, -1);
        this.f7540ay = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_couiNOPickerPaddingLeft, 0);
        this.f7541az = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUINumberPicker_couiNOPickerPaddingRight, 0);
        this.f7542b = typedArrayObtainStyledAttributes.getColor(R.styleable.COUINumberPicker_couiNormalTextColor, -1);
        this.f7543c = typedArrayObtainStyledAttributes.getColor(R.styleable.COUINumberPicker_couiFocusTextColor, -1);
        this.f7506aJ = typedArrayObtainStyledAttributes.getColor(R.styleable.COUINumberPicker_couiPickerBackgroundColor, -1);
        this.f7522ag = typedArrayObtainStyledAttributes.getInt(R.styleable.COUINumberPicker_couiPickerTouchEffectInterval, 100);
        m7304b(this.f7542b, this.f7543c);
        typedArrayObtainStyledAttributes.recycle();
        this.f7503aG = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_width);
        this.f7504aH = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_height);
        this.f7505aI = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_spacing);
        this.f7510aN = getResources().getDimensionPixelOffset(R.dimen.coui_number_picker_unit_min_width);
        this.f7539ax = getResources().getDimensionPixelSize(R.dimen.coui_numberpicker_unit_textSize);
        this.f7511aO = getResources().getDimensionPixelOffset(R.dimen.coui_number_picker_text_width);
        this.f7513aQ = getResources().getDimensionPixelOffset(R.dimen.coui_number_picker_text_margin_start);
        this.f7512aP = ((this.f7546f - this.f7511aO) - this.f7510aN) - (this.f7513aQ * 2);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7485M = viewConfiguration.getScaledTouchSlop();
        this.f7486N = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7487O = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint = new Paint();
        paint.setTextSize(this.f7547g);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        paint.setTypeface(Typeface.create("sys-sans-en", 0));
        this.f7497aA = fontMetrics.top;
        this.f7498aB = fontMetrics.bottom;
        this.f7549i = paint;
        this.f7551k = paint;
        this.f7551k.setTextSize(getResources().getDimensionPixelSize(R.dimen.coui_numberpicker_textSize_big));
        this.f7552l = new Scroller(getContext(), null, true);
        this.f7553m = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f7554n = new RunnableC1411g();
        setWillNotDraw(false);
        setVerticalScrollBarEnabled(false);
        this.f7550j = new Paint();
        this.f7550j.setAntiAlias(true);
        this.f7550j.setTextSize(this.f7539ax);
        this.f7550j.setColor(this.f7543c);
        this.f7507aK = context.getResources().getDimensionPixelOffset(R.dimen.coui_selected_background_radius);
        this.f7508aL = context.getResources().getDimensionPixelOffset(R.dimen.coui_selected_background_horizontal_padding);
        this.f7509aM = context.getResources().getDimensionPixelOffset(R.dimen.coui_selected_background_horizontal_padding);
        this.f7515aS = new Paint();
        this.f7515aS.setColor(this.f7506aJ);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m7251a(int OplusGLSurfaceView_13) {
        return String.format(Locale.getDefault(), "%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (z) {
            m7282g();
            m7285h();
        }
        m7293l();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int iM7265c = m7265c(OplusGLSurfaceView_13, this.f7555o);
        super.onMeasure(iM7265c, m7265c(i2, this.f7545e));
        if (View.MeasureSpec.getMode(iM7265c) != Integer.MIN_VALUE) {
            this.f7512aP = (getMeasuredWidth() - this.f7511aO) / 2;
        }
        setMeasuredDimension(m7248a(this.f7546f, getMeasuredWidth(), OplusGLSurfaceView_13) + this.f7541az + this.f7540ay, m7248a(this.f7544d, getMeasuredHeight(), i2));
    }

    public void setNumberPickerPaddingLeft(int OplusGLSurfaceView_13) {
        this.f7540ay = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getNumberPickerPaddingLeft() {
        return this.f7540ay;
    }

    public void setNumberPickerPaddingRight(int OplusGLSurfaceView_13) {
        this.f7541az = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getNumberPickerPaddingRight() {
        return this.f7541az;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7301a() {
        this.f7540ay = 0;
        this.f7541az = 0;
        requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7256a(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int OplusGLSurfaceView_13 = this.f7477E - ((this.f7478F + finalY) % this.f7476D);
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int iAbs = Math.abs(OplusGLSurfaceView_13);
        int i2 = this.f7476D;
        if (iAbs > i2 / 2) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 > 0 ? OplusGLSurfaceView_13 - i2 : OplusGLSurfaceView_13 + i2;
        }
        scrollBy(0, finalY + OplusGLSurfaceView_13);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        m7289j();
        float y = motionEvent.getY();
        this.f7481I = y;
        this.f7483K = y;
        this.f7482J = motionEvent.getEventTime();
        this.f7489Q = false;
        float COUIBaseListPopupWindow_12 = this.f7481I;
        if (COUIBaseListPopupWindow_12 < this.f7490R) {
            if (this.f7488P == 0) {
                this.f7554n.m7319a(2);
            }
        } else if (COUIBaseListPopupWindow_12 > this.f7491S && this.f7488P == 0) {
            this.f7554n.m7319a(1);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.f7552l.isFinished()) {
            this.f7552l.forceFinished(true);
            this.f7553m.forceFinished(true);
            m7267c(0);
        } else if (!this.f7553m.isFinished()) {
            this.f7552l.forceFinished(true);
            this.f7553m.forceFinished(true);
        } else {
            float f2 = this.f7481I;
            if (f2 < this.f7490R) {
                m7254a(false, ViewConfiguration.getLongPressTimeout());
            } else if (f2 > this.f7491S) {
                m7254a(true, ViewConfiguration.getLongPressTimeout());
            } else {
                this.f7489Q = true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f7484L == null) {
            this.f7484L = VelocityTracker.obtain();
        }
        this.f7484L.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            m7286i();
            this.f7554n.m7318a();
            VelocityTracker velocityTracker = this.f7484L;
            velocityTracker.computeCurrentVelocity(1000, this.f7487O);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.f7486N) {
                m7273d(yVelocity * 2);
                m7267c(2);
            } else {
                int y = (int) motionEvent.getY();
                int iAbs = (int) Math.abs(y - this.f7481I);
                long eventTime = motionEvent.getEventTime() - this.f7482J;
                if (iAbs <= this.f7485M && eventTime < ViewConfiguration.getTapTimeout()) {
                    if (this.f7489Q) {
                        this.f7489Q = false;
                        performClick();
                    } else {
                        int OplusGLSurfaceView_13 = (y / this.f7476D) - this.f7524ai;
                        if (OplusGLSurfaceView_13 > 0) {
                            m7253a(true);
                            this.f7554n.m7320b(1);
                        } else if (OplusGLSurfaceView_13 < 0) {
                            m7253a(false);
                            this.f7554n.m7320b(2);
                        }
                        m7291k();
                    }
                } else {
                    m7291k();
                }
                m7267c(0);
            }
            this.f7484L.recycle();
            this.f7484L = null;
        } else if (actionMasked == 2) {
            float y2 = motionEvent.getY();
            if (this.f7488P != 1) {
                if (((int) Math.abs(y2 - this.f7481I)) > this.f7485M) {
                    m7289j();
                    m7267c(1);
                }
            } else {
                scrollBy(0, (int) (y2 - this.f7483K));
                invalidate();
            }
            this.f7483K = y2;
        } else if (actionMasked == 3) {
            m7291k();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            m7289j();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (!this.f7566z) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.f7516aa = keyCode;
                m7289j();
                if (this.f7552l.isFinished()) {
                    m7253a(keyCode == 20);
                }
                return true;
            }
            if (action == 1 && this.f7516aa == keyCode) {
                this.f7516aa = -1;
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            m7289j();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            m7289j();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int OplusGLSurfaceView_13;
        if (!this.f7517ab.isEnabled()) {
            return false;
        }
        int y = (int) motionEvent.getY();
        if (y < this.f7490R) {
            OplusGLSurfaceView_13 = 3;
        } else {
            OplusGLSurfaceView_13 = y > this.f7491S ? 1 : 2;
        }
        int actionMasked = motionEvent.getActionMasked();
        C1405a c1405a = (C1405a) getAccessibilityNodeProvider();
        if (actionMasked == 7) {
            int i2 = this.f7492T;
            if (i2 == OplusGLSurfaceView_13 || i2 == -1) {
                return false;
            }
            c1405a.m7313a(i2, 256);
            c1405a.m7313a(OplusGLSurfaceView_13, 128);
            this.f7492T = OplusGLSurfaceView_13;
            c1405a.performAction(OplusGLSurfaceView_13, 64, null);
            return false;
        }
        if (actionMasked == 9) {
            c1405a.m7313a(OplusGLSurfaceView_13, 128);
            this.f7492T = OplusGLSurfaceView_13;
            c1405a.performAction(OplusGLSurfaceView_13, 64, null);
            return false;
        }
        if (actionMasked != 10) {
            return false;
        }
        c1405a.m7313a(OplusGLSurfaceView_13, 256);
        this.f7492T = -1;
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.f7552l;
        if (scroller.isFinished()) {
            scroller = this.f7553m;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.f7479G == 0) {
            this.f7479G = scroller.getStartY();
        }
        scrollBy(0, currY - this.f7479G);
        this.f7479G = currY;
        if (scroller.isFinished()) {
            m7262b(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int OplusGLSurfaceView_13, int i2) {
        int i3;
        int[] iArr = this.f7475C;
        int i4 = this.f7478F;
        if (!this.f7566z && i2 > 0 && iArr[this.f7524ai] <= this.f7558r) {
            this.f7478F = this.f7477E;
            return;
        }
        if (!this.f7566z && i2 < 0 && iArr[this.f7524ai] >= this.f7559s) {
            this.f7478F = this.f7477E;
            return;
        }
        this.f7478F += i2;
        while (true) {
            int i5 = this.f7478F;
            if (i5 - this.f7477E <= this.f7556p + (this.f7509aM / 2)) {
                break;
            }
            this.f7478F = i5 - this.f7476D;
            m7263b(iArr);
            m7252a(iArr[this.f7524ai], true);
            if (!this.f7566z && iArr[this.f7524ai] <= this.f7558r) {
                this.f7478F = this.f7477E;
            }
        }
        while (true) {
            i3 = this.f7478F;
            if (i3 - this.f7477E >= (-this.f7556p) - (this.f7509aM / 2)) {
                break;
            }
            this.f7478F = i3 + this.f7476D;
            m7255a(iArr);
            m7252a(iArr[this.f7524ai], true);
            if (!this.f7566z && iArr[this.f7524ai] >= this.f7559s) {
                this.f7478F = this.f7477E;
            }
        }
        if (i4 != i3) {
            onScrollChanged(0, i3, 0, i4);
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return this.f7478F;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return ((this.f7559s - this.f7558r) + 1) * this.f7476D;
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    public void setOnValueChangedListener(InterfaceC1410f interfaceC1410f) {
        this.f7561u = interfaceC1410f;
    }

    public void setOnScrollingStopListener(InterfaceC1409e interfaceC1409e) {
        this.f7562v = interfaceC1409e;
    }

    public void setOnScrollListener(InterfaceC1408d interfaceC1408d) {
        this.f7563w = interfaceC1408d;
    }

    public void setFormatter(InterfaceC1407c interfaceC1407c) {
        if (interfaceC1407c == this.f7473A) {
            return;
        }
        this.f7473A = interfaceC1407c;
        m7272d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7303b() {
        if (this.f7564x == null) {
            this.f7564x = new C1413i();
        }
        this.f7473A = this.f7564x;
    }

    public void setOnLongPressUpdateInterval(long OplusGLSurfaceView_15) {
        this.f7474B = OplusGLSurfaceView_15;
    }

    public int getValue() {
        return this.f7560t;
    }

    public void setValue(int OplusGLSurfaceView_13) {
        m7252a(OplusGLSurfaceView_13, false);
    }

    public void setUnitText(String str) {
        this.f7500aD = str;
    }

    public void setSelectedValueWidth(int OplusGLSurfaceView_13) {
        this.f7511aO = OplusGLSurfaceView_13;
    }

    public int getMinValue() {
        return this.f7558r;
    }

    public void setMinValue(int OplusGLSurfaceView_13) {
        if (this.f7558r == OplusGLSurfaceView_13) {
            return;
        }
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.f7558r = OplusGLSurfaceView_13;
        int i2 = this.f7558r;
        if (i2 > this.f7560t) {
            this.f7560t = i2;
        }
        m7272d();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7302a(int OplusGLSurfaceView_13, int i2) {
        m7304b(OplusGLSurfaceView_13, i2);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7266c() {
        this.f7566z = (this.f7559s - this.f7558r >= this.f7475C.length) && this.f7565y;
    }

    public boolean getWrapSelectorWheel() {
        return this.f7566z;
    }

    public void setWrapSelectorWheel(boolean z) {
        this.f7565y = z;
        m7266c();
    }

    public int getMaxValue() {
        return this.f7559s;
    }

    public void setMaxValue(int OplusGLSurfaceView_13) {
        if (this.f7559s == OplusGLSurfaceView_13) {
            return;
        }
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f7559s = OplusGLSurfaceView_13;
        int i2 = this.f7559s;
        if (i2 < this.f7560t) {
            this.f7560t = i2;
        }
        m7272d();
        invalidate();
    }

    public String[] getDisplayedValues() {
        return this.f7557q;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f7557q == strArr) {
            return;
        }
        this.f7557q = strArr;
        m7272d();
    }

    public void setPickerRowNumber(int OplusGLSurfaceView_13) {
        this.f7523ah = OplusGLSurfaceView_13;
        this.f7524ai = OplusGLSurfaceView_13 / 2;
        this.f7475C = new int[this.f7523ah];
    }

    public void setAlignPosition(int OplusGLSurfaceView_13) {
        this.f7537av = OplusGLSurfaceView_13;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7519ad = new HandlerThread("touchEffect", -16);
        this.f7519ad.start();
        this.f7520ae = new HandlerC1412h(this.f7519ad.getLooper());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7289j();
        HandlerThread handlerThread = this.f7519ad;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f7519ad = null;
        }
        Handler handler = this.f7520ae;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int iM7247a;
        int iM7247a2;
        int iM7247a3;
        int iM7247a4;
        int OplusGLSurfaceView_13;
        int i2;
        if (this.f7514aR) {
            int i3 = this.f7507aK;
            canvas.drawRoundRect(this.f7508aL, (getHeight() / 2.0f) - this.f7507aK, getWidth() - this.f7508aL, (getHeight() / 2.0f) + i3, i3, i3, this.f7515aS);
        }
        float right = (((getRight() - getLeft()) - this.f7540ay) - this.f7541az) / 2;
        if (this.f7500aD != null) {
            right = this.f7512aP + (this.f7511aO / 2);
            if (isLayoutRtl()) {
                right = ((getMeasuredWidth() - right) - this.f7541az) - this.f7540ay;
            }
        }
        int i4 = this.f7478F;
        int i5 = this.f7536au;
        boolean z = true;
        if (i5 != -1 && i5 < getRight() - getLeft()) {
            int i6 = this.f7537av;
            if (i6 == 1) {
                i2 = this.f7536au / 2;
            } else if (i6 == 2) {
                int right2 = getRight() - getLeft();
                int i7 = this.f7536au;
                i2 = (right2 - i7) + (i7 / 2);
            }
            right = i2;
        }
        int i8 = this.f7540ay;
        if (i8 != 0) {
            right += i8;
        }
        float COUIBaseListPopupWindow_12 = right;
        int[] iArr = this.f7475C;
        float f2 = 0.0f;
        int i9 = i4;
        int i10 = 0;
        while (i10 < iArr.length) {
            int i11 = iArr[i10];
            if (i9 > this.f7526ak && i9 < this.f7527al) {
                float fM7259b = m7259b(i9);
                iM7247a = m7247a(this.f7528am, this.f7532aq, fM7259b);
                iM7247a2 = m7247a(this.f7529an, this.f7533ar, fM7259b);
                iM7247a3 = m7247a(this.f7530ao, this.f7534as, fM7259b);
                iM7247a4 = m7247a(this.f7531ap, this.f7535at, fM7259b);
            } else {
                iM7247a = this.f7528am;
                iM7247a2 = this.f7529an;
                iM7247a3 = this.f7530ao;
                iM7247a4 = this.f7531ap;
            }
            int iArgb = Color.argb(iM7247a, iM7247a2, iM7247a3, iM7247a4);
            int i12 = this.f7547g;
            float fM7246a = m7246a(i12, this.f7538aw, i12, i12, i9);
            this.f7549i.setColor(iArgb);
            String str = this.f7548h.get(i11);
            if (!this.f7502aF) {
                this.f7549i.setTextSize(fM7246a);
                if (this.f7551k.measureText(str) >= getMeasuredWidth()) {
                    this.f7549i.setTextSize(this.f7547g);
                    this.f7502aF = z;
                }
            }
            if (i11 != Integer.MIN_VALUE) {
                Paint.FontMetrics fontMetrics = this.f7549i.getFontMetrics();
                if (i10 == this.f7524ai) {
                    OplusGLSurfaceView_13 = (int) ((((((i9 + i9) + this.f7476D) - fontMetrics.top) - fontMetrics.bottom) / 2.0f) + (this.f7509aM / 2));
                } else {
                    OplusGLSurfaceView_13 = (int) ((((((i9 + i9) + this.f7476D) - this.f7497aA) - this.f7498aB) / 2.0f) + (this.f7509aM / 2));
                }
                this.f7550j.setTextSize(this.f7547g);
                Paint.FontMetrics fontMetrics2 = this.f7550j.getFontMetrics();
                float f3 = (int) ((((this.f7476D - fontMetrics2.top) - fontMetrics2.bottom) / 2.0f) + (this.f7509aM / 2) + this.f7476D);
                canvas.drawText(str, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, this.f7549i);
                f2 = f3;
            } else {
                float f4 = fM7246a / this.f7538aw;
                for (float f5 = -0.5f; f5 < 1.0f; f5 += 1.0f) {
                    float f6 = this.f7503aG;
                    float f7 = (this.f7505aI + f6) * f5 * f4;
                    float f8 = this.f7504aH * f4;
                    float f9 = f7 + COUIBaseListPopupWindow_12;
                    float f10 = (f6 * f4) / 2.0f;
                    float f11 = i9;
                    int i13 = this.f7476D;
                    float f12 = f8 / 2.0f;
                    canvas.drawRect(f9 - f10, (((i13 / 2.0f) + f11) - f12) + 33.75f, f9 + f10, f11 + (i13 / 2.0f) + f12 + 33.75f, this.f7549i);
                }
            }
            i9 += this.f7476D;
            i10++;
            z = true;
        }
        if (this.f7500aD != null) {
            if (isLayoutRtl()) {
                COUIBaseListPopupWindow_12 = (COUIBaseListPopupWindow_12 + this.f7541az) - this.f7540ay;
            }
            float measuredWidth = COUIBaseListPopupWindow_12 + (this.f7511aO / 2) + this.f7513aQ;
            if (isLayoutRtl()) {
                measuredWidth = (getMeasuredWidth() - measuredWidth) - this.f7550j.measureText(this.f7500aD);
            }
            this.f7550j.setTextSize(this.f7539ax);
            canvas.drawText(this.f7500aD, measuredWidth, f2, this.f7550j);
        }
    }

    public boolean isLayoutRtl() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public void setHasBackground(boolean z) {
        this.f7514aR = z;
    }

    public int getBackgroundColor() {
        return this.f7506aJ;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m7259b(int OplusGLSurfaceView_13) {
        return Math.abs((OplusGLSurfaceView_13 - this.f7477E) - (this.f7524ai * this.f7476D)) / this.f7476D;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m7246a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        int i6;
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        int i7 = this.f7477E;
        int i8 = this.f7524ai;
        int i9 = this.f7476D;
        int i10 = (i8 * i9) + i7;
        int length = ((this.f7475C.length - 1) * i9) + i7;
        double IntrinsicsJvm.kt_5 = i5;
        double d2 = i10;
        if (IntrinsicsJvm.kt_5 > d2 - (i9 * 0.5d)) {
            i6 = length;
            if (IntrinsicsJvm.kt_5 < d2 + (i9 * 0.5d)) {
                return i2 - ((((i2 - OplusGLSurfaceView_13) * 2.0f) * Math.abs(i5 - i10)) / this.f7476D);
            }
        } else {
            i6 = length;
        }
        int i11 = this.f7476D;
        if (i5 <= i10 - i11) {
            COUIBaseListPopupWindow_12 = i3;
            f2 = (i4 - i3) * 1.0f;
            f3 = i5 - i7;
        } else {
            if (i5 < i10 + i11) {
                return i4;
            }
            COUIBaseListPopupWindow_12 = i3;
            f2 = (i4 - i3) * 1.0f;
            f3 = i6 - i5;
        }
        return COUIBaseListPopupWindow_12 + (((f2 * f3) / i11) / 2.0f);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.f7495W == null) {
            this.f7495W = new C1405a();
        }
        return this.f7495W;
    }

    public float getTextSize() {
        return this.f7549i.getTextSize();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m7265c(int OplusGLSurfaceView_13, int i2) {
        if (i2 == -1) {
            return OplusGLSurfaceView_13;
        }
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            }
            if (mode == 1073741824) {
                return OplusGLSurfaceView_13;
            }
            throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
        String str = this.f7500aD;
        if (str != null) {
            float fMeasureText = this.f7550j.measureText(str);
            int iMeasureText = this.f7510aN;
            if (fMeasureText > iMeasureText) {
                iMeasureText = (int) this.f7550j.measureText(this.f7500aD);
            }
            int i3 = this.f7512aP;
            size = iMeasureText + (i3 - this.f7510aN) + i3 + this.f7511aO;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7248a(int OplusGLSurfaceView_13, int i2, int i3) {
        return OplusGLSurfaceView_13 != -1 ? resolveSizeAndState(Math.max(OplusGLSurfaceView_13, i2), i3, 0) : i2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7272d() {
        this.f7548h.clear();
        int[] iArr = this.f7475C;
        int value = getValue();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f7475C.length; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 - this.f7524ai;
            int iM7270d = this.f7501aE ? m7270d(value, i2) : i2 + value;
            if (this.f7566z) {
                iM7270d = m7274e(iM7270d);
            }
            iArr[OplusGLSurfaceView_13] = iM7270d;
            m7280f(iArr[OplusGLSurfaceView_13]);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7252a(int OplusGLSurfaceView_13, boolean z) {
        int iMin;
        if (this.f7560t == OplusGLSurfaceView_13) {
            m7272d();
            return;
        }
        if (this.f7566z) {
            iMin = m7274e(OplusGLSurfaceView_13);
        } else {
            iMin = Math.min(Math.max(OplusGLSurfaceView_13, this.f7558r), this.f7559s);
        }
        int i2 = this.f7560t;
        this.f7560t = iMin;
        if (z) {
            m7277e(i2, iMin);
            this.f7520ae.removeMessages(0);
            this.f7520ae.sendEmptyMessage(0);
            AccessibilityManager accessibilityManager = this.f7517ab;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Message message = new Message();
                message.what = 1;
                message.obj = Integer.valueOf(iMin);
                this.f7520ae.sendMessage(message);
            }
        }
        m7272d();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m7276e() {
        this.f7518ac.m6464a(getContext(), this.f7525aj, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m7279f() {
        if (performHapticFeedback(308)) {
            return;
        }
        performHapticFeedback(302);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7253a(boolean z) {
        if (!m7256a(this.f7552l)) {
            m7256a(this.f7553m);
        }
        this.f7479G = 0;
        if (z) {
            this.f7552l.startScroll(0, 0, 0, -this.f7476D, 300);
        } else {
            this.f7552l.startScroll(0, 0, 0, this.f7476D, 300);
        }
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7282g() {
        m7272d();
        int[] iArr = this.f7475C;
        this.f7556p = (int) (((((getBottom() - getTop()) - (iArr.length * this.f7547g)) - this.f7509aM) / iArr.length) + 0.5f);
        this.f7476D = this.f7547g + this.f7556p;
        this.f7477E = 0;
        this.f7478F = 0;
        this.f7490R = (getHeight() / 2) - (this.f7476D / 2);
        this.f7491S = (getHeight() / 2) + (this.f7476D / 2);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m7285h() {
        setVerticalFadingEdgeEnabled(false);
        setFadingEdgeLength(((getBottom() - getTop()) - this.f7547g) / 2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7262b(Scroller scroller) {
        if (scroller == this.f7552l) {
            m7291k();
            m7267c(0);
        } else {
            int OplusGLSurfaceView_13 = this.f7488P;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7267c(int OplusGLSurfaceView_13) {
        if (this.f7488P == OplusGLSurfaceView_13) {
            return;
        }
        this.f7488P = OplusGLSurfaceView_13;
        InterfaceC1408d interfaceC1408d = this.f7563w;
        if (interfaceC1408d != null) {
            interfaceC1408d.m7316a(this, OplusGLSurfaceView_13);
        }
        if (this.f7488P == 0) {
            announceForAccessibility(this.f7548h.get(getValue()));
            InterfaceC1409e interfaceC1409e = this.f7562v;
            if (interfaceC1409e != null) {
                interfaceC1409e.m7317a();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7273d(int OplusGLSurfaceView_13) {
        this.f7479G = 0;
        if (OplusGLSurfaceView_13 > 0) {
            this.f7552l.fling(0, 0, 0, OplusGLSurfaceView_13, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.f7552l.fling(0, Integer.MAX_VALUE, 0, OplusGLSurfaceView_13, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m7274e(int OplusGLSurfaceView_13) {
        return m7270d(OplusGLSurfaceView_13, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m7270d(int OplusGLSurfaceView_13, int i2) {
        int i3 = this.f7559s;
        int i4 = this.f7558r;
        if (i3 - i4 <= 0) {
            return -1;
        }
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            OplusGLSurfaceView_13 = i4 - 1;
        }
        int i5 = this.f7559s;
        int i6 = this.f7558r;
        int iM6429a = COUIMathUtils.m6429a((OplusGLSurfaceView_13 - i6) + i2, (i5 - i6) + 1 + (this.f7501aE ? 1 : 0));
        int i7 = this.f7559s;
        int i8 = this.f7558r;
        if (iM6429a < (i7 - i8) + 1) {
            return i8 + iM6429a;
        }
        return Integer.MIN_VALUE;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7255a(int[] iArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            iArr[OplusGLSurfaceView_13] = m7270d(iArr[OplusGLSurfaceView_13], 1);
        }
        m7280f(iArr[iArr.length - 1]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7263b(int[] iArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            iArr[OplusGLSurfaceView_13] = m7270d(iArr[OplusGLSurfaceView_13], -1);
        }
        m7280f(iArr[0]);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7280f(int OplusGLSurfaceView_13) {
        String strM7281g;
        SparseArray<String> sparseArray = this.f7548h;
        if (sparseArray.get(OplusGLSurfaceView_13) != null) {
            return;
        }
        int i2 = this.f7558r;
        if (OplusGLSurfaceView_13 < i2 || OplusGLSurfaceView_13 > this.f7559s) {
            strM7281g = "";
        } else {
            String[] strArr = this.f7557q;
            if (strArr != null) {
                strM7281g = strArr[OplusGLSurfaceView_13 - i2];
            } else {
                strM7281g = m7281g(OplusGLSurfaceView_13);
            }
        }
        sparseArray.put(OplusGLSurfaceView_13, strM7281g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m7281g(int OplusGLSurfaceView_13) {
        InterfaceC1407c interfaceC1407c = this.f7473A;
        return interfaceC1407c != null ? interfaceC1407c.mo7062a(OplusGLSurfaceView_13) : m7251a(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7277e(int OplusGLSurfaceView_13, int i2) {
        InterfaceC1410f interfaceC1410f = this.f7561u;
        if (interfaceC1410f != null) {
            interfaceC1410f.mo7059a(this, OplusGLSurfaceView_13, this.f7560t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7254a(boolean z, long OplusGLSurfaceView_15) {
        RunnableC1406b runnableC1406b = this.f7480H;
        if (runnableC1406b == null) {
            this.f7480H = new RunnableC1406b();
        } else {
            removeCallbacks(runnableC1406b);
        }
        this.f7480H.m7315a(z);
        postDelayed(this.f7480H, OplusGLSurfaceView_15);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m7286i() {
        RunnableC1406b runnableC1406b = this.f7480H;
        if (runnableC1406b != null) {
            removeCallbacks(runnableC1406b);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7289j() {
        RunnableC1406b runnableC1406b = this.f7480H;
        if (runnableC1406b != null) {
            removeCallbacks(runnableC1406b);
        }
        this.f7554n.m7318a();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m7291k() {
        int OplusGLSurfaceView_13 = this.f7477E - this.f7478F;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        this.f7479G = 0;
        int iAbs = Math.abs(OplusGLSurfaceView_13);
        int i2 = this.f7476D;
        if (iAbs > i2 / 2) {
            if (OplusGLSurfaceView_13 > 0) {
                i2 = -i2;
            }
            OplusGLSurfaceView_13 += i2;
        }
        this.f7553m.startScroll(0, 0, 0, OplusGLSurfaceView_13, 800);
        invalidate();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7304b(int OplusGLSurfaceView_13, int i2) {
        this.f7528am = Color.alpha(OplusGLSurfaceView_13);
        this.f7532aq = Color.alpha(i2);
        this.f7529an = Color.red(OplusGLSurfaceView_13);
        this.f7533ar = Color.red(i2);
        this.f7530ao = Color.green(OplusGLSurfaceView_13);
        this.f7534as = Color.green(i2);
        this.f7531ap = Color.blue(OplusGLSurfaceView_13);
        this.f7535at = Color.blue(i2);
    }

    public void setPickerNormalColor(int OplusGLSurfaceView_13) {
        this.f7528am = Color.alpha(OplusGLSurfaceView_13);
        this.f7529an = Color.red(OplusGLSurfaceView_13);
        this.f7530ao = Color.green(OplusGLSurfaceView_13);
        this.f7531ap = Color.green(OplusGLSurfaceView_13);
    }

    public void setPickerFocusColor(int OplusGLSurfaceView_13) {
        this.f7532aq = Color.alpha(OplusGLSurfaceView_13);
        this.f7533ar = Color.red(OplusGLSurfaceView_13);
        this.f7534as = Color.green(OplusGLSurfaceView_13);
        this.f7535at = Color.green(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m7293l() {
        int OplusGLSurfaceView_13 = this.f7477E;
        int i2 = this.f7476D;
        int i3 = this.f7524ai;
        this.f7526ak = (int) (OplusGLSurfaceView_13 + (i2 * (i3 - 0.5d)));
        this.f7527al = (int) (OplusGLSurfaceView_13 + (i2 * (i3 + 0.5d)));
    }

    public void setIgnorable(boolean z) {
        if (this.f7501aE == z) {
            return;
        }
        this.f7501aE = z;
        m7272d();
        invalidate();
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$COUIBaseListPopupWindow_11 */
    class RunnableC1411g implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f7574b = 1;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f7575c = 2;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f7576d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f7577e;

        RunnableC1411g() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7318a() {
            this.f7577e = 0;
            this.f7576d = 0;
            COUINumberPicker.this.removeCallbacks(this);
            if (COUINumberPicker.this.f7493U) {
                COUINumberPicker.this.f7493U = false;
                COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
                cOUINumberPicker.invalidate(0, cOUINumberPicker.f7491S, COUINumberPicker.this.getRight(), COUINumberPicker.this.getBottom());
            }
            COUINumberPicker.this.f7494V = false;
            if (COUINumberPicker.this.f7494V) {
                COUINumberPicker cOUINumberPicker2 = COUINumberPicker.this;
                cOUINumberPicker2.invalidate(0, 0, cOUINumberPicker2.getRight(), COUINumberPicker.this.f7490R);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7319a(int OplusGLSurfaceView_13) {
            m7318a();
            this.f7577e = 1;
            this.f7576d = OplusGLSurfaceView_13;
            COUINumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7320b(int OplusGLSurfaceView_13) {
            m7318a();
            this.f7577e = 2;
            this.f7576d = OplusGLSurfaceView_13;
            COUINumberPicker.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int OplusGLSurfaceView_13 = this.f7577e;
            if (OplusGLSurfaceView_13 == 1) {
                int i2 = this.f7576d;
                if (i2 == 1) {
                    COUINumberPicker.this.f7493U = true;
                    COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
                    cOUINumberPicker.invalidate(0, cOUINumberPicker.f7491S, COUINumberPicker.this.getRight(), COUINumberPicker.this.getBottom());
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    COUINumberPicker.this.f7494V = true;
                    COUINumberPicker cOUINumberPicker2 = COUINumberPicker.this;
                    cOUINumberPicker2.invalidate(0, 0, cOUINumberPicker2.getRight(), COUINumberPicker.this.f7490R);
                    return;
                }
            }
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            int i3 = this.f7576d;
            if (i3 == 1) {
                if (!COUINumberPicker.this.f7493U) {
                    COUINumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                COUINumberPicker.this.f7493U = !r0.f7493U;
                COUINumberPicker cOUINumberPicker3 = COUINumberPicker.this;
                cOUINumberPicker3.invalidate(0, cOUINumberPicker3.f7491S, COUINumberPicker.this.getRight(), COUINumberPicker.this.getBottom());
                return;
            }
            if (i3 != 2) {
                return;
            }
            if (!COUINumberPicker.this.f7494V) {
                COUINumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            COUINumberPicker.this.f7494V = !r0.f7494V;
            COUINumberPicker cOUINumberPicker4 = COUINumberPicker.this;
            cOUINumberPicker4.invalidate(0, 0, cOUINumberPicker4.getRight(), COUINumberPicker.this.f7490R);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$IntrinsicsJvm.kt_4 */
    class RunnableC1406b implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f7572b;

        RunnableC1406b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m7315a(boolean z) {
            this.f7572b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            COUINumberPicker.this.m7253a(this.f7572b);
            COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
            cOUINumberPicker.postDelayed(this, cOUINumberPicker.f7474B);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$PlatformImplementations.kt_3 */
    class C1405a extends AccessibilityNodeProvider {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Rect f7568b = new Rect();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int[] f7569c = new int[2];

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f7570d = Integer.MIN_VALUE;

        C1405a() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == -1) {
                return m7306a(m7307a(COUINumberPicker.this.f7560t), COUINumberPicker.this.getScrollX(), COUINumberPicker.this.getScrollY(), COUINumberPicker.this.getScrollX() + (COUINumberPicker.this.getRight() - COUINumberPicker.this.getLeft()), COUINumberPicker.this.getScrollY() + (COUINumberPicker.this.getBottom() - COUINumberPicker.this.getTop()));
            }
            if (OplusGLSurfaceView_13 == 1) {
                return m7305a(1, m7307a(COUINumberPicker.this.f7560t + 1), COUINumberPicker.this.getScrollX(), COUINumberPicker.this.f7491S, COUINumberPicker.this.getScrollX() + (COUINumberPicker.this.getRight() - COUINumberPicker.this.getLeft()), COUINumberPicker.this.getScrollY() + (COUINumberPicker.this.getBottom() - COUINumberPicker.this.getTop()));
            }
            if (OplusGLSurfaceView_13 == 2) {
                return m7306a(m7307a(COUINumberPicker.this.f7560t), COUINumberPicker.this.getScrollX(), COUINumberPicker.this.f7490R, COUINumberPicker.this.getScrollX() + (COUINumberPicker.this.getRight() - COUINumberPicker.this.getLeft()), COUINumberPicker.this.f7491S);
            }
            if (OplusGLSurfaceView_13 == 3) {
                return m7305a(3, m7307a(COUINumberPicker.this.f7560t - 1), COUINumberPicker.this.getScrollX(), COUINumberPicker.this.getScrollY(), COUINumberPicker.this.getScrollX() + (COUINumberPicker.this.getRight() - COUINumberPicker.this.getLeft()), COUINumberPicker.this.f7490R);
            }
            return super.createAccessibilityNodeInfo(OplusGLSurfaceView_13);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int OplusGLSurfaceView_13) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (OplusGLSurfaceView_13 == -1) {
                m7310a(lowerCase, 3, arrayList);
                m7310a(lowerCase, 2, arrayList);
                m7310a(lowerCase, 1, arrayList);
                return arrayList;
            }
            if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                m7310a(lowerCase, OplusGLSurfaceView_13, arrayList);
                return arrayList;
            }
            return super.findAccessibilityNodeInfosByText(str, OplusGLSurfaceView_13);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            if (OplusGLSurfaceView_13 != -1) {
                if (OplusGLSurfaceView_13 == 1) {
                    if (i2 == 16) {
                        if (!COUINumberPicker.this.isEnabled()) {
                            return false;
                        }
                        COUINumberPicker.this.m7253a(true);
                        m7313a(OplusGLSurfaceView_13, 1);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.f7570d == OplusGLSurfaceView_13) {
                            return false;
                        }
                        this.f7570d = OplusGLSurfaceView_13;
                        m7313a(OplusGLSurfaceView_13, 32768);
                        COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
                        cOUINumberPicker.invalidate(0, cOUINumberPicker.f7491S, COUINumberPicker.this.getRight(), COUINumberPicker.this.getBottom());
                        return true;
                    }
                    if (i2 != 128 || this.f7570d != OplusGLSurfaceView_13) {
                        return false;
                    }
                    this.f7570d = Integer.MIN_VALUE;
                    m7313a(OplusGLSurfaceView_13, 65536);
                    COUINumberPicker cOUINumberPicker2 = COUINumberPicker.this;
                    cOUINumberPicker2.invalidate(0, cOUINumberPicker2.f7491S, COUINumberPicker.this.getRight(), COUINumberPicker.this.getBottom());
                    return true;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    if (i2 == 16) {
                        if (!COUINumberPicker.this.isEnabled()) {
                            return false;
                        }
                        COUINumberPicker.this.performClick();
                        return true;
                    }
                    if (i2 == 32) {
                        if (!COUINumberPicker.this.isEnabled()) {
                            return false;
                        }
                        COUINumberPicker.this.performLongClick();
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.f7570d == OplusGLSurfaceView_13) {
                            return false;
                        }
                        this.f7570d = OplusGLSurfaceView_13;
                        m7313a(OplusGLSurfaceView_13, 32768);
                        COUINumberPicker cOUINumberPicker3 = COUINumberPicker.this;
                        cOUINumberPicker3.invalidate(0, 0, cOUINumberPicker3.getRight(), COUINumberPicker.this.f7490R);
                        return true;
                    }
                    if (i2 != 128 || this.f7570d != OplusGLSurfaceView_13) {
                        return false;
                    }
                    this.f7570d = Integer.MIN_VALUE;
                    m7313a(OplusGLSurfaceView_13, 65536);
                    return true;
                }
                if (OplusGLSurfaceView_13 == 3) {
                    if (i2 == 16) {
                        if (!COUINumberPicker.this.isEnabled()) {
                            return false;
                        }
                        COUINumberPicker.this.m7253a(OplusGLSurfaceView_13 == 1);
                        m7313a(OplusGLSurfaceView_13, 1);
                        return true;
                    }
                    if (i2 == 64) {
                        if (this.f7570d == OplusGLSurfaceView_13) {
                            return false;
                        }
                        this.f7570d = OplusGLSurfaceView_13;
                        m7313a(OplusGLSurfaceView_13, 32768);
                        COUINumberPicker cOUINumberPicker4 = COUINumberPicker.this;
                        cOUINumberPicker4.invalidate(0, 0, cOUINumberPicker4.getRight(), COUINumberPicker.this.f7490R);
                        return true;
                    }
                    if (i2 != 128 || this.f7570d != OplusGLSurfaceView_13) {
                        return false;
                    }
                    this.f7570d = Integer.MIN_VALUE;
                    m7313a(OplusGLSurfaceView_13, 65536);
                    COUINumberPicker cOUINumberPicker5 = COUINumberPicker.this;
                    cOUINumberPicker5.invalidate(0, 0, cOUINumberPicker5.getRight(), COUINumberPicker.this.f7490R);
                    return true;
                }
            } else {
                if (i2 == 64) {
                    if (this.f7570d == OplusGLSurfaceView_13) {
                        return false;
                    }
                    this.f7570d = OplusGLSurfaceView_13;
                    return true;
                }
                if (i2 == 128) {
                    if (this.f7570d != OplusGLSurfaceView_13) {
                        return false;
                    }
                    this.f7570d = Integer.MIN_VALUE;
                    return true;
                }
                if (i2 == 4096) {
                    if (!COUINumberPicker.this.isEnabled()) {
                        return false;
                    }
                    COUINumberPicker.this.m7253a(true);
                    return true;
                }
                if (i2 == 8192) {
                    if (!COUINumberPicker.this.isEnabled()) {
                        return false;
                    }
                    COUINumberPicker.this.m7253a(false);
                    return true;
                }
            }
            return super.performAction(OplusGLSurfaceView_13, i2, bundle);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7313a(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 == 1) {
                if (m7312b()) {
                    m7308a(OplusGLSurfaceView_13, i2, m7307a(COUINumberPicker.this.f7560t + 1));
                }
            } else if (OplusGLSurfaceView_13 == 2) {
                m7309a(i2, m7307a(COUINumberPicker.this.f7560t));
            } else if (OplusGLSurfaceView_13 == 3 && m7311a()) {
                m7308a(OplusGLSurfaceView_13, i2, m7307a(COUINumberPicker.this.f7560t - 1));
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7310a(String str, int OplusGLSurfaceView_13, List<AccessibilityNodeInfo> list) {
            if (OplusGLSurfaceView_13 == 1) {
                String strM7307a = m7307a(COUINumberPicker.this.f7560t + 1);
                if (TextUtils.isEmpty(strM7307a) || !strM7307a.toString().toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(1));
                return;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            String strM7307a2 = m7307a(COUINumberPicker.this.f7560t - 1);
            if (TextUtils.isEmpty(strM7307a2) || !strM7307a2.toString().toLowerCase().contains(str)) {
                return;
            }
            list.add(createAccessibilityNodeInfo(3));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m7311a() {
            return COUINumberPicker.this.getWrapSelectorWheel() || COUINumberPicker.this.getValue() > COUINumberPicker.this.getMinValue();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m7312b() {
            return COUINumberPicker.this.getWrapSelectorWheel() || COUINumberPicker.this.getValue() < COUINumberPicker.this.getMaxValue();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private String m7307a(int OplusGLSurfaceView_13) {
            if (COUINumberPicker.this.f7566z) {
                OplusGLSurfaceView_13 = COUINumberPicker.this.m7274e(OplusGLSurfaceView_13);
            }
            if (OplusGLSurfaceView_13 <= COUINumberPicker.this.f7559s) {
                return COUINumberPicker.this.f7557q == null ? COUINumberPicker.this.m7281g(OplusGLSurfaceView_13) : COUINumberPicker.this.f7557q[OplusGLSurfaceView_13 - COUINumberPicker.this.f7558r];
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7309a(int OplusGLSurfaceView_13, String str) {
            if (COUINumberPicker.this.f7517ab.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(OplusGLSurfaceView_13);
                accessibilityEventObtain.setPackageName(COUINumberPicker.this.getContext().getPackageName());
                accessibilityEventObtain.getText().add(str);
                accessibilityEventObtain.setEnabled(COUINumberPicker.this.isEnabled());
                accessibilityEventObtain.setSource(COUINumberPicker.this, 2);
                COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
                cOUINumberPicker.requestSendAccessibilityEvent(cOUINumberPicker, accessibilityEventObtain);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7308a(int OplusGLSurfaceView_13, int i2, String str) {
            if (COUINumberPicker.this.f7517ab.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
                accessibilityEventObtain.setPackageName(COUINumberPicker.this.getContext().getPackageName());
                accessibilityEventObtain.getText().add(str);
                accessibilityEventObtain.setEnabled(COUINumberPicker.this.isEnabled());
                accessibilityEventObtain.setSource(COUINumberPicker.this, OplusGLSurfaceView_13);
                COUINumberPicker cOUINumberPicker = COUINumberPicker.this;
                cOUINumberPicker.requestSendAccessibilityEvent(cOUINumberPicker, accessibilityEventObtain);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private AccessibilityNodeInfo m7306a(String str, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setPackageName(COUINumberPicker.this.getContext().getPackageName());
            accessibilityNodeInfoObtain.setParent(COUINumberPicker.this);
            accessibilityNodeInfoObtain.setSource(COUINumberPicker.this);
            if (!TextUtils.isEmpty(COUINumberPicker.this.f7499aC)) {
                str = str + COUINumberPicker.this.f7499aC;
            }
            accessibilityNodeInfoObtain.setText(str);
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setLongClickable(true);
            accessibilityNodeInfoObtain.setEnabled(COUINumberPicker.this.isEnabled());
            accessibilityNodeInfoObtain.setScrollable(true);
            if (this.f7570d != 2) {
                accessibilityNodeInfoObtain.addAction(64);
            }
            if (this.f7570d == 2) {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (COUINumberPicker.this.isEnabled()) {
                accessibilityNodeInfoObtain.addAction(16);
            }
            Rect rect = this.f7568b;
            rect.set(OplusGLSurfaceView_13, i2, i3, i4);
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.f7569c;
            COUINumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            return accessibilityNodeInfoObtain;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private AccessibilityNodeInfo m7305a(int OplusGLSurfaceView_13, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setPackageName(COUINumberPicker.this.getContext().getPackageName());
            accessibilityNodeInfoObtain.setSource(COUINumberPicker.this, OplusGLSurfaceView_13);
            accessibilityNodeInfoObtain.setParent(COUINumberPicker.this);
            if (!TextUtils.isEmpty(COUINumberPicker.this.f7499aC)) {
                str = str + COUINumberPicker.this.f7499aC;
            }
            accessibilityNodeInfoObtain.setText(str);
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setLongClickable(true);
            accessibilityNodeInfoObtain.setEnabled(COUINumberPicker.this.isEnabled());
            Rect rect = this.f7568b;
            rect.set(i2, i3, i4, i5);
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.f7569c;
            COUINumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.f7570d != OplusGLSurfaceView_13) {
                accessibilityNodeInfoObtain.addAction(64);
            }
            if (this.f7570d == OplusGLSurfaceView_13) {
                accessibilityNodeInfoObtain.addAction(128);
            }
            if (COUINumberPicker.this.isEnabled()) {
                accessibilityNodeInfoObtain.addAction(16);
            }
            return accessibilityNodeInfoObtain;
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$OplusGLSurfaceView_13 */
    private class C1413i implements InterfaceC1407c {

        /* renamed from: PlatformImplementations.kt_3 */
        final StringBuilder f7579a = new StringBuilder();

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Object[] f7580b = new Object[1];

        /* renamed from: IntrinsicsJvm.kt_3 */
        Formatter f7581c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        DecimalFormat f7582d;

        C1413i() {
            m7322a(Locale.getDefault());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7322a(Locale locale) {
            this.f7581c = new Formatter(this.f7579a, locale);
            if (Build.VERSION.SDK_INT >= 24) {
                this.f7582d = new DecimalFormat("00");
            }
        }

        @Override // com.coui.appcompat.widget.COUINumberPicker.InterfaceC1407c
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo7062a(int OplusGLSurfaceView_13) {
            this.f7580b[0] = Integer.valueOf(OplusGLSurfaceView_13);
            StringBuilder sb = this.f7579a;
            sb.delete(0, sb.length());
            if (Build.VERSION.SDK_INT >= 24) {
                return this.f7582d.format(OplusGLSurfaceView_13);
            }
            this.f7581c.format("%02d", this.f7580b);
            return this.f7581c.toString();
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUINumberPicker$COUIBaseListPopupWindow_10 */
    private class HandlerC1412h extends Handler {
        HandlerC1412h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    String str = (String) COUINumberPicker.this.f7548h.get(((Integer) message.obj).intValue());
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(COUINumberPicker.this.f7499aC)) {
                        str = str + COUINumberPicker.this.f7499aC;
                    }
                    if (COUINumberPicker.this.f7488P == 0) {
                        COUINumberPicker.this.announceForAccessibility(str);
                        if (COUINumberPicker.this.f7562v != null) {
                            COUINumberPicker.this.f7562v.m7317a();
                        }
                    }
                }
            } else if (m7321a()) {
                COUINumberPicker.this.m7276e();
                COUINumberPicker.this.m7279f();
                COUINumberPicker.this.f7521af = SystemClock.uptimeMillis();
            }
            super.handleMessage(message);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m7321a() {
            return SystemClock.uptimeMillis() - COUINumberPicker.this.f7521af > ((long) COUINumberPicker.this.f7522ag);
        }
    }

    public void setNormalTextColor(int OplusGLSurfaceView_13) {
        if (this.f7542b != OplusGLSurfaceView_13) {
            this.f7542b = OplusGLSurfaceView_13;
            m7302a(this.f7542b, this.f7543c);
        }
    }

    public void setTouchEffectInterval(int OplusGLSurfaceView_13) {
        this.f7522ag = OplusGLSurfaceView_13;
    }

    public int getTouchEffectInterval() {
        return this.f7522ag;
    }
}
