package org.junit.runners;

/* loaded from: classes2.dex */
public class BlockJUnit4ClassRunner extends org.junit.runners.ParentRunner<org.junit.runners.model.FrameworkMethod> {
    private final java.util.concurrent.ConcurrentHashMap<org.junit.runners.model.FrameworkMethod, org.junit.runner.Description> methodDescriptions;

    public BlockJUnit4ClassRunner(java.lang.Class<?> cls) throws org.junit.runners.model.InitializationError {
        super(cls);
        this.methodDescriptions = new java.util.concurrent.ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(org.junit.runners.model.FrameworkMethod frameworkMethod, org.junit.runner.notification.RunNotifier runNotifier) {
        org.junit.runner.Description descriptionDescribeChild = describeChild(frameworkMethod);
        if (isIgnored(frameworkMethod)) {
            runNotifier.fireTestIgnored(descriptionDescribeChild);
        } else {
            runLeaf(methodBlock(frameworkMethod), descriptionDescribeChild, runNotifier);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public boolean isIgnored(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(org.junit.Ignore.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public org.junit.runner.Description describeChild(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        org.junit.runner.Description description = this.methodDescriptions.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        org.junit.runner.Description descriptionCreateTestDescription = org.junit.runner.Description.createTestDescription(getTestClass().getJavaClass(), testName(frameworkMethod), frameworkMethod.getAnnotations());
        this.methodDescriptions.putIfAbsent(frameworkMethod, descriptionCreateTestDescription);
        return descriptionCreateTestDescription;
    }

    @Override // org.junit.runners.ParentRunner
    protected java.util.List<org.junit.runners.model.FrameworkMethod> getChildren() {
        return computeTestMethods();
    }

    protected java.util.List<org.junit.runners.model.FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(org.junit.Test.class);
    }

    @Override // org.junit.runners.ParentRunner
    protected void collectInitializationErrors(java.util.List<java.lang.Throwable> list) {
        super.collectInitializationErrors(list);
        validateNoNonStaticInnerClass(list);
        validateConstructor(list);
        validateInstanceMethods(list);
        validateFields(list);
        validateMethods(list);
    }

    protected void validateNoNonStaticInnerClass(java.util.List<java.lang.Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            list.add(new java.lang.Exception("The inner class " + getTestClass().getName() + " is_renamed not static."));
        }
    }

    protected void validateConstructor(java.util.List<java.lang.Throwable> list) {
        validateOnlyOneConstructor(list);
        validateZeroArgConstructor(list);
    }

    protected void validateOnlyOneConstructor(java.util.List<java.lang.Throwable> list) {
        if (hasOneConstructor()) {
            return;
        }
        list.add(new java.lang.Exception("Test class should have exactly one public constructor"));
    }

    protected void validateZeroArgConstructor(java.util.List<java.lang.Throwable> list) {
        if (getTestClass().isANonStaticInnerClass() || !hasOneConstructor() || getTestClass().getOnlyConstructor().getParameterTypes().length == 0) {
            return;
        }
        list.add(new java.lang.Exception("Test class should have exactly one public zero-argument constructor"));
    }

    private boolean hasOneConstructor() {
        return getTestClass().getJavaClass().getConstructors().length == 1;
    }

    @java.lang.Deprecated
    protected void validateInstanceMethods(java.util.List<java.lang.Throwable> list) {
        validatePublicVoidNoArgMethods(org.junit.After.class, false, list);
        validatePublicVoidNoArgMethods(org.junit.Before.class, false, list);
        validateTestMethods(list);
        if (computeTestMethods().size() == 0) {
            list.add(new java.lang.Exception("No runnable methods"));
        }
    }

    protected void validateFields(java.util.List<java.lang.Throwable> list) {
        org.junit.internal.runners.rules.RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    private void validateMethods(java.util.List<java.lang.Throwable> list) {
        org.junit.internal.runners.rules.RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    protected void validateTestMethods(java.util.List<java.lang.Throwable> list) {
        validatePublicVoidNoArgMethods(org.junit.Test.class, false, list);
    }

    protected java.lang.Object createTest() throws java.lang.Exception {
        return getTestClass().getOnlyConstructor().newInstance(new java.lang.Object[0]);
    }

    protected java.lang.String testName(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    protected org.junit.runners.model.Statement methodBlock(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        try {
            java.lang.Object objRun = new org.junit.internal.runners.model.ReflectiveCallable() { // from class: org.junit.runners.BlockJUnit4ClassRunner.1
                @Override // org.junit.internal.runners.model.ReflectiveCallable
                protected java.lang.Object runReflectiveCall() throws java.lang.Throwable {
                    return org.junit.runners.BlockJUnit4ClassRunner.this.createTest();
                }
            }.run();
            return withRules(frameworkMethod, objRun, withAfters(frameworkMethod, objRun, withBefores(frameworkMethod, objRun, withPotentialTimeout(frameworkMethod, objRun, possiblyExpectingExceptions(frameworkMethod, objRun, methodInvoker(frameworkMethod, objRun))))));
        } catch (java.lang.Throwable th) {
            return new org.junit.internal.runners.statements.Fail(th);
        }
    }

    protected org.junit.runners.model.Statement methodInvoker(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj) {
        return new org.junit.internal.runners.statements.InvokeMethod(frameworkMethod, obj);
    }

    protected org.junit.runners.model.Statement possiblyExpectingExceptions(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        org.junit.Test test = (org.junit.Test) frameworkMethod.getAnnotation(org.junit.Test.class);
        return expectsException(test) ? new org.junit.internal.runners.statements.ExpectException(statement, getExpectedException(test)) : statement;
    }

    @java.lang.Deprecated
    protected org.junit.runners.model.Statement withPotentialTimeout(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        long timeout = getTimeout((org.junit.Test) frameworkMethod.getAnnotation(org.junit.Test.class));
        return timeout <= 0 ? statement : org.junit.internal.runners.statements.FailOnTimeout.builder().withTimeout(timeout, java.util.concurrent.TimeUnit.MILLISECONDS).build(statement);
    }

    protected org.junit.runners.model.Statement withBefores(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.runners.model.FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(org.junit.Before.class);
        return annotatedMethods.isEmpty() ? statement : new org.junit.internal.runners.statements.RunBefores(statement, annotatedMethods, obj);
    }

    protected org.junit.runners.model.Statement withAfters(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.runners.model.FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(org.junit.After.class);
        return annotatedMethods.isEmpty() ? statement : new org.junit.internal.runners.statements.RunAfters(statement, annotatedMethods, obj);
    }

    private org.junit.runners.model.Statement withRules(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.rules.TestRule> testRules = getTestRules(obj);
        return withTestRules(frameworkMethod, testRules, withMethodRules(frameworkMethod, testRules, obj, statement));
    }

    private org.junit.runners.model.Statement withMethodRules(org.junit.runners.model.FrameworkMethod frameworkMethod, java.util.List<org.junit.rules.TestRule> list, java.lang.Object obj, org.junit.runners.model.Statement statement) {
        for (org.junit.rules.MethodRule methodRule : getMethodRules(obj)) {
            if (!list.contains(methodRule)) {
                statement = methodRule.apply(statement, frameworkMethod, obj);
            }
        }
        return statement;
    }

    private java.util.List<org.junit.rules.MethodRule> getMethodRules(java.lang.Object obj) {
        return rules(obj);
    }

    protected java.util.List<org.junit.rules.MethodRule> rules(java.lang.Object obj) {
        java.util.List<org.junit.rules.MethodRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, org.junit.Rule.class, org.junit.rules.MethodRule.class);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, org.junit.Rule.class, org.junit.rules.MethodRule.class));
        return annotatedMethodValues;
    }

    private org.junit.runners.model.Statement withTestRules(org.junit.runners.model.FrameworkMethod frameworkMethod, java.util.List<org.junit.rules.TestRule> list, org.junit.runners.model.Statement statement) {
        return list.isEmpty() ? statement : new org.junit.rules.RunRules(statement, list, describeChild(frameworkMethod));
    }

    protected java.util.List<org.junit.rules.TestRule> getTestRules(java.lang.Object obj) {
        java.util.List<org.junit.rules.TestRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, org.junit.Rule.class, org.junit.rules.TestRule.class);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, org.junit.Rule.class, org.junit.rules.TestRule.class));
        return annotatedMethodValues;
    }

    private java.lang.Class<? extends java.lang.Throwable> getExpectedException(org.junit.Test test) {
        if (test == null || test.expected() == org.junit.Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private boolean expectsException(org.junit.Test test) {
        return getExpectedException(test) != null;
    }

    private long getTimeout(org.junit.Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }
}
