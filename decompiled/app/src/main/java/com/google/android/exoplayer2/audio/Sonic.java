package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int i_renamed, int i2, float f_renamed, float f2, int i3) {
        this.inputSampleRateHz = i_renamed;
        this.channelCount = i2;
        this.speed = f_renamed;
        this.pitch = f2;
        this.rate = i_renamed / i3;
        this.minPeriod = i_renamed / 400;
        this.maxPeriod = i_renamed / 65;
        this.maxRequiredFrameCount = this.maxPeriod * 2;
        int i4 = this.maxRequiredFrameCount;
        this.downSampleBuffer = new short[i4];
        this.inputBuffer = new short[i4 * i2];
        this.outputBuffer = new short[i4 * i2];
        this.pitchBuffer = new short[i4 * i2];
    }

    public void queueInput(java.nio.ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i_renamed = this.channelCount;
        int i2 = iRemaining / i_renamed;
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, i2);
        shortBuffer.get(this.inputBuffer, this.inputFrameCount * this.channelCount, ((i_renamed * i2) * 2) / 2);
        this.inputFrameCount += i2;
        processStreamInput();
    }

    public void getOutput(java.nio.ShortBuffer shortBuffer) {
        int iMin = java.lang.Math.min(shortBuffer.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer.put(this.outputBuffer, 0, this.channelCount * iMin);
        this.outputFrameCount -= iMin;
        short[] sArr = this.outputBuffer;
        int i_renamed = this.channelCount;
        java.lang.System.arraycopy(sArr, iMin * i_renamed, sArr, 0, this.outputFrameCount * i_renamed);
    }

    public void queueEndOfStream() {
        int i_renamed;
        int i2 = this.inputFrameCount;
        float f_renamed = this.speed;
        float f2 = this.pitch;
        int i3 = this.outputFrameCount + ((int) ((((i2 / (f_renamed / f2)) + this.pitchFrameCount) / (this.rate * f2)) + 0.5f));
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, i2, (this.maxRequiredFrameCount * 2) + i2);
        int i4 = 0;
        while (true) {
            i_renamed = this.maxRequiredFrameCount;
            int i5 = this.channelCount;
            if (i4 >= i_renamed * 2 * i5) {
                break;
            }
            this.inputBuffer[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.inputFrameCount += i_renamed * 2;
        processStreamInput();
        if (this.outputFrameCount > i3) {
            this.outputFrameCount = i3;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public int getFramesAvailable() {
        return this.outputFrameCount;
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArr, int i_renamed, int i2) {
        int length = sArr.length;
        int i3 = this.channelCount;
        int i4 = length / i3;
        return i_renamed + i2 <= i4 ? sArr : java.util.Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private void removeProcessedInputFrames(int i_renamed) {
        int i2 = this.inputFrameCount - i_renamed;
        short[] sArr = this.inputBuffer;
        int i3 = this.channelCount;
        java.lang.System.arraycopy(sArr, i_renamed * i3, sArr, 0, i3 * i2);
        this.inputFrameCount = i2;
    }

    private void copyToOutput(short[] sArr, int i_renamed, int i2) {
        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i2);
        int i3 = this.channelCount;
        java.lang.System.arraycopy(sArr, i_renamed * i3, this.outputBuffer, this.outputFrameCount * i3, i3 * i2);
        this.outputFrameCount += i2;
    }

    private int copyInputToOutput(int i_renamed) {
        int iMin = java.lang.Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        copyToOutput(this.inputBuffer, i_renamed, iMin);
        this.remainingInputToCopyFrameCount -= iMin;
        return iMin;
    }

    private void downSampleInput(short[] sArr, int i_renamed, int i2) {
        int i3 = this.maxRequiredFrameCount / i2;
        int i4 = this.channelCount;
        int i5 = i2 * i4;
        int i6 = i_renamed * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.downSampleBuffer[i7] = (short) (i8 / i5);
        }
    }

    private int findPitchPeriodInRange(short[] sArr, int i_renamed, int i2, int i3) {
        int i4 = i_renamed * this.channelCount;
        int i5 = 1;
        int i6 = 0;
        int i7 = 255;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += java.lang.Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            if (iAbs * i8 < i5 * i2) {
                i8 = i2;
                i5 = iAbs;
            }
            if (iAbs * i7 > i6 * i2) {
                i7 = i2;
                i6 = iAbs;
            }
            i2++;
        }
        this.minDiff = i5 / i8;
        this.maxDiff = i6 / i7;
        return i8;
    }

    private boolean previousPeriodBetter(int i_renamed, int i2) {
        return i_renamed != 0 && this.prevPeriod != 0 && i2 <= i_renamed * 3 && i_renamed * 2 > this.prevMinDiff * 3;
    }

    private int findPitchPeriod(short[] sArr, int i_renamed) {
        int iFindPitchPeriodInRange;
        int i2 = this.inputSampleRateHz;
        int i3 = i2 > 4000 ? i2 / 4000 : 1;
        if (this.channelCount == 1 && i3 == 1) {
            iFindPitchPeriodInRange = findPitchPeriodInRange(sArr, i_renamed, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i_renamed, i3);
            int iFindPitchPeriodInRange2 = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i3, this.maxPeriod / i3);
            if (i3 != 1) {
                int i4 = iFindPitchPeriodInRange2 * i3;
                int i5 = i3 * 4;
                int i6 = i4 - i5;
                int i7 = i4 + i5;
                int i8 = this.minPeriod;
                if (i6 >= i8) {
                    i8 = i6;
                }
                int i9 = this.maxPeriod;
                if (i7 > i9) {
                    i7 = i9;
                }
                if (this.channelCount == 1) {
                    iFindPitchPeriodInRange = findPitchPeriodInRange(sArr, i_renamed, i8, i7);
                } else {
                    downSampleInput(sArr, i_renamed, 1);
                    iFindPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, i8, i7);
                }
            } else {
                iFindPitchPeriodInRange = iFindPitchPeriodInRange2;
            }
        }
        int i10 = previousPeriodBetter(this.minDiff, this.maxDiff) ? this.prevPeriod : iFindPitchPeriodInRange;
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = iFindPitchPeriodInRange;
        return i10;
    }

    private void moveNewSamplesToPitchBuffer(int i_renamed) {
        int i2 = this.outputFrameCount - i_renamed;
        this.pitchBuffer = ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, i2);
        short[] sArr = this.outputBuffer;
        int i3 = this.channelCount;
        java.lang.System.arraycopy(sArr, i_renamed * i3, this.pitchBuffer, this.pitchFrameCount * i3, i3 * i2);
        this.outputFrameCount = i_renamed;
        this.pitchFrameCount += i2;
    }

    private void removePitchFrames(int i_renamed) {
        if (i_renamed == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i2 = this.channelCount;
        java.lang.System.arraycopy(sArr, i_renamed * i2, sArr, 0, (this.pitchFrameCount - i_renamed) * i2);
        this.pitchFrameCount -= i_renamed;
    }

    private short interpolate(short[] sArr, int i_renamed, int i2, int i3) {
        short s_renamed = sArr[i_renamed];
        short s2 = sArr[i_renamed + this.channelCount];
        int i4 = this.newRatePosition * i2;
        int i5 = this.oldRatePosition;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s_renamed * i8) + ((i9 - i8) * s2)) / i9);
    }

    private void adjustRate(float f_renamed, int i_renamed) {
        int i2;
        int i3;
        if (this.outputFrameCount == i_renamed) {
            return;
        }
        int i4 = this.inputSampleRateHz;
        int i5 = (int) (i4 / f_renamed);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        moveNewSamplesToPitchBuffer(i_renamed);
        int i6 = 0;
        while (true) {
            int i7 = this.pitchFrameCount;
            if (i6 < i7 - 1) {
                while (true) {
                    i2 = this.oldRatePosition;
                    int i8 = (i2 + 1) * i5;
                    i3 = this.newRatePosition;
                    if (i8 <= i3 * i4) {
                        break;
                    }
                    this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                    int i9 = 0;
                    while (true) {
                        int i10 = this.channelCount;
                        if (i9 < i10) {
                            this.outputBuffer[(this.outputFrameCount * i10) + i9] = interpolate(this.pitchBuffer, (i10 * i6) + i9, i4, i5);
                            i9++;
                        }
                    }
                    this.newRatePosition++;
                    this.outputFrameCount++;
                }
                this.oldRatePosition = i2 + 1;
                if (this.oldRatePosition == i4) {
                    this.oldRatePosition = 0;
                    com.google.android.exoplayer2.util.Assertions.checkState(i3 == i5);
                    this.newRatePosition = 0;
                }
                i6++;
            } else {
                removePitchFrames(i7 - 1);
                return;
            }
        }
    }

    private int skipPitchPeriod(short[] sArr, int i_renamed, float f_renamed, int i2) {
        int i3;
        if (f_renamed >= 2.0f) {
            i3 = (int) (i2 / (f_renamed - 1.0f));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((i2 * (2.0f - f_renamed)) / (f_renamed - 1.0f));
            i3 = i2;
        }
        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i3);
        overlapAdd(i3, this.channelCount, this.outputBuffer, this.outputFrameCount, sArr, i_renamed, sArr, i_renamed + i2);
        this.outputFrameCount += i3;
        return i3;
    }

    private int insertPitchPeriod(short[] sArr, int i_renamed, float f_renamed, int i2) {
        int i3;
        if (f_renamed < 0.5f) {
            i3 = (int) ((i2 * f_renamed) / (1.0f - f_renamed));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((i2 * ((2.0f * f_renamed) - 1.0f)) / (1.0f - f_renamed));
            i3 = i2;
        }
        int i4 = i2 + i3;
        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i4);
        int i5 = this.channelCount;
        java.lang.System.arraycopy(sArr, i_renamed * i5, this.outputBuffer, this.outputFrameCount * i5, i5 * i2);
        overlapAdd(i3, this.channelCount, this.outputBuffer, this.outputFrameCount + i2, sArr, i_renamed + i2, sArr, i_renamed);
        this.outputFrameCount += i4;
        return i3;
    }

    private void changeSpeed(float f_renamed) {
        int iInsertPitchPeriod;
        int i_renamed = this.inputFrameCount;
        if (i_renamed < this.maxRequiredFrameCount) {
            return;
        }
        int i2 = 0;
        do {
            if (this.remainingInputToCopyFrameCount > 0) {
                iInsertPitchPeriod = copyInputToOutput(i2);
            } else {
                int iFindPitchPeriod = findPitchPeriod(this.inputBuffer, i2);
                if (f_renamed > 1.0d) {
                    iInsertPitchPeriod = iFindPitchPeriod + skipPitchPeriod(this.inputBuffer, i2, f_renamed, iFindPitchPeriod);
                } else {
                    iInsertPitchPeriod = insertPitchPeriod(this.inputBuffer, i2, f_renamed, iFindPitchPeriod);
                }
            }
            i2 += iInsertPitchPeriod;
        } while (this.maxRequiredFrameCount + i2 <= i_renamed);
        removeProcessedInputFrames(i2);
    }

    private void processStreamInput() {
        int i_renamed = this.outputFrameCount;
        float f_renamed = this.speed;
        float f2 = this.pitch;
        float f3 = f_renamed / f2;
        float f4 = this.rate * f2;
        double d_renamed = f3;
        if (d_renamed > 1.00001d || d_renamed < 0.99999d) {
            changeSpeed(f3);
        } else {
            copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if (f4 != 1.0f) {
            adjustRate(f4, i_renamed);
        }
    }

    private static void overlapAdd(int i_renamed, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i_renamed; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i_renamed - i10)) + (sArr3[i8] * i10)) / i_renamed);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
