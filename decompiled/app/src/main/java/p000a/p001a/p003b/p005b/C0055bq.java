package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0096f;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bq */
/* loaded from: classes.dex */
public class C0055bq extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0055bq> f280q = new LruCache<>(5);

    /* renamed from: r */
    public C0096f f281r;

    /* renamed from: s */
    public Context.FaceState f282s;

    public C0055bq(Resources resources, Context context) {
        super(resources, C0120m.m524a("face"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0055bq m210a(Resources resources, Context context) {
        C0055bq c0055bq = f280q.get(Thread.currentThread().getName());
        if (c0055bq == null) {
            c0055bq = new C0055bq(resources, context);
            c0055bq.m30a();
            f280q.put(Thread.currentThread().getName(), c0055bq);
        }
        c0055bq.m56a(context);
        return c0055bq;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m211m() {
        f280q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "smoothMap");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.dehazeTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "faceMask");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f281r.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        if (this.f282s != null) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_smoothness"), this.f282s.skin_smoothness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_tone"), this.f282s.skin_tone);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_hue"), this.f282s.skin_hue);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_saturation"), this.f282s.skin_saturation);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_shadows"), this.f282s.skin_shadows);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "skin_highlights"), this.f282s.skin_highlights);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "teeth_whitening"), this.f282s.teeth_whitening);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "teeth_brightness"), this.f282s.teeth_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "eyes_brightness"), this.f282s.eyes_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "eyes_contrast"), this.f282s.eyes_contrast);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "eyes_clarity"), this.f282s.eyes_clarity);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "lips_brightness"), this.f282s.lips_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "lips_saturation"), this.f282s.lips_saturation);
        }
    }
}
