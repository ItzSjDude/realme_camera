package androidx.collection;

/* loaded from: classes.dex */
public final class CircularArray<E_renamed> {
    private int mCapacityBitmask;
    private E_renamed[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        E_renamed[] eArr = this.mElements;
        int length = eArr.length;
        int i_renamed = this.mHead;
        int i2 = length - i_renamed;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new java.lang.RuntimeException("Max array capacity exceeded");
        }
        java.lang.Object[] objArr = new java.lang.Object[i3];
        java.lang.System.arraycopy(eArr, i_renamed, objArr, 0, i2);
        java.lang.System.arraycopy(this.mElements, 0, objArr, i2, this.mHead);
        this.mElements = (E_renamed[]) objArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i3 - 1;
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i_renamed) {
        if (i_renamed < 1) {
            throw new java.lang.IllegalArgumentException("capacity must be_renamed >= 1");
        }
        if (i_renamed > 1073741824) {
            throw new java.lang.IllegalArgumentException("capacity must be_renamed <= 2^30");
        }
        i_renamed = java.lang.Integer.bitCount(i_renamed) != 1 ? java.lang.Integer.highestOneBit(i_renamed - 1) << 1 : i_renamed;
        this.mCapacityBitmask = i_renamed - 1;
        this.mElements = (E_renamed[]) new java.lang.Object[i_renamed];
    }

    public void addFirst(E_renamed e_renamed) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        E_renamed[] eArr = this.mElements;
        int i_renamed = this.mHead;
        eArr[i_renamed] = e_renamed;
        if (i_renamed == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E_renamed e_renamed) {
        E_renamed[] eArr = this.mElements;
        int i_renamed = this.mTail;
        eArr[i_renamed] = e_renamed;
        this.mTail = this.mCapacityBitmask & (i_renamed + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public E_renamed popFirst() {
        int i_renamed = this.mHead;
        if (i_renamed == this.mTail) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        E_renamed[] eArr = this.mElements;
        E_renamed e_renamed = eArr[i_renamed];
        eArr[i_renamed] = null;
        this.mHead = (i_renamed + 1) & this.mCapacityBitmask;
        return e_renamed;
    }

    public E_renamed popLast() {
        int i_renamed = this.mHead;
        int i2 = this.mTail;
        if (i_renamed == i2) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mCapacityBitmask & (i2 - 1);
        E_renamed[] eArr = this.mElements;
        E_renamed e_renamed = eArr[i3];
        eArr[i3] = null;
        this.mTail = i3;
        return e_renamed;
    }

    public void clear() {
        removeFromStart(size());
    }

    public void removeFromStart(int i_renamed) {
        if (i_renamed <= 0) {
            return;
        }
        if (i_renamed > size()) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int length = this.mElements.length;
        int i2 = this.mHead;
        if (i_renamed < length - i2) {
            length = i2 + i_renamed;
        }
        for (int i3 = this.mHead; i3 < length; i3++) {
            this.mElements[i3] = null;
        }
        int i4 = this.mHead;
        int i5 = length - i4;
        int i6 = i_renamed - i5;
        this.mHead = this.mCapacityBitmask & (i4 + i5);
        if (i6 > 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                this.mElements[i7] = null;
            }
            this.mHead = i6;
        }
    }

    public void removeFromEnd(int i_renamed) {
        int i2;
        if (i_renamed <= 0) {
            return;
        }
        if (i_renamed > size()) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mTail;
        int i4 = i_renamed < i3 ? i3 - i_renamed : 0;
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
        int i7 = i_renamed - i6;
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

    public E_renamed getFirst() {
        int i_renamed = this.mHead;
        if (i_renamed == this.mTail) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return this.mElements[i_renamed];
    }

    public E_renamed getLast() {
        int i_renamed = this.mHead;
        int i2 = this.mTail;
        if (i_renamed == i2) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (i2 - 1)];
    }

    public E_renamed get(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= size()) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i_renamed)];
    }

    public int size() {
        return this.mCapacityBitmask & (this.mTail - this.mHead);
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }
}
