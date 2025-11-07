package androidx.lifecycle;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.HashMap<java.lang.String, androidx.lifecycle.q_renamed> f1252a = new java.util.HashMap<>();

    final void a_renamed(java.lang.String str, androidx.lifecycle.q_renamed qVar) {
        androidx.lifecycle.q_renamed qVarPut = this.f1252a.put(str, qVar);
        if (qVarPut != null) {
            qVarPut.a_renamed();
        }
    }

    final androidx.lifecycle.q_renamed a_renamed(java.lang.String str) {
        return this.f1252a.get(str);
    }

    public final void a_renamed() {
        java.util.Iterator<androidx.lifecycle.q_renamed> it = this.f1252a.values().iterator();
        while (it.hasNext()) {
            it.next().d_renamed();
        }
        this.f1252a.clear();
    }
}
