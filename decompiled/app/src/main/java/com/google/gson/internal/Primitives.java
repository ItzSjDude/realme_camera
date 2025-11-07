package com.google.gson.internal;

/* loaded from: classes.dex */
public final class Primitives {
    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;

    private Primitives() {
        throw new java.lang.UnsupportedOperationException();
    }

    static {
        java.util.HashMap map = new java.util.HashMap(16);
        java.util.HashMap map2 = new java.util.HashMap(16);
        add(map, map2, java.lang.Boolean.TYPE, java.lang.Boolean.class);
        add(map, map2, java.lang.Byte.TYPE, java.lang.Byte.class);
        add(map, map2, java.lang.Character.TYPE, java.lang.Character.class);
        add(map, map2, java.lang.Double.TYPE, java.lang.Double.class);
        add(map, map2, java.lang.Float.TYPE, java.lang.Float.class);
        add(map, map2, java.lang.Integer.TYPE, java.lang.Integer.class);
        add(map, map2, java.lang.Long.TYPE, java.lang.Long.class);
        add(map, map2, java.lang.Short.TYPE, java.lang.Short.class);
        add(map, map2, java.lang.Void.TYPE, java.lang.Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = java.util.Collections.unmodifiableMap(map);
        WRAPPER_TO_PRIMITIVE_TYPE = java.util.Collections.unmodifiableMap(map2);
    }

    private static void add(java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map, java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map2, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean isPrimitive(java.lang.reflect.Type type) {
        return PRIMITIVE_TO_WRAPPER_TYPE.containsKey(type);
    }

    public static boolean isWrapperType(java.lang.reflect.Type type) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(type));
    }

    public static <T_renamed> java.lang.Class<T_renamed> wrap(java.lang.Class<T_renamed> cls) {
        java.lang.Class<T_renamed> cls2 = (java.lang.Class) PRIMITIVE_TO_WRAPPER_TYPE.get(com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }

    public static <T_renamed> java.lang.Class<T_renamed> unwrap(java.lang.Class<T_renamed> cls) {
        java.lang.Class<T_renamed> cls2 = (java.lang.Class) WRAPPER_TO_PRIMITIVE_TYPE.get(com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }
}
