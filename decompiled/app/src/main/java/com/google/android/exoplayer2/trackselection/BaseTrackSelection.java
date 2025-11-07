package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public abstract class BaseTrackSelection implements com.google.android.exoplayer2.trackselection.TrackSelection {
    private final long[] blacklistUntilTimes;
    private final com.google.android.exoplayer2.Format[] formats;
    protected final com.google.android.exoplayer2.source.TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f_renamed) {
    }

    public BaseTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int... iArr) {
        int i_renamed = 0;
        com.google.android.exoplayer2.util.Assertions.checkState(iArr.length > 0);
        this.group = (com.google.android.exoplayer2.source.TrackGroup) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackGroup);
        this.length = iArr.length;
        this.formats = new com.google.android.exoplayer2.Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.formats[i2] = trackGroup.getFormat(iArr[i2]);
        }
        java.util.Arrays.sort(this.formats, new com.google.android.exoplayer2.trackselection.BaseTrackSelection.DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i_renamed < i3) {
                this.tracks[i_renamed] = trackGroup.indexOf(this.formats[i_renamed]);
                i_renamed++;
            } else {
                this.blacklistUntilTimes = new long[i3];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.source.TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.Format getFormat(int i_renamed) {
        return this.formats[i_renamed];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i_renamed) {
        return this.tracks[i_renamed];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(com.google.android.exoplayer2.Format format) {
        for (int i_renamed = 0; i_renamed < this.length; i_renamed++) {
            if (this.formats[i_renamed] == format) {
                return i_renamed;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i_renamed) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == i_renamed) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final com.google.android.exoplayer2.Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j_renamed, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int i_renamed, long j_renamed) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(i_renamed, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !zIsBlacklisted) {
            zIsBlacklisted = (i2 == i_renamed || isBlacklisted(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[i_renamed] = java.lang.Math.max(jArr[i_renamed], com.google.android.exoplayer2.util.Util.addWithOverflowDefault(jElapsedRealtime, j_renamed, Long.MAX_VALUE));
        return true;
    }

    protected final boolean isBlacklisted(int i_renamed, long j_renamed) {
        return this.blacklistUntilTimes[i_renamed] > j_renamed;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (java.lang.System.identityHashCode(this.group) * 31) + java.util.Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.BaseTrackSelection baseTrackSelection = (com.google.android.exoplayer2.trackselection.BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && java.util.Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    private static final class DecreasingBandwidthComparator implements java.util.Comparator<com.google.android.exoplayer2.Format> {
        private DecreasingBandwidthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }
}
