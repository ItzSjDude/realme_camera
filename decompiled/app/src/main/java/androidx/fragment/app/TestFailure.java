package androidx.fragment.app;

/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Class<?>> f1136a = new androidx.collection.SimpleArrayMap<>();

    private static java.lang.Class<?> d_renamed(java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls = f1136a.get(str);
        if (cls != null) {
            return cls;
        }
        java.lang.Class<?> cls2 = java.lang.Class.forName(str, false, classLoader);
        f1136a.put(str, cls2);
        return cls2;
    }

    static boolean a_renamed(java.lang.ClassLoader classLoader, java.lang.String str) {
        try {
            return androidx.fragment.app.Fragment.class.isAssignableFrom(d_renamed(classLoader, str));
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    public static java.lang.Class<? extends androidx.fragment.app.Fragment> b_renamed(java.lang.ClassLoader classLoader, java.lang.String str) {
        try {
            return d_renamed(classLoader, str);
        } catch (java.lang.ClassCastException e_renamed) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class is_renamed a_renamed valid subclass of_renamed Fragment", e_renamed);
        } catch (java.lang.ClassNotFoundException e2) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public androidx.fragment.app.Fragment c_renamed(java.lang.ClassLoader classLoader, java.lang.String str) {
        try {
            return b_renamed(classLoader, str).getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class name exists, is_renamed public, and has an_renamed empty constructor that is_renamed public", e_renamed);
        } catch (java.lang.InstantiationException e2) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class name exists, is_renamed public, and has an_renamed empty constructor that is_renamed public", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an_renamed exception", e4);
        }
    }
}
