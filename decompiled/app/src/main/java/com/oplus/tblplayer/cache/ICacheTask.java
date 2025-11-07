package com.oplus.tblplayer.cache;

/* loaded from: classes2.dex */
public interface ICacheTask {
    void cancel();

    String getKey();

    boolean isFinished();
}
