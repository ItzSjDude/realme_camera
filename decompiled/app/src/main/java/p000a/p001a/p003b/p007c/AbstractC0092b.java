package p000a.p001a.p003b.p007c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import java.io.File;
import java.util.Map;
import p000a.p001a.p003b.C0098d;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class AbstractC0092b {
    public static final String WATERMARK_PATH = "/watermark.png";

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0098d f368a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public C0097g f369b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f370c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f371d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Bitmap f372e;

    public AbstractC0092b(C0097g c0097g) {
        this.f369b = c0097g;
        m273b().currentRender = c0097g;
        m273b().context = mo270a();
        m273b().assetManager = mo270a().getAssets();
        m273b().resources = mo270a().getResources();
        m273b().glRenderView = this;
        try {
            this.f372e = m275d();
            if (this.f372e == null) {
                this.f372e = BitmapFactory.decodeStream(mo270a().getAssets().open("editor/img/sample_images/logo-large.png"));
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f368a = new C0098d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract Context mo270a();

    /* renamed from: PlatformImplementations.kt_3 */
    public void m271a(int OplusGLSurfaceView_13) {
        GLES20.glGetError();
        if (this.f368a.m427r() != OplusGLSurfaceView_13) {
            this.f368a.m401c(OplusGLSurfaceView_13);
            this.f368a.m402c(this.f370c, this.f371d);
            this.f368a.m389b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m272a(int[] iArr) {
        GLES20.glGetError();
        if (this.f368a.m388a(iArr)) {
            return;
        }
        this.f368a.m402c(this.f370c, this.f371d);
        this.f368a.m389b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final co.polarr.renderer.entities.Context m273b() {
        return C0091a.f367a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Resources m274c() {
        return mo270a().getResources();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final Bitmap m275d() {
        try {
            File file = new File(mo270a().getFilesDir().getPath() + WATERMARK_PATH);
            if (file.exists()) {
                return BitmapFactory.decodeFile(file.getPath());
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m276e() {
        this.f368a.m371a(mo270a().getResources(), 512, 512, (Map<String, Object>) null);
        this.f368a.m420k(false);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m277f() {
        C0097g c0097g = this.f369b;
        if (c0097g != null) {
            c0097g.m322c();
        }
    }
}
