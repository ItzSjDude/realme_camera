package com.oplus.anim.c_renamed.c_renamed;

/* compiled from: BaseLayer.java */
/* loaded from: classes2.dex */
public abstract class a_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2, com.oplus.anim.c_renamed.g_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    final com.oplus.anim.b_renamed f3615b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final com.oplus.anim.c_renamed.c_renamed.d_renamed f3616c;
    final com.oplus.anim.a_renamed.b_renamed.o_renamed d_renamed;
    private final java.lang.String p_renamed;
    private com.oplus.anim.a_renamed.b_renamed.g_renamed r_renamed;
    private com.oplus.anim.c_renamed.c_renamed.a_renamed s_renamed;
    private com.oplus.anim.c_renamed.c_renamed.a_renamed t_renamed;
    private java.util.List<com.oplus.anim.c_renamed.c_renamed.a_renamed> u_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.Matrix f3614a = new android.graphics.Matrix();
    private final android.graphics.Path e_renamed = new android.graphics.Path();
    private final android.graphics.Matrix f_renamed = new android.graphics.Matrix();
    private final android.graphics.Paint g_renamed = new com.oplus.anim.a_renamed.a_renamed(1);
    private final android.graphics.Paint h_renamed = new com.oplus.anim.a_renamed.a_renamed(1, android.graphics.PorterDuff.Mode.DST_IN);
    private final android.graphics.Paint i_renamed = new com.oplus.anim.a_renamed.a_renamed(1, android.graphics.PorterDuff.Mode.DST_OUT);
    private final android.graphics.Paint j_renamed = new com.oplus.anim.a_renamed.a_renamed(1);
    private final android.graphics.Paint k_renamed = new com.oplus.anim.a_renamed.a_renamed(android.graphics.PorterDuff.Mode.CLEAR);
    private final android.graphics.RectF l_renamed = new android.graphics.RectF();
    private final android.graphics.RectF m_renamed = new android.graphics.RectF();
    private final android.graphics.RectF n_renamed = new android.graphics.RectF();
    private final android.graphics.RectF o_renamed = new android.graphics.RectF();
    private final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?>> q_renamed = new java.util.ArrayList();
    private boolean v_renamed = true;

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
    }

    abstract void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed);

    void b_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
    }

    a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.d_renamed dVar) {
        this.f3615b = bVar;
        this.f3616c = dVar;
        this.p_renamed = dVar.f_renamed() + "#draw";
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("BaseLayer::name = " + dVar.f_renamed() + ";layerModel.getMatteType() = " + dVar.l_renamed() + "; this = " + this);
        }
        if (dVar.l_renamed() == com.oplus.anim.c_renamed.c_renamed.d_renamed.b_renamed.INVERT) {
            this.j_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        } else {
            this.j_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        }
        this.d_renamed = dVar.o_renamed().j_renamed();
        this.d_renamed.a_renamed((com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2) this);
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("BaseLayer::layerModel.getMasks() ? ");
            sb.append(dVar.j_renamed() == null);
            com.oplus.anim.f_renamed.f_renamed.b_renamed(sb.toString());
        }
        if (dVar.j_renamed() != null && !dVar.j_renamed().isEmpty()) {
            this.r_renamed = new com.oplus.anim.a_renamed.b_renamed.g_renamed(dVar.j_renamed());
            java.util.Iterator<com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path>> it = this.r_renamed.b_renamed().iterator();
            while (it.hasNext()) {
                it.next().a_renamed(this);
            }
            for (com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar : this.r_renamed.c_renamed()) {
                a_renamed(aVar);
                aVar.a_renamed(this);
            }
        }
        f_renamed();
    }

    static com.oplus.anim.c_renamed.c_renamed.a_renamed a_renamed(com.oplus.anim.c_renamed.c_renamed.d_renamed dVar, com.oplus.anim.b_renamed bVar, com.oplus.anim.a_renamed aVar) {
        switch (dVar.k_renamed()) {
            case SHAPE:
                return new com.oplus.anim.c_renamed.c_renamed.f_renamed(bVar, dVar);
            case PRE_COMP:
                return new com.oplus.anim.c_renamed.c_renamed.b_renamed(bVar, dVar, aVar.b_renamed(dVar.g_renamed()), aVar);
            case SOLID:
                return new com.oplus.anim.c_renamed.c_renamed.g_renamed(bVar, dVar);
            case IMAGE:
                return new com.oplus.anim.c_renamed.c_renamed.c_renamed(bVar, dVar);
            case NULL:
                return new com.oplus.anim.c_renamed.c_renamed.e_renamed(bVar, dVar);
            case TEXT:
                return new com.oplus.anim.c_renamed.c_renamed.h_renamed(bVar, dVar);
            default:
                com.oplus.anim.k_renamed.b_renamed("Unknown layer type " + dVar.k_renamed());
                return null;
        }
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        g_renamed();
    }

    com.oplus.anim.c_renamed.c_renamed.d_renamed c_renamed() {
        return this.f3616c;
    }

    void a_renamed(com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        this.s_renamed = aVar;
    }

    boolean d_renamed() {
        return this.s_renamed != null;
    }

    void b_renamed(com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        this.t_renamed = aVar;
    }

    private void f_renamed() {
        if (!this.f3616c.d_renamed().isEmpty()) {
            final com.oplus.anim.a_renamed.b_renamed.c_renamed cVar = new com.oplus.anim.a_renamed.b_renamed.c_renamed(this.f3616c.d_renamed());
            if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                for (int i_renamed = 0; i_renamed < this.f3616c.d_renamed().size(); i_renamed++) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("BaseLayer::create InOutAnimations, " + this.f3616c.d_renamed().get(i_renamed).toString());
                }
            }
            cVar.a_renamed();
            cVar.a_renamed(new com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2() { // from class: com.oplus.anim.c_renamed.c_renamed.a_renamed.1
                @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
                public void a_renamed() {
                    com.oplus.anim.c_renamed.c_renamed.a_renamed.this.a_renamed(cVar.i_renamed() == 1.0f);
                }
            });
            a_renamed(cVar.g_renamed().floatValue() == 1.0f);
            a_renamed(cVar);
            return;
        }
        a_renamed(true);
    }

    private void g_renamed() {
        this.f3615b.invalidateSelf();
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z_renamed ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.q_renamed.add(aVar);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.l_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        h_renamed();
        this.f3614a.set(matrix);
        if (z_renamed) {
            java.util.List<com.oplus.anim.c_renamed.c_renamed.a_renamed> list = this.u_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3614a.preConcat(this.u_renamed.get(size).d_renamed.d_renamed());
                }
            } else {
                com.oplus.anim.c_renamed.c_renamed.a_renamed aVar = this.t_renamed;
                if (aVar != null) {
                    this.f3614a.preConcat(aVar.d_renamed.d_renamed());
                }
            }
        }
        this.f3614a.preConcat(this.d_renamed.d_renamed());
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.oplus.anim.k_renamed.c_renamed(this.p_renamed);
        if (!this.v_renamed || this.f3616c.v_renamed()) {
            com.oplus.anim.k_renamed.d_renamed(this.p_renamed);
            return;
        }
        h_renamed();
        com.oplus.anim.k_renamed.c_renamed("Layer#parentMatrix");
        this.f_renamed.reset();
        this.f_renamed.set(matrix);
        for (int size = this.u_renamed.size() - 1; size >= 0; size--) {
            this.f_renamed.preConcat(this.u_renamed.get(size).d_renamed.d_renamed());
        }
        com.oplus.anim.k_renamed.d_renamed("Layer#parentMatrix");
        int iIntValue = (int) ((((i_renamed / 255.0f) * (this.d_renamed.a_renamed() == null ? 100 : this.d_renamed.a_renamed().g_renamed().intValue())) / 100.0f) * 255.0f);
        if (!d_renamed() && !e_renamed()) {
            this.f_renamed.preConcat(this.d_renamed.d_renamed());
            com.oplus.anim.k_renamed.c_renamed("Layer#drawLayer");
            b_renamed(canvas, this.f_renamed, iIntValue);
            com.oplus.anim.k_renamed.d_renamed("Layer#drawLayer");
            float fD_renamed = com.oplus.anim.k_renamed.d_renamed(this.p_renamed);
            com.oplus.anim.k_renamed.a_renamed(this.p_renamed + " draw end time = " + fD_renamed);
            b_renamed(fD_renamed);
            return;
        }
        com.oplus.anim.k_renamed.c_renamed("Layer#computeBounds");
        a_renamed(this.l_renamed, this.f_renamed, false);
        b_renamed(this.l_renamed, matrix);
        this.f_renamed.preConcat(this.d_renamed.d_renamed());
        a_renamed(this.l_renamed, this.f_renamed);
        com.oplus.anim.k_renamed.d_renamed("Layer#computeBounds");
        if (!this.l_renamed.isEmpty()) {
            com.oplus.anim.k_renamed.c_renamed("Layer#saveLayer");
            a_renamed(canvas, this.l_renamed, this.g_renamed, true);
            com.oplus.anim.k_renamed.d_renamed("Layer#saveLayer");
            a_renamed(canvas);
            com.oplus.anim.k_renamed.c_renamed("Layer#drawLayer");
            b_renamed(canvas, this.f_renamed, iIntValue);
            com.oplus.anim.k_renamed.d_renamed("Layer#drawLayer");
            if (e_renamed()) {
                a_renamed(canvas, this.f_renamed);
            }
            if (d_renamed()) {
                com.oplus.anim.k_renamed.c_renamed("Layer#drawMatte");
                com.oplus.anim.k_renamed.c_renamed("Layer#saveLayer");
                a_renamed(canvas, this.l_renamed, this.j_renamed, false);
                com.oplus.anim.k_renamed.d_renamed("Layer#saveLayer");
                a_renamed(canvas);
                this.s_renamed.a_renamed(canvas, matrix, iIntValue);
                com.oplus.anim.k_renamed.c_renamed("Layer#restoreLayer");
                canvas.restore();
                com.oplus.anim.k_renamed.d_renamed("Layer#restoreLayer");
                com.oplus.anim.k_renamed.d_renamed("Layer#drawMatte");
            }
            com.oplus.anim.k_renamed.c_renamed("Layer#restoreLayer");
            canvas.restore();
            com.oplus.anim.k_renamed.d_renamed("Layer#restoreLayer");
        }
        float fD2 = com.oplus.anim.k_renamed.d_renamed(this.p_renamed);
        com.oplus.anim.k_renamed.a_renamed(this.p_renamed + " draw end,time = " + fD2);
        b_renamed(fD2);
    }

    private void b_renamed(float f_renamed) {
        this.f3615b.r_renamed().c_renamed().a_renamed(this.f3616c.f_renamed(), f_renamed);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        com.oplus.anim.k_renamed.c_renamed("Layer#clearLayer");
        canvas.drawRect(this.l_renamed.left - 1.0f, this.l_renamed.top - 1.0f, this.l_renamed.right + 1.0f, this.l_renamed.bottom + 1.0f, this.k_renamed);
        com.oplus.anim.k_renamed.d_renamed("Layer#clearLayer");
    }

    private void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        this.m_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (e_renamed()) {
            int size = this.r_renamed.a_renamed().size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.oplus.anim.c_renamed.b_renamed.g_renamed gVar = this.r_renamed.a_renamed().get(i_renamed);
                this.e_renamed.set(this.r_renamed.b_renamed().get(i_renamed).g_renamed());
                this.e_renamed.transform(matrix);
                int i2 = com.oplus.anim.c_renamed.c_renamed.a_renamed.XPanMode_2.f3620b[gVar.a_renamed().ordinal()];
                if (i2 == 1) {
                    return;
                }
                if (i2 == 2 || i2 == 3) {
                    if (gVar.d_renamed()) {
                        return;
                    }
                    this.e_renamed.computeBounds(this.o_renamed, false);
                    if (i_renamed == 0) {
                        this.m_renamed.set(this.o_renamed);
                    } else {
                        android.graphics.RectF rectF2 = this.m_renamed;
                        rectF2.set(java.lang.Math.min(rectF2.left, this.o_renamed.left), java.lang.Math.min(this.m_renamed.top, this.o_renamed.top), java.lang.Math.max(this.m_renamed.right, this.o_renamed.right), java.lang.Math.max(this.m_renamed.bottom, this.o_renamed.bottom));
                    }
                } else {
                    this.e_renamed.computeBounds(this.o_renamed, false);
                    if (i_renamed == 0) {
                        this.m_renamed.set(this.o_renamed);
                    } else {
                        android.graphics.RectF rectF3 = this.m_renamed;
                        rectF3.set(java.lang.Math.min(rectF3.left, this.o_renamed.left), java.lang.Math.min(this.m_renamed.top, this.o_renamed.top), java.lang.Math.max(this.m_renamed.right, this.o_renamed.right), java.lang.Math.max(this.m_renamed.bottom, this.o_renamed.bottom));
                    }
                }
            }
            if (rectF.intersect(this.m_renamed)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    /* renamed from: com.oplus.anim.c_renamed.c_renamed.a_renamed$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3620b = new int[com.oplus.anim.c_renamed.b_renamed.g_renamed.a_renamed.values().length];

        static {
            try {
                f3620b[com.oplus.anim.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3620b[com.oplus.anim.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f3620b[com.oplus.anim.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_ADD.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            f3619a = new int[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.values().length];
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.SHAPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.PRE_COMP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.SOLID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.IMAGE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.NULL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.TEXT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f3619a[com.oplus.anim.c_renamed.c_renamed.d_renamed.a_renamed.UNKNOWN.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    private void b_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        if (d_renamed() && this.f3616c.l_renamed() != com.oplus.anim.c_renamed.c_renamed.d_renamed.b_renamed.INVERT) {
            this.n_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.s_renamed.a_renamed(this.n_renamed, matrix, true);
            if (rectF.intersect(this.n_renamed)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix) {
        com.oplus.anim.k_renamed.c_renamed("Layer#saveLayer");
        a_renamed(canvas, this.l_renamed, this.h_renamed, false);
        com.oplus.anim.k_renamed.d_renamed("Layer#saveLayer");
        for (int i_renamed = 0; i_renamed < this.r_renamed.a_renamed().size(); i_renamed++) {
            com.oplus.anim.c_renamed.b_renamed.g_renamed gVar = this.r_renamed.a_renamed().get(i_renamed);
            com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar = this.r_renamed.b_renamed().get(i_renamed);
            com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2 = this.r_renamed.c_renamed().get(i_renamed);
            int i2 = com.oplus.anim.c_renamed.c_renamed.a_renamed.XPanMode_2.f3620b[gVar.a_renamed().ordinal()];
            if (i2 == 1) {
                if (i_renamed == 0) {
                    android.graphics.Paint paint = new android.graphics.Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.l_renamed, paint);
                }
                if (gVar.d_renamed()) {
                    d_renamed(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    c_renamed(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (gVar.d_renamed()) {
                        b_renamed(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        a_renamed(canvas, matrix, gVar, aVar, aVar2);
                    }
                }
            } else if (gVar.d_renamed()) {
                f_renamed(canvas, matrix, gVar, aVar, aVar2);
            } else {
                e_renamed(canvas, matrix, gVar, aVar, aVar2);
            }
        }
        com.oplus.anim.k_renamed.c_renamed("Layer#restoreLayer");
        canvas.restore();
        com.oplus.anim.k_renamed.d_renamed("Layer#restoreLayer");
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.g_renamed);
    }

    private void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        a_renamed(canvas, this.l_renamed, this.g_renamed, true);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    private void c_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
    }

    private void d_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        a_renamed(canvas, this.l_renamed, this.i_renamed, true);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.i_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    private void e_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        a_renamed(canvas, this.l_renamed, this.h_renamed, true);
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.g_renamed);
        canvas.restore();
    }

    private void f_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.b_renamed.g_renamed gVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        a_renamed(canvas, this.l_renamed, this.h_renamed, true);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.i_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    boolean e_renamed() {
        com.oplus.anim.a_renamed.b_renamed.g_renamed gVar = this.r_renamed;
        return (gVar == null || gVar.b_renamed().isEmpty()) ? false : true;
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed != this.v_renamed) {
            this.v_renamed = z_renamed;
            g_renamed();
        }
    }

    void a_renamed(float f_renamed) {
        this.d_renamed.a_renamed(f_renamed);
        if (this.r_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.r_renamed.b_renamed().size(); i_renamed++) {
                this.r_renamed.b_renamed().get(i_renamed).a_renamed(f_renamed);
            }
        }
        if (this.f3616c.b_renamed() != 0.0f) {
            f_renamed /= this.f3616c.b_renamed();
        }
        com.oplus.anim.c_renamed.c_renamed.a_renamed aVar = this.s_renamed;
        if (aVar != null) {
            this.s_renamed.a_renamed(aVar.f3616c.b_renamed() * f_renamed);
        }
        for (int i2 = 0; i2 < this.q_renamed.size(); i2++) {
            this.q_renamed.get(i2).a_renamed(f_renamed);
        }
    }

    private void h_renamed() {
        if (this.u_renamed != null) {
            return;
        }
        if (this.t_renamed == null) {
            this.u_renamed = java.util.Collections.emptyList();
            return;
        }
        this.u_renamed = new java.util.ArrayList();
        for (com.oplus.anim.c_renamed.c_renamed.a_renamed aVar = this.t_renamed; aVar != null; aVar = aVar.t_renamed) {
            this.u_renamed.add(aVar);
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3616c.f_renamed();
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("BaseLayer::resolveKeyPath()::this = " + b_renamed() + "; keyPath = " + fVar.toString());
        }
        if (fVar.a_renamed(b_renamed(), i_renamed)) {
            if (!"__container".equals(b_renamed())) {
                fVar2 = fVar2.a_renamed(b_renamed());
                if (fVar.c_renamed(b_renamed(), i_renamed)) {
                    if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                        com.oplus.anim.f_renamed.f_renamed.b_renamed("BaseLayer::resolveKeyPath()::name = " + b_renamed());
                    }
                    list.add(fVar2.a_renamed(this));
                }
            }
            if (fVar.d_renamed(b_renamed(), i_renamed)) {
                int iB = i_renamed + fVar.b_renamed(b_renamed(), i_renamed);
                if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("BaseLayer::resolveKeyPath()::newDepth = " + iB);
                }
                b_renamed(fVar, iB, list, fVar2);
            }
        }
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        this.d_renamed.a_renamed(t_renamed, bVar);
    }
}
