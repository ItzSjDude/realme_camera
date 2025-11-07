package org.junit.internal.runners.rules;

/* loaded from: classes2.dex */
public class RuleMemberValidator {
    public static final org.junit.internal.runners.rules.RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR;
    public static final org.junit.internal.runners.rules.RuleMemberValidator CLASS_RULE_VALIDATOR;
    public static final org.junit.internal.runners.rules.RuleMemberValidator RULE_METHOD_VALIDATOR;
    public static final org.junit.internal.runners.rules.RuleMemberValidator RULE_VALIDATOR;
    private final java.lang.Class<? extends java.lang.annotation.Annotation> annotation;
    private final boolean methods;
    private final java.util.List<org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator> validatorStrategies;

    interface RuleValidator {
        void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list);
    }

    static {
        CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.DeclaringClassMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeStatic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.FieldMustBeATestRule()).build();
        RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.FieldMustBeARule()).build();
        CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.DeclaringClassMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeStatic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MethodMustBeATestRule()).build();
        RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBePublic()).withValidator(new org.junit.internal.runners.rules.RuleMemberValidator.MethodMustBeARule()).build();
    }

    RuleMemberValidator(org.junit.internal.runners.rules.RuleMemberValidator.Builder builder) {
        this.annotation = builder.annotation;
        this.methods = builder.methods;
        this.validatorStrategies = builder.validators;
    }

    public void validate(org.junit.runners.model.TestClass testClass, java.util.List<java.lang.Throwable> list) {
        java.util.Iterator it = (this.methods ? testClass.getAnnotatedMethods(this.annotation) : testClass.getAnnotatedFields(this.annotation)).iterator();
        while (it.hasNext()) {
            validateMember((org.junit.runners.model.FrameworkMember) it.next(), list);
        }
    }

    private void validateMember(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.util.List<java.lang.Throwable> list) {
        java.util.Iterator<org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator> it = this.validatorStrategies.iterator();
        while (it.hasNext()) {
            it.next().validate(frameworkMember, this.annotation, list);
        }
    }

    private static org.junit.internal.runners.rules.RuleMemberValidator.Builder classRuleValidatorBuilder() {
        return new org.junit.internal.runners.rules.RuleMemberValidator.Builder(org.junit.ClassRule.class);
    }

    private static org.junit.internal.runners.rules.RuleMemberValidator.Builder testRuleValidatorBuilder() {
        return new org.junit.internal.runners.rules.RuleMemberValidator.Builder(org.junit.Rule.class);
    }

    private static class Builder {
        private final java.lang.Class<? extends java.lang.annotation.Annotation> annotation;
        private boolean methods;
        private final java.util.List<org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator> validators;

        private Builder(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
            this.annotation = cls;
            this.methods = false;
            this.validators = new java.util.ArrayList();
        }

        org.junit.internal.runners.rules.RuleMemberValidator.Builder forMethods() {
            this.methods = true;
            return this;
        }

        org.junit.internal.runners.rules.RuleMemberValidator.Builder withValidator(org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator ruleValidator) {
            this.validators.add(ruleValidator);
            return this;
        }

        org.junit.internal.runners.rules.RuleMemberValidator build() {
            return new org.junit.internal.runners.rules.RuleMemberValidator(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRuleType(org.junit.runners.model.FrameworkMember<?> frameworkMember) {
        return isMethodRule(frameworkMember) || isTestRule(frameworkMember);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTestRule(org.junit.runners.model.FrameworkMember<?> frameworkMember) {
        return org.junit.rules.TestRule.class.isAssignableFrom(frameworkMember.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMethodRule(org.junit.runners.model.FrameworkMember<?> frameworkMember) {
        return org.junit.rules.MethodRule.class.isAssignableFrom(frameworkMember.getType());
    }

    private static final class MemberMustBeNonStaticOrAlsoClassRule implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private MemberMustBeNonStaticOrAlsoClassRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            boolean zIsMethodRule = org.junit.internal.runners.rules.RuleMemberValidator.isMethodRule(frameworkMember);
            boolean z_renamed = frameworkMember.getAnnotation(org.junit.ClassRule.class) != null;
            if (frameworkMember.isStatic()) {
                if (zIsMethodRule || !z_renamed) {
                    list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, org.junit.internal.runners.rules.RuleMemberValidator.isMethodRule(frameworkMember) ? "must not be_renamed static." : "must not be_renamed static or it must be_renamed annotated with @ClassRule."));
                }
            }
        }
    }

    private static final class MemberMustBeStatic implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private MemberMustBeStatic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (frameworkMember.isStatic()) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must be_renamed static."));
        }
    }

    private static final class DeclaringClassMustBePublic implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private DeclaringClassMustBePublic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (isDeclaringClassPublic(frameworkMember)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must be_renamed declared in_renamed a_renamed public class."));
        }

        private boolean isDeclaringClassPublic(org.junit.runners.model.FrameworkMember<?> frameworkMember) {
            return java.lang.reflect.Modifier.isPublic(frameworkMember.getDeclaringClass().getModifiers());
        }
    }

    private static final class MemberMustBePublic implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private MemberMustBePublic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (frameworkMember.isPublic()) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must be_renamed public."));
        }
    }

    private static final class FieldMustBeARule implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private FieldMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (org.junit.internal.runners.rules.RuleMemberValidator.isRuleType(frameworkMember)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must implement MethodRule or TestRule."));
        }
    }

    private static final class MethodMustBeARule implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private MethodMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (org.junit.internal.runners.rules.RuleMemberValidator.isRuleType(frameworkMember)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must return an_renamed implementation of_renamed MethodRule or TestRule."));
        }
    }

    private static final class MethodMustBeATestRule implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private MethodMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (org.junit.internal.runners.rules.RuleMemberValidator.isTestRule(frameworkMember)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must return an_renamed implementation of_renamed TestRule."));
        }
    }

    private static final class FieldMustBeATestRule implements org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator {
        private FieldMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(org.junit.runners.model.FrameworkMember<?> frameworkMember, java.lang.Class<? extends java.lang.annotation.Annotation> cls, java.util.List<java.lang.Throwable> list) {
            if (org.junit.internal.runners.rules.RuleMemberValidator.isTestRule(frameworkMember)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.ValidationError(frameworkMember, cls, "must implement TestRule."));
        }
    }
}
