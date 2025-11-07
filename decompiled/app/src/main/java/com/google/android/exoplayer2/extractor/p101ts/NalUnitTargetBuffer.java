package com.google.android.exoplayer2.extractor.p101ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* loaded from: classes.dex */
final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int OplusGLSurfaceView_13, int i2) {
        this.targetType = OplusGLSurfaceView_13;
        this.nalData = new byte[i2 + 3];
        this.nalData[2] = 1;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void startNalUnit(int OplusGLSurfaceView_13) {
        Assertions.checkState(!this.isFilling);
        this.isFilling = OplusGLSurfaceView_13 == this.targetType;
        if (this.isFilling) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }

    public void appendToNalUnit(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (this.isFilling) {
            int i3 = i2 - OplusGLSurfaceView_13;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i4 = this.nalLength;
            if (length < i4 + i3) {
                this.nalData = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, OplusGLSurfaceView_13, this.nalData, this.nalLength, i3);
            this.nalLength += i3;
        }
    }

    public boolean endNalUnit(int OplusGLSurfaceView_13) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= OplusGLSurfaceView_13;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }
}
