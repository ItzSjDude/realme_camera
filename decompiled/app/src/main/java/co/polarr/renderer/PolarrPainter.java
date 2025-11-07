package co_renamed.polarr.renderer;

/* loaded from: classes.dex */
public class PolarrPainter {
    public static final float BUFFER_THES = 5.0f;
    public static final float DETLA_MOVEMENT = 10.0f;
    public static final android.graphics.PorterDuffXfermode K_renamed = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN);
    public static final float MAX_FADE_THRES = 20.0f;
    public static final boolean USE_PATH_HISTORY = true;
    public android.graphics.PathMeasure A_renamed;
    public float B_renamed;
    public int C_renamed;
    public int D_renamed;
    public float E_renamed;
    public float F_renamed;
    public float G_renamed;
    public int H_renamed;
    public co_renamed.polarr.renderer.PolarrPainter.BrushStyle I_renamed;
    public android.graphics.Canvas J_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public final android.content.Context f1929a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.graphics.Bitmap f1930b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.graphics.Bitmap f1931c;
    public android.graphics.Bitmap d_renamed;
    public android.graphics.Bitmap e_renamed;
    public android.graphics.Bitmap f_renamed;
    public android.graphics.Bitmap g_renamed;
    public double s_renamed;
    public float t_renamed;
    public float u_renamed;
    public int v_renamed;
    public android.graphics.Path z_renamed;
    public co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL q_renamed = co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.IDLE;
    public co_renamed.polarr.renderer.PolarrPainter.BrushStyle r_renamed = null;
    public java.util.List<co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH> x_renamed = new java.util.ArrayList();
    public float[] n_renamed = new float[2];
    public float[] o_renamed = new float[2];
    public float[] w_renamed = new float[2];
    public android.graphics.Paint h_renamed = new android.graphics.Paint();
    public android.graphics.Paint i_renamed = new android.graphics.Paint();
    public android.graphics.Canvas l_renamed = new android.graphics.Canvas();
    public android.graphics.Canvas k_renamed = new android.graphics.Canvas();
    public android.graphics.Canvas m_renamed = new android.graphics.Canvas();
    public android.graphics.Canvas j_renamed = new android.graphics.Canvas();
    public android.graphics.Matrix p_renamed = new android.graphics.Matrix();
    public int y_renamed = 0;

    public enum BrushStyle {
        MARKER("brush/brush8.png", 0.04f, 5.0f, 0.0f, 1, 0.8f, false),
        PENCIL("brush/dot10.png", 0.1f, 360.0f, 0.5f, 5, 1.0f, true),
        PAINTING("brush/pen2.png", 0.025f, 0.0f, 0.0f, 1, 1.0f, false);

        public final boolean canFade;
        public final int maxFlow;
        public final float maxRot;
        public final float paintAlpha;
        public final float randomRange;
        public final java.lang.String resName;
        public final float spacing;

        BrushStyle(java.lang.String str, float f_renamed, float f2, float f3, int i_renamed, float f4, boolean z_renamed) {
            this.resName = str;
            this.spacing = f_renamed;
            this.maxRot = f2;
            this.randomRange = f3;
            this.maxFlow = i_renamed;
            this.paintAlpha = f4;
            this.canFade = z_renamed;
        }
    }

    public static /* synthetic */ class porender_YuvEf {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final /* synthetic */ int[] f1932a = new int[co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.values().length];

        static {
            try {
                f1932a[co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.IDLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1932a[co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.START.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1932a[co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.MOVE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1932a[co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.DONE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public class porender_iuAiH {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f1933a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f1934b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f1935c;
        public float d_renamed;
        public boolean e_renamed;
        public co_renamed.polarr.renderer.PolarrPainter.BrushStyle f_renamed;
        public android.graphics.Path g_renamed;
        public boolean h_renamed;

        public porender_iuAiH(co_renamed.polarr.renderer.PolarrPainter polarrPainter) {
        }

        public /* synthetic */ porender_iuAiH(co_renamed.polarr.renderer.PolarrPainter polarrPainter, co_renamed.polarr.renderer.PolarrPainter.porender_YuvEf porender_yuvef) {
            this(polarrPainter);
        }
    }

    public enum porender_qbdmL {
        IDLE,
        START,
        MOVE,
        DONE
    }

    public PolarrPainter(android.content.Context context) {
        this.f1929a = context;
        updateBrushStyle(co_renamed.polarr.renderer.PolarrPainter.BrushStyle.MARKER);
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, android.graphics.Rect rect) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(rect.width(), rect.height(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postTranslate(-rect.left, -rect.top);
        canvas.drawBitmap(bitmap, matrix, null);
        return bitmapCreateBitmap;
    }

    public final void a_renamed() {
        this.l_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        this.m_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        this.k_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        this.j_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a_renamed(int r10) {
        /*
            r9 = this;
            android.graphics.Picture r0 = new android.graphics.Picture
            r0.<init>()
            android.graphics.Bitmap r1 = r9.e_renamed
            int r1 = r1.getWidth()
            android.graphics.Bitmap r2 = r9.e_renamed
            int r2 = r2.getHeight()
            android.graphics.Canvas r1 = r0.beginRecording(r1, r2)
            r9.l_renamed = r1
            java.util.List<co_renamed.polarr.renderer.PolarrPainter$porender_iuAiH> r1 = r9.x_renamed
            java.lang.Object r10 = r1.get(r10)
            co_renamed.polarr.renderer.PolarrPainter$porender_iuAiH r10 = (co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH) r10
            boolean r1 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.a_renamed(r10)
            if (r1 == 0) goto L29
            r9.a_renamed()
            return
        L29:
            android.graphics.PathMeasure r1 = new android.graphics.PathMeasure
            r1.<init>()
            co_renamed.polarr.renderer.PolarrPainter$BrushStyle r2 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.g_renamed(r10)
            co_renamed.polarr.renderer.PolarrPainter$BrushStyle r3 = r9.r_renamed
            if (r2 == r3) goto L4d
            co_renamed.polarr.renderer.PolarrPainter$BrushStyle r2 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.g_renamed(r10)
            r9.updateBrushStyle(r2)
        L3d:
            float r2 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.h_renamed(r10)
            float r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.c_renamed(r10)
            int r4 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.b_renamed(r10)
            r9.updateBrushSize(r2, r3, r4)
            goto L6a
        L4d:
            float r2 = r9.t_renamed
            float r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.h_renamed(r10)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L3d
            float r2 = r9.u_renamed
            float r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.c_renamed(r10)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L3d
            int r2 = r9.v_renamed
            int r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.b_renamed(r10)
            if (r2 == r3) goto L6a
            goto L3d
        L6a:
            r2 = 0
            r9.B_renamed = r2
            android.graphics.Path r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.f_renamed(r10)
            r4 = 0
            r1.setPath(r3, r4)
            float r3 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.e_renamed(r10)
            float r5 = r9.B_renamed
            float r6 = r9.E_renamed
            r7 = 1084227584(0x40a00000, float:5.0)
            float r7 = r7 * r6
            r8 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 * r7
            float r5 = r5 + r8
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L8c
            float r3 = r3 - r7
            r9.a_renamed(r1, r3, r6, r4)
        L8c:
            float r3 = r1.getLength()
            float r5 = r9.E_renamed
            boolean r10 = co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH.d_renamed(r10)
            r9.a_renamed(r1, r3, r5, r10)
            r0.endRecording()
            android.graphics.Canvas r10 = r9.J_renamed
            r0.draw(r10)
            android.graphics.Paint r10 = r9.h_renamed
            r0 = 0
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.k_renamed
            float r1 = r9.u_renamed
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            int r3 = r9.v_renamed
            int r3 = android.graphics.Color.red(r3)
            int r5 = r9.v_renamed
            int r5 = android.graphics.Color.green(r5)
            int r6 = r9.v_renamed
            int r6 = android.graphics.Color.blue(r6)
            int r1 = android.graphics.Color.argb(r1, r3, r5, r6)
            r10.drawColor(r1)
            android.graphics.Paint r10 = r9.h_renamed
            android.graphics.PorterDuffXfermode r1 = co_renamed.polarr.renderer.PolarrPainter.K_renamed
            r10.setXfermode(r1)
            android.graphics.Canvas r10 = r9.k_renamed
            android.graphics.Bitmap r1 = r9.e_renamed
            android.graphics.Paint r3 = r9.h_renamed
            r10.drawBitmap(r1, r2, r2, r3)
            android.graphics.Paint r10 = r9.h_renamed
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.j_renamed
            android.graphics.Bitmap r1 = r9.f1930b
            r10.drawBitmap(r1, r2, r2, r0)
            android.graphics.Canvas r10 = r9.k_renamed
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.CLEAR
            r10.drawColor(r4, r0)
            android.graphics.Canvas r9 = r9.J_renamed
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.CLEAR
            r9.drawColor(r4, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co_renamed.polarr.renderer.PolarrPainter.a_renamed(int):void");
    }

    public final void a_renamed(android.graphics.Bitmap bitmap, float f_renamed) {
        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            int i2 = iArr[i_renamed];
            if (android.graphics.Color.alpha(i2) != 0) {
                int iAlpha = (int) (android.graphics.Color.alpha(i2) * f_renamed);
                if (iAlpha > 0) {
                    iArr[i_renamed] = android.graphics.Color.argb(iAlpha, android.graphics.Color.red(i2), android.graphics.Color.green(i2), android.graphics.Color.blue(i2));
                } else {
                    iArr[i_renamed] = 0;
                }
            }
        }
        bitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public final void a_renamed(android.graphics.PathMeasure pathMeasure, float f_renamed, float f2, boolean z_renamed) {
        float f3 = this.B_renamed;
        while (true) {
            float f4 = this.B_renamed;
            if (f4 >= f_renamed) {
                break;
            }
            pathMeasure.getPosTan(f4, this.o_renamed, this.w_renamed);
            float[] fArr = this.w_renamed;
            double dAtan2 = java.lang.Math.atan2(fArr[0], fArr[1]);
            if (this.B_renamed == 0.0f) {
                this.s_renamed = dAtan2;
            }
            double dMax = java.lang.Math.max(this.s_renamed - this.r_renamed.maxRot, java.lang.Math.min(this.s_renamed + this.r_renamed.maxRot, dAtan2));
            double dRandom = dMax;
            for (int i_renamed = 0; i_renamed < this.r_renamed.maxFlow; i_renamed++) {
                if (this.r_renamed.randomRange > 0.0f) {
                    dRandom = (java.lang.Math.random() * 360.0d * this.r_renamed.randomRange) + dMax;
                }
                this.p_renamed.reset();
                this.p_renamed.postTranslate((-this.C_renamed) / 2.0f, ((-this.D_renamed) / 2.0f) + 0.0f);
                this.p_renamed.postRotate((float) dRandom, 0.0f, 0.0f);
                android.graphics.Matrix matrix = this.p_renamed;
                float[] fArr2 = this.o_renamed;
                matrix.postTranslate(fArr2[0], fArr2[1]);
                if (z_renamed) {
                    this.i_renamed.setAlpha((int) (this.u_renamed * this.r_renamed.paintAlpha * 255.0f * ((f_renamed - this.B_renamed) / (f_renamed - f3))));
                }
                this.l_renamed.drawBitmap(this.g_renamed, this.p_renamed, this.i_renamed);
            }
            this.B_renamed += f2;
        }
        if (z_renamed) {
            this.i_renamed = new android.graphics.Paint();
        }
    }

    public final void a_renamed(co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL porender_qbdml, float[] fArr, float[] fArr2) {
        int i_renamed = co_renamed.polarr.renderer.PolarrPainter.porender_YuvEf.f1932a[porender_qbdml.ordinal()];
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                float[] fArr3 = this.n_renamed;
                fArr3[0] = fArr[0];
                fArr3[1] = fArr[1];
                this.B_renamed = 0.0f;
                this.z_renamed = new android.graphics.Path();
                this.A_renamed = new android.graphics.PathMeasure();
                this.q_renamed = porender_qbdml;
                this.z_renamed.moveTo(fArr[0], fArr[1]);
                return;
            }
            co_renamed.polarr.renderer.PolarrPainter.porender_YuvEf porender_yuvef = null;
            if (i_renamed != 3) {
                if (i_renamed != 4) {
                    return;
                }
                float f_renamed = fArr[0];
                float[] fArr4 = this.n_renamed;
                this.z_renamed.quadTo(fArr4[0], fArr4[1], (f_renamed + fArr4[0]) / 2.0f, (fArr[1] + fArr4[1]) / 2.0f);
                float[] fArr5 = this.n_renamed;
                fArr5[0] = fArr[0];
                fArr5[1] = fArr[1];
                this.A_renamed.setPath(this.z_renamed, false);
                float length = this.A_renamed.getLength();
                boolean z_renamed = fArr2 != null && this.r_renamed.canFade && a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr2, this.n_renamed) > this.E_renamed * 20.0f;
                co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH porender_iuaih = new co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH(this, porender_yuvef);
                porender_iuaih.f1933a = this.B_renamed;
                a_renamed(this.A_renamed, length, this.E_renamed, z_renamed);
                d_renamed();
                porender_iuaih.g_renamed = this.z_renamed;
                porender_iuaih.f_renamed = this.r_renamed;
                porender_iuaih.f1934b = this.t_renamed;
                porender_iuaih.f1935c = this.v_renamed;
                porender_iuaih.d_renamed = this.u_renamed;
                porender_iuaih.e_renamed = z_renamed;
                this.y_renamed++;
                this.x_renamed.add(porender_iuaih);
                this.h_renamed.setXfermode(null);
                this.k_renamed.drawColor(android.graphics.Color.argb((int) (this.u_renamed * 255.0f), android.graphics.Color.red(this.v_renamed), android.graphics.Color.green(this.v_renamed), android.graphics.Color.blue(this.v_renamed)));
                this.h_renamed.setXfermode(K_renamed);
                this.k_renamed.drawBitmap(this.e_renamed, 0.0f, 0.0f, this.h_renamed);
                this.h_renamed.setXfermode(null);
                this.j_renamed.drawBitmap(this.f1930b, 0.0f, 0.0f, (android.graphics.Paint) null);
                this.k_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                this.l_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                porender_qbdml = co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.IDLE;
            } else {
                if (a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr, this.n_renamed) <= 10.0f) {
                    return;
                }
                float f2 = fArr[0];
                float[] fArr6 = this.n_renamed;
                this.z_renamed.quadTo(fArr6[0], fArr6[1], (f2 + fArr6[0]) / 2.0f, (fArr[1] + fArr6[1]) / 2.0f);
                float[] fArr7 = this.n_renamed;
                fArr7[0] = fArr[0];
                fArr7[1] = fArr[1];
                this.A_renamed.setPath(this.z_renamed, false);
                float length2 = this.A_renamed.getLength();
                float f3 = this.B_renamed;
                float f4 = this.E_renamed;
                float f5 = 5.0f * f4;
                if (length2 > f3 + (2.0f * f5)) {
                    a_renamed(this.A_renamed, length2 - f5, f4, false);
                }
                this.m_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                this.k_renamed.drawColor(android.graphics.Color.argb((int) (this.u_renamed * 255.0f), android.graphics.Color.red(this.v_renamed), android.graphics.Color.green(this.v_renamed), android.graphics.Color.blue(this.v_renamed)));
                this.h_renamed.setXfermode(K_renamed);
                this.k_renamed.drawBitmap(this.e_renamed, 0.0f, 0.0f, this.h_renamed);
                this.h_renamed.setXfermode(null);
                this.m_renamed.drawBitmap(this.f1930b, 0.0f, 0.0f, (android.graphics.Paint) null);
                this.k_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            }
        }
        this.q_renamed = porender_qbdml;
    }

    public void addPoint(float[] fArr) {
        a_renamed(co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.MOVE, fArr, null);
    }

    public final int b_renamed() {
        for (int i_renamed = this.y_renamed - 1; i_renamed >= 0; i_renamed--) {
            if (this.x_renamed.get(i_renamed).h_renamed) {
                return i_renamed;
            }
        }
        return 0;
    }

    public final void c_renamed() {
        a_renamed();
        f_renamed();
        for (int iB = b_renamed(); iB < this.y_renamed; iB++) {
            a_renamed(iB);
        }
        e_renamed();
    }

    public boolean canRedo() {
        return this.y_renamed < this.x_renamed.size();
    }

    public boolean canUndo() {
        return this.y_renamed > 0;
    }

    public void clear() {
        a_renamed();
        d_renamed();
        int i_renamed = this.y_renamed;
        if (i_renamed == 0 || this.x_renamed.get(i_renamed - 1).h_renamed) {
            return;
        }
        co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH porender_iuaih = new co_renamed.polarr.renderer.PolarrPainter.porender_iuAiH(this, null);
        porender_iuaih.h_renamed = true;
        this.x_renamed.add(porender_iuaih);
        this.y_renamed++;
    }

    public final void d_renamed() {
        while (this.x_renamed.size() > this.y_renamed) {
            this.x_renamed.remove(r0.size() - 1);
        }
    }

    public void draw(android.graphics.Canvas canvas) {
        if (this.f1930b == null) {
            return;
        }
        canvas.drawBitmap(this.f1931c, 0.0f, 0.0f, (android.graphics.Paint) null);
        if (this.q_renamed == co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.MOVE) {
            canvas.drawBitmap(this.d_renamed, 0.0f, 0.0f, (android.graphics.Paint) null);
        }
    }

    public final void e_renamed() {
        updateBrushStyle(this.I_renamed);
        updateBrushSize(this.F_renamed, this.G_renamed, this.H_renamed);
        this.l_renamed = this.J_renamed;
        this.l_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
    }

    public void endBrush(float[] fArr, float[] fArr2) {
        a_renamed(co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.DONE, fArr, fArr2);
    }

    public final void f_renamed() {
        this.F_renamed = this.t_renamed;
        this.G_renamed = this.u_renamed;
        this.H_renamed = this.v_renamed;
        this.I_renamed = this.r_renamed;
        this.J_renamed = this.l_renamed;
    }

    public android.graphics.Bitmap getLastPaintBitmap() {
        return this.f1931c;
    }

    public void redo() {
        if (canRedo()) {
            f_renamed();
            a_renamed(this.y_renamed);
            e_renamed();
            this.y_renamed++;
        }
    }

    public void reset() {
        clear();
        this.x_renamed.clear();
        this.y_renamed = 0;
    }

    public void setLastPaintBitmap(android.graphics.Bitmap bitmap) {
        android.graphics.Canvas canvas = this.j_renamed;
        if (canvas != null) {
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            this.j_renamed.drawBitmap(bitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
        }
    }

    public void startBrush(float[] fArr) {
        a_renamed(co_renamed.polarr.renderer.PolarrPainter.porender_qbdmL.START, fArr, null);
    }

    public void undo() {
        if (canUndo()) {
            this.y_renamed--;
            c_renamed();
        }
    }

    public void updateBrushSize(float f_renamed, float f2, int i_renamed) {
        android.graphics.Bitmap bitmapCreateScaledBitmap;
        this.t_renamed = f_renamed;
        this.u_renamed = f2;
        this.v_renamed = i_renamed;
        if (f_renamed == 0.0f) {
            f_renamed = 1.0f;
        }
        if (f_renamed == 1.0f) {
            bitmapCreateScaledBitmap = this.f_renamed.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        } else if (this.f_renamed.getWidth() != this.f_renamed.getHeight()) {
            android.graphics.Bitmap bitmap = this.f_renamed;
            android.graphics.Bitmap bitmapCreateScaledBitmap2 = android.graphics.Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), (int) (this.f_renamed.getHeight() * f_renamed), false);
            bitmapCreateScaledBitmap = a_renamed(bitmapCreateScaledBitmap2, new android.graphics.Rect(0, 0, (int) (this.f_renamed.getWidth() * f_renamed), bitmapCreateScaledBitmap2.getHeight()));
        } else {
            bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(this.f_renamed, (int) (r5.getWidth() * f_renamed), (int) (this.f_renamed.getHeight() * f_renamed), false);
        }
        if (this.r_renamed.paintAlpha < 1.0f) {
            a_renamed(bitmapCreateScaledBitmap, this.r_renamed.paintAlpha);
        }
        this.g_renamed = bitmapCreateScaledBitmap;
        this.C_renamed = this.g_renamed.getWidth();
        this.D_renamed = this.g_renamed.getHeight();
        this.E_renamed = this.g_renamed.getWidth() * this.r_renamed.spacing;
        this.E_renamed = java.lang.Math.max(this.E_renamed, 0.1f);
    }

    public void updateBrushStyle(co_renamed.polarr.renderer.PolarrPainter.BrushStyle brushStyle) {
        this.r_renamed = brushStyle;
        try {
            this.f_renamed = android.graphics.BitmapFactory.decodeStream(this.f1929a.getAssets().open(this.r_renamed.resName), null, new android.graphics.BitmapFactory.Options());
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        float f_renamed = this.t_renamed;
        if (f_renamed != 0.0f) {
            updateBrushSize(f_renamed, this.u_renamed, this.v_renamed);
        }
    }

    public void updateSize(int i_renamed, int i2) {
        this.f1930b = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.e_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.f1931c = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.d_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.j_renamed.setBitmap(this.f1931c);
        this.k_renamed.setBitmap(this.f1930b);
        this.l_renamed.setBitmap(this.e_renamed);
        this.m_renamed.setBitmap(this.d_renamed);
    }
}
