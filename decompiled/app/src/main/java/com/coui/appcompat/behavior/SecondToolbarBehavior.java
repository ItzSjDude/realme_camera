package com.coui.appcompat.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.AbstractC0408b<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f6373a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f6374b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f6375c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private View f6376d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f6377e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6378f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6379g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f6380h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6381i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ViewGroup.LayoutParams f6382j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f6383k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f6384l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f6385m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f6386n;

    /* renamed from: o */
    private int f6387o;

    /* renamed from: p */
    private int f6388p;

    /* renamed from: q */
    private int f6389q;

    /* renamed from: r */
    private float f6390r;

    /* renamed from: s */
    private float f6391s;

    /* renamed from: t */
    private Resources f6392t;

    /* renamed from: u */
    private boolean f6393u;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int OplusGLSurfaceView_13) {
    }

    public SecondToolbarBehavior() {
        this.f6380h = new int[2];
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6380h = new int[2];
        m6508a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6508a(Context context) {
        this.f6392t = context.getResources();
        this.f6383k = this.f6392t.getDimensionPixelOffset(R.dimen.preference_divider_margin_horizontal) * 2;
        this.f6386n = this.f6392t.getDimensionPixelOffset(R.dimen.preference_line_alpha_range_change_offset);
        this.f6389q = this.f6392t.getDimensionPixelOffset(R.dimen.preference_divider_width_change_offset);
        this.f6393u = this.f6392t.getBoolean(R.bool.is_dialog_preference_immersive);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        boolean z = (OplusGLSurfaceView_13 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (!this.f6393u && z) {
            if (this.f6384l <= 0) {
                this.f6384l = appBarLayout.getMeasuredHeight();
                this.f6375c = view2;
                this.f6374b = appBarLayout.findViewById(R.id_renamed.divider_line);
                this.f6373a = this.f6374b.getWidth();
                this.f6382j = this.f6374b.getLayoutParams();
                this.f6381i = appBarLayout.getMeasuredWidth();
                int i3 = this.f6384l;
                this.f6385m = i3 - this.f6386n;
                this.f6388p = i3 - this.f6392t.getDimensionPixelOffset(R.dimen.preference_divider_width_start_count_offset);
                this.f6387o = this.f6388p - this.f6389q;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.SecondToolbarBehavior.1
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View view3, int i4, int i5, int i6, int i7) {
                        SecondToolbarBehavior.this.m6507a();
                    }
                });
            } else if (view2 instanceof AbsListView) {
                ((AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int OplusGLSurfaceView_13, int i2, int i3) {
        m6507a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6507a() {
        this.f6376d = null;
        View view = this.f6375c;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(OplusGLSurfaceView_13).getVisibility() == 0) {
                        this.f6376d = viewGroup.getChildAt(OplusGLSurfaceView_13);
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
            }
        }
        if (this.f6376d == null) {
            this.f6376d = this.f6375c;
        }
        this.f6376d.getLocationOnScreen(this.f6380h);
        this.f6377e = this.f6380h[1];
        this.f6378f = 0;
        int i2 = this.f6377e;
        if (i2 < this.f6385m) {
            this.f6378f = this.f6386n;
        } else {
            int i3 = this.f6384l;
            if (i2 > i3) {
                this.f6378f = 0;
            } else {
                this.f6378f = i3 - i2;
            }
        }
        this.f6379g = this.f6378f;
        if (this.f6390r <= 1.0f) {
            this.f6390r = Math.abs(this.f6379g) / this.f6386n;
            this.f6374b.setAlpha(this.f6390r);
        }
        int i4 = this.f6377e;
        if (i4 < this.f6387o) {
            this.f6378f = this.f6389q;
        } else {
            int i5 = this.f6388p;
            if (i4 > i5) {
                this.f6378f = 0;
            } else {
                this.f6378f = i5 - i4;
            }
        }
        this.f6379g = this.f6378f;
        this.f6391s = Math.abs(this.f6379g) / this.f6389q;
        ViewGroup.LayoutParams layoutParams = this.f6382j;
        layoutParams.width = (int) (this.f6373a + (this.f6383k * this.f6391s));
        this.f6374b.setLayoutParams(layoutParams);
    }
}
