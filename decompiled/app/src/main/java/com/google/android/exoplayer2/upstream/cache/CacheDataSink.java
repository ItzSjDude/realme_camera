package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class CacheDataSink implements com.google.android.exoplayer2.upstream.DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    private final int bufferSize;
    private com.google.android.exoplayer2.util.ReusableBufferedOutputStream bufferedOutputStream;
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private java.io.File file;
    private final long maxCacheFileSize;
    private java.io.OutputStream outputStream;
    private long outputStreamBytesWritten;
    private boolean syncFileDescriptor;
    private java.io.FileOutputStream underlyingFileOutputStream;

    public static class CacheDataSinkException extends com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        public CacheDataSinkException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long j_renamed) {
        this(cache, j_renamed, DEFAULT_BUFFER_SIZE);
    }

    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long j_renamed, int i_renamed) {
        this.cache = (com.google.android.exoplayer2.upstream.cache.Cache) com.google.android.exoplayer2.util.Assertions.checkNotNull(cache);
        this.maxCacheFileSize = j_renamed;
        this.bufferSize = i_renamed;
        this.syncFileDescriptor = true;
    }

    public void experimental_setSyncFileDescriptor(boolean z_renamed) {
        this.syncFileDescriptor = z_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException {
        if (dataSpec.length == -1 && !dataSpec.isFlagSet(2)) {
            this.dataSpec = null;
            return;
        }
        this.dataSpec = dataSpec;
        this.dataSpecBytesWritten = 0L;
        try {
            openNextOutputStream();
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                    closeCurrentOutputStream();
                    openNextOutputStream();
                }
                int iMin = (int) java.lang.Math.min(i2 - i3, this.maxCacheFileSize - this.outputStreamBytesWritten);
                this.outputStream.write(bArr, i_renamed + i3, iMin);
                i3 += iMin;
                long j_renamed = iMin;
                this.outputStreamBytesWritten += j_renamed;
                this.dataSpecBytesWritten += j_renamed;
            } catch (java.io.IOException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e_renamed);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException {
        if (this.dataSpec == null) {
            return;
        }
        try {
            closeCurrentOutputStream();
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e_renamed);
        }
    }

    private void openNextOutputStream() throws java.io.IOException {
        this.file = this.cache.startFile(this.dataSpec.key, this.dataSpecBytesWritten + this.dataSpec.absoluteStreamPosition, this.dataSpec.length == -1 ? this.maxCacheFileSize : java.lang.Math.min(this.dataSpec.length - this.dataSpecBytesWritten, this.maxCacheFileSize));
        this.underlyingFileOutputStream = new java.io.FileOutputStream(this.file);
        int i_renamed = this.bufferSize;
        if (i_renamed > 0) {
            com.google.android.exoplayer2.util.ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new com.google.android.exoplayer2.util.ReusableBufferedOutputStream(this.underlyingFileOutputStream, i_renamed);
            } else {
                reusableBufferedOutputStream.reset(this.underlyingFileOutputStream);
            }
            this.outputStream = this.bufferedOutputStream;
        } else {
            this.outputStream = this.underlyingFileOutputStream;
        }
        this.outputStreamBytesWritten = 0L;
    }

    private void closeCurrentOutputStream() throws java.io.IOException {
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.syncFileDescriptor) {
                this.underlyingFileOutputStream.getFD().sync();
            }
            com.google.android.exoplayer2.util.Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            java.io.File file = this.file;
            this.file = null;
            this.cache.commitFile(file);
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            java.io.File file2 = this.file;
            this.file = null;
            file2.delete();
            throw th;
        }
    }
}
