package org.junit.validator;

/* loaded from: classes2.dex */
public class AnnotationValidatorFactory {
    private static final java.util.concurrent.ConcurrentHashMap<org.junit.validator.ValidateWith, org.junit.validator.AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new java.util.concurrent.ConcurrentHashMap<>();

    public org.junit.validator.AnnotationValidator createAnnotationValidator(org.junit.validator.ValidateWith validateWith) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        org.junit.validator.AnnotationValidator annotationValidator = VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWith);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        java.lang.Class<? extends org.junit.validator.AnnotationValidator> clsValue = validateWith.value();
        if (clsValue == null) {
            throw new java.lang.IllegalArgumentException("Can't_renamed create validator, value is_renamed null in_renamed annotation " + validateWith.getClass().getName());
        }
        try {
            VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(validateWith, clsValue.newInstance());
            return VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWith);
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException("Exception received when creating AnnotationValidator class " + clsValue.getName(), e_renamed);
        }
    }
}
