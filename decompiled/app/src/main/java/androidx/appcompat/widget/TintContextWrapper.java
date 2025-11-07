package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* renamed from: androidx.appcompat.widget.ao */
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f1865a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ArrayList<WeakReference<TintContextWrapper>> f1866b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Resources f1867c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Resources.Theme f1868d;

    /* renamed from: PlatformImplementations.kt_3 */
    public static Context m1536a(Context context) {
        if (!m1537b(context)) {
            return context;
        }
        synchronized (f1865a) {
            if (f1866b == null) {
                f1866b = new ArrayList<>();
            } else {
                for (int size = f1866b.size() - 1; size >= 0; size--) {
                    WeakReference<TintContextWrapper> weakReference = f1866b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1866b.remove(size);
                    }
                }
                for (int size2 = f1866b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<TintContextWrapper> weakReference2 = f1866b.get(size2);
                    TintContextWrapper c0319ao = weakReference2 != null ? weakReference2.get() : null;
                    if (c0319ao != null && c0319ao.getBaseContext() == context) {
                        return c0319ao;
                    }
                }
            }
            TintContextWrapper c0319ao2 = new TintContextWrapper(context);
            f1866b.add(new WeakReference<>(c0319ao2));
            return c0319ao2;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m1537b(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.m1619a();
    }

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.m1619a()) {
            this.f1867c = new VectorEnabledTintResources(this, context.getResources());
            this.f1868d = this.f1867c.newTheme();
            this.f1868d.setTo(context.getTheme());
        } else {
            this.f1867c = new TintResources(this, context.getResources());
            this.f1868d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1868d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int OplusGLSurfaceView_13) {
        Resources.Theme theme = this.f1868d;
        if (theme == null) {
            super.setTheme(OplusGLSurfaceView_13);
        } else {
            theme.applyStyle(OplusGLSurfaceView_13, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1867c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1867c.getAssets();
    }
}
