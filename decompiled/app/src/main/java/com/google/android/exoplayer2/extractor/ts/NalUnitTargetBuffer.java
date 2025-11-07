package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i_renamed, int i2) {
        this.targetType = i_renamed;
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

    public void startNalUnit(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.isFilling);
        this.isFilling = i_renamed == this.targetType;
        if (this.isFilling) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }

    public void appendToNalUnit(byte[] bArr, int i_renamed, int i2) {
        if (this.isFilling) {
            int i3 = i2 - i_renamed;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i4 = this.nalLength;
            if (length < i4 + i3) {
                this.nalData = java.util.Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            java.lang.System.arraycopy(bArr, i_renamed, this.nalData, this.nalLength, i3);
            this.nalLength += i3;
        }
    }

    public boolean endNalUnit(int i_renamed) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i_renamed;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }
}
