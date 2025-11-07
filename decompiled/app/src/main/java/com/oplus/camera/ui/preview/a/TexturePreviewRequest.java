package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: TexturePreviewRequest.java */
/* loaded from: classes2.dex */
public class aa_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.data.StickerItem f6833a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6834b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f6835c = "rosy_nude";
    private int d_renamed = 0;
    private boolean e_renamed = false;
    private java.lang.String f_renamed = "default";
    private int g_renamed = 0;
    private int h_renamed = -1;
    private int i_renamed = -1;
    private boolean j_renamed = false;
    private boolean k_renamed = false;
    private boolean l_renamed = true;
    private boolean m_renamed = false;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private float u_renamed = 1.0f;
    private float v_renamed = 1.0f;
    private boolean w_renamed = false;
    private float x_renamed = new java.math.BigDecimal(60).multiply(com.oplus.camera.d_renamed.f4358c).floatValue();
    private float y_renamed = 0.0f;
    private float z_renamed = 0.0f;
    private com.oplus.camera.tiltshift.TiltShiftParam A_renamed = null;
    private int[] B_renamed = null;
    private int[] C_renamed = null;
    private java.lang.String D_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed E_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed F_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed G_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed.b_renamed H_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed.a_renamed I_renamed = null;
    private android.graphics.Point J_renamed = new android.graphics.Point(0, 0);
    private com.oplus.camera.c_renamed.a_renamed K_renamed = null;
    private byte[] L_renamed = null;
    private long M_renamed = 0;
    private int N_renamed = 0;
    private boolean O_renamed = false;
    private int P_renamed = 5;

    /* compiled from: TexturePreviewRequest.java */
    public interface a_renamed {
        void c_renamed(int i_renamed);
    }

    /* compiled from: TexturePreviewRequest.java */
    public interface b_renamed {
        void a_renamed(float f_renamed);

        boolean a_renamed();
    }

    /* compiled from: TexturePreviewRequest.java */
    public interface c_renamed {
        void a_renamed(java.lang.String str);

        void b_renamed(boolean z_renamed);
    }

    /* compiled from: TexturePreviewRequest.java */
    public interface d_renamed {
        void b_renamed(boolean z_renamed);
    }

    /* compiled from: TexturePreviewRequest.java */
    public interface e_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(int[] iArr);

        void b_renamed(boolean z_renamed);

        void b_renamed(int[] iArr);
    }

    public void a_renamed(float f_renamed) {
        this.x_renamed = f_renamed;
    }

    public float a_renamed() {
        return this.x_renamed;
    }

    public boolean b_renamed() {
        return this.m_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void b_renamed(float f_renamed) {
        this.y_renamed = f_renamed;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed eVar = this.G_renamed;
        if (eVar != null) {
            eVar.a_renamed(f_renamed);
        }
    }

    public boolean c_renamed() {
        return this.w_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.w_renamed = z_renamed;
    }

    public boolean d_renamed() {
        return this.n_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    public void c_renamed(float f_renamed) {
        this.z_renamed = f_renamed;
    }

    public void a_renamed(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam) {
        this.A_renamed = tiltShiftParam;
    }

    public com.oplus.camera.tiltshift.TiltShiftParam e_renamed() {
        return this.A_renamed;
    }

    public float f_renamed() {
        return this.z_renamed;
    }

    public float g_renamed() {
        return this.y_renamed;
    }

    public boolean h_renamed() {
        return this.o_renamed;
    }

    public boolean i_renamed() {
        return this.p_renamed;
    }

    public void d_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public void e_renamed(boolean z_renamed) {
        this.p_renamed = z_renamed;
        N_renamed();
    }

    public void a_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed eVar = this.G_renamed;
        if (eVar != null) {
            eVar.a_renamed(iArr);
        }
    }

    public void b_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed eVar = this.G_renamed;
        if (eVar != null) {
            eVar.b_renamed(iArr);
        }
    }

    public void a_renamed(int i_renamed) {
        this.f6834b = i_renamed;
    }

    public int j_renamed() {
        return this.f6834b;
    }

    public void a_renamed(java.lang.String str) {
        this.f6835c = str;
    }

    public java.lang.String k_renamed() {
        return this.f6835c;
    }

    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public int l_renamed() {
        return this.d_renamed;
    }

    public void f_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    public boolean m_renamed() {
        return this.e_renamed;
    }

    public void b_renamed(java.lang.String str) {
        this.f_renamed = str;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed cVar = this.E_renamed;
        if (cVar != null) {
            cVar.a_renamed(str);
        }
    }

    public void g_renamed(boolean z_renamed) {
        this.N_renamed = z_renamed ? 1 : 2;
        M_renamed();
    }

    public boolean n_renamed() {
        return this.j_renamed;
    }

    public void h_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        this.f6833a = stickerItem;
    }

    public com.oplus.camera.sticker.data.StickerItem o_renamed() {
        return this.f6833a;
    }

    public boolean p_renamed() {
        return this.O_renamed;
    }

    public void i_renamed(boolean z_renamed) {
        this.O_renamed = z_renamed;
    }

    public void c_renamed(int[] iArr) {
        this.B_renamed = com.oplus.camera.util.Util.a_renamed(iArr);
    }

    public int[] q_renamed() {
        return this.B_renamed;
    }

    public boolean r_renamed() {
        return this.l_renamed;
    }

    public boolean s_renamed() {
        return this.f6833a != null;
    }

    public void a_renamed(byte[] bArr) {
        synchronized (this) {
            this.L_renamed = bArr;
        }
    }

    public byte[] t_renamed() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.L_renamed;
        }
        return bArr;
    }

    public void a_renamed(long j_renamed) {
        synchronized (this) {
            this.M_renamed = j_renamed;
        }
    }

    public long u_renamed() {
        long j_renamed;
        synchronized (this) {
            j_renamed = this.M_renamed;
        }
        return j_renamed;
    }

    public void a_renamed(com.oplus.camera.c_renamed.a_renamed aVar) {
        if (aVar != null) {
            this.K_renamed = aVar;
            this.q_renamed = true;
        } else {
            this.K_renamed = null;
            this.q_renamed = false;
        }
    }

    public android.graphics.Bitmap v_renamed() {
        com.oplus.camera.c_renamed.a_renamed aVar = this.K_renamed;
        if (aVar == null) {
            return null;
        }
        return aVar.f_renamed();
    }

    public int w_renamed() {
        com.oplus.camera.c_renamed.a_renamed aVar = this.K_renamed;
        if (aVar == null) {
            return 0;
        }
        return aVar.d_renamed();
    }

    public int x_renamed() {
        com.oplus.camera.c_renamed.a_renamed aVar = this.K_renamed;
        if (aVar == null) {
            return 0;
        }
        return aVar.e_renamed();
    }

    public boolean y_renamed() {
        return this.q_renamed;
    }

    public void j_renamed(boolean z_renamed) {
        this.r_renamed = z_renamed;
    }

    public boolean z_renamed() {
        return this.r_renamed;
    }

    public boolean A_renamed() {
        return this.s_renamed;
    }

    public void k_renamed(boolean z_renamed) {
        this.s_renamed = z_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public int B_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(android.graphics.Point point) {
        this.J_renamed = point;
    }

    public void d_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public int C_renamed() {
        return this.h_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed cVar) {
        this.E_renamed = cVar;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed cVar2 = this.E_renamed;
        if (cVar2 != null) {
            cVar2.b_renamed(this.l_renamed);
            this.E_renamed.a_renamed(this.f_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed dVar) {
        this.F_renamed = dVar;
        M_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed eVar) {
        this.G_renamed = eVar;
        N_renamed();
    }

    private void M_renamed() {
        int i_renamed;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.d_renamed dVar = this.F_renamed;
        if (dVar == null || (i_renamed = this.N_renamed) == 0) {
            return;
        }
        dVar.b_renamed(1 == i_renamed);
        this.N_renamed = 0;
    }

    public void l_renamed(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public boolean D_renamed() {
        return this.t_renamed;
    }

    public void d_renamed(float f_renamed) {
        this.u_renamed = f_renamed;
    }

    public void e_renamed(float f_renamed) {
        this.v_renamed = f_renamed;
    }

    public float E_renamed() {
        return this.u_renamed;
    }

    public float F_renamed() {
        return this.v_renamed;
    }

    private void N_renamed() {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed eVar = this.G_renamed;
        if (eVar != null) {
            eVar.b_renamed(this.p_renamed);
        }
    }

    public void G_renamed() {
        this.E_renamed = null;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.b_renamed bVar) {
        this.H_renamed = bVar;
    }

    public com.oplus.camera.ui.preview.a_renamed.aa_renamed.b_renamed H_renamed() {
        return this.H_renamed;
    }

    public android.graphics.Point I_renamed() {
        return this.J_renamed;
    }

    public int J_renamed() {
        return this.P_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed.a_renamed aVar) {
        this.I_renamed = aVar;
    }

    public void e_renamed(int i_renamed) {
        this.P_renamed = i_renamed;
        g_renamed(i_renamed);
    }

    private void g_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed.a_renamed aVar = this.I_renamed;
        if (aVar != null) {
            aVar.c_renamed(i_renamed);
        }
    }

    public int K_renamed() {
        return this.k_renamed ? 1 : 0;
    }

    public void m_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    public int L_renamed() {
        return this.i_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
    }
}
