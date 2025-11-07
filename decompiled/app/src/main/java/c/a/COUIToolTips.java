package c_renamed.a_renamed;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public final class s_renamed implements java.util.ListIterator {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.a_renamed.s_renamed f1887a = new c_renamed.a_renamed.s_renamed();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
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
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    private s_renamed() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Void next() {
        throw new java.util.NoSuchElementException();
    }

    @Override // java.util.ListIterator
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Void previous() {
        throw new java.util.NoSuchElementException();
    }
}
