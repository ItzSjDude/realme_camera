package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.p036h.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: FastScroller.java */
/* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
class FastScroller extends RecyclerView.AbstractC0692h implements RecyclerView.InterfaceC0697m {

    /* renamed from: OplusGLSurfaceView_5 */
    private static final int[] f4231k = {R.attr.state_pressed};

    /* renamed from: OplusGLSurfaceView_14 */
    private static final int[] f4232l = new int[0];

    /* renamed from: PlatformImplementations.kt_3 */
    final StateListDrawable f4238a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Drawable f4239b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4240c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f4241d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    float f4242e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f4243f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f4244g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    float f4245h;

    /* renamed from: OplusGLSurfaceView_6 */
    private final int f4248m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final int f4249n;

    /* renamed from: o */
    private final int f4250o;

    /* renamed from: p */
    private final int f4251p;

    /* renamed from: q */
    private final StateListDrawable f4252q;

    /* renamed from: r */
    private final Drawable f4253r;

    /* renamed from: s */
    private final int f4254s;

    /* renamed from: t */
    private final int f4255t;

    /* renamed from: w */
    private RecyclerView f4258w;

    /* renamed from: u */
    private int f4256u = 0;

    /* renamed from: v */
    private int f4257v = 0;

    /* renamed from: x */
    private boolean f4259x = false;

    /* renamed from: y */
    private boolean f4260y = false;

    /* renamed from: z */
    private int f4261z = 0;

    /* renamed from: A */
    private int f4233A = 0;

    /* renamed from: B */
    private final int[] f4234B = new int[2];

    /* renamed from: C */
    private final int[] f4235C = new int[2];

    /* renamed from: OplusGLSurfaceView_13 */
    final ValueAnimator f4246i = ValueAnimator.ofFloat(0.0f, 1.0f);

    /* renamed from: OplusGLSurfaceView_15 */
    int f4247j = 0;

    /* renamed from: D */
    private final Runnable f4236D = new Runnable() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_11.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.m4460b(500);
        }
    };

    /* renamed from: E */
    private final RecyclerView.AbstractC0698n f4237E = new RecyclerView.AbstractC0698n() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_11.2
        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
        public void onScrolled(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
            FastScroller.this.m4456a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4163a(boolean z) {
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int OplusGLSurfaceView_13, int i2, int i3) {
        this.f4238a = stateListDrawable;
        this.f4239b = drawable;
        this.f4252q = stateListDrawable2;
        this.f4253r = drawable2;
        this.f4250o = Math.max(OplusGLSurfaceView_13, stateListDrawable.getIntrinsicWidth());
        this.f4251p = Math.max(OplusGLSurfaceView_13, drawable.getIntrinsicWidth());
        this.f4254s = Math.max(OplusGLSurfaceView_13, stateListDrawable2.getIntrinsicWidth());
        this.f4255t = Math.max(OplusGLSurfaceView_13, drawable2.getIntrinsicWidth());
        this.f4248m = i2;
        this.f4249n = i3;
        this.f4238a.setAlpha(255);
        this.f4239b.setAlpha(255);
        this.f4246i.addListener(new PlatformImplementations.kt_3());
        this.f4246i.addUpdateListener(new IntrinsicsJvm.kt_4());
        m4457a(recyclerView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4457a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4258w;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m4449d();
        }
        this.f4258w = recyclerView;
        if (this.f4258w != null) {
            m4447c();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4447c() {
        this.f4258w.addItemDecoration(this);
        this.f4258w.addOnItemTouchListener(this);
        this.f4258w.addOnScrollListener(this.f4237E);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m4449d() {
        this.f4258w.removeItemDecoration(this);
        this.f4258w.removeOnItemTouchListener(this);
        this.f4258w.removeOnScrollListener(this.f4237E);
        m4451f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4454a() {
        this.f4258w.invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4455a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 2 && this.f4261z != 2) {
            this.f4238a.setState(f4231k);
            m4451f();
        }
        if (OplusGLSurfaceView_13 == 0) {
            m4454a();
        } else {
            m4459b();
        }
        if (this.f4261z == 2 && OplusGLSurfaceView_13 != 2) {
            this.f4238a.setState(f4232l);
            m4448c(1200);
        } else if (OplusGLSurfaceView_13 == 1) {
            m4448c(1500);
        }
        this.f4261z = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m4450e() {
        return ViewCompat.m2885g(this.f4258w) == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4459b() {
        int OplusGLSurfaceView_13 = this.f4247j;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            } else {
                this.f4246i.cancel();
            }
        }
        this.f4247j = 1;
        ValueAnimator valueAnimator = this.f4246i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f4246i.setDuration(500L);
        this.f4246i.setStartDelay(0L);
        this.f4246i.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4460b(int OplusGLSurfaceView_13) {
        int i2 = this.f4247j;
        if (i2 == 1) {
            this.f4246i.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f4247j = 3;
        ValueAnimator valueAnimator = this.f4246i;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f4246i.setDuration(OplusGLSurfaceView_13);
        this.f4246i.start();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m4451f() {
        this.f4258w.removeCallbacks(this.f4236D);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4448c(int OplusGLSurfaceView_13) {
        m4451f();
        this.f4258w.postDelayed(this.f4236D, OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
        if (this.f4256u != this.f4258w.getWidth() || this.f4257v != this.f4258w.getHeight()) {
            this.f4256u = this.f4258w.getWidth();
            this.f4257v = this.f4258w.getHeight();
            m4455a(0);
        } else if (this.f4247j != 0) {
            if (this.f4259x) {
                m4444a(canvas);
            }
            if (this.f4260y) {
                m4446b(canvas);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4444a(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f4256u;
        int i2 = this.f4250o;
        int i3 = OplusGLSurfaceView_13 - i2;
        int i4 = this.f4241d;
        int i5 = this.f4240c;
        int i6 = i4 - (i5 / 2);
        this.f4238a.setBounds(0, 0, i2, i5);
        this.f4239b.setBounds(0, 0, this.f4251p, this.f4257v);
        if (m4450e()) {
            this.f4239b.draw(canvas);
            canvas.translate(this.f4250o, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f4238a.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.f4250o, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f4239b.draw(canvas);
        canvas.translate(0.0f, i6);
        this.f4238a.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4446b(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f4257v;
        int i2 = this.f4254s;
        int i3 = this.f4244g;
        int i4 = this.f4243f;
        this.f4252q.setBounds(0, 0, i4, i2);
        this.f4253r.setBounds(0, 0, this.f4256u, this.f4255t);
        canvas.translate(0.0f, OplusGLSurfaceView_13 - i2);
        this.f4253r.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.f4252q.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4456a(int OplusGLSurfaceView_13, int i2) {
        int iComputeVerticalScrollRange = this.f4258w.computeVerticalScrollRange();
        int i3 = this.f4257v;
        this.f4259x = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.f4248m;
        int iComputeHorizontalScrollRange = this.f4258w.computeHorizontalScrollRange();
        int i4 = this.f4256u;
        this.f4260y = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.f4248m;
        if (!this.f4259x && !this.f4260y) {
            if (this.f4261z != 0) {
                m4455a(0);
                return;
            }
            return;
        }
        if (this.f4259x) {
            float COUIBaseListPopupWindow_12 = i3;
            this.f4241d = (int) ((COUIBaseListPopupWindow_12 * (i2 + (COUIBaseListPopupWindow_12 / 2.0f))) / iComputeVerticalScrollRange);
            this.f4240c = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.f4260y) {
            float f2 = i4;
            this.f4244g = (int) ((f2 * (OplusGLSurfaceView_13 + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f4243f = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.f4261z;
        if (i5 == 0 || i5 == 1) {
            m4455a(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4164a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int OplusGLSurfaceView_13 = this.f4261z;
        if (OplusGLSurfaceView_13 == 1) {
            boolean zM4458a = m4458a(motionEvent.getX(), motionEvent.getY());
            boolean zM4461b = m4461b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zM4458a && !zM4461b) {
                return false;
            }
            if (zM4461b) {
                this.f4233A = 1;
                this.f4245h = (int) motionEvent.getX();
            } else if (zM4458a) {
                this.f4233A = 2;
                this.f4242e = (int) motionEvent.getY();
            }
            m4455a(2);
        } else if (OplusGLSurfaceView_13 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4165b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f4261z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zM4458a = m4458a(motionEvent.getX(), motionEvent.getY());
            boolean zM4461b = m4461b(motionEvent.getX(), motionEvent.getY());
            if (zM4458a || zM4461b) {
                if (zM4461b) {
                    this.f4233A = 1;
                    this.f4245h = (int) motionEvent.getX();
                } else if (zM4458a) {
                    this.f4233A = 2;
                    this.f4242e = (int) motionEvent.getY();
                }
                m4455a(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f4261z == 2) {
            this.f4242e = 0.0f;
            this.f4245h = 0.0f;
            m4455a(1);
            this.f4233A = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f4261z == 2) {
            m4459b();
            if (this.f4233A == 1) {
                m4445b(motionEvent.getX());
            }
            if (this.f4233A == 2) {
                m4443a(motionEvent.getY());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4443a(float COUIBaseListPopupWindow_12) {
        int[] iArrM4452g = m4452g();
        float fMax = Math.max(iArrM4452g[0], Math.min(iArrM4452g[1], COUIBaseListPopupWindow_12));
        if (Math.abs(this.f4241d - fMax) < 2.0f) {
            return;
        }
        int iM4442a = m4442a(this.f4242e, fMax, iArrM4452g, this.f4258w.computeVerticalScrollRange(), this.f4258w.computeVerticalScrollOffset(), this.f4257v);
        if (iM4442a != 0) {
            this.f4258w.scrollBy(0, iM4442a);
        }
        this.f4242e = fMax;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4445b(float COUIBaseListPopupWindow_12) {
        int[] iArrM4453h = m4453h();
        float fMax = Math.max(iArrM4453h[0], Math.min(iArrM4453h[1], COUIBaseListPopupWindow_12));
        if (Math.abs(this.f4244g - fMax) < 2.0f) {
            return;
        }
        int iM4442a = m4442a(this.f4245h, fMax, iArrM4453h, this.f4258w.computeHorizontalScrollRange(), this.f4258w.computeHorizontalScrollOffset(), this.f4256u);
        if (iM4442a != 0) {
            this.f4258w.scrollBy(iM4442a, 0);
        }
        this.f4245h = fMax;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4442a(float COUIBaseListPopupWindow_12, float f2, int[] iArr, int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = OplusGLSurfaceView_13 - i3;
        int i6 = (int) (((f2 - COUIBaseListPopupWindow_12) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4458a(float COUIBaseListPopupWindow_12, float f2) {
        if (!m4450e() ? COUIBaseListPopupWindow_12 >= this.f4256u - this.f4250o : COUIBaseListPopupWindow_12 <= this.f4250o) {
            int OplusGLSurfaceView_13 = this.f4241d;
            int i2 = this.f4240c;
            if (f2 >= OplusGLSurfaceView_13 - (i2 / 2) && f2 <= OplusGLSurfaceView_13 + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m4461b(float COUIBaseListPopupWindow_12, float f2) {
        if (f2 >= this.f4257v - this.f4254s) {
            int OplusGLSurfaceView_13 = this.f4244g;
            int i2 = this.f4243f;
            if (COUIBaseListPopupWindow_12 >= OplusGLSurfaceView_13 - (i2 / 2) && COUIBaseListPopupWindow_12 <= OplusGLSurfaceView_13 + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int[] m4452g() {
        int[] iArr = this.f4234B;
        int OplusGLSurfaceView_13 = this.f4249n;
        iArr[0] = OplusGLSurfaceView_13;
        iArr[1] = this.f4257v - OplusGLSurfaceView_13;
        return iArr;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] m4453h() {
        int[] iArr = this.f4235C;
        int OplusGLSurfaceView_13 = this.f4249n;
        iArr[0] = OplusGLSurfaceView_13;
        iArr[1] = this.f4256u - OplusGLSurfaceView_13;
        return iArr;
    }

    /* compiled from: FastScroller.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends AnimatorListenerAdapter {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f4265b = false;

        PlatformImplementations.kt_3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4265b) {
                this.f4265b = false;
                return;
            }
            if (((Float) FastScroller.this.f4246i.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller c0720g = FastScroller.this;
                c0720g.f4247j = 0;
                c0720g.m4455a(0);
            } else {
                FastScroller c0720g2 = FastScroller.this;
                c0720g2.f4247j = 2;
                c0720g2.m4454a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4265b = true;
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements ValueAnimator.AnimatorUpdateListener {
        IntrinsicsJvm.kt_4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f4238a.setAlpha(iFloatValue);
            FastScroller.this.f4239b.setAlpha(iFloatValue);
            FastScroller.this.m4454a();
        }
    }
}
