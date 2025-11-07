package org.junit.runner;

/* loaded from: classes2.dex */
public class Result implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields = java.io.ObjectStreamClass.lookup(org.junit.runner.Result.SerializedForm.class).getFields();
    private static final long serialVersionUID = 1;
    private final java.util.concurrent.atomic.AtomicInteger count;
    private final java.util.concurrent.CopyOnWriteArrayList<org.junit.runner.notification.Failure> failures;
    private final java.util.concurrent.atomic.AtomicInteger ignoreCount;
    private final java.util.concurrent.atomic.AtomicLong runTime;
    private org.junit.runner.Result.SerializedForm serializedForm;
    private final java.util.concurrent.atomic.AtomicLong startTime;

    public Result() {
        this.count = new java.util.concurrent.atomic.AtomicInteger();
        this.ignoreCount = new java.util.concurrent.atomic.AtomicInteger();
        this.failures = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.runTime = new java.util.concurrent.atomic.AtomicLong();
        this.startTime = new java.util.concurrent.atomic.AtomicLong();
    }

    private Result(org.junit.runner.Result.SerializedForm serializedForm) {
        this.count = serializedForm.fCount;
        this.ignoreCount = serializedForm.fIgnoreCount;
        this.failures = new java.util.concurrent.CopyOnWriteArrayList<>(serializedForm.fFailures);
        this.runTime = new java.util.concurrent.atomic.AtomicLong(serializedForm.fRunTime);
        this.startTime = new java.util.concurrent.atomic.AtomicLong(serializedForm.fStartTime);
    }

    public int getRunCount() {
        return this.count.get();
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public long getRunTime() {
        return this.runTime.get();
    }

    public java.util.List<org.junit.runner.notification.Failure> getFailures() {
        return this.failures;
    }

    public int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public boolean wasSuccessful() {
        return getFailureCount() == 0;
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        new org.junit.runner.Result.SerializedForm(this).serialize(objectOutputStream);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
        this.serializedForm = org.junit.runner.Result.SerializedForm.deserialize(objectInputStream);
    }

    private java.lang.Object readResolve() {
        return new org.junit.runner.Result(this.serializedForm);
    }

    @org.junit.runner.notification.RunListener.ThreadSafe
    private class Listener extends org.junit.runner.notification.RunListener {
        @Override // org.junit.runner.notification.RunListener
        public void testAssumptionFailure(org.junit.runner.notification.Failure failure) {
        }

        private Listener() {
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunStarted(org.junit.runner.Description description) throws java.lang.Exception {
            org.junit.runner.Result.this.startTime.set(java.lang.System.currentTimeMillis());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunFinished(org.junit.runner.Result result) throws java.lang.Exception {
            org.junit.runner.Result.this.runTime.addAndGet(java.lang.System.currentTimeMillis() - org.junit.runner.Result.this.startTime.get());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(org.junit.runner.Description description) throws java.lang.Exception {
            org.junit.runner.Result.this.count.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(org.junit.runner.notification.Failure failure) throws java.lang.Exception {
            org.junit.runner.Result.this.failures.add(failure);
        }

        @Override // org.junit.runner.notification.RunListener
        public void testIgnored(org.junit.runner.Description description) throws java.lang.Exception {
            org.junit.runner.Result.this.ignoreCount.getAndIncrement();
        }
    }

    public org.junit.runner.notification.RunListener createListener() {
        return new org.junit.runner.Result.Listener();
    }

    private static class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 1;
        private final java.util.concurrent.atomic.AtomicInteger fCount;
        private final java.util.List<org.junit.runner.notification.Failure> fFailures;
        private final java.util.concurrent.atomic.AtomicInteger fIgnoreCount;
        private final long fRunTime;
        private final long fStartTime;

        public SerializedForm(org.junit.runner.Result result) {
            this.fCount = result.count;
            this.fIgnoreCount = result.ignoreCount;
            this.fFailures = java.util.Collections.synchronizedList(new java.util.ArrayList(result.failures));
            this.fRunTime = result.runTime.longValue();
            this.fStartTime = result.startTime.longValue();
        }

        private SerializedForm(java.io.ObjectInputStream.GetField getField) throws java.io.IOException {
            this.fCount = (java.util.concurrent.atomic.AtomicInteger) getField.get("fCount", (java.lang.Object) null);
            this.fIgnoreCount = (java.util.concurrent.atomic.AtomicInteger) getField.get("fIgnoreCount", (java.lang.Object) null);
            this.fFailures = (java.util.List) getField.get("fFailures", (java.lang.Object) null);
            this.fRunTime = getField.get("fRunTime", 0L);
            this.fStartTime = getField.get("fStartTime", 0L);
        }

        public void serialize(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            java.io.ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
            putFieldPutFields.put("fCount", this.fCount);
            putFieldPutFields.put("fIgnoreCount", this.fIgnoreCount);
            putFieldPutFields.put("fFailures", this.fFailures);
            putFieldPutFields.put("fRunTime", this.fRunTime);
            putFieldPutFields.put("fStartTime", this.fStartTime);
            objectOutputStream.writeFields();
        }

        public static org.junit.runner.Result.SerializedForm deserialize(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
            return new org.junit.runner.Result.SerializedForm(objectInputStream.readFields());
        }
    }
}
