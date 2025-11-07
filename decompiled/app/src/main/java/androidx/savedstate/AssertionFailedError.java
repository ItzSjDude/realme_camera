package androidx.savedstate;

/* compiled from: SavedStateRegistryController.java */
/* loaded from: classes.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.savedstate.c_renamed f1651a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.savedstate.a_renamed f1652b = new androidx.savedstate.a_renamed();

    private b_renamed(androidx.savedstate.c_renamed cVar) {
        this.f1651a = cVar;
    }

    public androidx.savedstate.a_renamed a_renamed() {
        return this.f1652b;
    }

    public void a_renamed(android.os.Bundle bundle) {
        androidx.lifecycle.e_renamed lifecycle = this.f1651a.getLifecycle();
        if (lifecycle.a_renamed() != androidx.lifecycle.e_renamed.b_renamed.INITIALIZED) {
            throw new java.lang.IllegalStateException("Restarter must be_renamed created only during owner's_renamed initialization stage");
        }
        lifecycle.a_renamed(new androidx.savedstate.Recreator(this.f1651a));
        this.f1652b.a_renamed(lifecycle, bundle);
    }

    public void b_renamed(android.os.Bundle bundle) {
        this.f1652b.a_renamed(bundle);
    }

    public static androidx.savedstate.b_renamed a_renamed(androidx.savedstate.c_renamed cVar) {
        return new androidx.savedstate.b_renamed(cVar);
    }
}
