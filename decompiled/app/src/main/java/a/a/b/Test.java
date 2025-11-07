package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class d_renamed implements a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed, co_renamed.polarr.renderer.PacmanFilter {
    public a_renamed.a_renamed.b_renamed.b_renamed.af_renamed A_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed B_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed I_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed J_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed K_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.z_renamed L_renamed;
    public boolean N_renamed;
    public int[] O_renamed;
    public byte[] P_renamed;
    public android.graphics.Bitmap Q_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed f49a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.b_renamed.an_renamed f50b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public co_renamed.polarr.renderer.filters.Basic f51c;
    public a_renamed.a_renamed.b_renamed.c_renamed e_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed f_renamed;
    public boolean h_renamed;
    public android.os.Handler j_renamed;
    public java.nio.ByteBuffer k_renamed;
    public boolean l_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed m_renamed;
    public float p_renamed;
    public float q_renamed;
    public float r_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed s_renamed;
    public co_renamed.polarr.renderer.entities.Context t_renamed;
    public int u_renamed;
    public int v_renamed;
    public java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed> w_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.w_renamed x_renamed;
    public android.content.res.Resources y_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed z_renamed;
    public int C_renamed = 0;
    public int D_renamed = 0;
    public boolean E_renamed = true;
    public boolean F_renamed = false;
    public boolean G_renamed = false;
    public boolean H_renamed = true;
    public int M_renamed = 0;
    public boolean R_renamed = false;
    public boolean d_renamed = true;
    public int g_renamed = 0;
    public java.util.Map<java.lang.String, java.lang.Object> i_renamed = new java.util.HashMap();
    public a_renamed.a_renamed.b_renamed.f_renamed.s_renamed n_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.s_renamed(10);
    public a_renamed.a_renamed.b_renamed.f_renamed.s_renamed o_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.s_renamed(20);

    public class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ byte[] f55a;

        public a_renamed(byte[] bArr) {
            this.f55a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.d_renamed.this.l_renamed = true;
            java.util.Map<java.lang.String, java.lang.Float> mapA = a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(300, 300, this.f55a, a_renamed.a_renamed.b_renamed.d_renamed.this.t_renamed.renderStates, false);
            java.util.HashMap map = new java.util.HashMap();
            map.putAll(mapA);
            if (!a_renamed.a_renamed.b_renamed.d_renamed.this.E_renamed) {
                map.remove("highlights");
                map.remove("shadows");
                map.remove("clarity");
                map.remove("dehaze");
            }
            java.util.Map<java.lang.String, java.lang.Object> mapGetRefStates = co_renamed.polarr.renderer.FilterPackageUtil.GetRefStates(map, 0.5f);
            synchronized (a_renamed.a_renamed.b_renamed.d_renamed.this.i_renamed) {
                a_renamed.a_renamed.b_renamed.d_renamed.this.i_renamed.clear();
                a_renamed.a_renamed.b_renamed.d_renamed.this.i_renamed.putAll(mapGetRefStates);
            }
            a_renamed.a_renamed.b_renamed.d_renamed.this.l_renamed = false;
        }
    }

    public d_renamed() {
        this.o_renamed.a_renamed(false);
        this.p_renamed = 0.0f;
        this.q_renamed = 0.0f;
        this.r_renamed = 1.0f;
    }

    public static java.util.List<android.graphics.PointF> a_renamed(java.util.List<android.graphics.PointF> list, float f_renamed, float f2, float f3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float f4 = (f3 - 1.0f) / 2.0f;
        for (android.graphics.PointF pointF : list) {
            android.graphics.PointF pointF2 = new android.graphics.PointF();
            pointF2.x_renamed = ((pointF.x_renamed + f4) - (f_renamed / 2.0f)) / f3;
            pointF2.y_renamed = ((pointF.y_renamed + f4) - (f2 / 2.0f)) / f3;
            arrayList.add(pointF2);
        }
        return arrayList;
    }

    public final void A_renamed() {
        java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> map;
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        if (context != null && (map = context.patterns) != null) {
            java.util.Iterator<a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> it = map.values().iterator();
            while (it.hasNext()) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(it.next());
            }
        }
        co_renamed.polarr.renderer.entities.Context context2 = this.t_renamed;
        if (context2 != null) {
            context2.patterns = null;
        }
    }

    public final byte[] B_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.t_renamed.intermediateTexture, 300, 300);
        if (this.k_renamed == null) {
            this.k_renamed = java.nio.ByteBuffer.allocate(360000);
        }
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVarA = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed((co_renamed.polarr.renderer.entities.Context) null);
        cVarA.b_renamed(this.t_renamed.intermediateTexture.f34a);
        cVarA.c_renamed(300, 300);
        cVarA.s_renamed();
        co_renamed.polarr.renderer.filters.Basic basic = co_renamed.polarr.renderer.filters.Basic.getInstance(this.y_renamed);
        basic.setInputTextureId(this.t_renamed.imageTexture.f34a);
        basic.draw();
        android.opengl.GLES20.glReadPixels(0, 0, 300, 300, 6408, 5121, this.k_renamed);
        cVarA.n_renamed();
        byte[] bArrArray = this.k_renamed.array();
        this.k_renamed.rewind();
        return bArrArray;
    }

    @Override // a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed
    public int a_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.z_renamed;
        if (cVar == null) {
            return 0;
        }
        return cVar.q_renamed();
    }

    public int a_renamed(java.util.List<android.graphics.PointF> list) {
        this.x_renamed.a_renamed(a_renamed(list, this.p_renamed, this.q_renamed, this.r_renamed), this.p_renamed, this.q_renamed, this.r_renamed);
        return this.t_renamed.writableTexture.f34a;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed aoVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2, float f_renamed, java.lang.Float f2) {
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
        a_renamed(aoVar, dVar.f34a, context.readableTexture);
        aoVar.r_renamed = new float[]{0.0f, (1.0f / dVar2.f36c) * f_renamed, 0.0f, (1.0f / dVar2.f36c) * fFloatValue2};
        aoVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(aoVar, context.readableTexture.f34a, dVar2);
        return dVar2;
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.at_renamed atVar, a_renamed.a_renamed.b_renamed.b_renamed.bw_renamed bwVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        atVar.r_renamed = new float[]{(1.0f / dVar2.f35b) * 8.0f, 0.0f};
        atVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(atVar, dVar.f34a, context.readableTexture);
        bwVar.r_renamed = new float[]{0.0f, (1.0f / dVar2.f36c) * 8.0f};
        bwVar.s_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(bwVar, context.readableTexture.f34a, dVar2);
        return dVar2;
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, java.lang.String str) {
        return a_renamed(bitmap, str, 1.0f);
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, java.lang.String str, float f_renamed) {
        return a_renamed(bitmap, str, f_renamed, 0.0f);
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, java.lang.String str, float f_renamed, float f2) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("fastRenderBitmap::filterId=%s_renamed::fastRenderBitmap=%f_renamed", str, java.lang.Float.valueOf(f_renamed));
        android.opengl.GLES20.glBindTexture(3553, this.C_renamed);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z_renamed = this.H_renamed;
        this.H_renamed = false;
        b_renamed();
        this.H_renamed = z_renamed;
        c_renamed(f2);
        b_renamed(str, f_renamed);
        j_renamed();
        android.opengl.GLES20.glFinish();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(this.t_renamed.readableTexture.f34a, bitmap.getWidth(), bitmap.getHeight()));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end render bitmap");
        return bitmapCreateBitmap;
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, java.util.Map<java.lang.String, java.lang.Object> map) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderBitmap::renderStates=%s_renamed", map == null ? "null" : map.toString());
        android.opengl.GLES20.glBindTexture(3553, this.C_renamed);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z_renamed = this.H_renamed;
        this.H_renamed = false;
        b_renamed();
        this.H_renamed = z_renamed;
        b_renamed(map);
        a_renamed((android.content.Context) null, false);
        android.opengl.GLES20.glFinish();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(this.t_renamed.readableTexture.f34a, bitmap.getWidth(), bitmap.getHeight()));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end render bitmap");
        return bitmapCreateBitmap;
    }

    public java.util.Map<java.lang.String, java.lang.Object> a_renamed(float f_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("autoEnhanceGlobalForFace::percent=%f_renamed", java.lang.Float.valueOf(f_renamed));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start auto enhance global face");
        java.util.Map<java.lang.String, java.lang.Object> mapGetRefStates = co_renamed.polarr.renderer.FilterPackageUtil.GetRefStates((java.util.Map) a_renamed.a_renamed.b_renamed.f_renamed.l_renamed.b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.f105a), f_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end auto enhance global face");
        return mapGetRefStates;
    }

    public java.util.Map<java.lang.String, java.lang.Object> a_renamed(float f_renamed, java.util.Map<java.lang.String, java.lang.Object> map) {
        int i_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("autoEnhanceGlobal::percent=%f_renamed", java.lang.Float.valueOf(f_renamed));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start auto enhance global");
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed.imageTexture;
        float f2 = dVar.f35b;
        float f3 = dVar.f36c;
        java.util.HashMap map2 = new java.util.HashMap();
        if (this.P_renamed == null || this.Q_renamed == null) {
            int i2 = (int) f2;
            int i3 = (int) f3;
            this.P_renamed = a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.b_renamed(this.y_renamed, this.t_renamed.imageTexture, i2, i3);
            this.Q_renamed = android.graphics.Bitmap.createBitmap(i2, i3, android.graphics.Bitmap.Config.ARGB_8888);
            this.Q_renamed.copyPixelsFromBuffer(java.nio.ByteBuffer.wrap(this.P_renamed));
        }
        int i4 = 80;
        if (f2 > f3) {
            i_renamed = (int) (80 * (f2 / f3));
        } else {
            i4 = (int) (80 * (f3 / f2));
            i_renamed = 80;
        }
        android.graphics.Bitmap bitmapA = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(this.Q_renamed, i_renamed, i4);
        byte[] bArrA = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(bitmapA);
        java.util.List<co_renamed.polarr.renderer.entities.FaceItem> list = null;
        if (map != null && map.get("faces") != null) {
            list = (java.util.List) map.get("faces");
        }
        java.util.Map<java.lang.String, java.lang.Float> mapA = a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(bitmapA.getWidth(), bitmapA.getHeight(), bArrA, this.t_renamed.renderStates, (list == null || list.isEmpty()) ? false : true);
        if (list != null) {
            java.util.HashMap map3 = new java.util.HashMap();
            for (co_renamed.polarr.renderer.entities.FaceItem faceItem : list) {
                int height = this.Q_renamed.getHeight();
                int width = this.Q_renamed.getWidth();
                float[] fArr = faceItem.boundaries;
                float f4 = width;
                int i5 = (int) (fArr[0] * f4);
                float f5 = height;
                int i6 = (int) (fArr[1] * f5);
                int i7 = (int) (fArr[2] * f4);
                int i8 = (int) (fArr[3] * f5);
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(this.Q_renamed, i5, i6, i7, i8);
                if (i7 > 50 || i8 > 50) {
                    bitmapCreateBitmap = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(bitmapCreateBitmap, 50.0f, 50.0f);
                }
                java.util.Map<java.lang.String, java.lang.Float> mapA2 = a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(bitmapCreateBitmap), this.t_renamed.renderStates);
                for (java.lang.String str : mapA2.keySet()) {
                    map3.put(str, !map3.containsKey(str) ? mapA2.get(str) : java.lang.Float.valueOf(java.lang.Math.min(((java.lang.Float) map3.get(str)).floatValue(), mapA2.get(str).floatValue())));
                }
            }
            for (java.util.Map.Entry entry : map3.entrySet()) {
                a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(mapA, (java.lang.String) entry.getKey(), ((java.lang.Float) entry.getValue()).floatValue());
            }
        }
        map2.putAll(mapA);
        if (!this.E_renamed) {
            map2.remove("highlights");
            map2.remove("shadows");
            map2.remove("clarity");
            map2.remove("dehaze");
        }
        android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        java.util.Map<java.lang.String, java.lang.Object> mapGetRefStates = co_renamed.polarr.renderer.FilterPackageUtil.GetRefStates(map2, f_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end auto enhance global");
        return mapGetRefStates;
    }

    public void a_renamed(float f_renamed, float f2, float f3) {
        this.p_renamed = f_renamed;
        this.q_renamed = f2;
        this.r_renamed = f3;
    }

    public void a_renamed(int i_renamed) {
        this.x_renamed.a_renamed(i_renamed);
    }

    public void a_renamed(int i_renamed, int i2) {
        this.x_renamed.a_renamed(i_renamed, i2, this.p_renamed, this.q_renamed, this.r_renamed);
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("clearTexture::textureId=%d_renamed::width=%d_renamed::height=%d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
        android.opengl.GLES20.glDisable(3089);
        this.z_renamed.b_renamed(i_renamed);
        this.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.z_renamed.c_renamed(i2, i3);
        this.z_renamed.s_renamed();
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        android.opengl.GLES20.glClear(16384);
        this.z_renamed.n_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed
    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (this.f51c == null) {
            this.f51c = new co_renamed.polarr.renderer.filters.Basic(this.y_renamed, this.t_renamed);
            this.f51c.a_renamed();
        }
        this.f51c.setNeedClear(true);
        android.opengl.Matrix.setIdentityM(this.f51c.getMatrix(), 0);
        a_renamed(this.f51c, i_renamed, i2, i3, i4);
    }

    @Override // a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed
    public void a_renamed(int i_renamed, int i2, float[] fArr, int i3, int i4) {
        if (this.f51c == null) {
            this.f51c = new co_renamed.polarr.renderer.filters.Basic(this.y_renamed, this.t_renamed);
            this.f51c.a_renamed();
        }
        this.f51c.setNeedClear(true);
        this.f51c.a_renamed(fArr);
        a_renamed(this.f51c, i_renamed, i2, i3, i4);
        android.opengl.Matrix.setIdentityM(this.f51c.getMatrix(), 0);
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, int i_renamed, int i2, int i3, int i4) {
        this.z_renamed.b_renamed(i2);
        this.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.z_renamed.c_renamed(i3, i4);
        this.z_renamed.a_renamed(aVar);
        if (i_renamed != 0) {
            this.z_renamed.a_renamed(i_renamed);
        }
        this.z_renamed.draw();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("render tex out id_renamed");
    }

    @Override // a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed
    public void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, int i_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        if (aVar == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderTexture::inputTextureID=%d_renamed::outputTexture=%s_renamed", java.lang.Integer.valueOf(i_renamed), dVar.toString());
        this.z_renamed.b_renamed(dVar.f34a);
        this.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.z_renamed.c_renamed(dVar.f35b, dVar.f36c);
        this.z_renamed.a_renamed(aVar);
        if (i_renamed != 0) {
            this.z_renamed.a_renamed(i_renamed);
        }
        this.z_renamed.draw();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("render tex");
    }

    @Override // a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed
    public void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, int i_renamed, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i2, int i3, int i4, int i5) {
        if (aVar == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("renderTexture::inputTextureID=%d_renamed::outputTexture=%s_renamed", java.lang.Integer.valueOf(i_renamed), dVar.toString());
        this.z_renamed.b_renamed(dVar.f34a);
        this.z_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.z_renamed.c_renamed(dVar.f35b, dVar.f36c);
        this.z_renamed.a_renamed(aVar);
        if (i_renamed != 0) {
            this.z_renamed.a_renamed(i_renamed);
        }
        this.z_renamed.a_renamed(i2, i3, i4, i5);
        this.z_renamed.draw();
        this.z_renamed.r_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("render tex");
    }

    public void a_renamed(android.content.Context context, boolean z_renamed) {
        int i_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("render::fastDraw=%b_renamed", java.lang.Boolean.valueOf(z_renamed));
        if (this.s_renamed == null) {
            android.util.Log.e_renamed("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z_renamed) {
            a_renamed(this.y_renamed);
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("render blur");
        a_renamed(context, z_renamed, z_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("do render");
        if (z_renamed || (i_renamed = this.D_renamed) == 0) {
            return;
        }
        this.z_renamed.b_renamed(i_renamed);
        this.z_renamed.c_renamed(this.u_renamed, this.v_renamed);
        this.z_renamed.s_renamed();
        android.opengl.GLES20.glViewport(0, 0, this.u_renamed, this.v_renamed);
        co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
        basicA.a_renamed(this.t_renamed.readableTexture.f34a);
        android.opengl.Matrix.translateM(basicA.getMatrix(), 0, this.p_renamed, this.q_renamed, 0.0f);
        float[] matrix = basicA.getMatrix();
        float f_renamed = this.r_renamed;
        android.opengl.Matrix.scaleM(matrix, 0, f_renamed, f_renamed, 1.0f);
        basicA.draw();
        this.z_renamed.n_renamed();
    }

    public final void a_renamed(android.content.Context context, boolean z_renamed, boolean z2) {
        co_renamed.polarr.renderer.entities.Context.WatermarkOptions watermarkOptions;
        co_renamed.polarr.renderer.entities.Context context2;
        android.content.res.Resources resources;
        java.util.List list;
        a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed ajVar;
        boolean z3 = false;
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("render::needSkip=%b_renamed::fastDraw=%b_renamed", java.lang.Boolean.valueOf(z_renamed), java.lang.Boolean.valueOf(z2));
        if (this.s_renamed == null) {
            android.util.Log.e_renamed("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z2) {
            this.x_renamed.a_renamed(this.t_renamed, false);
            a_renamed.a_renamed.b_renamed.f_renamed.c_renamed.a_renamed(this.t_renamed, this.y_renamed);
        }
        if (!z2) {
            co_renamed.polarr.renderer.entities.Context context3 = this.t_renamed;
            int[] iArr = context3.textures;
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarA = (iArr == null || iArr.length <= 0) ? a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed.a_renamed(this.y_renamed, this.t_renamed) : a_renamed.a_renamed.b_renamed.b_renamed.as_renamed.a_renamed(this.y_renamed, context3);
            aVarA.a_renamed(this.t_renamed.matrix);
            if (this.z_renamed == null) {
                this.z_renamed = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(this.t_renamed);
            }
            this.z_renamed.a_renamed(aVarA);
            this.z_renamed.b_renamed(this.t_renamed.readableTexture.f34a);
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar = this.z_renamed;
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed.readableTexture;
            cVar.c_renamed(dVar.f35b, dVar.f36c);
            this.z_renamed.a_renamed(this.t_renamed.imageTexture.f34a);
            this.z_renamed.draw();
        }
        java.lang.System.currentTimeMillis();
        this.s_renamed.a_renamed(this.t_renamed.readableTexture.f34a);
        this.s_renamed.w_renamed();
        if (z2) {
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar2 = this.s_renamed;
            co_renamed.polarr.renderer.entities.Context context4 = this.t_renamed;
            dVar2.d_renamed(context4.readableTexture.f34a, context4.writableTexture.f34a);
            if (this.C_renamed != 0) {
                this.s_renamed.t_renamed();
                co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
                basicA.a_renamed(this.C_renamed);
                basicA.draw();
            }
        }
        if (!z2 && (list = (java.util.List) this.t_renamed.renderStates.get("spots")) != null && !list.isEmpty()) {
            co_renamed.polarr.renderer.entities.Context context5 = this.t_renamed;
            int[] iArr2 = context5.textures;
            if (iArr2 == null || iArr2.length <= 0) {
                a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed ajVar2 = this.B_renamed;
                if (ajVar2 == null) {
                    this.B_renamed = a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed.b_renamed(this.y_renamed, this.t_renamed);
                } else {
                    ajVar2.a_renamed(this.t_renamed);
                }
                ajVar = this.B_renamed;
            } else {
                a_renamed.a_renamed.b_renamed.b_renamed.af_renamed afVar = this.A_renamed;
                if (afVar == null) {
                    this.A_renamed = a_renamed.a_renamed.b_renamed.b_renamed.af_renamed.a_renamed(this.y_renamed, context5);
                } else {
                    afVar.a_renamed(context5);
                }
                ajVar = this.A_renamed;
            }
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                co_renamed.polarr.renderer.entities.SpotItem spotItem = (co_renamed.polarr.renderer.entities.SpotItem) list.get(i_renamed);
                ajVar.s_renamed = spotItem.feather;
                ajVar.t_renamed = spotItem.size;
                ajVar.u_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.position);
                ajVar.v_renamed = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(spotItem.sourcePosition);
                ajVar.w_renamed = spotItem.angle;
                ajVar.x_renamed = spotItem.opacity;
                ajVar.y_renamed = spotItem.mode;
                this.s_renamed.b_renamed(ajVar);
            }
        }
        this.s_renamed.o_renamed();
        if (!z2) {
            co_renamed.polarr.renderer.entities.Context context6 = this.t_renamed;
            if (context6.faceMasks != null) {
                java.util.List list2 = (java.util.List) context6.renderStates.get("faces");
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (this.t_renamed.faceMasks.length > i2) {
                        co_renamed.polarr.renderer.entities.FaceItem faceItem = (co_renamed.polarr.renderer.entities.FaceItem) list2.get(i2);
                        co_renamed.polarr.renderer.entities.Context context7 = this.t_renamed;
                        a_renamed.a_renamed.b_renamed.c_renamed.f_renamed fVar = context7.faceMasks[i2];
                        if (faceItem.adjustments != null) {
                            a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed bqVarA = a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed.a_renamed(this.y_renamed, context7);
                            bqVarA.r_renamed = fVar;
                            bqVarA.s_renamed = faceItem.adjustments;
                            this.s_renamed.b_renamed(bqVarA);
                        }
                    }
                }
            }
        }
        if (!z2) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.y_renamed, this.t_renamed, this.s_renamed, this.w_renamed);
        }
        if (z_renamed) {
            this.s_renamed.p_renamed();
            if (z2) {
                int iR = this.s_renamed.r_renamed();
                context2 = this.t_renamed;
                if (iR != context2.writableTexture.f34a) {
                    return;
                } else {
                    resources = this.y_renamed;
                }
            } else {
                resources = this.y_renamed;
                context2 = this.t_renamed;
            }
            a_renamed(co_renamed.polarr.renderer.filters.Basic.a_renamed(resources, context2), this.s_renamed.r_renamed(), this.t_renamed.readableTexture);
            return;
        }
        java.lang.Object obj = this.t_renamed.renderStates.get("blur_opacity");
        if (((obj instanceof java.lang.Integer) && ((java.lang.Integer) obj).intValue() != 0) || ((obj instanceof java.lang.Float) && ((java.lang.Float) obj).floatValue() != 0.0f)) {
            z3 = true;
        }
        if (z3) {
            co_renamed.polarr.renderer.entities.Context context8 = this.t_renamed;
            if (context8.lensBlurTexture.f35b != 1) {
                this.s_renamed.b_renamed(a_renamed.a_renamed.b_renamed.b_renamed.y_renamed.a_renamed(this.y_renamed, context8));
            }
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) this.t_renamed.renderStates.get(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT);
        this.t_renamed.renderStates.remove("zPrevText");
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(context, this.y_renamed, this.t_renamed, (java.util.ArrayList<co_renamed.polarr.renderer.entities.TextItem>) arrayList);
        this.s_renamed.p_renamed();
        a_renamed(co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed), this.s_renamed.r_renamed(), this.t_renamed.readableTexture);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.y_renamed, this.t_renamed);
        co_renamed.polarr.renderer.entities.Context context9 = this.t_renamed;
        if (context9.watermarkTexture == null || (watermarkOptions = context9.watermarkOptions) == null) {
            return;
        }
        if (watermarkOptions.enabled || watermarkOptions.preview) {
            a_renamed.a_renamed.b_renamed.b_renamed.au_renamed auVarA = a_renamed.a_renamed.b_renamed.b_renamed.au_renamed.a_renamed(this.y_renamed, this.t_renamed);
            auVarA.a_renamed(this.t_renamed.matrix);
            this.z_renamed.a_renamed(auVarA);
            this.z_renamed.b_renamed(this.t_renamed.writableTexture.f34a);
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed cVar2 = this.z_renamed;
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.t_renamed.readableTexture;
            cVar2.c_renamed(dVar3.f35b, dVar3.f36c);
            this.z_renamed.a_renamed(this.t_renamed.readableTexture.f34a);
            this.z_renamed.draw();
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed(this.t_renamed);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.f_renamed(this.y_renamed, this.t_renamed);
        }
    }

    public final void a_renamed(android.content.res.Resources resources) {
        boolean z_renamed;
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        java.util.List<co_renamed.polarr.renderer.entities.Adjustment> list = (java.util.List) context.renderStates.get("local_adjustments");
        boolean z2 = false;
        if (list != null && !list.isEmpty()) {
            loop0: while (true) {
                for (co_renamed.polarr.renderer.entities.Adjustment adjustment : list) {
                    z_renamed = z_renamed || adjustment.adjustments.blur != 0.0f;
                }
            }
            if (z_renamed) {
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.readableTexture;
                int i_renamed = dVar.f35b;
                int i2 = dVar.f36c;
                int i3 = i_renamed >> 1;
                int i4 = i2 >> 1;
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, i3, i4);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i3, i4);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.lensBlurTexture, i3, i4);
                float[] fArr = context.matrix;
                context.matrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
                a_renamed((android.content.Context) null, true, false);
                a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(resources, context);
                a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(resources, context, context.lensBlurTexture);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i_renamed, i2);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i_renamed, i2);
                context.matrix = fArr;
            }
            z2 = z_renamed;
        }
        if (z2) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.lensBlurTexture, 1, 1);
    }

    public void a_renamed(android.content.res.Resources resources, int i_renamed, int i2, java.util.Map<java.lang.String, java.lang.Object> map) throws org.json.JSONException, java.io.IOException {
        this.u_renamed = i_renamed;
        this.v_renamed = i2;
        this.y_renamed = resources;
        android.util.TimingLogger timingLogger = new android.util.TimingLogger("Polarr", "nativeInit_width/height=" + i_renamed + "/" + i2);
        this.t_renamed = new co_renamed.polarr.renderer.entities.Context(this.N_renamed);
        this.t_renamed.shaderUtil = new a_renamed.a_renamed.b_renamed.f_renamed.m_renamed();
        this.t_renamed.shaderUtil.b_renamed(resources);
        timingLogger.addSplit("shaderUtil.init");
        if (this.M_renamed == 1) {
            this.t_renamed.isOES = true;
        }
        this.t_renamed.resources = resources;
        if (!this.N_renamed) {
            a_renamed(map, false, false);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(resources, this.t_renamed, new android.graphics.Point(i_renamed, i2));
            this.s_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed(this.t_renamed, resources);
            for (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar : a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(resources, this.t_renamed)) {
                this.s_renamed.a_renamed(aVar);
                if (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed) {
                    this.f49a = (a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed) aVar;
                }
            }
            this.s_renamed.a_renamed();
            this.s_renamed.c_renamed(this.u_renamed, this.v_renamed);
        }
        if (this.N_renamed) {
            int[] iArr = new int[7];
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i_renamed, i2);
            this.t_renamed.imageTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i_renamed, i2);
            this.t_renamed.readableTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, i_renamed, i2);
            this.t_renamed.writableTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, i_renamed, i2);
            this.t_renamed.dehazeTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[2], 6408, i_renamed, i2);
            this.t_renamed.denoiseTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[3], 6408, i_renamed, i2);
            this.t_renamed.grainTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[4], 6408, 1024, 1024);
            this.t_renamed.overlayTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[5], 6408, 1000, 1000);
            timingLogger.addSplit("outScreenContext.denoiseTexture");
            this.f50b = new a_renamed.a_renamed.b_renamed.b_renamed.an_renamed(resources, this.t_renamed);
            this.f50b.a_renamed();
            timingLogger.addSplit("BasicOes.create");
            this.f49a = new a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed(resources, this.t_renamed);
            this.f49a.a_renamed(this);
            timingLogger.addSplit("lookup2DFilter.create");
            this.f49a.a_renamed();
            timingLogger.addSplit("lookup2DFilter.create()");
        } else {
            this.w_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.b_renamed(resources, this.t_renamed);
            for (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed bVar : this.w_renamed) {
                bVar.a_renamed();
                bVar.c_renamed(this.u_renamed, this.v_renamed);
            }
            this.x_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.w_renamed(this.t_renamed, resources);
            this.x_renamed.b_renamed(this.t_renamed.denoiseTexture);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.d_renamed(this.t_renamed);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.t_renamed);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.t_renamed, this.u_renamed, this.v_renamed, this.H_renamed, true, (float[]) null);
        }
        this.z_renamed = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(this.t_renamed);
        timingLogger.addSplit("RenderTextureFilter.getInstance");
        if (!this.N_renamed) {
            float fMin = java.lang.Math.min(1.0f, 512.0f / java.lang.Math.max(i_renamed, i2));
            int i3 = (int) (i_renamed * fMin);
            int i4 = (int) (i2 * fMin);
            int[] iArr2 = new int[3];
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr2.length, iArr2, 0, 6408, i3, i4);
            this.I_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr2[0], 6408, i3, i4);
            this.J_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr2[1], 6408, i3, i4);
            this.K_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr2[2], 6408, i3, i4);
        }
        timingLogger.dumpToLog();
    }

    public void a_renamed(android.content.res.Resources resources, int i_renamed, int i2, boolean z_renamed) {
        a_renamed(resources, i_renamed, i2, z_renamed, z_renamed ? 1 : 0);
    }

    public void a_renamed(android.content.res.Resources resources, int i_renamed, int i2, boolean z_renamed, int i3) {
        this.r_renamed = 1.0f;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("initRender::width=%d_renamed::height=%d_renamed::fastMode=%b_renamed::textureType=%d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z_renamed), java.lang.Integer.valueOf(i3));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start init");
        if (resources == null || i_renamed <= 0 || i2 <= 0) {
            return;
        }
        this.N_renamed = z_renamed;
        this.E_renamed = !z_renamed;
        this.M_renamed = i3;
        if (z_renamed) {
            a_renamed(resources, 1, 1, (java.util.Map<java.lang.String, java.lang.Object>) null);
        } else {
            a_renamed(resources, 800, 800, (java.util.Map<java.lang.String, java.lang.Object>) null);
        }
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        context.isSDK = true;
        this.H_renamed = false;
        if (!z_renamed) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.lensBlurTexture, 1, 1);
        }
        c_renamed(i_renamed, i2);
        if (z_renamed) {
            s_renamed();
        }
        co_renamed.polarr.renderer.entities.Context.backgroundColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end init");
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("End of_renamed initRender, time = %d_renamed ms", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final void a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, int i_renamed, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.imageTexture;
        int i2 = dVar2.f35b;
        int i3 = dVar2.f36c;
        int iMax = java.lang.Math.max(0, (int) (java.lang.Math.log(i_renamed) / java.lang.Math.log(2.0d)));
        int iMax2 = java.lang.Math.max(i2 >> iMax, 1);
        int iMax3 = java.lang.Math.max(i3 >> iMax, 1);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, iMax2, iMax3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, iMax2, iMax3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.dehazeTexture, iMax2, iMax3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.denoiseTexture, iMax2, iMax3);
        if (!z_renamed) {
            float fMax = 1024.0f / java.lang.Math.max(i2, i3);
            int iFloor = (int) java.lang.Math.floor(i2 * fMax);
            int iFloor2 = (int) java.lang.Math.floor(i3 * fMax);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.paintTexture, iFloor, iFloor2);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.intermediateTexture, iFloor, iFloor2);
        }
        android.opengl.GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            dVar = context.imageTexture;
        } else {
            a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.i_renamed.a_renamed(resources, context), 0, context.readableTexture);
            dVar = context.readableTexture;
        }
        float[] fArr = new float[15];
        float f_renamed = 1.0f / 15;
        float f2 = 1.0f / i2;
        float f3 = 1.0f / i3;
        for (int i4 = 0; i4 <= 7; i4++) {
            float fExp = (float) java.lang.Math.exp((-(i4 * i4)) * f_renamed);
            fArr[7 - i4] = fExp;
            fArr[i4 + 7] = fExp;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.e_renamed eVarA = a_renamed.a_renamed.b_renamed.b_renamed.e_renamed.a_renamed(resources, context);
        eVarA.a_renamed("delta", java.lang.Float.valueOf(f2));
        eVarA.r_renamed = fArr;
        a_renamed.a_renamed.b_renamed.b_renamed.z_renamed zVarA = a_renamed.a_renamed.b_renamed.b_renamed.z_renamed.a_renamed(resources, context);
        zVarA.a_renamed("delta", java.lang.Float.valueOf(f3));
        zVarA.r_renamed = fArr;
        a_renamed(eVarA, dVar.f34a, context.writableTexture);
        a_renamed(zVarA, context.writableTexture.f34a, context.denoiseTexture);
        a_renamed(context, resources, z_renamed ? 4 : 1);
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.BrushItem brushItem) {
        if (this.r_renamed != 1.0f) {
            brushItem = brushItem.copy();
            brushItem.size /= this.r_renamed;
            brushItem.mosaicSize = java.lang.Math.min(brushItem.mosaicSize, 3.0f);
        }
        a_renamed.a_renamed.b_renamed.f_renamed.w_renamed wVar = this.x_renamed;
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        wVar.a_renamed(context, brushItem, context.writableTexture);
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.BrushItem brushItem, android.graphics.PointF pointF) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("addBrushPathPoint::brushItem=%s_renamed::point", brushItem, pointF);
        if (brushItem == null) {
            return;
        }
        if (brushItem.points == null) {
            brushItem.points = new java.util.ArrayList();
        }
        synchronized (brushItem.points) {
            a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed(brushItem, pointF, this.t_renamed.paintTexture.f35b, this.t_renamed.paintTexture.f36c);
        }
    }

    public final void a_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources, int i_renamed) {
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
        float fMin = java.lang.Math.min(1.0f, (512.0f / i_renamed) / java.lang.Math.max(f_renamed, f2));
        int i2 = (int) (f_renamed * fMin);
        int i3 = (int) (f2 * fMin);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.writableTexture, i2, i3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(context.readableTexture, i2, i3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.I_renamed, i2, i3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.J_renamed, i2, i3);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.K_renamed, i2, i3);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.denoiseTexture;
        a_renamed(context, atVarA, bwVarA, dVar2, this.K_renamed);
        qVarA.r_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(qVarA, dVar2.f34a, this.J_renamed);
        this.I_renamed = a_renamed(context, aoVarA, dVar2, this.I_renamed, 8.0f, (java.lang.Float) null);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.J_renamed;
        this.J_renamed = a_renamed(context, aoVarA, dVar3, dVar3, 8.0f, (java.lang.Float) null);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = this.K_renamed;
        this.K_renamed = a_renamed(context, aoVarA, dVar4, dVar4, 48.0f, (java.lang.Float) null);
        abVarA.r_renamed = this.I_renamed.f34a;
        abVarA.s_renamed = this.J_renamed.f34a;
        abVarA.t_renamed = this.K_renamed.f34a;
        abVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(abVarA, 0, context.writableTexture);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = context.writableTexture;
        dVarA.r_renamed = this.I_renamed.f34a;
        dVarA.s_renamed = this.K_renamed.f34a;
        dVarA.t_renamed = dVar5.f34a;
        dVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(dVarA, 0, this.J_renamed);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar6 = this.J_renamed;
        java.lang.Float fValueOf = java.lang.Float.valueOf(48.0f);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA2 = a_renamed(context, aoVarA, dVar5, dVar5, 8.0f, fValueOf);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarA3 = a_renamed(context, aoVarA, dVar6, dVar6, 8.0f, fValueOf);
        azVarA.r_renamed = dVarA2.f34a;
        azVarA.s_renamed = dVarA3.f34a;
        azVarA.t_renamed = dVar2.f34a;
        azVarA.u_renamed = co_renamed.polarr.renderer.entities.Context.overlayMesh;
        a_renamed(azVarA, 0, context.dehazeTexture);
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, int i_renamed, int i2, int i3) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("magicEraserPathOverLay::path=%s_renamed::outputTexture=%d_renamed::width=%d_renamed::height=%d_renamed", magicEraserPath, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
        if (this.L_renamed == null) {
            co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
            this.L_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.z_renamed(context.resources, context.shaderUtil);
            this.L_renamed.b_renamed(this.t_renamed.imageTexture.f34a, i2, i3, 0);
        }
        this.L_renamed.a_renamed(this.t_renamed.intermediateTexture, i_renamed, magicEraserPath, i2, i3, 0.0f, 0.0f, 1.0f);
    }

    public void a_renamed(java.lang.String str) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("fastUpdateFilter::filterID=%s_renamed", str);
        b_renamed(str, 1.0f);
    }

    public final void a_renamed(java.lang.String str, float f_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            if (!boVar.c_renamed(str)) {
                this.f49a.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(this.y_renamed.getAssets(), str));
            }
            this.f49a.a_renamed(f_renamed);
            this.f49a.p_renamed();
        }
    }

    public void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.FaceItem> list, float f_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateFaces::faceItems=%s_renamed::faceAdjustIntensity=%f_renamed", list, java.lang.Float.valueOf(f_renamed));
        if (!list.isEmpty()) {
            a_renamed.a_renamed.b_renamed.f_renamed.y_renamed.a_renamed(this.u_renamed, this.v_renamed, list, this.y_renamed, this.t_renamed);
        }
        this.t_renamed.renderStates.put("faces", list);
        if (this.O_renamed == null) {
            this.O_renamed = a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.a_renamed(this.y_renamed, this.t_renamed.imageTexture, 300, 300);
        }
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(300, 300, this.O_renamed, list.get(i_renamed), null, f_renamed, false);
        }
    }

    public void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed) {
        a_renamed(list, i_renamed, false, 0.0f, 0.0f, 0.0f);
    }

    public void a_renamed(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed, boolean z_renamed, float f_renamed, float f2, float f3) {
        boolean z2;
        int i2;
        if (list == null || list.isEmpty() || i_renamed <= 0) {
            return;
        }
        int[] iArr = new int[2];
        android.opengl.GLES31.glGetTexLevelParameteriv(3553, 0, 4096, iArr, 0);
        android.opengl.GLES31.glGetTexLevelParameteriv(3553, 0, 4097, iArr, 1);
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("drawFiltersFrame::drawingItems=%s_renamed::outputTexture=%d_renamed::width=%d_renamed::height=%d_renamed", list.toString(), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(iArr[0]), java.lang.Integer.valueOf(iArr[1]));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start draw filter frame");
        boolean zGlIsEnabled = android.opengl.GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glDisable(3089);
        }
        android.graphics.Rect rect = list.get(0).rect;
        int i3 = this.D_renamed;
        this.D_renamed = 0;
        java.util.Iterator<co_renamed.polarr.renderer.entities.DrawingItem> it = list.iterator();
        while (it.hasNext()) {
            android.graphics.Bitmap bitmap = it.next().thumbBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        int i4 = this.u_renamed;
        int i5 = this.v_renamed;
        if (this.d_renamed) {
            if (this.e_renamed == null) {
                this.e_renamed = new a_renamed.a_renamed.b_renamed.c_renamed(this.y_renamed, this.t_renamed);
            }
            if (z2 && this.t_renamed.isOES) {
                android.opengl.Matrix.setIdentityM(this.f50b.getMatrix(), 0);
                a_renamed(this.f50b, this.C_renamed, this.t_renamed.writableTexture);
            } else {
                int i6 = this.C_renamed;
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed.writableTexture;
                a_renamed(i6, dVar.f34a, dVar.f35b, dVar.f36c);
            }
            i2 = this.e_renamed.a_renamed(this.t_renamed.writableTexture, rect.width(), rect.height()).f34a;
            c_renamed(rect.width(), rect.height());
        } else {
            a_renamed.a_renamed.b_renamed.c_renamed cVar = this.e_renamed;
            if (cVar != null) {
                cVar.close();
                this.e_renamed = null;
            }
            c_renamed(rect.width(), rect.height());
            if (z2 && this.t_renamed.isOES) {
                android.opengl.Matrix.setIdentityM(this.f50b.getMatrix(), 0);
                a_renamed(this.f50b, this.C_renamed, this.t_renamed.writableTexture);
                i2 = this.t_renamed.writableTexture.f34a;
            } else {
                i2 = this.C_renamed;
            }
        }
        android.opengl.Matrix.setIdentityM(this.f49a.getMatrix(), 0);
        android.opengl.Matrix.scaleM(this.f49a.getMatrix(), 0, -1.0f, -1.0f, 1.0f);
        this.z_renamed.b_renamed(i_renamed);
        this.z_renamed.c_renamed(rect.width(), rect.height());
        this.z_renamed.s_renamed();
        this.f49a.ac_renamed = false;
        for (co_renamed.polarr.renderer.entities.DrawingItem drawingItem : list) {
            android.graphics.Bitmap bitmap2 = drawingItem.thumbBitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.f49a.a_renamed(i2);
            } else {
                this.f49a.a_renamed(this.n_renamed.a_renamed(drawingItem.thumbBitmap));
            }
            b_renamed(drawingItem.filterId, drawingItem.intensity);
            android.graphics.Rect rect2 = drawingItem.rect;
            android.opengl.GLES20.glViewport(rect2.left, rect2.top, rect2.width(), drawingItem.rect.height());
            this.f49a.a_renamed(z_renamed, (drawingItem.rect.width() <= drawingItem.rect.height() ? drawingItem.rect.width() : drawingItem.rect.height()) * f_renamed, f2 * drawingItem.rect.width(), f3 * drawingItem.rect.height(), drawingItem.rect.width(), drawingItem.rect.height());
            android.graphics.Bitmap bitmap3 = drawingItem.overlayBitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                int width = drawingItem.overlayBitmap.getWidth();
                int height = drawingItem.overlayBitmap.getHeight();
                if (this.f51c == null) {
                    this.f51c = new co_renamed.polarr.renderer.filters.Basic(this.y_renamed, this.t_renamed);
                    this.f51c.a_renamed();
                }
                this.f51c.setNeedClear(false);
                this.f51c.a_renamed(this.o_renamed.a_renamed(drawingItem.overlayBitmap));
                android.graphics.Rect rect3 = drawingItem.rect;
                android.opengl.GLES20.glViewport(rect3.left + drawingItem.overlayLeft, rect3.top + drawingItem.overlayTop, width, height);
                android.opengl.GLES20.glEnable(3042);
                android.opengl.GLES20.glBlendFunc(1, 771);
                this.f51c.draw();
                android.opengl.GLES20.glDisable(3042);
            }
        }
        this.z_renamed.n_renamed();
        this.D_renamed = i3;
        c_renamed(i4, i5);
        android.opengl.GLES20.glGetError();
        if (zGlIsEnabled) {
            android.opengl.GLES20.glEnable(3089);
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end draw filter frame");
    }

    public void a_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        a_renamed(map, true, true);
    }

    public void a_renamed(java.util.Map<java.lang.String, java.lang.Object> map, int i_renamed, float f_renamed, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start auto enhance face");
        if (map == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("autoEnhanceFace::faceStates=%s_renamed::faceIndex=%d_renamed::percent=%f_renamed::needReduceGlobal=%b_renamed", map, java.lang.Integer.valueOf(i_renamed), java.lang.Float.valueOf(f_renamed), java.lang.Boolean.valueOf(z_renamed));
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        java.util.List list = (java.util.List) map.get("faces");
        java.util.List list2 = (java.util.List) map.get("face_features");
        if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty()) {
            if (this.O_renamed == null) {
                this.O_renamed = a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.a_renamed(this.y_renamed, this.t_renamed.imageTexture, 300, 300);
            }
            if (i_renamed == -1) {
                int iMin = java.lang.Math.min(list.size(), list2.size());
                for (int i2 = 0; i2 < iMin; i2++) {
                    a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(300, 300, this.O_renamed, (co_renamed.polarr.renderer.entities.FaceItem) list.get(i2), (co_renamed.polarr.renderer.entities.Context.FaceFeaturesState) list2.get(i2), f_renamed, z_renamed);
                }
            } else if (list.size() > i_renamed && list2.size() > i_renamed) {
                a_renamed.a_renamed.b_renamed.f_renamed.n_renamed.a_renamed(300, 300, this.O_renamed, (co_renamed.polarr.renderer.entities.FaceItem) list.get(i_renamed), (co_renamed.polarr.renderer.entities.Context.FaceFeaturesState) list2.get(i_renamed), f_renamed, z_renamed);
            }
        }
        android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end auto enhance face");
    }

    public final void a_renamed(java.util.Map<java.lang.String, java.lang.Object> map, boolean z_renamed, boolean z2) {
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar;
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateStates::renderStates=%s_renamed::needUpdateFilter=%b_renamed::fastUpdate=%b_renamed", map == null ? "null" : map.toString(), java.lang.Boolean.valueOf(z_renamed), java.lang.Boolean.valueOf(z2));
        if (z2) {
            this.t_renamed.renderStates.putAll(map);
            if (z_renamed && (dVar = this.s_renamed) != null) {
                a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed baVar = (a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(dVar.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed.class);
                a_renamed.a_renamed.b_renamed.b_renamed.v_renamed vVar = (a_renamed.a_renamed.b_renamed.b_renamed.v_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.s_renamed.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.v_renamed.class);
                if (baVar != null && vVar != null && (!baVar.a_renamed(map) || !vVar.a_renamed(map))) {
                    for (java.lang.String str : map.keySet()) {
                        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.s_renamed.q_renamed(), str, this.t_renamed.renderStates.get(str));
                    }
                    baVar.b_renamed(map);
                    vVar.b_renamed(map);
                }
            }
        } else {
            java.lang.Object obj = this.t_renamed.renderStates.get("prevFaces");
            java.lang.Object obj2 = this.t_renamed.renderStates.get("prevFaceFeatures");
            a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.t_renamed.renderStates);
            a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
            if (boVar != null) {
                boVar.o_renamed();
            }
            if (map != null) {
                for (java.lang.String str2 : map.keySet()) {
                    java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(str2, map.get(str2));
                    if (str2.equals("lut_id")) {
                        b_renamed((java.lang.String) map.get(str2), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("lookup_intensity", map.get("lookup_intensity"))).floatValue());
                    } else {
                        this.t_renamed.renderStates.put(str2, objA);
                    }
                }
            }
            this.t_renamed.renderStates.remove("prevFaceFeatures");
            this.t_renamed.renderStates.remove("prevFaces");
            this.t_renamed.renderStates.remove("prevBrushes");
            this.t_renamed.renderStates.remove("zPrevSpots");
            this.t_renamed.renderStates.put("prevFaces", obj);
            this.t_renamed.renderStates.put("prevFaceFeatures", obj2);
            if (map != null) {
                if (!this.t_renamed.isSDK && map.containsKey("distortion_mesh")) {
                    a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.a_renamed(this.t_renamed, (float[]) this.t_renamed.renderStates.get("distortion_mesh"));
                }
                if (z_renamed) {
                    for (java.lang.String str3 : this.t_renamed.renderStates.keySet()) {
                        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.s_renamed.q_renamed(), str3, this.t_renamed.renderStates.get(str3));
                    }
                }
            }
            c_renamed();
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("do update states");
    }

    public final void a_renamed(boolean z_renamed) {
        a_renamed((android.content.Context) null, z_renamed);
        if (this.G_renamed) {
            co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
            basicA.a_renamed(this.t_renamed.readableTexture.f34a);
            android.opengl.Matrix.setIdentityM(basicA.getMatrix(), 0);
            a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed(basicA.getMatrix(), false, true);
            basicA.draw();
        }
    }

    public boolean a_renamed(int[] iArr) {
        boolean z_renamed;
        int[] iArr2 = this.t_renamed.textures;
        if (iArr2 == null || iArr2.length != 4) {
            z_renamed = false;
        } else {
            int length = iArr2.length;
            z_renamed = true;
            int i_renamed = 0;
            int i2 = 0;
            while (i_renamed < length) {
                if (iArr2[i_renamed] != iArr[i2]) {
                    z_renamed = false;
                }
                i_renamed++;
                i2++;
            }
        }
        if (!z_renamed) {
            this.t_renamed.textures = iArr;
        }
        this.C_renamed = 0;
        return z_renamed;
    }

    public void b_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateInputTexture", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start update input");
        boolean zGlIsEnabled = android.opengl.GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glDisable(3089);
        }
        this.O_renamed = null;
        this.P_renamed = null;
        this.Q_renamed = null;
        if (this.N_renamed || this.F_renamed) {
            k_renamed();
            return;
        }
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        g_renamed();
        android.opengl.GLES20.glGetError();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("updated input texture");
        this.t_renamed.renderStates.remove("prevFaces");
        this.t_renamed.renderStates.remove("prevFaceFeatures");
        if (this.E_renamed) {
            a_renamed(this.y_renamed, this.t_renamed, 2, false);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.t_renamed, this.u_renamed, this.v_renamed, this.H_renamed, true, (float[]) null);
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("input render maps");
            c_renamed();
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("input update others");
        }
        android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glEnable(3089);
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end update input");
    }

    public void b_renamed(float f_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("setFilterIntensity::intensity=%f_renamed", java.lang.Float.valueOf(f_renamed));
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar == null || boVar.A_renamed()) {
            return;
        }
        this.f49a.a_renamed(f_renamed);
    }

    public void b_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.b_renamed(i_renamed);
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        int i3 = i_renamed * i_renamed;
        co_renamed.polarr.renderer.entities.Context context = co_renamed.polarr.renderer.entities.Context.LutContext;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
        dVar.f35b = i3;
        dVar.f36c = i_renamed;
        context.renderStates = this.t_renamed.renderStates;
        this.s_renamed.a_renamed(context);
        this.s_renamed.c_renamed(i3, i_renamed);
        this.s_renamed.a_renamed(i2);
        this.s_renamed.w_renamed();
        this.s_renamed.o_renamed();
        this.s_renamed.p_renamed();
        a_renamed(co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed), this.s_renamed.r_renamed(), i2, i3, i_renamed);
        this.s_renamed.a_renamed(this.t_renamed);
        this.s_renamed.c_renamed(this.u_renamed, this.v_renamed);
    }

    public void b_renamed(co_renamed.polarr.renderer.entities.BrushItem brushItem) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateBrushPoints::brushItem=%s_renamed", brushItem);
        if (brushItem == null) {
            return;
        }
        if (brushItem.points == null) {
            brushItem.points = new java.util.ArrayList();
        }
        synchronized (brushItem.points) {
            a_renamed.a_renamed.b_renamed.f_renamed.w_renamed.a_renamed(brushItem.touchPoints, brushItem, this.t_renamed.paintTexture.f35b, this.t_renamed.paintTexture.f36c);
        }
    }

    public void b_renamed(java.lang.String str) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateStates::stateString=%s_renamed", str);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start update states json");
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.j_renamed.a_renamed(str));
        android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end update states json");
    }

    public void b_renamed(java.lang.String str, float f_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("fastUpdateFilter::filterID=%s_renamed::filterIntensity=%f_renamed", str, java.lang.Float.valueOf(f_renamed));
        java.lang.String[] strArrA = co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(this.y_renamed.getAssets(), str);
        if (strArrA == null) {
            a_renamed(str, f_renamed);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : strArrA) {
            co_renamed.polarr.renderer.entities.LutItem lutItem = new co_renamed.polarr.renderer.entities.LutItem();
            lutItem.filterId = str2;
            lutItem.intensity = 1.0f;
            arrayList.add(lutItem);
        }
        if (f_renamed >= 0.3f) {
            arrayList.get(0).intensity = (f_renamed - 0.3f) / 0.7f;
            arrayList.get(1).intensity = 1.0f;
        } else {
            arrayList.get(0).intensity = 0.0f;
            arrayList.get(1).intensity = f_renamed / 0.3f;
        }
        b_renamed(arrayList);
    }

    public void b_renamed(java.util.List<co_renamed.polarr.renderer.entities.LutItem> list) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarV = this.f49a.v_renamed();
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarW = this.f49a.w_renamed();
        this.f49a.r_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        float f_renamed = boVar.ae_renamed;
        boVar.ae_renamed = 0.0f;
        for (co_renamed.polarr.renderer.entities.LutItem lutItem : list) {
            if (lutItem != null && !android.text.TextUtils.isEmpty(lutItem.filterId)) {
                a_renamed(lutItem.filterId, lutItem.intensity);
                this.z_renamed.a_renamed(this.f49a);
                this.z_renamed.b_renamed(dVarW.f34a);
                this.z_renamed.c_renamed(dVarV.f35b, dVarV.f36c);
                this.z_renamed.a_renamed(dVarV.f34a);
                this.z_renamed.draw();
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVarV, dVarW);
            }
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar2 = this.f49a;
        boVar2.ae_renamed = f_renamed;
        boVar2.c_renamed("COMBAIN_FILTER");
        this.f49a.a_renamed(1.0f);
    }

    public void b_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String str;
        if (map == null) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateStates::renderStates=%s_renamed", map.toString());
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start update states");
        int[] iArr = new int[4];
        android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
        if (this.N_renamed) {
            a_renamed(map);
            str = "end fast update states";
        } else {
            a_renamed(map, true, false);
            android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            str = "end update states";
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(str);
    }

    public void b_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.c_renamed(z_renamed);
        }
    }

    public final void c_renamed() {
        if (this.t_renamed.renderStates.containsKey("faces")) {
            a_renamed.a_renamed.b_renamed.f_renamed.y_renamed.a_renamed((java.util.List<co_renamed.polarr.renderer.entities.FaceItem>) this.t_renamed.renderStates.get("faces"), this.y_renamed, this.t_renamed);
            if (this.t_renamed.renderStates.containsKey("face_features")) {
                co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
                a_renamed.a_renamed.b_renamed.f_renamed.t_renamed.a_renamed(context, (java.util.List<co_renamed.polarr.renderer.entities.Context.FaceFeaturesState>) context.renderStates.get("face_features"));
            }
        }
    }

    public void c_renamed(float f_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.B_renamed = f_renamed != 0.0f;
            this.f49a.ae_renamed = f_renamed;
        }
    }

    public void c_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("setInputTexture::inputTexture=%d_renamed", java.lang.Integer.valueOf(i_renamed));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start set input");
        this.C_renamed = i_renamed;
        this.t_renamed.textures = null;
        this.R_renamed = false;
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end set input");
    }

    public void c_renamed(int i_renamed, int i2) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("updateSize::width=%d_renamed::height=%d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start update size");
        this.u_renamed = i_renamed;
        this.v_renamed = i2;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.t_renamed.imageTexture, this.u_renamed, this.v_renamed);
        if (!this.N_renamed) {
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar = this.s_renamed;
            if (dVar != null) {
                dVar.c_renamed(this.u_renamed, this.v_renamed);
            }
            for (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed bVar : this.w_renamed) {
                bVar.a_renamed();
                bVar.c_renamed(this.u_renamed, this.v_renamed);
            }
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.c_renamed(this.u_renamed, this.v_renamed);
        }
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.d_renamed(this.t_renamed);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.t_renamed);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.t_renamed, this.u_renamed, this.v_renamed, this.H_renamed, true, (float[]) null);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end update size");
    }

    public void c_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.d_renamed(z_renamed);
        }
    }

    public void d_renamed() {
        this.x_renamed.d_renamed();
    }

    public void d_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start set output");
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("setOutputTexture::outTexture=%d_renamed", java.lang.Integer.valueOf(i_renamed));
        this.D_renamed = i_renamed;
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end set output");
    }

    public void d_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public void e_renamed() {
        this.n_renamed.a_renamed();
        this.o_renamed.a_renamed();
    }

    public void e_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.e_renamed(z_renamed);
        }
    }

    public void f_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("createInputTexture", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start create input");
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        this.C_renamed = iArr[0];
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(this.C_renamed);
        android.opengl.GLES20.glBindTexture(3553, this.C_renamed);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        this.R_renamed = true;
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end create input");
    }

    public void f_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.f_renamed(z_renamed);
        }
    }

    public final void g_renamed() {
        if (!this.N_renamed && this.M_renamed == 1) {
            if (this.f_renamed == null) {
                this.f_renamed = new a_renamed.a_renamed.b_renamed.b_renamed();
                this.f_renamed.a_renamed();
            }
            int i_renamed = this.C_renamed;
            if (i_renamed != 0) {
                this.f_renamed.a_renamed(i_renamed);
                this.z_renamed.b_renamed(this.t_renamed.imageTexture.f34a);
                this.z_renamed.c_renamed(this.u_renamed, this.v_renamed);
                this.z_renamed.s_renamed();
                this.f_renamed.a_renamed((android.graphics.SurfaceTexture) null, (float[]) null);
                this.z_renamed.n_renamed();
                return;
            }
            return;
        }
        if (this.N_renamed || this.C_renamed == 0) {
            if (this.M_renamed == 1) {
                android.opengl.Matrix.setIdentityM(this.f50b.getMatrix(), 0);
                a_renamed(this.f50b, this.C_renamed, this.t_renamed.imageTexture);
                return;
            } else {
                int i2 = this.C_renamed;
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.t_renamed.imageTexture;
                a_renamed(i2, dVar.f34a, dVar.f35b, dVar.f36c);
                return;
            }
        }
        this.z_renamed.b_renamed(this.t_renamed.imageTexture.f34a);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.t_renamed.imageTexture;
        int i3 = this.u_renamed;
        dVar2.f35b = i3;
        int i4 = this.v_renamed;
        dVar2.f36c = i4;
        this.z_renamed.c_renamed(i3, i4);
        this.z_renamed.s_renamed();
        co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
        basicA.a_renamed(this.C_renamed);
        basicA.draw();
        this.z_renamed.n_renamed();
        this.x_renamed.c_renamed(this.t_renamed.imageTexture);
    }

    public void g_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("enableRealTimeAutoEnhancement::isEnable=%b_renamed", java.lang.Boolean.valueOf(z_renamed));
        this.E_renamed = !z_renamed;
        this.F_renamed = z_renamed;
        if (this.F_renamed && !this.N_renamed) {
            if (this.f50b == null) {
                this.f50b = new a_renamed.a_renamed.b_renamed.b_renamed.an_renamed(this.y_renamed, this.t_renamed);
                this.f50b.a_renamed();
            }
            if (this.f49a == null) {
                this.f49a = new a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed(this.y_renamed, this.t_renamed);
                this.f49a.a_renamed(this);
                this.f49a.a_renamed();
            }
            s_renamed();
        }
        if (this.F_renamed && this.j_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("PO_AE_THEREAD");
            handlerThread.start();
            this.j_renamed = new android.os.Handler(handlerThread.getLooper());
        }
        if (this.E_renamed) {
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.t_renamed.dehazeTexture, 1, 1);
    }

    @Override // co_renamed.polarr.renderer.PacmanFilter
    public java.lang.String getSeed() {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            return boVar.y_renamed();
        }
        return null;
    }

    public void h_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("drawFrame", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start draw frame");
        boolean zGlIsEnabled = android.opengl.GLES20.glIsEnabled(3089);
        if (zGlIsEnabled) {
            android.opengl.GLES20.glDisable(3089);
        }
        if (!this.N_renamed && !this.F_renamed) {
            if (this.M_renamed == 1) {
                a_renamed(false);
                return;
            }
            android.opengl.GLES20.glGetError();
            int[] iArr = new int[4];
            android.opengl.GLES20.glGetIntegerv(2978, iArr, 0);
            a_renamed((android.content.Context) null, false);
            if (this.G_renamed) {
                co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
                basicA.a_renamed(this.t_renamed.readableTexture.f34a);
                android.opengl.Matrix.setIdentityM(basicA.getMatrix(), 0);
                basicA.draw();
            }
            android.opengl.GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            if (zGlIsEnabled) {
                android.opengl.GLES20.glEnable(3089);
            }
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end draw frame");
            return;
        }
        if (this.h_renamed) {
            if (this.g_renamed >= 1) {
                a_renamed.a_renamed.b_renamed.d_renamed.a_renamed aVar = new a_renamed.a_renamed.b_renamed.d_renamed.a_renamed(B_renamed());
                if (this.g_renamed > 1) {
                    aVar.run();
                } else if (!this.l_renamed) {
                    this.j_renamed.post(aVar);
                }
            }
            synchronized (this.i_renamed) {
                if (!this.i_renamed.isEmpty()) {
                    b_renamed(this.i_renamed);
                    i_renamed(true);
                    this.i_renamed.clear();
                }
            }
            this.g_renamed--;
            if (this.g_renamed <= 0) {
                this.g_renamed = 1;
            }
        }
        j_renamed();
    }

    public void h_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("autoEnhanceGlobal::isEnable=%b_renamed", java.lang.Boolean.valueOf(z_renamed));
        this.h_renamed = z_renamed;
        if (this.h_renamed) {
            this.g_renamed = 2;
        } else {
            i_renamed(false);
        }
    }

    public void i_renamed() {
        this.f49a.ad_renamed = true;
        h_renamed();
        this.f49a.ad_renamed = false;
    }

    public void i_renamed(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            if (!z_renamed) {
                boVar.c_renamed("default");
                return;
            }
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarU = boVar.u_renamed();
            b_renamed(dVarU.f36c, dVarU.f34a);
            this.f49a.c_renamed("AUTO_ENHANCE_FILTER");
        }
    }

    public final void j_renamed() {
        int i_renamed;
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar;
        int i2;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("fastDrawFrame", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.ac_renamed = true;
            android.opengl.Matrix.setIdentityM(boVar.getMatrix(), 0);
            co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
            if (context.isOES) {
                android.opengl.Matrix.scaleM(this.f49a.getMatrix(), 0, -1.0f, -1.0f, 1.0f);
                if (this.D_renamed != 0) {
                    a_renamed(this.f50b, this.C_renamed, this.t_renamed.readableTexture);
                    aVar = this.f49a;
                    dVar = this.t_renamed.readableTexture;
                    i2 = dVar.f34a;
                    i_renamed = this.D_renamed;
                    a_renamed(aVar, i2, i_renamed, dVar.f35b, dVar.f36c);
                } else {
                    co_renamed.polarr.renderer.entities.Context context2 = this.t_renamed;
                    a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context2.imageTexture;
                    a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = context2.writableTexture;
                    java.util.List list = (java.util.List) context2.renderStates.get("faces");
                    if (this.m_renamed != null && list != null && !list.isEmpty()) {
                        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar4 = dVar3;
                        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar5 = dVar2;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            co_renamed.polarr.renderer.entities.FaceItem faceItem = (co_renamed.polarr.renderer.entities.FaceItem) list.get(i3);
                            a_renamed.a_renamed.b_renamed.c_renamed.f_renamed fVar = this.t_renamed.faceMasks[i3];
                            co_renamed.polarr.renderer.entities.Context.FaceState faceState = faceItem.adjustments;
                            if (faceState != null) {
                                a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed bqVar = this.m_renamed;
                                bqVar.r_renamed = fVar;
                                bqVar.s_renamed = faceState;
                                a_renamed(bqVar, dVar5.f34a, dVar4);
                                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar6 = dVar4;
                                dVar4 = dVar5;
                                dVar5 = dVar6;
                            }
                        }
                        dVar2 = dVar5;
                    }
                    a_renamed(this.f49a, dVar2.f34a, this.t_renamed.readableTexture);
                }
            } else {
                i_renamed = this.D_renamed;
                if (i_renamed != 0) {
                    aVar = this.f49a;
                    i2 = this.C_renamed;
                    dVar = context.readableTexture;
                    a_renamed(aVar, i2, i_renamed, dVar.f35b, dVar.f36c);
                } else {
                    a_renamed(this.f49a, this.C_renamed, context.readableTexture);
                }
            }
        }
        if (this.G_renamed) {
            co_renamed.polarr.renderer.filters.Basic basicA = co_renamed.polarr.renderer.filters.Basic.a_renamed(this.y_renamed, this.t_renamed);
            basicA.a_renamed(this.t_renamed.readableTexture.f34a);
            android.opengl.Matrix.setIdentityM(basicA.getMatrix(), 0);
            basicA.draw();
        }
    }

    public void j_renamed(boolean z_renamed) {
        this.G_renamed = z_renamed;
    }

    public final void k_renamed() {
        g_renamed();
        android.opengl.GLES20.glGetError();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("fast update texture");
        if (this.E_renamed) {
            a_renamed(this.y_renamed, this.t_renamed, 2, false);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.t_renamed.readableTexture, this.u_renamed, this.v_renamed);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.t_renamed.writableTexture, this.u_renamed, this.v_renamed);
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("update texture for maps");
        }
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        co_renamed.polarr.renderer.filters.Basic.a_renamed(context.resources, context);
    }

    public void k_renamed(boolean z_renamed) {
        this.H_renamed = z_renamed;
    }

    public void l_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.c_renamed("COMBAIN_FILTER");
            this.f49a.a_renamed(1.0f);
        }
    }

    public int m_renamed() {
        return this.x_renamed.c_renamed().f34a;
    }

    public int n_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            return boVar.x_renamed();
        }
        return 0;
    }

    public a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed o_renamed() {
        return this.f49a;
    }

    public int p_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("getOutputId", new java.lang.Object[0]);
        int i_renamed = this.D_renamed;
        return i_renamed != 0 ? i_renamed : this.t_renamed.readableTexture.f34a;
    }

    public co_renamed.polarr.renderer.PacmanFilter q_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar == null || !boVar.B_renamed()) {
            return null;
        }
        return this;
    }

    public int r_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("getTextureId", new java.lang.Object[0]);
        return this.C_renamed;
    }

    @java.lang.Deprecated
    public void s_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("initAllFilters", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.q_renamed();
            this.f49a.r_renamed();
            if (this.f49a.c_renamed("default")) {
                return;
            }
            this.f49a.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(this.y_renamed.getAssets(), "default"));
        }
    }

    @Override // co_renamed.polarr.renderer.PacmanFilter
    public void setOrientation(co_renamed.polarr.renderer.Orientation orientation) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.a_renamed(orientation);
        }
    }

    @Override // co_renamed.polarr.renderer.PacmanFilter
    public void setSeed(java.lang.String str) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.d_renamed(str);
        }
    }

    public void t_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.C_renamed();
        }
    }

    public void u_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("release", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start release");
        x_renamed();
        z_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end release");
    }

    public final void v_renamed() {
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

    public final void w_renamed() {
        java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> map;
        co_renamed.polarr.renderer.entities.Context context = this.t_renamed;
        if (context != null && (map = context.brushes) != null) {
            java.util.Iterator<a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> it = map.values().iterator();
            while (it.hasNext()) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(it.next());
            }
        }
        co_renamed.polarr.renderer.entities.Context context2 = this.t_renamed;
        if (context2 != null) {
            context2.brushes = null;
        }
    }

    public void x_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("releaseGLRes", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start release gl_renamed");
        a_renamed.a_renamed.b_renamed.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.close();
            this.e_renamed = null;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this.f49a;
        if (boVar != null) {
            boVar.close();
            this.f49a = null;
        }
        this.n_renamed.a_renamed();
        this.o_renamed.a_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.d_renamed dVar = this.s_renamed;
        if (dVar != null) {
            a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed baVar = (a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(dVar.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed.class);
            a_renamed.a_renamed.b_renamed.b_renamed.v_renamed vVar = (a_renamed.a_renamed.b_renamed.b_renamed.v_renamed) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.s_renamed.q_renamed(), a_renamed.a_renamed.b_renamed.b_renamed.v_renamed.class);
            if (baVar != null) {
                baVar.n_renamed();
            }
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes filter1");
            if (vVar != null) {
                vVar.n_renamed();
            }
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes filter2");
            this.s_renamed.u_renamed();
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes filter3");
        }
        a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(this.t_renamed).t_renamed();
        a_renamed.a_renamed.b_renamed.c_renamed.f_renamed[] fVarArr = this.t_renamed.faceMasks;
        if (fVarArr != null) {
            for (a_renamed.a_renamed.b_renamed.c_renamed.f_renamed fVar : fVarArr) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(fVar);
            }
        }
        java.util.List<a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> list = this.t_renamed.textLayers;
        if (list != null) {
            java.util.Iterator<a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> it = list.iterator();
            while (it.hasNext()) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(it.next());
            }
        }
        int[] iArr = this.t_renamed.textures;
        if (iArr != null) {
            for (int i_renamed : iArr) {
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed);
            }
        }
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.t_renamed.brushTextures;
        if (dVarArr != null) {
            for (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 : dVarArr) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(dVar2);
            }
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.I_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.J_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.K_renamed);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.imageTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.dehazeTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.denoiseTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.cacheTexture);
        if (!this.N_renamed || this.D_renamed == 0) {
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.readableTexture);
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.writableTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.paintTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.retouchTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.lensBlurTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.intermediateTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.grainTexture);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(this.t_renamed.overlayTexture);
        A_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes pattern");
        w_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes brushes");
        y_renamed();
        a_renamed.a_renamed.b_renamed.f_renamed.z_renamed zVar = this.L_renamed;
        if (zVar != null) {
            zVar.a_renamed();
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes patch");
        a_renamed.a_renamed.b_renamed.f_renamed.w_renamed wVar = this.x_renamed;
        if (wVar != null) {
            wVar.e_renamed();
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes brush");
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("releaseGLRes render");
        android.opengl.GLES20.glFlush();
        this.t_renamed.shaderUtil.a_renamed();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end release gl_renamed");
    }

    public void y_renamed() {
        int i_renamed;
        if (this.R_renamed && (i_renamed = this.C_renamed) != 0) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.C_renamed);
        }
        this.C_renamed = 0;
    }

    public void z_renamed() {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("releaseNonGLRes", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("start release non-gl_renamed");
        this.O_renamed = null;
        this.P_renamed = null;
        this.Q_renamed = null;
        v_renamed();
        a_renamed.a_renamed.b_renamed.f_renamed.z_renamed zVar = this.L_renamed;
        if (zVar != null) {
            zVar.b_renamed();
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("end release non-gl_renamed");
    }
}
