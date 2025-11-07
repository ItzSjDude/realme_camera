package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.p036h.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.p099a.COUIPhysicalAnimationUtil;
import com.coui.appcompat.p099a.ViewNative;
import com.coui.appcompat.widget.COUIFlingLocateHelper;
import com.coui.appcompat.widget.COUILocateOverScroller;
import com.coui.appcompat.widget.SpringOverScroller;
import com.coui.appcompat.widget.COUIIOverScroller;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIRecyclerView extends RecyclerView {

    /* renamed from: A */
    private final int f3943A;

    /* renamed from: B */
    private RunnableC0669a f3944B;

    /* renamed from: C */
    private final int[] f3945C;

    /* renamed from: D */
    private final int[] f3946D;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f3947a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final int f3948b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final int f3949c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final int f3950d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final int f3951e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ArrayList<RecyclerView.InterfaceC0697m> f3952f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RecyclerView.InterfaceC0697m f3953g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f3954h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f3955i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f3956j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f3957k;

    /* renamed from: OplusGLSurfaceView_14 */
    private COUIIOverScroller f3958l;

    /* renamed from: OplusGLSurfaceView_6 */
    private SpringOverScroller f3959m;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUILocateOverScroller f3960n;

    /* renamed from: o */
    private COUIFlingLocateHelper f3961o;

    /* renamed from: p */
    private boolean f3962p;

    /* renamed from: q */
    private int f3963q;

    /* renamed from: r */
    private int f3964r;

    /* renamed from: s */
    private VelocityTracker f3965s;

    /* renamed from: t */
    private int f3966t;

    /* renamed from: u */
    private int f3967u;

    /* renamed from: v */
    private int f3968v;

    /* renamed from: w */
    private int f3969w;

    /* renamed from: x */
    private int f3970x;

    /* renamed from: y */
    private RecyclerView.AbstractC0696l f3971y;

    /* renamed from: z */
    private final int f3972z;

    public COUIRecyclerView(Context context) {
        this(context, null);
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f3947a = true;
        this.f3948b = 0;
        this.f3949c = 1;
        this.f3950d = 2;
        this.f3951e = 3;
        this.f3963q = 0;
        this.f3964r = -1;
        this.f3945C = new int[2];
        this.f3946D = new int[2];
        m4014a();
        m4019b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3970x = viewConfiguration.getScaledTouchSlop();
        this.f3972z = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3943A = viewConfiguration.getScaledMaximumFlingVelocity();
        m4020b(context);
        m4015a(context);
        this.f3961o = new COUIFlingLocateHelper();
        this.f3961o.m7780a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4014a() {
        if (this.f3944B == null) {
            this.f3944B = new RunnableC0669a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m4015a(Context context) {
        if (this.f3958l == null) {
            this.f3959m = new SpringOverScroller(context);
            this.f3960n = new COUILocateOverScroller(context);
            setIsUseNativeOverScroll(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4019b() {
        if (this.f3952f == null) {
            this.f3952f = new ArrayList<>();
        }
    }

    public void setHorizontalItemAlign(int OplusGLSurfaceView_13) {
        if (m4030f()) {
            setIsUseNativeOverScroll(true);
            this.f3961o.m7779a(OplusGLSurfaceView_13);
        }
    }

    public int getHorizontalItemAlign() {
        return this.f3961o.m7777a();
    }

    public void setIsUseNativeOverScroll(boolean z) {
        this.f3962p = z;
        if (this.f3962p) {
            this.f3958l = this.f3960n;
        } else {
            this.f3958l = this.f3959m;
        }
    }

    public boolean getIsUseNativeOverScroll() {
        return this.f3962p;
    }

    public void setHorizontalFlingFriction(float COUIBaseListPopupWindow_12) {
        this.f3960n.m7799a(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.AbstractC0693i abstractC0693i) {
        super.setLayoutManager(abstractC0693i);
        if (abstractC0693i != null) {
            if (abstractC0693i.canScrollHorizontally()) {
                this.f3959m.m8255d(3.2f);
            } else {
                this.f3959m.m8255d(2.15f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int OplusGLSurfaceView_13) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 1) {
                Log.w("COUIRecyclerView", "setScrollingTouchSlop(): bad argument constant " + OplusGLSurfaceView_13 + "; using default value");
            } else {
                this.f3970x = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f3970x = viewConfiguration.getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnFlingListener(RecyclerView.AbstractC0696l abstractC0696l) {
        this.f3971y = abstractC0696l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.AbstractC0696l getOnFlingListener() {
        return this.f3971y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getScrollState() {
        return this.f3963q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    void setScrollState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f3963q) {
            return;
        }
        this.f3963q = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 != 2) {
            m4022c();
        }
        dispatchOnScrollStateChanged(OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int OplusGLSurfaceView_13, int i2) {
        if (this.mLayout == null) {
            Log.COUIBaseListPopupWindow_8("COUIRecyclerView", "Cannot scroll without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                OplusGLSurfaceView_13 = 0;
            }
            if (!zCanScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(OplusGLSurfaceView_13, i2, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    boolean scrollByInternal(int OplusGLSurfaceView_13, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        consumePendingUpdateOperations();
        if (this.mAdapter == null || ((OplusGLSurfaceView_13 == 0 && i2 == 0) || (this.f3947a && ((getScrollY() < 0 && i2 > 0) || ((getScrollY() > 0 && i2 < 0) || ((getScrollX() < 0 && OplusGLSurfaceView_13 > 0) || (getScrollX() > 0 && OplusGLSurfaceView_13 < 0))))))) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        } else {
            this.mReusableIntPair[0] = 0;
            this.mReusableIntPair[1] = 0;
            scrollStep(OplusGLSurfaceView_13, i2, this.mReusableIntPair);
            int i10 = this.mReusableIntPair[0];
            int i11 = this.mReusableIntPair[1];
            i4 = i10;
            i3 = i11;
            i5 = OplusGLSurfaceView_13 - i10;
            i6 = i2 - i11;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        this.mReusableIntPair[0] = 0;
        this.mReusableIntPair[1] = 0;
        int i12 = i3;
        int i13 = i4;
        dispatchNestedScroll(i4, i3, i5, i6, this.f3945C, 0, this.mReusableIntPair);
        int i14 = i5 - this.mReusableIntPair[0];
        int i15 = i6 - this.mReusableIntPair[1];
        int i16 = this.f3968v;
        int[] iArr = this.f3945C;
        this.f3968v = i16 - iArr[0];
        this.f3969w -= iArr[1];
        if (motionEvent != null) {
            motionEvent.offsetLocation(iArr[0], iArr[1]);
        }
        int[] iArr2 = this.f3946D;
        int i17 = iArr2[0];
        int[] iArr3 = this.f3945C;
        iArr2[0] = i17 + iArr3[0];
        iArr2[1] = iArr2[1] + iArr3[1];
        if (getOverScrollMode() == 2 || motionEvent == null || !this.f3947a) {
            i7 = i13;
            i8 = i12;
        } else {
            if (i15 != 0 || i14 != 0) {
                this.f3955i = 2;
            }
            if (Math.abs(i15) == 0 && Math.abs(i12) < this.f3970x && Math.abs(i2) < this.f3970x && Math.abs(getScrollY()) > this.f3970x) {
                this.f3955i = 2;
            }
            if (i15 == 0) {
                i8 = i12;
                if (i8 == 0 && Math.abs(i2) > this.f3970x) {
                    this.f3955i = 2;
                }
            } else {
                i8 = i12;
            }
            if (Math.abs(i14) == 0 && Math.abs(i13) < this.f3970x && Math.abs(OplusGLSurfaceView_13) < this.f3970x && Math.abs(getScrollX()) > this.f3970x) {
                this.f3955i = 2;
            }
            if (i14 == 0) {
                i9 = i13;
                if (i9 == 0 && Math.abs(OplusGLSurfaceView_13) > this.f3970x) {
                    this.f3955i = 2;
                }
            } else {
                i9 = i13;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int iM6449a = COUIPhysicalAnimationUtil.m6449a(i15, scrollY, this.f3956j);
            int iM6449a2 = COUIPhysicalAnimationUtil.m6449a(i14, scrollX, this.f3956j);
            if ((scrollY < 0 && i2 > 0) || (scrollY > 0 && i2 < 0)) {
                iM6449a = COUIPhysicalAnimationUtil.m6449a(i2, scrollX, this.f3956j);
            }
            int i18 = iM6449a;
            if ((scrollX < 0 && OplusGLSurfaceView_13 > 0) || (scrollX > 0 && OplusGLSurfaceView_13 < 0)) {
                iM6449a2 = COUIPhysicalAnimationUtil.m6449a(OplusGLSurfaceView_13, scrollX, this.f3956j);
            }
            if (i18 == 0 && iM6449a2 == 0) {
                i7 = i9;
            } else {
                int i19 = this.f3956j;
                i7 = i9;
                overScrollBy(iM6449a2, i18, scrollX, scrollY, 0, 0, i19, i19, true);
            }
        }
        if (i7 != 0 || i8 != 0) {
            dispatchOnScrolled(i7, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i7 == 0 && i8 == 0) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4020b(Context context) {
        int OplusGLSurfaceView_13 = context.getResources().getDisplayMetrics().heightPixels;
        this.f3956j = OplusGLSurfaceView_13;
        this.f3957k = OplusGLSurfaceView_13;
    }

    @Override // android.view.View
    protected void onOverScrolled(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        if (getScrollY() == i2 && getScrollX() == OplusGLSurfaceView_13) {
            return;
        }
        onScrollChanged(OplusGLSurfaceView_13, i2, getScrollX(), getScrollY());
        ViewNative.m6506b(this, OplusGLSurfaceView_13);
        ViewNative.m6504a(this, i2);
        invalidateParentIfNeeded();
        awakenScrollBars();
    }

    protected void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = OplusGLSurfaceView_13 + i3;
        int i10 = i2 + i4;
        if ((i3 < 0 && i9 > 0) || (i3 > 0 && i9 < 0)) {
            i9 = 0;
        }
        if ((i4 < 0 && i10 > 0) || (i4 > 0 && i10 < 0)) {
            i10 = 0;
        }
        onOverScrolled(i9, i10, false, false);
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3947a) {
            int OplusGLSurfaceView_13 = this.f3955i;
            if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                SpringOverScroller c1531y = this.f3959m;
                if (c1531y.computeScrollOffset()) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    int iMo7784b = c1531y.mo7784b();
                    int iMo7785c = c1531y.mo7785c();
                    if (scrollX != iMo7784b || scrollY != iMo7785c) {
                        int i2 = this.f3957k;
                        overScrollBy(iMo7784b - scrollX, iMo7785c - scrollY, scrollX, scrollY, 0, 0, i2, i2, false);
                        onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                    }
                    if (c1531y.mo7783a()) {
                        setScrollState(0);
                    } else {
                        setScrollState(2);
                    }
                    if (awakenScrollBars()) {
                        return;
                    }
                    postInvalidateOnAnimation();
                }
            }
        }
    }

    public void setOverScrollEnable(boolean z) {
        this.f3947a = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int OplusGLSurfaceView_13, int i2) {
        smoothScrollBy(OplusGLSurfaceView_13, i2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int OplusGLSurfaceView_13, int i2, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.COUIBaseListPopupWindow_8("COUIRecyclerView", "Cannot smooth scroll without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!this.mLayout.canScrollHorizontally()) {
            OplusGLSurfaceView_13 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return;
        }
        this.f3944B.m4037a(OplusGLSurfaceView_13, i2, Integer.MIN_VALUE, interpolator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int OplusGLSurfaceView_13, int i2) {
        if (this.mLayout == null) {
            Log.COUIBaseListPopupWindow_8("COUIRecyclerView", "Cannot fling without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || Math.abs(OplusGLSurfaceView_13) < this.f3972z) {
            OplusGLSurfaceView_13 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i2) < this.f3972z) {
            i2 = 0;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return false;
        }
        this.f3959m.m8251a(getDisplay().getRefreshRate());
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        if (!dispatchNestedPreFling(COUIBaseListPopupWindow_12, f2)) {
            this.f3955i = 1;
            boolean z = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(COUIBaseListPopupWindow_12, f2, z);
            RecyclerView.AbstractC0696l abstractC0696l = this.f3971y;
            if (abstractC0696l != null && abstractC0696l.mo4162a(OplusGLSurfaceView_13, i2)) {
                return true;
            }
            if (z) {
                int i3 = zCanScrollHorizontally ? 1 : 0;
                if (zCanScrollVertically) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 1);
                int i4 = this.f3943A;
                int iMax = Math.max(-i4, Math.min(OplusGLSurfaceView_13, i4));
                int i5 = this.f3943A;
                this.f3944B.m4036a(iMax, Math.max(-i5, Math.min(i2, i5)));
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        setScrollState(0);
        m4022c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4022c() {
        m4014a();
        this.f3944B.m4038b();
        if (this.mLayout != null) {
            this.mLayout.stopSmoothScroller();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMinFlingVelocity() {
        return this.f3972z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMaxFlingVelocity() {
        return this.f3943A;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnItemTouchListener(RecyclerView.InterfaceC0697m interfaceC0697m) {
        m4019b();
        this.f3952f.add(interfaceC0697m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnItemTouchListener(RecyclerView.InterfaceC0697m interfaceC0697m) {
        this.f3952f.remove(interfaceC0697m);
        if (this.f3953g == interfaceC0697m) {
            this.f3953g = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4017a(MotionEvent motionEvent) {
        RecyclerView.InterfaceC0697m interfaceC0697m = this.f3953g;
        if (interfaceC0697m == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return m4021b(motionEvent);
        }
        interfaceC0697m.mo4165b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f3953g = null;
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m4021b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f3952f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            RecyclerView.InterfaceC0697m interfaceC0697m = this.f3952f.get(OplusGLSurfaceView_13);
            if (interfaceC0697m.mo4164a(this, motionEvent) && action != 3) {
                this.f3953g = interfaceC0697m;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.f3953g = null;
        if (m4021b(motionEvent)) {
            m4027e();
            return true;
        }
        if (this.mLayout == null) {
            return false;
        }
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.f3965s == null) {
            this.f3965s = VelocityTracker.obtain();
        }
        this.f3965s.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3954h) {
                this.f3954h = false;
            }
            this.f3964r = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f3968v = x;
            this.f3966t = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f3969w = y;
            this.f3967u = y;
            if (this.f3963q == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.f3946D;
            iArr[1] = 0;
            iArr[0] = 0;
            int OplusGLSurfaceView_13 = zCanScrollHorizontally ? 1 : 0;
            if (zCanScrollVertically) {
                OplusGLSurfaceView_13 |= 2;
            }
            startNestedScroll(OplusGLSurfaceView_13, 0);
        } else if (actionMasked == 1) {
            this.f3965s.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3964r);
            if (iFindPointerIndex < 0) {
                Log.COUIBaseListPopupWindow_8("COUIRecyclerView", "Error processing scroll; pointer index for id_renamed " + this.f3964r + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f3963q != 1) {
                int i2 = x2 - this.f3966t;
                int i3 = y2 - this.f3967u;
                if (!zCanScrollHorizontally || Math.abs(i2) <= this.f3970x) {
                    z = false;
                } else {
                    this.f3968v = x2;
                    z = true;
                }
                if (zCanScrollVertically && Math.abs(i3) > this.f3970x) {
                    this.f3969w = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            m4027e();
        } else if (actionMasked == 5) {
            this.f3964r = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3968v = x3;
            this.f3966t = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3969w = y3;
            this.f3967u = y3;
        } else if (actionMasked == 6) {
            m4023c(motionEvent);
        }
        return this.f3963q == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f3952f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f3952f.get(OplusGLSurfaceView_13).mo4163a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.COUIRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m4026d() {
        VelocityTracker velocityTracker = this.f3965s;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m4027e() {
        m4026d();
        setScrollState(0);
        ViewNative.m6506b(this, 0);
        ViewNative.m6504a(this, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4023c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3964r) {
            int OplusGLSurfaceView_13 = actionIndex == 0 ? 1 : 0;
            this.f3964r = motionEvent.getPointerId(OplusGLSurfaceView_13);
            int x = (int) (motionEvent.getX(OplusGLSurfaceView_13) + 0.5f);
            this.f3968v = x;
            this.f3966t = x;
            int y = (int) (motionEvent.getY(OplusGLSurfaceView_13) + 0.5f);
            this.f3969w = y;
            this.f3967u = y;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m4030f() {
        return getLayoutManager() != null && (getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) getLayoutManager()).getOrientation() == 0;
    }

    public RunnableC0669a getViewFlinger() {
        return this.f3944B;
    }

    /* renamed from: androidx.recyclerview.widget.COUIRecyclerView$PlatformImplementations.kt_3 */
    public class RunnableC0669a implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f3975c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f3976d;

        /* renamed from: PlatformImplementations.kt_3 */
        Interpolator f3973a = RecyclerView.sQuinticInterpolator;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f3977e = false;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f3978f = false;

        RunnableC0669a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int OplusGLSurfaceView_13;
            int i2;
            if (COUIRecyclerView.this.mLayout == null) {
                m4038b();
                return;
            }
            this.f3978f = false;
            this.f3977e = true;
            COUIRecyclerView.this.consumePendingUpdateOperations();
            COUIIOverScroller interfaceC1474h = COUIRecyclerView.this.f3958l;
            if (interfaceC1474h.computeScrollOffset()) {
                int iMo7784b = interfaceC1474h.mo7784b();
                int iMo7785c = interfaceC1474h.mo7785c();
                int i3 = iMo7784b - this.f3975c;
                int i4 = iMo7785c - this.f3976d;
                this.f3975c = iMo7784b;
                this.f3976d = iMo7785c;
                COUIRecyclerView.this.mReusableIntPair[0] = 0;
                COUIRecyclerView.this.mReusableIntPair[1] = 0;
                COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
                if (cOUIRecyclerView.dispatchNestedPreScroll(i3, i4, cOUIRecyclerView.mReusableIntPair, null, 1)) {
                    i3 -= COUIRecyclerView.this.mReusableIntPair[0];
                    i4 -= COUIRecyclerView.this.mReusableIntPair[1];
                }
                if (COUIRecyclerView.this.mAdapter != null) {
                    COUIRecyclerView.this.mReusableIntPair[0] = 0;
                    COUIRecyclerView.this.mReusableIntPair[1] = 0;
                    COUIRecyclerView cOUIRecyclerView2 = COUIRecyclerView.this;
                    cOUIRecyclerView2.scrollStep(i3, i4, cOUIRecyclerView2.mReusableIntPair);
                    OplusGLSurfaceView_13 = COUIRecyclerView.this.mReusableIntPair[0];
                    i2 = COUIRecyclerView.this.mReusableIntPair[1];
                    i3 -= OplusGLSurfaceView_13;
                    i4 -= i2;
                    RecyclerView.AbstractC0703s abstractC0703s = COUIRecyclerView.this.mLayout.mSmoothScroller;
                    if (abstractC0703s != null && !abstractC0703s.isPendingInitialRun() && abstractC0703s.isRunning()) {
                        int iM4230e = COUIRecyclerView.this.mState.m4230e();
                        if (iM4230e == 0) {
                            abstractC0703s.stop();
                        } else if (abstractC0703s.getTargetPosition() >= iM4230e) {
                            abstractC0703s.setTargetPosition(iM4230e - 1);
                            abstractC0703s.onAnimation(OplusGLSurfaceView_13, i2);
                        } else {
                            abstractC0703s.onAnimation(OplusGLSurfaceView_13, i2);
                        }
                    }
                } else {
                    OplusGLSurfaceView_13 = 0;
                    i2 = 0;
                }
                if (!COUIRecyclerView.this.mItemDecorations.isEmpty()) {
                    COUIRecyclerView.this.invalidate();
                }
                COUIRecyclerView.this.mReusableIntPair[0] = 0;
                COUIRecyclerView.this.mReusableIntPair[1] = 0;
                COUIRecyclerView cOUIRecyclerView3 = COUIRecyclerView.this;
                cOUIRecyclerView3.dispatchNestedScroll(OplusGLSurfaceView_13, i2, i3, i4, null, 1, cOUIRecyclerView3.mReusableIntPair);
                int i5 = i3 - COUIRecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - COUIRecyclerView.this.mReusableIntPair[1];
                if (OplusGLSurfaceView_13 != 0 || i2 != 0) {
                    COUIRecyclerView.this.dispatchOnScrolled(OplusGLSurfaceView_13, i2);
                }
                if (i6 != 0 && COUIRecyclerView.this.f3947a) {
                    COUIRecyclerView.this.f3955i = 3;
                    COUIRecyclerView.this.performHapticFeedback(307);
                    COUIRecyclerView cOUIRecyclerView4 = COUIRecyclerView.this;
                    cOUIRecyclerView4.overScrollBy(0, i6, 0, cOUIRecyclerView4.getScrollY(), 0, 0, 0, COUIRecyclerView.this.f3957k, false);
                    if (COUIRecyclerView.this.f3962p) {
                        COUIRecyclerView.this.f3959m.m8254c(interfaceC1474h.mo7789g());
                        COUIRecyclerView.this.f3959m.notifyVerticalEdgeReached(i6, 0, COUIRecyclerView.this.f3957k);
                    } else {
                        COUIRecyclerView.this.f3958l.notifyVerticalEdgeReached(i6, 0, COUIRecyclerView.this.f3957k);
                    }
                }
                if (i5 != 0 && COUIRecyclerView.this.f3947a) {
                    COUIRecyclerView.this.f3955i = 3;
                    COUIRecyclerView.this.performHapticFeedback(307);
                    COUIRecyclerView cOUIRecyclerView5 = COUIRecyclerView.this;
                    cOUIRecyclerView5.overScrollBy(i5, 0, cOUIRecyclerView5.getScrollX(), 0, 0, 0, COUIRecyclerView.this.f3957k, 0, false);
                    if (COUIRecyclerView.this.f3962p) {
                        COUIRecyclerView.this.f3959m.m8253b(interfaceC1474h.mo7788f());
                        COUIRecyclerView.this.f3959m.notifyHorizontalEdgeReached(i5, 0, COUIRecyclerView.this.f3957k);
                    } else {
                        COUIRecyclerView.this.f3958l.notifyHorizontalEdgeReached(i5, 0, COUIRecyclerView.this.f3957k);
                    }
                }
                if (!COUIRecyclerView.this.awakenScrollBars()) {
                    COUIRecyclerView.this.invalidate();
                }
                boolean z = interfaceC1474h.mo7783a() || (((interfaceC1474h.mo7784b() == interfaceC1474h.mo7786d()) || i5 != 0) && ((interfaceC1474h.mo7785c() == interfaceC1474h.mo7787e()) || i6 != 0));
                RecyclerView.AbstractC0703s abstractC0703s2 = COUIRecyclerView.this.mLayout.mSmoothScroller;
                if (!(abstractC0703s2 != null && abstractC0703s2.isPendingInitialRun()) && z) {
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        COUIRecyclerView.this.mPrefetchRegistry.m4473a();
                    }
                } else {
                    m4035a();
                    if (COUIRecyclerView.this.mGapWorker != null) {
                        COUIRecyclerView.this.mGapWorker.m4470a((RecyclerView) COUIRecyclerView.this, OplusGLSurfaceView_13, i2);
                    }
                }
            }
            RecyclerView.AbstractC0703s abstractC0703s3 = COUIRecyclerView.this.mLayout.mSmoothScroller;
            if (abstractC0703s3 != null && abstractC0703s3.isPendingInitialRun()) {
                abstractC0703s3.onAnimation(0, 0);
            }
            this.f3977e = false;
            if (!this.f3978f) {
                if (COUIRecyclerView.this.f3955i == 3 && COUIRecyclerView.this.f3947a) {
                    return;
                }
                COUIRecyclerView.this.setScrollState(0);
                COUIRecyclerView.this.stopNestedScroll(1);
                return;
            }
            m4034c();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4035a() {
            if (this.f3977e) {
                this.f3978f = true;
            } else {
                m4034c();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m4034c() {
            COUIRecyclerView.this.removeCallbacks(this);
            ViewCompat.m2857a(COUIRecyclerView.this, this);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4036a(int OplusGLSurfaceView_13, int i2) {
            COUIRecyclerView.this.setScrollState(2);
            this.f3976d = 0;
            this.f3975c = 0;
            if (this.f3973a != RecyclerView.sQuinticInterpolator) {
                this.f3973a = RecyclerView.sQuinticInterpolator;
                COUIRecyclerView.this.f3958l.mo7782a(RecyclerView.sQuinticInterpolator);
            }
            COUIRecyclerView.this.f3958l.fling(0, 0, OplusGLSurfaceView_13, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            COUIRecyclerView.this.f3958l.setFinalX(COUIRecyclerView.this.f3961o.m7781b(COUIRecyclerView.this.f3958l.mo7786d()));
            m4035a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4037a(int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = m4033a(OplusGLSurfaceView_13, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f3973a != interpolator) {
                this.f3973a = interpolator;
                COUIRecyclerView.this.f3958l.mo7782a(interpolator);
            }
            this.f3976d = 0;
            this.f3975c = 0;
            COUIRecyclerView.this.setScrollState(2);
            COUIRecyclerView.this.f3958l.startScroll(0, 0, OplusGLSurfaceView_13, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                COUIRecyclerView.this.f3958l.computeScrollOffset();
            }
            m4035a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float m4032a(float COUIBaseListPopupWindow_12) {
            return (float) Math.sin((COUIBaseListPopupWindow_12 - 0.5f) * 0.47123894f);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m4033a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((OplusGLSurfaceView_13 * OplusGLSurfaceView_13) + (i2 * i2));
            int width = z ? COUIRecyclerView.this.getWidth() : COUIRecyclerView.this.getHeight();
            int i5 = width / 2;
            float COUIBaseListPopupWindow_12 = width;
            float f2 = i5;
            float fM4032a = f2 + (m4032a(Math.min(1.0f, (iSqrt2 * 1.0f) / COUIBaseListPopupWindow_12)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fM4032a / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / COUIBaseListPopupWindow_12) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4038b() {
            COUIRecyclerView.this.removeCallbacks(this);
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            cOUIRecyclerView.m4015a(cOUIRecyclerView.getContext());
            COUIRecyclerView.this.f3958l.abortAnimation();
            COUIRecyclerView.this.f3959m.abortAnimation();
        }
    }
}
