package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: ContentGroup.java */
/* loaded from: classes2.dex */
public class d_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.a_renamed.m_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2, com.oplus.anim.c_renamed.g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f3462a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Path f3463b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.RectF f3464c;
    private final java.lang.String d_renamed;
    private final boolean e_renamed;
    private final java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> f_renamed;
    private final com.oplus.anim.b_renamed g_renamed;
    private java.util.List<com.oplus.anim.a_renamed.a_renamed.m_renamed> h_renamed;
    private com.oplus.anim.a_renamed.b_renamed.o_renamed i_renamed;

    public d_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.n_renamed nVar) {
        this(bVar, aVar, nVar.a_renamed(), nVar.c_renamed(), a_renamed(bVar, aVar, nVar.b_renamed()), a_renamed(nVar.b_renamed()));
    }

    d_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, java.lang.String str, boolean z_renamed, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, com.oplus.anim.c_renamed.a_renamed.l_renamed lVar) {
        this.f3462a = new android.graphics.Matrix();
        this.f3463b = new android.graphics.Path();
        this.f3464c = new android.graphics.RectF();
        this.d_renamed = str;
        this.g_renamed = bVar;
        this.e_renamed = z_renamed;
        this.f_renamed = list;
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::name = " + str + this);
        }
        if (lVar != null) {
            this.i_renamed = lVar.j_renamed();
            this.i_renamed.a_renamed(aVar);
            this.i_renamed.a_renamed(this);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list.get(size);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.j_renamed) {
                arrayList.add((com.oplus.anim.a_renamed.a_renamed.j_renamed) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((com.oplus.anim.a_renamed.a_renamed.j_renamed) arrayList.get(size2)).a_renamed(list.listIterator(list.size()));
        }
    }

    private static java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, java.util.List<com.oplus.anim.c_renamed.b_renamed.b_renamed> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::contentsFromModels()::contentModels.size() = " + list.size());
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVarA = list.get(i_renamed).a_renamed(bVar, aVar);
            if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::contentsFromModels()::content + " + i_renamed);
            }
            if (cVarA != null) {
                if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::contentsFromModels()::content = " + cVarA.toString());
                }
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    static com.oplus.anim.c_renamed.a_renamed.l_renamed a_renamed(java.util.List<com.oplus.anim.c_renamed.b_renamed.b_renamed> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.anim.c_renamed.b_renamed.b_renamed bVar = list.get(i_renamed);
            if (bVar instanceof com.oplus.anim.c_renamed.a_renamed.l_renamed) {
                if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::findTransform()::contentModel = " + bVar);
                }
                return (com.oplus.anim.c_renamed.a_renamed.l_renamed) bVar;
            }
        }
        return null;
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        this.g_renamed.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size() + this.f_renamed.size());
        arrayList.addAll(list);
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(size);
            cVar.a_renamed(arrayList, this.f_renamed.subList(0, size));
            arrayList.add(cVar);
        }
    }

    java.util.List<com.oplus.anim.a_renamed.a_renamed.m_renamed> c_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = new java.util.ArrayList();
            for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
                com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(i_renamed);
                if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.m_renamed) {
                    this.h_renamed.add((com.oplus.anim.a_renamed.a_renamed.m_renamed) cVar);
                }
            }
        }
        return this.h_renamed;
    }

    android.graphics.Matrix d_renamed() {
        com.oplus.anim.a_renamed.b_renamed.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            return oVar.d_renamed();
        }
        this.f3462a.reset();
        return this.f3462a;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        this.f3462a.reset();
        com.oplus.anim.a_renamed.b_renamed.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            this.f3462a.set(oVar.d_renamed());
        }
        this.f3463b.reset();
        if (this.e_renamed) {
            return this.f3463b;
        }
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(size);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.m_renamed) {
                this.f3463b.addPath(((com.oplus.anim.a_renamed.a_renamed.m_renamed) cVar).e_renamed(), this.f3462a);
            }
        }
        return this.f3463b;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.e_renamed) {
            return;
        }
        com.oplus.anim.k_renamed.c_renamed("ContentGroup#draw");
        this.f3462a.set(matrix);
        com.oplus.anim.a_renamed.b_renamed.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            this.f3462a.preConcat(oVar.d_renamed());
            i_renamed = (int) (((((this.i_renamed.a_renamed() == null ? 100 : this.i_renamed.a_renamed().g_renamed().intValue()) / 100.0f) * i_renamed) / 255.0f) * 255.0f);
        }
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(size);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.e_renamed) {
                if (com.oplus.anim.f_renamed.f_renamed.f3676a) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::draw() content = " + ((com.oplus.anim.a_renamed.a_renamed.e_renamed) cVar).b_renamed());
                }
                ((com.oplus.anim.a_renamed.a_renamed.e_renamed) cVar).a_renamed(canvas, this.f3462a, i_renamed);
            }
        }
        com.oplus.anim.k_renamed.d_renamed("ContentGroup#draw");
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.f3462a.set(matrix);
        com.oplus.anim.a_renamed.b_renamed.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            this.f3462a.preConcat(oVar.d_renamed());
        }
        this.f3464c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(size);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.e_renamed) {
                ((com.oplus.anim.a_renamed.a_renamed.e_renamed) cVar).a_renamed(this.f3464c, this.f3462a, z_renamed);
                rectF.union(this.f3464c);
            }
        }
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::resolveChildKeyPath()");
        }
        if (fVar.a_renamed(b_renamed(), i_renamed)) {
            if (!"__container".equals(b_renamed())) {
                fVar2 = fVar2.a_renamed(b_renamed());
                if (fVar.c_renamed(b_renamed(), i_renamed)) {
                    if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                        com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::resolveChildKeyPath():name = " + b_renamed());
                    }
                    list.add(fVar2.a_renamed(this));
                }
            }
            if (fVar.d_renamed(b_renamed(), i_renamed)) {
                int iB = i_renamed + fVar.b_renamed(b_renamed(), i_renamed);
                for (int i2 = 0; i2 < this.f_renamed.size(); i2++) {
                    com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = this.f_renamed.get(i2);
                    if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                        com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::resolveChildKeyPath()");
                    }
                    if (cVar instanceof com.oplus.anim.c_renamed.g_renamed) {
                        com.oplus.anim.c_renamed.g_renamed gVar = (com.oplus.anim.c_renamed.g_renamed) cVar;
                        if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                            com.oplus.anim.f_renamed.f_renamed.b_renamed("ContentGroup::resolveChildKeyPath()");
                        }
                        gVar.a_renamed(fVar, iB, list, fVar2);
                    }
                }
            }
        }
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        com.oplus.anim.a_renamed.b_renamed.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            oVar.a_renamed(t_renamed, bVar);
        }
    }
}
