package org.a_renamed.b_renamed;

/* compiled from: ArrayIterator.java */
/* loaded from: classes2.dex */
public class a_renamed implements java.util.Iterator<java.lang.Object> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f7937a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7938b = 0;

    public a_renamed(java.lang.Object obj) {
        if (!obj.getClass().isArray()) {
            throw new java.lang.IllegalArgumentException("not an_renamed array");
        }
        this.f7937a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7938b < java.lang.reflect.Array.getLength(this.f7937a);
    }

    @Override // java.util.Iterator
    public java.lang.Object next() {
        java.lang.Object obj = this.f7937a;
        int i_renamed = this.f7938b;
        this.f7938b = i_renamed + 1;
        return java.lang.reflect.Array.get(obj, i_renamed);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("cannot remove items from an_renamed array");
    }
}
