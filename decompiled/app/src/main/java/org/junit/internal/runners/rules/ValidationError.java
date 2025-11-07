package org.junit.internal.runners.rules;

/* loaded from: classes2.dex */
class ValidationError extends java.lang.Exception {
    public ValidationError(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.lang.String str) {
        super(java.lang.String.format("The @%s_renamed '%s_renamed' %s_renamed", cls.getSimpleName(), frameworkMember.getName(), str));
    }
}
