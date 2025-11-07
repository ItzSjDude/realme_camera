package p061c.p070f.p072b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class ArrayIterator.kt_2<T> implements Iterator<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f5043a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final T[] f5044b;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ArrayIterator.kt_2(T[] tArr) {
        Intrinsics.m5305d(tArr, "array");
        this.f5044b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5043a < this.f5044b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f5044b;
            int OplusGLSurfaceView_13 = this.f5043a;
            this.f5043a = OplusGLSurfaceView_13 + 1;
            return tArr[OplusGLSurfaceView_13];
        } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            this.f5043a--;
            throw new NoSuchElementException(COUIBaseListPopupWindow_8.getMessage());
        }
    }
}
