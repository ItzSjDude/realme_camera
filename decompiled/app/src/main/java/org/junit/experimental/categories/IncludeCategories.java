package org.junit.experimental.categories;

/* loaded from: classes2.dex */
public final class IncludeCategories extends org.junit.experimental.categories.CategoryFilterFactory {
    @Override // org.junit.experimental.categories.CategoryFilterFactory
    protected org.junit.runner.manipulation.Filter createFilter(java.util.List<java.lang.Class<?>> list) {
        return new org.junit.experimental.categories.IncludeCategories.IncludesAny(list);
    }

    private static class IncludesAny extends org.junit.experimental.categories.Categories.CategoryFilter {
        public IncludesAny(java.util.List<java.lang.Class<?>> list) {
            this(new java.util.HashSet(list));
        }

        public IncludesAny(java.util.Set<java.lang.Class<?>> set) {
            super(true, set, true, null);
        }

        @Override // org.junit.experimental.categories.Categories.CategoryFilter, org.junit.runner.manipulation.Filter
        public java.lang.String describe() {
            return "includes " + super.describe();
        }
    }
}
