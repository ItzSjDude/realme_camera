package org.junit.experimental.theories;

/* loaded from: classes2.dex */
public class ParameterSignature {
    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> CONVERTABLE_TYPES_MAP = buildConvertableTypesMap();
    private final java.lang.annotation.Annotation[] annotations;
    private final java.lang.Class<?> type;

    private static java.util.Map<java.lang.Class<?>, java.lang.Class<?>> buildConvertableTypesMap() {
        java.util.HashMap map = new java.util.HashMap();
        putSymmetrically(map, java.lang.Boolean.TYPE, java.lang.Boolean.class);
        putSymmetrically(map, java.lang.Byte.TYPE, java.lang.Byte.class);
        putSymmetrically(map, java.lang.Short.TYPE, java.lang.Short.class);
        putSymmetrically(map, java.lang.Character.TYPE, java.lang.Character.class);
        putSymmetrically(map, java.lang.Integer.TYPE, java.lang.Integer.class);
        putSymmetrically(map, java.lang.Long.TYPE, java.lang.Long.class);
        putSymmetrically(map, java.lang.Float.TYPE, java.lang.Float.class);
        putSymmetrically(map, java.lang.Double.TYPE, java.lang.Double.class);
        return java.util.Collections.unmodifiableMap(map);
    }

    private static <T_renamed> void putSymmetrically(java.util.Map<T_renamed, T_renamed> map, T_renamed t_renamed, T_renamed t2) {
        map.put(t_renamed, t2);
        map.put(t2, t_renamed);
    }

    public static java.util.ArrayList<org.junit.experimental.theories.ParameterSignature> signatures(java.lang.reflect.Method method) {
        return signatures(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public static java.util.List<org.junit.experimental.theories.ParameterSignature> signatures(java.lang.reflect.Constructor<?> constructor) {
        return signatures(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    private static java.util.ArrayList<org.junit.experimental.theories.ParameterSignature> signatures(java.lang.Class<?>[] clsArr, java.lang.annotation.Annotation[][] annotationArr) {
        java.util.ArrayList<org.junit.experimental.theories.ParameterSignature> arrayList = new java.util.ArrayList<>();
        for (int i_renamed = 0; i_renamed < clsArr.length; i_renamed++) {
            arrayList.add(new org.junit.experimental.theories.ParameterSignature(clsArr[i_renamed], annotationArr[i_renamed]));
        }
        return arrayList;
    }

    private ParameterSignature(java.lang.Class<?> cls, java.lang.annotation.Annotation[] annotationArr) {
        this.type = cls;
        this.annotations = annotationArr;
    }

    public boolean canAcceptValue(java.lang.Object obj) {
        return obj == null ? !this.type.isPrimitive() : canAcceptType(obj.getClass());
    }

    public boolean canAcceptType(java.lang.Class<?> cls) {
        return this.type.isAssignableFrom(cls) || isAssignableViaTypeConversion(this.type, cls);
    }

    public boolean canPotentiallyAcceptType(java.lang.Class<?> cls) {
        return cls.isAssignableFrom(this.type) || isAssignableViaTypeConversion(cls, this.type) || canAcceptType(cls);
    }

    private boolean isAssignableViaTypeConversion(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        if (CONVERTABLE_TYPES_MAP.containsKey(cls2)) {
            return cls.isAssignableFrom(CONVERTABLE_TYPES_MAP.get(cls2));
        }
        return false;
    }

    public java.lang.Class<?> getType() {
        return this.type;
    }

    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return java.util.Arrays.asList(this.annotations);
    }

    public boolean hasAnnotation(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public <T_renamed extends java.lang.annotation.Annotation> T_renamed findDeepAnnotation(java.lang.Class<T_renamed> cls) {
        return (T_renamed) findDeepAnnotation(this.annotations, cls, 3);
    }

    private <T_renamed extends java.lang.annotation.Annotation> T_renamed findDeepAnnotation(java.lang.annotation.Annotation[] annotationArr, java.lang.Class<T_renamed> cls, int i_renamed) {
        if (i_renamed == 0) {
            return null;
        }
        for (java.lang.annotation.Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
            java.lang.annotation.Annotation annotationFindDeepAnnotation = findDeepAnnotation(annotation.annotationType().getAnnotations(), cls, i_renamed - 1);
            if (annotationFindDeepAnnotation != null) {
                return cls.cast(annotationFindDeepAnnotation);
            }
        }
        return null;
    }

    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        for (java.lang.annotation.Annotation annotation : getAnnotations()) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }
}
