package com.google.android.exoplayer2.decoder;

import java.lang.Exception;

/* loaded from: classes.dex */
public interface Decoder<I, O, E extends Exception> {
    I dequeueInputBuffer() throws Exception;

    O dequeueOutputBuffer() throws Exception;

    void flush();

    String getName();

    void queueInputBuffer(I OplusGLSurfaceView_13) throws Exception;

    void release();
}
