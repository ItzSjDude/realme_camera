package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.ViewCompat;
import androidx.customview.p039a.ViewDragHelper;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    View f4491a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    float f4492b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4493c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f4494d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final ViewDragHelper f4495e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean f4496f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final ArrayList<RunnableC0762a> f4497g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f4498h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f4499i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f4500j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Drawable f4501k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f4502l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f4503m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f4504n;

    /* renamed from: o */
    private int f4505o;

    /* renamed from: p */
    private float f4506p;

    /* renamed from: q */
    private float f4507q;

    /* renamed from: r */
    private InterfaceC0764c f4508r;

    /* renamed from: s */
    private boolean f4509s;

    /* renamed from: t */
    private final Rect f4510t;

    /* renamed from: u */
    private Method f4511u;

    /* renamed from: v */
    private Field f4512v;

    /* renamed from: w */
    private boolean f4513w;

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$IntrinsicsJvm.kt_3 */
    public interface InterfaceC0764c {
    }

    public void setParallaxDistance(int OplusGLSurfaceView_13) {
        this.f4505o = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f4505o;
    }

    public void setSliderFadeColor(int OplusGLSurfaceView_13) {
        this.f4498h = OplusGLSurfaceView_13;
    }

    public int getSliderFadeColor() {
        return this.f4498h;
    }

    public void setCoveredFadeColor(int OplusGLSurfaceView_13) {
        this.f4499i = OplusGLSurfaceView_13;
    }

    public int getCoveredFadeColor() {
        return this.f4499i;
    }

    public void setPanelSlideListener(InterfaceC0764c interfaceC0764c) {
        this.f4508r = interfaceC0764c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4701a(View view) {
        int left;
        int right;
        int top;
        int bottom;
        boolean z;
        int OplusGLSurfaceView_13;
        View view2 = view;
        boolean zM4709f = m4709f();
        int width = zM4709f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zM4709f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !m4699d(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = zM4709f;
            } else {
                int iMax = Math.max(zM4709f ? paddingLeft : width, childAt.getLeft());
                int iMax2 = Math.max(paddingTop, childAt.getTop());
                if (zM4709f) {
                    z = zM4709f;
                    OplusGLSurfaceView_13 = width;
                } else {
                    z = zM4709f;
                    OplusGLSurfaceView_13 = paddingLeft;
                }
                childAt.setVisibility((iMax < left || iMax2 < top || Math.min(OplusGLSurfaceView_13, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i2++;
            view2 = view;
            zM4709f = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4700a() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean m4699d(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4509s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDetachedFromWindow();
        this.f4509s = true;
        int size = this.f4497g.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4497g.get(OplusGLSurfaceView_13).run();
        }
        this.f4497g.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0 A[PHI: r12
      0x00b0: PHI (r12v2 float) = (r12v1 float), (r12v3 float) binds: [B:36:0x00a5, B:38:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0142  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zM4709f = m4709f();
        if (zM4709f) {
            this.f4495e.m3108a(2);
        } else {
            this.f4495e.m3108a(1);
        }
        int i10 = i3 - OplusGLSurfaceView_13;
        int paddingRight = zM4709f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zM4709f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f4509s) {
            this.f4492b = (this.f4503m && this.f4496f) ? 1.0f : 0.0f;
        }
        int width = paddingRight;
        int i11 = width;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C0763b c0763b = (C0763b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (c0763b.f4518b) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (Math.min(width, i13 - this.f4502l) - i11) - (c0763b.leftMargin + c0763b.rightMargin);
                    this.f4493c = iMin;
                    int i14 = zM4709f ? c0763b.rightMargin : c0763b.leftMargin;
                    c0763b.f4519c = ((i11 + i14) + iMin) + (measuredWidth / 2) > i13;
                    int i15 = (int) (iMin * this.f4492b);
                    i5 = i14 + i15 + i11;
                    this.f4492b = i15 / this.f4493c;
                    i6 = 0;
                } else if (!this.f4503m || (i7 = this.f4505o) == 0) {
                    i5 = width;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.f4492b) * i7);
                    i5 = width;
                }
                if (zM4709f) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                width += childAt.getWidth();
                i11 = i5;
            }
        }
        if (this.f4509s) {
            if (this.f4503m) {
                if (this.f4505o != 0) {
                    m4695a(this.f4492b);
                }
                if (((C0763b) this.f4491a.getLayoutParams()).f4519c) {
                    m4696a(this.f4491a, this.f4492b, this.f4498h);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    m4696a(getChildAt(i16), 0.0f, this.f4498h);
                }
            }
            m4701a(this.f4491a);
        }
        this.f4509s = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        if (OplusGLSurfaceView_13 != i3) {
            this.f4509s = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f4503m) {
            return;
        }
        this.f4496f = view == this.f4491a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f4503m && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f4496f = !this.f4495e.m3119b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f4503m || (this.f4494d && actionMasked != 0)) {
            this.f4495e.m3126e();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f4495e.m3126e();
            return false;
        }
        if (actionMasked == 0) {
            this.f4494d = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f4506p = x;
            this.f4507q = y;
            if (this.f4495e.m3119b(this.f4491a, (int) x, (int) y) && m4706c(this.f4491a)) {
                z = true;
            }
            return this.f4495e.m3111a(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = Math.abs(x2 - this.f4506p);
            float fAbs2 = Math.abs(y2 - this.f4507q);
            if (fAbs > this.f4495e.m3123d() && fAbs2 > fAbs) {
                this.f4495e.m3126e();
                this.f4494d = true;
                return false;
            }
        }
        z = false;
        if (this.f4495e.m3111a(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4503m) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4495e.m3115b(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f4506p = x;
            this.f4507q = y;
        } else if (actionMasked == 1 && m4706c(this.f4491a)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float COUIBaseListPopupWindow_12 = x2 - this.f4506p;
            float f2 = y2 - this.f4507q;
            int iM3123d = this.f4495e.m3123d();
            if ((COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2) < iM3123d * iM3123d && this.f4495e.m3119b(this.f4491a, (int) x2, (int) y2)) {
                m4697a(this.f4491a, 0);
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4697a(View view, int OplusGLSurfaceView_13) {
        if (!this.f4509s && !m4702a(0.0f, OplusGLSurfaceView_13)) {
            return false;
        }
        this.f4496f = false;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m4698b(View view, int OplusGLSurfaceView_13) {
        if (!this.f4509s && !m4702a(1.0f, OplusGLSurfaceView_13)) {
            return false;
        }
        this.f4496f = true;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m4704b() {
        return m4698b(this.f4491a, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m4705c() {
        return m4697a(this.f4491a, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m4707d() {
        return !this.f4503m || this.f4492b == 1.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m4708e() {
        return this.f4503m;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4696a(View view, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0763b c0763b = (C0763b) view.getLayoutParams();
        if (COUIBaseListPopupWindow_12 > 0.0f && OplusGLSurfaceView_13 != 0) {
            int i2 = (((int) ((((-16777216) & OplusGLSurfaceView_13) >>> 24) * COUIBaseListPopupWindow_12)) << 24) | (OplusGLSurfaceView_13 & 16777215);
            if (c0763b.f4520d == null) {
                c0763b.f4520d = new Paint();
            }
            c0763b.f4520d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, c0763b.f4520d);
            }
            m4703b(view);
            return;
        }
        if (view.getLayerType() != 0) {
            if (c0763b.f4520d != null) {
                c0763b.f4520d.setColorFilter(null);
            }
            RunnableC0762a runnableC0762a = new RunnableC0762a(view);
            this.f4497g.add(runnableC0762a);
            ViewCompat.m2857a(this, runnableC0762a);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        C0763b c0763b = (C0763b) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f4503m && !c0763b.f4518b && this.f4491a != null) {
            canvas.getClipBounds(this.f4510t);
            if (m4709f()) {
                Rect rect = this.f4510t;
                rect.left = Math.max(rect.left, this.f4491a.getRight());
            } else {
                Rect rect2 = this.f4510t;
                rect2.right = Math.min(rect2.right, this.f4491a.getLeft());
            }
            canvas.clipRect(this.f4510t);
        }
        boolean zDrawChild = super.drawChild(canvas, view, OplusGLSurfaceView_15);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4703b(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            ViewCompat.m2847a(view, ((C0763b) view.getLayoutParams()).f4520d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.f4513w) {
                try {
                    this.f4511u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", COUIBaseListPopupWindow_8);
                }
                try {
                    this.f4512v = View.class.getDeclaredField("mRecreateDisplayList");
                    this.f4512v.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.COUIBaseListPopupWindow_8("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.f4513w = true;
            }
            if (this.f4511u == null || (field = this.f4512v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f4511u.invoke(view, (Object[]) null);
            } catch (Exception e3) {
                Log.COUIBaseListPopupWindow_8("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        ViewCompat.m2844a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4702a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        int paddingLeft;
        if (!this.f4503m) {
            return false;
        }
        boolean zM4709f = m4709f();
        C0763b c0763b = (C0763b) this.f4491a.getLayoutParams();
        if (zM4709f) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + c0763b.rightMargin) + (COUIBaseListPopupWindow_12 * this.f4493c)) + this.f4491a.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + c0763b.leftMargin + (COUIBaseListPopupWindow_12 * this.f4493c));
        }
        ViewDragHelper c0535c = this.f4495e;
        View view = this.f4491a;
        if (!c0535c.m3112a(view, paddingLeft, view.getTop())) {
            return false;
        }
        m4700a();
        ViewCompat.m2881e(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f4495e.m3113a(true)) {
            if (!this.f4503m) {
                this.f4495e.m3127f();
            } else {
                ViewCompat.m2881e(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f4500j = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f4501k = drawable;
    }

    @Deprecated
    public void setShadowResource(int OplusGLSurfaceView_13) {
        setShadowDrawable(getResources().getDrawable(OplusGLSurfaceView_13));
    }

    public void setShadowResourceLeft(int OplusGLSurfaceView_13) {
        setShadowDrawableLeft(ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    public void setShadowResourceRight(int OplusGLSurfaceView_13) {
        setShadowDrawableRight(ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int OplusGLSurfaceView_13;
        int right;
        super.draw(canvas);
        if (m4709f()) {
            drawable = this.f4501k;
        } else {
            drawable = this.f4500j;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (m4709f()) {
            right = childAt.getRight();
            OplusGLSurfaceView_13 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            OplusGLSurfaceView_13 = left;
            right = i2;
        }
        drawable.setBounds(right, top, OplusGLSurfaceView_13, bottom);
        drawable.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4695a(float r10) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            boolean r0 = r9.m4709f()
            android.view.View r1 = r9.f4491a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$IntrinsicsJvm.kt_4 r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.C0763b) r1
            boolean r2 = r1.f4519c
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = r3
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L59
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f4491a
            if (r4 != r5) goto L2c
            goto L56
        L2c:
            float r5 = r9.f4504n
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f4505o
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f4504n = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L42
            int r5 = -r5
        L42:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L56
            if (r0 == 0) goto L4d
            float r5 = r9.f4504n
            float r5 = r5 - r6
            goto L51
        L4d:
            float r5 = r9.f4504n
            float r5 = r6 - r5
        L51:
            int r6 = r9.f4499i
            r9.m4696a(r4, r5, r6)
        L56:
            int r3 = r3 + 1
            goto L21
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.m4695a(float):void");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m4706c(View view) {
        if (view == null) {
            return false;
        }
        return this.f4503m && ((C0763b) view.getLayoutParams()).f4519c && this.f4492b > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0763b();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0763b((ViewGroup.MarginLayoutParams) layoutParams) : new C0763b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0763b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0763b(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = m4708e() ? m4707d() : this.f4496f;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            m4704b();
        } else {
            m4705c();
        }
        this.f4496f = savedState.isOpen;
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$IntrinsicsJvm.kt_4 */
    public static class C0763b extends ViewGroup.MarginLayoutParams {

        /* renamed from: COUIBaseListPopupWindow_8 */
        private static final int[] f4516e = {R.attr.layout_weight};

        /* renamed from: PlatformImplementations.kt_3 */
        public float f4517a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f4518b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f4519c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        Paint f4520d;

        public C0763b() {
            super(-1, -1);
            this.f4517a = 0.0f;
        }

        public C0763b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4517a = 0.0f;
        }

        public C0763b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4517a = 0.0f;
        }

        public C0763b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4517a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4516e);
            this.f4517a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        boolean isOpen;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$PlatformImplementations.kt_3 */
    private class RunnableC0762a implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final View f4514a;

        RunnableC0762a(View view) {
            this.f4514a = view;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f4514a.getParent() == SlidingPaneLayout.this) {
                this.f4514a.setLayerType(0, null);
                SlidingPaneLayout.this.m4703b(this.f4514a);
            }
            SlidingPaneLayout.this.f4497g.remove(this);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m4709f() {
        return ViewCompat.m2885g(this) == 1;
    }
}
