package b_renamed.b_renamed;

/* compiled from: TestSuite.java */
/* loaded from: classes.dex */
public class i_renamed implements b_renamed.b_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f1882a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.Vector<b_renamed.b_renamed.d_renamed> f1883b = new java.util.Vector<>(10);

    public static b_renamed.b_renamed.d_renamed a_renamed(java.lang.Class<?> cls, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.Object objNewInstance;
        try {
            java.lang.reflect.Constructor<?> constructorA = a_renamed(cls);
            try {
                if (constructorA.getParameterTypes().length == 0) {
                    objNewInstance = constructorA.newInstance(new java.lang.Object[0]);
                    if (objNewInstance instanceof b_renamed.b_renamed.e_renamed) {
                        ((b_renamed.b_renamed.e_renamed) objNewInstance).c_renamed(str);
                    }
                } else {
                    objNewInstance = constructorA.newInstance(str);
                }
                return (b_renamed.b_renamed.d_renamed) objNewInstance;
            } catch (java.lang.IllegalAccessException e_renamed) {
                return a_renamed("Cannot access test case: " + str + " (" + a_renamed(e_renamed) + ")");
            } catch (java.lang.InstantiationException e2) {
                return a_renamed("Cannot instantiate test case: " + str + " (" + a_renamed(e2) + ")");
            } catch (java.lang.reflect.InvocationTargetException e3) {
                return a_renamed("Exception in_renamed constructor: " + str + " (" + a_renamed(e3.getTargetException()) + ")");
            }
        } catch (java.lang.NoSuchMethodException unused) {
            return a_renamed("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    public static java.lang.reflect.Constructor<?> a_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        try {
            return cls.getConstructor(java.lang.String.class);
        } catch (java.lang.NoSuchMethodException unused) {
            return cls.getConstructor(new java.lang.Class[0]);
        }
    }

    public static b_renamed.b_renamed.d_renamed a_renamed(final java.lang.String str) {
        return new b_renamed.b_renamed.e_renamed("warning") { // from class: b_renamed.b_renamed.i_renamed.1
            @Override // b_renamed.b_renamed.e_renamed
            protected void c_renamed() {
                b_renamed(str);
            }
        };
    }

    private static java.lang.String a_renamed(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public i_renamed() {
    }

    public i_renamed(java.lang.Class<?> cls) throws java.lang.SecurityException {
        b_renamed(cls);
    }

    private void b_renamed(java.lang.Class<?> cls) throws java.lang.SecurityException {
        this.f1882a = cls.getName();
        try {
            a_renamed(cls);
            if (!java.lang.reflect.Modifier.isPublic(cls.getModifiers())) {
                a_renamed(a_renamed("Class " + cls.getName() + " is_renamed not public"));
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Class<?> superclass = cls; b_renamed.b_renamed.d_renamed.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
                for (java.lang.reflect.Method method : org.junit.internal.MethodSorter.getDeclaredMethods(superclass)) {
                    a_renamed(method, arrayList, cls);
                }
            }
            if (this.f1883b.size() == 0) {
                a_renamed(a_renamed("No tests found in_renamed " + cls.getName()));
            }
        } catch (java.lang.NoSuchMethodException unused) {
            a_renamed(a_renamed("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public i_renamed(java.lang.String str) {
        b_renamed(str);
    }

    public void a_renamed(b_renamed.b_renamed.d_renamed dVar) {
        this.f1883b.add(dVar);
    }

    @Override // b_renamed.b_renamed.d_renamed
    public int a_renamed() {
        java.util.Iterator<b_renamed.b_renamed.d_renamed> it = this.f1883b.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += it.next().a_renamed();
        }
        return iA;
    }

    public java.lang.String b_renamed() {
        return this.f1882a;
    }

    @Override // b_renamed.b_renamed.d_renamed
    public void b_renamed(b_renamed.b_renamed.h_renamed hVar) {
        java.util.Iterator<b_renamed.b_renamed.d_renamed> it = this.f1883b.iterator();
        while (it.hasNext()) {
            b_renamed.b_renamed.d_renamed next = it.next();
            if (hVar.a_renamed()) {
                return;
            } else {
                a_renamed(next, hVar);
            }
        }
    }

    public void a_renamed(b_renamed.b_renamed.d_renamed dVar, b_renamed.b_renamed.h_renamed hVar) {
        dVar.b_renamed(hVar);
    }

    public void b_renamed(java.lang.String str) {
        this.f1882a = str;
    }

    public b_renamed.b_renamed.d_renamed a_renamed(int i_renamed) {
        return this.f1883b.get(i_renamed);
    }

    public int c_renamed() {
        return this.f1883b.size();
    }

    public java.lang.String toString() {
        if (b_renamed() != null) {
            return b_renamed();
        }
        return super.toString();
    }

    private void a_renamed(java.lang.reflect.Method method, java.util.List<java.lang.String> list, java.lang.Class<?> cls) {
        java.lang.String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (!a_renamed(method)) {
            if (b_renamed(method)) {
                a_renamed(a_renamed("Test method isn't_renamed public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
                return;
            }
            return;
        }
        list.add(name);
        a_renamed(a_renamed(cls, name));
    }

    private boolean a_renamed(java.lang.reflect.Method method) {
        return b_renamed(method) && java.lang.reflect.Modifier.isPublic(method.getModifiers());
    }

    private boolean b_renamed(java.lang.reflect.Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(java.lang.Void.TYPE);
    }
}
