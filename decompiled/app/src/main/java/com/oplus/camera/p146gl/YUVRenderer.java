package com.oplus.camera.p146gl;

import android.hardware.HardwareBuffer;
import android.renderscript.Matrix4f;
import com.oplus.camera.CameraLog;
import com.oplus.camera.jni.PreviewShow;
import com.oplus.camera.p146gl.GLProducer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: YUVRenderer.java */
/* renamed from: com.oplus.camera.gl.z */
/* loaded from: classes2.dex */
public class YUVRenderer implements GLProducer.OplusGLSurfaceView_6 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ArrayList<HardwareBuffer> f14324b;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float[] f14328f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f14330h;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f14323a = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f14325c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f14326d = -1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private GLCanvas f14327e = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ExtTexture f14329g = null;

    public YUVRenderer() {
        this.f14324b = null;
        this.f14328f = new float[16];
        this.f14330h = 0L;
        this.f14330h = PreviewShow.init();
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.scale(1.0f, -1.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        matrix4f.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        this.f14328f = matrix4f.getArray();
        this.f14324b = new ArrayList<>();
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14099a(GL10 gl10, EGLConfig eGLConfig) {
        this.f14329g = new ExtTexture(36197);
        this.f14327e = new GLES20Canvas();
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14098a(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        this.f14325c = OplusGLSurfaceView_13;
        this.f14326d = i2;
        this.f14327e.mo13966a(this.f14325c, this.f14326d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14292a(HardwareBuffer hardwareBuffer) {
        synchronized (this.f14323a) {
            if (this.f14324b == null) {
                hardwareBuffer.close();
                return;
            }
            if (this.f14324b.size() > 15) {
                this.f14324b.remove(0).close();
            }
            this.f14324b.add(hardwareBuffer);
        }
    }

    @Override // com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14097a(GL10 gl10) {
        this.f14327e.mo13977a(new float[]{1.0f, 0.0f, 0.0f, 0.0f});
        m14290a(this.f14327e, 0, 0, this.f14325c, this.f14326d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14290a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        HardwareBuffer hardwareBufferRemove;
        synchronized (this.f14323a) {
            hardwareBufferRemove = this.f14324b.size() > 0 ? this.f14324b.remove(0) : null;
        }
        CameraLog.m12952a("drawHardwareBuffer");
        if (hardwareBufferRemove != null) {
            interfaceC2757h.mo13965a(2);
            int iMo13983d = interfaceC2757h.mo13983d();
            int iMo13984e = interfaceC2757h.mo13984e();
            interfaceC2757h.mo13966a(i3, i4);
            interfaceC2757h.mo13959a((i3 / 2) + OplusGLSurfaceView_13, (i4 / 2) + i2);
            interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
            interfaceC2757h.mo13959a(-r1, -r2);
            PreviewShow.process(hardwareBufferRemove, 36197, this.f14329g.m13934e(), this.f14330h);
            interfaceC2757h.mo13973a(this.f14329g, this.f14328f, OplusGLSurfaceView_13, i2, i3, i4);
            interfaceC2757h.mo13966a(iMo13983d, iMo13984e);
            interfaceC2757h.mo13985f();
            hardwareBufferRemove.close();
        }
        CameraLog.m12958b("drawHardwareBuffer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14291a() {
        synchronized (this.f14323a) {
            if (this.f14324b.size() > 0) {
                this.f14324b.clear();
            }
        }
        PreviewShow.release(this.f14330h);
    }
}
