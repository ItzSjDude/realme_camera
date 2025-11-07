package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: BlurTexturePreview.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed implements com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6890a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f6891b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.Object f6892c;
    private int d_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private com.oplus.camera.gl_renamed.s_renamed o_renamed;
    private com.oplus.camera.gl_renamed.s_renamed p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private com.sensetime.blur.STBlurPreview t_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private android.os.Handler x_renamed;
    private android.os.HandlerThread y_renamed;
    private boolean z_renamed;

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
        return 1;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public e_renamed(android.content.Context context) {
        super(context);
        this.f6892c = new java.lang.Object();
        this.d_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = -1;
        this.n_renamed = -1;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = true;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = false;
        this.w_renamed = false;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = false;
        this.z_renamed = com.oplus.camera.sticker.c_renamed.d_renamed.g_renamed(context);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
        if (this.v_renamed) {
            synchronized (this.f6892c) {
                if (this.r_renamed) {
                    return;
                }
                boolean z_renamed = this.g_renamed;
                synchronized (this.f6892c) {
                    if (this.t_renamed != null && this.u_renamed != null) {
                        this.t_renamed.onPreviewCallback(bArr, i_renamed, i2, this.u_renamed.C_renamed(), z_renamed, true, 1, null);
                    }
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (this.f6892c) {
            if (this.u_renamed == null) {
                com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "canProcess, Engine has not init!");
                return false;
            }
            if (this.u_renamed.C_renamed() <= 0 && !this.r_renamed) {
                com.oplus.camera.e_renamed.f_renamed("BlurTexturePreview", "canProcess, facesCount: " + this.u_renamed.C_renamed());
                return false;
            }
            if (!this.u_renamed.r_renamed()) {
                com.oplus.camera.e_renamed.f_renamed("BlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.w_renamed) {
                return true;
            }
            com.oplus.camera.e_renamed.f_renamed("BlurTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) throws java.lang.Throwable {
        boolean z_renamed;
        java.lang.Object obj;
        int i_renamed;
        int iProcessTextureGradual;
        int i2;
        int iDoOnPreviewProcess;
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.u_renamed == null || aVar == null || aVar.f6977c == null || this.o_renamed == null) {
            return false;
        }
        if (!this.v_renamed) {
            com.oplus.camera.e_renamed.e_renamed("BlurTexturePreview", "process, mSTBlurFilter not create, so return!");
            return false;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
        int iH = sVar.h_renamed();
        int i3 = sVar.i_renamed();
        boolean z2 = this.g_renamed;
        java.lang.Object obj2 = this.f6892c;
        synchronized (obj2) {
            try {
                try {
                    if (this.t_renamed != null) {
                        if (this.s_renamed) {
                            this.t_renamed.resetSegmentThread();
                            this.t_renamed.setParam(com.sensetime.blur.BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE, this.r_renamed ? 1.0f : 0.0f);
                            this.s_renamed = false;
                        }
                        if (this.q_renamed) {
                            a_renamed(iH, i3, z2);
                            this.q_renamed = false;
                        }
                        android.opengl.GLES20.glViewport(0, 0, iH, i3);
                        this.t_renamed.setParam(4097, a_renamed(this.u_renamed.a_renamed()));
                        if (z2) {
                            if (this.z_renamed && this.r_renamed) {
                                com.oplus.camera.util.Util.a_renamed(sVar.e_renamed(), iH, i3, "dump_retention_before");
                            }
                            if (!this.r_renamed) {
                                iDoOnPreviewProcess = this.t_renamed.processTexture(sVar.e_renamed(), this.m_renamed, this.n_renamed, new int[]{this.o_renamed.e_renamed()}, false);
                                obj = obj2;
                                i2 = -1;
                            } else {
                                com.sensetime.blur.STBlurPreview sTBlurPreview = this.t_renamed;
                                int iE = sVar.e_renamed();
                                i2 = -1;
                                obj = obj2;
                                iDoOnPreviewProcess = sTBlurPreview.doOnPreviewProcess(iE, this.m_renamed, this.n_renamed, iH, i3, this.u_renamed.C_renamed(), new int[]{this.o_renamed.e_renamed()}, z2, false);
                            }
                            if (this.z_renamed && this.r_renamed) {
                                com.oplus.camera.util.Util.a_renamed(this.o_renamed.e_renamed(), this.o_renamed.h_renamed(), this.o_renamed.i_renamed(), "dump_retention_after");
                            }
                            iProcessTextureGradual = iDoOnPreviewProcess;
                            z_renamed = true;
                            i_renamed = i2;
                        } else {
                            obj = obj2;
                            i_renamed = -1;
                            int i4 = this.l_renamed;
                            int i5 = 180;
                            if (i4 != 0) {
                                if (i4 == 90) {
                                    i5 = 270;
                                } else if (i4 == 180) {
                                    i5 = 0;
                                } else if (i4 == 270) {
                                    i5 = 90;
                                }
                            }
                            this.t_renamed.rotateGrdualTexture(i5, false, false);
                            z_renamed = true;
                            iProcessTextureGradual = this.t_renamed.processTextureGradual(sVar.e_renamed(), this.m_renamed, this.n_renamed, new float[]{1.0f, 0.8f, 0.6f, 0.3f}, new int[]{this.o_renamed.e_renamed()}, false);
                        }
                        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                    } else {
                        z_renamed = true;
                        obj = obj2;
                        i_renamed = -1;
                        iProcessTextureGradual = -1;
                    }
                    android.opengl.GLES20.glViewport(0, 0, aVar.f6975a.d_renamed(), aVar.f6975a.e_renamed());
                    f6890a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                    if (iProcessTextureGradual != i_renamed) {
                        return z_renamed;
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    private float a_renamed(float f_renamed) {
        if (java.lang.Float.compare(f_renamed, 0.1f) <= 0) {
            return f_renamed;
        }
        if (java.lang.Float.compare(f_renamed, 0.3f) < 0) {
            return 0.4f;
        }
        if (java.lang.Float.compare(f_renamed, 0.4f) < 0) {
            return 0.5f;
        }
        if (java.lang.Float.compare(f_renamed, 0.5f) < 0) {
            return 0.6f;
        }
        if (java.lang.Float.compare(f_renamed, 0.6f) < 0) {
            return 0.7f;
        }
        if (java.lang.Float.compare(f_renamed, 0.8f) < 0) {
            return 0.8f;
        }
        return f_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "createEngine, sbBlurLicenseChecked: " + f6891b + ", mBlurPreviewHandlerThread: " + this.y_renamed + ", version: " + com.sensetime.blur.STBlurPreview.getVersion());
        if (-1 == this.m_renamed) {
            this.m_renamed = com.oplus.camera.util.k_renamed.a_renamed(android.graphics.BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_portrait.png"));
            this.n_renamed = com.oplus.camera.util.k_renamed.a_renamed(android.graphics.BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_background.png"));
        }
        if (this.y_renamed == null) {
            this.y_renamed = new android.os.HandlerThread("BlurPreviewHandlerThread");
            this.y_renamed.start();
            this.x_renamed = new android.os.Handler(this.y_renamed.getLooper()) { // from class: com.oplus.camera.ui.preview.a_renamed.e_renamed.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.oplus.camera.e_renamed.b_renamed("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, msg: " + message.what);
                    int i_renamed = message.what;
                    if (i_renamed == 1) {
                        com.oplus.camera.ui.preview.a_renamed.e_renamed.this.q_renamed();
                        return;
                    }
                    if (i_renamed != 2) {
                        if (i_renamed != 3) {
                            return;
                        }
                        synchronized (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.f6892c) {
                            if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed != null) {
                                com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed.destroy();
                                com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed = null;
                            }
                            com.oplus.camera.ui.preview.a_renamed.e_renamed.this.u_renamed = null;
                        }
                        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, MSG_DESTROY_BLUR_PREVIEW X_renamed");
                        return;
                    }
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.v_renamed = false;
                    synchronized (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.f6892c) {
                        if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed == null) {
                            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_MODEL)) {
                                com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed = new com.sensetime.blur.STBlurPreview(com.oplus.camera.ui.preview.a_renamed.e_renamed.this.j_renamed, true, "/odm/etc/camera/singleblur/portrait_retention_model.bin");
                            } else {
                                com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed = new com.sensetime.blur.STBlurPreview(com.oplus.camera.ui.preview.a_renamed.e_renamed.this.j_renamed, true);
                            }
                            com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed.setRetentionOpen(com.oplus.camera.ui.preview.a_renamed.e_renamed.this.r_renamed);
                        }
                    }
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.v_renamed = true;
                }
            };
        }
        if (!f6891b) {
            this.x_renamed.sendEmptyMessage(1);
        }
        synchronized (this.f6892c) {
            if (this.t_renamed == null) {
                this.x_renamed.sendEmptyMessage(2);
            } else {
                this.v_renamed = true;
            }
            this.u_renamed = aaVar;
            if (this.u_renamed != null) {
                this.u_renamed.a_renamed(this);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.e_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "destroyEngine");
                com.oplus.camera.ui.preview.a_renamed.e_renamed.this.v_renamed = false;
                synchronized (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.f6892c) {
                    if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed != null) {
                        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender");
                        com.oplus.camera.ui.preview.a_renamed.e_renamed.this.t_renamed.destroyRender();
                        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender X_renamed");
                    }
                }
                if (-1 != com.oplus.camera.ui.preview.a_renamed.e_renamed.this.m_renamed) {
                    com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.e_renamed.this.m_renamed);
                    com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.e_renamed.this.n_renamed);
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.m_renamed = -1;
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.n_renamed = -1;
                }
                if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.x_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.x_renamed.removeCallbacksAndMessages(null);
                    if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.y_renamed != null && com.oplus.camera.ui.preview.a_renamed.e_renamed.this.y_renamed.isAlive()) {
                        com.oplus.camera.ui.preview.a_renamed.e_renamed.this.x_renamed.sendEmptyMessage(3);
                    }
                }
                if (com.oplus.camera.ui.preview.a_renamed.e_renamed.this.y_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.y_renamed.quitSafely();
                    com.oplus.camera.ui.preview.a_renamed.e_renamed.this.y_renamed = null;
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.p_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        this.o_renamed = sVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "newTextures");
        this.p_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.d_renamed, this.k_renamed, true);
        this.o_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.d_renamed, this.k_renamed, true);
        this.w_renamed = true;
        synchronized (this.f6892c) {
            this.s_renamed = true;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.p_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.p_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.p_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.o_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.o_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.o_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "recycleTextures");
        if (this.w_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.p_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.p_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.o_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.o_renamed = null;
            }
            this.w_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.d_renamed = i2;
        this.k_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (this.f6892c) {
            this.q_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (this.t_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "initSTBlur, width: " + i_renamed + ", height: " + i2);
            this.t_renamed.initRender(i_renamed, i2, z_renamed);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "initSTBlur, X_renamed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        if (f6891b) {
            return;
        }
        byte[] bArrDecodeBuffer = null;
        if (new java.io.File("/odm/etc/camera/singleblur/license_release.lic").exists()) {
            byte[] bArrA = com.oplus.camera.a_renamed.c_renamed.a_renamed("singleblur/license_release.lic");
            bArrDecodeBuffer = new byte[bArrA.length + 1];
            java.lang.System.arraycopy(bArrA, 0, bArrDecodeBuffer, 0, bArrA.length);
            bArrDecodeBuffer[bArrA.length] = 0;
        } else if (new java.io.File("/odm/etc/camera/singleblur/license_release.license").exists()) {
            bArrDecodeBuffer = com.oplus.camera.jni.SecurityLicenseChecker.decodeBuffer(this.j_renamed, com.oplus.camera.a_renamed.c_renamed.a_renamed("singleblur/license_release.license"));
        }
        int iInitLicense = com.sensetime.faceapi.LicenseHelper.initLicense(bArrDecodeBuffer);
        if (iInitLicense != 0) {
            com.oplus.camera.e_renamed.f_renamed("BlurTexturePreview", "checkLicense failed, resultCode : " + iInitLicense);
            return;
        }
        f6891b = true;
        com.oplus.camera.e_renamed.a_renamed("BlurTexturePreview", "checkLicense success");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed
    public void b_renamed(boolean z_renamed) {
        synchronized (this.f6892c) {
            if (this.r_renamed != z_renamed) {
                this.r_renamed = z_renamed;
                this.s_renamed = true;
                if (this.t_renamed != null) {
                    this.t_renamed.setRetentionOpen(this.r_renamed);
                }
            }
        }
    }
}
