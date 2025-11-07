package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidVideoFileReaderSW {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final java.lang.String TAG = "NvAndroidVideoFileReaderSW";
    private static final boolean m_verbose = false;
    private android.media.MediaCodec.BufferInfo m_bufferInfo;
    private android.os.Handler m_cleanupHandler;
    private android.os.Handler m_handler;
    private com.cdv.utils.NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_owner;
    private android.media.MediaExtractor m_extractor = null;
    private int m_videoTrackIndex = -1;
    private android.media.MediaFormat m_format = null;
    private long m_duration = 0;
    private boolean m_extractorInOriginalState = true;
    private android.media.MediaCodec m_decoder = null;
    private android.media.ImageReader m_imageReader = null;
    private boolean m_decoderUseSurface = false;
    private java.lang.Object m_frameSyncObject = new java.lang.Object();
    private boolean m_imageReady = false;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    java.nio.ByteBuffer[] m_decoderInputBuffers = null;
    java.nio.ByteBuffer[] m_decoderOutputBuffers = null;
    private long m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
    private long m_timestampOfLastCopiedFrame = Long.MIN_VALUE;
    private boolean m_inputBufferQueued = false;
    private int m_pendingInputFrameCount = 0;
    private boolean m_sawInputEOS = false;
    private boolean m_sawOutputEOS = false;
    private long m_preloadedTimestamp = Long.MIN_VALUE;
    private long m_lastSeekTimestamp = Long.MIN_VALUE;
    private long m_lastSeekActualTimestamp = Long.MIN_VALUE;
    private boolean m_onlyDecodeKeyFrame = false;
    private long m_contiuousDecodingThreshold = 1000000;
    private boolean m_skipNonReferenceFrameWhenPlayback = false;
    private int m_videoColorTransferCharacteristic = 0;

    private native void nativeCopyVideoFrame(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, long j2);

    private native void nativeCopyVideoFrameFromYUV420ImagePlanes(long j_renamed, int i_renamed, int i2, int i3, int i4, java.nio.ByteBuffer byteBuffer, int i5, int i6, java.nio.ByteBuffer byteBuffer2, int i7, int i8, java.nio.ByteBuffer byteBuffer3, int i9, int i10, long j2);

    private native void nativeSetFormatInfo(long j_renamed, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    NvAndroidVideoFileReaderSW(long j_renamed, android.os.Handler handler, android.os.Handler handler2) {
        this.m_owner = 0L;
        this.m_handler = null;
        this.m_cleanupHandler = null;
        this.m_bufferInfo = null;
        this.m_owner = j_renamed;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new android.media.MediaCodec.BufferInfo();
    }

    public boolean OpenFile(java.lang.String str, android.content.Context context, int i_renamed, long j_renamed) {
        if (IsValid()) {
            android.util.Log.e_renamed(TAG, "You can't_renamed call OpenFile() twice!");
            return false;
        }
        this.m_extractor = com.cdv.utils.NvAndroidUtils.createMediaExtractorFromMediaFilePath(context, str);
        android.media.MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor == null) {
            return false;
        }
        this.m_extractorInOriginalState = true;
        int trackCount = mediaExtractor.getTrackCount();
        int i2 = 0;
        while (true) {
            if (i2 >= trackCount) {
                break;
            }
            if (this.m_extractor.getTrackFormat(i2).getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME).startsWith("video/")) {
                this.m_videoTrackIndex = i2;
                break;
            }
            i2++;
        }
        int i3 = this.m_videoTrackIndex;
        if (i3 < 0) {
            android.util.Log.e_renamed(TAG, "Failed to find a_renamed video track from " + str);
            CloseFile();
            return false;
        }
        this.m_extractor.selectTrack(i3);
        this.m_format = this.m_extractor.getTrackFormat(this.m_videoTrackIndex);
        if (android.os.Build.VERSION.SDK_INT == 16) {
            this.m_format.setInteger("max-input-size", 0);
        }
        boolean zEquals = android.os.Build.HARDWARE.equals("qcom");
        if (android.os.Build.VERSION.SDK_INT >= 23 && i_renamed >= 0 && !zEquals) {
            android.media.MediaFormat mediaFormat = this.m_format;
            if (i_renamed <= 0) {
                i_renamed = 120;
            }
            mediaFormat.setInteger("operating-rate", i_renamed);
        }
        try {
            this.m_duration = this.m_format.getLong("durationUs");
            java.lang.String string = this.m_format.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME);
            if (zEquals && this.m_format.containsKey(com.oplus.tblplayer.misc.IMediaFormat.KEY_FRAME_RATE)) {
                this.m_format.setInteger(com.oplus.tblplayer.misc.IMediaFormat.KEY_FRAME_RATE, 0);
            }
            this.m_videoColorTransferCharacteristic = 3;
            if (this.m_format.containsKey("color-transfer")) {
                this.m_videoColorTransferCharacteristic = this.m_format.getInteger("color-transfer");
            }
            this.m_decoderSetupFailed = false;
            if (!SetupDecoder(string)) {
                this.m_decoderSetupFailed = true;
                CloseFile();
                return false;
            }
            this.m_contiuousDecodingThreshold = j_renamed;
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            CloseFile();
            return false;
        }
    }

    public void preload(long j_renamed) {
        int iPreloadInternal = preloadInternal(j_renamed);
        int i_renamed = 0;
        while (iPreloadInternal == 4) {
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
            iPreloadInternal = preloadInternal(j_renamed);
            i_renamed++;
            android.util.Log.w_renamed(TAG, "Try to preload! times=" + i_renamed);
            if (i_renamed >= 2) {
                break;
            }
        }
        if (iPreloadInternal == 4) {
            android.util.Log.w_renamed(TAG, "Try to recreate MediaExtractor after preload!");
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        }
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
        CleanupDecoder(true);
        android.media.MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0L;
            this.m_extractorInOriginalState = true;
            this.m_onlyDecodeKeyFrame = false;
        }
    }

    public int SeekVideoFrame(long j_renamed, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long jMax = java.lang.Math.max(j_renamed, 0L);
        long j3 = this.m_duration;
        if (jMax >= j3) {
            if (jMax >= 25000 + j3) {
                return 1;
            }
            jMax = j3 - 1;
        }
        long j4 = this.m_timestampOfLastCopiedFrame;
        if (j4 != Long.MIN_VALUE && java.lang.Math.abs(jMax - j4) <= j2) {
            return 0;
        }
        int iSeekInternal = SeekInternal(jMax, j2, this.m_onlyDecodeKeyFrame ? 0 : 2);
        if (iSeekInternal == 0) {
            this.m_lastSeekTimestamp = jMax;
            this.m_lastSeekActualTimestamp = this.m_timestampOfLastCopiedFrame;
        } else {
            InvalidLastSeekTimestamp();
        }
        return iSeekInternal;
    }

    public int StartPlayback(long j_renamed, long j2) {
        long j3;
        long j4;
        if (!IsValid()) {
            return 1;
        }
        long jMax = java.lang.Math.max(j_renamed, 0L);
        if (jMax >= this.m_duration) {
            return 1;
        }
        long j5 = this.m_preloadedTimestamp;
        if (j5 != Long.MIN_VALUE) {
            if (jMax >= j5) {
                long j6 = this.m_timestampOfLastCopiedFrame;
                if (jMax <= j6) {
                    jMax = j6;
                }
            }
            this.m_preloadedTimestamp = Long.MIN_VALUE;
        } else {
            long j7 = this.m_lastSeekTimestamp;
            if (j7 != Long.MIN_VALUE && jMax == j7) {
                long j8 = this.m_lastSeekActualTimestamp;
                if (j8 != Long.MIN_VALUE) {
                    j3 = j8;
                }
            }
            j4 = this.m_timestampOfLastCopiedFrame;
            if (j3 != j4 && j4 == this.m_timestampOfLastDecodedFrame) {
                return 0;
            }
            int iSeekInternal = SeekInternal(j3, j2, 2);
            InvalidLastSeekTimestamp();
            return iSeekInternal;
        }
        j3 = jMax;
        j4 = this.m_timestampOfLastCopiedFrame;
        if (j3 != j4) {
        }
        int iSeekInternal2 = SeekInternal(j3, j2, 2);
        InvalidLastSeekTimestamp();
        return iSeekInternal2;
    }

    public int GetNextVideoFrameForPlayback() {
        if (!IsValid()) {
            return 1;
        }
        int iDecodeToFrame = DecodeToFrame(Long.MIN_VALUE, 0L, this.m_skipNonReferenceFrameWhenPlayback ? 1 : 0);
        InvalidLastSeekTimestamp();
        return iDecodeToFrame;
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    private boolean IsValid() {
        return this.m_decoder != null;
    }

    private boolean preferDecodeToImageReader(java.lang.String str) {
        if (com.cdv.utils.NvAndroidEncryptStringUtil.equals(android.os.Build.MANUFACTURER, com.cdv.utils.NvAndroidEncryptStringUtil.OP_ENCODE) && android.os.Build.MODEL.equals("R15")) {
            return str.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_MPEG2);
        }
        return false;
    }

    private int preloadInternal(long j_renamed) {
        if (!IsValid()) {
            return 2;
        }
        long jMax = java.lang.Math.max(java.lang.Math.min(j_renamed, this.m_duration - 1), 0L);
        int iSeekInternal = SeekInternal(jMax, 0L, 2);
        if (iSeekInternal == 0) {
            if (this.m_timestampOfLastCopiedFrame == Long.MIN_VALUE) {
                return iSeekInternal;
            }
            this.m_preloadedTimestamp = jMax;
            return iSeekInternal;
        }
        if (iSeekInternal != 1 || this.m_timestampOfLastCopiedFrame != Long.MIN_VALUE) {
            return iSeekInternal;
        }
        long j2 = this.m_timestampOfLastDecodedFrame;
        if (j2 == Long.MIN_VALUE || j2 >= this.m_duration - 100000) {
            return iSeekInternal;
        }
        return 4;
    }

    private boolean SetupDecoder(java.lang.String str) {
        if (preferDecodeToImageReader(str) && setupDecoderWithImageReader(str)) {
            return true;
        }
        return setupDecoderWithBuffers(str);
    }

    private boolean setupDecoderWithBuffers(java.lang.String str) {
        try {
            this.m_decoder = android.media.MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, (android.view.Surface) null, (android.media.MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private boolean setupDecoderWithImageReader(java.lang.String str) {
        boolean z_renamed;
        if (android.os.Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            this.m_decoder = android.media.MediaCodec.createDecoderByType(str);
            int[] iArr = this.m_decoder.getCodecInfo().getCapabilitiesForType(str).colorFormats;
            int length = iArr.length;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= length) {
                    z_renamed = false;
                    break;
                }
                if (iArr[i_renamed] == 2135033992) {
                    z_renamed = true;
                    break;
                }
                i_renamed++;
            }
            if (!z_renamed) {
                android.util.Log.w_renamed(TAG, "We can't_renamed decode to ImageReader if COLOR_FormatYUV420Flexible is_renamed not supported!");
                this.m_decoder.release();
                this.m_decoder = null;
                return false;
            }
            this.m_format.setInteger("color-format", 2135033992);
            this.m_imageReader = android.media.ImageReader.newInstance(this.m_format.getInteger("width"), this.m_format.getInteger("height"), 35, 1);
            this.m_imageReader.setOnImageAvailableListener(new android.media.ImageReader.OnImageAvailableListener() { // from class: com.cdv.io.NvAndroidVideoFileReaderSW.1
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(android.media.ImageReader imageReader) {
                    synchronized (com.cdv.io.NvAndroidVideoFileReaderSW.this.m_frameSyncObject) {
                        com.cdv.io.NvAndroidVideoFileReaderSW.this.m_imageReady = true;
                        com.cdv.io.NvAndroidVideoFileReaderSW.this.m_frameSyncObject.notifyAll();
                    }
                }
            }, this.m_handler);
            this.m_decoder.configure(this.m_format, this.m_imageReader.getSurface(), (android.media.MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderUseSurface = true;
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
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers();
                }
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
            }
        }
        if (!z_renamed) {
            CleanupDecoderCore(false);
        } else {
            this.m_cleanupHandler.post(new java.lang.Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReaderSW.2
                @Override // java.lang.Runnable
                public void run() {
                    com.cdv.io.NvAndroidVideoFileReaderSW.this.CleanupDecoderCore(true);
                }
            });
        }
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfLastCopiedFrame = Long.MIN_VALUE;
        this.m_pendingInputFrameCount = 0;
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
        android.media.ImageReader imageReader = this.m_imageReader;
        if (imageReader != null) {
            imageReader.close();
            this.m_imageReader = null;
        }
        this.m_decoderUseSurface = false;
    }

    private int SeekInternal(long j_renamed, long j2, int i_renamed) {
        long j3 = this.m_timestampOfLastDecodedFrame;
        boolean z_renamed = true;
        if ((j3 == Long.MIN_VALUE || j_renamed <= j3 || j_renamed >= j3 + this.m_contiuousDecodingThreshold) && (!this.m_extractorInOriginalState || j_renamed >= this.m_contiuousDecodingThreshold)) {
            z_renamed = false;
        }
        if (this.m_onlyDecodeKeyFrame) {
            z_renamed = false;
        }
        if (!z_renamed) {
            try {
                this.m_extractor.seekTo(j_renamed, 0);
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
                    this.m_pendingInputFrameCount = 0;
                }
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
                return 2;
            }
        }
        return DecodeToFrame(j_renamed, j2, i_renamed);
    }

    private int DecodeToFrame(long j_renamed, long j2, int i_renamed) {
        try {
            return DoDecodeToFrame(j_renamed, j2, i_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            this.CleanupDecoder(false);
            return 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    private int DoDecodeToFrame(long j_renamed, long j2, int i_renamed) throws android.media.MediaCodec.CryptoException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z_renamed;
        boolean z2;
        boolean z3;
        android.graphics.Rect rect;
        boolean z4;
        boolean z5;
        int iDequeueInputBuffer;
        int sampleData;
        long sampleTime;
        int i7 = i_renamed;
        int i8 = 3;
        int i9 = 2;
        int iMax = java.lang.Math.max(this.m_decoderInputBuffers.length / 3, 2);
        ?? r11 = 0;
        int i10 = 0;
        while (!this.m_sawOutputEOS) {
            if (isInterruptedDecoding()) {
                return i8;
            }
            if (!this.m_sawInputEOS && (iDequeueInputBuffer = this.m_decoder.dequeueInputBuffer(4000L)) >= 0) {
                java.nio.ByteBuffer byteBuffer = this.m_decoderInputBuffers[iDequeueInputBuffer];
                while (true) {
                    sampleData = this.m_extractor.readSampleData(byteBuffer, r11);
                    if (sampleData < 0) {
                        this.m_decoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        this.m_sawInputEOS = true;
                        break;
                    }
                    if (this.m_extractor.getSampleTrackIndex() != this.m_videoTrackIndex) {
                        android.util.Log.w_renamed(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_videoTrackIndex);
                    }
                    sampleTime = this.m_extractor.getSampleTime();
                    android.util.Log.d_renamed(TAG, "read sample from readeer:" + sampleTime);
                    if (!((i7 != 1 && (i7 != i9 || sampleTime >= j_renamed - j2)) ? r11 : true) || !isNonReferenceFrame(byteBuffer)) {
                        break;
                    }
                    this.m_extractor.advance();
                    this.m_extractorInOriginalState = r11;
                }
                this.m_decoder.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, sampleTime, 0);
                this.m_inputBufferQueued = true;
                this.m_pendingInputFrameCount++;
                this.m_extractor.advance();
                this.m_extractorInOriginalState = r11;
            }
            int i11 = iMax;
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (this.m_pendingInputFrameCount > iMax || this.m_sawInputEOS) ? com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET : r11);
            int i12 = i10 + 1;
            if (iDequeueOutputBuffer != -1) {
                if (iDequeueOutputBuffer == -3) {
                    this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    android.media.MediaFormat outputFormat = this.m_decoder.getOutputFormat();
                    if (outputFormat.containsKey("color-transfer")) {
                        this.m_videoColorTransferCharacteristic = outputFormat.getInteger("color-transfer");
                    }
                    ParseMediaFormat(outputFormat);
                } else {
                    if (iDequeueOutputBuffer < 0) {
                        android.util.Log.e_renamed(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                        return i9;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    if (this.m_bufferInfo.size != 0) {
                        this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
                        this.m_pendingInputFrameCount--;
                        if (j_renamed != Long.MIN_VALUE) {
                            boolean z6 = this.m_timestampOfLastDecodedFrame >= j_renamed - j2;
                            if (z6 || this.m_timestampOfLastDecodedFrame < this.m_duration - 100000) {
                                z4 = z6;
                                z5 = false;
                            } else {
                                z5 = true;
                                z4 = true;
                            }
                            if (this.m_onlyDecodeKeyFrame) {
                                z2 = z5;
                                z_renamed = true;
                            } else {
                                z2 = z5;
                                z_renamed = z4;
                            }
                        } else {
                            z_renamed = true;
                            z2 = false;
                        }
                        i6 = 0;
                    } else {
                        i6 = i12;
                        z_renamed = false;
                        z2 = false;
                    }
                    if (!this.m_decoderUseSurface) {
                        if (z_renamed) {
                            nativeCopyVideoFrame(this.m_owner, this.m_decoderOutputBuffers[iDequeueOutputBuffer], this.m_bufferInfo.offset, this.m_bufferInfo.size, this.m_timestampOfLastDecodedFrame);
                            this.m_timestampOfLastCopiedFrame = this.m_timestampOfLastDecodedFrame;
                        }
                        this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        i4 = 0;
                        z3 = z_renamed;
                        i2 = i9;
                        i3 = i11;
                    } else {
                        if (z_renamed) {
                            synchronized (this.m_frameSyncObject) {
                                this.m_imageReady = false;
                            }
                        }
                        this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, z_renamed);
                        if (z_renamed) {
                            android.media.Image imageAwaitNewImage = AwaitNewImage();
                            if (imageAwaitNewImage != null) {
                                int width = imageAwaitNewImage.getWidth();
                                int height = imageAwaitNewImage.getHeight();
                                if (android.os.Build.VERSION.SDK_INT >= 21) {
                                    rect = imageAwaitNewImage.getCropRect();
                                } else {
                                    rect = new android.graphics.Rect(0, 0, width, height);
                                }
                                android.media.Image.Plane[] planes = imageAwaitNewImage.getPlanes();
                                if (planes.length == 3) {
                                    i4 = 0;
                                    z3 = z_renamed;
                                    i3 = i11;
                                    i2 = i9;
                                    i5 = 3;
                                    nativeCopyVideoFrameFromYUV420ImagePlanes(this.m_owner, rect.left, rect.top, rect.right, rect.bottom, planes[0].getBuffer(), planes[0].getRowStride(), planes[0].getPixelStride(), planes[1].getBuffer(), planes[1].getRowStride(), planes[1].getPixelStride(), planes[i2].getBuffer(), planes[i2].getRowStride(), planes[i2].getPixelStride(), this.m_timestampOfLastDecodedFrame);
                                    this.m_timestampOfLastCopiedFrame = this.m_timestampOfLastDecodedFrame;
                                } else {
                                    i5 = 3;
                                    z3 = z_renamed;
                                    i2 = i9;
                                    i3 = i11;
                                    i4 = 0;
                                }
                                imageAwaitNewImage.close();
                                if (!z3 && !z2) {
                                    return i4;
                                }
                                i10 = i6;
                            } else {
                                int i13 = i9;
                                android.util.Log.e_renamed(TAG, "Render decoded frame to ImageReader failed!");
                                return i13;
                            }
                        } else {
                            z3 = z_renamed;
                            i2 = i9;
                            i3 = i11;
                            i4 = 0;
                        }
                    }
                    i5 = 3;
                    if (!z3) {
                    }
                    i10 = i6;
                }
                i10 = i12;
                i2 = i9;
                i3 = i11;
                i4 = 0;
                i5 = 3;
            } else {
                i10 = i12;
                i2 = i9;
                i3 = i11;
                i4 = 0;
                i5 = 3;
            }
            if (i10 > 100) {
                android.util.Log.e_renamed(TAG, "We have tried too many times and can't_renamed decode a_renamed frame!");
                return i2;
            }
            i7 = i_renamed;
            r11 = i4;
            iMax = i3;
            i9 = i2;
            i8 = i5;
        }
        int i14 = r11;
        if (j_renamed != Long.MIN_VALUE) {
            long j3 = this.m_timestampOfLastCopiedFrame;
            if (j3 != Long.MIN_VALUE && j3 >= this.m_duration - 100000) {
                return i14;
            }
        }
        return 1;
    }

    private android.media.Image AwaitNewImage() {
        synchronized (this.m_frameSyncObject) {
            while (!this.m_imageReady) {
                try {
                    this.m_frameSyncObject.wait(3000L);
                    if (!this.m_imageReady) {
                        android.util.Log.e_renamed(TAG, "ImageReader wait timed out!");
                        return null;
                    }
                } catch (java.lang.InterruptedException e_renamed) {
                    android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                    return null;
                }
            }
            this.m_imageReady = false;
            try {
                return this.m_imageReader.acquireLatestImage();
            } catch (java.lang.Exception e2) {
                android.util.Log.e_renamed(TAG, "" + e2.getMessage());
                e2.printStackTrace();
                return null;
            }
        }
    }

    private void DrainOutputBuffers() {
        if (!this.m_sawInputEOS || this.m_sawOutputEOS) {
            return;
        }
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

    private void InvalidLastSeekTimestamp() {
        this.m_lastSeekTimestamp = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = Long.MIN_VALUE;
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

    private void ParseMediaFormat(android.media.MediaFormat mediaFormat) {
        int integer;
        int integer2;
        int i_renamed;
        if (mediaFormat.containsKey("width") && mediaFormat.containsKey("height") && mediaFormat.containsKey("color-format")) {
            int integer3 = mediaFormat.getInteger("width");
            int integer4 = mediaFormat.getInteger("height");
            int integer5 = mediaFormat.getInteger("color-format");
            if (android.os.Build.VERSION.SDK_INT >= 18) {
                java.lang.String name = this.m_decoder.getName();
                if (integer5 == 25 && name.equals("OMX.k3.video.decoder.avc")) {
                    integer5 = 2130706688;
                }
            }
            int i2 = integer5;
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                integer2 = mediaFormat.containsKey("slice-height") ? mediaFormat.getInteger("slice-height") : integer4;
                integer = mediaFormat.containsKey("stride") ? mediaFormat.getInteger("stride") : integer3;
            } else {
                integer = integer3;
                integer2 = integer4;
            }
            if (android.os.Build.VERSION.SDK_INT >= 18) {
                java.lang.String name2 = this.m_decoder.getName();
                if (name2.startsWith("OMX.Nvidia.")) {
                    integer2 = (integer2 + 15) & (-16);
                } else if (name2.startsWith("OMX.SEC.avc.dec")) {
                    integer = integer3;
                    i_renamed = integer4;
                }
                i_renamed = integer2;
            } else {
                i_renamed = integer2;
            }
            int integer6 = mediaFormat.containsKey("crop-left") ? mediaFormat.getInteger("crop-left") : 0;
            int integer7 = mediaFormat.containsKey("crop-right") ? mediaFormat.getInteger("crop-right") : integer3 - 1;
            int integer8 = mediaFormat.containsKey("crop-top") ? mediaFormat.getInteger("crop-top") : 0;
            int integer9 = mediaFormat.containsKey("crop-bottom") ? mediaFormat.getInteger("crop-bottom") : integer4 - 1;
            nativeSetFormatInfo(this.m_owner, (integer7 + 1) - integer6, (integer9 + 1) - integer8, i2, i_renamed, integer, integer6, integer7, integer8, integer9);
        }
    }

    private boolean isInterruptedDecoding() {
        com.cdv.utils.NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }
}
