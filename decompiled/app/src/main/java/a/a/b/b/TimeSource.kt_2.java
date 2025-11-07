package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bo_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed implements a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed, java.lang.AutoCloseable {
    public static java.lang.String q_renamed;
    public static float r_renamed;
    public static float s_renamed;
    public static float t_renamed;
    public static float u_renamed;
    public static float v_renamed;
    public static float w_renamed;
    public static byte[] x_renamed;
    public static byte[] y_renamed;
    public float A_renamed;
    public boolean B_renamed;
    public android.graphics.Bitmap C_renamed;
    public java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> D_renamed;
    public java.lang.String E_renamed;
    public java.util.Map<java.lang.String, java.lang.Float> F_renamed;
    public float G_renamed;
    public float[] H_renamed;
    public float[] I_renamed;
    public java.util.Random J_renamed;
    public int K_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.bm_renamed L_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.bz_renamed M_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed N_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.ag_renamed O_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed P_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.i_renamed Q_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.bc_renamed R_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.ax_renamed S_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.bu_renamed T_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.ai_renamed U_renamed;
    public a_renamed.a_renamed.b_renamed.b_renamed.r_renamed V_renamed;
    public co_renamed.polarr.renderer.Orientation W_renamed;
    public int X_renamed;
    public int Y_renamed;
    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] Z_renamed;
    public java.lang.ref.WeakReference<a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed> aa_renamed;
    public boolean ab_renamed;
    public boolean ac_renamed;
    public boolean ad_renamed;
    public float ae_renamed;
    public float af_renamed;
    public float ag_renamed;
    public float ah_renamed;
    public boolean ai_renamed;
    public float aj_renamed;
    public float ak_renamed;
    public float al_renamed;
    public float z_renamed;

    public class a_renamed implements a_renamed.a_renamed.b_renamed.f_renamed.a_renamed {
        public a_renamed() {
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:8:0x001c  */
        @Override // a_renamed.a_renamed.b_renamed.f_renamed.a_renamed
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.io.InputStream a_renamed(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.m_renamed()
                r1 = 0
                if (r0 == 0) goto L1c
                java.io.File r0 = new java.io.File
                java.lang.String r2 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.m_renamed()
                r0.<init>(r2, r4)
                boolean r2 = r0.exists()
                if (r2 == 0) goto L1c
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L1c
                r2.<init>(r0)     // Catch: java.lang.Exception -> L1c
                goto L1d
            L1c:
                r2 = r1
            L1d:
                if (r2 != 0) goto L2e
                a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed r3 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.this     // Catch: java.lang.Exception -> L2f
                android.content.res.Resources r3 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.a_renamed(r3)     // Catch: java.lang.Exception -> L2f
                android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Exception -> L2f
                java.io.InputStream r1 = r3.open(r4)     // Catch: java.lang.Exception -> L2f
                goto L2f
            L2e:
                r1 = r2
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.a_renamed.a_renamed(java.lang.String):java.io.InputStream");
        }
    }

    public static /* synthetic */ class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final /* synthetic */ int[] f22a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public static final /* synthetic */ int[] f23b = new int[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.values().length];

        static {
            try {
                f23b[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.MULTIPLY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f23b[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.SCREEN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f23b[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.OVERLAY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f23b[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.NORMAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            f22a = new int[co_renamed.polarr.renderer.Orientation.values().length];
            try {
                f22a[co_renamed.polarr.renderer.Orientation.CCW_90.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f22a[co_renamed.polarr.renderer.Orientation.CCW_270.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f22a[co_renamed.polarr.renderer.Orientation.CCW_180.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f22a[co_renamed.polarr.renderer.Orientation.CCW_0.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    public bo_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("lookup_table"), context);
        this.ac_renamed = true;
        this.ad_renamed = false;
        this.ae_renamed = 0.08f;
        this.af_renamed = 0.6f;
        this.ag_renamed = 0.88f;
        this.ah_renamed = 0.2f;
        this.ai_renamed = false;
        this.aj_renamed = 0.0f;
        this.ak_renamed = 0.0f;
        this.al_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = 0.0f;
        this.D_renamed = new java.util.HashMap();
        this.E_renamed = null;
        this.F_renamed = new java.util.HashMap();
        this.G_renamed = 1.0f;
        this.H_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.I_renamed = new float[]{1.0f, 1.0f, 1.0f};
        this.J_renamed = new java.util.Random();
        this.K_renamed = 0;
        this.W_renamed = co_renamed.polarr.renderer.Orientation.CCW_0;
        this.X_renamed = 0;
        this.Y_renamed = 0;
        this.Z_renamed = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[2];
        this.ab_renamed = false;
        this.M_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bz_renamed(resources, context);
        this.M_renamed.a_renamed();
        this.L_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bm_renamed(resources, context);
        this.L_renamed.a_renamed();
        this.N_renamed = a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed.a_renamed(resources, context);
        this.O_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.ag_renamed(resources, context);
        this.O_renamed.a_renamed();
        this.P_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed(resources, context, this);
        this.P_renamed.a_renamed();
        this.V_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.r_renamed(resources, context);
        this.V_renamed.a_renamed();
        this.T_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bu_renamed(resources, context);
        this.T_renamed.a_renamed();
        this.R_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.bc_renamed(resources, context);
        this.R_renamed.a_renamed();
        this.S_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.ax_renamed(resources, context);
        this.S_renamed.a_renamed();
        this.U_renamed = new a_renamed.a_renamed.b_renamed.b_renamed.ai_renamed(resources, context);
        this.U_renamed.a_renamed();
    }

    public static void b_renamed(java.lang.String str) {
        q_renamed = str;
    }

    public boolean A_renamed() {
        return "COMBAIN_FILTER".equals(this.E_renamed);
    }

    public boolean B_renamed() {
        return (this.K_renamed & 224) != 0;
    }

    public void C_renamed() {
        z_renamed();
    }

    public final a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(int i_renamed, byte[] bArr, int i2, int i3) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9987.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 10497.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 10497.0f);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, java.nio.ByteBuffer.wrap(bArr));
        android.opengl.GLES20.glGenerateMipmap(3553);
        android.opengl.GLES20.glBindTexture(3553, 0);
        return a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i_renamed, 6408, i2, i3);
    }

    public void a_renamed(float f_renamed) {
        this.G_renamed = f_renamed;
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar) {
        this.aa_renamed = new java.lang.ref.WeakReference<>(aaVar);
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("Apply Bloom", new java.lang.Object[0]);
        a_renamed.a_renamed.b_renamed.f_renamed.o_renamed oVar = new a_renamed.a_renamed.b_renamed.f_renamed.o_renamed();
        int iRound = java.lang.Math.round(dVar.f35b * 0.55f);
        int iRound2 = java.lang.Math.round(dVar.f36c * 0.55f);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarD = this.L_renamed.d_renamed(iRound, iRound2);
        aaVar.a_renamed(this.M_renamed, dVar.f34a, dVarD);
        oVar.a_renamed(dVarD, this.L_renamed.e_renamed(iRound, iRound2));
        a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed aoVar = this.N_renamed;
        aoVar.r_renamed = new float[]{0.03f, 0.0f, 0.03f, 0.0f};
        aoVar.s_renamed = this.f15a.mesh;
        aaVar.a_renamed(aoVar, oVar.a_renamed().f34a, oVar.b_renamed());
        oVar.c_renamed();
        a_renamed.a_renamed.b_renamed.b_renamed.ao_renamed aoVar2 = this.N_renamed;
        aoVar2.r_renamed = new float[]{0.0f, 0.03f, 0.0f, 0.03f};
        aoVar2.s_renamed = this.f15a.mesh;
        aaVar.a_renamed(aoVar2, oVar.a_renamed().f34a, oVar.b_renamed());
        aaVar.a_renamed(this.L_renamed, dVar.f34a, dVar2);
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar, a_renamed.a_renamed.b_renamed.f_renamed.o_renamed oVar) {
        a_renamed.a_renamed.b_renamed.f_renamed.x_renamed xVar;
        a_renamed.a_renamed.b_renamed.b_renamed.by_renamed byVar;
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed boVar = this;
        float f_renamed = oVar.a_renamed().f35b;
        float f2 = oVar.a_renamed().f36c;
        co_renamed.polarr.renderer.Orientation orientation = co_renamed.polarr.renderer.Orientation.CCW_90;
        co_renamed.polarr.renderer.Orientation orientation2 = boVar.W_renamed;
        a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed[] cVarArrA = (orientation == orientation2 || co_renamed.polarr.renderer.Orientation.CCW_270 == orientation2) ? z_renamed().a_renamed(f2, f_renamed) : z_renamed().a_renamed(f_renamed, f2);
        a_renamed.a_renamed.b_renamed.f_renamed.x_renamed xVar2 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.SCREEN;
        a_renamed.a_renamed.b_renamed.b_renamed.by_renamed byVar2 = boVar.T_renamed;
        if (cVarArrA == null || cVarArrA.length <= 0) {
            return;
        }
        int length = cVarArrA.length;
        int i_renamed = 0;
        while (i_renamed < length) {
            a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.c_renamed cVar = cVarArrA[i_renamed];
            a_renamed.a_renamed.b_renamed.f_renamed.i_renamed.d_renamed dVar = cVar.f97b;
            int i2 = (int) (dVar.f99a * f_renamed);
            int i3 = (int) (dVar.f100b * f2);
            int i4 = (int) (dVar.f101c * f_renamed);
            int i5 = (int) (dVar.d_renamed * f2);
            a_renamed.a_renamed.b_renamed.f_renamed.x_renamed xVar3 = cVar.e_renamed;
            if (xVar3 != xVar2) {
                int i6 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.b_renamed.f23b[xVar3.ordinal()];
                byVar = i6 != 1 ? i6 != 2 ? i6 != 3 ? boVar.R_renamed : boVar.U_renamed : boVar.T_renamed : boVar.S_renamed;
                xVar = cVar.e_renamed;
            } else {
                a_renamed.a_renamed.b_renamed.b_renamed.by_renamed byVar3 = byVar2;
                xVar = xVar2;
                byVar = byVar3;
            }
            byVar.b_renamed(cVar.f96a);
            byVar.b_renamed((int) cVar.d_renamed);
            byVar.a_renamed(dVar.f99a, dVar.f100b, dVar.f101c, dVar.d_renamed);
            byVar.a_renamed(cVar.f98c);
            aaVar.a_renamed(byVar, oVar.a_renamed().f34a, oVar.b_renamed(), i2, i3, i4, i5);
            i_renamed++;
            boVar = this;
            a_renamed.a_renamed.b_renamed.f_renamed.x_renamed xVar4 = xVar;
            byVar2 = byVar;
            xVar2 = xVar4;
        }
        oVar.c_renamed();
    }

    public void a_renamed(co_renamed.polarr.renderer.Orientation orientation) {
        this.W_renamed = orientation;
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Cube cube) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        if (cube != null) {
            java.lang.String str = cube.filterID;
            this.E_renamed = str;
            this.F_renamed.put(str, java.lang.Float.valueOf(cube.size));
            int i_renamed = cube.size;
            int i2 = i_renamed * i_renamed;
            if (this.D_renamed.containsKey(cube.filterID)) {
                dVar = this.D_renamed.get(cube.filterID);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, i2, i_renamed);
            } else {
                int[] iArr = new int[1];
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i2, i_renamed);
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i2, i_renamed);
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9728, 9728);
                this.D_renamed.put(cube.filterID, dVarB);
                dVar = dVarB;
            }
            java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(cube.data.length);
            byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
            byteBufferAllocateDirect.put(cube.data);
            byteBufferAllocateDirect.position(0);
            android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
            int i3 = dVar.d_renamed;
            android.opengl.GLES20.glTexImage2D(3553, 0, i3, dVar.f35b, dVar.f36c, 0, i3, 5121, byteBufferAllocateDirect);
            android.opengl.GLES20.glBindTexture(3553, 0);
        }
    }

    public void a_renamed(boolean z_renamed, float f_renamed, float f2, float f3, float f4, float f5) {
        this.ai_renamed = z_renamed;
        this.aj_renamed = f_renamed;
        this.ak_renamed = f2;
        this.al_renamed = f3;
        this.z_renamed = f4;
        this.A_renamed = f5;
        draw();
        this.ai_renamed = false;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed
    public float[][] a_renamed(boolean z_renamed) {
        return z_renamed ? (this.K_renamed & 32) != 0 ? a_renamed.a_renamed.b_renamed.a_renamed.d_renamed.f10a : a_renamed.a_renamed.b_renamed.a_renamed.a_renamed.f4a : (this.K_renamed & 32) != 0 ? a_renamed.a_renamed.b_renamed.a_renamed.c_renamed.f8a : a_renamed.a_renamed.b_renamed.a_renamed.b_renamed.f6a;
    }

    public void b_renamed(int i_renamed) {
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed arVar = this.P_renamed;
        if (arVar != null) {
            arVar.b_renamed(i_renamed);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
        if (this.X_renamed != i_renamed || this.Y_renamed != i2) {
            this.X_renamed = i_renamed;
            this.Y_renamed = i2;
            if (this.K_renamed != 0) {
                s_renamed();
            }
        }
        super.b_renamed(i_renamed, i2);
    }

    public final void b_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        aaVar.a_renamed(this.O_renamed, dVar.f34a, dVar2);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed
    public float[][] b_renamed(boolean z_renamed) {
        return z_renamed ? (this.K_renamed & 32) != 0 ? a_renamed.a_renamed.b_renamed.a_renamed.d_renamed.f11b : a_renamed.a_renamed.b_renamed.a_renamed.a_renamed.f5b : (this.K_renamed & 32) != 0 ? a_renamed.a_renamed.b_renamed.a_renamed.c_renamed.f9b : a_renamed.a_renamed.b_renamed.a_renamed.b_renamed.f7b;
    }

    public final void c_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        aaVar.a_renamed(this.P_renamed, dVar.f34a, dVar2);
    }

    public void c_renamed(boolean z_renamed) {
        this.K_renamed = z_renamed ? this.K_renamed | 1 : this.K_renamed & (-2);
    }

    public boolean c_renamed(java.lang.String str) {
        if (str == null || !this.D_renamed.containsKey(str)) {
            return false;
        }
        this.E_renamed = str;
        return true;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        a_renamed.a_renamed.b_renamed.b_renamed.bm_renamed bmVar = this.L_renamed;
        if (bmVar != null) {
            bmVar.close();
            this.L_renamed = null;
        }
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed arVar = this.P_renamed;
        if (arVar != null) {
            arVar.close();
            this.P_renamed = null;
        }
        this.N_renamed = null;
        this.M_renamed = null;
        this.O_renamed = null;
        this.V_renamed = null;
        this.R_renamed = null;
        this.S_renamed = null;
        this.T_renamed = null;
        this.U_renamed = null;
        a_renamed.a_renamed.b_renamed.f_renamed.i_renamed iVar = this.Q_renamed;
        if (iVar != null) {
            iVar.close();
            this.Q_renamed = null;
        }
        t_renamed();
    }

    public final void d_renamed(a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        aaVar.a_renamed(this.V_renamed, dVar.f34a, dVar2);
    }

    public void d_renamed(java.lang.String str) {
        if ((this.K_renamed & 128) != 0) {
            if (str == null) {
                z_renamed().a_renamed(0L);
                b_renamed(0);
                return;
            }
            try {
                java.util.Map map = (java.util.Map) new com.google.gson.Gson().fromJson(str, java.util.Map.class);
                java.lang.Double d_renamed = (java.lang.Double) map.get("s_renamed");
                java.lang.Double d2 = (java.lang.Double) map.get("g_renamed");
                z_renamed().a_renamed(d_renamed.longValue());
                b_renamed(d2.intValue());
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void d_renamed(boolean z_renamed) {
        this.K_renamed = z_renamed ? this.K_renamed | 4 : this.K_renamed & (-5);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        if (this.K_renamed == 0) {
            t_renamed();
            super.draw();
            return;
        }
        if (this.ab_renamed) {
            super.draw();
            return;
        }
        a_renamed.a_renamed.b_renamed.f_renamed.aa_renamed aaVar = this.aa_renamed.get();
        if (aaVar != null) {
            int iB = b_renamed();
            int iA = aaVar.a_renamed();
            int i_renamed = this.X_renamed;
            int i2 = this.Y_renamed;
            s_renamed();
            float[] fArr = new float[16];
            int i3 = a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.b_renamed.f22a[this.W_renamed.ordinal()];
            if (i3 == 1) {
                android.opengl.Matrix.setRotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            } else if (i3 == 2) {
                android.opengl.Matrix.setRotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            } else if (i3 != 3) {
                android.opengl.Matrix.setIdentityM(fArr, 0);
            } else {
                android.opengl.Matrix.setRotateM(fArr, 0, 180.0f, 0.0f, 0.0f, 1.0f);
            }
            float[] fArr2 = new float[16];
            android.opengl.Matrix.multiplyMM(fArr2, 0, getMatrix(), 0, fArr, 0);
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.Z_renamed;
            aaVar.a_renamed(iB, dVarArr[0].f34a, fArr2, dVarArr[0].f35b, dVarArr[0].f36c);
            android.opengl.Matrix.setIdentityM(getMatrix(), 0);
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr2 = this.Z_renamed;
            aaVar.a_renamed(dVarArr2[0].f34a, dVarArr2[1].f34a, dVarArr2[1].f35b, dVarArr2[1].f36c);
            a_renamed.a_renamed.b_renamed.f_renamed.o_renamed oVar = new a_renamed.a_renamed.b_renamed.f_renamed.o_renamed();
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr3 = this.Z_renamed;
            oVar.a_renamed(dVarArr3[0], dVarArr3[1]);
            if ((this.K_renamed & 256) != 0) {
                z_renamed().c_renamed();
                this.K_renamed &= -257;
            }
            if ((this.K_renamed & 17) != 0) {
                a_renamed(aaVar, oVar.a_renamed(), oVar.b_renamed());
                oVar.c_renamed();
            }
            if ((this.K_renamed & 128) != 0) {
                a_renamed(aaVar, oVar);
            }
            if ((this.K_renamed & 34) != 0) {
                c_renamed(aaVar, oVar.a_renamed(), oVar.b_renamed());
                oVar.c_renamed();
            }
            if ((this.K_renamed & 68) != 0) {
                this.ab_renamed = true;
                aaVar.a_renamed(this, oVar.a_renamed().f34a, oVar.b_renamed());
                this.ab_renamed = false;
                oVar.c_renamed();
                b_renamed(aaVar, oVar.a_renamed(), oVar.b_renamed());
            } else {
                this.ab_renamed = true;
                aaVar.a_renamed(this, oVar.a_renamed().f34a, oVar.b_renamed());
                this.ab_renamed = false;
            }
            oVar.c_renamed();
            if ((this.K_renamed & 8) != 0) {
                d_renamed(aaVar, oVar.a_renamed(), oVar.b_renamed());
                oVar.c_renamed();
            }
            android.opengl.Matrix.invertM(fArr2, 0, fArr, 0);
            aaVar.a_renamed(oVar.a_renamed().f34a, iA, fArr2, i_renamed, i2);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() throws java.io.IOException {
        super.e_renamed();
        if (co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1.equals(this.E_renamed) || co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1B.equals(this.E_renamed) || this.B_renamed) {
            int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "grainTexture");
            android.opengl.GLES20.glActiveTexture(33986);
            n_renamed();
            android.opengl.GLES20.glBindTexture(3553, this.f15a.grainTexture.f34a);
            android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 2);
        }
        if (co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3.equals(this.E_renamed)) {
            int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "overlayTexture");
            android.opengl.GLES20.glActiveTexture(33987);
            android.opengl.GLES20.glBindTexture(3553, this.f15a.overlayTexture.f34a);
            android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 3);
        }
    }

    public void e_renamed(boolean z_renamed) {
        this.K_renamed = z_renamed ? this.K_renamed | 2 : this.K_renamed & (-3);
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed arVar = this.P_renamed;
        if (arVar != null) {
            arVar.p_renamed();
            this.P_renamed.d_renamed(0, 0);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
        if (this.ac_renamed) {
            super.f_renamed();
        }
    }

    public void f_renamed(boolean z_renamed) {
        this.K_renamed = z_renamed ? this.K_renamed | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480 : this.K_renamed & (-481);
        this.W_renamed = co_renamed.polarr.renderer.Orientation.CCW_0;
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed arVar = this.P_renamed;
        if (arVar != null) {
            arVar.p_renamed();
            this.P_renamed.d_renamed(8, 16);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() throws java.io.IOException {
        super.g_renamed();
        r_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void i_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        float f_renamed;
        java.lang.String str;
        super.j_renamed();
        if (!this.D_renamed.isEmpty() && (str = this.E_renamed) != null) {
            a_renamed("lut_size", this.F_renamed.get(str).floatValue());
            android.opengl.GLES20.glActiveTexture(33985);
            android.opengl.GLES20.glBindTexture(3553, this.D_renamed.get(this.E_renamed).f34a);
            a_renamed("lookup_texture", 1);
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.grainTexture;
            a_renamed("grainTextureSize", dVar.f35b, dVar.f36c);
            float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(this.f15a);
            a_renamed("textureSize", fArrB[0], fArrB[1]);
            a_renamed("globalScreenRotation", a_renamed.a_renamed.b_renamed.a_renamed.a_renamed());
            a_renamed("grainRandomOffset", this.J_renamed.nextFloat(), this.J_renamed.nextFloat());
            a_renamed("is_apply_roundcorner", this.ai_renamed ? 1 : 0);
            a_renamed("roundcorner_radius", this.aj_renamed);
            a_renamed("roundcorner_offset", this.ak_renamed, this.al_renamed);
            a_renamed("roundcorner_size", this.z_renamed, this.A_renamed);
        }
        a_renamed("is_apply_vignette", this.ad_renamed ? 1 : 0);
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "crop");
        float[] fArr = (float[]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("crop", this.f15a.renderStates);
        float[] fArrCopyOf = java.util.Arrays.copyOf(fArr, fArr.length);
        fArrCopyOf[1] = (1.0f - fArrCopyOf[3]) - fArrCopyOf[1];
        android.opengl.GLES20.glUniform4fv(iGlGetUniformLocation, 1, fArrCopyOf, 0);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "rotationMatrix"), 1, false, this.f15a.rotation90MatrixInv, 0);
        float[] fArrB2 = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(this.f15a);
        a_renamed("imgSize", fArrB2[0], fArrB2[1]);
        a_renamed("lookup_intensity", this.G_renamed);
        android.opengl.GLES20.glUniform3fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "domain_min"), 1, this.H_renamed, 0);
        android.opengl.GLES20.glUniform3fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "domain_max"), 1, this.I_renamed, 0);
        if (co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(this.E_renamed, "vignette_amount")) {
            co_renamed.polarr.renderer.entities.FilterItem filterItemA = a_renamed.a_renamed.b_renamed.e_renamed.a_renamed().a_renamed(this.E_renamed);
            a_renamed("is_apply_vignette", 1);
            for (java.lang.String str2 : new java.lang.String[]{"vignette_amount", "vignette_feather", "vignette_highlights", "vignette_roundness", "vignette_size", "vignette_exposure"}) {
                if (filterItemA.state.containsKey(str2)) {
                    a_renamed(str2, ((java.lang.Float) filterItemA.state.get(str2)).floatValue());
                }
            }
        } else if (co_renamed.polarr.renderer.FilterPackageUtil.b_renamed(this.E_renamed)) {
            a_renamed("is_apply_vignette", 0);
        } else {
            a_renamed("vignette_amount", r_renamed);
            a_renamed("vignette_feather", s_renamed);
            a_renamed("vignette_highlights", t_renamed);
            a_renamed("vignette_roundness", v_renamed);
            a_renamed("vignette_size", w_renamed);
            a_renamed("vignette_exposure", u_renamed);
        }
        if (co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(this.E_renamed, "grain_amount")) {
            a_renamed.a_renamed.b_renamed.e_renamed.a_renamed().a_renamed(this.E_renamed);
            a_renamed("grain_amount", 0.08f);
            a_renamed("grain_size", this.af_renamed);
            a_renamed("grain_highlights", 0.88f);
            f_renamed = 0.2f;
        } else if (!this.B_renamed) {
            a_renamed("grain_amount", 0.0f);
            a_renamed("is_apply_overlay", co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(this.E_renamed, "overlay_amount") ? 1 : 0);
        } else {
            a_renamed("grain_amount", this.ae_renamed);
            a_renamed("grain_size", this.af_renamed);
            a_renamed("grain_highlights", this.ag_renamed);
            f_renamed = this.ah_renamed;
        }
        a_renamed("grain_roughness", f_renamed);
        a_renamed("is_apply_overlay", co_renamed.polarr.renderer.FilterPackageUtil.a_renamed(this.E_renamed, "overlay_amount") ? 1 : 0);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        if (this.E_renamed == null) {
            return true;
        }
        return super.l_renamed();
    }

    public final void n_renamed() throws java.io.IOException {
        if (this.f15a.grainTextureBinded) {
            return;
        }
        try {
            if (x_renamed == null || x_renamed.length != 4194304) {
                java.io.InputStream inputStreamOpen = null;
                if (q_renamed != null) {
                    java.io.File file = new java.io.File(q_renamed, "film_grain_small.bin");
                    if (file.exists()) {
                        inputStreamOpen = new java.io.FileInputStream(file);
                    }
                }
                if (inputStreamOpen == null) {
                    inputStreamOpen = this.i_renamed.getAssets().open("textures/film_grain_small.bin");
                }
                byte[] bArrA = a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(inputStreamOpen);
                inputStreamOpen.close();
                x_renamed = bArrA;
            }
            this.f15a.grainTexture = a_renamed(this.f15a.grainTexture.f34a, x_renamed, 1024, 1024);
            this.f15a.grainTextureBinded = true;
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public void o_renamed() {
        this.E_renamed = null;
    }

    public void p_renamed() {
        this.K_renamed = 0;
    }

    public void q_renamed() {
        this.E_renamed = "AUTO_ENHANCE_FILTER";
        this.F_renamed.put("AUTO_ENHANCE_FILTER", java.lang.Float.valueOf(32.0f));
        if (this.D_renamed.containsKey("AUTO_ENHANCE_FILTER")) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(this.D_renamed.get("AUTO_ENHANCE_FILTER"), 1024, 32);
            return;
        }
        int[] iArr = new int[1];
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, 1024, 32);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, 1024, 32);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9728, 9728);
        this.D_renamed.put("AUTO_ENHANCE_FILTER", dVarB);
    }

    public void r_renamed() throws java.io.IOException {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        this.E_renamed = "COMBAIN_FILTER";
        if (this.C_renamed == null) {
            java.io.InputStream inputStreamOpen = null;
            try {
                if (q_renamed != null) {
                    java.io.File file = new java.io.File(q_renamed, "lut_all_points.png");
                    if (file.exists()) {
                        inputStreamOpen = new java.io.FileInputStream(file);
                    }
                }
                if (inputStreamOpen == null) {
                    inputStreamOpen = this.i_renamed.getAssets().open("textures/lut_all_points.png");
                }
                this.C_renamed = android.graphics.BitmapFactory.decodeStream(inputStreamOpen);
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        int width = this.C_renamed.getWidth();
        int height = this.C_renamed.getHeight();
        this.F_renamed.put("COMBAIN_FILTER", java.lang.Float.valueOf(height));
        if (this.D_renamed.containsKey("COMBAIN_FILTER")) {
            dVar = this.D_renamed.get("COMBAIN_FILTER");
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(dVar, width, height);
        } else {
            int[] iArr = new int[2];
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, width, height);
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, width, height);
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVarB2 = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[1], 6408, width, height);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.c_renamed(33071, 33071, 9728, 9728);
            this.D_renamed.put("COMBAIN_FILTER", dVarB);
            this.D_renamed.put("COMBAIN_FILTER_SWAP", dVarB2);
            dVar = dVarB;
        }
        android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, this.C_renamed, 0);
        android.opengl.GLES20.glBindTexture(3553, 0);
    }

    public final void s_renamed() {
        int i_renamed;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.Z_renamed;
        if (dVarArr[0] != null) {
            if (dVarArr[0].f35b == this.X_renamed && dVarArr[0].f36c == this.Y_renamed) {
                return;
            } else {
                t_renamed();
            }
        }
        int i2 = this.X_renamed;
        if (i2 <= 0 || (i_renamed = this.Y_renamed) <= 0) {
            return;
        }
        this.Z_renamed[0] = a_renamed(i2, i_renamed, 6408);
        this.Z_renamed[1] = a_renamed(this.X_renamed, this.Y_renamed, 6408);
    }

    public final void t_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.Z_renamed;
        if (dVarArr[0] == null && dVarArr[1] == null) {
            return;
        }
        a_renamed(this.Z_renamed[0]);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr2 = this.Z_renamed;
        dVarArr2[0] = null;
        a_renamed(dVarArr2[1]);
        this.Z_renamed[1] = null;
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed u_renamed() {
        if (!this.D_renamed.containsKey("AUTO_ENHANCE_FILTER")) {
            q_renamed();
        }
        return this.D_renamed.get("AUTO_ENHANCE_FILTER");
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed v_renamed() {
        return this.D_renamed.get("COMBAIN_FILTER");
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed w_renamed() {
        return this.D_renamed.get("COMBAIN_FILTER_SWAP");
    }

    public int x_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed arVar;
        if ((this.K_renamed & 34) == 0 || (arVar = this.P_renamed) == null) {
            return 0;
        }
        return arVar.o_renamed();
    }

    public java.lang.String y_renamed() {
        if ((this.K_renamed & 128) == 0) {
            return null;
        }
        int iX = x_renamed();
        long jA = z_renamed().a_renamed();
        java.util.HashMap map = new java.util.HashMap();
        map.put("s_renamed", java.lang.Long.valueOf(jA));
        map.put("g_renamed", java.lang.Long.valueOf(iX));
        return new com.google.gson.Gson().toJson(map);
    }

    public final a_renamed.a_renamed.b_renamed.f_renamed.i_renamed z_renamed() {
        if (this.Q_renamed == null) {
            this.Q_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.i_renamed(new a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.a_renamed(), "pacman.json");
            this.Q_renamed.b_renamed();
        }
        return this.Q_renamed;
    }
}
