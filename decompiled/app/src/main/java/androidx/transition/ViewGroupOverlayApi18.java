package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* renamed from: androidx.transition.w */
/* loaded from: classes.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ViewGroupOverlay f4670a;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f4670a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4718a(Drawable drawable) {
        this.f4670a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4719b(Drawable drawable) {
        this.f4670a.remove(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4829a(View view) {
        this.f4670a.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4830b(View view) {
        this.f4670a.remove(view);
    }
}
