package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.q */
/* loaded from: classes.dex */
public class C0080q extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0080q> f338q = new LruCache<>(5);

    /* renamed from: r */
    public Mesh f339r;

    public C0080q(Resources resources, Context context) {
        super(resources, C0120m.m524a("mul"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0080q m242a(Resources resources, Context context) {
        C0080q c0080q = f338q.get(Thread.currentThread().getName());
        if (c0080q == null) {
            c0080q = new C0080q(resources, context);
            c0080q.m30a();
            f338q.put(Thread.currentThread().getName(), c0080q);
        }
        c0080q.m56a(context);
        return c0080q;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m243m() {
        f338q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) this.f339r.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) this.f339r.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) this.f339r.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) this.f339r.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f339r.trianglesBuffer.capacity(), 5123, this.f339r.trianglesBuffer);
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
}
