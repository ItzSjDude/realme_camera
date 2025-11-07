package org.junit.internal.runners;

/* loaded from: classes2.dex */
public class JUnit38ClassRunner extends org.junit.runner.Runner implements org.junit.runner.manipulation.Filterable, org.junit.runner.manipulation.Sortable {
    private volatile b_renamed.b_renamed.d_renamed test;

    private static final class OldTestClassAdaptingListener implements b_renamed.b_renamed.g_renamed {
        private final org.junit.runner.notification.RunNotifier notifier;

        private OldTestClassAdaptingListener(org.junit.runner.notification.RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }

        @Override // b_renamed.b_renamed.g_renamed
        public void endTest(b_renamed.b_renamed.d_renamed dVar) {
            this.notifier.fireTestFinished(asDescription(dVar));
        }

        @Override // b_renamed.b_renamed.g_renamed
        public void startTest(b_renamed.b_renamed.d_renamed dVar) throws org.junit.runner.notification.StoppedByUserException {
            this.notifier.fireTestStarted(asDescription(dVar));
        }

        @Override // b_renamed.b_renamed.g_renamed
        public void addError(b_renamed.b_renamed.d_renamed dVar, java.lang.Throwable th) {
            this.notifier.fireTestFailure(new org.junit.runner.notification.Failure(asDescription(dVar), th));
        }

        private org.junit.runner.Description asDescription(b_renamed.b_renamed.d_renamed dVar) {
            if (dVar instanceof org.junit.runner.Describable) {
                return ((org.junit.runner.Describable) dVar).getDescription();
            }
            return org.junit.runner.Description.createTestDescription(getEffectiveClass(dVar), getName(dVar));
        }

        private java.lang.Class<? extends b_renamed.b_renamed.d_renamed> getEffectiveClass(b_renamed.b_renamed.d_renamed dVar) {
            return dVar.getClass();
        }

        private java.lang.String getName(b_renamed.b_renamed.d_renamed dVar) {
            if (dVar instanceof b_renamed.b_renamed.e_renamed) {
                return ((b_renamed.b_renamed.e_renamed) dVar).f_renamed();
            }
            return dVar.toString();
        }

        @Override // b_renamed.b_renamed.g_renamed
        public void addFailure(b_renamed.b_renamed.d_renamed dVar, b_renamed.b_renamed.b_renamed bVar) {
            addError(dVar, bVar);
        }
    }

    public JUnit38ClassRunner(java.lang.Class<?> cls) {
        this(new b_renamed.b_renamed.i_renamed(cls.asSubclass(b_renamed.b_renamed.e_renamed.class)));
    }

    public JUnit38ClassRunner(b_renamed.b_renamed.d_renamed dVar) {
        setTest(dVar);
    }

    @Override // org.junit.runner.Runner
    public void run(org.junit.runner.notification.RunNotifier runNotifier) {
        b_renamed.b_renamed.h_renamed hVar = new b_renamed.b_renamed.h_renamed();
        hVar.a_renamed(createAdaptingListener(runNotifier));
        getTest().b_renamed(hVar);
    }

    public b_renamed.b_renamed.g_renamed createAdaptingListener(org.junit.runner.notification.RunNotifier runNotifier) {
        return new org.junit.internal.runners.JUnit38ClassRunner.OldTestClassAdaptingListener(runNotifier);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public org.junit.runner.Description getDescription() {
        return makeDescription(getTest());
    }

    private static org.junit.runner.Description makeDescription(b_renamed.b_renamed.d_renamed dVar) {
        if (dVar instanceof b_renamed.b_renamed.e_renamed) {
            b_renamed.b_renamed.e_renamed eVar = (b_renamed.b_renamed.e_renamed) dVar;
            return org.junit.runner.Description.createTestDescription(eVar.getClass(), eVar.f_renamed(), getAnnotations(eVar));
        }
        if (dVar instanceof b_renamed.b_renamed.i_renamed) {
            b_renamed.b_renamed.i_renamed iVar = (b_renamed.b_renamed.i_renamed) dVar;
            org.junit.runner.Description descriptionCreateSuiteDescription = org.junit.runner.Description.createSuiteDescription(iVar.b_renamed() == null ? createSuiteDescription(iVar) : iVar.b_renamed(), new java.lang.annotation.Annotation[0]);
            int iC = iVar.c_renamed();
            for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
                descriptionCreateSuiteDescription.addChild(makeDescription(iVar.a_renamed(i_renamed)));
            }
            return descriptionCreateSuiteDescription;
        }
        if (dVar instanceof org.junit.runner.Describable) {
            return ((org.junit.runner.Describable) dVar).getDescription();
        }
        if (dVar instanceof b_renamed.a_renamed.a_renamed) {
            return makeDescription(((b_renamed.a_renamed.a_renamed) dVar).b_renamed());
        }
        return org.junit.runner.Description.createSuiteDescription(dVar.getClass());
    }

    private static java.lang.annotation.Annotation[] getAnnotations(b_renamed.b_renamed.e_renamed eVar) {
        try {
            return eVar.getClass().getMethod(eVar.f_renamed(), new java.lang.Class[0]).getDeclaredAnnotations();
        } catch (java.lang.NoSuchMethodException | java.lang.SecurityException unused) {
            return new java.lang.annotation.Annotation[0];
        }
    }

    private static java.lang.String createSuiteDescription(b_renamed.b_renamed.i_renamed iVar) {
        int iA = iVar.a_renamed();
        return java.lang.String.format("TestSuite with %s_renamed tests%s_renamed", java.lang.Integer.valueOf(iA), iA == 0 ? "" : java.lang.String.format(" [example: %s_renamed]", iVar.a_renamed(0)));
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(org.junit.runner.manipulation.Filter filter) throws org.junit.runner.manipulation.NoTestsRemainException {
        if (getTest() instanceof org.junit.runner.manipulation.Filterable) {
            ((org.junit.runner.manipulation.Filterable) getTest()).filter(filter);
            return;
        }
        if (getTest() instanceof b_renamed.b_renamed.i_renamed) {
            b_renamed.b_renamed.i_renamed iVar = (b_renamed.b_renamed.i_renamed) getTest();
            b_renamed.b_renamed.i_renamed iVar2 = new b_renamed.b_renamed.i_renamed(iVar.b_renamed());
            int iC = iVar.c_renamed();
            for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
                b_renamed.b_renamed.d_renamed dVarA = iVar.a_renamed(i_renamed);
                if (filter.shouldRun(makeDescription(dVarA))) {
                    iVar2.a_renamed(dVarA);
                }
            }
            setTest(iVar2);
            if (iVar2.c_renamed() == 0) {
                throw new org.junit.runner.manipulation.NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(org.junit.runner.manipulation.Sorter sorter) {
        if (getTest() instanceof org.junit.runner.manipulation.Sortable) {
            ((org.junit.runner.manipulation.Sortable) getTest()).sort(sorter);
        }
    }

    private void setTest(b_renamed.b_renamed.d_renamed dVar) {
        this.test = dVar;
    }

    private b_renamed.b_renamed.d_renamed getTest() {
        return this.test;
    }
}
