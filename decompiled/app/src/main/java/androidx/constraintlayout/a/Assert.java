package androidx.constraintlayout.a_renamed;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.constraintlayout.a_renamed.b_renamed f703b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.constraintlayout.a_renamed.c_renamed f704c;
    private int[] f_renamed;
    private int[] g_renamed;
    private float[] h_renamed;
    private int i_renamed;
    private int j_renamed;
    private boolean k_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    int f702a = 0;
    private int d_renamed = 8;
    private androidx.constraintlayout.a_renamed.h_renamed e_renamed = null;

    a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar, androidx.constraintlayout.a_renamed.c_renamed cVar) {
        int i_renamed = this.d_renamed;
        this.f_renamed = new int[i_renamed];
        this.g_renamed = new int[i_renamed];
        this.h_renamed = new float[i_renamed];
        this.i_renamed = -1;
        this.j_renamed = -1;
        this.k_renamed = false;
        this.f703b = bVar;
        this.f704c = cVar;
    }

    public final void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, float f_renamed) {
        if (f_renamed == 0.0f) {
            a_renamed(hVar, true);
            return;
        }
        int i_renamed = this.i_renamed;
        if (i_renamed == -1) {
            this.i_renamed = 0;
            float[] fArr = this.h_renamed;
            int i2 = this.i_renamed;
            fArr[i2] = f_renamed;
            this.f_renamed[i2] = hVar.f746a;
            this.g_renamed[this.i_renamed] = -1;
            hVar.i_renamed++;
            hVar.a_renamed(this.f703b);
            this.f702a++;
            if (this.k_renamed) {
                return;
            }
            this.j_renamed++;
            int i3 = this.j_renamed;
            int[] iArr = this.f_renamed;
            if (i3 >= iArr.length) {
                this.k_renamed = true;
                this.j_renamed = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i_renamed != -1 && i5 < this.f702a; i5++) {
            if (this.f_renamed[i_renamed] == hVar.f746a) {
                this.h_renamed[i_renamed] = f_renamed;
                return;
            }
            if (this.f_renamed[i_renamed] < hVar.f746a) {
                i4 = i_renamed;
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        int length = this.j_renamed;
        int i6 = length + 1;
        if (this.k_renamed) {
            int[] iArr2 = this.f_renamed;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i6;
        }
        int[] iArr3 = this.f_renamed;
        if (length >= iArr3.length && this.f702a < iArr3.length) {
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f_renamed;
                if (i7 >= iArr4.length) {
                    break;
                }
                if (iArr4[i7] == -1) {
                    length = i7;
                    break;
                }
                i7++;
            }
        }
        int[] iArr5 = this.f_renamed;
        if (length >= iArr5.length) {
            length = iArr5.length;
            this.d_renamed *= 2;
            this.k_renamed = false;
            this.j_renamed = length - 1;
            this.h_renamed = java.util.Arrays.copyOf(this.h_renamed, this.d_renamed);
            this.f_renamed = java.util.Arrays.copyOf(this.f_renamed, this.d_renamed);
            this.g_renamed = java.util.Arrays.copyOf(this.g_renamed, this.d_renamed);
        }
        this.f_renamed[length] = hVar.f746a;
        this.h_renamed[length] = f_renamed;
        if (i4 != -1) {
            int[] iArr6 = this.g_renamed;
            iArr6[length] = iArr6[i4];
            iArr6[i4] = length;
        } else {
            this.g_renamed[length] = this.i_renamed;
            this.i_renamed = length;
        }
        hVar.i_renamed++;
        hVar.a_renamed(this.f703b);
        this.f702a++;
        if (!this.k_renamed) {
            this.j_renamed++;
        }
        if (this.f702a >= this.f_renamed.length) {
            this.k_renamed = true;
        }
        int i8 = this.j_renamed;
        int[] iArr7 = this.f_renamed;
        if (i8 >= iArr7.length) {
            this.k_renamed = true;
            this.j_renamed = iArr7.length - 1;
        }
    }

    final void a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, float f_renamed, boolean z_renamed) {
        if (f_renamed == 0.0f) {
            return;
        }
        int i_renamed = this.i_renamed;
        if (i_renamed == -1) {
            this.i_renamed = 0;
            float[] fArr = this.h_renamed;
            int i2 = this.i_renamed;
            fArr[i2] = f_renamed;
            this.f_renamed[i2] = hVar.f746a;
            this.g_renamed[this.i_renamed] = -1;
            hVar.i_renamed++;
            hVar.a_renamed(this.f703b);
            this.f702a++;
            if (this.k_renamed) {
                return;
            }
            this.j_renamed++;
            int i3 = this.j_renamed;
            int[] iArr = this.f_renamed;
            if (i3 >= iArr.length) {
                this.k_renamed = true;
                this.j_renamed = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i_renamed != -1 && i5 < this.f702a; i5++) {
            if (this.f_renamed[i_renamed] == hVar.f746a) {
                float[] fArr2 = this.h_renamed;
                fArr2[i_renamed] = fArr2[i_renamed] + f_renamed;
                if (fArr2[i_renamed] == 0.0f) {
                    if (i_renamed == this.i_renamed) {
                        this.i_renamed = this.g_renamed[i_renamed];
                    } else {
                        int[] iArr2 = this.g_renamed;
                        iArr2[i4] = iArr2[i_renamed];
                    }
                    if (z_renamed) {
                        hVar.b_renamed(this.f703b);
                    }
                    if (this.k_renamed) {
                        this.j_renamed = i_renamed;
                    }
                    hVar.i_renamed--;
                    this.f702a--;
                    return;
                }
                return;
            }
            if (this.f_renamed[i_renamed] < hVar.f746a) {
                i4 = i_renamed;
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        int length = this.j_renamed;
        int i6 = length + 1;
        if (this.k_renamed) {
            int[] iArr3 = this.f_renamed;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i6;
        }
        int[] iArr4 = this.f_renamed;
        if (length >= iArr4.length && this.f702a < iArr4.length) {
            int i7 = 0;
            while (true) {
                int[] iArr5 = this.f_renamed;
                if (i7 >= iArr5.length) {
                    break;
                }
                if (iArr5[i7] == -1) {
                    length = i7;
                    break;
                }
                i7++;
            }
        }
        int[] iArr6 = this.f_renamed;
        if (length >= iArr6.length) {
            length = iArr6.length;
            this.d_renamed *= 2;
            this.k_renamed = false;
            this.j_renamed = length - 1;
            this.h_renamed = java.util.Arrays.copyOf(this.h_renamed, this.d_renamed);
            this.f_renamed = java.util.Arrays.copyOf(this.f_renamed, this.d_renamed);
            this.g_renamed = java.util.Arrays.copyOf(this.g_renamed, this.d_renamed);
        }
        this.f_renamed[length] = hVar.f746a;
        this.h_renamed[length] = f_renamed;
        if (i4 != -1) {
            int[] iArr7 = this.g_renamed;
            iArr7[length] = iArr7[i4];
            iArr7[i4] = length;
        } else {
            this.g_renamed[length] = this.i_renamed;
            this.i_renamed = length;
        }
        hVar.i_renamed++;
        hVar.a_renamed(this.f703b);
        this.f702a++;
        if (!this.k_renamed) {
            this.j_renamed++;
        }
        int i8 = this.j_renamed;
        int[] iArr8 = this.f_renamed;
        if (i8 >= iArr8.length) {
            this.k_renamed = true;
            this.j_renamed = iArr8.length - 1;
        }
    }

    public final float a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, boolean z_renamed) {
        if (this.e_renamed == hVar) {
            this.e_renamed = null;
        }
        int i_renamed = this.i_renamed;
        if (i_renamed == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i_renamed != -1 && i2 < this.f702a) {
            if (this.f_renamed[i_renamed] == hVar.f746a) {
                if (i_renamed == this.i_renamed) {
                    this.i_renamed = this.g_renamed[i_renamed];
                } else {
                    int[] iArr = this.g_renamed;
                    iArr[i3] = iArr[i_renamed];
                }
                if (z_renamed) {
                    hVar.b_renamed(this.f703b);
                }
                hVar.i_renamed--;
                this.f702a--;
                this.f_renamed[i_renamed] = -1;
                if (this.k_renamed) {
                    this.j_renamed = i_renamed;
                }
                return this.h_renamed[i_renamed];
            }
            i2++;
            i3 = i_renamed;
            i_renamed = this.g_renamed[i_renamed];
        }
        return 0.0f;
    }

    public final void a_renamed() {
        int i_renamed = this.i_renamed;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            androidx.constraintlayout.a_renamed.h_renamed hVar = this.f704c.f737c[this.f_renamed[i_renamed]];
            if (hVar != null) {
                hVar.b_renamed(this.f703b);
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        this.i_renamed = -1;
        this.j_renamed = -1;
        this.k_renamed = false;
        this.f702a = 0;
    }

    final boolean a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        int i_renamed = this.i_renamed;
        if (i_renamed == -1) {
            return false;
        }
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            if (this.f_renamed[i_renamed] == hVar.f746a) {
                return true;
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        return false;
    }

    void b_renamed() {
        int i_renamed = this.i_renamed;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            float[] fArr = this.h_renamed;
            fArr[i_renamed] = fArr[i_renamed] * (-1.0f);
            i_renamed = this.g_renamed[i_renamed];
        }
    }

    void a_renamed(float f_renamed) {
        int i_renamed = this.i_renamed;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            float[] fArr = this.h_renamed;
            fArr[i_renamed] = fArr[i_renamed] / f_renamed;
            i_renamed = this.g_renamed[i_renamed];
        }
    }

    private boolean a_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar, androidx.constraintlayout.a_renamed.e_renamed eVar) {
        return hVar.i_renamed <= 1;
    }

    androidx.constraintlayout.a_renamed.h_renamed a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        int i_renamed = this.i_renamed;
        androidx.constraintlayout.a_renamed.h_renamed hVar = null;
        androidx.constraintlayout.a_renamed.h_renamed hVar2 = null;
        boolean z_renamed = false;
        boolean z2 = false;
        float f_renamed = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            float f3 = this.h_renamed[i_renamed];
            androidx.constraintlayout.a_renamed.h_renamed hVar3 = this.f704c.f737c[this.f_renamed[i_renamed]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    this.h_renamed[i_renamed] = 0.0f;
                    hVar3.b_renamed(this.f703b);
                    f3 = 0.0f;
                }
            } else if (f3 < 0.001f) {
                this.h_renamed[i_renamed] = 0.0f;
                hVar3.b_renamed(this.f703b);
                f3 = 0.0f;
            }
            if (f3 != 0.0f) {
                if (hVar3.f_renamed == androidx.constraintlayout.a_renamed.h_renamed.a_renamed.UNRESTRICTED) {
                    if (hVar2 == null || f_renamed > f3) {
                        boolean zA = a_renamed(hVar3, eVar);
                        z_renamed = zA;
                        f_renamed = f3;
                        hVar2 = hVar3;
                    } else if (!z_renamed && a_renamed(hVar3, eVar)) {
                        f_renamed = f3;
                        hVar2 = hVar3;
                        z_renamed = true;
                    }
                } else if (hVar2 == null && f3 < 0.0f) {
                    if (hVar == null || f2 > f3) {
                        boolean zA2 = a_renamed(hVar3, eVar);
                        z2 = zA2;
                        f2 = f3;
                        hVar = hVar3;
                    } else if (!z2 && a_renamed(hVar3, eVar)) {
                        f2 = f3;
                        hVar = hVar3;
                        z2 = true;
                    }
                }
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        return hVar2 != null ? hVar2 : hVar;
    }

    final void a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar, androidx.constraintlayout.a_renamed.b_renamed bVar2, boolean z_renamed) {
        int i_renamed = this.i_renamed;
        while (true) {
            for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
                if (this.f_renamed[i_renamed] == bVar2.f732a.f746a) {
                    float f_renamed = this.h_renamed[i_renamed];
                    a_renamed(bVar2.f732a, z_renamed);
                    androidx.constraintlayout.a_renamed.a_renamed aVar = bVar2.d_renamed;
                    int i3 = aVar.i_renamed;
                    for (int i4 = 0; i3 != -1 && i4 < aVar.f702a; i4++) {
                        a_renamed(this.f704c.f737c[aVar.f_renamed[i3]], aVar.h_renamed[i3] * f_renamed, z_renamed);
                        i3 = aVar.g_renamed[i3];
                    }
                    bVar.f733b += bVar2.f733b * f_renamed;
                    if (z_renamed) {
                        bVar2.f732a.b_renamed(bVar);
                    }
                    i_renamed = this.i_renamed;
                } else {
                    i_renamed = this.g_renamed[i_renamed];
                }
            }
            return;
        }
    }

    void a_renamed(androidx.constraintlayout.a_renamed.b_renamed bVar, androidx.constraintlayout.a_renamed.b_renamed[] bVarArr) {
        int i_renamed = this.i_renamed;
        while (true) {
            for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
                androidx.constraintlayout.a_renamed.h_renamed hVar = this.f704c.f737c[this.f_renamed[i_renamed]];
                if (hVar.f747b != -1) {
                    float f_renamed = this.h_renamed[i_renamed];
                    a_renamed(hVar, true);
                    androidx.constraintlayout.a_renamed.b_renamed bVar2 = bVarArr[hVar.f747b];
                    if (!bVar2.e_renamed) {
                        androidx.constraintlayout.a_renamed.a_renamed aVar = bVar2.d_renamed;
                        int i3 = aVar.i_renamed;
                        for (int i4 = 0; i3 != -1 && i4 < aVar.f702a; i4++) {
                            a_renamed(this.f704c.f737c[aVar.f_renamed[i3]], aVar.h_renamed[i3] * f_renamed, true);
                            i3 = aVar.g_renamed[i3];
                        }
                    }
                    bVar.f733b += bVar2.f733b * f_renamed;
                    bVar2.f732a.b_renamed(bVar);
                    i_renamed = this.i_renamed;
                } else {
                    i_renamed = this.g_renamed[i_renamed];
                }
            }
            return;
        }
    }

    androidx.constraintlayout.a_renamed.h_renamed a_renamed(boolean[] zArr, androidx.constraintlayout.a_renamed.h_renamed hVar) {
        int i_renamed = this.i_renamed;
        androidx.constraintlayout.a_renamed.h_renamed hVar2 = null;
        float f_renamed = 0.0f;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            if (this.h_renamed[i_renamed] < 0.0f) {
                androidx.constraintlayout.a_renamed.h_renamed hVar3 = this.f704c.f737c[this.f_renamed[i_renamed]];
                if ((zArr == null || !zArr[hVar3.f746a]) && hVar3 != hVar && (hVar3.f_renamed == androidx.constraintlayout.a_renamed.h_renamed.a_renamed.SLACK || hVar3.f_renamed == androidx.constraintlayout.a_renamed.h_renamed.a_renamed.ERROR)) {
                    float f2 = this.h_renamed[i_renamed];
                    if (f2 < f_renamed) {
                        hVar2 = hVar3;
                        f_renamed = f2;
                    }
                }
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        return hVar2;
    }

    final androidx.constraintlayout.a_renamed.h_renamed a_renamed(int i_renamed) {
        int i2 = this.i_renamed;
        for (int i3 = 0; i2 != -1 && i3 < this.f702a; i3++) {
            if (i3 == i_renamed) {
                return this.f704c.f737c[this.f_renamed[i2]];
            }
            i2 = this.g_renamed[i2];
        }
        return null;
    }

    final float b_renamed(int i_renamed) {
        int i2 = this.i_renamed;
        for (int i3 = 0; i2 != -1 && i3 < this.f702a; i3++) {
            if (i3 == i_renamed) {
                return this.h_renamed[i2];
            }
            i2 = this.g_renamed[i2];
        }
        return 0.0f;
    }

    public final float b_renamed(androidx.constraintlayout.a_renamed.h_renamed hVar) {
        int i_renamed = this.i_renamed;
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            if (this.f_renamed[i_renamed] == hVar.f746a) {
                return this.h_renamed[i_renamed];
            }
            i_renamed = this.g_renamed[i_renamed];
        }
        return 0.0f;
    }

    public java.lang.String toString() {
        int i_renamed = this.i_renamed;
        java.lang.String str = "";
        for (int i2 = 0; i_renamed != -1 && i2 < this.f702a; i2++) {
            str = ((str + " -> ") + this.h_renamed[i_renamed] + " : ") + this.f704c.f737c[this.f_renamed[i_renamed]];
            i_renamed = this.g_renamed[i_renamed];
        }
        return str;
    }
}
