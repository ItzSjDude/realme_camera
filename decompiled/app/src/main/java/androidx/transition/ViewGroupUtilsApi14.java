package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14.java */
/* renamed from: androidx.transition.z */
/* loaded from: classes.dex */
class ViewGroupUtilsApi14 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static LayoutTransition f4672a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field f4673b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f4674c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Method f4675d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean f4676e;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m4835a(android.view.ViewGroup r5, boolean r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            androidx.transition.z$1 r0 = new androidx.transition.z$1
            r0.<init>()
            androidx.transition.ViewGroupUtilsApi14.f4672a = r0
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r4 = 4
            r0.setAnimator(r4, r3)
        L2a:
            if (r6 == 0) goto L4a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L44
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L3b
            m4834a(r6)
        L3b:
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.f4672a
            if (r6 == r0) goto L44
            int r0 = androidx.transition.R.id_renamed.transition_layout_save
            r5.setTag(r0, r6)
        L44:
            android.animation.LayoutTransition r6 = androidx.transition.ViewGroupUtilsApi14.f4672a
            r5.setLayoutTransition(r6)
            goto L9a
        L4a:
            r5.setLayoutTransition(r3)
            boolean r6 = androidx.transition.ViewGroupUtilsApi14.f4674c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L6a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L63
            androidx.transition.ViewGroupUtilsApi14.f4673b = r6     // Catch: java.lang.NoSuchFieldException -> L63
            java.lang.reflect.Field r6 = androidx.transition.ViewGroupUtilsApi14.f4673b     // Catch: java.lang.NoSuchFieldException -> L63
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L63
            goto L68
        L63:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.OplusGLSurfaceView_13(r0, r6)
        L68:
            androidx.transition.ViewGroupUtilsApi14.f4674c = r1
        L6a:
            java.lang.reflect.Field r6 = androidx.transition.ViewGroupUtilsApi14.f4673b
            if (r6 == 0) goto L83
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7e
            if (r6 == 0) goto L7c
            java.lang.reflect.Field r1 = androidx.transition.ViewGroupUtilsApi14.f4673b     // Catch: java.lang.IllegalAccessException -> L7a
            r1.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L7a
            goto L7c
        L7a:
            r2 = r6
            goto L7e
        L7c:
            r2 = r6
            goto L83
        L7e:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.OplusGLSurfaceView_13(r0, r6)
        L83:
            if (r2 == 0) goto L88
            r5.requestLayout()
        L88:
            int r6 = androidx.transition.R.id_renamed.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L9a
            int r0 = androidx.transition.R.id_renamed.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ViewGroupUtilsApi14.m4835a(android.view.ViewGroup, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4834a(LayoutTransition layoutTransition) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!f4676e) {
            try {
                f4675d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f4675d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.OplusGLSurfaceView_13("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f4676e = true;
        }
        Method method = f4675d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.OplusGLSurfaceView_13("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.OplusGLSurfaceView_13("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
