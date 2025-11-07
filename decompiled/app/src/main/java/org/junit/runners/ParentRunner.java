package org.junit.runners;

/* loaded from: classes2.dex */
public abstract class ParentRunner<T_renamed> extends org.junit.runner.Runner implements org.junit.runner.manipulation.Filterable, org.junit.runner.manipulation.Sortable {
    private static final java.util.List<org.junit.validator.TestClassValidator> VALIDATORS = java.util.Arrays.asList(new org.junit.validator.AnnotationsValidator(), new org.junit.validator.PublicClassValidator());
    private final java.lang.Object childrenLock = new java.lang.Object();
    private volatile java.util.Collection<T_renamed> filteredChildren = null;
    private volatile org.junit.runners.model.RunnerScheduler scheduler = new org.junit.runners.model.RunnerScheduler() { // from class: org.junit.runners.ParentRunner.1
        @Override // org.junit.runners.model.RunnerScheduler
        public void finished() {
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void schedule(java.lang.Runnable runnable) {
            runnable.run();
        }
    };
    private final org.junit.runners.model.TestClass testClass;

    protected abstract org.junit.runner.Description describeChild(T_renamed t_renamed);

    protected abstract java.util.List<T_renamed> getChildren();

    protected boolean isIgnored(T_renamed t_renamed) {
        return false;
    }

    protected abstract void runChild(T_renamed t_renamed, org.junit.runner.notification.RunNotifier runNotifier);

    protected ParentRunner(java.lang.Class<?> cls) throws org.junit.runners.model.InitializationError {
        this.testClass = createTestClass(cls);
        validate();
    }

    protected org.junit.runners.model.TestClass createTestClass(java.lang.Class<?> cls) {
        return new org.junit.runners.model.TestClass(cls);
    }

    protected void collectInitializationErrors(java.util.List<java.lang.Throwable> list) {
        validatePublicVoidNoArgMethods(org.junit.BeforeClass.class, true, list);
        validatePublicVoidNoArgMethods(org.junit.AfterClass.class, true, list);
        validateClassRules(list);
        applyValidators(list);
    }

    private void applyValidators(java.util.List<java.lang.Throwable> list) {
        if (getTestClass().getJavaClass() != null) {
            java.util.Iterator<org.junit.validator.TestClassValidator> it = VALIDATORS.iterator();
            while (it.hasNext()) {
                list.addAll(it.next().validateTestClass(getTestClass()));
            }
        }
    }

    protected void validatePublicVoidNoArgMethods(java.lang.Class<? extends java.lang.annotation.Annotation> cls, boolean z_renamed, java.util.List<java.lang.Throwable> list) {
        java.util.Iterator<org.junit.runners.model.FrameworkMethod> it = getTestClass().getAnnotatedMethods(cls).iterator();
        while (it.hasNext()) {
            it.next().validatePublicVoidNoArg(z_renamed, list);
        }
    }

    private void validateClassRules(java.util.List<java.lang.Throwable> list) {
        org.junit.internal.runners.rules.RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        org.junit.internal.runners.rules.RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    protected org.junit.runners.model.Statement classBlock(org.junit.runner.notification.RunNotifier runNotifier) {
        org.junit.runners.model.Statement statementChildrenInvoker = childrenInvoker(runNotifier);
        return !areAllChildrenIgnored() ? withClassRules(withAfterClasses(withBeforeClasses(statementChildrenInvoker))) : statementChildrenInvoker;
    }

    private boolean areAllChildrenIgnored() {
        java.util.Iterator<T_renamed> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            if (!isIgnored(it.next())) {
                return false;
            }
        }
        return true;
    }

    protected org.junit.runners.model.Statement withBeforeClasses(org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.runners.model.FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(org.junit.BeforeClass.class);
        return annotatedMethods.isEmpty() ? statement : new org.junit.internal.runners.statements.RunBefores(statement, annotatedMethods, null);
    }

    protected org.junit.runners.model.Statement withAfterClasses(org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.runners.model.FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(org.junit.AfterClass.class);
        return annotatedMethods.isEmpty() ? statement : new org.junit.internal.runners.statements.RunAfters(statement, annotatedMethods, null);
    }

    private org.junit.runners.model.Statement withClassRules(org.junit.runners.model.Statement statement) {
        java.util.List<org.junit.rules.TestRule> listClassRules = classRules();
        return listClassRules.isEmpty() ? statement : new org.junit.rules.RunRules(statement, listClassRules, getDescription());
    }

    protected java.util.List<org.junit.rules.TestRule> classRules() {
        java.util.List<org.junit.rules.TestRule> annotatedMethodValues = this.testClass.getAnnotatedMethodValues(null, org.junit.ClassRule.class, org.junit.rules.TestRule.class);
        annotatedMethodValues.addAll(this.testClass.getAnnotatedFieldValues(null, org.junit.ClassRule.class, org.junit.rules.TestRule.class));
        return annotatedMethodValues;
    }

    protected org.junit.runners.model.Statement childrenInvoker(final org.junit.runner.notification.RunNotifier runNotifier) {
        return new org.junit.runners.model.Statement() { // from class: org.junit.runners.ParentRunner.2
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                org.junit.runners.ParentRunner.this.runChildren(runNotifier);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runChildren(final org.junit.runner.notification.RunNotifier runNotifier) {
        org.junit.runners.model.RunnerScheduler runnerScheduler = this.scheduler;
        try {
            for (final T_renamed t_renamed : getFilteredChildren()) {
                runnerScheduler.schedule(new java.lang.Runnable() { // from class: org.junit.runners.ParentRunner.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        org.junit.runners.ParentRunner.this.runChild(t_renamed, runNotifier);
                    }
                });
            }
        } finally {
            runnerScheduler.finished();
        }
    }

    protected java.lang.String getName() {
        return this.testClass.getName();
    }

    public final org.junit.runners.model.TestClass getTestClass() {
        return this.testClass;
    }

    protected final void runLeaf(org.junit.runners.model.Statement statement, org.junit.runner.Description description, org.junit.runner.notification.RunNotifier runNotifier) {
        org.junit.internal.runners.model.EachTestNotifier eachTestNotifier = new org.junit.internal.runners.model.EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            try {
                statement.evaluate();
            } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
                eachTestNotifier.addFailedAssumption(e_renamed);
            } catch (java.lang.Throwable th) {
                eachTestNotifier.addFailure(th);
            }
        } finally {
            eachTestNotifier.fireTestFinished();
        }
    }

    protected java.lang.annotation.Annotation[] getRunnerAnnotations() {
        return this.testClass.getAnnotations();
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public org.junit.runner.Description getDescription() {
        org.junit.runner.Description descriptionCreateSuiteDescription = org.junit.runner.Description.createSuiteDescription(getName(), getRunnerAnnotations());
        java.util.Iterator<T_renamed> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(describeChild(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(org.junit.runner.notification.RunNotifier runNotifier) {
        org.junit.internal.runners.model.EachTestNotifier eachTestNotifier = new org.junit.internal.runners.model.EachTestNotifier(runNotifier, getDescription());
        try {
            classBlock(runNotifier).evaluate();
        } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
            eachTestNotifier.addFailedAssumption(e_renamed);
        } catch (org.junit.runner.notification.StoppedByUserException e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            eachTestNotifier.addFailure(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.Filterable
    public void filter(org.junit.runner.manipulation.Filter filter) throws org.junit.runner.manipulation.NoTestsRemainException {
        synchronized (this.childrenLock) {
            java.util.ArrayList arrayList = new java.util.ArrayList(getFilteredChildren());
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (shouldRun(filter, next)) {
                    try {
                        filter.apply(next);
                    } catch (org.junit.runner.manipulation.NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.filteredChildren = java.util.Collections.unmodifiableCollection(arrayList);
            if (this.filteredChildren.isEmpty()) {
                throw new org.junit.runner.manipulation.NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(org.junit.runner.manipulation.Sorter sorter) {
        synchronized (this.childrenLock) {
            java.util.Iterator<T_renamed> it = getFilteredChildren().iterator();
            while (it.hasNext()) {
                sorter.apply(it.next());
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(getFilteredChildren());
            java.util.Collections.sort(arrayList, comparator(sorter));
            this.filteredChildren = java.util.Collections.unmodifiableCollection(arrayList);
        }
    }

    private void validate() throws org.junit.runners.model.InitializationError {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        collectInitializationErrors(arrayList);
        if (!arrayList.isEmpty()) {
            throw new org.junit.runners.model.InitializationError(arrayList);
        }
    }

    private java.util.Collection<T_renamed> getFilteredChildren() {
        if (this.filteredChildren == null) {
            synchronized (this.childrenLock) {
                if (this.filteredChildren == null) {
                    this.filteredChildren = java.util.Collections.unmodifiableCollection(getChildren());
                }
            }
        }
        return this.filteredChildren;
    }

    private boolean shouldRun(org.junit.runner.manipulation.Filter filter, T_renamed t_renamed) {
        return filter.shouldRun(describeChild(t_renamed));
    }

    private java.util.Comparator<? super T_renamed> comparator(final org.junit.runner.manipulation.Sorter sorter) {
        return new java.util.Comparator<T_renamed>() { // from class: org.junit.runners.ParentRunner.4
            @Override // java.util.Comparator
            public int compare(T_renamed t_renamed, T_renamed t2) {
                return sorter.compare(org.junit.runners.ParentRunner.this.describeChild(t_renamed), org.junit.runners.ParentRunner.this.describeChild(t2));
            }
        };
    }

    public void setScheduler(org.junit.runners.model.RunnerScheduler runnerScheduler) {
        this.scheduler = runnerScheduler;
    }
}
