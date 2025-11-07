package org.junit.internal;

/* loaded from: classes2.dex */
public class ExactComparisonCriteria extends org.junit.internal.ComparisonCriteria {
    @Override // org.junit.internal.ComparisonCriteria
    protected void assertElementsEqual(java.lang.Object obj, java.lang.Object obj2) {
        org.junit.Assert.assertEquals(obj, obj2);
    }
}
