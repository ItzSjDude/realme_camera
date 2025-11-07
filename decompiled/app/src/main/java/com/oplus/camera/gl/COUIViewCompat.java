package com.oplus.camera.gl_renamed;

/* compiled from: SurfaceTextureScreenNail.java */
/* loaded from: classes2.dex */
public abstract class t_renamed implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private int af_renamed;
    protected int w_renamed;
    protected int x_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.Integer f4665a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final java.lang.Integer f4666b = 1;
    protected static final float[] g_renamed = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    protected static final float[] h_renamed = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    protected static final float[] i_renamed = {0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private static com.oplus.camera.ui.preview.v_renamed ai_renamed = new com.oplus.camera.ui.preview.v_renamed(0.0f, 1.0f);

    /* renamed from: c_renamed, reason: collision with root package name */
    protected boolean f4667c = false;
    protected boolean d_renamed = false;
    protected boolean e_renamed = false;
    protected boolean f_renamed = false;
    protected java.util.List<com.oplus.camera.gl_renamed.t_renamed.a_renamed> j_renamed = new java.util.ArrayList();
    protected final java.lang.Object k_renamed = new java.lang.Object();
    protected java.util.List<com.oplus.camera.gl_renamed.g_renamed> l_renamed = new java.util.ArrayList();
    protected com.oplus.camera.gl_renamed.s_renamed m_renamed = null;
    protected com.oplus.camera.gl_renamed.p_renamed n_renamed = null;
    protected com.oplus.camera.gl_renamed.w_renamed o_renamed = null;
    protected android.os.Handler p_renamed = new android.os.Handler();
    protected com.oplus.camera.ui.preview.h_renamed.c_renamed q_renamed = null;
    protected com.oplus.camera.ui.preview.h_renamed.b_renamed r_renamed = null;
    protected final java.lang.Object s_renamed = new java.lang.Object();
    protected java.util.HashMap<java.lang.String, com.oplus.camera.gl_renamed.t_renamed.b_renamed> t_renamed = new java.util.HashMap<>();
    protected com.oplus.camera.ui.preview.a_renamed.t_renamed u_renamed = null;
    protected com.oplus.camera.gl_renamed.GLRootView v_renamed = null;
    protected boolean y_renamed = false;
    protected boolean z_renamed = false;
    protected boolean A_renamed = false;
    protected java.util.Map<java.lang.Integer, com.oplus.camera.gl_renamed.t_renamed.c_renamed> B_renamed = new java.util.HashMap();
    protected long C_renamed = 0;
    protected int D_renamed = 0;
    protected boolean E_renamed = false;
    protected float[] F_renamed = new float[16];
    protected int G_renamed = 90;
    protected boolean H_renamed = false;
    protected boolean I_renamed = false;
    protected android.media.Image J_renamed = null;
    protected android.media.Image K_renamed = null;
    protected com.oplus.camera.gl_renamed.b_renamed.f_renamed L_renamed = null;
    protected com.oplus.camera.gl_renamed.b_renamed.h_renamed M_renamed = new com.oplus.camera.gl_renamed.b_renamed.h_renamed();
    protected java.util.Set<java.lang.Long> N_renamed = new java.util.HashSet();
    protected java.util.Set<java.lang.Long> O_renamed = new java.util.HashSet();
    protected java.util.Set<java.lang.Long> P_renamed = new java.util.HashSet();
    protected long Q_renamed = -1;
    private android.graphics.SurfaceTexture R_renamed = null;
    private final float[] S_renamed = new float[16];
    private volatile boolean T_renamed = false;
    private volatile com.oplus.camera.screen.out.e_renamed U_renamed = null;
    private final java.util.concurrent.locks.Lock V_renamed = new java.util.concurrent.locks.ReentrantLock();
    private boolean W_renamed = false;
    private float X_renamed = 0.0f;
    private int Y_renamed = 0;
    private int Z_renamed = 0;
    private java.util.List<com.oplus.camera.aps.util.CameraApsResult> aa_renamed = new java.util.ArrayList();
    private com.oplus.camera.aps.util.CameraApsResult ab_renamed = null;
    private final java.lang.Object ac_renamed = new java.lang.Object();
    private long ad_renamed = 0;
    private float[] ae_renamed = new float[16];
    private com.oplus.camera.gl_renamed.s_renamed ag_renamed = null;
    private com.oplus.camera.ui.preview.y_renamed ah_renamed = null;
    private volatile boolean aj_renamed = false;

    /* compiled from: SurfaceTextureScreenNail.java */
    public static class b_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        public static java.lang.String f4672c = "capture_blur";
        public static java.lang.String d_renamed = "capture_thumbnail";
        public static java.lang.String e_renamed = "capture_exit";
        public static java.lang.String f_renamed = "capture_origin";
        public boolean g_renamed = false;
        public boolean h_renamed = false;

        public void a_renamed(android.graphics.Bitmap bitmap) {
        }

        public void a_renamed(java.lang.Integer num, android.graphics.Bitmap bitmap, long j_renamed, long j2, android.hardware.camera2.CaptureResult captureResult) {
        }

        public boolean a_renamed() {
            return false;
        }

        public int b_renamed() {
            return 0;
        }
    }

    public abstract int a_renamed(int i2, int i3, int i4, int i5);

    public abstract void i_renamed();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public abstract void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture);

    public void a_renamed(int i2) {
        synchronized (this) {
            this.D_renamed = i2;
        }
    }

    public void a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar, boolean z_renamed, boolean z2, java.lang.String str) {
        synchronized (this) {
            com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setCapturePreviewCallback, cb_renamed: " + bVar + ", isEffect: " + z_renamed + ", needCheckTimestamp: " + z2 + ", type: " + str);
            bVar.g_renamed = z2;
            bVar.h_renamed = z_renamed;
            synchronized (this.s_renamed) {
                this.t_renamed.put(str, bVar);
            }
            if (com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c.equals(str)) {
                a_renamed(1);
                this.q_renamed.Z_renamed();
            } else if (com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed.equals(str)) {
                this.q_renamed.Z_renamed();
            }
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setCacheWhilePreview, state: " + z_renamed);
        synchronized (this.s_renamed) {
            this.z_renamed = z_renamed;
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setCacheWhileCapture, state: " + z_renamed);
        synchronized (this.s_renamed) {
            this.A_renamed = z_renamed;
        }
    }

    public void a_renamed(int i2, long j_renamed, long j2) {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setCapturePreviewTimestamp, which: " + i2 + ", identity: " + j_renamed + ", timestamp: " + j2);
        synchronized (this.s_renamed) {
            this.B_renamed.put(java.lang.Integer.valueOf(i2), new com.oplus.camera.gl_renamed.t_renamed.c_renamed(j_renamed, j2));
            if (f4666b.intValue() == i2 && j2 != 0) {
                this.v_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.t_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.oplus.camera.gl_renamed.t_renamed.this.n_renamed();
                        } catch (java.lang.Exception e_renamed) {
                            com.oplus.camera.e_renamed.f_renamed("SurfaceTextureScreenNail", "setCapturePreviewTimestamp, tryCapturePreview error: " + e_renamed.getMessage());
                        }
                    }
                });
            }
        }
    }

    public long b_renamed(int i2) {
        long j_renamed;
        synchronized (this.s_renamed) {
            j_renamed = this.B_renamed.containsKey(java.lang.Integer.valueOf(i2)) ? this.B_renamed.get(java.lang.Integer.valueOf(i2)).f4674b : 0L;
        }
        return j_renamed;
    }

    public void a_renamed(long j_renamed, long j2, long j3, boolean z_renamed, boolean z2) {
        synchronized (this.s_renamed) {
            this.B_renamed.put(f4665a, new com.oplus.camera.gl_renamed.t_renamed.c_renamed(j2, j3));
            if (z_renamed) {
                this.P_renamed.add(java.lang.Long.valueOf(j2));
            }
            if (!com.oplus.camera.util.Util.C_renamed() && z2) {
                this.q_renamed.Z_renamed();
            }
            this.N_renamed.clear();
            this.Q_renamed = -1L;
            this.O_renamed.clear();
            com.oplus.camera.e_renamed.b_renamed("SurfaceTextureScreenNail", "onCaptureStarted, frameNumber: " + j_renamed + ", identity: " + j2 + ", timestamp: " + j3 + ", quickJpeg: " + z_renamed + ", requestRender: " + z2);
        }
    }

    public void a_renamed(long j_renamed) {
        synchronized (this.s_renamed) {
            this.A_renamed = false;
            this.P_renamed.remove(java.lang.Long.valueOf(j_renamed));
        }
    }

    public void a_renamed(long j_renamed, long j2) {
        synchronized (this.s_renamed) {
            this.Q_renamed = j_renamed;
            this.O_renamed.add(java.lang.Long.valueOf(j2));
        }
        com.oplus.camera.e_renamed.b_renamed("SurfaceTextureScreenNail", "notifyCacheFrame, frameNumber: " + j_renamed + ", timestamp: " + j2);
    }

    public java.util.Set<java.lang.Long> a_renamed() {
        java.util.HashSet hashSet;
        synchronized (this.s_renamed) {
            hashSet = new java.util.HashSet(this.O_renamed);
        }
        return hashSet;
    }

    public void b_renamed(long j_renamed, long j2) {
        synchronized (this.s_renamed) {
            this.N_renamed.add(java.lang.Long.valueOf(j2));
        }
        com.oplus.camera.e_renamed.b_renamed("SurfaceTextureScreenNail", "notifySkipDrawFrame, frameNumber: " + j_renamed + ", timestamp: " + j2);
    }

    public java.util.Set<java.lang.Long> b_renamed() {
        java.util.HashSet hashSet;
        synchronized (this.s_renamed) {
            hashSet = new java.util.HashSet(this.N_renamed);
        }
        return hashSet;
    }

    public void a_renamed(java.lang.String str) {
        synchronized (this.s_renamed) {
            if (this.t_renamed != null && this.t_renamed.containsKey(str)) {
                this.t_renamed.remove(str);
            }
        }
    }

    public t_renamed() {
        this.af_renamed = 1;
        this.af_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_BUFFER_CACHE_SUPPORT) ? 1 : 0;
        ai_renamed.a_renamed(false);
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        this.u_renamed = tVar;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.GLRootView gLRootView) {
        this.v_renamed = gLRootView;
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.u_renamed;
        if (tVar != null) {
            tVar.a_renamed(this.v_renamed);
        }
    }

    public void c_renamed(boolean z_renamed) {
        synchronized (this) {
            this.W_renamed = z_renamed;
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "acquireSurfaceTexture");
        if (this.l_renamed.isEmpty()) {
            this.l_renamed.add(new com.oplus.camera.gl_renamed.g_renamed(36197));
            this.l_renamed.add(new com.oplus.camera.gl_renamed.g_renamed(36197));
            this.l_renamed.add(new com.oplus.camera.gl_renamed.g_renamed(36197));
        }
        java.util.Iterator<com.oplus.camera.gl_renamed.g_renamed> it = this.l_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(this.w_renamed, this.x_renamed);
        }
        if (this.j_renamed.isEmpty()) {
            this.j_renamed.add(new com.oplus.camera.gl_renamed.t_renamed.a_renamed(this.w_renamed, this.x_renamed));
        }
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion()) {
            this.R_renamed = new android.graphics.SurfaceTexture(this.l_renamed.get(2).e_renamed());
            this.R_renamed.setOnFrameAvailableListener(this, this.p_renamed);
            try {
                this.R_renamed.detachFromGLContext();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.u_renamed;
        if (tVar != null) {
            tVar.a_renamed(this);
            this.u_renamed.a_renamed(true);
        }
        synchronized (this) {
            this.T_renamed = true;
            f_renamed(z_renamed);
        }
        this.C_renamed = 0L;
        this.ad_renamed = 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() ? com.oplus.camera.jni.PreviewShow.init() : 0L;
    }

    public void e_renamed(boolean z_renamed) {
        this.aj_renamed = z_renamed;
    }

    public void f_renamed(boolean z_renamed) {
        char c2 = (z_renamed || com.oplus.camera.util.Util.aN_renamed()) ? this.aj_renamed ? (char) 4 : (char) 6 : (char) 7;
        synchronized (this.S_renamed) {
            android.opengl.Matrix.setIdentityM(this.S_renamed, 0);
            if ((c2 & 1) != 0) {
                android.opengl.Matrix.multiplyMM(this.S_renamed, 0, this.S_renamed, 0, g_renamed, 0);
            }
            if ((c2 & 4) != 0) {
                android.opengl.Matrix.multiplyMM(this.S_renamed, 0, this.S_renamed, 0, i_renamed, 0);
            }
            if ((c2 & 2) != 0) {
                android.opengl.Matrix.multiplyMM(this.S_renamed, 0, h_renamed, 0, this.S_renamed, 0);
            }
        }
    }

    public void c_renamed(int i2) {
        synchronized (this) {
            this.G_renamed = i2;
        }
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setDisplayOrientation, orientation: " + i2);
    }

    public android.graphics.SurfaceTexture c_renamed() {
        return this.R_renamed;
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "releaseTextures");
        synchronized (this) {
            this.T_renamed = false;
            while (!this.l_renamed.isEmpty()) {
                this.l_renamed.remove(0).o_renamed();
            }
            synchronized (this.s_renamed) {
                while (!this.j_renamed.isEmpty()) {
                    this.j_renamed.remove(0).c_renamed();
                }
            }
            if (this.u_renamed != null) {
                this.u_renamed.a_renamed(false);
                this.u_renamed.h_renamed();
            }
            if (this.m_renamed != null) {
                this.m_renamed.o_renamed();
                this.m_renamed = null;
            }
            synchronized (this.ac_renamed) {
                for (com.oplus.camera.aps.util.CameraApsResult cameraApsResult : this.aa_renamed) {
                    if (cameraApsResult != null) {
                        cameraApsResult.closeImageBuffer();
                        com.oplus.camera.perf.FluencyPerformance.c_renamed(cameraApsResult.getTimestamp());
                    }
                }
                this.aa_renamed.clear();
            }
            if (this.ab_renamed != null) {
                this.ab_renamed.closeImageBuffer();
                this.ab_renamed = null;
            }
        }
        this.C_renamed = 0L;
        long j_renamed = this.ad_renamed;
        if (0 != j_renamed) {
            com.oplus.camera.jni.PreviewShow.release(j_renamed);
            this.ad_renamed = 0L;
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.u_renamed;
        if (tVar != null) {
            tVar.a_renamed((com.oplus.camera.gl_renamed.t_renamed) null);
        }
        this.ag_renamed = null;
    }

    public void e_renamed() {
        java.util.Iterator<com.oplus.camera.gl_renamed.g_renamed> it = this.l_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(this.w_renamed, this.x_renamed);
        }
    }

    public void a_renamed(int i2, int i3) {
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "setSize, height: " + i3 + ", width: " + i2);
        this.w_renamed = i2;
        this.x_renamed = i3;
        synchronized (this.k_renamed) {
            while (!this.j_renamed.isEmpty()) {
                this.j_renamed.remove(0).c_renamed();
            }
            this.j_renamed.add(new com.oplus.camera.gl_renamed.t_renamed.a_renamed(this.w_renamed, this.x_renamed));
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.u_renamed;
        if (tVar != null) {
            tVar.b_renamed(i2, i3);
        }
    }

    public int f_renamed() {
        return this.w_renamed;
    }

    public int g_renamed() {
        return this.x_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        synchronized (this) {
            if (this.T_renamed && (com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() != 2 || this.R_renamed != null)) {
                if (this.R_renamed != null) {
                    this.R_renamed.attachToGLContext(this.l_renamed.get(0).e_renamed());
                }
                hVar.a_renamed(2);
                this.Y_renamed = hVar.d_renamed();
                this.Z_renamed = hVar.e_renamed();
                hVar.a_renamed(i4, i5);
                hVar.a_renamed(i2 + (i4 / 2), i3 + (i5 / 2));
                if (this.W_renamed) {
                    if (this.X_renamed - 0.0f < 0.001f) {
                        this.X_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_PREVIEW_SCALE);
                    }
                    hVar.a_renamed(this.X_renamed, -this.X_renamed, 1.0f);
                } else {
                    hVar.a_renamed(1.0f, -1.0f, 1.0f);
                }
                if (i6 == 1) {
                    hVar.a_renamed(-1.0f, 1.0f, 1.0f);
                } else if (i6 == 2) {
                    hVar.a_renamed(1.0f, -1.0f, 1.0f);
                }
                hVar.a_renamed(-r4, -r6);
                if (this.R_renamed != null) {
                    this.R_renamed.updateTexImage();
                }
                a_renamed(this.F_renamed);
                this.u_renamed.a_renamed(this.F_renamed);
                if (this.L_renamed == null || !this.H_renamed) {
                    if (i7 == 0) {
                        if (!this.u_renamed.a_renamed(hVar, this.l_renamed.get(0), i2, i3, i4, i5, this.G_renamed)) {
                            hVar.a_renamed(this.l_renamed.get(0), this.F_renamed, i2, i3, i4, i5);
                        }
                    } else if (1 == i7 && this.E_renamed) {
                        if (this.ag_renamed != null && this.ag_renamed.n_renamed() && this.u_renamed.a_renamed(hVar, this.l_renamed.get(0), i2, i3, i4, i5, this.D_renamed, false)) {
                            hVar.a_renamed(this.ag_renamed, this.F_renamed, i2, i3, i4, i5);
                            this.ag_renamed = null;
                        } else if (!this.u_renamed.a_renamed(hVar, this.l_renamed.get(0), i2, i3, i4, i5, this.D_renamed, true)) {
                            hVar.a_renamed(this.l_renamed.get(0), this.F_renamed, i2, i3, i4, i5);
                        }
                    }
                } else if (!this.u_renamed.a_renamed(hVar, this.L_renamed, this.L_renamed.f_renamed(), i2, i3, i4, i5, this.G_renamed)) {
                    android.opengl.Matrix.setIdentityM(this.ae_renamed, 0);
                    hVar.a_renamed(this.L_renamed.f_renamed(), this.ae_renamed, i2, i3, i4, i5);
                }
                hVar.a_renamed(this.Y_renamed, this.Z_renamed);
                hVar.f_renamed();
                if (this.R_renamed != null) {
                    this.R_renamed.detachFromGLContext();
                }
            }
        }
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.aps.util.CameraApsResult cameraApsResult) {
        com.oplus.camera.gl_renamed.t_renamed.a_renamed aVar;
        boolean z_renamed = b_renamed(cameraApsResult) || q_renamed();
        if (this.E_renamed) {
            if (z_renamed || p_renamed()) {
                int iO = o_renamed();
                boolean z2 = this.j_renamed.size() < java.lang.Math.max(iO, 2) || !this.u_renamed.a_renamed(gVar, this.j_renamed.get(1).f4669a);
                if (!z_renamed) {
                    aVar = this.j_renamed.get(0);
                } else if (!z2) {
                    aVar = this.j_renamed.remove(1);
                } else {
                    aVar = gVar.s_renamed() != 0 ? new com.oplus.camera.gl_renamed.t_renamed.a_renamed(this.w_renamed, this.x_renamed) : new com.oplus.camera.gl_renamed.t_renamed.a_renamed(cameraApsResult, hVar, new float[16]);
                }
                com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f4669a;
                if (z_renamed) {
                    this.ag_renamed = sVar;
                }
                if (sVar != null) {
                    aVar.f4669a = this.u_renamed.a_renamed(hVar, gVar, sVar, z_renamed);
                    aVar.f4669a.a_renamed(cameraApsResult != null ? cameraApsResult.getCaptureResult() : null);
                    if (z_renamed) {
                        this.ag_renamed = aVar.f4669a;
                    }
                } else {
                    aVar.f4670b.addRef();
                    a_renamed(aVar.d_renamed);
                }
                if (z_renamed && this.j_renamed.add(aVar) && this.j_renamed.size() > iO) {
                    this.j_renamed.remove(1).c_renamed();
                }
                n_renamed();
            }
        }
    }

    private com.oplus.camera.gl_renamed.t_renamed.a_renamed a_renamed(java.lang.Integer num) {
        com.oplus.camera.gl_renamed.t_renamed.a_renamed aVar;
        if (!this.j_renamed.isEmpty() && num != null) {
            int size = this.j_renamed.size();
            long jB = b_renamed(num.intValue());
            com.oplus.camera.e_renamed.c_renamed("SurfaceTextureScreenNail", "peekMatchedPreview, which: " + num + ", timestamp: " + jB + ", cache size: " + size);
            if (f4665a == num) {
                synchronized (this.s_renamed) {
                    com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar = this.t_renamed.get(com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed);
                    com.oplus.camera.gl_renamed.t_renamed.a_renamed aVar2 = this.j_renamed.get(size - 1);
                    aVar = this.j_renamed.get(0);
                    if (aVar2.b_renamed() > aVar.b_renamed()) {
                        aVar = aVar2;
                    }
                    if ((bVar == null || bVar.g_renamed) && aVar.b_renamed() < jB) {
                        aVar = null;
                    }
                }
                return aVar;
            }
            for (int i2 = 1; i2 < size; i2++) {
                if (this.j_renamed.get(i2).a_renamed() == jB) {
                    return this.j_renamed.get(i2);
                }
            }
            int i3 = 1;
            while (i3 < size - 1) {
                com.oplus.camera.gl_renamed.t_renamed.a_renamed aVar3 = this.j_renamed.get(i3);
                i3++;
                com.oplus.camera.gl_renamed.t_renamed.a_renamed aVar4 = this.j_renamed.get(i3);
                if (aVar3.a_renamed() < jB && jB < aVar4.a_renamed()) {
                    return jB - aVar3.a_renamed() < aVar4.a_renamed() - jB ? aVar3 : aVar4;
                }
            }
            if (size > 1 && this.j_renamed.get(1).a_renamed() >= jB) {
                return this.j_renamed.get(1);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0022 A_renamed[Catch: all -> 0x01cd, TryCatch #2 {, blocks: (B_renamed:6:0x0006, B_renamed:8:0x000d, B_renamed:14:0x001b, B_renamed:16:0x0022, B_renamed:18:0x0046, B_renamed:20:0x004c, B_renamed:30:0x00f6, B_renamed:32:0x00fa, B_renamed:33:0x0103, B_renamed:38:0x0113, B_renamed:40:0x0119, B_renamed:42:0x0121, B_renamed:73:0x01c7, B_renamed:21:0x0070, B_renamed:22:0x007e, B_renamed:24:0x008a, B_renamed:26:0x0092, B_renamed:28:0x009e, B_renamed:29:0x00b8, B_renamed:43:0x0149, B_renamed:45:0x014d, B_renamed:46:0x0154, B_renamed:47:0x0156, B_renamed:51:0x0162, B_renamed:57:0x0172, B_renamed:58:0x0179, B_renamed:61:0x017c, B_renamed:63:0x0186, B_renamed:64:0x018d, B_renamed:67:0x0190, B_renamed:69:0x0194, B_renamed:71:0x019a, B_renamed:72:0x01bc, B_renamed:78:0x01cc, B_renamed:10:0x0011, B_renamed:12:0x0017, B_renamed:48:0x0157, B_renamed:50:0x0161, B_renamed:54:0x0165, B_renamed:55:0x016f), top: B_renamed:87:0x0006, outer: #0, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x0149 A_renamed[Catch: all -> 0x01cd, TryCatch #2 {, blocks: (B_renamed:6:0x0006, B_renamed:8:0x000d, B_renamed:14:0x001b, B_renamed:16:0x0022, B_renamed:18:0x0046, B_renamed:20:0x004c, B_renamed:30:0x00f6, B_renamed:32:0x00fa, B_renamed:33:0x0103, B_renamed:38:0x0113, B_renamed:40:0x0119, B_renamed:42:0x0121, B_renamed:73:0x01c7, B_renamed:21:0x0070, B_renamed:22:0x007e, B_renamed:24:0x008a, B_renamed:26:0x0092, B_renamed:28:0x009e, B_renamed:29:0x00b8, B_renamed:43:0x0149, B_renamed:45:0x014d, B_renamed:46:0x0154, B_renamed:47:0x0156, B_renamed:51:0x0162, B_renamed:57:0x0172, B_renamed:58:0x0179, B_renamed:61:0x017c, B_renamed:63:0x0186, B_renamed:64:0x018d, B_renamed:67:0x0190, B_renamed:69:0x0194, B_renamed:71:0x019a, B_renamed:72:0x01bc, B_renamed:78:0x01cc, B_renamed:10:0x0011, B_renamed:12:0x0017, B_renamed:48:0x0157, B_renamed:50:0x0161, B_renamed:54:0x0165, B_renamed:55:0x016f), top: B_renamed:87:0x0006, outer: #0, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n_renamed() {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.t_renamed.n_renamed():void");
    }

    private boolean b_renamed(java.lang.String str) {
        boolean z_renamed;
        synchronized (this.s_renamed) {
            z_renamed = !this.j_renamed.isEmpty() && this.t_renamed.containsKey(str);
        }
        return z_renamed;
    }

    public boolean h_renamed() {
        return this.y_renamed;
    }

    public void g_renamed(boolean z_renamed) {
        this.y_renamed = z_renamed;
    }

    private void a_renamed(java.lang.String str, com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, java.lang.Integer num, long j_renamed) throws java.io.IOException {
        java.util.HashMap<java.lang.String, com.oplus.camera.gl_renamed.t_renamed.b_renamed> map;
        java.lang.Integer num2;
        com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar;
        android.graphics.Bitmap bitmapC;
        long j2;
        android.graphics.Bitmap bitmapC2;
        com.oplus.camera.e_renamed.a_renamed("CameraCapturePerformance.capturePreview", "11ct_capturePreview", com.oplus.camera.d_renamed.d_renamed.longValue());
        synchronized (this.s_renamed) {
            map = this.t_renamed;
        }
        com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar2 = map.get(str);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int iH = sVar.h_renamed();
        int i2 = sVar.i_renamed();
        if (com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c.equals(str) || com.oplus.camera.gl_renamed.t_renamed.b_renamed.f_renamed.equals(str)) {
            num2 = num;
            bVar = bVar2;
            bitmapC = com.oplus.camera.util.Util.c_renamed(sVar.e_renamed(), iH, i2);
            j2 = 0;
        } else if (com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed.equals(str) && bVar2 != null && num != null) {
            if (f4665a == num) {
                this.n_renamed.a_renamed(iH, i2, bVar2.b_renamed(), bVar2.a_renamed());
                bVar2.a_renamed(this.n_renamed.a_renamed(sVar.e_renamed(), iH, i2));
            }
            if (this.G_renamed == 270) {
                bitmapC2 = com.oplus.camera.util.Util.c_renamed(this.o_renamed.a_renamed(sVar), iH, i2);
            } else {
                bitmapC2 = com.oplus.camera.util.Util.c_renamed(sVar.e_renamed(), iH, i2);
            }
            android.graphics.Bitmap bitmap = bitmapC2;
            long j3 = bVar2.g_renamed ? sVar.j_renamed() : 0L;
            a_renamed(num.intValue(), 0L, 0L);
            num2 = num;
            bVar = bVar2;
            j2 = j3;
            bitmapC = bitmap;
        } else {
            if (com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed.equals(str) && bVar2 != null) {
                int i3 = iH / 20;
                int i4 = i2 / 20;
                synchronized (this) {
                    if (this.L_renamed != null && this.H_renamed) {
                        float[] fArr = new float[16];
                        android.opengl.Matrix.setIdentityM(fArr, 0);
                        a_renamed(hVar, this.L_renamed.f_renamed(), sVar, fArr);
                    }
                }
                android.graphics.Bitmap bitmapC3 = com.oplus.camera.util.Util.c_renamed(a_renamed(sVar.e_renamed(), i3, i4, 10), i3, i4);
                i_renamed();
                num2 = num;
                bVar = bVar2;
                bVar2.a_renamed(num, bitmapC3, 0L, 0L, null);
                g_renamed(true);
                a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed);
            } else {
                num2 = num;
                bVar = bVar2;
                if (com.oplus.camera.util.Util.b_renamed()) {
                    com.oplus.camera.util.Util.a_renamed(sVar.e_renamed(), iH, i2, "preview");
                }
            }
            j2 = 0;
            bitmapC = null;
        }
        if (bVar != null && bitmapC != null) {
            bVar.a_renamed(num, bitmapC, j_renamed, j2, f4666b == num2 ? sVar.s_renamed() : null);
            if (!com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed.equals(str) || !bVar.g_renamed) {
                a_renamed(str);
            }
        }
        com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "capturePreview, type: " + str + ", rawTexture: " + sVar + ", which: " + num2 + ", dump bitmap use time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        com.oplus.camera.e_renamed.d_renamed("CameraCapturePerformance.capturePreview", "11ct_capturePreview");
    }

    public void a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult, boolean z_renamed) {
        if (this.C_renamed == 0) {
            com.oplus.camera.e_renamed.a_renamed("SurfaceTextureScreenNail", "addImageBuffer, result: " + cameraApsResult);
        }
        synchronized (this.ac_renamed) {
            if (z_renamed) {
                for (com.oplus.camera.aps.util.CameraApsResult cameraApsResult2 : this.aa_renamed) {
                    if (cameraApsResult2 != null) {
                        cameraApsResult2.closeImageBuffer();
                        com.oplus.camera.perf.FluencyPerformance.c_renamed(cameraApsResult2.getTimestamp());
                    }
                }
                this.aa_renamed.clear();
                this.u_renamed.a_renamed();
                if (this.aa_renamed.size() > this.af_renamed && !a_renamed(this.aa_renamed.get(0)) && this.aa_renamed.get(0).getTimestamp() != b_renamed(f4665a.intValue())) {
                    com.oplus.camera.aps.util.CameraApsResult cameraApsResultRemove = this.aa_renamed.remove(0);
                    cameraApsResultRemove.closeImageBuffer();
                    com.oplus.camera.perf.FluencyPerformance.c_renamed(cameraApsResultRemove.getTimestamp());
                    com.oplus.camera.e_renamed.a_renamed("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame", com.oplus.camera.d_renamed.d_renamed.longValue());
                    com.oplus.camera.e_renamed.d_renamed("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame");
                    com.oplus.camera.e_renamed.f_renamed("SurfaceTextureScreenNail", "addImageBuffer, remove image: " + cameraApsResultRemove.getTimestamp());
                }
                this.aa_renamed.add(cameraApsResult);
            } else {
                if (this.aa_renamed.size() > this.af_renamed) {
                    com.oplus.camera.aps.util.CameraApsResult cameraApsResultRemove2 = this.aa_renamed.remove(0);
                    cameraApsResultRemove2.closeImageBuffer();
                    com.oplus.camera.perf.FluencyPerformance.c_renamed(cameraApsResultRemove2.getTimestamp());
                    com.oplus.camera.e_renamed.a_renamed("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame", com.oplus.camera.d_renamed.d_renamed.longValue());
                    com.oplus.camera.e_renamed.d_renamed("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame");
                    com.oplus.camera.e_renamed.f_renamed("SurfaceTextureScreenNail", "addImageBuffer, remove image: " + cameraApsResultRemove2.getTimestamp());
                }
                this.aa_renamed.add(cameraApsResult);
            }
        }
        onFrameAvailable(null);
    }

    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar, int i2, int i3, int i4, int i5) {
        synchronized (this) {
            if (!this.l_renamed.isEmpty() && !this.j_renamed.isEmpty()) {
                com.oplus.camera.statistics.model.PerformanceMsgData.getRealtimeFrameRate();
                if (!this.T_renamed) {
                    return false;
                }
                if (jVar != null) {
                    a_renamed(jVar);
                } else if (hVar != null) {
                    com.oplus.camera.e_renamed.a_renamed("Surfacetexture.draw", "68pv_SurfacetextureDraw", com.oplus.camera.d_renamed.d_renamed.longValue());
                    a_renamed(hVar, i2, i3, i4, i5);
                    if (this.L_renamed != null && this.H_renamed) {
                        if (!c_renamed(hVar, i2, i3, i4, i5)) {
                            return false;
                        }
                    } else {
                        d_renamed(hVar, i2, i3, i4, i5);
                    }
                    b_renamed(hVar, i2, i3, i4, i5);
                    com.oplus.camera.e_renamed.d_renamed("Surfacetexture.draw", "68pv_SurfacetextureDraw");
                }
                return true;
            }
            return false;
        }
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i2, int i3, int i4, int i5) {
        android.graphics.SurfaceTexture surfaceTexture;
        android.graphics.SurfaceTexture surfaceTexture2 = this.R_renamed;
        if (surfaceTexture2 != null) {
            surfaceTexture2.attachToGLContext(this.l_renamed.get(0).e_renamed());
        }
        hVar.a_renamed(2);
        hVar.a_renamed(i2 + (i4 / 2), i3 + (i5 / 2));
        if (this.W_renamed) {
            if (this.X_renamed - 0.0f < 0.001f) {
                this.X_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_PREVIEW_SCALE);
            }
            float f_renamed = this.X_renamed;
            hVar.a_renamed(f_renamed, -f_renamed, 1.0f);
        } else if (this.u_renamed.l_renamed()) {
            hVar.a_renamed(this.u_renamed.m_renamed(), -this.u_renamed.n_renamed(), 1.0f);
        } else {
            hVar.a_renamed(1.0f, -1.0f, 1.0f);
        }
        if (this.G_renamed != 90) {
            hVar.a_renamed(((r7 - 90) + 360) % 360, 0.0f, 0.0f, 1.0f);
        }
        hVar.a_renamed(-r5, -r6);
        android.graphics.SurfaceTexture surfaceTexture3 = this.R_renamed;
        if (surfaceTexture3 != null) {
            surfaceTexture3.updateTexImage();
        }
        a_renamed(this.F_renamed);
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && (surfaceTexture = this.R_renamed) != null) {
            this.C_renamed = surfaceTexture.getTimestamp();
        }
        this.u_renamed.b_renamed(this.C_renamed);
        this.u_renamed.a_renamed(this.F_renamed);
    }

    private void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i2, int i3, int i4, int i5) throws java.io.IOException {
        a_renamed(0);
        boolean zB = com.oplus.camera.util.Util.b_renamed();
        boolean zB2 = b_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c);
        boolean zB3 = b_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f_renamed);
        boolean zB4 = b_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed);
        if (this.E_renamed && (zB3 || zB || zB2 || zB4)) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.j_renamed.get(0).f4669a;
            this.u_renamed.a_renamed(hVar, this.l_renamed.get(0), sVar, false);
            if (zB) {
                this.u_renamed.a_renamed(hVar, this.l_renamed.get(0), sVar, false);
                a_renamed((java.lang.String) null, hVar, sVar, (java.lang.Integer) null, 0L);
            } else {
                a_renamed(hVar, this.l_renamed.get(0), sVar, this.F_renamed);
            }
            if (zB3) {
                a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f_renamed, hVar, sVar, (java.lang.Integer) null, 0L);
            }
            if (zB2) {
                a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c, hVar, sVar, (java.lang.Integer) null, 0L);
            }
            if (zB4) {
                a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed, hVar, sVar, (java.lang.Integer) null, 0L);
            }
        }
        hVar.f_renamed();
        this.u_renamed.a_renamed(hVar, i2, i3, i4, i5);
        android.graphics.SurfaceTexture surfaceTexture = this.R_renamed;
        if (surfaceTexture != null) {
            surfaceTexture.detachFromGLContext();
        }
    }

    private void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar) {
        android.graphics.SurfaceTexture surfaceTexture = this.R_renamed;
        if (surfaceTexture != null) {
            surfaceTexture.attachToGLContext(this.l_renamed.get(1).e_renamed());
        }
        synchronized (this.k_renamed) {
            if (this.ab_renamed != null && !this.ab_renamed.getHardwareBuffer().isClosed()) {
                com.oplus.camera.jni.PreviewShow.process(this.ab_renamed.getHardwareBuffer(), 36197, this.l_renamed.get(1).e_renamed(), this.ad_renamed);
            }
            jVar.b_renamed(this.l_renamed.get(1).e_renamed());
        }
        android.graphics.SurfaceTexture surfaceTexture2 = this.R_renamed;
        if (surfaceTexture2 != null) {
            surfaceTexture2.detachFromGLContext();
        }
    }

    private boolean c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i2, int i3, int i4, int i5) {
        synchronized (this.k_renamed) {
            if (this.J_renamed != null && this.K_renamed != null && !this.J_renamed.getHardwareBuffer().isClosed() && !this.K_renamed.getHardwareBuffer().isClosed()) {
                i_renamed(this.H_renamed);
                com.oplus.camera.jni.PreviewShow.process(this.J_renamed.getHardwareBuffer(), 36197, this.L_renamed.c_renamed(), this.ad_renamed);
                com.oplus.camera.jni.PreviewShow.process(this.K_renamed.getHardwareBuffer(), 36197, this.L_renamed.d_renamed(), this.ad_renamed);
                android.util.Size size = new android.util.Size(this.K_renamed.getWidth(), this.K_renamed.getHeight());
                android.util.Size size2 = new android.util.Size(this.J_renamed.getWidth(), this.J_renamed.getHeight());
                this.u_renamed.b_renamed(this.K_renamed.getTimestamp());
                this.L_renamed.e_renamed().b_renamed(true);
                if (this.u_renamed.b_renamed(hVar, this.L_renamed.e_renamed(), i2, i3, i4, i5, this.D_renamed)) {
                    this.L_renamed.a_renamed(hVar, this.u_renamed.j_renamed(4).g_renamed().e_renamed(), this.L_renamed.c_renamed(), size, size2, this.M_renamed.m_renamed(), true, this.M_renamed);
                } else {
                    this.L_renamed.a_renamed(hVar, this.L_renamed.d_renamed(), this.L_renamed.c_renamed(), size, size2, this.M_renamed.m_renamed(), false, this.M_renamed);
                }
                this.J_renamed.close();
                this.K_renamed.close();
                this.J_renamed = null;
                this.K_renamed = null;
                this.d_renamed = true;
            } else if (this.L_renamed.f_renamed() != null) {
                float[] fArr = new float[16];
                android.opengl.Matrix.setIdentityM(fArr, 0);
                hVar.a_renamed(this.L_renamed.f_renamed(), fArr, i2, i3, i4, i5);
            }
        }
        return true;
    }

    private void a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult, com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar) {
        com.oplus.camera.ui.preview.h_renamed.b_renamed bVar = this.r_renamed;
        if (bVar == null || !bVar.a_renamed()) {
            return;
        }
        if (this.ah_renamed == null) {
            this.ah_renamed = new com.oplus.camera.ui.preview.y_renamed();
        }
        this.ah_renamed.a_renamed(this.u_renamed);
        this.ah_renamed.a_renamed(this.r_renamed);
        this.ah_renamed.a_renamed(f_renamed(), g_renamed());
        this.ah_renamed.a_renamed(cameraApsResult, hVar, gVar);
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i2, int i3, int i4, int i5) {
        com.oplus.camera.ui.preview.y_renamed yVar = this.ah_renamed;
        if (yVar != null) {
            yVar.a_renamed(hVar, gVar, i2, i3, i4, i5);
        }
    }

    private boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (!ai_renamed.a_renamed()) {
            return false;
        }
        float fB_renamed = ai_renamed.b_renamed();
        hVar.c_renamed();
        hVar.a_renamed(fB_renamed);
        return true;
    }

    private void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        hVar.f_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d_renamed(com.oplus.camera.gl_renamed.h_renamed r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.t_renamed.d_renamed(com.oplus.camera.gl_renamed.h_renamed, int, int, int, int):void");
    }

    private final boolean a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult) {
        synchronized (this.s_renamed) {
            if (this.A_renamed) {
                return true;
            }
            if (this.P_renamed.isEmpty()) {
                return false;
            }
            if (cameraApsResult != null && cameraApsResult.getCaptureResult() != null && cameraApsResult.getCaptureResult().getFrameNumber() > this.Q_renamed + 3) {
                return false;
            }
            return true;
        }
    }

    private int o_renamed() {
        int i2;
        synchronized (this.s_renamed) {
            if (a_renamed((com.oplus.camera.aps.util.CameraApsResult) null)) {
                i2 = 25;
            } else {
                i2 = this.z_renamed ? 6 : 1;
            }
        }
        return i2;
    }

    private final boolean b_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult) {
        boolean z_renamed;
        synchronized (this.s_renamed) {
            z_renamed = a_renamed(cameraApsResult) || this.z_renamed;
        }
        return z_renamed;
    }

    private final boolean p_renamed() {
        boolean z_renamed;
        synchronized (this.s_renamed) {
            long jB = b_renamed(f4665a.intValue());
            com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar = this.t_renamed.get(com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed);
            z_renamed = (this.C_renamed >= jB && jB > 0) || !(bVar == null || bVar.g_renamed);
        }
        return z_renamed;
    }

    private final boolean q_renamed() {
        return b_renamed(f4666b.intValue()) > 0 && b_renamed(f4665a.intValue()) == 0;
    }

    public void j_renamed() {
        if (this.R_renamed == null || this.l_renamed.isEmpty()) {
            return;
        }
        this.R_renamed.attachToGLContext(this.l_renamed.get(0).e_renamed());
        this.R_renamed.updateTexImage();
        this.R_renamed.getTransformMatrix(this.F_renamed);
        this.R_renamed.detachFromGLContext();
    }

    public void k_renamed() {
        android.graphics.SurfaceTexture surfaceTexture = this.R_renamed;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public boolean l_renamed() {
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.u_renamed;
        if (tVar != null) {
            return tVar.f_renamed();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x0013 A_renamed[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B_renamed:8:0x000d, B_renamed:11:0x0018, B_renamed:12:0x0021, B_renamed:10:0x0013), top: B_renamed:17:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(float[] r4) {
        /*
            r3 = this;
            android.graphics.SurfaceTexture r0 = r3.R_renamed
            if (r0 == 0) goto L8
            r0.getTransformMatrix(r4)
            goto L22
        L8:
            float[] r0 = r3.S_renamed
            monitor-enter(r0)
            if (r4 == 0) goto L13
            int r1 = r4.length     // Catch: java.lang.Throwable -> L23
            float[] r2 = r3.S_renamed     // Catch: java.lang.Throwable -> L23
            int r2 = r2.length     // Catch: java.lang.Throwable -> L23
            if (r1 >= r2) goto L18
        L13:
            float[] r4 = r3.S_renamed     // Catch: java.lang.Throwable -> L23
            int r4 = r4.length     // Catch: java.lang.Throwable -> L23
            float[] r4 = new float[r4]     // Catch: java.lang.Throwable -> L23
        L18:
            float[] r1 = r3.S_renamed     // Catch: java.lang.Throwable -> L23
            float[] r3 = r3.S_renamed     // Catch: java.lang.Throwable -> L23
            int r3 = r3.length     // Catch: java.lang.Throwable -> L23
            r2 = 0
            java.lang.System.arraycopy(r1, r2, r4, r2, r3)     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
        L22:
            return
        L23:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.t_renamed.a_renamed(float[]):void");
    }

    public void a_renamed(android.media.Image image, int i2) {
        android.media.Image image2;
        synchronized (this.k_renamed) {
            try {
                if (1 == i2) {
                    if (this.J_renamed != null) {
                        this.J_renamed.close();
                    }
                    this.J_renamed = image;
                } else if (2 == i2) {
                    if (this.K_renamed != null) {
                        this.K_renamed.close();
                    }
                    this.K_renamed = image;
                }
                if (this.J_renamed != null && this.K_renamed != null) {
                    if (this.e_renamed && this.f_renamed) {
                        onFrameAvailable(null);
                        m_renamed();
                    } else {
                        if (1 == i2) {
                            image2 = this.J_renamed;
                            this.J_renamed = null;
                        } else if (2 == i2) {
                            image2 = this.K_renamed;
                            this.K_renamed = null;
                        } else {
                            image2 = null;
                        }
                        if (image2 != null) {
                            image2.close();
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public void m_renamed() {
        synchronized (this.s_renamed) {
            this.z_renamed = false;
            this.A_renamed = false;
            this.B_renamed.clear();
        }
        a_renamed(f4665a.intValue(), 0L, 0L);
        a_renamed(f4666b.intValue(), 0L, 0L);
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.gl_renamed.s_renamed sVar, float[] fArr) {
        if (sVar == null) {
            return;
        }
        if (!sVar.n_renamed()) {
            sVar.c_renamed(hVar);
        }
        int iF = sVar.f_renamed();
        int iG = sVar.g_renamed();
        hVar.a_renamed(sVar);
        hVar.a_renamed(0.0f, iG);
        hVar.a_renamed(1.0f, -1.0f, 1.0f);
        hVar.a_renamed(gVar, fArr, 0, 0, iF, iG);
        hVar.h_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.s_renamed sVar2, float[] fArr) {
        if (sVar2 == null || hVar == null) {
            return;
        }
        if (!sVar2.n_renamed()) {
            sVar2.c_renamed(hVar);
        }
        int iF = sVar2.f_renamed();
        int iG = sVar2.g_renamed();
        if (!com.oplus.camera.util.Util.C_renamed()) {
            android.opengl.GLES20.glFinish();
        }
        hVar.a_renamed(sVar2);
        hVar.a_renamed(0.0f, iG);
        hVar.a_renamed(1.0f, -1.0f, 1.0f);
        a_renamed(this.F_renamed);
        if (fArr == null) {
            fArr = this.F_renamed;
        }
        hVar.a_renamed(sVar, fArr, 0, 0, iF, iG);
        hVar.h_renamed();
        sVar2.a_renamed(sVar.j_renamed());
        sVar2.b_renamed(sVar.k_renamed());
        sVar2.a_renamed(sVar.s_renamed());
    }

    public void h_renamed(boolean z_renamed) {
        com.oplus.camera.gl_renamed.b_renamed.f_renamed fVar = this.L_renamed;
        if (fVar != null) {
            fVar.a_renamed(z_renamed);
        }
    }

    public void i_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.I_renamed = z_renamed;
        }
    }

    public void a_renamed(com.oplus.camera.screen.out.e_renamed eVar) {
        com.oplus.camera.e_renamed.b_renamed("SurfaceTextureScreenNail", "setPresentation: " + eVar);
        this.V_renamed.lock();
        this.U_renamed = eVar;
        this.V_renamed.unlock();
    }

    /* compiled from: SurfaceTextureScreenNail.java */
    private static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f4673a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public long f4674b;

        public c_renamed(long j_renamed, long j2) {
            this.f4673a = 0L;
            this.f4674b = 0L;
            this.f4673a = j_renamed;
            this.f4674b = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SurfaceTextureScreenNail.java */
    protected static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public com.oplus.camera.gl_renamed.s_renamed f4669a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public com.oplus.camera.aps.util.CameraApsResult f4670b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public com.oplus.camera.gl_renamed.h_renamed f4671c;
        public float[] d_renamed;

        public a_renamed(int i_renamed, int i2) {
            this.f4669a = null;
            this.f4670b = null;
            this.f4671c = null;
            this.d_renamed = null;
            this.f4669a = new com.oplus.camera.gl_renamed.s_renamed(i_renamed, i2, true);
        }

        public a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult, com.oplus.camera.gl_renamed.h_renamed hVar, float[] fArr) {
            this.f4669a = null;
            this.f4670b = null;
            this.f4671c = null;
            this.d_renamed = null;
            this.f4670b = cameraApsResult;
            this.f4671c = hVar;
            this.d_renamed = fArr;
        }

        public long a_renamed() {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.f4669a;
            if (sVar != null) {
                return sVar.j_renamed();
            }
            com.oplus.camera.aps.util.CameraApsResult cameraApsResult = this.f4670b;
            if (cameraApsResult != null) {
                return cameraApsResult.getTimestamp();
            }
            return 0L;
        }

        public long b_renamed() {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.f4669a;
            if (sVar != null) {
                return sVar.k_renamed();
            }
            com.oplus.camera.aps.util.CameraApsResult cameraApsResult = this.f4670b;
            if (cameraApsResult != null) {
                return cameraApsResult.getTimestamp();
            }
            return 0L;
        }

        public void c_renamed() {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.f4669a;
            if (sVar != null) {
                sVar.o_renamed();
                this.f4669a = null;
            }
            com.oplus.camera.aps.util.CameraApsResult cameraApsResult = this.f4670b;
            if (cameraApsResult != null) {
                cameraApsResult.closeImageBuffer();
                this.f4670b = null;
            }
        }

        public java.lang.String toString() {
            return "{mRawTexture: " + this.f4669a + ", mCameraApsResult: " + this.f4670b + ", mTransForm: " + this.d_renamed + "}";
        }
    }
}
