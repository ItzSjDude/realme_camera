package com.airbnb.lottie.c_renamed.c_renamed;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class h_renamed extends com.airbnb.lottie.c_renamed.c_renamed.a_renamed {
    private final java.lang.StringBuilder e_renamed;
    private final android.graphics.RectF f_renamed;
    private final android.graphics.Matrix g_renamed;
    private final android.graphics.Paint h_renamed;
    private final android.graphics.Paint i_renamed;
    private final java.util.Map<com.airbnb.lottie.c_renamed.d_renamed, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.d_renamed>> j_renamed;
    private final androidx.collection.LongSparseArray<java.lang.String> k_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.n_renamed l_renamed;
    private final com.airbnb.lottie.f_renamed m_renamed;
    private final com.airbnb.lottie.d_renamed n_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> o_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> p_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> q_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> r_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> s_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> t_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> u_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> v_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> w_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> x_renamed;

    h_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar) {
        super(fVar, dVar);
        this.e_renamed = new java.lang.StringBuilder(2);
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = new android.graphics.Matrix();
        int i_renamed = 1;
        this.h_renamed = new android.graphics.Paint(i_renamed) { // from class: com.airbnb.lottie.c_renamed.c_renamed.h_renamed.1
            {
                setStyle(android.graphics.Paint.Style.FILL);
            }
        };
        this.i_renamed = new android.graphics.Paint(i_renamed) { // from class: com.airbnb.lottie.c_renamed.c_renamed.h_renamed.2
            {
                setStyle(android.graphics.Paint.Style.STROKE);
            }
        };
        this.j_renamed = new java.util.HashMap();
        this.k_renamed = new androidx.collection.LongSparseArray<>();
        this.m_renamed = fVar;
        this.n_renamed = dVar.a_renamed();
        this.l_renamed = dVar.s_renamed().a_renamed();
        this.l_renamed.a_renamed(this);
        a_renamed(this.l_renamed);
        com.airbnb.lottie.c_renamed.a_renamed.k_renamed kVarT = dVar.t_renamed();
        if (kVarT != null && kVarT.f2058a != null) {
            this.o_renamed = kVarT.f2058a.a_renamed();
            this.o_renamed.a_renamed(this);
            a_renamed(this.o_renamed);
        }
        if (kVarT != null && kVarT.f2059b != null) {
            this.q_renamed = kVarT.f2059b.a_renamed();
            this.q_renamed.a_renamed(this);
            a_renamed(this.q_renamed);
        }
        if (kVarT != null && kVarT.f2060c != null) {
            this.s_renamed = kVarT.f2060c.a_renamed();
            this.s_renamed.a_renamed(this);
            a_renamed(this.s_renamed);
        }
        if (kVarT == null || kVarT.d_renamed == null) {
            return;
        }
        this.u_renamed = kVarT.d_renamed.a_renamed();
        this.u_renamed.a_renamed(this);
        a_renamed(this.u_renamed);
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        rectF.set(0.0f, 0.0f, this.n_renamed.d_renamed().width(), this.n_renamed.d_renamed().height());
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        canvas.save();
        if (!this.m_renamed.r_renamed()) {
            canvas.concat(matrix);
        }
        com.airbnb.lottie.c_renamed.b_renamed bVarG = this.l_renamed.g_renamed();
        com.airbnb.lottie.c_renamed.c_renamed cVar = this.n_renamed.k_renamed().get(bVarG.f2066b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar = this.p_renamed;
        if (aVar != null) {
            this.h_renamed.setColor(aVar.g_renamed().intValue());
        } else {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2 = this.o_renamed;
            if (aVar2 != null) {
                this.h_renamed.setColor(aVar2.g_renamed().intValue());
            } else {
                this.h_renamed.setColor(bVarG.h_renamed);
            }
        }
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar3 = this.r_renamed;
        if (aVar3 != null) {
            this.i_renamed.setColor(aVar3.g_renamed().intValue());
        } else {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar4 = this.q_renamed;
            if (aVar4 != null) {
                this.i_renamed.setColor(aVar4.g_renamed().intValue());
            } else {
                this.i_renamed.setColor(bVarG.i_renamed);
            }
        }
        int iIntValue = ((this.d_renamed.a_renamed() == null ? 100 : this.d_renamed.a_renamed().g_renamed().intValue()) * 255) / 100;
        this.h_renamed.setAlpha(iIntValue);
        this.i_renamed.setAlpha(iIntValue);
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar5 = this.t_renamed;
        if (aVar5 != null) {
            this.i_renamed.setStrokeWidth(aVar5.g_renamed().floatValue());
        } else {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar6 = this.s_renamed;
            if (aVar6 != null) {
                this.i_renamed.setStrokeWidth(aVar6.g_renamed().floatValue());
            } else {
                this.i_renamed.setStrokeWidth(bVarG.j_renamed * com.airbnb.lottie.f_renamed.h_renamed.a_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed(matrix));
            }
        }
        if (this.m_renamed.r_renamed()) {
            a_renamed(bVarG, matrix, cVar, canvas);
        } else {
            a_renamed(bVarG, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a_renamed(com.airbnb.lottie.c_renamed.b_renamed bVar, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.c_renamed cVar, android.graphics.Canvas canvas) {
        float fFloatValue;
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar = this.x_renamed;
        if (aVar != null) {
            fFloatValue = aVar.g_renamed().floatValue();
        } else {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2 = this.w_renamed;
            if (aVar2 != null) {
                fFloatValue = aVar2.g_renamed().floatValue();
            } else {
                fFloatValue = bVar.f2067c;
            }
        }
        float f_renamed = fFloatValue / 100.0f;
        float fA_renamed = com.airbnb.lottie.f_renamed.h_renamed.a_renamed(matrix);
        java.lang.String str = bVar.f2065a;
        float fA2 = bVar.f_renamed * com.airbnb.lottie.f_renamed.h_renamed.a_renamed();
        java.util.List<java.lang.String> listA = a_renamed(str);
        int size = listA.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String str2 = listA.get(i_renamed);
            float fA3 = a_renamed(str2, cVar, f_renamed, fA_renamed);
            canvas.save();
            a_renamed(bVar.d_renamed, canvas, fA3);
            canvas.translate(0.0f, (i_renamed * fA2) - (((size - 1) * fA2) / 2.0f));
            a_renamed(str2, bVar, matrix, cVar, canvas, fA_renamed, f_renamed);
            canvas.restore();
        }
    }

    private void a_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed bVar, android.graphics.Matrix matrix, com.airbnb.lottie.c_renamed.c_renamed cVar, android.graphics.Canvas canvas, float f_renamed, float f2) {
        float fFloatValue;
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            com.airbnb.lottie.c_renamed.d_renamed dVar = this.n_renamed.j_renamed().get(com.airbnb.lottie.c_renamed.d_renamed.a_renamed(str.charAt(i_renamed), cVar.a_renamed(), cVar.c_renamed()));
            if (dVar != null) {
                a_renamed(dVar, matrix, f2, bVar, canvas);
                float fB_renamed = ((float) dVar.b_renamed()) * f2 * com.airbnb.lottie.f_renamed.h_renamed.a_renamed() * f_renamed;
                float f3 = bVar.e_renamed / 10.0f;
                com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar = this.v_renamed;
                if (aVar != null) {
                    fFloatValue = aVar.g_renamed().floatValue();
                } else {
                    com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2 = this.u_renamed;
                    if (aVar2 != null) {
                        fFloatValue = aVar2.g_renamed().floatValue();
                    }
                    canvas.translate(fB_renamed + (f3 * f_renamed), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fB_renamed + (f3 * f_renamed), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x00a7 A_renamed[LOOP:0: B_renamed:23:0x00a5->B_renamed:24:0x00a7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(com.airbnb.lottie.c_renamed.b_renamed r7, com.airbnb.lottie.c_renamed.c_renamed r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(r9)
            com.airbnb.lottie.f_renamed r9 = r6.m_renamed
            java.lang.String r0 = r8.a_renamed()
            java.lang.String r8 = r8.c_renamed()
            android.graphics.Typeface r8 = r9.a_renamed(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.f2065a
            com.airbnb.lottie.f_renamed r0 = r6.m_renamed
            com.airbnb.lottie.q_renamed r0 = r0.q_renamed()
            if (r0 == 0) goto L22
            java.lang.String r9 = r0.a_renamed(r9)
        L22:
            android.graphics.Paint r0 = r6.h_renamed
            r0.setTypeface(r8)
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> r8 = r6.x_renamed
            if (r8 == 0) goto L36
            java.lang.Object r8 = r8.g_renamed()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L36:
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> r8 = r6.w_renamed
            if (r8 == 0) goto L45
            java.lang.Object r8 = r8.g_renamed()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L45:
            float r8 = r7.f2067c
        L47:
            android.graphics.Paint r0 = r6.h_renamed
            float r1 = com.airbnb.lottie.f_renamed.h_renamed.a_renamed()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.i_renamed
            android.graphics.Paint r1 = r6.h_renamed
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.i_renamed
            android.graphics.Paint r1 = r6.h_renamed
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f_renamed
            float r1 = com.airbnb.lottie.f_renamed.h_renamed.a_renamed()
            float r0 = r0 * r1
            int r1 = r7.e_renamed
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> r2 = r6.v_renamed
            if (r2 == 0) goto L84
            java.lang.Object r2 = r2.g_renamed()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L82:
            float r1 = r1 + r2
            goto L93
        L84:
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> r2 = r6.u_renamed
            if (r2 == 0) goto L93
            java.lang.Object r2 = r2.g_renamed()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L82
        L93:
            float r2 = com.airbnb.lottie.f_renamed.h_renamed.a_renamed()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.a_renamed(r9)
            int r9 = r8.size()
            r2 = 0
        La5:
            if (r2 >= r9) goto Ldb
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.i_renamed
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.c_renamed.b_renamed$a_renamed r5 = r7.d_renamed
            r6.a_renamed(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.a_renamed(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La5
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c_renamed.c_renamed.h_renamed.a_renamed(com.airbnb.lottie.c_renamed.b_renamed, com.airbnb.lottie.c_renamed.c_renamed, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private java.util.List<java.lang.String> a_renamed(java.lang.String str) {
        return java.util.Arrays.asList(str.replaceAll("\r_renamed\n_renamed", "\r_renamed").replaceAll("\n_renamed", "\r_renamed").split("\r_renamed"));
    }

    private void a_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed bVar, android.graphics.Canvas canvas, float f_renamed) {
        int length = 0;
        while (length < str.length()) {
            java.lang.String strA = a_renamed(str, length);
            length += strA.length();
            a_renamed(strA, bVar, canvas);
            canvas.translate(this.h_renamed.measureText(strA) + f_renamed, 0.0f);
        }
    }

    private float a_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.c_renamed cVar, float f_renamed, float f2) {
        float fB_renamed = 0.0f;
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            com.airbnb.lottie.c_renamed.d_renamed dVar = this.n_renamed.j_renamed().get(com.airbnb.lottie.c_renamed.d_renamed.a_renamed(str.charAt(i_renamed), cVar.a_renamed(), cVar.c_renamed()));
            if (dVar != null) {
                fB_renamed = (float) (fB_renamed + (dVar.b_renamed() * f_renamed * com.airbnb.lottie.f_renamed.h_renamed.a_renamed() * f2));
            }
        }
        return fB_renamed;
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.airbnb.lottie.c_renamed.c_renamed.h_renamed$3, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_6 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2129a = new int[com.airbnb.lottie.c_renamed.b_renamed.a_renamed.values().length];

        static {
            try {
                f2129a[com.airbnb.lottie.c_renamed.b_renamed.a_renamed.LEFT_ALIGN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2129a[com.airbnb.lottie.c_renamed.b_renamed.a_renamed.RIGHT_ALIGN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2129a[com.airbnb.lottie.c_renamed.b_renamed.a_renamed.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private void a_renamed(com.airbnb.lottie.c_renamed.b_renamed.a_renamed aVar, android.graphics.Canvas canvas, float f_renamed) {
        int i_renamed = com.airbnb.lottie.c_renamed.c_renamed.h_renamed.ParameterContainer_6.f2129a[aVar.ordinal()];
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                canvas.translate(-f_renamed, 0.0f);
            } else {
                if (i_renamed != 3) {
                    return;
                }
                canvas.translate((-f_renamed) / 2.0f, 0.0f);
            }
        }
    }

    private void a_renamed(com.airbnb.lottie.c_renamed.d_renamed dVar, android.graphics.Matrix matrix, float f_renamed, com.airbnb.lottie.c_renamed.b_renamed bVar, android.graphics.Canvas canvas) {
        java.util.List<com.airbnb.lottie.a_renamed.a_renamed.d_renamed> listA = a_renamed(dVar);
        for (int i_renamed = 0; i_renamed < listA.size(); i_renamed++) {
            android.graphics.Path pathE = listA.get(i_renamed).e_renamed();
            pathE.computeBounds(this.f_renamed, false);
            this.g_renamed.set(matrix);
            this.g_renamed.preTranslate(0.0f, (-bVar.g_renamed) * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
            this.g_renamed.preScale(f_renamed, f_renamed);
            pathE.transform(this.g_renamed);
            if (bVar.k_renamed) {
                a_renamed(pathE, this.h_renamed, canvas);
                a_renamed(pathE, this.i_renamed, canvas);
            } else {
                a_renamed(pathE, this.i_renamed, canvas);
                a_renamed(pathE, this.h_renamed, canvas);
            }
        }
    }

    private void a_renamed(android.graphics.Path path, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed bVar, android.graphics.Canvas canvas) {
        if (bVar.k_renamed) {
            a_renamed(str, this.h_renamed, canvas);
            a_renamed(str, this.i_renamed, canvas);
        } else {
            a_renamed(str, this.i_renamed, canvas);
            a_renamed(str, this.h_renamed, canvas);
        }
    }

    private void a_renamed(java.lang.String str, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private java.util.List<com.airbnb.lottie.a_renamed.a_renamed.d_renamed> a_renamed(com.airbnb.lottie.c_renamed.d_renamed dVar) {
        if (this.j_renamed.containsKey(dVar)) {
            return this.j_renamed.get(dVar);
        }
        java.util.List<com.airbnb.lottie.c_renamed.b_renamed.n_renamed> listA = dVar.a_renamed();
        int size = listA.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            arrayList.add(new com.airbnb.lottie.a_renamed.a_renamed.d_renamed(this.m_renamed, this, listA.get(i_renamed)));
        }
        this.j_renamed.put(dVar, arrayList);
        return arrayList;
    }

    private java.lang.String a_renamed(java.lang.String str, int i_renamed) {
        int iCodePointAt = str.codePointAt(i_renamed);
        int iCharCount = java.lang.Character.charCount(iCodePointAt) + i_renamed;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!a_renamed(iCodePointAt2)) {
                break;
            }
            iCharCount += java.lang.Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j_renamed = iCodePointAt;
        if (this.k_renamed.containsKey(j_renamed)) {
            return this.k_renamed.get(j_renamed);
        }
        this.e_renamed.setLength(0);
        while (i_renamed < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i_renamed);
            this.e_renamed.appendCodePoint(iCodePointAt3);
            i_renamed += java.lang.Character.charCount(iCodePointAt3);
        }
        java.lang.String string = this.e_renamed.toString();
        this.k_renamed.put(j_renamed, string);
        return string;
    }

    private boolean a_renamed(int i_renamed) {
        return java.lang.Character.getType(i_renamed) == 16 || java.lang.Character.getType(i_renamed) == 27 || java.lang.Character.getType(i_renamed) == 6 || java.lang.Character.getType(i_renamed) == 28 || java.lang.Character.getType(i_renamed) == 19;
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        super.a_renamed((com.airbnb.lottie.c_renamed.c_renamed.h_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.c_renamed.c_renamed.h_renamed>) cVar);
        if (t_renamed == com.airbnb.lottie.k_renamed.f2277a) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar = this.p_renamed;
            if (aVar != null) {
                b_renamed(aVar);
            }
            if (cVar == null) {
                this.p_renamed = null;
                return;
            }
            this.p_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.p_renamed.a_renamed(this);
            a_renamed(this.p_renamed);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.f2278b) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2 = this.r_renamed;
            if (aVar2 != null) {
                b_renamed(aVar2);
            }
            if (cVar == null) {
                this.r_renamed = null;
                return;
            }
            this.r_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.r_renamed.a_renamed(this);
            a_renamed(this.r_renamed);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.q_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar3 = this.t_renamed;
            if (aVar3 != null) {
                b_renamed(aVar3);
            }
            if (cVar == null) {
                this.t_renamed = null;
                return;
            }
            this.t_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.t_renamed.a_renamed(this);
            a_renamed(this.t_renamed);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.r_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar4 = this.v_renamed;
            if (aVar4 != null) {
                b_renamed(aVar4);
            }
            if (cVar == null) {
                this.v_renamed = null;
                return;
            }
            this.v_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.v_renamed.a_renamed(this);
            a_renamed(this.v_renamed);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.D_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar5 = this.x_renamed;
            if (aVar5 != null) {
                b_renamed(aVar5);
            }
            if (cVar == null) {
                this.x_renamed = null;
                return;
            }
            this.x_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.x_renamed.a_renamed(this);
            a_renamed(this.x_renamed);
        }
    }
}
