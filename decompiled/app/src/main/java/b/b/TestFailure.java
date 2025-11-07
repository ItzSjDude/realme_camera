package b_renamed.b_renamed;

/* compiled from: TestFailure.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected b_renamed.b_renamed.d_renamed f1875a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.lang.Throwable f1876b;

    public f_renamed(b_renamed.b_renamed.d_renamed dVar, java.lang.Throwable th) {
        this.f1875a = dVar;
        this.f1876b = th;
    }

    public java.lang.String toString() {
        return this.f1875a + ": " + this.f1876b.getMessage();
    }
}
