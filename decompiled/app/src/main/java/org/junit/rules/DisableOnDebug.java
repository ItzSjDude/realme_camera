package org.junit.rules;

/* loaded from: classes2.dex */
public class DisableOnDebug implements org.junit.rules.TestRule {
    private final boolean debugging;
    private final org.junit.rules.TestRule rule;

    public DisableOnDebug(org.junit.rules.TestRule testRule) {
        this(testRule, java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments());
    }

    DisableOnDebug(org.junit.rules.TestRule testRule, java.util.List<java.lang.String> list) {
        this.rule = testRule;
        this.debugging = isDebugging(list);
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        return this.debugging ? statement : this.rule.apply(statement, description);
    }

    private static boolean isDebugging(java.util.List<java.lang.String> list) {
        for (java.lang.String str : list) {
            if ("-Xdebug".equals(str) || str.startsWith("-agentlib:jdwp")) {
                return true;
            }
        }
        return false;
    }

    public boolean isDebugging() {
        return this.debugging;
    }
}
