package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public interface AudioRendererEventListener {
    default void onAudioDecoderInitialized(String str, long OplusGLSurfaceView_15, long j2) {
    }

    default void onAudioDisabled(DecoderCounters decoderCounters) {
    }

    default void onAudioEnabled(DecoderCounters decoderCounters) {
    }

    default void onAudioInputFormatChanged(Format format) {
    }

    default void onAudioSessionId(int OplusGLSurfaceView_13) {
    }

    default void onAudioSinkUnderrun(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$MUMUaHcEfIpwDLi9gxmScOQxifc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8302x12ba13a6(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$enabled$0$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8302x12ba13a6(DecoderCounters decoderCounters) {
            this.listener.onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(final String str, final long OplusGLSurfaceView_15, final long j2) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$F29t8_xYSK7h_6CpLRlp2y2yb1E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8300xba417f1c(str, OplusGLSurfaceView_15, j2);
                    }
                });
            }
        }

        /* renamed from: lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8300xba417f1c(String str, long OplusGLSurfaceView_15, long j2) {
            this.listener.onAudioDecoderInitialized(str, OplusGLSurfaceView_15, j2);
        }

        public void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$D7KvJbrpXrnWw4qzd_LI9ZtQytw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8303x2eadf638(format);
                    }
                });
            }
        }

        /* renamed from: lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8303x2eadf638(Format format) {
            this.listener.onAudioInputFormatChanged(format);
        }

        public void audioTrackUnderrun(final int OplusGLSurfaceView_13, final long OplusGLSurfaceView_15, final long j2) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$oPQKly422CpX1mqIU2N6d76OGxk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8299xe45e91e2(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2);
                    }
                });
            }
        }

        /* renamed from: lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8299xe45e91e2(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            this.listener.onAudioSinkUnderrun(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2);
        }

        public void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$jb22FSnmUl2pGG0LguQS_Wd-LWk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8301x939f43ed(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$disabled$4$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8301x939f43ed(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onAudioDisabled(decoderCounters);
        }

        public void audioSessionId(final int OplusGLSurfaceView_13) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$a1B1YBHhPRCtc1MQAc2fSVEo22I
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8298xc1c634cd(OplusGLSurfaceView_13);
                    }
                });
            }
        }

        /* renamed from: lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher */
        public /* synthetic */ void m8298xc1c634cd(int OplusGLSurfaceView_13) {
            this.listener.onAudioSessionId(OplusGLSurfaceView_13);
        }
    }
}
