package com.cdv.p098io;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class NvAndroidVideoFileReader implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DECODER_FEED_STATUS_Error = 3;
    private static final int DECODER_FEED_STATUS_Finish = 2;
    private static final int DECODER_FEED_STATUS_None = 0;
    private static final int DECODER_FEED_STATUS_Start = 1;
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final String TAG = "NvAndroidVideoFileReader";
    private static Method m_setOnFrameAvailableListener2;
    private static final boolean m_verbose = false;
    private MediaCodec.BufferInfo m_bufferInfo;
    private Handler m_cleanupHandler;
    private Context m_context;
    private Handler m_handler;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private Semaphore m_surfaceTextureCreationSemaphore;
    private int m_texId;
    private boolean m_usedAsyncDecodeMode;
    private int m_videoColorTransferCharacteristic;
    private String m_videoFilePath;
    private MediaExtractor m_extractor = null;
    private int m_videoTrackIndex = -1;
    private MediaFormat m_format = null;
    private long m_duration = 0;
    private boolean m_extractorInOriginalState = true;
    private SurfaceTexture m_surfaceTexture = null;
    private Surface m_surface = null;
    private MediaCodec m_decoder = null;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    ByteBuffer[] m_decoderInputBuffers = null;
    private Object m_frameSyncObject = new Object();
    private boolean m_frameAvailable = false;
    private long m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
    private long m_timestampOfCurTexFrame = Long.MIN_VALUE;
    private boolean m_curTexImageUpdated = false;
    private boolean m_firstPlaybackTexFrameUnconsumed = false;
    private boolean m_sawOutputEOS = false;
    private long m_preloadedTimestamp = Long.MIN_VALUE;
    private long m_lastSeekTimestamp = Long.MIN_VALUE;
    private long m_lastSeekActualTimestamp = Long.MIN_VALUE;
    private int m_usedTemporalLayer = -1;
    private long m_temporalLayerEndTime = -1;
    private boolean m_onlyDecodeKeyFrame = false;
    private long m_contiuousDecodingThreshold = 1500000;
    private boolean m_inputBufferQueued = false;
    private boolean m_sawInputEOS = false;
    private boolean m_skipNonReferenceFrameWhenPlayback = false;
    private AtomicLong m_timestampOfLastInputFrame = new AtomicLong(Long.MIN_VALUE);
    private AtomicInteger m_pendingInputFrameCount = new AtomicInteger(0);
    private HandlerThread m_feedVideoDecoderThread = null;
    private Handler m_feedVideoDecoderHandler = null;
    private int m_feedDecoderStatus = 0;
    private boolean m_feedDecoderStopping = false;
    private Object m_feedDecoderSyncObject = new Object();

    public void preload(long OplusGLSurfaceView_15) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                m_setOnFrameAvailableListener2 = SurfaceTexture.class.getDeclaredMethod("setOnFrameAvailableListener", SurfaceTexture.OnFrameAvailableListener.class, Handler.class);
                Log.IntrinsicsJvm.kt_5(TAG, "New SurfaceTexture.setOnFrameAvailableListener() method is available!");
            } catch (Exception unused) {
                m_setOnFrameAvailableListener2 = null;
            }
        }
    }

    NvAndroidVideoFileReader(Handler handler, Handler handler2) {
        this.m_handler = null;
        this.m_cleanupHandler = null;
        this.m_bufferInfo = null;
        this.m_usedAsyncDecodeMode = Build.VERSION.SDK_INT >= 28;
        this.m_videoColorTransferCharacteristic = 0;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        r9.m_videoTrackIndex = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean OpenFile(java.lang.String r10, int r11, android.content.Context r12, int r13, long r14) throws java.lang.IllegalAccessException, java.lang.InterruptedException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.p098io.NvAndroidVideoFileReader.OpenFile(java.lang.String, int, android.content.Context, int, long):boolean");
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void enableOnlyDecodeKeyFrame(boolean z) {
        this.m_onlyDecodeKeyFrame = z;
    }

    public void setActualDuration(long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 > this.m_duration) {
            this.m_duration = OplusGLSurfaceView_15;
        }
    }

    public void setInterruptionChecker(NvAndroidInterruptionChecker nvAndroidInterruptionChecker) {
        this.m_interruptionChecker = nvAndroidInterruptionChecker;
    }

    public void skipNonReferenceFrame(boolean z) {
        this.m_skipNonReferenceFrameWhenPlayback = z;
    }

    public void CloseFile() {
        InvalidLastSeekTimestamp();
        if (this.m_usedAsyncDecodeMode) {
            BreakFeedVideoDecoder();
            CloseFeedVideoDecoderThread();
        }
        try {
            CleanupDecoder(true);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0L;
            this.m_extractorInOriginalState = true;
        }
        this.m_usedTemporalLayer = -1;
        this.m_temporalLayerEndTime = -1L;
        this.m_onlyDecodeKeyFrame = false;
        this.m_videoFilePath = null;
        this.m_context = null;
    }

    public void SetDecodeTemporalLayer(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_13 == this.m_usedTemporalLayer) {
            return;
        }
        this.m_temporalLayerEndTime = OplusGLSurfaceView_15;
        this.m_usedTemporalLayer = OplusGLSurfaceView_13;
    }

    public int SeekVideoFrame(long OplusGLSurfaceView_15, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long jMax = Math.max(OplusGLSurfaceView_15, 0L);
        long j3 = this.m_duration;
        if (jMax >= j3) {
            if (jMax >= 40000 + j3) {
                return 1;
            }
            jMax = j3 - 1;
        }
        long j4 = this.m_timestampOfCurTexFrame;
        if (j4 != Long.MIN_VALUE && Math.abs(jMax - j4) <= j2) {
            return 0;
        }
        int iSeekInternal = SeekInternal(jMax, j2, false, this.m_onlyDecodeKeyFrame ? 0 : 2, false);
        if (iSeekInternal == 0) {
            this.m_lastSeekTimestamp = jMax;
            this.m_lastSeekActualTimestamp = this.m_timestampOfCurTexFrame;
        } else {
            InvalidLastSeekTimestamp();
        }
        return iSeekInternal;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int StartPlayback(long r11, long r13) {
        /*
            r10 = this;
            boolean r0 = r10.IsValid()
            r8 = 1
            if (r0 != 0) goto L8
            return r8
        L8:
            r0 = 0
            long r0 = java.lang.Math.max(r11, r0)
            long r2 = r10.m_duration
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L15
            return r8
        L15:
            long r2 = r10.m_preloadedTimestamp
            r4 = -9223372036854775808
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L2b
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L28
            long r2 = r10.m_timestampOfCurTexFrame
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L28
            r0 = r2
        L28:
            r10.m_preloadedTimestamp = r4
            goto L3d
        L2b:
            long r2 = r10.m_lastSeekTimestamp
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L3d
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L3d
            long r2 = r10.m_lastSeekActualTimestamp
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L3d
            r1 = r2
            goto L3e
        L3d:
            r1 = r0
        L3e:
            long r3 = r10.m_timestampOfCurTexFrame
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r9 = 0
            if (r0 != 0) goto L4e
            long r5 = r10.m_timestampOfLastDecodedFrame
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L4e
            r10.m_firstPlaybackTexFrameUnconsumed = r8
            return r9
        L4e:
            r5 = 0
            r6 = 2
            boolean r7 = r10.m_usedAsyncDecodeMode
            r0 = r10
            r3 = r13
            int r0 = r0.SeekInternal(r1, r3, r5, r6, r7)
            r10.InvalidLastSeekTimestamp()
            if (r0 == 0) goto L5e
            return r0
        L5e:
            r10.m_firstPlaybackTexFrameUnconsumed = r8
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.p098io.NvAndroidVideoFileReader.StartPlayback(long, long):int");
    }

    public int GetNextVideoFrameForPlayback() {
        if (!IsValid()) {
            return 1;
        }
        if (!this.m_firstPlaybackTexFrameUnconsumed) {
            boolean z = this.m_skipNonReferenceFrameWhenPlayback;
            int iDecodeToFrame = DecodeToFrame(Long.MIN_VALUE, 0L, false, z ? 1 : 0, this.m_usedAsyncDecodeMode);
            InvalidLastSeekTimestamp();
            if (iDecodeToFrame != 0) {
                return iDecodeToFrame;
            }
        } else {
            this.m_firstPlaybackTexFrameUnconsumed = false;
        }
        return 0;
    }

    public long GetTimestampOfCurrentTextureFrame() {
        return this.m_timestampOfCurTexFrame;
    }

    public void GetTransformMatrixOfSurfaceTexture(float[] fArr) {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(fArr);
        }
    }

    public void updateCurTexImage() {
        try {
            if (this.m_timestampOfCurTexFrame == Long.MIN_VALUE || this.m_curTexImageUpdated) {
                return;
            }
            if (this.m_surfaceTexture != null) {
                this.m_surfaceTexture.updateTexImage();
            }
            this.m_curTexImageUpdated = true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.m_frameSyncObject) {
            if (this.m_frameAvailable) {
                Log.COUIBaseListPopupWindow_8(TAG, "m_frameAvailable already set, frame could be dropped!");
            }
            this.m_frameAvailable = true;
            this.m_frameSyncObject.notifyAll();
        }
    }

    private boolean IsValid() {
        return this.m_decoder != null;
    }

    private boolean recreateMediaExtractor() throws Exception {
        try {
            this.m_extractor.release();
            this.m_extractor = NvAndroidUtils.createMediaExtractorFromMediaFilePath(this.m_context, this.m_videoFilePath);
            if (this.m_extractor == null) {
                throw new Exception("Failed to re-create media extractor!");
            }
            this.m_extractor.selectTrack(this.m_videoTrackIndex);
            this.m_extractorInOriginalState = true;
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0L;
            this.m_extractorInOriginalState = true;
            CloseFile();
            return false;
        }
    }

    private boolean SetupDecoder(String str) {
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, this.m_surface, (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private void CleanupDecoder(boolean z) {
        updateCurTexImage();
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers(true);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (!z) {
            CleanupDecoderCore(false);
        } else {
            this.m_cleanupHandler.post(new Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReader.2
                @Override // java.lang.Runnable
                public void run() {
                    NvAndroidVideoFileReader.this.CleanupDecoderCore(true);
                }
            });
        }
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_pendingInputFrameCount.set(0);
        this.m_timestampOfLastInputFrame.set(Long.MIN_VALUE);
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CleanupDecoderCore(boolean z) {
        MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            if (this.m_decoderStarted) {
                try {
                    if (this.m_inputBufferQueued) {
                        try {
                            mediaCodec.flush();
                        } catch (Exception unused) {
                        }
                        this.m_inputBufferQueued = false;
                    }
                    this.m_decoder.stop();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                this.m_decoderStarted = false;
                this.m_decoderInputBuffers = null;
            }
            this.m_decoder.release();
            this.m_decoder = null;
        }
        if (z) {
            Surface surface = this.m_surface;
            if (surface != null) {
                surface.release();
                this.m_surface = null;
            }
            SurfaceTexture surfaceTexture = this.m_surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.m_surfaceTexture = null;
            }
        }
    }

    private int SeekInternal(long OplusGLSurfaceView_15, long j2, boolean z, int OplusGLSurfaceView_13, boolean z2) {
        long j3 = this.m_timestampOfLastDecodedFrame;
        boolean z3 = true;
        if ((j3 == Long.MIN_VALUE || OplusGLSurfaceView_15 <= j3 || OplusGLSurfaceView_15 >= j3 + this.m_contiuousDecodingThreshold) && (!this.m_extractorInOriginalState || OplusGLSurfaceView_15 >= this.m_contiuousDecodingThreshold)) {
            z3 = false;
        }
        if (!z2 && this.m_feedDecoderStatus != 0) {
            z3 = false;
        }
        if (this.m_onlyDecodeKeyFrame) {
            z3 = false;
        }
        if (!z3) {
            try {
                BreakFeedVideoDecoder();
                this.m_extractor.seekTo(OplusGLSurfaceView_15, 0);
                if (this.m_extractor.getSampleTime() < 0 && OplusGLSurfaceView_15 < this.m_duration - 100000) {
                    Log.w(TAG, "Try to recreate MediaExtractor!");
                    if (!recreateMediaExtractor()) {
                        Log.COUIBaseListPopupWindow_8(TAG, "Failed to recreate MediaExtractor!");
                        CloseFile();
                        return 2;
                    }
                    this.m_extractor.seekTo(OplusGLSurfaceView_15, 0);
                }
                if (this.m_sawInputEOS || this.m_sawOutputEOS) {
                    CleanupDecoder(false);
                    if (!SetupDecoder(this.m_format.getString(IMediaFormat.KEY_MIME))) {
                        return 2;
                    }
                } else if (this.m_inputBufferQueued) {
                    try {
                        this.m_decoder.flush();
                    } catch (Exception unused) {
                    }
                    this.m_inputBufferQueued = false;
                    this.m_pendingInputFrameCount.set(0);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
                return 2;
            }
        }
        return DecodeToFrame(OplusGLSurfaceView_15, j2, z, OplusGLSurfaceView_13, z2);
    }

    private int DecodeToFrame(long OplusGLSurfaceView_15, long j2, boolean z, int OplusGLSurfaceView_13, boolean z2) {
        try {
            return DoDecodeToFrame(OplusGLSurfaceView_15, j2, z, OplusGLSurfaceView_13, z2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            this.CleanupDecoder(false);
            return 2;
        }
    }

    private int DoDecodeToFrame(long OplusGLSurfaceView_15, long j2, boolean z, int OplusGLSurfaceView_13, boolean z2) throws MediaCodec.CryptoException {
        boolean z3;
        int i2;
        boolean z4;
        int iMax = Math.max(this.m_decoderInputBuffers.length / 3, 2);
        if (z2) {
            FeedVideoDecoderTask();
        }
        boolean z5 = false;
        int i3 = 0;
        do {
            if (this.m_sawOutputEOS) {
                if (OplusGLSurfaceView_15 != Long.MIN_VALUE && this.m_timestampOfCurTexFrame != Long.MIN_VALUE) {
                    if (z5) {
                        return 0;
                    }
                    if (this.m_sawInputEOS) {
                        long j3 = this.m_timestampOfLastInputFrame.get();
                        if (j3 != Long.MIN_VALUE && this.m_timestampOfCurTexFrame >= j3) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
            if (isInterruptedDecoding()) {
                Log.IntrinsicsJvm.kt_5(TAG, "Interrupted video Decoding ");
                return 3;
            }
            if (!z2 && !this.m_sawInputEOS) {
                FeedVideoDecoder(this.m_decoder.dequeueInputBuffer(4000L));
            }
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (this.m_pendingInputFrameCount.get() > iMax || this.m_sawInputEOS || z2) ? ErrorCode.REASON_DS_ASSET : 0);
            i3++;
            if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3) {
                if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.m_decoder.getOutputFormat();
                    if (outputFormat.containsKey("color-transfer")) {
                        this.m_videoColorTransferCharacteristic = outputFormat.getInteger("color-transfer");
                    }
                } else {
                    if (iDequeueOutputBuffer < 0) {
                        Log.COUIBaseListPopupWindow_8(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                        return 2;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    if (this.m_sawOutputEOS) {
                        z3 = false;
                        i2 = i3;
                        z4 = false;
                    } else {
                        this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
                        this.m_pendingInputFrameCount.decrementAndGet();
                        if (OplusGLSurfaceView_15 != Long.MIN_VALUE) {
                            z4 = this.m_timestampOfLastDecodedFrame >= OplusGLSurfaceView_15 - j2;
                            if (z4 || !this.m_sawInputEOS || z) {
                                z3 = false;
                                i2 = 0;
                            } else {
                                long j4 = this.m_timestampOfLastInputFrame.get();
                                if (j4 == Long.MIN_VALUE || this.m_timestampOfLastDecodedFrame < j4) {
                                    z3 = false;
                                } else {
                                    z5 = true;
                                    z4 = true;
                                    z3 = true;
                                }
                                i2 = 0;
                            }
                        } else {
                            z3 = false;
                            i2 = 0;
                            z4 = true;
                        }
                    }
                    boolean z6 = this.m_onlyDecodeKeyFrame ? true : z4;
                    if (z6) {
                        if (!z) {
                            updateCurTexImage();
                        }
                        synchronized (this.m_frameSyncObject) {
                            this.m_frameAvailable = false;
                        }
                    }
                    this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, z6);
                    if (z6) {
                        boolean z7 = !z;
                        if (AwaitNewImage(z7)) {
                            this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
                            this.m_curTexImageUpdated = z7;
                            if (!z3) {
                                return 0;
                            }
                        } else {
                            Log.COUIBaseListPopupWindow_8(TAG, "Render decoded frame to surface texture failed!");
                            return 2;
                        }
                    }
                    i3 = i2;
                }
            }
            if (this.m_feedDecoderStatus == 3) {
                return 2;
            }
        } while (i3 <= 100);
        Log.COUIBaseListPopupWindow_8(TAG, "We have tried too many times and can't decode PlatformImplementations.kt_3 frame!");
        return 2;
    }

    private boolean isNonReferenceFrame(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return false;
        }
        byte[] bArr = new byte[5];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && (bArr[4] & 31) == 1 && ((bArr[4] >> 5) & 3) == 0;
    }

    private boolean canSkipFrame(ByteBuffer byteBuffer, long OplusGLSurfaceView_15) {
        if (byteBuffer == null || this.m_usedTemporalLayer <= 0 || OplusGLSurfaceView_15 >= this.m_temporalLayerEndTime) {
            return false;
        }
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        int OplusGLSurfaceView_13 = bArr[4] & 31;
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && (OplusGLSurfaceView_13 == 14 || OplusGLSurfaceView_13 == 20)) {
            if (!(((bArr[5] & 255) >> 7) > 0) || (((bArr[7] & 255) >> 5) & 7) <= this.m_usedTemporalLayer) {
                return false;
            }
        } else if (this.m_usedTemporalLayer <= 0) {
            return false;
        }
        return true;
    }

    private boolean AwaitNewImage(boolean z) {
        synchronized (this.m_frameSyncObject) {
            while (!this.m_frameAvailable) {
                try {
                    this.m_frameSyncObject.wait(3000L);
                    if (!this.m_frameAvailable) {
                        Log.COUIBaseListPopupWindow_8(TAG, "Frame wait timed out!");
                        return false;
                    }
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return false;
                }
            }
            this.m_frameAvailable = false;
            if (!z) {
                return true;
            }
            try {
                this.m_surfaceTexture.updateTexImage();
                return true;
            } catch (Exception e2) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + e2.getMessage());
                e2.printStackTrace();
                return false;
            }
        }
    }

    private void DrainOutputBuffers(boolean z) {
        if (z || (this.m_sawInputEOS && !this.m_sawOutputEOS)) {
            int OplusGLSurfaceView_13 = 0;
            while (!this.m_sawOutputEOS) {
                int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                OplusGLSurfaceView_13++;
                if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3 && iDequeueOutputBuffer != -2) {
                    if (iDequeueOutputBuffer < 0) {
                        Log.COUIBaseListPopupWindow_8(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                        return;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    OplusGLSurfaceView_13 = 0;
                }
                if (OplusGLSurfaceView_13 > 100) {
                    Log.COUIBaseListPopupWindow_8(TAG, "DrainDecoderBuffers(): We have tried too many times and can't decode PlatformImplementations.kt_3 frame!");
                    return;
                }
            }
        }
    }

    private void InvalidLastSeekTimestamp() {
        this.m_lastSeekTimestamp = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = Long.MIN_VALUE;
    }

    private boolean isInterruptedDecoding() {
        NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }

    private void CreateFeedVideoDecoderThread() {
        if (this.m_feedVideoDecoderThread != null) {
            return;
        }
        this.m_feedVideoDecoderThread = new HandlerThread("feed video decoder handler");
        this.m_feedVideoDecoderThread.start();
        this.m_feedVideoDecoderHandler = new Handler(this.m_feedVideoDecoderThread.getLooper());
    }

    private void CloseFeedVideoDecoderThread() {
        HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread == null) {
            return;
        }
        if (handlerThread.isAlive()) {
            this.m_feedVideoDecoderThread.quitSafely();
        }
        try {
            this.m_feedVideoDecoderThread.join();
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.m_feedVideoDecoderHandler = null;
        this.m_feedVideoDecoderThread = null;
    }

    private boolean FeedVideoDecoderTask() {
        HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            Log.COUIBaseListPopupWindow_8(TAG, "FeedVideoDecoderTask thread in invalid!");
            return false;
        }
        if (this.m_feedDecoderStatus != 0) {
            return true;
        }
        this.m_feedDecoderStatus = 1;
        this.m_feedDecoderStopping = false;
        this.m_feedVideoDecoderHandler.post(new Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReader.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NvAndroidVideoFileReader.this.FeedVideoDecoderInThread();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(NvAndroidVideoFileReader.TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                    NvAndroidVideoFileReader.this.m_feedDecoderStatus = 3;
                }
            }
        });
        return true;
    }

    private void BreakFeedVideoDecoder() {
        int OplusGLSurfaceView_13 = this.m_feedDecoderStatus;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            this.m_feedDecoderStatus = 0;
            this.m_feedDecoderStopping = false;
            return;
        }
        this.m_feedDecoderStopping = true;
        if (this.m_inputBufferQueued && OplusGLSurfaceView_13 != 2) {
            DrainOutputBuffersForFeedFinish();
        }
        System.currentTimeMillis();
        synchronized (this.m_feedDecoderSyncObject) {
            if (this.m_feedDecoderStatus != 2) {
                try {
                    this.m_feedDecoderSyncObject.wait(30000L);
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
        this.m_feedDecoderStatus = 0;
        this.m_feedDecoderStopping = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FeedVideoDecoderInThread() throws MediaCodec.CryptoException {
        this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
        while (!this.m_sawInputEOS) {
            int iDequeueInputBuffer = this.m_decoder.dequeueInputBuffer(-1L);
            if (this.m_feedDecoderStopping) {
                break;
            } else {
                FeedVideoDecoder(iDequeueInputBuffer);
            }
        }
        synchronized (this.m_feedDecoderSyncObject) {
            this.m_feedDecoderStatus = 2;
            this.m_feedDecoderSyncObject.notifyAll();
        }
    }

    private void FeedVideoDecoder(int OplusGLSurfaceView_13) throws MediaCodec.CryptoException {
        int sampleData;
        long sampleTime;
        if (OplusGLSurfaceView_13 >= 0) {
            ByteBuffer byteBuffer = this.m_decoderInputBuffers[OplusGLSurfaceView_13];
            while (true) {
                sampleData = this.m_extractor.readSampleData(byteBuffer, 0);
                if (sampleData < 0) {
                    this.m_decoder.queueInputBuffer(OplusGLSurfaceView_13, 0, 0, 0L, 4);
                    this.m_sawInputEOS = true;
                    return;
                }
                if (this.m_extractor.getSampleTrackIndex() != this.m_videoTrackIndex) {
                    Log.w(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_videoTrackIndex);
                }
                sampleTime = this.m_extractor.getSampleTime();
                if (((this.m_extractor.getSampleFlags() & 1) != 0) || !canSkipFrame(byteBuffer, sampleTime)) {
                    break;
                }
                this.m_extractor.advance();
                this.m_extractorInOriginalState = false;
            }
            this.m_timestampOfLastInputFrame.set(sampleTime);
            this.m_decoder.queueInputBuffer(OplusGLSurfaceView_13, 0, sampleData, sampleTime, 0);
            this.m_inputBufferQueued = true;
            this.m_pendingInputFrameCount.incrementAndGet();
            this.m_extractor.advance();
            this.m_extractorInOriginalState = false;
        }
    }

    private void DrainOutputBuffersForFeedFinish() {
        if (this.m_sawOutputEOS) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        while (!this.m_sawOutputEOS) {
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, 1000L);
            if (this.m_feedDecoderStatus == 2) {
                return;
            }
            OplusGLSurfaceView_13++;
            if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3 && iDequeueOutputBuffer != -2) {
                if (iDequeueOutputBuffer < 0) {
                    Log.COUIBaseListPopupWindow_8(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                    return;
                }
                if ((this.m_bufferInfo.flags & 4) != 0) {
                    this.m_sawOutputEOS = true;
                }
                this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                OplusGLSurfaceView_13 = 0;
            }
            if (OplusGLSurfaceView_13 > 100) {
                Log.COUIBaseListPopupWindow_8(TAG, "DrainDecoderBuffers(): We have tried too many times and can't decode PlatformImplementations.kt_3 frame!");
                return;
            }
        }
    }
}
