package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class ExoPlayerFactory {
    private static com.google.android.exoplayer2.upstream.BandwidthMeter singletonBandwidthMeter;

    private ExoPlayerFactory() {
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), trackSelector, loadControl);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), trackSelector, loadControl, drmSessionManager);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, int i_renamed) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context).setExtensionRendererMode(i_renamed), trackSelector, loadControl, drmSessionManager);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, int i_renamed, long j_renamed) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context).setExtensionRendererMode(i_renamed).setAllowedVideoJoiningTimeMs(j_renamed), trackSelector, loadControl, drmSessionManager);
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), trackSelector);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newSimpleInstance((android.content.Context) null, renderersFactory, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newSimpleInstance(context, renderersFactory, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(context, renderersFactory, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl(), drmSessionManager);
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, (com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto>) null, com.google.android.exoplayer2.util.Util.getLooper());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, com.google.android.exoplayer2.util.Util.getLooper());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, bandwidthMeter, new com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory(), com.google.android.exoplayer2.util.Util.getLooper());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory factory) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, factory, com.google.android.exoplayer2.util.Util.getLooper());
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, android.os.Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, new com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory(), looper);
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory factory, android.os.Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, drmSessionManager, getDefaultBandwidthMeter(), factory, looper);
    }

    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory factory, android.os.Looper looper) {
        return new com.google.android.exoplayer2.SimpleExoPlayer(context, renderersFactory, trackSelector, loadControl, drmSessionManager, bandwidthMeter, factory, looper);
    }

    public static com.google.android.exoplayer2.ExoPlayer newInstance(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newInstance(rendererArr, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl());
    }

    public static com.google.android.exoplayer2.ExoPlayer newInstance(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newInstance(rendererArr, trackSelector, loadControl, com.google.android.exoplayer2.util.Util.getLooper());
    }

    public static com.google.android.exoplayer2.ExoPlayer newInstance(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, android.os.Looper looper) {
        return newInstance(rendererArr, trackSelector, loadControl, getDefaultBandwidthMeter(), looper);
    }

    public static com.google.android.exoplayer2.ExoPlayer newInstance(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, android.os.Looper looper) {
        return new com.google.android.exoplayer2.ExoPlayerImpl(rendererArr, trackSelector, loadControl, bandwidthMeter, com.google.android.exoplayer2.util.Clock.DEFAULT, looper);
    }

    private static synchronized com.google.android.exoplayer2.upstream.BandwidthMeter getDefaultBandwidthMeter() {
        if (singletonBandwidthMeter == null) {
            singletonBandwidthMeter = new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder().build();
        }
        return singletonBandwidthMeter;
    }
}
