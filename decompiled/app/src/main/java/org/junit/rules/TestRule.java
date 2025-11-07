package org.junit.rules;

/* loaded from: classes2.dex */
public interface TestRule {
    org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description);
}
