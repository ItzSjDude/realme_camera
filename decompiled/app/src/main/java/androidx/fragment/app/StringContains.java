package androidx.fragment.app;

/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
class j_renamed extends androidx.lifecycle.q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final androidx.lifecycle.r_renamed.a_renamed f1171a = new androidx.lifecycle.r_renamed.a_renamed() { // from class: androidx.fragment.app.j_renamed.1
        @Override // androidx.lifecycle.r_renamed.a_renamed
        public <T_renamed extends androidx.lifecycle.q_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls) {
            return new androidx.fragment.app.j_renamed(true);
        }
    };
    private final boolean e_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.HashSet<androidx.fragment.app.Fragment> f1172b = new java.util.HashSet<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.HashMap<java.lang.String, androidx.fragment.app.j_renamed> f1173c = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, androidx.lifecycle.s_renamed> d_renamed = new java.util.HashMap<>();
    private boolean f_renamed = false;
    private boolean g_renamed = false;

    static androidx.fragment.app.j_renamed a_renamed(androidx.lifecycle.s_renamed sVar) {
        return (androidx.fragment.app.j_renamed) new androidx.lifecycle.r_renamed(sVar, f1171a).a_renamed(androidx.fragment.app.j_renamed.class);
    }

    j_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    @Override // androidx.lifecycle.q_renamed
    protected void a_renamed() {
        if (androidx.fragment.app.i_renamed.f1142b) {
            android.util.Log.d_renamed("FragmentManager", "onCleared called for " + this);
        }
        this.f_renamed = true;
    }

    boolean b_renamed() {
        return this.f_renamed;
    }

    boolean a_renamed(androidx.fragment.app.Fragment fragment) {
        return this.f1172b.add(fragment);
    }

    java.util.Collection<androidx.fragment.app.Fragment> c_renamed() {
        return this.f1172b;
    }

    boolean b_renamed(androidx.fragment.app.Fragment fragment) {
        if (!this.f1172b.contains(fragment)) {
            return true;
        }
        if (this.e_renamed) {
            return this.f_renamed;
        }
        return !this.g_renamed;
    }

    boolean c_renamed(androidx.fragment.app.Fragment fragment) {
        return this.f1172b.remove(fragment);
    }

    androidx.fragment.app.j_renamed d_renamed(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.j_renamed jVar = this.f1173c.get(fragment.mWho);
        if (jVar != null) {
            return jVar;
        }
        androidx.fragment.app.j_renamed jVar2 = new androidx.fragment.app.j_renamed(this.e_renamed);
        this.f1173c.put(fragment.mWho, jVar2);
        return jVar2;
    }

    androidx.lifecycle.s_renamed e_renamed(androidx.fragment.app.Fragment fragment) {
        androidx.lifecycle.s_renamed sVar = this.d_renamed.get(fragment.mWho);
        if (sVar != null) {
            return sVar;
        }
        androidx.lifecycle.s_renamed sVar2 = new androidx.lifecycle.s_renamed();
        this.d_renamed.put(fragment.mWho, sVar2);
        return sVar2;
    }

    void f_renamed(androidx.fragment.app.Fragment fragment) {
        if (androidx.fragment.app.i_renamed.f1142b) {
            android.util.Log.d_renamed("FragmentManager", "Clearing non-config state for " + fragment);
        }
        androidx.fragment.app.j_renamed jVar = this.f1173c.get(fragment.mWho);
        if (jVar != null) {
            jVar.a_renamed();
            this.f1173c.remove(fragment.mWho);
        }
        androidx.lifecycle.s_renamed sVar = this.d_renamed.get(fragment.mWho);
        if (sVar != null) {
            sVar.a_renamed();
            this.d_renamed.remove(fragment.mWho);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        androidx.fragment.app.j_renamed jVar = (androidx.fragment.app.j_renamed) obj;
        return this.f1172b.equals(jVar.f1172b) && this.f1173c.equals(jVar.f1173c) && this.d_renamed.equals(jVar.d_renamed);
    }

    public int hashCode() {
        return (((this.f1172b.hashCode() * 31) + this.f1173c.hashCode()) * 31) + this.d_renamed.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("FragmentManagerViewModel{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append("} Fragments (");
        java.util.Iterator<androidx.fragment.app.Fragment> it = this.f1172b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        java.util.Iterator<java.lang.String> it2 = this.f1173c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        java.util.Iterator<java.lang.String> it3 = this.d_renamed.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
