package org.junit.runners.parameterized;

/* loaded from: classes2.dex */
public class BlockJUnit4ClassRunnerWithParameters extends org.junit.runners.BlockJUnit4ClassRunner {
    private final java.lang.String name;
    private final java.lang.Object[] parameters;

    public BlockJUnit4ClassRunnerWithParameters(org.junit.runners.parameterized.TestWithParameters testWithParameters) throws org.junit.runners.model.InitializationError {
        super(testWithParameters.getTestClass().getJavaClass());
        this.parameters = testWithParameters.getParameters().toArray(new java.lang.Object[testWithParameters.getParameters().size()]);
        this.name = testWithParameters.getName();
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public java.lang.Object createTest() throws java.lang.Exception {
        if (fieldsAreAnnotated()) {
            return createTestUsingFieldInjection();
        }
        return createTestUsingConstructorInjection();
    }

    private java.lang.Object createTestUsingConstructorInjection() throws java.lang.Exception {
        return getTestClass().getOnlyConstructor().newInstance(this.parameters);
    }

    private java.lang.Object createTestUsingFieldInjection() throws java.lang.Exception {
        java.util.List<org.junit.runners.model.FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
        if (annotatedFieldsByParameter.size() != this.parameters.length) {
            throw new java.lang.Exception("Wrong number of_renamed parameters and @Parameter fields. @Parameter fields counted: " + annotatedFieldsByParameter.size() + ", available parameters: " + this.parameters.length + ".");
        }
        java.lang.Object objNewInstance = getTestClass().getJavaClass().newInstance();
        java.util.Iterator<org.junit.runners.model.FrameworkField> it = annotatedFieldsByParameter.iterator();
        while (it.hasNext()) {
            java.lang.reflect.Field field = it.next().getField();
            int iValue = ((org.junit.runners.Parameterized.Parameter) field.getAnnotation(org.junit.runners.Parameterized.Parameter.class)).value();
            try {
                field.set(objNewInstance, this.parameters[iValue]);
            } catch (java.lang.IllegalArgumentException e_renamed) {
                throw new java.lang.Exception(getTestClass().getName() + ": Trying to set " + field.getName() + " with the value " + this.parameters[iValue] + " that is_renamed not the right type (" + this.parameters[iValue].getClass().getSimpleName() + " instead of_renamed " + field.getType().getSimpleName() + ").", e_renamed);
            }
        }
        return objNewInstance;
    }

    @Override // org.junit.runners.ParentRunner
    protected java.lang.String getName() {
        return this.name;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected java.lang.String testName(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName() + getName();
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateConstructor(java.util.List<java.lang.Throwable> list) {
        validateOnlyOneConstructor(list);
        if (fieldsAreAnnotated()) {
            validateZeroArgConstructor(list);
        }
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateFields(java.util.List<java.lang.Throwable> list) {
        super.validateFields(list);
        if (fieldsAreAnnotated()) {
            java.util.List<org.junit.runners.model.FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
            int[] iArr = new int[annotatedFieldsByParameter.size()];
            java.util.Iterator<org.junit.runners.model.FrameworkField> it = annotatedFieldsByParameter.iterator();
            while (it.hasNext()) {
                int iValue = ((org.junit.runners.Parameterized.Parameter) it.next().getField().getAnnotation(org.junit.runners.Parameterized.Parameter.class)).value();
                if (iValue < 0 || iValue > annotatedFieldsByParameter.size() - 1) {
                    list.add(new java.lang.Exception("Invalid @Parameter value: " + iValue + ". @Parameter fields counted: " + annotatedFieldsByParameter.size() + ". Please use an_renamed index between 0 and " + (annotatedFieldsByParameter.size() - 1) + "."));
                } else {
                    iArr[iValue] = iArr[iValue] + 1;
                }
            }
            for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
                int i2 = iArr[i_renamed];
                if (i2 == 0) {
                    list.add(new java.lang.Exception("@Parameter(" + i_renamed + ") is_renamed never used."));
                } else if (i2 > 1) {
                    list.add(new java.lang.Exception("@Parameter(" + i_renamed + ") is_renamed used more than once (" + i2 + ")."));
                }
            }
        }
    }

    @Override // org.junit.runners.ParentRunner
    protected org.junit.runners.model.Statement classBlock(org.junit.runner.notification.RunNotifier runNotifier) {
        return childrenInvoker(runNotifier);
    }

    @Override // org.junit.runners.ParentRunner
    protected java.lang.annotation.Annotation[] getRunnerAnnotations() {
        return new java.lang.annotation.Annotation[0];
    }

    private java.util.List<org.junit.runners.model.FrameworkField> getAnnotatedFieldsByParameter() {
        return getTestClass().getAnnotatedFields(org.junit.runners.Parameterized.Parameter.class);
    }

    private boolean fieldsAreAnnotated() {
        return !getAnnotatedFieldsByParameter().isEmpty();
    }
}
