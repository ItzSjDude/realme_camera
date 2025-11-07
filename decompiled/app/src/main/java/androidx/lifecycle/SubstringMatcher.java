package androidx.lifecycle;

/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.Class<?>, java.lang.Integer> f1244a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.c_renamed>>> f1245b = new java.util.HashMap();

    static androidx.lifecycle.f_renamed a_renamed(java.lang.Object obj) {
        boolean z_renamed = obj instanceof androidx.lifecycle.f_renamed;
        boolean z2 = obj instanceof androidx.lifecycle.b_renamed;
        if (z_renamed && z2) {
            return new androidx.lifecycle.FullLifecycleObserverAdapter((androidx.lifecycle.b_renamed) obj, (androidx.lifecycle.f_renamed) obj);
        }
        if (z2) {
            return new androidx.lifecycle.FullLifecycleObserverAdapter((androidx.lifecycle.b_renamed) obj, null);
        }
        if (z_renamed) {
            return (androidx.lifecycle.f_renamed) obj;
        }
        java.lang.Class<?> cls = obj.getClass();
        if (b_renamed(cls) == 2) {
            java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.c_renamed>> list = f1245b.get(cls);
            if (list.size() == 1) {
                return new androidx.lifecycle.SingleGeneratedAdapterObserver(a_renamed(list.get(0), obj));
            }
            androidx.lifecycle.c_renamed[] cVarArr = new androidx.lifecycle.c_renamed[list.size()];
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                cVarArr[i_renamed] = a_renamed(list.get(i_renamed), obj);
            }
            return new androidx.lifecycle.CompositeGeneratedAdaptersObserver(cVarArr);
        }
        return new androidx.lifecycle.ReflectiveGenericLifecycleObserver(obj);
    }

    private static androidx.lifecycle.c_renamed a_renamed(java.lang.reflect.Constructor<? extends androidx.lifecycle.c_renamed> constructor, java.lang.Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        } catch (java.lang.InstantiationException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw new java.lang.RuntimeException(e3);
        }
    }

    private static java.lang.reflect.Constructor<? extends androidx.lifecycle.c_renamed> a_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            java.lang.Package r0 = cls.getPackage();
            java.lang.String canonicalName = cls.getCanonicalName();
            java.lang.String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            java.lang.String strA = a_renamed(canonicalName);
            if (!name.isEmpty()) {
                strA = name + "." + strA;
            }
            java.lang.reflect.Constructor declaredConstructor = java.lang.Class.forName(strA).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        } catch (java.lang.NoSuchMethodException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private static int b_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.Integer num = f1244a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iC = c_renamed(cls);
        f1244a.put(cls, java.lang.Integer.valueOf(iC));
        return iC;
    }

    private static int c_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        java.lang.reflect.Constructor<? extends androidx.lifecycle.c_renamed> constructorA = a_renamed(cls);
        if (constructorA != null) {
            f1245b.put(cls, java.util.Collections.singletonList(constructorA));
            return 2;
        }
        if (androidx.lifecycle.a_renamed.f1228a.a_renamed(cls)) {
            return 1;
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        java.util.ArrayList arrayList = null;
        if (d_renamed(superclass)) {
            if (b_renamed(superclass) == 1) {
                return 1;
            }
            arrayList = new java.util.ArrayList(f1245b.get(superclass));
        }
        for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
            if (d_renamed(cls2)) {
                if (b_renamed(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.addAll(f1245b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f1245b.put(cls, arrayList);
        return 2;
    }

    private static boolean d_renamed(java.lang.Class<?> cls) {
        return cls != null && androidx.lifecycle.g_renamed.class.isAssignableFrom(cls);
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
