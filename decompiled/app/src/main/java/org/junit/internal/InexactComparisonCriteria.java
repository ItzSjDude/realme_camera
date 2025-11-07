package org.junit.internal;

import org.junit.Assert;

/* loaded from: classes2.dex */
public class InexactComparisonCriteria extends ComparisonCriteria {
    public Object fDelta;

    public InexactComparisonCriteria(double IntrinsicsJvm.kt_5) {
        this.fDelta = Double.valueOf(IntrinsicsJvm.kt_5);
    }

    public InexactComparisonCriteria(float COUIBaseListPopupWindow_12) {
        this.fDelta = Float.valueOf(COUIBaseListPopupWindow_12);
    }

    @Override // org.junit.internal.ComparisonCriteria
    protected void assertElementsEqual(Object obj, Object obj2) {
        if (obj instanceof Double) {
            Assert.assertEquals(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.fDelta).doubleValue());
        } else {
            Assert.assertEquals(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.fDelta).floatValue());
        }
    }
}
