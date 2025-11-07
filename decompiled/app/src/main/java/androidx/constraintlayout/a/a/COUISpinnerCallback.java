package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Snapshot.java */
/* loaded from: classes.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f726a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f727b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f728c;
    private int d_renamed;
    private java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.p_renamed.a_renamed> e_renamed = new java.util.ArrayList<>();

    /* compiled from: Snapshot.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private androidx.constraintlayout.a_renamed.a_renamed.e_renamed f729a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.constraintlayout.a_renamed.a_renamed.e_renamed f730b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f731c;
        private androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed d_renamed;
        private int e_renamed;

        public a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar) {
            this.f729a = eVar;
            this.f730b = eVar.g_renamed();
            this.f731c = eVar.e_renamed();
            this.d_renamed = eVar.f_renamed();
            this.e_renamed = eVar.h_renamed();
        }

        public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
            this.f729a = fVar.a_renamed(this.f729a.d_renamed());
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = this.f729a;
            if (eVar != null) {
                this.f730b = eVar.g_renamed();
                this.f731c = this.f729a.e_renamed();
                this.d_renamed = this.f729a.f_renamed();
                this.e_renamed = this.f729a.h_renamed();
                return;
            }
            this.f730b = null;
            this.f731c = 0;
            this.d_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.STRONG;
            this.e_renamed = 0;
        }

        public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
            fVar.a_renamed(this.f729a.d_renamed()).a_renamed(this.f730b, this.f731c, this.d_renamed, this.e_renamed);
        }
    }

    public p_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        this.f726a = fVar.o_renamed();
        this.f727b = fVar.p_renamed();
        this.f728c = fVar.q_renamed();
        this.d_renamed = fVar.s_renamed();
        java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.e_renamed> arrayListD = fVar.D_renamed();
        int size = arrayListD.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.e_renamed.add(new androidx.constraintlayout.a_renamed.a_renamed.p_renamed.a_renamed(arrayListD.get(i_renamed)));
        }
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        this.f726a = fVar.o_renamed();
        this.f727b = fVar.p_renamed();
        this.f728c = fVar.q_renamed();
        this.d_renamed = fVar.s_renamed();
        int size = this.e_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.e_renamed.get(i_renamed).a_renamed(fVar);
        }
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        fVar.h_renamed(this.f726a);
        fVar.i_renamed(this.f727b);
        fVar.j_renamed(this.f728c);
        fVar.k_renamed(this.d_renamed);
        int size = this.e_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.e_renamed.get(i_renamed).b_renamed(fVar);
        }
    }
}
