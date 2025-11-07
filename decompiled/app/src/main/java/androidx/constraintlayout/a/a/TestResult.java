package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ConstraintWidgetGroup.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> f717a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f718b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f719c;
    public boolean d_renamed;
    public final int[] e_renamed;
    java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> f_renamed;
    java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> g_renamed;
    java.util.HashSet<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> h_renamed;
    java.util.HashSet<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> i_renamed;
    java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> j_renamed;
    java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> k_renamed;

    h_renamed(java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> list) {
        this.f718b = -1;
        this.f719c = -1;
        this.d_renamed = false;
        this.e_renamed = new int[]{this.f718b, this.f719c};
        this.f_renamed = new java.util.ArrayList();
        this.g_renamed = new java.util.ArrayList();
        this.h_renamed = new java.util.HashSet<>();
        this.i_renamed = new java.util.HashSet<>();
        this.j_renamed = new java.util.ArrayList();
        this.k_renamed = new java.util.ArrayList();
        this.f717a = list;
    }

    h_renamed(java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> list, boolean z_renamed) {
        this.f718b = -1;
        this.f719c = -1;
        this.d_renamed = false;
        this.e_renamed = new int[]{this.f718b, this.f719c};
        this.f_renamed = new java.util.ArrayList();
        this.g_renamed = new java.util.ArrayList();
        this.h_renamed = new java.util.HashSet<>();
        this.i_renamed = new java.util.HashSet<>();
        this.j_renamed = new java.util.ArrayList();
        this.k_renamed = new java.util.ArrayList();
        this.f717a = list;
        this.d_renamed = z_renamed;
    }

    public java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.f_renamed;
        }
        if (i_renamed == 1) {
            return this.g_renamed;
        }
        return null;
    }

    java.util.Set<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> b_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.h_renamed;
        }
        if (i_renamed == 1) {
            return this.i_renamed;
        }
        return null;
    }

    void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed) {
        if (i_renamed == 0) {
            this.h_renamed.add(fVar);
        } else if (i_renamed == 1) {
            this.i_renamed.add(fVar);
        }
    }

    java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> a_renamed() {
        if (!this.j_renamed.isEmpty()) {
            return this.j_renamed;
        }
        int size = this.f717a.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.f717a.get(i_renamed);
            if (!fVar.W_renamed) {
                a_renamed((java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed>) this.j_renamed, fVar);
            }
        }
        this.k_renamed.clear();
        this.k_renamed.addAll(this.f717a);
        this.k_renamed.removeAll(this.j_renamed);
        return this.j_renamed;
    }

    private void a_renamed(java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> arrayList, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        if (fVar.Y_renamed) {
            return;
        }
        arrayList.add(fVar);
        fVar.Y_renamed = true;
        if (fVar.i_renamed()) {
            return;
        }
        if (fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.j_renamed) {
            androidx.constraintlayout.a_renamed.a_renamed.j_renamed jVar = (androidx.constraintlayout.a_renamed.a_renamed.j_renamed) fVar;
            int i_renamed = jVar.aj_renamed;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                a_renamed(arrayList, jVar.ai_renamed[i2]);
            }
        }
        int length = fVar.A_renamed.length;
        for (int i3 = 0; i3 < length; i3++) {
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = fVar.A_renamed[i3].f710c;
            if (eVar != null) {
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar2 = eVar.f708a;
                if (eVar != null && fVar2 != fVar.l_renamed()) {
                    a_renamed(arrayList, fVar2);
                }
            }
        }
    }

    void b_renamed() {
        int size = this.k_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(this.k_renamed.get(i_renamed));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed r7) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.h_renamed.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed):void");
    }
}
