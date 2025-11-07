package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public interface AudioProcessor {
    public static final java.nio.ByteBuffer EMPTY_BUFFER = java.nio.ByteBuffer.allocateDirect(0).order(java.nio.ByteOrder.nativeOrder());

    boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;

    void flush();

    java.nio.ByteBuffer getOutput();

    int getOutputChannelCount();

    int getOutputEncoding();

    int getOutputSampleRateHz();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(java.nio.ByteBuffer byteBuffer);

    void reset();

    public static final class UnhandledFormatException extends java.lang.Exception {
        public UnhandledFormatException(int i_renamed, int i2, int i3) {
            super("Unhandled format: " + i_renamed + " Hz, " + i2 + " channels in_renamed encoding " + i3);
        }
    }
}
