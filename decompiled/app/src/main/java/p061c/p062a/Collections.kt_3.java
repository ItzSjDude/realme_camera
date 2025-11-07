package p061c.p062a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: Collections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.s */
/* loaded from: classes.dex */
public final class Collections.kt_3 implements ListIterator {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Collections.kt_3 f5027a = new Collections.kt_3();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private Collections.kt_3() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Void previous() {
        throw new NoSuchElementException();
    }
}
