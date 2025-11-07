package org.junit.experimental.max;

/* loaded from: classes2.dex */
public class MaxCore {
    private static final java.lang.String MALFORMED_JUNIT_3_TEST_CLASS_PREFIX = "malformed JUnit 3 test class: ";
    private final org.junit.experimental.max.MaxHistory history;

    @java.lang.Deprecated
    public static org.junit.experimental.max.MaxCore forFolder(java.lang.String str) {
        return storedLocally(new java.io.File(str));
    }

    public static org.junit.experimental.max.MaxCore storedLocally(java.io.File file) {
        return new org.junit.experimental.max.MaxCore(file);
    }

    private MaxCore(java.io.File file) {
        this.history = org.junit.experimental.max.MaxHistory.forFolder(file);
    }

    public org.junit.runner.Result run(java.lang.Class<?> cls) {
        return run(org.junit.runner.Request.aClass(cls));
    }

    public org.junit.runner.Result run(org.junit.runner.Request request) {
        return run(request, new org.junit.runner.JUnitCore());
    }

    public org.junit.runner.Result run(org.junit.runner.Request request, org.junit.runner.JUnitCore jUnitCore) {
        jUnitCore.addListener(this.history.listener());
        return jUnitCore.run(sortRequest(request).getRunner());
    }

    public org.junit.runner.Request sortRequest(org.junit.runner.Request request) {
        if (request instanceof org.junit.internal.requests.SortingRequest) {
            return request;
        }
        java.util.List<org.junit.runner.Description> listFindLeaves = findLeaves(request);
        java.util.Collections.sort(listFindLeaves, this.history.testComparator());
        return constructLeafRequest(listFindLeaves);
    }

    private org.junit.runner.Request constructLeafRequest(java.util.List<org.junit.runner.Description> list) {
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.junit.runner.Description> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(buildRunner(it.next()));
        }
        return new org.junit.runner.Request() { // from class: org.junit.experimental.max.MaxCore.1
            @Override // org.junit.runner.Request
            public org.junit.runner.Runner getRunner() {
                try {
                    return new org.junit.runners.Suite((java.lang.Class) null, arrayList) { // from class: org.junit.experimental.max.MaxCore.1.1
                    };
                } catch (org.junit.runners.model.InitializationError e_renamed) {
                    return new org.junit.internal.runners.ErrorReportingRunner(null, e_renamed);
                }
            }
        };
    }

    private org.junit.runner.Runner buildRunner(org.junit.runner.Description description) {
        if (description.toString().equals("TestSuite with 0 tests")) {
            return org.junit.runners.Suite.emptySuite();
        }
        if (description.toString().startsWith(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX)) {
            return new org.junit.internal.runners.JUnit38ClassRunner(new b_renamed.b_renamed.i_renamed(getMalformedTestClass(description)));
        }
        java.lang.Class<?> testClass = description.getTestClass();
        if (testClass == null) {
            throw new java.lang.RuntimeException("Can't_renamed build a_renamed runner from description [" + description + "]");
        }
        java.lang.String methodName = description.getMethodName();
        if (methodName == null) {
            return org.junit.runner.Request.aClass(testClass).getRunner();
        }
        return org.junit.runner.Request.method(testClass, methodName).getRunner();
    }

    private java.lang.Class<?> getMalformedTestClass(org.junit.runner.Description description) {
        try {
            return java.lang.Class.forName(description.toString().replace(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX, ""));
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public java.util.List<org.junit.runner.Description> sortedLeavesForTest(org.junit.runner.Request request) {
        return findLeaves(sortRequest(request));
    }

    private java.util.List<org.junit.runner.Description> findLeaves(org.junit.runner.Request request) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        findLeaves(null, request.getRunner().getDescription(), arrayList);
        return arrayList;
    }

    private void findLeaves(org.junit.runner.Description description, org.junit.runner.Description description2, java.util.List<org.junit.runner.Description> list) {
        if (description2.getChildren().isEmpty()) {
            if (description2.toString().equals("warning(junit.framework.TestSuite$1)")) {
                list.add(org.junit.runner.Description.createSuiteDescription(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX + description, new java.lang.annotation.Annotation[0]));
                return;
            }
            list.add(description2);
            return;
        }
        java.util.Iterator<org.junit.runner.Description> it = description2.getChildren().iterator();
        while (it.hasNext()) {
            findLeaves(description2, it.next(), list);
        }
    }
}
