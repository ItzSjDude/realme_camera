package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public interface Downloader {
    void cancel();

    void download() throws java.lang.InterruptedException, java.io.IOException;

    float getDownloadPercentage();

    long getDownloadedBytes();

    void remove() throws java.lang.InterruptedException;
}
