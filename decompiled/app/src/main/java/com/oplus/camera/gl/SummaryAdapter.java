package com.oplus.camera.gl_renamed;

/* compiled from: YUVRenderer.java */
/* loaded from: classes2.dex */
public class z_renamed implements com.oplus.camera.gl_renamed.m_renamed.GLProducer_6 {

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.ArrayList<android.hardware.HardwareBuffer> f4687b;
    private float[] f_renamed;
    private long h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f4686a = new java.lang.Object();

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4688c = -1;
    private int d_renamed = -1;
    private com.oplus.camera.gl_renamed.h_renamed e_renamed = null;
    private com.oplus.camera.gl_renamed.g_renamed g_renamed = null;

    public z_renamed() {
        this.f4687b = null;
        this.f_renamed = new float[16];
        this.h_renamed = 0L;
        this.h_renamed = com.oplus.camera.jni.PreviewShow.init();
        android.renderscript.Matrix4f matrix4f = new android.renderscript.Matrix4f();
        matrix4f.scale(1.0f, -1.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        matrix4f.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        this.f_renamed = matrix4f.getArray();
        this.f4687b = new java.util.ArrayList<>();
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        this.g_renamed = new com.oplus.camera.gl_renamed.g_renamed(36197);
        this.e_renamed = new com.oplus.camera.gl_renamed.i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        this.f4688c = i_renamed;
        this.d_renamed = i2;
        this.e_renamed.a_renamed(this.f4688c, this.d_renamed);
    }

    public void a_renamed(android.hardware.HardwareBuffer hardwareBuffer) {
        synchronized (this.f4686a) {
            if (this.f4687b == null) {
                hardwareBuffer.close();
                return;
            }
            if (this.f4687b.size() > 15) {
                this.f4687b.remove(0).close();
            }
            this.f4687b.add(hardwareBuffer);
        }
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        this.e_renamed.a_renamed(new float[]{1.0f, 0.0f, 0.0f, 0.0f});
        a_renamed(this.e_renamed, 0, 0, this.f4688c, this.d_renamed);
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        android.hardware.HardwareBuffer hardwareBufferRemove;
        synchronized (this.f4686a) {
            hardwareBufferRemove = this.f4687b.size() > 0 ? this.f4687b.remove(0) : null;
        }
        com.oplus.camera.e_renamed.a_renamed("drawHardwareBuffer");
        if (hardwareBufferRemove != null) {
            hVar.a_renamed(2);
            int iD = hVar.d_renamed();
            int iE = hVar.e_renamed();
            hVar.a_renamed(i3, i4);
            hVar.a_renamed((i3 / 2) + i_renamed, (i4 / 2) + i2);
            hVar.a_renamed(1.0f, -1.0f, 1.0f);
            hVar.a_renamed(-r1, -r2);
            com.oplus.camera.jni.PreviewShow.process(hardwareBufferRemove, 36197, this.g_renamed.e_renamed(), this.h_renamed);
            hVar.a_renamed(this.g_renamed, this.f_renamed, i_renamed, i2, i3, i4);
            hVar.a_renamed(iD, iE);
            hVar.f_renamed();
            hardwareBufferRemove.close();
        }
        com.oplus.camera.e_renamed.b_renamed("drawHardwareBuffer");
    }

    public void a_renamed() {
        synchronized (this.f4686a) {
            if (this.f4687b.size() > 0) {
                this.f4687b.clear();
            }
        }
        com.oplus.camera.jni.PreviewShow.release(this.h_renamed);
    }
}
