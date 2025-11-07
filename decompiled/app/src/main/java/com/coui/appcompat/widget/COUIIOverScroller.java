package com.coui.appcompat.widget;

import android.view.animation.Interpolator;

/* compiled from: COUIIOverScroller.java */
/* renamed from: com.coui.appcompat.widget.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public interface COUIIOverScroller {
    /* renamed from: PlatformImplementations.kt_3 */
    void mo7782a(Interpolator interpolator);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo7783a();

    void abortAnimation();

    /* renamed from: IntrinsicsJvm.kt_4 */
    int mo7784b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    int mo7785c();

    boolean computeScrollOffset();

    /* renamed from: IntrinsicsJvm.kt_5 */
    int mo7786d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    int mo7787e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    float mo7788f();

    void fling(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    /* renamed from: COUIBaseListPopupWindow_11 */
    float mo7789g();

    void notifyHorizontalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3);

    void notifyVerticalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3);

    void setFinalX(int OplusGLSurfaceView_13);

    void startScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5);
}
