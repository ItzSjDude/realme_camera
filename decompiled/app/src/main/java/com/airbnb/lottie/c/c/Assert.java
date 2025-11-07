package com.airbnb.lottie.c_renamed.c_renamed;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a_renamed implements com.airbnb.lottie.a_renamed.a_renamed.e_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4, com.airbnb.lottie.c_renamed.f_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    final com.airbnb.lottie.f_renamed f2118b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final com.airbnb.lottie.c_renamed.c_renamed.d_renamed f2119c;
    final com.airbnb.lottie.a_renamed.b_renamed.o_renamed d_renamed;
    private final java.lang.String p_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.g_renamed q_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.c_renamed r_renamed;
    private com.airbnb.lottie.c_renamed.c_renamed.a_renamed s_renamed;
    private com.airbnb.lottie.c_renamed.c_renamed.a_renamed t_renamed;
    private java.util.List<com.airbnb.lottie.c_renamed.c_renamed.a_renamed> u_renamed;
    private boolean x_renamed;
    private android.graphics.Paint y_renamed;
    private final android.graphics.Path e_renamed = new android.graphics.Path();
    private final android.graphics.Matrix f_renamed = new android.graphics.Matrix();
    private final android.graphics.Paint g_renamed = new com.airbnb.lottie.a_renamed.a_renamed(1);
    private final android.graphics.Paint h_renamed = new com.airbnb.lottie.a_renamed.a_renamed(1, android.graphics.PorterDuff.Mode.DST_IN);
    private final android.graphics.Paint i_renamed = new com.airbnb.lottie.a_renamed.a_renamed(1, android.graphics.PorterDuff.Mode.DST_OUT);
    private final android.graphics.Paint j_renamed = new com.airbnb.lottie.a_renamed.a_renamed(1);
    private final android.graphics.Paint k_renamed = new com.airbnb.lottie.a_renamed.a_renamed(android.graphics.PorterDuff.Mode.CLEAR);
    private final android.graphics.RectF l_renamed = new android.graphics.RectF();
    private final android.graphics.RectF m_renamed = new android.graphics.RectF();
    private final android.graphics.RectF n_renamed = new android.graphics.RectF();
    private final android.graphics.RectF o_renamed = new android.graphics.RectF();

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.Matrix f2117a = new android.graphics.Matrix();
    private final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?>> v_renamed = new java.util.ArrayList();
    private boolean w_renamed = true;

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
    }

    abstract void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed);

    void b_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
    }

    static com.airbnb.lottie.c_renamed.c_renamed.a_renamed a_renamed(com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar, com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.d_renamed dVar2) {
        switch (dVar.k_renamed()) {
            case SHAPE:
                return new com.airbnb.lottie.c_renamed.c_renamed.f_renamed(fVar, dVar);
            case PRE_COMP:
                return new com.airbnb.lottie.c_renamed.c_renamed.b_renamed(fVar, dVar, dVar2.b_renamed(dVar.g_renamed()), dVar2);
            case SOLID:
                return new com.airbnb.lottie.c_renamed.c_renamed.g_renamed(fVar, dVar);
            case IMAGE:
                return new com.airbnb.lottie.c_renamed.c_renamed.c_renamed(fVar, dVar);
            case NULL:
                return new com.airbnb.lottie.c_renamed.c_renamed.e_renamed(fVar, dVar);
            case TEXT:
                return new com.airbnb.lottie.c_renamed.c_renamed.h_renamed(fVar, dVar);
            default:
                com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Unknown layer type " + dVar.k_renamed());
                return null;
        }
    }

    a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar) {
        this.f2118b = fVar;
        this.f2119c = dVar;
        this.p_renamed = dVar.f_renamed() + "#draw";
        if (dVar.l_renamed() == com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.INVERT) {
            this.j_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        } else {
            this.j_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        }
        this.d_renamed = dVar.o_renamed().j_renamed();
        this.d_renamed.a_renamed((com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4) this);
        if (dVar.j_renamed() != null && !dVar.j_renamed().isEmpty()) {
            this.q_renamed = new com.airbnb.lottie.a_renamed.b_renamed.g_renamed(dVar.j_renamed());
            java.util.Iterator<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path>> it = this.q_renamed.b_renamed().iterator();
            while (it.hasNext()) {
                it.next().a_renamed(this);
            }
            for (com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar : this.q_renamed.c_renamed()) {
                a_renamed(aVar);
                aVar.a_renamed(this);
            }
        }
        f_renamed();
    }

    void a_renamed(boolean z_renamed) {
        if (z_renamed && this.y_renamed == null) {
            this.y_renamed = new com.airbnb.lottie.a_renamed.a_renamed();
        }
        this.x_renamed = z_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        g_renamed();
    }

    com.airbnb.lottie.c_renamed.c_renamed.d_renamed c_renamed() {
        return this.f2119c;
    }

    void a_renamed(com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        this.s_renamed = aVar;
    }

    boolean d_renamed() {
        return this.s_renamed != null;
    }

    void b_renamed(com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        this.t_renamed = aVar;
    }

    private void f_renamed() {
        if (!this.f2119c.d_renamed().isEmpty()) {
            this.r_renamed = new com.airbnb.lottie.a_renamed.b_renamed.c_renamed(this.f2119c.d_renamed());
            this.r_renamed.a_renamed();
            this.r_renamed.a_renamed(new com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4() { // from class: com.airbnb.lottie.c_renamed.c_renamed.a_renamed.1
                @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
                public void a_renamed() {
                    com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar = com.airbnb.lottie.c_renamed.c_renamed.a_renamed.this;
                    aVar.b_renamed(aVar.r_renamed.i_renamed() == 1.0f);
                }
            });
            b_renamed(this.r_renamed.g_renamed().floatValue() == 1.0f);
            a_renamed(this.r_renamed);
            return;
        }
        b_renamed(true);
    }

    private void g_renamed() {
        this.f2118b.invalidateSelf();
    }

    public void a_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.v_renamed.add(aVar);
    }

    public void b_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?> aVar) {
        this.v_renamed.remove(aVar);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.l_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        i_renamed();
        this.f2117a.set(matrix);
        if (z_renamed) {
            java.util.List<com.airbnb.lottie.c_renamed.c_renamed.a_renamed> list = this.u_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2117a.preConcat(this.u_renamed.get(size).d_renamed.d_renamed());
                }
            } else {
                com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar = this.t_renamed;
                if (aVar != null) {
                    this.f2117a.preConcat(aVar.d_renamed.d_renamed());
                }
            }
        }
        this.f2117a.preConcat(this.d_renamed.d_renamed());
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        android.graphics.Paint paint;
        com.airbnb.lottie.c_renamed.a_renamed(this.p_renamed);
        if (!this.w_renamed || this.f2119c.v_renamed()) {
            com.airbnb.lottie.c_renamed.b_renamed(this.p_renamed);
            return;
        }
        i_renamed();
        com.airbnb.lottie.c_renamed.a_renamed("Layer#parentMatrix");
        this.f_renamed.reset();
        this.f_renamed.set(matrix);
        for (int size = this.u_renamed.size() - 1; size >= 0; size--) {
            this.f_renamed.preConcat(this.u_renamed.get(size).d_renamed.d_renamed());
        }
        com.airbnb.lottie.c_renamed.b_renamed("Layer#parentMatrix");
        int iIntValue = (int) ((((i_renamed / 255.0f) * (this.d_renamed.a_renamed() == null ? 100 : this.d_renamed.a_renamed().g_renamed().intValue())) / 100.0f) * 255.0f);
        if (!d_renamed() && !e_renamed()) {
            this.f_renamed.preConcat(this.d_renamed.d_renamed());
            com.airbnb.lottie.c_renamed.a_renamed("Layer#drawLayer");
            b_renamed(canvas, this.f_renamed, iIntValue);
            com.airbnb.lottie.c_renamed.b_renamed("Layer#drawLayer");
            b_renamed(com.airbnb.lottie.c_renamed.b_renamed(this.p_renamed));
            return;
        }
        com.airbnb.lottie.c_renamed.a_renamed("Layer#computeBounds");
        a_renamed(this.l_renamed, this.f_renamed, false);
        b_renamed(this.l_renamed, matrix);
        this.f_renamed.preConcat(this.d_renamed.d_renamed());
        a_renamed(this.l_renamed, this.f_renamed);
        if (!this.l_renamed.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.l_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.airbnb.lottie.c_renamed.b_renamed("Layer#computeBounds");
        if (this.l_renamed.width() >= 1.0f && this.l_renamed.height() >= 1.0f) {
            com.airbnb.lottie.c_renamed.a_renamed("Layer#saveLayer");
            this.g_renamed.setAlpha(255);
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.g_renamed);
            com.airbnb.lottie.c_renamed.b_renamed("Layer#saveLayer");
            a_renamed(canvas);
            com.airbnb.lottie.c_renamed.a_renamed("Layer#drawLayer");
            b_renamed(canvas, this.f_renamed, iIntValue);
            com.airbnb.lottie.c_renamed.b_renamed("Layer#drawLayer");
            if (e_renamed()) {
                a_renamed(canvas, this.f_renamed);
            }
            if (d_renamed()) {
                com.airbnb.lottie.c_renamed.a_renamed("Layer#drawMatte");
                com.airbnb.lottie.c_renamed.a_renamed("Layer#saveLayer");
                com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.j_renamed, 19);
                com.airbnb.lottie.c_renamed.b_renamed("Layer#saveLayer");
                a_renamed(canvas);
                this.s_renamed.a_renamed(canvas, matrix, iIntValue);
                com.airbnb.lottie.c_renamed.a_renamed("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c_renamed.b_renamed("Layer#restoreLayer");
                com.airbnb.lottie.c_renamed.b_renamed("Layer#drawMatte");
            }
            com.airbnb.lottie.c_renamed.a_renamed("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c_renamed.b_renamed("Layer#restoreLayer");
        }
        if (this.x_renamed && (paint = this.y_renamed) != null) {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            this.y_renamed.setColor(-251901);
            this.y_renamed.setStrokeWidth(4.0f);
            canvas.drawRect(this.l_renamed, this.y_renamed);
            this.y_renamed.setStyle(android.graphics.Paint.Style.FILL);
            this.y_renamed.setColor(1357638635);
            canvas.drawRect(this.l_renamed, this.y_renamed);
        }
        b_renamed(com.airbnb.lottie.c_renamed.b_renamed(this.p_renamed));
    }

    private void b_renamed(float f_renamed) {
        this.f2118b.t_renamed().c_renamed().a_renamed(this.f2119c.f_renamed(), f_renamed);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        com.airbnb.lottie.c_renamed.a_renamed("Layer#clearLayer");
        canvas.drawRect(this.l_renamed.left - 1.0f, this.l_renamed.top - 1.0f, this.l_renamed.right + 1.0f, this.l_renamed.bottom + 1.0f, this.k_renamed);
        com.airbnb.lottie.c_renamed.b_renamed("Layer#clearLayer");
    }

    private void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        this.m_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (e_renamed()) {
            int size = this.q_renamed.a_renamed().size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar = this.q_renamed.a_renamed().get(i_renamed);
                this.e_renamed.set(this.q_renamed.b_renamed().get(i_renamed).g_renamed());
                this.e_renamed.transform(matrix);
                int i2 = com.airbnb.lottie.c_renamed.c_renamed.a_renamed.XPanMode_2.f2122b[gVar.a_renamed().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && gVar.d_renamed()) {
                    return;
                }
                this.e_renamed.computeBounds(this.o_renamed, false);
                if (i_renamed == 0) {
                    this.m_renamed.set(this.o_renamed);
                } else {
                    android.graphics.RectF rectF2 = this.m_renamed;
                    rectF2.set(java.lang.Math.min(rectF2.left, this.o_renamed.left), java.lang.Math.min(this.m_renamed.top, this.o_renamed.top), java.lang.Math.max(this.m_renamed.right, this.o_renamed.right), java.lang.Math.max(this.m_renamed.bottom, this.o_renamed.bottom));
                }
            }
            if (rectF.intersect(this.m_renamed)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.c_renamed.c_renamed.a_renamed$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2122b = new int[com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.values().length];

        static {
            try {
                f2122b[com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_NONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2122b[com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2122b[com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f2122b[com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_ADD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            f2121a = new int[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.values().length];
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.SHAPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.PRE_COMP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.SOLID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.IMAGE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.NULL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.TEXT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f2121a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.UNKNOWN.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
        }
    }

    private void b_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        if (d_renamed() && this.f2119c.l_renamed() != com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.INVERT) {
            this.n_renamed.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.s_renamed.a_renamed(this.n_renamed, matrix, true);
            if (rectF.intersect(this.n_renamed)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix) {
        com.airbnb.lottie.c_renamed.a_renamed("Layer#saveLayer");
        com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.h_renamed, 19);
        if (android.os.Build.VERSION.SDK_INT < 28) {
            a_renamed(canvas);
        }
        com.airbnb.lottie.c_renamed.b_renamed("Layer#saveLayer");
        for (int i_renamed = 0; i_renamed < this.q_renamed.a_renamed().size(); i_renamed++) {
            com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar = this.q_renamed.a_renamed().get(i_renamed);
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar = this.q_renamed.b_renamed().get(i_renamed);
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2 = this.q_renamed.c_renamed().get(i_renamed);
            int i2 = com.airbnb.lottie.c_renamed.c_renamed.a_renamed.XPanMode_2.f2122b[gVar.a_renamed().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i_renamed == 0) {
                        this.g_renamed.setColor(-16777216);
                        this.g_renamed.setAlpha(255);
                        canvas.drawRect(this.l_renamed, this.g_renamed);
                    }
                    if (gVar.d_renamed()) {
                        d_renamed(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        c_renamed(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
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
            } else if (h_renamed()) {
                this.g_renamed.setAlpha(255);
                canvas.drawRect(this.l_renamed, this.g_renamed);
            }
        }
        com.airbnb.lottie.c_renamed.a_renamed("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c_renamed.b_renamed("Layer#restoreLayer");
    }

    private boolean h_renamed() {
        if (this.q_renamed.b_renamed().isEmpty()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.q_renamed.a_renamed().size(); i_renamed++) {
            if (this.q_renamed.a_renamed().get(i_renamed).a_renamed() != com.airbnb.lottie.c_renamed.b_renamed.g_renamed.a_renamed.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.g_renamed);
    }

    private void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.g_renamed);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    private void c_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
    }

    private void d_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.i_renamed);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.i_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    private void e_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.h_renamed);
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        this.g_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        canvas.drawPath(this.e_renamed, this.g_renamed);
        canvas.restore();
    }

    private void f_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.b_renamed.g_renamed gVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2) {
        com.airbnb.lottie.f_renamed.h_renamed.a_renamed(canvas, this.l_renamed, this.h_renamed);
        canvas.drawRect(this.l_renamed, this.g_renamed);
        this.i_renamed.setAlpha((int) (aVar2.g_renamed().intValue() * 2.55f));
        this.e_renamed.set(aVar.g_renamed());
        this.e_renamed.transform(matrix);
        canvas.drawPath(this.e_renamed, this.i_renamed);
        canvas.restore();
    }

    boolean e_renamed() {
        com.airbnb.lottie.a_renamed.b_renamed.g_renamed gVar = this.q_renamed;
        return (gVar == null || gVar.b_renamed().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        if (z_renamed != this.w_renamed) {
            this.w_renamed = z_renamed;
            g_renamed();
        }
    }

    void a_renamed(float f_renamed) {
        this.d_renamed.a_renamed(f_renamed);
        if (this.q_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.q_renamed.b_renamed().size(); i_renamed++) {
                this.q_renamed.b_renamed().get(i_renamed).a_renamed(f_renamed);
            }
        }
        if (this.f2119c.b_renamed() != 0.0f) {
            f_renamed /= this.f2119c.b_renamed();
        }
        com.airbnb.lottie.a_renamed.b_renamed.c_renamed cVar = this.r_renamed;
        if (cVar != null) {
            cVar.a_renamed(f_renamed / this.f2119c.b_renamed());
        }
        com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar = this.s_renamed;
        if (aVar != null) {
            this.s_renamed.a_renamed(aVar.f2119c.b_renamed() * f_renamed);
        }
        for (int i2 = 0; i2 < this.v_renamed.size(); i2++) {
            this.v_renamed.get(i2).a_renamed(f_renamed);
        }
    }

    private void i_renamed() {
        if (this.u_renamed != null) {
            return;
        }
        if (this.t_renamed == null) {
            this.u_renamed = java.util.Collections.emptyList();
            return;
        }
        this.u_renamed = new java.util.ArrayList();
        for (com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar = this.t_renamed; aVar != null; aVar = aVar.t_renamed) {
            this.u_renamed.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2119c.f_renamed();
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar = this.s_renamed;
        if (aVar != null) {
            com.airbnb.lottie.c_renamed.e_renamed eVarA = eVar2.a_renamed(aVar.b_renamed());
            if (eVar.c_renamed(this.s_renamed.b_renamed(), i_renamed)) {
                list.add(eVarA.a_renamed(this.s_renamed));
            }
            if (eVar.d_renamed(b_renamed(), i_renamed)) {
                this.s_renamed.b_renamed(eVar, eVar.b_renamed(this.s_renamed.b_renamed(), i_renamed) + i_renamed, list, eVarA);
            }
        }
        if (eVar.a_renamed(b_renamed(), i_renamed)) {
            if (!"__container".equals(b_renamed())) {
                eVar2 = eVar2.a_renamed(b_renamed());
                if (eVar.c_renamed(b_renamed(), i_renamed)) {
                    list.add(eVar2.a_renamed(this));
                }
            }
            if (eVar.d_renamed(b_renamed(), i_renamed)) {
                b_renamed(eVar, i_renamed + eVar.b_renamed(b_renamed(), i_renamed), list, eVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        this.d_renamed.a_renamed(t_renamed, cVar);
    }
}
