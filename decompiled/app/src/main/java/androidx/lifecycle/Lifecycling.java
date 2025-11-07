package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.java */
/* renamed from: androidx.lifecycle.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Lifecycling {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<Class<?>, Integer> f3647a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> f3648b = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    static LifecycleEventObserver m3659a(Object obj) {
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof FullLifecycleObserver;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m3662b(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = f3648b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m3658a(list.get(0), obj));
            }
            GeneratedAdapter[] interfaceC0600cArr = new GeneratedAdapter[list.size()];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                interfaceC0600cArr[OplusGLSurfaceView_13] = m3658a(list.get(OplusGLSurfaceView_13), obj);
            }
            return new CompositeGeneratedAdaptersObserver(interfaceC0600cArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static GeneratedAdapter m3658a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Constructor<? extends GeneratedAdapter> m3661a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strM3660a = m3660a(canonicalName);
            if (!name.isEmpty()) {
                strM3660a = name + "." + strM3660a;
            }
            Constructor declaredConstructor = Class.forName(strM3660a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m3662b(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Integer num = f3647a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iM3663c = m3663c(cls);
        f3647a.put(cls, Integer.valueOf(iM3663c));
        return iM3663c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m3663c(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> constructorM3661a = m3661a(cls);
        if (constructorM3661a != null) {
            f3648b.put(cls, Collections.singletonList(constructorM3661a));
            return 2;
        }
        if (ClassesInfoCache.f3626a.m3626a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (m3664d(superclass)) {
            if (m3662b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f3648b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (m3664d(cls2)) {
                if (m3662b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f3648b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f3648b.put(cls, arrayList);
        return 2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean m3664d(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m3660a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
