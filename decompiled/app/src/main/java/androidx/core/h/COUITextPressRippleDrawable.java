package androidx.core.h_renamed;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class r_renamed implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.View f988a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.ViewTreeObserver f989b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.Runnable f990c;

    private r_renamed(android.view.View view, java.lang.Runnable runnable) {
        this.f988a = view;
        this.f989b = view.getViewTreeObserver();
        this.f990c = runnable;
    }

    public static androidx.core.h_renamed.r_renamed a_renamed(android.view.View view, java.lang.Runnable runnable) {
        if (view == null) {
            throw new java.lang.NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new java.lang.NullPointerException("runnable == null");
        }
        androidx.core.h_renamed.r_renamed rVar = new androidx.core.h_renamed.r_renamed(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a_renamed();
        this.f990c.run();
        return true;
    }

    public void a_renamed() {
        if (this.f989b.isAlive()) {
            this.f989b.removeOnPreDrawListener(this);
        } else {
            this.f988a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f988a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
        this.f989b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        a_renamed();
    }
}
