package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public final class LocalMediaDrmCallback implements com.google.android.exoplayer2.drm.MediaDrmCallback {
    private final byte[] keyResponse;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.keyResponse = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest provisionRequest) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest keyRequest) throws java.lang.Exception {
        return this.keyResponse;
    }
}
