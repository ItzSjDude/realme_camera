package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public abstract class BaseMediaSource implements com.google.android.exoplayer2.source.MediaSource {
    private android.os.Looper looper;
    private java.lang.Object manifest;
    private com.google.android.exoplayer2.Timeline timeline;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener> sourceInfoListeners = new java.util.ArrayList<>(1);
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher = new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher();

    protected abstract void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener);

    protected abstract void releaseSourceInternal();

    protected final void refreshSourceInfo(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        this.timeline = timeline;
        this.manifest = obj;
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener> it = this.sourceInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline, obj);
        }
    }

    protected final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0L);
    }

    protected final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(mediaPeriodId != null);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j_renamed);
    }

    protected final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
        return this.eventDispatcher.withParameters(i_renamed, mediaPeriodId, j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void prepareSource(com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        android.os.Looper looper = this.looper;
        com.google.android.exoplayer2.util.Assertions.checkArgument(looper == null || looper == looperMyLooper);
        this.sourceInfoListeners.add(sourceInfoRefreshListener);
        if (this.looper == null) {
            this.looper = looperMyLooper;
            prepareSourceInternal(transferListener);
        } else {
            com.google.android.exoplayer2.Timeline timeline = this.timeline;
            if (timeline != null) {
                sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline, this.manifest);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releaseSource(com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        this.sourceInfoListeners.remove(sourceInfoRefreshListener);
        if (this.sourceInfoListeners.isEmpty()) {
            this.looper = null;
            this.timeline = null;
            this.manifest = null;
            releaseSourceInternal();
        }
    }
}
