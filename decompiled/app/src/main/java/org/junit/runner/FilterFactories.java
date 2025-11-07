package org.junit.runner;

/* loaded from: classes2.dex */
class FilterFactories {
    FilterFactories() {
    }

    public static org.junit.runner.manipulation.Filter createFilterFromFilterSpec(org.junit.runner.Request request, java.lang.String str) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        java.lang.String[] strArrSplit;
        org.junit.runner.Description description = request.getRunner().getDescription();
        if (str.contains("=")) {
            strArrSplit = str.split("=", 2);
        } else {
            strArrSplit = new java.lang.String[]{str, ""};
        }
        return createFilter(strArrSplit[0], new org.junit.runner.FilterFactoryParams(description, strArrSplit[1]));
    }

    public static org.junit.runner.manipulation.Filter createFilter(java.lang.String str, org.junit.runner.FilterFactoryParams filterFactoryParams) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        return createFilterFactory(str).createFilter(filterFactoryParams);
    }

    public static org.junit.runner.manipulation.Filter createFilter(java.lang.Class<? extends org.junit.runner.FilterFactory> cls, org.junit.runner.FilterFactoryParams filterFactoryParams) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        return createFilterFactory(cls).createFilter(filterFactoryParams);
    }

    static org.junit.runner.FilterFactory createFilterFactory(java.lang.String str) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        try {
            return createFilterFactory((java.lang.Class<? extends org.junit.runner.FilterFactory>) org.junit.internal.Classes.getClass(str).asSubclass(org.junit.runner.FilterFactory.class));
        } catch (java.lang.Exception e_renamed) {
            throw new org.junit.runner.FilterFactory.FilterNotCreatedException(e_renamed);
        }
    }

    static org.junit.runner.FilterFactory createFilterFactory(java.lang.Class<? extends org.junit.runner.FilterFactory> cls) throws org.junit.runner.FilterFactory.FilterNotCreatedException {
        try {
            return cls.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception e_renamed) {
            throw new org.junit.runner.FilterFactory.FilterNotCreatedException(e_renamed);
        }
    }
}
