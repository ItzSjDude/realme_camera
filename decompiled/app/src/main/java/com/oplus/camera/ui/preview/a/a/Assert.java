package com.oplus.camera.ui.preview.a_renamed.a_renamed;

/* compiled from: DoubleExposureTexturePreview.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed implements com.oplus.camera.ui.preview.a_renamed.aa_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6821a = "0ms";
    private boolean A_renamed;
    private float[] B_renamed;
    private android.renderscript.Matrix4f C_renamed;
    private com.oplus.camera.doubleexposure.b_renamed D_renamed;
    private boolean E_renamed;
    private boolean F_renamed;
    private int G_renamed;
    private android.os.ConditionVariable H_renamed;
    private final java.lang.Object I_renamed;
    private com.oplus.camera.doubleexposure.g_renamed.a_renamed J_renamed;
    private com.oplus.camera.doubleexposure.a_renamed K_renamed;
    private boolean L_renamed;
    private boolean M_renamed;
    private boolean N_renamed;
    private boolean O_renamed;
    private float[] P_renamed;
    private long Q_renamed;
    private long R_renamed;
    private int S_renamed;
    private com.oplus.camera.ui.preview.a_renamed.a_renamed.d_renamed T_renamed;
    private com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed U_renamed;
    private boolean V_renamed;
    private boolean W_renamed;
    private java.lang.Runnable X_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f6822b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed f6823c;
    private int d_renamed;
    private int k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.gl_renamed.s_renamed m_renamed;
    private com.oplus.camera.gl_renamed.s_renamed n_renamed;
    private com.oplus.camera.gl_renamed.s_renamed o_renamed;
    private com.oplus.camera.gl_renamed.s_renamed p_renamed;
    private com.oplus.camera.gl_renamed.s_renamed q_renamed;
    private com.oplus.camera.gl_renamed.s_renamed r_renamed;
    private com.oplus.camera.gl_renamed.g_renamed s_renamed;
    private boolean t_renamed;
    private com.oplus.camera.doubleexposure.d_renamed u_renamed;
    private android.os.HandlerThread v_renamed;
    private android.os.Handler w_renamed;
    private com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed x_renamed;
    private android.graphics.SurfaceTexture y_renamed;
    private boolean z_renamed;

    private int a_renamed(int i_renamed, boolean z_renamed) {
        if (z_renamed) {
            if (i_renamed != 0) {
                if (i_renamed != 90) {
                    if (i_renamed != 180) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        if (i_renamed != 0) {
            if (i_renamed != 90) {
                if (i_renamed != 180) {
                    return 0;
                }
                return 90;
            }
            return 180;
        }
        return 270;
    }

    private boolean e_renamed(int i_renamed) {
        return i_renamed == 0 || i_renamed == 4 || i_renamed == 5 || i_renamed == 6;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 1024;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void x_renamed() {
    }

    public a_renamed(android.content.Context context) {
        super(context);
        this.f6822b = null;
        this.f6823c = null;
        this.d_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = false;
        this.A_renamed = false;
        this.B_renamed = new float[16];
        this.C_renamed = new android.renderscript.Matrix4f();
        this.D_renamed = null;
        this.E_renamed = false;
        this.F_renamed = false;
        this.G_renamed = 0;
        this.H_renamed = new android.os.ConditionVariable();
        this.I_renamed = new java.lang.Object();
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = false;
        this.M_renamed = false;
        this.N_renamed = false;
        this.O_renamed = false;
        this.P_renamed = null;
        this.Q_renamed = 0L;
        this.R_renamed = 0L;
        this.S_renamed = 0;
        this.T_renamed = null;
        this.U_renamed = null;
        this.V_renamed = true;
        this.W_renamed = false;
        this.X_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.1
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                if (com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.u_renamed == null) {
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed aVar = com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this;
                    aVar.u_renamed = new com.oplus.camera.doubleexposure.d_renamed(aVar.f6822b);
                    int iA = com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.u_renamed.a_renamed();
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.u_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.f6823c.J_renamed());
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.z_renamed = true;
                    com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "process, initResult: " + iA);
                }
                if (com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.x_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.H_renamed.open();
                }
                synchronized (com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.I_renamed) {
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.W_renamed = com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.g_renamed;
                }
                com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.O_renamed = true;
            }
        };
        this.f6822b = context;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        if (this.P_renamed == null) {
            this.P_renamed = new android.renderscript.Matrix4f().getArray();
        }
        if (this.v_renamed == null) {
            this.v_renamed = new android.os.HandlerThread("decode video");
            this.v_renamed.start();
        }
        if (this.w_renamed == null) {
            this.w_renamed = new android.os.Handler(this.v_renamed.getLooper());
        }
        this.f6823c = aaVar;
        this.f6823c.a_renamed(this);
        com.oplus.camera.util.Util.a_renamed(this.X_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        android.os.Handler handler = this.w_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = this.p_renamed;
        if (sVar != null) {
            sVar.o_renamed();
            this.p_renamed = null;
        }
        H_renamed();
        this.L_renamed = false;
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.q_renamed();
            }
        });
        this.O_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        com.oplus.camera.doubleexposure.d_renamed dVar = this.u_renamed;
        if (dVar == null || !this.z_renamed) {
            return;
        }
        dVar.c_renamed();
        this.u_renamed = null;
        this.z_renamed = false;
        this.A_renamed = false;
    }

    private void r_renamed() {
        android.os.HandlerThread handlerThread = this.v_renamed;
        if (handlerThread != null) {
            handlerThread.quit();
            this.v_renamed = null;
        }
        android.os.Handler handler = this.w_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.w_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        super.a_renamed(i_renamed, i2);
        this.d_renamed = i_renamed;
        this.k_renamed = i2;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.m_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.l_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        this.m_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.d_renamed, this.k_renamed, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.k_renamed, this.d_renamed, true);
        this.t_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.m_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "prepareTextures, mInputTexture.getId: " + this.m_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 != null && !sVar2.n_renamed()) {
            this.l_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.l_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar3 = this.n_renamed;
        if (sVar3 == null || sVar3.n_renamed()) {
            return;
        }
        this.n_renamed.c_renamed(hVar);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        if (this.t_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.m_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.l_renamed = null;
            }
            this.t_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (a__renamed(i_renamed)) {
            return this.t_renamed && this.f6823c != null;
        }
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "canProcess, not support");
        return false;
    }

    private void A_renamed() {
        com.oplus.camera.doubleexposure.d_renamed dVar;
        if (!this.z_renamed || this.A_renamed || (dVar = this.u_renamed) == null) {
            return;
        }
        dVar.b_renamed();
        this.A_renamed = true;
    }

    private void B_renamed() {
        if (this.L_renamed) {
            com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar = this.J_renamed;
            if (aVar != null) {
                aVar.onVideoClipDone();
            }
            com.oplus.camera.doubleexposure.a_renamed aVar2 = this.K_renamed;
            if (aVar2 != null) {
                aVar2.a_renamed();
            }
            this.L_renamed = false;
            this.J_renamed = null;
            this.K_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        int iA;
        com.oplus.camera.doubleexposure.b_renamed bVar;
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        A_renamed();
        B_renamed();
        if (this.s_renamed == null && this.E_renamed && (bVar = this.D_renamed) != null) {
            a_renamed(bVar);
            this.E_renamed = false;
        }
        if (this.x_renamed != null && this.V_renamed) {
            this.H_renamed.open();
        }
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        if (cVar != null && cVar.f_renamed()) {
            this.x_renamed.e_renamed();
        }
        try {
            if (E_renamed() && this.z_renamed && this.s_renamed != null) {
                C_renamed();
                if (this.n_renamed == null) {
                    this.n_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.s_renamed.f4611a, this.s_renamed.f4612b, true);
                    if (!this.n_renamed.n_renamed()) {
                        this.n_renamed.c_renamed(aVar.f6975a);
                    }
                }
                if (this.o_renamed == null) {
                    this.o_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.s_renamed.f4611a, this.s_renamed.f4612b, true);
                    if (!this.o_renamed.n_renamed()) {
                        this.o_renamed.c_renamed(aVar.f6975a);
                    }
                }
                if (this.y_renamed != null) {
                    this.y_renamed.updateTexImage();
                    this.y_renamed.getTransformMatrix(this.B_renamed);
                }
                a_renamed(aVar.f6975a, this.s_renamed, this.n_renamed, this.B_renamed);
                if (this.F_renamed) {
                    this.r_renamed = a_renamed(aVar.f6975a, this.n_renamed, this.o_renamed, this.C_renamed.getArray(), I_renamed()) ? this.o_renamed : this.n_renamed;
                    aVar.f_renamed = true;
                    aVar.d_renamed = this.r_renamed;
                    this.q_renamed = this.r_renamed;
                    this.p_renamed = null;
                    this.L_renamed = true;
                    f6821a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                    return true;
                }
                com.oplus.camera.aps.util.CameraApsResult cameraApsResult = aVar.e_renamed;
                synchronized (this.I_renamed) {
                    iA = this.u_renamed.a_renamed(this.n_renamed.e_renamed(), this.n_renamed.f4611a, this.n_renamed.f4612b, false, this.x_renamed.c_renamed(), this.D_renamed.g_renamed(), cameraApsResult, this.l_renamed.e_renamed(), a_renamed(this.G_renamed, this.W_renamed), this.W_renamed);
                    if (this.O_renamed) {
                        this.O_renamed = false;
                        iA = this.u_renamed.a_renamed(this.n_renamed.e_renamed(), this.n_renamed.f4611a, this.n_renamed.f4612b, false, this.x_renamed.c_renamed(), this.D_renamed.g_renamed(), cameraApsResult, this.l_renamed.e_renamed(), a_renamed(this.G_renamed, this.W_renamed), this.W_renamed);
                        com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "process, drop frame");
                    }
                }
                if (!e_renamed(iA)) {
                    com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "process, result: " + iA);
                    return false;
                }
                f_renamed(iA);
                this.L_renamed = true;
                this.p_renamed = this.l_renamed;
                this.q_renamed = null;
                this.V_renamed = true;
                f6821a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                return true;
            }
            if (this.M_renamed) {
                if (this.p_renamed == null && this.q_renamed == null) {
                    return false;
                }
                if (this.p_renamed != null) {
                    this.l_renamed = this.p_renamed;
                    com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "draw cache");
                } else {
                    this.r_renamed = this.q_renamed;
                    aVar.f_renamed = true;
                    aVar.d_renamed = this.r_renamed;
                    com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "draw video cache");
                }
                f6821a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                return true;
            }
            if (F_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "process, decoding not ready");
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void C_renamed() {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.n_renamed;
        if (sVar != null && (sVar.f_renamed() != this.s_renamed.f_renamed() || this.n_renamed.g_renamed() != this.s_renamed.g_renamed())) {
            this.n_renamed.o_renamed();
            this.n_renamed = null;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.o_renamed;
        if (sVar2 != null) {
            if (sVar2.f_renamed() == this.s_renamed.f_renamed() && this.o_renamed.g_renamed() == this.s_renamed.g_renamed()) {
                return;
            }
            this.o_renamed.o_renamed();
            this.o_renamed = null;
        }
    }

    private void f_renamed(int i_renamed) {
        if (this.N_renamed) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (i_renamed == 5) {
                if (jCurrentTimeMillis - this.Q_renamed <= com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.mode_double_exposure_move_closer, 0, true, false, false, false, false, true, 1000);
                }
                this.Q_renamed = jCurrentTimeMillis;
            } else if (i_renamed == 4) {
                if (this.S_renamed != 4) {
                    this.R_renamed = jCurrentTimeMillis;
                }
                if (jCurrentTimeMillis - this.R_renamed >= com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_nobody_hint, 0, true, false, false, false, false, true, 1000);
                }
            }
            this.S_renamed = i_renamed;
        }
    }

    private void D_renamed() {
        this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.mode_double_exposure_move_closer);
        this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_nobody_hint);
    }

    private boolean E_renamed() {
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        return cVar != null && cVar.i_renamed();
    }

    private boolean F_renamed() {
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        return cVar != null && cVar.j_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr) {
        if (sVar == null) {
            return;
        }
        int iF = sVar.f_renamed();
        int iG = sVar.g_renamed();
        hVar.a_renamed(sVar);
        hVar.a_renamed(0.0f, iG);
        hVar.a_renamed(1.0f, -1.0f, 1.0f);
        hVar.a_renamed(gVar, fArr, 0, 0, iF, iG);
        hVar.h_renamed();
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr, com.oplus.camera.ui.preview.a_renamed.a_renamed.d_renamed dVar) {
        int iF = sVar.f_renamed();
        int iG = sVar.g_renamed();
        int iC = dVar.c_renamed();
        if (!((dVar.a_renamed() > dVar.b_renamed() && dVar.c_renamed() % 180 == 0) || (dVar.a_renamed() < dVar.b_renamed() && dVar.c_renamed() % 180 != 0))) {
            return false;
        }
        hVar.a_renamed(sVar);
        com.oplus.camera.doubleexposure.b_renamed bVar = this.D_renamed;
        int i_renamed = 90;
        if (bVar != null && !bVar.g_renamed() && iC == 90) {
            i_renamed = 270;
        }
        a_renamed(hVar, iF, iG, i_renamed);
        hVar.a_renamed(cVar, fArr, 0, 0, iG, iF);
        hVar.h_renamed();
        return true;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3) {
        hVar.a_renamed(i_renamed / 2, i2 / 2);
        hVar.a_renamed(i3, 0.0f, 0.0f, 1.0f);
        if (i3 % 180 != 0) {
            hVar.a_renamed(-r5, -r4);
        } else {
            hVar.a_renamed(-r4, -r5);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
        r_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.doubleexposure.c_renamed cVar) {
        com.oplus.camera.doubleexposure.b_renamed bVarA = cVar.a_renamed();
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "onVideoLoadedDone, clipVideoInfo: " + bVarA);
        this.N_renamed = false;
        D_renamed();
        if (this.D_renamed != null && bVarA.c_renamed().equals(this.D_renamed.c_renamed())) {
            this.E_renamed = true;
            this.F_renamed = cVar.b_renamed();
        } else {
            if (this.D_renamed != null) {
                this.M_renamed = true;
            }
            H_renamed();
            this.D_renamed = bVarA;
            this.E_renamed = true;
            this.F_renamed = cVar.b_renamed();
        }
        if (cVar.c_renamed() != null) {
            this.J_renamed = cVar.c_renamed();
            this.L_renamed = false;
        }
        if (cVar.d_renamed() != null) {
            this.K_renamed = cVar.d_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void u_renamed() {
        G_renamed();
        H_renamed();
    }

    private void G_renamed() {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.p_renamed;
        if (sVar != null) {
            sVar.o_renamed();
            this.p_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void v_renamed() {
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        if (cVar != null) {
            cVar.h_renamed();
        }
        this.N_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void w_renamed() {
        synchronized (this.I_renamed) {
            this.O_renamed = true;
        }
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        if (cVar != null) {
            cVar.d_renamed();
        }
        G_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.a_renamed
    public void c_renamed(int i_renamed) {
        com.oplus.camera.doubleexposure.d_renamed dVar;
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "onDoubleExposureTypeChanged, newType:" + i_renamed);
        if (!this.z_renamed || (dVar = this.u_renamed) == null) {
            return;
        }
        dVar.a_renamed(i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        synchronized (this.I_renamed) {
            this.G_renamed = i_renamed;
        }
    }

    private void H_renamed() {
        if (this.x_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureTexturePreview", "stopDecode");
            this.x_renamed.g_renamed();
            android.os.Handler handler = this.w_renamed;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.x_renamed.k_renamed();
            this.x_renamed = null;
            synchronized (this.I_renamed) {
                if (this.s_renamed != null) {
                    this.s_renamed.o_renamed();
                    this.s_renamed = null;
                }
            }
        }
        this.E_renamed = false;
        this.F_renamed = false;
        this.D_renamed = null;
        this.O_renamed = true;
    }

    private void a_renamed(com.oplus.camera.doubleexposure.b_renamed bVar) {
        if (this.U_renamed == null) {
            this.U_renamed = new com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.3
                @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed
                public void a_renamed() {
                    if (com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.M_renamed) {
                        com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.M_renamed = false;
                    }
                }

                @Override // com.oplus.camera.ui.preview.a_renamed.a_renamed.b_renamed
                public void b_renamed() {
                    com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.this.u_renamed();
                }
            };
        }
        if (this.x_renamed == null) {
            this.s_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
            this.y_renamed = new android.graphics.SurfaceTexture(this.s_renamed.e_renamed());
            this.x_renamed = new com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed(bVar, this.y_renamed);
            this.x_renamed.a_renamed(this.I_renamed);
            this.x_renamed.a_renamed(this.H_renamed);
            this.x_renamed.a_renamed(this.U_renamed);
            this.s_renamed.a_renamed(this.x_renamed.a_renamed(), this.x_renamed.b_renamed());
            this.w_renamed.post(this.x_renamed);
        }
    }

    private com.oplus.camera.ui.preview.a_renamed.a_renamed.d_renamed I_renamed() {
        if (this.T_renamed == null) {
            this.T_renamed = new com.oplus.camera.ui.preview.a_renamed.a_renamed.d_renamed();
        }
        com.oplus.camera.ui.preview.a_renamed.a_renamed.c_renamed cVar = this.x_renamed;
        if (cVar == null) {
            this.T_renamed.a_renamed(0);
            this.T_renamed.b_renamed(0);
            this.T_renamed.c_renamed(0);
        } else {
            this.T_renamed.a_renamed(cVar.a_renamed());
            this.T_renamed.b_renamed(this.x_renamed.b_renamed());
            this.T_renamed.c_renamed(this.x_renamed.c_renamed());
        }
        return this.T_renamed;
    }
}
