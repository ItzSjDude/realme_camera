package com.oplus.camera.ui.preview.a_renamed.b_renamed;

/* compiled from: VideoWatermarkTexturePreview.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.s_renamed f6875a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed f6876b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.b_renamed.a_renamed f6877c;
    private boolean d_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int[] r_renamed;
    private int[] s_renamed;
    private int[] t_renamed;

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
        return 128;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public b_renamed(android.content.Context context) {
        super(context);
        this.f6875a = null;
        this.f6876b = null;
        this.f6877c = null;
        this.d_renamed = false;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = new int[1];
        this.s_renamed = new int[1];
        this.t_renamed = new int[1];
        com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "VideoWatermarkTexturePreview");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "createEngine");
        this.f6876b = aaVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.b_renamed.-$$Lambda$b_renamed$HYAW0lgcN-Rovh0j7hJcG-b1r6w
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.q_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "destroyEngine");
        com.oplus.camera.ui.preview.a_renamed.b_renamed.a_renamed aVar = this.f6877c;
        if (aVar != null) {
            aVar.b_renamed();
            this.f6877c = null;
        }
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.f6876b;
        if (aaVar != null) {
            android.graphics.Bitmap bitmapV = aaVar.v_renamed();
            com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "destroyEngine, watermarkBitmap: " + bitmapV);
            if (bitmapV != null && !bitmapV.isRecycled()) {
                bitmapV.recycle();
            }
        }
        this.f6876b = null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.f6875a;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.b_renamed("VideoWatermarkTexturePreview", "newTextures, mPreviewTextureWidth: " + this.k_renamed + ", mPreviewTextureHeight: " + this.l_renamed);
        this.f6875a = new com.oplus.camera.gl_renamed.s_renamed(this.k_renamed, this.l_renamed, false);
        this.d_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        android.graphics.Bitmap bitmapV;
        com.oplus.camera.gl_renamed.s_renamed sVar = this.f6875a;
        if (sVar != null && !sVar.n_renamed()) {
            this.f6875a.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.f6875a.e_renamed());
        }
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.f6876b;
        if (aaVar != null && (bitmapV = aaVar.v_renamed()) != null && !bitmapV.isRecycled() && this.f6876b.A_renamed()) {
            this.m_renamed = bitmapV.getWidth();
            this.n_renamed = bitmapV.getHeight();
            this.o_renamed = this.f6876b.w_renamed();
            this.p_renamed = this.f6876b.x_renamed();
            if (android.opengl.GLES20.glIsTexture(this.r_renamed[0])) {
                android.opengl.GLES20.glDeleteTextures(1, this.r_renamed, 0);
                this.r_renamed[0] = 0;
            }
            android.opengl.GLES20.glGenTextures(1, this.r_renamed, 0);
            android.opengl.GLES20.glBindTexture(3553, this.r_renamed[0]);
            android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
            android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
            android.opengl.GLES20.glTexParameteri(3553, 10241, 9729);
            android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
            android.opengl.GLUtils.texImage2D(3553, 0, bitmapV, 0);
            this.f6876b.k_renamed(false);
            com.oplus.camera.e_renamed.b_renamed("VideoWatermarkTexturePreview", "prepareTextures, BitmapTexture: " + this.r_renamed[0]);
        }
        int[] iArr = this.s_renamed;
        if (iArr[0] == 0) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            int[] iArr2 = this.s_renamed;
            if (iArr2[0] == 0) {
                throw new java.lang.RuntimeException("Could not create a_renamed new texture buffer object, glErrorString: " + android.opengl.GLES20.glGetString(android.opengl.GLES20.glGetError()));
            }
            android.opengl.GLES20.glBindTexture(3553, iArr2[0]);
            android.opengl.GLES20.glTexParameteri(3553, 10241, 9728);
            android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
            android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
            android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
            android.opengl.GLES20.glTexImage2D(3553, 0, 6408, this.k_renamed, this.l_renamed, 0, 6408, 5121, null);
            com.oplus.camera.e_renamed.b_renamed("VideoWatermarkTexturePreview", "prepareTextures, mOutTextures: " + this.s_renamed[0]);
        }
        int[] iArr3 = this.t_renamed;
        if (iArr3[0] == 0) {
            android.opengl.GLES20.glGenFramebuffers(1, iArr3, 0);
            if (this.t_renamed[0] == 0) {
                throw new java.lang.RuntimeException("Could not create a_renamed new frame buffer object, glErrorString: " + android.opengl.GLES20.glGetString(android.opengl.GLES20.glGetError()));
            }
            com.oplus.camera.e_renamed.b_renamed("VideoWatermarkTexturePreview", "prepareTextures, mFBOs: " + this.t_renamed[0]);
        }
        if (this.f6877c == null) {
            this.f6877c = new com.oplus.camera.ui.preview.a_renamed.b_renamed.a_renamed();
        }
        this.f6877c.a_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        if (this.f6875a != null) {
            com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.f6875a.e_renamed());
            this.f6875a.o_renamed();
            this.f6875a = null;
        }
        android.opengl.GLES20.glDeleteFramebuffers(1, this.t_renamed, 0);
        android.opengl.GLES20.glDeleteTextures(1, this.r_renamed, 0);
        android.opengl.GLES20.glDeleteTextures(1, this.s_renamed, 0);
        this.t_renamed[0] = 0;
        this.r_renamed[0] = 0;
        this.s_renamed[0] = 0;
        this.d_renamed = false;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.f6876b;
        if (aaVar != null) {
            android.graphics.Bitmap bitmapV = aaVar.v_renamed();
            com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "recycleTextures, watermarkBitmap: " + bitmapV);
            if (bitmapV == null || bitmapV.isRecycled()) {
                return;
            }
            bitmapV.recycle();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        if (!this.d_renamed) {
            com.oplus.camera.e_renamed.e_renamed("VideoWatermarkTexturePreview", "canProcess, texture is_renamed not initialized");
            return false;
        }
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.f6876b;
        if (aaVar == null) {
            return false;
        }
        return aaVar.y_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        if (aVar == null || aVar.f6977c == null) {
            com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        a_renamed(this.s_renamed, this.t_renamed);
        android.opengl.GLES20.glClear(16640);
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glViewport(0, 0, this.k_renamed, this.l_renamed);
        aVar.f6975a.a_renamed(aVar.f6977c, aVar.i_renamed, aVar.l_renamed, aVar.m_renamed, aVar.j_renamed, aVar.k_renamed);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(1, 771);
        int i_renamed = ((this.q_renamed + aVar.o_renamed) - 90) % 360;
        if (i_renamed == 90) {
            int i2 = this.k_renamed;
            int i3 = this.n_renamed;
            android.opengl.GLES20.glViewport((i2 - i3) - this.p_renamed, this.o_renamed, i3, this.m_renamed);
        } else if (i_renamed == 180) {
            int i4 = this.k_renamed;
            int i5 = this.m_renamed;
            int i6 = (i4 - i5) - this.o_renamed;
            int i7 = this.l_renamed;
            int i8 = this.n_renamed;
            android.opengl.GLES20.glViewport(i6, (i7 - i8) - this.p_renamed, i5, i8);
        } else if (i_renamed == 270) {
            int i9 = this.p_renamed;
            int i10 = this.l_renamed;
            int i11 = this.m_renamed;
            android.opengl.GLES20.glViewport(i9, (i10 - i11) - this.o_renamed, this.n_renamed, i11);
        } else {
            android.opengl.GLES20.glViewport(this.o_renamed, this.p_renamed, this.m_renamed, this.n_renamed);
        }
        this.f6877c.a_renamed(this.r_renamed[0], false, i_renamed);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glViewport(0, 0, this.k_renamed, this.l_renamed);
        this.f6877c.a_renamed(this.s_renamed[0], true, i_renamed);
        android.opengl.GLES20.glDisable(3042);
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("VideoWatermarkTexturePreview", "setSize, width: " + i2 + ", height: " + i_renamed);
        this.k_renamed = i_renamed;
        this.l_renamed = i2;
    }

    private void a_renamed(int[] iArr, int[] iArr2) {
        for (int i_renamed = 0; i_renamed < iArr2.length; i_renamed++) {
            android.opengl.GLES20.glBindFramebuffer(36160, iArr2[i_renamed]);
            android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr[i_renamed], 0);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.f6876b;
        if (aaVar == null || aaVar.z_renamed() || this.f6876b.v_renamed() != null) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("VideoWatermarkTexturePreview", "setOrientation, orientation: " + i_renamed);
        this.q_renamed = i_renamed;
    }
}
