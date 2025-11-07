package org.junit.validator;

/* loaded from: classes2.dex */
public abstract class AnnotationValidator {
    private static final java.util.List<java.lang.Exception> NO_VALIDATION_ERRORS = java.util.Collections.emptyList();

    public java.util.List<java.lang.Exception> validateAnnotatedClass(org.junit.runners.model.TestClass testClass) {
        return NO_VALIDATION_ERRORS;
    }

    public java.util.List<java.lang.Exception> validateAnnotatedField(org.junit.runners.model.FrameworkField frameworkField) {
        return NO_VALIDATION_ERRORS;
    }

    public java.util.List<java.lang.Exception> validateAnnotatedMethod(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        return NO_VALIDATION_ERRORS;
    }
}
