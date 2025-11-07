package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: BoundingBox.java */
/* loaded from: classes2.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7967a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final float[] f7968b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final float[] f7969c;
    private final float[] d_renamed;
    private final float[] e_renamed;
    private final float[] f_renamed;

    public b_renamed(java.lang.String str, float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        this(str, new float[]{f_renamed, f3, f5, 1.0f}, new float[]{f2, f4, f6, 1.0f}, org.andresoviedo.a_renamed.c_renamed.a_renamed.f7960a);
    }

    private b_renamed(java.lang.String str, float[] fArr, float[] fArr2, float[] fArr3) {
        this.f7967a = str;
        this.f7968b = new float[]{fArr[0], fArr[1], fArr[2], 1.0f};
        this.f7969c = new float[]{fArr2[0], fArr2[1], fArr2[2], 1.0f};
        this.d_renamed = fArr3;
        this.e_renamed = new float[4];
        this.f_renamed = new float[4];
        g_renamed();
    }

    private void g_renamed() {
        android.opengl.Matrix.multiplyMV(this.e_renamed, 0, this.d_renamed, 0, this.f7968b, 0);
        android.opengl.Matrix.multiplyMV(this.f_renamed, 0, this.d_renamed, 0, this.f7969c, 0);
    }

    public float a_renamed() {
        return this.e_renamed[0];
    }

    public float b_renamed() {
        return this.f_renamed[0];
    }

    public float c_renamed() {
        return this.e_renamed[1];
    }

    public float d_renamed() {
        return this.f_renamed[1];
    }

    public float e_renamed() {
        return this.e_renamed[2];
    }

    public float f_renamed() {
        return this.f_renamed[2];
    }

    public java.lang.String toString() {
        return "BoundingBox{id_renamed='" + this.f7967a + "', xMin=" + a_renamed() + ", xMax=" + b_renamed() + ", yMin=" + c_renamed() + ", yMax=" + d_renamed() + ", zMin=" + e_renamed() + ", zMax=" + f_renamed() + '}';
    }
}
