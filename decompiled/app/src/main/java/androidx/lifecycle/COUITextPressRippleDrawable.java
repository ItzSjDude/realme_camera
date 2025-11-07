package androidx.lifecycle;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class r_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.lifecycle.r_renamed.a_renamed f1250a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.lifecycle.s_renamed f1251b;

    /* compiled from: ViewModelProvider.java */
    public interface a_renamed {
        <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls);
    }

    /* compiled from: ViewModelProvider.java */
    static abstract class b_renamed implements androidx.lifecycle.r_renamed.a_renamed {
        public abstract <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.String str, java.lang.Class<T_renamed> cls);

        b_renamed() {
        }
    }

    public r_renamed(androidx.lifecycle.s_renamed sVar, androidx.lifecycle.r_renamed.a_renamed aVar) {
        this.f1250a = aVar;
        this.f1251b = sVar;
    }

    public <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls) {
        java.lang.String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new java.lang.IllegalArgumentException("Local and anonymous classes can not be_renamed ViewModels");
        }
        return (T_renamed) a_renamed("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.String str, java.lang.Class<T_renamed> cls) {
        T_renamed t_renamed;
        T_renamed t2 = (T_renamed) this.f1251b.a_renamed(str);
        if (cls.isInstance(t2)) {
            return t2;
        }
        androidx.lifecycle.r_renamed.a_renamed aVar = this.f1250a;
        if (aVar instanceof androidx.lifecycle.r_renamed.b_renamed) {
            t_renamed = (T_renamed) ((androidx.lifecycle.r_renamed.b_renamed) aVar).a_renamed(str, cls);
        } else {
            t_renamed = (T_renamed) aVar.a_renamed(cls);
        }
        this.f1251b.a_renamed(str, t_renamed);
        return t_renamed;
    }
}
