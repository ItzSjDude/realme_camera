package org.a_renamed.b_renamed;

/* compiled from: SelfDescribingValueIterator.java */
/* loaded from: classes2.dex */
public class d_renamed<T_renamed> implements java.util.Iterator<org.a_renamed.h_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Iterator<T_renamed> f7943a;

    public d_renamed(java.util.Iterator<T_renamed> it) {
        this.f7943a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7943a.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public org.a_renamed.h_renamed next() {
        return new org.a_renamed.b_renamed.c_renamed(this.f7943a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f7943a.remove();
    }
}
