package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* renamed from: androidx.lifecycle.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class ClassesInfoCache {

    /* renamed from: PlatformImplementations.kt_3 */
    static ClassesInfoCache f3626a = new ClassesInfoCache();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Map<Class<?>, PlatformImplementations.kt_3> f3627b = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Map<Class<?>, Boolean> f3628c = new HashMap();

    ClassesInfoCache() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3626a(Class<?> cls) {
        Boolean bool = this.f3628c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrM3625c = m3625c(cls);
        for (Method method : methodArrM3625c) {
            if (((InterfaceC0612o) method.getAnnotation(InterfaceC0612o.class)) != null) {
                m3623a(cls, methodArrM3625c);
                return true;
            }
        }
        this.f3628c.put(cls, false);
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Method[] m3625c(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    PlatformImplementations.kt_3 m3627b(Class<?> cls) {
        PlatformImplementations.kt_3 aVar = this.f3627b.get(cls);
        return aVar != null ? aVar : m3623a(cls, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3624a(Map<IntrinsicsJvm.kt_4, Lifecycle.PlatformImplementations.kt_3> map, IntrinsicsJvm.kt_4 bVar, Lifecycle.PlatformImplementations.kt_3 aVar, Class<?> cls) {
        Lifecycle.PlatformImplementations.kt_3 aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f3632b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m3623a(Class<?> cls, Method[] methodArr) {
        int OplusGLSurfaceView_13;
        PlatformImplementations.kt_3 aVarM3627b;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarM3627b = m3627b(superclass)) != null) {
            map.putAll(aVarM3627b.f3630b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<IntrinsicsJvm.kt_4, Lifecycle.PlatformImplementations.kt_3> entry : m3627b(cls2).f3630b.entrySet()) {
                m3624a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m3625c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            InterfaceC0612o interfaceC0612o = (InterfaceC0612o) method.getAnnotation(InterfaceC0612o.class);
            if (interfaceC0612o != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    OplusGLSurfaceView_13 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    OplusGLSurfaceView_13 = 1;
                }
                Lifecycle.PlatformImplementations.kt_3 aVarM3666a = interfaceC0612o.m3666a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.PlatformImplementations.kt_3.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarM3666a != Lifecycle.PlatformImplementations.kt_3.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    OplusGLSurfaceView_13 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m3624a(map, new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13, method), aVarM3666a, cls);
                z = true;
            }
        }
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(map);
        this.f3627b.put(cls, aVar);
        this.f3628c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Map<Lifecycle.PlatformImplementations.kt_3, List<IntrinsicsJvm.kt_4>> f3629a = new HashMap();

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Map<IntrinsicsJvm.kt_4, Lifecycle.PlatformImplementations.kt_3> f3630b;

        PlatformImplementations.kt_3(Map<IntrinsicsJvm.kt_4, Lifecycle.PlatformImplementations.kt_3> map) {
            this.f3630b = map;
            for (Map.Entry<IntrinsicsJvm.kt_4, Lifecycle.PlatformImplementations.kt_3> entry : map.entrySet()) {
                Lifecycle.PlatformImplementations.kt_3 value = entry.getValue();
                List<IntrinsicsJvm.kt_4> arrayList = this.f3629a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f3629a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3629a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m3628a(this.f3629a.get(aVar), interfaceC0605h, aVar, obj);
            m3628a(this.f3629a.get(Lifecycle.PlatformImplementations.kt_3.ON_ANY), interfaceC0605h, aVar, obj);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static void m3628a(List<IntrinsicsJvm.kt_4> list, LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m3630a(interfaceC0605h, aVar, obj);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final int f3631a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Method f3632b;

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, Method method) {
            this.f3631a = OplusGLSurfaceView_13;
            this.f3632b = method;
            this.f3632b.setAccessible(true);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3630a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int OplusGLSurfaceView_13 = this.f3631a;
                if (OplusGLSurfaceView_13 == 0) {
                    this.f3632b.invoke(obj, new Object[0]);
                } else if (OplusGLSurfaceView_13 == 1) {
                    this.f3632b.invoke(obj, interfaceC0605h);
                } else {
                    if (OplusGLSurfaceView_13 != 2) {
                        return;
                    }
                    this.f3632b.invoke(obj, interfaceC0605h, aVar);
                }
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntrinsicsJvm.kt_4)) {
                return false;
            }
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) obj;
            return this.f3631a == bVar.f3631a && this.f3632b.getName().equals(bVar.f3632b.getName());
        }

        public int hashCode() {
            return (this.f3631a * 31) + this.f3632b.getName().hashCode();
        }
    }
}
