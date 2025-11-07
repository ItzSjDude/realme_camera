package c_renamed.d_renamed;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.d_renamed.a_renamed f1902a;

    static {
        c_renamed.d_renamed.a_renamed aVar;
        int iA = a_renamed();
        if (iA >= 65544) {
            try {
                java.lang.Object objNewInstance = java.lang.Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objNewInstance, "Class.forName(\"kotlin.in_renamed…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance == null) {
                            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (c_renamed.d_renamed.a_renamed) objNewInstance;
                    } catch (java.lang.ClassCastException e_renamed) {
                        java.lang.Throwable thInitCause = new java.lang.ClassCastException("Instance classloader: " + objNewInstance.getClass().getClassLoader() + ", base type classloader: " + c_renamed.d_renamed.a_renamed.class.getClassLoader()).initCause(e_renamed);
                        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e_renamed)");
                        throw thInitCause;
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                }
            } catch (java.lang.ClassNotFoundException unused2) {
                java.lang.Object objNewInstance2 = java.lang.Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objNewInstance2, "Class.forName(\"kotlin.in_renamed…entations\").newInstance()");
                try {
                    if (objNewInstance2 == null) {
                        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (c_renamed.d_renamed.a_renamed) objNewInstance2;
                } catch (java.lang.ClassCastException e2) {
                    java.lang.Throwable thInitCause2 = new java.lang.ClassCastException("Instance classloader: " + objNewInstance2.getClass().getClassLoader() + ", base type classloader: " + c_renamed.d_renamed.a_renamed.class.getClassLoader()).initCause(e2);
                    c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(thInitCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e_renamed)");
                    throw thInitCause2;
                }
            }
        } else if (iA >= 65543) {
            try {
                java.lang.Object objNewInstance3 = java.lang.Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objNewInstance3, "Class.forName(\"kotlin.in_renamed…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance3 == null) {
                            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (c_renamed.d_renamed.a_renamed) objNewInstance3;
                    } catch (java.lang.ClassCastException e3) {
                        java.lang.Throwable thInitCause3 = new java.lang.ClassCastException("Instance classloader: " + objNewInstance3.getClass().getClassLoader() + ", base type classloader: " + c_renamed.d_renamed.a_renamed.class.getClassLoader()).initCause(e3);
                        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(thInitCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e_renamed)");
                        throw thInitCause3;
                    }
                } catch (java.lang.ClassNotFoundException unused3) {
                }
            } catch (java.lang.ClassNotFoundException unused4) {
                java.lang.Object objNewInstance4 = java.lang.Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objNewInstance4, "Class.forName(\"kotlin.in_renamed…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (c_renamed.d_renamed.a_renamed) objNewInstance4;
                } catch (java.lang.ClassCastException e4) {
                    java.lang.Throwable thInitCause4 = new java.lang.ClassCastException("Instance classloader: " + objNewInstance4.getClass().getClassLoader() + ", base type classloader: " + c_renamed.d_renamed.a_renamed.class.getClassLoader()).initCause(e4);
                    c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(thInitCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e_renamed)");
                    throw thInitCause4;
                }
            }
        } else {
            aVar = new c_renamed.d_renamed.a_renamed();
        }
        f1902a = aVar;
    }

    private static final int a_renamed() {
        java.lang.String property = java.lang.System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        java.lang.String str = property;
        int iA = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) str, '.', 0, false, 6, (java.lang.Object) null);
        if (iA < 0) {
            try {
                return java.lang.Integer.parseInt(property) * 65536;
            } catch (java.lang.NumberFormatException unused) {
                return 65542;
            }
        }
        int i_renamed = iA + 1;
        int iA2 = c_renamed.k_renamed.d_renamed.a_renamed((java.lang.CharSequence) str, '.', i_renamed, false, 4, (java.lang.Object) null);
        if (iA2 < 0) {
            iA2 = property.length();
        }
        if (property != null) {
            java.lang.String strSubstring = property.substring(0, iA);
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                java.lang.String strSubstring2 = property.substring(i_renamed, iA2);
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring2, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (java.lang.Integer.parseInt(strSubstring) * 65536) + java.lang.Integer.parseInt(strSubstring2);
                } catch (java.lang.NumberFormatException unused2) {
                    return 65542;
                }
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.String");
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.String");
    }
}
