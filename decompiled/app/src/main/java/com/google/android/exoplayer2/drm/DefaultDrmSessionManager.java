package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(18)
/* loaded from: classes.dex */
public class DefaultDrmSessionManager<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> implements com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager<T_renamed>, com.google.android.exoplayer2.drm.DrmSessionManager<T_renamed> {
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final java.lang.String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final java.lang.String TAG = "DefaultDrmSessionMgr";
    private final com.google.android.exoplayer2.drm.MediaDrmCallback callback;
    private final com.google.android.exoplayer2.util.EventDispatcher<com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener> eventDispatcher;
    private final int initialDrmRequestRetryCount;
    private final com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> mediaDrm;
    volatile com.google.android.exoplayer2.drm.DefaultDrmSessionManager<T_renamed>.MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private byte[] offlineLicenseKeySetId;
    private final java.util.HashMap<java.lang.String, java.lang.String> optionalKeyRequestParameters;
    private android.os.Looper playbackLooper;
    private final java.util.List<com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>> provisioningSessions;
    private final java.util.List<com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>> sessions;
    private final java.util.UUID uuid;

    @java.lang.Deprecated
    public interface EventListener extends com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final class MissingSchemeDataException extends java.lang.Exception {
        private MissingSchemeDataException(java.util.UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newWidevineInstance(com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> defaultDrmSessionManagerNewWidevineInstance = newWidevineInstance(mediaDrmCallback, map);
        if (handler != null && defaultDrmSessionEventListener != null) {
            defaultDrmSessionManagerNewWidevineInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return defaultDrmSessionManagerNewWidevineInstance;
    }

    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newWidevineInstance(com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return newFrameworkInstance(com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID, mediaDrmCallback, map);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newPlayReadyInstance(com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.lang.String str, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> defaultDrmSessionManagerNewPlayReadyInstance = newPlayReadyInstance(mediaDrmCallback, str);
        if (handler != null && defaultDrmSessionEventListener != null) {
            defaultDrmSessionManagerNewPlayReadyInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return defaultDrmSessionManagerNewPlayReadyInstance;
    }

    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newPlayReadyInstance(com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.lang.String str) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        java.util.HashMap map;
        if (android.text.TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new java.util.HashMap();
            map.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        }
        return newFrameworkInstance(com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID, mediaDrmCallback, map);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newFrameworkInstance(java.util.UUID uuid, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> defaultDrmSessionManagerNewFrameworkInstance = newFrameworkInstance(uuid, mediaDrmCallback, map);
        if (handler != null && defaultDrmSessionEventListener != null) {
            defaultDrmSessionManagerNewFrameworkInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return defaultDrmSessionManagerNewFrameworkInstance;
    }

    public static com.google.android.exoplayer2.drm.DefaultDrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> newFrameworkInstance(java.util.UUID uuid, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return new com.google.android.exoplayer2.drm.DefaultDrmSessionManager<>(uuid, (com.google.android.exoplayer2.drm.ExoMediaDrm) com.google.android.exoplayer2.drm.FrameworkMediaDrm.newInstance(uuid), mediaDrmCallback, map, false, 3);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map);
        if (handler == null || defaultDrmSessionEventListener == null) {
            return;
        }
        addListener(handler, defaultDrmSessionEventListener);
    }

    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map) {
        this(uuid, (com.google.android.exoplayer2.drm.ExoMediaDrm) exoMediaDrm, mediaDrmCallback, map, false, 3);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener, boolean z_renamed) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map, z_renamed);
        if (handler == null || defaultDrmSessionEventListener == null) {
            return;
        }
        addListener(handler, defaultDrmSessionEventListener);
    }

    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z_renamed) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map, z_renamed, 3);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener, boolean z_renamed, int i_renamed) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map, z_renamed, i_renamed);
        if (handler == null || defaultDrmSessionEventListener == null) {
            return;
        }
        addListener(handler, defaultDrmSessionEventListener);
    }

    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z_renamed, int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(exoMediaDrm);
        com.google.android.exoplayer2.util.Assertions.checkArgument(!com.google.android.exoplayer2.C_renamed.COMMON_PSSH_UUID.equals(uuid), "Use C_renamed.CLEARKEY_UUID instead");
        this.uuid = uuid;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = map;
        this.eventDispatcher = new com.google.android.exoplayer2.util.EventDispatcher<>();
        this.multiSession = z_renamed;
        this.initialDrmRequestRetryCount = i_renamed;
        this.mode = 0;
        this.sessions = new java.util.ArrayList();
        this.provisioningSessions = new java.util.ArrayList();
        if (z_renamed && com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(uuid) && com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
            exoMediaDrm.setPropertyString("sessionSharing", "enable");
        }
        exoMediaDrm.setOnEventListener(new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmEventListener());
    }

    public final void addListener(android.os.Handler handler, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.addListener(handler, defaultDrmSessionEventListener);
    }

    public final void removeListener(com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.removeListener(defaultDrmSessionEventListener);
    }

    public final java.lang.String getPropertyString(java.lang.String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final void setPropertyString(java.lang.String str, java.lang.String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final byte[] getPropertyByteArray(java.lang.String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final void setPropertyByteArray(java.lang.String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public void setMode(int i_renamed, byte[] bArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.sessions.isEmpty());
        if (i_renamed == 1 || i_renamed == 3) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        }
        this.mode = i_renamed;
        this.offlineLicenseKeySetId = bArr;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(com.google.android.exoplayer2.C_renamed.COMMON_PSSH_UUID)) {
                return false;
            }
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        java.lang.String str = drmInitData.schemeType;
        if (str == null || com.google.android.exoplayer2.C_renamed.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        return !(com.google.android.exoplayer2.C_renamed.CENC_TYPE_cbc1.equals(str) || com.google.android.exoplayer2.C_renamed.CENC_TYPE_cbcs.equals(str) || com.google.android.exoplayer2.C_renamed.CENC_TYPE_cens.equals(str)) || com.google.android.exoplayer2.util.Util.SDK_INT >= 25;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.exoplayer2.drm.DefaultDrmSession] */
    /* JADX WARN: Type inference failed for: r14v11, types: [com.google.android.exoplayer2.drm.DefaultDrmSession] */
    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public com.google.android.exoplayer2.drm.DrmSession<T_renamed> acquireSession(android.os.Looper looper, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list;
        com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession;
        android.os.Looper looper2 = this.playbackLooper;
        com.google.android.exoplayer2.util.Assertions.checkState(looper2 == null || looper2 == looper);
        if (this.sessions.isEmpty()) {
            this.playbackLooper = looper;
            if (this.mediaDrmHandler == null) {
                this.mediaDrmHandler = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmHandler(looper);
            }
        }
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager.SceneLoader_2 anonymousClass1 = null;
        if (this.offlineLicenseKeySetId == null) {
            java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> schemeDatas = getSchemeDatas(drmInitData, this.uuid, false);
            if (schemeDatas.isEmpty()) {
                final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException missingSchemeDataException = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException(this.uuid);
                this.eventDispatcher.dispatch(new com.google.android.exoplayer2.util.EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSessionManager$lsU4S5fVqixyNsHyDBIvI3jEzVc
                    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                    public final void sendTo(java.lang.Object obj) {
                        ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj).onDrmSessionManagerError(missingSchemeDataException);
                    }
                });
                return new com.google.android.exoplayer2.drm.ErrorStateDrmSession(new com.google.android.exoplayer2.drm.DrmSession.DrmSessionException(missingSchemeDataException));
            }
            list = schemeDatas;
        } else {
            list = null;
        }
        if (!this.multiSession) {
            if (!this.sessions.isEmpty()) {
                anonymousClass1 = this.sessions.get(0);
            }
        } else {
            java.util.Iterator<com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed> next = it.next();
                if (com.google.android.exoplayer2.util.Util.areEqual(next.schemeDatas, list)) {
                    anonymousClass1 = next;
                    break;
                }
            }
        }
        if (anonymousClass1 == null) {
            defaultDrmSession = new com.google.android.exoplayer2.drm.DefaultDrmSession(this.uuid, this.mediaDrm, this, list, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, looper, this.eventDispatcher, this.initialDrmRequestRetryCount);
            this.sessions.add(defaultDrmSession);
        } else {
            defaultDrmSession = (com.google.android.exoplayer2.drm.DrmSession<T_renamed>) anonymousClass1;
        }
        defaultDrmSession.acquire();
        return defaultDrmSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(com.google.android.exoplayer2.drm.DrmSession<T_renamed> drmSession) {
        if (drmSession instanceof com.google.android.exoplayer2.drm.ErrorStateDrmSession) {
            return;
        }
        com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed> defaultDrmSession = (com.google.android.exoplayer2.drm.DefaultDrmSession) drmSession;
        if (defaultDrmSession.release()) {
            this.sessions.remove(defaultDrmSession);
            if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
                this.provisioningSessions.get(1).provision();
            }
            this.provisioningSessions.remove(defaultDrmSession);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void provisionRequired(com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed> defaultDrmSession) {
        this.provisioningSessions.add(defaultDrmSession);
        if (this.provisioningSessions.size() == 1) {
            defaultDrmSession.provision();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionCompleted() {
        java.util.Iterator<com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>> it = this.provisioningSessions.iterator();
        while (it.hasNext()) {
            it.next().onProvisionCompleted();
        }
        this.provisioningSessions.clear();
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionError(java.lang.Exception exc) {
        java.util.Iterator<com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>> it = this.provisioningSessions.iterator();
        while (it.hasNext()) {
            it.next().onProvisionError(exc);
        }
        this.provisioningSessions.clear();
    }

    private static java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> getSchemeDatas(com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.UUID uuid, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList(drmInitData.schemeDataCount);
        for (int i_renamed = 0; i_renamed < drmInitData.schemeDataCount; i_renamed++) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = drmInitData.get(i_renamed);
            if ((schemeData.matches(uuid) || (com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(uuid) && schemeData.matches(com.google.android.exoplayer2.C_renamed.COMMON_PSSH_UUID))) && (schemeData.data != null || z_renamed)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends android.os.Handler {
        public MediaDrmHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession : com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(message.what);
                    return;
                }
            }
        }
    }

    private class MediaDrmEventListener implements com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener<T_renamed> {
        private MediaDrmEventListener() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(com.google.android.exoplayer2.drm.ExoMediaDrm<? extends T_renamed> exoMediaDrm, byte[] bArr, int i_renamed, int i2, byte[] bArr2) {
            if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.mode == 0) {
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.mediaDrmHandler.obtainMessage(i_renamed, bArr).sendToTarget();
            }
        }
    }
}
