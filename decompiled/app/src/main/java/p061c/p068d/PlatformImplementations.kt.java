package p061c.p068d;

import p061c.p070f.p072b.Intrinsics;
import p061c.p077k.C1005d;

/* compiled from: PlatformImplementations.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class PlatformImplementations.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_2 f5042a;

    static {
        PlatformImplementations.kt_2 c0935a;
        int iM5281a = m5281a();
        if (iM5281a >= 65544) {
            try {
                Object objNewInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                Intrinsics.m5301b(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c0935a = (PlatformImplementations.kt_2) objNewInstance;
                    } catch (ClassCastException COUIBaseListPopupWindow_8) {
                        Throwable thInitCause = new ClassCastException("Instance classloader: " + objNewInstance.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.kt_2.class.getClassLoader()).initCause(COUIBaseListPopupWindow_8);
                        Intrinsics.m5301b(thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(COUIBaseListPopupWindow_8)");
                        throw thInitCause;
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object objNewInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                Intrinsics.m5301b(objNewInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c0935a = (PlatformImplementations.kt_2) objNewInstance2;
                } catch (ClassCastException e2) {
                    Throwable thInitCause2 = new ClassCastException("Instance classloader: " + objNewInstance2.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.kt_2.class.getClassLoader()).initCause(e2);
                    Intrinsics.m5301b(thInitCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(COUIBaseListPopupWindow_8)");
                    throw thInitCause2;
                }
            }
        } else if (iM5281a >= 65543) {
            try {
                Object objNewInstance3 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                Intrinsics.m5301b(objNewInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c0935a = (PlatformImplementations.kt_2) objNewInstance3;
                    } catch (ClassCastException e3) {
                        Throwable thInitCause3 = new ClassCastException("Instance classloader: " + objNewInstance3.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.kt_2.class.getClassLoader()).initCause(e3);
                        Intrinsics.m5301b(thInitCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(COUIBaseListPopupWindow_8)");
                        throw thInitCause3;
                    }
                } catch (ClassNotFoundException unused3) {
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                Intrinsics.m5301b(objNewInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c0935a = (PlatformImplementations.kt_2) objNewInstance4;
                } catch (ClassCastException e4) {
                    Throwable thInitCause4 = new ClassCastException("Instance classloader: " + objNewInstance4.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.kt_2.class.getClassLoader()).initCause(e4);
                    Intrinsics.m5301b(thInitCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(COUIBaseListPopupWindow_8)");
                    throw thInitCause4;
                }
            }
        } else {
            c0935a = new PlatformImplementations.kt_2();
        }
        f5042a = c0935a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int m5281a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        String str = property;
        int iA = C1005d.m5358a((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iA < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int OplusGLSurfaceView_13 = iA + 1;
        int iA2 = C1005d.m5358a((CharSequence) str, '.', OplusGLSurfaceView_13, false, 4, (Object) null);
        if (iA2 < 0) {
            iA2 = property.length();
        }
        if (property != null) {
            String strSubstring = property.substring(0, iA);
            Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                String strSubstring2 = property.substring(OplusGLSurfaceView_13, iA2);
                Intrinsics.m5301b(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
                } catch (NumberFormatException unused2) {
                    return 65542;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
