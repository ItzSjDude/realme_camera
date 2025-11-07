package com.p094b.p095a;

import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.MotionEvent;
import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: TouchController.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class TouchController {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f6239a = "com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_14";

    /* renamed from: A */
    private int f6240A;

    /* renamed from: B */
    private float f6241B;

    /* renamed from: C */
    private float f6242C;

    /* renamed from: D */
    private float f6243D;

    /* renamed from: E */
    private float f6244E;

    /* renamed from: F */
    private float[] f6245F;

    /* renamed from: G */
    private float[] f6246G;

    /* renamed from: H */
    private float[] f6247H;

    /* renamed from: I */
    private float f6248I;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ModelSurfaceView f6249b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ModelRenderer f6250c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6251d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f6252e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f6253f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f6254g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f6255h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f6256i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f6257j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f6258k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f6259l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f6260m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f6261n;

    /* renamed from: o */
    private float f6262o;

    /* renamed from: p */
    private float f6263p;

    /* renamed from: q */
    private float f6264q;

    /* renamed from: r */
    private int f6265r;

    /* renamed from: s */
    private boolean f6266s;

    /* renamed from: t */
    private boolean f6267t;

    /* renamed from: u */
    private boolean f6268u;

    /* renamed from: v */
    private boolean f6269v;

    /* renamed from: w */
    private boolean f6270w;

    /* renamed from: x */
    private boolean f6271x;

    /* renamed from: y */
    private long f6272y;

    /* renamed from: z */
    private int f6273z;

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized boolean m6359a(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
            case 9:
                Log.m6277c(f6239a, "Gesture changed...");
                this.f6269v = true;
                this.f6273z = 0;
                this.f6272y = SystemClock.uptimeMillis();
                this.f6271x = false;
                break;
            case 1:
            case 3:
            case 4:
            case 6:
            case 10:
                if (this.f6272y > SystemClock.uptimeMillis() - 250) {
                    this.f6271x = true;
                } else {
                    this.f6269v = true;
                    this.f6273z = 0;
                    this.f6272y = SystemClock.uptimeMillis();
                    this.f6271x = false;
                }
                this.f6270w = false;
                break;
            case 2:
                this.f6270w = true;
                this.f6271x = false;
                this.f6273z++;
                break;
            case 7:
            case 8:
            default:
                Log.m6276b(f6239a, "Unknown state: " + motionEvent.getAction());
                this.f6269v = true;
                break;
        }
        this.f6251d = motionEvent.getPointerCount();
        if (this.f6251d == 1) {
            this.f6252e = motionEvent.getX();
            this.f6253f = motionEvent.getY();
            if (this.f6269v) {
                Log.m6277c(f6239a, "x:" + this.f6252e + ",y:" + this.f6253f);
                this.f6241B = this.f6252e;
                this.f6242C = this.f6253f;
            }
            this.f6256i = this.f6252e - this.f6241B;
            this.f6257j = this.f6253f - this.f6242C;
        } else if (this.f6251d == 2) {
            this.f6252e = motionEvent.getX(0);
            this.f6253f = motionEvent.getY(0);
            this.f6254g = motionEvent.getX(1);
            this.f6255h = motionEvent.getY(1);
            this.f6246G[0] = this.f6254g - this.f6252e;
            this.f6246G[1] = this.f6255h - this.f6253f;
            this.f6246G[2] = 0.0f;
            this.f6246G[3] = 1.0f;
            float length = Matrix.length(this.f6246G[0], this.f6246G[1], this.f6246G[2]);
            float[] fArr = this.f6246G;
            fArr[0] = fArr[0] / length;
            float[] fArr2 = this.f6246G;
            fArr2[1] = fArr2[1] / length;
            if (this.f6269v) {
                this.f6241B = this.f6252e;
                this.f6242C = this.f6253f;
                this.f6243D = this.f6254g;
                this.f6244E = this.f6255h;
                System.arraycopy(this.f6246G, 0, this.f6245F, 0, this.f6246G.length);
            }
            this.f6256i = this.f6252e - this.f6241B;
            this.f6257j = this.f6253f - this.f6242C;
            this.f6258k = this.f6254g - this.f6243D;
            this.f6259l = this.f6255h - this.f6244E;
            this.f6247H[0] = (this.f6245F[1] * this.f6246G[2]) - (this.f6245F[2] * this.f6246G[1]);
            this.f6247H[1] = (this.f6245F[2] * this.f6246G[0]) - (this.f6245F[0] * this.f6246G[2]);
            this.f6247H[2] = (this.f6245F[0] * this.f6246G[1]) - (this.f6245F[1] * this.f6246G[0]);
            float length2 = Matrix.length(this.f6247H[0], this.f6247H[1], this.f6247H[2]);
            float[] fArr3 = this.f6247H;
            fArr3[0] = fArr3[0] / length2;
            float[] fArr4 = this.f6247H;
            fArr4[1] = fArr4[1] / length2;
            float[] fArr5 = this.f6247H;
            fArr5[2] = fArr5[2] / length2;
            this.f6261n = (float) Math.sqrt(Math.pow(this.f6243D - this.f6241B, 2.0d) + Math.pow(this.f6244E - this.f6242C, 2.0d));
            this.f6260m = (float) Math.sqrt(Math.pow(this.f6254g - this.f6252e, 2.0d) + Math.pow(this.f6255h - this.f6253f, 2.0d));
            this.f6262o = motionEvent.getPressure(0);
            this.f6263p = motionEvent.getPressure(1);
            this.f6264q = 0.0f;
            this.f6264q = TouchController_2.m6360a(motionEvent);
            this.f6265r = TouchController_2.m6361b(motionEvent);
            if (this.f6265r == 1 && this.f6248I == 4.0f) {
                this.f6264q = 0.0f;
            } else if (this.f6265r == 4 && this.f6248I == 1.0f) {
                this.f6264q = 360.0f;
            }
            this.f6267t = !this.f6266s && this.f6256i * this.f6258k < 0.0f && this.f6257j * this.f6259l < 0.0f && Math.abs(this.f6256i + this.f6258k) < 10.0f && Math.abs(this.f6257j + this.f6259l) < 10.0f;
            this.f6268u = !this.f6267t && this.f6256i * this.f6258k > 0.0f && this.f6257j * this.f6259l > 0.0f;
        }
        if (this.f6251d == 1 && this.f6271x) {
            this.f6249b.getModelActivity().m6284c().m6331a(this.f6252e, this.f6253f);
        }
        int iMax = Math.max(this.f6250c.m6294d(), this.f6250c.m6295e());
        if (this.f6273z > 1) {
            SceneLoader c1239jM6284c = this.f6249b.getModelActivity().m6284c();
            c1239jM6284c.m6337b(this.f6256i, this.f6257j);
            Camera c4056cM6336b = c1239jM6284c.m6336b();
            if (this.f6251d != 1 || this.f6262o <= 4.0f) {
                if (this.f6251d == 1) {
                    this.f6240A = 5;
                    float COUIBaseListPopupWindow_12 = iMax;
                    this.f6256i = (float) ((this.f6256i / COUIBaseListPopupWindow_12) * 3.141592653589793d * 2.0d);
                    this.f6257j = (float) ((this.f6257j / COUIBaseListPopupWindow_12) * 3.141592653589793d * 2.0d);
                } else if (this.f6251d == 2) {
                    if (this.f6267t) {
                        this.f6240A = 1;
                        float fM6292b = (((this.f6260m - this.f6261n) / iMax) * this.f6250c.m6292b()) / 3.0f;
                        Log.m6278d(f6239a, "Zooming '" + fM6292b + "'...");
                        c4056cM6336b.m26180a(fM6292b);
                    }
                    if (this.f6268u) {
                        float f2 = this.f6256i;
                        float f3 = this.f6258k;
                        float f4 = this.f6257j;
                        float f5 = this.f6259l;
                    }
                }
            }
        }
        this.f6241B = this.f6252e;
        this.f6242C = this.f6253f;
        this.f6243D = this.f6254g;
        this.f6244E = this.f6255h;
        this.f6248I = this.f6265r;
        System.arraycopy(this.f6246G, 0, this.f6245F, 0, this.f6246G.length);
        if (this.f6269v && this.f6273z > 1) {
            this.f6269v = false;
            Log.m6279e(f6239a, "Fin");
        }
        return true;
    }
}
