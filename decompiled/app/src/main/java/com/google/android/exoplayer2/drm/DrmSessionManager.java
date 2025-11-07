package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public interface DrmSessionManager<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
    com.google.android.exoplayer2.drm.DrmSession<T_renamed> acquireSession(android.os.Looper looper, com.google.android.exoplayer2.drm.DrmInitData drmInitData);

    boolean canAcquireSession(com.google.android.exoplayer2.drm.DrmInitData drmInitData);

    void releaseSession(com.google.android.exoplayer2.drm.DrmSession<T_renamed> drmSession);
}
