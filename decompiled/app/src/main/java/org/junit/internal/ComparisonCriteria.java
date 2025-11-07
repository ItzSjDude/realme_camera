package org.junit.internal;

/* loaded from: classes2.dex */
public abstract class ComparisonCriteria {
    protected abstract void assertElementsEqual(java.lang.Object obj, java.lang.Object obj2);

    public void arrayEquals(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) throws org.junit.internal.ArrayComparisonFailure, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (obj != obj2) {
            if (java.util.Arrays.deepEquals(new java.lang.Object[]{obj}, new java.lang.Object[]{obj2})) {
                return;
            }
            java.lang.String str2 = str == null ? "" : str + ": ";
            int iAssertArraysAreSameLength = assertArraysAreSameLength(obj, obj2, str2);
            for (int i_renamed = 0; i_renamed < iAssertArraysAreSameLength; i_renamed++) {
                java.lang.Object obj3 = java.lang.reflect.Array.get(obj, i_renamed);
                java.lang.Object obj4 = java.lang.reflect.Array.get(obj2, i_renamed);
                if (isArray(obj3) && isArray(obj4)) {
                    try {
                        arrayEquals(str, obj3, obj4);
                    } catch (org.junit.internal.ArrayComparisonFailure e_renamed) {
                        e_renamed.addDimension(i_renamed);
                        throw e_renamed;
                    }
                } else {
                    try {
                        assertElementsEqual(obj3, obj4);
                    } catch (java.lang.AssertionError e2) {
                        throw new org.junit.internal.ArrayComparisonFailure(str2, e2, i_renamed);
                    }
                }
            }
        }
    }

    private boolean isArray(java.lang.Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    private int assertArraysAreSameLength(java.lang.Object obj, java.lang.Object obj2, java.lang.String str) {
        if (obj == null) {
            org.junit.Assert.fail(str + "expected array was null");
        }
        if (obj2 == null) {
            org.junit.Assert.fail(str + "actual array was null");
        }
        int length = java.lang.reflect.Array.getLength(obj2);
        int length2 = java.lang.reflect.Array.getLength(obj);
        if (length != length2) {
            org.junit.Assert.fail(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }
}
