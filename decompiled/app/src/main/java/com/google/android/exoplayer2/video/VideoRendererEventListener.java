package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public interface VideoRendererEventListener {
    default void onDroppedFrames(int i_renamed, long j_renamed) {
    }

    default void onRenderedFirstFrame(android.view.Surface surface) {
    }

    default void onVideoDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
    }

    default void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
    }

    default void onVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) {
    }

    public static final class EventDispatcher {
        private final android.os.Handler handler;
        private final com.google.android.exoplayer2.video.VideoRendererEventListener listener;

        public EventDispatcher(android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(handler) : null;
            this.listener = videoRendererEventListener;
        }

        public void enabled(final com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$Zf6ofdxzBBJ5SL288lE0HglRj8g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$enabled$0$VideoRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$VideoRendererEventListener$EventDispatcher(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            this.listener.onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(final java.lang.String str, final long j_renamed, final long j2) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$Y232CA7hogfrRJjYu2VeUSxg0VQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(str, j_renamed, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(java.lang.String str, long j_renamed, long j2) {
            this.listener.onVideoDecoderInitialized(str, j_renamed, j2);
        }

        public void inputFormatChanged(final com.google.android.exoplayer2.Format format) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$26y6c6BFFT4OL6bJiMmdsfxDEMQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(format);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(com.google.android.exoplayer2.Format format) {
            this.listener.onVideoInputFormatChanged(format);
        }

        public void droppedFrames(final int i_renamed, final long j_renamed) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$wpJzum9Nim-WREQi3I6t6RZgGzs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(i_renamed, j_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(int i_renamed, long j_renamed) {
            this.listener.onDroppedFrames(i_renamed, j_renamed);
        }

        public void videoSizeChanged(final int i_renamed, final int i2, final int i3, final float f_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (this.listener != null) {
                com.google.android.exoplayer2.AsyncHandlerUtil.sendAsyncMessage(this.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$TaBV3X3b5lKElsQ7tczViKAyQ3w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher(i_renamed, i2, i3, f_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher(int i_renamed, int i2, int i3, float f_renamed) {
            this.listener.onVideoSizeChanged(i_renamed, i2, i3, f_renamed);
        }

        public void renderedFirstFrame(final android.view.Surface surface) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$SFK5uUI0PHTm3Dg6Wdc1eRaQ9xk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher(surface);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher(android.view.Surface surface) {
            this.listener.onRenderedFirstFrame(surface);
        }

        public void disabled(final com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$qTQ-0WnG_WelRJ9iR8L0OaiS0Go
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$disabled$6$VideoRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$6$VideoRendererEventListener$EventDispatcher(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onVideoDisabled(decoderCounters);
        }
    }
}
