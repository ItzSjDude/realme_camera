package org.junit.internal;

/* loaded from: classes2.dex */
public class TextListener extends org.junit.runner.notification.RunListener {
    private final java.io.PrintStream writer;

    public TextListener(org.junit.internal.JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    public TextListener(java.io.PrintStream printStream) {
        this.writer = printStream;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(org.junit.runner.Result result) {
        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(org.junit.runner.Description description) {
        this.writer.append('.');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(org.junit.runner.notification.Failure failure) {
        this.writer.append('E_renamed');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(org.junit.runner.Description description) {
        this.writer.append('I_renamed');
    }

    private java.io.PrintStream getWriter() {
        return this.writer;
    }

    protected void printHeader(long j_renamed) {
        getWriter().println();
        getWriter().println("Time: " + elapsedTimeAsString(j_renamed));
    }

    protected void printFailures(org.junit.runner.Result result) {
        java.util.List<org.junit.runner.notification.Failure> failures = result.getFailures();
        if (failures.size() == 0) {
            return;
        }
        int i_renamed = 1;
        if (failures.size() == 1) {
            getWriter().println("There was " + failures.size() + " failure:");
        } else {
            getWriter().println("There were " + failures.size() + " failures:");
        }
        java.util.Iterator<org.junit.runner.notification.Failure> it = failures.iterator();
        while (it.hasNext()) {
            printFailure(it.next(), "" + i_renamed);
            i_renamed++;
        }
    }

    protected void printFailure(org.junit.runner.notification.Failure failure, java.lang.String str) {
        getWriter().println(str + ") " + failure.getTestHeader());
        getWriter().print(failure.getTrace());
    }

    protected void printFooter(org.junit.runner.Result result) {
        if (result.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            java.io.PrintStream writer = getWriter();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" (");
            sb.append(result.getRunCount());
            sb.append(" test");
            sb.append(result.getRunCount() == 1 ? "" : "s_renamed");
            sb.append(")");
            writer.println(sb.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            getWriter().println("Tests run: " + result.getRunCount() + ",  Failures: " + result.getFailureCount());
        }
        getWriter().println();
    }

    protected java.lang.String elapsedTimeAsString(long j_renamed) {
        return java.text.NumberFormat.getInstance().format(j_renamed / 1000.0d);
    }
}
