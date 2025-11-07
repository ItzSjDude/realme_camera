package androidx.core.p036h;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.r */
/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private final View f3070a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ViewTreeObserver f3071b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Runnable f3072c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f3070a = view;
        this.f3071b = view.getViewTreeObserver();
        this.f3072c = runnable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static OneShotPreDrawListener m2819a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        OneShotPreDrawListener viewOnAttachStateChangeListenerC0509r = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewOnAttachStateChangeListenerC0509r);
        view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC0509r);
        return viewOnAttachStateChangeListenerC0509r;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m2820a();
        this.f3072c.run();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2820a() {
        if (this.f3071b.isAlive()) {
            this.f3071b.removeOnPreDrawListener(this);
        } else {
            this.f3070a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3070a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f3071b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m2820a();
    }
}
