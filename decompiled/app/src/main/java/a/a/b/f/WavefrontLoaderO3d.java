package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] f111a = {null, null};

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f112b = 0;

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed() {
        return this.f111a[this.f112b];
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.f111a;
        dVarArr[0] = dVar;
        dVarArr[1] = dVar2;
        this.f112b = 0;
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed b_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.f111a;
        return dVarArr[(this.f112b + 1) % dVarArr.length];
    }

    public void c_renamed() {
        this.f112b = (this.f112b + 1) % this.f111a.length;
    }
}
