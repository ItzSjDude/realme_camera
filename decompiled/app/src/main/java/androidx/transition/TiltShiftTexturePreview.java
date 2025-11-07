package androidx.transition;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class ab_renamed implements androidx.transition.ac_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.ViewOverlay f1665a;

    ab_renamed(android.view.View view) {
        this.f1665a = view.getOverlay();
    }

    @Override // androidx.transition.ac_renamed
    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1665a.add(drawable);
    }

    @Override // androidx.transition.ac_renamed
    public void b_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1665a.remove(drawable);
    }
}
