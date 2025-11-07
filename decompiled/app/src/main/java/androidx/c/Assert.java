package androidx.c_renamed;

/* compiled from: EglRectBlt.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f660a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.nio.FloatBuffer f661b = a_renamed(f660a);

    /* renamed from: c_renamed, reason: collision with root package name */
    private final float[] f662c = new float[8];
    private final java.nio.FloatBuffer d_renamed = a_renamed(this.f662c);
    private final int e_renamed;
    private final int f_renamed;
    private androidx.c_renamed.e_renamed g_renamed;

    public static java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public a_renamed(androidx.c_renamed.e_renamed eVar, int i_renamed, int i2) {
        this.g_renamed = eVar;
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
    }

    public void a_renamed(boolean z_renamed) {
        androidx.c_renamed.e_renamed eVar = this.g_renamed;
        if (eVar != null) {
            if (z_renamed) {
                eVar.a_renamed();
            }
            this.g_renamed = null;
        }
    }

    public int a_renamed() {
        return this.g_renamed.b_renamed();
    }

    public void a_renamed(int i_renamed, android.graphics.Bitmap bitmap) {
        this.g_renamed.a_renamed(i_renamed, bitmap);
    }

    public void a_renamed(int i_renamed, float[] fArr, android.graphics.Rect rect) {
        a_renamed(rect);
        this.g_renamed.a_renamed(androidx.c_renamed.e_renamed.f688a, f661b, 0, 4, 2, 8, fArr, this.d_renamed, i_renamed, 8);
    }

    void a_renamed(android.graphics.Rect rect) {
        this.f662c[0] = rect.left / this.e_renamed;
        this.f662c[1] = 1.0f - (rect.bottom / this.f_renamed);
        this.f662c[2] = rect.right / this.e_renamed;
        this.f662c[3] = 1.0f - (rect.bottom / this.f_renamed);
        this.f662c[4] = rect.left / this.e_renamed;
        this.f662c[5] = 1.0f - (rect.top / this.f_renamed);
        this.f662c[6] = rect.right / this.e_renamed;
        this.f662c[7] = 1.0f - (rect.top / this.f_renamed);
        this.d_renamed.put(this.f662c);
        this.d_renamed.position(0);
    }
}
