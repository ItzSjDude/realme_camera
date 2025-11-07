package com.b_renamed.a_renamed.a_renamed;

/* compiled from: AnimGroup.java */
/* loaded from: classes.dex */
public class c_renamed implements com.b_renamed.a_renamed.a_renamed.j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final java.lang.String f2321a = "c_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    final com.b_renamed.a_renamed.a_renamed.e_renamed f2322b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final int f2323c;
    java.util.List<com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed> d_renamed = new java.util.ArrayList();

    public c_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar, int i_renamed) {
        this.f2322b = eVar;
        this.f2323c = i_renamed;
        eVar.a_renamed((com.b_renamed.a_renamed.a_renamed.j_renamed) this);
    }

    public com.b_renamed.a_renamed.a_renamed.c_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.j_renamed jVar) {
        return a_renamed(jVar, 0, (int) this.f2322b.e_renamed, false);
    }

    public com.b_renamed.a_renamed.a_renamed.c_renamed a_renamed(com.b_renamed.a_renamed.a_renamed.j_renamed jVar, int i_renamed, int i2, boolean z_renamed) {
        com.b_renamed.a_renamed.n_renamed.a_renamed(jVar != null);
        this.d_renamed.add(new com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed(jVar, i_renamed, i2, z_renamed));
        return this;
    }

    public long a_renamed() {
        long jMax = 0;
        if (this.f2322b.f2328b) {
            this.d_renamed.sort(new java.util.Comparator() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$c_renamed$TQzsjdUJfMAQozbmpbg-ZXIVHWU
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return com.b_renamed.a_renamed.a_renamed.c_renamed.b_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj, (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj2);
                }
            });
            for (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar : this.d_renamed) {
                jMax = java.lang.Math.max(jMax, (this.f2322b.e_renamed - (aVar.f2325b + aVar.f2326c)) + aVar.f2326c);
            }
            return jMax;
        }
        this.d_renamed.sort(new java.util.Comparator() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$c_renamed$xB0QgZOcdVD4emFy7a-GHGP4BpA
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj, (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj2);
            }
        });
        for (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar2 : this.d_renamed) {
            jMax = java.lang.Math.max(jMax, aVar2.f2325b + aVar2.f2326c);
        }
        return jMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar, com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar2) {
        if (aVar2.f2325b < aVar.f2325b) {
            return -1;
        }
        return aVar2.f2325b > aVar.f2325b ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar, com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar2) {
        if (aVar.f2325b < aVar2.f2325b) {
            return -1;
        }
        return aVar.f2325b > aVar2.f2325b ? 1 : 0;
    }

    public boolean b_renamed(com.b_renamed.a_renamed.a_renamed.j_renamed jVar) {
        if (jVar == null) {
            if (this.d_renamed.size() <= 0) {
                return false;
            }
            this.d_renamed.clear();
            return true;
        }
        for (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar : this.d_renamed) {
            if (aVar.f2324a == jVar) {
                this.d_renamed.remove(aVar);
                return true;
            }
        }
        return false;
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void b_renamed() {
        c_renamed();
    }

    public void a_renamed(java.util.function.Consumer<com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed> consumer) {
        java.util.Iterator<com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed> it = this.d_renamed.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    void c_renamed() {
        a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$c_renamed$AH2j3kY-YL4KLMFw0n9b64JAsZI
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                this.f_renamed$0.b_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar) {
        if (aVar.e_renamed || aVar.f2325b > this.f2322b.d_renamed) {
            return;
        }
        aVar.e_renamed = true;
        aVar.f2324a.b_renamed();
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void a_renamed(float f_renamed) {
        float f2;
        long jMin;
        c_renamed();
        for (com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar : this.d_renamed) {
            if (!aVar.e_renamed) {
                return;
            }
            if (this.f2322b.f2328b) {
                long jMax = java.lang.Math.max(0L, this.f2322b.d_renamed - (aVar.d_renamed ? 0L : this.f2322b.e_renamed - (aVar.f2325b + aVar.f2326c)));
                if (aVar.d_renamed) {
                    jMin = jMax % aVar.f2326c;
                } else {
                    jMin = java.lang.Math.min(jMax, aVar.f2326c);
                    int i_renamed = (jMin > aVar.f2326c ? 1 : (jMin == aVar.f2326c ? 0 : -1));
                }
                f2 = 1.0f - (jMin / aVar.f2326c);
            } else {
                f2 = f_renamed;
            }
            com.b_renamed.a_renamed.b_renamed.d_renamed("AnimGroup", "ratio:" + f2);
            aVar.f2324a.a_renamed(f2);
            if (f2 == 1.0f) {
                aVar.f2324a.d_renamed();
                aVar.e_renamed = false;
            }
        }
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void d_renamed() {
        a_renamed(new java.util.function.Consumer() { // from class: com.b_renamed.a_renamed.a_renamed.-$$Lambda$c_renamed$XBWLyOfRu-PObRwpEZ4GUB4XRDA
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed((com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.b_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar) {
        if (aVar.e_renamed) {
            aVar.f2324a.d_renamed();
            aVar.e_renamed = false;
        }
    }

    /* compiled from: AnimGroup.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.b_renamed.a_renamed.a_renamed.j_renamed f2324a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f2325b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f2326c;
        boolean d_renamed;
        boolean e_renamed = false;

        a_renamed(com.b_renamed.a_renamed.a_renamed.j_renamed jVar, int i_renamed, int i2, boolean z_renamed) {
            this.f2324a = jVar;
            this.f2325b = i_renamed;
            this.f2326c = i2;
            this.d_renamed = z_renamed;
        }
    }
}
