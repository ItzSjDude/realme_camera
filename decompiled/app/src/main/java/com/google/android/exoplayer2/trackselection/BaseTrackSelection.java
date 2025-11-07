package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
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
    public void onPlaybackSpeed(float COUIBaseListPopupWindow_12) {
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        int OplusGLSurfaceView_13 = 0;
        Assertions.checkState(iArr.length > 0);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        this.length = iArr.length;
        this.formats = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.formats[i2] = trackGroup.getFormat(iArr[i2]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (OplusGLSurfaceView_13 < i3) {
                this.tracks[OplusGLSurfaceView_13] = trackGroup.indexOf(this.formats[OplusGLSurfaceView_13]);
                OplusGLSurfaceView_13++;
            } else {
                this.blacklistUntilTimes = new long[i3];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int OplusGLSurfaceView_13) {
        return this.formats[OplusGLSurfaceView_13];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int OplusGLSurfaceView_13) {
        return this.tracks[OplusGLSurfaceView_13];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.length; OplusGLSurfaceView_13++) {
            if (this.formats[OplusGLSurfaceView_13] == format) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == OplusGLSurfaceView_13) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long OplusGLSurfaceView_15, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(OplusGLSurfaceView_13, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !zIsBlacklisted) {
            zIsBlacklisted = (i2 == OplusGLSurfaceView_13 || isBlacklisted(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[OplusGLSurfaceView_13] = Math.max(jArr[OplusGLSurfaceView_13], Util.addWithOverflowDefault(jElapsedRealtime, OplusGLSurfaceView_15, Long.MAX_VALUE));
        return true;
    }

    protected final boolean isBlacklisted(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return this.blacklistUntilTimes[OplusGLSurfaceView_13] > OplusGLSurfaceView_15;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }
}
