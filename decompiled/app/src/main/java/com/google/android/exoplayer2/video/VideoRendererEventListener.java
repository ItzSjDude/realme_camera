package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.AsyncHandlerUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public interface VideoRendererEventListener {
    default void onDroppedFrames(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
    }

    default void onRenderedFirstFrame(Surface surface) {
    }

    default void onVideoDecoderInitialized(String str, long OplusGLSurfaceView_15, long j2) {
    }

    default void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    default void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    default void onVideoInputFormatChanged(Format format) {
    }

    default void onVideoSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = videoRendererEventListener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$Zf6ofdxzBBJ5SL288lE0HglRj8g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8329xf2818e21(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$enabled$0$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8329xf2818e21(DecoderCounters decoderCounters) {
            this.listener.onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(final String str, final long OplusGLSurfaceView_15, final long j2) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$Y232CA7hogfrRJjYu2VeUSxg0VQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8326x9a08f997(str, OplusGLSurfaceView_15, j2);
                    }
                });
            }
        }

        /* renamed from: lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8326x9a08f997(String str, long OplusGLSurfaceView_15, long j2) {
            this.listener.onVideoDecoderInitialized(str, OplusGLSurfaceView_15, j2);
        }

        public void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$26y6c6BFFT4OL6bJiMmdsfxDEMQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8330xe7570b3(format);
                    }
                });
            }
        }

        /* renamed from: lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8330xe7570b3(Format format) {
            this.listener.onVideoInputFormatChanged(format);
        }

        public void droppedFrames(final int OplusGLSurfaceView_13, final long OplusGLSurfaceView_15) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$wpJzum9Nim-WREQi3I6t6RZgGzs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8328xf7e95759(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
                    }
                });
            }
        }

        /* renamed from: lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8328xf7e95759(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.listener.onDroppedFrames(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }

        public void videoSizeChanged(final int OplusGLSurfaceView_13, final int i2, final int i3, final float COUIBaseListPopupWindow_12) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.listener != null) {
                AsyncHandlerUtil.sendAsyncMessage(this.handler, new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$TaBV3X3b5lKElsQ7tczViKAyQ3w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8332x6ff94f6c(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                    }
                });
            }
        }

        /* renamed from: lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8332x6ff94f6c(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
            this.listener.onVideoSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
        }

        public void renderedFirstFrame(final Surface surface) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$SFK5uUI0PHTm3Dg6Wdc1eRaQ9xk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8331x44bb7f11(surface);
                    }
                });
            }
        }

        /* renamed from: lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8331x44bb7f11(Surface surface) {
            this.listener.onRenderedFirstFrame(surface);
        }

        public void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$qTQ-0WnG_WelRJ9iR8L0OaiS0Go
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8327xf93f9126(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$disabled$6$VideoRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8327xf93f9126(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onVideoDisabled(decoderCounters);
        }
    }
}
