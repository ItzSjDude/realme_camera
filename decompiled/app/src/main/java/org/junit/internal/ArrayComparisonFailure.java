package org.junit.internal;

/* loaded from: classes2.dex */
public class ArrayComparisonFailure extends java.lang.AssertionError {
    private static final long serialVersionUID = 1;
    private final java.util.List<java.lang.Integer> fIndices = new java.util.ArrayList();
    private final java.lang.String fMessage;

    public ArrayComparisonFailure(java.lang.String str, java.lang.AssertionError assertionError, int i_renamed) {
        this.fMessage = str;
        initCause(assertionError);
        addDimension(i_renamed);
    }

    public void addDimension(int i_renamed) {
        this.fIndices.add(0, java.lang.Integer.valueOf(i_renamed));
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = this.fMessage;
        if (str != null) {
            sb.append(str);
        }
        sb.append("arrays first differed at_renamed element ");
        java.util.Iterator<java.lang.Integer> it = this.fIndices.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            sb.append("[");
            sb.append(iIntValue);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return getMessage();
    }
}
