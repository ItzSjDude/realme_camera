package p061c.p070f.p072b;

import p061c.Function.kt;
import p061c.p070f.p071a.Functions.kt_20;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_11;
import p061c.p070f.p071a.Functions.kt_16;
import p061c.p070f.p071a.Functions.kt;
import p061c.p070f.p071a.Functions.kt_8;
import p061c.p070f.p071a.Functions.kt_17;
import p061c.p070f.p071a.Functions.kt_7;
import p061c.p070f.p071a.Functions.kt_2;
import p061c.p070f.p071a.Functions.kt_13;
import p061c.p070f.p071a.Functions.kt_5;
import p061c.p070f.p071a.Functions.kt_18;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p071a.Functions.kt_14;
import p061c.p070f.p071a.Functions.kt_23;
import p061c.p070f.p071a.Functions.kt_15;
import p061c.p070f.p071a.Functions.kt_9;
import p061c.p070f.p071a.Functions.kt_10;
import p061c.p070f.p071a.Functions.kt_6;
import p061c.p070f.p071a.Functions.kt_22;
import p061c.p070f.p071a.Functions.kt_12;
import p061c.p070f.p071a.Functions.kt_21;
import p061c.p070f.p071a.Functions.kt_4;

/* compiled from: TypeIntrinsics.java */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class TypeIntrinsics {
    /* renamed from: PlatformImplementations.kt_3 */
    private static <T extends Throwable> T m5316a(T t) {
        return (T) Intrinsics.m5294a((Throwable) t, TypeIntrinsics.class.getName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5317a(Object obj, String str) {
        m5318a((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5318a(String str) {
        throw m5315a(new ClassCastException(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ClassCastException m5315a(ClassCastException classCastException) {
        throw ((ClassCastException) m5316a(classCastException));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m5314a(Object obj) {
        if (obj instanceof FunctionBase.kt) {
            return ((FunctionBase.kt) obj).getArity();
        }
        if (obj instanceof Functions.kt_20) {
            return 0;
        }
        if (obj instanceof Functions.kt_3) {
            return 1;
        }
        if (obj instanceof Functions.kt_19) {
            return 2;
        }
        if (obj instanceof Functions.kt_9) {
            return 3;
        }
        if (obj instanceof Functions.kt_10) {
            return 4;
        }
        if (obj instanceof Functions.kt_6) {
            return 5;
        }
        if (obj instanceof Functions.kt_22) {
            return 6;
        }
        if (obj instanceof Functions.kt_12) {
            return 7;
        }
        if (obj instanceof Functions.kt_21) {
            return 8;
        }
        if (obj instanceof Functions.kt_4) {
            return 9;
        }
        if (obj instanceof Functions.kt_11) {
            return 10;
        }
        if (obj instanceof Functions.kt_16) {
            return 11;
        }
        if (obj instanceof Functions.kt) {
            return 12;
        }
        if (obj instanceof Functions.kt_8) {
            return 13;
        }
        if (obj instanceof Functions.kt_17) {
            return 14;
        }
        if (obj instanceof Functions.kt_7) {
            return 15;
        }
        if (obj instanceof Functions.kt_2) {
            return 16;
        }
        if (obj instanceof Functions.kt_13) {
            return 17;
        }
        if (obj instanceof Functions.kt_5) {
            return 18;
        }
        if (obj instanceof Functions.kt_18) {
            return 19;
        }
        if (obj instanceof Functions.kt_14) {
            return 20;
        }
        if (obj instanceof Functions.kt_23) {
            return 21;
        }
        return obj instanceof Functions.kt_15 ? 22 : -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m5319a(Object obj, int OplusGLSurfaceView_13) {
        return (obj instanceof Function.kt) && m5314a(obj) == OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Object m5320b(Object obj, int OplusGLSurfaceView_13) {
        if (obj != null && !m5319a(obj, OplusGLSurfaceView_13)) {
            m5317a(obj, "kotlin.jvm.functions.Function" + OplusGLSurfaceView_13);
        }
        return obj;
    }
}
