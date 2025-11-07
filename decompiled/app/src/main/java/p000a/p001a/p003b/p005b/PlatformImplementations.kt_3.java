package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import java.lang.ref.WeakReference;
import java.util.Random;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0112e;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ar */
/* loaded from: classes.dex */
public class C0029ar extends C0009b implements AutoCloseable {

    /* renamed from: A */
    public int f136A;

    /* renamed from: B */
    public int f137B;

    /* renamed from: C */
    public final float[] f138C;

    /* renamed from: D */
    public final float[] f139D;

    /* renamed from: E */
    public final float[] f140E;

    /* renamed from: F */
    public boolean f141F;

    /* renamed from: q */
    public int f142q;

    /* renamed from: r */
    public int f143r;

    /* renamed from: s */
    public int f144s;

    /* renamed from: t */
    public C0112e f145t;

    /* renamed from: u */
    public boolean f146u;

    /* renamed from: v */
    public WeakReference<PlatformImplementations.kt_3> f147v;

    /* renamed from: w */
    public final Random f148w;

    /* renamed from: x */
    public int f149x;

    /* renamed from: y */
    public int f150y;

    /* renamed from: z */
    public int f151z;

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ar$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        float[][] mo128a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        float[][] mo129b(boolean z);
    }

    public C0029ar(Resources resources, Context context, PlatformImplementations.kt_3 aVar) {
        super(resources, C0120m.m524a("glitch"), context);
        this.f148w = new Random(1000L);
        this.f149x = 3;
        this.f150y = 0;
        this.f151z = 0;
        this.f136A = 0;
        this.f137B = 0;
        this.f138C = new float[1024];
        this.f139D = new float[1024];
        this.f140E = new float[]{0.3f, 0.7f, 0.7f, 0.3f};
        this.f141F = false;
        this.f142q = 10;
        this.f143r = 1;
        this.f144s = 1;
        this.f145t = new C0112e(3);
        this.f146u = false;
        this.f147v = null;
        this.f147v = new WeakReference<>(aVar);
        m125n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m118a(boolean z) {
        if (this.f141F != z) {
            this.f141F = z;
            m125n();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m119a(float[][] fArr, float[][] fArr2) {
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        int i3 = 0;
        while (OplusGLSurfaceView_13 < 16) {
            int i4 = i3;
            int i5 = i2;
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = i6 * 4;
                float[] fArr3 = this.f138C;
                int i8 = i4 + 1;
                fArr3[i4] = fArr[OplusGLSurfaceView_13][i7];
                int i9 = i8 + 1;
                fArr3[i8] = fArr[OplusGLSurfaceView_13][i7 + 1];
                int i10 = i9 + 1;
                fArr3[i9] = fArr[OplusGLSurfaceView_13][i7 + 2];
                i4 = i10 + 1;
                fArr3[i10] = fArr[OplusGLSurfaceView_13][i7 + 3];
                int i11 = i6 * 2;
                float[] fArr4 = this.f139D;
                int i12 = i5 + 1;
                fArr4[i5] = fArr2[OplusGLSurfaceView_13][i11];
                i5 = i12 + 1;
                fArr4[i12] = fArr2[OplusGLSurfaceView_13][i11 + 1];
            }
            OplusGLSurfaceView_13++;
            i2 = i5;
            i3 = i4;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m120b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            this.f146u = true;
            this.f151z = OplusGLSurfaceView_13 & 15;
            this.f150y = (OplusGLSurfaceView_13 >> 4) & 15;
            this.f137B = (OplusGLSurfaceView_13 >> 8) & 15;
            this.f136A = (OplusGLSurfaceView_13 >> 12) & 15;
            this.f144s = (OplusGLSurfaceView_13 >> 16) & 15;
            if (this.f144s != 0) {
                return;
            }
        } else if (!this.f146u) {
            return;
        }
        this.f146u = false;
        this.f149x = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final float[] m121b(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = OplusGLSurfaceView_13 % 16;
        int i5 = i4 * 16 * 2;
        float[] fArr = new float[i3 * 2];
        int i6 = ((i2 % 16) * 2) + i5;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i7 * 2;
            float[] fArr2 = this.f139D;
            fArr[i8] = fArr2[i6];
            fArr[i8 + 1] = fArr2[i6 + 1];
            i6 = (((i6 + 2) - i5) % ((((i4 + 1) * 16) * 2) - i5)) + i5;
        }
        return fArr;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final float[] m122c(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = OplusGLSurfaceView_13 % 16;
        int i5 = i4 * 16 * 4;
        float[] fArr = new float[i3 * 4];
        int i6 = ((i2 % 16) * 4) + i5;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i7 * 4;
            float[] fArr2 = this.f138C;
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

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m123d(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 <= 0) {
            this.f143r = 1;
        } else {
            this.f143r = Math.max(1, Math.min(16, OplusGLSurfaceView_13));
        }
        this.f142q = i2 <= 0 ? 10 : Math.max(1, Math.min(16, i2));
        int i3 = this.f143r;
        int i4 = this.f142q;
        if (i3 > i4) {
            this.f143r = i4;
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m124m();
        super.draw();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        m38a("glitchEnabled", 1);
        float[] fArrM497b = C0115h.m497b(this.f21a);
        m118a(fArrM497b[0] > fArrM497b[1]);
        float[] fArr = this.f140E;
        m37a("forbiddenZone", fArr[0], fArr[1], fArr[2], fArr[3]);
        m38a("glitch_count", this.f144s);
        float[] fArrM122c = m122c(this.f151z, this.f150y, 16);
        float[] fArrM121b = m121b(this.f137B, this.f136A, 16);
        m46b("rects", fArrM122c, 0, 16);
        m41a("offsets", fArrM121b, 0, 16);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public final void m124m() {
        if (this.f146u) {
            return;
        }
        if (this.f149x == 0) {
            this.f151z = Math.round(this.f148w.nextFloat() * 16.0f) % 16;
            this.f137B = Math.round(this.f148w.nextFloat() * 16.0f) % 16;
            this.f150y = Math.round(this.f148w.nextFloat() * 16.0f) % 16;
            this.f136A = Math.round(this.f148w.nextFloat() * 16.0f) % 16;
            this.f144s = this.f145t.m472a() ? this.f142q : this.f143r;
        }
        this.f149x = (this.f149x + 1) % 3;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public final void m125n() {
        PlatformImplementations.kt_3 aVar = this.f147v.get();
        if (aVar != null) {
            m119a(aVar.mo128a(this.f141F), aVar.mo129b(this.f141F));
        }
    }

    /* renamed from: o */
    public int m126o() {
        return (this.f144s << 16) | this.f151z | (this.f150y << 4) | (this.f137B << 8) | (this.f136A << 12);
    }

    /* renamed from: p */
    public void m127p() {
        m125n();
    }
}
