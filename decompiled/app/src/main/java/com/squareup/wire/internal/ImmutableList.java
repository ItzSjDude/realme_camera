package com.squareup.wire.internal;

/* loaded from: classes2.dex */
final class ImmutableList<T_renamed> extends java.util.AbstractList<T_renamed> implements java.io.Serializable, java.util.RandomAccess {
    private final java.util.ArrayList<T_renamed> list;

    ImmutableList(java.util.List<T_renamed> list) {
        this.list = new java.util.ArrayList<>(list);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T_renamed get(int i_renamed) {
        return this.list.get(i_renamed);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public java.lang.Object[] toArray() {
        return this.list.toArray();
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return java.util.Collections.unmodifiableList(this.list);
    }
}
