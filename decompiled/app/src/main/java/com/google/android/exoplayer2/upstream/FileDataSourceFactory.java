package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class FileDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    private final com.google.android.exoplayer2.upstream.TransferListener listener;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.listener = transferListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.DataSource createDataSource() {
        com.google.android.exoplayer2.upstream.FileDataSource fileDataSource = new com.google.android.exoplayer2.upstream.FileDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            fileDataSource.addTransferListener(transferListener);
        }
        return fileDataSource;
    }
}
