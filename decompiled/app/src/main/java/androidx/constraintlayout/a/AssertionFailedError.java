package androidx.constraintlayout.a_renamed;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b_renamed implements androidx.constraintlayout.a_renamed.e_renamed.a_renamed {
    public final androidx.constraintlayout.a_renamed.a_renamed d_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.h_renamed f732a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    float f733b = 0.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    boolean f734c = false;
    boolean e_renamed = false;

    public b_renamed(androidx.constraintlayout.a_renamed.c_renamed cVar) {
        this.d_renamed = new androidx.constraintlayout.a_renamed.a_renamed(this, cVar);
    }

    boolean a_renamed() {
        androidx.constraintlayout.a_renamed.h_renamed hVar = this.f732a;
        return hVar != null && (hVar.f_renamed == androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED || this.f733b >= 0.0f);
    }

    public java.lang.String toString() {
        return b_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String b_renamed() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.b_renamed.b_renamed():java.lang.String");
    }

    public void c_renamed() {
        this.f732a = null;
        this.d_renamed.a_renamed();
        this.f733b = 0.0f;
        this.e_renamed = false;
    }

    boolean a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        return this.d_renamed.a_renamed(hVar);
    }

    androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, int i_renamed) {
        this.f732a = hVar;
        float f_renamed = i_renamed;
        hVar.d_renamed = f_renamed;
        this.f733b = f_renamed;
        this.e_renamed = true;
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, int i_renamed) {
        if (i_renamed < 0) {
            this.f733b = i_renamed * (-1);
            this.d_renamed.a_renamed(hVar, 1.0f);
        } else {
            this.f733b = i_renamed;
            this.d_renamed.a_renamed(hVar, -1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed) {
        boolean z_renamed = false;
        if (i_renamed != 0) {
            if (i_renamed < 0) {
                i_renamed *= -1;
                z_renamed = true;
            }
            this.f733b = i_renamed;
        }
        if (!z_renamed) {
            this.d_renamed.a_renamed(hVar, -1.0f);
            this.d_renamed.a_renamed(hVar2, 1.0f);
        } else {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
        }
        return this;
    }

    androidx.constraintlayout.a_renamed.b_renamed c_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, int i_renamed) {
        this.d_renamed.a_renamed(hVar, i_renamed);
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, int i_renamed) {
        boolean z_renamed = false;
        if (i_renamed != 0) {
            if (i_renamed < 0) {
                i_renamed *= -1;
                z_renamed = true;
            }
            this.f733b = i_renamed;
        }
        if (!z_renamed) {
            this.d_renamed.a_renamed(hVar, -1.0f);
            this.d_renamed.a_renamed(hVar2, 1.0f);
            this.d_renamed.a_renamed(hVar3, 1.0f);
        } else {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.d_renamed.a_renamed(hVar3, -1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, int i_renamed) {
        boolean z_renamed = false;
        if (i_renamed != 0) {
            if (i_renamed < 0) {
                i_renamed *= -1;
                z_renamed = true;
            }
            this.f733b = i_renamed;
        }
        if (!z_renamed) {
            this.d_renamed.a_renamed(hVar, -1.0f);
            this.d_renamed.a_renamed(hVar2, 1.0f);
            this.d_renamed.a_renamed(hVar3, -1.0f);
        } else {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.d_renamed.a_renamed(hVar3, 1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed a_renamed(float f_renamed, float f2, float f3, androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4) {
        this.f733b = 0.0f;
        if (f2 == 0.0f || f_renamed == f3) {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.d_renamed.a_renamed(hVar4, 1.0f);
            this.d_renamed.a_renamed(hVar3, -1.0f);
        } else if (f_renamed == 0.0f) {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.d_renamed.a_renamed(hVar3, 1.0f);
            this.d_renamed.a_renamed(hVar4, -1.0f);
        } else {
            float f4 = (f_renamed / f2) / (f3 / f2);
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.d_renamed.a_renamed(hVar4, f4);
            this.d_renamed.a_renamed(hVar3, -f4);
        }
        return this;
    }

    androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, int i_renamed, float f_renamed, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4, int i2) {
        if (hVar2 == hVar3) {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar4, 1.0f);
            this.d_renamed.a_renamed(hVar2, -2.0f);
            return this;
        }
        if (f_renamed == 0.5f) {
            this.d_renamed.a_renamed(hVar, 1.0f);
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.d_renamed.a_renamed(hVar3, -1.0f);
            this.d_renamed.a_renamed(hVar4, 1.0f);
            if (i_renamed > 0 || i2 > 0) {
                this.f733b = (-i_renamed) + i2;
            }
        } else if (f_renamed <= 0.0f) {
            this.d_renamed.a_renamed(hVar, -1.0f);
            this.d_renamed.a_renamed(hVar2, 1.0f);
            this.f733b = i_renamed;
        } else if (f_renamed >= 1.0f) {
            this.d_renamed.a_renamed(hVar3, -1.0f);
            this.d_renamed.a_renamed(hVar4, 1.0f);
            this.f733b = i2;
        } else {
            float f2 = 1.0f - f_renamed;
            this.d_renamed.a_renamed(hVar, f2 * 1.0f);
            this.d_renamed.a_renamed(hVar2, f2 * (-1.0f));
            this.d_renamed.a_renamed(hVar3, (-1.0f) * f_renamed);
            this.d_renamed.a_renamed(hVar4, 1.0f * f_renamed);
            if (i_renamed > 0 || i2 > 0) {
                this.f733b = ((-i_renamed) * f2) + (i2 * f_renamed);
            }
        }
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar, int i_renamed) {
        this.d_renamed.a_renamed(eVar.a_renamed(i_renamed, "ep_renamed"), 1.0f);
        this.d_renamed.a_renamed(eVar.a_renamed(i_renamed, "em_renamed"), -1.0f);
        return this;
    }

    androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, float f_renamed) {
        this.d_renamed.a_renamed(hVar, -1.0f);
        this.d_renamed.a_renamed(hVar2, 1.0f - f_renamed);
        this.d_renamed.a_renamed(hVar3, f_renamed);
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4, float f_renamed) {
        this.d_renamed.a_renamed(hVar, -1.0f);
        this.d_renamed.a_renamed(hVar2, 1.0f);
        this.d_renamed.a_renamed(hVar3, f_renamed);
        this.d_renamed.a_renamed(hVar4, -f_renamed);
        return this;
    }

    public androidx.constraintlayout.a_renamed.b_renamed b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.h_renamed hVar2, androidx.constraintlayout.a_renamed.h_renamed hVar3, androidx.constraintlayout.a_renamed.h_renamed hVar4, float f_renamed) {
        this.d_renamed.a_renamed(hVar3, 0.5f);
        this.d_renamed.a_renamed(hVar4, 0.5f);
        this.d_renamed.a_renamed(hVar, -0.5f);
        this.d_renamed.a_renamed(hVar2, -0.5f);
        this.f733b = -f_renamed;
        return this;
    }

    void d_renamed() {
        float f_renamed = this.f733b;
        if (f_renamed < 0.0f) {
            this.f733b = f_renamed * (-1.0f);
            this.d_renamed.b_renamed();
        }
    }

    boolean a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        boolean z_renamed;
        androidx.constraintlayout.a_renamed.h_renamed hVarA = this.d_renamed.a_renamed(eVar);
        if (hVarA == null) {
            z_renamed = true;
        } else {
            c_renamed(hVarA);
            z_renamed = false;
        }
        if (this.d_renamed.f702a == 0) {
            this.e_renamed = true;
        }
        return z_renamed;
    }

    androidx.constraintlayout.a_renamed.h_renamed b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        return this.d_renamed.a_renamed((boolean[]) null, hVar);
    }

    void c_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        androidx.constraintlayout.a_renamed.h_renamed hVar2 = this.f732a;
        if (hVar2 != null) {
            this.d_renamed.a_renamed(hVar2, -1.0f);
            this.f732a = null;
        }
        float fA_renamed = this.d_renamed.a_renamed(hVar, true) * (-1.0f);
        this.f732a = hVar;
        if (fA_renamed == 1.0f) {
            return;
        }
        this.f733b /= fA_renamed;
        this.d_renamed.a_renamed(fA_renamed);
    }

    public boolean e_renamed() {
        return this.f732a == null && this.f733b == 0.0f && this.d_renamed.f702a == 0;
    }

    @Override // androidx.constraintlayout.a_renamed.e_renamed.a_renamed
    public androidx.constraintlayout.a_renamed.h_renamed a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar, boolean[] zArr) {
        return this.d_renamed.a_renamed(zArr, (androidx.constraintlayout.a_renamed.h_renamed) null);
    }

    @Override // androidx.constraintlayout.a_renamed.e_renamed.a_renamed
    public void f_renamed() {
        this.d_renamed.a_renamed();
        this.f732a = null;
        this.f733b = 0.0f;
    }

    @Override // androidx.constraintlayout.a_renamed.e_renamed.a_renamed
    public void a_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed aVar) {
        if (aVar instanceof androidx.constraintlayout.a_renamed.b_renamed) {
            androidx.constraintlayout.a_renamed.b_renamed bVar = (androidx.constraintlayout.a_renamed.b_renamed) aVar;
            this.f732a = null;
            this.d_renamed.a_renamed();
            for (int i_renamed = 0; i_renamed < bVar.d_renamed.f702a; i_renamed++) {
                this.d_renamed.a_renamed(bVar.d_renamed.a_renamed(i_renamed), bVar.d_renamed.b_renamed(i_renamed), true);
            }
        }
    }

    @Override // androidx.constraintlayout.a_renamed.e_renamed.a_renamed
    public void d_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        float f_renamed = 1.0f;
        if (hVar.f748c != 1) {
            if (hVar.f748c == 2) {
                f_renamed = 1000.0f;
            } else if (hVar.f748c == 3) {
                f_renamed = 1000000.0f;
            } else if (hVar.f748c == 4) {
                f_renamed = 1.0E9f;
            } else if (hVar.f748c == 5) {
                f_renamed = 1.0E12f;
            }
        }
        this.d_renamed.a_renamed(hVar, f_renamed);
    }

    @Override // androidx.constraintlayout.a_renamed.e_renamed.a_renamed
    public androidx.constraintlayout.a_renamed.h_renamed g_renamed() {
        return this.f732a;
    }
}
