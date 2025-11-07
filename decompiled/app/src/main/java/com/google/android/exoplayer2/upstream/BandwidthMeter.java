package com.google.android.exoplayer2.upstream;

import android.os.Handler;

/* loaded from: classes.dex */
public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2);
    }

    void addEventListener(Handler handler, EventListener eventListener);

    long getBitrateEstimate();

    TransferListener getTransferListener();

    void removeEventListener(EventListener eventListener);
}
