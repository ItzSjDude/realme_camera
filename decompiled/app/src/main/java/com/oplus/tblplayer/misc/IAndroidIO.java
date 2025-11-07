package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public interface IAndroidIO {
    int close() throws java.io.IOException;

    int open(java.lang.String str) throws java.io.IOException;

    int read(byte[] bArr, int i_renamed) throws java.io.IOException;

    long seek(long j_renamed, int i_renamed) throws java.io.IOException;
}
