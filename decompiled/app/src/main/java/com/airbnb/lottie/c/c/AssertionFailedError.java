package com.airbnb.lottie.c_renamed.c_renamed;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b_renamed extends com.airbnb.lottie.c_renamed.c_renamed.a_renamed {
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> e_renamed;
    private final java.util.List<com.airbnb.lottie.c_renamed.c_renamed.a_renamed> f_renamed;
    private final android.graphics.RectF g_renamed;
    private final android.graphics.RectF h_renamed;
    private android.graphics.Paint i_renamed;

    public b_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> list, com.airbnb.lottie.d_renamed dVar2) {
        int i_renamed;
        com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar;
        super(fVar, dVar);
        this.f_renamed = new java.util.ArrayList();
        this.g_renamed = new android.graphics.RectF();
        this.h_renamed = new android.graphics.RectF();
        this.i_renamed = new android.graphics.Paint();
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarU = dVar.u_renamed();
        if (bVarU != null) {
            this.e_renamed = bVarU.a_renamed();
            a_renamed(this.e_renamed);
            this.e_renamed.a_renamed(this);
        } else {
            this.e_renamed = null;
        }
        androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray(dVar2.i_renamed().size());
        int size = list.size() - 1;
        com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar3 = list.get(size);
            com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVarA = com.airbnb.lottie.c_renamed.c_renamed.a_renamed.a_renamed(dVar3, fVar, dVar2);
            if (aVarA != null) {
                longSparseArray.put(aVarA.c_renamed().e_renamed(), aVarA);
                if (aVar2 != null) {
                    aVar2.a_renamed(aVarA);
                    aVar2 = null;
                } else {
                    this.f_renamed.add(0, aVarA);
                    int i2 = com.airbnb.lottie.c_renamed.c_renamed.b_renamed.SceneLoader_2.f2123a[dVar3.l_renamed().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = aVarA;
                    }
                }
            }
            size--;
        }
        for (i_renamed = 0; i_renamed < longSparseArray.size(); i_renamed++) {
            com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar3 = (com.airbnb.lottie.c_renamed.c_renamed.a_renamed) longSparseArray.get(longSparseArray.keyAt(i_renamed));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.c_renamed.c_renamed.a_renamed) longSparseArray.get(aVar3.c_renamed().m_renamed())) != null) {
                aVar3.b_renamed(aVar);
            }
        }
    }

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.airbnb.lottie.c_renamed.c_renamed.b_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2123a = new int[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.values().length];

        static {
            try {
                f2123a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.ADD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2123a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.INVERT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    public void a_renamed(boolean z_renamed) {
        super.a_renamed(z_renamed);
        java.util.Iterator<com.airbnb.lottie.c_renamed.c_renamed.a_renamed> it = this.f_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(z_renamed);
        }
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.airbnb.lottie.c_renamed.a_renamed("CompositionLayer#draw");
        this.h_renamed.set(0.0f, 0.0f, this.f2119c.h_renamed(), this.f2119c.i_renamed());
        matrix.mapRect(this.h_renamed);
        boolean z_renamed = this.f2118b.d_renamed() && this.f_renamed.size() > 1 && i_renamed != 255;
        if (z_renamed) {
            this.i_renamed.setAlpha(i_renamed);
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.h_renamed, this.i_renamed);
        } else {
            canvas.save();
        }
        if (z_renamed) {
            i_renamed = 255;
        }
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            if (!this.h_renamed.isEmpty() ? canvas.clipRect(this.h_renamed) : true) {
                this.f_renamed.get(size).a_renamed(canvas, matrix, i_renamed);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c_renamed.b_renamed("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            this.g_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f_renamed.get(size).a_renamed(this.g_renamed, this.f2117a, true);
            rectF.union(this.g_renamed);
        }
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    public void a_renamed(float f_renamed) {
        super.a_renamed(f_renamed);
        if (this.e_renamed != null) {
            f_renamed = ((this.e_renamed.g_renamed().floatValue() * this.f2119c.a_renamed().h_renamed()) - this.f2119c.a_renamed().f_renamed()) / (this.f2118b.t_renamed().m_renamed() + 0.01f);
        }
        if (this.e_renamed == null) {
            f_renamed -= this.f2119c.c_renamed();
        }
        if (this.f2119c.b_renamed() != 0.0f) {
            f_renamed /= this.f2119c.b_renamed();
        }
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            this.f_renamed.get(size).a_renamed(f_renamed);
        }
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    protected void b_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        for (int i2 = 0; i2 < this.f_renamed.size(); i2++) {
            this.f_renamed.get(i2).a_renamed(eVar, i_renamed, list, eVar2);
        }
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        super.a_renamed((com.airbnb.lottie.c_renamed.c_renamed.b_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.c_renamed.c_renamed.b_renamed>) cVar);
        if (t_renamed == com.airbnb.lottie.k_renamed.C_renamed) {
            if (cVar == null) {
                com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar = this.e_renamed;
                if (aVar != null) {
                    aVar.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) null);
                    return;
                }
                return;
            }
            this.e_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.e_renamed.a_renamed(this);
            a_renamed(this.e_renamed);
        }
    }
}
