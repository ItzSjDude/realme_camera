package com.google.android.exoplayer2.ext.av1;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Gav1OutputBuffer extends OutputBuffer {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public ColorInfo colorInfo;
    public int colorspace;
    public ByteBuffer data;
    public int decoderPrivate;
    public int height;
    public int mode;
    private final Gav1Decoder owner;
    public int width;
    public ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    public Gav1OutputBuffer(Gav1Decoder gav1Decoder) {
        this.owner = gav1Decoder;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }

    public void init(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        this.timeUs = OplusGLSurfaceView_15;
        this.mode = OplusGLSurfaceView_13;
    }

    public boolean initForRgbFrame(int OplusGLSurfaceView_13, int i2) {
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
        this.yuvPlanes = null;
        if (!isSafeToMultiply(OplusGLSurfaceView_13, i2)) {
            return false;
        }
        int i3 = OplusGLSurfaceView_13 * i2;
        if (!isSafeToMultiply(i3, 2)) {
            return false;
        }
        initData(i3 * 2);
        return true;
    }

    public boolean initForYuvFrame(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
        this.colorspace = i5;
        int i6 = (int) ((i2 + 1) / 2);
        if (isSafeToMultiply(i3, i2) && isSafeToMultiply(i4, i6)) {
            int i7 = i2 * i3;
            int i8 = i6 * i4;
            int i9 = (i8 * 2) + i7;
            if (isSafeToMultiply(i8, 2) && i9 >= i7) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                    this.data = ByteBuffer.allocateDirect(i9);
                } else {
                    this.data.position(0);
                    this.data.limit(i9);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
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

    public void initForPrivateFrame(int OplusGLSurfaceView_13, int i2) {
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
    }

    private void initData(int OplusGLSurfaceView_13) {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < OplusGLSurfaceView_13) {
            this.data = ByteBuffer.allocateDirect(OplusGLSurfaceView_13);
        } else {
            this.data.position(0);
            this.data.limit(OplusGLSurfaceView_13);
        }
    }

    private boolean isSafeToMultiply(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 >= 0 && i2 >= 0 && (i2 <= 0 || OplusGLSurfaceView_13 < Integer.MAX_VALUE / i2);
    }
}
