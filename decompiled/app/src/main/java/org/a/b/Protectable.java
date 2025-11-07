package org.a_renamed.b_renamed;

/* compiled from: SelfDescribingValue.java */
/* loaded from: classes2.dex */
public class c_renamed<T_renamed> implements org.a_renamed.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private T_renamed f7942a;

    public c_renamed(T_renamed t_renamed) {
        this.f7942a = t_renamed;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed(this.f7942a);
    }
}
