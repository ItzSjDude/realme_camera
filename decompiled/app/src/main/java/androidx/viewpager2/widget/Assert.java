package androidx.viewpager2.widget;

/* compiled from: AnimateLayoutChangeDetector.java */
/* loaded from: classes.dex */
final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.ViewGroup.MarginLayoutParams f1849a = new android.view.ViewGroup.MarginLayoutParams(-1, -1);

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.LinearLayoutManager f1850b;

    static {
        f1849a.setMargins(0, 0, 0, 0);
    }

    a_renamed(androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        this.f1850b = linearLayoutManager;
    }

    boolean a_renamed() {
        return (!b_renamed() || this.f1850b.getChildCount() <= 1) && c_renamed();
    }

    private boolean b_renamed() {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i_renamed;
        int bottom;
        int i2;
        int childCount = this.f1850b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z_renamed = this.f1850b.getOrientation() == 0;
        int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) int.class, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = this.f1850b.getChildAt(i3);
            if (childAt == null) {
                throw new java.lang.IllegalStateException("null view contained in_renamed the view hierarchy");
            }
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = f1849a;
            }
            int[] iArr2 = iArr[i3];
            if (z_renamed) {
                top = childAt.getLeft();
                i_renamed = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i_renamed = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i_renamed;
            int[] iArr3 = iArr[i3];
            if (z_renamed) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        java.util.Arrays.sort(iArr, new java.util.Comparator<int[]>() { // from class: androidx.viewpager2.widget.a_renamed.1
            @Override // java.util.Comparator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean c_renamed() {
        int childCount = this.f1850b.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            if (a_renamed(this.f1850b.getChildAt(i_renamed))) {
                return true;
            }
        }
        return false;
    }

    private static boolean a_renamed(android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            android.animation.LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                if (a_renamed(viewGroup.getChildAt(i_renamed))) {
                    return true;
                }
            }
        }
        return false;
    }
}
