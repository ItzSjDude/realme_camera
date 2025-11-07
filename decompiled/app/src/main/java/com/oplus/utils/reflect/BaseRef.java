package com.oplus.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class BaseRef<T> implements IBaseRef {
    static final HashMap<Class<?>, Object> DEFAULT_TYPES = new HashMap<>();
    private final String mName;
    private final Type mType;
    private Object mStub = null;
    private final T mDefaultValue = initDefaultValue();

    static {
        DEFAULT_TYPES.put(Integer.class, 0);
        DEFAULT_TYPES.put(Short.class, (short) 0);
        DEFAULT_TYPES.put(Long.class, 0L);
        DEFAULT_TYPES.put(Float.class, Float.valueOf(0.0f));
        DEFAULT_TYPES.put(Double.class, Double.valueOf(0.0d));
        DEFAULT_TYPES.put(Boolean.class, false);
        DEFAULT_TYPES.put(Byte.class, (byte) 0);
        DEFAULT_TYPES.put(Character.class, (char) 0);
    }

    BaseRef(Field field) {
        this.mName = field.getName();
        this.mType = getGenericType(field);
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public String getName() {
        return this.mName;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public void bindStub(Object obj) {
        this.mStub = obj;
    }

    Object checkStub(Object obj) {
        Class<?> cls;
        if (obj == null) {
            return obj;
        }
        Class<?> declaringClass = getDeclaringClass();
        return (declaringClass == null || !(declaringClass == (cls = obj.getClass()) || declaringClass.isAssignableFrom(cls))) ? this.mStub : obj;
    }

    T initDefaultValue() {
        for (Map.Entry<Class<?>, Object> entry : DEFAULT_TYPES.entrySet()) {
            if (this.mType.equals(entry.getKey())) {
                return (T) entry.getValue();
            }
        }
        return null;
    }

    T getDefaultValue() {
        return this.mDefaultValue;
    }

    private Type getGenericType(Field field) {
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return genericType;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        return actualTypeArguments.length > 0 ? actualTypeArguments[0] : genericType;
    }
}
