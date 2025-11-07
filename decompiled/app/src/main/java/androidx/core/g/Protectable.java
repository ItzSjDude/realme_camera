package androidx.core.g_renamed;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c_renamed {
    public static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return java.util.Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a_renamed(java.lang.Object... objArr) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return java.util.Objects.hash(objArr);
        }
        return java.util.Arrays.hashCode(objArr);
    }
}
