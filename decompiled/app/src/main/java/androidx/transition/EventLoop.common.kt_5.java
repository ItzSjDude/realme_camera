package androidx.transition;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class am_renamed implements androidx.transition.an_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.WindowId f1690a;

    am_renamed(android.view.View view) {
        this.f1690a = view.getWindowId();
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof androidx.transition.am_renamed) && ((androidx.transition.am_renamed) obj).f1690a.equals(this.f1690a);
    }

    public int hashCode() {
        return this.f1690a.hashCode();
    }
}
