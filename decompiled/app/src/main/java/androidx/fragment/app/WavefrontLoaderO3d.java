package androidx.fragment.app;

/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
class o_renamed implements androidx.lifecycle.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.lifecycle.i_renamed f1212a = null;

    o_renamed() {
    }

    void a_renamed() {
        if (this.f1212a == null) {
            this.f1212a = new androidx.lifecycle.i_renamed(this);
        }
    }

    boolean b_renamed() {
        return this.f1212a != null;
    }

    @Override // androidx.lifecycle.h_renamed
    public androidx.lifecycle.e_renamed getLifecycle() {
        a_renamed();
        return this.f1212a;
    }

    void a_renamed(androidx.lifecycle.e_renamed.a_renamed aVar) {
        this.f1212a.a_renamed(aVar);
    }
}
