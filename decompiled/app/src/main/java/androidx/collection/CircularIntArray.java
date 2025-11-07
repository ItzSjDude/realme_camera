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
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = length - OplusGLSurfaceView_13;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, OplusGLSurfaceView_13, iArr2, 0, i2);
        System.arraycopy(this.mElements, 0, iArr2, i2, this.mHead);
        this.mElements = iArr2;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i3 - 1;
    }

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (OplusGLSurfaceView_13 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        OplusGLSurfaceView_13 = Integer.bitCount(OplusGLSurfaceView_13) != 1 ? Integer.highestOneBit(OplusGLSurfaceView_13 - 1) << 1 : OplusGLSurfaceView_13;
        this.mCapacityBitmask = OplusGLSurfaceView_13 - 1;
        this.mElements = new int[OplusGLSurfaceView_13];
    }

    public void addFirst(int OplusGLSurfaceView_13) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        int[] iArr = this.mElements;
        int i2 = this.mHead;
        iArr[i2] = OplusGLSurfaceView_13;
        if (i2 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int OplusGLSurfaceView_13) {
        int[] iArr = this.mElements;
        int i2 = this.mTail;
        iArr[i2] = OplusGLSurfaceView_13;
        this.mTail = this.mCapacityBitmask & (i2 + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public int popFirst() {
        int OplusGLSurfaceView_13 = this.mHead;
        if (OplusGLSurfaceView_13 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = this.mElements[OplusGLSurfaceView_13];
        this.mHead = (OplusGLSurfaceView_13 + 1) & this.mCapacityBitmask;
        return i2;
    }

    public int popLast() {
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = this.mTail;
        if (OplusGLSurfaceView_13 == i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mCapacityBitmask & (i2 - 1);
        int i4 = this.mElements[i3];
        this.mTail = i3;
        return i4;
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public void removeFromStart(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        if (OplusGLSurfaceView_13 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mHead = this.mCapacityBitmask & (this.mHead + OplusGLSurfaceView_13);
    }

    public void removeFromEnd(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        if (OplusGLSurfaceView_13 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mTail = this.mCapacityBitmask & (this.mTail - OplusGLSurfaceView_13);
    }

    public int getFirst() {
        int OplusGLSurfaceView_13 = this.mHead;
        if (OplusGLSurfaceView_13 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[OplusGLSurfaceView_13];
    }

    public int getLast() {
        int OplusGLSurfaceView_13 = this.mHead;
        int i2 = this.mTail;
        if (OplusGLSurfaceView_13 == i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (i2 - 1)];
    }

    public int get(int OplusGLSurfaceView_13) {
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
