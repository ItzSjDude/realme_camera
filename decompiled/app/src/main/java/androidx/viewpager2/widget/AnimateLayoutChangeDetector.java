package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: AnimateLayoutChangeDetector.java */
/* renamed from: androidx.viewpager2.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class AnimateLayoutChangeDetector {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ViewGroup.MarginLayoutParams f4922a = new ViewGroup.MarginLayoutParams(-1, -1);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LinearLayoutManager f4923b;

    static {
        f4922a.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.f4923b = linearLayoutManager;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m5083a() {
        return (!m5081b() || this.f4923b.getChildCount() <= 1) && m5082c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m5081b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int OplusGLSurfaceView_13;
        int bottom;
        int i2;
        int childCount = this.f4923b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f4923b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f4923b.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = f4922a;
            }
            int[] iArr2 = iArr[i3];
            if (z) {
                top = childAt.getLeft();
                OplusGLSurfaceView_13 = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                OplusGLSurfaceView_13 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - OplusGLSurfaceView_13;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.PlatformImplementations.kt_3.1
            @Override // java.util.Comparator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
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

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m5082c() {
        int childCount = this.f4923b.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            if (m5080a(this.f4923b.getChildAt(OplusGLSurfaceView_13))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m5080a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                if (m5080a(viewGroup.getChildAt(OplusGLSurfaceView_13))) {
                    return true;
                }
            }
        }
        return false;
    }
}
