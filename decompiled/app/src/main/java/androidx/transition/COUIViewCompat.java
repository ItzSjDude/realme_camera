package androidx.transition;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class t_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.view.View f1755b;

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.util.Map<java.lang.String, java.lang.Object> f1754a = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    final java.util.ArrayList<androidx.transition.m_renamed> f1756c = new java.util.ArrayList<>();

    @java.lang.Deprecated
    public t_renamed() {
    }

    public t_renamed(android.view.View view) {
        this.f1755b = view;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.transition.t_renamed)) {
            return false;
        }
        androidx.transition.t_renamed tVar = (androidx.transition.t_renamed) obj;
        return this.f1755b == tVar.f1755b && this.f1754a.equals(tVar.f1754a);
    }

    public int hashCode() {
        return (this.f1755b.hashCode() * 31) + this.f1754a.hashCode();
    }

    public java.lang.String toString() {
        java.lang.String str = (("TransitionValues@" + java.lang.Integer.toHexString(hashCode()) + ":\n_renamed") + "    view = " + this.f1755b + "\n_renamed") + "    values:";
        for (java.lang.String str2 : this.f1754a.keySet()) {
            str = str + "    " + str2 + ": " + this.f1754a.get(str2) + "\n_renamed";
        }
        return str;
    }
}
