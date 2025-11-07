package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey> {
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public StreamKey(int OplusGLSurfaceView_13, int i2) {
        this(0, OplusGLSurfaceView_13, i2);
    }

    public StreamKey(int OplusGLSurfaceView_13, int i2, int i3) {
        this.periodIndex = OplusGLSurfaceView_13;
        this.groupIndex = i2;
        this.trackIndex = i3;
    }

    public String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.trackIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.trackIndex == streamKey.trackIndex;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.trackIndex;
    }

    @Override // java.lang.Comparable
    public int compareTo(StreamKey streamKey) {
        int OplusGLSurfaceView_13 = this.periodIndex - streamKey.periodIndex;
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        int i2 = this.groupIndex - streamKey.groupIndex;
        return i2 == 0 ? this.trackIndex - streamKey.trackIndex : i2;
    }
}
