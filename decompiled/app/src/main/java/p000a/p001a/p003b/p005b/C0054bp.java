package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bp */
/* loaded from: classes.dex */
public class C0054bp extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public float f277n;

    /* renamed from: o */
    public float f278o;

    /* renamed from: p */
    public int f279p;

    public C0054bp(Context context, Resources resources) {
        super(context, resources);
        this.f277n = 0.5f;
        this.f278o = 0.5f;
        m30a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m208a(List<Float> list) {
        FloatBuffer floatBufferAsFloatBuffer;
        if (list == null) {
            return;
        }
        synchronized (list) {
            int size = list.size() * 4;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
            floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size && list.size() > OplusGLSurfaceView_13; OplusGLSurfaceView_13++) {
                Float fValueOf = list.get(OplusGLSurfaceView_13);
                if (!this.f21a.isSDK && OplusGLSurfaceView_13 % 4 == 1) {
                    fValueOf = Float.valueOf(1.0f - fValueOf.floatValue());
                }
                floatBufferAsFloatBuffer.put(fValueOf.floatValue());
            }
        }
        floatBufferAsFloatBuffer.position(0);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
        GLES20.glVertexAttribPointer(this.f24d, 4, 5126, false, 0, (Buffer) floatBufferAsFloatBuffer);
        GLES20.glEnableVertexAttribArray(this.f24d);
        GLES20.glUseProgram(this.f22b);
        m209l();
        GLES20.glDrawArrays(0, 0, list.size() / 4);
        GLES20.glDisableVertexAttribArray(this.f24d);
        GLES20.glDisable(3042);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo49d() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        this.f22b = AbstractC0008a.m28c(AbstractC0008a.vertexHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("paint_vertex")), AbstractC0008a.fragmentHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("paint")));
        this.f24d = GLES20.glGetAttribLocation(this.f22b, "coordinates");
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public final void m209l() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "brushMap");
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.f279p);
        GLES20.glUniform1i(iGlGetUniformLocation, 4);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_IMAGE);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, this.f21a.denoiseTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation2, 5);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "brushSize"), this.f277n);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "flow"), this.f278o);
    }
}
