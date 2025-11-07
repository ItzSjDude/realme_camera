package co.polarr.renderer.filters;

import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0125r;

/* loaded from: classes.dex */
public class Basic extends C0009b {

    /* renamed from: r */
    public static LruCache<String, Basic> f5146r = new LruCache<>(5);

    /* renamed from: q */
    public boolean f5147q;

    public Basic(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
        this.f5147q = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Basic m5425a(Resources resources, Context context) {
        Basic basic = f5146r.get(Thread.currentThread().getName());
        if (basic == null) {
            basic = new Basic(resources, context);
            basic.m30a();
            f5146r.put(Thread.currentThread().getName(), basic);
        }
        basic.m56a(context);
        basic.m42a(C0125r.m596a());
        basic.f5147q = true;
        return basic;
    }

    public static Basic getInstance(Resources resources) {
        Basic basic = f5146r.get(Thread.currentThread().getName());
        if (basic == null) {
            basic = new Basic(resources, new Context());
            basic.m30a();
            f5146r.put(Thread.currentThread().getName(), basic);
        }
        basic.m42a(C0125r.m596a());
        basic.f5147q = true;
        return basic;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m5426m() {
        f5146r.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        super.draw();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
        if (this.f5147q) {
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

    public void setInputTextureId(int OplusGLSurfaceView_13) {
        m31a(OplusGLSurfaceView_13);
    }

    public void setNeedClear(boolean z) {
        this.f5147q = z;
    }
}
