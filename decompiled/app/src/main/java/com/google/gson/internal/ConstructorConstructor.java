package com.google.gson.internal;

/* loaded from: classes.dex */
public final class ConstructorConstructor {
    private final java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T_renamed> com.google.gson.internal.ObjectConstructor<T_renamed> get(com.google.gson.reflect.TypeToken<T_renamed> typeToken) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        final java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
        final com.google.gson.InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) instanceCreator.createInstance(type);
                }
            };
        }
        final com.google.gson.InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) instanceCreator2.createInstance(type);
                }
            };
        }
        com.google.gson.internal.ObjectConstructor<T_renamed> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        com.google.gson.internal.ObjectConstructor<T_renamed> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return objectConstructorNewDefaultImplementationConstructor != null ? objectConstructorNewDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
    }

    private <T_renamed> com.google.gson.internal.ObjectConstructor<T_renamed> newDefaultConstructor(java.lang.Class<? super T_renamed> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            final java.lang.reflect.Constructor<? super T_renamed> declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    try {
                        return (T_renamed) declaredConstructor.newInstance(null);
                    } catch (java.lang.IllegalAccessException e_renamed) {
                        throw new java.lang.AssertionError(e_renamed);
                    } catch (java.lang.InstantiationException e2) {
                        throw new java.lang.RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (java.lang.reflect.InvocationTargetException e3) {
                        throw new java.lang.RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    private <T_renamed> com.google.gson.internal.ObjectConstructor<T_renamed> newDefaultImplementationConstructor(final java.lang.reflect.Type type, java.lang.Class<? super T_renamed> cls) {
        if (java.util.Collection.class.isAssignableFrom(cls)) {
            if (java.util.SortedSet.class.isAssignableFrom(cls)) {
                return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.4
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T_renamed construct() {
                        return (T_renamed) new java.util.TreeSet();
                    }
                };
            }
            if (java.util.EnumSet.class.isAssignableFrom(cls)) {
                return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T_renamed construct() {
                        java.lang.reflect.Type type2 = type;
                        if (type2 instanceof java.lang.reflect.ParameterizedType) {
                            java.lang.reflect.Type type3 = ((java.lang.reflect.ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof java.lang.Class) {
                                return (T_renamed) java.util.EnumSet.noneOf((java.lang.Class) type3);
                            }
                            throw new com.google.gson.JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new com.google.gson.JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (java.util.Set.class.isAssignableFrom(cls)) {
                return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T_renamed construct() {
                        return (T_renamed) new java.util.LinkedHashSet();
                    }
                };
            }
            if (java.util.Queue.class.isAssignableFrom(cls)) {
                return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T_renamed construct() {
                        return (T_renamed) new java.util.LinkedList();
                    }
                };
            }
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) new java.util.ArrayList();
                }
            };
        }
        if (!java.util.Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (java.util.concurrent.ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) new java.util.concurrent.ConcurrentSkipListMap();
                }
            };
        }
        if (java.util.concurrent.ConcurrentMap.class.isAssignableFrom(cls)) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) new java.util.concurrent.ConcurrentHashMap();
                }
            };
        }
        if (java.util.SortedMap.class.isAssignableFrom(cls)) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) new java.util.TreeMap();
                }
            };
        }
        if ((type instanceof java.lang.reflect.ParameterizedType) && !java.lang.String.class.isAssignableFrom(com.google.gson.reflect.TypeToken.get(((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                @Override // com.google.gson.internal.ObjectConstructor
                public T_renamed construct() {
                    return (T_renamed) new java.util.LinkedHashMap();
                }
            };
        }
        return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.13
            @Override // com.google.gson.internal.ObjectConstructor
            public T_renamed construct() {
                return (T_renamed) new com.google.gson.internal.LinkedTreeMap();
            }
        };
    }

    private <T_renamed> com.google.gson.internal.ObjectConstructor<T_renamed> newUnsafeAllocator(final java.lang.reflect.Type type, final java.lang.Class<? super T_renamed> cls) {
        return new com.google.gson.internal.ObjectConstructor<T_renamed>() { // from class: com.google.gson.internal.ConstructorConstructor.14
            private final com.google.gson.internal.UnsafeAllocator unsafeAllocator = com.google.gson.internal.UnsafeAllocator.create();

            @Override // com.google.gson.internal.ObjectConstructor
            public T_renamed construct() {
                try {
                    return (T_renamed) this.unsafeAllocator.newInstance(cls);
                } catch (java.lang.Exception e_renamed) {
                    throw new java.lang.RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an_renamed InstanceCreator with Gson for this type may fix this problem.", e_renamed);
                }
            }
        };
    }

    public java.lang.String toString() {
        return this.instanceCreators.toString();
    }
}
