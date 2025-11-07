package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a_renamed implements com.airbnb.lottie.a_renamed.a_renamed.e_renamed, com.airbnb.lottie.a_renamed.a_renamed.k_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final com.airbnb.lottie.c_renamed.c_renamed.a_renamed f1988a;
    private final com.airbnb.lottie.f_renamed g_renamed;
    private final float[] i_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> j_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Integer> k_renamed;
    private final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float>> l_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> m_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> n_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.PathMeasure f1990c = new android.graphics.PathMeasure();
    private final android.graphics.Path d_renamed = new android.graphics.Path();
    private final android.graphics.Path e_renamed = new android.graphics.Path();
    private final android.graphics.RectF f_renamed = new android.graphics.RectF();
    private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.a_renamed.BaseStrokeContent_4> h_renamed = new java.util.ArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.graphics.Paint f1989b = new com.airbnb.lottie.a_renamed.a_renamed(1);

    a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, android.graphics.Paint.Cap cap, android.graphics.Paint.Join join, float f_renamed, com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, java.util.List<com.airbnb.lottie.c_renamed.a_renamed.b_renamed> list, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2) {
        this.g_renamed = fVar;
        this.f1988a = aVar;
        this.f1989b.setStyle(android.graphics.Paint.Style.STROKE);
        this.f1989b.setStrokeCap(cap);
        this.f1989b.setStrokeJoin(join);
        this.f1989b.setStrokeMiter(f_renamed);
        this.k_renamed = dVar.a_renamed();
        this.j_renamed = bVar.a_renamed();
        if (bVar2 == null) {
            this.m_renamed = null;
        } else {
            this.m_renamed = bVar2.a_renamed();
        }
        this.l_renamed = new java.util.ArrayList(list.size());
        this.i_renamed = new float[list.size()];
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            this.l_renamed.add(list.get(i_renamed).a_renamed());
        }
        aVar.a_renamed(this.k_renamed);
        aVar.a_renamed(this.j_renamed);
        for (int i2 = 0; i2 < this.l_renamed.size(); i2++) {
            aVar.a_renamed(this.l_renamed.get(i2));
        }
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2 = this.m_renamed;
        if (aVar2 != null) {
            aVar.a_renamed(aVar2);
        }
        this.k_renamed.a_renamed(this);
        this.j_renamed.a_renamed(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l_renamed.get(i3).a_renamed(this);
        }
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar3 = this.m_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(this);
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        this.g_renamed.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0055  */
    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> r8, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed r3 = (com.airbnb.lottie.a_renamed.a_renamed.c_renamed) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.a_renamed.a_renamed.s_renamed
            if (r4 == 0) goto L1f
            com.airbnb.lottie.a_renamed.a_renamed.s_renamed r3 = (com.airbnb.lottie.a_renamed.a_renamed.s_renamed) r3
            com.airbnb.lottie.c_renamed.b_renamed.q_renamed$a_renamed r4 = r3.c_renamed()
            com.airbnb.lottie.c_renamed.b_renamed.q_renamed$a_renamed r5 = com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.a_renamed(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed r3 = (com.airbnb.lottie.a_renamed.a_renamed.c_renamed) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.a_renamed.a_renamed.s_renamed
            if (r4 == 0) goto L55
            r4 = r3
            com.airbnb.lottie.a_renamed.a_renamed.s_renamed r4 = (com.airbnb.lottie.a_renamed.a_renamed.s_renamed) r4
            com.airbnb.lottie.c_renamed.b_renamed.q_renamed$a_renamed r5 = r4.c_renamed()
            com.airbnb.lottie.c_renamed.b_renamed.q_renamed$a_renamed r6 = com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed> r3 = r7.h_renamed
            r3.add(r0)
        L4c:
            com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed r0 = new com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed
            r0.<init>(r4)
            r4.a_renamed(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed r0 = new com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.airbnb.lottie.a_renamed.a_renamed.a_renamed.BaseStrokeContent_4.a_renamed(r0)
            com.airbnb.lottie.a_renamed.a_renamed.m_renamed r3 = (com.airbnb.lottie.a_renamed.a_renamed.m_renamed) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed> r7 = r7.h_renamed
            r7.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a_renamed.a_renamed.a_renamed.a_renamed(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.airbnb.lottie.c_renamed.a_renamed("StrokeContent#draw");
        if (com.airbnb.lottie.f_renamed.h_renamed.b_renamed(matrix)) {
            com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#draw");
            return;
        }
        this.f1989b.setAlpha(com.airbnb.lottie.f_renamed.g_renamed.a_renamed((int) ((((i_renamed / 255.0f) * ((com.airbnb.lottie.a_renamed.b_renamed.e_renamed) this.k_renamed).i_renamed()) / 100.0f) * 255.0f), 0, 255));
        this.f1989b.setStrokeWidth(((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) this.j_renamed).i_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed(matrix));
        if (this.f1989b.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#draw");
            return;
        }
        a_renamed(matrix);
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.n_renamed;
        if (aVar != null) {
            this.f1989b.setColorFilter(aVar.g_renamed());
        }
        for (int i2 = 0; i2 < this.h_renamed.size(); i2++) {
            com.airbnb.lottie.a_renamed.a_renamed.a_renamed.BaseStrokeContent_4 c0050a = this.h_renamed.get(i2);
            if (c0050a.f1992b != null) {
                a_renamed(canvas, c0050a, matrix);
            } else {
                com.airbnb.lottie.c_renamed.a_renamed("StrokeContent#buildPath");
                this.d_renamed.reset();
                for (int size = c0050a.f1991a.size() - 1; size >= 0; size--) {
                    this.d_renamed.addPath(((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) c0050a.f1991a.get(size)).e_renamed(), matrix);
                }
                com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#buildPath");
                com.airbnb.lottie.c_renamed.a_renamed("StrokeContent#drawPath");
                canvas.drawPath(this.d_renamed, this.f1989b);
                com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(android.graphics.Canvas r13, com.airbnb.lottie.a_renamed.a_renamed.a_renamed.BaseStrokeContent_4 r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a_renamed.a_renamed.a_renamed.a_renamed(android.graphics.Canvas, com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed, android.graphics.Matrix):void");
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        com.airbnb.lottie.c_renamed.a_renamed("StrokeContent#getBounds");
        this.d_renamed.reset();
        for (int i_renamed = 0; i_renamed < this.h_renamed.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.a_renamed.BaseStrokeContent_4 c0050a = this.h_renamed.get(i_renamed);
            for (int i2 = 0; i2 < c0050a.f1991a.size(); i2++) {
                this.d_renamed.addPath(((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) c0050a.f1991a.get(i2)).e_renamed(), matrix);
            }
        }
        this.d_renamed.computeBounds(this.f_renamed, false);
        float fI_renamed = ((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) this.j_renamed).i_renamed();
        android.graphics.RectF rectF2 = this.f_renamed;
        float f_renamed = fI_renamed / 2.0f;
        rectF2.set(rectF2.left - f_renamed, this.f_renamed.top - f_renamed, this.f_renamed.right + f_renamed, this.f_renamed.bottom + f_renamed);
        rectF.set(this.f_renamed);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#getBounds");
    }

    private void a_renamed(android.graphics.Matrix matrix) {
        com.airbnb.lottie.c_renamed.a_renamed("StrokeContent#applyDashPattern");
        if (this.l_renamed.isEmpty()) {
            com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#applyDashPattern");
            return;
        }
        float fA_renamed = com.airbnb.lottie.f_renamed.h_renamed.a_renamed(matrix);
        for (int i_renamed = 0; i_renamed < this.l_renamed.size(); i_renamed++) {
            this.i_renamed[i_renamed] = this.l_renamed.get(i_renamed).g_renamed().floatValue();
            if (i_renamed % 2 == 0) {
                float[] fArr = this.i_renamed;
                if (fArr[i_renamed] < 1.0f) {
                    fArr[i_renamed] = 1.0f;
                }
            } else {
                float[] fArr2 = this.i_renamed;
                if (fArr2[i_renamed] < 0.1f) {
                    fArr2[i_renamed] = 0.1f;
                }
            }
            float[] fArr3 = this.i_renamed;
            fArr3[i_renamed] = fArr3[i_renamed] * fA_renamed;
        }
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar = this.m_renamed;
        this.f1989b.setPathEffect(new android.graphics.DashPathEffect(this.i_renamed, aVar == null ? 0.0f : fA_renamed * aVar.g_renamed().floatValue()));
        com.airbnb.lottie.c_renamed.b_renamed("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.f_renamed.g_renamed.a_renamed(eVar, i_renamed, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        if (t_renamed == com.airbnb.lottie.k_renamed.d_renamed) {
            this.k_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Integer>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.q_renamed) {
            this.j_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.E_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.n_renamed;
            if (aVar != null) {
                this.f1988a.b_renamed(aVar);
            }
            if (cVar == null) {
                this.n_renamed = null;
                return;
            }
            this.n_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.n_renamed.a_renamed(this);
            this.f1988a.a_renamed(this.n_renamed);
        }
    }

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: com.airbnb.lottie.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class BaseStrokeContent_4 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> f1991a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.airbnb.lottie.a_renamed.a_renamed.s_renamed f1992b;

        private BaseStrokeContent_4(com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar) {
            this.f1991a = new java.util.ArrayList();
            this.f1992b = sVar;
        }
    }
}
