package androidx.lifecycle;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class i_renamed extends androidx.lifecycle.e_renamed {
    private final java.lang.ref.WeakReference<androidx.lifecycle.h_renamed> d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.a_renamed.a_renamed.b_renamed.a_renamed<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed> f1238b = new androidx.a_renamed.a_renamed.b_renamed.a_renamed<>();
    private int e_renamed = 0;
    private boolean f_renamed = false;
    private boolean g_renamed = false;
    private java.util.ArrayList<androidx.lifecycle.e_renamed.b_renamed> h_renamed = new java.util.ArrayList<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.lifecycle.e_renamed.b_renamed f1239c = androidx.lifecycle.e_renamed.b_renamed.INITIALIZED;

    public i_renamed(androidx.lifecycle.h_renamed hVar) {
        this.d_renamed = new java.lang.ref.WeakReference<>(hVar);
    }

    @java.lang.Deprecated
    public void a_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        b_renamed(bVar);
    }

    public void b_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        c_renamed(bVar);
    }

    public void a_renamed(androidx.lifecycle.e_renamed.a_renamed aVar) {
        c_renamed(b_renamed(aVar));
    }

    private void c_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        if (this.f1239c == bVar) {
            return;
        }
        this.f1239c = bVar;
        if (this.f_renamed || this.e_renamed != 0) {
            this.g_renamed = true;
            return;
        }
        this.f_renamed = true;
        d_renamed();
        this.f_renamed = false;
    }

    private boolean b_renamed() {
        if (this.f1238b.a_renamed() == 0) {
            return true;
        }
        androidx.lifecycle.e_renamed.b_renamed bVar = this.f1238b.d_renamed().getValue().f1242a;
        androidx.lifecycle.e_renamed.b_renamed bVar2 = this.f1238b.e_renamed().getValue().f1242a;
        return bVar == bVar2 && this.f1239c == bVar2;
    }

    private androidx.lifecycle.e_renamed.b_renamed c_renamed(androidx.lifecycle.g_renamed gVar) {
        java.util.Map.Entry<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed> entryD = this.f1238b.d_renamed(gVar);
        androidx.lifecycle.e_renamed.b_renamed bVar = null;
        androidx.lifecycle.e_renamed.b_renamed bVar2 = entryD != null ? entryD.getValue().f1242a : null;
        if (!this.h_renamed.isEmpty()) {
            bVar = this.h_renamed.get(r0.size() - 1);
        }
        return a_renamed(a_renamed(this.f1239c, bVar2), bVar);
    }

    @Override // androidx.lifecycle.e_renamed
    public void a_renamed(androidx.lifecycle.g_renamed gVar) {
        androidx.lifecycle.h_renamed hVar;
        androidx.lifecycle.i_renamed.a_renamed aVar = new androidx.lifecycle.i_renamed.a_renamed(gVar, this.f1239c == androidx.lifecycle.e_renamed.b_renamed.DESTROYED ? androidx.lifecycle.e_renamed.b_renamed.DESTROYED : androidx.lifecycle.e_renamed.b_renamed.INITIALIZED);
        if (this.f1238b.a_renamed(gVar, aVar) == null && (hVar = this.d_renamed.get()) != null) {
            boolean z_renamed = this.e_renamed != 0 || this.f_renamed;
            androidx.lifecycle.e_renamed.b_renamed bVarC = c_renamed(gVar);
            this.e_renamed++;
            while (aVar.f1242a.compareTo(bVarC) < 0 && this.f1238b.c_renamed(gVar)) {
                d_renamed(aVar.f1242a);
                aVar.a_renamed(hVar, f_renamed(aVar.f1242a));
                c_renamed();
                bVarC = c_renamed(gVar);
            }
            if (!z_renamed) {
                d_renamed();
            }
            this.e_renamed--;
        }
    }

    private void c_renamed() {
        this.h_renamed.remove(r1.size() - 1);
    }

    private void d_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        this.h_renamed.add(bVar);
    }

    @Override // androidx.lifecycle.e_renamed
    public void b_renamed(androidx.lifecycle.g_renamed gVar) {
        this.f1238b.b_renamed(gVar);
    }

    @Override // androidx.lifecycle.e_renamed
    public androidx.lifecycle.e_renamed.b_renamed a_renamed() {
        return this.f1239c;
    }

    static androidx.lifecycle.e_renamed.b_renamed b_renamed(androidx.lifecycle.e_renamed.a_renamed aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return androidx.lifecycle.e_renamed.b_renamed.CREATED;
            case ON_START:
            case ON_PAUSE:
                return androidx.lifecycle.e_renamed.b_renamed.STARTED;
            case ON_RESUME:
                return androidx.lifecycle.e_renamed.b_renamed.RESUMED;
            case ON_DESTROY:
                return androidx.lifecycle.e_renamed.b_renamed.DESTROYED;
            default:
                throw new java.lang.IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: androidx.lifecycle.i_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f1241b = new int[androidx.lifecycle.e_renamed.b_renamed.values().length];

        static {
            try {
                f1241b[androidx.lifecycle.e_renamed.b_renamed.INITIALIZED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1241b[androidx.lifecycle.e_renamed.b_renamed.CREATED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1241b[androidx.lifecycle.e_renamed.b_renamed.STARTED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1241b[androidx.lifecycle.e_renamed.b_renamed.RESUMED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f1241b[androidx.lifecycle.e_renamed.b_renamed.DESTROYED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            f1240a = new int[androidx.lifecycle.e_renamed.a_renamed.values().length];
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_CREATE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_STOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_RESUME.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                f1240a[androidx.lifecycle.e_renamed.a_renamed.ON_ANY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    private static androidx.lifecycle.e_renamed.a_renamed e_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        int i_renamed = androidx.lifecycle.i_renamed.SceneLoader_2.f1241b[bVar.ordinal()];
        if (i_renamed == 1) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i_renamed == 2) {
            return androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY;
        }
        if (i_renamed == 3) {
            return androidx.lifecycle.e_renamed.a_renamed.ON_STOP;
        }
        if (i_renamed == 4) {
            return androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE;
        }
        if (i_renamed == 5) {
            throw new java.lang.IllegalArgumentException();
        }
        throw new java.lang.IllegalArgumentException("Unexpected state value " + bVar);
    }

    private static androidx.lifecycle.e_renamed.a_renamed f_renamed(androidx.lifecycle.e_renamed.b_renamed bVar) {
        int i_renamed = androidx.lifecycle.i_renamed.SceneLoader_2.f1241b[bVar.ordinal()];
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                return androidx.lifecycle.e_renamed.a_renamed.ON_START;
            }
            if (i_renamed == 3) {
                return androidx.lifecycle.e_renamed.a_renamed.ON_RESUME;
            }
            if (i_renamed == 4) {
                throw new java.lang.IllegalArgumentException();
            }
            if (i_renamed != 5) {
                throw new java.lang.IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return androidx.lifecycle.e_renamed.a_renamed.ON_CREATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a_renamed(androidx.lifecycle.h_renamed hVar) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed>.d_renamed dVarC = this.f1238b.c_renamed();
        while (dVarC.hasNext() && !this.g_renamed) {
            java.util.Map.Entry next = dVarC.next();
            androidx.lifecycle.i_renamed.a_renamed aVar = (androidx.lifecycle.i_renamed.a_renamed) next.getValue();
            while (aVar.f1242a.compareTo(this.f1239c) < 0 && !this.g_renamed && this.f1238b.c_renamed(next.getKey())) {
                d_renamed(aVar.f1242a);
                aVar.a_renamed(hVar, f_renamed(aVar.f1242a));
                c_renamed();
            }
        }
    }

    private void b_renamed(androidx.lifecycle.h_renamed hVar) {
        java.util.Iterator<java.util.Map.Entry<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed>> itB = this.f1238b.b_renamed();
        while (itB.hasNext() && !this.g_renamed) {
            java.util.Map.Entry<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed> next = itB.next();
            androidx.lifecycle.i_renamed.a_renamed value = next.getValue();
            while (value.f1242a.compareTo(this.f1239c) > 0 && !this.g_renamed && this.f1238b.c_renamed(next.getKey())) {
                androidx.lifecycle.e_renamed.a_renamed aVarE = e_renamed(value.f1242a);
                d_renamed(b_renamed(aVarE));
                value.a_renamed(hVar, aVarE);
                c_renamed();
            }
        }
    }

    private void d_renamed() {
        androidx.lifecycle.h_renamed hVar = this.d_renamed.get();
        if (hVar == null) {
            throw new java.lang.IllegalStateException("LifecycleOwner of_renamed this LifecycleRegistry is_renamed alreadygarbage collected. It is_renamed too late to change lifecycle state.");
        }
        while (!b_renamed()) {
            this.g_renamed = false;
            if (this.f1239c.compareTo(this.f1238b.d_renamed().getValue().f1242a) < 0) {
                b_renamed(hVar);
            }
            java.util.Map.Entry<androidx.lifecycle.g_renamed, androidx.lifecycle.i_renamed.a_renamed> entryE = this.f1238b.e_renamed();
            if (!this.g_renamed && entryE != null && this.f1239c.compareTo(entryE.getValue().f1242a) > 0) {
                a_renamed(hVar);
            }
        }
        this.g_renamed = false;
    }

    static androidx.lifecycle.e_renamed.b_renamed a_renamed(androidx.lifecycle.e_renamed.b_renamed bVar, androidx.lifecycle.e_renamed.b_renamed bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* compiled from: LifecycleRegistry.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.lifecycle.e_renamed.b_renamed f1242a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.lifecycle.f_renamed f1243b;

        a_renamed(androidx.lifecycle.g_renamed gVar, androidx.lifecycle.e_renamed.b_renamed bVar) {
            this.f1243b = androidx.lifecycle.k_renamed.a_renamed(gVar);
            this.f1242a = bVar;
        }

        void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
            androidx.lifecycle.e_renamed.b_renamed bVarB = androidx.lifecycle.i_renamed.b_renamed(aVar);
            this.f1242a = androidx.lifecycle.i_renamed.a_renamed(this.f1242a, bVarB);
            this.f1243b.a_renamed(hVar, aVar);
            this.f1242a = bVarB;
        }
    }
}
