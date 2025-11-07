package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;
import java.nio.Buffer;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.az */
/* loaded from: classes.dex */
public class C0037az extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0037az> f165q = new LruCache<>(5);

    /* renamed from: r */
    public int f166r;

    /* renamed from: s */
    public int f167s;

    /* renamed from: t */
    public int f168t;

    /* renamed from: u */
    public Mesh f169u;

    public C0037az(Resources resources, Context context) {
        super(resources, C0120m.m524a("combine"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0037az m140a(Resources resources, Context context) {
        C0037az c0037az = f165q.get(Thread.currentThread().getName());
        if (c0037az == null) {
            c0037az = new C0037az(resources, context);
            c0037az.m30a();
            f165q.put(Thread.currentThread().getName(), c0037az);
        }
        c0037az.m56a(context);
        return c0037az;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m141m() {
        f165q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "PlatformImplementations.kt_3");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f166r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "IntrinsicsJvm.kt_4");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f167s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "I");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f168t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 2);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) this.f169u.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) this.f169u.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) this.f169u.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) this.f169u.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f169u.trianglesBuffer.capacity(), 5123, this.f169u.trianglesBuffer);
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
