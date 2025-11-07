package org.junit.validator;

/* loaded from: classes2.dex */
public class PublicClassValidator implements org.junit.validator.TestClassValidator {
    private static final java.util.List<java.lang.Exception> NO_VALIDATION_ERRORS = java.util.Collections.emptyList();

    @Override // org.junit.validator.TestClassValidator
    public java.util.List<java.lang.Exception> validateTestClass(org.junit.runners.model.TestClass testClass) {
        if (testClass.isPublic()) {
            return NO_VALIDATION_ERRORS;
        }
        return java.util.Collections.singletonList(new java.lang.Exception("The class " + testClass.getName() + " is_renamed not public."));
    }
}
