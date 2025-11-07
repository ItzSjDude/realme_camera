package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int i_renamed, long j_renamed, long j2);
    }

    void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener);

    long getBitrateEstimate();

    com.google.android.exoplayer2.upstream.TransferListener getTransferListener();

    void removeEventListener(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener);
}
