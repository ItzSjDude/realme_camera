package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    static final java.lang.Object f1218b = new java.lang.Object();
    private boolean f_renamed;
    private boolean i_renamed;
    private boolean j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.lang.Object f1219a = new java.lang.Object();
    private androidx.a_renamed.a_renamed.b_renamed.b_renamed<androidx.lifecycle.n_renamed<? super T_renamed>, androidx.lifecycle.LiveData<T_renamed>.a_renamed> e_renamed = new androidx.a_renamed.a_renamed.b_renamed.b_renamed<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1220c = 0;
    volatile java.lang.Object d_renamed = f1218b;
    private final java.lang.Runnable k_renamed = new java.lang.Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj;
            synchronized (androidx.lifecycle.LiveData.this.f1219a) {
                obj = androidx.lifecycle.LiveData.this.d_renamed;
                androidx.lifecycle.LiveData.this.d_renamed = androidx.lifecycle.LiveData.f1218b;
            }
            androidx.lifecycle.LiveData.this.a_renamed((androidx.lifecycle.LiveData) obj);
        }
    };
    private volatile java.lang.Object g_renamed = f1218b;
    private int h_renamed = -1;

    protected void b_renamed() {
    }

    protected void c_renamed() {
    }

    private void b_renamed(androidx.lifecycle.LiveData<T_renamed>.a_renamed aVar) {
        if (aVar.d_renamed) {
            if (!aVar.a_renamed()) {
                aVar.a_renamed(false);
                return;
            }
            int i_renamed = aVar.e_renamed;
            int i2 = this.h_renamed;
            if (i_renamed >= i2) {
                return;
            }
            aVar.e_renamed = i2;
            aVar.f1224c.a_renamed((java.lang.Object) this.g_renamed);
        }
    }

    void a_renamed(androidx.lifecycle.LiveData<T_renamed>.a_renamed aVar) {
        if (this.i_renamed) {
            this.j_renamed = true;
            return;
        }
        this.i_renamed = true;
        do {
            this.j_renamed = false;
            if (aVar != null) {
                b_renamed(aVar);
                aVar = null;
            } else {
                androidx.a_renamed.a_renamed.b_renamed.b_renamed<androidx.lifecycle.n_renamed<? super T_renamed>, androidx.lifecycle.LiveData<T_renamed>.a_renamed>.d_renamed dVarC = this.e_renamed.c_renamed();
                while (dVarC.hasNext()) {
                    b_renamed((androidx.lifecycle.LiveData.a_renamed) dVarC.next().getValue());
                    if (this.j_renamed) {
                        break;
                    }
                }
            }
        } while (this.j_renamed);
        this.i_renamed = false;
    }

    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.n_renamed<? super T_renamed> nVar) {
        a_renamed("observe");
        if (hVar.getLifecycle().a_renamed() == androidx.lifecycle.e_renamed.b_renamed.DESTROYED) {
            return;
        }
        androidx.lifecycle.LiveData.LifecycleBoundObserver lifecycleBoundObserver = new androidx.lifecycle.LiveData.LifecycleBoundObserver(hVar, nVar);
        androidx.lifecycle.LiveData<T_renamed>.a_renamed aVarA = this.e_renamed.a_renamed(nVar, lifecycleBoundObserver);
        if (aVarA != null && !aVarA.a_renamed(hVar)) {
            throw new java.lang.IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (aVarA != null) {
            return;
        }
        hVar.getLifecycle().a_renamed(lifecycleBoundObserver);
    }

    public void a_renamed(androidx.lifecycle.n_renamed<? super T_renamed> nVar) {
        a_renamed("removeObserver");
        androidx.lifecycle.LiveData<T_renamed>.a_renamed aVarB = this.e_renamed.b_renamed(nVar);
        if (aVarB == null) {
            return;
        }
        aVarB.b_renamed();
        aVarB.a_renamed(false);
    }

    protected void a_renamed(T_renamed t_renamed) {
        a_renamed("setValue");
        this.h_renamed++;
        this.g_renamed = t_renamed;
        a_renamed((androidx.lifecycle.LiveData.a_renamed) null);
    }

    public T_renamed a_renamed() {
        T_renamed t_renamed = (T_renamed) this.g_renamed;
        if (t_renamed != f1218b) {
            return t_renamed;
        }
        return null;
    }

    public boolean d_renamed() {
        return this.f1220c > 0;
    }

    void a_renamed(int i_renamed) {
        int i2 = this.f1220c;
        this.f1220c = i_renamed + i2;
        if (this.f_renamed) {
            return;
        }
        this.f_renamed = true;
        while (true) {
            try {
                if (i2 == this.f1220c) {
                    return;
                }
                boolean z_renamed = i2 == 0 && this.f1220c > 0;
                boolean z2 = i2 > 0 && this.f1220c == 0;
                int i3 = this.f1220c;
                if (z_renamed) {
                    b_renamed();
                } else if (z2) {
                    c_renamed();
                }
                i2 = i3;
            } finally {
                this.f_renamed = false;
            }
        }
    }

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData<T_renamed>.a_renamed implements androidx.lifecycle.f_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.lifecycle.h_renamed f1222a;

        LifecycleBoundObserver(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.n_renamed<? super T_renamed> nVar) {
            super(nVar);
            this.f1222a = hVar;
        }

        @Override // androidx.lifecycle.LiveData.a_renamed
        boolean a_renamed() {
            return this.f1222a.getLifecycle().a_renamed().isAtLeast(androidx.lifecycle.e_renamed.b_renamed.STARTED);
        }

        @Override // androidx.lifecycle.f_renamed
        public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
            androidx.lifecycle.e_renamed.b_renamed bVarA = this.f1222a.getLifecycle().a_renamed();
            if (bVarA == androidx.lifecycle.e_renamed.b_renamed.DESTROYED) {
                androidx.lifecycle.LiveData.this.a_renamed((androidx.lifecycle.n_renamed) this.f1224c);
                return;
            }
            androidx.lifecycle.e_renamed.b_renamed bVar = null;
            while (bVar != bVarA) {
                a_renamed(a_renamed());
                bVar = bVarA;
                bVarA = this.f1222a.getLifecycle().a_renamed();
            }
        }

        @Override // androidx.lifecycle.LiveData.a_renamed
        boolean a_renamed(androidx.lifecycle.h_renamed hVar) {
            return this.f1222a == hVar;
        }

        @Override // androidx.lifecycle.LiveData.a_renamed
        void b_renamed() {
            this.f1222a.getLifecycle().b_renamed(this);
        }
    }

    private abstract class a_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        final androidx.lifecycle.n_renamed<? super T_renamed> f1224c;
        boolean d_renamed;
        int e_renamed = -1;

        abstract boolean a_renamed();

        boolean a_renamed(androidx.lifecycle.h_renamed hVar) {
            return false;
        }

        void b_renamed() {
        }

        a_renamed(androidx.lifecycle.n_renamed<? super T_renamed> nVar) {
            this.f1224c = nVar;
        }

        void a_renamed(boolean z_renamed) {
            if (z_renamed == this.d_renamed) {
                return;
            }
            this.d_renamed = z_renamed;
            androidx.lifecycle.LiveData.this.a_renamed(this.d_renamed ? 1 : -1);
            if (this.d_renamed) {
                androidx.lifecycle.LiveData.this.a_renamed(this);
            }
        }
    }

    static void a_renamed(java.lang.String str) {
        if (androidx.a_renamed.a_renamed.a_renamed.a_renamed.a_renamed().c_renamed()) {
            return;
        }
        throw new java.lang.IllegalStateException("Cannot invoke " + str + " on_renamed a_renamed background thread");
    }
}
