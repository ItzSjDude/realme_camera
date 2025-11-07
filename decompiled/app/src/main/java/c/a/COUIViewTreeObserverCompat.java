package c_renamed.a_renamed;

/* compiled from: Maps.kt */
/* loaded from: classes.dex */
final class u_renamed implements java.io.Serializable, java.util.Map {
    public static final c_renamed.a_renamed.u_renamed INSTANCE = new c_renamed.a_renamed.u_renamed();
    private static final long serialVersionUID = 8246714829545688274L;

    @Override // java.util.Map
    public void clear() {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return false;
    }

    public boolean containsValue(java.lang.Void r1) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(r1, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE);
        return false;
    }

    @Override // java.util.Map
    public java.lang.Void get(java.lang.Object obj) {
        return null;
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public java.lang.Void put(java.lang.Object obj, java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(java.util.Map map) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Map
    public java.lang.Object remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public java.lang.String toString() {
        return "{}";
    }

    private u_renamed() {
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return containsValue((java.lang.Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final java.util.Set<java.util.Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ java.lang.Object get(java.lang.Object obj) {
        return get(obj);
    }

    @Override // java.util.Map
    public final java.util.Set<java.lang.Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final java.util.Collection values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof java.util.Map) && ((java.util.Map) obj).isEmpty();
    }

    public java.util.Set<java.util.Map.Entry> getEntries() {
        return c_renamed.a_renamed.v_renamed.INSTANCE;
    }

    public java.util.Set<java.lang.Object> getKeys() {
        return c_renamed.a_renamed.v_renamed.INSTANCE;
    }

    public java.util.Collection getValues() {
        return c_renamed.a_renamed.t_renamed.INSTANCE;
    }

    private final java.lang.Object readResolve() {
        return INSTANCE;
    }
}
