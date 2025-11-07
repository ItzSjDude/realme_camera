package org.junit.experimental.theories;

/* loaded from: classes2.dex */
public class Theories extends org.junit.runners.BlockJUnit4ClassRunner {
    public Theories(java.lang.Class<?> cls) throws org.junit.runners.model.InitializationError {
        super(cls);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
    protected void collectInitializationErrors(java.util.List<java.lang.Throwable> list) throws java.lang.SecurityException {
        super.collectInitializationErrors(list);
        validateDataPointFields(list);
        validateDataPointMethods(list);
    }

    private void validateDataPointFields(java.util.List<java.lang.Throwable> list) {
        for (java.lang.reflect.Field field : getTestClass().getJavaClass().getDeclaredFields()) {
            if (field.getAnnotation(org.junit.experimental.theories.DataPoint.class) != null || field.getAnnotation(org.junit.experimental.theories.DataPoints.class) != null) {
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    list.add(new java.lang.Error("DataPoint field " + field.getName() + " must be_renamed static"));
                }
                if (!java.lang.reflect.Modifier.isPublic(field.getModifiers())) {
                    list.add(new java.lang.Error("DataPoint field " + field.getName() + " must be_renamed public"));
                }
            }
        }
    }

    private void validateDataPointMethods(java.util.List<java.lang.Throwable> list) throws java.lang.SecurityException {
        for (java.lang.reflect.Method method : getTestClass().getJavaClass().getDeclaredMethods()) {
            if (method.getAnnotation(org.junit.experimental.theories.DataPoint.class) != null || method.getAnnotation(org.junit.experimental.theories.DataPoints.class) != null) {
                if (!java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                    list.add(new java.lang.Error("DataPoint method " + method.getName() + " must be_renamed static"));
                }
                if (!java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                    list.add(new java.lang.Error("DataPoint method " + method.getName() + " must be_renamed public"));
                }
            }
        }
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateConstructor(java.util.List<java.lang.Throwable> list) {
        validateOnlyOneConstructor(list);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateTestMethods(java.util.List<java.lang.Throwable> list) throws java.lang.SecurityException {
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : computeTestMethods()) {
            if (frameworkMethod.getAnnotation(org.junit.experimental.theories.Theory.class) != null) {
                frameworkMethod.validatePublicVoid(false, list);
                frameworkMethod.validateNoTypeParametersOnArgs(list);
            } else {
                frameworkMethod.validatePublicVoidNoArg(false, list);
            }
            java.util.Iterator<org.junit.experimental.theories.ParameterSignature> it = org.junit.experimental.theories.ParameterSignature.signatures(frameworkMethod.getMethod()).iterator();
            while (it.hasNext()) {
                org.junit.experimental.theories.ParametersSuppliedBy parametersSuppliedBy = (org.junit.experimental.theories.ParametersSuppliedBy) it.next().findDeepAnnotation(org.junit.experimental.theories.ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    validateParameterSupplier(parametersSuppliedBy.value(), list);
                }
            }
        }
    }

    private void validateParameterSupplier(java.lang.Class<? extends org.junit.experimental.theories.ParameterSupplier> cls, java.util.List<java.lang.Throwable> list) throws java.lang.SecurityException {
        java.lang.reflect.Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new java.lang.Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a_renamed TestClass)"));
            return;
        }
        java.lang.Class<?>[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length == 0 || parameterTypes[0].equals(org.junit.runners.model.TestClass.class)) {
            return;
        }
        list.add(new java.lang.Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a_renamed single TestClass instance"));
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected java.util.List<org.junit.runners.model.FrameworkMethod> computeTestMethods() {
        java.util.ArrayList arrayList = new java.util.ArrayList(super.computeTestMethods());
        java.util.List<org.junit.runners.model.FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(org.junit.experimental.theories.Theory.class);
        arrayList.removeAll(annotatedMethods);
        arrayList.addAll(annotatedMethods);
        return arrayList;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public org.junit.runners.model.Statement methodBlock(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        return new org.junit.experimental.theories.Theories.TheoryAnchor(frameworkMethod, getTestClass());
    }

    public static class TheoryAnchor extends org.junit.runners.model.Statement {
        private final org.junit.runners.model.TestClass testClass;
        private final org.junit.runners.model.FrameworkMethod testMethod;
        private int successes = 0;
        private java.util.List<org.junit.internal.AssumptionViolatedException> fInvalidParameters = new java.util.ArrayList();

        public TheoryAnchor(org.junit.runners.model.FrameworkMethod frameworkMethod, org.junit.runners.model.TestClass testClass) {
            this.testMethod = frameworkMethod;
            this.testClass = testClass;
        }

        private org.junit.runners.model.TestClass getTestClass() {
            return this.testClass;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws java.lang.Throwable {
            runWithAssignment(org.junit.experimental.theories.internal.Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
            boolean z_renamed = this.testMethod.getAnnotation(org.junit.experimental.theories.Theory.class) != null;
            if (this.successes == 0 && z_renamed) {
                org.junit.Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
            }
        }

        protected void runWithAssignment(org.junit.experimental.theories.internal.Assignments assignments) throws java.lang.Throwable {
            if (!assignments.isComplete()) {
                runWithIncompleteAssignment(assignments);
            } else {
                runWithCompleteAssignment(assignments);
            }
        }

        protected void runWithIncompleteAssignment(org.junit.experimental.theories.internal.Assignments assignments) throws java.lang.Throwable {
            java.util.Iterator<org.junit.experimental.theories.PotentialAssignment> it = assignments.potentialsForNextUnassigned().iterator();
            while (it.hasNext()) {
                runWithAssignment(assignments.assignNext(it.next()));
            }
        }

        protected void runWithCompleteAssignment(final org.junit.experimental.theories.internal.Assignments assignments) throws java.lang.Throwable {
            new org.junit.runners.BlockJUnit4ClassRunner(getTestClass().getJavaClass()) { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.1
                @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
                protected void collectInitializationErrors(java.util.List<java.lang.Throwable> list) {
                }

                @Override // org.junit.runners.BlockJUnit4ClassRunner
                public org.junit.runners.model.Statement methodBlock(org.junit.runners.model.FrameworkMethod frameworkMethod) {
                    final org.junit.runners.model.Statement statementMethodBlock = super.methodBlock(frameworkMethod);
                    return new org.junit.runners.model.Statement() { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.1.1
                        @Override // org.junit.runners.model.Statement
                        public void evaluate() throws java.lang.Throwable {
                            try {
                                statementMethodBlock.evaluate();
                                org.junit.experimental.theories.Theories.TheoryAnchor.this.handleDataPointSuccess();
                            } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
                                org.junit.experimental.theories.Theories.TheoryAnchor.this.handleAssumptionViolation(e_renamed);
                            } catch (java.lang.Throwable th) {
                                org.junit.experimental.theories.Theories.TheoryAnchor.this.reportParameterizedError(th, assignments.getArgumentStrings(org.junit.experimental.theories.Theories.TheoryAnchor.this.nullsOk()));
                            }
                        }
                    };
                }

                @Override // org.junit.runners.BlockJUnit4ClassRunner
                protected org.junit.runners.model.Statement methodInvoker(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj) {
                    return org.junit.experimental.theories.Theories.TheoryAnchor.this.methodCompletesWithParameters(frameworkMethod, assignments, obj);
                }

                @Override // org.junit.runners.BlockJUnit4ClassRunner
                public java.lang.Object createTest() throws java.lang.Exception {
                    java.lang.Object[] constructorArguments = assignments.getConstructorArguments();
                    if (!org.junit.experimental.theories.Theories.TheoryAnchor.this.nullsOk()) {
                        org.junit.Assume.assumeNotNull(constructorArguments);
                    }
                    return getTestClass().getOnlyConstructor().newInstance(constructorArguments);
                }
            }.methodBlock(this.testMethod).evaluate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public org.junit.runners.model.Statement methodCompletesWithParameters(final org.junit.runners.model.FrameworkMethod frameworkMethod, final org.junit.experimental.theories.internal.Assignments assignments, final java.lang.Object obj) {
            return new org.junit.runners.model.Statement() { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.2
                @Override // org.junit.runners.model.Statement
                public void evaluate() throws java.lang.Throwable {
                    java.lang.Object[] methodArguments = assignments.getMethodArguments();
                    if (!org.junit.experimental.theories.Theories.TheoryAnchor.this.nullsOk()) {
                        org.junit.Assume.assumeNotNull(methodArguments);
                    }
                    frameworkMethod.invokeExplosively(obj, methodArguments);
                }
            };
        }

        protected void handleAssumptionViolation(org.junit.internal.AssumptionViolatedException assumptionViolatedException) {
            this.fInvalidParameters.add(assumptionViolatedException);
        }

        protected void reportParameterizedError(java.lang.Throwable th, java.lang.Object... objArr) throws java.lang.Throwable {
            if (objArr.length == 0) {
                throw th;
            }
            throw new org.junit.experimental.theories.internal.ParameterizedAssertionError(th, this.testMethod.getName(), objArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean nullsOk() {
            org.junit.experimental.theories.Theory theory = (org.junit.experimental.theories.Theory) this.testMethod.getMethod().getAnnotation(org.junit.experimental.theories.Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        protected void handleDataPointSuccess() {
            this.successes++;
        }
    }
}
