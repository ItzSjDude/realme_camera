package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    private final GeneratedAdapter f3625a;

    SingleGeneratedAdapterObserver(GeneratedAdapter interfaceC0600c) {
        this.f3625a = interfaceC0600c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
        this.f3625a.m3637a(interfaceC0605h, aVar, false, null);
        this.f3625a.m3637a(interfaceC0605h, aVar, true, null);
    }
}
