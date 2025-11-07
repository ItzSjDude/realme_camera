package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface DataSource {

    public interface Factory {
        com.google.android.exoplayer2.upstream.DataSource createDataSource();
    }

    void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener);

    void close() throws java.io.IOException;

    android.net.Uri getUri();

    long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException;

    int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    default java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return java.util.Collections.emptyMap();
    }
}
