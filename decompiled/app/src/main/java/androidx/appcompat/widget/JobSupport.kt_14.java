package androidx.appcompat.widget;

/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public class at_renamed {
    public static void a_renamed(android.view.View view, java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            androidx.appcompat.widget.au_renamed.a_renamed(view, charSequence);
        }
    }
}
