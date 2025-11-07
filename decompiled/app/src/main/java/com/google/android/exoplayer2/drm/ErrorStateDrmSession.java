package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public final class ErrorStateDrmSession<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> implements com.google.android.exoplayer2.drm.DrmSession<T_renamed> {
    private final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error;

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public T_renamed getMediaCrypto() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus() {
        return null;
    }

    public ErrorStateDrmSession(com.google.android.exoplayer2.drm.DrmSession.DrmSessionException drmSessionException) {
        this.error = (com.google.android.exoplayer2.drm.DrmSession.DrmSessionException) com.google.android.exoplayer2.util.Assertions.checkNotNull(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        return this.error;
    }
}
