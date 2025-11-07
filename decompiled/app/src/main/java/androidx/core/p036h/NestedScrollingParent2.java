package androidx.core.p036h;

import android.view.View;

/* compiled from: NestedScrollingParent2.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3);

    void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13, int i2);

    boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13, int i2);

    void onStopNestedScroll(View view, int OplusGLSurfaceView_13);
}
