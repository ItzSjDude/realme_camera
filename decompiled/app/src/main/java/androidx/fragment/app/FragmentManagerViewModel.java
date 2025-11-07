package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel.java */
/* renamed from: androidx.fragment.app.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class FragmentManagerViewModel extends ViewModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ViewModelProvider.PlatformImplementations.kt_3 f3502a = new ViewModelProvider.PlatformImplementations.kt_3() { // from class: androidx.fragment.app.OplusGLSurfaceView_15.1
        @Override // androidx.lifecycle.ViewModelProvider.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public <T extends ViewModel> T mo3539a(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f3506e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final HashSet<Fragment> f3503b = new HashSet<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final HashMap<String, FragmentManagerViewModel> f3504c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final HashMap<String, ViewModelStore> f3505d = new HashMap<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f3507f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f3508g = false;

    /* renamed from: PlatformImplementations.kt_3 */
    static FragmentManagerViewModel m3529a(ViewModelStore c0616s) {
        return (FragmentManagerViewModel) new ViewModelProvider(c0616s, f3502a).m3677a(FragmentManagerViewModel.class);
    }

    FragmentManagerViewModel(boolean z) {
        this.f3506e = z;
    }

    @Override // androidx.lifecycle.ViewModel
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3530a() {
        if (FragmentManagerImpl.f3438b) {
            Log.IntrinsicsJvm.kt_5("FragmentManager", "onCleared called for " + this);
        }
        this.f3507f = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m3532b() {
        return this.f3507f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3531a(Fragment fragment) {
        return this.f3503b.add(fragment);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    Collection<Fragment> m3534c() {
        return this.f3503b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m3533b(Fragment fragment) {
        if (!this.f3503b.contains(fragment)) {
            return true;
        }
        if (this.f3506e) {
            return this.f3507f;
        }
        return !this.f3508g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m3535c(Fragment fragment) {
        return this.f3503b.remove(fragment);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    FragmentManagerViewModel m3536d(Fragment fragment) {
        FragmentManagerViewModel c0588j = this.f3504c.get(fragment.mWho);
        if (c0588j != null) {
            return c0588j;
        }
        FragmentManagerViewModel c0588j2 = new FragmentManagerViewModel(this.f3506e);
        this.f3504c.put(fragment.mWho, c0588j2);
        return c0588j2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    ViewModelStore m3537e(Fragment fragment) {
        ViewModelStore c0616s = this.f3505d.get(fragment.mWho);
        if (c0616s != null) {
            return c0616s;
        }
        ViewModelStore c0616s2 = new ViewModelStore();
        this.f3505d.put(fragment.mWho, c0616s2);
        return c0616s2;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m3538f(Fragment fragment) {
        if (FragmentManagerImpl.f3438b) {
            Log.IntrinsicsJvm.kt_5("FragmentManager", "Clearing non-config state for " + fragment);
        }
        FragmentManagerViewModel c0588j = this.f3504c.get(fragment.mWho);
        if (c0588j != null) {
            c0588j.mo3530a();
            this.f3504c.remove(fragment.mWho);
        }
        ViewModelStore c0616s = this.f3505d.get(fragment.mWho);
        if (c0616s != null) {
            c0616s.m3681a();
            this.f3505d.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel c0588j = (FragmentManagerViewModel) obj;
        return this.f3503b.equals(c0588j.f3503b) && this.f3504c.equals(c0588j.f3504c) && this.f3505d.equals(c0588j.f3505d);
    }

    public int hashCode() {
        return (((this.f3503b.hashCode() * 31) + this.f3504c.hashCode()) * 31) + this.f3505d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f3503b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f3504c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f3505d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
