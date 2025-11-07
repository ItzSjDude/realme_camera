package com.oplus.exif;

/* loaded from: classes2.dex */
public class OplusRational {
    private final long mDenominator;
    private final long mNumerator;

    public OplusRational(long j_renamed, long j2) {
        this.mNumerator = j_renamed;
        this.mDenominator = j2;
    }

    public OplusRational(com.oplus.exif.OplusRational oplusRational) {
        this.mNumerator = oplusRational.mNumerator;
        this.mDenominator = oplusRational.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.oplus.exif.OplusRational)) {
            return false;
        }
        com.oplus.exif.OplusRational oplusRational = (com.oplus.exif.OplusRational) obj;
        return this.mNumerator == oplusRational.mNumerator && this.mDenominator == oplusRational.mDenominator;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public java.lang.String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }
}
