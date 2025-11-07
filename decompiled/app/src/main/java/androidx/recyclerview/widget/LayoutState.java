package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* renamed from: androidx.recyclerview.widget.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class LayoutState {

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f4283b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f4284c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f4285d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f4286e;

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean f4289h;

    /* renamed from: OplusGLSurfaceView_13 */
    boolean f4290i;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f4282a = true;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f4287f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f4288g = 0;

    LayoutState() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4479a(RecyclerView.C0704t c0704t) {
        int OplusGLSurfaceView_13 = this.f4284c;
        return OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < c0704t.m4230e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    View m4478a(RecyclerView.C0700p c0700p) {
        View viewM4201c = c0700p.m4201c(this.f4284c);
        this.f4284c += this.f4285d;
        return viewM4201c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4283b + ", mCurrentPosition=" + this.f4284c + ", mItemDirection=" + this.f4285d + ", mLayoutDirection=" + this.f4286e + ", mStartLine=" + this.f4287f + ", mEndLine=" + this.f4288g + '}';
    }
}
