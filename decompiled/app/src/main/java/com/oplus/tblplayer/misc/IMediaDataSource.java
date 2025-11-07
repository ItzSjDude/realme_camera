package com.oplus.tblplayer.misc;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface IMediaDataSource {
    void close() throws IOException;

    long getSize() throws IOException;

    int readAt(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;
}
