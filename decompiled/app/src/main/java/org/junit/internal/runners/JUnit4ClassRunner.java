package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class JUnit4ClassRunner extends org.junit.runner.Runner implements org.junit.runner.manipulation.Filterable, org.junit.runner.manipulation.Sortable {
    private org.junit.internal.runners.TestClass testClass;
    private final java.util.List<java.lang.reflect.Method> testMethods = getTestMethods();

    public JUnit4ClassRunner(java.lang.Class<?> cls) throws org.junit.internal.runners.InitializationError {
        this.testClass = new org.junit.internal.runners.TestClass(cls);
        validate();
    }

    protected java.util.List<java.lang.reflect.Method> getTestMethods() {
        return this.testClass.getTestMethods();
    }

    protected void validate() throws org.junit.internal.runners.InitializationError {
        org.junit.internal.runners.MethodValidator methodValidator = new org.junit.internal.runners.MethodValidator(this.testClass);
        methodValidator.validateMethodsForDefaultRunner();
        methodValidator.assertValid();
    }

    @Override // org.junit.runner.Runner
    public void run(final org.junit.runner.notification.RunNotifier runNotifier) {
        new org.junit.internal.runners.ClassRoadie(runNotifier, this.testClass, getDescription(), new java.lang.Runnable() { // from class: org.junit.internal.runners.JUnit4ClassRunner.1
            @Override // java.lang.Runnable
            public void run() throws org.junit.runner.notification.StoppedByUserException {
                org.junit.internal.runners.JUnit4ClassRunner.this.runMethods(runNotifier);
            }
        }).runProtected();
    }

    protected void runMethods(org.junit.runner.notification.RunNotifier runNotifier) throws org.junit.runner.notification.StoppedByUserException {
        java.util.Iterator<java.lang.reflect.Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            invokeTestMethod(it.next(), runNotifier);
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public org.junit.runner.Description getDescription() {
        org.junit.runner.Description descriptionCreateSuiteDescription = org.junit.runner.Description.createSuiteDescription(getName(), classAnnotations());
        java.util.Iterator<java.lang.reflect.Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(methodDescription(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    protected java.lang.annotation.Annotation[] classAnnotations() {
        return this.testClass.getJavaClass().getAnnotations();
    }

    protected java.lang.String getName() {
        return getTestClass().getName();
    }

    protected java.lang.Object createTest() throws java.lang.Exception {
        return getTestClass().getConstructor().newInstance(new java.lang.Object[0]);
    }

    protected void invokeTestMethod(java.lang.reflect.Method method, org.junit.runner.notification.RunNotifier runNotifier) throws org.junit.runner.notification.StoppedByUserException {
        org.junit.runner.Description descriptionMethodDescription = methodDescription(method);
        try {
            new org.junit.internal.runners.MethodRoadie(createTest(), wrapMethod(method), runNotifier, descriptionMethodDescription).run();
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            testAborted(runNotifier, descriptionMethodDescription, e_renamed.getCause());
        } catch (java.lang.Exception e2) {
            testAborted(runNotifier, descriptionMethodDescription, e2);
        }
    }

    private void testAborted(org.junit.runner.notification.RunNotifier runNotifier, org.junit.runner.Description description, java.lang.Throwable th) throws org.junit.runner.notification.StoppedByUserException {
        runNotifier.fireTestStarted(description);
        runNotifier.fireTestFailure(new org.junit.runner.notification.Failure(description, th));
        runNotifier.fireTestFinished(description);
    }

    protected org.junit.internal.runners.TestMethod wrapMethod(java.lang.reflect.Method method) {
        return new org.junit.internal.runners.TestMethod(method, this.testClass);
    }

    protected java.lang.String testName(java.lang.reflect.Method method) {
        return method.getName();
    }

    protected org.junit.runner.Description methodDescription(java.lang.reflect.Method method) {
        return org.junit.runner.Description.createTestDescription(getTestClass().getJavaClass(), testName(method), testAnnotations(method));
    }

    protected java.lang.annotation.Annotation[] testAnnotations(java.lang.reflect.Method method) {
        return method.getAnnotations();
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(org.junit.runner.manipulation.Filter filter) throws org.junit.runner.manipulation.NoTestsRemainException {
        java.util.Iterator<java.lang.reflect.Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            if (!filter.shouldRun(methodDescription(it.next()))) {
                it.remove();
            }
        }
        if (this.testMethods.isEmpty()) {
            throw new org.junit.runner.manipulation.NoTestsRemainException();
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(final org.junit.runner.manipulation.Sorter sorter) {
        java.util.Collections.sort(this.testMethods, new java.util.Comparator<java.lang.reflect.Method>() { // from class: org.junit.internal.runners.JUnit4ClassRunner.2
            @Override // java.util.Comparator
            public int compare(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
                return sorter.compare(org.junit.internal.runners.JUnit4ClassRunner.this.methodDescription(method), org.junit.internal.runners.JUnit4ClassRunner.this.methodDescription(method2));
            }
        });
    }

    protected org.junit.internal.runners.TestClass getTestClass() {
        return this.testClass;
    }
}
