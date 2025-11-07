package com.oplus.anim.c_renamed.c_renamed;

/* compiled from: CompositionLayer.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.anim.c_renamed.c_renamed.a_renamed {
    private final java.util.List<com.oplus.anim.c_renamed.c_renamed.a_renamed> e_renamed;
    private final android.graphics.RectF f_renamed;
    private final android.graphics.RectF g_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> h_renamed;

    public b_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.d_renamed dVar, java.util.List<com.oplus.anim.c_renamed.c_renamed.d_renamed> list, com.oplus.anim.a_renamed aVar) {
        int i_renamed;
        com.oplus.anim.c_renamed.c_renamed.a_renamed aVar2;
        super(bVar, dVar);
        this.e_renamed = new java.util.ArrayList();
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = new android.graphics.RectF();
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarU = dVar.u_renamed();
        if (bVarU != null) {
            if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                com.oplus.anim.f_renamed.f_renamed.b_renamed("CompositionLayer::create timeRemapping animation, this = " + dVar.f_renamed());
            }
            this.h_renamed = bVarU.a_renamed();
            a_renamed(this.h_renamed);
            this.h_renamed.a_renamed(this);
        } else {
            this.h_renamed = null;
        }
        android.util.LongSparseArray longSparseArray = new android.util.LongSparseArray(aVar.i_renamed().size());
        int size = list.size() - 1;
        com.oplus.anim.c_renamed.c_renamed.a_renamed aVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            com.oplus.anim.c_renamed.c_renamed.d_renamed dVar2 = list.get(size);
            if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                com.oplus.anim.f_renamed.f_renamed.b_renamed("CompositionLayer::i_renamed = " + size + "; lm.type = " + dVar2.k_renamed() + "; lm.name = " + dVar2.f_renamed() + "; lm.id_renamed = " + dVar2.e_renamed());
            }
            com.oplus.anim.c_renamed.c_renamed.a_renamed aVarA = com.oplus.anim.c_renamed.c_renamed.a_renamed.a_renamed(dVar2, bVar, aVar);
            if (aVarA != null) {
                longSparseArray.put(aVarA.c_renamed().e_renamed(), aVarA);
                if (aVar3 != null) {
                    aVar3.a_renamed(aVarA);
                    aVar3 = null;
                } else {
                    this.e_renamed.add(0, aVarA);
                    int i2 = com.oplus.anim.c_renamed.c_renamed.b_renamed.SceneLoader_2.f3621a[dVar2.l_renamed().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar3 = aVarA;
                    }
                }
            }
            size--;
        }
        for (i_renamed = 0; i_renamed < longSparseArray.size(); i_renamed++) {
            com.oplus.anim.c_renamed.c_renamed.a_renamed aVar4 = (com.oplus.anim.c_renamed.c_renamed.a_renamed) longSparseArray.get(longSparseArray.keyAt(i_renamed));
            if (aVar4 != null && (aVar2 = (com.oplus.anim.c_renamed.c_renamed.a_renamed) longSparseArray.get(aVar4.c_renamed().m_renamed())) != null) {
                aVar4.b_renamed(aVar2);
            }
        }
    }

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.oplus.anim.c_renamed.c_renamed.b_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3621a = new int[com.oplus.anim.c_renamed.c_renamed.d_renamed.b_renamed.values().length];

        static {
            try {
                f3621a[com.oplus.anim.c_renamed.c_renamed.d_renamed.b_renamed.ADD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3621a[com.oplus.anim.c_renamed.c_renamed.d_renamed.b_renamed.INVERT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.oplus.anim.k_renamed.c_renamed("CompositionLayer#draw");
        canvas.save();
        this.g_renamed.set(0.0f, 0.0f, this.f3616c.h_renamed(), this.f3616c.i_renamed());
        matrix.mapRect(this.g_renamed);
        for (int size = this.e_renamed.size() - 1; size >= 0; size--) {
            if (!this.g_renamed.isEmpty() ? canvas.clipRect(this.g_renamed) : true) {
                this.e_renamed.get(size).a_renamed(canvas, matrix, i_renamed);
            }
        }
        canvas.restore();
        com.oplus.anim.k_renamed.d_renamed("CompositionLayer#draw");
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        for (int size = this.e_renamed.size() - 1; size >= 0; size--) {
            this.f_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.e_renamed.get(size).a_renamed(this.f_renamed, this.f3614a, true);
            rectF.union(this.f_renamed);
        }
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    public void a_renamed(float f_renamed) {
        super.a_renamed(f_renamed);
        if (this.h_renamed != null) {
            f_renamed = ((long) (this.h_renamed.g_renamed().floatValue() * 1000.0f)) / this.f3615b.r_renamed().e_renamed();
        }
        if (this.f3616c.b_renamed() != 0.0f) {
            f_renamed /= this.f3616c.b_renamed();
        }
        float fC_renamed = f_renamed - this.f3616c.c_renamed();
        for (int size = this.e_renamed.size() - 1; size >= 0; size--) {
            this.e_renamed.get(size).a_renamed(fC_renamed);
        }
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    protected void b_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        for (int i2 = 0; i2 < this.e_renamed.size(); i2++) {
            this.e_renamed.get(i2).a_renamed(fVar, i_renamed, list, fVar2);
        }
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        super.a_renamed((com.oplus.anim.c_renamed.c_renamed.b_renamed) t_renamed, (com.oplus.anim.g_renamed.b_renamed<com.oplus.anim.c_renamed.c_renamed.b_renamed>) bVar);
        if (t_renamed == com.oplus.anim.d_renamed.y_renamed) {
            if (bVar == null) {
                this.h_renamed = null;
            } else {
                this.h_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
                a_renamed(this.h_renamed);
            }
        }
    }
}
