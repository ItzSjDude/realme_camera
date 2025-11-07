package androidx.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ViewDragHelper;
import androidx.customview.view.AbsSavedState;
import com.p078a.p079a.Spring;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIDrawerLayout extends ViewGroup {

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final boolean f4948b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final boolean f4950d;

    /* renamed from: A */
    private int f4951A;

    /* renamed from: B */
    private int f4952B;

    /* renamed from: C */
    private int f4953C;

    /* renamed from: D */
    private int f4954D;

    /* renamed from: E */
    private boolean f4955E;

    /* renamed from: F */
    private boolean f4956F;

    /* renamed from: G */
    private InterfaceC0859c f4957G;

    /* renamed from: H */
    private List<InterfaceC0859c> f4958H;

    /* renamed from: I */
    private float f4959I;

    /* renamed from: J */
    private float f4960J;

    /* renamed from: K */
    private Drawable f4961K;

    /* renamed from: L */
    private Drawable f4962L;

    /* renamed from: M */
    private Drawable f4963M;

    /* renamed from: N */
    private Drawable f4964N;

    /* renamed from: O */
    private Object f4965O;

    /* renamed from: P */
    private boolean f4966P;

    /* renamed from: Q */
    private Drawable f4967Q;

    /* renamed from: R */
    private Drawable f4968R;

    /* renamed from: S */
    private Drawable f4969S;

    /* renamed from: T */
    private Drawable f4970T;

    /* renamed from: U */
    private Drawable f4971U;

    /* renamed from: V */
    private final ArrayList<View> f4972V;

    /* renamed from: W */
    private Rect f4973W;

    /* renamed from: aa */
    private Matrix f4974aa;

    /* renamed from: ab */
    private InterfaceC0857a f4975ab;

    /* renamed from: ac */
    private int f4976ac;

    /* renamed from: ad */
    private Spring f4977ad;

    /* renamed from: ae */
    private View f4978ae;

    /* renamed from: af */
    private int f4979af;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final C0858b f4980e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f4981f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f4982g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f4983h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f4984i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Paint f4985j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final ViewDragHelper f4986k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final ViewDragHelper f4987l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final ViewDragHelper f4988m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final C0861e f4989n;

    /* renamed from: o */
    private final C0861e f4990o;

    /* renamed from: p */
    private final C0861e f4991p;

    /* renamed from: q */
    private Rect f4992q;

    /* renamed from: r */
    private int f4993r;

    /* renamed from: s */
    private boolean f4994s;

    /* renamed from: t */
    private boolean f4995t;

    /* renamed from: u */
    private int f4996u;

    /* renamed from: v */
    private int f4997v;

    /* renamed from: w */
    private boolean f4998w;

    /* renamed from: x */
    private boolean f4999x;

    /* renamed from: y */
    private boolean f5000y;

    /* renamed from: z */
    private int f5001z;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f4949c = {R.attr.colorPrimaryDark};

    /* renamed from: PlatformImplementations.kt_3 */
    static final int[] f4947a = {R.attr.layout_gravity};

    /* renamed from: androidx.widget.COUIDrawerLayout$PlatformImplementations.kt_3 */
    public interface InterfaceC0857a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m5158a();
    }

    /* renamed from: androidx.widget.COUIDrawerLayout$IntrinsicsJvm.kt_3 */
    public interface InterfaceC0859c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m5159a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void m5160a(View view);

        /* renamed from: PlatformImplementations.kt_3 */
        void m5161a(View view, float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m5162b(View view);
    }

    static {
        f4948b = Build.VERSION.SDK_INT >= 19;
        f4950d = Build.VERSION.SDK_INT >= 21;
    }

    public void setDrawerElevation(float COUIBaseListPopupWindow_12) {
        this.f4981f = COUIBaseListPopupWindow_12;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m5150g(childAt)) {
                ViewCompat.m2841a(childAt, this.f4981f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f4950d) {
            return this.f4981f;
        }
        return 0.0f;
    }

    public void setScrimColor(int OplusGLSurfaceView_13) {
        this.f4983h = OplusGLSurfaceView_13;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0859c interfaceC0859c) {
        InterfaceC0859c interfaceC0859c2 = this.f4957G;
        if (interfaceC0859c2 != null) {
            m5143b(interfaceC0859c2);
        }
        if (interfaceC0859c != null) {
            m5134a(interfaceC0859c);
        }
        this.f4957G = interfaceC0859c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5134a(InterfaceC0859c interfaceC0859c) {
        if (interfaceC0859c == null) {
            return;
        }
        if (this.f4958H == null) {
            this.f4958H = new ArrayList();
        }
        this.f4958H.add(interfaceC0859c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5143b(InterfaceC0859c interfaceC0859c) {
        List<InterfaceC0859c> list;
        if (interfaceC0859c == null || (list = this.f4958H) == null) {
            return;
        }
        list.remove(interfaceC0859c);
    }

    public void setDrawerLockMode(int OplusGLSurfaceView_13) {
        m5129a(OplusGLSurfaceView_13, 3);
        m5129a(OplusGLSurfaceView_13, 5);
        m5129a(OplusGLSurfaceView_13, 80);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5129a(int OplusGLSurfaceView_13, int i2) {
        View viewM5137b;
        ViewDragHelper c0535c;
        int iM2773a = GravityCompat.m2773a(i2, ViewCompat.m2885g(this));
        if (i2 == 3) {
            this.f5001z = OplusGLSurfaceView_13;
        } else if (i2 == 5) {
            this.f4951A = OplusGLSurfaceView_13;
        } else if (i2 == 80) {
            this.f4954D = OplusGLSurfaceView_13;
        } else if (i2 == 8388611) {
            this.f4952B = OplusGLSurfaceView_13;
        } else if (i2 == 8388613) {
            this.f4953C = OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (iM2773a == 3) {
                c0535c = this.f4986k;
            } else if (iM2773a == 5) {
                c0535c = this.f4987l;
            } else {
                c0535c = this.f4988m;
            }
            c0535c.m3126e();
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 && (viewM5137b = m5137b(iM2773a)) != null) {
                m5151h(viewM5137b);
                return;
            }
            return;
        }
        View viewM5137b2 = m5137b(iM2773a);
        if (viewM5137b2 != null) {
            m5152i(viewM5137b2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m5125a(int OplusGLSurfaceView_13) {
        int iM2885g = ViewCompat.m2885g(this);
        if (OplusGLSurfaceView_13 == 3) {
            int i2 = this.f5001z;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iM2885g == 0 ? this.f4952B : this.f4953C;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 == 5) {
            int i4 = this.f4951A;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iM2885g == 0 ? this.f4953C : this.f4952B;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 == 80) {
            int i6 = this.f4954D;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 == 8388611) {
            int i7 = this.f4952B;
            if (i7 != 3) {
                return i7;
            }
            int i8 = iM2885g == 0 ? this.f5001z : this.f4951A;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 != 8388613) {
            return 0;
        }
        int i9 = this.f4953C;
        if (i9 != 3) {
            return i9;
        }
        int i10 = iM2885g == 0 ? this.f4951A : this.f5001z;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: PlatformImplementations.kt_3 */
    public int m5126a(View view) {
        if (!m5150g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
        }
        return m5125a(((C0860d) view.getLayoutParams()).f5002a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m5109a(float COUIBaseListPopupWindow_12, float f2, View view) {
        if (this.f4973W == null) {
            this.f4973W = new Rect();
        }
        view.getHitRect(this.f4973W);
        return this.f4973W.contains((int) COUIBaseListPopupWindow_12, (int) f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m5111a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventM5112b = m5112b(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventM5112b);
            motionEventM5112b.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MotionEvent m5112b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f4974aa == null) {
                this.f4974aa = new Matrix();
            }
            matrix.invert(this.f4974aa);
            motionEventObtain.transform(this.f4974aa);
        }
        return motionEventObtain;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5130a(int OplusGLSurfaceView_13, int i2, View view) {
        int iM3107a = this.f4986k.m3107a();
        int iM3107a2 = this.f4987l.m3107a();
        int iM3107a3 = this.f4988m.m3107a();
        int i3 = (iM3107a == 1 || iM3107a2 == 1 || iM3107a3 == 1) ? 1 : (iM3107a == 2 || iM3107a2 == 2 || iM3107a3 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            C0860d c0860d = (C0860d) view.getLayoutParams();
            if (c0860d.f5003b == 0.0f) {
                m5140b(view);
            } else if (c0860d.f5003b == 1.0f) {
                m5145c(view);
            } else {
                c0860d.f5005d &= 2;
            }
        }
        if (i3 != this.f4997v) {
            this.f4997v = i3;
            List<InterfaceC0859c> list = this.f4958H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4958H.get(size).m5159a(i3);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5140b(View view) {
        View rootView;
        C0860d c0860d = (C0860d) view.getLayoutParams();
        if (m5136a(view, 80) && c0860d.f5005d != 4) {
            c0860d.f5005d = 1;
        }
        if ((c0860d.f5005d & 1) == 1) {
            c0860d.f5005d = 0;
            List<InterfaceC0859c> list = this.f4958H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4958H.get(size).m5162b(view);
                }
            }
            m5116c(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m5145c(View view) {
        C0860d c0860d = (C0860d) view.getLayoutParams();
        if ((c0860d.f5005d & 1) == 0) {
            c0860d.f5005d = 1;
            List<InterfaceC0859c> list = this.f4958H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4958H.get(size).m5160a(view);
                }
            }
            m5116c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5116c(View view, boolean z) {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if ((!z && !m5150g(childAt)) || (z && childAt == view)) {
                ViewCompat.m2867b(childAt, 1);
            } else {
                ViewCompat.m2867b(childAt, 4);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5132a(View view, float COUIBaseListPopupWindow_12) {
        List<InterfaceC0859c> list = this.f4958H;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4958H.get(size).m5161a(view, COUIBaseListPopupWindow_12);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5141b(View view, float COUIBaseListPopupWindow_12) {
        C0860d c0860d = (C0860d) view.getLayoutParams();
        if (COUIBaseListPopupWindow_12 == c0860d.f5003b) {
            return;
        }
        c0860d.f5003b = COUIBaseListPopupWindow_12;
        m5132a(view, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m5147d(View view) {
        return ((C0860d) view.getLayoutParams()).f5003b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    int m5148e(View view) {
        return GravityCompat.m2773a(((C0860d) view.getLayoutParams()).f5002a, ViewCompat.m2885g(this));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m5136a(View view, int OplusGLSurfaceView_13) {
        return (m5148e(view) & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    View m5127a() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            C0860d c0860d = (C0860d) childAt.getLayoutParams();
            if ((c0860d.f5005d & 1) == 1) {
                return childAt;
            }
            if (m5136a(childAt, 80) && c0860d.f5003b > 0.0f) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m5146c(View view, float COUIBaseListPopupWindow_12) {
        float fM5147d = m5147d(view);
        if (m5136a(view, 80)) {
            view.offsetTopAndBottom((int) ((fM5147d - COUIBaseListPopupWindow_12) * view.getMeasuredHeight()));
        } else {
            float width = view.getWidth();
            int OplusGLSurfaceView_13 = ((int) (width * COUIBaseListPopupWindow_12)) - ((int) (fM5147d * width));
            if (!m5136a(view, 3)) {
                OplusGLSurfaceView_13 = -OplusGLSurfaceView_13;
            }
            view.offsetLeftAndRight(OplusGLSurfaceView_13);
        }
        m5141b(view, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    View m5137b(int OplusGLSurfaceView_13) {
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, ViewCompat.m2885g(this)) & 119;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m5148e(childAt) & 119) == iM2773a) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static String m5115c(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & 3) == 3 ? "LEFT" : (OplusGLSurfaceView_13 & 5) == 5 ? "RIGHT" : (OplusGLSurfaceView_13 & 80) == 80 ? "BOTTOM" : Integer.toHexString(OplusGLSurfaceView_13);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4999x = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4999x = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014e  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onMeasure(int, int):void");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m5118d() {
        if (f4950d) {
            return;
        }
        this.f4962L = m5119e();
        this.f4963M = m5120f();
        this.f4964N = this.f4971U;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable m5119e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iM2885g = ViewCompat.m2885g(this);
        if (iM2885g == 0) {
            Drawable drawable = this.f4967Q;
            if (drawable != null) {
                m5110a(drawable, iM2885g);
                return this.f4967Q;
            }
        } else {
            Drawable drawable2 = this.f4968R;
            if (drawable2 != null) {
                m5110a(drawable2, iM2885g);
                return this.f4968R;
            }
        }
        return this.f4969S;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable m5120f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iM2885g = ViewCompat.m2885g(this);
        if (iM2885g == 0) {
            Drawable drawable = this.f4968R;
            if (drawable != null) {
                m5110a(drawable, iM2885g);
                return this.f4968R;
            }
        } else {
            Drawable drawable2 = this.f4967Q;
            if (drawable2 != null) {
                m5110a(drawable2, iM2885g);
                return this.f4967Q;
            }
        }
        return this.f4970T;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m5110a(Drawable drawable, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (drawable == null || !DrawableCompat.m2575b(drawable)) {
            return false;
        }
        DrawableCompat.m2576b(drawable, OplusGLSurfaceView_13);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12;
        int paddingLeft;
        boolean z2 = true;
        this.f4998w = true;
        int i5 = i3 - OplusGLSurfaceView_13;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0860d c0860d = (C0860d) childAt.getLayoutParams();
                if (m5149f(childAt)) {
                    childAt.layout(c0860d.leftMargin, c0860d.topMargin, c0860d.leftMargin + childAt.getMeasuredWidth(), c0860d.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m5136a(childAt, 3)) {
                        float f2 = measuredWidth;
                        paddingLeft = (-measuredWidth) + ((int) (c0860d.f5003b * f2));
                        COUIBaseListPopupWindow_12 = (measuredWidth + paddingLeft) / f2;
                    } else if (m5136a(childAt, 5)) {
                        float f3 = measuredWidth;
                        COUIBaseListPopupWindow_12 = (i5 - r11) / f3;
                        paddingLeft = i5 - ((int) (c0860d.f5003b * f3));
                    } else {
                        int i7 = i4 - i2;
                        COUIBaseListPopupWindow_12 = (i7 - (i7 - ((int) (c0860d.f5003b * r11)))) / measuredHeight;
                        paddingLeft = childAt.getPaddingLeft();
                    }
                    boolean z3 = COUIBaseListPopupWindow_12 != c0860d.f5003b ? z2 : false;
                    int i8 = c0860d.f5002a & 119;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < c0860d.topMargin) {
                            i10 = c0860d.topMargin;
                        } else if (i10 + measuredHeight > i9 - c0860d.bottomMargin) {
                            i10 = (i9 - c0860d.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(paddingLeft, i10, measuredWidth + paddingLeft, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(paddingLeft, c0860d.topMargin, measuredWidth + paddingLeft, c0860d.topMargin + measuredHeight);
                    } else {
                        int measuredHeight2 = (int) ((i4 - i2) - (((C0860d) childAt.getLayoutParams()).f5003b * childAt.getMeasuredHeight()));
                        childAt.layout(paddingLeft, measuredHeight2, measuredWidth + paddingLeft, (childAt.getMeasuredHeight() + measuredHeight2) - c0860d.bottomMargin);
                    }
                    if (z3) {
                        m5141b(childAt, COUIBaseListPopupWindow_12);
                    }
                    int i11 = c0860d.f5003b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
            i6++;
            z2 = true;
        }
        this.f4998w = false;
        this.f4999x = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4998w) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            fMax = Math.max(fMax, ((C0860d) getChildAt(OplusGLSurfaceView_13).getLayoutParams()).f5003b);
        }
        this.f4984i = fMax;
        boolean zM3113a = this.f4986k.m3113a(true);
        boolean zM3113a2 = this.f4987l.m3113a(true);
        boolean zM3113a3 = this.f4988m.m3113a(true);
        if (zM3113a || zM3113a2 || zM3113a3) {
            ViewCompat.m2881e(this);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private static boolean m5124m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f4961K = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f4961K;
    }

    public void setStatusBarBackground(int OplusGLSurfaceView_13) {
        this.f4961K = OplusGLSurfaceView_13 != 0 ? ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int OplusGLSurfaceView_13) {
        this.f4961K = new ColorDrawable(OplusGLSurfaceView_13);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int OplusGLSurfaceView_13) {
        m5118d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.f4966P || this.f4961K == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.f4965O) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.f4961K.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f4961K.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13;
        int height = getHeight();
        boolean zM5149f = m5149f(view);
        int width = getWidth();
        int height2 = getHeight();
        int iSave = canvas.save();
        int i2 = 80;
        int i3 = 0;
        if (zM5149f) {
            int childCount = getChildCount();
            OplusGLSurfaceView_13 = width;
            int iHeight = height2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && ((m5124m(childAt) || m5136a(childAt, i2)) && m5150g(childAt) && childAt.getHeight() >= height)) {
                    if (m5136a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i5) {
                            i5 = right;
                        }
                    } else if (m5136a(childAt, 5)) {
                        int left = childAt.getLeft();
                        if (left < OplusGLSurfaceView_13) {
                            OplusGLSurfaceView_13 = left;
                        }
                    } else {
                        int top = childAt.getTop();
                        if (top < iHeight) {
                            Rect rect = this.f4992q;
                            iHeight = top + (rect != null ? rect.height() : 0);
                        }
                    }
                }
                i4++;
                i2 = 80;
            }
            canvas.clipRect(i5, 0, OplusGLSurfaceView_13, iHeight);
            i3 = i5;
        } else {
            OplusGLSurfaceView_13 = width;
        }
        boolean zDrawChild = super.drawChild(canvas, view, OplusGLSurfaceView_15);
        canvas.restoreToCount(iSave);
        float COUIBaseListPopupWindow_12 = this.f4984i;
        if (COUIBaseListPopupWindow_12 > 0.0f && zM5149f) {
            this.f4985j.setColor((this.f4983h & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * COUIBaseListPopupWindow_12)) << 24));
            canvas.drawRect(i3, 0.0f, OplusGLSurfaceView_13, getHeight(), this.f4985j);
        } else if (this.f4962L != null && m5136a(view, 3)) {
            int intrinsicWidth = this.f4962L.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f4986k.m3114b(), 1.0f));
            this.f4962L.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f4962L.setAlpha((int) (fMax * 255.0f));
            this.f4962L.draw(canvas);
        } else if (this.f4963M != null && m5136a(view, 5)) {
            int intrinsicWidth2 = this.f4963M.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f4987l.m3114b(), 1.0f));
            this.f4963M.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f4963M.setAlpha((int) (fMax2 * 255.0f));
            this.f4963M.draw(canvas);
        } else if (this.f4964N != null && m5136a(view, 80)) {
            int intrinsicHeight = this.f4964N.getIntrinsicHeight();
            int top2 = view.getTop();
            float fMax3 = Math.max(0.0f, Math.min((getHeight() - top2) / this.f4988m.m3114b(), 1.0f));
            this.f4964N.setBounds(view.getLeft(), top2 - intrinsicHeight, view.getRight(), view.getBottom());
            this.f4963M.setAlpha((int) (fMax3 * 255.0f));
            this.f4963M.draw(canvas);
        }
        return zDrawChild;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m5149f(View view) {
        return ((C0860d) view.getLayoutParams()).f5002a == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean m5150g(View view) {
        int iM2773a = GravityCompat.m2773a(((C0860d) view.getLayoutParams()).f5002a, ViewCompat.m2885g(view));
        return ((iM2773a & 3) == 0 && (iM2773a & 5) == 0 && (iM2773a & 80) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f4984i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int OplusGLSurfaceView_13 = childCount - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m5109a(x, y, childAt) && !m5149f(childAt) && m5111a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r0 = r6.f4986k
            r0.m3115b(r7)
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r0 = r6.f4987l
            r0.m3115b(r7)
            boolean r0 = r6.f4994s
            if (r0 != 0) goto L17
            boolean r0 = r6.f4995t
            if (r0 == 0) goto L17
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r0 = r6.f4988m
            r0.m3115b(r7)
        L17:
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L88
            if (r0 == r1) goto L30
            r7 = 3
            if (r0 == r7) goto L28
            goto L98
        L28:
            r6.m5135a(r1)
            r6.f4955E = r2
            r6.f4956F = r2
            goto L98
        L30:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = r6.f4986k
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.m3124d(r4, r5)
            android.view.View r4 = r6.m5127a()
            if (r3 == 0) goto L6d
            boolean r3 = r6.m5149f(r3)
            if (r3 == 0) goto L6d
            float r3 = r6.f4959I
            float r0 = r0 - r3
            float r3 = r6.f4960J
            float r7 = r7 - r3
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = r6.f4986k
            int r3 = r3.m3123d()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L6d
            if (r4 == 0) goto L6d
            int r7 = r6.m5126a(r4)
            r0 = 2
            if (r7 != r0) goto L6b
            goto L6d
        L6b:
            r7 = r2
            goto L6e
        L6d:
            r7 = r1
        L6e:
            boolean r0 = r6.f5000y
            if (r0 != 0) goto L80
            if (r4 == 0) goto L80
            if (r7 != 0) goto L80
            r6.f4978ae = r4
            com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 r7 = r6.f4977ad
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            r7.m5476b(r3)
            goto L83
        L80:
            r6.m5135a(r7)
        L83:
            r6.f4955E = r2
            r6.f4995t = r2
            goto L98
        L88:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f4959I = r0
            r6.f4960J = r7
            r6.f4955E = r2
            r6.f4956F = r2
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f4955E = z;
        if (z) {
            m5135a(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5138b() {
        m5135a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5135a(boolean z) {
        boolean zM3112a;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            C0860d c0860d = (C0860d) childAt.getLayoutParams();
            if (m5150g(childAt) && (!z || c0860d.f5004c)) {
                int width = childAt.getWidth();
                if (m5136a(childAt, 3)) {
                    zM3112a = this.f4986k.m3112a(childAt, -width, childAt.getTop());
                } else if (m5136a(childAt, 5)) {
                    zM3112a = this.f4987l.m3112a(childAt, getWidth(), childAt.getTop());
                } else {
                    InterfaceC0857a interfaceC0857a = this.f4975ab;
                    if (interfaceC0857a != null) {
                        interfaceC0857a.m5158a();
                        c0860d.f5004c = false;
                    } else {
                        zM3112a = this.f4988m.m3112a(childAt, childAt.getLeft(), getHeight());
                    }
                }
                z2 |= zM3112a;
                c0860d.f5004c = false;
            }
        }
        this.f4989n.m5164a();
        this.f4990o.m5164a();
        this.f4991p.m5164a();
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m5151h(View view) {
        m5133a(view, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5133a(View view, boolean z) {
        if (!m5150g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 sliding drawer");
        }
        C0860d c0860d = (C0860d) view.getLayoutParams();
        this.f4979af = 0;
        if (this.f4999x) {
            c0860d.f5003b = 1.0f;
            c0860d.f5005d = 1;
            m5116c(view, true);
        } else if (z) {
            c0860d.f5005d |= 2;
            if (m5136a(view, 3)) {
                this.f4986k.m3112a(view, 0, view.getTop());
            } else if (m5136a(view, 5)) {
                this.f4987l.m3112a(view, getWidth() - view.getWidth(), view.getTop());
            } else {
                this.f4988m.m3112a(view, view.getPaddingLeft(), 0);
            }
        } else {
            m5146c(view, 1.0f);
            m5130a(c0860d.f5002a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5131a(int OplusGLSurfaceView_13, boolean z) {
        View viewM5137b = m5137b(OplusGLSurfaceView_13);
        if (viewM5137b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m5115c(OplusGLSurfaceView_13));
        }
        m5133a(viewM5137b, z);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m5152i(View view) {
        m5142b(view, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5142b(View view, boolean z) {
        if (!m5150g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 sliding drawer");
        }
        C0860d c0860d = (C0860d) view.getLayoutParams();
        this.f4979af = 2;
        if (this.f4999x) {
            c0860d.f5003b = 0.0f;
            c0860d.f5005d = 0;
        } else if (z) {
            c0860d.f5005d |= 4;
            if (m5136a(view, 3)) {
                this.f4986k.m3112a(view, -view.getWidth(), view.getTop());
            } else if (m5136a(view, 5)) {
                this.f4987l.m3112a(view, getWidth(), view.getTop());
            } else {
                this.f4988m.m3112a(view, view.getLeft(), getHeight());
            }
        } else {
            m5146c(view, 0.0f);
            m5130a(c0860d.f5002a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5139b(int OplusGLSurfaceView_13, boolean z) {
        View viewM5137b = m5137b(OplusGLSurfaceView_13);
        if (viewM5137b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m5115c(OplusGLSurfaceView_13));
        }
        m5142b(viewM5137b, z);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m5153j(View view) {
        if (m5150g(view)) {
            return (((C0860d) view.getLayoutParams()).f5005d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m5154k(View view) {
        if (m5150g(view)) {
            return ((C0860d) view.getLayoutParams()).f5003b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m5121g() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            if (((C0860d) getChildAt(OplusGLSurfaceView_13).getLayoutParams()).f5004c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0860d(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0860d ? new C0860d((C0860d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0860d((ViewGroup.MarginLayoutParams) layoutParams) : new C0860d(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0860d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0860d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int OplusGLSurfaceView_13, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (m5150g(childAt)) {
                if (m5153j(childAt)) {
                    childAt.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
                    z = true;
                }
            } else {
                this.f4972V.add(childAt);
            }
        }
        if (!z) {
            int size = this.f4972V.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f4972V.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
                }
            }
        }
        this.f4972V.clear();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m5122h() {
        return m5144c() != null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    View m5144c() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m5150g(childAt) && m5154k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4 && m5122h()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4) {
            View viewM5144c = m5144c();
            if (viewM5144c != null && m5126a(viewM5144c) == 0) {
                m5138b();
            }
            return viewM5144c != null;
        }
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0 && m5137b(savedState.openDrawerGravity) != null) {
            m5128a(savedState.openDrawerGravity, savedState.onScreen, false);
        }
        if (savedState.lockModeLeft != 3) {
            m5129a(savedState.lockModeLeft, 3);
        }
        if (savedState.lockModeRight != 3) {
            m5129a(savedState.lockModeRight, 5);
        }
        if (savedState.lockModeStart != 3) {
            m5129a(savedState.lockModeStart, 8388611);
        }
        if (savedState.lockModeEnd != 3) {
            m5129a(savedState.lockModeEnd, 8388613);
        }
        if (savedState.lockModeBottom != 3) {
            m5129a(savedState.lockModeBottom, 80);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            C0860d c0860d = (C0860d) getChildAt(OplusGLSurfaceView_13).getLayoutParams();
            boolean z = c0860d.f5005d == 1;
            boolean z2 = c0860d.f5005d == 2;
            if (z || z2) {
                savedState.openDrawerGravity = c0860d.f5002a;
                savedState.onScreen = c0860d.f5003b;
                break;
            }
        }
        savedState.lockModeLeft = this.f5001z;
        savedState.lockModeRight = this.f4951A;
        savedState.lockModeStart = this.f4952B;
        savedState.lockModeEnd = this.f4953C;
        savedState.lockModeBottom = this.f4954D;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
        if (m5127a() != null || m5150g(view)) {
            ViewCompat.m2867b(view, 4);
        } else {
            ViewCompat.m2867b(view, 1);
        }
        if (f4948b) {
            return;
        }
        ViewCompat.m2854a(view, this.f4980e);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    static boolean m5123l(View view) {
        return (ViewCompat.m2883f(view) == 4 || ViewCompat.m2883f(view) == 2) ? false : true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.widget.COUIDrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
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
        int lockModeBottom;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        float onScreen;
        int openDrawerGravity;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
            this.lockModeBottom = parcel.readInt();
            this.onScreen = parcel.readFloat();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
            parcel.writeInt(this.lockModeBottom);
            parcel.writeFloat(this.onScreen);
        }
    }

    /* renamed from: androidx.widget.COUIDrawerLayout$COUIBaseListPopupWindow_8 */
    private class C0861e extends ViewDragHelper.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIDrawerLayout f5006a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f5007b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ViewDragHelper f5008c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f5009d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final Runnable f5010e;

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean onEdgeLock(int OplusGLSurfaceView_13) {
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m5164a() {
            this.f5006a.removeCallbacks(this.f5010e);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
            return this.f5006a.m5150g(view) && this.f5006a.m5136a(view, this.f5007b) && this.f5006a.m5126a(view) == 0;
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
            View viewM3120c = this.f5008c.m3120c();
            if (OplusGLSurfaceView_13 == 1) {
                this.f5009d = viewM3120c == null ? this.f5006a.getHeight() : viewM3120c.getTop();
            }
            this.f5006a.m5130a(this.f5007b, OplusGLSurfaceView_13, viewM3120c);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewPositionChanged(android.view.View r5, int r6, int r7, int r8, int r9) {
            /*
                r4 = this;
                int r8 = r5.getWidth()
                int r9 = r5.getHeight()
                androidx.widget.COUIDrawerLayout r0 = r4.f5006a
                r1 = 3
                boolean r0 = r0.m5136a(r5, r1)
                r1 = 4
                r2 = 0
                if (r0 == 0) goto L18
                int r6 = r6 + r8
                float r6 = (float) r6
            L15:
                float r7 = (float) r8
                float r6 = r6 / r7
                goto L42
            L18:
                androidx.widget.COUIDrawerLayout r0 = r4.f5006a
                r3 = 5
                boolean r0 = r0.m5136a(r5, r3)
                if (r0 == 0) goto L2a
                androidx.widget.COUIDrawerLayout r7 = r4.f5006a
                int r7 = r7.getWidth()
                int r7 = r7 - r6
                float r6 = (float) r7
                goto L15
            L2a:
                androidx.widget.COUIDrawerLayout r6 = r4.f5006a
                int r6 = r6.getMeasuredHeight()
                int r6 = r6 - r7
                float r6 = (float) r6
                float r7 = (float) r9
                float r6 = r6 / r7
                float r6 = java.lang.Math.max(r2, r6)
                int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r7 != 0) goto L3e
                r7 = r1
                goto L3f
            L3e:
                r7 = 1
            L3f:
                androidx.core.p036h.ViewCompat.m2867b(r5, r7)
            L42:
                androidx.widget.COUIDrawerLayout r7 = r4.f5006a
                r7.m5141b(r5, r6)
                int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r6 != 0) goto L4c
                goto L4d
            L4c:
                r1 = 0
            L4d:
                r5.setVisibility(r1)
                androidx.widget.COUIDrawerLayout r4 = r4.f5006a
                r4.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.C0861e.onViewPositionChanged(android.view.View, int, int, int, int):void");
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewCaptured(View view, int OplusGLSurfaceView_13) {
            ((C0860d) view.getLayoutParams()).f5004c = false;
            m5163b();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m5163b() {
            View viewM5137b;
            int OplusGLSurfaceView_13 = this.f5007b;
            View viewM5137b2 = null;
            if (OplusGLSurfaceView_13 == 3) {
                viewM5137b2 = this.f5006a.m5137b(80);
                viewM5137b = this.f5006a.m5137b(5);
            } else if (OplusGLSurfaceView_13 == 5) {
                viewM5137b2 = this.f5006a.m5137b(3);
                viewM5137b = this.f5006a.m5137b(80);
            } else if (OplusGLSurfaceView_13 != 80) {
                viewM5137b = null;
            } else {
                viewM5137b2 = this.f5006a.m5137b(3);
                viewM5137b = this.f5006a.m5137b(5);
            }
            if (viewM5137b2 != null) {
                this.f5006a.m5152i(viewM5137b2);
            }
            if (viewM5137b != null) {
                this.f5006a.m5152i(viewM5137b);
            }
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
            int width;
            float fM5147d = this.f5006a.m5147d(view);
            int width2 = view.getWidth();
            int height = view.getHeight();
            int left = view.getLeft();
            int top = view.getTop();
            if (this.f5006a.m5136a(view, 3)) {
                if (COUIBaseListPopupWindow_12 > 0.0f || (COUIBaseListPopupWindow_12 == 0.0f && fM5147d > 0.5f)) {
                    left = 0;
                } else {
                    width = -width2;
                    left = width;
                }
            } else if (this.f5006a.m5136a(view, 5)) {
                width = this.f5006a.getWidth();
                if (COUIBaseListPopupWindow_12 < 0.0f || (COUIBaseListPopupWindow_12 == 0.0f && fM5147d > 0.5f)) {
                    width -= width2;
                }
                left = width;
            } else {
                top = this.f5006a.getHeight() - view.getMinimumHeight();
                this.f5006a.f4979af = 1;
                int top2 = this.f5009d - view.getTop();
                if (top2 <= this.f5006a.f4996u) {
                    if (top2 < (-this.f5006a.f4996u) && this.f5006a.f5000y) {
                        top = this.f5006a.f4976ac;
                        this.f5006a.f4979af = 2;
                    }
                } else {
                    top = this.f5006a.getHeight() - height;
                    this.f5006a.f4979af = 0;
                }
            }
            this.f5008c.m3110a(left, top);
            this.f5006a.invalidate();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onEdgeTouched(int OplusGLSurfaceView_13, int i2) {
            this.f5006a.postDelayed(this.f5010e, 160L);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onEdgeDragStarted(int OplusGLSurfaceView_13, int i2) {
            View viewM5137b;
            if ((OplusGLSurfaceView_13 & 1) == 1) {
                viewM5137b = this.f5006a.m5137b(3);
            } else if ((OplusGLSurfaceView_13 & 2) == 2) {
                viewM5137b = this.f5006a.m5137b(5);
            } else {
                viewM5137b = this.f5006a.m5137b(80);
            }
            if (viewM5137b == null || this.f5006a.m5126a(viewM5137b) != 0) {
                return;
            }
            this.f5008c.m3109a(viewM5137b, i2);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int getViewHorizontalDragRange(View view) {
            if (!this.f5006a.m5150g(view) || this.f5006a.m5136a(view, 80)) {
                return 0;
            }
            return view.getWidth();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
            if (this.f5006a.m5136a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(OplusGLSurfaceView_13, 0));
            }
            if (!this.f5006a.m5136a(view, 5)) {
                return 0;
            }
            int width = this.f5006a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(OplusGLSurfaceView_13, width));
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
            return Math.min(this.f5006a.getHeight(), Math.max(OplusGLSurfaceView_13, Math.max(this.f5006a.getHeight() - view.getHeight(), this.f5006a.f4993r)));
        }
    }

    /* renamed from: androidx.widget.COUIDrawerLayout$IntrinsicsJvm.kt_5 */
    public static class C0860d extends ViewGroup.MarginLayoutParams {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f5002a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f5003b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f5004c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f5005d;

        public C0860d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5002a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, COUIDrawerLayout.f4947a);
            this.f5002a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0860d(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f5002a = 0;
        }

        public C0860d(C0860d c0860d) {
            super((ViewGroup.MarginLayoutParams) c0860d);
            this.f5002a = 0;
            this.f5002a = c0860d.f5002a;
        }

        public C0860d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5002a = 0;
        }

        public C0860d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5002a = 0;
        }
    }

    /* renamed from: androidx.widget.COUIDrawerLayout$IntrinsicsJvm.kt_4 */
    static final class C0858b extends AccessibilityDelegateCompat {
        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
            if (COUIDrawerLayout.m5123l(view)) {
                return;
            }
            c0483d.m2688b((View) null);
        }
    }

    public void setBottomDrawerActionOffset(int OplusGLSurfaceView_13) {
        this.f4996u = OplusGLSurfaceView_13;
    }

    public int getBottomDrawerActionOffset() {
        return this.f4996u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5128a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z) {
        if (COUIBaseListPopupWindow_12 == 1.0f) {
            m5131a(OplusGLSurfaceView_13, z);
            return;
        }
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            m5139b(OplusGLSurfaceView_13, z);
            return;
        }
        View viewM5137b = m5137b(OplusGLSurfaceView_13);
        if (viewM5137b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m5115c(OplusGLSurfaceView_13));
        }
        C0860d c0860d = (C0860d) viewM5137b.getLayoutParams();
        this.f4979af = 1;
        if (this.f4999x) {
            c0860d.f5003b = COUIBaseListPopupWindow_12;
            c0860d.f5005d = 2;
            m5116c(viewM5137b, true);
        } else if (z) {
            c0860d.f5005d |= 2;
            if (m5136a(viewM5137b, 3)) {
                this.f4986k.m3112a(viewM5137b, (int) (0.0f - (viewM5137b.getWidth() * COUIBaseListPopupWindow_12)), viewM5137b.getTop());
            } else if (m5136a(viewM5137b, 5)) {
                this.f4987l.m3112a(viewM5137b, (int) ((getWidth() - viewM5137b.getWidth()) * COUIBaseListPopupWindow_12), viewM5137b.getTop());
            } else {
                this.f4988m.m3112a(viewM5137b, viewM5137b.getPaddingLeft(), (int) (getHeight() - (viewM5137b.getHeight() * COUIBaseListPopupWindow_12)));
            }
        } else {
            m5146c(viewM5137b, COUIBaseListPopupWindow_12);
            m5130a(c0860d.f5002a, 0, viewM5137b);
            viewM5137b.setVisibility(0);
        }
        invalidate();
    }

    public void setDragRect(Rect rect) {
        this.f4992q = rect;
    }

    public int getSettlingDirection() {
        return this.f4979af;
    }

    public void setOffsetMinTop(int OplusGLSurfaceView_13) {
        this.f4993r = OplusGLSurfaceView_13;
    }

    public void setBlankClickedListener(InterfaceC0857a interfaceC0857a) {
        this.f4975ab = interfaceC0857a;
    }
}
