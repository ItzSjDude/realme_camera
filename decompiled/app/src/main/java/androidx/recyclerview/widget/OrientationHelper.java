package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* renamed from: androidx.recyclerview.widget.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public abstract class OrientationHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final RecyclerView.AbstractC0693i f4294a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Rect f4295b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f4296c;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo4498a(View view);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo4500a(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract int mo4501b(View view);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract int mo4504c(View view);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract int mo4505d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract int mo4506d(View view);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract int mo4507e();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract int mo4508e(View view);

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract int mo4509f();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract int mo4510f(View view);

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract int mo4511g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    public abstract int mo4512h();

    /* renamed from: OplusGLSurfaceView_13 */
    public abstract int mo4513i();

    /* renamed from: OplusGLSurfaceView_15 */
    public abstract int mo4514j();

    private OrientationHelper(RecyclerView.AbstractC0693i abstractC0693i) {
        this.f4296c = Integer.MIN_VALUE;
        this.f4295b = new Rect();
        this.f4294a = abstractC0693i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public RecyclerView.AbstractC0693i m4499a() {
        return this.f4294a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4502b() {
        this.f4296c = mo4511g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m4503c() {
        if (Integer.MIN_VALUE == this.f4296c) {
            return 0;
        }
        return mo4511g() - this.f4296c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static OrientationHelper m4496a(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return m4495a(abstractC0693i);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return m4497b(abstractC0693i);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static OrientationHelper m4495a(RecyclerView.AbstractC0693i abstractC0693i) {
        return new OrientationHelper(abstractC0693i) { // from class: androidx.recyclerview.widget.OplusGLSurfaceView_11.1
            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_8 */
            public int mo4507e() {
                return this.f4294a.getWidth() - this.f4294a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_12 */
            public int mo4509f() {
                return this.f4294a.getWidth();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4500a(int OplusGLSurfaceView_13) {
                this.f4294a.offsetChildrenHorizontal(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo4505d() {
                return this.f4294a.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_8 */
            public int mo4508e(View view) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                return this.f4294a.getDecoratedMeasuredWidth(view) + c0694j.leftMargin + c0694j.rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_12 */
            public int mo4510f(View view) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                return this.f4294a.getDecoratedMeasuredHeight(view) + c0694j.topMargin + c0694j.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4501b(View view) {
                return this.f4294a.getDecoratedRight(view) + ((RecyclerView.C0694j) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4498a(View view) {
                return this.f4294a.getDecoratedLeft(view) - ((RecyclerView.C0694j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_3 */
            public int mo4504c(View view) {
                this.f4294a.getTransformedBoundingBox(view, true, this.f4295b);
                return this.f4295b.right;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo4506d(View view) {
                this.f4294a.getTransformedBoundingBox(view, true, this.f4295b);
                return this.f4295b.left;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_11 */
            public int mo4511g() {
                return (this.f4294a.getWidth() - this.f4294a.getPaddingLeft()) - this.f4294a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_10 */
            public int mo4512h() {
                return this.f4294a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: OplusGLSurfaceView_13 */
            public int mo4513i() {
                return this.f4294a.getWidthMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: OplusGLSurfaceView_15 */
            public int mo4514j() {
                return this.f4294a.getHeightMode();
            }
        };
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static OrientationHelper m4497b(RecyclerView.AbstractC0693i abstractC0693i) {
        return new OrientationHelper(abstractC0693i) { // from class: androidx.recyclerview.widget.OplusGLSurfaceView_11.2
            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_8 */
            public int mo4507e() {
                return this.f4294a.getHeight() - this.f4294a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_12 */
            public int mo4509f() {
                return this.f4294a.getHeight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4500a(int OplusGLSurfaceView_13) {
                this.f4294a.offsetChildrenVertical(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo4505d() {
                return this.f4294a.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_8 */
            public int mo4508e(View view) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                return this.f4294a.getDecoratedMeasuredHeight(view) + c0694j.topMargin + c0694j.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_12 */
            public int mo4510f(View view) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                return this.f4294a.getDecoratedMeasuredWidth(view) + c0694j.leftMargin + c0694j.rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4501b(View view) {
                return this.f4294a.getDecoratedBottom(view) + ((RecyclerView.C0694j) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4498a(View view) {
                return this.f4294a.getDecoratedTop(view) - ((RecyclerView.C0694j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_3 */
            public int mo4504c(View view) {
                this.f4294a.getTransformedBoundingBox(view, true, this.f4295b);
                return this.f4295b.bottom;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo4506d(View view) {
                this.f4294a.getTransformedBoundingBox(view, true, this.f4295b);
                return this.f4295b.top;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_11 */
            public int mo4511g() {
                return (this.f4294a.getHeight() - this.f4294a.getPaddingTop()) - this.f4294a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: COUIBaseListPopupWindow_10 */
            public int mo4512h() {
                return this.f4294a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: OplusGLSurfaceView_13 */
            public int mo4513i() {
                return this.f4294a.getHeightMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            /* renamed from: OplusGLSurfaceView_15 */
            public int mo4514j() {
                return this.f4294a.getWidthMode();
            }
        };
    }
}
