package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: BaseScrollBar.java */
/* loaded from: classes2.dex */
public abstract class b_renamed extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.os.Handler f6475a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.gl_renamed.m_renamed f6476b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed f6477c;
    protected com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed d_renamed;
    protected boolean e_renamed;
    protected int f_renamed;
    protected final android.view.animation.Interpolator g_renamed;
    protected int h_renamed;
    protected int i_renamed;
    protected float j_renamed;
    protected float k_renamed;
    protected float l_renamed;
    protected float m_renamed;
    protected float n_renamed;
    protected float o_renamed;
    protected float p_renamed;
    protected float q_renamed;
    protected boolean r_renamed;
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed s_renamed;
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed t_renamed;
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed u_renamed;
    com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed v_renamed;
    private int w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;

    /* compiled from: BaseScrollBar.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(int i_renamed, boolean z_renamed);

        void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar);

        boolean a_renamed(int i_renamed);

        boolean b_renamed();

        int c_renamed();

        int d_renamed();
    }

    protected abstract void a_renamed(float f_renamed);

    protected abstract void a_renamed(android.view.MotionEvent motionEvent);

    protected abstract void b_renamed(float f_renamed);

    protected abstract void b_renamed(android.view.MotionEvent motionEvent);

    protected abstract int c_renamed(float f_renamed);

    protected abstract float d_renamed(int i_renamed);

    protected abstract void l_renamed();

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    public b_renamed(android.content.Context context) {
        this(context, null, 0);
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6475a = null;
        this.f6476b = null;
        this.w_renamed = 1;
        this.f6477c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.x_renamed = false;
        this.y_renamed = false;
        this.f_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        this.g_renamed = new android.view.animation.Interpolator() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f_renamed) {
                float f2 = f_renamed - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        this.r_renamed = false;
        this.s_renamed = new com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.3
            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void a_renamed(final float f_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6475a.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iC = com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(f_renamed);
                        if (iC == com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f_renamed || com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iC, com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.p_renamed)) {
                            return;
                        }
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(iC);
                    }
                });
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void b_renamed(final float f_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = com.oplus.camera.ui.menu.levelcontrol.b_renamed.this;
                bVar.e_renamed = false;
                bVar.f6475a.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.b_renamed(0);
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(f_renamed));
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.setScrolling(false);
                    }
                });
            }
        };
        this.t_renamed = new com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.4
            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void a_renamed(float f_renamed) {
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void b_renamed(final float f_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = com.oplus.camera.ui.menu.levelcontrol.b_renamed.this;
                bVar.e_renamed = false;
                bVar.f6475a.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.b_renamed(0);
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.setScrolling(false);
                    }
                });
            }
        };
        this.u_renamed = new com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.5
            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void a_renamed(final float f_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6475a.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iC = com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(f_renamed);
                        if (iC == com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f_renamed || com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iC, com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.p_renamed)) {
                            return;
                        }
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(iC);
                    }
                });
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed
            public void b_renamed(final float f_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6475a.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.c_renamed(f_renamed));
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.l_renamed();
                    }
                });
            }
        };
        this.v_renamed = new com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.6
            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.d_renamed.a_renamed();
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed
            public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.d_renamed.a_renamed(jVar);
                if (com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.d_renamed()) {
                    return;
                }
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.e_renamed();
                    }
                });
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed
            public void b_renamed() {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.i_renamed();
                    }
                });
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.BaseScrollBar, i_renamed, 0);
        this.h_renamed = typedArrayObtainStyledAttributes.getInt(0, 0);
        this.i_renamed = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, 0);
        this.k_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.l_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.m_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.n_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 0);
        this.o_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.p_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
        this.q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 0);
        typedArrayObtainStyledAttributes.recycle();
        setOpaque(false);
        setSurfaceTextureListener(this);
        this.f6475a = new android.os.Handler(android.os.Looper.myLooper());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "onSurfaceTextureAvailable");
        this.f6476b = new com.oplus.camera.gl_renamed.m_renamed(surfaceTexture);
        if (this.w_renamed == 1) {
            this.f6476b.a_renamed(true);
        }
        this.f6476b.a_renamed(2);
        this.f6476b.a_renamed(8, 8, 8, 8, 16, 0);
        this.f6476b.a_renamed(this.f6477c);
        this.f6476b.b_renamed(0);
        this.f6476b.a_renamed((android.view.SurfaceHolder) null);
        this.f6476b.a_renamed(null, 0, i_renamed, i2);
        this.y_renamed = true;
        b_renamed(this.d_renamed.c_renamed());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "onSurfaceTextureSizeChanged");
        this.f6476b.a_renamed(null, 0, i_renamed, i2);
        this.f6476b.d_renamed();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "onSurfaceTextureDestroyed");
        this.f6476b.b_renamed((android.view.SurfaceHolder) null);
        this.f6476b.e_renamed();
        return false;
    }

    public void setScrollBarTextureViewCallback(com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    public void setCameraEntryType(int i_renamed) {
        this.w_renamed = i_renamed;
    }

    public void setFilterCategory(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.f6477c.a_renamed(aVar);
    }

    public void a_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar;
        if (this.f6476b == null || (jVar = this.f6477c) == null || !jVar.h_renamed() || e_renamed()) {
            return;
        }
        this.f6476b.d_renamed();
    }

    public void a_renamed(final int i_renamed, final int i2) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "notifyPreviewSizeChanged, Size: " + i_renamed + " x_renamed " + i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (com.oplus.camera.util.Util.d_renamed(i2, i_renamed) == 2) {
            fArr[0] = 0.0f;
        }
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
        if (jVar != null) {
            jVar.a_renamed(fArr);
        }
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            mVar.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.a_renamed(i_renamed, i2);
                }
            });
            this.f6476b.d_renamed();
        }
    }

    public void b_renamed() {
        this.r_renamed = false;
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            mVar.g_renamed();
        }
    }

    public void c_renamed() {
        this.r_renamed = true;
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
            if (jVar != null) {
                jVar.a_renamed(mVar);
            }
            this.f6476b.f_renamed();
            this.f6476b.h_renamed();
        }
        this.e_renamed = false;
        setScrolling(false);
    }

    public void d_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar;
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar == null || (jVar = this.f6477c) == null) {
            return;
        }
        jVar.b_renamed(mVar);
    }

    public void setScrolling(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "setScrolling, isScrolling: " + this.x_renamed + " -> " + z_renamed);
        this.x_renamed = z_renamed;
    }

    public boolean e_renamed() {
        return this.x_renamed;
    }

    public void a_renamed(final com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "createTextures, mGLProducer: " + this.f6476b);
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            mVar.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.8
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.a_renamed(com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.p_renamed, com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.q_renamed);
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.a_renamed(iVar, !com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.a_renamed(iVar));
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.c_renamed();
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.b_renamed(iVar.l_renamed());
                }
            });
        }
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        if (this.f6476b != null) {
            this.f6477c.a_renamed(i_renamed, str);
        }
    }

    public void a_renamed(final int i_renamed) {
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            mVar.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.c_renamed(i_renamed);
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.d_renamed();
                }
            });
        }
    }

    public void b_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
        j_renamed();
        a_renamed(d_renamed(i_renamed), false);
    }

    protected void c_renamed(int i_renamed) {
        a_renamed(i_renamed, true);
    }

    protected void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "onItemChanged, index: " + this.f_renamed + " -> " + i_renamed + ", hasTexturesInited: " + k_renamed() + ", isFromSlide: " + z_renamed);
        if (i_renamed == this.f_renamed || !k_renamed()) {
            return;
        }
        this.f6477c.a_renamed(i_renamed);
        this.d_renamed.a_renamed(i_renamed, z_renamed);
        this.f_renamed = i_renamed;
    }

    public void f_renamed() {
        this.e_renamed = false;
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("BaseScrollBar", "slideToNextItem, texture not init, so return");
            return;
        }
        if (this.f_renamed >= getModelNum() - 1) {
            return;
        }
        int i_renamed = this.f_renamed + 1;
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "slideToNextItem, index: " + this.f_renamed + " -> " + i_renamed);
        j_renamed();
        a_renamed(d_renamed(i_renamed), 26, this.g_renamed, this.s_renamed);
    }

    public void g_renamed() {
        this.e_renamed = false;
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("BaseScrollBar", "slideToPreviousItem, texture not init, so return");
            return;
        }
        if (this.f_renamed <= this.d_renamed.d_renamed()) {
            return;
        }
        int i_renamed = this.f_renamed - 1;
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "slideToPreviousItem, index: " + this.f_renamed + " -> " + i_renamed);
        j_renamed();
        a_renamed(d_renamed(i_renamed), 26, this.g_renamed, this.s_renamed);
    }

    public void h_renamed() {
        this.e_renamed = false;
        float fD_renamed = d_renamed(c_renamed(getCurrPosition()));
        if (java.lang.Float.compare(fD_renamed, getCurrPosition()) != 0) {
            com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "forceScrollNearWithNoAnim, position: " + getCurrPosition() + " -> " + fD_renamed);
            j_renamed();
            a_renamed(fD_renamed, true);
        }
    }

    public void i_renamed() {
        if (this.y_renamed) {
            this.f6476b.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.10
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c == null || !com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.d_renamed()) {
                        return;
                    }
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.a_renamed(com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.p_renamed, com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.q_renamed);
                    com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6477c.f_renamed();
                }
            });
        } else {
            com.oplus.camera.e_renamed.f_renamed("BaseScrollBar", "notifyGLModelParam, GLProducer has not been init.");
        }
    }

    protected boolean a_renamed(float f_renamed, int i_renamed, android.view.animation.Interpolator interpolator, com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed bVar) {
        float currPosition = f_renamed - getCurrPosition();
        if (!this.r_renamed && this.f6477c != null && java.lang.Float.compare(currPosition, 0.0f) != 0) {
            setScrolling(true);
            this.f6477c.a_renamed(getCurrPosition(), currPosition, i_renamed, interpolator, bVar);
            this.f6476b.b_renamed(1);
            ((android.app.Activity) getContext()).runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.b_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b != null) {
                        com.oplus.camera.ui.menu.levelcontrol.b_renamed.this.f6476b.b_renamed();
                    }
                }
            });
            return true;
        }
        this.e_renamed = false;
        return false;
    }

    protected void a_renamed(float f_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "moveToPosition, position: " + getCurrPosition() + " -> " + f_renamed);
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
        if (jVar != null) {
            jVar.a_renamed(f_renamed, 0.0f, 0, null, null);
            com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
            if (mVar != null) {
                mVar.d_renamed();
            }
            if (z_renamed) {
                c_renamed(c_renamed(f_renamed));
            }
        }
    }

    protected void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BaseScrollBar", "cancelScrollAnim");
        android.os.Handler handler = this.f6475a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.e_renamed = false;
        setScrolling(false);
        com.oplus.camera.gl_renamed.m_renamed mVar = this.f6476b;
        if (mVar != null) {
            mVar.b_renamed(0);
        }
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
        if (jVar != null) {
            jVar.a_renamed();
        }
    }

    protected boolean k_renamed() {
        return getModelNum() > 0;
    }

    protected int getModelNum() {
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
        if (jVar != null) {
            return jVar.g_renamed();
        }
        return 0;
    }

    protected float getCurrPosition() {
        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = this.f6477c;
        if (jVar != null) {
            return jVar.b_renamed();
        }
        return 0.0f;
    }

    protected float getElementWidth() {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.A_renamed();
    }

    protected float getElementHeight() {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.B_renamed();
    }

    protected float getElementGap() {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.C_renamed();
    }

    protected float getElementImageSize() {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.z_renamed();
    }
}
