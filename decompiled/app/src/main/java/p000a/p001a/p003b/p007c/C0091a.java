package p000a.p001a.p003b.p007c;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.filters.Basic;
import p000a.p001a.p003b.p005b.p006a.C0010c;
import p000a.p001a.p003b.p010f.C0113f;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class C0091a {

    /* renamed from: PlatformImplementations.kt_3 */
    public static Context f367a = new Context();

    static {
        new Context();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m264a(byte b2) {
        return b2 & 255;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m265a(Resources resources, int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = new int[1];
        C0113f.m480a(iArr.length, iArr, 0, 6408, i2, i3);
        int i4 = iArr[0];
        C0010c c0010cM59a = C0010c.m59a((Context) null);
        c0010cM59a.m63a(Basic.getInstance(resources));
        c0010cM59a.m31a(OplusGLSurfaceView_13);
        c0010cM59a.m64b(i4);
        c0010cM59a.m48c(i2, i3);
        c0010cM59a.draw();
        return i4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int[] m266a(int OplusGLSurfaceView_13, int i2, int i3) {
        byte[] bArrArray = C0113f.m474a(OplusGLSurfaceView_13, i2, i3).array();
        int[] iArr = new int[bArrArray.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = bArrArray[i4] & 255;
        }
        return iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int[] m267a(Resources resources, C0094d c0094d, int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (c0094d == null || (i3 = c0094d.f387a) < 0) {
            return null;
        }
        if (OplusGLSurfaceView_13 == c0094d.f388b && i2 == c0094d.f389c) {
            return m266a(i3, OplusGLSurfaceView_13, i2);
        }
        if (resources == null) {
            return null;
        }
        int iM265a = m265a(resources, i3, OplusGLSurfaceView_13, i2);
        int[] iArrM266a = m266a(iM265a, OplusGLSurfaceView_13, i2);
        C0113f.m476a(iM265a);
        C0097g.m312e(iM265a);
        return iArrM266a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m268b(int OplusGLSurfaceView_13, int i2, int i3) {
        return C0113f.m474a(OplusGLSurfaceView_13, i2, i3).array();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m269b(Resources resources, C0094d c0094d, int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (c0094d == null || (i3 = c0094d.f387a) < 0) {
            return null;
        }
        if (OplusGLSurfaceView_13 == c0094d.f388b && i2 == c0094d.f389c) {
            return m268b(i3, OplusGLSurfaceView_13, i2);
        }
        if (resources == null) {
            return null;
        }
        int iM265a = m265a(resources, i3, OplusGLSurfaceView_13, i2);
        byte[] bArrM268b = m268b(iM265a, OplusGLSurfaceView_13, i2);
        C0113f.m476a(iM265a);
        C0097g.m312e(iM265a);
        return bArrM268b;
    }
}
