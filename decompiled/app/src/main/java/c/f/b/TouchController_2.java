package c_renamed.f_renamed.b_renamed;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes.dex */
public class m_renamed {
    private static <T_renamed extends java.lang.Throwable> T_renamed a_renamed(T_renamed t_renamed) {
        return (T_renamed) c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Throwable) t_renamed, c_renamed.f_renamed.b_renamed.m_renamed.class.getName());
    }

    public static void a_renamed(java.lang.Object obj, java.lang.String str) {
        a_renamed((obj == null ? "null" : obj.getClass().getName()) + " cannot be_renamed cast to " + str);
    }

    public static void a_renamed(java.lang.String str) {
        throw a_renamed(new java.lang.ClassCastException(str));
    }

    public static java.lang.ClassCastException a_renamed(java.lang.ClassCastException classCastException) {
        throw ((java.lang.ClassCastException) a_renamed(classCastException));
    }

    public static int a_renamed(java.lang.Object obj) {
        if (obj instanceof c_renamed.f_renamed.b_renamed.g_renamed) {
            return ((c_renamed.f_renamed.b_renamed.g_renamed) obj).getArity();
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.a_renamed) {
            return 0;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.b_renamed) {
            return 1;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.m_renamed) {
            return 2;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.q_renamed) {
            return 3;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.r_renamed) {
            return 4;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.s_renamed) {
            return 5;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.t_renamed) {
            return 6;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.u_renamed) {
            return 7;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.v_renamed) {
            return 8;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.w_renamed) {
            return 9;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.c_renamed) {
            return 10;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.d_renamed) {
            return 11;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.e_renamed) {
            return 12;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.f_renamed) {
            return 13;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.g_renamed) {
            return 14;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.h_renamed) {
            return 15;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.i_renamed) {
            return 16;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.j_renamed) {
            return 17;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.k_renamed) {
            return 18;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.l_renamed) {
            return 19;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.n_renamed) {
            return 20;
        }
        if (obj instanceof c_renamed.f_renamed.a_renamed.o_renamed) {
            return 21;
        }
        return obj instanceof c_renamed.f_renamed.a_renamed.p_renamed ? 22 : -1;
    }

    public static boolean a_renamed(java.lang.Object obj, int i_renamed) {
        return (obj instanceof c_renamed.c_renamed) && a_renamed(obj) == i_renamed;
    }

    public static java.lang.Object b_renamed(java.lang.Object obj, int i_renamed) {
        if (obj != null && !a_renamed(obj, i_renamed)) {
            a_renamed(obj, "kotlin.jvm.functions.Function" + i_renamed);
        }
        return obj;
    }
}
