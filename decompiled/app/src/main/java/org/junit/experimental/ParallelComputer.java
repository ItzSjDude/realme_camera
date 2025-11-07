package org.junit.experimental;

/* loaded from: classes2.dex */
public class ParallelComputer extends org.junit.runner.Computer {
    private final boolean classes;
    private final boolean methods;

    public ParallelComputer(boolean z_renamed, boolean z2) {
        this.classes = z_renamed;
        this.methods = z2;
    }

    public static org.junit.runner.Computer classes() {
        return new org.junit.experimental.ParallelComputer(true, false);
    }

    public static org.junit.runner.Computer methods() {
        return new org.junit.experimental.ParallelComputer(false, true);
    }

    private static org.junit.runner.Runner parallelize(org.junit.runner.Runner runner) {
        if (runner instanceof org.junit.runners.ParentRunner) {
            ((org.junit.runners.ParentRunner) runner).setScheduler(new org.junit.runners.model.RunnerScheduler() { // from class: org.junit.experimental.ParallelComputer.1
                private final java.util.concurrent.ExecutorService fService = java.util.concurrent.Executors.newCachedThreadPool();

                @Override // org.junit.runners.model.RunnerScheduler
                public void schedule(java.lang.Runnable runnable) {
                    this.fService.submit(runnable);
                }

                @Override // org.junit.runners.model.RunnerScheduler
                public void finished() throws java.lang.InterruptedException {
                    try {
                        this.fService.shutdown();
                        this.fService.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
                    } catch (java.lang.InterruptedException e_renamed) {
                        e_renamed.printStackTrace(java.lang.System.err);
                    }
                }
            });
        }
        return runner;
    }

    @Override // org.junit.runner.Computer
    public org.junit.runner.Runner getSuite(org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        org.junit.runner.Runner suite = super.getSuite(runnerBuilder, clsArr);
        return this.classes ? parallelize(suite) : suite;
    }

    @Override // org.junit.runner.Computer
    protected org.junit.runner.Runner getRunner(org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?> cls) throws java.lang.Throwable {
        org.junit.runner.Runner runner = super.getRunner(runnerBuilder, cls);
        return this.methods ? parallelize(runner) : runner;
    }
}
