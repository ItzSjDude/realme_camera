package com.google.android.exoplayer2.audio;

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
    private final com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public AudioTimestampPoller(android.media.AudioTrack audioTrack) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
            this.audioTimestamp = new com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19(audioTrack);
            reset();
        } else {
            this.audioTimestamp = null;
            updateState(3);
        }
    }

    public boolean maybePollTimestamp(long j_renamed) {
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 == null || j_renamed - this.lastTimestampSampleTimeUs < this.sampleIntervalUs) {
            return false;
        }
        this.lastTimestampSampleTimeUs = j_renamed;
        boolean zMaybeUpdateTimestamp = audioTimestampV19.maybeUpdateTimestamp();
        int i_renamed = this.state;
        if (i_renamed == 0) {
            if (!zMaybeUpdateTimestamp) {
                if (j_renamed - this.initializeSystemTimeUs <= 500000) {
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
        if (i_renamed == 1) {
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
        if (i_renamed == 2) {
            if (zMaybeUpdateTimestamp) {
                return zMaybeUpdateTimestamp;
            }
            reset();
            return zMaybeUpdateTimestamp;
        }
        if (i_renamed != 3) {
            if (i_renamed == 4) {
                return zMaybeUpdateTimestamp;
            }
            throw new java.lang.IllegalStateException();
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
        int i_renamed = this.state;
        return i_renamed == 1 || i_renamed == 2;
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
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampSystemTimeUs();
        }
        return -9223372036854775807L;
    }

    public long getTimestampPositionFrames() {
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampPositionFrames();
        }
        return -1L;
    }

    private void updateState(int i_renamed) {
        this.state = i_renamed;
        if (i_renamed == 0) {
            this.lastTimestampSampleTimeUs = 0L;
            this.initialTimestampPositionFrames = -1L;
            this.initializeSystemTimeUs = java.lang.System.nanoTime() / 1000;
            this.sampleIntervalUs = 10000L;
            return;
        }
        if (i_renamed == 1) {
            this.sampleIntervalUs = 10000L;
            return;
        }
        if (i_renamed == 2 || i_renamed == 3) {
            this.sampleIntervalUs = 10000000L;
        } else {
            if (i_renamed == 4) {
                this.sampleIntervalUs = 500000L;
                return;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    @android.annotation.TargetApi(19)
    private static final class AudioTimestampV19 {
        private final android.media.AudioTimestamp audioTimestamp = new android.media.AudioTimestamp();
        private final android.media.AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public AudioTimestampV19(android.media.AudioTrack audioTrack) {
            this.audioTrack = audioTrack;
        }

        public boolean maybeUpdateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j_renamed = this.audioTimestamp.framePosition;
                if (this.lastTimestampRawPositionFrames > j_renamed) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastTimestampRawPositionFrames = j_renamed;
                this.lastTimestampPositionFrames = j_renamed + (this.rawTimestampFramePositionWrapCount << 32);
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
