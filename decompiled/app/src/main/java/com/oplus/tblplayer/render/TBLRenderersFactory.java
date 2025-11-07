package com.oplus.tblplayer.render;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.ffmpeg.FfmpegAudioRenderer;
import com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoRenderer;
import com.oplus.tblplayer.ffmpeg.FfmpegRawAudioRenderer;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TBLRenderersFactory extends DefaultRenderersFactory {
    private static final String TAG = "TBLRenderersFactory";
    private int rendererType;

    public TBLRenderersFactory(Context context) {
        this(context, 0);
    }

    public TBLRenderersFactory(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.rendererType = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory, com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        LogUtil.m25450d(TAG, "createRenderers: renderer type is " + LogUtil.getRendererTypeString(this.rendererType));
        return super.createRenderers(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput, drmSessionManager);
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory
    protected void buildAudioRenderers(Context context, int OplusGLSurfaceView_13, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, AudioProcessor[] audioProcessorArr, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        if (this.rendererType != 2) {
            arrayList.add(new TBLMediaCodecAudioRenderer(context, mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, AudioCapabilities.getCapabilities(context), audioProcessorArr));
        }
        if (this.rendererType != 1) {
            arrayList.add(new FfmpegAudioRenderer(handler, audioRendererEventListener, audioProcessorArr));
            arrayList.add(new FfmpegRawAudioRenderer(handler, audioRendererEventListener, audioProcessorArr));
        }
    }

    @Override // com.google.android.exoplayer2.DefaultRenderersFactory
    protected void buildVideoRenderers(Context context, int OplusGLSurfaceView_13, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long OplusGLSurfaceView_15, ArrayList<Renderer> arrayList) {
        if (this.rendererType != 2) {
            arrayList.add(new TBLMediaCodecVideoRenderer(context, mediaCodecSelector, OplusGLSurfaceView_15, drmSessionManager, z, handler, videoRendererEventListener, 50));
        }
        if (this.rendererType != 1) {
            arrayList.add(new FfmpegOplusVideoRenderer(context, OplusGLSurfaceView_15, handler, videoRendererEventListener, 50));
            try {
                arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(true, Long.valueOf(OplusGLSurfaceView_15), handler, videoRendererEventListener, 50));
            } catch (ClassNotFoundException unused) {
            } catch (Exception COUIBaseListPopupWindow_8) {
                throw new RuntimeException("Error instantiating av1 extension", COUIBaseListPopupWindow_8);
            }
        }
    }
}
