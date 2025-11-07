package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* renamed from: androidx.appcompat.widget.aq */
/* loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final WeakReference<Context> f1873a;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f1873a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(OplusGLSurfaceView_13);
        Context context = this.f1873a.get();
        if (drawable != null && context != null) {
            ResourceManagerInternal.m1462a().m1479a(context, OplusGLSurfaceView_13, drawable);
        }
        return drawable;
    }
}
