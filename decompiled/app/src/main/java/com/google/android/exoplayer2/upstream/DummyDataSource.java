package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DummyDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public static final com.google.android.exoplayer2.upstream.DummyDataSource INSTANCE = new com.google.android.exoplayer2.upstream.DummyDataSource();
    public static final com.google.android.exoplayer2.upstream.DataSource.Factory FACTORY = new com.google.android.exoplayer2.upstream.DataSource.Factory() { // from class: com.google.android.exoplayer2.upstream.-$$Lambda$DummyDataSource$5JL9ytmtADrptG840gjTuddaBKA
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public final com.google.android.exoplayer2.upstream.DataSource createDataSource() {
            return com.google.android.exoplayer2.upstream.DummyDataSource.lambda$5JL9ytmtADrptG840gjTuddaBKA();
        }
    };

    public static /* synthetic */ com.google.android.exoplayer2.upstream.DummyDataSource lambda$5JL9ytmtADrptG840gjTuddaBKA() {
        return new com.google.android.exoplayer2.upstream.DummyDataSource();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return null;
    }

    private DummyDataSource() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        throw new java.io.IOException("Dummy source");
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException();
    }
}
