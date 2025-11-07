package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class r_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public float q_renamed;
    public boolean r_renamed;

    public r_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("vertical_stripes"), context);
        this.q_renamed = 0.5f;
        this.r_renamed = false;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(this.f15a);
        a_renamed("imageSize", fArrB[0], fArrB[1]);
        a_renamed("strength", this.q_renamed);
        a_renamed("axis", this.r_renamed ? 0.0f : 1.0f);
    }
}
