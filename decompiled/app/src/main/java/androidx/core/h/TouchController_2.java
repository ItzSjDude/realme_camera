package androidx.core.h_renamed;

/* compiled from: NestedScrollingParent.java */
/* loaded from: classes.dex */
public interface m_renamed {
    boolean onNestedFling(android.view.View view, float f_renamed, float f2, boolean z_renamed);

    boolean onNestedPreFling(android.view.View view, float f_renamed, float f2);

    void onNestedPreScroll(android.view.View view, int i_renamed, int i2, int[] iArr);

    void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4);

    void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i_renamed);

    boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i_renamed);

    void onStopNestedScroll(android.view.View view);
}
