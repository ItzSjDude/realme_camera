package p000a.p001a.p003b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.C0058bt;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0010c;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0125r;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class C0090c implements AutoCloseable {

    /* renamed from: PlatformImplementations.kt_3 */
    public C0010c f360a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public C0058bt f361b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public C0094d[] f362c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f363d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f364e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f365f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f366g = 0;

    public C0090c(Resources resources, Context context) {
        this.f360a = C0010c.m59a(context);
        this.f361b = new C0058bt(resources, context);
        this.f361b.m30a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public C0094d m260a(C0094d c0094d, int OplusGLSurfaceView_13, int i2) {
        m262a(c0094d.f388b, c0094d.f389c, OplusGLSurfaceView_13, i2);
        C0094d[] c0094dArr = this.f362c;
        int length = c0094dArr.length;
        int i3 = 0;
        while (i3 < length) {
            C0094d c0094d2 = c0094dArr[i3];
            this.f361b.m212d(c0094d.f388b, c0094d.f389c);
            m263a(this.f361b, c0094d, c0094d2);
            i3++;
            c0094d = c0094d2;
        }
        return c0094d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m261a() {
        C0094d[] c0094dArr = this.f362c;
        if (c0094dArr != null) {
            for (C0094d c0094d : c0094dArr) {
                C0001a.m9a(c0094d);
            }
            this.f362c = null;
            this.f366g = 0;
            this.f365f = 0;
            this.f364e = 0;
            this.f363d = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m262a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.f362c != null && (this.f363d != OplusGLSurfaceView_13 || this.f364e != i2 || this.f365f != i3 || this.f366g != i4)) {
            m261a();
        }
        if (this.f362c == null) {
            this.f363d = OplusGLSurfaceView_13;
            this.f364e = i2;
            this.f365f = i3;
            this.f366g = i4;
            int i5 = this.f363d;
            int i6 = this.f364e;
            int i7 = 0;
            while (i5 > i3) {
                i5 >>= 1;
                if (i5 <= i3) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == 0) {
                i7 = 1;
            }
            int i8 = this.f363d;
            this.f362c = new C0094d[i7];
            int i9 = i6;
            for (int i10 = 0; i10 < i7; i10++) {
                i8 >>= 1;
                i9 >>= 1;
                int[] iArr = new int[1];
                C0113f.m480a(iArr.length, iArr, 0, 6408, i8, i9);
                this.f362c[i10] = C0113f.m486b(iArr[0], 6408, i8, i9);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m263a(AbstractC0008a abstractC0008a, C0094d c0094d, C0094d c0094d2) {
        this.f360a.m31a(c0094d.f387a);
        this.f360a.m64b(c0094d2.f387a);
        this.f360a.m42a(C0125r.m596a());
        this.f360a.m48c(c0094d2.f388b, c0094d2.f389c);
        this.f360a.m63a(abstractC0008a);
        this.f360a.draw();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        m261a();
        this.f360a = null;
        this.f361b = null;
    }
}
