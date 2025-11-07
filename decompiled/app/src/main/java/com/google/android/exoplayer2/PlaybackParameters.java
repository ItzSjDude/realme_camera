package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class PlaybackParameters {
    public static final com.google.android.exoplayer2.PlaybackParameters DEFAULT = new com.google.android.exoplayer2.PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float f_renamed) {
        this(f_renamed, 1.0f, false);
    }

    public PlaybackParameters(float f_renamed, float f2) {
        this(f_renamed, f2, false);
    }

    public PlaybackParameters(float f_renamed, float f2, boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(f_renamed > 0.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f2 > 0.0f);
        this.speed = f_renamed;
        this.pitch = f2;
        this.skipSilence = z_renamed;
        this.scaledUsPerMs = java.lang.Math.round(f_renamed * 1000.0f);
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j_renamed) {
        return j_renamed * this.scaledUsPerMs;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = (com.google.android.exoplayer2.PlaybackParameters) obj;
        return this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence;
    }

    public int hashCode() {
        return ((((527 + java.lang.Float.floatToRawIntBits(this.speed)) * 31) + java.lang.Float.floatToRawIntBits(this.pitch)) * 31) + (this.skipSilence ? 1 : 0);
    }
}
