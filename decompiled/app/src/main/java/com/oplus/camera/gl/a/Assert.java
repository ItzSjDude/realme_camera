package com.oplus.camera.gl_renamed.a_renamed;

/* compiled from: GLImageCircularGaussBlurProcessor.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.a_renamed.e_renamed f4574a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4575b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4576c = 0;

    public a_renamed() {
        this.f4574a = null;
        this.f4574a = new com.oplus.camera.gl_renamed.a_renamed.e_renamed();
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f4575b = i_renamed;
        this.f4576c = i2;
    }

    public int a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2) {
        com.oplus.camera.gl_renamed.a_renamed.e_renamed eVar = this.f4574a;
        if (eVar == null) {
            return i_renamed;
        }
        eVar.a_renamed(0.0f, this.f4576c);
        int iA = this.f4574a.a_renamed(i_renamed, floatBuffer, floatBuffer2, 0);
        this.f4574a.a_renamed(this.f4575b, 0.0f);
        return this.f4574a.a_renamed(iA, floatBuffer, floatBuffer2, 1);
    }

    public void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.gl_renamed.a_renamed.e_renamed eVar = this.f4574a;
        if (eVar != null) {
            eVar.a_renamed(i_renamed, i2);
        }
    }

    public void a_renamed() {
        com.oplus.camera.gl_renamed.a_renamed.e_renamed eVar = this.f4574a;
        if (eVar != null) {
            eVar.b_renamed();
        }
    }

    public void b_renamed() {
        com.oplus.camera.gl_renamed.a_renamed.e_renamed eVar = this.f4574a;
        if (eVar != null) {
            eVar.c_renamed();
            this.f4574a = null;
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.gl_renamed.a_renamed.e_renamed eVar = this.f4574a;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }
}
