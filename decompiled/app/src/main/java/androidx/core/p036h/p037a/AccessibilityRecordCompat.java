package androidx.core.p036h.p037a;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AccessibilityRecord f3049a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2755a(AccessibilityRecord accessibilityRecord, View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2754a(AccessibilityRecord accessibilityRecord, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2756b(AccessibilityRecord accessibilityRecord, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(OplusGLSurfaceView_13);
        }
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f3049a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat c0485f = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f3049a;
        if (accessibilityRecord == null) {
            if (c0485f.f3049a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(c0485f.f3049a)) {
            return false;
        }
        return true;
    }
}
