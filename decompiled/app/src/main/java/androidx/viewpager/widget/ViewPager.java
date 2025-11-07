package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.OnApplyWindowInsetsListener;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: A */
    private int f4791A;

    /* renamed from: B */
    private boolean f4792B;

    /* renamed from: C */
    private boolean f4793C;

    /* renamed from: D */
    private int f4794D;

    /* renamed from: E */
    private int f4795E;

    /* renamed from: F */
    private int f4796F;

    /* renamed from: G */
    private float f4797G;

    /* renamed from: H */
    private float f4798H;

    /* renamed from: I */
    private float f4799I;

    /* renamed from: J */
    private float f4800J;

    /* renamed from: K */
    private int f4801K;

    /* renamed from: L */
    private VelocityTracker f4802L;

    /* renamed from: M */
    private int f4803M;

    /* renamed from: N */
    private int f4804N;

    /* renamed from: O */
    private int f4805O;

    /* renamed from: P */
    private int f4806P;

    /* renamed from: Q */
    private boolean f4807Q;

    /* renamed from: R */
    private EdgeEffect f4808R;

    /* renamed from: S */
    private EdgeEffect f4809S;

    /* renamed from: T */
    private boolean f4810T;

    /* renamed from: U */
    private boolean f4811U;

    /* renamed from: V */
    private boolean f4812V;

    /* renamed from: W */
    private int f4813W;

    /* renamed from: aa */
    private List<InterfaceC0827f> f4814aa;

    /* renamed from: ab */
    private InterfaceC0827f f4815ab;

    /* renamed from: ac */
    private InterfaceC0827f f4816ac;

    /* renamed from: ad */
    private List<InterfaceC0826e> f4817ad;

    /* renamed from: ae */
    private InterfaceC0828g f4818ae;

    /* renamed from: af */
    private int f4819af;

    /* renamed from: ag */
    private int f4820ag;

    /* renamed from: ah */
    private ArrayList<View> f4821ah;

    /* renamed from: aj */
    private final Runnable f4822aj;

    /* renamed from: ak */
    private int f4823ak;

    /* renamed from: IntrinsicsJvm.kt_4 */
    PagerAdapter f4824b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4825c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f4826d;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final ArrayList<C0823b> f4827g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final C0823b f4828h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Rect f4829i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f4830j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Parcelable f4831k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ClassLoader f4832l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Scroller f4833m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f4834n;

    /* renamed from: o */
    private C0829h f4835o;

    /* renamed from: p */
    private int f4836p;

    /* renamed from: q */
    private Drawable f4837q;

    /* renamed from: r */
    private int f4838r;

    /* renamed from: s */
    private int f4839s;

    /* renamed from: t */
    private float f4840t;

    /* renamed from: u */
    private float f4841u;

    /* renamed from: v */
    private int f4842v;

    /* renamed from: w */
    private int f4843w;

    /* renamed from: x */
    private boolean f4844x;

    /* renamed from: y */
    private boolean f4845y;

    /* renamed from: z */
    private boolean f4846z;

    /* renamed from: PlatformImplementations.kt_3 */
    static final int[] f4787a = {R.attr.layout_gravity};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Comparator<C0823b> f4789e = new Comparator<C0823b>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(C0823b c0823b, C0823b c0823b2) {
            return c0823b.f4851b - c0823b2.f4851b;
        }
    };

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final Interpolator f4790f = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            float f2 = COUIBaseListPopupWindow_12 - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: ai */
    private static final C0830i f4788ai = new C0830i();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.viewpager.widget.ViewPager$PlatformImplementations.kt_3 */
    public @interface InterfaceC0822a {
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_8 */
    public interface InterfaceC0826e {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter abstractC0831a, PagerAdapter abstractC0831a2);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_12 */
    public interface InterfaceC0827f {
        void onPageScrollStateChanged(int OplusGLSurfaceView_13);

        void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2);

        void onPageSelected(int OplusGLSurfaceView_13);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_11 */
    public interface InterfaceC0828g {
        /* renamed from: PlatformImplementations.kt_3 */
        void m4998a(View view, float COUIBaseListPopupWindow_12);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$IntrinsicsJvm.kt_4 */
    static class C0823b {

        /* renamed from: PlatformImplementations.kt_3 */
        Object f4850a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4851b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f4852c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f4853d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        float f4854e;

        C0823b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f4827g = new ArrayList<>();
        this.f4828h = new C0823b();
        this.f4829i = new Rect();
        this.f4830j = -1;
        this.f4831k = null;
        this.f4832l = null;
        this.f4840t = -3.4028235E38f;
        this.f4841u = Float.MAX_VALUE;
        this.f4791A = 1;
        this.f4801K = -1;
        this.f4810T = true;
        this.f4811U = false;
        this.f4822aj = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewPager.this.setScrollState(0);
                ViewPager.this.m4989c();
            }
        };
        this.f4823ak = 0;
        m4973a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4827g = new ArrayList<>();
        this.f4828h = new C0823b();
        this.f4829i = new Rect();
        this.f4830j = -1;
        this.f4831k = null;
        this.f4832l = null;
        this.f4840t = -3.4028235E38f;
        this.f4841u = Float.MAX_VALUE;
        this.f4791A = 1;
        this.f4801K = -1;
        this.f4810T = true;
        this.f4811U = false;
        this.f4822aj = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewPager.this.setScrollState(0);
                ViewPager.this.m4989c();
            }
        };
        this.f4823ak = 0;
        m4973a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4973a() {
        setWillNotDraw(false);
        setDescendantFocusability(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        setFocusable(true);
        Context context = getContext();
        this.f4833m = new Scroller(context, f4790f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float COUIBaseListPopupWindow_12 = context.getResources().getDisplayMetrics().density;
        this.f4796F = viewConfiguration.getScaledPagingTouchSlop();
        this.f4803M = (int) (400.0f * COUIBaseListPopupWindow_12);
        this.f4804N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4808R = new EdgeEffect(context);
        this.f4809S = new EdgeEffect(context);
        this.f4805O = (int) (25.0f * COUIBaseListPopupWindow_12);
        this.f4806P = (int) (2.0f * COUIBaseListPopupWindow_12);
        this.f4794D = (int) (COUIBaseListPopupWindow_12 * 16.0f);
        ViewCompat.m2854a(this, new C0825d());
        if (ViewCompat.m2883f(this) == 0) {
            ViewCompat.m2867b((View) this, 1);
        }
        ViewCompat.m2855a(this, new OnApplyWindowInsetsListener() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: IntrinsicsJvm.kt_4 */
            private final Rect f4849b = new Rect();

            @Override // androidx.core.p036h.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat c0490ad) {
                WindowInsetsCompat c0490adM2839a = ViewCompat.m2839a(view, c0490ad);
                if (c0490adM2839a.m2765f()) {
                    return c0490adM2839a;
                }
                Rect rect = this.f4849b;
                rect.left = c0490adM2839a.m2759a();
                rect.top = c0490adM2839a.m2761b();
                rect.right = c0490adM2839a.m2762c();
                rect.bottom = c0490adM2839a.m2763d();
                int childCount = ViewPager.this.getChildCount();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                    WindowInsetsCompat c0490adM2865b = ViewCompat.m2865b(ViewPager.this.getChildAt(OplusGLSurfaceView_13), c0490adM2839a);
                    rect.left = Math.min(c0490adM2865b.m2759a(), rect.left);
                    rect.top = Math.min(c0490adM2865b.m2761b(), rect.top);
                    rect.right = Math.min(c0490adM2865b.m2762c(), rect.right);
                    rect.bottom = Math.min(c0490adM2865b.m2763d(), rect.bottom);
                }
                return c0490adM2839a.m2760a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4822aj);
        Scroller scroller = this.f4833m;
        if (scroller != null && !scroller.isFinished()) {
            this.f4833m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int OplusGLSurfaceView_13) {
        if (this.f4823ak == OplusGLSurfaceView_13) {
            return;
        }
        this.f4823ak = OplusGLSurfaceView_13;
        if (this.f4818ae != null) {
            m4958b(OplusGLSurfaceView_13 != 0);
        }
        m4965f(OplusGLSurfaceView_13);
    }

    public void setAdapter(PagerAdapter abstractC0831a) throws Resources.NotFoundException {
        PagerAdapter abstractC0831a2 = this.f4824b;
        if (abstractC0831a2 != null) {
            abstractC0831a2.m5020c(null);
            this.f4824b.m5009a((ViewGroup) this);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4827g.size(); OplusGLSurfaceView_13++) {
                C0823b c0823b = this.f4827g.get(OplusGLSurfaceView_13);
                this.f4824b.mo5010a((ViewGroup) this, c0823b.f4851b, c0823b.f4850a);
            }
            this.f4824b.m5017b((ViewGroup) this);
            this.f4827g.clear();
            m4964f();
            this.f4825c = 0;
            scrollTo(0, 0);
        }
        PagerAdapter abstractC0831a3 = this.f4824b;
        this.f4824b = abstractC0831a;
        this.f4826d = 0;
        if (this.f4824b != null) {
            if (this.f4835o == null) {
                this.f4835o = new C0829h();
            }
            this.f4824b.m5020c(this.f4835o);
            this.f4846z = false;
            boolean z = this.f4810T;
            this.f4810T = true;
            this.f4826d = this.f4824b.mo5000a();
            if (this.f4830j >= 0) {
                this.f4824b.m5006a(this.f4831k, this.f4832l);
                m4978a(this.f4830j, false, true);
                this.f4830j = -1;
                this.f4831k = null;
                this.f4832l = null;
            } else if (!z) {
                m4989c();
            } else {
                requestLayout();
            }
        }
        List<InterfaceC0826e> list = this.f4817ad;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f4817ad.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4817ad.get(i2).onAdapterChanged(this, abstractC0831a3, abstractC0831a);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m4964f() {
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < getChildCount()) {
            if (!((C0824c) getChildAt(OplusGLSurfaceView_13).getLayoutParams()).f4855a) {
                removeViewAt(OplusGLSurfaceView_13);
                OplusGLSurfaceView_13--;
            }
            OplusGLSurfaceView_13++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f4824b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4980a(InterfaceC0826e interfaceC0826e) {
        if (this.f4817ad == null) {
            this.f4817ad = new ArrayList();
        }
        this.f4817ad.add(interfaceC0826e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4987b(InterfaceC0826e interfaceC0826e) {
        List<InterfaceC0826e> list = this.f4817ad;
        if (list != null) {
            list.remove(interfaceC0826e);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f4846z = false;
        m4978a(OplusGLSurfaceView_13, !this.f4810T, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4977a(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        this.f4846z = false;
        m4978a(OplusGLSurfaceView_13, z, false);
    }

    public int getCurrentItem() {
        return this.f4825c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4978a(int OplusGLSurfaceView_13, boolean z, boolean z2) throws Resources.NotFoundException {
        m4979a(OplusGLSurfaceView_13, z, z2, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4979a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2) throws Resources.NotFoundException {
        PagerAdapter abstractC0831a = this.f4824b;
        if (abstractC0831a == null || abstractC0831a.mo5000a() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f4825c == OplusGLSurfaceView_13 && this.f4827g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        } else if (OplusGLSurfaceView_13 >= this.f4824b.mo5000a()) {
            OplusGLSurfaceView_13 = this.f4824b.mo5000a() - 1;
        }
        int i3 = this.f4791A;
        int i4 = this.f4825c;
        if (OplusGLSurfaceView_13 > i4 + i3 || OplusGLSurfaceView_13 < i4 - i3) {
            for (int i5 = 0; i5 < this.f4827g.size(); i5++) {
                this.f4827g.get(i5).f4852c = true;
            }
        }
        boolean z3 = this.f4825c != OplusGLSurfaceView_13;
        if (this.f4810T) {
            this.f4825c = OplusGLSurfaceView_13;
            if (z3) {
                m4963e(OplusGLSurfaceView_13);
            }
            requestLayout();
            return;
        }
        m4974a(OplusGLSurfaceView_13);
        m4952a(OplusGLSurfaceView_13, z, i2, z3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4952a(int OplusGLSurfaceView_13, boolean z, int i2, boolean z2) throws Resources.NotFoundException {
        C0823b c0823bM4984b = m4984b(OplusGLSurfaceView_13);
        int clientWidth = c0823bM4984b != null ? (int) (getClientWidth() * Math.max(this.f4840t, Math.min(c0823bM4984b.f4854e, this.f4841u))) : 0;
        if (z) {
            m4976a(clientWidth, 0, i2);
            if (z2) {
                m4963e(OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        if (z2) {
            m4963e(OplusGLSurfaceView_13);
        }
        m4955a(false);
        scrollTo(clientWidth, 0);
        m4962d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC0827f interfaceC0827f) {
        this.f4815ab = interfaceC0827f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4981a(InterfaceC0827f interfaceC0827f) {
        if (this.f4814aa == null) {
            this.f4814aa = new ArrayList();
        }
        this.f4814aa.add(interfaceC0827f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4988b(InterfaceC0827f interfaceC0827f) {
        List<InterfaceC0827f> list = this.f4814aa;
        if (list != null) {
            list.remove(interfaceC0827f);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int OplusGLSurfaceView_13, int i2) {
        if (this.f4820ag == 2) {
            i2 = (OplusGLSurfaceView_13 - 1) - i2;
        }
        return ((C0824c) this.f4821ah.get(i2).getLayoutParams()).f4860f;
    }

    public int getOffscreenPageLimit() {
        return this.f4791A;
    }

    public void setOffscreenPageLimit(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (OplusGLSurfaceView_13 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + OplusGLSurfaceView_13 + " too small; defaulting to 1");
            OplusGLSurfaceView_13 = 1;
        }
        if (OplusGLSurfaceView_13 != this.f4791A) {
            this.f4791A = OplusGLSurfaceView_13;
            m4989c();
        }
    }

    public void setPageMargin(int OplusGLSurfaceView_13) {
        int i2 = this.f4836p;
        this.f4836p = OplusGLSurfaceView_13;
        int width = getWidth();
        m4951a(width, width, OplusGLSurfaceView_13, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f4836p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f4837q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int OplusGLSurfaceView_13) {
        setPageMarginDrawable(ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4837q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4837q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    float m4970a(float COUIBaseListPopupWindow_12) {
        return (float) Math.sin((COUIBaseListPopupWindow_12 - 0.5f) * 0.47123894f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4976a(int OplusGLSurfaceView_13, int i2, int i3) throws Resources.NotFoundException {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f4833m;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f4834n ? this.f4833m.getCurrX() : this.f4833m.getStartX();
            this.f4833m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = OplusGLSurfaceView_13 - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m4955a(false);
            m4989c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float COUIBaseListPopupWindow_12 = clientWidth;
        float f2 = i7;
        float fM4970a = f2 + (m4970a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / COUIBaseListPopupWindow_12)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM4970a / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((COUIBaseListPopupWindow_12 * this.f4824b.m5012b(this.f4825c)) + this.f4836p)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f4834n = false;
        this.f4833m.startScroll(i4, scrollY, i5, i6, iMin);
        ViewCompat.m2881e(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    C0823b m4971a(int OplusGLSurfaceView_13, int i2) {
        C0823b c0823b = new C0823b();
        c0823b.f4851b = OplusGLSurfaceView_13;
        c0823b.f4850a = this.f4824b.mo5004a((ViewGroup) this, OplusGLSurfaceView_13);
        c0823b.f4853d = this.f4824b.m5012b(OplusGLSurfaceView_13);
        if (i2 < 0 || i2 >= this.f4827g.size()) {
            this.f4827g.add(c0823b);
        } else {
            this.f4827g.add(i2, c0823b);
        }
        return c0823b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4986b() throws Resources.NotFoundException {
        int iMo5000a = this.f4824b.mo5000a();
        this.f4826d = iMo5000a;
        boolean z = this.f4827g.size() < (this.f4791A * 2) + 1 && this.f4827g.size() < iMo5000a;
        int iMax = this.f4825c;
        int OplusGLSurfaceView_13 = 0;
        boolean z2 = false;
        while (OplusGLSurfaceView_13 < this.f4827g.size()) {
            C0823b c0823b = this.f4827g.get(OplusGLSurfaceView_13);
            int iM5001a = this.f4824b.m5001a(c0823b.f4850a);
            if (iM5001a != -1) {
                if (iM5001a == -2) {
                    this.f4827g.remove(OplusGLSurfaceView_13);
                    OplusGLSurfaceView_13--;
                    if (!z2) {
                        this.f4824b.m5009a((ViewGroup) this);
                        z2 = true;
                    }
                    this.f4824b.mo5010a((ViewGroup) this, c0823b.f4851b, c0823b.f4850a);
                    if (this.f4825c == c0823b.f4851b) {
                        iMax = Math.max(0, Math.min(this.f4825c, iMo5000a - 1));
                    }
                } else if (c0823b.f4851b != iM5001a) {
                    if (c0823b.f4851b == this.f4825c) {
                        iMax = iM5001a;
                    }
                    c0823b.f4851b = iM5001a;
                }
                z = true;
            }
            OplusGLSurfaceView_13++;
        }
        if (z2) {
            this.f4824b.m5017b((ViewGroup) this);
        }
        Collections.sort(this.f4827g, f4789e);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                C0824c c0824c = (C0824c) getChildAt(i2).getLayoutParams();
                if (!c0824c.f4855a) {
                    c0824c.f4857c = 0.0f;
                }
            }
            m4978a(iMax, false, true);
            requestLayout();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4989c() throws Resources.NotFoundException {
        m4974a(this.f4825c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe A[PHI: r7 r10 r15
      0x00fe: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B:63:0x00f3, B:60:0x00dd, B:54:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r10v4 int) = (r10v3 int), (r10v2 int), (r10v7 int) binds: [B:63:0x00f3, B:60:0x00dd, B:54:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r15v6 int) = (r15v4 int), (r15v5 int), (r15v9 int) binds: [B:63:0x00f3, B:60:0x00dd, B:54:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m4974a(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m4974a(int):void");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m4966g() {
        if (this.f4820ag != 0) {
            ArrayList<View> arrayList = this.f4821ah;
            if (arrayList == null) {
                this.f4821ah = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                this.f4821ah.add(getChildAt(OplusGLSurfaceView_13));
            }
            Collections.sort(this.f4821ah, f4788ai);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4954a(C0823b c0823b, int OplusGLSurfaceView_13, C0823b c0823b2) {
        C0823b c0823b3;
        C0823b c0823b4;
        int iMo5000a = this.f4824b.mo5000a();
        int clientWidth = getClientWidth();
        float COUIBaseListPopupWindow_12 = clientWidth > 0 ? this.f4836p / clientWidth : 0.0f;
        if (c0823b2 != null) {
            int i2 = c0823b2.f4851b;
            if (i2 < c0823b.f4851b) {
                float fM5012b = c0823b2.f4854e + c0823b2.f4853d + COUIBaseListPopupWindow_12;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= c0823b.f4851b && i4 < this.f4827g.size()) {
                    C0823b c0823b5 = this.f4827g.get(i4);
                    while (true) {
                        c0823b4 = c0823b5;
                        if (i3 <= c0823b4.f4851b || i4 >= this.f4827g.size() - 1) {
                            break;
                        }
                        i4++;
                        c0823b5 = this.f4827g.get(i4);
                    }
                    while (i3 < c0823b4.f4851b) {
                        fM5012b += this.f4824b.m5012b(i3) + COUIBaseListPopupWindow_12;
                        i3++;
                    }
                    c0823b4.f4854e = fM5012b;
                    fM5012b += c0823b4.f4853d + COUIBaseListPopupWindow_12;
                    i3++;
                }
            } else if (i2 > c0823b.f4851b) {
                int size = this.f4827g.size() - 1;
                float fM5012b2 = c0823b2.f4854e;
                while (true) {
                    i2--;
                    if (i2 < c0823b.f4851b || size < 0) {
                        break;
                    }
                    C0823b c0823b6 = this.f4827g.get(size);
                    while (true) {
                        c0823b3 = c0823b6;
                        if (i2 >= c0823b3.f4851b || size <= 0) {
                            break;
                        }
                        size--;
                        c0823b6 = this.f4827g.get(size);
                    }
                    while (i2 > c0823b3.f4851b) {
                        fM5012b2 -= this.f4824b.m5012b(i2) + COUIBaseListPopupWindow_12;
                        i2--;
                    }
                    fM5012b2 -= c0823b3.f4853d + COUIBaseListPopupWindow_12;
                    c0823b3.f4854e = fM5012b2;
                }
            }
        }
        int size2 = this.f4827g.size();
        float fM5012b3 = c0823b.f4854e;
        int i5 = c0823b.f4851b - 1;
        this.f4840t = c0823b.f4851b == 0 ? c0823b.f4854e : -3.4028235E38f;
        int i6 = iMo5000a - 1;
        this.f4841u = c0823b.f4851b == i6 ? (c0823b.f4854e + c0823b.f4853d) - 1.0f : Float.MAX_VALUE;
        int i7 = OplusGLSurfaceView_13 - 1;
        while (i7 >= 0) {
            C0823b c0823b7 = this.f4827g.get(i7);
            while (i5 > c0823b7.f4851b) {
                fM5012b3 -= this.f4824b.m5012b(i5) + COUIBaseListPopupWindow_12;
                i5--;
            }
            fM5012b3 -= c0823b7.f4853d + COUIBaseListPopupWindow_12;
            c0823b7.f4854e = fM5012b3;
            if (c0823b7.f4851b == 0) {
                this.f4840t = fM5012b3;
            }
            i7--;
            i5--;
        }
        float fM5012b4 = c0823b.f4854e + c0823b.f4853d + COUIBaseListPopupWindow_12;
        int i8 = c0823b.f4851b + 1;
        int i9 = OplusGLSurfaceView_13 + 1;
        while (i9 < size2) {
            C0823b c0823b8 = this.f4827g.get(i9);
            while (i8 < c0823b8.f4851b) {
                fM5012b4 += this.f4824b.m5012b(i8) + COUIBaseListPopupWindow_12;
                i8++;
            }
            if (c0823b8.f4851b == i6) {
                this.f4841u = (c0823b8.f4853d + fM5012b4) - 1.0f;
            }
            c0823b8.f4854e = fM5012b4;
            fM5012b4 += c0823b8.f4853d + COUIBaseListPopupWindow_12;
            i9++;
            i8++;
        }
        this.f4811U = false;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager.widget.ViewPager.SavedState.1
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, OplusGLSurfaceView_13);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.f4825c;
        PagerAdapter abstractC0831a = this.f4824b;
        if (abstractC0831a != null) {
            savedState.adapterState = abstractC0831a.m5013b();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter abstractC0831a = this.f4824b;
        if (abstractC0831a != null) {
            abstractC0831a.m5006a(savedState.adapterState, savedState.loader);
            m4978a(savedState.position, false, true);
        } else {
            this.f4830j = savedState.position;
            this.f4831k = savedState.adapterState;
            this.f4832l = savedState.loader;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0824c c0824c = (C0824c) layoutParams;
        c0824c.f4855a |= m4961c(view);
        if (this.f4844x) {
            if (c0824c != null && c0824c.f4855a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0824c.f4858d = true;
            addViewInLayout(view, OplusGLSurfaceView_13, layoutParams);
            return;
        }
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m4961c(View view) {
        return view.getClass().getAnnotation(InterfaceC0822a.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f4844x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    C0823b m4972a(View view) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4827g.size(); OplusGLSurfaceView_13++) {
            C0823b c0823b = this.f4827g.get(OplusGLSurfaceView_13);
            if (this.f4824b.mo5011a(view, c0823b.f4850a)) {
                return c0823b;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    C0823b m4985b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return m4972a(view);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    C0823b m4984b(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f4827g.size(); i2++) {
            C0823b c0823b = this.f4827g.get(i2);
            if (c0823b.f4851b == OplusGLSurfaceView_13) {
                return c0823b;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4810T = true;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        C0824c c0824c;
        C0824c c0824c2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, OplusGLSurfaceView_13), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f4795E = Math.min(measuredWidth / 10, this.f4794D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int measuredHeight2 = measuredHeight;
        int measuredWidth2 = paddingLeft;
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (c0824c2 = (C0824c) childAt.getLayoutParams()) != null && c0824c2.f4855a) {
                int i8 = c0824c2.f4856b & 7;
                int i9 = c0824c2.f4856b & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (c0824c2.width != -2) {
                    i4 = c0824c2.width != -1 ? c0824c2.width : measuredWidth2;
                    i10 = 1073741824;
                } else {
                    i4 = measuredWidth2;
                }
                if (c0824c2.height != -2) {
                    i5 = c0824c2.height != -1 ? c0824c2.height : measuredHeight2;
                } else {
                    i5 = measuredHeight2;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight2 -= childAt.getMeasuredHeight();
                } else if (z2) {
                    measuredWidth2 -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.f4842v = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
        this.f4843w = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
        this.f4844x = true;
        m4989c();
        this.f4844x = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((c0824c = (C0824c) childAt2.getLayoutParams()) == null || !c0824c.f4855a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (measuredWidth2 * c0824c.f4857c), 1073741824), this.f4843w);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        if (OplusGLSurfaceView_13 != i3) {
            int i5 = this.f4836p;
            m4951a(OplusGLSurfaceView_13, i3, i5, i5);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4951a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f4827g.isEmpty()) {
            if (!this.f4833m.isFinished()) {
                this.f4833m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((OplusGLSurfaceView_13 - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        C0823b c0823bM4984b = m4984b(this.f4825c);
        int iMin = (int) ((c0823bM4984b != null ? Math.min(c0823bM4984b.f4854e, this.f4841u) : 0.0f) * ((OplusGLSurfaceView_13 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m4955a(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws Resources.NotFoundException {
        boolean z2;
        C0823b c0823bM4972a;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i5 = i3 - OplusGLSurfaceView_13;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i7 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0824c c0824c = (C0824c) childAt.getLayoutParams();
                if (c0824c.f4855a) {
                    int i9 = c0824c.f4856b & 7;
                    int i10 = c0824c.f4856b & 112;
                    if (i9 == 1) {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i9 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i9 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i10 == 16) {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i10 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i10 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i6 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i11 = iMax + scrollX;
                    childAt.layout(i11, iMax2, childAt.getMeasuredWidth() + i11, iMax2 + childAt.getMeasuredHeight());
                    i7++;
                }
            }
        }
        int i12 = (i5 - measuredWidth) - paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                C0824c c0824c2 = (C0824c) childAt2.getLayoutParams();
                if (!c0824c2.f4855a && (c0823bM4972a = m4972a(childAt2)) != null) {
                    float COUIBaseListPopupWindow_12 = i12;
                    int i14 = ((int) (c0823bM4972a.f4854e * COUIBaseListPopupWindow_12)) + measuredWidth;
                    if (c0824c2.f4858d) {
                        c0824c2.f4858d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (COUIBaseListPopupWindow_12 * c0824c2.f4857c), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - measuredHeight2) - measuredHeight, 1073741824));
                    }
                    childAt2.layout(i14, measuredHeight2, childAt2.getMeasuredWidth() + i14, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.f4838r = measuredHeight2;
        this.f4839s = i6 - measuredHeight;
        this.f4813W = i7;
        if (this.f4810T) {
            z2 = false;
            m4952a(this.f4825c, false, 0, false);
        } else {
            z2 = false;
        }
        this.f4810T = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f4834n = true;
        if (!this.f4833m.isFinished() && this.f4833m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f4833m.getCurrX();
            int currY = this.f4833m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m4962d(currX)) {
                    this.f4833m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.m2881e(this);
            return;
        }
        m4955a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m4962d(int OplusGLSurfaceView_13) {
        if (this.f4827g.size() == 0) {
            if (this.f4810T) {
                return false;
            }
            this.f4812V = false;
            m4975a(0, 0.0f, 0);
            if (this.f4812V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0823b c0823bM4968i = m4968i();
        int clientWidth = getClientWidth();
        int i2 = this.f4836p;
        int i3 = clientWidth + i2;
        float COUIBaseListPopupWindow_12 = clientWidth;
        int i4 = c0823bM4968i.f4851b;
        float f2 = ((OplusGLSurfaceView_13 / COUIBaseListPopupWindow_12) - c0823bM4968i.f4854e) / (c0823bM4968i.f4853d + (i2 / COUIBaseListPopupWindow_12));
        this.f4812V = false;
        m4975a(i4, f2, (int) (i3 * f2));
        if (this.f4812V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m4975a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f4813W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = r1
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$IntrinsicsJvm.kt_3 r9 = (androidx.viewpager.widget.ViewPager.C0824c) r9
            boolean r10 = r9.f4855a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f4856b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.m4957b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_11 r13 = r12.f4818ae
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$IntrinsicsJvm.kt_3 r0 = (androidx.viewpager.widget.ViewPager.C0824c) r0
            boolean r0 = r0.f4855a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_11 r3 = r12.f4818ae
            r3.m4998a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.f4812V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m4975a(int, float, int):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4957b(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        InterfaceC0827f interfaceC0827f = this.f4815ab;
        if (interfaceC0827f != null) {
            interfaceC0827f.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
        }
        List<InterfaceC0827f> list = this.f4814aa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                InterfaceC0827f interfaceC0827f2 = this.f4814aa.get(i3);
                if (interfaceC0827f2 != null) {
                    interfaceC0827f2.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
                }
            }
        }
        InterfaceC0827f interfaceC0827f3 = this.f4816ac;
        if (interfaceC0827f3 != null) {
            interfaceC0827f3.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m4963e(int OplusGLSurfaceView_13) {
        InterfaceC0827f interfaceC0827f = this.f4815ab;
        if (interfaceC0827f != null) {
            interfaceC0827f.onPageSelected(OplusGLSurfaceView_13);
        }
        List<InterfaceC0827f> list = this.f4814aa;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0827f interfaceC0827f2 = this.f4814aa.get(i2);
                if (interfaceC0827f2 != null) {
                    interfaceC0827f2.onPageSelected(OplusGLSurfaceView_13);
                }
            }
        }
        InterfaceC0827f interfaceC0827f3 = this.f4816ac;
        if (interfaceC0827f3 != null) {
            interfaceC0827f3.onPageSelected(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m4965f(int OplusGLSurfaceView_13) {
        InterfaceC0827f interfaceC0827f = this.f4815ab;
        if (interfaceC0827f != null) {
            interfaceC0827f.onPageScrollStateChanged(OplusGLSurfaceView_13);
        }
        List<InterfaceC0827f> list = this.f4814aa;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0827f interfaceC0827f2 = this.f4814aa.get(i2);
                if (interfaceC0827f2 != null) {
                    interfaceC0827f2.onPageScrollStateChanged(OplusGLSurfaceView_13);
                }
            }
        }
        InterfaceC0827f interfaceC0827f3 = this.f4816ac;
        if (interfaceC0827f3 != null) {
            interfaceC0827f3.onPageScrollStateChanged(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4955a(boolean z) {
        boolean z2 = this.f4823ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f4833m.isFinished()) {
                this.f4833m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4833m.getCurrX();
                int currY = this.f4833m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m4962d(currX);
                    }
                }
            }
        }
        this.f4846z = false;
        boolean z3 = z2;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4827g.size(); OplusGLSurfaceView_13++) {
            C0823b c0823b = this.f4827g.get(OplusGLSurfaceView_13);
            if (c0823b.f4852c) {
                c0823b.f4852c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.m2857a(this, this.f4822aj);
            } else {
                this.f4822aj.run();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4956a(float COUIBaseListPopupWindow_12, float f2) {
        return (COUIBaseListPopupWindow_12 < ((float) this.f4795E) && f2 > 0.0f) || (COUIBaseListPopupWindow_12 > ((float) (getWidth() - this.f4795E)) && f2 < 0.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4958b(boolean z) {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            getChildAt(OplusGLSurfaceView_13).setLayerType(z ? this.f4819af : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m4967h();
            return false;
        }
        if (action != 0) {
            if (this.f4792B) {
                return true;
            }
            if (this.f4793C) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f4799I = x;
            this.f4797G = x;
            float y = motionEvent.getY();
            this.f4800J = y;
            this.f4798H = y;
            this.f4801K = motionEvent.getPointerId(0);
            this.f4793C = false;
            this.f4834n = true;
            this.f4833m.computeScrollOffset();
            if (this.f4823ak == 2 && Math.abs(this.f4833m.getFinalX() - this.f4833m.getCurrX()) > this.f4806P) {
                this.f4833m.abortAnimation();
                this.f4846z = false;
                m4989c();
                this.f4792B = true;
                m4960c(true);
                setScrollState(1);
            } else {
                m4955a(false);
                this.f4792B = false;
            }
        } else if (action == 2) {
            int OplusGLSurfaceView_13 = this.f4801K;
            if (OplusGLSurfaceView_13 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(OplusGLSurfaceView_13);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float COUIBaseListPopupWindow_12 = x2 - this.f4797G;
                float fAbs = Math.abs(COUIBaseListPopupWindow_12);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.f4800J);
                if (COUIBaseListPopupWindow_12 != 0.0f && !m4956a(this.f4797G, COUIBaseListPopupWindow_12) && m4983a(this, false, (int) COUIBaseListPopupWindow_12, (int) x2, (int) y2)) {
                    this.f4797G = x2;
                    this.f4798H = y2;
                    this.f4793C = true;
                    return false;
                }
                if (fAbs > this.f4796F && fAbs * 0.5f > fAbs2) {
                    this.f4792B = true;
                    m4960c(true);
                    setScrollState(1);
                    this.f4797G = COUIBaseListPopupWindow_12 > 0.0f ? this.f4799I + this.f4796F : this.f4799I - this.f4796F;
                    this.f4798H = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.f4796F) {
                    this.f4793C = true;
                }
                if (this.f4792B && m4959b(x2)) {
                    ViewCompat.m2881e(this);
                }
            }
        } else if (action == 6) {
            m4953a(motionEvent);
        }
        if (this.f4802L == null) {
            this.f4802L = VelocityTracker.obtain();
        }
        this.f4802L.addMovement(motionEvent);
        return this.f4792B;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m4967h() {
        this.f4801K = -1;
        m4969j();
        this.f4808R.onRelease();
        this.f4809S.onRelease();
        return this.f4808R.isFinished() || this.f4809S.isFinished();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4960c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m4959b(float COUIBaseListPopupWindow_12) {
        boolean z;
        boolean z2;
        float f2 = this.f4797G - COUIBaseListPopupWindow_12;
        this.f4797G = COUIBaseListPopupWindow_12;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.f4840t * clientWidth;
        float f4 = this.f4841u * clientWidth;
        boolean z3 = false;
        C0823b c0823b = this.f4827g.get(0);
        ArrayList<C0823b> arrayList = this.f4827g;
        C0823b c0823b2 = arrayList.get(arrayList.size() - 1);
        if (c0823b.f4851b != 0) {
            f3 = c0823b.f4854e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (c0823b2.f4851b != this.f4824b.mo5000a() - 1) {
            f4 = c0823b2.f4854e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f4808R.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f4809S.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int OplusGLSurfaceView_13 = (int) scrollX;
        this.f4797G += scrollX - OplusGLSurfaceView_13;
        scrollTo(OplusGLSurfaceView_13, getScrollY());
        m4962d(OplusGLSurfaceView_13);
        return z3;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private C0823b m4968i() {
        int OplusGLSurfaceView_13;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float COUIBaseListPopupWindow_12 = clientWidth > 0 ? this.f4836p / clientWidth : 0.0f;
        C0823b c0823b = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = -1;
        boolean z = true;
        while (i2 < this.f4827g.size()) {
            C0823b c0823b2 = this.f4827g.get(i2);
            if (!z && c0823b2.f4851b != (OplusGLSurfaceView_13 = i3 + 1)) {
                c0823b2 = this.f4828h;
                c0823b2.f4854e = f2 + f3 + COUIBaseListPopupWindow_12;
                c0823b2.f4851b = OplusGLSurfaceView_13;
                c0823b2.f4853d = this.f4824b.m5012b(c0823b2.f4851b);
                i2--;
            }
            f2 = c0823b2.f4854e;
            float f4 = c0823b2.f4853d + f2 + COUIBaseListPopupWindow_12;
            if (!z && scrollX < f2) {
                return c0823b;
            }
            if (scrollX < f4 || i2 == this.f4827g.size() - 1) {
                return c0823b2;
            }
            i3 = c0823b2.f4851b;
            f3 = c0823b2.f4853d;
            i2++;
            z = false;
            c0823b = c0823b2;
        }
        return c0823b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4949a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2, int i3) {
        if (Math.abs(i3) <= this.f4805O || Math.abs(i2) <= this.f4803M) {
            OplusGLSurfaceView_13 += (int) (COUIBaseListPopupWindow_12 + (OplusGLSurfaceView_13 >= this.f4825c ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            OplusGLSurfaceView_13++;
        }
        if (this.f4827g.size() <= 0) {
            return OplusGLSurfaceView_13;
        }
        return Math.max(this.f4827g.get(0).f4851b, Math.min(OplusGLSurfaceView_13, this.f4827g.get(r1.size() - 1).f4851b));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter abstractC0831a;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (abstractC0831a = this.f4824b) != null && abstractC0831a.mo5000a() > 1)) {
            if (!this.f4808R.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f4840t * width);
                this.f4808R.setSize(height, width);
                zDraw = false | this.f4808R.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f4809S.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f4841u + 1.0f)) * width2);
                this.f4809S.setSize(height2, width2);
                zDraw |= this.f4809S.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f4808R.finish();
            this.f4809S.finish();
        }
        if (zDraw) {
            ViewCompat.m2881e(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f4836p <= 0 || this.f4837q == null || this.f4827g.size() <= 0 || this.f4824b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.f4836p / width;
        int OplusGLSurfaceView_13 = 0;
        C0823b c0823b = this.f4827g.get(0);
        float f5 = c0823b.f4854e;
        int size = this.f4827g.size();
        int i2 = c0823b.f4851b;
        int i3 = this.f4827g.get(size - 1).f4851b;
        while (i2 < i3) {
            while (i2 > c0823b.f4851b && OplusGLSurfaceView_13 < size) {
                OplusGLSurfaceView_13++;
                c0823b = this.f4827g.get(OplusGLSurfaceView_13);
            }
            if (i2 == c0823b.f4851b) {
                f2 = (c0823b.f4854e + c0823b.f4853d) * width;
                COUIBaseListPopupWindow_12 = c0823b.f4854e + c0823b.f4853d + f4;
            } else {
                float fM5012b = this.f4824b.m5012b(i2);
                float f6 = (f5 + fM5012b) * width;
                COUIBaseListPopupWindow_12 = f5 + fM5012b + f4;
                f2 = f6;
            }
            if (this.f4836p + f2 > scrollX) {
                f3 = f4;
                this.f4837q.setBounds(Math.round(f2), this.f4838r, Math.round(this.f4836p + f2), this.f4839s);
                this.f4837q.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f5 = COUIBaseListPopupWindow_12;
            f4 = f3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4953a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4801K) {
            int OplusGLSurfaceView_13 = actionIndex == 0 ? 1 : 0;
            this.f4797G = motionEvent.getX(OplusGLSurfaceView_13);
            this.f4801K = motionEvent.getPointerId(OplusGLSurfaceView_13);
            VelocityTracker velocityTracker = this.f4802L;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m4969j() {
        this.f4792B = false;
        this.f4793C = false;
        VelocityTracker velocityTracker = this.f4802L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4802L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f4845y != z) {
            this.f4845y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int OplusGLSurfaceView_13) {
        if (this.f4824b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return OplusGLSurfaceView_13 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f4840t)) : OplusGLSurfaceView_13 > 0 && scrollX < ((int) (((float) clientWidth) * this.f4841u));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m4983a(View view, boolean z, int OplusGLSurfaceView_13, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && m4983a(childAt, true, OplusGLSurfaceView_13, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-OplusGLSurfaceView_13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m4982a(keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m4982a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return m4991d();
                }
                return m4990c(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return m4992e();
                }
                return m4990c(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return m4990c(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m4990c(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m4990c(int r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto La
            goto L69
        La:
            if (r0 == 0) goto L68
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r6) goto L18
            r4 = r1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = r2
        L1e:
            if (r4 != 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.COUIBaseListPopupWindow_8(r4, r0)
            goto L69
        L68:
            r3 = r0
        L69:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r0 = r0.findNextFocus(r6, r3, r7)
            r4 = 66
            r5 = 17
            if (r0 == 0) goto Lba
            if (r0 == r3) goto Lba
            if (r7 != r5) goto L9a
            android.graphics.Rect r1 = r6.f4829i
            android.graphics.Rect r1 = r6.m4950a(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f4829i
            android.graphics.Rect r2 = r6.m4950a(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto L94
            if (r1 < r2) goto L94
            boolean r0 = r6.m4991d()
            goto L98
        L94:
            boolean r0 = r0.requestFocus()
        L98:
            r2 = r0
            goto Lcd
        L9a:
            if (r7 != r4) goto Lcd
            android.graphics.Rect r1 = r6.f4829i
            android.graphics.Rect r1 = r6.m4950a(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f4829i
            android.graphics.Rect r2 = r6.m4950a(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto Lb5
            if (r1 > r2) goto Lb5
            boolean r0 = r6.m4992e()
            goto L98
        Lb5:
            boolean r0 = r0.requestFocus()
            goto L98
        Lba:
            if (r7 == r5) goto Lc9
            if (r7 != r1) goto Lbf
            goto Lc9
        Lbf:
            if (r7 == r4) goto Lc4
            r0 = 2
            if (r7 != r0) goto Lcd
        Lc4:
            boolean r2 = r6.m4992e()
            goto Lcd
        Lc9:
            boolean r2 = r6.m4991d()
        Lcd:
            if (r2 == 0) goto Ld6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m4990c(int):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect m4950a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m4991d() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13 = this.f4825c;
        if (OplusGLSurfaceView_13 <= 0) {
            return false;
        }
        m4977a(OplusGLSurfaceView_13 - 1, true);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean m4992e() throws Resources.NotFoundException {
        PagerAdapter abstractC0831a = this.f4824b;
        if (abstractC0831a == null || this.f4825c >= abstractC0831a.mo5000a() - 1) {
            return false;
        }
        m4977a(this.f4825c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int OplusGLSurfaceView_13, int i2) {
        C0823b c0823bM4972a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (c0823bM4972a = m4972a(childAt)) != null && c0823bM4972a.f4851b == this.f4825c) {
                    childAt.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0823b c0823bM4972a;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt.getVisibility() == 0 && (c0823bM4972a = m4972a(childAt)) != null && c0823bM4972a.f4851b == this.f4825c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int OplusGLSurfaceView_13, Rect rect) {
        int i2;
        int i3;
        C0823b c0823bM4972a;
        int childCount = getChildCount();
        int i4 = -1;
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (c0823bM4972a = m4972a(childAt)) != null && c0823bM4972a.f4851b == this.f4825c && childAt.requestFocus(OplusGLSurfaceView_13, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0823b c0823bM4972a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt.getVisibility() == 0 && (c0823bM4972a = m4972a(childAt)) != null && c0823bM4972a.f4851b == this.f4825c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0824c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0824c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0824c(getContext(), attributeSet);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$IntrinsicsJvm.kt_5 */
    class C0825d extends AccessibilityDelegateCompat {
        C0825d() {
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m4997a());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.f4824b == null) {
                return;
            }
            accessibilityEvent.setItemCount(ViewPager.this.f4824b.mo5000a());
            accessibilityEvent.setFromIndex(ViewPager.this.f4825c);
            accessibilityEvent.setToIndex(ViewPager.this.f4825c);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
            c0483d.m2690b((CharSequence) ViewPager.class.getName());
            c0483d.m2715i(m4997a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                c0483d.m2676a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c0483d.m2676a(8192);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
                return true;
            }
            if (OplusGLSurfaceView_13 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f4825c + 1);
                return true;
            }
            if (OplusGLSurfaceView_13 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f4825c - 1);
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m4997a() {
            return ViewPager.this.f4824b != null && ViewPager.this.f4824b.mo5000a() > 1;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$COUIBaseListPopupWindow_10 */
    private class C0829h extends DataSetObserver {
        C0829h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.m4986b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.m4986b();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$IntrinsicsJvm.kt_3 */
    public static class C0824c extends ViewGroup.LayoutParams {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f4855a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f4856b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        float f4857c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f4858d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f4859e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f4860f;

        public C0824c() {
            super(-1, -1);
            this.f4857c = 0.0f;
        }

        public C0824c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4857c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4787a);
            this.f4856b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$OplusGLSurfaceView_13 */
    static class C0830i implements Comparator<View> {
        C0830i() {
        }

        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0824c c0824c = (C0824c) view.getLayoutParams();
            C0824c c0824c2 = (C0824c) view2.getLayoutParams();
            if (c0824c.f4855a != c0824c2.f4855a) {
                return c0824c.f4855a ? 1 : -1;
            }
            return c0824c.f4859e - c0824c2.f4859e;
        }
    }
}
