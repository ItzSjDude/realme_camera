package org.a_renamed.a_renamed;

/* compiled from: SubstringMatcher.java */
/* loaded from: classes2.dex */
public abstract class k_renamed extends org.a_renamed.k_renamed<java.lang.String> {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final java.lang.String f7936a;

    protected abstract java.lang.String a_renamed();

    protected abstract boolean a_renamed(java.lang.String str);

    protected k_renamed(java.lang.String str) {
        this.f7936a = str;
    }

    @Override // org.a_renamed.k_renamed
    /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
    public boolean matchesSafely(java.lang.String str) {
        return a_renamed(str);
    }

    @Override // org.a_renamed.k_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void describeMismatchSafely(java.lang.String str, org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("was \"").a_renamed(str).a_renamed("\"");
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("a_renamed string ").a_renamed(a_renamed()).a_renamed(" ").a_renamed((java.lang.Object) this.f7936a);
    }
}
