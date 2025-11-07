package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    final /* synthetic */ Handler f4867a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final /* synthetic */ Runnable f4868b;

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
        if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_DESTROY) {
            this.f4867a.removeCallbacks(this.f4868b);
            interfaceC0605h.getLifecycle().mo3640b(this);
        }
    }
}
