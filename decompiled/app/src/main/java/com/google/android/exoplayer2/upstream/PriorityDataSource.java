package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class PriorityDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private final int priority;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final com.google.android.exoplayer2.upstream.DataSource upstream;

    public PriorityDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i_renamed) {
        this.upstream = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
        this.priorityTaskManager = (com.google.android.exoplayer2.util.PriorityTaskManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(priorityTaskManager);
        this.priority = i_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.upstream.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        this.priorityTaskManager.proceedOrThrow(this.priority);
        return this.upstream.read(bArr, i_renamed, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        this.upstream.close();
    }
}
