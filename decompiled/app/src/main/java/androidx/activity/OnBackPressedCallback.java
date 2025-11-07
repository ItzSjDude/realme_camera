package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.java */
/* renamed from: androidx.activity.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f737a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CopyOnWriteArrayList<Cancellable> f738b = new CopyOnWriteArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo728c();

    public OnBackPressedCallback(boolean z) {
        this.f737a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m724a(boolean z) {
        this.f737a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m725a() {
        return this.f737a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m726b() {
        Iterator<Cancellable> it = this.f738b.iterator();
        while (it.hasNext()) {
            it.next().mo719a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m723a(Cancellable interfaceC0173a) {
        this.f738b.add(interfaceC0173a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m727b(Cancellable interfaceC0173a) {
        this.f738b.remove(interfaceC0173a);
    }
}
