package kotlinx.coroutines.internal;

/* compiled from: ArrayQueue.kt */
/* loaded from: classes2.dex */
public class a_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object[] f7858a = new java.lang.Object[16];

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7859b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7860c;

    public final boolean a_renamed() {
        return this.f7859b == this.f7860c;
    }

    public final void a_renamed(T_renamed t_renamed) {
        java.lang.Object[] objArr = this.f7858a;
        int i_renamed = this.f7860c;
        objArr[i_renamed] = t_renamed;
        this.f7860c = (objArr.length - 1) & (i_renamed + 1);
        if (this.f7860c == this.f7859b) {
            c_renamed();
        }
    }

    public final T_renamed b_renamed() {
        int i_renamed = this.f7859b;
        if (i_renamed == this.f7860c) {
            return null;
        }
        java.lang.Object[] objArr = this.f7858a;
        T_renamed t_renamed = (T_renamed) objArr[i_renamed];
        objArr[i_renamed] = null;
        this.f7859b = (i_renamed + 1) & (objArr.length - 1);
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type T_renamed");
    }

    private final void c_renamed() {
        java.lang.Object[] objArr = this.f7858a;
        int length = objArr.length;
        java.lang.Object[] objArr2 = new java.lang.Object[length << 1];
        c_renamed.a_renamed.b_renamed.a_renamed(objArr, objArr2, 0, this.f7859b, 0, 10, null);
        java.lang.Object[] objArr3 = this.f7858a;
        int length2 = objArr3.length;
        int i_renamed = this.f7859b;
        c_renamed.a_renamed.b_renamed.a_renamed(objArr3, objArr2, length2 - i_renamed, 0, i_renamed, 4, null);
        this.f7858a = objArr2;
        this.f7859b = 0;
        this.f7860c = length;
    }
}
