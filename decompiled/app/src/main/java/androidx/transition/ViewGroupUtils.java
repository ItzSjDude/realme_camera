package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewGroupUtils.java */
/* renamed from: androidx.transition.y */
/* loaded from: classes.dex */
class ViewGroupUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f4671a = true;

    /* renamed from: PlatformImplementations.kt_3 */
    static ViewGroupOverlayImpl m4831a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.m4828a(viewGroup);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4832a(ViewGroup viewGroup, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT >= 18) {
            m4833b(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.m4835a(viewGroup, z);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m4833b(ViewGroup viewGroup, boolean z) {
        if (f4671a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f4671a = false;
            }
        }
    }
}
