package androidx.core.h_renamed;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.ViewParent f983a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.ViewParent f984b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.view.View f985c;
    private boolean d_renamed;
    private int[] e_renamed;

    public l_renamed(android.view.View view) {
        this.f985c = view;
    }

    public void a_renamed(boolean z_renamed) {
        if (this.d_renamed) {
            androidx.core.h_renamed.v_renamed.z_renamed(this.f985c);
        }
        this.d_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.d_renamed;
    }

    public boolean b_renamed() {
        return a_renamed(0);
    }

    public boolean a_renamed(int i_renamed) {
        return d_renamed(i_renamed) != null;
    }

    public boolean b_renamed(int i_renamed) {
        return a_renamed(i_renamed, 0);
    }

    public boolean a_renamed(int i_renamed, int i2) {
        if (a_renamed(i2)) {
            return true;
        }
        if (!a_renamed()) {
            return false;
        }
        android.view.View view = this.f985c;
        for (android.view.ViewParent parent = this.f985c.getParent(); parent != null; parent = parent.getParent()) {
            if (androidx.core.h_renamed.y_renamed.a_renamed(parent, view, this.f985c, i_renamed, i2)) {
                a_renamed(i2, parent);
                androidx.core.h_renamed.y_renamed.b_renamed(parent, view, this.f985c, i_renamed, i2);
                return true;
            }
            if (parent instanceof android.view.View) {
                view = (android.view.View) parent;
            }
        }
        return false;
    }

    public void c_renamed() {
        c_renamed(0);
    }

    public void c_renamed(int i_renamed) {
        android.view.ViewParent viewParentD = d_renamed(i_renamed);
        if (viewParentD != null) {
            androidx.core.h_renamed.y_renamed.a_renamed(viewParentD, this.f985c, i_renamed);
            a_renamed(i_renamed, (android.view.ViewParent) null);
        }
    }

    public boolean a_renamed(int i_renamed, int i2, int i3, int i4, int[] iArr) {
        return b_renamed(i_renamed, i2, i3, i4, iArr, 0, null);
    }

    public boolean a_renamed(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5) {
        return b_renamed(i_renamed, i2, i3, i4, iArr, i5, null);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        b_renamed(i_renamed, i2, i3, i4, iArr, i5, iArr2);
    }

    private boolean b_renamed(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        android.view.ViewParent viewParentD;
        int i6;
        int i7;
        int[] iArr3;
        if (!a_renamed() || (viewParentD = d_renamed(i5)) == null) {
            return false;
        }
        if (i_renamed == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f985c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrD = d_renamed();
            iArrD[0] = 0;
            iArrD[1] = 0;
            iArr3 = iArrD;
        } else {
            iArr3 = iArr2;
        }
        androidx.core.h_renamed.y_renamed.a_renamed(viewParentD, this.f985c, i_renamed, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f985c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean a_renamed(int i_renamed, int i2, int[] iArr, int[] iArr2) {
        return a_renamed(i_renamed, i2, iArr, iArr2, 0);
    }

    public boolean a_renamed(int i_renamed, int i2, int[] iArr, int[] iArr2, int i3) {
        android.view.ViewParent viewParentD;
        int i4;
        int i5;
        if (!a_renamed() || (viewParentD = d_renamed(i3)) == null) {
            return false;
        }
        if (i_renamed == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f985c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = d_renamed();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        androidx.core.h_renamed.y_renamed.a_renamed(viewParentD, this.f985c, i_renamed, i2, iArr, i3);
        if (iArr2 != null) {
            this.f985c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a_renamed(float f_renamed, float f2, boolean z_renamed) {
        android.view.ViewParent viewParentD;
        if (!a_renamed() || (viewParentD = d_renamed(0)) == null) {
            return false;
        }
        return androidx.core.h_renamed.y_renamed.a_renamed(viewParentD, this.f985c, f_renamed, f2, z_renamed);
    }

    public boolean a_renamed(float f_renamed, float f2) {
        android.view.ViewParent viewParentD;
        if (!a_renamed() || (viewParentD = d_renamed(0)) == null) {
            return false;
        }
        return androidx.core.h_renamed.y_renamed.a_renamed(viewParentD, this.f985c, f_renamed, f2);
    }

    private android.view.ViewParent d_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.f983a;
        }
        if (i_renamed != 1) {
            return null;
        }
        return this.f984b;
    }

    private void a_renamed(int i_renamed, android.view.ViewParent viewParent) {
        if (i_renamed == 0) {
            this.f983a = viewParent;
        } else {
            if (i_renamed != 1) {
                return;
            }
            this.f984b = viewParent;
        }
    }

    private int[] d_renamed() {
        if (this.e_renamed == null) {
            this.e_renamed = new int[2];
        }
        return this.e_renamed;
    }
}
