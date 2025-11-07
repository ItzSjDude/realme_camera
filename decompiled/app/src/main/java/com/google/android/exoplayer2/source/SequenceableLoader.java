package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t);
    }

    boolean continueLoading(long OplusGLSurfaceView_15);

    long getBufferedPositionUs();

    long getLargestQueuedTimeUsByType(int OplusGLSurfaceView_13);

    long getNextKeyFramePositionUs(long OplusGLSurfaceView_15);

    long getNextLoadPositionUs();

    void reevaluateBuffer(long OplusGLSurfaceView_15);
}
