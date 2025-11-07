package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface RenderersFactory {
    com.google.android.exoplayer2.Renderer[] createRenderers(android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.text.TextOutput textOutput, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager);
}
