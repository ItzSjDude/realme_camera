package com.oplus.tblplayer.misc;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface IAndroidIO {
    int close() throws IOException;

    int open(String str) throws IOException;

    int read(byte[] bArr, int OplusGLSurfaceView_13) throws IOException;

    long seek(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) throws IOException;
}
