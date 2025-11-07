package androidx.constraintlayout.a_renamed;

/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class h_renamed {
    private static int j_renamed = 1;
    private static int k_renamed = 1;
    private static int l_renamed = 1;
    private static int m_renamed = 1;
    private static int n_renamed = 1;
    public float d_renamed;
    androidx.constraintlayout.a_renamed.h_renamed.a_renamed f_renamed;
    private java.lang.String o_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f746a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f747b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f748c = 0;
    float[] e_renamed = new float[7];
    androidx.constraintlayout.a_renamed.b_renamed[] g_renamed = new androidx.constraintlayout.a_renamed.b_renamed[8];
    int h_renamed = 0;
    public int i_renamed = 0;

    /* compiled from: SolverVariable.java */
    public enum a_renamed {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void a_renamed() {
        k_renamed++;
    }

    public h_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed aVar, java.lang.String str) {
        this.f_renamed = aVar;
    }

    public final void a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        int i_renamed = 0;
        while (true) {
            int i2 = this.h_renamed;
            if (i_renamed < i2) {
                if (this.g_renamed[i_renamed] == bVar) {
                    return;
                } else {
                    i_renamed++;
                }
            } else {
                androidx.constraintlayout.a_renamed.b_renamed[] bVarArr = this.g_renamed;
                if (i2 >= bVarArr.length) {
                    this.g_renamed = (androidx.constraintlayout.a_renamed.b_renamed[]) java.util.Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                androidx.constraintlayout.a_renamed.b_renamed[] bVarArr2 = this.g_renamed;
                int i3 = this.h_renamed;
                bVarArr2[i3] = bVar;
                this.h_renamed = i3 + 1;
                return;
            }
        }
    }

    public final void b_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        int i_renamed = this.h_renamed;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (this.g_renamed[i2] == bVar) {
                for (int i3 = 0; i3 < (i_renamed - i2) - 1; i3++) {
                    androidx.constraintlayout.a_renamed.b_renamed[] bVarArr = this.g_renamed;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.h_renamed--;
                return;
            }
        }
    }

    public final void c_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar) {
        int i_renamed = this.h_renamed;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            this.g_renamed[i2].d_renamed.a_renamed(this.g_renamed[i2], bVar, false);
        }
        this.h_renamed = 0;
    }

    public void b_renamed() {
        this.o_renamed = null;
        this.f_renamed = androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNKNOWN;
        this.f748c = 0;
        this.f746a = -1;
        this.f747b = -1;
        this.d_renamed = 0.0f;
        this.h_renamed = 0;
        this.i_renamed = 0;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.h_renamed.a_renamed aVar, java.lang.String str) {
        this.f_renamed = aVar;
    }

    public java.lang.String toString() {
        return "" + this.o_renamed;
    }
}
