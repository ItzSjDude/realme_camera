package androidx.core.p036h;

import android.view.View;

/* compiled from: NestedScrollingParent.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public interface NestedScrollingParent {
    boolean onNestedFling(View view, float COUIBaseListPopupWindow_12, float f2, boolean z);

    boolean onNestedPreFling(View view, float COUIBaseListPopupWindow_12, float f2);

    void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr);

    void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4);

    void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13);

    boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13);

    void onStopNestedScroll(View view);
}
