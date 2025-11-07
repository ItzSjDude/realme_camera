package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface TransferListener {
    void onBytesTransferred(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed, int i_renamed);

    void onTransferEnd(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed);

    void onTransferInitializing(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed);

    void onTransferStart(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed);
}
