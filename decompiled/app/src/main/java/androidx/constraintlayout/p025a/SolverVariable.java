package androidx.constraintlayout.p025a;

import java.util.Arrays;

/* compiled from: SolverVariable.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class SolverVariable {

    /* renamed from: OplusGLSurfaceView_15 */
    private static int f2418j = 1;

    /* renamed from: OplusGLSurfaceView_5 */
    private static int f2419k = 1;

    /* renamed from: OplusGLSurfaceView_14 */
    private static int f2420l = 1;

    /* renamed from: OplusGLSurfaceView_6 */
    private static int f2421m = 1;

    /* renamed from: OplusGLSurfaceView_11 */
    private static int f2422n = 1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float f2426d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    PlatformImplementations.kt_3 f2428f;

    /* renamed from: o */
    private String f2432o;

    /* renamed from: PlatformImplementations.kt_3 */
    public int f2423a = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f2424b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f2425c = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    float[] f2427e = new float[7];

    /* renamed from: COUIBaseListPopupWindow_11 */
    ArrayRow[] f2429g = new ArrayRow[8];

    /* renamed from: COUIBaseListPopupWindow_10 */
    int f2430h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    public int f2431i = 0;

    /* compiled from: SolverVariable.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m2154a() {
        f2419k++;
    }

    public SolverVariable(PlatformImplementations.kt_3 aVar, String str) {
        this.f2428f = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m2155a(ArrayRow c0391b) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int i2 = this.f2430h;
            if (OplusGLSurfaceView_13 < i2) {
                if (this.f2429g[OplusGLSurfaceView_13] == c0391b) {
                    return;
                } else {
                    OplusGLSurfaceView_13++;
                }
            } else {
                ArrayRow[] c0391bArr = this.f2429g;
                if (i2 >= c0391bArr.length) {
                    this.f2429g = (ArrayRow[]) Arrays.copyOf(c0391bArr, c0391bArr.length * 2);
                }
                ArrayRow[] c0391bArr2 = this.f2429g;
                int i3 = this.f2430h;
                c0391bArr2[i3] = c0391b;
                this.f2430h = i3 + 1;
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m2158b(ArrayRow c0391b) {
        int OplusGLSurfaceView_13 = this.f2430h;
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (this.f2429g[i2] == c0391b) {
                for (int i3 = 0; i3 < (OplusGLSurfaceView_13 - i2) - 1; i3++) {
                    ArrayRow[] c0391bArr = this.f2429g;
                    int i4 = i2 + i3;
                    c0391bArr[i4] = c0391bArr[i4 + 1];
                }
                this.f2430h--;
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m2159c(ArrayRow c0391b) {
        int OplusGLSurfaceView_13 = this.f2430h;
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            this.f2429g[i2].f2363d.m1899a(this.f2429g[i2], c0391b, false);
        }
        this.f2430h = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2157b() {
        this.f2432o = null;
        this.f2428f = PlatformImplementations.kt_3.UNKNOWN;
        this.f2425c = 0;
        this.f2423a = -1;
        this.f2424b = -1;
        this.f2426d = 0.0f;
        this.f2430h = 0;
        this.f2431i = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2156a(PlatformImplementations.kt_3 aVar, String str) {
        this.f2428f = aVar;
    }

    public String toString() {
        return "" + this.f2432o;
    }
}
