package c_renamed.f_renamed.b_renamed;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes.dex */
final class a_renamed<T_renamed> implements java.util.Iterator<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f1903a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final T_renamed[] f1904b;

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public a_renamed(T_renamed[] tArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "array");
        this.f1904b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1903a < this.f1904b.length;
    }

    @Override // java.util.Iterator
    public T_renamed next() {
        try {
            T_renamed[] tArr = this.f1904b;
            int i_renamed = this.f1903a;
            this.f1903a = i_renamed + 1;
            return tArr[i_renamed];
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            this.f1903a--;
            throw new java.util.NoSuchElementException(e_renamed.getMessage());
        }
    }
}
