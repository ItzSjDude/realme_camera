package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DataSchemeDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final java.lang.String SCHEME_DATA = "data";
    private int bytesRead;
    private byte[] data;
    private com.google.android.exoplayer2.upstream.DataSpec dataSpec;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        transferInitializing(dataSpec);
        this.dataSpec = dataSpec;
        android.net.Uri uri = dataSpec.uri;
        java.lang.String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.google.android.exoplayer2.ParserException("Unsupported scheme: " + scheme);
        }
        java.lang.String[] strArrSplit = com.google.android.exoplayer2.util.Util.split(uri.getSchemeSpecificPart(), ",");
        if (strArrSplit.length != 2) {
            throw new com.google.android.exoplayer2.ParserException("Unexpected URI format: " + uri);
        }
        java.lang.String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.data = android.util.Base64.decode(str, 0);
            } catch (java.lang.IllegalArgumentException e_renamed) {
                throw new com.google.android.exoplayer2.ParserException("Error while parsing Base64 encoded string: " + str, e_renamed);
            }
        } else {
            this.data = com.google.android.exoplayer2.util.Util.getUtf8Bytes(java.net.URLDecoder.decode(str, "US-ASCII"));
        }
        transferStarted(dataSpec);
        return this.data.length;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.data.length - this.bytesRead;
        if (length == 0) {
            return -1;
        }
        int iMin = java.lang.Math.min(i2, length);
        java.lang.System.arraycopy(this.data, this.bytesRead, bArr, i_renamed, iMin);
        this.bytesRead += iMin;
        bytesTransferred(iMin);
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        if (this.data != null) {
            this.data = null;
            transferEnded();
        }
        this.dataSpec = null;
    }
}
