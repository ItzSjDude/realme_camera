package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.by */
/* loaded from: classes.dex */
public class C0063by extends C0009b {

    /* renamed from: q */
    public static final float[] f293q = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: r */
    public static final float[] f294r = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.5f, -0.5f, 1.0f};

    /* renamed from: s */
    public static final float[] f295s = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 0.5f, 1.0f};

    /* renamed from: t */
    public static final float[] f296t = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: u */
    public static final float[] f297u = {-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: v */
    public static final float[] f298v = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: w */
    public C0094d f299w;

    /* renamed from: x */
    public float[] f300x;

    /* renamed from: y */
    public float[] f301y;

    /* renamed from: z */
    public float f302z;

    public C0063by(Resources resources, String str, Context context) {
        super(resources, str, context);
        this.f300x = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        this.f301y = new float[9];
        this.f302z = 1.0f;
        m222m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m217a(float COUIBaseListPopupWindow_12) {
        this.f302z = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m218a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        float[] fArr = this.f300x;
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m219a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[3] * fArr3[1]) + (fArr2[6] * fArr3[2]);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[7] * fArr3[2]);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[8] * fArr3[2]);
        fArr[3] = (fArr2[0] * fArr3[3]) + (fArr2[3] * fArr3[4]) + (fArr2[6] * fArr3[5]);
        fArr[4] = (fArr2[1] * fArr3[3]) + (fArr2[4] * fArr3[4]) + (fArr2[7] * fArr3[5]);
        fArr[5] = (fArr2[2] * fArr3[3]) + (fArr2[5] * fArr3[4]) + (fArr2[8] * fArr3[5]);
        fArr[6] = (fArr2[0] * fArr3[6]) + (fArr2[3] * fArr3[7]) + (fArr2[6] * fArr3[8]);
        fArr[7] = (fArr2[1] * fArr3[6]) + (fArr2[4] * fArr3[7]) + (fArr2[7] * fArr3[8]);
        fArr[8] = (fArr2[2] * fArr3[6]) + (fArr2[5] * fArr3[7]) + (fArr2[8] * fArr3[8]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m220b(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 % 360;
        if (i2 == 0) {
            m222m();
            return;
        }
        if (90 == i2 || -270 == i2) {
            float[] fArr = f296t;
            float[] fArr2 = this.f301y;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return;
        }
        if (180 == i2 || -180 == i2) {
            float[] fArr3 = f297u;
            float[] fArr4 = this.f301y;
            System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        } else {
            if (270 == i2 || -90 == i2) {
                float[] fArr5 = f298v;
                float[] fArr6 = this.f301y;
                System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
                return;
            }
            double radians = Math.toRadians(i2);
            float fSin = (float) Math.sin(radians);
            float fCos = (float) Math.cos(radians);
            float[] fArr7 = new float[9];
            m219a(fArr7, new float[]{fCos, fSin, 0.0f, -fSin, fCos, 0.0f, 0.0f, 0.0f, 1.0f}, f294r);
            m219a(this.f301y, f295s, fArr7);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m221b(C0094d c0094d) {
        this.f299w = c0094d;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        m32a(m43b(), 0);
        m34a(this.f299w, 1);
        m38a("texture", 0);
        m38a("sprite", 1);
        m40a("spriteMatrix", this.f301y);
        float[] fArr = this.f300x;
        m37a("bkgndCrop", fArr[0], fArr[1], fArr[2], fArr[3]);
        m35a("opacity", this.f302z);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public final void m222m() {
        float[] fArr = f293q;
        float[] fArr2 = this.f301y;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }
}
