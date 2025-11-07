package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: StickerTexturePreview.java */
/* loaded from: classes2.dex */
public class w_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6968a = "0ms";
    private java.util.Map<java.lang.Long, java.lang.Integer> A_renamed;
    private java.util.Map<java.lang.Long, java.lang.Integer> B_renamed;
    private boolean C_renamed;
    private boolean D_renamed;
    private float E_renamed;
    private final java.lang.Object F_renamed;
    private com.oplus.camera.sticker.d_renamed G_renamed;
    private java.util.concurrent.ConcurrentHashMap<com.oplus.camera.sticker.b_renamed, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> H_renamed;
    private java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.b_renamed> I_renamed;
    private com.sensetime.stmobile.STMobileHumanActionNative J_renamed;
    private com.sensetime.stmobile.STMobileHardwareBufferNative K_renamed;
    private com.sensetime.stmobile.STGLRender L_renamed;
    private byte[] M_renamed;
    private android.os.Handler N_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6969b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6970c;
    private int d_renamed;
    private int k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private volatile int n_renamed;
    private int o_renamed;
    private java.util.ArrayList<com.oplus.camera.gl_renamed.s_renamed> p_renamed;
    private com.oplus.camera.gl_renamed.s_renamed q_renamed;
    private com.oplus.camera.gl_renamed.s_renamed r_renamed;
    private com.oplus.camera.gl_renamed.s_renamed s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private volatile boolean v_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed w_renamed;
    private com.sensetime.stmobile.STSoundPlayManager x_renamed;
    private java.util.ArrayList<java.lang.Long> y_renamed;
    private java.util.ArrayList<java.lang.Long> z_renamed;

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(long j_renamed) {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(android.util.Size size, boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 8;
    }

    public w_renamed(android.content.Context context) {
        super(context);
        this.f6969b = 0;
        this.f6970c = 0;
        this.d_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = false;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = new java.util.ArrayList<>();
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = false;
        this.v_renamed = false;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = true;
        this.D_renamed = false;
        this.E_renamed = 1.0f;
        this.F_renamed = new java.lang.Object();
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = null;
        this.N_renamed = null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        this.w_renamed = aaVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "destroyEngine");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.s_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.r_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
        int i2 = this.n_renamed;
        if (i2 == 0) {
            this.o_renamed = 0;
            return;
        }
        if (i2 == 90) {
            this.o_renamed = 1;
        } else if (i2 == 180) {
            this.o_renamed = 2;
        } else {
            if (i2 != 270) {
                return;
            }
            this.o_renamed = 3;
        }
    }

    private void A_renamed() {
        if (this.B_renamed == null) {
            this.B_renamed = new java.util.HashMap();
            this.B_renamed.put(2L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_blink));
            this.B_renamed.put(4L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_open_month));
            this.B_renamed.put(8L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_shake_head));
            this.B_renamed.put(16L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_node_head));
            this.B_renamed.put(32L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_pick_eyebrow));
        }
        if (this.A_renamed == null) {
            this.A_renamed = new java.util.HashMap();
            this.A_renamed.put(4096L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_show_palm));
            this.A_renamed.put(16384L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_heart_shape_two_hand));
            this.A_renamed.put(32768L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_hold_up_hand));
            this.A_renamed.put(131072L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_congratulate));
            this.A_renamed.put(262144L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_heart_shape_one_hand));
            this.A_renamed.put(2048L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_thumb_up));
            this.A_renamed.put(512L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_ok));
            this.A_renamed.put(1024L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_yeah));
            this.A_renamed.put(8192L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_pistol));
            this.A_renamed.put(1048576L, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.sticker_hint_index_finger));
        }
    }

    private void B_renamed() {
        if (!this.u_renamed && this.t_renamed && this.v_renamed) {
            com.oplus.camera.e_renamed.a_renamed("initGLRes");
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "initGLRes");
            synchronized (this.F_renamed) {
                G_renamed();
            }
            this.x_renamed = new com.sensetime.stmobile.STSoundPlayManager(this.j_renamed);
            synchronized (this.F_renamed) {
                this.u_renamed = true;
            }
            com.oplus.camera.e_renamed.b_renamed("initGLRes");
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void m_renamed() throws java.lang.IllegalStateException {
        com.sensetime.stmobile.STSoundPlayManager sTSoundPlayManager = this.x_renamed;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.pauseSound();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void n_renamed() throws java.lang.IllegalStateException {
        com.sensetime.stmobile.STSoundPlayManager sTSoundPlayManager = this.x_renamed;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.resumeSound();
        }
    }

    private void C_renamed() {
        com.sensetime.stmobile.STSoundPlayManager sTSoundPlayManager = this.x_renamed;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.release();
            this.x_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2 + ", mCameraId: " + this.f_renamed);
        if (i2 <= 0 || i_renamed <= 0) {
            return;
        }
        this.f6969b = i_renamed;
        this.f6970c = i2;
    }

    private void D_renamed() {
        if (this.f6969b == 0 || this.f6970c == 0) {
            return;
        }
        this.d_renamed = this.g_renamed ? 320 : com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480;
        int i_renamed = this.f6969b;
        int i2 = this.f6970c;
        if (i_renamed >= i2) {
            int i3 = this.d_renamed;
            this.E_renamed = i_renamed / i3;
            this.k_renamed = i3;
            this.l_renamed = (i2 * i3) / i_renamed;
        } else {
            int i4 = this.d_renamed;
            this.E_renamed = i2 / i4;
            this.l_renamed = i4;
            this.k_renamed = (i_renamed * i4) / i2;
        }
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "checkInitActionDetectImageSize, mActionDetectImageWidth: " + this.k_renamed + ", mActionDetectImageHeight: " + this.l_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void o_renamed() {
        if (this.i_renamed != null) {
            this.i_renamed.a_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void p_renamed() {
        java.util.concurrent.ConcurrentHashMap<com.oplus.camera.sticker.b_renamed, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> concurrentHashMap = this.H_renamed;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        this.H_renamed.clear();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() throws java.lang.Throwable {
        com.oplus.camera.sticker.data.StickerItem stickerItemO = this.w_renamed.o_renamed();
        if (!this.t_renamed || stickerItemO == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "updateMaterialInfos, mbTextureInited: " + this.t_renamed + ", item: " + stickerItemO);
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("Sticker.onPreviewEffectChanged");
        E_renamed();
        this.D_renamed = true;
        java.util.HashMap<java.lang.String, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> mapA = a_renamed(stickerItemO.getStickerName());
        java.util.HashMap<java.lang.String, com.oplus.camera.sticker.b_renamed> mapA2 = a_renamed(mapA);
        java.util.concurrent.ConcurrentHashMap<com.oplus.camera.sticker.b_renamed, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> concurrentHashMap = this.H_renamed;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        } else {
            this.H_renamed = new java.util.concurrent.ConcurrentHashMap<>();
        }
        if (mapA2 != null) {
            for (java.lang.String str : mapA2.keySet()) {
                this.H_renamed.put(mapA2.get(str), mapA.get(str));
            }
        }
        com.oplus.camera.e_renamed.b_renamed("Sticker.onPreviewEffectChanged");
        return true;
    }

    private java.util.HashMap<java.lang.String, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> a_renamed(java.lang.String str) throws java.lang.Throwable {
        com.oplus.camera.sticker.data.StickerItem stickerItemO = this.w_renamed.o_renamed();
        if (stickerItemO == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "getExtendedInfoMap, item is_renamed null");
            return null;
        }
        java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> listA = com.oplus.camera.sticker.g_renamed.a_renamed(this.j_renamed, stickerItemO);
        java.util.HashMap<java.lang.String, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> map = new java.util.HashMap<>();
        if (listA != null && listA.size() > 0) {
            for (com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo : listA) {
                if (multiStickerExtendedInfo != null) {
                    if (map.containsKey(multiStickerExtendedInfo.getStickerName())) {
                        map.get(multiStickerExtendedInfo.getStickerName()).add(multiStickerExtendedInfo);
                    } else {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        arrayList.add(multiStickerExtendedInfo);
                        map.put(multiStickerExtendedInfo.getStickerName(), arrayList);
                    }
                }
            }
        } else {
            map.put(str, new java.util.ArrayList());
        }
        return map;
    }

    private java.util.HashMap<java.lang.String, com.oplus.camera.sticker.b_renamed> a_renamed(java.util.HashMap<java.lang.String, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> map) {
        java.lang.String strA;
        com.oplus.camera.gl_renamed.s_renamed sVar;
        com.oplus.camera.sticker.data.StickerItem stickerItemO = this.w_renamed.o_renamed();
        if (stickerItemO == null || map == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "getMaterialInfoMap, item: " + stickerItemO + ", extendedInfoMap: " + map);
            return null;
        }
        java.lang.String fileContentUri = stickerItemO.getFileContentUri();
        java.util.HashMap<java.lang.String, com.oplus.camera.sticker.b_renamed> map2 = new java.util.HashMap<>();
        synchronized (this.F_renamed) {
            java.lang.String str = fileContentUri;
            int i_renamed = 0;
            int i2 = 0;
            for (java.lang.String str2 : map.keySet()) {
                java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = map.get(str2);
                if (i_renamed >= this.I_renamed.size()) {
                    com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "getMaterialInfoMap, Just support " + this.I_renamed.size() + " materials.");
                } else {
                    int i3 = i_renamed + 1;
                    com.oplus.camera.sticker.b_renamed bVar = this.I_renamed.get(i_renamed);
                    if (list != null && list.size() > 0) {
                        if (list.get(0).getPositionType() == 0) {
                            sVar = this.q_renamed;
                        } else if (list.get(0).getPositionType() == 2) {
                            sVar = this.r_renamed;
                        } else {
                            sVar = this.p_renamed.get(i2);
                            i2++;
                        }
                        strA = com.oplus.camera.sticker.c_renamed.a_renamed(list.get(0), com.oplus.camera.util.Util.d_renamed(this.f6970c, this.f6969b));
                    } else {
                        strA = str;
                        sVar = this.r_renamed;
                    }
                    bVar.a_renamed(this.f6969b / sVar.f_renamed());
                    bVar.a_renamed(sVar);
                    a_renamed(bVar, strA);
                    map2.put(str2, bVar);
                    str = strA;
                    i_renamed = i3;
                }
            }
        }
        return map2;
    }

    private void a_renamed(com.oplus.camera.sticker.b_renamed bVar, java.lang.String str) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "changeStickerNative, sticker: " + str);
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.j_renamed);
        byte[] bArrA = com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed(this.j_renamed, str);
        if (bArrA != null) {
            bVar.a_renamed().changeStickerFromBuffer(bArrA, bArrA.length);
        } else {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "changeStickerNative failed, bytes: " + bArrA);
        }
        o_renamed();
        b_renamed(bVar.a_renamed().getTriggerAction());
        a_renamed(bVar, str, bVar.a_renamed().getTriggerAction());
    }

    private void E_renamed() {
        com.oplus.camera.sticker.data.StickerItem stickerItemO = this.w_renamed.o_renamed();
        if (stickerItemO != null) {
            com.oplus.camera.ui.preview.a_renamed.q_renamed qVarB = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.j_renamed);
            com.sensetime.stmobile.STSoundPlayManager sTSoundPlayManager = this.x_renamed;
            if (sTSoundPlayManager != null) {
                sTSoundPlayManager.setPauseState(qVarB.a_renamed(stickerItemO.getStickerUUID()));
                return;
            }
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "checkStickerMusicPauseState, non selected sticker!");
    }

    private void F_renamed() {
        if (this.I_renamed != null) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "destroyStInstance");
            java.util.Iterator<com.oplus.camera.sticker.b_renamed> it = this.I_renamed.iterator();
            while (it.hasNext()) {
                com.oplus.camera.sticker.b_renamed next = it.next();
                if (next != null) {
                    next.a_renamed().destroyInstance();
                }
            }
            this.I_renamed.clear();
        }
    }

    private void G_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.sticker.b_renamed> copyOnWriteArrayList = this.I_renamed;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() != 0) {
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "createStInstance");
        for (int i_renamed = 0; i_renamed < 5; i_renamed++) {
            com.oplus.camera.sticker.b_renamed bVar = new com.oplus.camera.sticker.b_renamed();
            bVar.a_renamed().createInstance(com.oplus.camera.util.Util.l_renamed());
            this.I_renamed.add(bVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
        if (this.N_renamed == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("InitResThread");
            handlerThread.start();
            this.N_renamed = new android.os.Handler(handlerThread.getLooper());
        }
        this.N_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.w_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("Sticker.initHumanAction");
                synchronized (com.oplus.camera.ui.preview.a_renamed.w_renamed.this.F_renamed) {
                    com.oplus.camera.ui.preview.a_renamed.w_renamed.this.r_renamed();
                    com.oplus.camera.ui.preview.a_renamed.w_renamed.this.v_renamed = true;
                }
                com.oplus.camera.e_renamed.b_renamed("Sticker.initHumanAction");
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "newTextures");
        com.oplus.camera.e_renamed.a_renamed("Sticker.newTextures");
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            this.p_renamed.add(new com.oplus.camera.gl_renamed.s_renamed(this.f6969b / 2, this.f6970c / 2, true));
        }
        this.q_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6969b, this.f6970c, true);
        this.r_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6969b, this.f6970c, true);
        this.s_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6969b, this.f6970c, true);
        this.t_renamed = true;
        com.oplus.camera.e_renamed.b_renamed("Sticker.newTextures");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        B_renamed();
        com.oplus.camera.e_renamed.a_renamed("Sticker.prepareTextures");
        java.util.ArrayList<com.oplus.camera.gl_renamed.s_renamed> arrayList = this.p_renamed;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.gl_renamed.s_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.gl_renamed.s_renamed next = it.next();
                if (next != null && !next.n_renamed()) {
                    next.c_renamed(hVar);
                    com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "prepareTextures, texture id_renamed: " + next.e_renamed());
                }
            }
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = this.q_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.q_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.q_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.r_renamed;
        if (sVar2 != null && !sVar2.n_renamed()) {
            this.r_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.r_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar3 = this.s_renamed;
        if (sVar3 != null && !sVar3.n_renamed()) {
            this.s_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "prepareTextures, texture id_renamed: " + this.s_renamed.e_renamed());
        }
        com.oplus.camera.e_renamed.b_renamed("Sticker.prepareTextures");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "recycleTextures, mbGLInit: " + this.u_renamed + ", mbTextureInited: " + this.t_renamed);
        if (this.u_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Sticker.eglInit");
            synchronized (this.F_renamed) {
                if (this.J_renamed != null) {
                    this.J_renamed.reset();
                }
            }
            this.m_renamed = false;
            C_renamed();
            java.util.Map<java.lang.Long, java.lang.Integer> map = this.A_renamed;
            if (map != null) {
                map.clear();
                this.A_renamed = null;
            }
            java.util.Map<java.lang.Long, java.lang.Integer> map2 = this.B_renamed;
            if (map2 != null) {
                map2.clear();
                this.B_renamed = null;
            }
            o_renamed();
            this.u_renamed = false;
            com.oplus.camera.e_renamed.b_renamed("Sticker.eglInit");
        }
        if (this.t_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Sticker.recycleTextures");
            java.util.ArrayList<com.oplus.camera.gl_renamed.s_renamed> arrayList = this.p_renamed;
            if (arrayList != null) {
                java.util.Iterator<com.oplus.camera.gl_renamed.s_renamed> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.oplus.camera.gl_renamed.s_renamed next = it.next();
                    if (next != null) {
                        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "recycleTextures, texture id_renamed: " + next.e_renamed());
                        next.o_renamed();
                    }
                }
                this.p_renamed.clear();
            }
            if (this.q_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.q_renamed.e_renamed());
                this.q_renamed.o_renamed();
                this.q_renamed = null;
            }
            if (this.r_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.r_renamed.e_renamed());
                this.r_renamed.o_renamed();
                this.r_renamed = null;
            }
            if (this.s_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "recycleTextures, texture id_renamed: " + this.s_renamed.e_renamed());
                this.s_renamed.o_renamed();
                this.s_renamed = null;
            }
            com.sensetime.stmobile.STMobileHardwareBufferNative sTMobileHardwareBufferNative = this.K_renamed;
            if (sTMobileHardwareBufferNative != null) {
                sTMobileHardwareBufferNative.release();
                this.K_renamed = null;
                this.M_renamed = null;
                com.sensetime.stmobile.STGLRender sTGLRender = this.L_renamed;
                if (sTGLRender != null) {
                    sTGLRender.destroy();
                    this.L_renamed = null;
                }
            }
            this.t_renamed = false;
            com.oplus.camera.e_renamed.b_renamed("Sticker.recycleTextures");
        }
    }

    private void a_renamed(com.oplus.camera.sticker.b_renamed bVar, java.lang.String str, long j_renamed) {
        if (str == null) {
            j_renamed = 0;
        }
        bVar.a_renamed(j_renamed);
    }

    private void a_renamed(com.sensetime.stmobile.model.STHumanAction sTHumanAction) {
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            bVar.b_renamed(sTHumanAction);
            bVar.a_renamed(sTHumanAction);
            b_renamed(bVar.b_renamed(this.E_renamed));
        }
    }

    private int b_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("processNoFrontTexture");
        int iProcessTexture = -1;
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = this.H_renamed.get(bVar);
            if (list == null || list.size() == 0 || list.get(0).getPositionType() != 0) {
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                iProcessTexture = bVar.a_renamed().processTexture(sVar.e_renamed(), bVar.b_renamed(this.E_renamed), this.o_renamed, bVar.c_renamed().f_renamed(), bVar.c_renamed().g_renamed(), 0, 0, false, null, bVar.c_renamed().e_renamed());
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                if (com.oplus.camera.util.Util.b_renamed()) {
                    com.oplus.camera.util.Util.a_renamed(bVar.c_renamed(), "NONFORE");
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("processNoFrontTexture");
        return iProcessTexture;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar) throws java.io.IOException {
        if (c_renamed(sVar)) {
            a_renamed(hVar, sVar, -16777216);
        }
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = this.H_renamed.get(bVar);
            if (list != null && list.size() > 0) {
                for (com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!bVar.c_renamed().equals(sVar)) {
                        android.graphics.RectF rectFA = com.oplus.camera.sticker.c_renamed.a_renamed(multiStickerExtendedInfo, sVar.f_renamed(), sVar.g_renamed());
                        a_renamed(hVar, bVar.c_renamed(), sVar, com.oplus.camera.sticker.c_renamed.a_renamed(bVar.c_renamed().f_renamed(), bVar.c_renamed().g_renamed(), rectFA), rectFA);
                        if (com.oplus.camera.util.Util.b_renamed()) {
                            com.oplus.camera.util.Util.a_renamed(sVar, "OUTPUT");
                        }
                    }
                }
            }
        }
    }

    private int a_renamed(int i_renamed, com.oplus.camera.gl_renamed.s_renamed sVar) throws java.io.IOException {
        int iProcessTexture = i_renamed;
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = this.H_renamed.get(bVar);
            if (list != null && list.size() > 0 && list.get(0).getPositionType() == 0) {
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                iProcessTexture = bVar.a_renamed().processTexture(bVar.c_renamed().e_renamed(), bVar.b_renamed(this.E_renamed), this.o_renamed, bVar.c_renamed().f_renamed(), bVar.c_renamed().g_renamed(), 0, 0, false, null, sVar.e_renamed());
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                if (com.oplus.camera.util.Util.b_renamed()) {
                    com.oplus.camera.util.Util.a_renamed(sVar, "FORE");
                }
            }
        }
        return iProcessTexture;
    }

    private com.oplus.camera.gl_renamed.s_renamed H_renamed() {
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = this.H_renamed.get(bVar);
            if (list != null && list.size() > 0 && list.get(0).getPositionType() == 0) {
                return bVar.c_renamed();
            }
        }
        return null;
    }

    private boolean c_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        boolean z_renamed = false;
        boolean z2 = false;
        for (com.oplus.camera.sticker.b_renamed bVar : this.H_renamed.keySet()) {
            java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list = this.H_renamed.get(bVar);
            if (list != null && list.size() > 0) {
                for (com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!bVar.c_renamed().equals(sVar)) {
                        z2 = true;
                    }
                }
                if (list.get(0).getPositionType() == 2) {
                    z_renamed = true;
                }
            }
        }
        return !z_renamed && z2;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        return this.w_renamed != null && a__renamed(i_renamed) && this.t_renamed && this.w_renamed.r_renamed() && this.w_renamed.s_renamed() && !com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.w_renamed.o_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) throws java.io.IOException {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (aVar == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        int iB = -1;
        if (this.w_renamed != null && aVar.f6977c != null) {
            if (!this.m_renamed) {
                if (this.u_renamed && h_renamed()) {
                    this.m_renamed = true;
                } else {
                    a_renamed(aVar.f6975a, this.s_renamed, this.r_renamed);
                    com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "process, non selected sticker!");
                    return false;
                }
            }
            if (this.K_renamed == null) {
                D_renamed();
                this.K_renamed = new com.sensetime.stmobile.STMobileHardwareBufferNative();
                this.K_renamed.init(this.k_renamed, this.l_renamed, 0, 1);
                this.M_renamed = new byte[this.k_renamed * this.l_renamed * 4];
                if (this.L_renamed == null) {
                    this.L_renamed = new com.sensetime.stmobile.STGLRender();
                    this.L_renamed.init(this.f6969b, this.f6970c);
                }
            }
            e_renamed(aVar.f6977c.e_renamed());
            iB = b_renamed(aVar.f6977c);
            com.oplus.camera.gl_renamed.s_renamed sVarH = H_renamed();
            if (sVarH != null) {
                a_renamed(aVar.f6975a, sVarH);
                iB = a_renamed(iB, this.r_renamed);
            } else {
                a_renamed(aVar.f6975a, this.r_renamed);
            }
            com.oplus.camera.util.k_renamed.a_renamed("process");
        } else if (this.w_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "process, mRequest is_renamed null");
        }
        if (iB != 0) {
            com.oplus.camera.e_renamed.f_renamed("StickerTexturePreview", "process, result: " + iB);
        }
        f6968a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return iB == 0;
    }

    private void e_renamed(int i_renamed) {
        com.sensetime.stmobile.model.STHumanAction sTHumanActionHumanActionDetect;
        com.oplus.camera.e_renamed.a_renamed("doHumanActionDetect");
        int textureId = this.K_renamed.getTextureId();
        this.L_renamed.copyTexture(this.L_renamed.resizeTexture(i_renamed, this.k_renamed, this.l_renamed, 0), textureId, this.k_renamed, this.l_renamed);
        this.K_renamed.downloadRgbaImage(this.k_renamed, this.l_renamed, this.M_renamed);
        synchronized (this.F_renamed) {
            r_renamed();
            sTHumanActionHumanActionDetect = this.J_renamed.humanActionDetect(this.M_renamed, 6, com.oplus.camera.sticker.c_renamed.a_renamed(this.H_renamed), this.o_renamed, this.k_renamed, this.l_renamed);
        }
        a_renamed(sTHumanActionHumanActionDetect);
        com.oplus.camera.e_renamed.b_renamed("doHumanActionDetect");
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.s_renamed sVar2) {
        hVar.a_renamed(sVar2);
        hVar.a_renamed(sVar, 0, 0, sVar2.f_renamed(), sVar2.g_renamed());
        hVar.h_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.s_renamed sVar2, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        hVar.a_renamed(sVar2);
        hVar.a_renamed(sVar, rectF, rectF2);
        hVar.h_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, int i_renamed) {
        hVar.a_renamed(sVar);
        hVar.a_renamed(0.0f, 0.0f, sVar.h_renamed(), sVar.i_renamed(), i_renamed);
        hVar.h_renamed();
    }

    public void q_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "destroyHumanAction");
        com.sensetime.stmobile.STMobileHumanActionNative sTMobileHumanActionNative = this.J_renamed;
        if (sTMobileHumanActionNative != null) {
            sTMobileHumanActionNative.reset();
            this.J_renamed.destroyInstance();
            this.J_renamed.destroyInstanceImage();
            this.J_renamed = null;
        }
        this.v_renamed = false;
    }

    public void r_renamed() {
        if (this.J_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("StickerTexturePreview", "initNativeInstance");
            this.J_renamed = new com.sensetime.stmobile.STMobileHumanActionNative();
            int iCreateInstanceFromAssetFile = this.J_renamed.createInstanceFromAssetFile("M_SenseME_Action_5.2.12.model", com.oplus.camera.sticker.c_renamed.f5438a, com.oplus.camera.util.Util.l_renamed().getAssets());
            int iCreateInstanceImage = this.J_renamed.createInstanceImage("M_SenseME_Action_5.2.12.model", com.oplus.camera.sticker.c_renamed.f5439b, com.oplus.camera.util.Util.l_renamed().getAssets());
            if (iCreateInstanceFromAssetFile == 0) {
                this.J_renamed.setParam(2, 0.3f);
                this.J_renamed.setParam(1, 320.0f);
                this.J_renamed.setParam(20, 0.2f);
                this.J_renamed.setParam(3, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER_SUPPORT_MAX_FACE_NUM));
            }
            if (iCreateInstanceImage == 0) {
                this.J_renamed.setParamImage(2, 0.1f);
                this.J_renamed.setParamImage(1, 640.0f);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
        android.os.Handler handler = this.N_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.N_renamed = null;
        }
        F_renamed();
        synchronized (this.F_renamed) {
            if (this.H_renamed != null) {
                this.H_renamed.clear();
                this.H_renamed = null;
            }
            q_renamed();
        }
    }

    private void b_renamed(long j_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.y_renamed == null) {
            this.y_renamed = new java.util.ArrayList<>();
        }
        this.y_renamed.clear();
        if (this.z_renamed == null) {
            this.z_renamed = new java.util.ArrayList<>();
        }
        this.z_renamed.clear();
        A_renamed();
        java.util.Set<java.lang.Long> setKeySet = this.B_renamed.keySet();
        java.util.Set<java.lang.Long> setKeySet2 = this.A_renamed.keySet();
        if (setKeySet != null) {
            java.util.Iterator<java.lang.Long> it = setKeySet.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (j_renamed >= 0 && (j_renamed & jLongValue) > 0) {
                    this.y_renamed.add(java.lang.Long.valueOf(jLongValue));
                }
            }
        }
        if (setKeySet2 != null) {
            java.util.Iterator<java.lang.Long> it2 = setKeySet2.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = it2.next().longValue();
                if (j_renamed >= 0 && (j_renamed & jLongValue2) > 0) {
                    this.z_renamed.add(java.lang.Long.valueOf(jLongValue2));
                }
            }
        }
        for (int i_renamed = 0; i_renamed < this.y_renamed.size(); i_renamed++) {
            if (this.i_renamed != null) {
                this.C_renamed = false;
                this.i_renamed.a_renamed(this.j_renamed.getResources().getString(this.B_renamed.get(this.y_renamed.get(i_renamed)).intValue()));
                return;
            }
        }
        for (int i2 = 0; i2 < this.z_renamed.size(); i2++) {
            if (this.i_renamed != null) {
                this.C_renamed = false;
                this.i_renamed.a_renamed(this.j_renamed.getResources().getString(this.A_renamed.get(this.z_renamed.get(i2)).intValue()));
                return;
            }
        }
    }

    private void b_renamed(com.sensetime.stmobile.model.STHumanAction sTHumanAction) {
        java.util.ArrayList<java.lang.Long> arrayList;
        java.util.ArrayList<java.lang.Long> arrayList2;
        if (sTHumanAction == null || this.C_renamed) {
            return;
        }
        if (sTHumanAction.faceCount > 0 && (arrayList2 = this.y_renamed) != null && arrayList2.size() > 0) {
            for (int i_renamed = 0; i_renamed < sTHumanAction.faceCount; i_renamed++) {
                long j_renamed = sTHumanAction.faces[i_renamed].faceAction;
                for (int i2 = 0; i2 < this.y_renamed.size(); i2++) {
                    if ((this.y_renamed.get(i2).longValue() & j_renamed) > 0) {
                        this.C_renamed = true;
                        o_renamed();
                        return;
                    }
                }
            }
        }
        if (sTHumanAction.handCount <= 0 || (arrayList = this.z_renamed) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < sTHumanAction.handCount; i3++) {
            long j2 = sTHumanAction.hands[i3].handAction;
            for (int i4 = 0; i4 < this.z_renamed.size(); i4++) {
                if ((this.z_renamed.get(i4).longValue() & j2) > 0) {
                    this.C_renamed = true;
                    o_renamed();
                    return;
                }
            }
        }
    }
}
