package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public abstract class BasePlayer implements com.google.android.exoplayer2.Player {
    protected final com.google.android.exoplayer2.Timeline.Window window = new com.google.android.exoplayer2.Timeline.Window();

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition(int i_renamed) {
        seekTo(i_renamed, -9223372036854775807L);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(long j_renamed) {
        seekTo(getCurrentWindowIndex(), j_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void fastSeekTo(long j_renamed, boolean z_renamed) {
        fastSeekTo(getCurrentWindowIndex(), j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void previous() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void next() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop() {
        stop(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getNextWindowIndex() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final java.lang.Object getCurrentTag() {
        int currentWindowIndex = getCurrentWindowIndex();
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentWindowIndex >= currentTimeline.getWindowCount()) {
            return null;
        }
        return currentTimeline.getWindow(currentWindowIndex, this.window, true).tag;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return com.google.android.exoplayer2.util.Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowDynamic() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentDuration() {
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }
}
