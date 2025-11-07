package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: Dimensions.java */
/* loaded from: classes2.dex */
public class d_renamed {
    private static final java.text.DecimalFormat k_renamed = new java.text.DecimalFormat("0.##");

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f7973a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f7974b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f7975c;
    private float d_renamed;
    private float e_renamed;
    private float f_renamed;
    private final float[] g_renamed;
    private final float[] h_renamed;
    private final float[] i_renamed;
    private boolean j_renamed;

    public d_renamed() {
        this.f7973a = Float.MAX_VALUE;
        this.f7974b = -3.4028235E38f;
        this.f7975c = -3.4028235E38f;
        this.d_renamed = Float.MAX_VALUE;
        this.e_renamed = Float.MAX_VALUE;
        this.f_renamed = -3.4028235E38f;
        this.g_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.h_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.i_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.j_renamed = false;
    }

    public d_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        this.f7973a = Float.MAX_VALUE;
        this.f7974b = -3.4028235E38f;
        this.f7975c = -3.4028235E38f;
        this.d_renamed = Float.MAX_VALUE;
        this.e_renamed = Float.MAX_VALUE;
        this.f_renamed = -3.4028235E38f;
        this.g_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.h_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.i_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.j_renamed = false;
        this.f7973a = f_renamed;
        this.f7974b = f2;
        this.f7975c = f3;
        this.d_renamed = f4;
        this.f_renamed = f5;
        this.e_renamed = f6;
        d_renamed();
    }

    public void a_renamed(float f_renamed, float f2, float f3) {
        if (f_renamed > this.f7974b) {
            this.f7974b = f_renamed;
        }
        if (f_renamed < this.f7973a) {
            this.f7973a = f_renamed;
        }
        if (f2 > this.f7975c) {
            this.f7975c = f2;
        }
        if (f2 < this.d_renamed) {
            this.d_renamed = f2;
        }
        if (f3 > this.f_renamed) {
            this.f_renamed = f3;
        }
        if (f3 < this.e_renamed) {
            this.e_renamed = f3;
        }
        d_renamed();
    }

    private void d_renamed() {
        this.h_renamed[0] = f_renamed();
        this.h_renamed[1] = h_renamed();
        this.h_renamed[2] = j_renamed();
        this.i_renamed[0] = e_renamed();
        this.i_renamed[1] = g_renamed();
        this.i_renamed[2] = i_renamed();
        this.g_renamed[0] = (e_renamed() + f_renamed()) / 2.0f;
        this.g_renamed[1] = (g_renamed() + h_renamed()) / 2.0f;
        this.g_renamed[2] = (i_renamed() + j_renamed()) / 2.0f;
        this.j_renamed = true;
    }

    public float a_renamed() {
        return java.lang.Math.abs(e_renamed() - f_renamed());
    }

    public float b_renamed() {
        return java.lang.Math.abs(g_renamed() - h_renamed());
    }

    public float c_renamed() {
        return java.lang.Math.abs(i_renamed() - j_renamed());
    }

    private float e_renamed() {
        if (this.j_renamed) {
            return this.f7974b;
        }
        return 0.0f;
    }

    private float f_renamed() {
        if (this.j_renamed) {
            return this.f7973a;
        }
        return 0.0f;
    }

    private float g_renamed() {
        if (this.j_renamed) {
            return this.f7975c;
        }
        return 0.0f;
    }

    private float h_renamed() {
        if (this.j_renamed) {
            return this.d_renamed;
        }
        return 0.0f;
    }

    private float i_renamed() {
        if (this.j_renamed) {
            return this.f_renamed;
        }
        return 0.0f;
    }

    private float j_renamed() {
        if (this.j_renamed) {
            return this.e_renamed;
        }
        return 0.0f;
    }

    public java.lang.String toString() {
        return "Dimensions{min=" + java.util.Arrays.toString(this.h_renamed) + ", max=" + java.util.Arrays.toString(this.i_renamed) + ", center=" + java.util.Arrays.toString(this.g_renamed) + ", width=" + a_renamed() + ", height=" + b_renamed() + ", depth=" + c_renamed() + '}';
    }
}
