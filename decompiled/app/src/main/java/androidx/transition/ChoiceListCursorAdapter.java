package androidx.transition;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class w_renamed implements androidx.transition.x_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.ViewGroupOverlay f1760a;

    w_renamed(android.view.ViewGroup viewGroup) {
        this.f1760a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ac_renamed
    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1760a.add(drawable);
    }

    @Override // androidx.transition.ac_renamed
    public void b_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1760a.remove(drawable);
    }

    @Override // androidx.transition.x_renamed
    public void a_renamed(android.view.View view) {
        this.f1760a.add(view);
    }

    @Override // androidx.transition.x_renamed
    public void b_renamed(android.view.View view) {
        this.f1760a.remove(view);
    }
}
