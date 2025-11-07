package androidx.customview.p039a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.p036h.ViewCompat;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ViewDragHelper {

    /* renamed from: v */
    private static final Interpolator f3189v = new Interpolator() { // from class: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            float f2 = COUIBaseListPopupWindow_12 - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private int f3190a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f3191b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float[] f3193d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float[] f3194e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float[] f3195f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float[] f3196g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f3197h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int[] f3198i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int[] f3199j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f3200k;

    /* renamed from: OplusGLSurfaceView_14 */
    private VelocityTracker f3201l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f3202m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f3203n;

    /* renamed from: o */
    private int f3204o;

    /* renamed from: p */
    private int f3205p;

    /* renamed from: q */
    private OverScroller f3206q;

    /* renamed from: r */
    private final PlatformImplementations.kt_3 f3207r;

    /* renamed from: s */
    private View f3208s;

    /* renamed from: t */
    private boolean f3209t;

    /* renamed from: u */
    private final ViewGroup f3210u;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f3192c = -1;

    /* renamed from: w */
    private final Runnable f3211w = new Runnable() { // from class: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.m3121c(0);
        }
    };

    /* compiled from: ViewDragHelper.java */
    /* renamed from: androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int OplusGLSurfaceView_13, int i2) {
        }

        public boolean onEdgeLock(int OplusGLSurfaceView_13) {
            return false;
        }

        public void onEdgeTouched(int OplusGLSurfaceView_13, int i2) {
        }

        public void onViewCaptured(View view, int OplusGLSurfaceView_13) {
        }

        public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
        }

        public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ViewDragHelper m3091a(ViewGroup viewGroup, PlatformImplementations.kt_3 aVar) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ViewDragHelper m3090a(ViewGroup viewGroup, float COUIBaseListPopupWindow_12, PlatformImplementations.kt_3 aVar) {
        ViewDragHelper c0535cM3091a = m3091a(viewGroup, aVar);
        c0535cM3091a.f3191b = (int) (c0535cM3091a.f3191b * (1.0f / COUIBaseListPopupWindow_12));
        return c0535cM3091a;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, PlatformImplementations.kt_3 aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f3210u = viewGroup;
        this.f3207r = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3204o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f3191b = viewConfiguration.getScaledTouchSlop();
        this.f3202m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3203n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3206q = new OverScroller(context, f3189v);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m3107a() {
        return this.f3190a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3108a(int OplusGLSurfaceView_13) {
        this.f3205p = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m3114b() {
        return this.f3204o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3109a(View view, int OplusGLSurfaceView_13) {
        if (view.getParent() != this.f3210u) {
            throw new IllegalArgumentException("captureChildView: parameter must be PlatformImplementations.kt_3 descendant of the ViewDragHelper's tracked parent view (" + this.f3210u + ")");
        }
        this.f3208s = view;
        this.f3192c = OplusGLSurfaceView_13;
        this.f3207r.onViewCaptured(view, OplusGLSurfaceView_13);
        m3121c(1);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public View m3120c() {
        return this.f3208s;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m3123d() {
        return this.f3191b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3126e() {
        this.f3192c = -1;
        m3104g();
        VelocityTracker velocityTracker = this.f3201l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3201l = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3127f() {
        m3126e();
        if (this.f3190a == 2) {
            int currX = this.f3206q.getCurrX();
            int currY = this.f3206q.getCurrY();
            this.f3206q.abortAnimation();
            int currX2 = this.f3206q.getCurrX();
            int currY2 = this.f3206q.getCurrY();
            this.f3207r.onViewPositionChanged(this.f3208s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        m3121c(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3112a(View view, int OplusGLSurfaceView_13, int i2) {
        this.f3208s = view;
        this.f3192c = -1;
        boolean zM3095a = m3095a(OplusGLSurfaceView_13, i2, 0, 0);
        if (!zM3095a && this.f3190a == 0 && this.f3208s != null) {
            this.f3208s = null;
        }
        return zM3095a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3110a(int OplusGLSurfaceView_13, int i2) {
        if (!this.f3209t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of PlatformImplementations.kt_3 call to Callback#onViewReleased");
        }
        return m3095a(OplusGLSurfaceView_13, i2, (int) this.f3201l.getXVelocity(this.f3192c), (int) this.f3201l.getYVelocity(this.f3192c));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3095a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int left = this.f3208s.getLeft();
        int top = this.f3208s.getTop();
        int i5 = OplusGLSurfaceView_13 - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f3206q.abortAnimation();
            m3121c(0);
            return false;
        }
        this.f3206q.startScroll(left, top, i5, i6, m3089a(this.f3208s, i5, i6, i3, i4));
        m3121c(2);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m3089a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float f4;
        int iM3097b = m3097b(i3, (int) this.f3203n, (int) this.f3202m);
        int iM3097b2 = m3097b(i4, (int) this.f3203n, (int) this.f3202m);
        int iAbs = Math.abs(OplusGLSurfaceView_13);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iM3097b);
        int iAbs4 = Math.abs(iM3097b2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iM3097b != 0) {
            COUIBaseListPopupWindow_12 = iAbs3;
            f2 = i5;
        } else {
            COUIBaseListPopupWindow_12 = iAbs;
            f2 = i6;
        }
        float f5 = COUIBaseListPopupWindow_12 / f2;
        if (iM3097b2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((m3088a(OplusGLSurfaceView_13, iM3097b, this.f3207r.getViewHorizontalDragRange(view)) * f5) + (m3088a(i2, iM3097b2, this.f3207r.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m3088a(int OplusGLSurfaceView_13, int i2, int i3) {
        int iAbs;
        if (OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        int width = this.f3210u.getWidth();
        float COUIBaseListPopupWindow_12 = width / 2;
        float fM3086a = COUIBaseListPopupWindow_12 + (m3086a(Math.min(1.0f, Math.abs(OplusGLSurfaceView_13) / width)) * COUIBaseListPopupWindow_12);
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM3086a / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(OplusGLSurfaceView_13) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(iAbs, 600);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m3097b(int OplusGLSurfaceView_13, int i2, int i3) {
        int iAbs = Math.abs(OplusGLSurfaceView_13);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? OplusGLSurfaceView_13 > 0 ? i3 : -i3 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m3087a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        float fAbs = Math.abs(COUIBaseListPopupWindow_12);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? COUIBaseListPopupWindow_12 > 0.0f ? f3 : -f3 : COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m3086a(float COUIBaseListPopupWindow_12) {
        return (float) Math.sin((COUIBaseListPopupWindow_12 - 0.5f) * 0.47123894f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3113a(boolean z) {
        if (this.f3190a == 2) {
            boolean zComputeScrollOffset = this.f3206q.computeScrollOffset();
            int currX = this.f3206q.getCurrX();
            int currY = this.f3206q.getCurrY();
            int left = currX - this.f3208s.getLeft();
            int top = currY - this.f3208s.getTop();
            if (left != 0) {
                ViewCompat.m2884f(this.f3208s, left);
            }
            if (top != 0) {
                ViewCompat.m2882e(this.f3208s, top);
            }
            if (left != 0 || top != 0) {
                this.f3207r.onViewPositionChanged(this.f3208s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f3206q.getFinalX() && currY == this.f3206q.getFinalY()) {
                this.f3206q.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.f3210u.post(this.f3211w);
                } else {
                    m3121c(0);
                }
            }
        }
        return this.f3190a == 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3092a(float COUIBaseListPopupWindow_12, float f2) {
        this.f3209t = true;
        this.f3207r.onViewReleased(this.f3208s, COUIBaseListPopupWindow_12, f2);
        this.f3209t = false;
        if (this.f3190a == 1) {
            m3121c(0);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m3104g() {
        float[] fArr = this.f3193d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f3194e, 0.0f);
        Arrays.fill(this.f3195f, 0.0f);
        Arrays.fill(this.f3196g, 0.0f);
        Arrays.fill(this.f3197h, 0);
        Arrays.fill(this.f3198i, 0);
        Arrays.fill(this.f3199j, 0);
        this.f3200k = 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m3102e(int OplusGLSurfaceView_13) {
        if (this.f3193d == null || !m3116b(OplusGLSurfaceView_13)) {
            return;
        }
        this.f3193d[OplusGLSurfaceView_13] = 0.0f;
        this.f3194e[OplusGLSurfaceView_13] = 0.0f;
        this.f3195f[OplusGLSurfaceView_13] = 0.0f;
        this.f3196g[OplusGLSurfaceView_13] = 0.0f;
        this.f3197h[OplusGLSurfaceView_13] = 0;
        this.f3198i[OplusGLSurfaceView_13] = 0;
        this.f3199j[OplusGLSurfaceView_13] = 0;
        this.f3200k = (~(1 << OplusGLSurfaceView_13)) & this.f3200k;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m3103f(int OplusGLSurfaceView_13) {
        float[] fArr = this.f3193d;
        if (fArr == null || fArr.length <= OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f3193d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f3194e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f3195f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f3196g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f3197h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3198i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3199j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3193d = fArr2;
            this.f3194e = fArr3;
            this.f3195f = fArr4;
            this.f3196g = fArr5;
            this.f3197h = iArr;
            this.f3198i = iArr2;
            this.f3199j = iArr3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3093a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        m3103f(OplusGLSurfaceView_13);
        float[] fArr = this.f3193d;
        this.f3195f[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_12;
        fArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_12;
        float[] fArr2 = this.f3194e;
        this.f3196g[OplusGLSurfaceView_13] = f2;
        fArr2[OplusGLSurfaceView_13] = f2;
        this.f3197h[OplusGLSurfaceView_13] = m3101e((int) COUIBaseListPopupWindow_12, (int) f2);
        this.f3200k |= 1 << OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3100c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < pointerCount; OplusGLSurfaceView_13++) {
            int pointerId = motionEvent.getPointerId(OplusGLSurfaceView_13);
            if (m3105g(pointerId)) {
                float x = motionEvent.getX(OplusGLSurfaceView_13);
                float y = motionEvent.getY(OplusGLSurfaceView_13);
                this.f3195f[pointerId] = x;
                this.f3196g[pointerId] = y;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3116b(int OplusGLSurfaceView_13) {
        return (this.f3200k & (1 << OplusGLSurfaceView_13)) != 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m3121c(int OplusGLSurfaceView_13) {
        this.f3210u.removeCallbacks(this.f3211w);
        if (this.f3190a != OplusGLSurfaceView_13) {
            this.f3190a = OplusGLSurfaceView_13;
            this.f3207r.onViewDragStateChanged(OplusGLSurfaceView_13);
            if (this.f3190a == 0) {
                this.f3208s = null;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m3118b(View view, int OplusGLSurfaceView_13) {
        if (view == this.f3208s && this.f3192c == OplusGLSurfaceView_13) {
            return true;
        }
        if (view == null || !this.f3207r.tryCaptureView(view, OplusGLSurfaceView_13)) {
            return false;
        }
        this.f3192c = OplusGLSurfaceView_13;
        m3109a(view, OplusGLSurfaceView_13);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m3111a(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.p039a.ViewDragHelper.m3111a(android.view.MotionEvent):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3115b(MotionEvent motionEvent) {
        int OplusGLSurfaceView_13;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m3126e();
        }
        if (this.f3201l == null) {
            this.f3201l = VelocityTracker.obtain();
        }
        this.f3201l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewM3124d = m3124d((int) x, (int) y);
            m3093a(x, y, pointerId);
            m3118b(viewM3124d, pointerId);
            int i3 = this.f3197h[pointerId];
            int i4 = this.f3205p;
            if ((i3 & i4) != 0) {
                this.f3207r.onEdgeTouched(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f3190a == 1) {
                m3106h();
            }
            m3126e();
            return;
        }
        if (actionMasked == 2) {
            if (this.f3190a == 1) {
                if (m3105g(this.f3192c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f3192c);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f3195f;
                    int i5 = this.f3192c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f3196g[i5]);
                    m3099b(this.f3208s.getLeft() + i6, this.f3208s.getTop() + i7, i6, i7);
                    m3100c(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (m3105g(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float COUIBaseListPopupWindow_12 = x3 - this.f3193d[pointerId2];
                    float f2 = y3 - this.f3194e[pointerId2];
                    m3098b(COUIBaseListPopupWindow_12, f2, pointerId2);
                    if (this.f3190a != 1) {
                        View viewM3124d2 = m3124d((int) x3, (int) y3);
                        if (m3096a(viewM3124d2, COUIBaseListPopupWindow_12, f2) && m3118b(viewM3124d2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m3100c(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f3190a == 1) {
                m3092a(0.0f, 0.0f);
            }
            m3126e();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            m3093a(x4, y4, pointerId3);
            if (this.f3190a == 0) {
                m3118b(m3124d((int) x4, (int) y4), pointerId3);
                int i8 = this.f3197h[pointerId3];
                int i9 = this.f3205p;
                if ((i8 & i9) != 0) {
                    this.f3207r.onEdgeTouched(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
            if (m3122c((int) x4, (int) y4)) {
                m3118b(this.f3208s, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f3190a == 1 && pointerId4 == this.f3192c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    OplusGLSurfaceView_13 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.f3192c) {
                    View viewM3124d3 = m3124d((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.f3208s;
                    if (viewM3124d3 == view && m3118b(view, pointerId5)) {
                        OplusGLSurfaceView_13 = this.f3192c;
                        break;
                    }
                }
                i2++;
            }
            if (OplusGLSurfaceView_13 == -1) {
                m3106h();
            }
        }
        m3102e(pointerId4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3098b(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        int i2 = m3094a(COUIBaseListPopupWindow_12, f2, OplusGLSurfaceView_13, 1) ? 1 : 0;
        if (m3094a(f2, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, 4)) {
            i2 |= 4;
        }
        if (m3094a(COUIBaseListPopupWindow_12, f2, OplusGLSurfaceView_13, 2)) {
            i2 |= 2;
        }
        if (m3094a(f2, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f3198i;
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] | i2;
            this.f3207r.onEdgeDragStarted(i2, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3094a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2) {
        float fAbs = Math.abs(COUIBaseListPopupWindow_12);
        float fAbs2 = Math.abs(f2);
        if ((this.f3197h[OplusGLSurfaceView_13] & i2) != i2 || (this.f3205p & i2) == 0 || (this.f3199j[OplusGLSurfaceView_13] & i2) == i2 || (this.f3198i[OplusGLSurfaceView_13] & i2) == i2) {
            return false;
        }
        int i3 = this.f3191b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f3207r.onEdgeLock(i2)) {
            return (this.f3198i[OplusGLSurfaceView_13] & i2) == 0 && fAbs > ((float) this.f3191b);
        }
        int[] iArr = this.f3199j;
        iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] | i2;
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3096a(View view, float COUIBaseListPopupWindow_12, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f3207r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f3207r.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(COUIBaseListPopupWindow_12) > ((float) this.f3191b) : z2 && Math.abs(f2) > ((float) this.f3191b);
        }
        float f3 = (COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2);
        int OplusGLSurfaceView_13 = this.f3191b;
        return f3 > ((float) (OplusGLSurfaceView_13 * OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m3125d(int OplusGLSurfaceView_13) {
        int length = this.f3193d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m3117b(OplusGLSurfaceView_13, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3117b(int OplusGLSurfaceView_13, int i2) {
        if (!m3116b(i2)) {
            return false;
        }
        boolean z = (OplusGLSurfaceView_13 & 1) == 1;
        boolean z2 = (OplusGLSurfaceView_13 & 2) == 2;
        float COUIBaseListPopupWindow_12 = this.f3195f[i2] - this.f3193d[i2];
        float f2 = this.f3196g[i2] - this.f3194e[i2];
        if (!z || !z2) {
            return z ? Math.abs(COUIBaseListPopupWindow_12) > ((float) this.f3191b) : z2 && Math.abs(f2) > ((float) this.f3191b);
        }
        float f3 = (COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2);
        int i3 = this.f3191b;
        return f3 > ((float) (i3 * i3));
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m3106h() {
        this.f3201l.computeCurrentVelocity(1000, this.f3202m);
        m3092a(m3087a(this.f3201l.getXVelocity(this.f3192c), this.f3203n, this.f3202m), m3087a(this.f3201l.getYVelocity(this.f3192c), this.f3203n, this.f3202m));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3099b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int left = this.f3208s.getLeft();
        int top = this.f3208s.getTop();
        if (i3 != 0) {
            OplusGLSurfaceView_13 = this.f3207r.clampViewPositionHorizontal(this.f3208s, OplusGLSurfaceView_13, i3);
            ViewCompat.m2884f(this.f3208s, OplusGLSurfaceView_13 - left);
        }
        int i5 = OplusGLSurfaceView_13;
        if (i4 != 0) {
            i2 = this.f3207r.clampViewPositionVertical(this.f3208s, i2, i4);
            ViewCompat.m2882e(this.f3208s, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f3207r.onViewPositionChanged(this.f3208s, i5, i6, i5 - left, i6 - top);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m3122c(int OplusGLSurfaceView_13, int i2) {
        return m3119b(this.f3208s, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3119b(View view, int OplusGLSurfaceView_13, int i2) {
        return view != null && OplusGLSurfaceView_13 >= view.getLeft() && OplusGLSurfaceView_13 < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public View m3124d(int OplusGLSurfaceView_13, int i2) {
        for (int childCount = this.f3210u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3210u.getChildAt(this.f3207r.getOrderedChildIndex(childCount));
            if (OplusGLSurfaceView_13 >= childAt.getLeft() && OplusGLSurfaceView_13 < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m3101e(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 < this.f3210u.getLeft() + this.f3204o ? 1 : 0;
        if (i2 < this.f3210u.getTop() + this.f3204o) {
            i3 |= 4;
        }
        if (OplusGLSurfaceView_13 > this.f3210u.getRight() - this.f3204o) {
            i3 |= 2;
        }
        return i2 > this.f3210u.getBottom() - this.f3204o ? i3 | 8 : i3;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m3105g(int OplusGLSurfaceView_13) {
        if (m3116b(OplusGLSurfaceView_13)) {
            return true;
        }
        Log.COUIBaseListPopupWindow_8("ViewDragHelper", "Ignoring pointerId=" + OplusGLSurfaceView_13 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
