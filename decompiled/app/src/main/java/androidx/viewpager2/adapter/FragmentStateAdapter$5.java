package androidx.viewpager2.adapter;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements androidx.lifecycle.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final /* synthetic */ android.os.Handler f1816a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1817b;

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
        if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY) {
            this.f1816a.removeCallbacks(this.f1817b);
            hVar.getLifecycle().b_renamed(this);
        }
    }
}
