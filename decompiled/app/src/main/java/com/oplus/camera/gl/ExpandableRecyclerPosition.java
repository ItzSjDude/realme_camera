package com.oplus.camera.gl_renamed;

/* compiled from: UploadedTexture.java */
/* loaded from: classes2.dex */
public abstract class x_renamed extends com.oplus.camera.gl_renamed.c_renamed {
    private static java.util.HashMap<com.oplus.camera.gl_renamed.x_renamed.a_renamed, android.graphics.Bitmap> h_renamed = new java.util.HashMap<>();
    private static com.oplus.camera.gl_renamed.x_renamed.a_renamed j_renamed = new com.oplus.camera.gl_renamed.x_renamed.a_renamed();
    private static int k_renamed;
    protected android.graphics.Bitmap i_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private int p_renamed;

    protected abstract void a_renamed(android.graphics.Bitmap bitmap);

    protected abstract android.graphics.Bitmap d__renamed();

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public int m_renamed() {
        return 3553;
    }

    protected x_renamed(boolean z_renamed) {
        super(null, 0, 0);
        this.l_renamed = true;
        this.m_renamed = false;
        this.n_renamed = true;
        this.o_renamed = false;
        if (z_renamed) {
            a_renamed(true);
            this.p_renamed = 1;
        }
    }

    private static android.graphics.Bitmap a_renamed(boolean z_renamed, android.graphics.Bitmap.Config config, int i_renamed) {
        android.graphics.Bitmap bitmapA;
        com.oplus.camera.gl_renamed.x_renamed.a_renamed aVar = j_renamed;
        aVar.f4681a = z_renamed;
        aVar.f4682b = config;
        aVar.f4683c = i_renamed;
        android.graphics.Bitmap bitmap = h_renamed.get(aVar);
        if (bitmap != null) {
            return bitmap;
        }
        if (z_renamed) {
            bitmapA = com.oplus.camera.util.Util.a_renamed(1, i_renamed, config);
        } else {
            bitmapA = com.oplus.camera.util.Util.a_renamed(i_renamed, 1, config);
        }
        android.graphics.Bitmap bitmap2 = bitmapA;
        h_renamed.put(aVar.clone(), bitmap2);
        return bitmap2;
    }

    public static void s_renamed() {
        k_renamed = 0;
    }

    public static boolean t_renamed() {
        return k_renamed > 100;
    }

    private android.graphics.Bitmap v_renamed() {
        if (this.i_renamed == null) {
            this.i_renamed = d__renamed();
            int width = this.i_renamed.getWidth() + (this.p_renamed * 2);
            int height = this.i_renamed.getHeight() + (this.p_renamed * 2);
            if (this.f4611a == -1) {
                a_renamed(width, height);
            }
        }
        return this.i_renamed;
    }

    private void w_renamed() {
        a_renamed(this.i_renamed);
        this.i_renamed = null;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public int f_renamed() {
        if (this.f4611a == -1) {
            v_renamed();
        }
        return this.f4611a;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public int g_renamed() {
        if (this.f4611a == -1) {
            v_renamed();
        }
        return this.f4612b;
    }

    public boolean u_renamed() {
        return n_renamed() && this.l_renamed;
    }

    public void c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (!n_renamed()) {
            if (this.o_renamed) {
                int i_renamed = k_renamed + 1;
                k_renamed = i_renamed;
                if (i_renamed > 100) {
                    return;
                }
            }
            d_renamed(hVar);
            return;
        }
        if (this.l_renamed) {
            return;
        }
        android.graphics.Bitmap bitmapV = v_renamed();
        int internalFormat = android.opengl.GLUtils.getInternalFormat(bitmapV);
        int type = android.opengl.GLUtils.getType(bitmapV);
        int i2 = this.p_renamed;
        hVar.a_renamed(this, i2, i2, bitmapV, internalFormat, type);
        w_renamed();
        this.l_renamed = true;
    }

    private void d_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        boolean z_renamed;
        android.graphics.Bitmap bitmapV = v_renamed();
        try {
            if (bitmapV != null) {
                try {
                    int width = bitmapV.getWidth();
                    int height = bitmapV.getHeight();
                    int i_renamed = this.p_renamed;
                    int i2 = this.p_renamed;
                    int iH = h_renamed();
                    int i3 = i_renamed();
                    this.f4613c = hVar.a_renamed().b_renamed();
                    hVar.b_renamed(this);
                    if (width == iH && height == i3) {
                        hVar.a_renamed(this, bitmapV);
                    } else {
                        int internalFormat = android.opengl.GLUtils.getInternalFormat(bitmapV);
                        int type = android.opengl.GLUtils.getType(bitmapV);
                        android.graphics.Bitmap.Config config = bitmapV.getConfig();
                        hVar.a_renamed(this, internalFormat, type);
                        hVar.a_renamed(this, this.p_renamed, this.p_renamed, bitmapV, internalFormat, type);
                        if (this.p_renamed > 0) {
                            z_renamed = false;
                            hVar.a_renamed(this, 0, 0, a_renamed(true, config, i3), internalFormat, type);
                            hVar.a_renamed(this, 0, 0, a_renamed(false, config, iH), internalFormat, type);
                        } else {
                            z_renamed = false;
                        }
                        if (this.p_renamed + width < iH) {
                            hVar.a_renamed(this, this.p_renamed + width, 0, a_renamed(true, config, i3), internalFormat, type);
                        }
                        if (this.p_renamed + height < i3) {
                            hVar.a_renamed(this, 0, this.p_renamed + height, a_renamed(z_renamed, config, iH), internalFormat, type);
                        }
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                w_renamed();
                a_renamed(hVar);
                this.d_renamed = 1;
                this.l_renamed = true;
                return;
            }
            this.d_renamed = -1;
            throw new java.lang.RuntimeException("Texture load fail, no bitmap");
        } catch (java.lang.Throwable th) {
            w_renamed();
            throw th;
        }
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    protected boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        c_renamed(hVar);
        return u_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.v_renamed
    public boolean r_renamed() {
        return this.n_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public void o_renamed() {
        super.o_renamed();
        if (this.i_renamed != null) {
            w_renamed();
        }
    }

    /* compiled from: UploadedTexture.java */
    private static class a_renamed implements java.lang.Cloneable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f4681a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.graphics.Bitmap.Config f4682b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f4683c;

        private a_renamed() {
        }

        public int hashCode() {
            int iHashCode = this.f4682b.hashCode() ^ this.f4683c;
            return this.f4681a ? iHashCode : -iHashCode;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.oplus.camera.gl_renamed.x_renamed.a_renamed)) {
                return false;
            }
            com.oplus.camera.gl_renamed.x_renamed.a_renamed aVar = (com.oplus.camera.gl_renamed.x_renamed.a_renamed) obj;
            return this.f4681a == aVar.f4681a && this.f4682b == aVar.f4682b && this.f4683c == aVar.f4683c;
        }

        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.gl_renamed.x_renamed.a_renamed clone() {
            try {
                return (com.oplus.camera.gl_renamed.x_renamed.a_renamed) super.clone();
            } catch (java.lang.CloneNotSupportedException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            }
        }
    }
}
