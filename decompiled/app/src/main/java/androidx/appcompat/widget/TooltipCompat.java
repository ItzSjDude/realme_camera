package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* compiled from: TooltipCompat.java */
/* renamed from: androidx.appcompat.widget.at */
/* loaded from: classes.dex */
public class TooltipCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1605a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            TooltipCompatHandler.m1606a(view, charSequence);
        }
    }
}
