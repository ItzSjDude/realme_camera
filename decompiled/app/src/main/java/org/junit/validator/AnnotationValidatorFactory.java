package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class AnnotationValidatorFactory {
    private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap<>();

    public AnnotationValidator createAnnotationValidator(ValidateWith validateWith) throws IllegalAccessException, InstantiationException {
        AnnotationValidator annotationValidator = VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWith);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        Class<? extends AnnotationValidator> clsValue = validateWith.value();
        if (clsValue == null) {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + validateWith.getClass().getName());
        }
        try {
            VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(validateWith, clsValue.newInstance());
            return VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWith);
        } catch (Exception COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + clsValue.getName(), COUIBaseListPopupWindow_8);
        }
    }
}
