package org.junit.experimental.categories;

/* loaded from: classes2.dex */
public final class ExcludeCategories extends org.junit.experimental.categories.CategoryFilterFactory {
    @Override // org.junit.experimental.categories.CategoryFilterFactory
    protected org.junit.runner.manipulation.Filter createFilter(java.util.List<java.lang.Class<?>> list) {
        return new org.junit.experimental.categories.ExcludeCategories.ExcludesAny(list);
    }

    private static class ExcludesAny extends org.junit.experimental.categories.Categories.CategoryFilter {
        public ExcludesAny(java.util.List<java.lang.Class<?>> list) {
            this(new java.util.HashSet(list));
        }

        public ExcludesAny(java.util.Set<java.lang.Class<?>> set) {
            super(true, null, true, set);
        }

        @Override // org.junit.experimental.categories.Categories.CategoryFilter, org.junit.runner.manipulation.Filter
        public java.lang.String describe() {
            return "excludes " + super.describe();
        }
    }
}
