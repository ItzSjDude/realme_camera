package androidx.p023c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: EglRectBlt.java */
/* renamed from: androidx.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class EglRectBlt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f2038a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final FloatBuffer f2039b = m1769a(f2038a);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float[] f2040c = new float[8];

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final FloatBuffer f2041d = m1769a(this.f2040c);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f2042e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f2043f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Texture2dProgram f2044g;

    /* renamed from: PlatformImplementations.kt_3 */
    public static FloatBuffer m1769a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public EglRectBlt(Texture2dProgram c0362e, int OplusGLSurfaceView_13, int i2) {
        this.f2044g = c0362e;
        this.f2042e = OplusGLSurfaceView_13;
        this.f2043f = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1774a(boolean z) {
        Texture2dProgram c0362e = this.f2044g;
        if (c0362e != null) {
            if (z) {
                c0362e.m1831a();
            }
            this.f2044g = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1770a() {
        return this.f2044g.m1834b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1771a(int OplusGLSurfaceView_13, Bitmap bitmap) {
        this.f2044g.m1832a(OplusGLSurfaceView_13, bitmap);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1772a(int OplusGLSurfaceView_13, float[] fArr, Rect rect) {
        m1773a(rect);
        this.f2044g.m1833a(Texture2dProgram.f2127a, f2039b, 0, 4, 2, 8, fArr, this.f2041d, OplusGLSurfaceView_13, 8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1773a(Rect rect) {
        this.f2040c[0] = rect.left / this.f2042e;
        this.f2040c[1] = 1.0f - (rect.bottom / this.f2043f);
        this.f2040c[2] = rect.right / this.f2042e;
        this.f2040c[3] = 1.0f - (rect.bottom / this.f2043f);
        this.f2040c[4] = rect.left / this.f2042e;
        this.f2040c[5] = 1.0f - (rect.top / this.f2043f);
        this.f2040c[6] = rect.right / this.f2042e;
        this.f2040c[7] = 1.0f - (rect.top / this.f2043f);
        this.f2041d.put(this.f2040c);
        this.f2041d.position(0);
    }
}
