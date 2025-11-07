package org.junit.internal.matchers;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public abstract class TypeSafeMatcher<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {
    private java.lang.Class<?> expectedType;

    public abstract boolean matchesSafely(T_renamed t_renamed);

    protected TypeSafeMatcher() {
        this.expectedType = findExpectedType(getClass());
    }

    private static java.lang.Class<?> findExpectedType(java.lang.Class<?> cls) throws java.lang.SecurityException {
        while (cls != java.lang.Object.class) {
            for (java.lang.reflect.Method method : org.junit.internal.MethodSorter.getDeclaredMethods(cls)) {
                if (isMatchesSafelyMethod(method)) {
                    return method.getParameterTypes()[0];
                }
            }
            cls = cls.getSuperclass();
        }
        throw new java.lang.Error("Cannot determine correct type for matchesSafely() method.");
    }

    private static boolean isMatchesSafelyMethod(java.lang.reflect.Method method) {
        return method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected TypeSafeMatcher(java.lang.Class<T_renamed> cls) {
        this.expectedType = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.a_renamed.f_renamed
    public final boolean matches(java.lang.Object obj) {
        return obj != 0 && this.expectedType.isInstance(obj) && matchesSafely(obj);
    }
}
