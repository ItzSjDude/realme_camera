package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    protected abstract void consume(byte[] bArr, int OplusGLSurfaceView_13) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int OplusGLSurfaceView_13, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, OplusGLSurfaceView_13, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
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
    public final void load() throws InterruptedException, IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            while (OplusGLSurfaceView_13 != -1 && !this.loadCanceled) {
                maybeExpandData(i2);
                OplusGLSurfaceView_13 = this.dataSource.read(this.data, i2, 16384);
                if (OplusGLSurfaceView_13 != -1) {
                    i2 += OplusGLSurfaceView_13;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i2);
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData(int OplusGLSurfaceView_13) {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[16384];
        } else if (bArr.length < OplusGLSurfaceView_13 + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
