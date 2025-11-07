package p057b.p059b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: TestCase.java */
/* renamed from: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public abstract class TestCase extends Assert implements Test {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f5012a;

    @Override // p057b.p059b.Test
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5165a() {
        return 1;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m5178d() throws Exception {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void m5179e() throws Exception {
    }

    public TestCase() {
        this.f5012a = null;
    }

    public TestCase(String str) {
        this.f5012a = str;
    }

    @Override // p057b.p059b.Test
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5168b(TestResult c0870h) {
        c0870h.m5186a(this);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5175b() throws Throwable {
        Throwable th;
        m5178d();
        try {
            mo5176c();
            try {
                m5179e();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            try {
                m5179e();
            } catch (Throwable unused) {
            }
            throw th3;
        }
        if (th != null) {
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo5176c() throws Throwable {
        m5174b("TestCase.fName cannot be null", this.f5012a);
        Method method = null;
        try {
            method = getClass().getMethod(this.f5012a, (Class[]) null);
        } catch (NoSuchMethodException unused) {
            m5173b("Method \"" + this.f5012a + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            m5173b("Method \"" + this.f5012a + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.fillInStackTrace();
            throw COUIBaseListPopupWindow_8;
        } catch (InvocationTargetException e2) {
            e2.fillInStackTrace();
            throw e2.getTargetException();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m5173b(String str) {
        Assert.m5169a(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m5174b(String str, Object obj) {
        Assert.m5170a(str, obj);
    }

    public String toString() {
        return m5180f() + "(" + getClass().getName() + ")";
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m5180f() {
        return this.f5012a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m5177c(String str) {
        this.f5012a = str;
    }
}
