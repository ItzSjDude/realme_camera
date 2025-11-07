package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: TiltShiftTexturePreview.java */
/* loaded from: classes2.dex */
public class ab_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6836a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f6837b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6838c;
    private int d_renamed;
    private int k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.gl_renamed.s_renamed m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private com.oplus.camera.tiltshift.TiltShiftPreview p_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;

    /* compiled from: TiltShiftTexturePreview.java */
    enum a_renamed {
        BLUR_LEVEL,
        WIDTH_SCALE,
        HEIGHT_SCALE,
        MIN_AREA_SIZE,
        EROSION_VALUE,
        ROTATION_ANGLE
    }

    private int a_renamed(int i_renamed, boolean z_renamed) {
        if (z_renamed) {
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

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 512;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public ab_renamed(android.content.Context context) {
        super(context);
        this.f6837b = new java.lang.Object();
        this.f6838c = 0;
        this.d_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = false;
        this.s_renamed = false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (this.f6837b) {
            if (this.q_renamed == null) {
                return false;
            }
            if (!this.q_renamed.d_renamed()) {
                return false;
            }
            if (this.s_renamed) {
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        int iA;
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.q_renamed == null || aVar == null || aVar.f6977c == null || this.l_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "process, false");
            return false;
        }
        synchronized (this.f6837b) {
            if (!this.r_renamed) {
                com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "process, not create, so return!");
                return false;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
            int iH = sVar.h_renamed();
            int i_renamed = sVar.i_renamed();
            boolean z_renamed = this.g_renamed;
            synchronized (this.f6837b) {
                if (this.n_renamed && !q_renamed()) {
                    com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "process, inTextureWidth: " + i_renamed + ", inTextureHeight: " + iH);
                    a_renamed(i_renamed, iH, z_renamed);
                    this.n_renamed = false;
                }
                iA = a_renamed(i_renamed, iH, sVar.e_renamed(), new int[]{this.l_renamed.e_renamed()}, z_renamed, a_renamed(this.k_renamed, z_renamed), this.q_renamed.I_renamed());
            }
            this.o_renamed = iA == 0;
            boolean z2 = iA == 0;
            f6836a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
            return z2;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean y_renamed() {
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "createEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ab_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.f6837b) {
                    if (com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.q_renamed()) {
                        com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.p_renamed = new com.oplus.camera.tiltshift.TiltShiftPreview();
                    }
                    com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.r_renamed = true;
                    com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.q_renamed = aaVar;
                    com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "createEngine X_renamed");
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "destroyEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ab_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.f6837b) {
                    if (com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.p_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.h_renamed.g_renamed();
                        com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.p_renamed.destory();
                        com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.p_renamed = null;
                    }
                    com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.q_renamed = null;
                    com.oplus.camera.ui.preview.a_renamed.ab_renamed.this.r_renamed = false;
                    com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "destroyEngine X_renamed");
                }
            }
        });
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
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "newTextures");
        this.m_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6838c, this.d_renamed, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6838c, this.d_renamed, true);
        this.s_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.m_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "prepareTextures, mInputTiltShiftTexture.getId: " + this.m_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.l_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "prepareTextures, mOutputTiltShiftTexture.getId: " + this.l_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "recycleTextures");
        if (this.s_renamed) {
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
            this.s_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6838c = i2;
        this.d_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (this.f6837b) {
            this.n_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (q_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", "initTiltShift, width: " + i_renamed + ", height: " + i2 + ", isFrontCamera: " + z_renamed);
        int iInit = this.p_renamed.init(i2, i_renamed, 1, 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("initTiltShift, X_renamed, initResult: ");
        sb.append(iInit);
        com.oplus.camera.e_renamed.a_renamed("TiltShiftTexturePreview", sb.toString());
    }

    private int a_renamed(int i_renamed, int i2, int i3, int[] iArr, boolean z_renamed, int i4, android.graphics.Point point) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.q_renamed;
        if (aaVar == null) {
            return -1;
        }
        com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParamE = aaVar.e_renamed();
        if (q_renamed() || iArr == null || tiltShiftParamE == null) {
            return -1;
        }
        java.lang.System.currentTimeMillis();
        int[] iArr2 = new int[1];
        this.p_renamed.setDebugMask(tiltShiftParamE.isAdjusting());
        this.p_renamed.setParam(com.oplus.camera.ui.preview.a_renamed.ab_renamed.a_renamed.BLUR_LEVEL.ordinal(), this.q_renamed.f_renamed());
        this.p_renamed.setParam(com.oplus.camera.ui.preview.a_renamed.ab_renamed.a_renamed.ROTATION_ANGLE.ordinal(), i4);
        this.p_renamed.getMaskTexture(i_renamed, i2, tiltShiftParamE.getCenterX(), tiltShiftParamE.getCenterY(), tiltShiftParamE.getInnerDistance(), tiltShiftParamE.getAngle(), tiltShiftParamE.isCircle(), iArr2);
        int iProcess = this.p_renamed.process(i3, iArr2[0], iArr);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        return iProcess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q_renamed() {
        return this.p_renamed == null;
    }
}
