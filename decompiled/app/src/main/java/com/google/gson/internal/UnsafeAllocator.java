package com.google.gson.internal;

/* loaded from: classes.dex */
public abstract class UnsafeAllocator {
    public abstract <T_renamed> T_renamed newInstance(java.lang.Class<T_renamed> cls) throws java.lang.Exception;

    public static com.google.gson.internal.UnsafeAllocator create() throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("sun.misc.Unsafe");
            java.lang.reflect.Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final java.lang.Object obj = declaredField.get(null);
            final java.lang.reflect.Method method = cls.getMethod("allocateInstance", java.lang.Class.class);
            return new com.google.gson.internal.UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                @Override // com.google.gson.internal.UnsafeAllocator
                public <T_renamed> T_renamed newInstance(java.lang.Class<T_renamed> cls2) throws java.lang.Exception {
                    return (T_renamed) method.invoke(obj, cls2);
                }
            };
        } catch (java.lang.Exception unused) {
            try {
                try {
                    java.lang.reflect.Method declaredMethod = java.io.ObjectStreamClass.class.getDeclaredMethod("getConstructorId", java.lang.Class.class);
                    declaredMethod.setAccessible(true);
                    final int iIntValue = ((java.lang.Integer) declaredMethod.invoke(null, java.lang.Object.class)).intValue();
                    final java.lang.reflect.Method declaredMethod2 = java.io.ObjectStreamClass.class.getDeclaredMethod("newInstance", java.lang.Class.class, java.lang.Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new com.google.gson.internal.UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T_renamed> T_renamed newInstance(java.lang.Class<T_renamed> cls2) throws java.lang.Exception {
                            return (T_renamed) declaredMethod2.invoke(null, cls2, java.lang.Integer.valueOf(iIntValue));
                        }
                    };
                } catch (java.lang.Exception unused2) {
                    return new com.google.gson.internal.UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T_renamed> T_renamed newInstance(java.lang.Class<T_renamed> cls2) {
                            throw new java.lang.UnsupportedOperationException("Cannot allocate " + cls2);
                        }
                    };
                }
            } catch (java.lang.Exception unused3) {
                final java.lang.reflect.Method declaredMethod3 = java.io.ObjectInputStream.class.getDeclaredMethod("newInstance", java.lang.Class.class, java.lang.Class.class);
                declaredMethod3.setAccessible(true);
                return new com.google.gson.internal.UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                    @Override // com.google.gson.internal.UnsafeAllocator
                    public <T_renamed> T_renamed newInstance(java.lang.Class<T_renamed> cls2) throws java.lang.Exception {
                        return (T_renamed) declaredMethod3.invoke(null, cls2, java.lang.Object.class);
                    }
                };
            }
        }
    }
}
