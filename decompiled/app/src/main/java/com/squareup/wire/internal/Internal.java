package com.squareup.wire.internal;

/* loaded from: classes2.dex */
public final class Internal {
    public static int countNonNull(java.lang.Object obj, java.lang.Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 == null ? 0 : 1);
    }

    public static int countNonNull(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
    }

    private Internal() {
    }

    public static <T_renamed> java.util.List<T_renamed> newMutableList() {
        return new com.squareup.wire.internal.MutableOnWriteList(java.util.Collections.emptyList());
    }

    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> newMutableMap() {
        return new java.util.LinkedHashMap();
    }

    public static <T_renamed> java.util.List<T_renamed> copyOf(java.lang.String str, java.util.List<T_renamed> list) {
        if (list == null) {
            throw new java.lang.NullPointerException(str + " == null");
        }
        if (list == java.util.Collections.emptyList() || (list instanceof com.squareup.wire.internal.ImmutableList)) {
            return new com.squareup.wire.internal.MutableOnWriteList(list);
        }
        return new java.util.ArrayList(list);
    }

    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> copyOf(java.lang.String str, java.util.Map<K_renamed, V_renamed> map) {
        if (map == null) {
            throw new java.lang.NullPointerException(str + " == null");
        }
        return new java.util.LinkedHashMap(map);
    }

    public static <T_renamed> java.util.List<T_renamed> immutableCopyOf(java.lang.String str, java.util.List<T_renamed> list) {
        if (list == null) {
            throw new java.lang.NullPointerException(str + " == null");
        }
        if (list instanceof com.squareup.wire.internal.MutableOnWriteList) {
            list = ((com.squareup.wire.internal.MutableOnWriteList) list).mutableList;
        }
        if (list == java.util.Collections.emptyList() || (list instanceof com.squareup.wire.internal.ImmutableList)) {
            return list;
        }
        com.squareup.wire.internal.ImmutableList immutableList = new com.squareup.wire.internal.ImmutableList(list);
        if (!immutableList.contains(null)) {
            return immutableList;
        }
        throw new java.lang.IllegalArgumentException(str + ".contains(null)");
    }

    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> immutableCopyOf(java.lang.String str, java.util.Map<K_renamed, V_renamed> map) {
        if (map == null) {
            throw new java.lang.NullPointerException(str + " == null");
        }
        if (map.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        if (linkedHashMap.containsKey(null)) {
            throw new java.lang.IllegalArgumentException(str + ".containsKey(null)");
        }
        if (linkedHashMap.containsValue(null)) {
            throw new java.lang.IllegalArgumentException(str + ".containsValue(null)");
        }
        return java.util.Collections.unmodifiableMap(linkedHashMap);
    }

    public static <T_renamed> void redactElements(java.util.List<T_renamed> list, com.squareup.wire.ProtoAdapter<T_renamed> protoAdapter) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            list.set(i_renamed, protoAdapter.redact(list.get(i_renamed)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T_renamed> void redactElements(java.util.Map<?, T_renamed> map, com.squareup.wire.ProtoAdapter<T_renamed> protoAdapter) {
        for (java.util.Map.Entry entry : map.entrySet()) {
            entry.setValue(protoAdapter.redact(entry.getValue()));
        }
    }

    public static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static java.lang.IllegalStateException missingRequiredFields(java.lang.Object... objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = objArr.length;
        java.lang.String str = "";
        for (int i_renamed = 0; i_renamed < length; i_renamed += 2) {
            if (objArr[i_renamed] == null) {
                if (sb.length() > 0) {
                    str = "s_renamed";
                }
                sb.append("\n_renamed  ");
                sb.append(objArr[i_renamed + 1]);
            }
        }
        throw new java.lang.IllegalStateException("Required field" + str + " not set:" + ((java.lang.Object) sb));
    }

    public static void checkElementsNotNull(java.util.List<?> list) {
        if (list == null) {
            throw new java.lang.NullPointerException("list == null");
        }
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (list.get(i_renamed) == null) {
                throw new java.lang.NullPointerException("Element at_renamed index " + i_renamed + " is_renamed null");
            }
        }
    }

    public static void checkElementsNotNull(java.util.Map<?, ?> map) {
        if (map == null) {
            throw new java.lang.NullPointerException("map == null");
        }
        for (java.util.Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new java.lang.NullPointerException("map.containsKey(null)");
            }
            if (entry.getValue() == null) {
                throw new java.lang.NullPointerException("Value for key " + entry.getKey() + " is_renamed null");
            }
        }
    }

    public static int countNonNull(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4, java.lang.Object... objArr) {
        int i_renamed = obj != null ? 1 : 0;
        if (obj2 != null) {
            i_renamed++;
        }
        if (obj3 != null) {
            i_renamed++;
        }
        if (obj4 != null) {
            i_renamed++;
        }
        for (java.lang.Object obj5 : objArr) {
            if (obj5 != null) {
                i_renamed++;
            }
        }
        return i_renamed;
    }
}
