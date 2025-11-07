package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0125r;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bd */
/* loaded from: classes.dex */
public class C0042bd extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0042bd> f187q = new LruCache<>(5);

    public C0042bd(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0042bd m150a(Resources resources, Context context) {
        C0042bd c0042bd = f187q.get(Thread.currentThread().getName());
        if (c0042bd == null) {
            c0042bd = new C0042bd(resources, context);
            c0042bd.m30a();
            f187q.put(Thread.currentThread().getName(), c0042bd);
        }
        c0042bd.m56a(context);
        c0042bd.m42a(C0125r.m596a());
        return c0042bd;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m151m() {
        f187q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        return false;
    }
}
