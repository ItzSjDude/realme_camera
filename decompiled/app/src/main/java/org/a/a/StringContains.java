package org.a_renamed.a_renamed;

/* compiled from: StringContains.java */
/* loaded from: classes2.dex */
public class j_renamed extends org.a_renamed.a_renamed.k_renamed {
    @Override // org.a_renamed.a_renamed.k_renamed
    protected java.lang.String a_renamed() {
        return "containing";
    }

    public j_renamed(java.lang.String str) {
        super(str);
    }

    @Override // org.a_renamed.a_renamed.k_renamed
    protected boolean a_renamed(java.lang.String str) {
        return str.indexOf(this.f7936a) >= 0;
    }

    public static org.a_renamed.f_renamed<java.lang.String> b_renamed(java.lang.String str) {
        return new org.a_renamed.a_renamed.j_renamed(str);
    }
}
