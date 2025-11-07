package org.junit.runner.manipulation;

/* loaded from: classes2.dex */
public class Sorter implements java.util.Comparator<org.junit.runner.Description> {
    public static final org.junit.runner.manipulation.Sorter NULL = new org.junit.runner.manipulation.Sorter(new java.util.Comparator<org.junit.runner.Description>() { // from class: org.junit.runner.manipulation.Sorter.1
        @Override // java.util.Comparator
        public int compare(org.junit.runner.Description description, org.junit.runner.Description description2) {
            return 0;
        }
    });
    private final java.util.Comparator<org.junit.runner.Description> comparator;

    public Sorter(java.util.Comparator<org.junit.runner.Description> comparator) {
        this.comparator = comparator;
    }

    public void apply(java.lang.Object obj) {
        if (obj instanceof org.junit.runner.manipulation.Sortable) {
            ((org.junit.runner.manipulation.Sortable) obj).sort(this);
        }
    }

    @Override // java.util.Comparator
    public int compare(org.junit.runner.Description description, org.junit.runner.Description description2) {
        return this.comparator.compare(description, description2);
    }
}
