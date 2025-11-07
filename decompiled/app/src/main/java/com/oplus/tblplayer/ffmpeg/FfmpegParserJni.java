package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegParserJni {
    private static final int AVSEEK_SIZE = 65536;
    private static final int BUFFER_LENGTH = 32768;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final java.lang.String TAG = "FfmpegParserJni";
    private com.oplus.tblplayer.ffmpeg.FfmpegExtractorInput ffmpegExtractorInput;
    private byte[] frameBuffer;
    private byte[] inputBuffer;
    private long nativeContext;
    private java.lang.Throwable readError;

    private native java.lang.String nativeGetContainerMime(long j_renamed);

    private native long nativeGetDuration(long j_renamed);

    private native long nativeGetLastPacketDuration(long j_renamed);

    private native boolean nativeGetLastPacketIsKeyframe(long j_renamed);

    private native int nativeGetLastPacketStreamIndex(long j_renamed);

    private native long nativeGetLastPacketTimeUs(long j_renamed);

    private native long nativeGetTrackBitrate(long j_renamed, int i_renamed);

    private native int nativeGetTrackChannels(long j_renamed, int i_renamed);

    private native byte[] nativeGetTrackCodecParameters(long j_renamed, int i_renamed);

    private native java.lang.String nativeGetTrackCodecTag(long j_renamed, int i_renamed);

    private native int nativeGetTrackCount(long j_renamed);

    private native long nativeGetTrackDuration(long j_renamed, int i_renamed);

    private native byte[] nativeGetTrackExtraData(long j_renamed, int i_renamed);

    private native java.lang.String nativeGetTrackMime(long j_renamed, int i_renamed);

    private native int nativeGetTrackPcmEncoding(long j_renamed, int i_renamed);

    private native int nativeGetTrackSampleRate(long j_renamed, int i_renamed);

    private native int nativeGetTrackType(long j_renamed, int i_renamed);

    private native com.google.android.exoplayer2.video.ColorInfo nativeGetTrackVideoColorInfo(long j_renamed, int i_renamed);

    private native float nativeGetTrackVideoFrameRate(long j_renamed, int i_renamed);

    private native int nativeGetTrackVideoHeight(long j_renamed, int i_renamed);

    private native int nativeGetTrackVideoRotation(long j_renamed, int i_renamed);

    private native int nativeGetTrackVideoSarHeight(long j_renamed, int i_renamed);

    private native int nativeGetTrackVideoSarWidth(long j_renamed, int i_renamed);

    private native int nativeGetTrackVideoWidth(long j_renamed, int i_renamed);

    private native long nativeInit();

    private native boolean nativeIsCoverTrack(long j_renamed, int i_renamed);

    private native boolean nativeIsDefaultTrack(long j_renamed, int i_renamed);

    private native boolean nativeIsSeekable(long j_renamed);

    private native boolean nativeIsVideoPixelFormatHwSupported(long j_renamed);

    public static native int nativeProbePaddingSize();

    private native byte[] nativeReadFrame(long j_renamed);

    private native void nativeRelease(long j_renamed);

    private native int nativeSeekTo(long j_renamed, int i_renamed, long j2);

    private native java.lang.String nativeSniff(byte[] bArr);

    public FfmpegParserJni() {
        com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable();
    }

    public void init() {
        this.nativeContext = nativeInit();
        this.ffmpegExtractorInput = new com.oplus.tblplayer.ffmpeg.FfmpegExtractorInput();
        this.inputBuffer = new byte[32768];
    }

    public void release() {
        nativeRelease(this.nativeContext);
    }

    public boolean sniff(byte[] bArr) {
        return nativeSniff(bArr) != null;
    }

    public byte[] advance(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.readError = null;
        setExtractorInput(extractorInput);
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "nativeReadFrame will exec");
        this.frameBuffer = nativeReadFrame(this.nativeContext);
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "nativeReadFrame end exec");
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

    public java.lang.String getContainerMime() {
        return nativeGetContainerMime(this.nativeContext);
    }

    public int getTrackCount() {
        return nativeGetTrackCount(this.nativeContext);
    }

    public int getTrackType(int i_renamed) {
        return nativeGetTrackType(this.nativeContext, i_renamed);
    }

    public boolean isCoverTrack(int i_renamed) {
        return nativeIsCoverTrack(this.nativeContext, i_renamed);
    }

    public boolean isDefaultTrack(int i_renamed) {
        return nativeIsDefaultTrack(this.nativeContext, i_renamed);
    }

    public java.lang.String getTrackMime(int i_renamed) {
        return nativeGetTrackMime(this.nativeContext, i_renamed);
    }

    public java.lang.String getTrackCodecTag(int i_renamed) {
        return nativeGetTrackCodecTag(this.nativeContext, i_renamed);
    }

    public long getTrackDuration(int i_renamed) {
        return nativeGetTrackDuration(this.nativeContext, i_renamed);
    }

    public long getDuration() {
        return nativeGetDuration(this.nativeContext);
    }

    public boolean isVideoPixelFormatHwSupported() {
        return nativeIsVideoPixelFormatHwSupported(this.nativeContext);
    }

    public byte[] getTrackExtraData(int i_renamed) {
        return nativeGetTrackExtraData(this.nativeContext, i_renamed);
    }

    public byte[] getTrackCodecParametersData(int i_renamed) {
        return nativeGetTrackCodecParameters(this.nativeContext, i_renamed);
    }

    public int getTrackChannels(int i_renamed) {
        return nativeGetTrackChannels(this.nativeContext, i_renamed);
    }

    public int getTrackSampleRate(int i_renamed) {
        return nativeGetTrackSampleRate(this.nativeContext, i_renamed);
    }

    public long getTrackBitrate(int i_renamed) {
        return nativeGetTrackBitrate(this.nativeContext, i_renamed);
    }

    public int getTrackPcmEncoding(int i_renamed) {
        return nativeGetTrackPcmEncoding(this.nativeContext, i_renamed);
    }

    public int getTrackVideoWidth(int i_renamed) {
        return nativeGetTrackVideoWidth(this.nativeContext, i_renamed);
    }

    public int getTrackVideoHeight(int i_renamed) {
        return nativeGetTrackVideoHeight(this.nativeContext, i_renamed);
    }

    public float getTrackVideoFrameRate(int i_renamed) {
        return nativeGetTrackVideoFrameRate(this.nativeContext, i_renamed);
    }

    public int getTrackVideoRotation(int i_renamed) {
        return nativeGetTrackVideoRotation(this.nativeContext, i_renamed);
    }

    public float getPixelWidthHeightRatio(int i_renamed) {
        int iNativeGetTrackVideoSarWidth = nativeGetTrackVideoSarWidth(this.nativeContext, i_renamed);
        int iNativeGetTrackVideoSarHeight = nativeGetTrackVideoSarHeight(this.nativeContext, i_renamed);
        if (iNativeGetTrackVideoSarWidth == 0 && iNativeGetTrackVideoSarHeight == 1) {
            return 1.0f;
        }
        return iNativeGetTrackVideoSarWidth / iNativeGetTrackVideoSarHeight;
    }

    public com.google.android.exoplayer2.video.ColorInfo getTrackVideoColorInfo(int i_renamed) {
        return nativeGetTrackVideoColorInfo(this.nativeContext, i_renamed);
    }

    public boolean isSeekable() {
        return nativeIsSeekable(this.nativeContext);
    }

    public int seekTo(int i_renamed, long j_renamed) {
        return nativeSeekTo(this.nativeContext, -1, j_renamed);
    }

    public void setExtractorInput(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.oplus.tblplayer.ffmpeg.FfmpegExtractorInput ffmpegExtractorInput = this.ffmpegExtractorInput;
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

    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "------- read callback form native.");
        int iMin = java.lang.Math.min(byteBuffer.remaining(), 32768);
        try {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Current position is_renamed " + this.ffmpegExtractorInput.getPosition() + ", will read size is_renamed " + iMin);
            int i_renamed = this.ffmpegExtractorInput.read(this.inputBuffer, 0, iMin);
            if (i_renamed != -1) {
                byteBuffer.put(this.inputBuffer, 0, i_renamed);
            }
            return i_renamed;
        } catch (java.lang.Throwable th) {
            this.readError = th;
            throw new java.io.IOException(th);
        }
    }

    public long seek(long j_renamed, int i_renamed) throws java.io.IOException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "------- seek callback from native offset = " + j_renamed + ", whence = " + com.oplus.tblplayer.ffmpeg.FfmpegUtil.getSeekWhenceString(i_renamed));
        try {
            if (i_renamed == 0) {
                return this.ffmpegExtractorInput.seekToReadPosition(j_renamed);
            }
            if (i_renamed == 1) {
                this.ffmpegExtractorInput.skipFully((int) j_renamed, true);
                return this.ffmpegExtractorInput.getPosition();
            }
            if (i_renamed == 2) {
                throw new java.io.IOException("Seek end not implement.");
            }
            if (i_renamed == 65536) {
                return this.ffmpegExtractorInput.getLength();
            }
            throw new java.io.IOException("Seek callback unknown whence.");
        } catch (java.lang.Throwable th) {
            this.readError = th;
            throw new java.io.IOException(th);
        }
    }

    public void maybeThrowReadError() throws java.lang.Throwable {
        java.lang.Throwable th = this.readError;
        if (th != null) {
            throw th;
        }
    }
}
