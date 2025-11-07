package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: MergePathsContent.java */
@android.annotation.TargetApi(19)
/* loaded from: classes.dex */
public class l_renamed implements com.airbnb.lottie.a_renamed.a_renamed.j_renamed, com.airbnb.lottie.a_renamed.a_renamed.m_renamed {
    private final java.lang.String d_renamed;
    private final com.airbnb.lottie.c_renamed.b_renamed.h_renamed f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f2007a = new android.graphics.Path();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Path f2008b = new android.graphics.Path();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.Path f2009c = new android.graphics.Path();
    private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> e_renamed = new java.util.ArrayList();

    public l_renamed(com.airbnb.lottie.c_renamed.b_renamed.h_renamed hVar) {
        if (android.os.Build.VERSION.SDK_INT < 19) {
            throw new java.lang.IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d_renamed = hVar.a_renamed();
        this.f_renamed = hVar;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.j_renamed
    public void a_renamed(java.util.ListIterator<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed) {
                this.e_renamed.add((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < this.e_renamed.size(); i_renamed++) {
            this.e_renamed.get(i_renamed).a_renamed(list, list2);
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        this.f2009c.reset();
        if (this.f_renamed.c_renamed()) {
            return this.f2009c;
        }
        int i_renamed = com.airbnb.lottie.a_renamed.a_renamed.l_renamed.SceneLoader_2.f2010a[this.f_renamed.b_renamed().ordinal()];
        if (i_renamed == 1) {
            a_renamed();
        } else if (i_renamed == 2) {
            a_renamed(android.graphics.Path.Op.UNION);
        } else if (i_renamed == 3) {
            a_renamed(android.graphics.Path.Op.REVERSE_DIFFERENCE);
        } else if (i_renamed == 4) {
            a_renamed(android.graphics.Path.Op.INTERSECT);
        } else if (i_renamed == 5) {
            a_renamed(android.graphics.Path.Op.XOR);
        }
        return this.f2009c;
    }

    /* compiled from: MergePathsContent.java */
    /* renamed from: com.airbnb.lottie.a_renamed.a_renamed.l_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2010a = new int[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.values().length];

        static {
            try {
                f2010a[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.MERGE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2010a[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.ADD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2010a[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.SUBTRACT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f2010a[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.INTERSECT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f2010a[com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    private void a_renamed() {
        for (int i_renamed = 0; i_renamed < this.e_renamed.size(); i_renamed++) {
            this.f2009c.addPath(this.e_renamed.get(i_renamed).e_renamed());
        }
    }

    @android.annotation.TargetApi(19)
    private void a_renamed(android.graphics.Path.Op op) {
        this.f2008b.reset();
        this.f2007a.reset();
        for (int size = this.e_renamed.size() - 1; size >= 1; size--) {
            com.airbnb.lottie.a_renamed.a_renamed.m_renamed mVar = this.e_renamed.get(size);
            if (mVar instanceof com.airbnb.lottie.a_renamed.a_renamed.d_renamed) {
                com.airbnb.lottie.a_renamed.a_renamed.d_renamed dVar = (com.airbnb.lottie.a_renamed.a_renamed.d_renamed) mVar;
                java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> listC = dVar.c_renamed();
                for (int size2 = listC.size() - 1; size2 >= 0; size2--) {
                    android.graphics.Path pathE = listC.get(size2).e_renamed();
                    pathE.transform(dVar.d_renamed());
                    this.f2008b.addPath(pathE);
                }
            } else {
                this.f2008b.addPath(mVar.e_renamed());
            }
        }
        com.airbnb.lottie.a_renamed.a_renamed.m_renamed mVar2 = this.e_renamed.get(0);
        if (mVar2 instanceof com.airbnb.lottie.a_renamed.a_renamed.d_renamed) {
            com.airbnb.lottie.a_renamed.a_renamed.d_renamed dVar2 = (com.airbnb.lottie.a_renamed.a_renamed.d_renamed) mVar2;
            java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> listC2 = dVar2.c_renamed();
            for (int i_renamed = 0; i_renamed < listC2.size(); i_renamed++) {
                android.graphics.Path pathE2 = listC2.get(i_renamed).e_renamed();
                pathE2.transform(dVar2.d_renamed());
                this.f2007a.addPath(pathE2);
            }
        } else {
            this.f2007a.set(mVar2.e_renamed());
        }
        this.f2009c.op(this.f2007a, this.f2008b, op);
    }
}
