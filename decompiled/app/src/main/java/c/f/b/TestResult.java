package c_renamed.f_renamed.b_renamed;

/* compiled from: Intrinsics.java */
/* loaded from: classes.dex */
public class h_renamed {
    public static int a_renamed(int i_renamed, int i2) {
        if (i_renamed < i2) {
            return -1;
        }
        return i_renamed == i2 ? 0 : 1;
    }

    private h_renamed() {
    }

    public static void a_renamed(java.lang.Object obj) {
        if (obj == null) {
            b_renamed();
        }
    }

    public static void a_renamed() {
        throw ((c_renamed.f_renamed) a_renamed(new c_renamed.f_renamed()));
    }

    public static void b_renamed() {
        throw ((java.lang.NullPointerException) a_renamed(new java.lang.NullPointerException()));
    }

    public static void a_renamed(java.lang.String str) {
        throw ((c_renamed.r_renamed) a_renamed(new c_renamed.r_renamed(str)));
    }

    public static void b_renamed(java.lang.String str) {
        a_renamed("lateinit property " + str + " has not been initialized");
    }

    public static void a_renamed(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.IllegalStateException) a_renamed(new java.lang.IllegalStateException(str + " must not be_renamed null")));
    }

    public static void b_renamed(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            return;
        }
        throw ((java.lang.NullPointerException) a_renamed(new java.lang.NullPointerException(str + " must not be_renamed null")));
    }

    public static void c_renamed(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            c_renamed(str);
        }
    }

    public static void d_renamed(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            d_renamed(str);
        }
    }

    private static void c_renamed(java.lang.String str) {
        throw ((java.lang.IllegalArgumentException) a_renamed(new java.lang.IllegalArgumentException(e_renamed(str))));
    }

    private static void d_renamed(java.lang.String str) {
        throw ((java.lang.NullPointerException) a_renamed(new java.lang.NullPointerException(e_renamed(str))));
    }

    private static java.lang.String e_renamed(java.lang.String str) {
        java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as_renamed non-null is_renamed null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static <T_renamed extends java.lang.Throwable> T_renamed a_renamed(T_renamed t_renamed) {
        return (T_renamed) a_renamed((java.lang.Throwable) t_renamed, c_renamed.f_renamed.b_renamed.h_renamed.class.getName());
    }

    static <T_renamed extends java.lang.Throwable> T_renamed a_renamed(T_renamed t_renamed, java.lang.String str) {
        java.lang.StackTraceElement[] stackTrace = t_renamed.getStackTrace();
        int length = stackTrace.length;
        int i_renamed = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i_renamed = i2;
            }
        }
        t_renamed.setStackTrace((java.lang.StackTraceElement[]) java.util.Arrays.copyOfRange(stackTrace, i_renamed + 1, length));
        return t_renamed;
    }
}
