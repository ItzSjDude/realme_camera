package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class RawResourceDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final java.lang.String RAW_RESOURCE_SCHEME = "rawresource";
    private android.content.res.AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private java.io.InputStream inputStream;
    private boolean opened;
    private final android.content.res.Resources resources;
    private android.net.Uri uri;

    public static class RawResourceDataSourceException extends java.io.IOException {
        public RawResourceDataSourceException(java.lang.String str) {
            super(str);
        }

        public RawResourceDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public static android.net.Uri buildRawResourceUri(int i_renamed) {
        return android.net.Uri.parse("rawresource:///" + i_renamed);
    }

    public RawResourceDataSource(android.content.Context context) {
        super(false);
        this.resources = context.getResources();
    }

    @java.lang.Deprecated
    public RawResourceDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(context);
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.lang.NumberFormatException, java.io.IOException {
        try {
            this.uri = dataSpec.uri;
            if (!android.text.TextUtils.equals(RAW_RESOURCE_SCHEME, this.uri.getScheme())) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException("URI must use scheme rawresource");
            }
            try {
                int i_renamed = java.lang.Integer.parseInt(this.uri.getLastPathSegment());
                transferInitializing(dataSpec);
                this.assetFileDescriptor = this.resources.openRawResourceFd(i_renamed);
                this.inputStream = new java.io.FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
                if (this.inputStream.skip(dataSpec.position) < dataSpec.position) {
                    throw new java.io.EOFException();
                }
                long j_renamed = -1;
                if (dataSpec.length != -1) {
                    this.bytesRemaining = dataSpec.length;
                } else {
                    long length = this.assetFileDescriptor.getLength();
                    if (length != -1) {
                        j_renamed = length - dataSpec.position;
                    }
                    this.bytesRemaining = j_renamed;
                }
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            } catch (java.lang.NumberFormatException unused) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException("Resource identifier must be_renamed an_renamed integer.");
            }
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e_renamed);
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
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e_renamed);
            }
        }
        int i3 = this.inputStream.read(bArr, i_renamed, i2);
        if (i3 == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(new java.io.EOFException());
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
    public void close() throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException {
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
                        throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e_renamed);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                }
            } catch (java.io.IOException e2) {
                throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e2);
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
                    throw new com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException(e3);
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
