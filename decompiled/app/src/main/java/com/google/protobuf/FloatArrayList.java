package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final FloatArrayList EMPTY_LIST = new FloatArrayList(new float[0], 0);
    private float[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    FloatArrayList() {
        this(new float[10], 0);
    }

    private FloatArrayList(float[] fArr, int OplusGLSurfaceView_13) {
        this.array = fArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        if (i2 < OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.array;
        System.arraycopy(fArr, i2, fArr, OplusGLSurfaceView_13, this.size - i2);
        this.size -= i2 - OplusGLSurfaceView_13;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (Float.floatToIntBits(this.array[OplusGLSurfaceView_13]) != Float.floatToIntBits(fArr[OplusGLSurfaceView_13])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.array[OplusGLSurfaceView_13]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new FloatArrayList(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int OplusGLSurfaceView_13) {
        return Float.valueOf(getFloat(OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int OplusGLSurfaceView_13, Float COUIBaseListPopupWindow_12) {
        return Float.valueOf(setFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12.floatValue()));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        float[] fArr = this.array;
        float f2 = fArr[OplusGLSurfaceView_13];
        fArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_12;
        return f2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Float COUIBaseListPopupWindow_12) {
        addFloat(COUIBaseListPopupWindow_12.floatValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, Float COUIBaseListPopupWindow_12) {
        addFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12.floatValue());
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float COUIBaseListPopupWindow_12) {
        ensureIsMutable();
        int OplusGLSurfaceView_13 = this.size;
        float[] fArr = this.array;
        if (OplusGLSurfaceView_13 == fArr.length) {
            float[] fArr2 = new float[((OplusGLSurfaceView_13 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, OplusGLSurfaceView_13);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = COUIBaseListPopupWindow_12;
    }

    private void addFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        int i2;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        float[] fArr = this.array;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, OplusGLSurfaceView_13, fArr, OplusGLSurfaceView_13 + 1, i2 - OplusGLSurfaceView_13);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, fArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = fArr2;
        }
        this.array[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_12;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int OplusGLSurfaceView_13 = floatArrayList.size;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < OplusGLSurfaceView_13) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + OplusGLSurfaceView_13;
        float[] fArr = this.array;
        if (i3 > fArr.length) {
            this.array = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (obj.equals(Float.valueOf(this.array[OplusGLSurfaceView_13]))) {
                float[] fArr = this.array;
                System.arraycopy(fArr, OplusGLSurfaceView_13 + 1, fArr, OplusGLSurfaceView_13, (this.size - OplusGLSurfaceView_13) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        float[] fArr = this.array;
        float COUIBaseListPopupWindow_12 = fArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(fArr, OplusGLSurfaceView_13 + 1, fArr, OplusGLSurfaceView_13, (r2 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(COUIBaseListPopupWindow_12);
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
