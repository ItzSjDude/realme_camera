package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public final class OfflineLicenseHelper<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
    private final android.os.ConditionVariable conditionVariable;
    private final com.google.android.exoplayer2.drm.DefaultDrmSessionManager<T_renamed> drmSessionManager;
    private final android.os.HandlerThread handlerThread = new android.os.HandlerThread("OfflineLicenseHelper");

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newWidevineInstance(java.lang.String str, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return newWidevineInstance(str, false, factory, null);
    }

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newWidevineInstance(java.lang.String str, boolean z_renamed, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return newWidevineInstance(str, z_renamed, factory, null);
    }

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newWidevineInstance(java.lang.String str, boolean z_renamed, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory, java.util.HashMap<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return new com.google.android.exoplayer2.drm.OfflineLicenseHelper<>(com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID, com.google.android.exoplayer2.drm.FrameworkMediaDrm.newInstance(com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID), new com.google.android.exoplayer2.drm.HttpMediaDrmCallback(str, z_renamed, factory), map);
    }

    public OfflineLicenseHelper(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map) {
        this.handlerThread.start();
        this.conditionVariable = new android.os.ConditionVariable();
        com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener = new com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener() { // from class: com.google.android.exoplayer2.drm.OfflineLicenseHelper.1
            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysLoaded() {
                com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmSessionManagerError(java.lang.Exception exc) {
                com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysRestored() {
                com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
            public void onDrmKeysRemoved() {
                com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.conditionVariable.open();
            }
        };
        this.drmSessionManager = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager<>(uuid, exoMediaDrm, mediaDrmCallback, map);
        this.drmSessionManager.addListener(new android.os.Handler(this.handlerThread.getLooper()), defaultDrmSessionEventListener);
    }

    public synchronized byte[] getPropertyByteArray(java.lang.String str) {
        return this.drmSessionManager.getPropertyByteArray(str);
    }

    public synchronized void setPropertyByteArray(java.lang.String str, byte[] bArr) {
        this.drmSessionManager.setPropertyByteArray(str, bArr);
    }

    public synchronized java.lang.String getPropertyString(java.lang.String str) {
        return this.drmSessionManager.getPropertyString(str);
    }

    public synchronized void setPropertyString(java.lang.String str, java.lang.String str2) {
        this.drmSessionManager.setPropertyString(str, str2);
    }

    public synchronized byte[] downloadLicense(com.google.android.exoplayer2.drm.DrmInitData drmInitData) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkArgument(drmInitData != null);
        return blockingKeyRequest(2, null, drmInitData);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, null);
    }

    public synchronized void releaseLicense(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, null);
    }

    public synchronized android.util.Pair<java.lang.Long, java.lang.Long> getLicenseDurationRemainingSec(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        com.google.android.exoplayer2.drm.DrmSession<T_renamed> drmSessionOpenBlockingKeyRequest = openBlockingKeyRequest(1, bArr, null);
        com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = drmSessionOpenBlockingKeyRequest.getError();
        android.util.Pair<java.lang.Long, java.lang.Long> licenseDurationRemainingSec = com.google.android.exoplayer2.drm.WidevineUtil.getLicenseDurationRemainingSec(drmSessionOpenBlockingKeyRequest);
        this.drmSessionManager.releaseSession(drmSessionOpenBlockingKeyRequest);
        if (error == null) {
            return licenseDurationRemainingSec;
        }
        if (error.getCause() instanceof com.google.android.exoplayer2.drm.KeysExpiredException) {
            return android.util.Pair.create(0L, 0L);
        }
        throw error;
    }

    public void release() {
        this.handlerThread.quit();
    }

    private byte[] blockingKeyRequest(int i_renamed, byte[] bArr, com.google.android.exoplayer2.drm.DrmInitData drmInitData) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.drm.DrmSession<T_renamed> drmSessionOpenBlockingKeyRequest = openBlockingKeyRequest(i_renamed, bArr, drmInitData);
        com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = drmSessionOpenBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = drmSessionOpenBlockingKeyRequest.getOfflineLicenseKeySetId();
        this.drmSessionManager.releaseSession(drmSessionOpenBlockingKeyRequest);
        if (error == null) {
            return offlineLicenseKeySetId;
        }
        throw error;
    }

    private com.google.android.exoplayer2.drm.DrmSession<T_renamed> openBlockingKeyRequest(int i_renamed, byte[] bArr, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        this.drmSessionManager.setMode(i_renamed, bArr);
        this.conditionVariable.close();
        com.google.android.exoplayer2.drm.DrmSession<T_renamed> drmSessionAcquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), drmInitData);
        this.conditionVariable.block();
        return drmSessionAcquireSession;
    }
}
