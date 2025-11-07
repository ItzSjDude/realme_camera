package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class SeekParameters {
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;
    public static final com.google.android.exoplayer2.SeekParameters EXACT = new com.google.android.exoplayer2.SeekParameters(0, 0);
    public static final com.google.android.exoplayer2.SeekParameters CLOSEST_SYNC = new com.google.android.exoplayer2.SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final com.google.android.exoplayer2.SeekParameters PREVIOUS_SYNC = new com.google.android.exoplayer2.SeekParameters(Long.MAX_VALUE, 0);
    public static final com.google.android.exoplayer2.SeekParameters NEXT_SYNC = new com.google.android.exoplayer2.SeekParameters(0, Long.MAX_VALUE);
    public static final com.google.android.exoplayer2.SeekParameters DEFAULT = EXACT;

    public SeekParameters(long j_renamed, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 >= 0);
        this.toleranceBeforeUs = j_renamed;
        this.toleranceAfterUs = j2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.SeekParameters seekParameters = (com.google.android.exoplayer2.SeekParameters) obj;
        return this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }
}
