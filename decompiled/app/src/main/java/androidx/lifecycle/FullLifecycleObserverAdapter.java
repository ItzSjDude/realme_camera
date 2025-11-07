package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    private final FullLifecycleObserver f3601a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LifecycleEventObserver f3602b;

    FullLifecycleObserverAdapter(FullLifecycleObserver interfaceC0599b, LifecycleEventObserver interfaceC0603f) {
        this.f3601a = interfaceC0599b;
        this.f3602b = interfaceC0603f;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f3601a.m3631a(interfaceC0605h);
                break;
            case ON_START:
                this.f3601a.m3632b(interfaceC0605h);
                break;
            case ON_RESUME:
                this.f3601a.m3633c(interfaceC0605h);
                break;
            case ON_PAUSE:
                this.f3601a.m3634d(interfaceC0605h);
                break;
            case ON_STOP:
                this.f3601a.m3635e(interfaceC0605h);
                break;
            case ON_DESTROY:
                this.f3601a.m3636f(interfaceC0605h);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver interfaceC0603f = this.f3602b;
        if (interfaceC0603f != null) {
            interfaceC0603f.mo714a(interfaceC0605h, aVar);
        }
    }
}
