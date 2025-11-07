package androidx.savedstate;

/* compiled from: SavedStateRegistry.java */
@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.Bundle f1650c;
    private boolean d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.a_renamed.a_renamed.b_renamed.b_renamed<java.lang.String, androidx.savedstate.a_renamed.b_renamed> f1649b = new androidx.a_renamed.a_renamed.b_renamed.b_renamed<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    boolean f1648a = true;

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface SavedStateRegistry_2 {
        void a_renamed(androidx.savedstate.c_renamed cVar);
    }

    /* compiled from: SavedStateRegistry.java */
    public interface b_renamed {
        android.os.Bundle a_renamed();
    }

    a_renamed() {
    }

    public android.os.Bundle a_renamed(java.lang.String str) {
        if (!this.d_renamed) {
            throw new java.lang.IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of_renamed corresponding component");
        }
        android.os.Bundle bundle = this.f1650c;
        if (bundle == null) {
            return null;
        }
        android.os.Bundle bundle2 = bundle.getBundle(str);
        this.f1650c.remove(str);
        if (this.f1650c.isEmpty()) {
            this.f1650c = null;
        }
        return bundle2;
    }

    void a_renamed(androidx.lifecycle.e_renamed eVar, android.os.Bundle bundle) {
        if (this.d_renamed) {
            throw new java.lang.IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f1650c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        eVar.a_renamed(new androidx.lifecycle.d_renamed() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.f_renamed
            public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
                if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_START) {
                    this.f1647a.f1648a = true;
                } else if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_STOP) {
                    this.f1647a.f1648a = false;
                }
            }
        });
        this.d_renamed = true;
    }

    void a_renamed(android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        android.os.Bundle bundle3 = this.f1650c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.a_renamed.a_renamed.b_renamed.b_renamed<java.lang.String, androidx.savedstate.a_renamed.b_renamed>.d_renamed dVarC = this.f1649b.c_renamed();
        while (dVarC.hasNext()) {
            java.util.Map.Entry next = dVarC.next();
            bundle2.putBundle((java.lang.String) next.getKey(), ((androidx.savedstate.a_renamed.b_renamed) next.getValue()).a_renamed());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
