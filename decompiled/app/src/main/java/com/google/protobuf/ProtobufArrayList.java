package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0);
    private E[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private ProtobufArrayList(E[] eArr, int OplusGLSurfaceView_13) {
        this.array = eArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new ProtobufArrayList<>(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E COUIBaseListPopupWindow_8) {
        ensureIsMutable();
        int OplusGLSurfaceView_13 = this.size;
        E[] eArr = this.array;
        if (OplusGLSurfaceView_13 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((OplusGLSurfaceView_13 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = COUIBaseListPopupWindow_8;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int i2;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        E[] eArr = this.array;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, OplusGLSurfaceView_13, eArr, OplusGLSurfaceView_13 + 1, i2 - OplusGLSurfaceView_13);
        } else {
            E[] eArr2 = (E[]) createArray(((i2 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, eArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, eArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = eArr2;
        }
        this.array[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        E[] eArr = this.array;
        E COUIBaseListPopupWindow_8 = eArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(eArr, OplusGLSurfaceView_13 + 1, eArr, OplusGLSurfaceView_13, (r2 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return COUIBaseListPopupWindow_8;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        E[] eArr = this.array;
        E e2 = eArr[OplusGLSurfaceView_13];
        eArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private static <E> E[] createArray(int OplusGLSurfaceView_13) {
        return (E[]) new Object[OplusGLSurfaceView_13];
    }

    private void ensureIndexInRange(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int OplusGLSurfaceView_13) {
        return "Index:" + OplusGLSurfaceView_13 + ", Size:" + this.size;
    }
}
