package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class c_renamed implements java.lang.AutoCloseable {

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed f24a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.b_renamed.bt_renamed f25b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] f26c = null;
    public int d_renamed = 0;
    public int e_renamed = 0;
    public int f_renamed = 0;
    public int g_renamed = 0;

    public c_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        this.f24a = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.c_renamed.a_renamed(context);
        this.f25b = new a_renamed.a_renamed.b_renamed.b_renamed.bt_renamed(resources, context);
        this.f25b.a_renamed();
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2) {
        a_renamed(dVar.f35b, dVar.f36c, i_renamed, i2);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.f26c;
        int length = dVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = dVarArr[i3];
            this.f25b.d_renamed(dVar.f35b, dVar.f36c);
            a_renamed(this.f25b, dVar, dVar2);
            i3++;
            dVar = dVar2;
        }
        return dVar;
    }

    public final void a_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] dVarArr = this.f26c;
        if (dVarArr != null) {
            for (a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar : dVarArr) {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(dVar);
            }
            this.f26c = null;
            this.g_renamed = 0;
            this.f_renamed = 0;
            this.e_renamed = 0;
            this.d_renamed = 0;
        }
    }

    public final void a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (this.f26c != null && (this.d_renamed != i_renamed || this.e_renamed != i2 || this.f_renamed != i3 || this.g_renamed != i4)) {
            a_renamed();
        }
        if (this.f26c == null) {
            this.d_renamed = i_renamed;
            this.e_renamed = i2;
            this.f_renamed = i3;
            this.g_renamed = i4;
            int i5 = this.d_renamed;
            int i6 = this.e_renamed;
            int i7 = 0;
            while (i5 > i3) {
                i5 >>= 1;
                if (i5 <= i3) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == 0) {
                i7 = 1;
            }
            int i8 = this.d_renamed;
            this.f26c = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[i7];
            int i9 = i6;
            for (int i10 = 0; i10 < i7; i10++) {
                i8 >>= 1;
                i9 >>= 1;
                int[] iArr = new int[1];
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr.length, iArr, 0, 6408, i8, i9);
                this.f26c[i10] = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i8, i9);
            }
        }
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        this.f24a.a_renamed(dVar.f34a);
        this.f24a.b_renamed(dVar2.f34a);
        this.f24a.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        this.f24a.c_renamed(dVar2.f35b, dVar2.f36c);
        this.f24a.a_renamed(aVar);
        this.f24a.draw();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        a_renamed();
        this.f24a = null;
        this.f25b = null;
    }
}
