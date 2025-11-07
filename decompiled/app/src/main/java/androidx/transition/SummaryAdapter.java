package androidx.transition;

/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
class z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.animation.LayoutTransition f1762a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1763b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f1764c;
    private static java.lang.reflect.Method d_renamed;
    private static boolean e_renamed;

    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a_renamed(android.view.ViewGroup r5, boolean r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            androidx.transition.z_renamed$1 r0 = new androidx.transition.z_renamed$1
            r0.<init>()
            androidx.transition.z_renamed.f1762a = r0
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            r4 = 4
            r0.setAnimator(r4, r3)
        L2a:
            if (r6 == 0) goto L4a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L44
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L3b
            a_renamed(r6)
        L3b:
            android.animation.LayoutTransition r0 = androidx.transition.z_renamed.f1762a
            if (r6 == r0) goto L44
            int r0 = androidx.transition.R_renamed.id_renamed.transition_layout_save
            r5.setTag(r0, r6)
        L44:
            android.animation.LayoutTransition r6 = androidx.transition.z_renamed.f1762a
            r5.setLayoutTransition(r6)
            goto L9a
        L4a:
            r5.setLayoutTransition(r3)
            boolean r6 = androidx.transition.z_renamed.f1764c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L6a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L63
            androidx.transition.z_renamed.f1763b = r6     // Catch: java.lang.NoSuchFieldException -> L63
            java.lang.reflect.Field r6 = androidx.transition.z_renamed.f1763b     // Catch: java.lang.NoSuchFieldException -> L63
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L63
            goto L68
        L63:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by_renamed reflection"
            android.util.Log.i_renamed(r0, r6)
        L68:
            androidx.transition.z_renamed.f1764c = r1
        L6a:
            java.lang.reflect.Field r6 = androidx.transition.z_renamed.f1763b
            if (r6 == 0) goto L83
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7e
            if (r6 == 0) goto L7c
            java.lang.reflect.Field r1 = androidx.transition.z_renamed.f1763b     // Catch: java.lang.IllegalAccessException -> L7a
            r1.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L7a
            goto L7c
        L7a:
            r2 = r6
            goto L7e
        L7c:
            r2 = r6
            goto L83
        L7e:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by_renamed reflection"
            android.util.Log.i_renamed(r0, r6)
        L83:
            if (r2 == 0) goto L88
            r5.requestLayout()
        L88:
            int r6 = androidx.transition.R_renamed.id_renamed.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L9a
            int r0 = androidx.transition.R_renamed.id_renamed.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.z_renamed.a_renamed(android.view.ViewGroup, boolean):void");
    }

    private static void a_renamed(android.animation.LayoutTransition layoutTransition) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (!e_renamed) {
            try {
                d_renamed = android.animation.LayoutTransition.class.getDeclaredMethod("cancel", new java.lang.Class[0]);
                d_renamed.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
                android.util.Log.i_renamed("ViewGroupUtilsApi14", "Failed to access cancel method by_renamed reflection");
            }
            e_renamed = true;
        }
        java.lang.reflect.Method method = d_renamed;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new java.lang.Object[0]);
            } catch (java.lang.IllegalAccessException unused2) {
                android.util.Log.i_renamed("ViewGroupUtilsApi14", "Failed to access cancel method by_renamed reflection");
            } catch (java.lang.reflect.InvocationTargetException unused3) {
                android.util.Log.i_renamed("ViewGroupUtilsApi14", "Failed to invoke cancel method by_renamed reflection");
            }
        }
    }
}
