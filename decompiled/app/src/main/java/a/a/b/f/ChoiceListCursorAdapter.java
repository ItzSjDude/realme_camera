package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static android.util.LruCache<java.lang.String, java.util.List<java.lang.Float>> f134a = new android.util.LruCache<>(100);

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final float[][] f135b = {new float[]{1.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 1.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 1.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 1.0f}};

    /* renamed from: c_renamed, reason: collision with root package name */
    public static float f136c = 255.0f;
    public final a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed d_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed e_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed f_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed g_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed h_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed i_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed j_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed k_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed l_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.am_renamed m_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed n_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed o_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed p_renamed;
    public final android.content.res.Resources q_renamed;
    public final a_renamed.a_renamed.b_renamed.b_renamed.b_renamed r_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed t_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed u_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed v_renamed;
    public float w_renamed;
    public co_renamed.polarr.renderer.entities.BrushItem s_renamed = new co_renamed.polarr.renderer.entities.BrushItem();
    public float x_renamed = f136c * 0.5f;

    public w_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        this.q_renamed = resources;
        this.d_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed(context, resources);
        this.e_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed(context, resources);
        this.f_renamed = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(context);
        this.r_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.b_renamed(resources, context);
        this.r_renamed.a_renamed();
        int[] iArr = new int[5];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, 1, 1);
        this.g_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, 1, 1);
        this.h_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, 1, 1);
        android.opengl.GLES20.glBindTexture(3553, this.h_renamed.f34a);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9728.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9728.0f);
        android.opengl.GLES20.glBindTexture(3553, 0);
        this.j_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, 1, 1);
        this.i_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[3], 6408, 1, 1);
        this.k_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[4], 6408, 1, 1);
        this.m_renamed = a_renamed.a_renamed.b_renamed.b_renamed.am_renamed.a_renamed(resources, context);
        this.n_renamed = a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed.a_renamed(resources, context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed.a_renamed(resources, context);
        this.l_renamed = a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed.a_renamed(resources, context);
    }

    public static double a_renamed(double d_renamed) {
        return ((a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(d_renamed) / 10.0d) * 9.0d) + 1.0d;
    }

    public static java.util.List<java.lang.Float> a_renamed(co_renamed.polarr.renderer.entities.BrushItem brushItem, android.graphics.PointF pointF, float f_renamed, float f2) {
        float[] fArr;
        float[] fArr2;
        float f3 = brushItem.size * f136c;
        float f4 = brushItem.spacing;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f / f_renamed, 1.0f / f2};
        float[] fArr5 = {pointF.x_renamed * f_renamed, pointF.y_renamed * f2, 0.5f};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (brushItem.prevPoint == null) {
            brushItem.prevPoint = new float[]{fArr5[0], fArr5[1], fArr5[2]};
            if (!"paint".equals(brushItem.mode)) {
                fArr5[0] = fArr5[0] * fArr4[0];
                fArr5[1] = fArr5[1] * fArr4[1];
                brushItem.points.add(java.lang.Float.valueOf(fArr5[0]));
                brushItem.points.add(java.lang.Float.valueOf(fArr5[1]));
                brushItem.points.add(java.lang.Float.valueOf(fArr5[2]));
            }
        } else {
            if ("paint".equals(brushItem.mode)) {
                float f5 = fArr5[1];
                float[] fArr6 = brushItem.prevPoint;
                fArr = fArr4;
                fArr3[3] = (float) java.lang.Math.atan2(f5 - fArr6[1], fArr5[0] - fArr6[0]);
            } else {
                fArr = fArr4;
            }
            int iMax = java.lang.Math.max((int) (f4 * f3 * fArr5[2]), 1);
            float fA_renamed = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(fArr5, brushItem.prevPoint);
            if (fA_renamed >= iMax) {
                float f6 = 0.0f;
                if (brushItem.interpolate) {
                    int i_renamed = iMax;
                    while (true) {
                        float f7 = i_renamed;
                        if (f7 > fA_renamed) {
                            break;
                        }
                        try {
                            a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(brushItem.prevPoint, fArr5, f7 / fA_renamed, fArr3);
                            arrayList.add(java.lang.Float.valueOf(fArr3[0]));
                            arrayList.add(java.lang.Float.valueOf(fArr3[1]));
                            arrayList.add(java.lang.Float.valueOf(fArr3[2]));
                            if ("paint".equals(brushItem.mode)) {
                                arrayList.add(java.lang.Float.valueOf(fArr3[3]));
                            }
                            i_renamed += iMax;
                        } catch (java.lang.OutOfMemoryError e_renamed) {
                            e_renamed.printStackTrace();
                        }
                        e_renamed.printStackTrace();
                    }
                    if (!"paint".equals(brushItem.mode)) {
                        i_renamed = 3;
                    }
                    int size = arrayList.size();
                    int i2 = size - i_renamed;
                    brushItem.prevPoint = new float[]{((java.lang.Float) arrayList.get(i2)).floatValue(), ((java.lang.Float) arrayList.get(i2 + 1)).floatValue(), ((java.lang.Float) arrayList.get(i2 + 2)).floatValue()};
                    int i3 = 0;
                    while (i3 < size) {
                        if (brushItem.randomize > f6) {
                            fArr2 = fArr;
                            double d_renamed = f3;
                            arrayList.set(i3, java.lang.Float.valueOf((float) (((java.lang.Float) arrayList.get(i3)).floatValue() + ((java.lang.Math.random() - 0.5d) * brushItem.randomize * d_renamed))));
                            arrayList.set(i3 + 1, java.lang.Float.valueOf((float) (((java.lang.Float) arrayList.get(r6)).floatValue() + ((java.lang.Math.random() - 0.5d) * brushItem.randomize * d_renamed))));
                        } else {
                            fArr2 = fArr;
                        }
                        arrayList.set(i3, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i3)).floatValue() * fArr2[0]));
                        int i4 = i3 + 1;
                        arrayList.set(i4, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i4)).floatValue() * fArr2[1]));
                        i3 += i_renamed;
                        fArr = fArr2;
                        f6 = 0.0f;
                    }
                    brushItem.points.addAll(arrayList);
                } else {
                    float[] fArr7 = fArr;
                    fArr3[0] = fArr5[0];
                    fArr3[1] = fArr5[1];
                    fArr3[2] = fArr5[2];
                    arrayList.add(java.lang.Float.valueOf(fArr3[0]));
                    arrayList.add(java.lang.Float.valueOf(fArr3[1]));
                    arrayList.add(java.lang.Float.valueOf(fArr3[2]));
                    if ("paint".equals(brushItem.mode)) {
                        arrayList.add(java.lang.Float.valueOf(fArr3[3]));
                    }
                    i_renamed = "paint".equals(brushItem.mode) ? 4 : 3;
                    int size2 = arrayList.size();
                    int i5 = size2 - i_renamed;
                    brushItem.prevPoint = new float[]{((java.lang.Float) arrayList.get(i5)).floatValue(), ((java.lang.Float) arrayList.get(i5 + 1)).floatValue(), ((java.lang.Float) arrayList.get(i5 + 2)).floatValue()};
                    for (int i6 = 0; i6 < size2; i6 += i_renamed) {
                        if (brushItem.randomize > 0.0f) {
                            double d2 = f3;
                            arrayList.set(i6, java.lang.Float.valueOf((float) (((java.lang.Float) arrayList.get(i6)).floatValue() + ((java.lang.Math.random() - 0.5d) * brushItem.randomize * d2))));
                            arrayList.set(i6 + 1, java.lang.Float.valueOf((float) (((java.lang.Float) arrayList.get(r6)).floatValue() + ((java.lang.Math.random() - 0.5d) * brushItem.randomize * d2))));
                        }
                        arrayList.set(i6, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i6)).floatValue() * fArr7[0]));
                        int i7 = i6 + 1;
                        arrayList.set(i7, java.lang.Float.valueOf(((java.lang.Float) arrayList.get(i7)).floatValue() * fArr7[1]));
                    }
                    brushItem.points.addAll(arrayList);
                }
            }
        }
        return arrayList;
    }

    public static void a_renamed() {
        f134a.evictAll();
    }

    public static void a_renamed(java.util.List<android.graphics.PointF> list, co_renamed.polarr.renderer.entities.BrushItem brushItem, float f_renamed, float f2) {
        brushItem.points.clear();
        brushItem.prevPoint = null;
        java.util.Iterator<android.graphics.PointF> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(brushItem, it.next(), f_renamed, f2);
        }
    }

    public void a_renamed(int i_renamed) {
        int i2 = this.h_renamed.f34a;
        if (i_renamed != i2) {
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed;
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed, i2, dVar.f35b, dVar.f36c);
        }
        a_renamed(this.h_renamed.f34a, this.g_renamed.f34a, 0.0f, 0.0f, 1.0f);
    }

    public void a_renamed(int i_renamed, int i2, float f_renamed, float f2, float f3) {
        android.opengl.GLES20.glDisable(3042);
        this.o_renamed.a_renamed(i_renamed);
        a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed ayVar = this.o_renamed;
        ayVar.r_renamed = this.t_renamed.f34a;
        android.opengl.Matrix.setIdentityM(ayVar.getMatrix(), 0);
        android.opengl.Matrix.translateM(this.o_renamed.getMatrix(), 0, f_renamed, f2, 0.0f);
        android.opengl.Matrix.scaleM(this.o_renamed.getMatrix(), 0, f3, f3, 1.0f);
        a_renamed(this.o_renamed, i2);
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, int i_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarL = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.l_renamed();
        cVarL.b_renamed(i_renamed);
        cVarL.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed;
        cVarL.c_renamed(dVar.f35b, dVar.f36c);
        cVarL.a_renamed(aVar);
        cVarL.s_renamed();
        aVar.draw();
        cVarL.n_renamed();
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
        android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9729, 9729);
        android.opengl.GLES20.glBindTexture(3553, 0);
        this.f_renamed.b_renamed(dVar.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.f_renamed.c_renamed(dVar.f35b, dVar.f36c);
        this.f_renamed.s_renamed();
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        b_renamed();
        this.f_renamed.n_renamed();
        android.opengl.GLES20.glFinish();
        android.opengl.GLES20.glFlush();
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context, co_renamed.polarr.renderer.entities.BrushItem brushItem) {
        a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed bpVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed next;
        this.x_renamed = java.lang.Math.max(10.0f, brushItem.size * f136c);
        float f_renamed = brushItem.spacing;
        this.w_renamed = (float) a_renamed(brushItem.hardness);
        if (!"paint".equals(brushItem.mode)) {
            a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar = this.d_renamed;
            bfVar.n_renamed = this.x_renamed;
            bfVar.o_renamed = this.w_renamed;
            bfVar.p_renamed = brushItem.flow;
            bfVar.q_renamed = brushItem.channel;
            bfVar.r_renamed = brushItem.erase;
            bfVar.s_renamed = false;
            return;
        }
        boolean z_renamed = brushItem.erase;
        if (z_renamed) {
            a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar2 = this.d_renamed;
            bfVar2.r_renamed = z_renamed;
            bfVar2.n_renamed = this.x_renamed;
            bfVar2.o_renamed = this.w_renamed;
            bfVar2.p_renamed = brushItem.flow;
            bfVar2.q_renamed = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
            return;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed bpVar2 = this.e_renamed;
        bpVar2.n_renamed = this.x_renamed;
        bpVar2.o_renamed = brushItem.flow;
        if (context.brushes.get(brushItem.texture) != null) {
            bpVar = this.e_renamed;
            next = context.brushes.get(brushItem.texture);
        } else {
            bpVar = this.e_renamed;
            next = context.brushes.values().iterator().next();
        }
        bpVar.p_renamed = next.f34a;
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context, co_renamed.polarr.renderer.entities.BrushItem brushItem, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        android.opengl.GLES20.glDisable(3042);
        brushItem.interpolate = true;
        if (com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR.equals(brushItem.texture) || "mosaic".equals(brushItem.texture) || "dot".equals(brushItem.texture) || "eraser".equals(brushItem.texture)) {
            brushItem.mode = "effect";
        } else {
            brushItem.mode = "paint";
        }
        this.u_renamed = dVar;
        this.p_renamed = context.intermediateTexture;
        this.s_renamed = brushItem;
        this.s_renamed.points.clear();
        this.s_renamed.prevPoint = null;
        this.f_renamed.b_renamed(this.p_renamed.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.p_renamed;
        cVar.c_renamed(dVar2.f35b, dVar2.f36c);
        this.f_renamed.s_renamed();
        if ("effect".equals(this.s_renamed.mode)) {
            android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        b_renamed();
        this.f_renamed.n_renamed();
        if (com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s_renamed.texture)) {
            f_renamed();
        } else if ("mosaic".equals(this.s_renamed.texture)) {
            a_renamed("square");
        } else if ("dot".equals(this.s_renamed.texture)) {
            a_renamed("dot");
        } else {
            a_renamed(this.j_renamed);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.p_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = context.paintTexture;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar3, dVar4.f35b, dVar4.f36c);
        a_renamed(context, this.s_renamed);
        this.f_renamed.b_renamed(this.p_renamed.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar2 = this.f_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = this.p_renamed;
        cVar2.c_renamed(dVar5.f35b, dVar5.f36c);
        this.f_renamed.s_renamed();
        if ("effect".equals(this.s_renamed.mode)) {
            android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        b_renamed();
        this.f_renamed.n_renamed();
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context, co_renamed.polarr.renderer.entities.BrushItem brushItem, co_renamed.polarr.renderer.entities.BrushItem brushItem2, boolean z_renamed, boolean z2) {
        a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed bpVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed next;
        if (brushItem == null) {
            brushItem = new co_renamed.polarr.renderer.entities.BrushItem();
        }
        if (brushItem2 == null) {
            brushItem2 = this.s_renamed;
        }
        if (z2) {
            brushItem.size = brushItem2.size;
            brushItem.hardness = brushItem2.hardness;
            brushItem.flow = brushItem2.flow;
        }
        brushItem2.points = brushItem.points;
        brushItem2.size = brushItem.size;
        brushItem2.spacing = brushItem.spacing;
        brushItem2.hardness = brushItem.hardness;
        brushItem2.flow = brushItem.flow;
        brushItem2.channel = brushItem.channel;
        brushItem2.erase = brushItem.erase;
        brushItem2.mode = brushItem.mode;
        brushItem2.texture = brushItem.texture;
        brushItem2.randomize = brushItem.randomize;
        brushItem2.interpolate = brushItem.interpolate;
        co_renamed.polarr.renderer.entities.BrushItem brushItem3 = this.s_renamed;
        brushItem3.mode = brushItem.mode;
        brushItem3.texture = brushItem.texture;
        brushItem3.randomize = brushItem.randomize;
        brushItem3.interpolate = brushItem.interpolate;
        brushItem3.erase = brushItem2.erase;
        this.x_renamed = java.lang.Math.max(10.0f, brushItem2.size * f136c);
        float f_renamed = brushItem2.spacing;
        this.w_renamed = (float) a_renamed(brushItem2.hardness);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.paintTexture;
        int i_renamed = dVar.f35b;
        int i2 = dVar.f36c;
        if (!"paint".equals(brushItem2.mode)) {
            a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar = this.d_renamed;
            bfVar.n_renamed = this.x_renamed;
            bfVar.o_renamed = this.w_renamed;
            bfVar.p_renamed = brushItem2.flow;
            bfVar.q_renamed = brushItem2.channel;
            bfVar.r_renamed = brushItem2.erase;
            bfVar.s_renamed = false;
            if (z_renamed) {
                a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(context.glRenderView.c_renamed(), context).r_renamed = this.x_renamed;
                a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(context.glRenderView.c_renamed(), context).s_renamed = this.w_renamed;
                a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed.a_renamed(context.glRenderView.c_renamed(), context).t_renamed = brushItem2.flow;
                return;
            }
            return;
        }
        boolean z3 = brushItem2.erase;
        if (z3) {
            a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar2 = this.d_renamed;
            bfVar2.r_renamed = z3;
            bfVar2.n_renamed = this.x_renamed;
            bfVar2.o_renamed = this.w_renamed;
            bfVar2.p_renamed = brushItem2.flow;
            bfVar2.q_renamed = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
            return;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bp_renamed bpVar2 = this.e_renamed;
        bpVar2.n_renamed = this.x_renamed;
        bpVar2.o_renamed = brushItem2.flow;
        if (context.brushes.get(brushItem2.texture) != null) {
            bpVar = this.e_renamed;
            next = context.brushes.get(brushItem2.texture);
        } else {
            bpVar = this.e_renamed;
            next = context.brushes.values().iterator().next();
        }
        bpVar.p_renamed = next.f34a;
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context, co_renamed.polarr.renderer.entities.BrushItem brushItem, boolean z_renamed) {
        java.util.List<java.lang.Float> list;
        if (brushItem.blend) {
            return;
        }
        co_renamed.polarr.renderer.entities.BrushItem brushItem2 = new co_renamed.polarr.renderer.entities.BrushItem();
        if (brushItem.pointId == null || (list = brushItem.points) == null || list.isEmpty()) {
            java.lang.String str = brushItem.pointId;
            if (str != null) {
                brushItem.points = f134a.get(str);
            }
        } else {
            f134a.put(brushItem.pointId, brushItem.points);
        }
        a_renamed(context, brushItem, brushItem2, z_renamed, false);
        java.util.List<java.lang.Float> list2 = brushItem2.points;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        a_renamed(brushItem2.points);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(co_renamed.polarr.renderer.entities.Context r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed(co_renamed.polarr.renderer.entities.Context, boolean):void");
    }

    public final void a_renamed(java.lang.String str) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed;
        int i_renamed = dVar.f35b;
        int i2 = dVar.f36c;
        float f_renamed = this.s_renamed.mosaicSize;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.j_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar2, i_renamed, i2);
        android.opengl.GLES20.glBindTexture(3553, dVar2.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9728, 9728);
        android.opengl.GLES20.glBindTexture(3553, 0);
        a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed awVar = this.l_renamed;
        awVar.r_renamed = str;
        awVar.s_renamed = f_renamed;
        awVar.t_renamed = dVar.f35b;
        awVar.u_renamed = dVar.f36c;
        awVar.v_renamed = this.v_renamed.f34a;
        awVar.a_renamed(dVar.f34a);
        a_renamed(this.l_renamed, dVar2);
    }

    public void a_renamed(java.util.List<java.lang.Float> list) {
        a_renamed.a_renamed.b_renamed.b_renamed.bf_renamed bfVar;
        boolean z_renamed;
        if (!"paint".equals(this.s_renamed.mode)) {
            bfVar = this.d_renamed;
            z_renamed = false;
        } else if (!this.s_renamed.erase) {
            this.e_renamed.a_renamed(list);
            return;
        } else {
            bfVar = this.d_renamed;
            z_renamed = true;
        }
        bfVar.a_renamed(list, z_renamed);
    }

    public void a_renamed(java.util.List<android.graphics.PointF> list, float f_renamed, float f2, float f3) {
        android.opengl.GLES20.glDisable(3042);
        this.f_renamed.b_renamed(this.p_renamed.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.p_renamed;
        cVar.c_renamed(dVar.f35b, dVar.f36c);
        this.f_renamed.s_renamed();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.graphics.PointF pointF : list) {
            co_renamed.polarr.renderer.entities.BrushItem brushItem = this.s_renamed;
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.p_renamed;
            arrayList.addAll(a_renamed(brushItem, pointF, dVar2.f35b, dVar2.f36c));
        }
        a_renamed(arrayList);
        this.f_renamed.n_renamed();
        a_renamed(false, f_renamed, f2, f3);
    }

    public final void a_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.b_renamed bVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        android.opengl.GLES20.glFinish();
        "effect".equals(this.s_renamed.mode);
        this.f_renamed.b_renamed(this.u_renamed.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.u_renamed;
        cVar.c_renamed(dVar2.f35b, dVar2.f36c);
        this.f_renamed.s_renamed();
        co_renamed.polarr.renderer.filters.Basic basic = co_renamed.polarr.renderer.filters.Basic.getInstance(this.q_renamed);
        basic.setNeedClear(false);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        android.opengl.GLES20.glBlendFuncSeparate(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.s_renamed.mode)) {
            this.r_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
            this.r_renamed.a_renamed(this.p_renamed.f34a);
            a_renamed.a_renamed.b_renamed.b_renamed.b_renamed bVar2 = this.r_renamed;
            bVar2.q_renamed = 1.0f;
            bVar2.r_renamed = 1.0f;
            if (com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s_renamed.texture) || "mosaic".equals(this.s_renamed.texture) || "dot".equals(this.s_renamed.texture) || z_renamed) {
                bVar = this.r_renamed;
                dVar = this.j_renamed;
            } else {
                bVar = this.r_renamed;
                dVar = this.t_renamed;
            }
            bVar.s_renamed = dVar.f34a;
            this.r_renamed.draw();
        } else {
            android.opengl.GLES20.glBlendFunc(1, 771);
            basic.setInputTextureId(this.p_renamed.f34a);
            basic.draw();
        }
        android.opengl.GLES20.glDisable(3042);
        this.f_renamed.n_renamed();
    }

    public final void a_renamed(boolean z_renamed, float f_renamed, float f2, float f3) {
        a_renamed.a_renamed.b_renamed.b_renamed.b_renamed bVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        this.f_renamed.b_renamed(this.u_renamed.f34a);
        this.f_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.u_renamed;
        cVar.c_renamed(dVar2.f35b, dVar2.f36c);
        this.f_renamed.s_renamed();
        co_renamed.polarr.renderer.filters.Basic basic = co_renamed.polarr.renderer.filters.Basic.getInstance(this.q_renamed);
        basic.setNeedClear(false);
        android.opengl.Matrix.translateM(basic.getMatrix(), 0, f_renamed, f2, 0.0f);
        android.opengl.Matrix.scaleM(basic.getMatrix(), 0, f3, f3, 1.0f);
        if (!z_renamed) {
            android.opengl.GLES20.glClear(16384);
            android.opengl.GLES20.glDisable(3042);
            basic.setInputTextureId(this.g_renamed.f34a);
            basic.draw();
        }
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        android.opengl.GLES20.glBlendFuncSeparate(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.s_renamed.mode)) {
            this.r_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
            android.opengl.Matrix.translateM(this.r_renamed.getMatrix(), 0, f_renamed, f2, 0.0f);
            android.opengl.Matrix.scaleM(this.r_renamed.getMatrix(), 0, f3, f3, 1.0f);
            this.r_renamed.a_renamed(this.p_renamed.f34a);
            a_renamed.a_renamed.b_renamed.b_renamed.b_renamed bVar2 = this.r_renamed;
            bVar2.q_renamed = 1.0f;
            bVar2.r_renamed = 1.0f;
            if (com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s_renamed.texture) || "mosaic".equals(this.s_renamed.texture) || "dot".equals(this.s_renamed.texture) || z_renamed) {
                bVar = this.r_renamed;
                dVar = this.j_renamed;
            } else {
                bVar = this.r_renamed;
                dVar = this.t_renamed;
            }
            bVar.s_renamed = dVar.f34a;
            this.r_renamed.draw();
        } else {
            android.opengl.GLES20.glBlendFunc(1, 771);
            basic.setInputTextureId(this.p_renamed.f34a);
            basic.draw();
        }
        android.opengl.GLES20.glDisable(3042);
        this.f_renamed.n_renamed();
    }

    public void a_renamed(float[] fArr) {
        android.opengl.GLES20.glColorMask(fArr[0] != 0.0f, fArr[1] != 0.0f, fArr[2] != 0.0f, fArr[3] != 0.0f);
        android.opengl.GLES20.glClear(16384);
    }

    public void b_renamed() {
        a_renamed(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
    }

    public void b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        this.v_renamed = dVar;
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed c_renamed() {
        return this.h_renamed;
    }

    public void c_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        this.t_renamed = dVar;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.g_renamed, dVar.f35b, dVar.f36c);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.h_renamed, dVar.f35b, dVar.f36c);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.i_renamed, dVar.f35b, dVar.f36c);
        a_renamed(this.h_renamed);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a, this.g_renamed.f34a, dVar.f35b, dVar.f36c);
    }

    public void d_renamed() {
        android.opengl.GLES20.glDisable(3042);
        this.u_renamed = this.g_renamed;
        a_renamed(false);
        g_renamed();
        android.opengl.GLES20.glBindTexture(3553, this.h_renamed.f34a);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9728.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9728.0f);
        android.opengl.GLES20.glBindTexture(3553, 0);
    }

    public void e_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.g_renamed;
        if (dVar != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.g_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.h_renamed;
        if (dVar2 != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar2);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.h_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.j_renamed;
        if (dVar3 != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar3);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.j_renamed.f34a);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = this.k_renamed;
        if (dVar4 != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar4);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.k_renamed.f34a);
        }
    }

    public final void f_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed;
        int i_renamed = dVar.f35b;
        int i2 = dVar.f36c;
        while (true) {
            if (i_renamed <= 2048 && i2 <= 2048) {
                float f_renamed = 1.0f / i_renamed;
                float f2 = 1.0f / i2;
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.j_renamed;
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.p_renamed;
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar2, i_renamed, i2);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar3, i_renamed, i2);
                android.opengl.GLES20.glBindTexture(3553, dVar2.f34a);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9729, 9729);
                android.opengl.GLES20.glBindTexture(3553, 0);
                a_renamed.a_renamed.b_renamed.b_renamed.am_renamed amVar = this.m_renamed;
                amVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
                amVar.r_renamed = new float[]{f_renamed, 0.0f};
                amVar.a_renamed(this.t_renamed.f34a);
                a_renamed(this.m_renamed, dVar3);
                a_renamed.a_renamed.b_renamed.b_renamed.am_renamed amVar2 = this.m_renamed;
                amVar2.r_renamed = new float[]{0.0f, f2};
                amVar2.a_renamed(dVar3.f34a);
                a_renamed(this.m_renamed, dVar2);
                a_renamed.a_renamed.b_renamed.b_renamed.am_renamed amVar3 = this.m_renamed;
                amVar3.r_renamed = new float[]{f_renamed, 0.0f};
                amVar3.a_renamed(dVar2.f34a);
                a_renamed(this.m_renamed, dVar3);
                a_renamed.a_renamed.b_renamed.b_renamed.am_renamed amVar4 = this.m_renamed;
                amVar4.r_renamed = new float[]{0.0f, f2};
                amVar4.a_renamed(dVar3.f34a);
                a_renamed(this.m_renamed, dVar2);
                return;
            }
            i_renamed >>= 1;
            i2 >>= 1;
        }
    }

    public final void g_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.h_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a, this.i_renamed.f34a, dVar.f35b, dVar.f36c);
        this.n_renamed.a_renamed(this.g_renamed.f34a);
        a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed bkVar = this.n_renamed;
        bkVar.r_renamed = this.t_renamed.f34a;
        bkVar.s_renamed = this.i_renamed.f34a;
        bkVar.t_renamed = this.p_renamed.f34a;
        a_renamed(bkVar, this.h_renamed);
    }
}
