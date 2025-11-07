package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class VideoDecoderOutputBuffer extends com.oplus.tblplayer.ffmpeg.OutputBuffer {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public static final int VIDEO_OUTPUT_MODE_NONE = -1;
    public static final int VIDEO_OUTPUT_MODE_SURFACE_YUV = 1;
    public static final int VIDEO_OUTPUT_MODE_YUV = 0;
    public com.google.android.exoplayer2.video.ColorInfo colorInfo;
    public int colorspace;
    public java.nio.ByteBuffer data;
    public int decoderPrivate;
    public int height;
    public int mode;
    private final com.oplus.tblplayer.ffmpeg.OutputBuffer.Owner<com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer> owner;
    public java.nio.ByteBuffer supplementalData;
    public int width;
    public java.nio.ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoOutputMode {
    }

    public VideoDecoderOutputBuffer(com.oplus.tblplayer.ffmpeg.OutputBuffer.Owner<com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer> owner) {
        this.owner = owner;
    }

    @Override // com.oplus.tblplayer.ffmpeg.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }

    public void init(long j_renamed, int i_renamed, java.nio.ByteBuffer byteBuffer) {
        this.timeUs = j_renamed;
        this.mode = i_renamed;
        if (byteBuffer != null && byteBuffer.hasRemaining()) {
            int iLimit = byteBuffer.limit();
            java.nio.ByteBuffer byteBuffer2 = this.supplementalData;
            if (byteBuffer2 == null || byteBuffer2.capacity() < iLimit) {
                this.supplementalData = java.nio.ByteBuffer.allocate(iLimit);
            } else {
                this.supplementalData.clear();
            }
            this.supplementalData.put(byteBuffer);
            this.supplementalData.flip();
            byteBuffer.position(0);
            return;
        }
        this.supplementalData = null;
    }

    public boolean initForYuvFrame(int i_renamed, int i2, int i3, int i4, int i5) {
        this.width = i_renamed;
        this.height = i2;
        this.colorspace = i5;
        int i6 = (int) ((i2 + 1) / 2);
        if (isSafeToMultiply(i3, i2) && isSafeToMultiply(i4, i6)) {
            int i7 = i2 * i3;
            int i8 = i6 * i4;
            int i9 = (i8 * 2) + i7;
            if (isSafeToMultiply(i8, 2) && i9 >= i7) {
                java.nio.ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                    this.data = java.nio.ByteBuffer.allocateDirect(i9);
                } else {
                    this.data.position(0);
                    this.data.limit(i9);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new java.nio.ByteBuffer[3];
                }
                java.nio.ByteBuffer byteBuffer2 = this.data;
                java.nio.ByteBuffer[] byteBufferArr = this.yuvPlanes;
                byteBufferArr[0] = byteBuffer2.slice();
                byteBufferArr[0].limit(i7);
                byteBuffer2.position(i7);
                byteBufferArr[1] = byteBuffer2.slice();
                byteBufferArr[1].limit(i8);
                byteBuffer2.position(i7 + i8);
                byteBufferArr[2] = byteBuffer2.slice();
                byteBufferArr[2].limit(i8);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i3;
                iArr[1] = i4;
                iArr[2] = i4;
                return true;
            }
        }
        return false;
    }

    public void initForPrivateFrame(int i_renamed, int i2) {
        this.width = i_renamed;
        this.height = i2;
    }

    private static boolean isSafeToMultiply(int i_renamed, int i2) {
        return i_renamed >= 0 && i2 >= 0 && (i2 <= 0 || i_renamed < Integer.MAX_VALUE / i2);
    }
}
