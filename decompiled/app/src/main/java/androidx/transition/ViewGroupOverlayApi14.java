package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupOverlayApi14.java */
/* renamed from: androidx.transition.v */
/* loaded from: classes.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ViewGroupOverlayApi14 m4828a(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.m4717d(viewGroup);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4829a(View view) {
        this.f4521a.m4724a(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4830b(View view) {
        this.f4521a.m4726b(view);
    }
}
