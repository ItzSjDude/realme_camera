package org.junit.runners;

/* loaded from: classes2.dex */
public class Parameterized extends org.junit.runners.Suite {
    private static final org.junit.runners.parameterized.ParametersRunnerFactory DEFAULT_FACTORY = new org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory();
    private static final java.util.List<org.junit.runner.Runner> NO_RUNNERS = java.util.Collections.emptyList();
    private final java.util.List<org.junit.runner.Runner> runners;

    @java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface Parameter {
        int value() default 0;
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface Parameters {
        java.lang.String name() default "{index}";
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Inherited
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface UseParametersRunnerFactory {
        java.lang.Class<? extends org.junit.runners.parameterized.ParametersRunnerFactory> value() default org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory.class;
    }

    public Parameterized(java.lang.Class<?> cls) throws java.lang.Throwable {
        super(cls, NO_RUNNERS);
        this.runners = java.util.Collections.unmodifiableList(createRunnersForParameters(allParameters(), ((org.junit.runners.Parameterized.Parameters) getParametersMethod().getAnnotation(org.junit.runners.Parameterized.Parameters.class)).name(), getParametersRunnerFactory(cls)));
    }

    private org.junit.runners.parameterized.ParametersRunnerFactory getParametersRunnerFactory(java.lang.Class<?> cls) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        org.junit.runners.Parameterized.UseParametersRunnerFactory useParametersRunnerFactory = (org.junit.runners.Parameterized.UseParametersRunnerFactory) cls.getAnnotation(org.junit.runners.Parameterized.UseParametersRunnerFactory.class);
        if (useParametersRunnerFactory == null) {
            return DEFAULT_FACTORY;
        }
        return useParametersRunnerFactory.value().newInstance();
    }

    @Override // org.junit.runners.Suite, org.junit.runners.ParentRunner
    protected java.util.List<org.junit.runner.Runner> getChildren() {
        return this.runners;
    }

    private org.junit.runners.parameterized.TestWithParameters createTestWithNotNormalizedParameters(java.lang.String str, int i_renamed, java.lang.Object obj) {
        return createTestWithParameters(getTestClass(), str, i_renamed, obj instanceof java.lang.Object[] ? (java.lang.Object[]) obj : new java.lang.Object[]{obj});
    }

    private java.lang.Iterable<java.lang.Object> allParameters() throws java.lang.Exception {
        java.lang.Object objInvokeExplosively = getParametersMethod().invokeExplosively(null, new java.lang.Object[0]);
        if (objInvokeExplosively instanceof java.lang.Iterable) {
            return (java.lang.Iterable) objInvokeExplosively;
        }
        if (objInvokeExplosively instanceof java.lang.Object[]) {
            return java.util.Arrays.asList((java.lang.Object[]) objInvokeExplosively);
        }
        throw parametersMethodReturnedWrongType();
    }

    private org.junit.runners.model.FrameworkMethod getParametersMethod() throws java.lang.Exception {
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods(org.junit.runners.Parameterized.Parameters.class)) {
            if (frameworkMethod.isStatic() && frameworkMethod.isPublic()) {
                return frameworkMethod;
            }
        }
        throw new java.lang.Exception("No public static parameters method on_renamed class " + getTestClass().getName());
    }

    private java.util.List<org.junit.runner.Runner> createRunnersForParameters(java.lang.Iterable<java.lang.Object> iterable, java.lang.String str, org.junit.runners.parameterized.ParametersRunnerFactory parametersRunnerFactory) throws java.lang.Exception {
        try {
            java.util.List<org.junit.runners.parameterized.TestWithParameters> listCreateTestsForParameters = createTestsForParameters(iterable, str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<org.junit.runners.parameterized.TestWithParameters> it = listCreateTestsForParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(parametersRunnerFactory.createRunnerForTestWithParameters(it.next()));
            }
            return arrayList;
        } catch (java.lang.ClassCastException unused) {
            throw parametersMethodReturnedWrongType();
        }
    }

    private java.util.List<org.junit.runners.parameterized.TestWithParameters> createTestsForParameters(java.lang.Iterable<java.lang.Object> iterable, java.lang.String str) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Object> it = iterable.iterator();
        int i_renamed = 0;
        while (it.hasNext()) {
            arrayList.add(createTestWithNotNormalizedParameters(str, i_renamed, it.next()));
            i_renamed++;
        }
        return arrayList;
    }

    private java.lang.Exception parametersMethodReturnedWrongType() throws java.lang.Exception {
        return new java.lang.Exception(java.text.MessageFormat.format("{0}.{1}() must return an_renamed Iterable of_renamed arrays.", getTestClass().getName(), getParametersMethod().getName()));
    }

    private static org.junit.runners.parameterized.TestWithParameters createTestWithParameters(org.junit.runners.model.TestClass testClass, java.lang.String str, int i_renamed, java.lang.Object[] objArr) {
        return new org.junit.runners.parameterized.TestWithParameters("[" + java.text.MessageFormat.format(str.replaceAll("\\{index\\}", java.lang.Integer.toString(i_renamed)), objArr) + "]", testClass, java.util.Arrays.asList(objArr));
    }
}
