package org.junit.runner;

/* loaded from: classes2.dex */
public interface FilterFactory {
    org.junit.runner.manipulation.Filter createFilter(org.junit.runner.FilterFactoryParams filterFactoryParams) throws org.junit.runner.FilterFactory.FilterNotCreatedException;

    public static class FilterNotCreatedException extends java.lang.Exception {
        public FilterNotCreatedException(java.lang.Exception exc) {
            super(exc.getMessage(), exc);
        }
    }
}
