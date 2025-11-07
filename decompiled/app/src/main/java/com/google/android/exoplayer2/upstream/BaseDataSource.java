package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList<TransferListener> listeners = new ArrayList<>(1);

    protected BaseDataSource(boolean z) {
        this.isNetwork = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        if (this.listeners.contains(transferListener)) {
            return;
        }
        this.listeners.add(transferListener);
        this.listenerCount++;
    }

    protected final void transferInitializing(DataSpec dataSpec) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.listenerCount; OplusGLSurfaceView_13++) {
            this.listeners.get(OplusGLSurfaceView_13).onTransferInitializing(this, dataSpec, this.isNetwork);
        }
    }

    protected final void transferStarted(DataSpec dataSpec) {
        this.dataSpec = dataSpec;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.listenerCount; OplusGLSurfaceView_13++) {
            this.listeners.get(OplusGLSurfaceView_13).onTransferStart(this, dataSpec, this.isNetwork);
        }
    }

    protected final void bytesTransferred(int OplusGLSurfaceView_13) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            this.listeners.get(i2).onBytesTransferred(this, dataSpec, this.isNetwork, OplusGLSurfaceView_13);
        }
    }

    protected final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.listenerCount; OplusGLSurfaceView_13++) {
            this.listeners.get(OplusGLSurfaceView_13).onTransferEnd(this, dataSpec, this.isNetwork);
        }
        this.dataSpec = null;
    }
}
