package org.junit.internal;

/* loaded from: classes2.dex */
public class MethodSorter {
    public static final java.util.Comparator<java.lang.reflect.Method> DEFAULT = new java.util.Comparator<java.lang.reflect.Method>() { // from class: org.junit.internal.MethodSorter.1
        @Override // java.util.Comparator
        public int compare(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
            int iHashCode = method.getName().hashCode();
            int iHashCode2 = method2.getName().hashCode();
            if (iHashCode != iHashCode2) {
                return iHashCode < iHashCode2 ? -1 : 1;
            }
            return org.junit.internal.MethodSorter.NAME_ASCENDING.compare(method, method2);
        }
    };
    public static final java.util.Comparator<java.lang.reflect.Method> NAME_ASCENDING = new java.util.Comparator<java.lang.reflect.Method>() { // from class: org.junit.internal.MethodSorter.2
        @Override // java.util.Comparator
        public int compare(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            return iCompareTo != 0 ? iCompareTo : method.toString().compareTo(method2.toString());
        }
    };

    public static java.lang.reflect.Method[] getDeclaredMethods(java.lang.Class<?> cls) throws java.lang.SecurityException {
        java.util.Comparator<java.lang.reflect.Method> sorter = getSorter((org.junit.FixMethodOrder) cls.getAnnotation(org.junit.FixMethodOrder.class));
        java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
        if (sorter != null) {
            java.util.Arrays.sort(declaredMethods, sorter);
        }
        return declaredMethods;
    }

    private MethodSorter() {
    }

    private static java.util.Comparator<java.lang.reflect.Method> getSorter(org.junit.FixMethodOrder fixMethodOrder) {
        if (fixMethodOrder == null) {
            return DEFAULT;
        }
        return fixMethodOrder.value().getComparator();
    }
}
