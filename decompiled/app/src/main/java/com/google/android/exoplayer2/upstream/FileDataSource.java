package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class FileDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    private long bytesRemaining;
    private java.io.RandomAccessFile file;
    private boolean opened;
    private android.net.Uri uri;

    public static class FileDataSourceException extends java.io.IOException {
        public FileDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    @java.lang.Deprecated
    public FileDataSource(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this();
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        try {
            this.uri = dataSpec.uri;
            transferInitializing(dataSpec);
            this.file = new java.io.RandomAccessFile(dataSpec.uri.getPath(), "r_renamed");
            this.file.seek(dataSpec.position);
            this.bytesRemaining = dataSpec.length == -1 ? this.file.length() - dataSpec.position : dataSpec.length;
            if (this.bytesRemaining < 0) {
                throw new java.io.EOFException();
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e_renamed);
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
        try {
            int i3 = this.file.read(bArr, i_renamed, (int) java.lang.Math.min(j_renamed, i2));
            if (i3 > 0) {
                this.bytesRemaining -= i3;
                bytesTransferred(i3);
            }
            return i3;
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.file != null) {
                    this.file.close();
                }
            } catch (java.io.IOException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException(e_renamed);
            }
        } finally {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }
}
