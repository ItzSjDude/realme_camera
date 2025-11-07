package com.squareup.wire.internal;

/* loaded from: classes2.dex */
final class MutableOnWriteList<T_renamed> extends java.util.AbstractList<T_renamed> implements java.io.Serializable, java.util.RandomAccess {
    private final java.util.List<T_renamed> immutableList;
    java.util.List<T_renamed> mutableList;

    MutableOnWriteList(java.util.List<T_renamed> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public T_renamed get(int i_renamed) {
        return this.mutableList.get(i_renamed);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mutableList.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T_renamed set(int i_renamed, T_renamed t_renamed) {
        java.util.List<T_renamed> list = this.mutableList;
        java.util.List<T_renamed> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new java.util.ArrayList(list2);
        }
        return this.mutableList.set(i_renamed, t_renamed);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i_renamed, T_renamed t_renamed) {
        java.util.List<T_renamed> list = this.mutableList;
        java.util.List<T_renamed> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new java.util.ArrayList(list2);
        }
        this.mutableList.add(i_renamed, t_renamed);
    }

    @Override // java.util.AbstractList, java.util.List
    public T_renamed remove(int i_renamed) {
        java.util.List<T_renamed> list = this.mutableList;
        java.util.List<T_renamed> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new java.util.ArrayList(list2);
        }
        return this.mutableList.remove(i_renamed);
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.util.ArrayList(this.mutableList);
    }
}
