package com.oplus.tblplayer.render;

/* loaded from: classes2.dex */
public class TBLRenderersFactory extends com.google.android.exoplayer2.DefaultRenderersFactory {
    private static final java.lang.String TAG = "TBLRenderersFactory";
    private int rendererType;

    public TBLRenderersFactory(android.content.Context context) {
        this(context, 0);
    }

    public TBLRenderersFactory(android.content.Context context, int i_renamed) {
        super(context);
        this.rendererType = i_renamed;
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory, com.google.android.exoplayer2.RenderersFactory
    public com.google.android.exoplayer2.Renderer[] createRenderers(android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.text.TextOutput textOutput, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createRenderers: renderer type is_renamed " + com.oplus.tblplayer.utils.LogUtil.getRendererTypeString(this.rendererType));
        return super.createRenderers(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput, drmSessionManager);
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory
    protected void buildAudioRenderers(android.content.Context context, int i_renamed, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        if (this.rendererType != 2) {
            arrayList.add(new com.oplus.tblplayer.render.TBLMediaCodecAudioRenderer(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(context), audioProcessorArr));
        }
        if (this.rendererType != 1) {
            arrayList.add(new com.oplus.tblplayer.ffmpeg.FfmpegAudioRenderer(handler, audioRendererEventListener, audioProcessorArr));
            arrayList.add(new com.oplus.tblplayer.ffmpeg.FfmpegRawAudioRenderer(handler, audioRendererEventListener, audioProcessorArr));
        }
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory
    protected void buildVideoRenderers(android.content.Context context, int i_renamed, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, long j_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        if (this.rendererType != 2) {
            arrayList.add(new com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer(context, mediaCodecSelector, j_renamed, drmSessionManager, z_renamed, handler, videoRendererEventListener, 50));
        }
        if (this.rendererType != 1) {
            arrayList.add(new com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoRenderer(context, j_renamed, handler, videoRendererEventListener, 50));
            try {
                arrayList.add((com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(java.lang.Boolean.TYPE, java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(true, java.lang.Long.valueOf(j_renamed), handler, videoRendererEventListener, 50));
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException("Error instantiating av1 extension", e_renamed);
            }
        }
    }
}
