package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float COUIBaseListPopupWindow_12) {
        this(COUIBaseListPopupWindow_12, 1.0f, false);
    }

    public PlaybackParameters(float COUIBaseListPopupWindow_12, float f2) {
        this(COUIBaseListPopupWindow_12, f2, false);
    }

    public PlaybackParameters(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        Assertions.checkArgument(COUIBaseListPopupWindow_12 > 0.0f);
        Assertions.checkArgument(f2 > 0.0f);
        this.speed = COUIBaseListPopupWindow_12;
        this.pitch = f2;
        this.skipSilence = z;
        this.scaledUsPerMs = Math.round(COUIBaseListPopupWindow_12 * 1000.0f);
    }

    public long getMediaTimeUsForPlayoutTimeMs(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 * this.scaledUsPerMs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        return this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence;
    }

    public int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch)) * 31) + (this.skipSilence ? 1 : 0);
    }
}
