package androidx.lifecycle;

/* compiled from: ReportFragment.java */
/* loaded from: classes.dex */
public class p_renamed extends android.app.Fragment {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.lifecycle.p_renamed.a_renamed f1247a;

    /* compiled from: ReportFragment.java */
    interface a_renamed {
        void a_renamed();

        void b_renamed();

        void c_renamed();
    }

    public static void a_renamed(android.app.Activity activity) {
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new androidx.lifecycle.p_renamed(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a_renamed(androidx.lifecycle.p_renamed.a_renamed aVar) {
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    private void b_renamed(androidx.lifecycle.p_renamed.a_renamed aVar) {
        if (aVar != null) {
            aVar.b_renamed();
        }
    }

    private void c_renamed(androidx.lifecycle.p_renamed.a_renamed aVar) {
        if (aVar != null) {
            aVar.c_renamed();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
        a_renamed(this.f1247a);
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        b_renamed(this.f1247a);
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c_renamed(this.f1247a);
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY);
        this.f1247a = null;
    }

    private void a_renamed(androidx.lifecycle.e_renamed.a_renamed aVar) {
        android.content.ComponentCallbacks2 activity = getActivity();
        if (activity instanceof androidx.lifecycle.j_renamed) {
            ((androidx.lifecycle.j_renamed) activity).a_renamed().a_renamed(aVar);
        } else if (activity instanceof androidx.lifecycle.h_renamed) {
            androidx.lifecycle.e_renamed lifecycle = ((androidx.lifecycle.h_renamed) activity).getLifecycle();
            if (lifecycle instanceof androidx.lifecycle.i_renamed) {
                ((androidx.lifecycle.i_renamed) lifecycle).a_renamed(aVar);
            }
        }
    }
}
