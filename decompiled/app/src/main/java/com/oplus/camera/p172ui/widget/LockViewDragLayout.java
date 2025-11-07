package com.oplus.camera.p172ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.customview.p039a.ViewDragHelper;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.control.MainShutterButton;

/* loaded from: classes2.dex */
public class LockViewDragLayout extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f22612a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f22613b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f22614c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f22615d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean f22616e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static boolean f22617f;

    /* renamed from: A */
    private Point f22618A;

    /* renamed from: B */
    private Point f22619B;

    /* renamed from: C */
    private Point f22620C;

    /* renamed from: D */
    private int f22621D;

    /* renamed from: E */
    private int f22622E;

    /* renamed from: F */
    private int f22623F;

    /* renamed from: G */
    private int f22624G;

    /* renamed from: H */
    private int f22625H;

    /* renamed from: I */
    private int f22626I;

    /* renamed from: J */
    private float f22627J;

    /* renamed from: K */
    private float f22628K;

    /* renamed from: L */
    private float f22629L;

    /* renamed from: M */
    private float f22630M;

    /* renamed from: N */
    private boolean f22631N;

    /* renamed from: O */
    private boolean f22632O;

    /* renamed from: P */
    private boolean f22633P;

    /* renamed from: Q */
    private boolean f22634Q;

    /* renamed from: R */
    private boolean f22635R;

    /* renamed from: S */
    private boolean f22636S;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Context f22637g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LockImageView f22638h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ImageView f22639i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ViewDragHelper f22640j;

    /* renamed from: OplusGLSurfaceView_5 */
    private MainShutterButton f22641k;

    /* renamed from: OplusGLSurfaceView_14 */
    private InterfaceC3501a f22642l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ValueAnimator f22643m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ValueAnimator f22644n;

    /* renamed from: o */
    private ValueAnimator f22645o;

    /* renamed from: p */
    private ValueAnimator f22646p;

    /* renamed from: q */
    private ValueAnimator f22647q;

    /* renamed from: r */
    private ValueAnimator f22648r;

    /* renamed from: s */
    private Interpolator f22649s;

    /* renamed from: t */
    private Interpolator f22650t;

    /* renamed from: u */
    private Paint f22651u;

    /* renamed from: v */
    private RectF f22652v;

    /* renamed from: w */
    private Paint f22653w;

    /* renamed from: x */
    private Paint f22654x;

    /* renamed from: y */
    private Point f22655y;

    /* renamed from: z */
    private Point f22656z;

    /* renamed from: com.oplus.camera.ui.widget.LockViewDragLayout$PlatformImplementations.kt_3 */
    public interface InterfaceC3501a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo19221a(boolean z);
    }

    public LockViewDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22637g = null;
        this.f22638h = null;
        this.f22639i = null;
        this.f22640j = null;
        this.f22641k = null;
        this.f22642l = null;
        this.f22643m = null;
        this.f22644n = null;
        this.f22645o = null;
        this.f22646p = null;
        this.f22647q = null;
        this.f22648r = null;
        this.f22649s = null;
        this.f22650t = null;
        this.f22651u = null;
        this.f22652v = null;
        this.f22653w = null;
        this.f22654x = null;
        this.f22655y = new Point();
        this.f22656z = new Point();
        this.f22618A = new Point();
        this.f22619B = new Point();
        this.f22620C = new Point();
        this.f22621D = 0;
        this.f22622E = 0;
        this.f22623F = 0;
        this.f22624G = 0;
        this.f22625H = 0;
        this.f22626I = 0;
        this.f22627J = 0.0f;
        this.f22628K = 0.0f;
        this.f22629L = 1.0f;
        this.f22630M = 0.0f;
        this.f22631N = true;
        this.f22632O = false;
        this.f22633P = false;
        this.f22634Q = true;
        this.f22635R = false;
        this.f22636S = false;
        this.f22637g = context;
        m23981a(context, attributeSet, 0);
    }

    public static void setLongPressState(boolean z) {
        f22613b = z;
    }

    public static boolean getLongPressState() {
        return f22613b;
    }

    public static void setReachBorderState(boolean z) {
        f22614c = z;
    }

    public static boolean getIsReachBorder() {
        return f22614c;
    }

    public static void setVolumeDownState(boolean z) {
        f22615d = z;
    }

    public static void setQuickRecordState(boolean z) {
        CameraLog.m12954a("LockViewDragLayout", "setQuickRecordState, quickRecordState: " + f22616e + "->" + z);
        f22616e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m23984a() {
        return f22617f;
    }

    public static void setIsQuickVideoStartedByShutterButtonLongClick(boolean z) {
        f22617f = z;
    }

    public static boolean getIsVolumeDownState() {
        return f22615d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23981a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this.f22640j = ViewDragHelper.m3090a(this, 1.0f, new C3502b());
        this.f22624G = this.f22637g.getColor(R.color.color_light_red);
        this.f22622E = this.f22637g.getColor(R.color.color_white_with_full_percent_transparency);
        this.f22652v = new RectF();
        this.f22651u = new Paint();
        this.f22651u.setColor(this.f22624G);
        this.f22651u.setStrokeWidth(10.0f);
        this.f22651u.setAntiAlias(true);
        this.f22653w = new Paint();
        this.f22653w.setColor(this.f22637g.getColor(R.color.color_white_with_50_percent_transparency));
        this.f22653w.setAntiAlias(true);
        Path path = new Path();
        path.addCircle(0.0f, 0.0f, 3.0f, Path.Direction.CW);
        this.f22653w.setPathEffect(new PathDashPathEffect(path, 22.0f, 0.0f, PathDashPathEffect.Style.TRANSLATE));
        this.f22654x = new Paint();
        this.f22654x.setColor(this.f22624G);
        this.f22654x.setStrokeWidth(10.0f);
        this.f22654x.setAntiAlias(true);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MainShutterButton, OplusGLSurfaceView_13, 0);
        Resources resources = context.getResources();
        this.f22626I = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_corner_radius));
        this.f22625H = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_length));
        this.f22628K = typedArrayObtainStyledAttributes.getResources().getDimension(R.dimen.shutter_button_move_circle_lock_size);
        this.f22627J = typedArrayObtainStyledAttributes.getResources().getDimension(R.dimen.shutter_button_move_circle_size);
        typedArrayObtainStyledAttributes.recycle();
        this.f22644n = m23977a(this.f22655y.y);
        m24003g();
        m24005h();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m24003g() {
        this.f22649s = AnimationUtils.loadInterpolator(this.f22637g, R.anim.quick_video_shutter_scale_path_interpolator);
        this.f22650t = AnimationUtils.loadInterpolator(this.f22637g, R.anim.quick_video_circle_slide_path_interpolator);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (f22615d && !f22617f) {
            return false;
        }
        if (this.f22640j.m3111a(motionEvent) && f22616e) {
            z = true;
        }
        f22612a = z;
        return f22612a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            setLongPressState(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (f22615d && !f22617f) {
            m23983a(motionEvent);
            return false;
        }
        if (this.f22639i.getVisibility() == 0) {
            this.f22640j.m3115b(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f22631N = true;
                this.f22619B.y = this.f22620C.y;
            } else if (action == 1) {
                this.f22631N = false;
                this.f22656z.y = this.f22618A.y;
            }
            m23983a(motionEvent);
            return true;
        }
        m23983a(motionEvent);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23983a(MotionEvent motionEvent) {
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.f22641k.setPressed(false);
            this.f22640j.m3127f();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f22639i = (ImageView) findViewById(R.id_renamed.shutter_move_circle);
        this.f22638h = (LockImageView) findViewById(R.id_renamed.camera_quick_lock);
        this.f22641k = (MainShutterButton) findViewById(R.id_renamed.shutter_button);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f22640j.m3113a(true)) {
            invalidate();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        int right = this.f22639i.getRight() - this.f22639i.getLeft();
        int bottom = this.f22639i.getBottom() - this.f22639i.getTop();
        this.f22620C.x = this.f22641k.getLeft() + (this.f22641k.getWidth() / 2);
        this.f22620C.y = this.f22641k.getTop() + (this.f22641k.getHeight() / 2);
        if (!f22612a) {
            this.f22619B.x = this.f22639i.getLeft() + (right / 2);
            this.f22619B.y = this.f22639i.getTop() + (bottom / 2);
        }
        this.f22655y.x = this.f22638h.getLeft() + (this.f22638h.getMeasuredWidth() / 2);
        this.f22655y.y = this.f22638h.getTop() + (this.f22638h.getMeasuredHeight() / 2);
        this.f22656z.x = this.f22638h.getLeft() + (this.f22638h.getMeasuredWidth() / 3);
        this.f22656z.y = this.f22638h.getBottom() + (this.f22638h.getMeasuredHeight() / 3);
        this.f22618A.x = this.f22641k.getLeft() + (right / 2);
        this.f22618A.y = this.f22641k.getTop() - this.f22626I;
        this.f22623F = this.f22620C.y - this.f22655y.y;
        this.f22621D = this.f22638h.getBottom() + (this.f22638h.getHeight() / 2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        if (view == this.f22638h || f22615d) {
            if (this.f22635R) {
                float COUIBaseListPopupWindow_12 = this.f22627J;
                this.f22630M = ((COUIBaseListPopupWindow_12 / 2.0f) - (((this.f22620C.y - this.f22619B.y) / this.f22623F) * ((COUIBaseListPopupWindow_12 / 2.0f) - (this.f22625H / 2)))) * this.f22629L;
                if (getDistance() < (this.f22623F >> 1) - 10) {
                    m23994c(canvas);
                }
                this.f22618A.y = Math.min(this.f22641k.getTop() - this.f22626I, this.f22619B.y);
                m23982a(canvas);
                if (!this.f22647q.isRunning() || f22612a) {
                    m23990b(canvas);
                }
            } else {
                this.f22635R = false;
                this.f22636S = false;
            }
        }
        return super.drawChild(canvas, view, OplusGLSurfaceView_15);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (f22614c || !this.f22636S) {
            return;
        }
        canvas.drawLine(this.f22618A.x, this.f22656z.y, this.f22618A.x, this.f22618A.y, this.f22653w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDistance() {
        return (float) Math.sqrt(Math.pow(this.f22619B.x - this.f22620C.x, 2.0d) + Math.pow(this.f22619B.y - this.f22620C.y, 2.0d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23982a(Canvas canvas) {
        canvas.drawCircle(this.f22619B.x, this.f22619B.y, Math.max(this.f22630M, this.f22628K / 2.0f), this.f22654x);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23990b(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float f4;
        int OplusGLSurfaceView_13;
        float f5;
        float f6 = this.f22620C.y - this.f22619B.y;
        int i2 = this.f22623F;
        if (i2 > f6) {
            float f7 = f6 / i2;
            float f8 = ((this.f22627J / 2.0f) - (this.f22625H / 2)) * f7;
            COUIBaseListPopupWindow_12 = (this.f22620C.x - (this.f22627J / 2.0f)) + f8;
            f2 = (this.f22620C.y - (this.f22627J / 2.0f)) + f8;
            f3 = (this.f22620C.x + (this.f22627J / 2.0f)) - f8;
            f4 = (this.f22620C.y + (this.f22627J / 2.0f)) - f8;
            f5 = (f4 - f2) / 2.0f;
            if (0.5f < f7) {
                f5 *= 1.0f - ((f7 - 0.5f) / 0.5f);
                OplusGLSurfaceView_13 = this.f22626I;
                if (f5 < OplusGLSurfaceView_13) {
                }
            }
            float f9 = f5;
            canvas.drawRoundRect(COUIBaseListPopupWindow_12, f2, f3, f4, f9, f9, this.f22651u);
        }
        COUIBaseListPopupWindow_12 = this.f22620C.x - (this.f22625H / 2);
        int i3 = this.f22620C.y;
        int i4 = this.f22625H;
        f2 = i3 - (i4 / 2);
        f3 = COUIBaseListPopupWindow_12 + i4;
        f4 = f2 + i4;
        OplusGLSurfaceView_13 = this.f22626I;
        f5 = OplusGLSurfaceView_13;
        float f92 = f5;
        canvas.drawRoundRect(COUIBaseListPopupWindow_12, f2, f3, f4, f92, f92, this.f22651u);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m23994c(Canvas canvas) {
        float COUIBaseListPopupWindow_12 = this.f22630M * 2.0f;
        float distance = 1.0f - (getDistance() / this.f22623F);
        this.f22652v.left = this.f22620C.x;
        this.f22652v.top = this.f22619B.y;
        this.f22652v.right = this.f22620C.x;
        this.f22652v.bottom = this.f22620C.y;
        float fHeight = this.f22652v.height() * 0.75f;
        canvas.save();
        canvas.translate(this.f22620C.x + this.f22630M, this.f22620C.y - this.f22652v.height());
        Path path = new Path();
        float f2 = -COUIBaseListPopupWindow_12;
        float f3 = 1.0f - distance;
        float f4 = fHeight * f3;
        path.quadTo(f2 * f3, f4, 0.0f, this.f22652v.height());
        path.lineTo((-this.f22630M) * 2.0f, this.f22652v.height());
        path.quadTo(f2 * distance, f4, (-this.f22630M) * 2.0f, 0.0f);
        path.close();
        canvas.drawPath(path, this.f22651u);
        canvas.restore();
    }

    /* renamed from: com.oplus.camera.ui.widget.LockViewDragLayout$IntrinsicsJvm.kt_4 */
    class C3502b extends ViewDragHelper.PlatformImplementations.kt_3 {
        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
            return OplusGLSurfaceView_13;
        }

        C3502b() {
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
            return view == LockViewDragLayout.this.f22639i;
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
            return LockViewDragLayout.this.f22639i.getLeft();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
            super.onViewReleased(view, COUIBaseListPopupWindow_12, f2);
            CameraLog.m12954a("LockViewDragLayout", "onViewReleased, mbReachBorder" + LockViewDragLayout.f22614c);
            LockViewDragLayout.this.f22635R = false;
            LockViewDragLayout.this.f22636S = false;
            if (LockViewDragLayout.this.f22642l != null) {
                LockViewDragLayout.this.f22642l.mo19221a(LockViewDragLayout.f22614c);
            }
            if (view == LockViewDragLayout.this.f22639i && !LockViewDragLayout.f22614c && LockViewDragLayout.this.f22640j != null && LockViewDragLayout.this.f22640j.m3107a() != 0) {
                LockViewDragLayout.this.f22640j.m3110a(LockViewDragLayout.this.f22620C.x, LockViewDragLayout.this.f22620C.y);
                LockViewDragLayout.this.invalidate();
            }
            LockViewDragLayout.this.m24027d();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int getViewHorizontalDragRange(View view) {
            return LockViewDragLayout.this.getMeasuredWidth() - view.getMeasuredWidth();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int getViewVerticalDragRange(View view) {
            return LockViewDragLayout.this.getMeasuredHeight() - view.getMeasuredHeight();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, OplusGLSurfaceView_13, i2, i3, i4);
            if (-56 <= i2 || LockViewDragLayout.this.f22655y.y != LockViewDragLayout.this.f22619B.y) {
                if ((290 >= i2 || LockViewDragLayout.this.f22619B.y < LockViewDragLayout.this.f22620C.y) && view.getId() == R.id_renamed.shutter_move_circle) {
                    float COUIBaseListPopupWindow_12 = LockViewDragLayout.this.f22655y.y;
                    float f2 = LockViewDragLayout.this.f22621D;
                    LockViewDragLayout.this.f22641k.setPressed(false);
                    if (LockViewDragLayout.this.f22645o.isRunning()) {
                        LockViewDragLayout.this.f22645o.cancel();
                        LockViewDragLayout.this.f22629L = 1.0f;
                    }
                    if (LockViewDragLayout.this.f22620C.y - (LockViewDragLayout.this.f22623F >> 1) < LockViewDragLayout.this.f22619B.y) {
                        LockViewDragLayout.this.f22654x.setColor(LockViewDragLayout.this.f22624G);
                        if (LockViewDragLayout.this.f22633P) {
                            LockViewDragLayout.this.f22633P = false;
                        }
                    } else {
                        if (!LockViewDragLayout.this.f22644n.isRunning() && Math.abs(LockViewDragLayout.this.f22619B.y - COUIBaseListPopupWindow_12) > 0.0f && !LockViewDragLayout.this.f22633P) {
                            LockViewDragLayout lockViewDragLayout = LockViewDragLayout.this;
                            lockViewDragLayout.f22648r = ValueAnimator.ofArgb(lockViewDragLayout.f22624G, LockViewDragLayout.this.f22622E);
                            LockViewDragLayout.this.f22648r.setInterpolator(LockViewDragLayout.this.f22650t);
                            LockViewDragLayout.this.f22648r.setDuration(150L);
                            LockViewDragLayout.this.f22648r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.IntrinsicsJvm.kt_4.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    LockViewDragLayout.this.f22654x.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                    LockViewDragLayout.this.invalidate();
                                }
                            });
                            if (!LockViewDragLayout.this.f22648r.isRunning()) {
                                LockViewDragLayout.this.f22648r.start();
                            }
                        }
                        LockViewDragLayout.this.f22633P = true;
                    }
                    if (f2 < LockViewDragLayout.this.f22619B.y) {
                        LockViewDragLayout.this.f22619B.y += i4;
                        if (LockViewDragLayout.this.f22619B.y <= COUIBaseListPopupWindow_12) {
                            LockViewDragLayout.this.f22619B.y = (int) COUIBaseListPopupWindow_12;
                        }
                        if (LockViewDragLayout.this.f22632O) {
                            LockViewDragLayout.this.f22632O = false;
                        }
                    } else {
                        if (LockViewDragLayout.this.f22644n.isRunning() || Math.abs(LockViewDragLayout.this.f22619B.y - COUIBaseListPopupWindow_12) <= 0.0f || LockViewDragLayout.this.f22632O) {
                            if (!LockViewDragLayout.this.f22644n.isRunning()) {
                                LockViewDragLayout.this.f22619B.y += i4;
                                if (LockViewDragLayout.this.f22619B.y <= COUIBaseListPopupWindow_12) {
                                    LockViewDragLayout.this.f22619B.y = (int) COUIBaseListPopupWindow_12;
                                }
                            }
                        } else {
                            LockViewDragLayout.this.f22644n.setFloatValues(LockViewDragLayout.this.f22619B.y, COUIBaseListPopupWindow_12);
                            LockViewDragLayout.this.f22644n.start();
                        }
                        LockViewDragLayout.this.f22632O = true;
                    }
                    if (LockViewDragLayout.this.f22619B.y <= LockViewDragLayout.this.f22621D && !LockViewDragLayout.f22614c) {
                        boolean unused = LockViewDragLayout.f22614c = true;
                    }
                    if (LockViewDragLayout.this.f22619B.y > LockViewDragLayout.this.f22621D && LockViewDragLayout.f22614c) {
                        boolean unused2 = LockViewDragLayout.f22614c = false;
                    }
                    float distance = ((LockViewDragLayout.this.getDistance() / (LockViewDragLayout.this.f22623F >> 1)) * 0.1f) + 1.0f;
                    if (LockViewDragLayout.this.getDistance() >= (LockViewDragLayout.this.f22623F >> 1) || i4 >= 0) {
                        if (i4 != 0 && LockViewDragLayout.this.f22631N) {
                            LockViewDragLayout.this.f22643m = ValueAnimator.ofFloat(distance, 1.0f);
                            LockViewDragLayout.this.f22643m.setInterpolator(LockViewDragLayout.this.f22649s);
                            LockViewDragLayout.this.f22643m.setDuration(267L);
                            LockViewDragLayout.this.f22643m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.IntrinsicsJvm.kt_4.2
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    LockViewDragLayout.this.f22641k.setScaleX(fFloatValue);
                                    LockViewDragLayout.this.f22641k.setScaleY(fFloatValue);
                                }
                            });
                            if (!LockViewDragLayout.this.f22643m.isRunning() && LockViewDragLayout.this.f22634Q) {
                                LockViewDragLayout.this.f22634Q = false;
                                LockViewDragLayout.this.f22643m.start();
                            }
                        }
                    } else {
                        LockViewDragLayout.this.f22641k.setScaleX(distance);
                        LockViewDragLayout.this.f22641k.setScaleY(distance);
                        LockViewDragLayout.this.f22634Q = true;
                    }
                    LockViewDragLayout.this.f22638h.setChangIcon((LockViewDragLayout.this.getDistance() * 1.0f) / LockViewDragLayout.this.f22623F);
                    if (LockViewDragLayout.this.f22619B.y > LockViewDragLayout.this.f22620C.y) {
                        LockViewDragLayout.this.f22619B.y = LockViewDragLayout.this.f22620C.y;
                    }
                    if (LockViewDragLayout.this.f22619B.y < LockViewDragLayout.this.f22638h.getTop() - (LockViewDragLayout.this.f22638h.getHeight() / 2)) {
                        LockViewDragLayout.this.f22619B.y = LockViewDragLayout.this.f22638h.getTop() - (LockViewDragLayout.this.f22638h.getHeight() / 2);
                    }
                    LockViewDragLayout.this.invalidate();
                }
            }
        }
    }

    public void setVDHLayoutListener(InterfaceC3501a interfaceC3501a) {
        this.f22642l = interfaceC3501a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ValueAnimator m23977a(float COUIBaseListPopupWindow_12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f22619B.y, COUIBaseListPopupWindow_12);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(this.f22650t);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LockViewDragLayout.this.f22619B.y = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LockViewDragLayout.this.invalidate();
            }
        });
        return valueAnimatorOfFloat;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m24005h() {
        this.f22647q = ValueAnimator.ofFloat(1.0f, 0.9f);
        this.f22647q.setDuration(417L);
        this.f22647q.setInterpolator(this.f22649s);
        this.f22645o = ValueAnimator.ofFloat(0.9f, 1.05f);
        this.f22645o.setDuration(167L);
        this.f22645o.setInterpolator(this.f22649s);
        this.f22646p = ValueAnimator.ofFloat(1.05f, 1.0f);
        this.f22646p.setDuration(367L);
        this.f22646p.setInterpolator(this.f22649s);
        this.f22647q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LockViewDragLayout.this.f22629L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (1.0f == valueAnimator.getAnimatedFraction()) {
                    LockViewDragLayout.this.f22645o.start();
                }
                LockViewDragLayout.this.invalidate();
            }
        });
        this.f22645o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LockViewDragLayout.this.f22629L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (1.0f == valueAnimator.getAnimatedFraction()) {
                    LockViewDragLayout.this.f22646p.start();
                }
                LockViewDragLayout.this.invalidate();
            }
        });
        this.f22646p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.LockViewDragLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LockViewDragLayout.this.f22629L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LockViewDragLayout.this.invalidate();
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m24007i() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f22653w, "alpha", 0, 255);
        objectAnimatorOfInt.setDuration(300L);
        objectAnimatorOfInt.setInterpolator(this.f22649s);
        objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$LockViewDragLayout$NJkxbfzkEheW1FthV8CVsDjtZFY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m23993c(valueAnimator);
            }
        });
        objectAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m23993c(ValueAnimator valueAnimator) {
        this.f22653w.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24025b() {
        this.f22638h.setVisibility(0);
        this.f22638h.setChangIcon(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f22638h, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(this.f22649s);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$LockViewDragLayout$Y1ZXJYfTrAY4qJ1A9I7pge1JraU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m23989b(valueAnimator);
            }
        });
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m23989b(ValueAnimator valueAnimator) {
        this.f22638h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24026c() {
        CameraLog.m12954a("LockViewDragLayout", "showLockUI, mIsLongPress: " + getLongPressState() + ", mbIsVolumeDown:" + f22615d + ", mbIsShowAdhesion:" + this.f22635R);
        if (this.f22639i.getVisibility() == 0) {
            CameraLog.m12954a("LockViewDragLayout", "showLockUI, mIvMoveCircle is visible so return!");
            return;
        }
        this.f22639i.setVisibility(0);
        this.f22647q.start();
        if (f22615d) {
            return;
        }
        m24025b();
        m24007i();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24027d() {
        CameraLog.m12954a("LockViewDragLayout", "hideLockUI");
        if (8 == this.f22639i.getVisibility()) {
            CameraLog.m12954a("LockViewDragLayout", "hideLockUI, mIvMoveCircle is gone so return!");
            return;
        }
        this.f22639i.setVisibility(8);
        m24009j();
        f22612a = false;
        f22614c = false;
        this.f22635R = false;
        this.f22636S = false;
        this.f22640j.m3127f();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m24009j() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f22638h, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setInterpolator(this.f22649s);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$LockViewDragLayout$QW7qRXkSpMO0wpqCcV8VnjAdBMY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m23980a(valueAnimator);
            }
        });
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m23980a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.f22638h.setAlpha(fFloatValue);
        if (1.0f == animatedFraction) {
            this.f22638h.setVisibility(4);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m24028e() {
        f22614c = false;
        this.f22635R = true;
        this.f22636S = !getIsVolumeDownState();
        this.f22638h.setLock(false);
        this.f22654x.setColor(this.f22624G);
        this.f22631N = true;
    }

    public void setShowAdhesion(boolean z) {
        CameraLog.m12954a("LockViewDragLayout", "setShowAdhesion, mbIsShowAdhesion: " + this.f22635R + " -> " + z);
        this.f22635R = z;
    }

    public void setShowLine(boolean z) {
        CameraLog.m12954a("LockViewDragLayout", "setShowLine, mbIsShowLine: " + this.f22636S + " -> " + z);
        this.f22636S = z;
    }

    public static boolean getMoveStatus() {
        return f22612a;
    }

    public static void setIsVolumeDown(boolean z) {
        f22615d = z;
    }
}
