package org.junit.experimental.categories;

/* loaded from: classes2.dex */
abstract class CategoryFilterFactory implements org.junit.runner.FilterFactory {
    protected abstract org.junit.runner.manipulation.Filter createFilter(java.util.List<java.lang.Class<?>> list);

    CategoryFilterFactory() {
    }

    @Override // org.junit.runner.FilterFactory
    public org.junit.runner.manipulation.Filter createFilter(org.junit.runner.FilterFactoryParams filterFactoryParams) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        try {
            return createFilter(parseCategories(filterFactoryParams.getArgs()));
        } catch (java.lang.ClassNotFoundException e_renamed) {
            throw new org.junit.runner.FilterFactory.FilterNotCreatedException(e_renamed);
        }
    }

    private java.util.List<java.lang.Class<?>> parseCategories(java.lang.String str) throws java.lang.ClassNotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : str.split(",")) {
            arrayList.add(org.junit.internal.Classes.getClass(str2));
        }
        return arrayList;
    }
}
