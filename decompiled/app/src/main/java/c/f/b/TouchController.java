package c_renamed.f_renamed.b_renamed;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes.dex */
public class l_renamed {
    public c_renamed.i_renamed.a_renamed a_renamed(java.lang.Class cls) {
        return new c_renamed.f_renamed.b_renamed.d_renamed(cls);
    }

    public java.lang.String a_renamed(c_renamed.f_renamed.b_renamed.i_renamed iVar) {
        return a_renamed((c_renamed.f_renamed.b_renamed.g_renamed) iVar);
    }

    public java.lang.String a_renamed(c_renamed.f_renamed.b_renamed.g_renamed gVar) {
        java.lang.String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
