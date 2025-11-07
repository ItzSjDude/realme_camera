package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public class DefaultRenderersFactory implements com.google.android.exoplayer2.RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final java.lang.String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final android.content.Context context;
    private com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager;
    private int extensionRendererMode;
    private com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector;
    private boolean playClearSamplesWithoutKeys;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    protected void buildMiscellaneousRenderers(android.content.Context context, android.os.Handler handler, int i_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
    }

    public DefaultRenderersFactory(android.content.Context context) {
        this.context = context;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        this.mediaCodecSelector = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT;
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        this(context, drmSessionManager, 0);
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, int i_renamed) {
        this(context, i_renamed, DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, int i_renamed) {
        this(context, drmSessionManager, i_renamed, DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, int i_renamed, long j_renamed) {
        this(context, null, i_renamed, j_renamed);
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, int i_renamed, long j_renamed) {
        this.context = context;
        this.extensionRendererMode = i_renamed;
        this.allowedVideoJoiningTimeMs = j_renamed;
        this.drmSessionManager = drmSessionManager;
        this.mediaCodecSelector = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setExtensionRendererMode(int i_renamed) {
        this.extensionRendererMode = i_renamed;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setPlayClearSamplesWithoutKeys(boolean z_renamed) {
        this.playClearSamplesWithoutKeys = z_renamed;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setMediaCodecSelector(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this.mediaCodecSelector = mediaCodecSelector;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j_renamed) {
        this.allowedVideoJoiningTimeMs = j_renamed;
        return this;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public com.google.android.exoplayer2.Renderer[] createRenderers(android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.text.TextOutput textOutput, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager) {
        com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager2 = drmSessionManager == null ? this.drmSessionManager : drmSessionManager;
        java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList = new java.util.ArrayList<>();
        com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager3 = drmSessionManager2;
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager3, this.playClearSamplesWithoutKeys, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager3, this.playClearSamplesWithoutKeys, buildAudioProcessors(), handler, audioRendererEventListener, arrayList);
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (com.google.android.exoplayer2.Renderer[]) arrayList.toArray(new com.google.android.exoplayer2.Renderer[arrayList.size()]);
    }

    protected void buildVideoRenderers(android.content.Context context, int i_renamed, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, long j_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        int i2;
        arrayList.add(new com.google.android.exoplayer2.video.MediaCodecVideoRenderer(context, mediaCodecSelector, j_renamed, drmSessionManager, z_renamed, handler, videoRendererEventListener, 50));
        if (i_renamed == 0) {
            return;
        }
        int size = arrayList.size();
        if (i_renamed == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(java.lang.Boolean.TYPE, java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(true, java.lang.Long.valueOf(j_renamed), handler, videoRendererEventListener, 50));
                    com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Loaded LibvpxVideoRenderer.");
                } catch (java.lang.ClassNotFoundException unused) {
                }
            } catch (java.lang.ClassNotFoundException unused2) {
                i2 = size;
            }
            try {
                arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(java.lang.Boolean.TYPE, java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(true, java.lang.Long.valueOf(j_renamed), handler, videoRendererEventListener, 50));
                com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Loaded Libgav1VideoRenderer.");
            } catch (java.lang.ClassNotFoundException unused3) {
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException("Error instantiating AV1 extension", e_renamed);
            }
        } catch (java.lang.Exception e2) {
            throw new java.lang.RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    protected void buildAudioRenderers(android.content.Context context, int i_renamed, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(context), audioProcessorArr));
        if (i_renamed == 0) {
            return;
        }
        int size = arrayList.size();
        if (i_renamed == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                    com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Loaded LibopusAudioRenderer.");
                } catch (java.lang.ClassNotFoundException unused) {
                }
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException("Error instantiating Opus extension", e_renamed);
            }
        } catch (java.lang.ClassNotFoundException unused2) {
            i2 = size;
        }
        try {
            try {
                i3 = i2 + 1;
                try {
                    arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                    com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Loaded LibflacAudioRenderer.");
                } catch (java.lang.ClassNotFoundException unused3) {
                }
            } catch (java.lang.ClassNotFoundException unused4) {
                i3 = i2;
            }
            try {
                arrayList.add(i3, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Loaded FfmpegAudioRenderer.");
            } catch (java.lang.ClassNotFoundException unused5) {
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException("Error instantiating FFmpeg extension", e2);
            }
        } catch (java.lang.Exception e3) {
            throw new java.lang.RuntimeException("Error instantiating FLAC extension", e3);
        }
    }

    protected void buildTextRenderers(android.content.Context context, com.google.android.exoplayer2.text.TextOutput textOutput, android.os.Looper looper, int i_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.text.TextRenderer(textOutput, looper));
    }

    protected void buildMetadataRenderers(android.content.Context context, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, android.os.Looper looper, int i_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.MetadataRenderer(metadataOutput, looper));
    }

    protected void buildCameraMotionRenderers(android.content.Context context, int i_renamed, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.video.spherical.CameraMotionRenderer());
    }

    protected com.google.android.exoplayer2.audio.AudioProcessor[] buildAudioProcessors() {
        return new com.google.android.exoplayer2.audio.AudioProcessor[0];
    }
}
