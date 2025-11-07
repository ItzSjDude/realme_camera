package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    private final GeneratedAdapter[] f3600a;

    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] interfaceC0600cArr) {
        this.f3600a = interfaceC0600cArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
        MethodCallsLogger c0609l = new MethodCallsLogger();
        for (GeneratedAdapter interfaceC0600c : this.f3600a) {
            interfaceC0600c.m3637a(interfaceC0605h, aVar, false, c0609l);
        }
        for (GeneratedAdapter interfaceC0600c2 : this.f3600a) {
            interfaceC0600c2.m3637a(interfaceC0605h, aVar, true, c0609l);
        }
    }
}
