package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: OesDrawerEngine.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.b_renamed.d_renamed f4605a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.b_renamed.c_renamed f4606b;
    private com.oplus.camera.gl_renamed.g_renamed d_renamed;
    private com.oplus.camera.gl_renamed.g_renamed e_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.s_renamed f4607c = null;
    private int f_renamed = -1;

    public f_renamed() {
        this.f4605a = null;
        this.f4606b = null;
        this.d_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
        this.e_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
        this.f4605a = new com.oplus.camera.gl_renamed.b_renamed.g_renamed();
        this.f4606b = new com.oplus.camera.gl_renamed.b_renamed.b_renamed();
        if (this.d_renamed == null) {
            this.d_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
        }
        if (this.e_renamed == null) {
            this.e_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
        }
    }

    public void a_renamed() {
        this.f4605a.e__renamed();
        this.f4606b.b_renamed();
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "release");
        if (this.f4605a != null) {
            com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "recycleTextures, mSqureOesDrawer");
            this.f4605a.b_renamed();
            this.f4605a = null;
        }
        if (this.f4606b != null) {
            com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "recycleTextures, mFboDrawer");
            this.f4606b.c_renamed();
            this.f4606b = null;
        }
        if (this.d_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.d_renamed.e_renamed());
            this.d_renamed.o_renamed();
            this.d_renamed = null;
        }
        if (this.e_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.e_renamed.e_renamed());
            this.e_renamed.o_renamed();
            this.e_renamed = null;
        }
        if (this.f4607c != null) {
            com.oplus.camera.e_renamed.a_renamed("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.f4607c.e_renamed());
            this.f4607c.o_renamed();
            this.f4607c = null;
        }
    }

    public int c_renamed() {
        return this.d_renamed.e_renamed();
    }

    public int d_renamed() {
        return this.e_renamed.e_renamed();
    }

    public com.oplus.camera.gl_renamed.g_renamed e_renamed() {
        return this.e_renamed;
    }

    public int a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, android.util.Size size, android.util.Size size2, int i3, boolean z_renamed, com.oplus.camera.gl_renamed.b_renamed.h_renamed hVar2) {
        hVar2.a_renamed(size, size2, i3, hVar2.n_renamed());
        if (this.f4607c == null) {
            this.f4607c = new com.oplus.camera.gl_renamed.s_renamed(hVar2.l_renamed(), hVar2.k_renamed(), true);
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = this.f4607c;
        if (sVar != null && !sVar.n_renamed()) {
            this.f4607c.c_renamed(hVar);
        }
        if (a_renamed(size2, size, i3, hVar2.n_renamed())) {
            this.f_renamed = this.f4605a.a_renamed(i_renamed, i2, size, size2, i3, hVar2.n_renamed(), z_renamed, hVar2, this.f4607c);
            this.f4606b.a_renamed(this.f_renamed, i_renamed, i2, size, size2, i3, hVar2.n_renamed(), hVar2);
        } else {
            com.oplus.camera.e_renamed.f_renamed("OesDrawerEngine", "skip the frame, size does not match the type");
        }
        return this.f_renamed;
    }

    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.f4607c;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.gl_renamed.b_renamed.d_renamed dVar = this.f4605a;
        if (dVar != null) {
            dVar.a_renamed(z_renamed);
        }
    }

    private boolean a_renamed(android.util.Size size, android.util.Size size2, int i_renamed, boolean z_renamed) {
        if (i_renamed != 0) {
            if (i_renamed != 1) {
                if (i_renamed == 2 && (!com.oplus.camera.util.Util.a_renamed(size, 1.7777777777777777d) || !com.oplus.camera.util.Util.a_renamed(size2, 1.7777777777777777d))) {
                    return false;
                }
            } else if (z_renamed) {
                if (size2.getHeight() != size2.getWidth()) {
                    return false;
                }
            } else if (size.getHeight() != size.getWidth()) {
                return false;
            }
        } else if (size.getWidth() != size2.getWidth() || size.getHeight() != size2.getHeight()) {
            return false;
        }
        return true;
    }
}
