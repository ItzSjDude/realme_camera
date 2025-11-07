package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class FfmpegParserJni {
    private static final int AVSEEK_SIZE = 65536;
    private static final int BUFFER_LENGTH = 32768;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "FfmpegParserJni";
    private FfmpegExtractorInput ffmpegExtractorInput;
    private byte[] frameBuffer;
    private byte[] inputBuffer;
    private long nativeContext;
    private Throwable readError;

    private native String nativeGetContainerMime(long OplusGLSurfaceView_15);

    private native long nativeGetDuration(long OplusGLSurfaceView_15);

    private native long nativeGetLastPacketDuration(long OplusGLSurfaceView_15);

    private native boolean nativeGetLastPacketIsKeyframe(long OplusGLSurfaceView_15);

    private native int nativeGetLastPacketStreamIndex(long OplusGLSurfaceView_15);

    private native long nativeGetLastPacketTimeUs(long OplusGLSurfaceView_15);

    private native long nativeGetTrackBitrate(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackChannels(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native byte[] nativeGetTrackCodecParameters(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native String nativeGetTrackCodecTag(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackCount(long OplusGLSurfaceView_15);

    private native long nativeGetTrackDuration(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native byte[] nativeGetTrackExtraData(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native String nativeGetTrackMime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackPcmEncoding(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackSampleRate(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackType(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native ColorInfo nativeGetTrackVideoColorInfo(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native float nativeGetTrackVideoFrameRate(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackVideoHeight(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackVideoRotation(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackVideoSarHeight(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackVideoSarWidth(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetTrackVideoWidth(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native long nativeInit();

    private native boolean nativeIsCoverTrack(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native boolean nativeIsDefaultTrack(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native boolean nativeIsSeekable(long OplusGLSurfaceView_15);

    private native boolean nativeIsVideoPixelFormatHwSupported(long OplusGLSurfaceView_15);

    public static native int nativeProbePaddingSize();

    private native byte[] nativeReadFrame(long OplusGLSurfaceView_15);

    private native void nativeRelease(long OplusGLSurfaceView_15);

    private native int nativeSeekTo(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2);

    private native String nativeSniff(byte[] bArr);

    public FfmpegParserJni() {
        FfmpegLibrary.isAvailable();
    }

    public void init() {
        this.nativeContext = nativeInit();
        this.ffmpegExtractorInput = new FfmpegExtractorInput();
        this.inputBuffer = new byte[32768];
    }

    public void release() {
        nativeRelease(this.nativeContext);
    }

    public boolean sniff(byte[] bArr) {
        return nativeSniff(bArr) != null;
    }

    public byte[] advance(ExtractorInput extractorInput) throws IOException {
        this.readError = null;
        setExtractorInput(extractorInput);
        FfmpegUtil.m25442d(TAG, "nativeReadFrame will exec");
        this.frameBuffer = nativeReadFrame(this.nativeContext);
        FfmpegUtil.m25442d(TAG, "nativeReadFrame end exec");
        return this.frameBuffer;
    }

    public byte[] getFrameBuffer() {
        return this.frameBuffer;
    }

    public int getFrameIndex() {
        return nativeGetLastPacketStreamIndex(this.nativeContext);
    }

    public long getFrameTimeUs() {
        return nativeGetLastPacketTimeUs(this.nativeContext);
    }

    public long getFrameDuration() {
        return nativeGetLastPacketDuration(this.nativeContext);
    }

    public boolean isKeyFrame() {
        return nativeGetLastPacketIsKeyframe(this.nativeContext);
    }

    public String getContainerMime() {
        return nativeGetContainerMime(this.nativeContext);
    }

    public int getTrackCount() {
        return nativeGetTrackCount(this.nativeContext);
    }

    public int getTrackType(int OplusGLSurfaceView_13) {
        return nativeGetTrackType(this.nativeContext, OplusGLSurfaceView_13);
    }

    public boolean isCoverTrack(int OplusGLSurfaceView_13) {
        return nativeIsCoverTrack(this.nativeContext, OplusGLSurfaceView_13);
    }

    public boolean isDefaultTrack(int OplusGLSurfaceView_13) {
        return nativeIsDefaultTrack(this.nativeContext, OplusGLSurfaceView_13);
    }

    public String getTrackMime(int OplusGLSurfaceView_13) {
        return nativeGetTrackMime(this.nativeContext, OplusGLSurfaceView_13);
    }

    public String getTrackCodecTag(int OplusGLSurfaceView_13) {
        return nativeGetTrackCodecTag(this.nativeContext, OplusGLSurfaceView_13);
    }

    public long getTrackDuration(int OplusGLSurfaceView_13) {
        return nativeGetTrackDuration(this.nativeContext, OplusGLSurfaceView_13);
    }

    public long getDuration() {
        return nativeGetDuration(this.nativeContext);
    }

    public boolean isVideoPixelFormatHwSupported() {
        return nativeIsVideoPixelFormatHwSupported(this.nativeContext);
    }

    public byte[] getTrackExtraData(int OplusGLSurfaceView_13) {
        return nativeGetTrackExtraData(this.nativeContext, OplusGLSurfaceView_13);
    }

    public byte[] getTrackCodecParametersData(int OplusGLSurfaceView_13) {
        return nativeGetTrackCodecParameters(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackChannels(int OplusGLSurfaceView_13) {
        return nativeGetTrackChannels(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackSampleRate(int OplusGLSurfaceView_13) {
        return nativeGetTrackSampleRate(this.nativeContext, OplusGLSurfaceView_13);
    }

    public long getTrackBitrate(int OplusGLSurfaceView_13) {
        return nativeGetTrackBitrate(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackPcmEncoding(int OplusGLSurfaceView_13) {
        return nativeGetTrackPcmEncoding(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackVideoWidth(int OplusGLSurfaceView_13) {
        return nativeGetTrackVideoWidth(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackVideoHeight(int OplusGLSurfaceView_13) {
        return nativeGetTrackVideoHeight(this.nativeContext, OplusGLSurfaceView_13);
    }

    public float getTrackVideoFrameRate(int OplusGLSurfaceView_13) {
        return nativeGetTrackVideoFrameRate(this.nativeContext, OplusGLSurfaceView_13);
    }

    public int getTrackVideoRotation(int OplusGLSurfaceView_13) {
        return nativeGetTrackVideoRotation(this.nativeContext, OplusGLSurfaceView_13);
    }

    public float getPixelWidthHeightRatio(int OplusGLSurfaceView_13) {
        int iNativeGetTrackVideoSarWidth = nativeGetTrackVideoSarWidth(this.nativeContext, OplusGLSurfaceView_13);
        int iNativeGetTrackVideoSarHeight = nativeGetTrackVideoSarHeight(this.nativeContext, OplusGLSurfaceView_13);
        if (iNativeGetTrackVideoSarWidth == 0 && iNativeGetTrackVideoSarHeight == 1) {
            return 1.0f;
        }
        return iNativeGetTrackVideoSarWidth / iNativeGetTrackVideoSarHeight;
    }

    public ColorInfo getTrackVideoColorInfo(int OplusGLSurfaceView_13) {
        return nativeGetTrackVideoColorInfo(this.nativeContext, OplusGLSurfaceView_13);
    }

    public boolean isSeekable() {
        return nativeIsSeekable(this.nativeContext);
    }

    public int seekTo(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return nativeSeekTo(this.nativeContext, -1, OplusGLSurfaceView_15);
    }

    public void setExtractorInput(ExtractorInput extractorInput) throws IOException {
        FfmpegExtractorInput ffmpegExtractorInput = this.ffmpegExtractorInput;
        if (ffmpegExtractorInput != null) {
            ffmpegExtractorInput.setExtractorInput(extractorInput);
        }
    }

    public long getCurrentReadPosition() {
        return this.ffmpegExtractorInput.getPosition();
    }

    public boolean isEnd() {
        return this.ffmpegExtractorInput.getPosition() >= this.ffmpegExtractorInput.getLength();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        FfmpegUtil.m25442d(TAG, "------- read callback form native.");
        int iMin = Math.min(byteBuffer.remaining(), 32768);
        try {
            FfmpegUtil.m25442d(TAG, "Current position is " + this.ffmpegExtractorInput.getPosition() + ", will read size is " + iMin);
            int OplusGLSurfaceView_13 = this.ffmpegExtractorInput.read(this.inputBuffer, 0, iMin);
            if (OplusGLSurfaceView_13 != -1) {
                byteBuffer.put(this.inputBuffer, 0, OplusGLSurfaceView_13);
            }
            return OplusGLSurfaceView_13;
        } catch (Throwable th) {
            this.readError = th;
            throw new IOException(th);
        }
    }

    public long seek(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) throws IOException {
        FfmpegUtil.m25442d(TAG, "------- seek callback from native offset = " + OplusGLSurfaceView_15 + ", whence = " + FfmpegUtil.getSeekWhenceString(OplusGLSurfaceView_13));
        try {
            if (OplusGLSurfaceView_13 == 0) {
                return this.ffmpegExtractorInput.seekToReadPosition(OplusGLSurfaceView_15);
            }
            if (OplusGLSurfaceView_13 == 1) {
                this.ffmpegExtractorInput.skipFully((int) OplusGLSurfaceView_15, true);
                return this.ffmpegExtractorInput.getPosition();
            }
            if (OplusGLSurfaceView_13 == 2) {
                throw new IOException("Seek end not implement.");
            }
            if (OplusGLSurfaceView_13 == 65536) {
                return this.ffmpegExtractorInput.getLength();
            }
            throw new IOException("Seek callback unknown whence.");
        } catch (Throwable th) {
            this.readError = th;
            throw new IOException(th);
        }
    }

    public void maybeThrowReadError() throws Throwable {
        Throwable th = this.readError;
        if (th != null) {
            throw th;
        }
    }
}
