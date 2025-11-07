package org.junit.runners.parameterized;

/* loaded from: classes2.dex */
public class TestWithParameters {
    private final java.lang.String name;
    private final java.util.List<java.lang.Object> parameters;
    private final org.junit.runners.model.TestClass testClass;

    public TestWithParameters(java.lang.String str, org.junit.runners.model.TestClass testClass, java.util.List<java.lang.Object> list) {
        notNull(str, "The name is_renamed missing.");
        notNull(testClass, "The test class is_renamed missing.");
        notNull(list, "The parameters are missing.");
        this.name = str;
        this.testClass = testClass;
        this.parameters = java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public java.lang.String getName() {
        return this.name;
    }

    public org.junit.runners.model.TestClass getTestClass() {
        return this.testClass;
    }

    public java.util.List<java.lang.Object> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return ((((this.name.hashCode() + 14747) * 14747) + this.testClass.hashCode()) * 14747) + this.parameters.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        org.junit.runners.parameterized.TestWithParameters testWithParameters = (org.junit.runners.parameterized.TestWithParameters) obj;
        return this.name.equals(testWithParameters.name) && this.parameters.equals(testWithParameters.parameters) && this.testClass.equals(testWithParameters.testClass);
    }

    public java.lang.String toString() {
        return this.testClass.getName() + " '" + this.name + "' with parameters " + this.parameters;
    }

    private static void notNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.NullPointerException(str);
        }
    }
}
