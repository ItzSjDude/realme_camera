package androidx.constraintlayout.a_renamed;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class e_renamed {
    public static androidx.constraintlayout.a_renamed.f_renamed g_renamed = null;
    private static int h_renamed = 1000;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.b_renamed[] f739b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public boolean f740c;
    int d_renamed;
    int e_renamed;
    final androidx.constraintlayout.a_renamed.c_renamed f_renamed;
    private androidx.constraintlayout.a_renamed.e_renamed.a_renamed j_renamed;
    private int l_renamed;
    private boolean[] m_renamed;
    private int n_renamed;
    private androidx.constraintlayout.a_renamed.h_renamed[] o_renamed;
    private int p_renamed;
    private androidx.constraintlayout.a_renamed.b_renamed[] q_renamed;
    private final androidx.constraintlayout.a_renamed.e_renamed.a_renamed r_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    int f738a = 0;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.a_renamed.h_renamed> i_renamed = null;
    private int k_renamed = 32;

    /* compiled from: LinearSystem.java */
    interface a_renamed {
        androidx.constraintlayout.a_renamed.h_renamed a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar, boolean[] zArr);

        void a_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed aVar);

        void d_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar);

        void f_renamed();

        androidx.constraintlayout.a_renamed.h_renamed g_renamed();
    }

    public e_renamed() {
        int i_renamed = this.k_renamed;
        this.l_renamed = i_renamed;
        this.f739b = null;
        this.f740c = false;
        this.m_renamed = new boolean[i_renamed];
        this.d_renamed = 1;
        this.e_renamed = 0;
        this.n_renamed = i_renamed;
        this.o_renamed = new androidx.constraintlayout.a_renamed.h_renamed[h_renamed];
        this.p_renamed = 0;
        this.q_renamed = new androidx.constraintlayout.a_renamed.b_renamed[i_renamed];
        this.f739b = new androidx.constraintlayout.a_renamed.b_renamed[i_renamed];
        i_renamed();
        this.f_renamed = new androidx.constraintlayout.a_renamed.c_renamed();
        this.j_renamed = new androidx.constraintlayout.a_renamed.d_renamed(this.f_renamed);
        this.r_renamed = new androidx.constraintlayout.a_renamed.b_renamed(this.f_renamed);
    }

    public static androidx.constraintlayout.a_renamed.f_renamed a_renamed() {
        return g_renamed;
    }

    private void h_renamed() {
        this.k_renamed *= 2;
        this.f739b = (androidx.constraintlayout.a_renamed.b_renamed[]) java.util.Arrays.copyOf(this.f739b, this.k_renamed);
        androidx.constraintlayout.a_renamed.c_renamed cVar = this.f_renamed;
        cVar.f737c = (androidx.constraintlayout.a_renamed.h_renamed[]) java.util.Arrays.copyOf(cVar.f737c, this.k_renamed);
        int i_renamed = this.k_renamed;
        this.m_renamed = new boolean[i_renamed];
        this.l_renamed = i_renamed;
        this.n_renamed = i_renamed;
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.d_renamed++;
            androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
            fVar2.p_renamed = java.lang.Math.max(fVar2.p_renamed, this.k_renamed);
            androidx.constraintlayout.a_renamed.f_renamed fVar3 = g_renamed;
            fVar3.D_renamed = fVar3.p_renamed;
        }
    }

    private void i_renamed() {
        int i_renamed = 0;
        while (true) {
            androidx.constraintlayout.a_renamed.b_renamed[] bVarArr = this.f739b;
            if (i_renamed >= bVarArr.length) {
                return;
            }
            androidx.constraintlayout.a_renamed.b_renamed bVar = bVarArr[i_renamed];
            if (bVar != null) {
                this.f_renamed.f735a.a_renamed(bVar);
            }
            this.f739b[i_renamed] = null;
            i_renamed++;
        }
    }

    public void b_renamed() {
        for (int i_renamed = 0; i_renamed < this.f_renamed.f737c.length; i_renamed++) {
            androidx.constraintlayout.a_renamed.h_renamed hVar = this.f_renamed.f737c[i_renamed];
            if (hVar != null) {
                hVar.b_renamed();
            }
        }
        this.f_renamed.f736b.a_renamed(this.o_renamed, this.p_renamed);
        this.p_renamed = 0;
        java.util.Arrays.fill(this.f_renamed.f737c, (java.lang.Object) null);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.a_renamed.h_renamed> map = this.i_renamed;
        if (map != null) {
            map.clear();
        }
        this.f738a = 0;
        this.j_renamed.f_renamed();
        this.d_renamed = 1;
        for (int i2 = 0; i2 < this.e_renamed; i2++) {
            this.f739b[i2].f734c = false;
        }
        i_renamed();
        this.e_renamed = 0;
    }

    public androidx.constraintlayout.a_renamed.h_renamed a_renamed(java.lang.Object obj) {
        androidx.constraintlayout.a_renamed.h_renamed hVarB = null;
        if (obj == null) {
            return null;
        }
        if (this.d_renamed + 1 >= this.l_renamed) {
            h_renamed();
        }
        if (obj instanceof androidx.constraintlayout.a_renamed.a_renamed.e_renamed) {
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = (androidx.constraintlayout.a_renamed.a_renamed.e_renamed) obj;
            hVarB = eVar.b_renamed();
            if (hVarB == null) {
                eVar.a_renamed(this.f_renamed);
                hVarB = eVar.b_renamed();
            }
            if (hVarB.f746a == -1 || hVarB.f746a > this.f738a || this.f_renamed.f737c[hVarB.f746a] == null) {
                if (hVarB.f746a != -1) {
                    hVarB.b_renamed();
                }
                this.f738a++;
                this.d_renamed++;
                hVarB.f746a = this.f738a;
                hVarB.f_renamed = androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED;
                this.f_renamed.f737c[this.f738a] = hVarB;
            }
        }
        return hVarB;
    }

    public androidx.constraintlayout.a_renamed.b_renamed c_renamed() {
        androidx.constraintlayout.a_renamed.b_renamed bVarA = this.f_renamed.f735a.a_renamed();
        if (bVarA == null) {
            bVarA = new androidx.constraintlayout.a_renamed.b_renamed(this.f_renamed);
        } else {
            bVarA.c_renamed();
        }
        androidx.constraintlayout.a_renamed.h_renamed.a_renamed();
        return bVarA;
    }

    public androidx.constraintlayout.a_renamed.h_renamed d_renamed() {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.n_renamed++;
        }
        if (this.d_renamed + 1 >= this.l_renamed) {
            h_renamed();
        }
        androidx.constraintlayout.a_renamed.h_renamed hVarA = a_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed.SLACK, (java.lang.String) null);
        this.f738a++;
        this.d_renamed++;
        hVarA.f746a = this.f738a;
        this.f_renamed.f737c[this.f738a] = hVarA;
        return hVarA;
    }

    public androidx.constraintlayout.a_renamed.h_renamed e_renamed() {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.o_renamed++;
        }
        if (this.d_renamed + 1 >= this.l_renamed) {
            h_renamed();
        }
        androidx.constraintlayout.a_renamed.h_renamed hVarA = a_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed.SLACK, (java.lang.String) null);
        this.f738a++;
        this.d_renamed++;
        hVarA.f746a = this.f738a;
        this.f_renamed.f737c[this.f738a] = hVarA;
        return hVarA;
    }

    private void b_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        bVar.a_renamed(this, 0);
    }

    void a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar, int i_renamed, int i2) {
        bVar.c_renamed(a_renamed(i2, (java.lang.String) null), i_renamed);
    }

    public androidx.constraintlayout.a_renamed.h_renamed a_renamed(int i_renamed, java.lang.String str) {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.m_renamed++;
        }
        if (this.d_renamed + 1 >= this.l_renamed) {
            h_renamed();
        }
        androidx.constraintlayout.a_renamed.h_renamed hVarA = a_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed.ERROR, str);
        this.f738a++;
        this.d_renamed++;
        hVarA.f746a = this.f738a;
        hVarA.f748c = i_renamed;
        this.f_renamed.f737c[this.f738a] = hVarA;
        this.j_renamed.d_renamed(hVarA);
        return hVarA;
    }

    private androidx.constraintlayout.a_renamed.h_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed aVar, java.lang.String str) {
        androidx.constraintlayout.a_renamed.h_renamed hVarA = this.f_renamed.f736b.a_renamed();
        if (hVarA == null) {
            hVarA = new androidx.constraintlayout.a_renamed.h_renamed(aVar, str);
            hVarA.a_renamed(aVar, str);
        } else {
            hVarA.b_renamed();
            hVarA.a_renamed(aVar, str);
        }
        int i_renamed = this.p_renamed;
        int i2 = h_renamed;
        if (i_renamed >= i2) {
            h_renamed = i2 * 2;
            this.o_renamed = (androidx.constraintlayout.a_renamed.h_renamed[]) java.util.Arrays.copyOf(this.o_renamed, h_renamed);
        }
        androidx.constraintlayout.a_renamed.h_renamed[] hVarArr = this.o_renamed;
        int i3 = this.p_renamed;
        this.p_renamed = i3 + 1;
        hVarArr[i3] = hVarA;
        return hVarA;
    }

    public int b_renamed(java.lang.Object obj) {
        androidx.constraintlayout.a_renamed.h_renamed hVarB = ((androidx.constraintlayout.a_renamed.a_renamed.e_renamed) obj).b_renamed();
        if (hVarB != null) {
            return (int) (hVarB.d_renamed + 0.5f);
        }
        return 0;
    }

    public void f_renamed() throws java.lang.Exception {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.e_renamed++;
        }
        if (this.f740c) {
            androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
            if (fVar2 != null) {
                fVar2.r_renamed++;
            }
            boolean z_renamed = false;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= this.e_renamed) {
                    z_renamed = true;
                    break;
                } else if (!this.f739b[i_renamed].e_renamed) {
                    break;
                } else {
                    i_renamed++;
                }
            }
            if (!z_renamed) {
                a_renamed(this.j_renamed);
                return;
            }
            androidx.constraintlayout.a_renamed.f_renamed fVar3 = g_renamed;
            if (fVar3 != null) {
                fVar3.q_renamed++;
            }
            j_renamed();
            return;
        }
        a_renamed(this.j_renamed);
    }

    void a_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed aVar) throws java.lang.Exception {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.t_renamed++;
            androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
            fVar2.u_renamed = java.lang.Math.max(fVar2.u_renamed, this.d_renamed);
            androidx.constraintlayout.a_renamed.f_renamed fVar3 = g_renamed;
            fVar3.v_renamed = java.lang.Math.max(fVar3.v_renamed, this.e_renamed);
        }
        c_renamed((androidx.constraintlayout.a_renamed.b_renamed) aVar);
        b_renamed(aVar);
        a_renamed(aVar, false);
        j_renamed();
    }

    private final void c_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        if (this.e_renamed > 0) {
            bVar.d_renamed.a_renamed(bVar, this.f739b);
            if (bVar.d_renamed.f702a == 0) {
                bVar.e_renamed = true;
            }
        }
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        androidx.constraintlayout.a_renamed.h_renamed hVarB;
        if (bVar == null) {
            return;
        }
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.f_renamed++;
            if (bVar.e_renamed) {
                g_renamed.g_renamed++;
            }
        }
        if (this.e_renamed + 1 >= this.n_renamed || this.d_renamed + 1 >= this.l_renamed) {
            h_renamed();
        }
        boolean z_renamed = false;
        if (!bVar.e_renamed) {
            c_renamed(bVar);
            if (bVar.e_renamed()) {
                return;
            }
            bVar.d_renamed();
            if (bVar.a_renamed(this)) {
                androidx.constraintlayout.a_renamed.h_renamed hVarE = e_renamed();
                bVar.f732a = hVarE;
                d_renamed(bVar);
                this.r_renamed.a_renamed(bVar);
                a_renamed(this.r_renamed, true);
                if (hVarE.f747b == -1) {
                    if (bVar.f732a == hVarE && (hVarB = bVar.b_renamed(hVarE)) != null) {
                        androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
                        if (fVar2 != null) {
                            fVar2.j_renamed++;
                        }
                        bVar.c_renamed(hVarB);
                    }
                    if (!bVar.e_renamed) {
                        bVar.f732a.c_renamed(bVar);
                    }
                    this.e_renamed--;
                }
                z_renamed = true;
            }
            if (!bVar.a_renamed()) {
                return;
            }
        }
        if (z_renamed) {
            return;
        }
        d_renamed(bVar);
    }

    private final void d_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        if (this.f739b[this.e_renamed] != null) {
            this.f_renamed.f735a.a_renamed(this.f739b[this.e_renamed]);
        }
        this.f739b[this.e_renamed] = bVar;
        androidx.constraintlayout.a_renamed.h_renamed hVar = bVar.f732a;
        int i_renamed = this.e_renamed;
        hVar.f747b = i_renamed;
        this.e_renamed = i_renamed + 1;
        bVar.f732a.c_renamed(bVar);
    }

    private final int a_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed aVar, boolean z_renamed) {
        androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
        if (fVar != null) {
            fVar.h_renamed++;
        }
        for (int i_renamed = 0; i_renamed < this.d_renamed; i_renamed++) {
            this.m_renamed[i_renamed] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
            if (fVar2 != null) {
                fVar2.i_renamed++;
            }
            i2++;
            if (i2 >= this.d_renamed * 2) {
                return i2;
            }
            if (aVar.g_renamed() != null) {
                this.m_renamed[aVar.g_renamed().f746a] = true;
            }
            androidx.constraintlayout.a_renamed.h_renamed hVarA = aVar.a_renamed(this, this.m_renamed);
            if (hVarA != null) {
                if (this.m_renamed[hVarA.f746a]) {
                    return i2;
                }
                this.m_renamed[hVarA.f746a] = true;
            }
            if (hVarA != null) {
                float f_renamed = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.e_renamed; i4++) {
                    androidx.constraintlayout.a_renamed.b_renamed bVar = this.f739b[i4];
                    if (bVar.f732a.f_renamed != androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED && !bVar.e_renamed && bVar.a_renamed(hVarA)) {
                        float fB_renamed = bVar.d_renamed.b_renamed(hVarA);
                        if (fB_renamed < 0.0f) {
                            float f2 = (-bVar.f733b) / fB_renamed;
                            if (f2 < f_renamed) {
                                i3 = i4;
                                f_renamed = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    androidx.constraintlayout.a_renamed.b_renamed bVar2 = this.f739b[i3];
                    bVar2.f732a.f747b = -1;
                    androidx.constraintlayout.a_renamed.f_renamed fVar3 = g_renamed;
                    if (fVar3 != null) {
                        fVar3.j_renamed++;
                    }
                    bVar2.c_renamed(hVarA);
                    bVar2.f732a.f747b = i3;
                    bVar2.f732a.c_renamed(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    private int b_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed aVar) throws java.lang.Exception {
        float f_renamed;
        boolean z_renamed;
        int i_renamed = 0;
        while (true) {
            f_renamed = 0.0f;
            if (i_renamed >= this.e_renamed) {
                z_renamed = false;
                break;
            }
            if (this.f739b[i_renamed].f732a.f_renamed != androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED && this.f739b[i_renamed].f733b < 0.0f) {
                z_renamed = true;
                break;
            }
            i_renamed++;
        }
        if (!z_renamed) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            androidx.constraintlayout.a_renamed.f_renamed fVar = g_renamed;
            if (fVar != null) {
                fVar.k_renamed++;
            }
            i2++;
            float f2 = Float.MAX_VALUE;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.e_renamed) {
                androidx.constraintlayout.a_renamed.b_renamed bVar = this.f739b[i5];
                if (bVar.f732a.f_renamed != androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED && !bVar.e_renamed && bVar.f733b < f_renamed) {
                    int i7 = 1;
                    while (i7 < this.d_renamed) {
                        androidx.constraintlayout.a_renamed.h_renamed hVar = this.f_renamed.f737c[i7];
                        float fB_renamed = bVar.d_renamed.b_renamed(hVar);
                        if (fB_renamed > f_renamed) {
                            int i8 = i6;
                            float f3 = f2;
                            int i9 = i4;
                            int i10 = i3;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f4 = hVar.e_renamed[i11] / fB_renamed;
                                if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i5;
                                    f3 = f4;
                                    i8 = i11;
                                }
                            }
                            i3 = i10;
                            i4 = i9;
                            f2 = f3;
                            i6 = i8;
                        }
                        i7++;
                        f_renamed = 0.0f;
                    }
                }
                i5++;
                f_renamed = 0.0f;
            }
            if (i3 != -1) {
                androidx.constraintlayout.a_renamed.b_renamed bVar2 = this.f739b[i3];
                bVar2.f732a.f747b = -1;
                androidx.constraintlayout.a_renamed.f_renamed fVar2 = g_renamed;
                if (fVar2 != null) {
                    fVar2.j_renamed++;
                }
                bVar2.c_renamed(this.f_renamed.f737c[i4]);
                bVar2.f732a.f747b = i3;
                bVar2.f732a.c_renamed(bVar2);
            } else {
                z2 = true;
            }
            if (i2 > this.d_renamed / 2) {
                z2 = true;
            }
            f_renamed = 0.0f;
        }
        return i2;
    }

    private void j_renamed() {
        for (int i_renamed = 0; i_renamed < this.e_renamed; i_renamed++) {
            androidx.constraintlayout.a_renamed.b_renamed bVar = this.f739b[i_renamed];
            bVar.f732a.d_renamed = bVar.f733b;
        }
    }

    public androidx.constraintlayout.a_renamed.c_renamed g_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed, int i2) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        androidx.constraintlayout.a_renamed.h_renamed hVarD = d_renamed();
        hVarD.f748c = 0;
        bVarC.a_renamed(hVar, hVar2, hVarD, i_renamed);
        if (i2 != 6) {
            a_renamed(bVarC, (int) (bVarC.d_renamed.b_renamed(hVarD) * (-1.0f)), i2);
        }
        a_renamed(bVarC);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, boolean z_renamed) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        androidx.constraintlayout.a_renamed.h_renamed hVarD = d_renamed();
        hVarD.f748c = 0;
        bVarC.a_renamed(hVar, hVar2, hVarD, 0);
        if (z_renamed) {
            a_renamed(bVarC, (int) (bVarC.d_renamed.b_renamed(hVarD) * (-1.0f)), 1);
        }
        a_renamed(bVarC);
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed, int i2) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        androidx.constraintlayout.a_renamed.h_renamed hVarD = d_renamed();
        hVarD.f748c = 0;
        bVarC.b_renamed(hVar, hVar2, hVarD, i_renamed);
        if (i2 != 6) {
            a_renamed(bVarC, (int) (bVarC.d_renamed.b_renamed(hVarD) * (-1.0f)), i2);
        }
        a_renamed(bVarC);
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, boolean z_renamed) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        androidx.constraintlayout.a_renamed.h_renamed hVarD = d_renamed();
        hVarD.f748c = 0;
        bVarC.b_renamed(hVar, hVar2, hVarD, 0);
        if (z_renamed) {
            a_renamed(bVarC, (int) (bVarC.d_renamed.b_renamed(hVarD) * (-1.0f)), 1);
        }
        a_renamed(bVarC);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed, float f_renamed, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4, int i2, int i3) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        bVarC.a_renamed(hVar, hVar2, i_renamed, f_renamed, hVar3, hVar4, i2);
        if (i3 != 6) {
            bVarC.a_renamed(this, i3);
        }
        a_renamed(bVarC);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4, float f_renamed, int i_renamed) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        bVarC.a_renamed(hVar, hVar2, hVar3, hVar4, f_renamed);
        if (i_renamed != 6) {
            bVarC.a_renamed(this, i_renamed);
        }
        a_renamed(bVarC);
    }

    public androidx.constraintlayout.a_renamed.b_renamed c_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed, int i2) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        bVarC.a_renamed(hVar, hVar2, i_renamed);
        if (i2 != 6) {
            bVarC.a_renamed(this, i2);
        }
        a_renamed(bVarC);
        return bVarC;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, int i_renamed) {
        int i2 = hVar.f747b;
        if (hVar.f747b != -1) {
            androidx.constraintlayout.a_renamed.b_renamed bVar = this.f739b[i2];
            if (bVar.e_renamed) {
                bVar.f733b = i_renamed;
                return;
            }
            if (bVar.d_renamed.f702a == 0) {
                bVar.e_renamed = true;
                bVar.f733b = i_renamed;
                return;
            } else {
                androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
                bVarC.b_renamed(hVar, i_renamed);
                a_renamed(bVarC);
                return;
            }
        }
        androidx.constraintlayout.a_renamed.b_renamed bVarC2 = c_renamed();
        bVarC2.a_renamed(hVar, i_renamed);
        a_renamed(bVarC2);
    }

    public static androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar, androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, float f_renamed, boolean z_renamed) {
        androidx.constraintlayout.a_renamed.b_renamed bVarC = eVar.c_renamed();
        if (z_renamed) {
            eVar.b_renamed(bVarC);
        }
        return bVarC.a_renamed(hVar, hVar2, hVar3, f_renamed);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar2, float f_renamed, int i_renamed) {
        androidx.constraintlayout.a_renamed.h_renamed hVarA = a_renamed(fVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT));
        androidx.constraintlayout.a_renamed.h_renamed hVarA2 = a_renamed(fVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP));
        androidx.constraintlayout.a_renamed.h_renamed hVarA3 = a_renamed(fVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT));
        androidx.constraintlayout.a_renamed.h_renamed hVarA4 = a_renamed(fVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM));
        androidx.constraintlayout.a_renamed.h_renamed hVarA5 = a_renamed(fVar2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT));
        androidx.constraintlayout.a_renamed.h_renamed hVarA6 = a_renamed(fVar2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP));
        androidx.constraintlayout.a_renamed.h_renamed hVarA7 = a_renamed(fVar2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT));
        androidx.constraintlayout.a_renamed.h_renamed hVarA8 = a_renamed(fVar2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM));
        androidx.constraintlayout.a_renamed.b_renamed bVarC = c_renamed();
        double d_renamed = f_renamed;
        double d2 = i_renamed;
        bVarC.b_renamed(hVarA2, hVarA4, hVarA6, hVarA8, (float) (java.lang.Math.sin(d_renamed) * d2));
        a_renamed(bVarC);
        androidx.constraintlayout.a_renamed.b_renamed bVarC2 = c_renamed();
        bVarC2.b_renamed(hVarA, hVarA3, hVarA5, hVarA7, (float) (java.lang.Math.cos(d_renamed) * d2));
        a_renamed(bVarC2);
    }
}
