package androidx.f_renamed.a_renamed;

/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a_renamed implements androidx.f_renamed.a_renamed.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f1093a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object[] f1094b;

    public a_renamed(java.lang.String str, java.lang.Object[] objArr) {
        this.f1093a = str;
        this.f1094b = objArr;
    }

    public a_renamed(java.lang.String str) {
        this(str, null);
    }

    @Override // androidx.f_renamed.a_renamed.e_renamed
    public java.lang.String b_renamed() {
        return this.f1093a;
    }

    @Override // androidx.f_renamed.a_renamed.e_renamed
    public void a_renamed(androidx.f_renamed.a_renamed.d_renamed dVar) {
        a_renamed(dVar, this.f1094b);
    }

    public static void a_renamed(androidx.f_renamed.a_renamed.d_renamed dVar, java.lang.Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i_renamed = 0;
        while (i_renamed < length) {
            java.lang.Object obj = objArr[i_renamed];
            i_renamed++;
            a_renamed(dVar, i_renamed, obj);
        }
    }

    private static void a_renamed(androidx.f_renamed.a_renamed.d_renamed dVar, int i_renamed, java.lang.Object obj) {
        if (obj == null) {
            dVar.a_renamed(i_renamed);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.a_renamed(i_renamed, (byte[]) obj);
            return;
        }
        if (obj instanceof java.lang.Float) {
            dVar.a_renamed(i_renamed, ((java.lang.Float) obj).floatValue());
            return;
        }
        if (obj instanceof java.lang.Double) {
            dVar.a_renamed(i_renamed, ((java.lang.Double) obj).doubleValue());
            return;
        }
        if (obj instanceof java.lang.Long) {
            dVar.a_renamed(i_renamed, ((java.lang.Long) obj).longValue());
            return;
        }
        if (obj instanceof java.lang.Integer) {
            dVar.a_renamed(i_renamed, ((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Short) {
            dVar.a_renamed(i_renamed, ((java.lang.Short) obj).shortValue());
            return;
        }
        if (obj instanceof java.lang.Byte) {
            dVar.a_renamed(i_renamed, ((java.lang.Byte) obj).byteValue());
            return;
        }
        if (obj instanceof java.lang.String) {
            dVar.a_renamed(i_renamed, (java.lang.String) obj);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            dVar.a_renamed(i_renamed, ((java.lang.Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot bind " + obj + " at_renamed index " + i_renamed + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
