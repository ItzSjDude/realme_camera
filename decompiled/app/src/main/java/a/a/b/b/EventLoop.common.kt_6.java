package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bm_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed implements java.lang.AutoCloseable {
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed q_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed r_renamed;

    public bm_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("bloom"), context);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        a_renamed(this.q_renamed);
        this.q_renamed = null;
        a_renamed(this.r_renamed);
        this.r_renamed = null;
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed d_renamed(int i_renamed, int i2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.q_renamed;
        if (dVar != null && (dVar.f35b != i_renamed || dVar.f36c != i2)) {
            a_renamed(this.q_renamed);
            this.q_renamed = null;
        }
        if (this.q_renamed == null) {
            this.q_renamed = a_renamed(i_renamed, i2, 6408);
        }
        return this.q_renamed;
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed e_renamed(int i_renamed, int i2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.r_renamed;
        if (dVar != null && (dVar.f35b != i_renamed || dVar.f36c != i2)) {
            a_renamed(this.r_renamed);
            this.r_renamed = null;
        }
        if (this.r_renamed == null) {
            this.r_renamed = a_renamed(i_renamed, i2, 6408);
        }
        return this.r_renamed;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
        super.e_renamed();
        a_renamed(this.q_renamed, c_renamed() + 1);
        a_renamed("blurTex", c_renamed() + 1);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
    }
}
