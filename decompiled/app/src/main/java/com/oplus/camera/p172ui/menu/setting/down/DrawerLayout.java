package com.oplus.camera.p172ui.menu.setting.down;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.setting.CameraDrawerSettingMenuPanel;

/* loaded from: classes2.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: A */
    private PathInterpolator f20073A;

    /* renamed from: B */
    private PathInterpolator f20074B;

    /* renamed from: C */
    private ShapeDrawable f20075C;

    /* renamed from: D */
    private ShapeDrawable f20076D;

    /* renamed from: E */
    private long f20077E;

    /* renamed from: F */
    private long f20078F;

    /* renamed from: G */
    private long f20079G;

    /* renamed from: H */
    private float f20080H;

    /* renamed from: I */
    private int f20081I;

    /* renamed from: J */
    private ComboPreferences f20082J;

    /* renamed from: K */
    private int f20083K;

    /* renamed from: L */
    private int f20084L;

    /* renamed from: M */
    private boolean f20085M;

    /* renamed from: N */
    private boolean f20086N;

    /* renamed from: O */
    private float f20087O;

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f20088a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20089b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20090c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20091d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f20092e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f20093f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f20094g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC3323b f20095h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f20096i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f20097j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f20098k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f20099l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f20100m;
    private CameraDrawerSettingMenuPanel mSubSettingView;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f20101n;

    /* renamed from: o */
    private int f20102o;

    /* renamed from: p */
    private C3322a f20103p;

    /* renamed from: q */
    private ValueAnimator f20104q;

    /* renamed from: r */
    private ValueAnimator f20105r;

    /* renamed from: s */
    private ValueAnimator f20106s;

    /* renamed from: t */
    private float f20107t;

    /* renamed from: u */
    private View f20108u;

    /* renamed from: v */
    private View f20109v;

    /* renamed from: w */
    private Rect f20110w;

    /* renamed from: x */
    private Rect f20111x;

    /* renamed from: y */
    private float f20112y;

    /* renamed from: z */
    private PathInterpolator f20113z;

    /* renamed from: com.oplus.camera.ui.menu.setting.down.DrawerLayout$IntrinsicsJvm.kt_4 */
    public interface InterfaceC3323b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo21389a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo21390a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo21391a(boolean z, boolean z2, int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo21392e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo21393f();

        /* renamed from: OplusGLSurfaceView_5 */
        boolean mo21394k();

        /* renamed from: OplusGLSurfaceView_14 */
        void mo21395l();

        /* renamed from: u */
        boolean mo21396u();

        /* renamed from: v */
        void mo21397v();

        /* renamed from: w */
        void mo21398w();
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.down.DrawerLayout$IntrinsicsJvm.kt_3 */
    public interface InterfaceC3324c {
        void setOffset(float COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21378c() {
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20088a = false;
        this.f20089b = 0;
        this.f20090c = 0;
        this.f20091d = 0;
        this.f20092e = 0.0f;
        this.f20093f = 0.0f;
        this.f20094g = false;
        this.f20095h = null;
        this.f20096i = false;
        this.f20097j = false;
        this.f20098k = false;
        this.f20099l = false;
        this.f20100m = true;
        this.f20101n = false;
        this.f20102o = 0;
        this.f20103p = null;
        this.f20104q = null;
        this.f20105r = null;
        this.f20106s = null;
        this.f20107t = 0.0f;
        this.f20108u = null;
        this.mSubSettingView = null;
        this.f20109v = null;
        this.f20110w = null;
        this.f20111x = null;
        this.f20112y = 0.0f;
        this.f20113z = new PathInterpolator(0.4f, 0.0f, 0.3f, 1.0f);
        this.f20073A = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.f20074B = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20075C = null;
        this.f20076D = null;
        this.f20077E = 0L;
        this.f20078F = 0L;
        this.f20079G = -1L;
        this.f20080H = 0.0f;
        this.f20081I = 0;
        this.f20082J = null;
        this.f20083K = 0;
        this.f20084L = 0;
        this.f20085M = false;
        this.f20086N = false;
        this.f20087O = 0.0f;
        InverseManager.INS.registerBackgroundInverse(context, this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f20108u = findViewById(R.id_renamed.oplus_setting_bar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21373a() {
        this.mSubSettingView = (CameraDrawerSettingMenuPanel) findViewById(R.id_renamed.oplus_subsetting_bar);
        this.f20109v = findViewById(R.id_renamed.setting_arrow);
        this.f20109v.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.down.DrawerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    DrawerLayout.this.f20086N = false;
                    DrawerLayout.this.f20087O = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        DrawerLayout.this.f20086N = Math.abs(motionEvent.getY() - DrawerLayout.this.f20087O) > 20.0f;
                        return false;
                    }
                    if (action == 3) {
                        return false;
                    }
                } else {
                    if (DrawerLayout.this.f20086N || DrawerLayout.this.f20109v.getVisibility() != 0 || 1.0f != DrawerLayout.this.f20109v.getAlpha()) {
                        return false;
                    }
                    DrawerLayout.this.m21372m();
                }
                return true;
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int measuredHeight;
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        this.f20090c = 0;
        measureChild(this.f20108u, OplusGLSurfaceView_13, i2);
        int measuredHeight2 = this.f20108u.getMeasuredHeight() + 0;
        CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
        if (cameraDrawerSettingMenuPanel != null) {
            measureChild(cameraDrawerSettingMenuPanel, OplusGLSurfaceView_13, i2);
            measuredHeight = this.mSubSettingView.getMeasuredHeight();
        } else {
            measuredHeight = 0;
        }
        View view = this.f20109v;
        if (view != null) {
            measureChild(view, OplusGLSurfaceView_13, i2);
        }
        this.f20098k = measuredHeight == 0;
        this.f20090c = measuredHeight;
        if (1 == this.f20083K) {
            this.f20090c = getContext().getResources().getDimensionPixelSize(R.dimen.fold_tool_draw_panel_max_scroll);
        }
        setMeasuredDimension(size, (int) (measuredHeight2 + this.f20107t));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws Resources.NotFoundException {
        int i5;
        int i6;
        boolean zEquals = this.f20082J.getString(CameraUIInterface.KEY_SUB_SETTING, "off").equals("on");
        int measuredWidth = getMeasuredWidth();
        this.f20112y = getViewOffsetPercent();
        if (4 == this.f20083K) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = OplusGLSurfaceView_13;
            i6 = i2;
        }
        View view = this.f20108u;
        view.layout(((measuredWidth - view.getMeasuredWidth()) / 2) + i5, i6, ((this.f20108u.getMeasuredWidth() + measuredWidth) / 2) + i5, this.f20108u.getMeasuredHeight() + i6);
        if (this.mSubSettingView != null) {
            this.f20080H = this.f20074B.getInterpolation(Math.min(this.f20112y, 1.0f));
            this.mSubSettingView.setAlpha(this.f20080H);
            this.mSubSettingView.setOffset(this.f20112y);
            CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
            cameraDrawerSettingMenuPanel.layout(((measuredWidth - cameraDrawerSettingMenuPanel.getMeasuredWidth()) / 2) + i5, this.f20108u.getMeasuredHeight(), ((this.mSubSettingView.getMeasuredWidth() + measuredWidth) / 2) + i5, this.f20108u.getMeasuredHeight() + this.mSubSettingView.getMeasuredHeight());
            if (1 == this.f20083K) {
                int color = getResources().getColor(R.color.camera_sub_setting_bg_color_for_full_screen_mode);
                float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.menu_bg_radius);
                this.mSubSettingView.setBackground(m21349a(0.0f == this.f20080H ? 0 : InverseManager.INS.getBackgroundColor(this, color), new RoundRectShape(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize}, null, null)));
            } else {
                this.mSubSettingView.setBackgroundResource(0);
            }
        }
        View view2 = this.f20109v;
        if (view2 != null) {
            view2.setAlpha(this.f20080H);
            View view3 = this.f20109v;
            view3.layout(((measuredWidth - view3.getMeasuredWidth()) / 2) + i5, i4 - this.f20109v.getMeasuredHeight(), i5 + ((measuredWidth + this.f20109v.getMeasuredWidth()) / 2), i4);
        }
        if (4 == this.f20083K && zEquals) {
            int color2 = getResources().getColor(R.color.color_white_with_20_percent_transparency);
            if (this.f20085M) {
                color2 = getResources().getColor(R.color.color_black_with_80_percent_transparency);
            }
            float dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.menu_bg_radius);
            setBackground(m21349a(0.0f != this.f20080H ? InverseManager.INS.getBackgroundColor(this, color2) : 0, new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2}, null, null)));
            return;
        }
        if (1 == this.f20083K) {
            setBackgroundResource(0);
            removeView(this.f20109v);
        } else {
            m21365c(this.f20080H);
        }
    }

    private float getViewOffsetPercent() {
        int OplusGLSurfaceView_13 = this.f20090c;
        if (OplusGLSurfaceView_13 == 0) {
            return 0.0f;
        }
        return this.f20107t / (OplusGLSurfaceView_13 * 1.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        CameraLog.m12959b("DrawerLayout", "onInterceptTouchEvent, mbEnabled: " + this.f20099l + ", isAnimationRun: " + m21384i() + ", mbTouch: " + this.f20096i);
        if (!this.f20099l || m21384i() || (1 == motionEvent.getAction() && this.f20096i)) {
            setEnableTouch(false);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01db  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m21376a(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.m21376a(android.view.MotionEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21353a(float COUIBaseListPopupWindow_12, float f2) {
        if (this.f20108u == null) {
            return false;
        }
        if (this.f20110w == null) {
            this.f20110w = new Rect();
            this.f20108u.getHitRect(this.f20110w);
        }
        return this.f20110w.contains((int) COUIBaseListPopupWindow_12, (int) f2);
    }

    public void setPreferences(ComboPreferences comboPreferences) {
        this.f20082J = comboPreferences;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        CameraLog.m12959b("DrawerLayout", "setEnabled, mbEnabled: " + this.f20099l + " > " + z + ", mDealEventFromOutState: " + this.f20102o);
        if (2 == this.f20102o) {
            setEnableTouch(false);
        }
        this.f20099l = z;
        super.setEnabled(z);
    }

    private void setDealStateFromOut(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("DrawerLayout", "setDealStateFromOut, mDealEventFromOutState: " + this.f20102o + " -> " + OplusGLSurfaceView_13);
        this.f20102o = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationState(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("DrawerLayout", "setAnimationState, mAnimationState: " + this.f20081I + " -> " + OplusGLSurfaceView_13);
        this.f20081I = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21352a(MotionEvent motionEvent, float COUIBaseListPopupWindow_12) {
        this.f20089b = (int) this.f20107t;
        float f2 = COUIBaseListPopupWindow_12 - this.f20093f;
        setEnableTouch(false);
        setDealStateFromOut(0);
        if (this.f20101n) {
            this.f20088a = true;
            m21350a(this.f20089b, this.f20090c);
        } else {
            float eventTime = f2 / (motionEvent.getEventTime() - motionEvent.getDownTime());
            CameraLog.m12954a("DrawerLayout", "handleDrawerSettingEventUp, speed: " + eventTime + ", mScrollTo: " + this.f20089b + ", offsetUpDownY: " + f2 + ", mMaxScroll: " + this.f20090c);
            if (((1.2f < Math.abs(eventTime) && 0.0f < eventTime) || this.f20089b > this.f20090c / 2) && ((f2 > 0.0f || this.f20089b > this.f20090c) && ViewConfiguration.get(getContext()).getScaledTouchSlop() <= Math.abs(f2) && motionEvent.getPointerCount() <= 1)) {
                this.f20088a = true;
                m21357b(this.f20089b, this.f20090c, true);
            } else {
                this.f20088a = false;
                int OplusGLSurfaceView_13 = this.f20089b;
                int i2 = this.f20091d;
                if (OplusGLSurfaceView_13 != i2) {
                    m21356b(OplusGLSurfaceView_13, i2);
                }
            }
        }
        this.f20093f = 0.0f;
        this.f20094g = false;
        if (this.f20095h == null || Math.abs(f2) <= 0.0f) {
            return;
        }
        this.f20095h.mo21390a(this.f20088a);
        this.f20095h.mo21392e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m21342a(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f20090c;
        float f2 = ((COUIBaseListPopupWindow_12 - OplusGLSurfaceView_13) / 2.0f) + OplusGLSurfaceView_13;
        return f2 > ((float) (OplusGLSurfaceView_13 + 100)) ? OplusGLSurfaceView_13 + 100 : f2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21355b(float COUIBaseListPopupWindow_12) {
        this.f20101n = true;
        this.f20107t = COUIBaseListPopupWindow_12;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScroll(float COUIBaseListPopupWindow_12) {
        this.f20101n = false;
        this.f20107t = COUIBaseListPopupWindow_12;
        requestLayout();
        InterfaceC3323b interfaceC3323b = this.f20095h;
        if (interfaceC3323b != null) {
            int OplusGLSurfaceView_13 = this.f20090c;
            if (OplusGLSurfaceView_13 > 0) {
                interfaceC3323b.mo21389a((OplusGLSurfaceView_13 - COUIBaseListPopupWindow_12) / ((OplusGLSurfaceView_13 - this.f20091d) * 1.0f));
            } else {
                interfaceC3323b.mo21389a(1.0f);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21365c(float COUIBaseListPopupWindow_12) {
        setBackground(m21348a(0.0f == COUIBaseListPopupWindow_12 ? 0 : InverseManager.INS.getBackgroundColor(this, Color.argb(0.8f * COUIBaseListPopupWindow_12, 0.0f, 0.0f, 0.0f))));
    }

    @Override // android.view.View
    public void setBackgroundColor(int OplusGLSurfaceView_13) {
        m21365c(Math.min(this.f20112y, 1.0f));
        if (getBackground() == this.f20075C) {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m21348a(int OplusGLSurfaceView_13) {
        if (this.f20075C == null) {
            float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.menu_bg_radius);
            this.f20075C = new ShapeDrawable(new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize}, null, null));
        }
        this.f20075C.getPaint().setColor(OplusGLSurfaceView_13);
        return this.f20075C;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m21349a(int OplusGLSurfaceView_13, Shape shape) {
        if (this.f20076D == null) {
            this.f20076D = new ShapeDrawable();
        }
        this.f20076D.setShape(shape);
        this.f20076D.getPaint().setColor(OplusGLSurfaceView_13);
        return this.f20076D;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21350a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b("DrawerLayout", "startUpDampAnimator, start: " + OplusGLSurfaceView_13 + ", end: " + i2);
        ValueAnimator valueAnimator = this.f20106s;
        if (valueAnimator == null) {
            this.f20106s = ValueAnimator.ofInt(OplusGLSurfaceView_13, i2);
            this.f20106s.setDuration(450L);
            this.f20106s.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_damp_up_interpolator));
            this.f20106s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.-$$Lambda$DrawerLayout$qaOpDagCjdOg-qrsZ9_n81oLMis
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.COUIBaseListPopupWindow_12$0.m21358b(valueAnimator2);
                }
            });
        } else {
            valueAnimator.setIntValues(OplusGLSurfaceView_13, i2);
        }
        if (this.f20103p == null) {
            this.f20103p = new C3322a();
        }
        this.f20103p.m21388a(this.f20088a ? 1 : 2);
        this.f20106s.addListener(this.f20103p);
        InterfaceC3323b interfaceC3323b = this.f20095h;
        if (interfaceC3323b != null) {
            interfaceC3323b.mo21391a(this.f20088a, true, 450);
        }
        this.f20106s.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21358b(ValueAnimator valueAnimator) {
        if (this.f20088a) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f20089b = iIntValue;
            m21355b(iIntValue);
            return;
        }
        this.f20106s.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21356b(int OplusGLSurfaceView_13, int i2) {
        m21357b(OplusGLSurfaceView_13, i2, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21357b(int OplusGLSurfaceView_13, final int i2, boolean z) {
        ValueAnimator valueAnimator = this.f20104q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f20104q.cancel();
        }
        InterfaceC3323b interfaceC3323b = this.f20095h;
        if (interfaceC3323b != null) {
            interfaceC3323b.mo21391a(this.f20088a, true, m21363c(OplusGLSurfaceView_13, i2));
        }
        this.f20104q = ValueAnimator.ofInt(OplusGLSurfaceView_13, i2);
        this.f20104q.setDuration(m21345a(OplusGLSurfaceView_13, i2, z ? 1.1f : 1.0f));
        if (z) {
            this.f20104q.setInterpolator(this.f20073A);
        } else {
            this.f20104q.setInterpolator(this.f20113z);
        }
        this.f20104q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.DrawerLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DrawerLayout.this.f20089b = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                DrawerLayout.this.setScroll(r2.f20089b);
                if (DrawerLayout.this.f20089b == 0 && DrawerLayout.this.f20082J != null && i2 == 0) {
                    DrawerLayout.this.f20082J.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
                }
            }
        });
        if (this.f20103p == null) {
            this.f20103p = new C3322a();
        }
        if (!this.f20088a) {
            this.f20105r = ValueAnimator.ofFloat(this.f20080H, 0.0f);
            this.f20105r.setInterpolator(this.f20074B);
            this.f20105r.setDuration(m21363c(OplusGLSurfaceView_13, i2));
            this.f20105r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.-$$Lambda$DrawerLayout$XM906D_UWsT_wQEI1_QKLQrxqhQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.COUIBaseListPopupWindow_12$0.m21351a(valueAnimator2);
                }
            });
            this.f20105r.start();
        }
        this.f20103p.m21388a(this.f20088a ? 1 : 2);
        this.f20104q.addListener(this.f20103p);
        this.f20104q.start();
        PopUpWindowManager.m20705a(this.f20088a, m21363c(OplusGLSurfaceView_13, i2));
        CameraLog.m12954a("DrawerLayout", "startAnimator, mbOpen: " + this.f20088a + ", duration: " + this.f20104q.getDuration() + ", start: " + OplusGLSurfaceView_13 + ", end: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21351a(ValueAnimator valueAnimator) {
        this.f20080H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21345a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        boolean z = this.f20088a;
        return (int) ((Math.abs(OplusGLSurfaceView_13 - i2) / (this.f20090c * 1.0f)) * 500 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m21363c(int OplusGLSurfaceView_13, int i2) {
        return (int) ((Math.abs(OplusGLSurfaceView_13 - i2) / (this.f20090c * 1.0f)) * 250.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21377b() {
        ValueAnimator valueAnimator = this.f20104q;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f20104q.cancel();
    }

    public void setOpenAndClose(boolean z) {
        CameraLog.m12959b("DrawerLayout", "setOpenAndClose, isShow: " + z + ", mbPause: " + this.f20097j + ", mbTouch: " + this.f20096i + ", mbOpen: " + this.f20088a);
        InterfaceC3323b interfaceC3323b = this.f20095h;
        if (interfaceC3323b != null) {
            if (z) {
                interfaceC3323b.mo21398w();
            } else {
                interfaceC3323b.mo21397v();
            }
        }
        if (this.f20097j || !(this.f20096i || this.f20088a == z)) {
            this.f20088a = z;
            if (!this.f20097j) {
                m21356b(this.f20089b, this.f20088a ? this.f20090c : this.f20091d);
            } else {
                ValueAnimator valueAnimator = this.f20104q;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f20104q.cancel();
                }
                this.f20089b = this.f20088a ? this.f20090c : this.f20091d;
                setScroll(this.f20089b);
            }
            InterfaceC3323b interfaceC3323b2 = this.f20095h;
            if (interfaceC3323b2 != null) {
                interfaceC3323b2.mo21390a(this.f20088a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m21372m() {
        CameraLog.m12959b("DrawerLayout", "onArrowClick");
        setEnableTouch(false);
        InterfaceC3323b interfaceC3323b = this.f20095h;
        if (interfaceC3323b != null) {
            interfaceC3323b.mo21393f();
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.down.DrawerLayout$PlatformImplementations.kt_3 */
    private class C3322a extends AnimatorListenerAdapter {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f20118b;

        private C3322a() {
            this.f20118b = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraLog.m12954a("DrawerLayout", "AnimatorListener, onAnimationEnd");
            DrawerLayout.this.setScroll(r2.f20089b);
            if (DrawerLayout.this.m21385j() && DrawerLayout.this.f20095h != null) {
                DrawerLayout.this.f20095h.mo21395l();
            }
            DrawerLayout.this.setAnimationState(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CameraLog.m12954a("DrawerLayout", "AnimatorListener, onAnimationStart");
            DrawerLayout.this.f20094g = false;
            DrawerLayout.this.setAnimationState(this.f20118b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            CameraLog.m12954a("DrawerLayout", "AnimatorListener, onAnimationCancel");
            if (DrawerLayout.this.f20104q != null) {
                DrawerLayout.this.f20104q.removeListener(DrawerLayout.this.f20103p);
                DrawerLayout.this.f20104q = null;
            }
            DrawerLayout.this.setScroll(r2.f20089b);
            if (DrawerLayout.this.m21385j() && DrawerLayout.this.f20095h != null) {
                DrawerLayout.this.f20095h.mo21395l();
            }
            DrawerLayout.this.setAnimationState(0);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m21388a(int OplusGLSurfaceView_13) {
            this.f20118b = OplusGLSurfaceView_13;
        }
    }

    public void setOnDrawerListener(InterfaceC3323b interfaceC3323b) {
        this.f20095h = interfaceC3323b;
    }

    public void setRollVisibility(int OplusGLSurfaceView_13) {
        if (this.mSubSettingView != null) {
            this.f20100m = OplusGLSurfaceView_13 == 0;
            this.mSubSettingView.setVisibility(OplusGLSurfaceView_13);
        }
    }

    public void setEnableTouch(boolean z) {
        CameraLog.m12959b("DrawerLayout", "setEnableTouch, mbTouch: " + this.f20096i + " > " + z);
        this.f20096i = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21379d() {
        int OplusGLSurfaceView_13;
        int i2;
        if (m21384i() || (OplusGLSurfaceView_13 = this.f20091d) == (i2 = this.f20089b)) {
            return;
        }
        m21356b(i2, OplusGLSurfaceView_13);
    }

    public boolean getEnableTouch() {
        return this.f20096i;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m21380e() {
        return this.f20088a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m21381f() {
        this.f20088a = false;
        this.f20097j = true;
        this.f20107t = 0.0f;
        this.f20089b = 0;
        setEnableTouch(false);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m21382g() {
        this.f20097j = false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m21383h() {
        return this.f20098k;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m21384i() {
        return this.f20081I != 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m21385j() {
        return 2 == this.f20081I;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m21386k() {
        return 0.0f != this.f20107t && isShown();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21375a(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("DrawerLayout", "hasDealEvent, mDownEventTimeFromOut: " + this.f20077E + ", eventTime: " + OplusGLSurfaceView_15);
        boolean z = this.f20077E == OplusGLSurfaceView_15;
        if (!z) {
            setEnableTouch(false);
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21374a(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f20083K = OplusGLSurfaceView_13;
        this.f20084L = i2;
        this.f20085M = z;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m21387l() {
        ValueAnimator valueAnimator = this.f20104q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
        if (cameraDrawerSettingMenuPanel != null) {
            cameraDrawerSettingMenuPanel.setBackgroundResource(0);
        }
        this.f20089b = 0;
        setScroll(this.f20089b);
        this.f20082J.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
    }
}
