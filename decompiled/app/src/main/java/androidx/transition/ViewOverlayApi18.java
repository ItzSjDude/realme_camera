package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* renamed from: androidx.transition.ab */
/* loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ViewOverlay f4528a;

    ViewOverlayApi18(View view) {
        this.f4528a = view.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4718a(Drawable drawable) {
        this.f4528a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4719b(Drawable drawable) {
        this.f4528a.remove(drawable);
    }
}
