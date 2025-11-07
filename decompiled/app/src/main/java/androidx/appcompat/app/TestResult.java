package androidx.appcompat.app;

/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f270a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f271b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.Class<?> f272c;
    private static boolean d_renamed;
    private static java.lang.reflect.Field e_renamed;
    private static boolean f_renamed;
    private static java.lang.reflect.Field g_renamed;
    private static boolean h_renamed;

    static void a_renamed(android.content.res.Resources resources) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            d_renamed(resources);
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            c_renamed(resources);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            b_renamed(resources);
        }
    }

    private static void b_renamed(android.content.res.Resources resources) {
        java.util.Map map;
        if (!f271b) {
            try {
                f270a = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                f270a.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f271b = true;
        }
        java.lang.reflect.Field field = f270a;
        if (field != null) {
            try {
                map = (java.util.Map) field.get(resources);
            } catch (java.lang.IllegalAccessException e3) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c_renamed(android.content.res.Resources resources) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (!f271b) {
            try {
                f270a = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                f270a.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f271b = true;
        }
        java.lang.Object obj = null;
        java.lang.reflect.Field field = f270a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (java.lang.IllegalAccessException e3) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        a_renamed(obj);
    }

    private static void d_renamed(android.content.res.Resources resources) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        java.lang.Object obj;
        if (!h_renamed) {
            try {
                g_renamed = android.content.res.Resources.class.getDeclaredField("mResourcesImpl");
                g_renamed.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            h_renamed = true;
        }
        java.lang.reflect.Field field = g_renamed;
        if (field == null) {
            return;
        }
        java.lang.Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (java.lang.IllegalAccessException e3) {
            android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f271b) {
            try {
                f270a = obj.getClass().getDeclaredField("mDrawableCache");
                f270a.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e4) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f271b = true;
        }
        java.lang.reflect.Field field2 = f270a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (java.lang.IllegalAccessException e5) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            a_renamed(obj2);
        }
    }

    private static void a_renamed(java.lang.Object obj) {
        android.util.LongSparseArray longSparseArray;
        if (!d_renamed) {
            try {
                f272c = java.lang.Class.forName("android.content.res.ThemedResourceCache");
            } catch (java.lang.ClassNotFoundException e2) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d_renamed = true;
        }
        java.lang.Class<?> cls = f272c;
        if (cls == null) {
            return;
        }
        if (!f_renamed) {
            try {
                e_renamed = cls.getDeclaredField("mUnthemedEntries");
                e_renamed.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e3) {
                android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f_renamed = true;
        }
        java.lang.reflect.Field field = e_renamed;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (android.util.LongSparseArray) field.get(obj);
        } catch (java.lang.IllegalAccessException e4) {
            android.util.Log.e_renamed("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
