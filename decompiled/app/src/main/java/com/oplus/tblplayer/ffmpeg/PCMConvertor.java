package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class PCMConvertor {
    private long context;
    private final int inPcmEncoding;
    private java.nio.ByteBuffer outBuffer;
    private final int outPcmEncoding = 2;

    public static int getSampleSize(int i_renamed) {
        if (i_renamed == Integer.MIN_VALUE) {
            return 3;
        }
        if (i_renamed != 1073741824) {
            if (i_renamed == 2) {
                return 2;
            }
            if (i_renamed == 3) {
                return 1;
            }
            if (i_renamed != 4) {
                return 0;
            }
        }
        return 4;
    }

    protected native int pcmConvert(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, java.nio.ByteBuffer byteBuffer2, int i2);

    protected native long pcmCreateContext(int i_renamed, int i2);

    protected native void pcmDestroyContext(long j_renamed);

    public PCMConvertor(int i_renamed) {
        this.inPcmEncoding = i_renamed;
        this.context = pcmCreateContext(getSampleSize(i_renamed), getSampleSize(this.outPcmEncoding));
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        pcmDestroyContext(this.context);
    }

    public int getInPcmEncoding() {
        return this.inPcmEncoding;
    }

    public int getOutPcmEncoding() {
        return this.outPcmEncoding;
    }

    public int getOutSampleSize() {
        return getSampleSize(this.outPcmEncoding);
    }

    public java.nio.ByteBuffer convert(java.nio.ByteBuffer byteBuffer) {
        int i_renamed = this.inPcmEncoding;
        if (i_renamed == this.outPcmEncoding) {
            return byteBuffer;
        }
        int sampleSize = getSampleSize(i_renamed);
        int iLimit = ((byteBuffer.limit() - byteBuffer.position()) / sampleSize) * getSampleSize(this.outPcmEncoding);
        java.nio.ByteBuffer byteBuffer2 = this.outBuffer;
        if (byteBuffer2 == null || byteBuffer2.limit() < iLimit) {
            this.outBuffer = java.nio.ByteBuffer.allocateDirect(iLimit).order(java.nio.ByteOrder.nativeOrder());
        }
        int iPosition = byteBuffer.position();
        int iPcmConvert = pcmConvert(this.context, byteBuffer, byteBuffer.limit(), this.outBuffer, iLimit);
        byteBuffer.position(iPosition);
        this.outBuffer.limit(iPcmConvert);
        return this.outBuffer;
    }
}
