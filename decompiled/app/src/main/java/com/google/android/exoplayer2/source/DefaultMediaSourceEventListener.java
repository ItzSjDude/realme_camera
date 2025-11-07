package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public abstract class DefaultMediaSourceEventListener implements com.google.android.exoplayer2.source.MediaSourceEventListener {
    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onDownstreamFormatChanged(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCanceled(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCompleted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onMediaPeriodCreated(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onMediaPeriodReleased(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onReadingStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onUpstreamDiscarded(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }
}
