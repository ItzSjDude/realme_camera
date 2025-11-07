package androidx.activity;

/* compiled from: OnBackPressedCallback.java */
/* loaded from: classes.dex */
public abstract class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f194a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.concurrent.CopyOnWriteArrayList<androidx.activity.a_renamed> f195b = new java.util.concurrent.CopyOnWriteArrayList<>();

    public abstract void c_renamed();

    public c_renamed(boolean z_renamed) {
        this.f194a = z_renamed;
    }

    public final void a_renamed(boolean z_renamed) {
        this.f194a = z_renamed;
    }

    public final boolean a_renamed() {
        return this.f194a;
    }

    public final void b_renamed() {
        java.util.Iterator<androidx.activity.a_renamed> it = this.f195b.iterator();
        while (it.hasNext()) {
            it.next().a_renamed();
        }
    }

    void a_renamed(androidx.activity.a_renamed aVar) {
        this.f195b.add(aVar);
    }

    void b_renamed(androidx.activity.a_renamed aVar) {
        this.f195b.remove(aVar);
    }
}
