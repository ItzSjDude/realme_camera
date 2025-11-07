package com.google.android.exoplayer2.extractor;

import java.io.IOException;

/* loaded from: classes.dex */
public interface ExtractorInput {
    void advancePeekPosition(int OplusGLSurfaceView_13) throws InterruptedException, IOException;

    boolean advancePeekPosition(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException;

    boolean peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException;

    int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException;

    void readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException;

    boolean readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) throws Throwable;

    int skip(int OplusGLSurfaceView_13) throws InterruptedException, IOException;

    void skipFully(int OplusGLSurfaceView_13) throws InterruptedException, IOException;

    boolean skipFully(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException;
}
