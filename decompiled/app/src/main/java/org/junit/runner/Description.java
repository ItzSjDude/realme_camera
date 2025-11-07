package org.junit.runner;

/* loaded from: classes2.dex */
public class Description implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private final java.lang.annotation.Annotation[] fAnnotations;
    private final java.util.Collection<org.junit.runner.Description> fChildren;
    private final java.lang.String fDisplayName;
    private volatile java.lang.Class<?> fTestClass;
    private final java.io.Serializable fUniqueId;
    private static final java.util.regex.Pattern METHOD_AND_CLASS_NAME_PATTERN = java.util.regex.Pattern.compile("([\\s_renamed\\S_renamed]*)\\((.*)\\)");
    public static final org.junit.runner.Description EMPTY = new org.junit.runner.Description(null, "No Tests", new java.lang.annotation.Annotation[0]);
    public static final org.junit.runner.Description TEST_MECHANISM = new org.junit.runner.Description(null, "Test mechanism", new java.lang.annotation.Annotation[0]);

    public static org.junit.runner.Description createSuiteDescription(java.lang.String str, java.lang.annotation.Annotation... annotationArr) {
        return new org.junit.runner.Description(null, str, annotationArr);
    }

    public static org.junit.runner.Description createSuiteDescription(java.lang.String str, java.io.Serializable serializable, java.lang.annotation.Annotation... annotationArr) {
        return new org.junit.runner.Description(null, str, serializable, annotationArr);
    }

    public static org.junit.runner.Description createTestDescription(java.lang.String str, java.lang.String str2, java.lang.annotation.Annotation... annotationArr) {
        return new org.junit.runner.Description(null, formatDisplayName(str2, str), annotationArr);
    }

    public static org.junit.runner.Description createTestDescription(java.lang.Class<?> cls, java.lang.String str, java.lang.annotation.Annotation... annotationArr) {
        return new org.junit.runner.Description(cls, formatDisplayName(str, cls.getName()), annotationArr);
    }

    public static org.junit.runner.Description createTestDescription(java.lang.Class<?> cls, java.lang.String str) {
        return new org.junit.runner.Description(cls, formatDisplayName(str, cls.getName()), new java.lang.annotation.Annotation[0]);
    }

    public static org.junit.runner.Description createTestDescription(java.lang.String str, java.lang.String str2, java.io.Serializable serializable) {
        return new org.junit.runner.Description(null, formatDisplayName(str2, str), serializable, new java.lang.annotation.Annotation[0]);
    }

    private static java.lang.String formatDisplayName(java.lang.String str, java.lang.String str2) {
        return java.lang.String.format("%s_renamed(%s_renamed)", str, str2);
    }

    public static org.junit.runner.Description createSuiteDescription(java.lang.Class<?> cls) {
        return new org.junit.runner.Description(cls, cls.getName(), cls.getAnnotations());
    }

    private Description(java.lang.Class<?> cls, java.lang.String str, java.lang.annotation.Annotation... annotationArr) {
        this(cls, str, str, annotationArr);
    }

    private Description(java.lang.Class<?> cls, java.lang.String str, java.io.Serializable serializable, java.lang.annotation.Annotation... annotationArr) {
        this.fChildren = new java.util.concurrent.ConcurrentLinkedQueue();
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("The display name must not be_renamed empty.");
        }
        if (serializable == null) {
            throw new java.lang.IllegalArgumentException("The unique id_renamed must not be_renamed null.");
        }
        this.fTestClass = cls;
        this.fDisplayName = str;
        this.fUniqueId = serializable;
        this.fAnnotations = annotationArr;
    }

    public java.lang.String getDisplayName() {
        return this.fDisplayName;
    }

    public void addChild(org.junit.runner.Description description) {
        this.fChildren.add(description);
    }

    public java.util.ArrayList<org.junit.runner.Description> getChildren() {
        return new java.util.ArrayList<>(this.fChildren);
    }

    public boolean isSuite() {
        return !isTest();
    }

    public boolean isTest() {
        return this.fChildren.isEmpty();
    }

    public int testCount() {
        if (isTest()) {
            return 1;
        }
        int iTestCount = 0;
        java.util.Iterator<org.junit.runner.Description> it = this.fChildren.iterator();
        while (it.hasNext()) {
            iTestCount += it.next().testCount();
        }
        return iTestCount;
    }

    public int hashCode() {
        return this.fUniqueId.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof org.junit.runner.Description) {
            return this.fUniqueId.equals(((org.junit.runner.Description) obj).fUniqueId);
        }
        return false;
    }

    public java.lang.String toString() {
        return getDisplayName();
    }

    public boolean isEmpty() {
        return equals(EMPTY);
    }

    public org.junit.runner.Description childlessCopy() {
        return new org.junit.runner.Description(this.fTestClass, this.fDisplayName, this.fAnnotations);
    }

    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        for (java.lang.annotation.Annotation annotation : this.fAnnotations) {
            if (annotation.annotationType().equals(cls)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public java.util.Collection<java.lang.annotation.Annotation> getAnnotations() {
        return java.util.Arrays.asList(this.fAnnotations);
    }

    public java.lang.Class<?> getTestClass() {
        if (this.fTestClass != null) {
            return this.fTestClass;
        }
        java.lang.String className = getClassName();
        if (className == null) {
            return null;
        }
        try {
            this.fTestClass = java.lang.Class.forName(className, false, getClass().getClassLoader());
            return this.fTestClass;
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public java.lang.String getClassName() {
        return this.fTestClass != null ? this.fTestClass.getName() : methodAndClassNamePatternGroupOrDefault(2, toString());
    }

    public java.lang.String getMethodName() {
        return methodAndClassNamePatternGroupOrDefault(1, null);
    }

    private java.lang.String methodAndClassNamePatternGroupOrDefault(int i_renamed, java.lang.String str) {
        java.util.regex.Matcher matcher = METHOD_AND_CLASS_NAME_PATTERN.matcher(toString());
        return matcher.matches() ? matcher.group(i_renamed) : str;
    }
}
