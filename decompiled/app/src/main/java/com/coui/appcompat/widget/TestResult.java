package com.coui.appcompat.widget;

/* compiled from: COUIIOverScroller.java */
/* loaded from: classes.dex */
public interface h_renamed {
    void a_renamed(android.view.animation.Interpolator interpolator);

    boolean a_renamed();

    void abortAnimation();

    int b_renamed();

    int c_renamed();

    boolean computeScrollOffset();

    int d_renamed();

    int e_renamed();

    float f_renamed();

    void fling(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    float g_renamed();

    void notifyHorizontalEdgeReached(int i_renamed, int i2, int i3);

    void notifyVerticalEdgeReached(int i_renamed, int i2, int i3);

    void setFinalX(int i_renamed);

    void startScroll(int i_renamed, int i2, int i3, int i4, int i5);
}
