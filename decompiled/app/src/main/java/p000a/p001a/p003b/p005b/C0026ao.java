package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ao */
/* loaded from: classes.dex */
public class C0026ao extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0026ao> f119q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f120r;

    /* renamed from: s */
    public Mesh f121s;

    public C0026ao(Resources resources, Context context) {
        super(resources, C0120m.m524a("box_blur"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0026ao m112a(Resources resources, Context context) {
        C0026ao c0026ao = f119q.get(Thread.currentThread().getName());
        if (c0026ao == null) {
            c0026ao = new C0026ao(resources, context);
            c0026ao.m30a();
            f119q.put(Thread.currentThread().getName(), c0026ao);
        }
        c0026ao.m56a(context);
        return c0026ao;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m113m() {
        f119q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) this.f121s.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) this.f121s.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) this.f121s.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) this.f121s.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f121s.trianglesBuffer.capacity(), 5123, this.f121s.trianglesBuffer);
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
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "delta"), 1, this.f120r, 0);
    }
}
