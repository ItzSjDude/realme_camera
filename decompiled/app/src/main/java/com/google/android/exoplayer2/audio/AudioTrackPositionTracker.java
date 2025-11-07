package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller;
    private android.media.AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private java.lang.reflect.Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPosition;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j_renamed);

        void onPositionFramesMismatch(long j_renamed, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j_renamed, long j2, long j3, long j4);

        void onUnderrun(int i_renamed, long j_renamed);
    }

    public AudioTrackPositionTracker(com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener listener) {
        this.listener = (com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener) com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = android.media.AudioTrack.class.getMethod("getLatency", (java.lang.Class[]) null);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    public void setAudioTrack(android.media.AudioTrack audioTrack, int i_renamed, int i2, int i3) {
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = i2;
        this.bufferSize = i3;
        this.audioTimestampPoller = new com.google.android.exoplayer2.audio.AudioTimestampPoller(audioTrack);
        this.outputSampleRate = audioTrack.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(i_renamed);
        this.isOutputPcm = com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(i_renamed);
        this.bufferSizeUs = this.isOutputPcm ? framesToDurationUs(i3 / i2) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0L;
    }

    public long getCurrentPositionUs(boolean z_renamed) {
        long playbackHeadPositionUs;
        if (((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long jNanoTime = java.lang.System.nanoTime() / 1000;
        com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller = (com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTimestampPoller);
        boolean zHasAdvancingTimestamp = audioTimestampPoller.hasAdvancingTimestamp();
        if (zHasAdvancingTimestamp) {
            playbackHeadPositionUs = framesToDurationUs(audioTimestampPoller.getTimestampPositionFrames()) + (jNanoTime - audioTimestampPoller.getTimestampSystemTimeUs());
        } else {
            if (this.playheadOffsetCount == 0) {
                playbackHeadPositionUs = getPlaybackHeadPositionUs();
            } else {
                playbackHeadPositionUs = this.smoothedPlayheadOffsetUs + jNanoTime;
            }
            if (!z_renamed) {
                playbackHeadPositionUs -= this.latencyUs;
            }
        }
        if (this.lastSampleUsedGetTimestampMode != zHasAdvancingTimestamp) {
            this.previousModeSystemTimeUs = this.lastSystemTimeUs;
            this.previousModePositionUs = this.lastPositionUs;
        }
        long j_renamed = jNanoTime - this.previousModeSystemTimeUs;
        if (j_renamed < 1000000) {
            long j2 = this.previousModePositionUs + j_renamed;
            long j3 = (j_renamed * 1000) / 1000000;
            playbackHeadPositionUs = ((playbackHeadPositionUs * j3) + ((1000 - j3) * j2)) / 1000;
        }
        this.lastSystemTimeUs = jNanoTime;
        this.lastPositionUs = playbackHeadPositionUs;
        this.lastSampleUsedGetTimestampMode = zHasAdvancingTimestamp;
        return playbackHeadPositionUs;
    }

    public void start() {
        ((com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTimestampPoller)).reset();
    }

    public boolean isPlaying() {
        return ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3;
    }

    public boolean mayHandleBuffer(long j_renamed) {
        com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener listener;
        int playState = ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack)).getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            }
            if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z_renamed = this.hasData;
        this.hasData = hasPendingData(j_renamed);
        if (z_renamed && !this.hasData && playState != 1 && (listener = this.listener) != null) {
            listener.onUnderrun(this.bufferSize, com.google.android.exoplayer2.C_renamed.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public int getAvailableBufferSize(long j_renamed) {
        return this.bufferSize - ((int) (j_renamed - (getPlaybackHeadPosition() * this.outputPcmFrameSize)));
    }

    public boolean isStalled(long j_renamed) {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && j_renamed > 0 && android.os.SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    public void handleEndOfStream(long j_renamed) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = android.os.SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j_renamed;
    }

    public boolean hasPendingData(long j_renamed) {
        return j_renamed > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != -9223372036854775807L) {
            return false;
        }
        ((com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTimestampPoller)).reset();
        return true;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs == 0) {
            return;
        }
        long jNanoTime = java.lang.System.nanoTime() / 1000;
        if (jNanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long[] jArr = this.playheadOffsets;
            int i_renamed = this.nextPlayheadOffsetIndex;
            jArr[i_renamed] = playbackHeadPositionUs - jNanoTime;
            this.nextPlayheadOffsetIndex = (i_renamed + 1) % 10;
            int i2 = this.playheadOffsetCount;
            if (i2 < 10) {
                this.playheadOffsetCount = i2 + 1;
            }
            this.lastPlayheadSampleTimeUs = jNanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.playheadOffsetCount;
                if (i3 >= i4) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / i4;
                i3++;
            }
        }
        if (this.needsPassthroughWorkarounds) {
            return;
        }
        maybePollAndCheckTimestamp(jNanoTime, playbackHeadPositionUs);
        maybeUpdateLatency(jNanoTime);
    }

    private void maybePollAndCheckTimestamp(long j_renamed, long j2) {
        com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller = (com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTimestampPoller);
        if (audioTimestampPoller.maybePollTimestamp(j_renamed)) {
            long timestampSystemTimeUs = audioTimestampPoller.getTimestampSystemTimeUs();
            long timestampPositionFrames = audioTimestampPoller.getTimestampPositionFrames();
            if (java.lang.Math.abs(timestampSystemTimeUs - j_renamed) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j_renamed, j2);
                audioTimestampPoller.rejectTimestamp();
            } else if (java.lang.Math.abs(framesToDurationUs(timestampPositionFrames) - j2) > 5000000) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j_renamed, j2);
                audioTimestampPoller.rejectTimestamp();
            } else {
                audioTimestampPoller.acceptTimestamp();
            }
        }
    }

    private void maybeUpdateLatency(long j_renamed) {
        java.lang.reflect.Method method;
        if (!this.isOutputPcm || (method = this.getLatencyMethod) == null || j_renamed - this.lastLatencySampleTimeUs < 500000) {
            return;
        }
        try {
            this.latencyUs = (((java.lang.Integer) com.google.android.exoplayer2.util.Util.castNonNull((java.lang.Integer) method.invoke(com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack), new java.lang.Object[0]))).intValue() * 1000) - this.bufferSizeUs;
            this.latencyUs = java.lang.Math.max(this.latencyUs, 0L);
            if (this.latencyUs > 5000000) {
                this.listener.onInvalidLatency(this.latencyUs);
                this.latencyUs = 0L;
            }
        } catch (java.lang.Exception unused) {
            this.getLatencyMethod = null;
        }
        this.lastLatencySampleTimeUs = j_renamed;
    }

    private long framesToDurationUs(long j_renamed) {
        return (j_renamed * 1000000) / this.outputSampleRate;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.lastSystemTimeUs = 0L;
        this.previousModeSystemTimeUs = 0L;
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack)).getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private static boolean needsPassthroughWorkarounds(int i_renamed) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 23 && (i_renamed == 5 || i_renamed == 6);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private long getPlaybackHeadPosition() {
        android.media.AudioTrack audioTrack = (android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioTrack);
        if (this.stopTimestampUs != -9223372036854775807L) {
            return java.lang.Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((android.os.SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.outputSampleRate) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack.getPlaybackHeadPosition();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = android.os.SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }
}
