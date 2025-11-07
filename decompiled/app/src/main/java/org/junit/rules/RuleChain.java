package org.junit.rules;

/* loaded from: classes2.dex */
public class RuleChain implements org.junit.rules.TestRule {
    private static final org.junit.rules.RuleChain EMPTY_CHAIN = new org.junit.rules.RuleChain(java.util.Collections.emptyList());
    private java.util.List<org.junit.rules.TestRule> rulesStartingWithInnerMost;

    public static org.junit.rules.RuleChain emptyRuleChain() {
        return EMPTY_CHAIN;
    }

    public static org.junit.rules.RuleChain outerRule(org.junit.rules.TestRule testRule) {
        return emptyRuleChain().around(testRule);
    }

    private RuleChain(java.util.List<org.junit.rules.TestRule> list) {
        this.rulesStartingWithInnerMost = list;
    }

    public org.junit.rules.RuleChain around(org.junit.rules.TestRule testRule) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(testRule);
        arrayList.addAll(this.rulesStartingWithInnerMost);
        return new org.junit.rules.RuleChain(arrayList);
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        java.util.Iterator<org.junit.rules.TestRule> it = this.rulesStartingWithInnerMost.iterator();
        while (it.hasNext()) {
            statement = it.next().apply(statement, description);
        }
        return statement;
    }
}
