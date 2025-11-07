package org.junit.experimental.max;

/* loaded from: classes2.dex */
public class MaxHistory implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private final java.util.Map<java.lang.String, java.lang.Long> fDurations = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Long> fFailureTimestamps = new java.util.HashMap();
    private final java.io.File fHistoryStore;

    public static org.junit.experimental.max.MaxHistory forFolder(java.io.File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (org.junit.experimental.max.CouldNotReadCoreException e_renamed) {
                e_renamed.printStackTrace();
                file.delete();
            }
        }
        return new org.junit.experimental.max.MaxHistory(file);
    }

    private static org.junit.experimental.max.MaxHistory readHistory(java.io.File file) throws org.junit.experimental.max.CouldNotReadCoreException, java.io.IOException {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
                try {
                    return (org.junit.experimental.max.MaxHistory) objectInputStream.readObject();
                } finally {
                    objectInputStream.close();
                }
            } finally {
                fileInputStream.close();
            }
        } catch (java.lang.Exception e_renamed) {
            throw new org.junit.experimental.max.CouldNotReadCoreException(e_renamed);
        }
    }

    private MaxHistory(java.io.File file) {
        this.fHistoryStore = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() throws java.io.IOException {
        java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    java.lang.Long getFailureTimestamp(org.junit.runner.Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    void putTestFailureTimestamp(org.junit.runner.Description description, long j_renamed) {
        this.fFailureTimestamps.put(description.toString(), java.lang.Long.valueOf(j_renamed));
    }

    boolean isNewTest(org.junit.runner.Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    java.lang.Long getTestDuration(org.junit.runner.Description description) {
        return this.fDurations.get(description.toString());
    }

    void putTestDuration(org.junit.runner.Description description, long j_renamed) {
        this.fDurations.put(description.toString(), java.lang.Long.valueOf(j_renamed));
    }

    private final class RememberingListener extends org.junit.runner.notification.RunListener {
        private long overallStart;
        private java.util.Map<org.junit.runner.Description, java.lang.Long> starts;

        private RememberingListener() {
            this.overallStart = java.lang.System.currentTimeMillis();
            this.starts = new java.util.HashMap();
        }

        @Override // org.junit.runner.notification.RunListener
        public void testStarted(org.junit.runner.Description description) throws java.lang.Exception {
            this.starts.put(description, java.lang.Long.valueOf(java.lang.System.nanoTime()));
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(org.junit.runner.Description description) throws java.lang.Exception {
            org.junit.experimental.max.MaxHistory.this.putTestDuration(description, java.lang.System.nanoTime() - this.starts.get(description).longValue());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(org.junit.runner.notification.Failure failure) throws java.lang.Exception {
            org.junit.experimental.max.MaxHistory.this.putTestFailureTimestamp(failure.getDescription(), this.overallStart);
        }

        @Override // org.junit.runner.notification.RunListener
        public void testRunFinished(org.junit.runner.Result result) throws java.lang.Exception {
            org.junit.experimental.max.MaxHistory.this.save();
        }
    }

    private class TestComparator implements java.util.Comparator<org.junit.runner.Description> {
        private TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(org.junit.runner.Description description, org.junit.runner.Description description2) {
            if (org.junit.experimental.max.MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (org.junit.experimental.max.MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int iCompareTo = getFailure(description2).compareTo(getFailure(description));
            return iCompareTo != 0 ? iCompareTo : org.junit.experimental.max.MaxHistory.this.getTestDuration(description).compareTo(org.junit.experimental.max.MaxHistory.this.getTestDuration(description2));
        }

        private java.lang.Long getFailure(org.junit.runner.Description description) {
            java.lang.Long failureTimestamp = org.junit.experimental.max.MaxHistory.this.getFailureTimestamp(description);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }
    }

    public org.junit.runner.notification.RunListener listener() {
        return new org.junit.experimental.max.MaxHistory.RememberingListener();
    }

    public java.util.Comparator<org.junit.runner.Description> testComparator() {
        return new org.junit.experimental.max.MaxHistory.TestComparator();
    }
}
