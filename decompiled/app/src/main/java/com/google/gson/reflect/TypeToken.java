package com.google.gson.reflect;

/* loaded from: classes.dex */
public class TypeToken<T_renamed> {
    final int hashCode;
    final java.lang.Class<? super T_renamed> rawType;
    final java.lang.reflect.Type type;

    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = (java.lang.Class<? super T_renamed>) com.google.gson.internal.$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    TypeToken(java.lang.reflect.Type type) {
        this.type = com.google.gson.internal.$Gson$Types.canonicalize((java.lang.reflect.Type) com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(type));
        this.rawType = (java.lang.Class<? super T_renamed>) com.google.gson.internal.$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    static java.lang.reflect.Type getSuperclassTypeParameter(java.lang.Class<?> cls) {
        java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof java.lang.Class) {
            throw new java.lang.RuntimeException("Missing type parameter.");
        }
        return com.google.gson.internal.$Gson$Types.canonicalize(((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final java.lang.Class<? super T_renamed> getRawType() {
        return this.rawType;
    }

    public final java.lang.reflect.Type getType() {
        return this.type;
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(java.lang.Class<?> cls) {
        return isAssignableFrom((java.lang.reflect.Type) cls);
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(java.lang.reflect.Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        java.lang.reflect.Type type2 = this.type;
        if (type2 instanceof java.lang.Class) {
            return this.rawType.isAssignableFrom(com.google.gson.internal.$Gson$Types.getRawType(type));
        }
        if (type2 instanceof java.lang.reflect.ParameterizedType) {
            return isAssignableFrom(type, (java.lang.reflect.ParameterizedType) type2, new java.util.HashMap());
        }
        if (type2 instanceof java.lang.reflect.GenericArrayType) {
            return this.rawType.isAssignableFrom(com.google.gson.internal.$Gson$Types.getRawType(type)) && isAssignableFrom(type, (java.lang.reflect.GenericArrayType) this.type);
        }
        throw buildUnexpectedTypeError(type2, java.lang.Class.class, java.lang.reflect.ParameterizedType.class, java.lang.reflect.GenericArrayType.class);
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(com.google.gson.reflect.TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(java.lang.reflect.Type type, java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof java.lang.reflect.ParameterizedType)) {
            return true;
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            type = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof java.lang.Class) {
            type = (java.lang.Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (java.lang.reflect.ParameterizedType) genericComponentType, new java.util.HashMap());
    }

    private static boolean isAssignableFrom(java.lang.reflect.Type type, java.lang.reflect.ParameterizedType parameterizedType, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        java.lang.Class<?> rawType = com.google.gson.internal.$Gson$Types.getRawType(type);
        java.lang.reflect.ParameterizedType parameterizedType2 = type instanceof java.lang.reflect.ParameterizedType ? (java.lang.reflect.ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters = rawType.getTypeParameters();
            for (int i_renamed = 0; i_renamed < actualTypeArguments.length; i_renamed++) {
                java.lang.reflect.Type type2 = actualTypeArguments[i_renamed];
                java.lang.reflect.TypeVariable<java.lang.Class<?>> typeVariable = typeParameters[i_renamed];
                while (type2 instanceof java.lang.reflect.TypeVariable) {
                    type2 = map.get(((java.lang.reflect.TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (java.lang.reflect.Type type3 : rawType.getGenericInterfaces()) {
            if (isAssignableFrom(type3, parameterizedType, new java.util.HashMap(map))) {
                return true;
            }
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new java.util.HashMap(map));
    }

    private static boolean typeEquals(java.lang.reflect.ParameterizedType parameterizedType, java.lang.reflect.ParameterizedType parameterizedType2, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        java.lang.reflect.Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i_renamed = 0; i_renamed < actualTypeArguments.length; i_renamed++) {
            if (!matches(actualTypeArguments[i_renamed], actualTypeArguments2[i_renamed], map)) {
                return false;
            }
        }
        return true;
    }

    private static java.lang.AssertionError buildUnexpectedTypeError(java.lang.reflect.Type type, java.lang.Class<?>... clsArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Unexpected type. Expected one of_renamed: ");
        for (java.lang.Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new java.lang.AssertionError(sb.toString());
    }

    private static boolean matches(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        return type2.equals(type) || ((type instanceof java.lang.reflect.TypeVariable) && type2.equals(map.get(((java.lang.reflect.TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(java.lang.Object obj) {
        return (obj instanceof com.google.gson.reflect.TypeToken) && com.google.gson.internal.$Gson$Types.equals(this.type, ((com.google.gson.reflect.TypeToken) obj).type);
    }

    public final java.lang.String toString() {
        return com.google.gson.internal.$Gson$Types.typeToString(this.type);
    }

    public static com.google.gson.reflect.TypeToken<?> get(java.lang.reflect.Type type) {
        return new com.google.gson.reflect.TypeToken<>(type);
    }

    public static <T_renamed> com.google.gson.reflect.TypeToken<T_renamed> get(java.lang.Class<T_renamed> cls) {
        return new com.google.gson.reflect.TypeToken<>(cls);
    }
}
