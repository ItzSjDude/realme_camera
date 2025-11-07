package com.oplus.camera.photo3d;

/* compiled from: ThreeDPhotoManager.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.camera.photo3d.d_renamed.b_renamed, com.oplus.camera.photo3d.ui.g_renamed.a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.app.Activity f5013c;
    private final android.content.Context d_renamed;
    private final com.oplus.camera.capmode.a_renamed e_renamed;
    private final com.oplus.camera.ui.CameraUIInterface f_renamed;
    private final com.oplus.camera.photo3d.d_renamed g_renamed;
    private com.b_renamed.a_renamed.h_renamed h_renamed;
    private com.b_renamed.a_renamed.g_renamed i_renamed;
    private com.oplus.camera.photo3d.a_renamed j_renamed;
    private com.b_renamed.a_renamed.a_renamed.e_renamed k_renamed;
    private int l_renamed;
    private int q_renamed;
    private boolean m_renamed = true;
    private final android.os.ConditionVariable n_renamed = new android.os.ConditionVariable();
    private java.util.concurrent.atomic.AtomicBoolean o_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicLong p_renamed = new java.util.concurrent.atomic.AtomicLong(0);
    private boolean r_renamed = false;
    private com.b_renamed.a_renamed.k_renamed s_renamed = new com.b_renamed.a_renamed.k_renamed() { // from class: com.oplus.camera.photo3d.b_renamed.1
        @Override // com.b_renamed.a_renamed.k_renamed
        public void a_renamed(android.view.Surface surface) {
            com.oplus.camera.e_renamed.b_renamed(f2364a, "onRenderStart, mbPortraitDirection: " + com.oplus.camera.photo3d.b_renamed.this.m_renamed + ", mbMainObjectOnRight: " + com.oplus.camera.photo3d.b_renamed.this.r_renamed);
            com.b_renamed.a_renamed.a_renamed.j_renamed jVarA = com.oplus.camera.photo3d.b_renamed.this.h_renamed.a_renamed(com.oplus.camera.photo3d.b_renamed.this.g_renamed(), com.oplus.camera.photo3d.b_renamed.this.m_renamed, com.oplus.camera.photo3d.b_renamed.this.h_renamed());
            if (jVarA != null) {
                com.oplus.camera.photo3d.b_renamed.this.e_renamed().a_renamed(jVarA).a_renamed();
            }
        }

        @Override // com.b_renamed.a_renamed.k_renamed
        public void b_renamed(android.view.Surface surface) {
            com.oplus.camera.e_renamed.b_renamed(f2364a, "onRenderFinish");
        }

        @Override // com.b_renamed.a_renamed.k_renamed
        public void a_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar) {
            com.oplus.camera.e_renamed.b_renamed(f2364a, "onAnimationStart");
        }

        @Override // com.b_renamed.a_renamed.k_renamed
        public void b_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar) {
            com.oplus.camera.e_renamed.b_renamed(f2364a, "onAnimationComplete");
            com.oplus.camera.photo3d.b_renamed.this.f5011a.sendEmptyMessage(com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS);
        }

        @Override // com.b_renamed.a_renamed.k_renamed
        public void c_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar) {
            com.oplus.camera.e_renamed.b_renamed(f2364a, "onAnimationFinish");
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.os.Handler f5011a = a_renamed("3d photo thread");

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.Handler f5012b = a_renamed("3d photo mesh thread");

    public b_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.l_renamed = 1;
        this.q_renamed = 0;
        this.f5013c = activity;
        this.d_renamed = this.f5013c.getApplicationContext();
        this.e_renamed = aVar;
        this.f_renamed = cameraUIInterface;
        this.g_renamed = new com.oplus.camera.photo3d.d_renamed(this.d_renamed, this.f5011a, this.e_renamed, this.f_renamed);
        this.g_renamed.a_renamed(this);
        this.l_renamed = this.e_renamed.t_renamed().getInt("pref_3d_photo_scene_type", 1);
        this.q_renamed = com.oplus.camera.e_renamed.a_renamed() ? 8 : 0;
    }

    private android.os.Handler a_renamed(java.lang.String str) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(str);
        handlerThread.start();
        return new com.oplus.camera.photo3d.b_renamed.ThreeDPhotoManager_2(handlerThread.getLooper());
    }

    public void a_renamed(long j_renamed, long j2) {
        this.f5012b.obtainMessage(1000, new com.oplus.camera.photo3d.b_renamed.a_renamed(b_renamed(j_renamed), j2)).sendToTarget();
    }

    @Override // com.oplus.camera.photo3d.d_renamed.b_renamed
    public void a_renamed(android.view.Surface surface) {
        com.oplus.camera.e_renamed.b_renamed("ThreeDPhotoManager", "onEncodeSurfaceCreated");
        this.f5011a.obtainMessage(1002, surface).sendToTarget();
    }

    @Override // com.oplus.camera.photo3d.ui.g_renamed.a_renamed
    public void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar) {
        this.l_renamed = dVar.a_renamed();
        com.oplus.camera.e_renamed.b_renamed("ThreeDPhotoManager", "onMenuItemClicked, item: " + dVar.a_renamed());
    }

    public void a_renamed() {
        this.f5012b.removeMessages(1000);
    }

    /* compiled from: ThreeDPhotoManager.java */
    /* renamed from: com.oplus.camera.photo3d.b_renamed$b_renamed, reason: collision with other inner class name */
    private class ThreeDPhotoManager_2 extends android.os.Handler {
        public ThreeDPhotoManager_2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.Throwable {
            super.handleMessage(message);
            switch (message.what) {
                case 1000:
                    com.oplus.camera.photo3d.b_renamed.a_renamed aVar = (com.oplus.camera.photo3d.b_renamed.a_renamed) message.obj;
                    com.oplus.camera.photo3d.b_renamed.this.i_renamed = aVar.f5015a;
                    com.oplus.camera.photo3d.b_renamed bVar = com.oplus.camera.photo3d.b_renamed.this;
                    bVar.m_renamed = bVar.i_renamed.g_renamed;
                    com.oplus.camera.photo3d.b_renamed.this.a_renamed(-1L);
                    com.oplus.camera.photo3d.b_renamed.this.o_renamed.set(true);
                    com.oplus.camera.photo3d.b_renamed.this.g_renamed.a_renamed();
                    com.oplus.camera.photo3d.b_renamed.this.p_renamed.set(aVar.f5016b);
                    break;
                case com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                    com.oplus.camera.photo3d.b_renamed.this.g_renamed.c_renamed();
                    com.oplus.camera.photo3d.b_renamed.this.h_renamed.b_renamed();
                    com.oplus.camera.photo3d.b_renamed.this.d_renamed();
                    break;
                case 1002:
                    android.view.Surface surface = (android.view.Surface) message.obj;
                    android.util.Size sizeB = com.oplus.camera.photo3d.b_renamed.this.g_renamed.b_renamed();
                    com.oplus.camera.photo3d.b_renamed bVar2 = com.oplus.camera.photo3d.b_renamed.this;
                    bVar2.h_renamed = com.b_renamed.a_renamed.i_renamed.a_renamed(bVar2.f5013c, com.oplus.camera.photo3d.b_renamed.this.i_renamed).a_renamed(surface, sizeB.getHeight(), sizeB.getWidth()).a_renamed(com.oplus.camera.photo3d.b_renamed.this.s_renamed);
                    com.oplus.camera.photo3d.b_renamed.this.h_renamed.a_renamed(com.oplus.camera.photo3d.b_renamed.this.q_renamed);
                    com.oplus.camera.photo3d.b_renamed.this.h_renamed.a_renamed();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(long j_renamed) {
        if (this.o_renamed.get()) {
            com.oplus.camera.e_renamed.b_renamed("ThreeDPhotoManager", "waitRendingDone");
            this.n_renamed.close();
            if (j_renamed > 0) {
                this.n_renamed.block(j_renamed);
            } else {
                this.n_renamed.block();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("ThreeDPhotoManager", "notifyRecordingStop");
        com.oplus.camera.photo3d.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.p_renamed.get());
        }
        this.o_renamed.set(false);
        this.n_renamed.open();
    }

    private com.b_renamed.a_renamed.g_renamed b_renamed(long j_renamed) {
        com.oplus.camera.photo3d.PhotoMeshData meshData = com.oplus.camera.photo3d.PhotoMeshData.getMeshData(j_renamed);
        com.b_renamed.a_renamed.g_renamed gVar = new com.b_renamed.a_renamed.g_renamed();
        gVar.f2351a = meshData.mVerticesBuffer;
        gVar.f2352b = meshData.mColorsBuffer;
        gVar.f2353c = meshData.mFacesBuffer;
        gVar.e_renamed = meshData.mStride;
        gVar.d_renamed = meshData.mLabels;
        gVar.f_renamed = meshData.mRotated;
        gVar.h_renamed = meshData.mTextureData;
        gVar.g_renamed = meshData.mbPortraitDirection;
        this.r_renamed = meshData.mbMainObjectOnRight;
        return gVar;
    }

    public void b_renamed() {
        com.b_renamed.a_renamed.h_renamed hVar = this.h_renamed;
        if (hVar != null) {
            hVar.b_renamed();
        }
        a_renamed(3000L);
        android.os.Handler handler = this.f5011a;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f5011a = null;
        }
        android.os.Handler handler2 = this.f5012b;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.f5012b = null;
        }
        this.j_renamed = null;
    }

    public void a_renamed(com.oplus.camera.photo3d.a_renamed aVar) {
        this.j_renamed = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.b_renamed.a_renamed.a_renamed.e_renamed e_renamed() {
        com.b_renamed.a_renamed.a_renamed.e_renamed eVar = this.k_renamed;
        if (eVar == null) {
            this.k_renamed = new com.b_renamed.a_renamed.a_renamed.e_renamed(f_renamed()).a_renamed(false);
            return this.k_renamed;
        }
        eVar.a_renamed(0).b_renamed((com.b_renamed.a_renamed.a_renamed.j_renamed) null);
        this.k_renamed.a_renamed(f_renamed());
        return this.k_renamed;
    }

    private int f_renamed() {
        int i_renamed = this.l_renamed;
        return (2 == i_renamed || 3 == i_renamed) ? 5000 : 3000;
    }

    public int c_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_3D_PHOTO_MESH_PROCESS_TIME) + f_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.b_renamed.a_renamed.a_renamed.d_renamed g_renamed() {
        int i_renamed = this.l_renamed;
        if (i_renamed == 1) {
            return com.b_renamed.a_renamed.a_renamed.d_renamed.DollyZoom;
        }
        if (i_renamed == 2) {
            return com.b_renamed.a_renamed.a_renamed.d_renamed.Circle;
        }
        if (i_renamed == 3) {
            return com.b_renamed.a_renamed.a_renamed.d_renamed.Swing;
        }
        if (i_renamed == 4) {
            return com.b_renamed.a_renamed.a_renamed.d_renamed.FixedGaze;
        }
        return com.b_renamed.a_renamed.a_renamed.d_renamed.DollyZoom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.b_renamed.a_renamed.a_renamed.a_renamed h_renamed() {
        if (4 != this.l_renamed) {
            return null;
        }
        return new com.b_renamed.a_renamed.a_renamed.a_renamed(i_renamed());
    }

    private com.b_renamed.a_renamed.a_renamed.b_renamed i_renamed() {
        int iV = this.e_renamed.v_renamed();
        if (iV == 0 || iV == 90) {
            if (this.r_renamed) {
                return com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_LEFT2RIGHT;
            }
            return com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT;
        }
        if (iV == 180 || iV == 270) {
            if (this.r_renamed) {
                return com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT;
            }
            return com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_LEFT2RIGHT;
        }
        return com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_DEFAULT;
    }

    /* compiled from: ThreeDPhotoManager.java */
    private class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.b_renamed.a_renamed.g_renamed f5015a;

        /* renamed from: b_renamed, reason: collision with root package name */
        long f5016b;

        public a_renamed(com.b_renamed.a_renamed.g_renamed gVar, long j_renamed) {
            this.f5015a = gVar;
            this.f5016b = j_renamed;
        }
    }
}
