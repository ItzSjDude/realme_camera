package org.junit.internal.runners;

/* loaded from: classes2.dex */
public class SuiteMethod extends org.junit.internal.runners.JUnit38ClassRunner {
    public SuiteMethod(java.lang.Class<?> cls) throws java.lang.Throwable {
        super(testFromSuiteMethod(cls));
    }

    public static b_renamed.b_renamed.d_renamed testFromSuiteMethod(java.lang.Class<?> cls) throws java.lang.Exception {
        try {
            java.lang.reflect.Method method = cls.getMethod("suite", new java.lang.Class[0]);
            if (!java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                throw new java.lang.Exception(cls.getName() + ".suite() must be_renamed static");
            }
            return (b_renamed.b_renamed.d_renamed) method.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            throw e_renamed.getCause();
        }
    }
}
