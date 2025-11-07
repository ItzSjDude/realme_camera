package b_renamed.b_renamed;

/* compiled from: TestCase.java */
/* loaded from: classes.dex */
public abstract class e_renamed extends b_renamed.b_renamed.a_renamed implements b_renamed.b_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f1874a;

    @Override // b_renamed.b_renamed.d_renamed
    public int a_renamed() {
        return 1;
    }

    protected void d_renamed() throws java.lang.Exception {
    }

    protected void e_renamed() throws java.lang.Exception {
    }

    public e_renamed() {
        this.f1874a = null;
    }

    public e_renamed(java.lang.String str) {
        this.f1874a = str;
    }

    @Override // b_renamed.b_renamed.d_renamed
    public void b_renamed(b_renamed.b_renamed.h_renamed hVar) {
        hVar.a_renamed(this);
    }

    public void b_renamed() throws java.lang.Throwable {
        java.lang.Throwable th;
        d_renamed();
        try {
            c_renamed();
            try {
                e_renamed();
                th = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            try {
                e_renamed();
            } catch (java.lang.Throwable unused) {
            }
            throw th3;
        }
        if (th != null) {
            throw th;
        }
    }

    protected void c_renamed() throws java.lang.Throwable {
        b_renamed("TestCase.fName cannot be_renamed null", this.f1874a);
        java.lang.reflect.Method method = null;
        try {
            method = getClass().getMethod(this.f1874a, (java.lang.Class[]) null);
        } catch (java.lang.NoSuchMethodException unused) {
            b_renamed("Method \"" + this.f1874a + "\" not found");
        }
        if (!java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
            b_renamed("Method \"" + this.f1874a + "\" should be_renamed public");
        }
        try {
            method.invoke(this, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException e_renamed) {
            e_renamed.fillInStackTrace();
            throw e_renamed;
        } catch (java.lang.reflect.InvocationTargetException e2) {
            e2.fillInStackTrace();
            throw e2.getTargetException();
        }
    }

    public static void b_renamed(java.lang.String str) {
        b_renamed.b_renamed.a_renamed.a_renamed(str);
    }

    public static void b_renamed(java.lang.String str, java.lang.Object obj) {
        b_renamed.b_renamed.a_renamed.a_renamed(str, obj);
    }

    public java.lang.String toString() {
        return f_renamed() + "(" + getClass().getName() + ")";
    }

    public java.lang.String f_renamed() {
        return this.f1874a;
    }

    public void c_renamed(java.lang.String str) {
        this.f1874a = str;
    }
}
