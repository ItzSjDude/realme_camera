package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher.java */
/* renamed from: androidx.appcompat.app.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class ResourcesFlusher {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Field f1014a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f1015b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Class<?> f1016c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f1017d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Field f1018e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static boolean f1019f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static Field f1020g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static boolean f1021h;

    /* renamed from: PlatformImplementations.kt_3 */
    static void m926a(Resources resources) throws IllegalAccessException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            m930d(resources);
        } else if (Build.VERSION.SDK_INT >= 23) {
            m929c(resources);
        } else if (Build.VERSION.SDK_INT >= 21) {
            m928b(resources);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m928b(Resources resources) {
        Map map;
        if (!f1015b) {
            try {
                f1014a = Resources.class.getDeclaredField("mDrawableCache");
                f1014a.setAccessible(true);
            } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", COUIBaseListPopupWindow_8);
            }
            f1015b = true;
        }
        Field field = f1014a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m929c(Resources resources) throws IllegalAccessException, IllegalArgumentException {
        if (!f1015b) {
            try {
                f1014a = Resources.class.getDeclaredField("mDrawableCache");
                f1014a.setAccessible(true);
            } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", COUIBaseListPopupWindow_8);
            }
            f1015b = true;
        }
        Object obj = null;
        Field field = f1014a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj == null) {
            return;
        }
        m927a(obj);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m930d(Resources resources) throws IllegalAccessException, IllegalArgumentException {
        Object obj;
        if (!f1021h) {
            try {
                f1020g = Resources.class.getDeclaredField("mResourcesImpl");
                f1020g.setAccessible(true);
            } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", COUIBaseListPopupWindow_8);
            }
            f1021h = true;
        }
        Field field = f1020g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e2) {
            Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1015b) {
            try {
                f1014a = obj.getClass().getDeclaredField("mDrawableCache");
                f1014a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f1015b = true;
        }
        Field field2 = f1014a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e4) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        if (obj2 != null) {
            m927a(obj2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m927a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1017d) {
            try {
                f1016c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not find ThemedResourceCache class", COUIBaseListPopupWindow_8);
            }
            f1017d = true;
        }
        Class<?> cls = f1016c;
        if (cls == null) {
            return;
        }
        if (!f1019f) {
            try {
                f1018e = cls.getDeclaredField("mUnthemedEntries");
                f1018e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1019f = true;
        }
        Field field = f1018e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.COUIBaseListPopupWindow_8("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
