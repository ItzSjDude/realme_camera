package com.coui.appcompat.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class StatementBehavior extends CoordinatorLayout.AbstractC0408b {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f6395a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f6396b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f6397c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private View f6398d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f6399e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6400f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6401g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f6402h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ViewGroup.LayoutParams f6403i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f6404j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f6405k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f6406l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f6407m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f6408n;

    /* renamed from: o */
    private int f6409o;

    /* renamed from: p */
    private int f6410p;

    /* renamed from: q */
    private float f6411q;

    /* renamed from: r */
    private float f6412r;

    /* renamed from: s */
    private Resources f6413s;

    public StatementBehavior() {
        this.f6402h = new int[2];
    }

    public StatementBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6402h = new int[2];
        m6512a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6512a(Context context) {
        this.f6413s = context.getResources();
        this.f6404j = this.f6413s.getDimensionPixelOffset(R.dimen.preference_divider_margin_horizontal) * 2;
        this.f6407m = this.f6413s.getDimensionPixelOffset(R.dimen.preference_line_alpha_range_change_offset);
        this.f6410p = this.f6413s.getDimensionPixelOffset(R.dimen.preference_divider_width_change_offset);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int OplusGLSurfaceView_13, int i2) {
        if (this.f6405k <= 0) {
            view.getLocationOnScreen(this.f6402h);
            this.f6405k = this.f6402h[1];
            this.f6397c = view3;
            this.f6396b = view.findViewById(R.id_renamed.divider_line);
            this.f6395a = this.f6396b.getWidth();
            this.f6403i = this.f6396b.getLayoutParams();
            int i3 = this.f6405k;
            this.f6406l = i3 - this.f6407m;
            this.f6409o = i3 - this.f6413s.getDimensionPixelOffset(R.dimen.preference_divider_width_start_count_offset);
            this.f6408n = this.f6409o - this.f6410p;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        view3.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.StatementBehavior.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view4, int i4, int i5, int i6, int i7) {
                StatementBehavior.this.m6511a();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6511a() {
        this.f6398d = null;
        View view = this.f6397c;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(OplusGLSurfaceView_13).getVisibility() == 0) {
                        this.f6398d = viewGroup.getChildAt(OplusGLSurfaceView_13);
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
            }
        }
        if (this.f6398d == null) {
            this.f6398d = this.f6397c;
        }
        this.f6398d.getLocationOnScreen(this.f6402h);
        this.f6399e = this.f6402h[1];
        this.f6400f = 0;
        int i2 = this.f6399e;
        if (i2 < this.f6406l) {
            this.f6400f = this.f6407m;
        } else {
            int i3 = this.f6405k;
            if (i2 > i3) {
                this.f6400f = 0;
            } else {
                this.f6400f = i3 - i2;
            }
        }
        this.f6401g = this.f6400f;
        if (this.f6411q <= 1.0f) {
            this.f6411q = Math.abs(this.f6401g) / this.f6407m;
            this.f6396b.setAlpha(this.f6411q);
        }
        int i4 = this.f6399e;
        if (i4 < this.f6408n) {
            this.f6400f = this.f6410p;
        } else {
            int i5 = this.f6409o;
            if (i4 > i5) {
                this.f6400f = 0;
            } else {
                this.f6400f = i5 - i4;
            }
        }
        this.f6401g = this.f6400f;
        this.f6412r = Math.abs(this.f6401g) / this.f6410p;
        ViewGroup.LayoutParams layoutParams = this.f6403i;
        layoutParams.width = (int) (this.f6395a - (this.f6404j * (1.0f - this.f6412r)));
        this.f6396b.setLayoutParams(layoutParams);
    }
}
