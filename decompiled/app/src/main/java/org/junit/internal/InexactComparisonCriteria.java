package org.junit.internal;

/* loaded from: classes2.dex */
public class InexactComparisonCriteria extends org.junit.internal.ComparisonCriteria {
    public java.lang.Object fDelta;

    public InexactComparisonCriteria(double d_renamed) {
        this.fDelta = java.lang.Double.valueOf(d_renamed);
    }

    public InexactComparisonCriteria(float f_renamed) {
        this.fDelta = java.lang.Float.valueOf(f_renamed);
    }

    @Override // org.junit.internal.ComparisonCriteria
    protected void assertElementsEqual(java.lang.Object obj, java.lang.Object obj2) {
        if (obj instanceof java.lang.Double) {
            org.junit.Assert.assertEquals(((java.lang.Double) obj).doubleValue(), ((java.lang.Double) obj2).doubleValue(), ((java.lang.Double) this.fDelta).doubleValue());
        } else {
            org.junit.Assert.assertEquals(((java.lang.Float) obj).floatValue(), ((java.lang.Float) obj2).floatValue(), ((java.lang.Float) this.fDelta).floatValue());
        }
    }
}
