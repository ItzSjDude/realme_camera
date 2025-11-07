package com.oplus.tblplayer.ffmpeg;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class PCMConvertor {
    private long context;
    private final int inPcmEncoding;
    private ByteBuffer outBuffer;
    private final int outPcmEncoding = 2;

    public static int getSampleSize(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            return 3;
        }
        if (OplusGLSurfaceView_13 != 1073741824) {
            if (OplusGLSurfaceView_13 == 2) {
                return 2;
            }
            if (OplusGLSurfaceView_13 == 3) {
                return 1;
            }
            if (OplusGLSurfaceView_13 != 4) {
                return 0;
            }
        }
        return 4;
    }

    protected native int pcmConvert(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, ByteBuffer byteBuffer2, int i2);

    protected native long pcmCreateContext(int OplusGLSurfaceView_13, int i2);

    protected native void pcmDestroyContext(long OplusGLSurfaceView_15);

    public PCMConvertor(int OplusGLSurfaceView_13) {
        this.inPcmEncoding = OplusGLSurfaceView_13;
        this.context = pcmCreateContext(getSampleSize(OplusGLSurfaceView_13), getSampleSize(this.outPcmEncoding));
    }

    protected void finalize() throws Throwable {
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

    public ByteBuffer convert(ByteBuffer byteBuffer) {
        int OplusGLSurfaceView_13 = this.inPcmEncoding;
        if (OplusGLSurfaceView_13 == this.outPcmEncoding) {
            return byteBuffer;
        }
        int sampleSize = getSampleSize(OplusGLSurfaceView_13);
        int iLimit = ((byteBuffer.limit() - byteBuffer.position()) / sampleSize) * getSampleSize(this.outPcmEncoding);
        ByteBuffer byteBuffer2 = this.outBuffer;
        if (byteBuffer2 == null || byteBuffer2.limit() < iLimit) {
            this.outBuffer = ByteBuffer.allocateDirect(iLimit).order(ByteOrder.nativeOrder());
        }
        int iPosition = byteBuffer.position();
        int iPcmConvert = pcmConvert(this.context, byteBuffer, byteBuffer.limit(), this.outBuffer, iLimit);
        byteBuffer.position(iPosition);
        this.outBuffer.limit(iPcmConvert);
        return this.outBuffer;
    }
}
