package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.am */
/* loaded from: classes.dex */
public class C0024am extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0024am> f114q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f115r;

    /* renamed from: s */
    public Mesh f116s;

    public C0024am(Resources resources, Context context) {
        super(resources, C0120m.m524a("paint_box_blur"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0024am m110a(Resources resources, Context context) {
        C0024am c0024am = f114q.get(Thread.currentThread().getName());
        if (c0024am == null) {
            c0024am = new C0024am(resources, context);
            c0024am.m30a();
            f114q.put(Thread.currentThread().getName(), c0024am);
        }
        c0024am.m56a(context);
        return c0024am;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m111m() {
        f114q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) this.f116s.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) this.f116s.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) this.f116s.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) this.f116s.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f116s.trianglesBuffer.capacity(), 5123, this.f116s.trianglesBuffer);
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

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "delta"), 1, this.f115r, 0);
    }
}
