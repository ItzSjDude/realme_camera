package c_renamed.f_renamed.b_renamed;

/* compiled from: Reflection.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final c_renamed.f_renamed.b_renamed.l_renamed f1909a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final c_renamed.i_renamed.a_renamed[] f1910b;

    static {
        c_renamed.f_renamed.b_renamed.l_renamed lVar = null;
        try {
            lVar = (c_renamed.f_renamed.b_renamed.l_renamed) java.lang.Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new c_renamed.f_renamed.b_renamed.l_renamed();
        }
        f1909a = lVar;
        f1910b = new c_renamed.i_renamed.a_renamed[0];
    }

    public static c_renamed.i_renamed.a_renamed a_renamed(java.lang.Class cls) {
        return f1909a.a_renamed(cls);
    }

    public static java.lang.String a_renamed(c_renamed.f_renamed.b_renamed.i_renamed iVar) {
        return f1909a.a_renamed(iVar);
    }

    public static java.lang.String a_renamed(c_renamed.f_renamed.b_renamed.g_renamed gVar) {
        return f1909a.a_renamed(gVar);
    }
}
