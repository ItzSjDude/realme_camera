package androidx.dynamicanimation.a_renamed;

/* compiled from: SpringAnimation.java */
/* loaded from: classes.dex */
public final class f_renamed extends androidx.dynamicanimation.a_renamed.c_renamed<androidx.dynamicanimation.a_renamed.f_renamed> {
    private androidx.dynamicanimation.a_renamed.g_renamed w_renamed;
    private float x_renamed;
    private boolean y_renamed;

    public f_renamed(androidx.dynamicanimation.a_renamed.e_renamed eVar) {
        super(eVar);
        this.w_renamed = null;
        this.x_renamed = Float.MAX_VALUE;
        this.y_renamed = false;
    }

    public <K_renamed> f_renamed(K_renamed k_renamed, androidx.dynamicanimation.a_renamed.d_renamed<K_renamed> dVar, float f_renamed) {
        super(k_renamed, dVar);
        this.w_renamed = null;
        this.x_renamed = Float.MAX_VALUE;
        this.y_renamed = false;
        this.w_renamed = new androidx.dynamicanimation.a_renamed.g_renamed(f_renamed);
    }

    public androidx.dynamicanimation.a_renamed.g_renamed e_renamed() {
        return this.w_renamed;
    }

    public androidx.dynamicanimation.a_renamed.f_renamed a_renamed(androidx.dynamicanimation.a_renamed.g_renamed gVar) {
        this.w_renamed = gVar;
        return this;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    public void a_renamed() {
        f_renamed();
        this.w_renamed.a_renamed(d_renamed());
        super.a_renamed();
    }

    public void a_renamed(float f_renamed) {
        if (c_renamed()) {
            this.x_renamed = f_renamed;
            return;
        }
        if (this.w_renamed == null) {
            this.w_renamed = new androidx.dynamicanimation.a_renamed.g_renamed(f_renamed);
        }
        this.w_renamed.c_renamed(f_renamed);
        a_renamed();
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    public void b_renamed() {
        super.b_renamed();
        float f_renamed = this.x_renamed;
        if (f_renamed != Float.MAX_VALUE) {
            androidx.dynamicanimation.a_renamed.g_renamed gVar = this.w_renamed;
            if (gVar == null) {
                this.w_renamed = new androidx.dynamicanimation.a_renamed.g_renamed(f_renamed);
            } else {
                gVar.c_renamed(f_renamed);
            }
            this.x_renamed = Float.MAX_VALUE;
        }
    }

    private void f_renamed() {
        androidx.dynamicanimation.a_renamed.g_renamed gVar = this.w_renamed;
        if (gVar == null) {
            throw new java.lang.UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a_renamed spring force needs to be_renamed set.");
        }
        double dA_renamed = gVar.a_renamed();
        if (dA_renamed > this.u_renamed) {
            throw new java.lang.UnsupportedOperationException("Final position of_renamed the spring cannot be_renamed greater than the max value.");
        }
        if (dA_renamed < this.v_renamed) {
            throw new java.lang.UnsupportedOperationException("Final position of_renamed the spring cannot be_renamed less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    boolean b_renamed(long j_renamed) {
        if (this.y_renamed) {
            float f_renamed = this.x_renamed;
            if (f_renamed != Float.MAX_VALUE) {
                this.w_renamed.c_renamed(f_renamed);
                this.x_renamed = Float.MAX_VALUE;
            }
            this.p_renamed = this.w_renamed.a_renamed();
            this.o_renamed = 0.0f;
            this.y_renamed = false;
            return true;
        }
        if (this.x_renamed != Float.MAX_VALUE) {
            long j2 = j_renamed / 2;
            androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVarA = this.w_renamed.a_renamed(this.p_renamed, this.o_renamed, j2);
            this.w_renamed.c_renamed(this.x_renamed);
            this.x_renamed = Float.MAX_VALUE;
            androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVarA2 = this.w_renamed.a_renamed(aVarA.f1077a, aVarA.f1078b, j2);
            this.p_renamed = aVarA2.f1077a;
            this.o_renamed = aVarA2.f1078b;
        } else {
            androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVarA3 = this.w_renamed.a_renamed(this.p_renamed, this.o_renamed, j_renamed);
            this.p_renamed = aVarA3.f1077a;
            this.o_renamed = aVarA3.f1078b;
        }
        this.p_renamed = java.lang.Math.max(this.p_renamed, this.v_renamed);
        this.p_renamed = java.lang.Math.min(this.p_renamed, this.u_renamed);
        if (!a_renamed(this.p_renamed, this.o_renamed)) {
            return false;
        }
        this.p_renamed = this.w_renamed.a_renamed();
        this.o_renamed = 0.0f;
        return true;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    boolean a_renamed(float f_renamed, float f2) {
        return this.w_renamed.a_renamed(f_renamed, f2);
    }
}
