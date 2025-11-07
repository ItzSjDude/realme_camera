package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ar_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed implements java.lang.AutoCloseable {
    public int A_renamed;
    public int B_renamed;
    public final float[] C_renamed;
    public final float[] D_renamed;
    public final float[] E_renamed;
    public boolean F_renamed;
    public int q_renamed;
    public int r_renamed;
    public int s_renamed;
    public a_renamed.a_renamed.b_renamed.f_renamed.e_renamed t_renamed;
    public boolean u_renamed;
    public java.lang.ref.WeakReference<a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed> v_renamed;
    public final java.util.Random w_renamed;
    public int x_renamed;
    public int y_renamed;
    public int z_renamed;

    public interface a_renamed {
        float[][] a_renamed(boolean z_renamed);

        float[][] b_renamed(boolean z_renamed);
    }

    public ar_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed aVar) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("glitch"), context);
        this.w_renamed = new java.util.Random(1000L);
        this.x_renamed = 3;
        this.y_renamed = 0;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = new float[1024];
        this.D_renamed = new float[1024];
        this.E_renamed = new float[]{0.3f, 0.7f, 0.7f, 0.3f};
        this.F_renamed = false;
        this.q_renamed = 10;
        this.r_renamed = 1;
        this.s_renamed = 1;
        this.t_renamed = new a_renamed.a_renamed.b_renamed.f_renamed.e_renamed(3);
        this.u_renamed = false;
        this.v_renamed = null;
        this.v_renamed = new java.lang.ref.WeakReference<>(aVar);
        n_renamed();
    }

    public final void a_renamed(boolean z_renamed) {
        if (this.F_renamed != z_renamed) {
            this.F_renamed = z_renamed;
            n_renamed();
        }
    }

    public final void a_renamed(float[][] fArr, float[][] fArr2) {
        int i_renamed = 0;
        int i2 = 0;
        int i3 = 0;
        while (i_renamed < 16) {
            int i4 = i3;
            int i5 = i2;
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = i6 * 4;
                float[] fArr3 = this.C_renamed;
                int i8 = i4 + 1;
                fArr3[i4] = fArr[i_renamed][i7];
                int i9 = i8 + 1;
                fArr3[i8] = fArr[i_renamed][i7 + 1];
                int i10 = i9 + 1;
                fArr3[i9] = fArr[i_renamed][i7 + 2];
                i4 = i10 + 1;
                fArr3[i10] = fArr[i_renamed][i7 + 3];
                int i11 = i6 * 2;
                float[] fArr4 = this.D_renamed;
                int i12 = i5 + 1;
                fArr4[i5] = fArr2[i_renamed][i11];
                i5 = i12 + 1;
                fArr4[i12] = fArr2[i_renamed][i11 + 1];
            }
            i_renamed++;
            i2 = i5;
            i3 = i4;
        }
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed != 0) {
            this.u_renamed = true;
            this.z_renamed = i_renamed & 15;
            this.y_renamed = (i_renamed >> 4) & 15;
            this.B_renamed = (i_renamed >> 8) & 15;
            this.A_renamed = (i_renamed >> 12) & 15;
            this.s_renamed = (i_renamed >> 16) & 15;
            if (this.s_renamed != 0) {
                return;
            }
        } else if (!this.u_renamed) {
            return;
        }
        this.u_renamed = false;
        this.x_renamed = 0;
    }

    public final float[] b_renamed(int i_renamed, int i2, int i3) {
        int i4 = i_renamed % 16;
        int i5 = i4 * 16 * 2;
        float[] fArr = new float[i3 * 2];
        int i6 = ((i2 % 16) * 2) + i5;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i7 * 2;
            float[] fArr2 = this.D_renamed;
            fArr[i8] = fArr2[i6];
            fArr[i8 + 1] = fArr2[i6 + 1];
            i6 = (((i6 + 2) - i5) % ((((i4 + 1) * 16) * 2) - i5)) + i5;
        }
        return fArr;
    }

    public final float[] c_renamed(int i_renamed, int i2, int i3) {
        int i4 = i_renamed % 16;
        int i5 = i4 * 16 * 4;
        float[] fArr = new float[i3 * 4];
        int i6 = ((i2 % 16) * 4) + i5;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i7 * 4;
            float[] fArr2 = this.C_renamed;
            fArr[i8] = fArr2[i6];
            fArr[i8 + 1] = fArr2[i6 + 1];
            fArr[i8 + 2] = fArr2[i6 + 2];
            fArr[i8 + 3] = fArr2[i6 + 3];
            i6 = (((i6 + 4) - i5) % ((((i4 + 1) * 16) * 4) - i5)) + i5;
        }
        return fArr;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public void d_renamed(int i_renamed, int i2) {
        if (i_renamed <= 0) {
            this.r_renamed = 1;
        } else {
            this.r_renamed = java.lang.Math.max(1, java.lang.Math.min(16, i_renamed));
        }
        this.q_renamed = i2 <= 0 ? 10 : java.lang.Math.max(1, java.lang.Math.min(16, i2));
        int i3 = this.r_renamed;
        int i4 = this.q_renamed;
        if (i3 > i4) {
            this.r_renamed = i4;
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        m_renamed();
        super.draw();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        a_renamed("glitchEnabled", 1);
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(this.f15a);
        a_renamed(fArrB[0] > fArrB[1]);
        float[] fArr = this.E_renamed;
        a_renamed("forbiddenZone", fArr[0], fArr[1], fArr[2], fArr[3]);
        a_renamed("glitch_count", this.s_renamed);
        float[] fArrC = c_renamed(this.z_renamed, this.y_renamed, 16);
        float[] fArrB2 = b_renamed(this.B_renamed, this.A_renamed, 16);
        b_renamed("rects", fArrC, 0, 16);
        a_renamed("offsets", fArrB2, 0, 16);
    }

    public final void m_renamed() {
        if (this.u_renamed) {
            return;
        }
        if (this.x_renamed == 0) {
            this.z_renamed = java.lang.Math.round(this.w_renamed.nextFloat() * 16.0f) % 16;
            this.B_renamed = java.lang.Math.round(this.w_renamed.nextFloat() * 16.0f) % 16;
            this.y_renamed = java.lang.Math.round(this.w_renamed.nextFloat() * 16.0f) % 16;
            this.A_renamed = java.lang.Math.round(this.w_renamed.nextFloat() * 16.0f) % 16;
            this.s_renamed = this.t_renamed.a_renamed() ? this.q_renamed : this.r_renamed;
        }
        this.x_renamed = (this.x_renamed + 1) % 3;
    }

    public final void n_renamed() {
        a_renamed.a_renamed.b_renamed.b_renamed.ar_renamed.a_renamed aVar = this.v_renamed.get();
        if (aVar != null) {
            a_renamed(aVar.a_renamed(this.F_renamed), aVar.b_renamed(this.F_renamed));
        }
    }

    public int o_renamed() {
        return (this.s_renamed << 16) | this.z_renamed | (this.y_renamed << 4) | (this.B_renamed << 8) | (this.A_renamed << 12);
    }

    public void p_renamed() {
        n_renamed();
    }
}
