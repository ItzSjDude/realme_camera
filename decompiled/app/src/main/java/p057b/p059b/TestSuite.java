package p057b.p059b;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

/* compiled from: TestSuite.java */
/* renamed from: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class TestSuite implements Test {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f5022a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Vector<Test> f5023b = new Vector<>(10);

    /* renamed from: PlatformImplementations.kt_3 */
    public static Test m5190a(Class<?> cls, String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        try {
            Constructor<?> constructorM5193a = m5193a(cls);
            try {
                if (constructorM5193a.getParameterTypes().length == 0) {
                    objNewInstance = constructorM5193a.newInstance(new Object[0]);
                    if (objNewInstance instanceof TestCase) {
                        ((TestCase) objNewInstance).m5177c(str);
                    }
                } else {
                    objNewInstance = constructorM5193a.newInstance(str);
                }
                return (Test) objNewInstance;
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                return m5191a("Cannot access test case: " + str + " (" + m5192a(COUIBaseListPopupWindow_8) + ")");
            } catch (InstantiationException e2) {
                return m5191a("Cannot instantiate test case: " + str + " (" + m5192a(e2) + ")");
            } catch (InvocationTargetException e3) {
                return m5191a("Exception in constructor: " + str + " (" + m5192a(e3.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return m5191a("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Constructor<?> m5193a(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Test m5191a(final String str) {
        return new TestCase("warning") { // from class: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13.1
            @Override // p057b.p059b.TestCase
            /* renamed from: IntrinsicsJvm.kt_3 */
            protected void mo5176c() {
                m5173b(str);
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m5192a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public TestSuite() {
    }

    public TestSuite(Class<?> cls) throws SecurityException {
        m5196b(cls);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5196b(Class<?> cls) throws SecurityException {
        this.f5022a = cls.getName();
        try {
            m5193a(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                m5199a(m5191a("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = cls; Test.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
                for (Method method : MethodSorter.getDeclaredMethods(superclass)) {
                    m5194a(method, arrayList, cls);
                }
            }
            if (this.f5023b.size() == 0) {
                m5199a(m5191a("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            m5199a(m5191a("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public TestSuite(String str) {
        m5202b(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5199a(Test interfaceC0866d) {
        this.f5023b.add(interfaceC0866d);
    }

    @Override // p057b.p059b.Test
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5165a() {
        Iterator<Test> it = this.f5023b.iterator();
        int iMo5165a = 0;
        while (it.hasNext()) {
            iMo5165a += it.next().mo5165a();
        }
        return iMo5165a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m5201b() {
        return this.f5022a;
    }

    @Override // p057b.p059b.Test
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5168b(TestResult c0870h) {
        Iterator<Test> it = this.f5023b.iterator();
        while (it.hasNext()) {
            Test next = it.next();
            if (c0870h.m5188a()) {
                return;
            } else {
                m5200a(next, c0870h);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5200a(Test interfaceC0866d, TestResult c0870h) {
        interfaceC0866d.mo5168b(c0870h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5202b(String str) {
        this.f5022a = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Test m5198a(int OplusGLSurfaceView_13) {
        return this.f5023b.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m5203c() {
        return this.f5023b.size();
    }

    public String toString() {
        if (m5201b() != null) {
            return m5201b();
        }
        return super.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5194a(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (!m5195a(method)) {
            if (m5197b(method)) {
                m5199a(m5191a("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
                return;
            }
            return;
        }
        list.add(name);
        m5199a(m5190a(cls, name));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m5195a(Method method) {
        return m5197b(method) && Modifier.isPublic(method.getModifiers());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m5197b(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }
}
