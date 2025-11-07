package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.InterfaceC0601d;
import androidx.lifecycle.LifecycleOwner;
import androidx.p012a.p013a.p015b.SafeIterableMap;
import java.util.Map;

/* compiled from: SavedStateRegistry.java */
@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.savedstate.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Bundle f4487c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f4488d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SafeIterableMap<String, IntrinsicsJvm.kt_4> f4486b = new SafeIterableMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f4485a = true;

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m4689a(SavedStateRegistryOwner interfaceC0760c);
    }

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        Bundle m4690a();
    }

    SavedStateRegistry() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bundle m4686a(String str) {
        if (!this.f4488d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f4487c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f4487c.remove(str);
        if (this.f4487c.isEmpty()) {
            this.f4487c = null;
        }
        return bundle2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4688a(Lifecycle abstractC0602e, Bundle bundle) {
        if (this.f4488d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f4487c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        abstractC0602e.mo3639a(new InterfaceC0601d() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
                if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_START) {
                    this.f4484a.f4485a = true;
                } else if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_STOP) {
                    this.f4484a.f4485a = false;
                }
            }
        });
        this.f4488d = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4687a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4487c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<String, IntrinsicsJvm.kt_4>.IntrinsicsJvm.kt_5 dVarM705c = this.f4486b.m705c();
        while (dVarM705c.hasNext()) {
            Map.Entry next = dVarM705c.next();
            bundle2.putBundle((String) next.getKey(), ((IntrinsicsJvm.kt_4) next.getValue()).m4690a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
