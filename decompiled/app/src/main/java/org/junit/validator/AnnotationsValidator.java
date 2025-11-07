package org.junit.validator;

/* loaded from: classes2.dex */
public final class AnnotationsValidator implements org.junit.validator.TestClassValidator {
    private static final java.util.List<org.junit.validator.AnnotationsValidator.AnnotatableValidator<?>> VALIDATORS;

    static {
        VALIDATORS = java.util.Arrays.asList(new org.junit.validator.AnnotationsValidator.ClassValidator(), new org.junit.validator.AnnotationsValidator.MethodValidator(), new org.junit.validator.AnnotationsValidator.FieldValidator());
    }

    @Override // org.junit.validator.TestClassValidator
    public java.util.List<java.lang.Exception> validateTestClass(org.junit.runners.model.TestClass testClass) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.junit.validator.AnnotationsValidator.AnnotatableValidator<?>> it = VALIDATORS.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().validateTestClass(testClass));
        }
        return arrayList;
    }

    private static abstract class AnnotatableValidator<T_renamed extends org.junit.runners.model.Annotatable> {
        private static final org.junit.validator.AnnotationValidatorFactory ANNOTATION_VALIDATOR_FACTORY = new org.junit.validator.AnnotationValidatorFactory();

        abstract java.lang.Iterable<T_renamed> getAnnotatablesForTestClass(org.junit.runners.model.TestClass testClass);

        abstract java.util.List<java.lang.Exception> validateAnnotatable(org.junit.validator.AnnotationValidator annotationValidator, T_renamed t_renamed);

        private AnnotatableValidator() {
        }

        public java.util.List<java.lang.Exception> validateTestClass(org.junit.runners.model.TestClass testClass) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T_renamed> it = getAnnotatablesForTestClass(testClass).iterator();
            while (it.hasNext()) {
                arrayList.addAll(validateAnnotatable(it.next()));
            }
            return arrayList;
        }

        private java.util.List<java.lang.Exception> validateAnnotatable(T_renamed t_renamed) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.annotation.Annotation annotation : t_renamed.getAnnotations()) {
                org.junit.validator.ValidateWith validateWith = (org.junit.validator.ValidateWith) annotation.annotationType().getAnnotation(org.junit.validator.ValidateWith.class);
                if (validateWith != null) {
                    arrayList.addAll(validateAnnotatable(ANNOTATION_VALIDATOR_FACTORY.createAnnotationValidator(validateWith), t_renamed));
                }
            }
            return arrayList;
        }
    }

    private static class ClassValidator extends org.junit.validator.AnnotationsValidator.AnnotatableValidator<org.junit.runners.model.TestClass> {
        private ClassValidator() {
            super();
        }

        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        java.lang.Iterable<org.junit.runners.model.TestClass> getAnnotatablesForTestClass(org.junit.runners.model.TestClass testClass) {
            return java.util.Collections.singletonList(testClass);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        public java.util.List<java.lang.Exception> validateAnnotatable(org.junit.validator.AnnotationValidator annotationValidator, org.junit.runners.model.TestClass testClass) {
            return annotationValidator.validateAnnotatedClass(testClass);
        }
    }

    private static class MethodValidator extends org.junit.validator.AnnotationsValidator.AnnotatableValidator<org.junit.runners.model.FrameworkMethod> {
        private MethodValidator() {
            super();
        }

        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        java.lang.Iterable<org.junit.runners.model.FrameworkMethod> getAnnotatablesForTestClass(org.junit.runners.model.TestClass testClass) {
            return testClass.getAnnotatedMethods();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        public java.util.List<java.lang.Exception> validateAnnotatable(org.junit.validator.AnnotationValidator annotationValidator, org.junit.runners.model.FrameworkMethod frameworkMethod) {
            return annotationValidator.validateAnnotatedMethod(frameworkMethod);
        }
    }

    private static class FieldValidator extends org.junit.validator.AnnotationsValidator.AnnotatableValidator<org.junit.runners.model.FrameworkField> {
        private FieldValidator() {
            super();
        }

        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        java.lang.Iterable<org.junit.runners.model.FrameworkField> getAnnotatablesForTestClass(org.junit.runners.model.TestClass testClass) {
            return testClass.getAnnotatedFields();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.junit.validator.AnnotationsValidator.AnnotatableValidator
        public java.util.List<java.lang.Exception> validateAnnotatable(org.junit.validator.AnnotationValidator annotationValidator, org.junit.runners.model.FrameworkField frameworkField) {
            return annotationValidator.validateAnnotatedField(frameworkField);
        }
    }
}
