package org.junit.experimental.categories;

/* loaded from: classes2.dex */
public final class CategoryValidator extends org.junit.validator.AnnotationValidator {
    private static final java.util.Set<java.lang.Class<? extends java.lang.annotation.Annotation>> INCOMPATIBLE_ANNOTATIONS = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(org.junit.BeforeClass.class, org.junit.AfterClass.class, org.junit.Before.class, org.junit.After.class)));

    @Override // org.junit.validator.AnnotationValidator
    public java.util.List<java.lang.Exception> validateAnnotatedMethod(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.annotation.Annotation annotation : frameworkMethod.getAnnotations()) {
            for (java.lang.Class<? extends java.lang.annotation.Annotation> cls : INCOMPATIBLE_ANNOTATIONS) {
                if (annotation.annotationType().isAssignableFrom(cls)) {
                    addErrorMessage(arrayList, cls);
                }
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    private void addErrorMessage(java.util.List<java.lang.Exception> list, java.lang.Class<?> cls) {
        list.add(new java.lang.Exception(java.lang.String.format("@%s_renamed can not be_renamed combined with @Category", cls.getSimpleName())));
    }
}
