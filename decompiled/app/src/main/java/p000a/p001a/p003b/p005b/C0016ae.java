package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ae */
/* loaded from: classes.dex */
public class C0016ae extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public static LruCache<String, C0016ae> f72n = new LruCache<>(5);

    /* renamed from: o */
    public float[] f73o;

    /* renamed from: p */
    public float[] f74p;

    /* renamed from: q */
    public float[] f75q;

    /* renamed from: r */
    public float f76r;

    /* renamed from: s */
    public float f77s;

    /* renamed from: t */
    public float f78t;

    /* renamed from: u */
    public boolean f79u;

    public C0016ae(Resources resources, Context context) {
        super(context, resources);
        this.f77s = 0.0f;
        this.f78t = 0.5f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0016ae m99a(Resources resources, Context context) {
        C0016ae c0016ae = f72n.get(Thread.currentThread().getName());
        if (c0016ae == null) {
            c0016ae = new C0016ae(resources, context);
            c0016ae.m30a();
            f72n.put(Thread.currentThread().getName(), c0016ae);
        }
        c0016ae.f21a = context;
        return c0016ae;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static void m100l() {
        f72n.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m55k();
        mo23j();
        mo53h();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        this.f22b = AbstractC0008a.m28c(AbstractC0008a.vertexHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("vertex")), this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("brush_cursor")));
        this.f23c = GLES20.glGetAttribLocation(this.f22b, "a_Vertex");
        this.f24d = GLES20.glGetAttribLocation(this.f22b, "a_TexCoord");
        this.f25e = GLES20.glGetAttribLocation(this.f22b, "a_Distortion");
        this.f26f = GLES20.glGetAttribLocation(this.f22b, "a_Delta");
        this.f27g = GLES20.glGetUniformLocation(this.f22b, "u_ModelViewProjectionMatrix");
        this.f28h = GLES20.glGetUniformLocation(this.f22b, "texture");
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) Context.overlayMesh.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) Context.overlayMesh.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) Context.overlayMesh.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) Context.overlayMesh.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, Context.overlayMesh.trianglesBuffer.capacity(), 5123, Context.overlayMesh.trianglesBuffer);
        int i5 = this.f23c;
        if (i5 >= 0) {
            GLES20.glDisableVertexAttribArray(i5);
        }
        int i6 = this.f24d;
        if (i6 >= 0) {
            GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.f25e;
        if (i7 >= 0) {
            GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.f26f;
        if (i8 >= 0) {
            GLES20.glDisableVertexAttribArray(i8);
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        if (this.f73o == null) {
            this.f73o = new float[]{0.0f, 0.0f, 0.0f};
        }
        float fMin = Math.min(1.0f, this.f73o[2] * 2.0f);
        float[] fArr = this.f30j;
        float[] fArr2 = this.f21a.overlayMatrix;
        float[] fArr3 = this.f75q;
        Matrix.translateM(fArr, 0, fArr2, 0, fArr3[0], fArr3[1], fArr3[2]);
        float[] fArr4 = this.f30j;
        float[] fArr5 = this.f74p;
        Matrix.scaleM(fArr4, 0, fArr5[0], fArr5[1], fArr5[2]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "pressure"), fMin);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "hardness"), this.f77s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "flow"), this.f78t);
        super.mo23j();
    }
}
