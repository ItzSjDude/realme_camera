package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources.java */
/* renamed from: androidx.appcompat.widget.aw */
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f1919a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final WeakReference<Context> f1920b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m1619a() {
        return m1620b() && Build.VERSION.SDK_INT <= 20;
    }

    public VectorEnabledTintResources(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1920b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        Context context = this.f1920b.get();
        if (context != null) {
            return ResourceManagerInternal.m1462a().m1476a(context, this, OplusGLSurfaceView_13);
        }
        return super.getDrawable(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final Drawable m1621a(int OplusGLSurfaceView_13) {
        return super.getDrawable(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m1620b() {
        return f1919a;
    }
}
