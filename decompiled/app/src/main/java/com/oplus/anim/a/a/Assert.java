package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes2.dex */
public abstract class a_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {
    private final com.oplus.anim.b_renamed f_renamed;
    private final com.oplus.anim.c_renamed.c_renamed.a_renamed g_renamed;
    private final float[] i_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> j_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Integer> k_renamed;
    private final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float>> l_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> m_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> n_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.Paint f3456a = new com.oplus.anim.a_renamed.a_renamed(1);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.PathMeasure f3457b = new android.graphics.PathMeasure();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.Path f3458c = new android.graphics.Path();
    private final android.graphics.Path d_renamed = new android.graphics.Path();
    private final android.graphics.RectF e_renamed = new android.graphics.RectF();
    private final java.util.List<com.oplus.anim.a_renamed.a_renamed.a_renamed.BaseStrokeContent_2> h_renamed = new java.util.ArrayList();

    a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, android.graphics.Paint.Cap cap, android.graphics.Paint.Join join, float f_renamed, com.oplus.anim.c_renamed.a_renamed.d_renamed dVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, java.util.List<com.oplus.anim.c_renamed.a_renamed.b_renamed> list, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar3) {
        this.f_renamed = bVar;
        this.g_renamed = aVar;
        this.f3456a.setStyle(android.graphics.Paint.Style.STROKE);
        this.f3456a.setStrokeCap(cap);
        this.f3456a.setStrokeJoin(join);
        this.f3456a.setStrokeMiter(f_renamed);
        this.k_renamed = dVar.a_renamed();
        this.j_renamed = bVar2.a_renamed();
        if (bVar3 == null) {
            this.m_renamed = null;
        } else {
            this.m_renamed = bVar3.a_renamed();
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
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2 = this.m_renamed;
        if (aVar2 != null) {
            aVar.a_renamed(aVar2);
        }
        this.k_renamed.a_renamed(this);
        this.j_renamed.a_renamed(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l_renamed.get(i3).a_renamed(this);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar3 = this.m_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(this);
        }
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        this.f_renamed.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0055  */
    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> r8, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.oplus.anim.a_renamed.a_renamed.c_renamed r3 = (com.oplus.anim.a_renamed.a_renamed.c_renamed) r3
            boolean r4 = r3 instanceof com.oplus.anim.a_renamed.a_renamed.s_renamed
            if (r4 == 0) goto L1f
            com.oplus.anim.a_renamed.a_renamed.s_renamed r3 = (com.oplus.anim.a_renamed.a_renamed.s_renamed) r3
            com.oplus.anim.c_renamed.b_renamed.q_renamed$a_renamed r4 = r3.c_renamed()
            com.oplus.anim.c_renamed.b_renamed.q_renamed$a_renamed r5 = com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed.INDIVIDUALLY
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
            com.oplus.anim.a_renamed.a_renamed.c_renamed r3 = (com.oplus.anim.a_renamed.a_renamed.c_renamed) r3
            boolean r4 = r3 instanceof com.oplus.anim.a_renamed.a_renamed.s_renamed
            if (r4 == 0) goto L55
            r4 = r3
            com.oplus.anim.a_renamed.a_renamed.s_renamed r4 = (com.oplus.anim.a_renamed.a_renamed.s_renamed) r4
            com.oplus.anim.c_renamed.b_renamed.q_renamed$a_renamed r5 = r4.c_renamed()
            com.oplus.anim.c_renamed.b_renamed.q_renamed$a_renamed r6 = com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed> r3 = r7.h_renamed
            r3.add(r0)
        L4c:
            com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed r0 = new com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed
            r0.<init>(r4)
            r4.a_renamed(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.oplus.anim.a_renamed.a_renamed.m_renamed
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed r0 = new com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.oplus.anim.a_renamed.a_renamed.a_renamed.BaseStrokeContent_2.a_renamed(r0)
            com.oplus.anim.a_renamed.a_renamed.m_renamed r3 = (com.oplus.anim.a_renamed.a_renamed.m_renamed) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed> r7 = r7.h_renamed
            r7.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.a_renamed.a_renamed.a_renamed.a_renamed(java.util.List, java.util.List):void");
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.oplus.anim.k_renamed.c_renamed("StrokeContent#draw");
        this.f3456a.setAlpha(com.oplus.anim.f_renamed.e_renamed.a_renamed((int) ((((i_renamed / 255.0f) * ((com.oplus.anim.a_renamed.b_renamed.e_renamed) this.k_renamed).i_renamed()) / 100.0f) * 255.0f), 0, 255));
        this.f3456a.setStrokeWidth(((com.oplus.anim.a_renamed.b_renamed.c_renamed) this.j_renamed).i_renamed() * com.oplus.anim.f_renamed.g_renamed.a_renamed(matrix));
        if (this.f3456a.getStrokeWidth() <= 0.0f) {
            com.oplus.anim.k_renamed.d_renamed("StrokeContent#draw");
            return;
        }
        a_renamed(matrix);
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.n_renamed;
        if (aVar != null) {
            this.f3456a.setColorFilter(aVar.g_renamed());
        }
        for (int i2 = 0; i2 < this.h_renamed.size(); i2++) {
            com.oplus.anim.a_renamed.a_renamed.a_renamed.BaseStrokeContent_2 c0076a = this.h_renamed.get(i2);
            if (c0076a.f3460b != null) {
                a_renamed(canvas, c0076a, matrix);
            } else {
                com.oplus.anim.k_renamed.c_renamed("StrokeContent#buildPath");
                this.f3458c.reset();
                for (int size = c0076a.f3459a.size() - 1; size >= 0; size--) {
                    this.f3458c.addPath(((com.oplus.anim.a_renamed.a_renamed.m_renamed) c0076a.f3459a.get(size)).e_renamed(), matrix);
                }
                com.oplus.anim.k_renamed.d_renamed("StrokeContent#buildPath");
                com.oplus.anim.k_renamed.c_renamed("StrokeContent#drawPath");
                canvas.drawPath(this.f3458c, this.f3456a);
                com.oplus.anim.k_renamed.d_renamed("StrokeContent#drawPath");
            }
        }
        com.oplus.anim.k_renamed.d_renamed("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(android.graphics.Canvas r13, com.oplus.anim.a_renamed.a_renamed.a_renamed.BaseStrokeContent_2 r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.a_renamed.a_renamed.a_renamed.a_renamed(android.graphics.Canvas, com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed, android.graphics.Matrix):void");
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        com.oplus.anim.k_renamed.c_renamed("StrokeContent#getBounds");
        this.f3458c.reset();
        for (int i_renamed = 0; i_renamed < this.h_renamed.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.a_renamed.BaseStrokeContent_2 c0076a = this.h_renamed.get(i_renamed);
            for (int i2 = 0; i2 < c0076a.f3459a.size(); i2++) {
                this.f3458c.addPath(((com.oplus.anim.a_renamed.a_renamed.m_renamed) c0076a.f3459a.get(i2)).e_renamed(), matrix);
            }
        }
        this.f3458c.computeBounds(this.e_renamed, false);
        float fI_renamed = ((com.oplus.anim.a_renamed.b_renamed.c_renamed) this.j_renamed).i_renamed();
        android.graphics.RectF rectF2 = this.e_renamed;
        float f_renamed = fI_renamed / 2.0f;
        rectF2.set(rectF2.left - f_renamed, this.e_renamed.top - f_renamed, this.e_renamed.right + f_renamed, this.e_renamed.bottom + f_renamed);
        rectF.set(this.e_renamed);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.oplus.anim.k_renamed.d_renamed("StrokeContent#getBounds");
    }

    private void a_renamed(android.graphics.Matrix matrix) {
        com.oplus.anim.k_renamed.c_renamed("StrokeContent#applyDashPattern");
        if (this.l_renamed.isEmpty()) {
            com.oplus.anim.k_renamed.d_renamed("StrokeContent#applyDashPattern");
            return;
        }
        float fA_renamed = com.oplus.anim.f_renamed.g_renamed.a_renamed(matrix);
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
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar = this.m_renamed;
        this.f3456a.setPathEffect(new android.graphics.DashPathEffect(this.i_renamed, aVar == null ? 0.0f : aVar.g_renamed().floatValue()));
        com.oplus.anim.k_renamed.d_renamed("StrokeContent#applyDashPattern");
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (t_renamed == com.oplus.anim.d_renamed.d_renamed) {
            this.k_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.m_renamed) {
            this.j_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.z_renamed) {
            if (bVar == null) {
                this.n_renamed = null;
                return;
            }
            this.n_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
            this.n_renamed.a_renamed(this);
            this.g_renamed.a_renamed(this.n_renamed);
        }
    }

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: com.oplus.anim.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class BaseStrokeContent_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.util.List<com.oplus.anim.a_renamed.a_renamed.m_renamed> f3459a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.oplus.anim.a_renamed.a_renamed.s_renamed f3460b;

        private BaseStrokeContent_2(com.oplus.anim.a_renamed.a_renamed.s_renamed sVar) {
            this.f3459a = new java.util.ArrayList();
            this.f3460b = sVar;
        }
    }
}
