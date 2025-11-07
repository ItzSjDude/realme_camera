package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public abstract class BaseDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final java.util.ArrayList<com.google.android.exoplayer2.upstream.TransferListener> listeners = new java.util.ArrayList<>(1);

    protected BaseDataSource(boolean z_renamed) {
        this.isNetwork = z_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        if (this.listeners.contains(transferListener)) {
            return;
        }
        this.listeners.add(transferListener);
        this.listenerCount++;
    }

    protected final void transferInitializing(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        for (int i_renamed = 0; i_renamed < this.listenerCount; i_renamed++) {
            this.listeners.get(i_renamed).onTransferInitializing(this, dataSpec, this.isNetwork);
        }
    }

    protected final void transferStarted(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        this.dataSpec = dataSpec;
        for (int i_renamed = 0; i_renamed < this.listenerCount; i_renamed++) {
            this.listeners.get(i_renamed).onTransferStart(this, dataSpec, this.isNetwork);
        }
    }

    protected final void bytesTransferred(int i_renamed) {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Util.castNonNull(this.dataSpec);
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            this.listeners.get(i2).onBytesTransferred(this, dataSpec, this.isNetwork, i_renamed);
        }
    }

    protected final void transferEnded() {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Util.castNonNull(this.dataSpec);
        for (int i_renamed = 0; i_renamed < this.listenerCount; i_renamed++) {
            this.listeners.get(i_renamed).onTransferEnd(this, dataSpec, this.isNetwork);
        }
        this.dataSpec = null;
    }
}
