package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: OplusBlurTexturePreview.java */
/* loaded from: classes2.dex */
public class r_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed implements com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f6947a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6948b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6949c;
    private int d_renamed;
    private int k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.gl_renamed.s_renamed m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private com.oplus.a_renamed.a_renamed q_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private android.os.Handler v_renamed;
    private android.os.HandlerThread w_renamed;

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

    public r_renamed(android.content.Context context) {
        super(context);
        this.f6947a = new java.lang.Object();
        this.f6948b = 0;
        this.f6949c = 0;
        this.d_renamed = -1;
        this.k_renamed = -1;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = true;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = false;
        this.t_renamed = false;
        this.u_renamed = false;
        this.v_renamed = null;
        this.w_renamed = null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed bVar) {
        synchronized (this.f6947a) {
            this.i_renamed = bVar;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
        if (this.s_renamed) {
            synchronized (this.f6947a) {
                if (this.o_renamed) {
                    return;
                }
                if (this.q_renamed != null && this.r_renamed != null && this.i_renamed != null) {
                    this.q_renamed.a_renamed(bArr, i_renamed, i2, this.r_renamed.C_renamed(), this.g_renamed, this.i_renamed.b_renamed());
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (this.f6947a) {
            if (this.r_renamed == null) {
                com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "canProcess, Engine has not init!");
                return false;
            }
            if (this.r_renamed.C_renamed() <= 0 && !this.o_renamed) {
                com.oplus.camera.e_renamed.f_renamed("OplusBlurTexturePreview", "canProcess, facesCount: " + this.r_renamed.C_renamed());
                return false;
            }
            if (!this.r_renamed.r_renamed()) {
                com.oplus.camera.e_renamed.f_renamed("OplusBlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.u_renamed) {
                return true;
            }
            com.oplus.camera.e_renamed.f_renamed("OplusBlurTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        int iA;
        if (this.r_renamed == null || aVar == null || aVar.f6977c == null || this.l_renamed == null) {
            return false;
        }
        if (!this.s_renamed) {
            com.oplus.camera.e_renamed.e_renamed("OplusBlurTexturePreview", "process, mSTBlurFilter not create, so return!");
            return false;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
        int iH = sVar.h_renamed();
        int i_renamed = sVar.i_renamed();
        synchronized (this.f6947a) {
            if (this.q_renamed != null) {
                if (this.n_renamed && this.q_renamed != null) {
                    b_renamed(iH, i_renamed);
                    this.n_renamed = false;
                }
                if (this.p_renamed) {
                    this.q_renamed.c_renamed();
                    this.q_renamed.a_renamed(6, this.o_renamed ? 1.0f : 0.0f);
                    this.p_renamed = false;
                }
                android.opengl.GLES20.glViewport(0, 0, iH, i_renamed);
                if (!this.o_renamed) {
                    this.q_renamed.a_renamed(0, this.r_renamed.a_renamed());
                    iA = this.q_renamed.a_renamed(sVar.e_renamed(), this.d_renamed, this.k_renamed, new int[]{this.l_renamed.e_renamed()});
                } else if (this.i_renamed != null) {
                    iA = this.q_renamed.a_renamed(sVar.e_renamed(), iH, i_renamed, this.r_renamed.C_renamed() <= 0 ? null : this.i_renamed.b_renamed(), this.d_renamed, this.k_renamed, new int[]{this.l_renamed.e_renamed()}, this.g_renamed);
                } else {
                    iA = -1;
                }
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            } else {
                iA = -1;
            }
        }
        android.opengl.GLES20.glViewport(0, 0, aVar.f6975a.d_renamed(), aVar.f6975a.e_renamed());
        return iA != -1;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "createEngine");
        if (-1 == this.d_renamed) {
            this.d_renamed = com.oplus.camera.util.k_renamed.a_renamed(android.graphics.BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_portrait.png"));
            this.k_renamed = com.oplus.camera.util.k_renamed.a_renamed(android.graphics.BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_background.png"));
        }
        if (this.w_renamed == null) {
            this.w_renamed = new android.os.HandlerThread("BlurPreviewHandlerThread");
            this.w_renamed.start();
            this.v_renamed = new android.os.Handler(this.w_renamed.getLooper()) { // from class: com.oplus.camera.ui.preview.a_renamed.r_renamed.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.oplus.camera.e_renamed.b_renamed("OplusBlurTexturePreview", "mBlurPreviewHandler, handleMessage, msg: " + message.what);
                    int i_renamed = message.what;
                    if (i_renamed != 0) {
                        if (i_renamed != 1) {
                            return;
                        }
                        synchronized (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.f6947a) {
                            if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed != null) {
                                com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed.a_renamed();
                                com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed = null;
                            }
                            com.oplus.camera.ui.preview.a_renamed.r_renamed.this.r_renamed = null;
                        }
                        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "mBlurPreviewHandler, handleMessage, MSG_DESTROY_BLUR_PREVIEW X_renamed");
                        return;
                    }
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.s_renamed = false;
                    synchronized (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.f6947a) {
                        if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed == null) {
                            com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed = new com.oplus.a_renamed.a_renamed();
                            com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.r_renamed.this.o_renamed);
                            com.oplus.camera.ui.preview.a_renamed.r_renamed.this.t_renamed = com.oplus.a_renamed.a_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.r_renamed.this.f6948b, com.oplus.camera.ui.preview.a_renamed.r_renamed.this.f6949c);
                            com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.r_renamed.this.j_renamed);
                        }
                        com.oplus.camera.ui.preview.a_renamed.r_renamed.this.s_renamed = com.oplus.camera.ui.preview.a_renamed.r_renamed.this.t_renamed;
                    }
                }
            };
        }
        synchronized (this.f6947a) {
            if (this.q_renamed == null) {
                this.v_renamed.sendEmptyMessage(0);
            } else {
                this.s_renamed = this.t_renamed;
            }
            this.r_renamed = aaVar;
            if (this.r_renamed != null) {
                this.r_renamed.a_renamed(this);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.r_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "destroyEngine");
                com.oplus.camera.ui.preview.a_renamed.r_renamed.this.s_renamed = false;
                synchronized (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.f6947a) {
                    if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.r_renamed.this.q_renamed.b_renamed();
                    }
                }
                if (-1 != com.oplus.camera.ui.preview.a_renamed.r_renamed.this.d_renamed) {
                    com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.r_renamed.this.d_renamed);
                    com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.r_renamed.this.k_renamed);
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.d_renamed = -1;
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.k_renamed = -1;
                }
                if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.v_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.v_renamed.removeCallbacksAndMessages(null);
                    if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.w_renamed != null && com.oplus.camera.ui.preview.a_renamed.r_renamed.this.w_renamed.isAlive()) {
                        com.oplus.camera.ui.preview.a_renamed.r_renamed.this.v_renamed.sendEmptyMessage(1);
                    }
                }
                if (com.oplus.camera.ui.preview.a_renamed.r_renamed.this.w_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.w_renamed.quitSafely();
                    com.oplus.camera.ui.preview.a_renamed.r_renamed.this.w_renamed = null;
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
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        this.l_renamed = sVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "newTextures");
        this.m_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6948b, this.f6949c, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6948b, this.f6949c, true);
        this.u_renamed = true;
        synchronized (this.f6947a) {
            this.p_renamed = true;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.m_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.m_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.l_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.l_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "recycleTextures");
        if (this.u_renamed) {
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
            this.u_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6948b = i2;
        this.f6949c = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (this.f6947a) {
            this.n_renamed = z_renamed;
        }
    }

    private void b_renamed(int i_renamed, int i2) {
        com.oplus.a_renamed.a_renamed aVar = this.q_renamed;
        if (aVar != null) {
            aVar.b_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed
    public void b_renamed(boolean z_renamed) {
        synchronized (this.f6947a) {
            if (this.o_renamed != z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("OplusBlurTexturePreview", "onRetentionOpenChanged, isOpen: " + z_renamed);
                this.o_renamed = z_renamed;
                this.p_renamed = true;
                if (this.q_renamed != null) {
                    this.q_renamed.a_renamed(z_renamed);
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int l_renamed() {
        int i_renamed;
        synchronized (this.f6947a) {
            i_renamed = this.o_renamed ? 1 : 0;
        }
        return i_renamed;
    }
}
