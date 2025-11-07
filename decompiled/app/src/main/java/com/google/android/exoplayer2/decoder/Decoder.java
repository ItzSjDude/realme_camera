package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public interface Decoder<I_renamed, O_renamed, E_renamed extends java.lang.Exception> {
    I_renamed dequeueInputBuffer() throws java.lang.Exception;

    O_renamed dequeueOutputBuffer() throws java.lang.Exception;

    void flush();

    java.lang.String getName();

    void queueInputBuffer(I_renamed i_renamed) throws java.lang.Exception;

    void release();
}
