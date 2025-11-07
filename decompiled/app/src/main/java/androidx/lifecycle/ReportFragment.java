package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: ReportFragment.java */
/* renamed from: androidx.lifecycle.p */
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 f3650a;

    /* compiled from: ReportFragment.java */
    /* renamed from: androidx.lifecycle.p$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3672a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m3673b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m3674c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3667a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3669a(PlatformImplementations.kt_3 aVar) {
        if (aVar != null) {
            aVar.m3672a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3670b(PlatformImplementations.kt_3 aVar) {
        if (aVar != null) {
            aVar.m3673b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3671c(PlatformImplementations.kt_3 aVar) {
        if (aVar != null) {
            aVar.m3674c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m3669a(this.f3650a);
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m3670b(this.f3650a);
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m3671c(this.f3650a);
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m3668a(Lifecycle.PlatformImplementations.kt_3.ON_DESTROY);
        this.f3650a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3668a(Lifecycle.PlatformImplementations.kt_3 aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).m3657a().m3653a(aVar);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).m3653a(aVar);
            }
        }
    }
}
