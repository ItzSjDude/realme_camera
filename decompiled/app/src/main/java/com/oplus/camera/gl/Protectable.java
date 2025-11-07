package com.oplus.camera.gl_renamed;

/* compiled from: BasicTexture.java */
/* loaded from: classes2.dex */
public abstract class c_renamed implements com.oplus.camera.gl_renamed.v_renamed {
    private static java.util.WeakHashMap<com.oplus.camera.gl_renamed.c_renamed, java.lang.Object> j_renamed = new java.util.WeakHashMap<>();
    private static java.lang.ThreadLocal k_renamed = new java.lang.ThreadLocal();

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f4611a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f4612b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f4613c;
    protected int d_renamed;
    protected int e_renamed;
    protected int f_renamed;
    protected com.oplus.camera.gl_renamed.h_renamed g_renamed;
    private long h_renamed;
    private long i_renamed;
    private boolean l_renamed;

    protected abstract boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar);

    public boolean d_renamed() {
        return false;
    }

    public abstract int m_renamed();

    protected c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2) {
        this.f4611a = -1;
        this.f4612b = -1;
        this.f4613c = -1;
        this.g_renamed = null;
        this.h_renamed = 0L;
        this.i_renamed = 0L;
        a_renamed(hVar);
        this.f4613c = i_renamed;
        this.d_renamed = i2;
        synchronized (j_renamed) {
            j_renamed.put(this, null);
        }
    }

    protected c_renamed() {
        this(null, 0, 0);
    }

    public static void a_renamed() {
        synchronized (j_renamed) {
            java.util.Iterator<com.oplus.camera.gl_renamed.c_renamed> it = j_renamed.keySet().iterator();
            while (it.hasNext()) {
                it.next().q_renamed();
            }
        }
    }

    public static void b_renamed() {
        synchronized (j_renamed) {
            for (com.oplus.camera.gl_renamed.c_renamed cVar : j_renamed.keySet()) {
                cVar.d_renamed = 0;
                cVar.a_renamed((com.oplus.camera.gl_renamed.h_renamed) null);
            }
        }
    }

    protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        this.g_renamed = hVar;
    }

    public com.oplus.camera.gl_renamed.h_renamed c_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f4611a = i_renamed;
        this.f4612b = i2;
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
        if (this.e_renamed > 4096 || this.f_renamed > 4096) {
            android.util.Log.w_renamed("BasicTexture", java.lang.String.format("texture is_renamed too large: %d_renamed x_renamed %d_renamed", java.lang.Integer.valueOf(this.e_renamed), java.lang.Integer.valueOf(this.f_renamed)), new java.lang.Exception());
        }
    }

    public int e_renamed() {
        return this.f4613c;
    }

    public int f_renamed() {
        return this.f4611a;
    }

    public int g_renamed() {
        return this.f4612b;
    }

    public int h_renamed() {
        return this.e_renamed;
    }

    public int i_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(long j2) {
        this.h_renamed = j2;
    }

    public long j_renamed() {
        return this.h_renamed;
    }

    public void b_renamed(long j2) {
        this.i_renamed = j2;
    }

    public long k_renamed() {
        return this.i_renamed;
    }

    public boolean l_renamed() {
        return this.l_renamed;
    }

    protected void a_renamed(boolean z_renamed) {
        this.l_renamed = z_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        hVar.a_renamed(this, i_renamed, i2, i3, i4);
    }

    public boolean n_renamed() {
        return this.d_renamed == 1;
    }

    public void o_renamed() {
        s_renamed();
    }

    public void p_renamed() {
        this.d_renamed = 0;
        a_renamed((com.oplus.camera.gl_renamed.h_renamed) null);
    }

    public void q_renamed() {
        s_renamed();
    }

    private void s_renamed() {
        com.oplus.camera.gl_renamed.h_renamed hVar = this.g_renamed;
        if (hVar != null && this.f4613c != -1) {
            hVar.a_renamed(this);
            this.f4613c = -1;
        }
        this.d_renamed = 0;
        a_renamed((com.oplus.camera.gl_renamed.h_renamed) null);
    }

    protected void finalize() {
        k_renamed.set(com.oplus.camera.gl_renamed.c_renamed.class);
        o_renamed();
        k_renamed.set(null);
    }
}
