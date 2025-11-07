package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* loaded from: classes.dex */
public final class $Gson$Types {
    static final java.lang.reflect.Type[] EMPTY_TYPE_ARRAY = new java.lang.reflect.Type[0];

    private $Gson$Types() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static java.lang.reflect.ParameterizedType newParameterizedTypeWithOwner(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.reflect.Type... typeArr) {
        return new com.google.gson.internal.$Gson$Types.$Gson$Types_2(type, type2, typeArr);
    }

    public static java.lang.reflect.GenericArrayType arrayOf(java.lang.reflect.Type type) {
        return new com.google.gson.internal.$Gson$Types.$Gson$Types_3(type);
    }

    public static java.lang.reflect.WildcardType subtypeOf(java.lang.reflect.Type type) {
        return new com.google.gson.internal.$Gson$Types.$Gson$Types_4(new java.lang.reflect.Type[]{type}, EMPTY_TYPE_ARRAY);
    }

    public static java.lang.reflect.WildcardType supertypeOf(java.lang.reflect.Type type) {
        return new com.google.gson.internal.$Gson$Types.$Gson$Types_4(new java.lang.reflect.Type[]{java.lang.Object.class}, new java.lang.reflect.Type[]{type});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.gson.internal.$Gson$Types$$Gson$Types_3] */
    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            java.lang.Class genericArrayTypeImpl = (java.lang.Class) type;
            if (genericArrayTypeImpl.isArray()) {
                genericArrayTypeImpl = new com.google.gson.internal.$Gson$Types.$Gson$Types_3(canonicalize(genericArrayTypeImpl.getComponentType()));
            }
            return genericArrayTypeImpl;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            return new com.google.gson.internal.$Gson$Types.$Gson$Types_2(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return new com.google.gson.internal.$Gson$Types.$Gson$Types_3(((java.lang.reflect.GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return type;
        }
        java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
        return new com.google.gson.internal.$Gson$Types.$Gson$Types_4(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static java.lang.Class<?> getRawType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type rawType = ((java.lang.reflect.ParameterizedType) type).getRawType();
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(rawType instanceof java.lang.Class);
            return (java.lang.Class) rawType;
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return java.lang.reflect.Array.newInstance(getRawType(((java.lang.reflect.GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return java.lang.Object.class;
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return getRawType(((java.lang.reflect.WildcardType) type).getUpperBounds()[0]);
        }
        throw new java.lang.IllegalArgumentException("Expected a_renamed Class, ParameterizedType, or GenericArrayType, but <" + type + "> is_renamed of_renamed type " + (type == null ? "null" : type.getClass().getName()));
    }

    static boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof java.lang.Class) {
            return type.equals(type2);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            if (!(type2 instanceof java.lang.reflect.ParameterizedType)) {
                return false;
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type2;
            return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && java.util.Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            if (type2 instanceof java.lang.reflect.GenericArrayType) {
                return equals(((java.lang.reflect.GenericArrayType) type).getGenericComponentType(), ((java.lang.reflect.GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            if (!(type2 instanceof java.lang.reflect.WildcardType)) {
                return false;
            }
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type;
            java.lang.reflect.WildcardType wildcardType2 = (java.lang.reflect.WildcardType) type2;
            return java.util.Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && java.util.Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof java.lang.reflect.TypeVariable) || !(type2 instanceof java.lang.reflect.TypeVariable)) {
            return false;
        }
        java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type;
        java.lang.reflect.TypeVariable typeVariable2 = (java.lang.reflect.TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    static int hashCodeOrZero(java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static java.lang.String typeToString(java.lang.reflect.Type type) {
        return type instanceof java.lang.Class ? ((java.lang.Class) type).getName() : type.toString();
    }

    static java.lang.reflect.Type getGenericSupertype(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            java.lang.Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                if (interfaces[i_renamed] == cls2) {
                    return cls.getGenericInterfaces()[i_renamed];
                }
                if (cls2.isAssignableFrom(interfaces[i_renamed])) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i_renamed], interfaces[i_renamed], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != java.lang.Object.class) {
                java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static java.lang.reflect.Type getSupertype(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, getGenericSupertype(type, cls, cls2));
    }

    public static java.lang.reflect.Type getArrayComponentType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.reflect.GenericArrayType) {
            return ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        }
        return ((java.lang.Class) type).getComponentType();
    }

    public static java.lang.reflect.Type getCollectionElementType(java.lang.reflect.Type type, java.lang.Class<?> cls) {
        java.lang.reflect.Type supertype = getSupertype(type, cls, java.util.Collection.class);
        if (supertype instanceof java.lang.reflect.WildcardType) {
            supertype = ((java.lang.reflect.WildcardType) supertype).getUpperBounds()[0];
        }
        if (supertype instanceof java.lang.reflect.ParameterizedType) {
            return ((java.lang.reflect.ParameterizedType) supertype).getActualTypeArguments()[0];
        }
        return java.lang.Object.class;
    }

    public static java.lang.reflect.Type[] getMapKeyAndValueTypes(java.lang.reflect.Type type, java.lang.Class<?> cls) {
        if (type == java.util.Properties.class) {
            return new java.lang.reflect.Type[]{java.lang.String.class, java.lang.String.class};
        }
        java.lang.reflect.Type supertype = getSupertype(type, cls, java.util.Map.class);
        if (supertype instanceof java.lang.reflect.ParameterizedType) {
            return ((java.lang.reflect.ParameterizedType) supertype).getActualTypeArguments();
        }
        return new java.lang.reflect.Type[]{java.lang.Object.class, java.lang.Object.class};
    }

    public static java.lang.reflect.Type resolve(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.Type type2) {
        java.lang.reflect.Type type3 = type2;
        while (type3 instanceof java.lang.reflect.TypeVariable) {
            java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type3;
            java.lang.reflect.Type typeResolveTypeVariable = resolveTypeVariable(type, cls, typeVariable);
            if (typeResolveTypeVariable == typeVariable) {
                return typeResolveTypeVariable;
            }
            type3 = typeResolveTypeVariable;
        }
        if (type3 instanceof java.lang.Class) {
            java.lang.Class cls2 = (java.lang.Class) type3;
            if (cls2.isArray()) {
                java.lang.Class<?> componentType = cls2.getComponentType();
                java.lang.reflect.Type typeResolve = resolve(type, cls, componentType);
                return componentType == typeResolve ? cls2 : arrayOf(typeResolve);
            }
        }
        if (type3 instanceof java.lang.reflect.GenericArrayType) {
            java.lang.reflect.GenericArrayType genericArrayType = (java.lang.reflect.GenericArrayType) type3;
            java.lang.reflect.Type genericComponentType = genericArrayType.getGenericComponentType();
            java.lang.reflect.Type typeResolve2 = resolve(type, cls, genericComponentType);
            return genericComponentType == typeResolve2 ? genericArrayType : arrayOf(typeResolve2);
        }
        if (type3 instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type3;
            java.lang.reflect.Type ownerType = parameterizedType.getOwnerType();
            java.lang.reflect.Type typeResolve3 = resolve(type, cls, ownerType);
            boolean z_renamed = typeResolve3 != ownerType;
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                java.lang.reflect.Type typeResolve4 = resolve(type, cls, actualTypeArguments[i_renamed]);
                if (typeResolve4 != actualTypeArguments[i_renamed]) {
                    if (!z_renamed) {
                        actualTypeArguments = (java.lang.reflect.Type[]) actualTypeArguments.clone();
                        z_renamed = true;
                    }
                    actualTypeArguments[i_renamed] = typeResolve4;
                }
            }
            return z_renamed ? newParameterizedTypeWithOwner(typeResolve3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type3 instanceof java.lang.reflect.WildcardType;
        java.lang.reflect.Type type4 = type3;
        if (z2) {
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type3;
            java.lang.reflect.Type[] lowerBounds = wildcardType.getLowerBounds();
            java.lang.reflect.Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                java.lang.reflect.Type typeResolve5 = resolve(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (typeResolve5 != lowerBounds[0]) {
                    return supertypeOf(typeResolve5);
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    java.lang.reflect.Type typeResolve6 = resolve(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (typeResolve6 != upperBounds[0]) {
                        return subtypeOf(typeResolve6);
                    }
                }
            }
        }
        return type4;
    }

    static java.lang.reflect.Type resolveTypeVariable(java.lang.reflect.Type type, java.lang.Class<?> cls, java.lang.reflect.TypeVariable<?> typeVariable) {
        java.lang.Class<?> clsDeclaringClassOf = declaringClassOf(typeVariable);
        if (clsDeclaringClassOf == null) {
            return typeVariable;
        }
        java.lang.reflect.Type genericSupertype = getGenericSupertype(type, cls, clsDeclaringClassOf);
        if (!(genericSupertype instanceof java.lang.reflect.ParameterizedType)) {
            return typeVariable;
        }
        return ((java.lang.reflect.ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(clsDeclaringClassOf.getTypeParameters(), typeVariable)];
    }

    private static int indexOf(java.lang.Object[] objArr, java.lang.Object obj) {
        for (int i_renamed = 0; i_renamed < objArr.length; i_renamed++) {
            if (obj.equals(objArr[i_renamed])) {
                return i_renamed;
            }
        }
        throw new java.util.NoSuchElementException();
    }

    private static java.lang.Class<?> declaringClassOf(java.lang.reflect.TypeVariable<?> typeVariable) {
        java.lang.reflect.GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof java.lang.Class) {
            return (java.lang.Class) genericDeclaration;
        }
        return null;
    }

    static void checkNotPrimitive(java.lang.reflect.Type type) {
        com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(((type instanceof java.lang.Class) && ((java.lang.Class) type).isPrimitive()) ? false : true);
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: com.google.gson.internal.$Gson$Types$$Gson$Types_2 */
    private static final class $Gson$Types_2 implements java.io.Serializable, java.lang.reflect.ParameterizedType {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type ownerType;
        private final java.lang.reflect.Type rawType;
        private final java.lang.reflect.Type[] typeArguments;

        public $Gson$Types_2(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.reflect.Type... typeArr) {
            int i_renamed = 0;
            if (type2 instanceof java.lang.Class) {
                java.lang.Class cls = (java.lang.Class) type2;
                boolean z_renamed = true;
                boolean z2 = java.lang.reflect.Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z_renamed = false;
                }
                com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(z_renamed);
            }
            this.ownerType = type == null ? null : com.google.gson.internal.$Gson$Types.canonicalize(type);
            this.rawType = com.google.gson.internal.$Gson$Types.canonicalize(type2);
            this.typeArguments = (java.lang.reflect.Type[]) typeArr.clone();
            while (true) {
                java.lang.reflect.Type[] typeArr2 = this.typeArguments;
                if (i_renamed >= typeArr2.length) {
                    return;
                }
                com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(typeArr2[i_renamed]);
                com.google.gson.internal.$Gson$Types.checkNotPrimitive(this.typeArguments[i_renamed]);
                java.lang.reflect.Type[] typeArr3 = this.typeArguments;
                typeArr3[i_renamed] = com.google.gson.internal.$Gson$Types.canonicalize(typeArr3[i_renamed]);
                i_renamed++;
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type[] getActualTypeArguments() {
            return (java.lang.reflect.Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public java.lang.reflect.Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.ParameterizedType) && com.google.gson.internal.$Gson$Types.equals(this, (java.lang.reflect.ParameterizedType) obj);
        }

        public int hashCode() {
            return com.google.gson.internal.$Gson$Types.hashCodeOrZero(this.ownerType) ^ (java.util.Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode());
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(com.google.gson.internal.$Gson$Types.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(com.google.gson.internal.$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i_renamed = 1; i_renamed < this.typeArguments.length; i_renamed++) {
                sb.append(", ");
                sb.append(com.google.gson.internal.$Gson$Types.typeToString(this.typeArguments[i_renamed]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: com.google.gson.internal.$Gson$Types$$Gson$Types_3 */
    private static final class $Gson$Types_3 implements java.io.Serializable, java.lang.reflect.GenericArrayType {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type componentType;

        public $Gson$Types_3(java.lang.reflect.Type type) {
            this.componentType = com.google.gson.internal.$Gson$Types.canonicalize(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public java.lang.reflect.Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.GenericArrayType) && com.google.gson.internal.$Gson$Types.equals(this, (java.lang.reflect.GenericArrayType) obj);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public java.lang.String toString() {
            return com.google.gson.internal.$Gson$Types.typeToString(this.componentType) + "[]";
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: com.google.gson.internal.$Gson$Types$$Gson$Types_4 */
    private static final class $Gson$Types_4 implements java.io.Serializable, java.lang.reflect.WildcardType {
        private static final long serialVersionUID = 0;
        private final java.lang.reflect.Type lowerBound;
        private final java.lang.reflect.Type upperBound;

        public $Gson$Types_4(java.lang.reflect.Type[] typeArr, java.lang.reflect.Type[] typeArr2) {
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(typeArr2[0]);
                com.google.gson.internal.$Gson$Types.checkNotPrimitive(typeArr2[0]);
                com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument(typeArr[0] == java.lang.Object.class);
                this.lowerBound = com.google.gson.internal.$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = java.lang.Object.class;
                return;
            }
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(typeArr[0]);
            com.google.gson.internal.$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = com.google.gson.internal.$Gson$Types.canonicalize(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getUpperBounds() {
            return new java.lang.reflect.Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public java.lang.reflect.Type[] getLowerBounds() {
            java.lang.reflect.Type type = this.lowerBound;
            return type != null ? new java.lang.reflect.Type[]{type} : com.google.gson.internal.$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof java.lang.reflect.WildcardType) && com.google.gson.internal.$Gson$Types.equals(this, (java.lang.reflect.WildcardType) obj);
        }

        public int hashCode() {
            java.lang.reflect.Type type = this.lowerBound;
            return (this.upperBound.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
        }

        public java.lang.String toString() {
            if (this.lowerBound != null) {
                return "? super " + com.google.gson.internal.$Gson$Types.typeToString(this.lowerBound);
            }
            if (this.upperBound == java.lang.Object.class) {
                return "?";
            }
            return "? extends " + com.google.gson.internal.$Gson$Types.typeToString(this.upperBound);
        }
    }
}
