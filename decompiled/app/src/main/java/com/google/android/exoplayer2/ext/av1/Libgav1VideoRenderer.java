package com.google.android.exoplayer2.ext.av1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.camera.capmode.VideoMode;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class Libgav1VideoRenderer extends BaseRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((Util.ceilDivide(VideoMode.VIDEO_720P_WIDTH, 64) * Util.ceilDivide(VideoMode.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int DEFAULT_NUM_OF_INPUT_BUFFERS = 4;
    private static final int DEFAULT_NUM_OF_OUTPUT_BUFFERS = 4;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "Libgav1VideoRenderer";
    public static final int THREAD_COUNT_AUTODETECT = 0;
    private final long allowedJoiningTimeMs;
    private Bitmap bitmap;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private Gav1Decoder decoder;
    protected DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private final boolean disableLoopFilter;
    private DrmSession<ExoMediaCrypto> drmSession;
    private final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private Format format;
    private final FormatHolder formatHolder;
    private final TimedValueQueue<Format> formatQueue;
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private Gav1InputBuffer inputBuffer;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private Gav1OutputBuffer outputBuffer;
    private Gav1OutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private DrmSession<ExoMediaCrypto> pendingDrmSession;
    private Format pendingFormat;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private final boolean scaleToFit;
    private Surface surface;
    private final boolean useSurfaceYuvOutput;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 < -30000;
    }

    private static boolean isBufferVeryLate(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 < -500000;
    }

    protected void onQueueInputBuffer(Gav1InputBuffer gav1InputBuffer) {
    }

    public Libgav1VideoRenderer(boolean z, long OplusGLSurfaceView_15) {
        this(z, OplusGLSurfaceView_15, null, null, 0);
    }

    public Libgav1VideoRenderer(boolean z, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        this(z, OplusGLSurfaceView_15, handler, videoRendererEventListener, OplusGLSurfaceView_13, null, false, false, true);
    }

    public Libgav1VideoRenderer(boolean z, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13, DrmSessionManager<ExoMediaCrypto> drmSessionManager, boolean z2, boolean z3, boolean z4) {
        super(2);
        this.scaleToFit = z;
        this.disableLoopFilter = z3;
        this.allowedJoiningTimeMs = OplusGLSurfaceView_15;
        this.maxDroppedFramesToNotify = OplusGLSurfaceView_13;
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z2;
        this.useSurfaceYuvOutput = z4;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatHolder = new FormatHolder();
        this.formatQueue = new TimedValueQueue<>();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.outputMode = -1;
        this.decoderReinitializationState = 0;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (Gav1Library.isAvailable() && MimeTypes.VIDEO_AV1.equalsIgnoreCase(format.sampleMimeType)) {
            return !supportsFormatDrm(this.drmSessionManager, format.drmInitData) ? 2 : 20;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int source = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(OplusGLSurfaceView_15, j2)) {
                }
                while (feedInputBuffer()) {
                }
                TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (Gav1DecoderException COUIBaseListPopupWindow_8) {
                throw ExoPlaybackException.createForRenderer(COUIBaseListPopupWindow_8, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.format != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || this.outputMode == -1))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long OplusGLSurfaceView_15, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
        this.formatQueue.clear();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.format = null;
        this.waitingForKeys = false;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            releaseDecoder();
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long OplusGLSurfaceView_15) throws ExoPlaybackException {
        this.outputStreamOffsetUs = OplusGLSurfaceView_15;
        super.onStreamChanged(formatArr, OplusGLSurfaceView_15);
    }

    protected void onDecoderInitialized(String str, long OplusGLSurfaceView_15, long j2) {
        this.eventDispatcher.decoderInitialized(str, OplusGLSurfaceView_15, j2);
    }

    protected void flushDecoder() throws ExoPlaybackException {
        this.waitingForKeys = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        Gav1OutputBuffer gav1OutputBuffer = this.outputBuffer;
        if (gav1OutputBuffer != null) {
            gav1OutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    protected void releaseDecoder() {
        Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        gav1Decoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
    }

    protected void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Format format2 = this.format;
        this.format = format;
        this.pendingFormat = format;
        if (!Util.areEqual(this.format.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.format.drmInitData != null) {
                DrmSessionManager<ExoMediaCrypto> drmSessionManager = this.drmSessionManager;
                if (drmSessionManager == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires PlatformImplementations.kt_3 DrmSessionManager"), getIndex());
                }
                this.pendingDrmSession = drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
                DrmSession<ExoMediaCrypto> drmSession = this.pendingDrmSession;
                if (drmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(drmSession);
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        if (this.pendingDrmSession != this.drmSession) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.format);
    }

    protected void onProcessedOutputBuffer(long OplusGLSurfaceView_15) {
        this.buffersInCodecCount--;
    }

    protected boolean shouldDropOutputBuffer(long OplusGLSurfaceView_15, long j2) {
        return isBufferLate(OplusGLSurfaceView_15);
    }

    protected boolean shouldDropBuffersToKeyframe(long OplusGLSurfaceView_15, long j2) {
        return isBufferVeryLate(OplusGLSurfaceView_15);
    }

    protected boolean shouldForceRenderOutputBuffer(long OplusGLSurfaceView_15, long j2) {
        return isBufferLate(OplusGLSurfaceView_15) && j2 > 100000;
    }

    protected void skipOutputBuffer(Gav1OutputBuffer gav1OutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        gav1OutputBuffer.release();
    }

    protected void dropOutputBuffer(Gav1OutputBuffer gav1OutputBuffer) {
        updateDroppedBufferCounters(1);
        gav1OutputBuffer.release();
    }

    protected void renderOutputBuffer(Gav1OutputBuffer gav1OutputBuffer) throws IllegalAccessException, NoSuchMethodException, Gav1DecoderException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        int OplusGLSurfaceView_13 = gav1OutputBuffer.mode;
        boolean z = OplusGLSurfaceView_13 == 1 && this.surface != null;
        boolean z2 = OplusGLSurfaceView_13 == 0 && this.outputBufferRenderer != null;
        if (!z2 && !z) {
            dropOutputBuffer(gav1OutputBuffer);
            return;
        }
        maybeNotifyVideoSizeChanged(gav1OutputBuffer.width, gav1OutputBuffer.height);
        if (z2) {
            this.outputBufferRenderer.setOutputBuffer(gav1OutputBuffer);
        } else {
            renderOutputBufferToSurface(gav1OutputBuffer, this.surface);
        }
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    protected void renderOutputBufferToSurface(Gav1OutputBuffer gav1OutputBuffer, Surface surface) throws Gav1DecoderException {
        Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null) {
            throw new Gav1DecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        gav1Decoder.renderToSurface(gav1OutputBuffer, surface);
        gav1OutputBuffer.release();
    }

    protected boolean maybeDropBuffersToKeyframe(long OplusGLSurfaceView_15) throws ExoPlaybackException {
        int iSkipSource = skipSource(OplusGLSurfaceView_15);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushDecoder();
        return true;
    }

    protected void updateDroppedBufferCounters(int OplusGLSurfaceView_13) {
        this.decoderCounters.droppedBufferCount += OplusGLSurfaceView_13;
        this.droppedFrames += OplusGLSurfaceView_13;
        this.consecutiveDroppedFrameCount += OplusGLSurfaceView_13;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 <= 0 || this.droppedFrames < i2) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int OplusGLSurfaceView_13, Object obj) throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (OplusGLSurfaceView_13 == 1) {
            setOutput((Surface) obj, null);
            return;
        }
        if (OplusGLSurfaceView_13 == 10000) {
            setOutput(null, (Gav1OutputBufferRenderer) obj);
        } else if (OplusGLSurfaceView_13 == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(OplusGLSurfaceView_13, obj);
        }
    }

    private void setOutput(Surface surface, Gav1OutputBufferRenderer gav1OutputBufferRenderer) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Assertions.checkState(surface == null || gav1OutputBufferRenderer == null);
        if (this.surface != surface || this.outputBufferRenderer != gav1OutputBufferRenderer) {
            this.surface = surface;
            this.outputBufferRenderer = gav1OutputBufferRenderer;
            if (surface != null) {
                this.outputMode = this.useSurfaceYuvOutput ? 1 : -1;
            } else {
                this.outputMode = gav1OutputBufferRenderer == null ? -1 : 0;
            }
            int OplusGLSurfaceView_13 = this.outputMode;
            if (OplusGLSurfaceView_13 != -1) {
                Gav1Decoder gav1Decoder = this.decoder;
                if (gav1Decoder != null) {
                    gav1Decoder.setOutputMode(OplusGLSurfaceView_13);
                }
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (getState() == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (this.outputMode != -1) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        DrmSession<ExoMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null && drmSession.getMediaCrypto() == null && this.drmSession.getError() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createVpxDecoder");
            this.decoder = new Gav1Decoder(4, 4, this.format.maxInputSize != -1 ? this.format.maxInputSize : DEFAULT_INPUT_BUFFER_SIZE, 0);
            this.decoder.setOutputMode(this.outputMode);
            TraceUtil.endSection();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            onDecoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (Gav1DecoderException COUIBaseListPopupWindow_8) {
            throw ExoPlaybackException.createForRenderer(COUIBaseListPopupWindow_8, getIndex());
        }
    }

    private boolean feedInputBuffer() throws ExoPlaybackException, Gav1DecoderException {
        Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = gav1Decoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer((Gav1Decoder) this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        int source = this.waitingForKeys ? -4 : readSource(this.formatHolder, this.inputBuffer, false);
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer((Gav1Decoder) this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        if (this.pendingFormat != null) {
            this.formatQueue.add(this.inputBuffer.timeUs, this.pendingFormat);
            this.pendingFormat = null;
        }
        this.inputBuffer.flip();
        this.inputBuffer.colorInfo = this.formatHolder.format.colorInfo;
        onQueueInputBuffer(this.inputBuffer);
        this.decoder.queueInputBuffer((Gav1Decoder) this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private boolean drainOutputBuffer(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, Gav1DecoderException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.outputBuffer == null) {
            this.outputBuffer = this.decoder.dequeueOutputBuffer();
            if (this.outputBuffer == null) {
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
            this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
            }
            return false;
        }
        boolean zProcessOutputBuffer = processOutputBuffer(OplusGLSurfaceView_15, j2);
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return zProcessOutputBuffer;
    }

    private boolean processOutputBuffer(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, Gav1DecoderException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = OplusGLSurfaceView_15;
        }
        long j3 = this.outputBuffer.timeUs - OplusGLSurfaceView_15;
        if (this.outputMode == -1) {
            if (!isBufferLate(j3)) {
                return false;
            }
            skipOutputBuffer(this.outputBuffer);
            return true;
        }
        long j4 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
        Format formatPollFloor = this.formatQueue.pollFloor(j4);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        boolean z = getState() == 2;
        if (!this.renderedFirstFrame || (z && shouldForceRenderOutputBuffer(j3, jElapsedRealtime - this.lastRenderTimeUs))) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j4, System.nanoTime(), this.outputFormat);
            }
            renderOutputBuffer(this.outputBuffer);
            return true;
        }
        if (!z || OplusGLSurfaceView_15 == this.initialPositionUs || (shouldDropBuffersToKeyframe(j3, j2) && maybeDropBuffersToKeyframe(OplusGLSurfaceView_15))) {
            return false;
        }
        if (shouldDropOutputBuffer(j3, j2)) {
            dropOutputBuffer(this.outputBuffer);
            return true;
        }
        if (j3 < 30000) {
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.frameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j4, System.nanoTime(), this.outputFormat);
            }
            renderOutputBuffer(this.outputBuffer);
            return true;
        }
        return false;
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        if (this.drmSession == null || (!z && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = this.drmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
    }

    private void renderRgbFrame(Gav1OutputBuffer gav1OutputBuffer, boolean z) throws Surface.OutOfResourcesException, IllegalArgumentException {
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.getWidth() != gav1OutputBuffer.width || this.bitmap.getHeight() != gav1OutputBuffer.height) {
            this.bitmap = Bitmap.createBitmap(gav1OutputBuffer.width, gav1OutputBuffer.height, Bitmap.Config.RGB_565);
        }
        this.bitmap.copyPixelsFromBuffer(gav1OutputBuffer.data);
        Canvas canvasLockCanvas = this.surface.lockCanvas(null);
        if (z) {
            canvasLockCanvas.scale(canvasLockCanvas.getWidth() / gav1OutputBuffer.width, canvasLockCanvas.getHeight() / gav1OutputBuffer.height);
        }
        canvasLockCanvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
        this.surface.unlockCanvasAndPost(canvasLockCanvas);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
    }

    private void maybeNotifyVideoSizeChanged(int OplusGLSurfaceView_13, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.reportedWidth == OplusGLSurfaceView_13 && this.reportedHeight == i2) {
            return;
        }
        this.reportedWidth = OplusGLSurfaceView_13;
        this.reportedHeight = i2;
        this.eventDispatcher.videoSizeChanged(OplusGLSurfaceView_13, i2, 0, 1.0f);
    }

    private void maybeRenotifyVideoSizeChanged() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.reportedWidth == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, 0, 1.0f);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }
}
