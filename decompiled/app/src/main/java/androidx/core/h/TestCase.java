package androidx.core.h_renamed;

/* compiled from: LayoutInflaterCompat.java */
/* loaded from: classes.dex */
public final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f981a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f982b;

    private static void b_renamed(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (!f982b) {
            try {
                f981a = android.view.LayoutInflater.class.getDeclaredField("mFactory2");
                f981a.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e_renamed) {
                android.util.Log.e_renamed("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on_renamed class " + android.view.LayoutInflater.class.getName() + "; inflation may have unexpected results.", e_renamed);
            }
            f982b = true;
        }
        java.lang.reflect.Field field = f981a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (java.lang.IllegalAccessException e2) {
                android.util.Log.e_renamed("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on_renamed LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void a_renamed(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        layoutInflater.setFactory2(factory2);
        if (android.os.Build.VERSION.SDK_INT < 21) {
            android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof android.view.LayoutInflater.Factory2) {
                b_renamed(layoutInflater, (android.view.LayoutInflater.Factory2) factory);
            } else {
                b_renamed(layoutInflater, factory2);
            }
        }
    }
}
