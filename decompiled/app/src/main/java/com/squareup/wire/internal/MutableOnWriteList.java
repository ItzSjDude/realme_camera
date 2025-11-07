package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class MutableOnWriteList<T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<T> immutableList;
    List<T> mutableList;

    MutableOnWriteList(List<T> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int OplusGLSurfaceView_13) {
        return this.mutableList.get(OplusGLSurfaceView_13);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mutableList.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int OplusGLSurfaceView_13, T t) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        return this.mutableList.set(OplusGLSurfaceView_13, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, T t) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        this.mutableList.add(OplusGLSurfaceView_13, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int OplusGLSurfaceView_13) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        return this.mutableList.remove(OplusGLSurfaceView_13);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }
}
