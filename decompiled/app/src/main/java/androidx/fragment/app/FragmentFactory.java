package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FragmentFactory.java */
/* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class FragmentFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final SimpleArrayMap<String, Class<?>> f3428a = new SimpleArrayMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Class<?> m3383d(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = f3428a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f3428a.put(str, cls2);
        return cls2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m3381a(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(m3383d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Class<? extends Fragment> m3382b(ClassLoader classLoader, String str) {
        try {
            return m3383d(classLoader, str);
        } catch (ClassCastException COUIBaseListPopupWindow_8) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": make sure class is PlatformImplementations.kt_3 valid subclass of Fragment", COUIBaseListPopupWindow_8);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Fragment mo3384c(ClassLoader classLoader, String str) {
        try {
            return m3382b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", COUIBaseListPopupWindow_8);
        } catch (InstantiationException e2) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.C0573b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
