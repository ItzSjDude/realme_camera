package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.p036h.ViewPropertyAnimatorListener;

/* compiled from: AbsActionBarView.java */
/* renamed from: androidx.appcompat.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final PlatformImplementations.kt_3 f1705a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final Context f1706b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected ActionMenuView f1707c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected ActionMenuPresenter f1708d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f1709e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected ViewPropertyAnimatorCompat f1710f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f1711g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f1712h;

    /* renamed from: PlatformImplementations.kt_3 */
    protected static int m1387a(int OplusGLSurfaceView_13, int i2, boolean z) {
        return z ? OplusGLSurfaceView_13 - i2 : OplusGLSurfaceView_13 + i2;
    }

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f1705a = new PlatformImplementations.kt_3();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f1706b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f1706b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1708d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1253a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1711g = false;
        }
        if (!this.f1711g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1711g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1711g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1712h = false;
        }
        if (!this.f1712h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1712h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1712h = false;
        }
        return true;
    }

    public void setContentHeight(int OplusGLSurfaceView_13) {
        this.f1709e = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1709e;
    }

    public int getAnimatedVisibility() {
        if (this.f1710f != null) {
            return this.f1705a.f1713a;
        }
        return getVisibility();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat mo1218a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        ViewPropertyAnimatorCompat c0517z = this.f1710f;
        if (c0517z != null) {
            c0517z.m2953b();
        }
        if (OplusGLSurfaceView_13 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat c0517zM2946a = ViewCompat.m2895n(this).m2946a(1.0f);
            c0517zM2946a.m2947a(OplusGLSurfaceView_15);
            c0517zM2946a.m2949a(this.f1705a.m1392a(c0517zM2946a, OplusGLSurfaceView_13));
            return c0517zM2946a;
        }
        ViewPropertyAnimatorCompat c0517zM2946a2 = ViewCompat.m2895n(this).m2946a(0.0f);
        c0517zM2946a2.m2947a(OplusGLSurfaceView_15);
        c0517zM2946a2.m2949a(this.f1705a.m1392a(c0517zM2946a2, OplusGLSurfaceView_13));
        return c0517zM2946a2;
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != getVisibility()) {
            ViewPropertyAnimatorCompat c0517z = this.f1710f;
            if (c0517z != null) {
                c0517z.m2953b();
            }
            super.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1220a() {
        ActionMenuPresenter actionMenuPresenter = this.f1708d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.m1260c();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m1390a(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(OplusGLSurfaceView_13, Integer.MIN_VALUE), i2);
        return Math.max(0, (OplusGLSurfaceView_13 - view.getMeasuredWidth()) - i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m1391a(View view, int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(OplusGLSurfaceView_13 - measuredWidth, i4, OplusGLSurfaceView_13, measuredHeight + i4);
        } else {
            view.layout(OplusGLSurfaceView_13, i4, OplusGLSurfaceView_13 + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 implements ViewPropertyAnimatorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        int f1713a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f1715c = false;

        protected PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m1392a(ViewPropertyAnimatorCompat c0517z, int OplusGLSurfaceView_13) {
            AbsActionBarView.this.f1710f = c0517z;
            this.f1713a = OplusGLSurfaceView_13;
            return this;
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo852a(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f1715c = false;
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo853b(View view) {
            if (this.f1715c) {
                return;
            }
            AbsActionBarView abstractC0304a = AbsActionBarView.this;
            abstractC0304a.f1710f = null;
            AbsActionBarView.super.setVisibility(this.f1713a);
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo1393c(View view) {
            this.f1715c = true;
        }
    }
}
