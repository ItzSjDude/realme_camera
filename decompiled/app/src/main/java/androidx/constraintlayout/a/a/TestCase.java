package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.constraintlayout.a_renamed.a_renamed.f_renamed f708a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed f709b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed f710c;
    androidx.constraintlayout.a_renamed.h_renamed f_renamed;
    private androidx.constraintlayout.a_renamed.a_renamed.m_renamed g_renamed = new androidx.constraintlayout.a_renamed.a_renamed.m_renamed(this);
    public int d_renamed = 0;
    int e_renamed = -1;
    private androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed h_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.NONE;
    private androidx.constraintlayout.a_renamed.a_renamed.e_renamed.a_renamed i_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.a_renamed.RELAXED;
    private int j_renamed = 0;

    /* compiled from: ConstraintAnchor.java */
    public enum a_renamed {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    public enum b_renamed {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    public enum c_renamed {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public androidx.constraintlayout.a_renamed.a_renamed.m_renamed a_renamed() {
        return this.g_renamed;
    }

    public e_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar) {
        this.f708a = fVar;
        this.f709b = cVar;
    }

    public androidx.constraintlayout.a_renamed.h_renamed b_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.c_renamed cVar) {
        androidx.constraintlayout.a_renamed.h_renamed hVar = this.f_renamed;
        if (hVar == null) {
            this.f_renamed = new androidx.constraintlayout.a_renamed.h_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED, null);
        } else {
            hVar.b_renamed();
        }
    }

    public androidx.constraintlayout.a_renamed.a_renamed.f_renamed c_renamed() {
        return this.f708a;
    }

    public androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed d_renamed() {
        return this.f709b;
    }

    public int e_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar;
        if (this.f708a.m_renamed() == 8) {
            return 0;
        }
        if (this.e_renamed > -1 && (eVar = this.f710c) != null && eVar.f708a.m_renamed() == 8) {
            return this.e_renamed;
        }
        return this.d_renamed;
    }

    public androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed f_renamed() {
        return this.h_renamed;
    }

    public androidx.constraintlayout.a_renamed.a_renamed.e_renamed g_renamed() {
        return this.f710c;
    }

    public int h_renamed() {
        return this.j_renamed;
    }

    public void i_renamed() {
        this.f710c = null;
        this.d_renamed = 0;
        this.e_renamed = -1;
        this.h_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.STRONG;
        this.j_renamed = 0;
        this.i_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.a_renamed.RELAXED;
        this.g_renamed.b_renamed();
    }

    public boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar, int i_renamed, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed bVar, int i2) {
        return a_renamed(eVar, i_renamed, -1, bVar, i2, false);
    }

    public boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar, int i_renamed, int i2, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed bVar, int i3, boolean z_renamed) {
        if (eVar == null) {
            this.f710c = null;
            this.d_renamed = 0;
            this.e_renamed = -1;
            this.h_renamed = androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.NONE;
            this.j_renamed = 2;
            return true;
        }
        if (!z_renamed && !a_renamed(eVar)) {
            return false;
        }
        this.f710c = eVar;
        if (i_renamed > 0) {
            this.d_renamed = i_renamed;
        } else {
            this.d_renamed = 0;
        }
        this.e_renamed = i2;
        this.h_renamed = bVar;
        this.j_renamed = i3;
        return true;
    }

    public boolean j_renamed() {
        return this.f710c != null;
    }

    public boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar) {
        if (eVar == null) {
            return false;
        }
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVarD = eVar.d_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar = this.f709b;
        if (cVarD == cVar) {
            return cVar != androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE || (eVar.c_renamed().A_renamed() && c_renamed().A_renamed());
        }
        switch (this.f709b) {
            case CENTER:
                return (cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_X || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z_renamed = cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT;
                return eVar.c_renamed() instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed ? z_renamed || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_X : z_renamed;
            case TOP:
            case BOTTOM:
                boolean z2 = cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM;
                return eVar.c_renamed() instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed ? z2 || cVarD == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_Y : z2;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new java.lang.AssertionError(this.f709b.name());
        }
    }

    public java.lang.String toString() {
        return this.f708a.n_renamed() + ":" + this.f709b.toString();
    }
}
