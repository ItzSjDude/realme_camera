package androidx.constraintlayout.p025a;

import androidx.constraintlayout.p025a.SolverVariable;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ArrayLinkedVariables {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArrayRow f2171b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Cache f2172c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int[] f2175f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int[] f2176g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float[] f2177h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f2178i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f2179j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f2180k;

    /* renamed from: PlatformImplementations.kt_3 */
    int f2170a = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2173d = 8;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SolverVariable f2174e = null;

    ArrayLinkedVariables(ArrayRow c0391b, Cache c0392c) {
        int OplusGLSurfaceView_13 = this.f2173d;
        this.f2175f = new int[OplusGLSurfaceView_13];
        this.f2176g = new int[OplusGLSurfaceView_13];
        this.f2177h = new float[OplusGLSurfaceView_13];
        this.f2178i = -1;
        this.f2179j = -1;
        this.f2180k = false;
        this.f2171b = c0391b;
        this.f2172c = c0392c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m1901a(SolverVariable c0397h, float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            m1893a(c0397h, true);
            return;
        }
        int OplusGLSurfaceView_13 = this.f2178i;
        if (OplusGLSurfaceView_13 == -1) {
            this.f2178i = 0;
            float[] fArr = this.f2177h;
            int i2 = this.f2178i;
            fArr[i2] = COUIBaseListPopupWindow_12;
            this.f2175f[i2] = c0397h.f2423a;
            this.f2176g[this.f2178i] = -1;
            c0397h.f2431i++;
            c0397h.m2155a(this.f2171b);
            this.f2170a++;
            if (this.f2180k) {
                return;
            }
            this.f2179j++;
            int i3 = this.f2179j;
            int[] iArr = this.f2175f;
            if (i3 >= iArr.length) {
                this.f2180k = true;
                this.f2179j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; OplusGLSurfaceView_13 != -1 && i5 < this.f2170a; i5++) {
            if (this.f2175f[OplusGLSurfaceView_13] == c0397h.f2423a) {
                this.f2177h[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_12;
                return;
            }
            if (this.f2175f[OplusGLSurfaceView_13] < c0397h.f2423a) {
                i4 = OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        int length = this.f2179j;
        int i6 = length + 1;
        if (this.f2180k) {
            int[] iArr2 = this.f2175f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i6;
        }
        int[] iArr3 = this.f2175f;
        if (length >= iArr3.length && this.f2170a < iArr3.length) {
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f2175f;
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
        int[] iArr5 = this.f2175f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            this.f2173d *= 2;
            this.f2180k = false;
            this.f2179j = length - 1;
            this.f2177h = Arrays.copyOf(this.f2177h, this.f2173d);
            this.f2175f = Arrays.copyOf(this.f2175f, this.f2173d);
            this.f2176g = Arrays.copyOf(this.f2176g, this.f2173d);
        }
        this.f2175f[length] = c0397h.f2423a;
        this.f2177h[length] = COUIBaseListPopupWindow_12;
        if (i4 != -1) {
            int[] iArr6 = this.f2176g;
            iArr6[length] = iArr6[i4];
            iArr6[i4] = length;
        } else {
            this.f2176g[length] = this.f2178i;
            this.f2178i = length;
        }
        c0397h.f2431i++;
        c0397h.m2155a(this.f2171b);
        this.f2170a++;
        if (!this.f2180k) {
            this.f2179j++;
        }
        if (this.f2170a >= this.f2175f.length) {
            this.f2180k = true;
        }
        int i8 = this.f2179j;
        int[] iArr7 = this.f2175f;
        if (i8 >= iArr7.length) {
            this.f2180k = true;
            this.f2179j = iArr7.length - 1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m1902a(SolverVariable c0397h, float COUIBaseListPopupWindow_12, boolean z) {
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f2178i;
        if (OplusGLSurfaceView_13 == -1) {
            this.f2178i = 0;
            float[] fArr = this.f2177h;
            int i2 = this.f2178i;
            fArr[i2] = COUIBaseListPopupWindow_12;
            this.f2175f[i2] = c0397h.f2423a;
            this.f2176g[this.f2178i] = -1;
            c0397h.f2431i++;
            c0397h.m2155a(this.f2171b);
            this.f2170a++;
            if (this.f2180k) {
                return;
            }
            this.f2179j++;
            int i3 = this.f2179j;
            int[] iArr = this.f2175f;
            if (i3 >= iArr.length) {
                this.f2180k = true;
                this.f2179j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; OplusGLSurfaceView_13 != -1 && i5 < this.f2170a; i5++) {
            if (this.f2175f[OplusGLSurfaceView_13] == c0397h.f2423a) {
                float[] fArr2 = this.f2177h;
                fArr2[OplusGLSurfaceView_13] = fArr2[OplusGLSurfaceView_13] + COUIBaseListPopupWindow_12;
                if (fArr2[OplusGLSurfaceView_13] == 0.0f) {
                    if (OplusGLSurfaceView_13 == this.f2178i) {
                        this.f2178i = this.f2176g[OplusGLSurfaceView_13];
                    } else {
                        int[] iArr2 = this.f2176g;
                        iArr2[i4] = iArr2[OplusGLSurfaceView_13];
                    }
                    if (z) {
                        c0397h.m2158b(this.f2171b);
                    }
                    if (this.f2180k) {
                        this.f2179j = OplusGLSurfaceView_13;
                    }
                    c0397h.f2431i--;
                    this.f2170a--;
                    return;
                }
                return;
            }
            if (this.f2175f[OplusGLSurfaceView_13] < c0397h.f2423a) {
                i4 = OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        int length = this.f2179j;
        int i6 = length + 1;
        if (this.f2180k) {
            int[] iArr3 = this.f2175f;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i6;
        }
        int[] iArr4 = this.f2175f;
        if (length >= iArr4.length && this.f2170a < iArr4.length) {
            int i7 = 0;
            while (true) {
                int[] iArr5 = this.f2175f;
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
        int[] iArr6 = this.f2175f;
        if (length >= iArr6.length) {
            length = iArr6.length;
            this.f2173d *= 2;
            this.f2180k = false;
            this.f2179j = length - 1;
            this.f2177h = Arrays.copyOf(this.f2177h, this.f2173d);
            this.f2175f = Arrays.copyOf(this.f2175f, this.f2173d);
            this.f2176g = Arrays.copyOf(this.f2176g, this.f2173d);
        }
        this.f2175f[length] = c0397h.f2423a;
        this.f2177h[length] = COUIBaseListPopupWindow_12;
        if (i4 != -1) {
            int[] iArr7 = this.f2176g;
            iArr7[length] = iArr7[i4];
            iArr7[i4] = length;
        } else {
            this.f2176g[length] = this.f2178i;
            this.f2178i = length;
        }
        c0397h.f2431i++;
        c0397h.m2155a(this.f2171b);
        this.f2170a++;
        if (!this.f2180k) {
            this.f2179j++;
        }
        int i8 = this.f2179j;
        int[] iArr8 = this.f2175f;
        if (i8 >= iArr8.length) {
            this.f2180k = true;
            this.f2179j = iArr8.length - 1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final float m1893a(SolverVariable c0397h, boolean z) {
        if (this.f2174e == c0397h) {
            this.f2174e = null;
        }
        int OplusGLSurfaceView_13 = this.f2178i;
        if (OplusGLSurfaceView_13 == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (OplusGLSurfaceView_13 != -1 && i2 < this.f2170a) {
            if (this.f2175f[OplusGLSurfaceView_13] == c0397h.f2423a) {
                if (OplusGLSurfaceView_13 == this.f2178i) {
                    this.f2178i = this.f2176g[OplusGLSurfaceView_13];
                } else {
                    int[] iArr = this.f2176g;
                    iArr[i3] = iArr[OplusGLSurfaceView_13];
                }
                if (z) {
                    c0397h.m2158b(this.f2171b);
                }
                c0397h.f2431i--;
                this.f2170a--;
                this.f2175f[OplusGLSurfaceView_13] = -1;
                if (this.f2180k) {
                    this.f2179j = OplusGLSurfaceView_13;
                }
                return this.f2177h[OplusGLSurfaceView_13];
            }
            i2++;
            i3 = OplusGLSurfaceView_13;
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m1897a() {
        int OplusGLSurfaceView_13 = this.f2178i;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            SolverVariable c0397h = this.f2172c.f2367c[this.f2175f[OplusGLSurfaceView_13]];
            if (c0397h != null) {
                c0397h.m2158b(this.f2171b);
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        this.f2178i = -1;
        this.f2179j = -1;
        this.f2180k = false;
        this.f2170a = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final boolean m1903a(SolverVariable c0397h) {
        int OplusGLSurfaceView_13 = this.f2178i;
        if (OplusGLSurfaceView_13 == -1) {
            return false;
        }
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            if (this.f2175f[OplusGLSurfaceView_13] == c0397h.f2423a) {
                return true;
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1906b() {
        int OplusGLSurfaceView_13 = this.f2178i;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            float[] fArr = this.f2177h;
            fArr[OplusGLSurfaceView_13] = fArr[OplusGLSurfaceView_13] * (-1.0f);
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1898a(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f2178i;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            float[] fArr = this.f2177h;
            fArr[OplusGLSurfaceView_13] = fArr[OplusGLSurfaceView_13] / COUIBaseListPopupWindow_12;
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1892a(SolverVariable c0397h, LinearSystem c0394e) {
        return c0397h.f2431i <= 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    SolverVariable m1895a(LinearSystem c0394e) {
        int OplusGLSurfaceView_13 = this.f2178i;
        SolverVariable c0397h = null;
        SolverVariable c0397h2 = null;
        boolean z = false;
        boolean z2 = false;
        float COUIBaseListPopupWindow_12 = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            float f3 = this.f2177h[OplusGLSurfaceView_13];
            SolverVariable c0397h3 = this.f2172c.f2367c[this.f2175f[OplusGLSurfaceView_13]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    this.f2177h[OplusGLSurfaceView_13] = 0.0f;
                    c0397h3.m2158b(this.f2171b);
                    f3 = 0.0f;
                }
            } else if (f3 < 0.001f) {
                this.f2177h[OplusGLSurfaceView_13] = 0.0f;
                c0397h3.m2158b(this.f2171b);
                f3 = 0.0f;
            }
            if (f3 != 0.0f) {
                if (c0397h3.f2428f == SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED) {
                    if (c0397h2 == null || COUIBaseListPopupWindow_12 > f3) {
                        boolean zM1892a = m1892a(c0397h3, c0394e);
                        z = zM1892a;
                        COUIBaseListPopupWindow_12 = f3;
                        c0397h2 = c0397h3;
                    } else if (!z && m1892a(c0397h3, c0394e)) {
                        COUIBaseListPopupWindow_12 = f3;
                        c0397h2 = c0397h3;
                        z = true;
                    }
                } else if (c0397h2 == null && f3 < 0.0f) {
                    if (c0397h == null || f2 > f3) {
                        boolean zM1892a2 = m1892a(c0397h3, c0394e);
                        z2 = zM1892a2;
                        f2 = f3;
                        c0397h = c0397h3;
                    } else if (!z2 && m1892a(c0397h3, c0394e)) {
                        f2 = f3;
                        c0397h = c0397h3;
                        z2 = true;
                    }
                }
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return c0397h2 != null ? c0397h2 : c0397h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m1899a(ArrayRow c0391b, ArrayRow c0391b2, boolean z) {
        int OplusGLSurfaceView_13 = this.f2178i;
        while (true) {
            for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
                if (this.f2175f[OplusGLSurfaceView_13] == c0391b2.f2360a.f2423a) {
                    float COUIBaseListPopupWindow_12 = this.f2177h[OplusGLSurfaceView_13];
                    m1893a(c0391b2.f2360a, z);
                    ArrayLinkedVariables c0373a = c0391b2.f2363d;
                    int i3 = c0373a.f2178i;
                    for (int i4 = 0; i3 != -1 && i4 < c0373a.f2170a; i4++) {
                        m1902a(this.f2172c.f2367c[c0373a.f2175f[i3]], c0373a.f2177h[i3] * COUIBaseListPopupWindow_12, z);
                        i3 = c0373a.f2176g[i3];
                    }
                    c0391b.f2361b += c0391b2.f2361b * COUIBaseListPopupWindow_12;
                    if (z) {
                        c0391b2.f2360a.m2158b(c0391b);
                    }
                    OplusGLSurfaceView_13 = this.f2178i;
                } else {
                    OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
                }
            }
            return;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1900a(ArrayRow c0391b, ArrayRow[] c0391bArr) {
        int OplusGLSurfaceView_13 = this.f2178i;
        while (true) {
            for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
                SolverVariable c0397h = this.f2172c.f2367c[this.f2175f[OplusGLSurfaceView_13]];
                if (c0397h.f2424b != -1) {
                    float COUIBaseListPopupWindow_12 = this.f2177h[OplusGLSurfaceView_13];
                    m1893a(c0397h, true);
                    ArrayRow c0391b2 = c0391bArr[c0397h.f2424b];
                    if (!c0391b2.f2364e) {
                        ArrayLinkedVariables c0373a = c0391b2.f2363d;
                        int i3 = c0373a.f2178i;
                        for (int i4 = 0; i3 != -1 && i4 < c0373a.f2170a; i4++) {
                            m1902a(this.f2172c.f2367c[c0373a.f2175f[i3]], c0373a.f2177h[i3] * COUIBaseListPopupWindow_12, true);
                            i3 = c0373a.f2176g[i3];
                        }
                    }
                    c0391b.f2361b += c0391b2.f2361b * COUIBaseListPopupWindow_12;
                    c0391b2.f2360a.m2158b(c0391b);
                    OplusGLSurfaceView_13 = this.f2178i;
                } else {
                    OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
                }
            }
            return;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    SolverVariable m1896a(boolean[] zArr, SolverVariable c0397h) {
        int OplusGLSurfaceView_13 = this.f2178i;
        SolverVariable c0397h2 = null;
        float COUIBaseListPopupWindow_12 = 0.0f;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            if (this.f2177h[OplusGLSurfaceView_13] < 0.0f) {
                SolverVariable c0397h3 = this.f2172c.f2367c[this.f2175f[OplusGLSurfaceView_13]];
                if ((zArr == null || !zArr[c0397h3.f2423a]) && c0397h3 != c0397h && (c0397h3.f2428f == SolverVariable.PlatformImplementations.kt_3.SLACK || c0397h3.f2428f == SolverVariable.PlatformImplementations.kt_3.ERROR)) {
                    float f2 = this.f2177h[OplusGLSurfaceView_13];
                    if (f2 < COUIBaseListPopupWindow_12) {
                        c0397h2 = c0397h3;
                        COUIBaseListPopupWindow_12 = f2;
                    }
                }
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return c0397h2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final SolverVariable m1894a(int OplusGLSurfaceView_13) {
        int i2 = this.f2178i;
        for (int i3 = 0; i2 != -1 && i3 < this.f2170a; i3++) {
            if (i3 == OplusGLSurfaceView_13) {
                return this.f2172c.f2367c[this.f2175f[i2]];
            }
            i2 = this.f2176g[i2];
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    final float m1904b(int OplusGLSurfaceView_13) {
        int i2 = this.f2178i;
        for (int i3 = 0; i2 != -1 && i3 < this.f2170a; i3++) {
            if (i3 == OplusGLSurfaceView_13) {
                return this.f2177h[i2];
            }
            i2 = this.f2176g[i2];
        }
        return 0.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final float m1905b(SolverVariable c0397h) {
        int OplusGLSurfaceView_13 = this.f2178i;
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            if (this.f2175f[OplusGLSurfaceView_13] == c0397h.f2423a) {
                return this.f2177h[OplusGLSurfaceView_13];
            }
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return 0.0f;
    }

    public String toString() {
        int OplusGLSurfaceView_13 = this.f2178i;
        String str = "";
        for (int i2 = 0; OplusGLSurfaceView_13 != -1 && i2 < this.f2170a; i2++) {
            str = ((str + " -> ") + this.f2177h[OplusGLSurfaceView_13] + " : ") + this.f2172c.f2367c[this.f2175f[OplusGLSurfaceView_13]];
            OplusGLSurfaceView_13 = this.f2176g[OplusGLSurfaceView_13];
        }
        return str;
    }
}
