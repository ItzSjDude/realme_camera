package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bf */
/* loaded from: classes.dex */
public class C0044bf extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public float f195n;

    /* renamed from: o */
    public float f196o;

    /* renamed from: p */
    public float f197p;

    /* renamed from: q */
    public float[] f198q;

    /* renamed from: r */
    public boolean f199r;

    /* renamed from: s */
    public boolean f200s;

    /* renamed from: t */
    public FloatBuffer f201t;

    public C0044bf(Context context, Resources resources) {
        super(context, resources);
        this.f195n = 0.5f;
        this.f196o = 0.0f;
        this.f197p = 0.5f;
        this.f198q = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        m30a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m154a(List<Float> list, boolean z) {
        int size;
        if (list == null || list.isEmpty()) {
            return;
        }
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        if (z) {
            if (this.f199r) {
                GLES20.glBlendFuncSeparate(0, 771, 0, 771);
            } else {
                GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
            }
        } else if (!this.f199r || this.f200s) {
            GLES20.glBlendFunc(1, 769);
        } else {
            GLES20.glBlendFunc(0, 769);
        }
        if (z) {
            synchronized (list) {
                int size2 = list.size() * 4;
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size2);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                this.f201t = byteBufferAllocateDirect.asFloatBuffer();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size2 && list.size() > OplusGLSurfaceView_13; OplusGLSurfaceView_13++) {
                    Float fValueOf = list.get(OplusGLSurfaceView_13);
                    if (!this.f21a.isSDK && OplusGLSurfaceView_13 % 4 == 1) {
                        fValueOf = Float.valueOf(1.0f - fValueOf.floatValue());
                    }
                    this.f201t.put(fValueOf.floatValue());
                }
            }
            this.f201t.position(0);
            GLES20.glVertexAttribPointer(this.f24d, 4, 5126, false, 0, (Buffer) this.f201t);
            GLES20.glEnableVertexAttribArray(this.f24d);
            GLES20.glUseProgram(this.f22b);
            m155l();
            size = list.size() / 4;
        } else {
            synchronized (list) {
                int size3 = list.size() * 4;
                ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(size3);
                byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
                this.f201t = byteBufferAllocateDirect2.asFloatBuffer();
                for (int i2 = 0; i2 < size3 && list.size() > i2; i2++) {
                    Float fValueOf2 = list.get(i2);
                    if (!this.f21a.isSDK && i2 % 3 == 1) {
                        fValueOf2 = Float.valueOf(1.0f - fValueOf2.floatValue());
                    }
                    this.f201t.put(fValueOf2.floatValue());
                }
            }
            this.f201t.position(0);
            GLES20.glVertexAttribPointer(this.f24d, 3, 5126, false, 0, (Buffer) this.f201t);
            GLES20.glEnableVertexAttribArray(this.f24d);
            GLES20.glUseProgram(this.f22b);
            m155l();
            size = list.size() / 3;
        }
        GLES20.glDrawArrays(0, 0, size);
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
        this.f22b = AbstractC0008a.m28c(AbstractC0008a.vertexHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("brush_vertex")), AbstractC0008a.fragmentHeader + this.f21a.shaderUtil.m530a(this.f29i, C0120m.m524a("brush")));
        this.f24d = GLES20.glGetAttribLocation(this.f22b, "coordinates");
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m155l() {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "brushSize"), this.f195n);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "hardness"), this.f196o);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "flow"), this.f197p);
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "channelMask"), 1, this.f198q, 0);
    }
}
