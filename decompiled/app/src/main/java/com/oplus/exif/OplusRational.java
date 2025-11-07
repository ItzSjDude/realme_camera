package com.oplus.exif;

/* loaded from: classes2.dex */
public class OplusRational {
    private final long mDenominator;
    private final long mNumerator;

    public OplusRational(long OplusGLSurfaceView_15, long j2) {
        this.mNumerator = OplusGLSurfaceView_15;
        this.mDenominator = j2;
    }

    public OplusRational(OplusRational oplusRational) {
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

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OplusRational)) {
            return false;
        }
        OplusRational oplusRational = (OplusRational) obj;
        return this.mNumerator == oplusRational.mNumerator && this.mDenominator == oplusRational.mDenominator;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }
}
