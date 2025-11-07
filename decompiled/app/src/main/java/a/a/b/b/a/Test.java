package a_renamed.a_renamed.b_renamed.b_renamed.a_renamed;

/* loaded from: classes.dex */
public class d_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public java.util.Queue<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> n_renamed;
    public java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> o_renamed;
    public int p_renamed;
    public int q_renamed;
    public int r_renamed;
    public int s_renamed;
    public int[] t_renamed;
    public int[] u_renamed;
    public int v_renamed;

    public d_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        super(context, resources);
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 2;
        this.t_renamed = new int[1];
        this.u_renamed = new int[this.s_renamed];
        this.v_renamed = 0;
        this.o_renamed = new java.util.ArrayList();
        this.n_renamed = new java.util.concurrent.ConcurrentLinkedQueue();
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar) {
        this.n_renamed.add(aVar);
    }

    public void a_renamed(co_renamed.polarr.renderer.entities.Context context) {
        this.f15a = context;
    }

    public boolean a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, boolean z_renamed) {
        aVar.f15a = this.f15a;
        if (this.f15a.isLutRender && ((aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.c_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.av_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.f_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.bx_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.al_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.k_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.l_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.p_renamed) || (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.ad_renamed))) {
            return false;
        }
        if (!z_renamed && (aVar instanceof a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed) && ((a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed) aVar).l_renamed()) {
            return false;
        }
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u_renamed[this.v_renamed % 2], 0);
        int i_renamed = this.v_renamed;
        aVar.a_renamed(i_renamed == 0 ? b_renamed() : this.u_renamed[(i_renamed - 1) % 2]);
        aVar.a_renamed(this.j_renamed);
        aVar.draw();
        this.v_renamed++;
        return true;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
        this.p_renamed = i_renamed;
        this.q_renamed = i2;
        y_renamed();
        e_renamed(i_renamed, i2);
    }

    public boolean b_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar) {
        return a_renamed(aVar, false);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void d_renamed() {
    }

    public void d_renamed(int i_renamed, int i2) {
        int[] iArr = this.u_renamed;
        iArr[0] = i_renamed;
        iArr[1] = i2;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        w_renamed();
        o_renamed();
        p_renamed();
    }

    public final void e_renamed(int i_renamed, int i2) {
        this.p_renamed = i_renamed;
        this.q_renamed = i2;
        z_renamed();
        android.opengl.GLES20.glBindFramebuffer(36160, this.t_renamed[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u_renamed[0], 0);
        x_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        m_renamed();
    }

    public final void l_renamed() {
        android.opengl.GLES20.glBindFramebuffer(36160, this.t_renamed[0]);
        android.opengl.GLES20.glViewport(0, 0, this.p_renamed, this.q_renamed);
    }

    public final void m_renamed() {
        n_renamed();
        android.opengl.GLES20.glGenFramebuffers(1, this.t_renamed, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(this.t_renamed[0]);
        android.opengl.GLES20.glGenTextures(this.s_renamed, this.u_renamed, 0);
        for (int i_renamed : this.u_renamed) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(i_renamed);
        }
        for (int i2 = 0; i2 < this.s_renamed; i2++) {
            android.opengl.GLES20.glBindTexture(3553, this.u_renamed[i2]);
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        }
    }

    public void n_renamed() {
        android.opengl.GLES20.glDeleteFramebuffers(1, this.t_renamed, 0);
        android.opengl.GLES20.glDeleteTextures(this.s_renamed, this.u_renamed, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.d_renamed(this.t_renamed[0]);
        for (int i_renamed : this.u_renamed) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(i_renamed);
        }
        android.opengl.GLES20.glFlush();
    }

    public void o_renamed() {
        if (this.r_renamed > 0) {
            boolean z_renamed = false;
            for (int i_renamed = 0; i_renamed < this.o_renamed.size(); i_renamed++) {
                z_renamed = z_renamed || b_renamed(this.o_renamed.get(i_renamed));
            }
            if (z_renamed) {
                return;
            }
            a_renamed(this.o_renamed.get(0), true);
        }
    }

    public void p_renamed() {
        x_renamed();
    }

    public java.util.List<a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> q_renamed() {
        return this.o_renamed;
    }

    public int r_renamed() {
        int i_renamed = this.v_renamed;
        return i_renamed == 0 ? b_renamed() : this.u_renamed[(i_renamed - 1) % 2];
    }

    public void s_renamed() {
        x_renamed();
    }

    public void t_renamed() {
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u_renamed[this.v_renamed % 2], 0);
        this.v_renamed++;
    }

    public void u_renamed() {
        n_renamed();
    }

    public void v_renamed() {
        l_renamed();
    }

    public void w_renamed() {
        y_renamed();
        this.v_renamed = 0;
        l_renamed();
    }

    public final void x_renamed() {
        android.opengl.GLES20.glBindRenderbuffer(36161, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
    }

    public final void y_renamed() {
        while (true) {
            a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVarPoll = this.n_renamed.poll();
            if (aVarPoll == null) {
                return;
            }
            aVarPoll.a_renamed();
            aVarPoll.c_renamed(this.p_renamed, this.q_renamed);
            this.o_renamed.add(aVarPoll);
            this.r_renamed++;
        }
    }

    public final void z_renamed() {
        for (int i_renamed = 0; i_renamed < this.s_renamed; i_renamed++) {
            android.opengl.GLES20.glBindTexture(3553, this.u_renamed[i_renamed]);
            android.opengl.GLES20.glTexImage2D(3553, 0, 6408, this.p_renamed, this.q_renamed, 0, 6408, 5121, null);
        }
    }
}
