package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.an */
/* loaded from: classes.dex */
public class C0025an extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0025an> f117q = new LruCache<>(5);

    /* renamed from: r */
    public boolean f118r;

    public C0025an(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
        this.f118r = true;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        super.draw();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
        if (this.f118r) {
            super.mo51f();
        }
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public float[] getMatrix() {
        return super.getMatrix();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        return false;
    }
}
