package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d_renamed implements com.airbnb.lottie.a_renamed.a_renamed.e_renamed, com.airbnb.lottie.a_renamed.a_renamed.m_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4, com.airbnb.lottie.c_renamed.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f1994a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.RectF f1995b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f1996c;
    private final android.graphics.Path d_renamed;
    private final android.graphics.RectF e_renamed;
    private final java.lang.String f_renamed;
    private final boolean g_renamed;
    private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> h_renamed;
    private final com.airbnb.lottie.f_renamed i_renamed;
    private java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> j_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.o_renamed k_renamed;

    private static java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, java.util.List<com.airbnb.lottie.c_renamed.b_renamed.b_renamed> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVarA = list.get(i_renamed).a_renamed(fVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    static com.airbnb.lottie.c_renamed.a_renamed.l_renamed a_renamed(java.util.List<com.airbnb.lottie.c_renamed.b_renamed.b_renamed> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.airbnb.lottie.c_renamed.b_renamed.b_renamed bVar = list.get(i_renamed);
            if (bVar instanceof com.airbnb.lottie.c_renamed.a_renamed.l_renamed) {
                return (com.airbnb.lottie.c_renamed.a_renamed.l_renamed) bVar;
            }
        }
        return null;
    }

    public d_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.n_renamed nVar) {
        this(fVar, aVar, nVar.a_renamed(), nVar.c_renamed(), a_renamed(fVar, aVar, nVar.b_renamed()), a_renamed(nVar.b_renamed()));
    }

    d_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, java.lang.String str, boolean z_renamed, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, com.airbnb.lottie.c_renamed.a_renamed.l_renamed lVar) {
        this.f1994a = new com.airbnb.lottie.a_renamed.a_renamed();
        this.f1995b = new android.graphics.RectF();
        this.f1996c = new android.graphics.Matrix();
        this.d_renamed = new android.graphics.Path();
        this.e_renamed = new android.graphics.RectF();
        this.f_renamed = str;
        this.i_renamed = fVar;
        this.g_renamed = z_renamed;
        this.h_renamed = list;
        if (lVar != null) {
            this.k_renamed = lVar.j_renamed();
            this.k_renamed.a_renamed(aVar);
            this.k_renamed.a_renamed(this);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list.get(size);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.j_renamed) {
                arrayList.add((com.airbnb.lottie.a_renamed.a_renamed.j_renamed) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((com.airbnb.lottie.a_renamed.a_renamed.j_renamed) arrayList.get(size2)).a_renamed(list.listIterator(list.size()));
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        this.i_renamed.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size() + this.h_renamed.size());
        arrayList.addAll(list);
        for (int size = this.h_renamed.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(size);
            cVar.a_renamed(arrayList, this.h_renamed.subList(0, size));
            arrayList.add(cVar);
        }
    }

    java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> c_renamed() {
        if (this.j_renamed == null) {
            this.j_renamed = new java.util.ArrayList();
            for (int i_renamed = 0; i_renamed < this.h_renamed.size(); i_renamed++) {
                com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(i_renamed);
                if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed) {
                    this.j_renamed.add((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) cVar);
                }
            }
        }
        return this.j_renamed;
    }

    android.graphics.Matrix d_renamed() {
        com.airbnb.lottie.a_renamed.b_renamed.o_renamed oVar = this.k_renamed;
        if (oVar != null) {
            return oVar.d_renamed();
        }
        this.f1996c.reset();
        return this.f1996c;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        this.f1996c.reset();
        com.airbnb.lottie.a_renamed.b_renamed.o_renamed oVar = this.k_renamed;
        if (oVar != null) {
            this.f1996c.set(oVar.d_renamed());
        }
        this.d_renamed.reset();
        if (this.g_renamed) {
            return this.d_renamed;
        }
        for (int size = this.h_renamed.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(size);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed) {
                this.d_renamed.addPath(((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) cVar).e_renamed(), this.f1996c);
            }
        }
        return this.d_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.g_renamed) {
            return;
        }
        this.f1996c.set(matrix);
        com.airbnb.lottie.a_renamed.b_renamed.o_renamed oVar = this.k_renamed;
        if (oVar != null) {
            this.f1996c.preConcat(oVar.d_renamed());
            i_renamed = (int) (((((this.k_renamed.a_renamed() == null ? 100 : this.k_renamed.a_renamed().g_renamed().intValue()) / 100.0f) * i_renamed) / 255.0f) * 255.0f);
        }
        boolean z_renamed = this.i_renamed.d_renamed() && f_renamed() && i_renamed != 255;
        if (z_renamed) {
            this.f1995b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a_renamed(this.f1995b, this.f1996c, true);
            this.f1994a.setAlpha(i_renamed);
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.f1995b, this.f1994a);
        }
        if (z_renamed) {
            i_renamed = 255;
        }
        for (int size = this.h_renamed.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(size);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.e_renamed) {
                ((com.airbnb.lottie.a_renamed.a_renamed.e_renamed) cVar).a_renamed(canvas, this.f1996c, i_renamed);
            }
        }
        if (z_renamed) {
            canvas.restore();
        }
    }

    private boolean f_renamed() {
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.h_renamed.size(); i2++) {
            if ((this.h_renamed.get(i2) instanceof com.airbnb.lottie.a_renamed.a_renamed.e_renamed) && (i_renamed = i_renamed + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.f1996c.set(matrix);
        com.airbnb.lottie.a_renamed.b_renamed.o_renamed oVar = this.k_renamed;
        if (oVar != null) {
            this.f1996c.preConcat(oVar.d_renamed());
        }
        this.e_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h_renamed.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(size);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.e_renamed) {
                ((com.airbnb.lottie.a_renamed.a_renamed.e_renamed) cVar).a_renamed(this.e_renamed, this.f1996c, z_renamed);
                rectF.union(this.e_renamed);
            }
        }
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        if (eVar.a_renamed(b_renamed(), i_renamed) || "__container".equals(b_renamed())) {
            if (!"__container".equals(b_renamed())) {
                eVar2 = eVar2.a_renamed(b_renamed());
                if (eVar.c_renamed(b_renamed(), i_renamed)) {
                    list.add(eVar2.a_renamed(this));
                }
            }
            if (eVar.d_renamed(b_renamed(), i_renamed)) {
                int iB = i_renamed + eVar.b_renamed(b_renamed(), i_renamed);
                for (int i2 = 0; i2 < this.h_renamed.size(); i2++) {
                    com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = this.h_renamed.get(i2);
                    if (cVar instanceof com.airbnb.lottie.c_renamed.f_renamed) {
                        ((com.airbnb.lottie.c_renamed.f_renamed) cVar).a_renamed(eVar, iB, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        com.airbnb.lottie.a_renamed.b_renamed.o_renamed oVar = this.k_renamed;
        if (oVar != null) {
            oVar.a_renamed(t_renamed, cVar);
        }
    }
}
