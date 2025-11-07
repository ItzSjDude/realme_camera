package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bv */
/* loaded from: classes.dex */
public class C0060bv extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public static LruCache<String, C0060bv> f285n = new LruCache<>(5);

    /* renamed from: o */
    public float[] f286o;

    /* renamed from: p */
    public float f287p;

    /* renamed from: q */
    public float[] f288q;

    /* renamed from: r */
    public boolean f289r;

    public C0060bv(Resources resources, Context context) {
        super(context, resources);
        this.f286o = new float[]{0.5f, 0.5f};
        this.f287p = 42.0f;
        this.f288q = new float[]{0.0f, 0.0f, 0.0f};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0060bv m213a(Resources resources, Context context) {
        C0060bv c0060bv = f285n.get(Thread.currentThread().getName());
        if (c0060bv == null) {
            c0060bv = new C0060bv(resources, context);
            c0060bv.m30a();
            f285n.put(Thread.currentThread().getName(), c0060bv);
        }
        c0060bv.f21a = context;
        return c0060bv;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static void m214l() {
        f285n.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m55k();
        mo23j();
        mo50e();
        mo53h();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        this.f22b = AbstractC0008a.m28c(AbstractC0008a.vertexHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("vertex")), this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("color_cursor")));
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
        if (this.f286o != null) {
            GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "position"), 1, this.f286o, 0);
            float fM498c = this.f287p * C0115h.m498c(this.f21a);
            Context context = this.f21a;
            float COUIBaseListPopupWindow_12 = context.imageTexture.f388b;
            float f2 = context.screen.zoom;
            float[] fArr = {fM498c / (COUIBaseListPopupWindow_12 * f2), fM498c / (r7.f389c * f2), 1.0f};
            float[] fArr2 = this.f286o;
            float[] fArr3 = {fArr2[0] * 2.0f, (-fArr2[1]) * 2.0f, 0.0f};
            Matrix.translateM(this.f30j, 0, context.overlayMatrix, 0, fArr3[0], fArr3[1], fArr3[2]);
            Matrix.scaleM(this.f30j, 0, fArr[0], fArr[1], fArr[2]);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "texel"), 1.0f / fM498c);
            float[] fArr4 = this.f288q;
            if (fArr4 == null || fArr4.length != 3) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "colorMix"), 0.0f);
            } else {
                GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.ATTR_TTS_COLOR), 1, this.f288q, 0);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "colorMix"), 1.0f);
            }
        }
        m31a(this.f21a.dehazeTexture.f387a);
        super.mo23j();
    }
}
