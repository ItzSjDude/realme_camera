package com.oplus.tblplayer.ffmpeg;

import android.content.Context;
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
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.exception.VideoDecoderException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public abstract class SimpleDecoderVideoRenderer extends BaseRenderer {
    private static final boolean DEBUG = true;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "SimpleVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private FfmpegOplusVideoDecoder decoder;
    private DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private DrmSession<ExoMediaCrypto> drmSession;
    private final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private long fastRendererTimeUs;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private boolean forceRenderFrame;
    protected final FormatHolder formatHolder;
    private long initialPositionUs;
    private FfmpegVideoInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastPresentTimeUs;
    private long lastRenderTimeUs;
    private Context mAppContext;
    protected final int maxDroppedFramesToNotify;
    private boolean needDropFrame;
    private FrameOutputBuffer nextOutputBuffer;
    private FrameOutputBuffer outputBuffer;
    private int outputHeight;
    private boolean outputStreamEnded;
    private int outputWidth;
    private DrmSession<ExoMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private Surface surface;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 < -30000;
    }

    private static boolean isBufferVeryLate(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 < -500000;
    }

    protected abstract FfmpegOplusVideoDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws VideoDecoderException;

    protected boolean shouldForceRenderOutputBuffer(long OplusGLSurfaceView_15, long j2) {
        return OplusGLSurfaceView_15 == Long.MIN_VALUE && j2 > 100000;
    }

    protected abstract int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager, Format format);

    public SimpleDecoderVideoRenderer() {
        this(0L);
    }

    public SimpleDecoderVideoRenderer(long OplusGLSurfaceView_15) {
        this(null, OplusGLSurfaceView_15, null, null, 0);
    }

    public SimpleDecoderVideoRenderer(Context context, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        this(context, OplusGLSurfaceView_15, handler, videoRendererEventListener, OplusGLSurfaceView_13, null, false);
    }

    public SimpleDecoderVideoRenderer(Context context, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13, DrmSessionManager<ExoMediaCrypto> drmSessionManager, boolean z) {
        super(2);
        this.mAppContext = context;
        this.allowedJoiningTimeMs = OplusGLSurfaceView_15;
        this.maxDroppedFramesToNotify = OplusGLSurfaceView_13;
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatHolder = new FormatHolder();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.initialPositionUs = -9223372036854775807L;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.needDropFrame = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException, InterruptedException {
        if (this.outputStreamEnded) {
            FfmpegUtil.m25442d(TAG, Integer.toHexString(hashCode()) + " outputStreamEnded");
            return;
        }
        if (this.inputFormat == null) {
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
                while (drainOutputBuffer(OplusGLSurfaceView_15)) {
                }
                while (feedInputBuffer()) {
                }
                TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (VideoDecoderException COUIBaseListPopupWindow_8) {
                throw ExoPlaybackException.createForRenderer(COUIBaseListPopupWindow_8, getIndex());
            }
        }
    }

    private void onInputFormatChanged(Format format) throws ExoPlaybackException, InterruptedException {
        FfmpegUtil.m25442d(TAG, "onInputFormatChanged: " + Integer.toHexString(hashCode()));
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        if (!Util.areEqual(this.inputFormat.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.inputFormat.drmInitData != null) {
                DrmSessionManager<ExoMediaCrypto> drmSessionManager = this.drmSessionManager;
                if (drmSessionManager == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires PlatformImplementations.kt_3 DrmSessionManager"), getIndex());
                }
                this.pendingDrmSession = drmSessionManager.acquireSession(Looper.myLooper(), this.inputFormat.drmInitData);
                DrmSession<ExoMediaCrypto> drmSession = this.pendingDrmSession;
                if (drmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(drmSession);
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        DrmSession<ExoMediaCrypto> drmSession2 = this.pendingDrmSession;
        DrmSession<ExoMediaCrypto> drmSession3 = this.drmSession;
        if (drmSession2 != drmSession3 || (drmSession2 == null && drmSession3 == null)) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        ExoMediaCrypto mediaCrypto = null;
        DrmSession<ExoMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null && (mediaCrypto = drmSession.getMediaCrypto()) == null) {
            DrmSession.DrmSessionException error = this.drmSession.getError();
            if (error != null) {
                throw ExoPlaybackException.createForRenderer(error, getIndex());
            }
            return;
        }
        try {
            FfmpegUtil.m25442d(TAG, "maybeInitDecoder: createVideoDecoder");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createVideoDecoder");
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
            TraceUtil.endSection();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.eventDispatcher.decoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (VideoDecoderException COUIBaseListPopupWindow_8) {
            throw ExoPlaybackException.createForRenderer(COUIBaseListPopupWindow_8, getIndex());
        }
    }

    private void releaseDecoder() throws InterruptedException {
        FfmpegUtil.m25442d(TAG, "releaseDecoder: ");
        FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
        if (ffmpegOplusVideoDecoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.nextOutputBuffer = null;
        if (this.surface != null) {
            ffmpegOplusVideoDecoder.updateRenderSurface(null);
        }
        this.decoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.forceRenderFrame = false;
        this.buffersInCodecCount = 0;
        Surface surface = this.dummySurface;
        if (surface != null) {
            if (this.surface == surface) {
                this.surface = null;
            }
            this.dummySurface.release();
            this.dummySurface = null;
        }
    }

    private void renderToEndOfStream() throws ExoPlaybackException {
        this.needDropFrame = false;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean drainOutputBuffer(long OplusGLSurfaceView_15) throws ExoPlaybackException, IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, VideoDecoderException, IllegalArgumentException, InvocationTargetException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = OplusGLSurfaceView_15;
        }
        if (this.outputBuffer == null) {
            FrameOutputBuffer frameOutputBuffer = this.nextOutputBuffer;
            if (frameOutputBuffer != null) {
                this.outputBuffer = frameOutputBuffer;
                this.nextOutputBuffer = null;
            } else {
                this.outputBuffer = this.decoder.dequeueOutputBuffer();
            }
            if (this.outputBuffer == null) {
                FfmpegUtil.m25442d(TAG, "drainOutputBuffer:  no buffers");
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
            this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.nextOutputBuffer == null) {
            this.nextOutputBuffer = this.decoder.dequeueOutputBuffer();
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
                renderToEndOfStream();
            }
            return false;
        }
        if (this.outputBuffer.timeUs >= this.initialPositionUs) {
            this.needDropFrame = false;
        }
        this.lastPresentTimeUs = this.outputBuffer.timeUs;
        if (this.needDropFrame) {
            long j2 = this.fastRendererTimeUs;
            if (j2 == -9223372036854775807L || j2 > this.lastPresentTimeUs) {
                FfmpegUtil.m25442d(TAG, "need drop timeUs:" + this.lastPresentTimeUs);
                dropBuffer();
                this.buffersInCodecCount = this.buffersInCodecCount - 1;
                return true;
            }
        }
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(this.outputBuffer.timeUs - OplusGLSurfaceView_15)) {
                return false;
            }
            this.forceRenderFrame = false;
            skipBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        if (this.forceRenderFrame) {
            this.forceRenderFrame = false;
            renderBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        FrameOutputBuffer frameOutputBuffer2 = this.nextOutputBuffer;
        long j3 = (frameOutputBuffer2 == null || frameOutputBuffer2.isEndOfStream()) ? -9223372036854775807L : this.nextOutputBuffer.timeUs;
        long j4 = this.outputBuffer.timeUs - OplusGLSurfaceView_15;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        if (!this.renderedFirstFrame || (getState() == 2 && (j4 <= 30000 || shouldForceRenderOutputBuffer(this.outputBuffer.timeUs, jElapsedRealtime - this.lastRenderTimeUs)))) {
            renderBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        if (shouldDropBuffersToKeyframe(j4) && maybeDropBuffersToKeyframe(OplusGLSurfaceView_15)) {
            this.forceRenderFrame = true;
            return false;
        }
        if (!shouldDropOutputBuffer(this.outputBuffer.timeUs, j3, OplusGLSurfaceView_15, -9223372036854775807L)) {
            return false;
        }
        dropBuffer();
        this.buffersInCodecCount--;
        return true;
    }

    private boolean shouldDropOutputBuffer(long OplusGLSurfaceView_15, long j2, long j3, long j4) {
        return isBufferLate(OplusGLSurfaceView_15 - j3) && !(j4 == -9223372036854775807L && j2 == -9223372036854775807L);
    }

    private boolean shouldDropBuffersToKeyframe(long OplusGLSurfaceView_15) {
        return isBufferVeryLate(OplusGLSurfaceView_15);
    }

    private void renderBuffer() throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        FfmpegUtil.m25442d(TAG, "renderBuffer start");
        if (this.surface == null) {
            dropBuffer();
            return;
        }
        if (this.outputBuffer.width != this.outputWidth || this.outputBuffer.height != this.outputHeight) {
            this.outputWidth = this.outputBuffer.width;
            this.outputHeight = this.outputBuffer.height;
            FfmpegUtil.m25442d(TAG, "renderBuffer: videoSizeChanged [" + this.outputWidth + " x " + this.outputHeight + "]");
        }
        maybeNotifyVideoSizeChanged(this.outputBuffer.width, this.outputBuffer.height);
        try {
            if (this.outputBuffer.data != null) {
                this.decoder.renderToSurface(this.outputBuffer, this.surface);
                this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
            }
        } catch (FfmpegVideoDecoderException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        FfmpegUtil.m25442d(TAG, "renderBuffer end");
        this.outputBuffer.release();
        this.outputBuffer = null;
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    private void dropBuffer() {
        FfmpegUtil.m25442d(TAG, "dropBuffer");
        updateDroppedBufferCounters(1);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private boolean maybeDropBuffersToKeyframe(long OplusGLSurfaceView_15) throws ExoPlaybackException, InterruptedException {
        int iSkipSource = skipSource(OplusGLSurfaceView_15);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushDecoder();
        return true;
    }

    private void updateDroppedBufferCounters(int OplusGLSurfaceView_13) {
        this.decoderCounters.droppedBufferCount += OplusGLSurfaceView_13;
        this.droppedFrames += OplusGLSurfaceView_13;
        this.consecutiveDroppedFrameCount += OplusGLSurfaceView_13;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    private void skipBuffer() {
        this.decoderCounters.skippedOutputBufferCount++;
        FfmpegUtil.m25442d(TAG, "skipBuffer: " + this.decoderCounters.skippedOutputBufferCount);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private void flushDecoder() throws ExoPlaybackException, InterruptedException {
        this.waitingForKeys = false;
        this.forceRenderFrame = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        FrameOutputBuffer frameOutputBuffer = this.outputBuffer;
        if (frameOutputBuffer != null) {
            frameOutputBuffer.release();
            this.outputBuffer = null;
        }
        FrameOutputBuffer frameOutputBuffer2 = this.nextOutputBuffer;
        if (frameOutputBuffer2 != null) {
            frameOutputBuffer2.release();
            this.nextOutputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private boolean feedInputBuffer() throws Exception {
        int source;
        FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
        if (ffmpegOplusVideoDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = ffmpegOplusVideoDecoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer((FfmpegOplusVideoDecoder) this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        if (this.waitingForKeys) {
            source = -4;
        } else {
            try {
                source = readSource(this.formatHolder, this.inputBuffer, false);
            } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                throw ExoPlaybackException.createForRenderer(new Exception(COUIBaseListPopupWindow_8), getIndex());
            }
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer((FfmpegOplusVideoDecoder) this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        this.inputBuffer.flip();
        queueInputBuffer(this.decoder, this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    protected void queueInputBuffer(SimpleDecoder<FfmpegVideoInputBuffer, ? extends FrameOutputBuffer, ? extends VideoDecoderException> simpleDecoder, FfmpegVideoInputBuffer ffmpegVideoInputBuffer) throws Exception {
        simpleDecoder.queueInputBuffer((SimpleDecoder<FfmpegVideoInputBuffer, ? extends FrameOutputBuffer, ? extends VideoDecoderException>) ffmpegVideoInputBuffer);
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

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int OplusGLSurfaceView_13, Object obj) throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (OplusGLSurfaceView_13 == 1) {
            setSurface((Surface) obj);
        } else {
            if (OplusGLSurfaceView_13 == 4) {
                return;
            }
            super.handleMessage(OplusGLSurfaceView_13, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else if (this.decoder != null) {
                this.dummySurface = DummySurface.newInstanceV17(this.mAppContext, false);
                surface = this.dummySurface;
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
                if (ffmpegOplusVideoDecoder != null && surface != null) {
                    ffmpegOplusVideoDecoder.updateRenderSurface(surface);
                } else {
                    FfmpegUtil.m25446i(TAG, "setSurface: Don't release SW decoder");
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (surface == null || surface == this.dummySurface) {
            return;
        }
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected boolean getRenderedFirstFrame() {
        return this.renderedFirstFrame;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected long getLastPresentTimeUs() {
        return this.lastPresentTimeUs;
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.fastRendererTimeUs = -9223372036854775807L;
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
        FfmpegUtil.m25442d(TAG, "maybeNotifyVideoSizeChanged: [" + OplusGLSurfaceView_13 + " x " + i2 + "]");
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

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || this.surface == null))) {
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
        super.onEnabled(z);
        this.decoderCounters = new DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long OplusGLSurfaceView_15, boolean z) throws ExoPlaybackException, InterruptedException {
        FfmpegUtil.m25442d(TAG, "onPositionReset: " + OplusGLSurfaceView_15);
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long OplusGLSurfaceView_15, boolean z) throws ExoPlaybackException {
        if (this.lastPresentTimeUs >= OplusGLSurfaceView_15) {
            FfmpegUtil.m25442d(TAG, "invalid positionUs:" + OplusGLSurfaceView_15 + ",lastPresentTimeUs:" + this.lastPresentTimeUs);
            return;
        }
        this.needDropFrame = true;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onSetFastRendererPosition(long OplusGLSurfaceView_15, boolean z) {
        FfmpegUtil.m25442d(TAG, "onSetFastRendererPosition positionUs:" + OplusGLSurfaceView_15);
        this.fastRendererTimeUs = OplusGLSurfaceView_15;
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
        this.inputFormat = null;
        this.waitingForKeys = false;
        this.outputWidth = -1;
        this.outputHeight = -1;
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

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) throws ExoPlaybackException {
        if (!FfmpegLibrary.isAvailable()) {
            FfmpegUtil.m25444e(TAG, "CoreLibrary not available");
            return 0;
        }
        int iSupportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
        if (iSupportsFormatInternal <= 2) {
            return iSupportsFormatInternal;
        }
        return iSupportsFormatInternal | (Util.SDK_INT >= 21 ? 32 : 0) | 8;
    }
}
