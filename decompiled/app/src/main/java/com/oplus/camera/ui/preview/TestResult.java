package com.oplus.camera.ui.preview;

/* compiled from: CameraScreenNail.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.gl_renamed.t_renamed {
    private boolean V_renamed;
    private boolean W_renamed;
    private android.content.Context ab_renamed;
    private com.oplus.camera.ui.preview.c_renamed ad_renamed;
    private final float[] R_renamed = new float[16];
    private int S_renamed = 0;
    private float T_renamed = 0.0f;
    private float U_renamed = 0.0f;
    private boolean X_renamed = false;
    private boolean Y_renamed = true;
    private boolean Z_renamed = false;
    private boolean aa_renamed = false;
    private com.oplus.camera.ui.preview.ad_renamed ac_renamed = new com.oplus.camera.ui.preview.ad_renamed();
    private com.oplus.camera.gl_renamed.s_renamed ae_renamed = null;
    private com.oplus.camera.gl_renamed.s_renamed af_renamed = null;
    private com.oplus.camera.gl_renamed.d_renamed ag_renamed = null;
    private com.oplus.camera.ui.preview.h_renamed.d_renamed ah_renamed = null;
    private com.oplus.camera.ui.preview.h_renamed.a_renamed ai_renamed = null;
    private com.oplus.camera.gl_renamed.a_renamed.b_renamed aj_renamed = null;
    private com.oplus.camera.gl_renamed.a_renamed.a_renamed ak_renamed = null;
    private int al_renamed = 0;
    private int am_renamed = 0;
    private long an_renamed = 0;
    private int ao_renamed = 0;
    private android.util.Size ap_renamed = null;
    private float[] aq_renamed = null;
    private com.oplus.camera.ui.preview.d_renamed ar_renamed = new com.oplus.camera.ui.preview.d_renamed();
    private boolean as_renamed = false;
    private java.lang.Runnable at_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.h_renamed.5
        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.ui.preview.h_renamed.this.q_renamed.ab_renamed();
        }
    };

    /* compiled from: CameraScreenNail.java */
    public interface a_renamed {
        void a_renamed();
    }

    /* compiled from: CameraScreenNail.java */
    public interface b_renamed {
        float a_renamed(float f_renamed);

        boolean a_renamed();

        void b_renamed();
    }

    /* compiled from: CameraScreenNail.java */
    public interface c_renamed {
        void Z_renamed();

        void aa_renamed();

        void ab_renamed();

        void ac_renamed();
    }

    /* compiled from: CameraScreenNail.java */
    public interface d_renamed {
        int a_renamed(int i_renamed);

        void a_renamed();

        void b_renamed();

        void c_renamed();

        void d_renamed();
    }

    public h_renamed(android.content.Context context, com.oplus.camera.ui.preview.h_renamed.c_renamed cVar, boolean z_renamed) {
        this.W_renamed = false;
        this.ab_renamed = null;
        this.ad_renamed = null;
        synchronized (this.k_renamed) {
            this.ab_renamed = context;
            this.q_renamed = cVar;
            this.ad_renamed = new com.oplus.camera.ui.preview.aa_renamed();
            this.W_renamed = z_renamed ? false : true;
            this.M_renamed.a_renamed(com.oplus.camera.util.Util.getScreenWidth());
            this.M_renamed.b_renamed(com.oplus.camera.util.Util.getScreenHeight());
            this.M_renamed.c_renamed(com.oplus.camera.util.Util.getSettingMenuPanelHeight());
        }
    }

    public void n_renamed() {
        synchronized (this.k_renamed) {
            this.E_renamed = false;
        }
    }

    public boolean o_renamed() {
        return this.E_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public void d_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.X_renamed = false;
            super.d_renamed(z_renamed);
            this.ae_renamed = new com.oplus.camera.gl_renamed.s_renamed(f_renamed(), g_renamed(), true);
        }
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public void a_renamed(int i_renamed, int i2) {
        super.a_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public void d_renamed() {
        synchronized (this.k_renamed) {
            super.d_renamed();
            C_renamed();
            this.ar_renamed.b_renamed();
            d_renamed(0);
        }
    }

    public void p_renamed() {
        if (this.M_renamed != null) {
            this.M_renamed.a_renamed(com.oplus.camera.util.Util.getScreenWidth());
            this.M_renamed.b_renamed(com.oplus.camera.util.Util.getScreenHeight());
            this.M_renamed.c_renamed(com.oplus.camera.util.Util.getSettingMenuPanelHeight());
        }
    }

    public void q_renamed() {
        this.u_renamed.i_renamed();
        this.ai_renamed = null;
        this.v_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.h_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.preview.h_renamed.this.n_renamed != null) {
                    com.oplus.camera.ui.preview.h_renamed.this.n_renamed.a_renamed();
                }
                if (com.oplus.camera.ui.preview.h_renamed.this.o_renamed != null) {
                    com.oplus.camera.ui.preview.h_renamed.this.o_renamed.b_renamed();
                }
                if (com.oplus.camera.ui.preview.h_renamed.this.aj_renamed != null) {
                    com.oplus.camera.ui.preview.h_renamed.this.aj_renamed.c_renamed();
                    com.oplus.camera.ui.preview.h_renamed.this.aj_renamed = null;
                }
                if (com.oplus.camera.ui.preview.h_renamed.this.ak_renamed != null) {
                    com.oplus.camera.ui.preview.h_renamed.this.ak_renamed.b_renamed();
                    com.oplus.camera.ui.preview.h_renamed.this.ak_renamed = null;
                }
                synchronized (this) {
                    if (com.oplus.camera.ui.preview.h_renamed.this.L_renamed != null) {
                        com.oplus.camera.ui.preview.h_renamed.this.L_renamed.b_renamed();
                        com.oplus.camera.ui.preview.h_renamed.this.L_renamed = null;
                    }
                }
            }
        });
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.d_renamed dVar) {
        this.ah_renamed = dVar;
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.a_renamed aVar) {
        this.ai_renamed = aVar;
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.b_renamed bVar) {
        this.r_renamed = bVar;
    }

    public void a_renamed(android.util.Size size, android.util.Size size2) {
        if (this.aj_renamed == null) {
            return;
        }
        if (!x_renamed()) {
            this.aj_renamed.a_renamed(size, size2);
            this.ap_renamed = size;
        } else {
            android.util.Size size3 = this.ap_renamed;
            if (size3 != null) {
                this.aj_renamed.a_renamed(size3, size2);
            }
        }
        synchronized (this.k_renamed) {
            if (this.S_renamed == 0 || this.S_renamed == 15) {
                this.q_renamed.Z_renamed();
                d_renamed(13);
            }
        }
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraScreenNail", "setGaussianBlurBitmap");
        this.al_renamed = i_renamed;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.ag_renamed = new com.oplus.camera.gl_renamed.d_renamed(bitmap);
            synchronized (this.k_renamed) {
                this.q_renamed.Z_renamed();
                d_renamed(5);
            }
            return;
        }
        d_renamed(0);
        this.ah_renamed.d_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public int a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.ak_renamed.b_renamed(i2, i3);
        this.ak_renamed.a_renamed(i2, i3);
        this.ak_renamed.a_renamed(i4);
        return this.ak_renamed.a_renamed(i_renamed, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4580a), com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4581b));
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public void i_renamed() {
        this.ak_renamed.a_renamed();
    }

    private void C_renamed() {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.af_renamed;
        if (sVar != null) {
            sVar.p_renamed();
            this.af_renamed = null;
        }
        com.oplus.camera.gl_renamed.a_renamed.b_renamed bVar = this.aj_renamed;
        if (bVar != null) {
            bVar.b_renamed();
        }
    }

    public void r_renamed() {
        if (this.u_renamed != null) {
            this.u_renamed.b_renamed();
        }
        if (this.aj_renamed == null) {
            this.aj_renamed = new com.oplus.camera.gl_renamed.a_renamed.b_renamed();
        }
        if (this.ak_renamed == null) {
            this.ak_renamed = new com.oplus.camera.gl_renamed.a_renamed.a_renamed();
        }
        this.n_renamed = new com.oplus.camera.gl_renamed.p_renamed();
        this.o_renamed = new com.oplus.camera.gl_renamed.w_renamed();
        if (this.L_renamed == null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.L_renamed = new com.oplus.camera.gl_renamed.b_renamed.f_renamed();
        }
        if (this.L_renamed != null) {
            this.L_renamed.a_renamed();
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        if (this.u_renamed != null) {
            this.u_renamed.a_renamed(i_renamed, i2);
        }
    }

    public void j_renamed(boolean z_renamed) {
        this.H_renamed = z_renamed;
    }

    public void s_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraScreenNail", "animateOpenEnd");
        this.T_renamed = 0.0f;
        synchronized (this.k_renamed) {
            d_renamed(0);
        }
    }

    public void t_renamed() {
        synchronized (this.k_renamed) {
            d_renamed(0);
        }
    }

    public void d_renamed(int i_renamed) {
        synchronized (this.k_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraScreenNail", "setAnimState, state: " + this.S_renamed + "->" + i_renamed);
            this.S_renamed = i_renamed;
        }
    }

    private void D_renamed() {
        if (this.E_renamed) {
            return;
        }
        this.E_renamed = true;
        this.aq_renamed = null;
        com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onFirstFrameDrawed");
        this.q_renamed.ac_renamed();
        com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onFirstFrameDrawed");
        com.oplus.camera.perf.b_renamed.c_renamed("launch_first_frame_draw");
        com.oplus.camera.e_renamed.f_renamed("CameraScreenNail", "CameraTest First Frame Draw");
    }

    private boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        if (!this.ar_renamed.a_renamed()) {
            return false;
        }
        this.ar_renamed.a_renamed(this.u_renamed, this.l_renamed.get(0), this.af_renamed, hVar, i_renamed, i2, i3, i4);
        return true;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        super.a_renamed(hVar, (com.oplus.camera.ui.menu.levelcontrol.j_renamed) null, i_renamed, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:100:0x0204 A_renamed[Catch: all -> 0x03ef, TryCatch #1 {, blocks: (B_renamed:4:0x000b, B_renamed:6:0x0010, B_renamed:7:0x002a, B_renamed:9:0x0033, B_renamed:11:0x003b, B_renamed:18:0x0047, B_renamed:200:0x03e8, B_renamed:20:0x004e, B_renamed:22:0x0057, B_renamed:24:0x006a, B_renamed:25:0x0073, B_renamed:27:0x0075, B_renamed:28:0x0087, B_renamed:30:0x0089, B_renamed:32:0x008f, B_renamed:33:0x009b, B_renamed:35:0x009d, B_renamed:37:0x00a1, B_renamed:39:0x00a7, B_renamed:40:0x00aa, B_renamed:42:0x00ac, B_renamed:110:0x023c, B_renamed:112:0x0244, B_renamed:114:0x0248, B_renamed:116:0x024c, B_renamed:118:0x0252, B_renamed:120:0x025b, B_renamed:122:0x0261, B_renamed:124:0x026a, B_renamed:126:0x027f, B_renamed:127:0x0287, B_renamed:129:0x028d, B_renamed:130:0x0292, B_renamed:132:0x02bc, B_renamed:134:0x02c0, B_renamed:136:0x02e3, B_renamed:143:0x02f8, B_renamed:145:0x02fd, B_renamed:147:0x0301, B_renamed:149:0x0307, B_renamed:151:0x031f, B_renamed:153:0x032d, B_renamed:155:0x032f, B_renamed:157:0x0336, B_renamed:159:0x033b, B_renamed:161:0x0341, B_renamed:165:0x034b, B_renamed:178:0x0382, B_renamed:179:0x0388, B_renamed:181:0x038e, B_renamed:183:0x0394, B_renamed:185:0x0398, B_renamed:187:0x039e, B_renamed:189:0x03a6, B_renamed:190:0x03b5, B_renamed:192:0x03b9, B_renamed:194:0x03d5, B_renamed:196:0x03de, B_renamed:195:0x03db, B_renamed:168:0x0351, B_renamed:170:0x0356, B_renamed:171:0x0360, B_renamed:173:0x0364, B_renamed:175:0x036a, B_renamed:137:0x02e7, B_renamed:138:0x02ee, B_renamed:139:0x02f3, B_renamed:123:0x0268, B_renamed:119:0x0259, B_renamed:55:0x00d5, B_renamed:57:0x00d9, B_renamed:59:0x00ee, B_renamed:65:0x0112, B_renamed:67:0x0121, B_renamed:69:0x0125, B_renamed:70:0x012e, B_renamed:88:0x018f, B_renamed:89:0x0190, B_renamed:60:0x00f6, B_renamed:62:0x00fe, B_renamed:64:0x0106, B_renamed:90:0x0195, B_renamed:98:0x01d4, B_renamed:100:0x0204, B_renamed:102:0x020d, B_renamed:106:0x0214, B_renamed:101:0x0208, B_renamed:93:0x01b6, B_renamed:95:0x01ba, B_renamed:97:0x01bc, B_renamed:92:0x01a6, B_renamed:107:0x021c, B_renamed:109:0x022f, B_renamed:13:0x003f, B_renamed:15:0x0043, B_renamed:71:0x012f, B_renamed:73:0x0135, B_renamed:75:0x0140, B_renamed:76:0x0156, B_renamed:78:0x015a, B_renamed:80:0x015e, B_renamed:82:0x0166, B_renamed:84:0x018b, B_renamed:83:0x0177), top: B_renamed:209:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:101:0x0208 A_renamed[Catch: all -> 0x03ef, TryCatch #1 {, blocks: (B_renamed:4:0x000b, B_renamed:6:0x0010, B_renamed:7:0x002a, B_renamed:9:0x0033, B_renamed:11:0x003b, B_renamed:18:0x0047, B_renamed:200:0x03e8, B_renamed:20:0x004e, B_renamed:22:0x0057, B_renamed:24:0x006a, B_renamed:25:0x0073, B_renamed:27:0x0075, B_renamed:28:0x0087, B_renamed:30:0x0089, B_renamed:32:0x008f, B_renamed:33:0x009b, B_renamed:35:0x009d, B_renamed:37:0x00a1, B_renamed:39:0x00a7, B_renamed:40:0x00aa, B_renamed:42:0x00ac, B_renamed:110:0x023c, B_renamed:112:0x0244, B_renamed:114:0x0248, B_renamed:116:0x024c, B_renamed:118:0x0252, B_renamed:120:0x025b, B_renamed:122:0x0261, B_renamed:124:0x026a, B_renamed:126:0x027f, B_renamed:127:0x0287, B_renamed:129:0x028d, B_renamed:130:0x0292, B_renamed:132:0x02bc, B_renamed:134:0x02c0, B_renamed:136:0x02e3, B_renamed:143:0x02f8, B_renamed:145:0x02fd, B_renamed:147:0x0301, B_renamed:149:0x0307, B_renamed:151:0x031f, B_renamed:153:0x032d, B_renamed:155:0x032f, B_renamed:157:0x0336, B_renamed:159:0x033b, B_renamed:161:0x0341, B_renamed:165:0x034b, B_renamed:178:0x0382, B_renamed:179:0x0388, B_renamed:181:0x038e, B_renamed:183:0x0394, B_renamed:185:0x0398, B_renamed:187:0x039e, B_renamed:189:0x03a6, B_renamed:190:0x03b5, B_renamed:192:0x03b9, B_renamed:194:0x03d5, B_renamed:196:0x03de, B_renamed:195:0x03db, B_renamed:168:0x0351, B_renamed:170:0x0356, B_renamed:171:0x0360, B_renamed:173:0x0364, B_renamed:175:0x036a, B_renamed:137:0x02e7, B_renamed:138:0x02ee, B_renamed:139:0x02f3, B_renamed:123:0x0268, B_renamed:119:0x0259, B_renamed:55:0x00d5, B_renamed:57:0x00d9, B_renamed:59:0x00ee, B_renamed:65:0x0112, B_renamed:67:0x0121, B_renamed:69:0x0125, B_renamed:70:0x012e, B_renamed:88:0x018f, B_renamed:89:0x0190, B_renamed:60:0x00f6, B_renamed:62:0x00fe, B_renamed:64:0x0106, B_renamed:90:0x0195, B_renamed:98:0x01d4, B_renamed:100:0x0204, B_renamed:102:0x020d, B_renamed:106:0x0214, B_renamed:101:0x0208, B_renamed:93:0x01b6, B_renamed:95:0x01ba, B_renamed:97:0x01bc, B_renamed:92:0x01a6, B_renamed:107:0x021c, B_renamed:109:0x022f, B_renamed:13:0x003f, B_renamed:15:0x0043, B_renamed:71:0x012f, B_renamed:73:0x0135, B_renamed:75:0x0140, B_renamed:76:0x0156, B_renamed:78:0x015a, B_renamed:80:0x015e, B_renamed:82:0x0166, B_renamed:84:0x018b, B_renamed:83:0x0177), top: B_renamed:209:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:167:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:202:0x03eb  */
    @Override // com.oplus.camera.gl_renamed.t_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed r23, com.oplus.camera.ui.menu.levelcontrol.j_renamed r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.h_renamed.a_renamed(com.oplus.camera.gl_renamed.h_renamed, com.oplus.camera.ui.menu.levelcontrol.j_renamed, int, int, int, int):boolean");
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.s_renamed sVar2) {
        hVar.a_renamed(sVar2);
        hVar.a_renamed(sVar, 0, 0, sVar2.f_renamed(), sVar2.g_renamed());
        hVar.h_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (this.l_renamed.isEmpty()) {
            return;
        }
        a_renamed(this.F_renamed);
        a_renamed(hVar, this.l_renamed.get(0), this.ae_renamed, this.F_renamed);
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        com.oplus.camera.e_renamed.a_renamed("CameraScreenNail.onFrameAvailable");
        E_renamed();
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion()) {
            synchronized (this.k_renamed) {
                if (surfaceTexture != null) {
                    if (c_renamed() == surfaceTexture) {
                        this.C_renamed = surfaceTexture.getTimestamp();
                    }
                }
                com.oplus.camera.e_renamed.f_renamed("CameraScreenNail", "onFrameAvailable, surfaceTexture does not correspond.");
                com.oplus.camera.e_renamed.b_renamed("CameraScreenNail.onFrameAvailable");
                return;
            }
        }
        if (!this.V_renamed) {
            this.V_renamed = true;
        }
        if (!this.X_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onFirstFrameAvailable");
            this.X_renamed = true;
            com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onFirstFrameAvailable");
            com.oplus.camera.perf.b_renamed.c_renamed("launch_first_frame_available");
            com.oplus.camera.e_renamed.f_renamed("CameraScreenNail", "CameraTest First Frame available");
        }
        if (this.V_renamed) {
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                this.p_renamed.post(this.at_renamed);
            } else {
                this.at_renamed.run();
            }
            if (this.Y_renamed) {
                this.q_renamed.Z_renamed();
            }
        }
        com.oplus.camera.e_renamed.b_renamed("CameraScreenNail.onFrameAvailable");
    }

    public void c_renamed(int i_renamed, int i2) {
        synchronized (this.k_renamed) {
            this.ad_renamed.b_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.gl_renamed.t_renamed
    public void m_renamed() {
        synchronized (this.k_renamed) {
            this.f4667c = true;
        }
        super.m_renamed();
    }

    public boolean u_renamed() {
        boolean z_renamed;
        synchronized (this.k_renamed) {
            z_renamed = this.f4667c && this.S_renamed == 0;
        }
        return z_renamed;
    }

    public boolean v_renamed() {
        boolean z_renamed;
        synchronized (this.k_renamed) {
            z_renamed = this.d_renamed;
        }
        return z_renamed;
    }

    public void k_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.d_renamed = z_renamed;
        }
    }

    public void l_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.e_renamed = z_renamed;
        }
    }

    public void m_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.f_renamed = z_renamed;
        }
    }

    public void w_renamed() {
        synchronized (this.k_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraScreenNail", "noModeChangeTask");
            this.aa_renamed = false;
        }
    }

    public boolean x_renamed() {
        boolean z_renamed;
        synchronized (this.k_renamed) {
            z_renamed = this.aa_renamed;
        }
        return z_renamed;
    }

    public void y_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraScreenNail", "forceRequestRender");
        android.content.Context context = this.ab_renamed;
        if (context != null) {
            ((android.app.Activity) context).runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.h_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.oplus.camera.ui.preview.h_renamed.this.k_renamed) {
                        com.oplus.camera.ui.preview.h_renamed.this.q_renamed.Z_renamed();
                    }
                }
            });
        }
    }

    public void n_renamed(boolean z_renamed) {
        synchronized (this.k_renamed) {
            if (!this.Y_renamed && z_renamed) {
                this.Y_renamed = z_renamed;
                if (this.Y_renamed && this.V_renamed) {
                    this.q_renamed.Z_renamed();
                }
            }
            this.Y_renamed = z_renamed;
            com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "setDrawFrame, mbDrawFrame: " + this.Y_renamed);
        }
    }

    public void e_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "setMultiVideoType, type: " + i_renamed);
        this.M_renamed.f_renamed(i_renamed);
    }

    public void o_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "setMainOneCameraImplDraw, mainOneCameraImplDraw: " + z_renamed);
        this.M_renamed.a_renamed(z_renamed);
    }

    public void d_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "setSmallSurfaceSize, width: " + i_renamed + ", height: " + i2);
        this.M_renamed.a_renamed(i_renamed, i2);
    }

    public int z_renamed() {
        return this.M_renamed.h_renamed();
    }

    public int A_renamed() {
        return this.M_renamed.a_renamed();
    }

    public android.graphics.Rect B_renamed() {
        return this.M_renamed.o_renamed();
    }

    public void e_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "setSmallSurfacePosition, x_renamed: " + i_renamed + ", y_renamed: " + i2);
        this.M_renamed.d_renamed(i_renamed);
        this.M_renamed.e_renamed(i2);
    }

    private void E_renamed() {
        long jNanoTime = java.lang.System.nanoTime();
        long j_renamed = this.an_renamed;
        if (j_renamed == 0) {
            this.an_renamed = jNanoTime;
        } else if (jNanoTime - j_renamed > com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            double d2 = (this.ao_renamed * 1.0E9d) / (jNanoTime - j_renamed);
            com.oplus.camera.w_renamed.a_renamed.a_renamed().b_renamed((int) d2);
            com.oplus.camera.e_renamed.c_renamed("CameraScreenNail", "onFrameAvailableFps, fps: " + d2);
            this.an_renamed = jNanoTime;
            this.ao_renamed = 0;
        }
        this.ao_renamed++;
    }

    public void f_renamed(int i_renamed) {
        synchronized (this.k_renamed) {
            if (1 == i_renamed) {
                if (this.J_renamed != null) {
                    com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "closeMultiImage cameraRole: " + i_renamed);
                    this.J_renamed.close();
                    this.J_renamed = null;
                }
            } else if (this.K_renamed != null) {
                com.oplus.camera.e_renamed.b_renamed("CameraScreenNail", "closeMultiImage cameraRole: " + i_renamed);
                this.K_renamed.close();
                this.K_renamed = null;
            }
        }
    }

    public void p_renamed(boolean z_renamed) {
        this.as_renamed = z_renamed;
    }
}
