package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateRegistryController.java */
/* renamed from: androidx.savedstate.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SavedStateRegistryOwner f4489a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SavedStateRegistry f4490b = new SavedStateRegistry();

    private SavedStateRegistryController(SavedStateRegistryOwner interfaceC0760c) {
        this.f4489a = interfaceC0760c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SavedStateRegistry m4692a() {
        return this.f4490b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4693a(Bundle bundle) {
        Lifecycle lifecycle = this.f4489a.getLifecycle();
        if (lifecycle.mo3638a() != Lifecycle.IntrinsicsJvm.kt_4.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.mo3639a(new Recreator(this.f4489a));
        this.f4490b.m4688a(lifecycle, bundle);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4694b(Bundle bundle) {
        this.f4490b.m4687a(bundle);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static SavedStateRegistryController m4691a(SavedStateRegistryOwner interfaceC0760c) {
        return new SavedStateRegistryController(interfaceC0760c);
    }
}
