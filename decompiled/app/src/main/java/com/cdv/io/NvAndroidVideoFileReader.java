package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidVideoFileReader implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
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
    private static final java.lang.String TAG = "NvAndroidVideoFileReader";
    private static java.lang.reflect.Method m_setOnFrameAvailableListener2;
    private static final boolean m_verbose = false;
    private android.media.MediaCodec.BufferInfo m_bufferInfo;
    private android.os.Handler m_cleanupHandler;
    private android.content.Context m_context;
    private android.os.Handler m_handler;
    private com.cdv.utils.NvAndroidInterruptionChecker m_interruptionChecker;
    private java.util.concurrent.Semaphore m_surfaceTextureCreationSemaphore;
    private int m_texId;
    private boolean m_usedAsyncDecodeMode;
    private int m_videoColorTransferCharacteristic;
    private java.lang.String m_videoFilePath;
    private android.media.MediaExtractor m_extractor = null;
    private int m_videoTrackIndex = -1;
    private android.media.MediaFormat m_format = null;
    private long m_duration = 0;
    private boolean m_extractorInOriginalState = true;
    private android.graphics.SurfaceTexture m_surfaceTexture = null;
    private android.view.Surface m_surface = null;
    private android.media.MediaCodec m_decoder = null;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    java.nio.ByteBuffer[] m_decoderInputBuffers = null;
    private java.lang.Object m_frameSyncObject = new java.lang.Object();
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
    private java.util.concurrent.atomic.AtomicLong m_timestampOfLastInputFrame = new java.util.concurrent.atomic.AtomicLong(Long.MIN_VALUE);
    private java.util.concurrent.atomic.AtomicInteger m_pendingInputFrameCount = new java.util.concurrent.atomic.AtomicInteger(0);
    private android.os.HandlerThread m_feedVideoDecoderThread = null;
    private android.os.Handler m_feedVideoDecoderHandler = null;
    private int m_feedDecoderStatus = 0;
    private boolean m_feedDecoderStopping = false;
    private java.lang.Object m_feedDecoderSyncObject = new java.lang.Object();

    public void preload(long j_renamed) {
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            try {
                m_setOnFrameAvailableListener2 = android.graphics.SurfaceTexture.class.getDeclaredMethod("setOnFrameAvailableListener", android.graphics.SurfaceTexture.OnFrameAvailableListener.class, android.os.Handler.class);
                android.util.Log.d_renamed(TAG, "New SurfaceTexture.setOnFrameAvailableListener() method is_renamed available!");
            } catch (java.lang.Exception unused) {
                m_setOnFrameAvailableListener2 = null;
            }
        }
    }

    NvAndroidVideoFileReader(android.os.Handler handler, android.os.Handler handler2) {
        this.m_handler = null;
        this.m_cleanupHandler = null;
        this.m_bufferInfo = null;
        this.m_usedAsyncDecodeMode = android.os.Build.VERSION.SDK_INT >= 28;
        this.m_videoColorTransferCharacteristic = 0;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new android.media.MediaCodec.BufferInfo();
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:16:0x0040, code lost:
    
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
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.OpenFile(java.lang.String, int, android.content.Context, int, long):boolean");
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void enableOnlyDecodeKeyFrame(boolean z_renamed) {
        this.m_onlyDecodeKeyFrame = z_renamed;
    }

    public void setActualDuration(long j_renamed) {
        if (j_renamed > this.m_duration) {
            this.m_duration = j_renamed;
        }
    }

    public void setInterruptionChecker(com.cdv.utils.NvAndroidInterruptionChecker nvAndroidInterruptionChecker) {
        this.m_interruptionChecker = nvAndroidInterruptionChecker;
    }

    public void skipNonReferenceFrame(boolean z_renamed) {
        this.m_skipNonReferenceFrameWhenPlayback = z_renamed;
    }

    public void CloseFile() {
        InvalidLastSeekTimestamp();
        if (this.m_usedAsyncDecodeMode) {
            BreakFeedVideoDecoder();
            CloseFeedVideoDecoderThread();
        }
        try {
            CleanupDecoder(true);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        android.media.MediaExtractor mediaExtractor = this.m_extractor;
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

    public void SetDecodeTemporalLayer(int i_renamed, long j_renamed) {
        if (i_renamed == this.m_usedTemporalLayer) {
            return;
        }
        this.m_temporalLayerEndTime = j_renamed;
        this.m_usedTemporalLayer = i_renamed;
    }

    public int SeekVideoFrame(long j_renamed, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long jMax = java.lang.Math.max(j_renamed, 0L);
        long j3 = this.m_duration;
        if (jMax >= j3) {
            if (jMax >= 40000 + j3) {
                return 1;
            }
            jMax = j3 - 1;
        }
        long j4 = this.m_timestampOfCurTexFrame;
        if (j4 != Long.MIN_VALUE && java.lang.Math.abs(jMax - j4) <= j2) {
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

    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x005d A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x005e  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.StartPlayback(long, long):int");
    }

    public int GetNextVideoFrameForPlayback() {
        if (!IsValid()) {
            return 1;
        }
        if (!this.m_firstPlaybackTexFrameUnconsumed) {
            boolean z_renamed = this.m_skipNonReferenceFrameWhenPlayback;
            int iDecodeToFrame = DecodeToFrame(Long.MIN_VALUE, 0L, false, z_renamed ? 1 : 0, this.m_usedAsyncDecodeMode);
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
        android.graphics.SurfaceTexture surfaceTexture = this.m_surfaceTexture;
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
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        synchronized (this.m_frameSyncObject) {
            if (this.m_frameAvailable) {
                android.util.Log.e_renamed(TAG, "m_frameAvailable already set, frame could be_renamed dropped!");
            }
            this.m_frameAvailable = true;
            this.m_frameSyncObject.notifyAll();
        }
    }

    private boolean IsValid() {
        return this.m_decoder != null;
    }

    private boolean recreateMediaExtractor() throws java.lang.Exception {
        try {
            this.m_extractor.release();
            this.m_extractor = com.cdv.utils.NvAndroidUtils.createMediaExtractorFromMediaFilePath(this.m_context, this.m_videoFilePath);
            if (this.m_extractor == null) {
                throw new java.lang.Exception("Failed to re-create media extractor!");
            }
            this.m_extractor.selectTrack(this.m_videoTrackIndex);
            this.m_extractorInOriginalState = true;
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0L;
            this.m_extractorInOriginalState = true;
            CloseFile();
            return false;
        }
    }

    private boolean SetupDecoder(java.lang.String str) {
        try {
            this.m_decoder = android.media.MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, this.m_surface, (android.media.MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private void CleanupDecoder(boolean z_renamed) {
        updateCurTexImage();
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers(true);
                }
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
            }
        }
        if (!z_renamed) {
            CleanupDecoderCore(false);
        } else {
            this.m_cleanupHandler.post(new java.lang.Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReader.2
                @Override // java.lang.Runnable
                public void run() {
                    com.cdv.io.NvAndroidVideoFileReader.this.CleanupDecoderCore(true);
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
    public void CleanupDecoderCore(boolean z_renamed) {
        android.media.MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            if (this.m_decoderStarted) {
                try {
                    if (this.m_inputBufferQueued) {
                        try {
                            mediaCodec.flush();
                        } catch (java.lang.Exception unused) {
                        }
                        this.m_inputBufferQueued = false;
                    }
                    this.m_decoder.stop();
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                }
                this.m_decoderStarted = false;
                this.m_decoderInputBuffers = null;
            }
            this.m_decoder.release();
            this.m_decoder = null;
        }
        if (z_renamed) {
            android.view.Surface surface = this.m_surface;
            if (surface != null) {
                surface.release();
                this.m_surface = null;
            }
            android.graphics.SurfaceTexture surfaceTexture = this.m_surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.m_surfaceTexture = null;
            }
        }
    }

    private int SeekInternal(long j_renamed, long j2, boolean z_renamed, int i_renamed, boolean z2) {
        long j3 = this.m_timestampOfLastDecodedFrame;
        boolean z3 = true;
        if ((j3 == Long.MIN_VALUE || j_renamed <= j3 || j_renamed >= j3 + this.m_contiuousDecodingThreshold) && (!this.m_extractorInOriginalState || j_renamed >= this.m_contiuousDecodingThreshold)) {
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
                this.m_extractor.seekTo(j_renamed, 0);
                if (this.m_extractor.getSampleTime() < 0 && j_renamed < this.m_duration - 100000) {
                    android.util.Log.w_renamed(TAG, "Try to recreate MediaExtractor!");
                    if (!recreateMediaExtractor()) {
                        android.util.Log.e_renamed(TAG, "Failed to recreate MediaExtractor!");
                        CloseFile();
                        return 2;
                    }
                    this.m_extractor.seekTo(j_renamed, 0);
                }
                if (this.m_sawInputEOS || this.m_sawOutputEOS) {
                    CleanupDecoder(false);
                    if (!SetupDecoder(this.m_format.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME))) {
                        return 2;
                    }
                } else if (this.m_inputBufferQueued) {
                    try {
                        this.m_decoder.flush();
                    } catch (java.lang.Exception unused) {
                    }
                    this.m_inputBufferQueued = false;
                    this.m_pendingInputFrameCount.set(0);
                }
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
                return 2;
            }
        }
        return DecodeToFrame(j_renamed, j2, z_renamed, i_renamed, z2);
    }

    private int DecodeToFrame(long j_renamed, long j2, boolean z_renamed, int i_renamed, boolean z2) {
        try {
            return DoDecodeToFrame(j_renamed, j2, z_renamed, i_renamed, z2);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            this.CleanupDecoder(false);
            return 2;
        }
    }

    private int DoDecodeToFrame(long j_renamed, long j2, boolean z_renamed, int i_renamed, boolean z2) throws android.media.MediaCodec.CryptoException {
        boolean z3;
        int i2;
        boolean z4;
        int iMax = java.lang.Math.max(this.m_decoderInputBuffers.length / 3, 2);
        if (z2) {
            FeedVideoDecoderTask();
        }
        boolean z5 = false;
        int i3 = 0;
        do {
            if (this.m_sawOutputEOS) {
                if (j_renamed != Long.MIN_VALUE && this.m_timestampOfCurTexFrame != Long.MIN_VALUE) {
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
                android.util.Log.d_renamed(TAG, "Interrupted video Decoding ");
                return 3;
            }
            if (!z2 && !this.m_sawInputEOS) {
                FeedVideoDecoder(this.m_decoder.dequeueInputBuffer(4000L));
            }
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (this.m_pendingInputFrameCount.get() > iMax || this.m_sawInputEOS || z2) ? com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET : 0);
            i3++;
            if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3) {
                if (iDequeueOutputBuffer == -2) {
                    android.media.MediaFormat outputFormat = this.m_decoder.getOutputFormat();
                    if (outputFormat.containsKey("color-transfer")) {
                        this.m_videoColorTransferCharacteristic = outputFormat.getInteger("color-transfer");
                    }
                } else {
                    if (iDequeueOutputBuffer < 0) {
                        android.util.Log.e_renamed(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
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
                        if (j_renamed != Long.MIN_VALUE) {
                            z4 = this.m_timestampOfLastDecodedFrame >= j_renamed - j2;
                            if (z4 || !this.m_sawInputEOS || z_renamed) {
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
                        if (!z_renamed) {
                            updateCurTexImage();
                        }
                        synchronized (this.m_frameSyncObject) {
                            this.m_frameAvailable = false;
                        }
                    }
                    this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, z6);
                    if (z6) {
                        boolean z7 = !z_renamed;
                        if (AwaitNewImage(z7)) {
                            this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
                            this.m_curTexImageUpdated = z7;
                            if (!z3) {
                                return 0;
                            }
                        } else {
                            android.util.Log.e_renamed(TAG, "Render decoded frame to surface texture failed!");
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
        android.util.Log.e_renamed(TAG, "We have tried too many times and can't_renamed decode a_renamed frame!");
        return 2;
    }

    private boolean isNonReferenceFrame(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return false;
        }
        byte[] bArr = new byte[5];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && (bArr[4] & 31) == 1 && ((bArr[4] >> 5) & 3) == 0;
    }

    private boolean canSkipFrame(java.nio.ByteBuffer byteBuffer, long j_renamed) {
        if (byteBuffer == null || this.m_usedTemporalLayer <= 0 || j_renamed >= this.m_temporalLayerEndTime) {
            return false;
        }
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        int i_renamed = bArr[4] & 31;
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && (i_renamed == 14 || i_renamed == 20)) {
            if (!(((bArr[5] & 255) >> 7) > 0) || (((bArr[7] & 255) >> 5) & 7) <= this.m_usedTemporalLayer) {
                return false;
            }
        } else if (this.m_usedTemporalLayer <= 0) {
            return false;
        }
        return true;
    }

    private boolean AwaitNewImage(boolean z_renamed) {
        synchronized (this.m_frameSyncObject) {
            while (!this.m_frameAvailable) {
                try {
                    this.m_frameSyncObject.wait(3000L);
                    if (!this.m_frameAvailable) {
                        android.util.Log.e_renamed(TAG, "Frame wait timed out!");
                        return false;
                    }
                } catch (java.lang.InterruptedException e_renamed) {
                    android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                    return false;
                }
            }
            this.m_frameAvailable = false;
            if (!z_renamed) {
                return true;
            }
            try {
                this.m_surfaceTexture.updateTexImage();
                return true;
            } catch (java.lang.Exception e2) {
                android.util.Log.e_renamed(TAG, "" + e2.getMessage());
                e2.printStackTrace();
                return false;
            }
        }
    }

    private void DrainOutputBuffers(boolean z_renamed) {
        if (z_renamed || (this.m_sawInputEOS && !this.m_sawOutputEOS)) {
            int i_renamed = 0;
            while (!this.m_sawOutputEOS) {
                int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                i_renamed++;
                if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3 && iDequeueOutputBuffer != -2) {
                    if (iDequeueOutputBuffer < 0) {
                        android.util.Log.e_renamed(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                        return;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    i_renamed = 0;
                }
                if (i_renamed > 100) {
                    android.util.Log.e_renamed(TAG, "DrainDecoderBuffers(): We have tried too many times and can't_renamed decode a_renamed frame!");
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
        com.cdv.utils.NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }

    private void CreateFeedVideoDecoderThread() {
        if (this.m_feedVideoDecoderThread != null) {
            return;
        }
        this.m_feedVideoDecoderThread = new android.os.HandlerThread("feed video decoder handler");
        this.m_feedVideoDecoderThread.start();
        this.m_feedVideoDecoderHandler = new android.os.Handler(this.m_feedVideoDecoderThread.getLooper());
    }

    private void CloseFeedVideoDecoderThread() {
        android.os.HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread == null) {
            return;
        }
        if (handlerThread.isAlive()) {
            this.m_feedVideoDecoderThread.quitSafely();
        }
        try {
            this.m_feedVideoDecoderThread.join();
        } catch (java.lang.InterruptedException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.m_feedVideoDecoderHandler = null;
        this.m_feedVideoDecoderThread = null;
    }

    private boolean FeedVideoDecoderTask() {
        android.os.HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            android.util.Log.e_renamed(TAG, "FeedVideoDecoderTask thread in_renamed invalid!");
            return false;
        }
        if (this.m_feedDecoderStatus != 0) {
            return true;
        }
        this.m_feedDecoderStatus = 1;
        this.m_feedDecoderStopping = false;
        this.m_feedVideoDecoderHandler.post(new java.lang.Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReader.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.cdv.io.NvAndroidVideoFileReader.this.FeedVideoDecoderInThread();
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.e_renamed(com.cdv.io.NvAndroidVideoFileReader.TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                    com.cdv.io.NvAndroidVideoFileReader.this.m_feedDecoderStatus = 3;
                }
            }
        });
        return true;
    }

    private void BreakFeedVideoDecoder() {
        int i_renamed = this.m_feedDecoderStatus;
        if (i_renamed == 0) {
            return;
        }
        if (i_renamed == 3) {
            this.m_feedDecoderStatus = 0;
            this.m_feedDecoderStopping = false;
            return;
        }
        this.m_feedDecoderStopping = true;
        if (this.m_inputBufferQueued && i_renamed != 2) {
            DrainOutputBuffersForFeedFinish();
        }
        java.lang.System.currentTimeMillis();
        synchronized (this.m_feedDecoderSyncObject) {
            if (this.m_feedDecoderStatus != 2) {
                try {
                    this.m_feedDecoderSyncObject.wait(30000L);
                } catch (java.lang.InterruptedException e_renamed) {
                    android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                }
            }
        }
        this.m_feedDecoderStatus = 0;
        this.m_feedDecoderStopping = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FeedVideoDecoderInThread() throws android.media.MediaCodec.CryptoException {
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

    private void FeedVideoDecoder(int i_renamed) throws android.media.MediaCodec.CryptoException {
        int sampleData;
        long sampleTime;
        if (i_renamed >= 0) {
            java.nio.ByteBuffer byteBuffer = this.m_decoderInputBuffers[i_renamed];
            while (true) {
                sampleData = this.m_extractor.readSampleData(byteBuffer, 0);
                if (sampleData < 0) {
                    this.m_decoder.queueInputBuffer(i_renamed, 0, 0, 0L, 4);
                    this.m_sawInputEOS = true;
                    return;
                }
                if (this.m_extractor.getSampleTrackIndex() != this.m_videoTrackIndex) {
                    android.util.Log.w_renamed(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_videoTrackIndex);
                }
                sampleTime = this.m_extractor.getSampleTime();
                if (((this.m_extractor.getSampleFlags() & 1) != 0) || !canSkipFrame(byteBuffer, sampleTime)) {
                    break;
                }
                this.m_extractor.advance();
                this.m_extractorInOriginalState = false;
            }
            this.m_timestampOfLastInputFrame.set(sampleTime);
            this.m_decoder.queueInputBuffer(i_renamed, 0, sampleData, sampleTime, 0);
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
        int i_renamed = 0;
        while (!this.m_sawOutputEOS) {
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, 1000L);
            if (this.m_feedDecoderStatus == 2) {
                return;
            }
            i_renamed++;
            if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3 && iDequeueOutputBuffer != -2) {
                if (iDequeueOutputBuffer < 0) {
                    android.util.Log.e_renamed(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                    return;
                }
                if ((this.m_bufferInfo.flags & 4) != 0) {
                    this.m_sawOutputEOS = true;
                }
                this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                i_renamed = 0;
            }
            if (i_renamed > 100) {
                android.util.Log.e_renamed(TAG, "DrainDecoderBuffers(): We have tried too many times and can't_renamed decode a_renamed frame!");
                return;
            }
        }
    }
}
