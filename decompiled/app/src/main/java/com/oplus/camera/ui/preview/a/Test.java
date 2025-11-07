package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: ArcsoftBlurTexturePreview.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f6886a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6887b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6888c;
    private int d_renamed;
    private com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.gl_renamed.s_renamed m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI q_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed r_renamed;
    private boolean s_renamed;
    private android.content.Context t_renamed;
    private android.graphics.Rect[] u_renamed;

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

    public d_renamed(android.content.Context context) {
        super(context);
        this.f6886a = new java.lang.Object();
        this.f6887b = 0;
        this.f6888c = 0;
        this.d_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.r_renamed = null;
        this.s_renamed = false;
        this.t_renamed = null;
        this.u_renamed = null;
        this.t_renamed = context;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed bVar) {
        synchronized (this.f6886a) {
            this.k_renamed = bVar;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (this.f6886a) {
            if (this.r_renamed == null) {
                return false;
            }
            if (this.r_renamed.C_renamed() <= 0) {
                if (this.o_renamed) {
                    this.o_renamed = false;
                }
                return false;
            }
            if (!this.r_renamed.r_renamed()) {
                com.oplus.camera.e_renamed.f_renamed("ArcsoftBlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.s_renamed) {
                return true;
            }
            com.oplus.camera.e_renamed.f_renamed("ArcsoftBlurTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        int iProcess;
        if (aVar == null || aVar.f6977c == null || this.l_renamed == null) {
            return false;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
        int iH = sVar.h_renamed();
        int i_renamed = sVar.i_renamed();
        synchronized (this.f6886a) {
            if (this.r_renamed == null) {
                return false;
            }
            if (this.n_renamed && this.q_renamed != null) {
                b_renamed(iH, i_renamed);
                this.n_renamed = false;
            }
            if (!this.p_renamed) {
                return false;
            }
            android.opengl.GLES20.glViewport(0, 0, iH, i_renamed);
            if (this.k_renamed != null) {
                this.u_renamed = this.k_renamed.b_renamed();
            }
            if (this.q_renamed == null || this.u_renamed == null || this.u_renamed.length <= 0) {
                iProcess = -1;
            } else {
                int length = this.u_renamed.length;
                int[] iArr = new int[length * 4];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (this.u_renamed[i2] == null) {
                        com.oplus.camera.e_renamed.f_renamed("ArcsoftBlurTexturePreview", "process, faceRects is_renamed null");
                        break;
                    }
                    iArr[i3] = iH - this.u_renamed[i2].bottom;
                    int i4 = i3 + 1;
                    iArr[i4] = i_renamed - this.u_renamed[i2].right;
                    int i5 = i4 + 1;
                    iArr[i5] = iH - this.u_renamed[i2].top;
                    int i6 = i5 + 1;
                    iArr[i6] = i_renamed - this.u_renamed[i2].left;
                    i3 = i6 + 1;
                    i2++;
                }
                int[] iArr2 = {10, 11, 12, 13};
                int i7 = this.d_renamed;
                int i8 = i7 != 0 ? i7 != 90 ? i7 != 180 ? i7 != 270 ? 0 : 1 : 2 : 4 : 3;
                java.lang.System.currentTimeMillis();
                if (!this.o_renamed && this.r_renamed.C_renamed() > 0) {
                    this.o_renamed = true;
                    this.q_renamed.forceUpdateFrame(com.oplus.camera.util.Util.C_renamed() ? 0 : 1);
                    com.oplus.camera.e_renamed.f_renamed("ArcsoftBlurTexturePreview", "process, forceUpdateFrame");
                }
                iProcess = this.q_renamed.process(sVar.e_renamed(), new int[]{this.l_renamed.e_renamed()}, length, iArr, iArr2, (int) (this.r_renamed.a_renamed() * 100.0f), i8);
                com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            }
            android.opengl.GLES20.glViewport(0, 0, aVar.f6975a.d_renamed(), aVar.f6975a.e_renamed());
            return iProcess != -1;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "createEngine,  reques: " + aaVar);
        synchronized (this.f6886a) {
            if (this.q_renamed == null) {
                this.q_renamed = new com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI();
                com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "createEngine, native version: " + this.q_renamed.getVersion());
            }
            this.r_renamed = aaVar;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        if (this.h_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "destroyEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.d_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.d_renamed.this.f6886a) {
                    if (com.oplus.camera.ui.preview.a_renamed.d_renamed.this.q_renamed != null && com.oplus.camera.ui.preview.a_renamed.d_renamed.this.p_renamed) {
                        int iRelease = com.oplus.camera.ui.preview.a_renamed.d_renamed.this.q_renamed.release();
                        com.oplus.camera.ui.preview.a_renamed.d_renamed.this.p_renamed = false;
                        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "destroyEngine, X_renamed ret: " + iRelease);
                    }
                    com.oplus.camera.ui.preview.a_renamed.d_renamed.this.q_renamed = null;
                    com.oplus.camera.ui.preview.a_renamed.d_renamed.this.r_renamed = null;
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
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "newTextures");
        this.m_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6887b, this.f6888c, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6887b, this.f6888c, true);
        this.s_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.m_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.m_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.l_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.l_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "recycleTextures");
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
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6887b = i2;
        this.f6888c = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "setTextureSizeChanged, sizeChanged: " + z_renamed);
        synchronized (this.f6886a) {
            this.n_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    private boolean b_renamed(int i_renamed, int i2) {
        if (this.p_renamed) {
            int iRelease = this.q_renamed.release();
            this.p_renamed = false;
            com.oplus.camera.e_renamed.f_renamed("ArcsoftBlurTexturePreview", "initSingleBokeh, release X_renamed ret: " + iRelease);
        }
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", "initSingleBokeh, srcWidth: " + i_renamed + ", srcHeight: " + i2 + ", outWidth: " + i_renamed + ", outHeight: " + i2 + ", format: 10, mCameraId: " + this.f_renamed);
        int iInit = this.q_renamed.init(i_renamed, i2, i_renamed, i2, 10, this.f_renamed, 1);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("initSingleBokeh, X_renamed ret: ");
        sb.append(iInit);
        com.oplus.camera.e_renamed.a_renamed("ArcsoftBlurTexturePreview", sb.toString());
        this.p_renamed = iInit == 0;
        return this.p_renamed;
    }
}
