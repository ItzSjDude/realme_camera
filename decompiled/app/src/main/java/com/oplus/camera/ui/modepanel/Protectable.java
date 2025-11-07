package com.oplus.camera.ui.modepanel;

/* compiled from: DragHelperUtils.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static int f6715a = 15;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected static int f6716b = 10;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected static float f6717c = 100.0f;
    protected static float d_renamed = 200.0f;

    public static float a_renamed() {
        return 1.0f;
    }

    public static int a_renamed(float f_renamed, int i_renamed) {
        if (f_renamed > 1.0f) {
            f_renamed = 1.0f;
        }
        return (int) (f_renamed * i_renamed);
    }

    public static boolean a_renamed(com.oplus.camera.ui.modepanel.k_renamed kVar) {
        if (kVar != null) {
            return kVar.h_renamed();
        }
        return true;
    }

    public static boolean b_renamed(com.oplus.camera.ui.modepanel.k_renamed kVar) {
        if (kVar != null) {
            return kVar.f_renamed();
        }
        return true;
    }

    public static int a_renamed(android.view.View view, int i_renamed, int i2) {
        int iA = a_renamed(i2, view.getHeight());
        if (iA < 0) {
            return -a_renamed((c_renamed() - i2) / c_renamed(), d_renamed());
        }
        if (iA > 0) {
            return a_renamed(((i2 - view.getHeight()) + c_renamed()) / c_renamed(), d_renamed());
        }
        return 0;
    }

    public static int a_renamed(int i_renamed, int i2) {
        float f_renamed = i_renamed;
        if (f_renamed < c_renamed()) {
            return -1;
        }
        return f_renamed > ((float) i2) - c_renamed() ? 1 : 0;
    }

    public static float b_renamed() {
        return f6717c / a_renamed();
    }

    public static float c_renamed() {
        return d_renamed / a_renamed();
    }

    public static int d_renamed() {
        return (int) (f6716b / a_renamed());
    }

    public static int e_renamed() {
        return (int) (f6715a / a_renamed());
    }

    public static int b_renamed(android.view.View view, int i_renamed, int i2) {
        int iB = b_renamed(i_renamed, view.getWidth());
        if (iB < 0) {
            return -a_renamed((b_renamed() - i_renamed) / b_renamed(), e_renamed());
        }
        if (iB > 0) {
            return a_renamed(((i_renamed - view.getWidth()) + b_renamed()) / b_renamed(), e_renamed());
        }
        return 0;
    }

    protected static int b_renamed(int i_renamed, int i2) {
        float f_renamed = i_renamed;
        if (f_renamed < b_renamed()) {
            return -1;
        }
        return f_renamed > ((float) i2) - b_renamed() ? 1 : 0;
    }

    public static android.graphics.Rect c_renamed(android.view.View view, int i_renamed, int i2) {
        int height;
        int height2;
        int i3;
        int i4;
        int[] iArr = new int[2];
        if (view == null) {
            return new android.graphics.Rect(0, 0, 0, 0);
        }
        view.getLocationOnScreen(iArr);
        if (4 != i_renamed) {
            height = iArr[0];
            int i5 = iArr[1];
            int width = (int) (iArr[0] + (view.getWidth() * view.getScaleX()));
            height2 = (int) (iArr[1] + (view.getHeight() * view.getScaleY()));
            i3 = i5;
            i4 = width;
        } else if (i2 == 90) {
            i4 = iArr[0];
            height = iArr[0] - ((int) (view.getHeight() * view.getScaleY()));
            i3 = iArr[1];
            height2 = (int) (i3 + (view.getWidth() * view.getScaleX()));
        } else {
            i4 = com.oplus.camera.screen.f_renamed.f5371a - iArr[0];
            height = i4 - ((int) (view.getHeight() * view.getScaleY()));
            i3 = com.oplus.camera.screen.f_renamed.f5372b - iArr[1];
            height2 = ((int) (view.getWidth() * view.getScaleX())) + i3;
        }
        return new android.graphics.Rect(height, i3, i4, height2);
    }
}
