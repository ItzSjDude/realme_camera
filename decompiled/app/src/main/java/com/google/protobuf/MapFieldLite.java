package com.google.protobuf;

/* loaded from: classes.dex */
public final class MapFieldLite<K_renamed, V_renamed> extends java.util.LinkedHashMap<K_renamed, V_renamed> {
    private static final com.google.protobuf.MapFieldLite EMPTY_MAP_FIELD = new com.google.protobuf.MapFieldLite();
    private boolean isMutable;

    private MapFieldLite() {
        this.isMutable = true;
    }

    private MapFieldLite(java.util.Map<K_renamed, V_renamed> map) {
        super(map);
        this.isMutable = true;
    }

    static {
        EMPTY_MAP_FIELD.makeImmutable();
    }

    public static <K_renamed, V_renamed> com.google.protobuf.MapFieldLite<K_renamed, V_renamed> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public void mergeFrom(com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mapFieldLite) {
        ensureMutable();
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
        return isEmpty() ? java.util.Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        ensureMutable();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
        ensureMutable();
        com.google.protobuf.Internal.checkNotNull(k_renamed);
        com.google.protobuf.Internal.checkNotNull(v_renamed);
        return (V_renamed) super.put(k_renamed, v_renamed);
    }

    public V_renamed put(java.util.Map.Entry<K_renamed, V_renamed> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(java.util.Map<? extends K_renamed, ? extends V_renamed> map) {
        ensureMutable();
        checkForNullKeysAndValues(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V_renamed remove(java.lang.Object obj) {
        ensureMutable();
        return (V_renamed) super.remove(obj);
    }

    private static void checkForNullKeysAndValues(java.util.Map<?, ?> map) {
        for (java.lang.Object obj : map.keySet()) {
            com.google.protobuf.Internal.checkNotNull(obj);
            com.google.protobuf.Internal.checkNotNull(map.get(obj));
        }
    }

    private static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return java.util.Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    static <K_renamed, V_renamed> boolean equals(java.util.Map<K_renamed, V_renamed> map, java.util.Map<K_renamed, V_renamed> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof java.util.Map) && equals((java.util.Map) this, (java.util.Map) obj);
    }

    private static int calculateHashCodeForObject(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return com.google.protobuf.Internal.hashCode((byte[]) obj);
        }
        if (obj instanceof com.google.protobuf.Internal.EnumLite) {
            throw new java.lang.UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    static <K_renamed, V_renamed> int calculateHashCodeForMap(java.util.Map<K_renamed, V_renamed> map) {
        int iCalculateHashCodeForObject = 0;
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            iCalculateHashCodeForObject += calculateHashCodeForObject(entry.getValue()) ^ calculateHashCodeForObject(entry.getKey());
        }
        return iCalculateHashCodeForObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    private static java.lang.Object copy(java.lang.Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return java.util.Arrays.copyOf(bArr, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> copy(java.util.Map<K_renamed, V_renamed> map) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), copy(entry.getValue()));
        }
        return linkedHashMap;
    }

    public com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mutableCopy() {
        return isEmpty() ? new com.google.protobuf.MapFieldLite<>() : new com.google.protobuf.MapFieldLite<>(this);
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private void ensureMutable() {
        if (!isMutable()) {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
