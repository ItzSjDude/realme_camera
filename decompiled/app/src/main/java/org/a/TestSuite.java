package org.a_renamed;

/* compiled from: StringDescription.java */
/* loaded from: classes2.dex */
public class i_renamed extends org.a_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Appendable f7945b;

    public i_renamed() {
        this(new java.lang.StringBuilder());
    }

    public i_renamed(java.lang.Appendable appendable) {
        this.f7945b = appendable;
    }

    public static java.lang.String b_renamed(org.a_renamed.h_renamed hVar) {
        return new org.a_renamed.i_renamed().a_renamed(hVar).toString();
    }

    public static java.lang.String c_renamed(org.a_renamed.h_renamed hVar) {
        return b_renamed(hVar);
    }

    @Override // org.a_renamed.a_renamed
    protected void b_renamed(java.lang.String str) throws java.io.IOException {
        try {
            this.f7945b.append(str);
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException("Could not write description", e_renamed);
        }
    }

    @Override // org.a_renamed.a_renamed
    protected void a_renamed(char c2) throws java.io.IOException {
        try {
            this.f7945b.append(c2);
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException("Could not write description", e_renamed);
        }
    }

    public java.lang.String toString() {
        return this.f7945b.toString();
    }
}
