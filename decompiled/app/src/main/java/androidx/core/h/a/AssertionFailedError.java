package androidx.core.h_renamed.a_renamed;

/* compiled from: AccessibilityEventCompat.java */
/* loaded from: classes.dex */
public final class b_renamed {
    public static void a_renamed(android.view.accessibility.AccessibilityEvent accessibilityEvent, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i_renamed);
        }
    }

    public static int a_renamed(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
