package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class AudioTimestampPoller {
    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 10000;
    private static final int INITIALIZING_DURATION_US = 500000;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.audioTimestamp = new AudioTimestampV19(audioTrack);
            reset();
        } else {
            this.audioTimestamp = null;
            updateState(3);
        }
    }

    public boolean maybePollTimestamp(long OplusGLSurfaceView_15) {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 == null || OplusGLSurfaceView_15 - this.lastTimestampSampleTimeUs < this.sampleIntervalUs) {
            return false;
        }
        this.lastTimestampSampleTimeUs = OplusGLSurfaceView_15;
        boolean zMaybeUpdateTimestamp = audioTimestampV19.maybeUpdateTimestamp();
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 == 0) {
            if (!zMaybeUpdateTimestamp) {
                if (OplusGLSurfaceView_15 - this.initializeSystemTimeUs <= 500000) {
                    return zMaybeUpdateTimestamp;
                }
                updateState(3);
                return zMaybeUpdateTimestamp;
            }
            if (this.audioTimestamp.getTimestampSystemTimeUs() < this.initializeSystemTimeUs) {
                return false;
            }
            this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
            updateState(1);
            return zMaybeUpdateTimestamp;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (!zMaybeUpdateTimestamp) {
                reset();
                return zMaybeUpdateTimestamp;
            }
            if (this.audioTimestamp.getTimestampPositionFrames() <= this.initialTimestampPositionFrames) {
                return zMaybeUpdateTimestamp;
            }
            updateState(2);
            return zMaybeUpdateTimestamp;
        }
        if (OplusGLSurfaceView_13 == 2) {
            if (zMaybeUpdateTimestamp) {
                return zMaybeUpdateTimestamp;
            }
            reset();
            return zMaybeUpdateTimestamp;
        }
        if (OplusGLSurfaceView_13 != 3) {
            if (OplusGLSurfaceView_13 == 4) {
                return zMaybeUpdateTimestamp;
            }
            throw new IllegalStateException();
        }
        if (!zMaybeUpdateTimestamp) {
            return zMaybeUpdateTimestamp;
        }
        reset();
        return zMaybeUpdateTimestamp;
    }

    public void rejectTimestamp() {
        updateState(4);
    }

    public void acceptTimestamp() {
        if (this.state == 4) {
            reset();
        }
    }

    public boolean hasTimestamp() {
        int OplusGLSurfaceView_13 = this.state;
        return OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2;
    }

    public boolean hasAdvancingTimestamp() {
        return this.state == 2;
    }

    public void reset() {
        if (this.audioTimestamp != null) {
            updateState(0);
        }
    }

    public long getTimestampSystemTimeUs() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampSystemTimeUs();
        }
        return -9223372036854775807L;
    }

    public long getTimestampPositionFrames() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampPositionFrames();
        }
        return -1L;
    }

    private void updateState(int OplusGLSurfaceView_13) {
        this.state = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 0) {
            this.lastTimestampSampleTimeUs = 0L;
            this.initialTimestampPositionFrames = -1L;
            this.initializeSystemTimeUs = System.nanoTime() / 1000;
            this.sampleIntervalUs = 10000L;
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            this.sampleIntervalUs = 10000L;
            return;
        }
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
            this.sampleIntervalUs = 10000000L;
        } else {
            if (OplusGLSurfaceView_13 == 4) {
                this.sampleIntervalUs = 500000L;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @TargetApi(19)
    private static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp = new AudioTimestamp();
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public AudioTimestampV19(AudioTrack audioTrack) {
            this.audioTrack = audioTrack;
        }

        public boolean maybeUpdateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long OplusGLSurfaceView_15 = this.audioTimestamp.framePosition;
                if (this.lastTimestampRawPositionFrames > OplusGLSurfaceView_15) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastTimestampRawPositionFrames = OplusGLSurfaceView_15;
                this.lastTimestampPositionFrames = OplusGLSurfaceView_15 + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }

        public long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000;
        }

        public long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }
    }
}
