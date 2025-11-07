package com.coui.appcompat.dialog.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.p036h.ScrollingView;
import com.coui.appcompat.p099a.COUINavigationBarUtil;
import com.coui.appcompat.p099a.COUIPanelMultiWindowUtils;
import com.coui.appcompat.p099a.COUIViewMarginUtil;
import com.coui.appcompat.widget.COUIPanelConstraintLayout;
import com.coui.appcompat.widget.COUIButtonBarLayout;
import com.coui.appcompat.widget.IgnoreWindowInsetsFrameLayout;
import coui.support.appcompat.R;
import java.lang.ref.WeakReference;

/* compiled from: COUIPanelAdjustResizeHelper.java */
/* renamed from: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Interpolator f6833a = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Interpolator f6834b = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: OplusGLSurfaceView_6 */
    private int f6845m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f6846n;

    /* renamed from: o */
    private int f6847o;

    /* renamed from: p */
    private WeakReference<View> f6848p;

    /* renamed from: q */
    private ValueAnimator f6849q;

    /* renamed from: r */
    private ValueAnimator f6850r;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6835c = 2;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f6836d = true;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f6837e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6838f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6839g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6840h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6841i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private View f6842j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f6843k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f6844l = -1;

    /* renamed from: s */
    private int f6851s = 2;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6860a(Context context, ViewGroup viewGroup, WindowInsets windowInsets) throws Resources.NotFoundException {
        int iM6433c = COUINavigationBarUtil.m6432b(context) && !context.getResources().getBoolean(R.bool.is_ignore_nav_height_in_panel_ime_adjust) ? COUINavigationBarUtil.m6433c(context) : 0;
        if (Build.VERSION.SDK_INT >= 30) {
            m6847a(viewGroup, Math.max(0, windowInsets.getInsets(WindowInsets.Type.ime()).bottom - iM6433c), windowInsets);
            return;
        }
        int iM6840a = m6840a(windowInsets.getSystemWindowInsetBottom(), iM6433c);
        if (iM6840a > 0) {
            m6849a(viewGroup, true, iM6840a);
        } else if (this.f6835c != 2) {
            m6849a(viewGroup, false, this.f6839g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6840a(int OplusGLSurfaceView_13, int i2) {
        return this.f6851s == 2038 ? OplusGLSurfaceView_13 : OplusGLSurfaceView_13 - i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6847a(ViewGroup viewGroup, int OplusGLSurfaceView_13, WindowInsets windowInsets) throws Resources.NotFoundException {
        if (this.f6839g == OplusGLSurfaceView_13) {
            return;
        }
        m6852a(OplusGLSurfaceView_13 > 0);
        m6853a(viewGroup, OplusGLSurfaceView_13);
        m6861a(viewGroup, Boolean.valueOf(OplusGLSurfaceView_13 > 0));
        if (viewGroup instanceof COUIPanelConstraintLayout) {
            m6843a((View) viewGroup, OplusGLSurfaceView_13);
            COUIPanelConstraintLayout c1487l = (COUIPanelConstraintLayout) viewGroup;
            m6842a((View) c1487l.getBtnBarLayout(), 0.0f);
            m6842a(c1487l.getDivider(), 0.0f);
            return;
        }
        m6845a((View) viewGroup, this.f6847o, windowInsets);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6849a(ViewGroup viewGroup, boolean z, int OplusGLSurfaceView_13) {
        m6852a(z);
        m6853a(viewGroup, OplusGLSurfaceView_13);
        m6861a(viewGroup, Boolean.valueOf(z));
        m6848a(viewGroup, z);
        this.f6836d = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6852a(boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f6835c = 1;
        } else {
            this.f6835c = 2;
            if (!this.f6837e && z) {
                this.f6835c = 0;
            } else if (this.f6837e && z) {
                this.f6835c = 1;
            }
        }
        this.f6837e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m6853a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        if (viewGroup == null) {
            return false;
        }
        m6863b();
        if (viewGroup instanceof COUIPanelConstraintLayout) {
            COUIPanelConstraintLayout c1487l = (COUIPanelConstraintLayout) viewGroup;
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c1487l.getMaxHeight(), c1487l.getLayoutAtMaxHeight() ? 1073741824 : Integer.MIN_VALUE));
            m6846a(viewGroup);
        }
        this.f6838f = viewGroup.getMeasuredHeight();
        int i2 = this.f6835c;
        if (i2 == 0) {
            this.f6839g = OplusGLSurfaceView_13;
            this.f6840h = this.f6839g;
        } else if (i2 == 1) {
            this.f6838f -= OplusGLSurfaceView_13;
            this.f6840h = OplusGLSurfaceView_13 - this.f6839g;
            this.f6839g = OplusGLSurfaceView_13;
        } else if (i2 == 2 && !this.f6836d) {
            this.f6839g = OplusGLSurfaceView_13;
            this.f6840h = this.f6839g;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m6861a(ViewGroup viewGroup, Boolean bool) {
        this.f6848p = null;
        this.f6845m = 0;
        this.f6846n = 0.0f;
        this.f6847o = 0;
        if (viewGroup == null || this.f6840h == 0) {
            return;
        }
        if (viewGroup instanceof COUIPanelConstraintLayout) {
            m6851a((COUIPanelConstraintLayout) viewGroup, bool);
        } else {
            m6855b(viewGroup, bool);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6851a(COUIPanelConstraintLayout c1487l, Boolean bool) {
        int OplusGLSurfaceView_13 = this.f6835c == 2 ? -1 : 1;
        int maxHeight = c1487l.getMaxHeight();
        int i2 = this.f6840h * OplusGLSurfaceView_13;
        float translationY = c1487l.getBtnBarLayout() != null ? c1487l.getBtnBarLayout().getTranslationY() : 0.0f;
        this.f6848p = new WeakReference<>(c1487l);
        if ((this.f6843k && maxHeight != 0) || (!COUIPanelMultiWindowUtils.m6448e(c1487l.getContext()) && translationY == 0.0f)) {
            View view = this.f6842j;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 != null) {
                    this.f6844l = view2.getPaddingBottom();
                    this.f6848p = new WeakReference<>(view2);
                }
                this.f6846n = -i2;
            } else {
                this.f6844l = -1;
            }
            this.f6845m = i2;
            return;
        }
        int i3 = this.f6838f - this.f6841i;
        int paddingBottom = c1487l.getPaddingBottom();
        int height = c1487l.getBtnBarLayout() != null ? c1487l.getBtnBarLayout().getHeight() : 0;
        int height2 = c1487l.getDivider() != null ? c1487l.getDivider().getHeight() : 0;
        int i4 = this.f6835c;
        if (i4 == 1) {
            i3 += this.f6839g;
        } else if (i4 == 2) {
            i3 -= this.f6839g;
        }
        if (i3 >= this.f6839g + height + height2 && paddingBottom == 0) {
            this.f6846n = -i2;
            return;
        }
        int i5 = OplusGLSurfaceView_13 * (((this.f6839g + height) + height2) - i3);
        this.f6845m = Math.max(-paddingBottom, i5);
        if (this.f6835c == 1) {
            int iMax = Math.max(0, paddingBottom + i5);
            int i6 = this.f6839g;
            this.f6846n = (-Math.min(i6, Math.max(-i6, i6 - iMax))) - translationY;
            return;
        }
        this.f6846n = bool.booleanValue() ? -(i2 - r2) : -translationY;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6855b(ViewGroup viewGroup, Boolean bool) {
        int OplusGLSurfaceView_13 = (this.f6835c == 2 ? -1 : 1) * this.f6840h;
        this.f6848p = new WeakReference<>(viewGroup);
        this.f6847o = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6846a(ViewGroup viewGroup) {
        View viewFindFocus;
        if (viewGroup == null || (viewFindFocus = viewGroup.findFocus()) == null) {
            return;
        }
        this.f6841i = 0;
        this.f6843k = false;
        this.f6842j = null;
        if (m6856b(viewFindFocus)) {
            this.f6843k = true;
            this.f6842j = viewFindFocus;
        }
        this.f6841i = m6841a(viewFindFocus) + viewFindFocus.getTop() + COUIViewMarginUtil.m6502a(viewFindFocus, 3);
        for (View view = (View) viewFindFocus.getParent(); view != null && view != viewGroup.getParent(); view = (View) view.getParent()) {
            if (m6856b(view)) {
                this.f6843k = true;
                this.f6842j = view;
            }
            this.f6841i += view.getTop();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6848a(ViewGroup viewGroup, boolean z) {
        float fAbs;
        float fAbs2;
        if (viewGroup == null || this.f6848p == null) {
            return;
        }
        if (viewGroup instanceof COUIPanelConstraintLayout) {
            COUIPanelConstraintLayout c1487l = (COUIPanelConstraintLayout) viewGroup;
            int maxHeight = c1487l.getMaxHeight();
            if (z) {
                fAbs2 = Math.abs((this.f6840h * 120.0f) / maxHeight) + 300.0f;
            } else {
                fAbs2 = Math.abs((this.f6840h * 50.0f) / maxHeight) + 200.0f;
            }
            long OplusGLSurfaceView_15 = (long) fAbs2;
            m6844a(this.f6848p.get(), this.f6845m, OplusGLSurfaceView_15);
            m6850a(c1487l, this.f6846n, OplusGLSurfaceView_15);
            return;
        }
        int iM6442b = COUIPanelMultiWindowUtils.m6442b(viewGroup.getContext());
        if (z) {
            fAbs = Math.abs((this.f6840h * 120.0f) / iM6442b) + 300.0f;
        } else {
            fAbs = Math.abs((this.f6840h * 50.0f) / iM6442b) + 200.0f;
        }
        m6854b(viewGroup, this.f6847o, (long) fAbs);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6844a(final View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_13 == 0 || view == null) {
            return;
        }
        final int paddingLeft = view.getPaddingLeft();
        final int paddingRight = view.getPaddingRight();
        final int paddingTop = view.getPaddingTop();
        int iMax = Math.max(0, view.getPaddingBottom());
        final int iMax2 = Math.max(0, OplusGLSurfaceView_13 + iMax);
        this.f6849q = ValueAnimator.ofInt(iMax, iMax2);
        this.f6849q.setDuration(OplusGLSurfaceView_15);
        if (iMax < iMax2) {
            this.f6849q.setInterpolator(f6833a);
        } else {
            this.f6849q.setInterpolator(f6834b);
        }
        this.f6849q.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, iMax2);
            }
        });
        this.f6849q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.f6849q.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6850a(final COUIPanelConstraintLayout c1487l, float COUIBaseListPopupWindow_12, long OplusGLSurfaceView_15) {
        if (COUIBaseListPopupWindow_12 == 0.0f || c1487l == null || c1487l.getBtnBarLayout() == null) {
            return;
        }
        float translationY = c1487l.getBtnBarLayout().getTranslationY();
        final float fMin = Math.min(0.0f, COUIBaseListPopupWindow_12 + translationY);
        this.f6850r = ValueAnimator.ofFloat(translationY, fMin);
        this.f6850r.setDuration(OplusGLSurfaceView_15);
        if (translationY < fMin) {
            this.f6850r.setInterpolator(f6833a);
        } else {
            this.f6850r.setInterpolator(f6834b);
        }
        this.f6850r.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c1487l.getBtnBarLayout().setTranslationY(fMin);
                c1487l.getDivider().setTranslationY(fMin);
            }
        });
        this.f6850r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c1487l.isAttachedToWindow()) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c1487l.getBtnBarLayout().setTranslationY(fFloatValue);
                    c1487l.getDivider().setTranslationY(fFloatValue);
                }
            }
        });
        this.f6850r.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6854b(final View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_13 == 0 || view == null) {
            return;
        }
        int iMax = Math.max(0, COUIViewMarginUtil.m6502a(view, 3));
        final int iMax2 = Math.max(0, OplusGLSurfaceView_13 + iMax);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iMax, iMax2);
        valueAnimatorOfInt.setDuration(OplusGLSurfaceView_15);
        if (iMax < iMax2) {
            valueAnimatorOfInt.setInterpolator(f6833a);
        } else {
            valueAnimatorOfInt.setInterpolator(f6834b);
        }
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIViewMarginUtil.m6503a(view, iMax2, 3);
            }
        });
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_5.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    COUIViewMarginUtil.m6503a(view, ((Integer) valueAnimator.getAnimatedValue()).intValue(), 3);
                }
            }
        });
        valueAnimatorOfInt.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6843a(View view, int OplusGLSurfaceView_13) {
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6842a(View view, float COUIBaseListPopupWindow_12) {
        if (view != null) {
            view.setTranslationY(view.getTranslationY() + COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6845a(View view, int OplusGLSurfaceView_13, WindowInsets windowInsets) throws Resources.NotFoundException {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.coui_bottom_sheet_margin_bottom_if_need);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height() + windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int measuredHeight = view.getMeasuredHeight() + marginLayoutParams.bottomMargin + OplusGLSurfaceView_13;
            if (measuredHeight > iHeight) {
                OplusGLSurfaceView_13 -= measuredHeight - iHeight;
            }
            if ((view instanceof IgnoreWindowInsetsFrameLayout) && layoutParams.height > 0) {
                marginLayoutParams.bottomMargin = Math.max(dimensionPixelSize, marginLayoutParams.bottomMargin + OplusGLSurfaceView_13);
                view.setLayoutParams(layoutParams);
            } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams.bottomMargin = Math.max(dimensionPixelSize, marginLayoutParams.bottomMargin + OplusGLSurfaceView_13);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6841a(View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m6856b(View view) {
        return (view instanceof ScrollView) || (view instanceof AbsListView) || (view instanceof ScrollingView);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View m6857f() {
        View view = this.f6842j;
        if (view != null) {
            return (View) view.getParent();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6862a(COUIPanelConstraintLayout c1487l) {
        if (this.f6843k) {
            View viewM6857f = m6857f();
            if (viewM6857f != null && this.f6844l >= 0) {
                viewM6857f.setPadding(0, 0, 0, 0);
            }
        } else if (c1487l != null) {
            c1487l.setPadding(0, 0, 0, 0);
        }
        if (c1487l != null) {
            COUIButtonBarLayout btnBarLayout = c1487l.getBtnBarLayout();
            View divider = c1487l.getDivider();
            if (btnBarLayout != null) {
                btnBarLayout.setTranslationY(0.0f);
            }
            if (divider != null) {
                divider.setTranslationY(0.0f);
            }
            c1487l.setPadding(0, 0, 0, 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6858a() {
        this.f6839g = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6863b() {
        ValueAnimator valueAnimator = this.f6849q;
        boolean z = false;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f6849q.cancel();
                z = true;
            }
            this.f6849q = null;
        }
        ValueAnimator valueAnimator2 = this.f6850r;
        if (valueAnimator2 != null) {
            if (valueAnimator2.isRunning()) {
                this.f6850r.cancel();
            }
            this.f6850r = null;
        }
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m6864c() {
        return this.f6845m;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m6865d() {
        return this.f6846n;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m6866e() {
        return this.f6847o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6859a(int OplusGLSurfaceView_13) {
        this.f6851s = OplusGLSurfaceView_13;
    }
}
