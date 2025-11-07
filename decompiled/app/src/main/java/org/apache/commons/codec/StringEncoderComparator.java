package org.apache.commons.codec;

/* loaded from: classes2.dex */
public class StringEncoderComparator implements java.util.Comparator {
    private final org.apache.commons.codec.StringEncoder stringEncoder;

    public StringEncoderComparator() {
        this.stringEncoder = null;
    }

    public StringEncoderComparator(org.apache.commons.codec.StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        try {
            return ((java.lang.Comparable) this.stringEncoder.encode(obj)).compareTo((java.lang.Comparable) this.stringEncoder.encode(obj2));
        } catch (org.apache.commons.codec.EncoderException unused) {
            return 0;
        }
    }
}
