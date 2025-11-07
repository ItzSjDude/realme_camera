package com.oplus.tblplayer.cache;

import com.oplus.tblplayer.misc.MediaUrl;

/* loaded from: classes2.dex */
public interface ICacheListener {
    void onCacheError(MediaUrl mediaUrl, int OplusGLSurfaceView_13, String str);

    void onCacheFinish(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, long j3, long j4);

    void onCacheStart(MediaUrl mediaUrl);
}
