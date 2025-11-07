package androidx.collection;

/* loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i_renamed = this.mHead;
        int i2 = length - i_renamed;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new java.lang.RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        java.lang.System.arraycopy(iArr, i_renamed, iArr2, 0, i2);
        java.lang.System.arraycopy(this.mElements, 0, iArr2, i2, this.mHead);
        this.mElements = iArr2;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i3 - 1;
    }

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i_renamed) {
        if (i_renamed < 1) {
            throw new java.lang.IllegalArgumentException("capacity must be_renamed >= 1");
        }
        if (i_renamed > 1073741824) {
            throw new java.lang.IllegalArgumentException("capacity must be_renamed <= 2^30");
        }
        i_renamed = java.lang.Integer.bitCount(i_renamed) != 1 ? java.lang.Integer.highestOneBit(i_renamed - 1) << 1 : i_renamed;
        this.mCapacityBitmask = i_renamed - 1;
        this.mElements = new int[i_renamed];
    }

    public void addFirst(int i_renamed) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        int[] iArr = this.mElements;
        int i2 = this.mHead;
        iArr[i2] = i_renamed;
        if (i2 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i_renamed) {
        int[] iArr = this.mElements;
        int i2 = this.mTail;
        iArr[i2] = i_renamed;
        this.mTail = this.mCapacityBitmask & (i2 + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public int popFirst() {
        int i_renamed = this.mHead;
        if (i_renamed == this.mTail) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i2 = this.mElements[i_renamed];
        this.mHead = (i_renamed + 1) & this.mCapacityBitmask;
        return i2;
    }

    public int popLast() {
        int i_renamed = this.mHead;
        int i2 = this.mTail;
        if (i_renamed == i2) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mCapacityBitmask & (i2 - 1);
        int i4 = this.mElements[i3];
        this.mTail = i3;
        return i4;
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public void removeFromStart(int i_renamed) {
        if (i_renamed <= 0) {
            return;
        }
        if (i_renamed > size()) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        this.mHead = this.mCapacityBitmask & (this.mHead + i_renamed);
    }

    public void removeFromEnd(int i_renamed) {
        if (i_renamed <= 0) {
            return;
        }
        if (i_renamed > size()) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        this.mTail = this.mCapacityBitmask & (this.mTail - i_renamed);
    }

    public int getFirst() {
        int i_renamed = this.mHead;
        if (i_renamed == this.mTail) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return this.mElements[i_renamed];
    }

    public int getLast() {
        int i_renamed = this.mHead;
        int i2 = this.mTail;
        if (i_renamed == i2) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (i2 - 1)];
    }

    public int get(int i_renamed) {
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
