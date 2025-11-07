package c_renamed.a_renamed;

/* compiled from: Iterators.kt */
/* loaded from: classes.dex */
public abstract class w_renamed implements java.util.Iterator<java.lang.Integer> {
    public abstract int b_renamed();

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Iterator
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public final java.lang.Integer next() {
        return java.lang.Integer.valueOf(b_renamed());
    }
}
