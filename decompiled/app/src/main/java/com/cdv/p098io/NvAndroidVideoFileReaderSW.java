package com.cdv.p098io;

import android.content.Context;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.cdv.utils.NvAndroidEncryptStringUtil;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.nio.ByteBuffer;

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
    private static final String TAG = "NvAndroidVideoFileReaderSW";
    private static final boolean m_verbose = false;
    private MediaCodec.BufferInfo m_bufferInfo;
    private Handler m_cleanupHandler;
    private Handler m_handler;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_owner;
    private MediaExtractor m_extractor = null;
    private int m_videoTrackIndex = -1;
    private MediaFormat m_format = null;
    private long m_duration = 0;
    private boolean m_extractorInOriginalState = true;
    private MediaCodec m_decoder = null;
    private ImageReader m_imageReader = null;
    private boolean m_decoderUseSurface = false;
    private Object m_frameSyncObject = new Object();
    private boolean m_imageReady = false;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    ByteBuffer[] m_decoderInputBuffers = null;
    ByteBuffer[] m_decoderOutputBuffers = null;
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

    private native void nativeCopyVideoFrame(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int i2, long j2);

    private native void nativeCopyVideoFrameFromYUV420ImagePlanes(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5, int i6, ByteBuffer byteBuffer2, int i7, int i8, ByteBuffer byteBuffer3, int i9, int i10, long j2);

    private native void nativeSetFormatInfo(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    NvAndroidVideoFileReaderSW(long OplusGLSurfaceView_15, Handler handler, Handler handler2) {
        this.m_owner = 0L;
        this.m_handler = null;
        this.m_cleanupHandler = null;
        this.m_bufferInfo = null;
        this.m_owner = OplusGLSurfaceView_15;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
    }

    public boolean OpenFile(String str, Context context, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (IsValid()) {
            Log.COUIBaseListPopupWindow_8(TAG, "You can't call OpenFile() twice!");
            return false;
        }
        this.m_extractor = NvAndroidUtils.createMediaExtractorFromMediaFilePath(context, str);
        MediaExtractor mediaExtractor = this.m_extractor;
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
            if (this.m_extractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                this.m_videoTrackIndex = i2;
                break;
            }
            i2++;
        }
        int i3 = this.m_videoTrackIndex;
        if (i3 < 0) {
            Log.COUIBaseListPopupWindow_8(TAG, "Failed to find PlatformImplementations.kt_3 video track from " + str);
            CloseFile();
            return false;
        }
        this.m_extractor.selectTrack(i3);
        this.m_format = this.m_extractor.getTrackFormat(this.m_videoTrackIndex);
        if (Build.VERSION.SDK_INT == 16) {
            this.m_format.setInteger("max-input-size", 0);
        }
        boolean zEquals = Build.HARDWARE.equals("qcom");
        if (Build.VERSION.SDK_INT >= 23 && OplusGLSurfaceView_13 >= 0 && !zEquals) {
            MediaFormat mediaFormat = this.m_format;
            if (OplusGLSurfaceView_13 <= 0) {
                OplusGLSurfaceView_13 = 120;
            }
            mediaFormat.setInteger("operating-rate", OplusGLSurfaceView_13);
        }
        try {
            this.m_duration = this.m_format.getLong("durationUs");
            String string = this.m_format.getString(IMediaFormat.KEY_MIME);
            if (zEquals && this.m_format.containsKey(IMediaFormat.KEY_FRAME_RATE)) {
                this.m_format.setInteger(IMediaFormat.KEY_FRAME_RATE, 0);
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
            this.m_contiuousDecodingThreshold = OplusGLSurfaceView_15;
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            CloseFile();
            return false;
        }
    }

    public void preload(long OplusGLSurfaceView_15) {
        int iPreloadInternal = preloadInternal(OplusGLSurfaceView_15);
        int OplusGLSurfaceView_13 = 0;
        while (iPreloadInternal == 4) {
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
            iPreloadInternal = preloadInternal(OplusGLSurfaceView_15);
            OplusGLSurfaceView_13++;
            Log.w(TAG, "Try to preload! times=" + OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 >= 2) {
                break;
            }
        }
        if (iPreloadInternal == 4) {
            Log.w(TAG, "Try to recreate MediaExtractor after preload!");
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        }
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
        CleanupDecoder(true);
        MediaExtractor mediaExtractor = this.m_extractor;
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

    public int SeekVideoFrame(long OplusGLSurfaceView_15, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long jMax = Math.max(OplusGLSurfaceView_15, 0L);
        long j3 = this.m_duration;
        if (jMax >= j3) {
            if (jMax >= 25000 + j3) {
                return 1;
            }
            jMax = j3 - 1;
        }
        long j4 = this.m_timestampOfLastCopiedFrame;
        if (j4 != Long.MIN_VALUE && Math.abs(jMax - j4) <= j2) {
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

    public int StartPlayback(long OplusGLSurfaceView_15, long j2) {
        long j3;
        long j4;
        if (!IsValid()) {
            return 1;
        }
        long jMax = Math.max(OplusGLSurfaceView_15, 0L);
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

    private boolean preferDecodeToImageReader(String str) {
        if (NvAndroidEncryptStringUtil.equals(Build.MANUFACTURER, NvAndroidEncryptStringUtil.OP_ENCODE) && Build.MODEL.equals("R15")) {
            return str.equals(MimeTypes.VIDEO_MPEG2);
        }
        return false;
    }

    private int preloadInternal(long OplusGLSurfaceView_15) {
        if (!IsValid()) {
            return 2;
        }
        long jMax = Math.max(Math.min(OplusGLSurfaceView_15, this.m_duration - 1), 0L);
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

    private boolean SetupDecoder(String str) {
        if (preferDecodeToImageReader(str) && setupDecoderWithImageReader(str)) {
            return true;
        }
        return setupDecoderWithBuffers(str);
    }

    private boolean setupDecoderWithBuffers(String str) {
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, (Surface) null, (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private boolean setupDecoderWithImageReader(String str) {
        boolean z;
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            int[] iArr = this.m_decoder.getCodecInfo().getCapabilitiesForType(str).colorFormats;
            int length = iArr.length;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= length) {
                    z = false;
                    break;
                }
                if (iArr[OplusGLSurfaceView_13] == 2135033992) {
                    z = true;
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            if (!z) {
                Log.w(TAG, "We can't decode to ImageReader if COLOR_FormatYUV420Flexible is not supported!");
                this.m_decoder.release();
                this.m_decoder = null;
                return false;
            }
            this.m_format.setInteger("color-format", 2135033992);
            this.m_imageReader = ImageReader.newInstance(this.m_format.getInteger("width"), this.m_format.getInteger("height"), 35, 1);
            this.m_imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.cdv.io.NvAndroidVideoFileReaderSW.1
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    synchronized (NvAndroidVideoFileReaderSW.this.m_frameSyncObject) {
                        NvAndroidVideoFileReaderSW.this.m_imageReady = true;
                        NvAndroidVideoFileReaderSW.this.m_frameSyncObject.notifyAll();
                    }
                }
            }, this.m_handler);
            this.m_decoder.configure(this.m_format, this.m_imageReader.getSurface(), (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderUseSurface = true;
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
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (!z) {
            CleanupDecoderCore(false);
        } else {
            this.m_cleanupHandler.post(new Runnable() { // from class: com.cdv.io.NvAndroidVideoFileReaderSW.2
                @Override // java.lang.Runnable
                public void run() {
                    NvAndroidVideoFileReaderSW.this.CleanupDecoderCore(true);
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
        ImageReader imageReader = this.m_imageReader;
        if (imageReader != null) {
            imageReader.close();
            this.m_imageReader = null;
        }
        this.m_decoderUseSurface = false;
    }

    private int SeekInternal(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        long j3 = this.m_timestampOfLastDecodedFrame;
        boolean z = true;
        if ((j3 == Long.MIN_VALUE || OplusGLSurfaceView_15 <= j3 || OplusGLSurfaceView_15 >= j3 + this.m_contiuousDecodingThreshold) && (!this.m_extractorInOriginalState || OplusGLSurfaceView_15 >= this.m_contiuousDecodingThreshold)) {
            z = false;
        }
        if (this.m_onlyDecodeKeyFrame) {
            z = false;
        }
        if (!z) {
            try {
                this.m_extractor.seekTo(OplusGLSurfaceView_15, 0);
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
                    this.m_pendingInputFrameCount = 0;
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
                return 2;
            }
        }
        return DecodeToFrame(OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    private int DecodeToFrame(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        try {
            return DoDecodeToFrame(OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            this.CleanupDecoder(false);
            return 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    private int DoDecodeToFrame(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) throws MediaCodec.CryptoException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        boolean z3;
        Rect rect;
        boolean z4;
        boolean z5;
        int iDequeueInputBuffer;
        int sampleData;
        long sampleTime;
        int i7 = OplusGLSurfaceView_13;
        int i8 = 3;
        int i9 = 2;
        int iMax = Math.max(this.m_decoderInputBuffers.length / 3, 2);
        ?? r11 = 0;
        int i10 = 0;
        while (!this.m_sawOutputEOS) {
            if (isInterruptedDecoding()) {
                return i8;
            }
            if (!this.m_sawInputEOS && (iDequeueInputBuffer = this.m_decoder.dequeueInputBuffer(4000L)) >= 0) {
                ByteBuffer byteBuffer = this.m_decoderInputBuffers[iDequeueInputBuffer];
                while (true) {
                    sampleData = this.m_extractor.readSampleData(byteBuffer, r11);
                    if (sampleData < 0) {
                        this.m_decoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        this.m_sawInputEOS = true;
                        break;
                    }
                    if (this.m_extractor.getSampleTrackIndex() != this.m_videoTrackIndex) {
                        Log.w(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_videoTrackIndex);
                    }
                    sampleTime = this.m_extractor.getSampleTime();
                    Log.IntrinsicsJvm.kt_5(TAG, "read sample from readeer:" + sampleTime);
                    if (!((i7 != 1 && (i7 != i9 || sampleTime >= OplusGLSurfaceView_15 - j2)) ? r11 : true) || !isNonReferenceFrame(byteBuffer)) {
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
            int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (this.m_pendingInputFrameCount > iMax || this.m_sawInputEOS) ? ErrorCode.REASON_DS_ASSET : r11);
            int i12 = i10 + 1;
            if (iDequeueOutputBuffer != -1) {
                if (iDequeueOutputBuffer == -3) {
                    this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.m_decoder.getOutputFormat();
                    if (outputFormat.containsKey("color-transfer")) {
                        this.m_videoColorTransferCharacteristic = outputFormat.getInteger("color-transfer");
                    }
                    ParseMediaFormat(outputFormat);
                } else {
                    if (iDequeueOutputBuffer < 0) {
                        Log.COUIBaseListPopupWindow_8(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                        return i9;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    if (this.m_bufferInfo.size != 0) {
                        this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
                        this.m_pendingInputFrameCount--;
                        if (OplusGLSurfaceView_15 != Long.MIN_VALUE) {
                            boolean z6 = this.m_timestampOfLastDecodedFrame >= OplusGLSurfaceView_15 - j2;
                            if (z6 || this.m_timestampOfLastDecodedFrame < this.m_duration - 100000) {
                                z4 = z6;
                                z5 = false;
                            } else {
                                z5 = true;
                                z4 = true;
                            }
                            if (this.m_onlyDecodeKeyFrame) {
                                z2 = z5;
                                z = true;
                            } else {
                                z2 = z5;
                                z = z4;
                            }
                        } else {
                            z = true;
                            z2 = false;
                        }
                        i6 = 0;
                    } else {
                        i6 = i12;
                        z = false;
                        z2 = false;
                    }
                    if (!this.m_decoderUseSurface) {
                        if (z) {
                            nativeCopyVideoFrame(this.m_owner, this.m_decoderOutputBuffers[iDequeueOutputBuffer], this.m_bufferInfo.offset, this.m_bufferInfo.size, this.m_timestampOfLastDecodedFrame);
                            this.m_timestampOfLastCopiedFrame = this.m_timestampOfLastDecodedFrame;
                        }
                        this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        i4 = 0;
                        z3 = z;
                        i2 = i9;
                        i3 = i11;
                    } else {
                        if (z) {
                            synchronized (this.m_frameSyncObject) {
                                this.m_imageReady = false;
                            }
                        }
                        this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, z);
                        if (z) {
                            Image imageAwaitNewImage = AwaitNewImage();
                            if (imageAwaitNewImage != null) {
                                int width = imageAwaitNewImage.getWidth();
                                int height = imageAwaitNewImage.getHeight();
                                if (Build.VERSION.SDK_INT >= 21) {
                                    rect = imageAwaitNewImage.getCropRect();
                                } else {
                                    rect = new Rect(0, 0, width, height);
                                }
                                Image.Plane[] planes = imageAwaitNewImage.getPlanes();
                                if (planes.length == 3) {
                                    i4 = 0;
                                    z3 = z;
                                    i3 = i11;
                                    i2 = i9;
                                    i5 = 3;
                                    nativeCopyVideoFrameFromYUV420ImagePlanes(this.m_owner, rect.left, rect.top, rect.right, rect.bottom, planes[0].getBuffer(), planes[0].getRowStride(), planes[0].getPixelStride(), planes[1].getBuffer(), planes[1].getRowStride(), planes[1].getPixelStride(), planes[i2].getBuffer(), planes[i2].getRowStride(), planes[i2].getPixelStride(), this.m_timestampOfLastDecodedFrame);
                                    this.m_timestampOfLastCopiedFrame = this.m_timestampOfLastDecodedFrame;
                                } else {
                                    i5 = 3;
                                    z3 = z;
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
                                Log.COUIBaseListPopupWindow_8(TAG, "Render decoded frame to ImageReader failed!");
                                return i13;
                            }
                        } else {
                            z3 = z;
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
                Log.COUIBaseListPopupWindow_8(TAG, "We have tried too many times and can't decode PlatformImplementations.kt_3 frame!");
                return i2;
            }
            i7 = OplusGLSurfaceView_13;
            r11 = i4;
            iMax = i3;
            i9 = i2;
            i8 = i5;
        }
        int i14 = r11;
        if (OplusGLSurfaceView_15 != Long.MIN_VALUE) {
            long j3 = this.m_timestampOfLastCopiedFrame;
            if (j3 != Long.MIN_VALUE && j3 >= this.m_duration - 100000) {
                return i14;
            }
        }
        return 1;
    }

    private Image AwaitNewImage() {
        synchronized (this.m_frameSyncObject) {
            while (!this.m_imageReady) {
                try {
                    this.m_frameSyncObject.wait(3000L);
                    if (!this.m_imageReady) {
                        Log.COUIBaseListPopupWindow_8(TAG, "ImageReader wait timed out!");
                        return null;
                    }
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return null;
                }
            }
            this.m_imageReady = false;
            try {
                return this.m_imageReader.acquireLatestImage();
            } catch (Exception e2) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + e2.getMessage());
                e2.printStackTrace();
                return null;
            }
        }
    }

    private void DrainOutputBuffers() {
        if (!this.m_sawInputEOS || this.m_sawOutputEOS) {
            return;
        }
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

    private void InvalidLastSeekTimestamp() {
        this.m_lastSeekTimestamp = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = Long.MIN_VALUE;
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

    private void ParseMediaFormat(MediaFormat mediaFormat) {
        int integer;
        int integer2;
        int OplusGLSurfaceView_13;
        if (mediaFormat.containsKey("width") && mediaFormat.containsKey("height") && mediaFormat.containsKey("color-format")) {
            int integer3 = mediaFormat.getInteger("width");
            int integer4 = mediaFormat.getInteger("height");
            int integer5 = mediaFormat.getInteger("color-format");
            if (Build.VERSION.SDK_INT >= 18) {
                String name = this.m_decoder.getName();
                if (integer5 == 25 && name.equals("OMX.k3.video.decoder.avc")) {
                    integer5 = 2130706688;
                }
            }
            int i2 = integer5;
            if (Build.VERSION.SDK_INT >= 23) {
                integer2 = mediaFormat.containsKey("slice-height") ? mediaFormat.getInteger("slice-height") : integer4;
                integer = mediaFormat.containsKey("stride") ? mediaFormat.getInteger("stride") : integer3;
            } else {
                integer = integer3;
                integer2 = integer4;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                String name2 = this.m_decoder.getName();
                if (name2.startsWith("OMX.Nvidia.")) {
                    integer2 = (integer2 + 15) & (-16);
                } else if (name2.startsWith("OMX.SEC.avc.dec")) {
                    integer = integer3;
                    OplusGLSurfaceView_13 = integer4;
                }
                OplusGLSurfaceView_13 = integer2;
            } else {
                OplusGLSurfaceView_13 = integer2;
            }
            int integer6 = mediaFormat.containsKey("crop-left") ? mediaFormat.getInteger("crop-left") : 0;
            int integer7 = mediaFormat.containsKey("crop-right") ? mediaFormat.getInteger("crop-right") : integer3 - 1;
            int integer8 = mediaFormat.containsKey("crop-top") ? mediaFormat.getInteger("crop-top") : 0;
            int integer9 = mediaFormat.containsKey("crop-bottom") ? mediaFormat.getInteger("crop-bottom") : integer4 - 1;
            nativeSetFormatInfo(this.m_owner, (integer7 + 1) - integer6, (integer9 + 1) - integer8, i2, OplusGLSurfaceView_13, integer, integer6, integer7, integer8, integer9);
        }
    }

    private boolean isInterruptedDecoding() {
        NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }
}
