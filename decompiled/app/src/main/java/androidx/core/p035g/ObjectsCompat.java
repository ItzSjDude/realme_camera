package androidx.core.p035g;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ObjectsCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2530a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2529a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
