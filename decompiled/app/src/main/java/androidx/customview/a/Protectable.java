package androidx.customview.a_renamed;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class c_renamed {
    private static final android.view.animation.Interpolator v_renamed = new android.view.animation.Interpolator() { // from class: androidx.customview.a_renamed.c_renamed.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f_renamed) {
            float f2 = f_renamed - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f1040a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f1041b;
    private float[] d_renamed;
    private float[] e_renamed;
    private float[] f_renamed;
    private float[] g_renamed;
    private int[] h_renamed;
    private int[] i_renamed;
    private int[] j_renamed;
    private int k_renamed;
    private android.view.VelocityTracker l_renamed;
    private float m_renamed;
    private float n_renamed;
    private int o_renamed;
    private int p_renamed;
    private android.widget.OverScroller q_renamed;
    private final androidx.customview.a_renamed.c_renamed.a_renamed r_renamed;
    private android.view.View s_renamed;
    private boolean t_renamed;
    private final android.view.ViewGroup u_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f1042c = -1;
    private final java.lang.Runnable w_renamed = new java.lang.Runnable() { // from class: androidx.customview.a_renamed.c_renamed.2
        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.a_renamed.c_renamed.this.c_renamed(0);
        }
    };

    /* compiled from: ViewDragHelper.java */
    public static abstract class a_renamed {
        public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i_renamed) {
            return i_renamed;
        }

        public int getViewHorizontalDragRange(android.view.View view) {
            return 0;
        }

        public int getViewVerticalDragRange(android.view.View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i_renamed, int i2) {
        }

        public boolean onEdgeLock(int i_renamed) {
            return false;
        }

        public void onEdgeTouched(int i_renamed, int i2) {
        }

        public void onViewCaptured(android.view.View view, int i_renamed) {
        }

        public void onViewDragStateChanged(int i_renamed) {
        }

        public void onViewPositionChanged(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        }

        public void onViewReleased(android.view.View view, float f_renamed, float f2) {
        }

        public abstract boolean tryCaptureView(android.view.View view, int i_renamed);
    }

    public static androidx.customview.a_renamed.c_renamed a_renamed(android.view.ViewGroup viewGroup, androidx.customview.a_renamed.c_renamed.a_renamed aVar) {
        return new androidx.customview.a_renamed.c_renamed(viewGroup.getContext(), viewGroup, aVar);
    }

    public static androidx.customview.a_renamed.c_renamed a_renamed(android.view.ViewGroup viewGroup, float f_renamed, androidx.customview.a_renamed.c_renamed.a_renamed aVar) {
        androidx.customview.a_renamed.c_renamed cVarA = a_renamed(viewGroup, aVar);
        cVarA.f1041b = (int) (cVarA.f1041b * (1.0f / f_renamed));
        return cVarA;
    }

    private c_renamed(android.content.Context context, android.view.ViewGroup viewGroup, androidx.customview.a_renamed.c_renamed.a_renamed aVar) {
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("Parent view may not be_renamed null");
        }
        if (aVar == null) {
            throw new java.lang.IllegalArgumentException("Callback may not be_renamed null");
        }
        this.u_renamed = viewGroup;
        this.r_renamed = aVar;
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.o_renamed = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1041b = viewConfiguration.getScaledTouchSlop();
        this.m_renamed = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n_renamed = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q_renamed = new android.widget.OverScroller(context, v_renamed);
    }

    public int a_renamed() {
        return this.f1040a;
    }

    public void a_renamed(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    public int b_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(android.view.View view, int i_renamed) {
        if (view.getParent() != this.u_renamed) {
            throw new java.lang.IllegalArgumentException("captureChildView: parameter must be_renamed a_renamed descendant of_renamed the ViewDragHelper's_renamed tracked parent view (" + this.u_renamed + ")");
        }
        this.s_renamed = view;
        this.f1042c = i_renamed;
        this.r_renamed.onViewCaptured(view, i_renamed);
        c_renamed(1);
    }

    public android.view.View c_renamed() {
        return this.s_renamed;
    }

    public int d_renamed() {
        return this.f1041b;
    }

    public void e_renamed() {
        this.f1042c = -1;
        g_renamed();
        android.view.VelocityTracker velocityTracker = this.l_renamed;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l_renamed = null;
        }
    }

    public void f_renamed() {
        e_renamed();
        if (this.f1040a == 2) {
            int currX = this.q_renamed.getCurrX();
            int currY = this.q_renamed.getCurrY();
            this.q_renamed.abortAnimation();
            int currX2 = this.q_renamed.getCurrX();
            int currY2 = this.q_renamed.getCurrY();
            this.r_renamed.onViewPositionChanged(this.s_renamed, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        c_renamed(0);
    }

    public boolean a_renamed(android.view.View view, int i_renamed, int i2) {
        this.s_renamed = view;
        this.f1042c = -1;
        boolean zA = a_renamed(i_renamed, i2, 0, 0);
        if (!zA && this.f1040a == 0 && this.s_renamed != null) {
            this.s_renamed = null;
        }
        return zA;
    }

    public boolean a_renamed(int i_renamed, int i2) {
        if (!this.t_renamed) {
            throw new java.lang.IllegalStateException("Cannot settleCapturedViewAt outside of_renamed a_renamed call to Callback#onViewReleased");
        }
        return a_renamed(i_renamed, i2, (int) this.l_renamed.getXVelocity(this.f1042c), (int) this.l_renamed.getYVelocity(this.f1042c));
    }

    private boolean a_renamed(int i_renamed, int i2, int i3, int i4) {
        int left = this.s_renamed.getLeft();
        int top = this.s_renamed.getTop();
        int i5 = i_renamed - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q_renamed.abortAnimation();
            c_renamed(0);
            return false;
        }
        this.q_renamed.startScroll(left, top, i5, i6, a_renamed(this.s_renamed, i5, i6, i3, i4));
        c_renamed(2);
        return true;
    }

    private int a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        float f_renamed;
        float f2;
        float f3;
        float f4;
        int iB = b_renamed(i3, (int) this.n_renamed, (int) this.m_renamed);
        int iB2 = b_renamed(i4, (int) this.n_renamed, (int) this.m_renamed);
        int iAbs = java.lang.Math.abs(i_renamed);
        int iAbs2 = java.lang.Math.abs(i2);
        int iAbs3 = java.lang.Math.abs(iB);
        int iAbs4 = java.lang.Math.abs(iB2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iB != 0) {
            f_renamed = iAbs3;
            f2 = i5;
        } else {
            f_renamed = iAbs;
            f2 = i6;
        }
        float f5 = f_renamed / f2;
        if (iB2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((a_renamed(i_renamed, iB, this.r_renamed.getViewHorizontalDragRange(view)) * f5) + (a_renamed(i2, iB2, this.r_renamed.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    private int a_renamed(int i_renamed, int i2, int i3) {
        int iAbs;
        if (i_renamed == 0) {
            return 0;
        }
        int width = this.u_renamed.getWidth();
        float f_renamed = width / 2;
        float fA_renamed = f_renamed + (a_renamed(java.lang.Math.min(1.0f, java.lang.Math.abs(i_renamed) / width)) * f_renamed);
        int iAbs2 = java.lang.Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = java.lang.Math.round(java.lang.Math.abs(fA_renamed / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((java.lang.Math.abs(i_renamed) / i3) + 1.0f) * 256.0f);
        }
        return java.lang.Math.min(iAbs, 600);
    }

    private int b_renamed(int i_renamed, int i2, int i3) {
        int iAbs = java.lang.Math.abs(i_renamed);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i_renamed > 0 ? i3 : -i3 : i_renamed;
    }

    private float a_renamed(float f_renamed, float f2, float f3) {
        float fAbs = java.lang.Math.abs(f_renamed);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f_renamed > 0.0f ? f3 : -f3 : f_renamed;
    }

    private float a_renamed(float f_renamed) {
        return (float) java.lang.Math.sin((f_renamed - 0.5f) * 0.47123894f);
    }

    public boolean a_renamed(boolean z_renamed) {
        if (this.f1040a == 2) {
            boolean zComputeScrollOffset = this.q_renamed.computeScrollOffset();
            int currX = this.q_renamed.getCurrX();
            int currY = this.q_renamed.getCurrY();
            int left = currX - this.s_renamed.getLeft();
            int top = currY - this.s_renamed.getTop();
            if (left != 0) {
                androidx.core.h_renamed.v_renamed.f_renamed(this.s_renamed, left);
            }
            if (top != 0) {
                androidx.core.h_renamed.v_renamed.e_renamed(this.s_renamed, top);
            }
            if (left != 0 || top != 0) {
                this.r_renamed.onViewPositionChanged(this.s_renamed, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.q_renamed.getFinalX() && currY == this.q_renamed.getFinalY()) {
                this.q_renamed.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z_renamed) {
                    this.u_renamed.post(this.w_renamed);
                } else {
                    c_renamed(0);
                }
            }
        }
        return this.f1040a == 2;
    }

    private void a_renamed(float f_renamed, float f2) {
        this.t_renamed = true;
        this.r_renamed.onViewReleased(this.s_renamed, f_renamed, f2);
        this.t_renamed = false;
        if (this.f1040a == 1) {
            c_renamed(0);
        }
    }

    private void g_renamed() {
        float[] fArr = this.d_renamed;
        if (fArr == null) {
            return;
        }
        java.util.Arrays.fill(fArr, 0.0f);
        java.util.Arrays.fill(this.e_renamed, 0.0f);
        java.util.Arrays.fill(this.f_renamed, 0.0f);
        java.util.Arrays.fill(this.g_renamed, 0.0f);
        java.util.Arrays.fill(this.h_renamed, 0);
        java.util.Arrays.fill(this.i_renamed, 0);
        java.util.Arrays.fill(this.j_renamed, 0);
        this.k_renamed = 0;
    }

    private void e_renamed(int i_renamed) {
        if (this.d_renamed == null || !b_renamed(i_renamed)) {
            return;
        }
        this.d_renamed[i_renamed] = 0.0f;
        this.e_renamed[i_renamed] = 0.0f;
        this.f_renamed[i_renamed] = 0.0f;
        this.g_renamed[i_renamed] = 0.0f;
        this.h_renamed[i_renamed] = 0;
        this.i_renamed[i_renamed] = 0;
        this.j_renamed[i_renamed] = 0;
        this.k_renamed = (~(1 << i_renamed)) & this.k_renamed;
    }

    private void f_renamed(int i_renamed) {
        float[] fArr = this.d_renamed;
        if (fArr == null || fArr.length <= i_renamed) {
            int i2 = i_renamed + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.d_renamed;
            if (fArr6 != null) {
                java.lang.System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.e_renamed;
                java.lang.System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f_renamed;
                java.lang.System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.g_renamed;
                java.lang.System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.h_renamed;
                java.lang.System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i_renamed;
                java.lang.System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j_renamed;
                java.lang.System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d_renamed = fArr2;
            this.e_renamed = fArr3;
            this.f_renamed = fArr4;
            this.g_renamed = fArr5;
            this.h_renamed = iArr;
            this.i_renamed = iArr2;
            this.j_renamed = iArr3;
        }
    }

    private void a_renamed(float f_renamed, float f2, int i_renamed) {
        f_renamed(i_renamed);
        float[] fArr = this.d_renamed;
        this.f_renamed[i_renamed] = f_renamed;
        fArr[i_renamed] = f_renamed;
        float[] fArr2 = this.e_renamed;
        this.g_renamed[i_renamed] = f2;
        fArr2[i_renamed] = f2;
        this.h_renamed[i_renamed] = e_renamed((int) f_renamed, (int) f2);
        this.k_renamed |= 1 << i_renamed;
    }

    private void c_renamed(android.view.MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i_renamed = 0; i_renamed < pointerCount; i_renamed++) {
            int pointerId = motionEvent.getPointerId(i_renamed);
            if (g_renamed(pointerId)) {
                float x_renamed = motionEvent.getX(i_renamed);
                float y_renamed = motionEvent.getY(i_renamed);
                this.f_renamed[pointerId] = x_renamed;
                this.g_renamed[pointerId] = y_renamed;
            }
        }
    }

    public boolean b_renamed(int i_renamed) {
        return (this.k_renamed & (1 << i_renamed)) != 0;
    }

    void c_renamed(int i_renamed) {
        this.u_renamed.removeCallbacks(this.w_renamed);
        if (this.f1040a != i_renamed) {
            this.f1040a = i_renamed;
            this.r_renamed.onViewDragStateChanged(i_renamed);
            if (this.f1040a == 0) {
                this.s_renamed = null;
            }
        }
    }

    boolean b_renamed(android.view.View view, int i_renamed) {
        if (view == this.s_renamed && this.f1042c == i_renamed) {
            return true;
        }
        if (view == null || !this.r_renamed.tryCaptureView(view, i_renamed)) {
            return false;
        }
        this.f1042c = i_renamed;
        a_renamed(view, i_renamed);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.a_renamed.c_renamed.a_renamed(android.view.MotionEvent):boolean");
    }

    public void b_renamed(android.view.MotionEvent motionEvent) {
        int i_renamed;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            e_renamed();
        }
        if (this.l_renamed == null) {
            this.l_renamed = android.view.VelocityTracker.obtain();
        }
        this.l_renamed.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x_renamed = motionEvent.getX();
            float y_renamed = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            android.view.View viewD = d_renamed((int) x_renamed, (int) y_renamed);
            a_renamed(x_renamed, y_renamed, pointerId);
            b_renamed(viewD, pointerId);
            int i3 = this.h_renamed[pointerId];
            int i4 = this.p_renamed;
            if ((i3 & i4) != 0) {
                this.r_renamed.onEdgeTouched(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1040a == 1) {
                h_renamed();
            }
            e_renamed();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1040a == 1) {
                if (g_renamed(this.f1042c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1042c);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f_renamed;
                    int i5 = this.f1042c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.g_renamed[i5]);
                    b_renamed(this.s_renamed.getLeft() + i6, this.s_renamed.getTop() + i7, i6, i7);
                    c_renamed(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (g_renamed(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f_renamed = x3 - this.d_renamed[pointerId2];
                    float f2 = y3 - this.e_renamed[pointerId2];
                    b_renamed(f_renamed, f2, pointerId2);
                    if (this.f1040a != 1) {
                        android.view.View viewD2 = d_renamed((int) x3, (int) y3);
                        if (a_renamed(viewD2, f_renamed, f2) && b_renamed(viewD2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            c_renamed(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f1040a == 1) {
                a_renamed(0.0f, 0.0f);
            }
            e_renamed();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            a_renamed(x4, y4, pointerId3);
            if (this.f1040a == 0) {
                b_renamed(d_renamed((int) x4, (int) y4), pointerId3);
                int i8 = this.h_renamed[pointerId3];
                int i9 = this.p_renamed;
                if ((i8 & i9) != 0) {
                    this.r_renamed.onEdgeTouched(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
            if (c_renamed((int) x4, (int) y4)) {
                b_renamed(this.s_renamed, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f1040a == 1 && pointerId4 == this.f1042c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i_renamed = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.f1042c) {
                    android.view.View viewD3 = d_renamed((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    android.view.View view = this.s_renamed;
                    if (viewD3 == view && b_renamed(view, pointerId5)) {
                        i_renamed = this.f1042c;
                        break;
                    }
                }
                i2++;
            }
            if (i_renamed == -1) {
                h_renamed();
            }
        }
        e_renamed(pointerId4);
    }

    private void b_renamed(float f_renamed, float f2, int i_renamed) {
        int i2 = a_renamed(f_renamed, f2, i_renamed, 1) ? 1 : 0;
        if (a_renamed(f2, f_renamed, i_renamed, 4)) {
            i2 |= 4;
        }
        if (a_renamed(f_renamed, f2, i_renamed, 2)) {
            i2 |= 2;
        }
        if (a_renamed(f2, f_renamed, i_renamed, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i_renamed;
            iArr[i_renamed] = iArr[i_renamed] | i2;
            this.r_renamed.onEdgeDragStarted(i2, i_renamed);
        }
    }

    private boolean a_renamed(float f_renamed, float f2, int i_renamed, int i2) {
        float fAbs = java.lang.Math.abs(f_renamed);
        float fAbs2 = java.lang.Math.abs(f2);
        if ((this.h_renamed[i_renamed] & i2) != i2 || (this.p_renamed & i2) == 0 || (this.j_renamed[i_renamed] & i2) == i2 || (this.i_renamed[i_renamed] & i2) == i2) {
            return false;
        }
        int i3 = this.f1041b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r_renamed.onEdgeLock(i2)) {
            return (this.i_renamed[i_renamed] & i2) == 0 && fAbs > ((float) this.f1041b);
        }
        int[] iArr = this.j_renamed;
        iArr[i_renamed] = iArr[i_renamed] | i2;
        return false;
    }

    private boolean a_renamed(android.view.View view, float f_renamed, float f2) {
        if (view == null) {
            return false;
        }
        boolean z_renamed = this.r_renamed.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.r_renamed.getViewVerticalDragRange(view) > 0;
        if (!z_renamed || !z2) {
            return z_renamed ? java.lang.Math.abs(f_renamed) > ((float) this.f1041b) : z2 && java.lang.Math.abs(f2) > ((float) this.f1041b);
        }
        float f3 = (f_renamed * f_renamed) + (f2 * f2);
        int i_renamed = this.f1041b;
        return f3 > ((float) (i_renamed * i_renamed));
    }

    public boolean d_renamed(int i_renamed) {
        int length = this.d_renamed.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b_renamed(i_renamed, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b_renamed(int i_renamed, int i2) {
        if (!b_renamed(i2)) {
            return false;
        }
        boolean z_renamed = (i_renamed & 1) == 1;
        boolean z2 = (i_renamed & 2) == 2;
        float f_renamed = this.f_renamed[i2] - this.d_renamed[i2];
        float f2 = this.g_renamed[i2] - this.e_renamed[i2];
        if (!z_renamed || !z2) {
            return z_renamed ? java.lang.Math.abs(f_renamed) > ((float) this.f1041b) : z2 && java.lang.Math.abs(f2) > ((float) this.f1041b);
        }
        float f3 = (f_renamed * f_renamed) + (f2 * f2);
        int i3 = this.f1041b;
        return f3 > ((float) (i3 * i3));
    }

    private void h_renamed() {
        this.l_renamed.computeCurrentVelocity(1000, this.m_renamed);
        a_renamed(a_renamed(this.l_renamed.getXVelocity(this.f1042c), this.n_renamed, this.m_renamed), a_renamed(this.l_renamed.getYVelocity(this.f1042c), this.n_renamed, this.m_renamed));
    }

    private void b_renamed(int i_renamed, int i2, int i3, int i4) {
        int left = this.s_renamed.getLeft();
        int top = this.s_renamed.getTop();
        if (i3 != 0) {
            i_renamed = this.r_renamed.clampViewPositionHorizontal(this.s_renamed, i_renamed, i3);
            androidx.core.h_renamed.v_renamed.f_renamed(this.s_renamed, i_renamed - left);
        }
        int i5 = i_renamed;
        if (i4 != 0) {
            i2 = this.r_renamed.clampViewPositionVertical(this.s_renamed, i2, i4);
            androidx.core.h_renamed.v_renamed.e_renamed(this.s_renamed, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r_renamed.onViewPositionChanged(this.s_renamed, i5, i6, i5 - left, i6 - top);
    }

    public boolean c_renamed(int i_renamed, int i2) {
        return b_renamed(this.s_renamed, i_renamed, i2);
    }

    public boolean b_renamed(android.view.View view, int i_renamed, int i2) {
        return view != null && i_renamed >= view.getLeft() && i_renamed < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public android.view.View d_renamed(int i_renamed, int i2) {
        for (int childCount = this.u_renamed.getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = this.u_renamed.getChildAt(this.r_renamed.getOrderedChildIndex(childCount));
            if (i_renamed >= childAt.getLeft() && i_renamed < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int e_renamed(int i_renamed, int i2) {
        int i3 = i_renamed < this.u_renamed.getLeft() + this.o_renamed ? 1 : 0;
        if (i2 < this.u_renamed.getTop() + this.o_renamed) {
            i3 |= 4;
        }
        if (i_renamed > this.u_renamed.getRight() - this.o_renamed) {
            i3 |= 2;
        }
        return i2 > this.u_renamed.getBottom() - this.o_renamed ? i3 | 8 : i3;
    }

    private boolean g_renamed(int i_renamed) {
        if (b_renamed(i_renamed)) {
            return true;
        }
        android.util.Log.e_renamed("ViewDragHelper", "Ignoring pointerId=" + i_renamed + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in_renamed the event stream.");
        return false;
    }
}
