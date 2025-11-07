package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public interface SeekMap {
    long getDurationUs();

    com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed);

    boolean isSeekable();

    public static final class Unseekable implements com.google.android.exoplayer2.extractor.SeekMap {
        private final long durationUs;
        private final com.google.android.exoplayer2.extractor.SeekMap.SeekPoints startSeekPoints;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j_renamed) {
            this(j_renamed, 0L);
        }

        public Unseekable(long j_renamed, long j2) {
            this.durationUs = j_renamed;
            this.startSeekPoints = new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(j2 == 0 ? com.google.android.exoplayer2.extractor.SeekPoint.START : new com.google.android.exoplayer2.extractor.SeekPoint(0L, j2));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
            return this.startSeekPoints;
        }
    }

    public static final class SeekPoints {
        public final com.google.android.exoplayer2.extractor.SeekPoint first;
        public final com.google.android.exoplayer2.extractor.SeekPoint second;

        public SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint seekPoint, com.google.android.exoplayer2.extractor.SeekPoint seekPoint2) {
            this.first = (com.google.android.exoplayer2.extractor.SeekPoint) com.google.android.exoplayer2.util.Assertions.checkNotNull(seekPoint);
            this.second = (com.google.android.exoplayer2.extractor.SeekPoint) com.google.android.exoplayer2.util.Assertions.checkNotNull(seekPoint2);
        }

        public java.lang.String toString() {
            java.lang.String str;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[");
            sb.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = ", " + this.second;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.extractor.SeekMap.SeekPoints seekPoints = (com.google.android.exoplayer2.extractor.SeekMap.SeekPoints) obj;
            return this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }
    }
}
