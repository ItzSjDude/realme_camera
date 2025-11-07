package b_renamed.a_renamed;

/* compiled from: TestDecorator.java */
/* loaded from: classes.dex */
public class a_renamed extends b_renamed.b_renamed.a_renamed implements b_renamed.b_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected b_renamed.b_renamed.d_renamed f1873a;

    public void a_renamed(b_renamed.b_renamed.h_renamed hVar) {
        this.f1873a.b_renamed(hVar);
    }

    @Override // b_renamed.b_renamed.d_renamed
    public int a_renamed() {
        return this.f1873a.a_renamed();
    }

    @Override // b_renamed.b_renamed.d_renamed
    public void b_renamed(b_renamed.b_renamed.h_renamed hVar) {
        a_renamed(hVar);
    }

    public java.lang.String toString() {
        return this.f1873a.toString();
    }

    public b_renamed.b_renamed.d_renamed b_renamed() {
        return this.f1873a;
    }
}
