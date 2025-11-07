package androidx.core.p036h;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewParent f3063a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ViewParent f3064b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final View f3065c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f3066d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int[] f3067e;

    public NestedScrollingChildHelper(View view) {
        this.f3065c = view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2801a(boolean z) {
        if (this.f3066d) {
            ViewCompat.m2907z(this.f3065c);
        }
        this.f3066d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2802a() {
        return this.f3066d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2811b() {
        return m2805a(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2805a(int OplusGLSurfaceView_13) {
        return m2798d(OplusGLSurfaceView_13) != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2812b(int OplusGLSurfaceView_13) {
        return m2806a(OplusGLSurfaceView_13, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2806a(int OplusGLSurfaceView_13, int i2) {
        if (m2805a(i2)) {
            return true;
        }
        if (!m2802a()) {
            return false;
        }
        View view = this.f3065c;
        for (ViewParent parent = this.f3065c.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.m2941a(parent, view, this.f3065c, OplusGLSurfaceView_13, i2)) {
                m2796a(i2, parent);
                ViewParentCompat.m2943b(parent, view, this.f3065c, OplusGLSurfaceView_13, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2813c() {
        m2814c(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2814c(int OplusGLSurfaceView_13) {
        ViewParent viewParentM2798d = m2798d(OplusGLSurfaceView_13);
        if (viewParentM2798d != null) {
            ViewParentCompat.m2936a(viewParentM2798d, this.f3065c, OplusGLSurfaceView_13);
            m2796a(OplusGLSurfaceView_13, (ViewParent) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2807a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        return m2797b(OplusGLSurfaceView_13, i2, i3, i4, iArr, 0, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2808a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5) {
        return m2797b(OplusGLSurfaceView_13, i2, i3, i4, iArr, i5, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2800a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m2797b(OplusGLSurfaceView_13, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m2797b(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentM2798d;
        int i6;
        int i7;
        int[] iArr3;
        if (!m2802a() || (viewParentM2798d = m2798d(i5)) == null) {
            return false;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f3065c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrM2799d = m2799d();
            iArrM2799d[0] = 0;
            iArrM2799d[1] = 0;
            iArr3 = iArrM2799d;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.m2937a(viewParentM2798d, this.f3065c, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f3065c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2809a(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2) {
        return m2810a(OplusGLSurfaceView_13, i2, iArr, iArr2, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2810a(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentM2798d;
        int i4;
        int i5;
        if (!m2802a() || (viewParentM2798d = m2798d(i3)) == null) {
            return false;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f3065c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = m2799d();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.m2938a(viewParentM2798d, this.f3065c, OplusGLSurfaceView_13, i2, iArr, i3);
        if (iArr2 != null) {
            this.f3065c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2804a(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        ViewParent viewParentM2798d;
        if (!m2802a() || (viewParentM2798d = m2798d(0)) == null) {
            return false;
        }
        return ViewParentCompat.m2940a(viewParentM2798d, this.f3065c, COUIBaseListPopupWindow_12, f2, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2803a(float COUIBaseListPopupWindow_12, float f2) {
        ViewParent viewParentM2798d;
        if (!m2802a() || (viewParentM2798d = m2798d(0)) == null) {
            return false;
        }
        return ViewParentCompat.m2939a(viewParentM2798d, this.f3065c, COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ViewParent m2798d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f3063a;
        }
        if (OplusGLSurfaceView_13 != 1) {
            return null;
        }
        return this.f3064b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2796a(int OplusGLSurfaceView_13, ViewParent viewParent) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f3063a = viewParent;
        } else {
            if (OplusGLSurfaceView_13 != 1) {
                return;
            }
            this.f3064b = viewParent;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int[] m2799d() {
        if (this.f3067e == null) {
            this.f3067e = new int[2];
        }
        return this.f3067e;
    }
}
