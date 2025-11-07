package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public interface AudioRendererEventListener {
    default void onAudioDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
    }

    default void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
    }

    default void onAudioSessionId(int i_renamed) {
    }

    default void onAudioSinkUnderrun(int i_renamed, long j_renamed, long j2) {
    }

    public static final class EventDispatcher {
        private final android.os.Handler handler;
        private final com.google.android.exoplayer2.audio.AudioRendererEventListener listener;

        public EventDispatcher(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void enabled(final com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$MUMUaHcEfIpwDLi9gxmScOQxifc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$enabled$0$AudioRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$AudioRendererEventListener$EventDispatcher(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            this.listener.onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(final java.lang.String str, final long j_renamed, final long j2) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$F29t8_xYSK7h_6CpLRlp2y2yb1E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(str, j_renamed, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(java.lang.String str, long j_renamed, long j2) {
            this.listener.onAudioDecoderInitialized(str, j_renamed, j2);
        }

        public void inputFormatChanged(final com.google.android.exoplayer2.Format format) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$D7KvJbrpXrnWw4qzd_LI9ZtQytw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(format);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(com.google.android.exoplayer2.Format format) {
            this.listener.onAudioInputFormatChanged(format);
        }

        public void audioTrackUnderrun(final int i_renamed, final long j_renamed, final long j2) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$oPQKly422CpX1mqIU2N6d76OGxk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(i_renamed, j_renamed, j2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(int i_renamed, long j_renamed, long j2) {
            this.listener.onAudioSinkUnderrun(i_renamed, j_renamed, j2);
        }

        public void disabled(final com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$jb22FSnmUl2pGG0LguQS_Wd-LWk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$disabled$4$AudioRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$4$AudioRendererEventListener$EventDispatcher(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onAudioDisabled(decoderCounters);
        }

        public void audioSessionId(final int i_renamed) {
            if (this.listener != null) {
                this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$a1B1YBHhPRCtc1MQAc2fSVEo22I
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(i_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(int i_renamed) {
            this.listener.onAudioSessionId(i_renamed);
        }
    }
}
