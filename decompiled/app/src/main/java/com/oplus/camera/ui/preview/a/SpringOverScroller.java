package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: TexturePreview.java */
/* loaded from: classes2.dex */
public abstract class y_renamed {
    protected java.lang.String e_renamed = null;
    protected int f_renamed = 0;
    protected boolean g_renamed = false;
    protected com.oplus.camera.gl_renamed.GLRootView h_renamed = null;
    protected com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed i_renamed = null;
    protected android.content.Context j_renamed;

    /* compiled from: TexturePreview.java */
    public interface b_renamed {
        int a_renamed(int i_renamed, int i2);

        com.oplus.camera.u_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, long j_renamed);

        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

        void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar);

        void a_renamed(java.lang.String str);

        android.graphics.Rect[] b_renamed();
    }

    public void a_renamed(int i_renamed, int i2) {
    }

    public void a_renamed(long j_renamed) {
    }

    public void a_renamed(android.util.Size size, boolean z_renamed) {
    }

    public void a_renamed(com.oplus.camera.doubleexposure.c_renamed cVar) {
    }

    public abstract void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar);

    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
    }

    public abstract void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar);

    public void a_renamed(boolean z_renamed) {
    }

    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
    }

    public void a_renamed(byte[] bArr, byte[] bArr2, int i_renamed, int i2) {
    }

    public abstract boolean a_renamed();

    public abstract boolean a_renamed(int i_renamed);

    public abstract boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar);

    public abstract void b_renamed();

    public void b_renamed(int i_renamed) {
    }

    public abstract void c_renamed();

    public abstract int d_renamed();

    public void d_renamed(int i_renamed) {
    }

    public abstract void e_renamed();

    public abstract com.oplus.camera.gl_renamed.s_renamed f_renamed();

    public abstract com.oplus.camera.gl_renamed.s_renamed g_renamed();

    public abstract boolean h_renamed();

    public abstract void i_renamed();

    public abstract void j_renamed();

    public int k_renamed() {
        return 0;
    }

    public int l_renamed() {
        return 0;
    }

    public void m_renamed() {
    }

    public void n_renamed() {
    }

    public void o_renamed() {
    }

    public void p_renamed() {
    }

    public void u_renamed() {
    }

    public void v_renamed() {
    }

    public void w_renamed() {
    }

    public void x_renamed() {
    }

    public boolean y_renamed() {
        return false;
    }

    public int[] z_renamed() {
        return null;
    }

    public void s_renamed() {
        this.j_renamed = null;
    }

    public boolean a__renamed(int i_renamed) {
        return (com.oplus.camera.e_renamed.a_renamed.a_renamed(this.e_renamed, this.f_renamed).F_renamed().isPreviewAlgoDisable(d_renamed()) || (d_renamed() & i_renamed) == 0) ? false : true;
    }

    /* compiled from: TexturePreview.java */
    public class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public com.oplus.camera.gl_renamed.h_renamed f6975a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        public com.oplus.camera.gl_renamed.g_renamed f6976b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        public com.oplus.camera.gl_renamed.s_renamed f6977c = null;
        public com.oplus.camera.gl_renamed.s_renamed d_renamed = null;
        public com.oplus.camera.aps.util.CameraApsResult e_renamed = null;
        public boolean f_renamed = false;
        public boolean g_renamed = false;
        public boolean h_renamed = false;
        public float[] i_renamed = null;
        public int j_renamed = 0;
        public int k_renamed = 0;
        public int l_renamed = 0;
        public int m_renamed = 0;
        public int n_renamed = 0;
        public int o_renamed = 0;

        public a_renamed() {
        }

        public java.lang.String toString() {
            return "FrameInfo: mExtTexture: " + this.f6976b + ", mInTexture: " + this.f6977c + ", mWidth: " + this.j_renamed + ", mHeight: " + this.k_renamed + ", mRequestRenderType: " + this.n_renamed + ", mOrientation: " + this.o_renamed + ", mbApsAlgoInitFinish: " + this.h_renamed;
        }
    }

    public com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed t_renamed() {
        return new com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.b_renamed bVar) {
        this.i_renamed = bVar;
    }

    public y_renamed(android.content.Context context) {
        this.j_renamed = null;
        this.j_renamed = context;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.GLRootView gLRootView) {
        this.h_renamed = gLRootView;
    }

    public void a_renamed(java.lang.String str, int i_renamed) {
        this.e_renamed = str;
        this.f_renamed = i_renamed;
        this.g_renamed = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.f_renamed);
    }
}
