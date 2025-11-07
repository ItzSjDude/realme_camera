package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public android.content.res.Resources f146a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public co_renamed.polarr.renderer.entities.Context f147b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f148c = 0;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed d_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] e_renamed;
    public float[][] f_renamed;
    public int g_renamed;
    public co_renamed.polarr.renderer.entities.MagicEraserHistoryItem h_renamed;
    public boolean i_renamed;
    public int j_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed k_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed l_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed m_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed n_renamed;
    public boolean o_renamed;
    public int p_renamed;
    public float[] q_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.x_renamed r_renamed;

    public class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f149a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed f150b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.util.List<a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed> f151c;
        public android.graphics.RectF d_renamed;
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed e_renamed;
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f_renamed;

        public b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed zVar) {
            this.f151c = new java.util.ArrayList();
        }
    }

    public static class c_renamed extends a_renamed.a_renamed.b_renamed.c_renamed.d_renamed {
        public int e_renamed;
        public int f_renamed;
        public float[] g_renamed;

        public static a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
            a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar = new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed();
            cVar.f34a = dVar.f34a;
            cVar.f35b = dVar.f35b;
            cVar.f36c = dVar.f36c;
            cVar.d_renamed = dVar.d_renamed;
            return cVar;
        }
    }

    public class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed f152a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f153b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f154c;

        public d_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed zVar, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
            this.f152a = cVar;
            this.f153b = dVar;
            this.f154c = dVar2;
        }
    }

    public z_renamed(android.content.res.Resources resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed mVar) {
        int i_renamed = this.f148c;
        this.e_renamed = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[i_renamed];
        this.f_renamed = new float[i_renamed][];
        this.f146a = resources;
        this.f147b = new co_renamed.polarr.renderer.entities.Context();
        this.f147b.mesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(true, false, false, 1));
        this.f147b.shaderUtil = mVar;
        this.g_renamed = 0;
        int[] iArr = new int[3];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(3, iArr, 0, 6408, 1, 1);
        this.d_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, 1, 1);
        this.l_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, 1, 1);
        this.m_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, 1, 1);
        this.k_renamed = a_renamed(1, 1);
        this.n_renamed = a_renamed(1, 1);
    }

    public static float[] a_renamed(android.graphics.RectF rectF, float f_renamed, float f2, float f3) {
        float f4 = f3 * 2.0f;
        float fMin = java.lang.Math.min(java.lang.Math.max(java.lang.Math.round(rectF.width() * f_renamed) + f4, 0.0f), f_renamed) / f_renamed;
        float fMin2 = java.lang.Math.min(java.lang.Math.max(java.lang.Math.round(rectF.height() * f2) + f4, 0.0f), f2) / f2;
        float fMin3 = java.lang.Math.min(java.lang.Math.max(java.lang.Math.round(rectF.left * f_renamed) - f3, 0.0f), f_renamed - fMin) / f_renamed;
        float fMin4 = java.lang.Math.min(java.lang.Math.max(java.lang.Math.round(rectF.top * f2) - f3, 0.0f), f2 - fMin2) / f2;
        float f5 = 1.0f / fMin;
        float f6 = 1.0f / fMin2;
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        android.opengl.Matrix.translateM(fArrA, 0, (-1.0f) - ((fMin3 * 2.0f) * f5), (fMin4 * 2.0f * f6) + 1.0f, 0.0f);
        android.opengl.Matrix.scaleM(fArrA, 0, f5, f6, 1.0f);
        android.opengl.Matrix.translateM(fArrA, 0, 1.0f, -1.0f, 0.0f);
        return fArrA;
    }

    public final int a_renamed(int i_renamed, int i2, int i3) {
        return java.lang.Math.max(i2, java.lang.Math.min(i_renamed, i3));
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(int i_renamed, int i2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA = a_renamed(6408, 5131, i_renamed, i2);
        android.opengl.GLES20.glBindTexture(3553, dVarA.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9728, 9728);
        android.opengl.GLES20.glBindTexture(3553, 0);
        return dVarA;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(int i_renamed, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, i_renamed, i2, i3, i4);
        return a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], i_renamed, i3, i4);
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = b_renamed(dVar.f35b, dVar.f36c);
        a_renamed.a_renamed.b_renamed.b_renamed.t_renamed tVarA = a_renamed.a_renamed.b_renamed.b_renamed.t_renamed.a_renamed(this.f146a, this.f147b);
        tVarA.a_renamed(dVar.f34a);
        tVarA.r_renamed = i_renamed;
        a_renamed(tVarA, dVarB);
        return dVarB;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed bVar, int i_renamed) {
        int i2 = i_renamed + 1;
        int iMin = java.lang.Math.min(6, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = bVar.f150b.f153b;
        int i3 = 1;
        while (i3 <= i2) {
            a_renamed(bVar, bVar.f150b, iMin);
            a_renamed(bVar, bVar.f150b, (i_renamed < 1 || i3 != i2) ? bVar.f151c.get(i_renamed) : bVar.f151c.get(i_renamed - 1), dVar);
            i3++;
        }
        if (this.o_renamed) {
            android.opengl.GLES30.glFinish();
        }
        return dVar;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = b_renamed(cVar.f35b, cVar.f36c);
        a_renamed.a_renamed.b_renamed.b_renamed.n_renamed nVarA = a_renamed.a_renamed.b_renamed.b_renamed.n_renamed.a_renamed(this.f146a, this.f147b);
        nVarA.r_renamed = cVar.f34a;
        a_renamed(nVarA, dVarB);
        a_renamed(cVar, dVarB);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVarB, cVar.e_renamed, cVar.f_renamed);
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
        aVarA.a_renamed(cVar.f34a);
        aVarA.a_renamed(cVar.g_renamed);
        a_renamed(aVarA, dVarB);
        return dVarB;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed r7, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed r8, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed r9, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed r10) {
        /*
            r6 = this;
            int r0 = r10.e_renamed
            int r1 = r10.f_renamed
            r2 = 34842(0x881a, float:4.8824E-41)
            r3 = 5131(0x140b, float:7.19E-42)
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(r8, r2, r3, r0, r1)
            android.content.res.Resources r0 = r6.f146a
            co_renamed.polarr.renderer.entities.Context r1 = r6.f147b
            a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed r0 = a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed.a_renamed(r0, r1)
            float[] r1 = r10.g_renamed
            r0.v_renamed = r1
            int r1 = r10.f34a
            r0.r_renamed = r1
            r1 = 2
            float[] r2 = new float[r1]
            int r3 = r10.f35b
            float r3 = (float) r3
            r4 = 0
            r2[r4] = r3
            int r3 = r10.f36c
            float r3 = (float) r3
            r5 = 1
            r2[r5] = r3
            r0.s_renamed = r2
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed r7 = r7.f149a
            float[] r1 = new float[r1]
            int r2 = r7.f35b
            float r2 = (float) r2
            r1[r4] = r2
            int r7 = r7.f36c
            float r7 = (float) r7
            r1[r5] = r7
            r0.t_renamed = r1
            boolean r7 = r6.i_renamed
            if (r7 == 0) goto L62
            co_renamed.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.h_renamed
            java.util.List<java.lang.Float> r7 = r7.randomLists
            int r7 = r7.size()
            int r1 = r6.j_renamed
            if (r7 <= r1) goto L62
            co_renamed.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.h_renamed
            java.util.List<java.lang.Float> r7 = r7.randomLists
            int r2 = r1 + 1
            r6.j_renamed = r2
            java.lang.Object r7 = r7.get(r1)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r0.u_renamed = r7
            goto L76
        L62:
            double r1 = java.lang.Math.random()
            float r7 = (float) r1
            r0.u_renamed = r7
            co_renamed.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.h_renamed
            java.util.List<java.lang.Float> r7 = r7.randomLists
            float r1 = r0.u_renamed
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r7.add(r1)
        L76:
            float[] r7 = r10.g_renamed
            r0.a_renamed(r7)
            r6.a_renamed(r0, r8)
            a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$d_renamed r7 = new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$d_renamed
            r7.<init>(r6, r10, r9, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$b_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$c_renamed):a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$d_renamed");
    }

    public final a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed bVar, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = dVar.f154c;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = bVar.f_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar4, 34842, 5131, cVar.e_renamed, cVar.f_renamed);
        a_renamed.a_renamed.b_renamed.b_renamed.o_renamed oVarA = a_renamed.a_renamed.b_renamed.b_renamed.o_renamed.a_renamed(this.f146a, this.f147b);
        float[] fArr = cVar.g_renamed;
        oVarA.x_renamed = fArr;
        oVarA.s_renamed = cVar.f34a;
        oVarA.r_renamed = dVar2.f34a;
        oVarA.t_renamed = dVar3.f34a;
        oVarA.u_renamed = new float[]{cVar.f35b, cVar.f36c};
        oVarA.v_renamed = new float[]{dVar2.f35b, dVar2.f36c};
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = bVar.f149a;
        oVarA.w_renamed = new float[]{dVar5.f35b, dVar5.f36c};
        oVarA.a_renamed(fArr);
        a_renamed(oVarA, dVar4);
        a_renamed(dVar3, dVar4);
        return new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed(this, cVar, dVar2, dVar3);
    }

    public java.util.List<java.lang.Float> a_renamed(java.util.List<android.graphics.PointF> list, float f_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.q_renamed = null;
        java.util.Iterator<android.graphics.PointF> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(arrayList, it.next(), f_renamed);
        }
        return arrayList;
    }

    public void a_renamed() {
        c_renamed(-1, -1);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.d_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.m_renamed;
        if (dVar2 != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar2);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.m_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.l_renamed;
        if (dVar3 != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar3);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.l_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = this.k_renamed;
        if (dVar4 != null) {
            a_renamed(dVar4);
            this.k_renamed = null;
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = this.n_renamed;
        if (dVar5 != null) {
            a_renamed(dVar5);
            this.n_renamed = null;
        }
    }

    public final void a_renamed(int i_renamed) {
        if (this.f148c <= 0) {
            return;
        }
        co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
        basicA.setNeedClear(false);
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarL = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.l_renamed();
        cVarL.b_renamed(i_renamed);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.d_renamed;
        cVarL.c_renamed(dVar.f35b, dVar.f36c);
        cVarL.s_renamed();
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        basicA.a_renamed(this.d_renamed.f34a);
        basicA.draw();
        for (int i2 = 0; i2 < this.g_renamed; i2++) {
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.e_renamed[i2];
            android.opengl.Matrix.invertM(basicA.getMatrix(), 0, this.f_renamed[i2], 0);
            basicA.a_renamed(dVar2.f34a);
            basicA.draw();
        }
        cVarL.n_renamed();
    }

    public void a_renamed(int i_renamed, int i2, android.graphics.Rect rect) {
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i2, rect.width(), rect.height());
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed, i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(int r20, co_renamed.polarr.renderer.entities.MagicEraserPath r21) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.a_renamed(int, co_renamed.polarr.renderer.entities.MagicEraserPath):void");
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarL = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.l_renamed();
        cVarL.b_renamed(dVar.f34a);
        cVarL.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        cVarL.c_renamed(dVar.f35b, dVar.f36c);
        cVarL.a_renamed(aVar);
        cVarL.s_renamed();
        aVar.draw();
        cVarL.n_renamed();
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        int i_renamed = dVar.f34a;
        if (i_renamed != 0) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(dVar.f34a);
        }
        dVar.f34a = 0;
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, int i2, int i3, float f_renamed, float f2, float f3) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.d_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, dVar2.f35b, dVar2.f36c);
        a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar = new a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed(this.f147b, this.f146a);
        bfVar.o_renamed = (float) a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed(1.0d);
        bfVar.p_renamed = 1.0f;
        bfVar.q_renamed = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarL = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.l_renamed();
        cVarL.b_renamed(dVar.f34a);
        cVarL.c_renamed(dVar.f35b, dVar.f36c);
        cVarL.s_renamed();
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        java.util.List<android.graphics.PointF> list = magicEraserPath.points;
        if (list != null && !list.isEmpty()) {
            float f4 = magicEraserPath.radius * 2.0f;
            bfVar.n_renamed = f4;
            bfVar.a_renamed(a_renamed(magicEraserPath.points, f4), false);
        }
        cVarL.n_renamed();
        android.opengl.GLES20.glViewport(0, 0, i2, i3);
        co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
        android.opengl.Matrix.scaleM(basicA.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        android.opengl.Matrix.translateM(basicA.getMatrix(), 0, f_renamed, f2, 0.0f);
        android.opengl.Matrix.scaleM(basicA.getMatrix(), 0, f3, f3, 1.0f);
        basicA.a_renamed(i_renamed);
        basicA.draw();
        if (this.r_renamed == null) {
            this.r_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.x_renamed(this.f146a, this.f147b);
            this.r_renamed.a_renamed();
        }
        this.f147b.overlayMask = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        a_renamed.a_renamed.b_renamed.b_renamed.x_renamed xVar = this.r_renamed;
        xVar.r_renamed = 0.5f;
        xVar.a_renamed(dVar.f34a);
        android.opengl.Matrix.setIdentityM(this.r_renamed.getMatrix(), 0);
        android.opengl.Matrix.scaleM(this.r_renamed.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        this.r_renamed.draw();
        android.opengl.GLES20.glDisable(3042);
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        int i_renamed = dVar2.f34a;
        dVar2.f34a = dVar.f34a;
        dVar.f34a = i_renamed;
        int i2 = dVar2.f35b;
        dVar2.f35b = dVar.f35b;
        dVar.f35b = i2;
        int i3 = dVar2.f36c;
        dVar2.f36c = dVar.f36c;
        dVar.f36c = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed r20, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed r21, int r22) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$b_renamed, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed$d_renamed, int):void");
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed bVar, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = bVar.e_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = dVar.f154c;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar3, cVar.e_renamed, cVar.f_renamed);
        a_renamed.a_renamed.b_renamed.b_renamed.bi_renamed biVarA = a_renamed.a_renamed.b_renamed.b_renamed.bi_renamed.a_renamed(this.f146a, this.f147b);
        float[] fArr = cVar.g_renamed;
        biVarA.w_renamed = fArr;
        biVarA.t_renamed = dVar4.f34a;
        biVarA.s_renamed = cVar.f34a;
        biVarA.r_renamed = dVar2.f34a;
        biVarA.u_renamed = new float[]{dVar2.f35b, dVar2.f36c};
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = bVar.f149a;
        biVarA.v_renamed = new float[]{dVar5.f35b, dVar5.f36c};
        biVarA.a_renamed(fArr);
        a_renamed(biVarA, dVar3);
        a_renamed(dVar2, dVar3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, android.graphics.RectF rectF, int i2) {
        android.opengl.GLES30.glGetError();
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA = null;
        a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed bVar = new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.b_renamed();
        bVar.f149a = cVar;
        bVar.d_renamed = rectF;
        bVar.f150b = null;
        bVar.f151c = new java.util.ArrayList();
        int i3 = 1;
        bVar.e_renamed = b_renamed(1, 1);
        bVar.f_renamed = this.k_renamed;
        this.o_renamed = false;
        float fMin = java.lang.Math.min(bVar.d_renamed.width(), 1.0f);
        float fMin2 = java.lang.Math.min(bVar.d_renamed.height(), 1.0f);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.l_renamed;
        float f_renamed = fMin * fMin2 * dVar2.f36c * dVar2.f35b;
        android.util.Log.d_renamed("POLARR_SDK", "pixels:" + java.lang.Math.round(f_renamed));
        if (f_renamed > 1.0E7f) {
            this.o_renamed = true;
            i3 = 3;
        } else if (f_renamed > 2000000.0f) {
            this.o_renamed = true;
            i3 = 2;
        } else if (f_renamed > 1000000.0f) {
            this.o_renamed = true;
        } else {
            if (f_renamed > 500000.0f) {
                this.o_renamed = true;
            }
            i3 = 0;
        }
        if (this.o_renamed) {
            this.p_renamed = java.lang.Math.min(this.p_renamed, 3);
            this.p_renamed = java.lang.Math.max(this.p_renamed, 0);
            i3 += this.p_renamed;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVarA = a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed.a_renamed(a_renamed(cVar, dVar.f34a));
        bVar.f151c.add(cVarA);
        int i4 = i_renamed * 2;
        cVarA.e_renamed = a_renamed(java.lang.Math.round(cVarA.f35b * bVar.d_renamed.width()) + i4, 0, cVarA.f35b);
        cVarA.f_renamed = a_renamed(java.lang.Math.round(cVarA.f36c * bVar.d_renamed.height()) + i4, 0, cVarA.f36c);
        float f2 = i_renamed;
        cVarA.g_renamed = a_renamed(bVar.d_renamed, cVarA.f35b, cVarA.f36c, f2);
        while (cVarA.e_renamed > i_renamed && cVarA.f_renamed > i_renamed) {
            cVarA = a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed.a_renamed(b_renamed(cVarA));
            cVarA.e_renamed = a_renamed(java.lang.Math.round(cVarA.f35b * bVar.d_renamed.width()) + i4, 0, cVarA.f35b);
            cVarA.f_renamed = a_renamed(java.lang.Math.round(cVarA.f36c * bVar.d_renamed.height()) + i4, 0, cVarA.f36c);
            cVarA.g_renamed = a_renamed(bVar.d_renamed, cVarA.f35b, cVarA.f36c, f2);
            bVar.f151c.add(cVarA);
        }
        int size = bVar.f151c.size() - 3;
        for (int i5 = size; i5 >= i3; i5--) {
            a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed cVar2 = bVar.f151c.get(i5);
            bVar.f150b = i5 == size ? a_renamed(bVar, this.n_renamed, a_renamed(cVar2), cVar2) : a_renamed(bVar, bVar.f150b, dVarA, cVar2);
            dVarA = a_renamed(bVar, i5);
            android.opengl.GLES20.glFinish();
            if (i5 == i3) {
                co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
                basicA.setNeedClear(false);
                a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarL = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.l_renamed();
                cVarL.b_renamed(i2);
                cVarL.c_renamed(cVar.f35b, cVar.f36c);
                cVarL.s_renamed();
                android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                android.opengl.GLES20.glClear(16384);
                basicA.a_renamed(cVar2.f34a);
                basicA.draw();
                android.opengl.Matrix.invertM(basicA.getMatrix(), 0, cVar2.g_renamed, 0);
                basicA.a_renamed(dVarA.f34a);
                basicA.draw();
                cVarL.n_renamed();
                a_renamed(bVar.e_renamed);
                java.util.Iterator<a_renamed.a_renamed.b_renamed.f_renamed.z_renamed.c_renamed> it = bVar.f151c.iterator();
                while (it.hasNext()) {
                    a_renamed(it.next());
                }
            }
        }
        android.opengl.GLES30.glFlush();
        android.opengl.GLES30.glGetError();
    }

    public void a_renamed(java.util.List<java.lang.Float> list, android.graphics.PointF pointF, float f_renamed) {
        float[] fArr = new float[4];
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.d_renamed;
        float f2 = dVar.f35b;
        float f3 = dVar.f36c;
        float[] fArr2 = {1.0f / f2, 1.0f / f3};
        float[] fArr3 = {pointF.x_renamed * f2, (1.0f - pointF.y_renamed) * f3, 0.5f};
        if (this.q_renamed == null) {
            this.q_renamed = new float[]{fArr3[0], fArr3[1], fArr3[2]};
            fArr3[0] = fArr3[0] * fArr2[0];
            fArr3[1] = fArr3[1] * fArr2[1];
            list.add(java.lang.Float.valueOf(fArr3[0]));
            list.add(java.lang.Float.valueOf(fArr3[1]));
            list.add(java.lang.Float.valueOf(fArr3[2]));
            return;
        }
        int i_renamed = (int) (f_renamed * 0.3f * fArr3[2]);
        if (i_renamed < 1) {
            i_renamed = 1;
        }
        float fA_renamed = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr3, this.q_renamed);
        if (fA_renamed >= i_renamed) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int i2 = i_renamed;
            while (true) {
                float f4 = i2;
                if (f4 > fA_renamed) {
                    break;
                }
                try {
                    a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(this.q_renamed, fArr3, f4 / fA_renamed, fArr);
                    arrayList.add(java.lang.Float.valueOf(fArr[0]));
                    arrayList.add(java.lang.Float.valueOf(fArr[1]));
                    arrayList.add(java.lang.Float.valueOf(fArr[2]));
                    i2 += i_renamed;
                } catch (java.lang.OutOfMemoryError e_renamed) {
                    e_renamed.printStackTrace();
                    return;
                }
                e_renamed.printStackTrace();
                return;
            }
            int size = arrayList.size();
            int i3 = size - 3;
            this.q_renamed = new float[]{((java.lang.Float) arrayList.get(i3)).floatValue(), ((java.lang.Float) arrayList.get(i3 + 1)).floatValue(), ((java.lang.Float) arrayList.get(i3 + 2)).floatValue()};
            for (int i4 = 0; i4 < size; i4 += 3) {
                arrayList.set(i4, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i4)).floatValue() * fArr2[0]));
                int i5 = i4 + 1;
                arrayList.set(i5, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i5)).floatValue() * fArr2[1]));
            }
            list.addAll(arrayList);
        }
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed b_renamed(int i_renamed, int i2) {
        int[] iArr = new int[1];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i_renamed, i2);
        return a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i_renamed, i2);
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = b_renamed(dVar.f35b >> 1, dVar.f36c >> 1);
        co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
        basicA.a_renamed(dVar.f34a);
        a_renamed(basicA, dVarB);
        return dVarB;
    }

    public void b_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.t_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.n_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bi_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ah_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.j_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.o_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed.m_renamed();
    }

    public void b_renamed(int i_renamed, int i2, int i3, int i4) {
        this.p_renamed = i4;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.d_renamed, i2, i3);
        c_renamed(i_renamed, -1);
    }

    public void b_renamed(int i_renamed, int i2, android.graphics.Rect rect) {
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i_renamed, i2, rect);
    }

    public void c_renamed(int i_renamed, int i2) {
        if (i_renamed > 0) {
            co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.f146a, this.f147b);
            basicA.a_renamed(i_renamed);
            a_renamed(basicA, this.d_renamed);
        }
        if (i2 != 0) {
            this.g_renamed = -1;
            a_renamed(i2);
        }
        for (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar : this.e_renamed) {
            if (dVar != null) {
                a_renamed(dVar);
            }
        }
        for (int i3 = 0; i3 < this.f148c; i3++) {
            this.e_renamed[i3] = null;
            this.f_renamed[i3] = null;
        }
        this.g_renamed = 0;
    }
}
