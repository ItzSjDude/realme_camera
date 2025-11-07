package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface SequenceableLoader {

    public interface Callback<T_renamed extends com.google.android.exoplayer2.source.SequenceableLoader> {
        void onContinueLoadingRequested(T_renamed t_renamed);
    }

    boolean continueLoading(long j_renamed);

    long getBufferedPositionUs();

    long getLargestQueuedTimeUsByType(int i_renamed);

    long getNextKeyFramePositionUs(long j_renamed);

    long getNextLoadPositionUs();

    void reevaluateBuffer(long j_renamed);
}
