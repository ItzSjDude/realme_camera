package androidx.core.p035g;

/* compiled from: DebugUtils.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class DebugUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2527a(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
