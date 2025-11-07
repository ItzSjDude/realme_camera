package org.a_renamed.a_renamed;

/* compiled from: IsNull.java */
/* loaded from: classes2.dex */
public class i_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {
    @Override // org.a_renamed.f_renamed
    public boolean matches(java.lang.Object obj) {
        return obj == null;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("null");
    }

    public static org.a_renamed.f_renamed<java.lang.Object> a_renamed() {
        return new org.a_renamed.a_renamed.i_renamed();
    }

    public static org.a_renamed.f_renamed<java.lang.Object> b_renamed() {
        return org.a_renamed.a_renamed.h_renamed.a_renamed(a_renamed());
    }
}
