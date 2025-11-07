package org.junit.rules;

/* loaded from: classes2.dex */
public abstract class TestWatcher implements org.junit.rules.TestRule {
    protected void failed(java.lang.Throwable th, org.junit.runner.Description description) {
    }

    protected void finished(org.junit.runner.Description description) {
    }

    @java.lang.Deprecated
    protected void skipped(org.junit.internal.AssumptionViolatedException assumptionViolatedException, org.junit.runner.Description description) {
    }

    protected void starting(org.junit.runner.Description description) {
    }

    protected void succeeded(org.junit.runner.Description description) {
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(final org.junit.runners.model.Statement statement, final org.junit.runner.Description description) {
        return new org.junit.runners.model.Statement() { // from class: org.junit.rules.TestWatcher.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v3, types: [org.junit.runner.Description] */
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws java.lang.Exception {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                org.junit.rules.TestWatcher.this.startingQuietly(description, arrayList);
                try {
                    try {
                        try {
                            statement.evaluate();
                            org.junit.rules.TestWatcher.this.succeededQuietly(description, arrayList);
                        } catch (java.lang.Throwable th) {
                            arrayList.add(th);
                            org.junit.rules.TestWatcher.this.failedQuietly(th, description, arrayList);
                        }
                    } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
                        arrayList.add(e_renamed);
                        org.junit.rules.TestWatcher.this.skippedQuietly(e_renamed, description, arrayList);
                    }
                    org.junit.runners.model.MultipleFailureException.assertEmpty(arrayList);
                } finally {
                    org.junit.rules.TestWatcher.this.finishedQuietly(description, arrayList);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void succeededQuietly(org.junit.runner.Description description, java.util.List<java.lang.Throwable> list) {
        try {
            succeeded(description);
        } catch (java.lang.Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failedQuietly(java.lang.Throwable th, org.junit.runner.Description description, java.util.List<java.lang.Throwable> list) {
        try {
            failed(th, description);
        } catch (java.lang.Throwable th2) {
            list.add(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skippedQuietly(org.junit.internal.AssumptionViolatedException assumptionViolatedException, org.junit.runner.Description description, java.util.List<java.lang.Throwable> list) {
        try {
            if (assumptionViolatedException instanceof org.junit.AssumptionViolatedException) {
                skipped((org.junit.AssumptionViolatedException) assumptionViolatedException, description);
            } else {
                skipped(assumptionViolatedException, description);
            }
        } catch (java.lang.Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startingQuietly(org.junit.runner.Description description, java.util.List<java.lang.Throwable> list) {
        try {
            starting(description);
        } catch (java.lang.Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishedQuietly(org.junit.runner.Description description, java.util.List<java.lang.Throwable> list) {
        try {
            finished(description);
        } catch (java.lang.Throwable th) {
            list.add(th);
        }
    }

    protected void skipped(org.junit.AssumptionViolatedException assumptionViolatedException, org.junit.runner.Description description) {
        skipped((org.junit.internal.AssumptionViolatedException) assumptionViolatedException, description);
    }
}
