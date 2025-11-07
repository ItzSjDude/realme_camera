package org.junit.runner;

/* loaded from: classes2.dex */
public final class FilterFactoryParams {
    private final java.lang.String args;
    private final org.junit.runner.Description topLevelDescription;

    public FilterFactoryParams(org.junit.runner.Description description, java.lang.String str) {
        if (str == null || description == null) {
            throw new java.lang.NullPointerException();
        }
        this.topLevelDescription = description;
        this.args = str;
    }

    public java.lang.String getArgs() {
        return this.args;
    }

    public org.junit.runner.Description getTopLevelDescription() {
        return this.topLevelDescription;
    }
}
