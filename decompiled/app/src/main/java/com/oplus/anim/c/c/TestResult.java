package com.oplus.anim.c_renamed.c_renamed;

/* compiled from: TextLayer.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.anim.c_renamed.c_renamed.a_renamed {
    private final char[] e_renamed;
    private final android.graphics.RectF f_renamed;
    private final android.graphics.Matrix g_renamed;
    private final android.graphics.Paint h_renamed;
    private final android.graphics.Paint i_renamed;
    private final java.util.Map<com.oplus.anim.c_renamed.e_renamed, java.util.List<com.oplus.anim.a_renamed.a_renamed.d_renamed>> j_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.n_renamed k_renamed;
    private final com.oplus.anim.b_renamed l_renamed;
    private final com.oplus.anim.a_renamed m_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> n_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> o_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> p_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> q_renamed;

    h_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.d_renamed dVar) {
        super(bVar, dVar);
        int i_renamed = 1;
        this.e_renamed = new char[1];
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = new android.graphics.Matrix();
        this.h_renamed = new android.graphics.Paint(i_renamed) { // from class: com.oplus.anim.c_renamed.c_renamed.h_renamed.1
            {
                setStyle(android.graphics.Paint.Style.FILL);
            }
        };
        this.i_renamed = new android.graphics.Paint(i_renamed) { // from class: com.oplus.anim.c_renamed.c_renamed.h_renamed.2
            {
                setStyle(android.graphics.Paint.Style.STROKE);
            }
        };
        this.j_renamed = new java.util.HashMap();
        this.l_renamed = bVar;
        this.m_renamed = dVar.a_renamed();
        this.k_renamed = dVar.s_renamed().a_renamed();
        this.k_renamed.a_renamed(this);
        a_renamed(this.k_renamed);
        com.oplus.anim.c_renamed.a_renamed.k_renamed kVarT = dVar.t_renamed();
        if (kVarT != null && kVarT.f3556a != null) {
            this.n_renamed = kVarT.f3556a.a_renamed();
            this.n_renamed.a_renamed(this);
            a_renamed(this.n_renamed);
        }
        if (kVarT != null && kVarT.f3557b != null) {
            this.o_renamed = kVarT.f3557b.a_renamed();
            this.o_renamed.a_renamed(this);
            a_renamed(this.o_renamed);
        }
        if (kVarT != null && kVarT.f3558c != null) {
            this.p_renamed = kVarT.f3558c.a_renamed();
            this.p_renamed.a_renamed(this);
            a_renamed(this.p_renamed);
        }
        if (kVarT == null || kVarT.d_renamed == null) {
            return;
        }
        this.q_renamed = kVarT.d_renamed.a_renamed();
        this.q_renamed.a_renamed(this);
        a_renamed(this.q_renamed);
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        rectF.set(0.0f, 0.0f, this.m_renamed.d_renamed().width(), this.m_renamed.d_renamed().height());
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.oplus.anim.k_renamed.c_renamed("TextLayer#draw");
        canvas.save();
        if (!this.l_renamed.p_renamed()) {
            canvas.setMatrix(matrix);
        }
        com.oplus.anim.c_renamed.b_renamed bVarG = this.k_renamed.g_renamed();
        com.oplus.anim.c_renamed.d_renamed dVar = this.m_renamed.k_renamed().get(bVarG.f3564b);
        if (dVar == null) {
            canvas.restore();
            return;
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar = this.n_renamed;
        if (aVar != null) {
            this.h_renamed.setColor(aVar.g_renamed().intValue());
        } else {
            this.h_renamed.setColor(bVarG.h_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar2 = this.o_renamed;
        if (aVar2 != null) {
            this.i_renamed.setColor(aVar2.g_renamed().intValue());
        } else {
            this.i_renamed.setColor(bVarG.i_renamed);
        }
        int iIntValue = ((this.d_renamed.a_renamed() == null ? 100 : this.d_renamed.a_renamed().g_renamed().intValue()) * 255) / 100;
        this.h_renamed.setAlpha(iIntValue);
        this.i_renamed.setAlpha(iIntValue);
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar3 = this.p_renamed;
        if (aVar3 != null) {
            this.i_renamed.setStrokeWidth(aVar3.g_renamed().floatValue());
        } else {
            this.i_renamed.setStrokeWidth((float) (bVarG.j_renamed * com.oplus.anim.f_renamed.g_renamed.a_renamed() * com.oplus.anim.f_renamed.g_renamed.a_renamed(matrix)));
        }
        if (this.l_renamed.p_renamed()) {
            a_renamed(bVarG, matrix, dVar, canvas);
        } else {
            a_renamed(bVarG, dVar, matrix, canvas);
        }
        canvas.restore();
        com.oplus.anim.k_renamed.d_renamed("TextLayer#draw");
    }

    private void a_renamed(com.oplus.anim.c_renamed.b_renamed bVar, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.d_renamed dVar, android.graphics.Canvas canvas) {
        float f_renamed = ((float) bVar.f3565c) / 100.0f;
        float fA_renamed = com.oplus.anim.f_renamed.g_renamed.a_renamed(matrix);
        java.lang.String str = bVar.f3563a;
        float fA2 = ((float) bVar.f_renamed) * com.oplus.anim.f_renamed.g_renamed.a_renamed();
        java.util.List<java.lang.String> listA = a_renamed(str);
        int size = listA.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String str2 = listA.get(i_renamed);
            float fA3 = a_renamed(str2, dVar, f_renamed, fA_renamed);
            canvas.save();
            a_renamed(bVar.d_renamed, canvas, fA3);
            canvas.translate(0.0f, (i_renamed * fA2) - (((size - 1) * fA2) / 2.0f));
            a_renamed(str2, bVar, matrix, dVar, canvas, fA_renamed, f_renamed);
            canvas.restore();
        }
    }

    private void a_renamed(java.lang.String str, com.oplus.anim.c_renamed.b_renamed bVar, android.graphics.Matrix matrix, com.oplus.anim.c_renamed.d_renamed dVar, android.graphics.Canvas canvas, float f_renamed, float f2) {
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            com.oplus.anim.c_renamed.e_renamed eVar = this.m_renamed.j_renamed().get(com.oplus.anim.c_renamed.e_renamed.a_renamed(str.charAt(i_renamed), dVar.a_renamed(), dVar.c_renamed()));
            if (eVar != null) {
                a_renamed(eVar, matrix, f2, bVar, canvas);
                float fB_renamed = ((float) eVar.b_renamed()) * f2 * com.oplus.anim.f_renamed.g_renamed.a_renamed() * f_renamed;
                float fFloatValue = bVar.e_renamed / 10.0f;
                com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar = this.q_renamed;
                if (aVar != null) {
                    fFloatValue += aVar.g_renamed().floatValue();
                }
                canvas.translate(fB_renamed + (fFloatValue * f_renamed), 0.0f);
            }
        }
    }

    private void a_renamed(com.oplus.anim.c_renamed.b_renamed bVar, com.oplus.anim.c_renamed.d_renamed dVar, android.graphics.Matrix matrix, android.graphics.Canvas canvas) {
        android.graphics.Typeface typefaceA;
        float fA_renamed = com.oplus.anim.f_renamed.g_renamed.a_renamed(matrix);
        if (!android.text.TextUtils.isEmpty(dVar.a_renamed()) && dVar.a_renamed().contains("ColorFont")) {
            typefaceA = com.oplus.anim.f_renamed.g_renamed.a_renamed(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0), dVar.c_renamed());
        } else {
            typefaceA = this.l_renamed.a_renamed(dVar.a_renamed(), dVar.c_renamed());
        }
        if (typefaceA == null) {
            return;
        }
        java.lang.String strA = bVar.f3563a;
        com.oplus.anim.p_renamed pVarO = this.l_renamed.o_renamed();
        if (pVarO != null) {
            strA = pVarO.a_renamed(strA);
        }
        this.h_renamed.setTypeface(typefaceA);
        this.h_renamed.setTextSize((float) (bVar.f3565c * com.oplus.anim.f_renamed.g_renamed.a_renamed()));
        this.i_renamed.setTypeface(this.h_renamed.getTypeface());
        this.i_renamed.setTextSize(this.h_renamed.getTextSize());
        float fA2 = ((float) bVar.f_renamed) * com.oplus.anim.f_renamed.g_renamed.a_renamed();
        java.util.List<java.lang.String> listA = a_renamed(strA);
        int size = listA.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String str = listA.get(i_renamed);
            a_renamed(bVar.d_renamed, canvas, this.i_renamed.measureText(str));
            canvas.translate(0.0f, (i_renamed * fA2) - (((size - 1) * fA2) / 2.0f));
            a_renamed(str, bVar, canvas, fA_renamed);
            canvas.setMatrix(matrix);
        }
    }

    private java.util.List<java.lang.String> a_renamed(java.lang.String str) {
        return java.util.Arrays.asList(str.replaceAll("\r_renamed\n_renamed", "\r_renamed").replaceAll("\n_renamed", "\r_renamed").split("\r_renamed"));
    }

    private void a_renamed(java.lang.String str, com.oplus.anim.c_renamed.b_renamed bVar, android.graphics.Canvas canvas, float f_renamed) {
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            a_renamed(cCharAt, bVar, canvas);
            char[] cArr = this.e_renamed;
            cArr[0] = cCharAt;
            float fMeasureText = this.h_renamed.measureText(cArr, 0, 1);
            float fFloatValue = bVar.e_renamed / 10.0f;
            com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar = this.q_renamed;
            if (aVar != null) {
                fFloatValue += aVar.g_renamed().floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * f_renamed), 0.0f);
        }
    }

    private float a_renamed(java.lang.String str, com.oplus.anim.c_renamed.d_renamed dVar, float f_renamed, float f2) {
        float fB_renamed = 0.0f;
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            com.oplus.anim.c_renamed.e_renamed eVar = this.m_renamed.j_renamed().get(com.oplus.anim.c_renamed.e_renamed.a_renamed(str.charAt(i_renamed), dVar.a_renamed(), dVar.c_renamed()));
            if (eVar != null) {
                fB_renamed = (float) (fB_renamed + (eVar.b_renamed() * f_renamed * com.oplus.anim.f_renamed.g_renamed.a_renamed() * f2));
            }
        }
        return fB_renamed;
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.oplus.anim.c_renamed.c_renamed.h_renamed$3, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_6 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3627a = new int[com.oplus.anim.c_renamed.b_renamed.a_renamed.values().length];

        static {
            try {
                f3627a[com.oplus.anim.c_renamed.b_renamed.a_renamed.LEFT_ALIGN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3627a[com.oplus.anim.c_renamed.b_renamed.a_renamed.RIGHT_ALIGN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f3627a[com.oplus.anim.c_renamed.b_renamed.a_renamed.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private void a_renamed(com.oplus.anim.c_renamed.b_renamed.a_renamed aVar, android.graphics.Canvas canvas, float f_renamed) {
        int i_renamed = com.oplus.anim.c_renamed.c_renamed.h_renamed.ParameterContainer_6.f3627a[aVar.ordinal()];
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

    private void a_renamed(com.oplus.anim.c_renamed.e_renamed eVar, android.graphics.Matrix matrix, float f_renamed, com.oplus.anim.c_renamed.b_renamed bVar, android.graphics.Canvas canvas) {
        java.util.List<com.oplus.anim.a_renamed.a_renamed.d_renamed> listA = a_renamed(eVar);
        for (int i_renamed = 0; i_renamed < listA.size(); i_renamed++) {
            android.graphics.Path pathE = listA.get(i_renamed).e_renamed();
            pathE.computeBounds(this.f_renamed, false);
            this.g_renamed.set(matrix);
            this.g_renamed.preTranslate(0.0f, ((float) (-bVar.g_renamed)) * com.oplus.anim.f_renamed.g_renamed.a_renamed());
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

    private void a_renamed(char c2, com.oplus.anim.c_renamed.b_renamed bVar, android.graphics.Canvas canvas) {
        this.e_renamed[0] = c2;
        if (bVar.k_renamed) {
            a_renamed(this.e_renamed, this.h_renamed, canvas);
            a_renamed(this.e_renamed, this.i_renamed, canvas);
        } else {
            a_renamed(this.e_renamed, this.i_renamed, canvas);
            a_renamed(this.e_renamed, this.h_renamed, canvas);
        }
    }

    private void a_renamed(char[] cArr, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private java.util.List<com.oplus.anim.a_renamed.a_renamed.d_renamed> a_renamed(com.oplus.anim.c_renamed.e_renamed eVar) {
        if (this.j_renamed.containsKey(eVar)) {
            return this.j_renamed.get(eVar);
        }
        java.util.List<com.oplus.anim.c_renamed.b_renamed.n_renamed> listA = eVar.a_renamed();
        int size = listA.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            arrayList.add(new com.oplus.anim.a_renamed.a_renamed.d_renamed(this.l_renamed, this, listA.get(i_renamed)));
        }
        this.j_renamed.put(eVar, arrayList);
        return arrayList;
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar3;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar4;
        super.a_renamed((com.oplus.anim.c_renamed.c_renamed.h_renamed) t_renamed, (com.oplus.anim.g_renamed.b_renamed<com.oplus.anim.c_renamed.c_renamed.h_renamed>) bVar);
        if (t_renamed == com.oplus.anim.d_renamed.f3641a && (aVar4 = this.n_renamed) != null) {
            aVar4.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.f3642b && (aVar3 = this.o_renamed) != null) {
            aVar3.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.m_renamed && (aVar2 = this.p_renamed) != null) {
            aVar2.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
        } else {
            if (t_renamed != com.oplus.anim.d_renamed.n_renamed || (aVar = this.q_renamed) == null) {
                return;
            }
            aVar.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
        }
    }
}
