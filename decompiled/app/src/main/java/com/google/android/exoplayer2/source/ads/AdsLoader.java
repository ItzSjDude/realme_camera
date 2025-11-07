package com.google.android.exoplayer2.source.ads;

/* loaded from: classes.dex */
public interface AdsLoader {

    public interface AdViewProvider {
        android.view.View[] getAdOverlayViews();

        android.view.ViewGroup getAdViewGroup();
    }

    public interface EventListener {
        default void onAdClicked() {
        }

        default void onAdLoadError(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException adLoadException, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        }

        default void onAdPlaybackState(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        }

        default void onAdTapped() {
        }
    }

    void handlePrepareError(int i_renamed, int i2, java.io.IOException iOException);

    void release();

    void setPlayer(com.google.android.exoplayer2.Player player);

    void setSupportedContentTypes(int... iArr);

    void start(com.google.android.exoplayer2.source.ads.AdsLoader.EventListener eventListener, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider);

    void stop();
}
