package com.a_renamed.a_renamed;

/* compiled from: BaseSpringSystem.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.a_renamed.a_renamed.i_renamed f1963c;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, com.a_renamed.a_renamed.f_renamed> f1961a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Set<com.a_renamed.a_renamed.f_renamed> f1962b = new java.util.concurrent.CopyOnWriteArraySet();
    private final java.util.concurrent.CopyOnWriteArraySet<com.a_renamed.a_renamed.k_renamed> d_renamed = new java.util.concurrent.CopyOnWriteArraySet<>();
    private boolean e_renamed = true;

    public b_renamed(com.a_renamed.a_renamed.i_renamed iVar) {
        if (iVar == null) {
            throw new java.lang.IllegalArgumentException("springLooper is_renamed required");
        }
        this.f1963c = iVar;
        this.f1963c.a_renamed(this);
    }

    public boolean a_renamed() {
        return this.e_renamed;
    }

    public com.a_renamed.a_renamed.f_renamed b_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = new com.a_renamed.a_renamed.f_renamed(this);
        a_renamed(fVar);
        return fVar;
    }

    void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
        if (fVar == null) {
            throw new java.lang.IllegalArgumentException("spring is_renamed required");
        }
        if (this.f1961a.containsKey(fVar.b_renamed())) {
            throw new java.lang.IllegalArgumentException("spring is_renamed already registered");
        }
        this.f1961a.put(fVar.b_renamed(), fVar);
    }

    void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
        if (fVar == null) {
            throw new java.lang.IllegalArgumentException("spring is_renamed required");
        }
        this.f1962b.remove(fVar);
        this.f1961a.remove(fVar.b_renamed());
    }

    void a_renamed(double d_renamed) {
        for (com.a_renamed.a_renamed.f_renamed fVar : this.f1962b) {
            if (fVar.g_renamed()) {
                fVar.d_renamed(d_renamed / 1000.0d);
            } else {
                this.f1962b.remove(fVar);
            }
        }
    }

    public void b_renamed(double d_renamed) {
        java.util.Iterator<com.a_renamed.a_renamed.k_renamed> it = this.d_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(this);
        }
        a_renamed(d_renamed);
        if (this.f1962b.isEmpty()) {
            this.e_renamed = true;
        }
        java.util.Iterator<com.a_renamed.a_renamed.k_renamed> it2 = this.d_renamed.iterator();
        while (it2.hasNext()) {
            it2.next().b_renamed(this);
        }
        if (this.e_renamed) {
            this.f1963c.c_renamed();
        }
    }

    void a_renamed(java.lang.String str) {
        com.a_renamed.a_renamed.f_renamed fVar = this.f1961a.get(str);
        if (fVar == null) {
            throw new java.lang.IllegalArgumentException("springId " + str + " does not reference a_renamed registered spring");
        }
        this.f1962b.add(fVar);
        if (a_renamed()) {
            this.e_renamed = false;
            this.f1963c.b_renamed();
        }
    }
}
