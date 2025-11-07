package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: Material.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f7979a = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f7980b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float[] f7981c;
    private float[] d_renamed;
    private float[] e_renamed;
    private float f_renamed;
    private java.lang.String h_renamed;
    private byte[] i_renamed;
    private float[] k_renamed;
    private float g_renamed = 1.0f;
    private int j_renamed = -1;

    public f_renamed() {
    }

    public f_renamed(java.lang.String str) {
        this.f7980b = str;
    }

    public byte[] a_renamed() {
        return this.i_renamed;
    }

    public int b_renamed() {
        return this.j_renamed;
    }

    public float[] c_renamed() {
        float[] fArr;
        if (a_renamed() != null) {
            return f7979a;
        }
        if (this.k_renamed == null && (fArr = this.d_renamed) != null) {
            this.k_renamed = new float[4];
            float[] fArr2 = this.k_renamed;
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[1];
            fArr2[2] = fArr[2];
            fArr2[3] = this.g_renamed;
        }
        return this.k_renamed;
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Material{name='");
        sb.append(this.f7980b);
        sb.append('\'');
        sb.append(", ambient=");
        sb.append(java.util.Arrays.toString(this.f7981c));
        sb.append(", diffuse=");
        sb.append(java.util.Arrays.toString(this.d_renamed));
        sb.append(", specular=");
        sb.append(java.util.Arrays.toString(this.e_renamed));
        sb.append(", shininess=");
        sb.append(this.f_renamed);
        sb.append(", alpha=");
        sb.append(this.g_renamed);
        sb.append(", textureFile='");
        sb.append(this.h_renamed);
        sb.append('\'');
        sb.append(", textureData=");
        if (this.i_renamed != null) {
            str = this.i_renamed.length + " (bytes)";
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", textureId=");
        sb.append(this.j_renamed);
        sb.append('}');
        return sb.toString();
    }
}
