package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: FragmentViewLifecycleOwner.java */
/* renamed from: androidx.fragment.app.o */
/* loaded from: classes.dex */
class FragmentViewLifecycleOwner implements LifecycleOwner {

    /* renamed from: PlatformImplementations.kt_3 */
    private LifecycleRegistry f3598a = null;

    FragmentViewLifecycleOwner() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3605a() {
        if (this.f3598a == null) {
            this.f3598a = new LifecycleRegistry(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m3607b() {
        return this.f3598a != null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        m3605a();
        return this.f3598a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3606a(Lifecycle.PlatformImplementations.kt_3 aVar) {
        this.f3598a.m3653a(aVar);
    }
}
