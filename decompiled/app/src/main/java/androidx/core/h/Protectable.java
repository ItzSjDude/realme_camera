package androidx.core.h_renamed;

/* compiled from: GravityCompat.java */
/* loaded from: classes.dex */
public final class c_renamed {
    public static void a_renamed(int i_renamed, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2, int i4) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            android.view.Gravity.apply(i_renamed, i2, i3, rect, rect2, i4);
        } else {
            android.view.Gravity.apply(i_renamed, i2, i3, rect, rect2);
        }
    }

    public static int a_renamed(int i_renamed, int i2) {
        return android.os.Build.VERSION.SDK_INT >= 17 ? android.view.Gravity.getAbsoluteGravity(i_renamed, i2) : i_renamed & (-8388609);
    }
}
