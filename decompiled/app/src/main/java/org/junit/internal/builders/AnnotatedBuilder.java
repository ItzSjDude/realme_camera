package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class AnnotatedBuilder extends org.junit.runners.model.RunnerBuilder {
    private static final java.lang.String CONSTRUCTOR_ERROR_FORMAT = "Custom runner class %s_renamed should have a_renamed public constructor with signature %s_renamed(Class testClass)";
    private final org.junit.runners.model.RunnerBuilder suiteBuilder;

    public AnnotatedBuilder(org.junit.runners.model.RunnerBuilder runnerBuilder) {
        this.suiteBuilder = runnerBuilder;
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Exception {
        java.lang.Class<?> enclosingClassForNonStaticMemberClass = cls;
        while (enclosingClassForNonStaticMemberClass != null) {
            org.junit.runner.RunWith runWith = (org.junit.runner.RunWith) enclosingClassForNonStaticMemberClass.getAnnotation(org.junit.runner.RunWith.class);
            if (runWith == null) {
                enclosingClassForNonStaticMemberClass = getEnclosingClassForNonStaticMemberClass(enclosingClassForNonStaticMemberClass);
            } else {
                return buildRunner(runWith.value(), cls);
            }
        }
        return null;
    }

    private java.lang.Class<?> getEnclosingClassForNonStaticMemberClass(java.lang.Class<?> cls) {
        if (!cls.isMemberClass() || java.lang.reflect.Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public org.junit.runner.Runner buildRunner(java.lang.Class<? extends org.junit.runner.Runner> cls, java.lang.Class<?> cls2) throws java.lang.Exception {
        try {
            return cls.getConstructor(java.lang.Class.class).newInstance(cls2);
        } catch (java.lang.NoSuchMethodException unused) {
            try {
                return cls.getConstructor(java.lang.Class.class, org.junit.runners.model.RunnerBuilder.class).newInstance(cls2, this.suiteBuilder);
            } catch (java.lang.NoSuchMethodException unused2) {
                java.lang.String simpleName = cls.getSimpleName();
                throw new org.junit.runners.model.InitializationError(java.lang.String.format(CONSTRUCTOR_ERROR_FORMAT, simpleName, simpleName));
            }
        }
    }
}
