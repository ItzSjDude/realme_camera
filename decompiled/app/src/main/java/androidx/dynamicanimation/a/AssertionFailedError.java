package androidx.dynamicanimation.a_renamed;

/* compiled from: COUIPanelDragToHiddenAnimation.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.dynamicanimation.a_renamed.c_renamed<androidx.dynamicanimation.a_renamed.b_renamed> {
    private long A_renamed;
    private final androidx.dynamicanimation.a_renamed.b_renamed.a_renamed w_renamed;
    private float x_renamed;
    private float y_renamed;
    private long z_renamed;

    public <K_renamed> b_renamed(K_renamed k_renamed, androidx.dynamicanimation.a_renamed.d_renamed<K_renamed> dVar) {
        super(k_renamed, dVar);
        this.w_renamed = new androidx.dynamicanimation.a_renamed.b_renamed.a_renamed();
        this.x_renamed = 0.0f;
        this.y_renamed = -1.0f;
        this.z_renamed = 0L;
        this.A_renamed = 120L;
        this.w_renamed.a_renamed(d_renamed());
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.dynamicanimation.a_renamed.b_renamed e_renamed(float f_renamed) {
        super.e_renamed(f_renamed);
        return this;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.dynamicanimation.a_renamed.b_renamed f_renamed(float f_renamed) {
        super.f_renamed(f_renamed);
        return this;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.dynamicanimation.a_renamed.b_renamed g_renamed(float f_renamed) {
        super.g_renamed(f_renamed);
        this.x_renamed = f_renamed;
        return this;
    }

    public androidx.dynamicanimation.a_renamed.b_renamed d_renamed(float f_renamed) {
        if (f_renamed <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Velocity must be_renamed positive");
        }
        this.y_renamed = f_renamed;
        return this;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    public void a_renamed() {
        this.z_renamed = java.lang.System.currentTimeMillis();
        this.w_renamed.f1071c = this.z_renamed;
        this.w_renamed.d_renamed = this.z_renamed + this.A_renamed;
        this.w_renamed.e_renamed = this.x_renamed;
        this.w_renamed.f_renamed = this.y_renamed;
        this.w_renamed.g_renamed = 0.0f;
        this.w_renamed.h_renamed = this.u_renamed;
        super.a_renamed();
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    boolean b_renamed(long j_renamed) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVarA = this.w_renamed.a_renamed(this.p_renamed, this.o_renamed, jCurrentTimeMillis, j_renamed);
        this.p_renamed = aVarA.f1077a;
        this.o_renamed = aVarA.f1078b;
        if (this.y_renamed >= 0.0f && (this.o_renamed <= this.y_renamed || jCurrentTimeMillis >= this.z_renamed + this.A_renamed)) {
            this.p_renamed = this.u_renamed;
            return true;
        }
        if (this.p_renamed < this.v_renamed) {
            this.p_renamed = this.v_renamed;
            return true;
        }
        if (this.p_renamed <= this.u_renamed) {
            return a_renamed(this.p_renamed, this.o_renamed);
        }
        this.p_renamed = this.u_renamed;
        return true;
    }

    @Override // androidx.dynamicanimation.a_renamed.c_renamed
    boolean a_renamed(float f_renamed, float f2) {
        return f_renamed >= this.u_renamed || f_renamed <= this.v_renamed || this.w_renamed.a_renamed(f_renamed, f2);
    }

    /* compiled from: COUIPanelDragToHiddenAnimation.java */
    static final class a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f1070b;

        /* renamed from: a_renamed, reason: collision with root package name */
        private float f1069a = -4.2f;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f1071c = 0;
        private long d_renamed = 0;
        private float e_renamed = 0.0f;
        private float f_renamed = 0.0f;
        private float g_renamed = 0.0f;
        private float h_renamed = 0.0f;
        private final androidx.dynamicanimation.a_renamed.c_renamed.a_renamed i_renamed = new androidx.dynamicanimation.a_renamed.c_renamed.a_renamed();

        a_renamed() {
        }

        androidx.dynamicanimation.a_renamed.c_renamed.a_renamed a_renamed(float f_renamed, float f2, long j_renamed, long j2) {
            if (this.f_renamed < 0.0f) {
                float f3 = j2;
                this.i_renamed.f1078b = (float) (f2 * java.lang.Math.exp((f3 / 1000.0f) * this.f1069a));
                androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVar = this.i_renamed;
                float f4 = this.f1069a;
                aVar.f1077a = (float) ((f_renamed - (f2 / f4)) + ((f2 / f4) * java.lang.Math.exp((f4 * f3) / 1000.0f)));
            } else {
                this.i_renamed.f1078b = a_renamed(j_renamed);
                this.i_renamed.f1077a = b_renamed(j_renamed);
            }
            if (a_renamed(this.i_renamed.f1077a, this.i_renamed.f1078b)) {
                this.i_renamed.f1078b = 0.0f;
            }
            return this.i_renamed;
        }

        private float a_renamed(long j_renamed) {
            if (j_renamed >= this.d_renamed) {
                return this.f_renamed;
            }
            long j2 = this.f1071c;
            float f_renamed = (j_renamed - j2) / (r0 - j2);
            float f2 = this.e_renamed;
            return f2 + ((this.f_renamed - f2) * f_renamed);
        }

        private float b_renamed(long j_renamed) {
            if (j_renamed >= this.d_renamed) {
                return this.h_renamed;
            }
            long j2 = this.f1071c;
            float f_renamed = (j_renamed - j2) / (r0 - j2);
            float f2 = this.g_renamed;
            return f2 + ((this.h_renamed - f2) * f_renamed);
        }

        public boolean a_renamed(float f_renamed, float f2) {
            return java.lang.Math.abs(f2) < this.f1070b;
        }

        void a_renamed(float f_renamed) {
            this.f1070b = f_renamed * 62.5f;
        }
    }
}
