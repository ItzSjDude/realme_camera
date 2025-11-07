package org.junit.runners.model;

/* loaded from: classes2.dex */
class NoGenericTypeParametersValidator {
    private final java.lang.reflect.Method method;

    NoGenericTypeParametersValidator(java.lang.reflect.Method method) {
        this.method = method;
    }

    void validate(java.util.List<java.lang.Throwable> list) {
        for (java.lang.reflect.Type type : this.method.getGenericParameterTypes()) {
            validateNoTypeParameterOnType(type, list);
        }
    }

    private void validateNoTypeParameterOnType(java.lang.reflect.Type type, java.util.List<java.lang.Throwable> list) {
        if (type instanceof java.lang.reflect.TypeVariable) {
            list.add(new java.lang.Exception("Method " + this.method.getName() + "() contains unresolved type variable " + type));
            return;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            validateNoTypeParameterOnParameterizedType((java.lang.reflect.ParameterizedType) type, list);
        } else if (type instanceof java.lang.reflect.WildcardType) {
            validateNoTypeParameterOnWildcardType((java.lang.reflect.WildcardType) type, list);
        } else if (type instanceof java.lang.reflect.GenericArrayType) {
            validateNoTypeParameterOnGenericArrayType((java.lang.reflect.GenericArrayType) type, list);
        }
    }

    private void validateNoTypeParameterOnParameterizedType(java.lang.reflect.ParameterizedType parameterizedType, java.util.List<java.lang.Throwable> list) {
        for (java.lang.reflect.Type type : parameterizedType.getActualTypeArguments()) {
            validateNoTypeParameterOnType(type, list);
        }
    }

    private void validateNoTypeParameterOnWildcardType(java.lang.reflect.WildcardType wildcardType, java.util.List<java.lang.Throwable> list) {
        for (java.lang.reflect.Type type : wildcardType.getUpperBounds()) {
            validateNoTypeParameterOnType(type, list);
        }
        for (java.lang.reflect.Type type2 : wildcardType.getLowerBounds()) {
            validateNoTypeParameterOnType(type2, list);
        }
    }

    private void validateNoTypeParameterOnGenericArrayType(java.lang.reflect.GenericArrayType genericArrayType, java.util.List<java.lang.Throwable> list) {
        validateNoTypeParameterOnType(genericArrayType.getGenericComponentType(), list);
    }
}
