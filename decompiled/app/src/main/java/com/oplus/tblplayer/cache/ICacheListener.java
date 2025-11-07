package com.oplus.tblplayer.cache;

/* loaded from: classes2.dex */
public interface ICacheListener {
    void onCacheError(com.oplus.tblplayer.misc.MediaUrl mediaUrl, int i_renamed, java.lang.String str);

    void onCacheFinish(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, long j3, long j4);

    void onCacheStart(com.oplus.tblplayer.misc.MediaUrl mediaUrl);
}
