package androidx.core.h_renamed.a_renamed;

/* compiled from: AccessibilityRecordCompat.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.accessibility.AccessibilityRecord f970a;

    public static void a_renamed(android.view.accessibility.AccessibilityRecord accessibilityRecord, android.view.View view, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i_renamed);
        }
    }

    public static void a_renamed(android.view.accessibility.AccessibilityRecord accessibilityRecord, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i_renamed);
        }
    }

    public static void b_renamed(android.view.accessibility.AccessibilityRecord accessibilityRecord, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i_renamed);
        }
    }

    @java.lang.Deprecated
    public int hashCode() {
        android.view.accessibility.AccessibilityRecord accessibilityRecord = this.f970a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @java.lang.Deprecated
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof androidx.core.h_renamed.a_renamed.f_renamed)) {
            return false;
        }
        androidx.core.h_renamed.a_renamed.f_renamed fVar = (androidx.core.h_renamed.a_renamed.f_renamed) obj;
        android.view.accessibility.AccessibilityRecord accessibilityRecord = this.f970a;
        if (accessibilityRecord == null) {
            if (fVar.f970a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(fVar.f970a)) {
            return false;
        }
        return true;
    }
}
