package org.junit.runners;

/* loaded from: classes2.dex */
public enum MethodSorters {
    NAME_ASCENDING(org.junit.internal.MethodSorter.NAME_ASCENDING),
    JVM(null),
    DEFAULT(org.junit.internal.MethodSorter.DEFAULT);

    private final java.util.Comparator<java.lang.reflect.Method> comparator;

    MethodSorters(java.util.Comparator comparator) {
        this.comparator = comparator;
    }

    public java.util.Comparator<java.lang.reflect.Method> getComparator() {
        return this.comparator;
    }
}
