package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
abstract class BaseRef<T_renamed> implements com.oplus.utils.reflect.IBaseRef {
    static final java.util.HashMap<java.lang.Class<?>, java.lang.Object> DEFAULT_TYPES = new java.util.HashMap<>();
    private final java.lang.String mName;
    private final java.lang.reflect.Type mType;
    private java.lang.Object mStub = null;
    private final T_renamed mDefaultValue = initDefaultValue();

    static {
        DEFAULT_TYPES.put(java.lang.Integer.class, 0);
        DEFAULT_TYPES.put(java.lang.Short.class, (short) 0);
        DEFAULT_TYPES.put(java.lang.Long.class, 0L);
        DEFAULT_TYPES.put(java.lang.Float.class, java.lang.Float.valueOf(0.0f));
        DEFAULT_TYPES.put(java.lang.Double.class, java.lang.Double.valueOf(0.0d));
        DEFAULT_TYPES.put(java.lang.Boolean.class, false);
        DEFAULT_TYPES.put(java.lang.Byte.class, (byte) 0);
        DEFAULT_TYPES.put(java.lang.Character.class, (char) 0);
    }

    BaseRef(java.lang.reflect.Field field) {
        this.mName = field.getName();
        this.mType = getGenericType(field);
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public java.lang.String getName() {
        return this.mName;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public void bindStub(java.lang.Object obj) {
        this.mStub = obj;
    }

    java.lang.Object checkStub(java.lang.Object obj) {
        java.lang.Class<?> cls;
        if (obj == null) {
            return obj;
        }
        java.lang.Class<?> declaringClass = getDeclaringClass();
        return (declaringClass == null || !(declaringClass == (cls = obj.getClass()) || declaringClass.isAssignableFrom(cls))) ? this.mStub : obj;
    }

    T_renamed initDefaultValue() {
        for (java.util.Map.Entry<java.lang.Class<?>, java.lang.Object> entry : DEFAULT_TYPES.entrySet()) {
            if (this.mType.equals(entry.getKey())) {
                return (T_renamed) entry.getValue();
            }
        }
        return null;
    }

    T_renamed getDefaultValue() {
        return this.mDefaultValue;
    }

    private java.lang.reflect.Type getGenericType(java.lang.reflect.Field field) {
        java.lang.reflect.Type genericType = field.getGenericType();
        if (!(genericType instanceof java.lang.reflect.ParameterizedType)) {
            return genericType;
        }
        java.lang.reflect.Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) genericType).getActualTypeArguments();
        return actualTypeArguments.length > 0 ? actualTypeArguments[0] : genericType;
    }
}
