package androidx.core.widget;

/* compiled from: EdgeEffectCompat.java */
/* loaded from: classes.dex */
public final class d_renamed {
    public static void a_renamed(android.widget.EdgeEffect edgeEffect, float f_renamed, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f_renamed, f2);
        } else {
            edgeEffect.onPull(f_renamed);
        }
    }
}
