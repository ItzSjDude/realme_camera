package androidx.constraintlayout.p025a.p026a;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ResolutionNode.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.o */
/* loaded from: classes.dex */
public class ResolutionNode {

    /* renamed from: COUIBaseListPopupWindow_10 */
    HashSet<ResolutionNode> f2347h = new HashSet<>(2);

    /* renamed from: OplusGLSurfaceView_13 */
    int f2348i = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo2067a() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2081a(ResolutionNode c0388o) {
        this.f2347h.add(c0388o);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo2073b() {
        this.f2348i = 0;
        this.f2347h.clear();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m2082e() {
        this.f2348i = 0;
        Iterator<ResolutionNode> it = this.f2347h.iterator();
        while (it.hasNext()) {
            it.next().m2082e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2083f() {
        this.f2348i = 1;
        Iterator<ResolutionNode> it = this.f2347h.iterator();
        while (it.hasNext()) {
            it.next().mo2067a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m2084g() {
        return this.f2348i == 1;
    }
}
