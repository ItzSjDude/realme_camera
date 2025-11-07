package org.junit.rules;

import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.p222a.CoreMatchers;
import org.p222a.StringDescription;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* loaded from: classes2.dex */
public class ExpectedException implements TestRule {
    private final ExpectedExceptionMatcherBuilder matcherBuilder = new ExpectedExceptionMatcherBuilder();
    private String missingExceptionMessage = "Expected test to throw %s";

    @Deprecated
    public ExpectedException handleAssertionErrors() {
        return this;
    }

    @Deprecated
    public ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }

    public static ExpectedException none() {
        return new ExpectedException();
    }

    private ExpectedException() {
    }

    public ExpectedException reportMissingExceptionWithMessage(String str) {
        this.missingExceptionMessage = str;
        return this;
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ExpectedExceptionStatement(statement);
    }

    public void expect(Matcher<?> interfaceC4039f) {
        this.matcherBuilder.add(interfaceC4039f);
    }

    public void expect(Class<? extends Throwable> cls) {
        expect(CoreMatchers.m26060a((Class<?>) cls));
    }

    public void expectMessage(String str) {
        expectMessage(CoreMatchers.m26063a(str));
    }

    public void expectMessage(Matcher<String> interfaceC4039f) {
        expect(ThrowableMessageMatcher.hasMessage(interfaceC4039f));
    }

    public void expectCause(Matcher<? extends Throwable> interfaceC4039f) {
        expect(ThrowableCauseMatcher.hasCause(interfaceC4039f));
    }

    private class ExpectedExceptionStatement extends Statement {
        private final Statement next;

        public ExpectedExceptionStatement(Statement statement) {
            this.next = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            try {
                this.next.evaluate();
                if (ExpectedException.this.isAnyExceptionExpected()) {
                    ExpectedException.this.failDueToMissingException();
                }
            } catch (Throwable th) {
                ExpectedException.this.handleException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Throwable th) throws Throwable {
        if (isAnyExceptionExpected()) {
            Assert.assertThat(th, this.matcherBuilder.build());
            return;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnyExceptionExpected() {
        return this.matcherBuilder.expectsThrowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failDueToMissingException() throws AssertionError {
        Assert.fail(missingExceptionMessage());
    }

    private String missingExceptionMessage() {
        return String.format(this.missingExceptionMessage, StringDescription.m26072b((SelfDescribing) this.matcherBuilder.build()));
    }
}
