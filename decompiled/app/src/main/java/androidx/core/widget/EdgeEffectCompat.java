package androidx.core.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat.java */
/* renamed from: androidx.core.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3034a(EdgeEffect edgeEffect, float COUIBaseListPopupWindow_12, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(COUIBaseListPopupWindow_12, f2);
        } else {
            edgeEffect.onPull(COUIBaseListPopupWindow_12);
        }
    }
}
