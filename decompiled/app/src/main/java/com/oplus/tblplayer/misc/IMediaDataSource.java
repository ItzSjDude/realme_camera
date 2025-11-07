package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public interface IMediaDataSource {
    void close() throws java.io.IOException;

    long getSize() throws java.io.IOException;

    int readAt(long j_renamed, byte[] bArr, int i_renamed, int i2) throws java.io.IOException;
}
