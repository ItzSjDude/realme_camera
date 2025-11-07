package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class AssetDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    private final android.content.res.AssetManager assetManager;
    private long bytesRemaining;
    private java.io.InputStream inputStream;
    private boolean opened;
    private android.net.Uri uri;

    public static final class AssetDataSourceException extends java.io.IOException {
        public AssetDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(android.content.Context context) {
        super(false);
        this.assetManager = context.getAssets();
    }

    @java.lang.Deprecated
    public AssetDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(context);
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException, java.io.EOFException {
        try {
            this.uri = dataSpec.uri;
            java.lang.String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            transferInitializing(dataSpec);
            this.inputStream = this.assetManager.open(path, 1);
            if (this.inputStream.skip(dataSpec.position) < dataSpec.position) {
                throw new java.io.EOFException();
            }
            if (dataSpec.length != -1) {
                this.bytesRemaining = dataSpec.length;
            } else {
                this.bytesRemaining = this.inputStream.available();
                if (this.bytesRemaining == 2147483647L) {
                    this.bytesRemaining = -1L;
                }
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        long j_renamed = this.bytesRemaining;
        if (j_renamed == 0) {
            return -1;
        }
        if (j_renamed != -1) {
            try {
                i2 = (int) java.lang.Math.min(j_renamed, i2);
            } catch (java.io.IOException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e_renamed);
            }
        }
        int i3 = this.inputStream.read(bArr, i_renamed, i2);
        if (i3 == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(new java.io.EOFException());
        }
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - i3;
        }
        bytesTransferred(i3);
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.inputStream != null) {
                    this.inputStream.close();
                }
            } catch (java.io.IOException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException(e_renamed);
            }
        } finally {
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }
}
