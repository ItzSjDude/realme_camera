package org.junit.rules;

/* loaded from: classes2.dex */
public class ExpectedException implements org.junit.rules.TestRule {
    private final org.junit.rules.ExpectedExceptionMatcherBuilder matcherBuilder = new org.junit.rules.ExpectedExceptionMatcherBuilder();
    private java.lang.String missingExceptionMessage = "Expected test to throw %s_renamed";

    @java.lang.Deprecated
    public org.junit.rules.ExpectedException handleAssertionErrors() {
        return this;
    }

    @java.lang.Deprecated
    public org.junit.rules.ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }

    public static org.junit.rules.ExpectedException none() {
        return new org.junit.rules.ExpectedException();
    }

    private ExpectedException() {
    }

    public org.junit.rules.ExpectedException reportMissingExceptionWithMessage(java.lang.String str) {
        this.missingExceptionMessage = str;
        return this;
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        return new org.junit.rules.ExpectedException.ExpectedExceptionStatement(statement);
    }

    public void expect(org.a_renamed.f_renamed<?> fVar) {
        this.matcherBuilder.add(fVar);
    }

    public void expect(java.lang.Class<? extends java.lang.Throwable> cls) {
        expect(org.a_renamed.c_renamed.a_renamed((java.lang.Class<?>) cls));
    }

    public void expectMessage(java.lang.String str) {
        expectMessage(org.a_renamed.c_renamed.a_renamed(str));
    }

    public void expectMessage(org.a_renamed.f_renamed<java.lang.String> fVar) {
        expect(org.junit.internal.matchers.ThrowableMessageMatcher.hasMessage(fVar));
    }

    public void expectCause(org.a_renamed.f_renamed<? extends java.lang.Throwable> fVar) {
        expect(org.junit.internal.matchers.ThrowableCauseMatcher.hasCause(fVar));
    }

    private class ExpectedExceptionStatement extends org.junit.runners.model.Statement {
        private final org.junit.runners.model.Statement next;

        public ExpectedExceptionStatement(org.junit.runners.model.Statement statement) {
            this.next = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws java.lang.Throwable {
            try {
                this.next.evaluate();
                if (org.junit.rules.ExpectedException.this.isAnyExceptionExpected()) {
                    org.junit.rules.ExpectedException.this.failDueToMissingException();
                }
            } catch (java.lang.Throwable th) {
                org.junit.rules.ExpectedException.this.handleException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(java.lang.Throwable th) throws java.lang.Throwable {
        if (isAnyExceptionExpected()) {
            org.junit.Assert.assertThat(th, this.matcherBuilder.build());
            return;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnyExceptionExpected() {
        return this.matcherBuilder.expectsThrowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failDueToMissingException() throws java.lang.AssertionError {
        org.junit.Assert.fail(missingExceptionMessage());
    }

    private java.lang.String missingExceptionMessage() {
        return java.lang.String.format(this.missingExceptionMessage, org.a_renamed.i_renamed.b_renamed((org.a_renamed.h_renamed) this.matcherBuilder.build()));
    }
}
