package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ag_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public float q_renamed;
    public android.graphics.PointF r_renamed;
    public float s_renamed;
    public float t_renamed;

    public ag_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("fringing"), context);
        this.q_renamed = 0.16f;
        this.r_renamed = new android.graphics.PointF(0.5f, 0.5f);
        this.s_renamed = 0.8f;
        this.t_renamed = 0.4f;
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("fringing2_vertex");
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        a_renamed("fringing", this.q_renamed);
        android.graphics.PointF pointF = this.r_renamed;
        a_renamed("fringing_center", pointF.x_renamed, pointF.y_renamed);
        a_renamed("fringing_radius", this.s_renamed);
        a_renamed("fringing_radius_inner", this.t_renamed);
    }
}
