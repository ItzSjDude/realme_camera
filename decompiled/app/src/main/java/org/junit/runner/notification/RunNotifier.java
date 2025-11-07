package org.junit.runner.notification;

/* loaded from: classes2.dex */
public class RunNotifier {
    private final java.util.List<org.junit.runner.notification.RunListener> listeners = new java.util.concurrent.CopyOnWriteArrayList();
    private volatile boolean pleaseStop = false;

    public void addListener(org.junit.runner.notification.RunListener runListener) {
        if (runListener == null) {
            throw new java.lang.NullPointerException("Cannot add a_renamed null listener");
        }
        this.listeners.add(wrapIfNotThreadSafe(runListener));
    }

    public void removeListener(org.junit.runner.notification.RunListener runListener) {
        if (runListener == null) {
            throw new java.lang.NullPointerException("Cannot remove a_renamed null listener");
        }
        this.listeners.remove(wrapIfNotThreadSafe(runListener));
    }

    org.junit.runner.notification.RunListener wrapIfNotThreadSafe(org.junit.runner.notification.RunListener runListener) {
        return runListener.getClass().isAnnotationPresent(org.junit.runner.notification.RunListener.ThreadSafe.class) ? runListener : new org.junit.runner.notification.SynchronizedRunListener(runListener, this);
    }

    private abstract class SafeNotifier {
        private final java.util.List<org.junit.runner.notification.RunListener> currentListeners;

        protected abstract void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception;

        SafeNotifier(org.junit.runner.notification.RunNotifier runNotifier) {
            this(runNotifier.listeners);
        }

        SafeNotifier(java.util.List<org.junit.runner.notification.RunListener> list) {
            this.currentListeners = list;
        }

        void run() {
            int size = this.currentListeners.size();
            java.util.ArrayList arrayList = new java.util.ArrayList(size);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(size);
            for (org.junit.runner.notification.RunListener runListener : this.currentListeners) {
                try {
                    notifyListener(runListener);
                    arrayList.add(runListener);
                } catch (java.lang.Exception e_renamed) {
                    arrayList2.add(new org.junit.runner.notification.Failure(org.junit.runner.Description.TEST_MECHANISM, e_renamed));
                }
            }
            org.junit.runner.notification.RunNotifier.this.fireTestFailures(arrayList, arrayList2);
        }
    }

    public void fireTestRunStarted(final org.junit.runner.Description description) {
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.1
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testRunStarted(description);
            }
        }.run();
    }

    public void fireTestRunFinished(final org.junit.runner.Result result) {
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.2
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testRunFinished(result);
            }
        }.run();
    }

    public void fireTestStarted(final org.junit.runner.Description description) throws org.junit.runner.notification.StoppedByUserException {
        if (this.pleaseStop) {
            throw new org.junit.runner.notification.StoppedByUserException();
        }
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.3
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testStarted(description);
            }
        }.run();
    }

    public void fireTestFailure(org.junit.runner.notification.Failure failure) {
        fireTestFailures(this.listeners, java.util.Arrays.asList(failure));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireTestFailures(java.util.List<org.junit.runner.notification.RunListener> list, final java.util.List<org.junit.runner.notification.Failure> list2) {
        if (list2.isEmpty()) {
            return;
        }
        new org.junit.runner.notification.RunNotifier.SafeNotifier(list) { // from class: org.junit.runner.notification.RunNotifier.4
            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                java.util.Iterator it = list2.iterator();
                while (it.hasNext()) {
                    runListener.testFailure((org.junit.runner.notification.Failure) it.next());
                }
            }
        }.run();
    }

    public void fireTestAssumptionFailed(final org.junit.runner.notification.Failure failure) {
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.5
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testAssumptionFailure(failure);
            }
        }.run();
    }

    public void fireTestIgnored(final org.junit.runner.Description description) {
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.6
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testIgnored(description);
            }
        }.run();
    }

    public void fireTestFinished(final org.junit.runner.Description description) {
        new org.junit.runner.notification.RunNotifier.SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.7
            /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
            {
                super(org.junit.runner.notification.RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(org.junit.runner.notification.RunListener runListener) throws java.lang.Exception {
                runListener.testFinished(description);
            }
        }.run();
    }

    public void pleaseStop() {
        this.pleaseStop = true;
    }

    public void addFirstListener(org.junit.runner.notification.RunListener runListener) {
        if (runListener == null) {
            throw new java.lang.NullPointerException("Cannot add a_renamed null listener");
        }
        this.listeners.add(0, wrapIfNotThreadSafe(runListener));
    }
}
