package org.junit.experimental.categories;

/* loaded from: classes2.dex */
public class Categories extends org.junit.runners.Suite {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface ExcludeCategory {
        boolean matchAny() default true;

        java.lang.Class<?>[] value() default {};
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface IncludeCategory {
        boolean matchAny() default true;

        java.lang.Class<?>[] value() default {};
    }

    public static class CategoryFilter extends org.junit.runner.manipulation.Filter {
        private final java.util.Set<java.lang.Class<?>> excluded;
        private final boolean excludedAny;
        private final java.util.Set<java.lang.Class<?>> included;
        private final boolean includedAny;

        public static org.junit.experimental.categories.Categories.CategoryFilter include(boolean z_renamed, java.lang.Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(z_renamed, org.junit.experimental.categories.Categories.createSet(clsArr), true, null);
            }
            throw new java.lang.NullPointerException("has null category");
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter include(java.lang.Class<?> cls) {
            return include(true, cls);
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter include(java.lang.Class<?>... clsArr) {
            return include(true, clsArr);
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter exclude(boolean z_renamed, java.lang.Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(true, null, z_renamed, org.junit.experimental.categories.Categories.createSet(clsArr));
            }
            throw new java.lang.NullPointerException("has null category");
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter exclude(java.lang.Class<?> cls) {
            return exclude(true, cls);
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter exclude(java.lang.Class<?>... clsArr) {
            return exclude(true, clsArr);
        }

        public static org.junit.experimental.categories.Categories.CategoryFilter categoryFilter(boolean z_renamed, java.util.Set<java.lang.Class<?>> set, boolean z2, java.util.Set<java.lang.Class<?>> set2) {
            return new org.junit.experimental.categories.Categories.CategoryFilter(z_renamed, set, z2, set2);
        }

        protected CategoryFilter(boolean z_renamed, java.util.Set<java.lang.Class<?>> set, boolean z2, java.util.Set<java.lang.Class<?>> set2) {
            this.includedAny = z_renamed;
            this.excludedAny = z2;
            this.included = copyAndRefine(set);
            this.excluded = copyAndRefine(set2);
        }

        @Override // org.junit.runner.manipulation.Filter
        public java.lang.String describe() {
            return toString();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("categories ");
            sb.append(this.included.isEmpty() ? "[all]" : this.included);
            if (!this.excluded.isEmpty()) {
                sb.append(" - ");
                sb.append(this.excluded);
            }
            return sb.toString();
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(org.junit.runner.Description description) {
            if (hasCorrectCategoryAnnotation(description)) {
                return true;
            }
            java.util.Iterator<org.junit.runner.Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (shouldRun(it.next())) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasCorrectCategoryAnnotation(org.junit.runner.Description description) {
            java.util.Set<java.lang.Class<?>> setCategories = categories(description);
            if (setCategories.isEmpty()) {
                return this.included.isEmpty();
            }
            if (!this.excluded.isEmpty()) {
                if (this.excludedAny) {
                    if (matchesAnyParentCategories(setCategories, this.excluded)) {
                        return false;
                    }
                } else if (matchesAllParentCategories(setCategories, this.excluded)) {
                    return false;
                }
            }
            if (this.included.isEmpty()) {
                return true;
            }
            if (this.includedAny) {
                return matchesAnyParentCategories(setCategories, this.included);
            }
            return matchesAllParentCategories(setCategories, this.included);
        }

        private boolean matchesAnyParentCategories(java.util.Set<java.lang.Class<?>> set, java.util.Set<java.lang.Class<?>> set2) {
            java.util.Iterator<java.lang.Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (org.junit.experimental.categories.Categories.hasAssignableTo(set, it.next())) {
                    return true;
                }
            }
            return false;
        }

        private boolean matchesAllParentCategories(java.util.Set<java.lang.Class<?>> set, java.util.Set<java.lang.Class<?>> set2) {
            java.util.Iterator<java.lang.Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (!org.junit.experimental.categories.Categories.hasAssignableTo(set, it.next())) {
                    return false;
                }
            }
            return true;
        }

        private static java.util.Set<java.lang.Class<?>> categories(org.junit.runner.Description description) {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.Collections.addAll(hashSet, directCategories(description));
            java.util.Collections.addAll(hashSet, directCategories(parentDescription(description)));
            return hashSet;
        }

        private static org.junit.runner.Description parentDescription(org.junit.runner.Description description) {
            java.lang.Class<?> testClass = description.getTestClass();
            if (testClass == null) {
                return null;
            }
            return org.junit.runner.Description.createSuiteDescription(testClass);
        }

        private static java.lang.Class<?>[] directCategories(org.junit.runner.Description description) {
            if (description == null) {
                return new java.lang.Class[0];
            }
            org.junit.experimental.categories.Category category = (org.junit.experimental.categories.Category) description.getAnnotation(org.junit.experimental.categories.Category.class);
            return category == null ? new java.lang.Class[0] : category.value();
        }

        private static java.util.Set<java.lang.Class<?>> copyAndRefine(java.util.Set<java.lang.Class<?>> set) {
            java.util.HashSet hashSet = new java.util.HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove(null);
            return hashSet;
        }

        private static boolean hasNull(java.lang.Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (java.lang.Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public Categories(java.lang.Class<?> cls, org.junit.runners.model.RunnerBuilder runnerBuilder) throws org.junit.runners.model.InitializationError {
        super(cls, runnerBuilder);
        try {
            filter(org.junit.experimental.categories.Categories.CategoryFilter.categoryFilter(isAnyIncluded(cls), getIncludedCategory(cls), isAnyExcluded(cls), getExcludedCategory(cls)));
            assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
        } catch (org.junit.runner.manipulation.NoTestsRemainException e_renamed) {
            throw new org.junit.runners.model.InitializationError(e_renamed);
        }
    }

    private static java.util.Set<java.lang.Class<?>> getIncludedCategory(java.lang.Class<?> cls) {
        org.junit.experimental.categories.Categories.IncludeCategory includeCategory = (org.junit.experimental.categories.Categories.IncludeCategory) cls.getAnnotation(org.junit.experimental.categories.Categories.IncludeCategory.class);
        return createSet(includeCategory == null ? null : includeCategory.value());
    }

    private static boolean isAnyIncluded(java.lang.Class<?> cls) {
        org.junit.experimental.categories.Categories.IncludeCategory includeCategory = (org.junit.experimental.categories.Categories.IncludeCategory) cls.getAnnotation(org.junit.experimental.categories.Categories.IncludeCategory.class);
        return includeCategory == null || includeCategory.matchAny();
    }

    private static java.util.Set<java.lang.Class<?>> getExcludedCategory(java.lang.Class<?> cls) {
        org.junit.experimental.categories.Categories.ExcludeCategory excludeCategory = (org.junit.experimental.categories.Categories.ExcludeCategory) cls.getAnnotation(org.junit.experimental.categories.Categories.ExcludeCategory.class);
        return createSet(excludeCategory == null ? null : excludeCategory.value());
    }

    private static boolean isAnyExcluded(java.lang.Class<?> cls) {
        org.junit.experimental.categories.Categories.ExcludeCategory excludeCategory = (org.junit.experimental.categories.Categories.ExcludeCategory) cls.getAnnotation(org.junit.experimental.categories.Categories.ExcludeCategory.class);
        return excludeCategory == null || excludeCategory.matchAny();
    }

    private static void assertNoCategorizedDescendentsOfUncategorizeableParents(org.junit.runner.Description description) throws org.junit.runners.model.InitializationError {
        if (!canHaveCategorizedChildren(description)) {
            assertNoDescendantsHaveCategoryAnnotations(description);
        }
        java.util.Iterator<org.junit.runner.Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            assertNoCategorizedDescendentsOfUncategorizeableParents(it.next());
        }
    }

    private static void assertNoDescendantsHaveCategoryAnnotations(org.junit.runner.Description description) throws org.junit.runners.model.InitializationError {
        java.util.Iterator<org.junit.runner.Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            org.junit.runner.Description next = it.next();
            if (next.getAnnotation(org.junit.experimental.categories.Category.class) != null) {
                throw new org.junit.runners.model.InitializationError("Category annotations on_renamed Parameterized classes are not supported on_renamed individual methods.");
            }
            assertNoDescendantsHaveCategoryAnnotations(next);
        }
    }

    private static boolean canHaveCategorizedChildren(org.junit.runner.Description description) {
        java.util.Iterator<org.junit.runner.Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().getTestClass() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasAssignableTo(java.util.Set<java.lang.Class<?>> set, java.lang.Class<?> cls) {
        java.util.Iterator<java.lang.Class<?>> it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.Set<java.lang.Class<?>> createSet(java.lang.Class<?>... clsArr) {
        java.util.HashSet hashSet = new java.util.HashSet();
        if (clsArr != null) {
            java.util.Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }
}
