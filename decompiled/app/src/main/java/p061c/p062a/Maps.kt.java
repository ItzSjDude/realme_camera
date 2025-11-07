package p061c.p062a;

import com.android.providers.downloads.Downloads;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Maps.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.u */
/* loaded from: classes.dex */
final class Maps.kt implements Serializable, Map {
    public static final Maps.kt INSTANCE = new Maps.kt();
    private static final long serialVersionUID = 8246714829545688274L;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    public boolean containsValue(Void r1) {
        Intrinsics.m5305d(r1, Downloads.Impl.RequestHeaders.COLUMN_VALUE);
        return false;
    }

    @Override // java.util.Map
    public Void get(Object obj) {
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
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object obj, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "{}";
    }

    private Maps.kt() {
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object obj) {
        return get(obj);
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final Collection values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public Set<Map.Entry> getEntries() {
        return Sets.kt.INSTANCE;
    }

    public Set<Object> getKeys() {
        return Sets.kt.INSTANCE;
    }

    public Collection getValues() {
        return Collections.kt.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
