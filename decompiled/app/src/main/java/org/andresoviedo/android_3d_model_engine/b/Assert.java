package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: AnimatedModel.java */
/* loaded from: classes2.dex */
public class a_renamed extends org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed {
    private float[] h_renamed;
    private java.nio.FloatBuffer i_renamed;
    private java.nio.FloatBuffer j_renamed;
    private float[][] k_renamed;

    public float[] a_renamed() {
        float[] fArr = this.h_renamed;
        return fArr == null ? org.andresoviedo.a_renamed.c_renamed.a_renamed.f7960a : fArr;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed a_renamed(java.nio.FloatBuffer floatBuffer) {
        this.i_renamed = floatBuffer;
        return this;
    }

    public java.nio.FloatBuffer b_renamed() {
        return this.i_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed b_renamed(java.nio.FloatBuffer floatBuffer) {
        this.j_renamed = floatBuffer;
        return this;
    }

    public java.nio.FloatBuffer c_renamed() {
        return this.j_renamed;
    }

    @Override // org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed
    public org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed d_renamed() {
        return super.d_renamed();
    }

    @Override // org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed
    /* renamed from: e_renamed, reason: merged with bridge method [inline-methods] */
    public org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed clone() {
        org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed aVar = new org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed();
        super.a_renamed(aVar);
        aVar.a_renamed(b_renamed());
        aVar.b_renamed(c_renamed());
        aVar.k_renamed = this.k_renamed;
        aVar.h_renamed = this.h_renamed;
        return aVar;
    }
}
