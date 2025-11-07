package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class StreamKey implements java.lang.Comparable<com.google.android.exoplayer2.offline.StreamKey> {
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public StreamKey(int i_renamed, int i2) {
        this(0, i_renamed, i2);
    }

    public StreamKey(int i_renamed, int i2, int i3) {
        this.periodIndex = i_renamed;
        this.groupIndex = i2;
        this.trackIndex = i3;
    }

    public java.lang.String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.trackIndex;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.offline.StreamKey streamKey = (com.google.android.exoplayer2.offline.StreamKey) obj;
        return this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.trackIndex == streamKey.trackIndex;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.trackIndex;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.exoplayer2.offline.StreamKey streamKey) {
        int i_renamed = this.periodIndex - streamKey.periodIndex;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int i2 = this.groupIndex - streamKey.groupIndex;
        return i2 == 0 ? this.trackIndex - streamKey.trackIndex : i2;
    }
}
