package a_renamed.a_renamed.b_renamed.c_renamed;

/* loaded from: classes.dex */
public class g_renamed implements android.opengl.GLSurfaceView.Renderer {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final float[] f40a = {0.0f, 0.0f, 0.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    public static float f41b = 2.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static int f42c = 60;
    public static final java.util.HashMap<java.lang.Long, a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed> d_renamed = new java.util.HashMap<>();
    public java.util.Queue<java.lang.Runnable> A_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.q_renamed B_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.w_renamed C_renamed;
    public boolean D_renamed;
    public long E_renamed;
    public long F_renamed;
    public int e_renamed;
    public volatile boolean f_renamed;
    public a_renamed.a_renamed.b_renamed.e_renamed.d_renamed g_renamed;
    public android.opengl.GLSurfaceView h_renamed;
    public float[] i_renamed;
    public int j_renamed;
    public final android.content.res.Resources k_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed l_renamed;
    public java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> m_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed n_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.x_renamed o_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.x_renamed p_renamed;
    public android.graphics.Point q_renamed;
    public java.util.List<android.graphics.Bitmap> r_renamed;
    public android.graphics.Bitmap s_renamed;
    public android.graphics.Point t_renamed;
    public boolean u_renamed;
    public java.util.concurrent.atomic.AtomicBoolean v_renamed;
    public java.util.concurrent.atomic.AtomicBoolean w_renamed;
    public java.util.concurrent.atomic.AtomicBoolean x_renamed;
    public java.util.concurrent.atomic.AtomicBoolean y_renamed;
    public boolean z_renamed;

    public class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ boolean f43a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final /* synthetic */ a_renamed.a_renamed.b_renamed.c_renamed.d_renamed f44b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final /* synthetic */ boolean f45c;

        public a_renamed(boolean z_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, boolean z2) {
            this.f43a = z_renamed;
            this.f44b = dVar;
            this.f45c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.this.a_renamed(this.f43a, this.f44b, this.f45c, false);
        }
    }

    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.util.LinkedList<java.lang.Integer> f46a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.util.LinkedList<java.lang.Integer> f47b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final java.util.LinkedList<java.lang.Integer> f48c;

        public b_renamed() {
            this.f46a = new java.util.LinkedList<>();
            this.f47b = new java.util.LinkedList<>();
            this.f48c = new java.util.LinkedList<>();
        }

        public /* synthetic */ b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.e_renamed eVar) {
            this();
        }
    }

    public g_renamed(android.content.Context context, android.content.res.Resources resources, a_renamed.a_renamed.b_renamed.e_renamed.d_renamed dVar) {
        this.i_renamed = new float[25];
        this.j_renamed = 0;
        this.u_renamed = false;
        this.E_renamed = 0L;
        this.F_renamed = 0L;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = dVar;
        this.k_renamed = resources;
        j_renamed();
    }

    public g_renamed(android.content.Context context, android.content.res.Resources resources, android.opengl.GLSurfaceView gLSurfaceView) {
        this.i_renamed = new float[25];
        this.j_renamed = 0;
        this.u_renamed = false;
        this.E_renamed = 0L;
        this.F_renamed = 0L;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.h_renamed = gLSurfaceView;
        this.k_renamed = resources;
        j_renamed();
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar, java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> list) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar;
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar2;
        synchronized (context) {
            java.util.List<co_renamed.polarr.renderer.entities.Adjustment> list2 = (java.util.List) context.renderStates.get("local_adjustments");
            aVar = null;
            if (list2 != null && !list2.isEmpty()) {
                java.util.Map<java.lang.String, java.lang.Object> map = context.renderStates;
                context.renderStates = new java.util.HashMap();
                a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(context.renderStates);
                a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar3 = null;
                for (co_renamed.polarr.renderer.entities.Adjustment adjustment : list2) {
                    if (!adjustment.disabled) {
                        if ("radial".equals(adjustment.type)) {
                            a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed apVarA = a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed.a_renamed(resources, context);
                            apVarA.r_renamed = adjustment.feather;
                            apVarA.v_renamed = adjustment.size;
                            apVarA.u_renamed = java.util.Arrays.copyOf(adjustment.position, 2);
                            apVarA.u_renamed[1] = -apVarA.u_renamed[1];
                            apVarA.t_renamed = -adjustment.angle;
                            apVarA.s_renamed = adjustment.invert ? 1.0f : 0.0f;
                            apVarA.w_renamed = 1.0f;
                            apVarA.x_renamed = 0.0f;
                            aVar2 = apVarA;
                        } else if ("gradient".equals(adjustment.type)) {
                            a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed acVarA = a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed.a_renamed(resources, context);
                            acVarA.r_renamed = java.util.Arrays.copyOf(adjustment.startPoint, 2);
                            acVarA.r_renamed[1] = -acVarA.r_renamed[1];
                            acVarA.s_renamed = java.util.Arrays.copyOf(adjustment.endPoint, 2);
                            acVarA.s_renamed[1] = -acVarA.s_renamed[1];
                            acVarA.t_renamed = adjustment.invert ? 1.0f : 0.0f;
                            acVarA.u_renamed = adjustment.reflect ? 1.0f : 0.0f;
                            acVarA.v_renamed = 1.0f;
                            acVarA.w_renamed = 0.0f;
                            aVar2 = acVarA;
                        } else if ("luminance".equals(adjustment.type)) {
                            a_renamed.a_renamed.b_renamed.b_renamed.be_renamed beVarA = a_renamed.a_renamed.b_renamed.b_renamed.be_renamed.a_renamed(resources, context);
                            beVarA.r_renamed = adjustment.target;
                            beVarA.s_renamed = adjustment.range;
                            beVarA.u_renamed = adjustment.invert ? 1.0f : 0.0f;
                            beVarA.t_renamed = adjustment.smoothness;
                            beVarA.v_renamed = 1.0f;
                            beVarA.w_renamed = 0.0f;
                            aVar2 = beVarA;
                        } else if (com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_COLOR.equals(adjustment.type)) {
                            a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed akVarA = a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed.a_renamed(resources, context);
                            akVarA.r_renamed = adjustment.feather;
                            akVarA.u_renamed = adjustment.threshold;
                            akVarA.w_renamed = adjustment.size;
                            akVarA.v_renamed = java.util.Arrays.copyOf(adjustment.position, 2);
                            akVarA.v_renamed[1] = -akVarA.v_renamed[1];
                            akVarA.s_renamed = adjustment.invert ? 1.0f : 0.0f;
                            akVarA.t_renamed = adjustment.useRadius ? 1.0f : 0.0f;
                            akVarA.z_renamed = adjustment.selectedColor != null ? adjustment.selectedColor : f40a;
                            akVarA.A_renamed = (adjustment.selectedColor == null || adjustment.selectedColor.length <= 0) ? 0.0f : 1.0f;
                            akVarA.x_renamed = 1.0f;
                            akVarA.y_renamed = 0.0f;
                            aVar2 = akVarA;
                        } else if (!"brush".equals(adjustment.type)) {
                            aVar2 = null;
                        } else if ("paint".equals(adjustment.brush_mode)) {
                            dVar.b_renamed(co_renamed.polarr.renderer.filters.Basic.a_renamed(resources, context));
                            android.opengl.GLES20.glEnable(3042);
                            android.opengl.GLES20.glBlendEquation(32774);
                            android.opengl.GLES20.glBlendFunc(1, 771);
                            a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed bdVarA = a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed.a_renamed(resources, context);
                            bdVarA.a_renamed(adjustment.paintTextureId);
                            bdVarA.draw();
                            android.opengl.GLES20.glDisable(3042);
                            aVar2 = null;
                        } else {
                            a_renamed.a_renamed.b_renamed.b_renamed.s_renamed sVarA = a_renamed.a_renamed.b_renamed.b_renamed.s_renamed.a_renamed(resources, context);
                            sVarA.s_renamed = adjustment.channel;
                            sVarA.r_renamed = adjustment.invert ? 1.0f : 0.0f;
                            sVarA.t_renamed = 1.0f;
                            sVarA.u_renamed = 0.0f;
                            aVar2 = sVarA;
                        }
                        if (aVar2 != null) {
                            if (adjustment.showOverlay) {
                                aVar3 = aVar2;
                            }
                            dVar.b_renamed(aVar2);
                            context.renderStates.putAll(co_renamed.polarr.renderer.entities.Adjustment.getAdjustmentHashMap(adjustment.adjustments));
                            for (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed bVar : list) {
                                if (!bVar.l_renamed()) {
                                    dVar.b_renamed(bVar);
                                }
                            }
                        }
                    }
                }
                context.renderStates = map;
                if (((java.lang.Float) context.renderStates.get("blur_opacity")).floatValue() == 0.0f) {
                    dVar.s_renamed();
                    c_renamed(resources, context);
                    a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.readableTexture;
                    context.readableTexture = context.tempTexture;
                    a_renamed(resources, context, context.readableTexture);
                    context.readableTexture = dVar2;
                    dVar.v_renamed();
                }
                aVar = aVar3;
            }
        }
        return aVar;
    }

    public static a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed aoVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2, float f_renamed, java.lang.Float f2) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        if (f2 == null) {
            f2 = java.lang.Float.valueOf(f_renamed);
        }
        float f3 = 1.0f / dVar2.f35b;
        float fFloatValue = f2.floatValue();
        float fFloatValue2 = f2.floatValue();
        aoVar.r_renamed = new float[]{f3 * f_renamed, 0.0f, f3 * fFloatValue, 0.0f};
        aoVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, dVar.f34a, context.readableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) aoVar, true);
        aoVar.r_renamed = new float[]{0.0f, (1.0f / dVar2.f36c) * f_renamed, 0.0f, (1.0f / dVar2.f36c) * fFloatValue2};
        aoVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, context.readableTexture.f34a, dVar2, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) aoVar, true);
        return dVar2;
    }

    public static a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.at_renamed atVar, a_renamed.a_renamed.b_renamed.b_renamed.bw_renamed bwVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        atVar.r_renamed = new float[]{(1.0f / dVar2.f35b) * 8.0f, 0.0f};
        atVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, dVar.f34a, context.readableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) atVar, true);
        bwVar.r_renamed = new float[]{0.0f, (1.0f / dVar2.f36c) * 8.0f};
        bwVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, context.readableTexture.f34a, dVar2, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) bwVar, true);
        return dVar2;
    }

    public static a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed a_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVar;
        java.lang.Long lValueOf = java.lang.Long.valueOf(java.lang.Thread.currentThread().getId());
        synchronized (d_renamed) {
            if (d_renamed.containsKey(lValueOf)) {
                bVar = d_renamed.get(lValueOf);
            } else {
                bVar = new a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed(null);
                d_renamed.put(lValueOf, bVar);
            }
        }
        return bVar;
    }

    public static void a_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f48c) {
            bVarA.f48c.add(java.lang.Integer.valueOf(i_renamed));
        }
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a);
    }

    public static void a_renamed(android.content.Context context, android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context2, java.util.ArrayList<co_renamed.polarr.renderer.entities.TextItem> arrayList) {
        if (context == null) {
            return;
        }
        java.util.ArrayList arrayList2 = (java.util.ArrayList) context2.renderStates.get("zPrevText");
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int i_renamed = 0;
        java.util.Iterator<co_renamed.polarr.renderer.entities.TextItem> it = arrayList.iterator();
        while (it.hasNext()) {
            co_renamed.polarr.renderer.entities.TextItem next = it.next();
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context2.textLayers.size() > i_renamed ? context2.textLayers.get(i_renamed) : null;
            if (dVar == null) {
                context2.textLayers.add(a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed(context, resources.getAssets(), next, context2, null));
            } else if (arrayList2 == null || arrayList2.size() <= i_renamed || !a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(arrayList2.get(i_renamed), next)) {
                a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed(context, resources.getAssets(), next, context2, dVar);
            }
            i_renamed++;
        }
        context2.renderStates.put("zPrevText", arrayList);
    }

    public static void a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        java.lang.String[] strArr = {"brush_08_8.png", "brush_09_8.png", "brush_07.png", "brush_05.png", "brush_04.png", "brush_03.png", "brush_02.png"};
        java.util.HashMap map = new java.util.HashMap();
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                options.inPremultiplied = false;
            }
            android.graphics.Bitmap bitmapDecodeStream = null;
            try {
                bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(resources.getAssets().open("paint/" + strArr[i_renamed]), null, options);
            } catch (java.io.IOException unused) {
            }
            if (bitmapDecodeStream != null) {
                int[] iArr = new int[1];
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                android.opengl.GLES20.glBindTexture(3553, dVarB.f34a);
                android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmapDecodeStream, 0);
                bitmapDecodeStream.recycle();
                map.put(new java.lang.String[]{"stroke_5", "stroke_6", "stroke_3", "stroke_4", "dot", "speckles", "chalk"}[i_renamed], dVarB);
            }
        }
        context.brushes = map;
    }

    public static void a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.imageTexture;
        int i2 = dVar2.f35b;
        int i3 = dVar2.f36c;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        int iMax = java.lang.Math.max(0, (int) (java.lang.Math.log(i_renamed) / java.lang.Math.log(2.0d)));
        int i4 = i2 >> iMax;
        int i5 = i3 >> iMax;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i4, i5);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i4, i5);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.dehazeTexture, i4, i5);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.denoiseTexture, i4, i5);
        float fMax = 1024.0f / java.lang.Math.max(i2, i3);
        float f_renamed = i2;
        int iFloor = (int) java.lang.Math.floor(f_renamed * fMax);
        float f2 = i3;
        int iFloor2 = (int) java.lang.Math.floor(fMax * f2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.paintTexture, iFloor, iFloor2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = context.brushTextures;
        if (dVarArr != null) {
            for (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 : dVarArr) {
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar3, iFloor, iFloor2);
            }
        }
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.intermediateTexture, iFloor, iFloor2);
        android.opengl.GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            dVar = context.imageTexture;
        } else {
            a_renamed(context, 0, context.readableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) a_renamed.a_renamed.b_renamed.b_renamed.i_renamed.a_renamed(resources, context), false);
            dVar = context.readableTexture;
        }
        float[] fArr = new float[15];
        float f3 = 1.0f / 15;
        float f4 = 1.0f / f_renamed;
        float f5 = 1.0f / f2;
        for (int i6 = 0; i6 <= 7; i6++) {
            float fExp = (float) java.lang.Math.exp((-(i6 * i6)) * f3);
            fArr[7 - i6] = fExp;
            fArr[i6 + 7] = fExp;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.e_renamed eVarA = a_renamed.a_renamed.b_renamed.b_renamed.e_renamed.a_renamed(resources, context);
        eVarA.a_renamed("delta", java.lang.Float.valueOf(f4));
        eVarA.r_renamed = fArr;
        a_renamed.a_renamed.b_renamed.b_renamed.z_renamed zVarA = a_renamed.a_renamed.b_renamed.b_renamed.z_renamed.a_renamed(resources, context);
        zVarA.a_renamed("delta", java.lang.Float.valueOf(f5));
        zVarA.r_renamed = fArr;
        a_renamed(context, dVar.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) eVarA, true);
        a_renamed(context, context.writableTexture.f34a, context.denoiseTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) zVarA, true);
        a_renamed(context, resources);
    }

    public static void a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        if (dVar == null) {
            dVar = context.readableTexture;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed blVarA = a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed.a_renamed(resources, context);
        blVarA.a_renamed(context);
        blVarA.r_renamed = new float[]{0.0f, (dVar.f35b / dVar.f36c) * 0.036f};
        a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) blVarA, false);
        blVarA.r_renamed = new float[]{0.036f, 0.0f};
        a_renamed(context, context.writableTexture.f34a, dVar, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) blVarA, false);
    }

    public static void a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, android.graphics.Point point) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = context.brushTextures;
        int i_renamed = 16;
        int[] iArr = new int[dVarArr != null ? dVarArr.length + 16 : 16];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, point.x_renamed, point.y_renamed);
        int i2 = 0;
        context.imageTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, point.x_renamed, point.y_renamed);
        context.dehazeTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, point.x_renamed, point.y_renamed);
        context.denoiseTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, point.x_renamed, point.y_renamed);
        context.cacheTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[3], 6408, point.x_renamed, point.y_renamed);
        context.readableTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[4], 6408, point.x_renamed, point.y_renamed);
        context.writableTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[5], 6408, point.x_renamed, point.y_renamed);
        context.paintTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[6], 6408, point.x_renamed, point.y_renamed);
        context.retouchTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[7], 6408, point.x_renamed, point.y_renamed);
        context.intermediateTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[8], 6408, point.x_renamed, point.y_renamed);
        context.lensBlurTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[9], 6408, point.x_renamed, point.y_renamed);
        context.tempTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[10], 6408, point.x_renamed, point.y_renamed);
        context.screenTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[11], 6408, point.x_renamed, point.y_renamed);
        context.watermarkTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[12], 6408, point.x_renamed, point.y_renamed);
        context.exportTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[13], 6408, point.x_renamed, point.y_renamed);
        context.grainTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[14], 6408, 1024, 1024);
        context.overlayTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[15], 6408, 1000, 1000);
        if (context.brushTextures != null) {
            while (true) {
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr2 = context.brushTextures;
                if (i2 >= dVarArr2.length) {
                    break;
                }
                dVarArr2[i2] = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[i_renamed], 6408, point.x_renamed, point.y_renamed);
                i2++;
                i_renamed++;
            }
        }
        b_renamed(resources, context);
        a_renamed(resources, context);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context) {
        float[] fArr = context.compositeResolution;
        int i_renamed = (int) fArr[0];
        int i2 = (int) fArr[1];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i_renamed, i2);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, float f_renamed, float f2) {
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(context);
        float f3 = fArrB[0] / 2.0f;
        float f4 = fArrB[1] / 2.0f;
        android.opengl.Matrix.setIdentityM(context.scaleMatrix, 0);
        android.opengl.Matrix.scaleM(context.scaleMatrix, 0, f3 / f_renamed, f4 / f2, 1.0f);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, float f_renamed, float f2, float f3, float f4) {
        android.opengl.Matrix.setIdentityM(context.cropMatrix, 0);
        android.opengl.Matrix.scaleM(context.cropMatrix, 0, f3, f4, 1.0f);
        android.opengl.Matrix.translateM(context.cropMatrix, 0, f_renamed, f2, 0.0f);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, float f_renamed, float f2, boolean z_renamed, boolean z2, float[] fArr) {
        float[] fArrB;
        float[] fArr2;
        if (z2) {
            fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(context);
        } else {
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
            fArrB = new float[]{dVar.f35b, dVar.f36c};
        }
        float f3 = fArrB[0] / 2.0f;
        float f4 = fArrB[1] / 2.0f;
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(context);
        float[] fArr3 = fArr != null ? new float[]{fArrA[0] + fArr[0], fArrA[1] + fArr[1], (float) java.lang.Math.floor(fArrA[2] * fArr[2]), (float) java.lang.Math.floor(fArrA[3] * fArr[3])} : fArrA;
        if (z2) {
            float f5 = fArr3[0];
            float f6 = context.cropScale;
            fArr2 = new float[]{((f5 - f3) * f6) + f3, ((fArr3[1] - f4) * f6) + f4, fArr3[2] * f6, fArr3[3] * f6};
        } else {
            fArr2 = new float[]{0.0f, 0.0f, fArrB[0], fArrB[1]};
        }
        float f7 = ((-(fArrB[0] - fArr2[2])) / 2.0f) + fArr2[0];
        float f8 = ((-(fArrB[1] - fArr2[3])) / 2.0f) + fArr2[1];
        float f9 = fArr2[2] / fArrB[0];
        float f10 = fArr2[3] / fArrB[1];
        float f11 = f7 / fArr2[2];
        float f12 = f8 / fArr2[3];
        float f13 = z_renamed ? -1.0f : 1.0f;
        e_renamed(context);
        b_renamed(context, -f7, -f8);
        a_renamed(context, f9, f13 * f10);
        c_renamed(context);
        a_renamed(context, f11 * 2.0f, f12 * 2.0f, f9, f10);
        int i_renamed = (int) f_renamed;
        int i2 = (int) f2;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i_renamed, i2);
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, int i_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, boolean z_renamed) {
        if (i_renamed == dVar.f34a) {
            return;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarA = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(context);
        cVarA.a_renamed(aVar);
        cVarA.b_renamed(dVar.f34a);
        cVarA.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        cVarA.c_renamed(dVar.f35b, dVar.f36c);
        if (i_renamed != 0) {
            cVarA.a_renamed(i_renamed);
        }
        cVarA.draw();
    }

    public static void a_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed aoVarA = a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.at_renamed atVarA = a_renamed.a_renamed.b_renamed.b_renamed.at_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.bw_renamed bwVarA = a_renamed.a_renamed.b_renamed.b_renamed.bw_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.az_renamed azVarA = a_renamed.a_renamed.b_renamed.b_renamed.az_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed abVarA = a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.d_renamed dVarA = a_renamed.a_renamed.b_renamed.b_renamed.d_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.b_renamed.q_renamed qVarA = a_renamed.a_renamed.b_renamed.b_renamed.q_renamed.a_renamed(resources, context);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
        float f_renamed = dVar.f35b;
        float f2 = dVar.f36c;
        float fMax = 512.0f / java.lang.Math.max(f_renamed, f2);
        int i_renamed = (int) (f_renamed * fMax);
        int i2 = (int) (f2 * fMax);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i_renamed, i2);
        int[] iArr = new int[3];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB2 = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB3 = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.denoiseTexture;
        a_renamed(context, atVarA, bwVarA, dVar2, dVarB3);
        qVarA.r_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, dVar2.f34a, dVarB2, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) qVarA, true);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA2 = a_renamed(context, aoVarA, dVar2, dVarB, 8.0f, (java.lang.Float) null);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA3 = a_renamed(context, aoVarA, dVarB2, dVarB2, 8.0f, (java.lang.Float) null);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA4 = a_renamed(context, aoVarA, dVarB3, dVarB3, 48.0f, (java.lang.Float) null);
        abVarA.r_renamed = dVarA2.f34a;
        abVarA.s_renamed = dVarA3.f34a;
        abVarA.t_renamed = dVarA4.f34a;
        abVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, 0, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) abVarA, true);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = context.writableTexture;
        dVarA.r_renamed = dVarA2.f34a;
        dVarA.s_renamed = dVarA4.f34a;
        dVarA.t_renamed = dVar3.f34a;
        dVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, 0, dVarA3, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) dVarA, true);
        java.lang.Float fValueOf = java.lang.Float.valueOf(48.0f);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA5 = a_renamed(context, aoVarA, dVar3, dVar3, 8.0f, fValueOf);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA6 = a_renamed(context, aoVarA, dVarA3, dVarA3, 8.0f, fValueOf);
        azVarA.r_renamed = dVarA5.f34a;
        azVarA.s_renamed = dVarA6.f34a;
        azVarA.t_renamed = dVar2.f34a;
        azVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(context, 0, context.dehazeTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) azVarA, true);
        a_renamed(dVarA2);
        a_renamed(dVarA3);
        a_renamed(dVarA4);
    }

    public static void b_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f46a) {
            java.util.Iterator it = bVarA.f46a.iterator();
            while (it.hasNext()) {
                android.opengl.GLES20.glDeleteProgram(((java.lang.Integer) it.next()).intValue());
            }
            bVarA.f46a.clear();
        }
        synchronized (bVarA.f48c) {
            int[] iArr = new int[bVarA.f48c.size()];
            java.util.Iterator it2 = bVarA.f48c.iterator();
            int i_renamed = 0;
            while (it2.hasNext()) {
                iArr[i_renamed] = ((java.lang.Integer) it2.next()).intValue();
                i_renamed++;
            }
            android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            bVarA.f48c.clear();
        }
        synchronized (bVarA.f47b) {
            int[] iArr2 = new int[bVarA.f47b.size()];
            java.util.Iterator it3 = bVarA.f47b.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                iArr2[i2] = ((java.lang.Integer) it3.next()).intValue();
                i2++;
            }
            android.opengl.GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            bVarA.f47b.clear();
        }
    }

    public static void b_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f46a) {
            bVarA.f46a.add(java.lang.Integer.valueOf(i_renamed));
        }
    }

    public static void b_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        java.lang.String[] strArr = {"mosaic_pattern_00.png", "mosaic_pattern_01.png", "mosaic_pattern_02.png", "mosaic_pattern_03.png", "mosaic_pattern_04.png"};
        java.util.HashMap map = new java.util.HashMap();
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                options.inPremultiplied = false;
            }
            android.graphics.Bitmap bitmapDecodeStream = null;
            try {
                bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(resources.getAssets().open("paint/" + strArr[i_renamed]), null, options);
            } catch (java.io.IOException unused) {
            }
            if (bitmapDecodeStream != null) {
                int[] iArr = new int[1];
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                android.opengl.GLES20.glBindTexture(3553, dVarB.f34a);
                android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmapDecodeStream, 0);
                bitmapDecodeStream.recycle();
                map.put(new java.lang.String[]{"square", "hexagon", "dot", "triangle", "diamond"}[i_renamed], dVarB);
            }
        }
        context.patterns = map;
    }

    public static void b_renamed(co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.readableTexture;
        context.readableTexture = context.writableTexture;
        context.writableTexture = dVar;
    }

    public static void b_renamed(co_renamed.polarr.renderer.entities.Context context, float f_renamed, float f2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
        float[] fArr = {dVar.f35b, dVar.f36c};
        android.opengl.Matrix.setIdentityM(context.translationMatrix, 0);
        android.opengl.Matrix.translateM(context.translationMatrix, 0, (f_renamed / fArr[0]) * 2.0f, (f2 / fArr[1]) * 2.0f, 0.0f);
    }

    public static void c_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f47b) {
            if (!bVarA.f47b.contains(java.lang.Integer.valueOf(i_renamed))) {
                bVarA.f47b.add(java.lang.Integer.valueOf(i_renamed));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        java.util.List<co_renamed.polarr.renderer.entities.Adjustment> list = (java.util.List) context.renderStates.get("local_adjustments");
        if (list == null || list.isEmpty()) {
            return;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.s_renamed sVar = null;
        int i_renamed = 0;
        for (co_renamed.polarr.renderer.entities.Adjustment adjustment : list) {
            if (!"brush".equals(adjustment.type) || !"paint".equals(adjustment.brush_mode)) {
                float f_renamed = adjustment.adjustments.blur / 1.5f;
                float fMin = java.lang.Math.min(1, i_renamed);
                if ("radial".equals(adjustment.type)) {
                    a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed apVarA = a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed.a_renamed(resources, context);
                    apVarA.r_renamed = adjustment.feather;
                    apVarA.v_renamed = adjustment.size;
                    apVarA.u_renamed = java.util.Arrays.copyOf(adjustment.position, 2);
                    float[] fArr = apVarA.u_renamed;
                    fArr[1] = -fArr[1];
                    apVarA.t_renamed = -adjustment.angle;
                    apVarA.s_renamed = adjustment.invert ? 1.0f : 0.0f;
                    apVarA.w_renamed = f_renamed;
                    apVarA.x_renamed = fMin;
                    sVar = apVarA;
                } else if ("gradient".equals(adjustment.type)) {
                    a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed acVarA = a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed.a_renamed(resources, context);
                    acVarA.r_renamed = java.util.Arrays.copyOf(adjustment.startPoint, 2);
                    float[] fArr2 = acVarA.r_renamed;
                    fArr2[1] = -fArr2[1];
                    acVarA.s_renamed = java.util.Arrays.copyOf(adjustment.endPoint, 2);
                    float[] fArr3 = acVarA.s_renamed;
                    fArr3[1] = -fArr3[1];
                    acVarA.t_renamed = adjustment.invert ? 1.0f : 0.0f;
                    acVarA.u_renamed = adjustment.reflect ? 1.0f : 0.0f;
                    acVarA.v_renamed = f_renamed;
                    acVarA.w_renamed = fMin;
                    sVar = acVarA;
                } else if ("luminance".equals(adjustment.type)) {
                    a_renamed.a_renamed.b_renamed.b_renamed.be_renamed beVarA = a_renamed.a_renamed.b_renamed.b_renamed.be_renamed.a_renamed(resources, context);
                    beVarA.r_renamed = adjustment.target;
                    beVarA.s_renamed = adjustment.range;
                    beVarA.u_renamed = adjustment.invert ? 1.0f : 0.0f;
                    beVarA.t_renamed = adjustment.smoothness;
                    beVarA.v_renamed = f_renamed;
                    beVarA.w_renamed = fMin;
                    sVar = beVarA;
                } else if (com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_COLOR.equals(adjustment.type)) {
                    a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed akVarA = a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed.a_renamed(resources, context);
                    akVarA.r_renamed = adjustment.feather;
                    akVarA.u_renamed = adjustment.threshold;
                    akVarA.w_renamed = adjustment.size;
                    akVarA.v_renamed = java.util.Arrays.copyOf(adjustment.position, 2);
                    float[] fArr4 = akVarA.v_renamed;
                    fArr4[1] = -fArr4[1];
                    akVarA.s_renamed = adjustment.invert ? 1.0f : 0.0f;
                    akVarA.t_renamed = adjustment.useRadius ? 1.0f : 0.0f;
                    float[] fArr5 = adjustment.selectedColor;
                    if (fArr5 == null) {
                        fArr5 = f40a;
                    }
                    akVarA.z_renamed = fArr5;
                    float[] fArr6 = adjustment.selectedColor;
                    if (fArr6 != null && fArr6.length > 0) {
                        f_renamed = 1.0f;
                    }
                    akVarA.A_renamed = f_renamed;
                    akVarA.x_renamed = f_renamed;
                    akVarA.y_renamed = fMin;
                    sVar = akVarA;
                } else {
                    sVar = sVar;
                    if ("brush".equals(adjustment.type)) {
                        sVar = sVar;
                        if (!"paint".equals(adjustment.brush_mode)) {
                            a_renamed.a_renamed.b_renamed.b_renamed.s_renamed sVarA = a_renamed.a_renamed.b_renamed.b_renamed.s_renamed.a_renamed(resources, context);
                            sVarA.s_renamed = adjustment.channel;
                            sVarA.r_renamed = adjustment.invert ? 1.0f : 0.0f;
                            sVarA.t_renamed = f_renamed;
                            sVarA.u_renamed = fMin;
                            sVar = sVarA;
                        }
                    }
                }
                if (sVar != null) {
                    a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) sVar, false);
                    b_renamed(context);
                }
                i_renamed++;
            }
        }
    }

    public static void c_renamed(co_renamed.polarr.renderer.entities.Context context) {
        android.opengl.Matrix.setIdentityM(context.matrix, 0);
        float[] fArr = context.matrix;
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr, 0, context.projectionMatrix, 0);
        float[] fArr2 = context.matrix;
        android.opengl.Matrix.multiplyMM(fArr2, 0, fArr2, 0, context.scaleMatrix, 0);
        float[] fArr3 = context.matrix;
        android.opengl.Matrix.multiplyMM(fArr3, 0, fArr3, 0, context.translationMatrix, 0);
        float[] fArr4 = context.matrix;
        context.viewMatrix = java.util.Arrays.copyOf(fArr4, fArr4.length);
        if (!context.cropMode) {
            float[] fArr5 = context.matrix;
            android.opengl.Matrix.multiplyMM(fArr5, 0, fArr5, 0, context.projectionMatrix, 0);
            float[] fArr6 = context.matrix;
            android.opengl.Matrix.multiplyMM(fArr6, 0, fArr6, 0, context.rotationMatrix, 0);
            float[] fArr7 = context.matrix;
            android.opengl.Matrix.multiplyMM(fArr7, 0, fArr7, 0, context.projectionMatrixInv, 0);
            float[] fArr8 = context.matrix;
            android.opengl.Matrix.multiplyMM(fArr8, 0, fArr8, 0, context.rotation90Matrix, 0);
        }
        android.opengl.Matrix.invertM(context.matrixInv, 0, context.matrix, 0);
    }

    public static void d_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f48c) {
            int iIndexOf = bVarA.f48c.indexOf(java.lang.Integer.valueOf(i_renamed));
            if (iIndexOf >= 0) {
                bVarA.f48c.remove(iIndexOf);
            }
        }
    }

    public static void d_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed(resources, context, 2);
    }

    public static void d_renamed(co_renamed.polarr.renderer.entities.Context context) {
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(context);
        float f_renamed = fArrB[0];
        float f2 = fArrB[1];
        android.opengl.Matrix.orthoM(context.projectionMatrix, 0, f_renamed / (-2.0f), f_renamed / 2.0f, f2 / (-2.0f), f2 / 2.0f, -9999.0f, 9999.0f);
        android.opengl.Matrix.invertM(context.projectionMatrixInv, 0, context.projectionMatrix, 0);
    }

    public static void e_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed bVarA = a_renamed();
        synchronized (bVarA.f47b) {
            int iIndexOf = bVarA.f47b.indexOf(java.lang.Integer.valueOf(i_renamed));
            if (iIndexOf >= 0) {
                bVarA.f47b.remove(iIndexOf);
            }
        }
    }

    public static void e_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        float f_renamed;
        float f2;
        java.util.ArrayList arrayList = (java.util.ArrayList) context.renderStates.get(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT);
        if (arrayList.isEmpty()) {
            return;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.h_renamed hVarA = a_renamed.a_renamed.b_renamed.b_renamed.h_renamed.a_renamed(resources, context);
        if (((java.lang.Boolean) context.renderStates.get("textInverted")).booleanValue()) {
            hVarA.r_renamed = (float[]) context.renderStates.get("textInvertedColor");
            f2 = 22.0f;
            f_renamed = 1.0f;
        } else {
            hVarA.r_renamed = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
            f_renamed = -1.0f;
            f2 = -1.0f;
        }
        a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) hVarA, false);
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            if (context.textLayers.size() > i_renamed) {
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.textLayers.get(i_renamed);
                co_renamed.polarr.renderer.entities.TextItem textItem = (co_renamed.polarr.renderer.entities.TextItem) arrayList.get(i_renamed);
                if (dVar != null && textItem != null && !textItem.disabled) {
                    a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed bgVarA = a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed.a_renamed(resources, context);
                    float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed(textItem, context, dVar);
                    float[] matrix = bgVarA.getMatrix();
                    java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_x", context.renderStates);
                    boolean zBooleanValue = objA instanceof java.lang.Boolean ? ((java.lang.Boolean) objA).booleanValue() : false;
                    java.lang.Object objA2 = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_y", context.renderStates);
                    boolean zBooleanValue2 = objA2 instanceof java.lang.Boolean ? ((java.lang.Boolean) objA2).booleanValue() : false;
                    android.opengl.Matrix.multiplyMM(matrix, 0, context.matrix, 0, fArrA, 0);
                    android.opengl.Matrix.scaleM(matrix, 0, zBooleanValue ? -1.0f : 1.0f, zBooleanValue2 ? -1.0f : 1.0f, 1.0f);
                    bgVarA.a_renamed(matrix);
                    bgVarA.w_renamed = matrix;
                    bgVarA.r_renamed = dVar;
                    bgVarA.s_renamed = textItem.color;
                    bgVarA.t_renamed = f_renamed > 0.0f ? f_renamed : textItem.opacity;
                    bgVarA.u_renamed = f2 > 0.0f ? f2 : textItem.blendMode;
                    bgVarA.v_renamed = textItem.blendMix;
                    a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(true, false);
                    a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) bgVarA, false);
                    a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(false, false);
                }
            }
        }
        b_renamed(context);
    }

    public static void e_renamed(co_renamed.polarr.renderer.entities.Context context) {
        float fFloatValue = ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("rotation", context.renderStates)).floatValue();
        context.rotation = fFloatValue;
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(context);
        float f_renamed = fArrB[0] / 2.0f;
        float f2 = fArrB[1] / 2.0f;
        double d2 = fFloatValue * 0.017453292519943295d;
        double dAbs = java.lang.Math.abs(java.lang.Math.cos(d2));
        double dAbs2 = java.lang.Math.abs(java.lang.Math.sin(d2));
        double d3 = f_renamed;
        double d4 = f2;
        context.cropScale = (float) java.lang.Math.min(d3 / ((d3 * dAbs) + (d4 * dAbs2)), d4 / ((d3 * dAbs2) + (dAbs * d4)));
        context.cropScale = java.lang.Math.min(1.0f, context.cropScale);
        java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_x", context.renderStates);
        boolean zBooleanValue = objA instanceof java.lang.Boolean ? ((java.lang.Boolean) objA).booleanValue() : false;
        java.lang.Object objA2 = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("flip_y", context.renderStates);
        boolean zBooleanValue2 = objA2 instanceof java.lang.Boolean ? ((java.lang.Boolean) objA2).booleanValue() : false;
        int iFloatValue = (((int) ((java.lang.Float) context.renderStates.get("rotate90")).floatValue()) + 4) % 4;
        context.renderStates.put("rotate90", java.lang.Float.valueOf(iFloatValue));
        if (iFloatValue % 2 == 1) {
            if (zBooleanValue && !zBooleanValue2) {
                zBooleanValue = false;
                zBooleanValue2 = true;
            } else if (!zBooleanValue && zBooleanValue2) {
                zBooleanValue2 = false;
                zBooleanValue = true;
            }
        }
        android.opengl.Matrix.setIdentityM(context.rotationMatrix, 0);
        android.opengl.Matrix.rotateM(context.rotationMatrix, 0, context.rotation, 0.0f, 0.0f, 1.0f);
        a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(context.rotationMatrix, zBooleanValue, zBooleanValue2);
        android.opengl.Matrix.setIdentityM(context.rotation90Matrix, 0);
        android.opengl.Matrix.rotateM(context.rotation90Matrix, 0, iFloatValue * 90, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.invertM(context.rotation90MatrixInv, 0, context.rotation90Matrix, 0);
    }

    public static void f_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(true, true);
        a_renamed(context, context.readableTexture.f34a, context.writableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) a_renamed.a_renamed.b_renamed.b_renamed.m_renamed.a_renamed(resources, context), false);
        b_renamed(context);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(false, false);
    }

    public final void a_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar) {
        dVar.b_renamed(aVar);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        context.overlayMask = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
        a_renamed.a_renamed.b_renamed.b_renamed.x_renamed xVar = this.p_renamed;
        xVar.r_renamed = 1.0f;
        dVar.b_renamed(xVar);
        android.opengl.GLES20.glDisable(3042);
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.A_renamed.add(runnable);
    }

    public final void a_renamed(java.util.List<android.graphics.Bitmap> list) {
        a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed();
        if (i_renamed().imageTexture == null) {
            a_renamed(this.k_renamed, i_renamed(), this.q_renamed);
        } else {
            o_renamed();
        }
        if (i_renamed().textures != null && i_renamed().textures.length > 0) {
            android.opengl.GLES20.glDeleteTextures(4, i_renamed().textures, 0);
            android.opengl.GLES20.glFlush();
            i_renamed().textures = new int[0];
        }
        if (list.size() == 1) {
            android.opengl.GLES20.glBindTexture(3553, i_renamed().imageTexture.f34a);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
            android.opengl.GLUtils.texImage2D(3553, 0, 6408, list.get(0), 0);
        } else {
            i_renamed().textures = new int[4];
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed().textures.length, i_renamed().textures, 0, 6408, list.get(0).getWidth(), list.get(0).getHeight());
            for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
                android.opengl.GLES20.glBindTexture(3553, i_renamed().textures[i_renamed]);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
                android.opengl.GLES20.glTexImage2D(3553, 0, 6408, list.get(i_renamed).getWidth(), list.get(i_renamed).getHeight(), 0, 6408, 5121, null);
                android.opengl.GLUtils.texImage2D(3553, 0, 6408, list.get(i_renamed), 0);
            }
            i_renamed().imageTexture.f35b = this.q_renamed.x_renamed;
            i_renamed().imageTexture.f36c = this.q_renamed.y_renamed;
        }
        d_renamed(this.k_renamed, i_renamed());
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = i_renamed().screenTexture;
        android.graphics.Point point = this.t_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, point.x_renamed, point.y_renamed);
        this.u_renamed = true;
    }

    public final void a_renamed(boolean z_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, boolean z2) {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed aVar = new a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(z_renamed, dVar, z2);
        a_renamed.a_renamed.b_renamed.e_renamed.d_renamed dVar2 = this.g_renamed;
        if (dVar2 != null) {
            dVar2.a_renamed(aVar);
        }
        android.opengl.GLSurfaceView gLSurfaceView = this.h_renamed;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(aVar);
        }
    }

    public final void a_renamed(boolean z_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, boolean z2, boolean z3) {
        float f_renamed;
        float f2;
        if ((z_renamed && this.f_renamed) || this.l_renamed == null || i_renamed().writableTexture == null || i_renamed().writableTexture.f36c == 0 || !i_renamed().photoLoaded) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.f_renamed = true;
        if (z_renamed) {
            e_renamed();
        }
        if (!this.z_renamed) {
            this.C_renamed.a_renamed(i_renamed(), false);
            a_renamed.a_renamed.b_renamed.f_renamed.c_renamed.a_renamed(i_renamed(), this.k_renamed);
        }
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA = (i_renamed().textures == null || i_renamed().textures.length <= 0) ? a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed.a_renamed(this.k_renamed, i_renamed()) : a_renamed.a_renamed.b_renamed.b_renamed.as_renamed.a_renamed(this.k_renamed, i_renamed());
        aVarA.a_renamed(i_renamed().matrix);
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarA = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(i_renamed());
        cVarA.a_renamed(aVarA);
        cVarA.b_renamed(i_renamed().readableTexture.f34a);
        cVarA.c_renamed(i_renamed().readableTexture.f35b, i_renamed().readableTexture.f36c);
        cVarA.a_renamed(i_renamed().imageTexture.f34a);
        if (this.z_renamed) {
            co_renamed.polarr.renderer.entities.Mesh mesh = i_renamed().mesh;
            i_renamed().mesh = co_renamed.polarr.renderer.entities.Context.DefaultMesh;
            cVarA.draw();
            i_renamed().mesh = mesh;
        } else {
            cVarA.draw();
        }
        if (!this.z_renamed) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(false, false);
            a_renamed.a_renamed.b_renamed.f_renamed.y_renamed.a_renamed((java.util.List<co_renamed.polarr.renderer.entities.FaceItem>) i_renamed().renderStates.get("faces"), this.k_renamed, i_renamed());
            if (i_renamed().readableTexture == null) {
                return;
            }
            this.l_renamed.a_renamed(i_renamed().readableTexture.f34a);
            this.l_renamed.w_renamed();
            java.util.List list = (java.util.List) i_renamed().renderStates.get("spots");
            if (list != null && !list.isEmpty()) {
                a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed ajVarB = (i_renamed().textures == null || i_renamed().textures.length <= 0) ? a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed.b_renamed(this.k_renamed, i_renamed()) : a_renamed.a_renamed.b_renamed.b_renamed.af_renamed.a_renamed(this.k_renamed, i_renamed());
                for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                    co_renamed.polarr.renderer.entities.SpotItem spotItem = (co_renamed.polarr.renderer.entities.SpotItem) list.get(i_renamed);
                    ajVarB.s_renamed = spotItem.feather;
                    ajVarB.t_renamed = spotItem.size;
                    ajVarB.u_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.position);
                    ajVarB.v_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.sourcePosition);
                    ajVarB.w_renamed = spotItem.angle;
                    ajVarB.x_renamed = spotItem.opacity;
                    ajVarB.y_renamed = spotItem.mode;
                    this.l_renamed.b_renamed(ajVarB);
                }
            }
            this.l_renamed.o_renamed();
            java.util.List list2 = (java.util.List) i_renamed().renderStates.get("faces");
            for (int i2 = 0; i2 < list2.size(); i2++) {
                try {
                    co_renamed.polarr.renderer.entities.FaceItem faceItem = (co_renamed.polarr.renderer.entities.FaceItem) list2.get(i2);
                    a_renamed.a_renamed.b_renamed.c_renamed.f_renamed fVar = i_renamed().faceMasks[i2];
                    if (faceItem.adjustments != null) {
                        a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed bqVarA = a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed.a_renamed(this.k_renamed, i_renamed());
                        bqVarA.r_renamed = fVar;
                        bqVarA.s_renamed = faceItem.adjustments;
                        this.l_renamed.b_renamed(bqVarA);
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA2 = a_renamed(this.k_renamed, i_renamed(), this.l_renamed, this.m_renamed);
            if (z3) {
                a_renamed(i_renamed(), this.l_renamed.r_renamed(), i_renamed().readableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) co_renamed.polarr.renderer.filters.Basic.a_renamed(this.k_renamed, i_renamed()), false);
                this.l_renamed.p_renamed();
                return;
            }
            java.lang.Object obj = i_renamed().renderStates.get("blur_opacity");
            if ((((obj instanceof java.lang.Integer) && ((java.lang.Integer) obj).intValue() != 0) || ((obj instanceof java.lang.Float) && ((java.lang.Float) obj).floatValue() != 0.0f)) && i_renamed().lensBlurTexture.f35b != 1) {
                this.l_renamed.b_renamed(a_renamed.a_renamed.b_renamed.b_renamed.y_renamed.a_renamed(this.k_renamed, i_renamed()));
            }
            if (aVarA2 != null) {
                a_renamed(i_renamed(), aVarA2, this.l_renamed);
            }
            this.l_renamed.p_renamed();
            a_renamed(i_renamed(), this.l_renamed.r_renamed(), i_renamed().readableTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) co_renamed.polarr.renderer.filters.Basic.a_renamed(this.k_renamed, i_renamed()), false);
            e_renamed(this.k_renamed, i_renamed());
            if (!i_renamed().cropMode && i_renamed().watermarkTexture != null && (i_renamed().watermarkOptions.enabled || i_renamed().watermarkOptions.preview)) {
                a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA3 = (i_renamed().textures == null || i_renamed().textures.length <= 0) ? a_renamed.a_renamed.b_renamed.b_renamed.au_renamed.a_renamed(this.k_renamed, i_renamed()) : a_renamed.a_renamed.b_renamed.b_renamed.bn_renamed.a_renamed(this.k_renamed, i_renamed());
                aVarA3.a_renamed(i_renamed().matrix);
                a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarA2 = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(i_renamed());
                cVarA2.a_renamed(aVarA3);
                cVarA2.b_renamed(i_renamed().writableTexture.f34a);
                cVarA2.c_renamed(i_renamed().readableTexture.f35b, i_renamed().readableTexture.f36c);
                cVarA2.a_renamed(i_renamed().readableTexture.f34a);
                cVarA2.draw();
                b_renamed(i_renamed());
                f_renamed(this.k_renamed, i_renamed());
            }
            if (dVar != null) {
                if (dVar == i_renamed().cacheTexture) {
                    if (i_renamed().cropMode) {
                        f2 = i_renamed().imageTexture.f35b;
                        f_renamed = i_renamed().imageTexture.f36c;
                    } else {
                        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(i_renamed());
                        float f3 = fArrA[2];
                        f_renamed = fArrA[3];
                        f2 = f3;
                    }
                    android.graphics.Point point = this.t_renamed;
                    float fMin = java.lang.Math.min(point.x_renamed / f2, point.y_renamed / f_renamed);
                    a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, (int) (f2 * fMin), (int) (f_renamed * fMin));
                }
                a_renamed(i_renamed(), i_renamed().readableTexture.f34a, dVar, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) co_renamed.polarr.renderer.filters.Basic.a_renamed(this.k_renamed, i_renamed()), false);
            }
        }
        if (z_renamed && i_renamed().readableTexture != null) {
            a_renamed(i_renamed(), i_renamed().readableTexture.f34a, i_renamed().screenTexture, (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed) co_renamed.polarr.renderer.filters.Basic.a_renamed(this.k_renamed, i_renamed()), false);
            this.n_renamed.a_renamed(i_renamed().screenTexture.f34a);
            if (z2) {
                this.F_renamed = java.lang.System.currentTimeMillis();
            }
        }
        this.f_renamed = false;
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        float[] fArr = this.i_renamed;
        int i3 = this.j_renamed;
        this.j_renamed = i3 + 1;
        fArr[i3] = 1000.0f / (jCurrentTimeMillis2 - jCurrentTimeMillis);
        this.j_renamed %= fArr.length;
    }

    public void b_renamed(java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> list) {
        java.util.Iterator<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> it = list.iterator();
        while (it.hasNext()) {
            this.l_renamed.a_renamed(it.next());
        }
    }

    public void c_renamed() {
        if (this.f_renamed) {
            k_renamed();
        } else {
            a_renamed(true, (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed) null, true);
        }
    }

    public final boolean d_renamed() {
        float f_renamed = f42c;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.E_renamed != 0) {
            f_renamed = 1000.0f / (jCurrentTimeMillis - r3);
        }
        boolean z_renamed = false;
        if (java.lang.System.currentTimeMillis() - this.F_renamed > 200 && !this.f_renamed) {
            this.F_renamed = Long.MAX_VALUE;
            android.graphics.Point point = this.t_renamed;
            this.l_renamed.c_renamed(point.x_renamed, point.y_renamed);
            a_renamed(true, (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed) null, false, false);
            float f2 = this.t_renamed.x_renamed;
            float f3 = f41b;
            this.l_renamed.c_renamed((int) (f2 / f3), (int) (r1.y_renamed / f3));
        }
        this.E_renamed = java.lang.System.currentTimeMillis();
        int i_renamed = this.e_renamed;
        if (i_renamed > 0) {
            this.e_renamed = i_renamed - 1;
            return this.e_renamed != 0;
        }
        float fG_renamed = g_renamed();
        this.e_renamed = 0;
        if (fG_renamed > 0.0f && fG_renamed < 40.0f) {
            this.e_renamed = (int) java.lang.Math.ceil(60.0f / fG_renamed);
            z_renamed = true;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.q_renamed qVar = this.B_renamed;
        if (qVar != null) {
            qVar.a_renamed(f_renamed, fG_renamed, this.e_renamed - 1);
        }
        return z_renamed;
    }

    public void e_renamed() {
        if (this.y_renamed.getAndSet(false)) {
            if (i_renamed().imageTexture == null) {
                float[] fArr = i_renamed().screenMatrix;
                android.graphics.Point point = this.q_renamed;
                int i_renamed = point.x_renamed;
                int i2 = point.y_renamed;
                android.graphics.Point point2 = this.t_renamed;
                a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr, 2, i_renamed, i2, point2.x_renamed, point2.y_renamed);
                android.graphics.Point point3 = this.q_renamed;
                if (point3.x_renamed / point3.y_renamed < 1.0f) {
                    a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(i_renamed().screenMatrix, false, true);
                }
            }
            q_renamed();
            r_renamed();
        }
    }

    public final void f_renamed() {
        java.util.Vector vector = new java.util.Vector();
        while (true) {
            java.lang.Runnable runnablePoll = this.A_renamed.poll();
            if (runnablePoll == null) {
                break;
            } else {
                vector.add(runnablePoll);
            }
        }
        java.util.Iterator it = vector.iterator();
        while (it.hasNext()) {
            ((java.lang.Runnable) it.next()).run();
        }
    }

    public final float g_renamed() {
        int i_renamed = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float[] fArr = this.i_renamed;
            if (i_renamed >= fArr.length) {
                break;
            }
            if (fArr[i_renamed] > 0.0f) {
                i3 = (int) (i3 + fArr[i_renamed]);
                i2++;
            }
            i_renamed++;
        }
        if (i2 < 15) {
            return 0.0f;
        }
        return i3 / i2;
    }

    public float h_renamed() {
        co_renamed.polarr.renderer.entities.Context contextI = i_renamed();
        android.graphics.Point point = this.t_renamed;
        return a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(contextI, point.x_renamed, point.y_renamed, false, null);
    }

    public final co_renamed.polarr.renderer.entities.Context i_renamed() {
        return a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a;
    }

    public final void j_renamed() {
        i_renamed().shaderUtil = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(this.k_renamed);
        this.l_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed(i_renamed(), this.k_renamed);
        this.q_renamed = new android.graphics.Point();
        this.t_renamed = new android.graphics.Point();
        this.n_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.aa_renamed(this.k_renamed, i_renamed());
        this.o_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.x_renamed(this.k_renamed, i_renamed());
        this.p_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.x_renamed(this.k_renamed, i_renamed());
        this.v_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.w_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.x_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.y_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(this.k_renamed, i_renamed()));
        this.m_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.b_renamed(this.k_renamed, i_renamed());
        a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(null, null, null);
        this.A_renamed = new java.util.concurrent.LinkedBlockingQueue();
    }

    public void k_renamed() {
        this.F_renamed = java.lang.System.currentTimeMillis();
    }

    public void l_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a = new co_renamed.polarr.renderer.entities.Context();
        a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a.resources = this.k_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.w_renamed wVar = this.C_renamed;
        if (wVar != null) {
            wVar.e_renamed();
        }
        n_renamed();
        a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed();
    }

    public boolean m_renamed() {
        android.graphics.Bitmap bitmap;
        if (d_renamed() && this.g_renamed != null) {
            f_renamed();
            return true;
        }
        if (this.v_renamed.getAndSet(false)) {
            java.util.List<android.graphics.Bitmap> list = this.r_renamed;
            if (list != null && !list.isEmpty()) {
                a_renamed(this.r_renamed);
                if (this.D_renamed) {
                    java.util.Iterator<android.graphics.Bitmap> it = this.r_renamed.iterator();
                    while (it.hasNext()) {
                        it.next().recycle();
                    }
                }
                if (i_renamed().textures == null || i_renamed().textures.length <= 0) {
                    i_renamed().glRenderView.a_renamed(i_renamed().imageTexture.f34a);
                } else {
                    i_renamed().glRenderView.a_renamed(i_renamed().textures);
                }
                this.r_renamed = null;
            }
            co_renamed.polarr.renderer.entities.Context contextI = i_renamed();
            android.graphics.Point point = this.t_renamed;
            a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(contextI, point.x_renamed, point.y_renamed);
            i_renamed().screen.zoom = h_renamed();
            s_renamed();
            p_renamed();
            i_renamed().photoLoaded = true;
            c_renamed();
            a_renamed.a_renamed.b_renamed.b_renamed.v_renamed vVar = (a_renamed.a_renamed.b_renamed.b_renamed.v_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.l_renamed.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.v_renamed.class);
            if (vVar != null) {
                vVar.m_renamed();
            }
            a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed baVar = (a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.l_renamed.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed.class);
            if (baVar != null) {
                baVar.m_renamed();
            }
            return false;
        }
        if (i_renamed().imageTexture != null && this.x_renamed.getAndSet(false)) {
            d_renamed(this.k_renamed, i_renamed());
        }
        if (i_renamed().imageTexture != null && this.w_renamed.getAndSet(false) && (bitmap = this.s_renamed) != null && !bitmap.isRecycled()) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i_renamed().watermarkTexture, this.s_renamed.getWidth(), this.s_renamed.getHeight());
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(9729, 9729, 33071, 33071);
            android.opengl.GLUtils.texImage2D(3553, 0, 6408, this.s_renamed, 0);
            i_renamed().watermarkOptions.width = this.s_renamed.getWidth();
            i_renamed().watermarkOptions.height = this.s_renamed.getHeight();
            this.s_renamed.recycle();
            this.s_renamed = null;
        }
        if (this.u_renamed && i_renamed().photoLoaded) {
            android.graphics.Point point2 = this.t_renamed;
            android.opengl.GLES20.glViewport(0, 0, point2.x_renamed, point2.y_renamed);
            this.n_renamed.a_renamed(i_renamed().screenTexture.f34a);
            this.n_renamed.draw();
            android.opengl.GLES20.glEnable(3042);
            android.opengl.GLES20.glBlendEquation(32774);
            android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
            float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
            android.opengl.Matrix.multiplyMM(fArrA, 0, fArrA, 0, i_renamed().overlayMatrix, 0);
            a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArrA, false, true);
            a_renamed.a_renamed.b_renamed.b_renamed.x_renamed xVar = this.o_renamed;
            if (xVar.q_renamed) {
                xVar.a_renamed(fArrA);
                this.o_renamed.draw();
            }
            if (a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed.a_renamed(this.k_renamed, i_renamed()) != null && a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed.a_renamed(this.k_renamed, i_renamed()).r_renamed) {
                a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed.a_renamed(this.k_renamed, i_renamed()).draw();
            }
            if (a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(this.k_renamed, i_renamed()) != null && a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(this.k_renamed, i_renamed()).u_renamed) {
                a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(this.k_renamed, i_renamed()).draw();
            }
            android.opengl.GLES20.glDisable(3042);
        } else {
            i_renamed();
            float[] fArr = co_renamed.polarr.renderer.entities.Context.backgroundColor;
            android.opengl.GLES20.glClearColor(fArr[0], fArr[1], fArr[2], 1.0f);
            android.opengl.GLES20.glClear(16640);
        }
        f_renamed();
        return false;
    }

    public final void n_renamed() {
        co_renamed.polarr.renderer.filters.Basic.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.y_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.as_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.h_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.be_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.s_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed.n_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bb_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.af_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed.l_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.l_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.m_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.au_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bn_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.i_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.at_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bw_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.az_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.d_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.q_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.e_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.z_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.g_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.am_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed.m_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed.m_renamed();
    }

    public final void o_renamed() {
        co_renamed.polarr.renderer.entities.Context contextI = i_renamed();
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = contextI.imageTexture;
        android.graphics.Point point = this.q_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar, point.x_renamed, point.y_renamed);
        contextI.faceMasks = null;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        m_renamed();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        android.graphics.Point point = this.t_renamed;
        point.x_renamed = i_renamed;
        point.y_renamed = i2;
        s_renamed();
        p_renamed();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        i_renamed().glRenderView.e_renamed();
        a_renamed(this.k_renamed, i_renamed(), new android.graphics.Point(512, 512));
        this.n_renamed.a_renamed();
        this.l_renamed.a_renamed();
        java.util.Iterator<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed();
        }
        this.o_renamed.a_renamed();
        this.p_renamed.a_renamed();
        this.C_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.w_renamed(i_renamed(), this.k_renamed);
    }

    public final void p_renamed() {
        float f_renamed = this.t_renamed.x_renamed;
        float f2 = f41b;
        int i_renamed = (int) (f_renamed / f2);
        int i2 = (int) (r0.y_renamed / f2);
        this.l_renamed.c_renamed(i_renamed, i2);
        java.util.Iterator<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            it.next().c_renamed(i_renamed, i2);
        }
    }

    public void q_renamed() {
        co_renamed.polarr.renderer.entities.Context contextI = i_renamed();
        d_renamed(contextI);
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(contextI);
        android.graphics.Point point = this.t_renamed;
        float[] fArr = {point.x_renamed, point.y_renamed};
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(contextI);
        float f_renamed = contextI.cropScale;
        if (contextI.cropMode) {
            fArrA = new float[]{0.0f, 0.0f, fArrB[0], fArrB[1]};
            f_renamed = 1.0f;
        }
        float f2 = (int) (fArrB[0] / 2.0f);
        float f3 = (int) (fArrB[1] / 2.0f);
        float[] fArr2 = {((fArrA[0] - f2) * f_renamed) + f2, ((fArrA[1] - f3) * f_renamed) + f3, fArrA[2] * f_renamed, fArrA[3] * f_renamed};
        co_renamed.polarr.renderer.entities.Context.Screen screen = contextI.screen;
        float f4 = screen.zoom / f_renamed;
        float[] fArr3 = {0.0f, 0.0f};
        float[] fArr4 = screen.offset;
        float f5 = fArr4[0] - fArr3[0];
        float f6 = fArr3[1] + fArr4[1];
        int i_renamed = (int) (fArr2[2] * f4);
        int i2 = (int) (fArr2[3] * f4);
        float f7 = i_renamed;
        int i3 = ((int) (fArr[0] - f7)) >> 1;
        float f8 = i2;
        int i4 = ((int) (fArr[1] - f8)) >> 1;
        int i5 = (int) (((int) (i3 - f5)) + ((fArr[0] % 2.0f) / 2.0f));
        int i6 = (int) (((int) (i4 + f6)) + ((fArr[1] % 2.0f) / 2.0f));
        int iMax = (int) ((i_renamed + i5) - fArr[0]);
        int iMin = (int) ((i2 + i6) - fArr[1]);
        if (f7 < fArr[0]) {
            iMax = java.lang.Math.max(0, iMax) + java.lang.Math.min(0, i5);
        }
        if (f8 < fArr[1]) {
            iMin = java.lang.Math.min(0, i6) + java.lang.Math.max(0, iMin);
        }
        int i7 = (int) (iMax / f4);
        int i8 = (int) (iMin / f4);
        float fMin = java.lang.Math.min(fArr[0] / f4, fArr2[2]);
        float fMin2 = java.lang.Math.min(fArr[1] / f4, fArr2[3]);
        int i9 = (int) (fArr2[2] - fMin);
        int i10 = (int) (fArr2[3] - fMin2);
        float f9 = ((fArrB[0] - fArr2[2]) / 2.0f) - fArr2[0];
        float f10 = ((fArrB[1] - fArr2[3]) / 2.0f) - fArr2[1];
        float fA_renamed = (float) (((i9 >> 1) - a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(i7, 0.0d, fArr2[2] - fMin)) - f9);
        float fA2 = (float) (((i10 >> 1) - a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(i8, 0.0d, fArr2[3] - fMin2)) - f10);
        float f11 = fMin / fArrB[0];
        float f12 = fMin2 / fArrB[1];
        contextI.compositeResolution[0] = java.lang.Math.min(fArr[0], f7);
        contextI.compositeResolution[1] = java.lang.Math.min(fArr[1], f8);
        double d2 = f5;
        contextI.compositeCoords[0] = (float) (a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(d2, i3, -i3) - d2);
        double d3 = f6;
        contextI.compositeCoords[1] = (float) (a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(d3, i4, -i4) - d3);
        float[] fArr5 = contextI.compositeCoords;
        float f13 = fArr5[0];
        float[] fArr6 = contextI.compositeResolution;
        fArr5[2] = f13 + fArr6[0];
        fArr5[3] = fArr5[1] + fArr6[1];
        e_renamed(contextI);
        b_renamed(contextI, -fA_renamed, -fA2);
        a_renamed(contextI, f11, f12);
        c_renamed(contextI);
        a_renamed(contextI, ((-f9) / fArr2[2]) * 2.0f, ((-f10) / fArr2[3]) * 2.0f, fArr2[2] / fArrB[0], fArr2[3] / fArrB[1]);
        a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.d_renamed(contextI);
        a_renamed(contextI);
        contextI.minZoom = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(contextI, (int) fArr[0], (int) fArr[1], false, null);
    }

    public void r_renamed() {
        this.n_renamed.a_renamed(i_renamed().screenMatrix);
    }

    public void s_renamed() {
        this.y_renamed.lazySet(true);
    }
}
