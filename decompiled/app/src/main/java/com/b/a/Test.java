package com.b_renamed.a_renamed;

/* compiled from: ModelRenderer.java */
/* loaded from: classes.dex */
public class d_renamed implements android.opengl.GLSurfaceView.Renderer {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f2342a = "d_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f2343b = {0.25f, 0.25f, 0.25f, 0.5f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final float[] f2344c = {1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] d_renamed = {1.0f, 1.0f, 1.0f, 0.5f};
    private static float e_renamed = 0.64f;
    private static final float[] f_renamed = {1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] g_renamed = {0.0f, 1.0f, 0.0f, 1.0f};
    private static final float[] h_renamed = {1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] i_renamed = {1.0f, 1.0f, 1.0f, 0.5f};
    private static final float[] j_renamed = {1.0f, 1.0f, 1.0f, 0.1f};
    private final com.b_renamed.a_renamed.j_renamed l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private final org.andresoviedo.android_3d_model_engine.a_renamed.c_renamed p_renamed;
    private long q_renamed = -1;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private java.util.Map<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed, org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> t_renamed = new java.util.HashMap();
    private java.util.Map<java.lang.Object, java.lang.Integer> u_renamed = new java.util.HashMap();
    private java.util.Map<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed, org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> v_renamed = new java.util.HashMap();
    private java.util.Map<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed, org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> w_renamed = new java.util.HashMap();
    private java.util.Map<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed, org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> x_renamed = new java.util.HashMap();
    private boolean y_renamed = false;
    private final float[] z_renamed = new float[16];
    private final float[] A_renamed = new float[16];
    private final float[] B_renamed = new float[16];
    private final float[] C_renamed = new float[4];
    private final float[] D_renamed = new float[3];
    private final float[] E_renamed = new float[3];
    private final float[] F_renamed = {0.0f, 0.0f, 0.0f, 1.0f};
    private final float[] G_renamed = new float[16];
    private final float[] H_renamed = new float[16];
    private final float[] I_renamed = new float[16];
    private final float[] J_renamed = new float[16];
    private final float[] K_renamed = new float[16];
    private final float[] L_renamed = new float[16];
    private boolean M_renamed = false;
    private boolean N_renamed = false;
    private boolean O_renamed = true;
    private boolean P_renamed = true;
    private boolean Q_renamed = false;
    private int R_renamed = 0;
    private final float[] S_renamed = new float[16];
    private java.util.Map<java.lang.String, java.lang.Boolean> T_renamed = new java.util.HashMap();
    private boolean U_renamed = false;
    private boolean V_renamed = false;
    private final float[] k_renamed = {0.0f, 0.0f, 0.0f, 1.0f};

    public float a_renamed() {
        return 1.0f;
    }

    public float b_renamed() {
        return 200.0f;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
    }

    public d_renamed(com.b_renamed.a_renamed.e_renamed eVar) throws java.lang.IllegalAccessException, java.io.IOException {
        this.l_renamed = eVar.getModelActivity().c_renamed();
        this.p_renamed = new org.andresoviedo.android_3d_model_engine.a_renamed.c_renamed(eVar.getContext());
    }

    public boolean c_renamed() {
        return this.M_renamed;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        com.b_renamed.a_renamed.b_renamed.c_renamed(f2342a, "onSurfaceCreated. config: " + eGLConfig);
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.c_renamed();
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        float[] fArr = this.k_renamed;
        cVar.a_renamed(fArr[0], fArr[1], fArr[2], fArr[3]);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar2.i_renamed(2929);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar4.i_renamed(3089);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i2, int i3) {
        this.m_renamed = i2;
        this.n_renamed = i3;
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(0, 0, i2, i3);
        this.o_renamed = i2 / i3;
        com.b_renamed.a_renamed.b_renamed.c_renamed(f2342a, "onSurfaceChanged: projection: [" + (-this.o_renamed) + "," + this.o_renamed + ",-1,1]-near/far[1,10]");
        float[] fArr = this.A_renamed;
        float f2 = this.o_renamed;
        android.opengl.Matrix.frustumM(fArr, 0, -f2, f2, -1.0f, 1.0f, a_renamed(), b_renamed());
        float[] fArr2 = this.K_renamed;
        float f3 = this.o_renamed;
        android.opengl.Matrix.frustumM(fArr2, 0, -f3, f3, -1.0f, 1.0f, a_renamed(), b_renamed());
        float[] fArr3 = this.H_renamed;
        float f4 = this.o_renamed;
        android.opengl.Matrix.frustumM(fArr3, 0, -f4, f4, -1.0f, 1.0f, a_renamed(), b_renamed());
        float[] fArr4 = this.S_renamed;
        float f5 = this.o_renamed;
        android.opengl.Matrix.orthoM(fArr4, 0, -f5, f5, -1.0f, 1.0f, a_renamed(), b_renamed());
    }

    public boolean a_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        boolean zC;
        if (this.V_renamed) {
            return false;
        }
        try {
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(0, 0, this.m_renamed, this.n_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(0, 0, this.m_renamed, this.n_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            cVar.b_renamed(16640);
        } catch (java.lang.Error e2) {
            e_renamed = e2;
            zC = false;
        } catch (java.lang.Exception e3) {
            e_renamed = e3;
            zC = false;
        }
        if (this.l_renamed == null) {
            return false;
        }
        float[] fArr = f2344c;
        if (this.l_renamed.o_renamed()) {
            try {
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                cVar4.i_renamed(3042);
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar6 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar7 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar8 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                cVar6.c_renamed(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
            } catch (java.lang.Error e4) {
                e_renamed = e4;
                zC = false;
                com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "Fatal error: " + e_renamed.getMessage(), e_renamed);
                this.V_renamed = true;
                return zC;
            } catch (java.lang.Exception e5) {
                e_renamed = e5;
                zC = false;
                com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "Fatal exception: " + e_renamed.getMessage(), e_renamed);
                this.V_renamed = true;
                return zC;
            }
        } else {
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar9 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar10 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            cVar9.g_renamed(3042);
        }
        zC = this.l_renamed.c_renamed();
        try {
            org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVarB = this.l_renamed.b_renamed();
            if (cVarB.c_renamed()) {
                int i2 = this.m_renamed;
                int i3 = this.n_renamed;
                android.opengl.Matrix.setLookAtM(this.z_renamed, 0, cVarB.f7970a, cVarB.f7971b, cVarB.f7972c, cVarB.d_renamed, cVarB.e_renamed, cVarB.f_renamed, cVarB.g_renamed, cVarB.h_renamed, cVarB.i_renamed);
                android.opengl.Matrix.frustumM(this.A_renamed, cVarB.n_renamed, cVarB.j_renamed, cVarB.k_renamed, cVarB.l_renamed, cVarB.m_renamed, a_renamed(), b_renamed());
                android.opengl.Matrix.multiplyMM(this.B_renamed, 0, this.A_renamed, 0, this.z_renamed, 0);
                cVarB.a_renamed(false);
            }
        } catch (java.lang.Error e6) {
            e_renamed = e6;
            com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "Fatal error: " + e_renamed.getMessage(), e_renamed);
            this.V_renamed = true;
            return zC;
        } catch (java.lang.Exception e7) {
            e_renamed = e7;
            com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "Fatal exception: " + e_renamed.getMessage(), e_renamed);
            this.V_renamed = true;
            return zC;
        }
        if (!this.l_renamed.m_renamed()) {
            a_renamed(this.z_renamed, this.A_renamed, this.B_renamed, this.D_renamed, fArr, this.E_renamed);
            return zC;
        }
        if (this.l_renamed.n_renamed()) {
            if (this.U_renamed) {
                a_renamed(this.G_renamed, this.H_renamed, this.I_renamed, this.D_renamed, f_renamed, this.E_renamed);
            } else {
                a_renamed(this.J_renamed, this.K_renamed, this.L_renamed, this.D_renamed, g_renamed, this.E_renamed);
            }
            this.U_renamed = !this.U_renamed;
            return zC;
        }
        if (this.l_renamed.h_renamed()) {
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(0, 0, this.m_renamed / 2, this.n_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(0, 0, this.m_renamed / 2, this.n_renamed);
            a_renamed(this.G_renamed, this.H_renamed, this.I_renamed, this.D_renamed, null, this.E_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.m_renamed / 2, 0, this.m_renamed / 2, this.n_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(this.m_renamed / 2, 0, this.m_renamed / 2, this.n_renamed);
            a_renamed(this.J_renamed, this.K_renamed, this.L_renamed, this.D_renamed, null, this.E_renamed);
        }
        return zC;
    }

    private void a_renamed(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6) throws java.io.IOException {
        this.l_renamed.b_renamed();
        int i2 = this.R_renamed;
        if (i2 != -3) {
            if (i2 == -2) {
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                float[] fArr7 = this.k_renamed;
                cVar.a_renamed(fArr7[0], fArr7[1], fArr7[2], fArr7[3]);
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                cVar2.b_renamed(16640);
            } else if (i2 == -1) {
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                float[] fArr8 = this.k_renamed;
                cVar5.a_renamed(1.0f - fArr8[0], 1.0f - fArr8[1], 1.0f - fArr8[2], 1.0f - fArr8[3]);
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar6 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar7 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar8 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                cVar6.b_renamed(16640);
            }
        }
        boolean z_renamed = this.l_renamed.g_renamed() && this.Q_renamed;
        boolean z2 = this.l_renamed.k_renamed() && c_renamed();
        boolean z3 = this.l_renamed.e_renamed() || this.N_renamed;
        boolean z4 = this.l_renamed.i_renamed() && this.O_renamed;
        boolean z5 = this.l_renamed.j_renamed() && this.P_renamed;
        java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> listD = this.l_renamed.d_renamed();
        for (int i3 = 0; i3 < listD.size(); i3++) {
            a_renamed(fArr, fArr2, fArr4, fArr5, fArr6, z_renamed, z2, z3, z4, z5, listD, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3, types: [org.andresoviedo.android_3d_model_engine.a_renamed.c_renamed] */
    /* JADX WARN: Type inference failed for: r16v5 */
    private void a_renamed(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list, int i2) throws java.io.IOException {
        boolean z6;
        org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar;
        java.lang.Integer numValueOf = null;
        try {
            gVar = list.get(i2);
            try {
                try {
                    if (!gVar.l_renamed()) {
                        return;
                    }
                    if (!this.T_renamed.containsKey(gVar.g_renamed())) {
                        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelRenderer", "Drawing model: " + gVar.g_renamed() + ", " + gVar.getClass().getSimpleName());
                        this.T_renamed.put(gVar.g_renamed(), true);
                    }
                    z6 = this.p_renamed;
                    org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed bVarA = z6.a_renamed(gVar, false, z4, z2, z_renamed, z5);
                    if (bVarA == null) {
                        if (this.T_renamed.containsKey(gVar.g_renamed() + "drawer")) {
                            return;
                        }
                        com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "No drawer for " + gVar.g_renamed());
                        this.T_renamed.put(gVar.g_renamed() + "drawer", true);
                        return;
                    }
                    gVar.m_renamed();
                    gVar.b_renamed(false);
                    if (z4 && (numValueOf = this.u_renamed.get(gVar.q_renamed())) == null && gVar.q_renamed() != null) {
                        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelRenderer", "Loading texture for obj: '" + gVar.g_renamed() + "'... bytes: " + gVar.q_renamed().length);
                        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(gVar.q_renamed());
                        numValueOf = java.lang.Integer.valueOf(org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(byteArrayInputStream));
                        byteArrayInputStream.close();
                        this.u_renamed.put(gVar.q_renamed(), numValueOf);
                        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelRenderer", "Loaded texture OK. id_renamed: " + numValueOf);
                    }
                    if (numValueOf == null) {
                        numValueOf = -1;
                    }
                    int iO = gVar.o_renamed();
                    org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                    if (iO == 0) {
                        org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed bVarA2 = this.p_renamed.a_renamed();
                        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                        bVarA2.a_renamed(gVar, fArr2, fArr, 0, fArr3, fArr5);
                        return;
                    }
                    if (z3) {
                        int iO2 = gVar.o_renamed();
                        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                        if (iO2 != 0) {
                            int iO3 = gVar.o_renamed();
                            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                            if (iO3 != 1) {
                                int iO4 = gVar.o_renamed();
                                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                                if (iO4 != 3) {
                                    int iO5 = gVar.o_renamed();
                                    org.andresoviedo.a_renamed.a_renamed.c_renamed cVar6 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                                    if (iO5 != 2) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    try {
                        if (this.l_renamed.f_renamed()) {
                            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar7 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                            z6 = 1;
                            try {
                                bVarA.a_renamed(gVar, fArr2, fArr, 0, gVar.p_renamed(), numValueOf.intValue(), fArr3, fArr4, fArr5);
                                gVar.a_renamed(this.p_renamed, fArr3, fArr4);
                                return;
                            } catch (java.lang.Error e2) {
                                e_renamed = e2;
                                gVar = gVar;
                                com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "There was a_renamed problem rendering the object '" + gVar.g_renamed() + "':" + e_renamed.getMessage(), e_renamed);
                                return;
                            } catch (java.lang.Exception e3) {
                                e_renamed = e3;
                                gVar = gVar;
                                if (this.T_renamed.containsKey(e_renamed.getMessage())) {
                                    return;
                                }
                                com.b_renamed.a_renamed.b_renamed.a_renamed("ModelRenderer", "There was a_renamed problem rendering the object '" + gVar.g_renamed() + "':" + e_renamed.getMessage(), e_renamed);
                                this.T_renamed.put(e_renamed.getMessage(), java.lang.Boolean.valueOf(z6));
                                return;
                            }
                        }
                        if (this.l_renamed.l_renamed() && (gVar instanceof org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed)) {
                            return;
                        }
                        if (!this.T_renamed.containsKey(gVar.g_renamed() + "render")) {
                            com.b_renamed.a_renamed.b_renamed.d_renamed("ModelRenderer", "Rendering object... " + gVar.g_renamed());
                            com.b_renamed.a_renamed.b_renamed.c_renamed("ModelRenderer", gVar.toString());
                            com.b_renamed.a_renamed.b_renamed.c_renamed("ModelRenderer", bVarA.toString());
                            this.T_renamed.put(gVar.g_renamed() + "render", true);
                        }
                        bVarA.a_renamed(gVar, fArr2, fArr, numValueOf.intValue(), fArr3, fArr4, fArr5);
                        gVar.a_renamed(this.p_renamed, fArr3, fArr4);
                    } catch (java.lang.Exception e4) {
                        e_renamed = e4;
                    }
                } catch (java.lang.Exception e5) {
                    e_renamed = e5;
                    z6 = 1;
                }
            } catch (java.lang.Error e6) {
                e_renamed = e6;
            }
        } catch (java.lang.Error e7) {
            e_renamed = e7;
            gVar = null;
        } catch (java.lang.Exception e8) {
            e_renamed = e8;
            z6 = 1;
            gVar = null;
        }
    }

    public int d_renamed() {
        return this.m_renamed;
    }

    public int e_renamed() {
        return this.n_renamed;
    }
}
