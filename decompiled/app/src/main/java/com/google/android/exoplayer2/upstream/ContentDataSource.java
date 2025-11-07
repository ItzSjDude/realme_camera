package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class ContentDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    private android.content.res.AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private java.io.FileInputStream inputStream;
    private boolean opened;
    private final android.content.ContentResolver resolver;
    private android.net.Uri uri;

    public static class ContentDataSourceException extends java.io.IOException {
        public ContentDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(android.content.Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    @java.lang.Deprecated
    public ContentDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(context);
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        try {
            this.uri = dataSpec.uri;
            transferInitializing(dataSpec);
            this.assetFileDescriptor = this.resolver.openAssetFileDescriptor(this.uri, "r_renamed");
            if (this.assetFileDescriptor == null) {
                throw new java.io.FileNotFoundException("Could not open file descriptor for: " + this.uri);
            }
            this.inputStream = new java.io.FileInputStream(this.assetFileDescriptor.getFileDescriptor());
            long startOffset = this.assetFileDescriptor.getStartOffset();
            long jSkip = this.inputStream.skip(dataSpec.position + startOffset) - startOffset;
            if (jSkip != dataSpec.position) {
                throw new java.io.EOFException();
            }
            long jPosition = -1;
            if (dataSpec.length != -1) {
                this.bytesRemaining = dataSpec.length;
            } else {
                long length = this.assetFileDescriptor.getLength();
                if (length == -1) {
                    java.nio.channels.FileChannel channel = this.inputStream.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        jPosition = size - channel.position();
                    }
                    this.bytesRemaining = jPosition;
                } else {
                    this.bytesRemaining = length - jSkip;
                }
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e_renamed);
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
                throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e_renamed);
            }
        }
        int i3 = this.inputStream.read(bArr, i_renamed, i2);
        if (i3 == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(new java.io.EOFException());
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
    public void close() throws com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.inputStream != null) {
                    this.inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        if (this.assetFileDescriptor != null) {
                            this.assetFileDescriptor.close();
                        }
                    } catch (java.io.IOException e_renamed) {
                        throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e_renamed);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                }
            } catch (java.io.IOException e2) {
                throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e2);
            }
        } catch (java.lang.Throwable th) {
            this.inputStream = null;
            try {
                try {
                    if (this.assetFileDescriptor != null) {
                        this.assetFileDescriptor.close();
                    }
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                    throw th;
                } catch (java.io.IOException e3) {
                    throw new com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException(e3);
                }
            } finally {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            }
        }
    }
}
