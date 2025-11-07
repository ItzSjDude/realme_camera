package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class PlayerMessage {
    private android.os.Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private java.lang.Object payload;
    private final com.google.android.exoplayer2.PlayerMessage.Sender sender;
    private final com.google.android.exoplayer2.PlayerMessage.Target target;
    private final com.google.android.exoplayer2.Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = -9223372036854775807L;
    private boolean deleteAfterDelivery = true;

    public interface Sender {
        void sendMessage(com.google.android.exoplayer2.PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException;
    }

    public PlayerMessage(com.google.android.exoplayer2.PlayerMessage.Sender sender, com.google.android.exoplayer2.PlayerMessage.Target target, com.google.android.exoplayer2.Timeline timeline, int i_renamed, android.os.Handler handler) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.handler = handler;
        this.windowIndex = i_renamed;
    }

    public com.google.android.exoplayer2.Timeline getTimeline() {
        return this.timeline;
    }

    public com.google.android.exoplayer2.PlayerMessage.Target getTarget() {
        return this.target;
    }

    public com.google.android.exoplayer2.PlayerMessage setType(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        this.type = i_renamed;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public com.google.android.exoplayer2.PlayerMessage setPayload(java.lang.Object obj) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public java.lang.Object getPayload() {
        return this.payload;
    }

    public com.google.android.exoplayer2.PlayerMessage setHandler(android.os.Handler handler) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        this.handler = handler;
        return this;
    }

    public android.os.Handler getHandler() {
        return this.handler;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public com.google.android.exoplayer2.PlayerMessage setPosition(long j_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        this.positionMs = j_renamed;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setPosition(int i_renamed, long j_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed != -9223372036854775807L);
        if (i_renamed < 0 || (!this.timeline.isEmpty() && i_renamed >= this.timeline.getWindowCount())) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(this.timeline, i_renamed, j_renamed);
        }
        this.windowIndex = i_renamed;
        this.positionMs = j_renamed;
        return this;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public com.google.android.exoplayer2.PlayerMessage setDeleteAfterDelivery(boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z_renamed;
        return this;
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public com.google.android.exoplayer2.PlayerMessage send() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public synchronized com.google.android.exoplayer2.PlayerMessage cancel() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public synchronized boolean blockUntilDelivered() throws java.lang.InterruptedException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.isSent);
        com.google.android.exoplayer2.util.Assertions.checkState(this.handler.getLooper().getThread() != java.lang.Thread.currentThread());
        while (!this.isProcessed) {
            wait();
        }
        return this.isDelivered;
    }

    public synchronized void markAsProcessed(boolean z_renamed) {
        this.isDelivered = z_renamed | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }
}
