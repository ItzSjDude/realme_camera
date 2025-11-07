package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public abstract class DataChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    protected abstract void consume(byte[] bArr, int i_renamed) throws java.io.IOException;

    public DataChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed, com.google.android.exoplayer2.Format format, int i2, java.lang.Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i_renamed, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.lang.InterruptedException, java.io.IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i_renamed = 0;
            int i2 = 0;
            while (i_renamed != -1 && !this.loadCanceled) {
                maybeExpandData(i2);
                i_renamed = this.dataSource.read(this.data, i2, 16384);
                if (i_renamed != -1) {
                    i2 += i_renamed;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i2);
            }
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData(int i_renamed) {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[16384];
        } else if (bArr.length < i_renamed + 16384) {
            this.data = java.util.Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
