package androidx.collection;

/* loaded from: classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = length - OplusGLSurfaceView_13;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr = new Object[i3];
        System.arraycopy(eArr, OplusGLSurfaceView_13, objArr, 0, i2);
        System.arraycopy(this.mElements, 0, objArr, i2, this.mHead);
        this.mElements = (E[]) objArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i3 - 1;
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (OplusGLSurfaceView_13 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        OplusGLSurfaceView_13 = Integer.bitCount(OplusGLSurfaceView_13) != 1 ? Integer.highestOneBit(OplusGLSurfaceView_13 - 1) << 1 : OplusGLSurfaceView_13;
        this.mCapacityBitmask = OplusGLSurfaceView_13 - 1;
        this.mElements = (E[]) new Object[OplusGLSurfaceView_13];
    }

    public void addFirst(E COUIBaseListPopupWindow_8) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        E[] eArr = this.mElements;
        int OplusGLSurfaceView_13 = this.mHead;
        eArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
        if (OplusGLSurfaceView_13 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E COUIBaseListPopupWindow_8) {
        E[] eArr = this.mElements;
        int OplusGLSurfaceView_13 = this.mTail;
        eArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
        this.mTail = this.mCapacityBitmask & (OplusGLSurfaceView_13 + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public E popFirst() {
        int OplusGLSurfaceView_13 = this.mHead;
        if (OplusGLSurfaceView_13 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.mElements;
        E COUIBaseListPopupWindow_8 = eArr[OplusGLSurfaceView_13];
        eArr[OplusGLSurfaceView_13] = null;
        this.mHead = (OplusGLSurfaceView_13 + 1) & this.mCapacityBitmask;
        return COUIBaseListPopupWindow_8;
    }

    public E popLast() {
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = this.mTail;
        if (OplusGLSurfaceView_13 == i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mCapacityBitmask & (i2 - 1);
        E[] eArr = this.mElements;
        E COUIBaseListPopupWindow_8 = eArr[i3];
        eArr[i3] = null;
        this.mTail = i3;
        return COUIBaseListPopupWindow_8;
    }

    public void clear() {
        removeFromStart(size());
    }

    public void removeFromStart(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        if (OplusGLSurfaceView_13 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.mElements.length;
        int i2 = this.mHead;
        if (OplusGLSurfaceView_13 < length - i2) {
            length = i2 + OplusGLSurfaceView_13;
        }
        for (int i3 = this.mHead; i3 < length; i3++) {
            this.mElements[i3] = null;
        }
        int i4 = this.mHead;
        int i5 = length - i4;
        int i6 = OplusGLSurfaceView_13 - i5;
        this.mHead = this.mCapacityBitmask & (i4 + i5);
        if (i6 > 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                this.mElements[i7] = null;
            }
            this.mHead = i6;
        }
    }

    public void removeFromEnd(int OplusGLSurfaceView_13) {
        int i2;
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        if (OplusGLSurfaceView_13 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mTail;
        int i4 = OplusGLSurfaceView_13 < i3 ? i3 - OplusGLSurfaceView_13 : 0;
        int i5 = i4;
        while (true) {
            i2 = this.mTail;
            if (i5 >= i2) {
                break;
            }
            this.mElements[i5] = null;
            i5++;
        }
        int i6 = i2 - i4;
        int i7 = OplusGLSurfaceView_13 - i6;
        this.mTail = i2 - i6;
        if (i7 > 0) {
            this.mTail = this.mElements.length;
            int i8 = this.mTail - i7;
            for (int i9 = i8; i9 < this.mTail; i9++) {
                this.mElements[i9] = null;
            }
            this.mTail = i8;
        }
    }

    public E getFirst() {
        int OplusGLSurfaceView_13 = this.mHead;
        if (OplusGLSurfaceView_13 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[OplusGLSurfaceView_13];
    }

    public E getLast() {
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = this.mTail;
        if (OplusGLSurfaceView_13 == i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (i2 - 1)];
    }

    public E get(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + OplusGLSurfaceView_13)];
    }

    public int size() {
        return this.mCapacityBitmask & (this.mTail - this.mHead);
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }
}
