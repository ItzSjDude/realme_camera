package androidx.appcompat.p016a.p017a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.p027a.ContextCompat;
import androidx.core.p027a.p028a.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class AppCompatResources {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ThreadLocal<TypedValue> f785a = new ThreadLocal<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final WeakHashMap<Context, SparseArray<PlatformImplementations.kt_3>> f786b = new WeakHashMap<>(0);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Object f787c = new Object();

    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m729a(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(OplusGLSurfaceView_13);
        }
        ColorStateList colorStateListM734d = m734d(context, OplusGLSurfaceView_13);
        if (colorStateListM734d != null) {
            return colorStateListM734d;
        }
        ColorStateList colorStateListM733c = m733c(context, OplusGLSurfaceView_13);
        if (colorStateListM733c != null) {
            m731a(context, OplusGLSurfaceView_13, colorStateListM733c);
            return colorStateListM733c;
        }
        return ContextCompat.m2253b(context, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Drawable m732b(Context context, int OplusGLSurfaceView_13) {
        return ResourceManagerInternal.m1462a().m1474a(context, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static ColorStateList m733c(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (m735e(context, OplusGLSurfaceView_13)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.m2257a(resources, resources.getXml(OplusGLSurfaceView_13), context.getTheme());
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static ColorStateList m734d(Context context, int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar;
        synchronized (f787c) {
            SparseArray<PlatformImplementations.kt_3> sparseArray = f786b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(OplusGLSurfaceView_13)) != null) {
                if (aVar.f789b.equals(context.getResources().getConfiguration())) {
                    return aVar.f788a;
                }
                sparseArray.remove(OplusGLSurfaceView_13);
            }
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m731a(Context context, int OplusGLSurfaceView_13, ColorStateList colorStateList) {
        synchronized (f787c) {
            SparseArray<PlatformImplementations.kt_3> sparseArray = f786b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f786b.put(context, sparseArray);
            }
            sparseArray.append(OplusGLSurfaceView_13, new PlatformImplementations.kt_3(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean m735e(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        TypedValue typedValueM730a = m730a();
        resources.getValue(OplusGLSurfaceView_13, typedValueM730a, true);
        return typedValueM730a.type >= 28 && typedValueM730a.type <= 31;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static TypedValue m730a() {
        TypedValue typedValue = f785a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f785a.set(typedValue2);
        return typedValue2;
    }

    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final ColorStateList f788a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Configuration f789b;

        PlatformImplementations.kt_3(ColorStateList colorStateList, Configuration configuration) {
            this.f788a = colorStateList;
            this.f789b = configuration;
        }
    }
}
