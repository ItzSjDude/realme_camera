package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(18)
/* loaded from: classes.dex */
class DefaultDrmSession<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> implements com.google.android.exoplayer2.drm.DrmSession<T_renamed> {
    private static final int MAX_LICENSE_DURATION_TO_RENEW = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final java.lang.String TAG = "DefaultDrmSession";
    final com.google.android.exoplayer2.drm.MediaDrmCallback callback;
    private com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest currentKeyRequest;
    private com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final com.google.android.exoplayer2.util.EventDispatcher<com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener> eventDispatcher;
    private final int initialDrmRequestRetryCount;
    private com.google.android.exoplayer2.drm.DrmSession.DrmSessionException lastException;
    private T_renamed mediaCrypto;
    private final com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private int openCount;
    private final java.util.HashMap<java.lang.String, java.lang.String> optionalKeyRequestParameters;
    private com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>.PostRequestHandler postRequestHandler;
    final com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed>.PostResponseHandler postResponseHandler;
    private final com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager<T_renamed> provisioningManager;
    private android.os.HandlerThread requestHandlerThread;
    public final java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> schemeDatas;
    private byte[] sessionId;
    private int state;
    final java.util.UUID uuid;

    public interface ProvisioningManager<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
        void onProvisionCompleted();

        void onProvisionError(java.lang.Exception exc);

        void provisionRequired(com.google.android.exoplayer2.drm.DefaultDrmSession<T_renamed> defaultDrmSession);
    }

    public DefaultDrmSession(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm<T_renamed> exoMediaDrm, com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager<T_renamed> provisioningManager, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i_renamed, byte[] bArr, java.util.HashMap<java.lang.String, java.lang.String> map, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, android.os.Looper looper, com.google.android.exoplayer2.util.EventDispatcher<com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener> eventDispatcher, int i2) {
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.mediaDrm = exoMediaDrm;
        this.mode = i_renamed;
        this.offlineLicenseKeySetId = bArr;
        this.schemeDatas = bArr == null ? java.util.Collections.unmodifiableList(list) : null;
        this.optionalKeyRequestParameters = map;
        this.callback = mediaDrmCallback;
        this.initialDrmRequestRetryCount = i2;
        this.eventDispatcher = eventDispatcher;
        this.state = 2;
        this.postResponseHandler = new com.google.android.exoplayer2.drm.DefaultDrmSession.PostResponseHandler(looper);
        this.requestHandlerThread = new android.os.HandlerThread("DrmRequestHandler");
        this.requestHandlerThread.start();
        this.postRequestHandler = new com.google.android.exoplayer2.drm.DefaultDrmSession.PostRequestHandler(this.requestHandlerThread.getLooper());
    }

    public void acquire() {
        int i_renamed = this.openCount + 1;
        this.openCount = i_renamed;
        if (i_renamed == 1 && this.state != 1 && openInternal(true)) {
            doLicense(true);
        }
    }

    public boolean release() {
        int i_renamed = this.openCount - 1;
        this.openCount = i_renamed;
        if (i_renamed != 0) {
            return false;
        }
        this.state = 0;
        this.postResponseHandler.removeCallbacksAndMessages(null);
        this.postRequestHandler.removeCallbacksAndMessages(null);
        this.postRequestHandler = null;
        this.requestHandlerThread.quit();
        this.requestHandlerThread = null;
        this.mediaCrypto = null;
        this.lastException = null;
        this.currentKeyRequest = null;
        this.currentProvisionRequest = null;
        byte[] bArr = this.sessionId;
        if (bArr != null) {
            this.mediaDrm.closeSession(bArr);
            this.sessionId = null;
            this.eventDispatcher.dispatch(new com.google.android.exoplayer2.util.EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$1U2yJBSMBm8ESUSz9LUzNXtoVus
                @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                public final void sendTo(java.lang.Object obj) {
                    ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj).onDrmSessionReleased();
                }
            });
        }
        return true;
    }

    public boolean hasSessionId(byte[] bArr) {
        return java.util.Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i_renamed) {
        if (isOpen()) {
            if (i_renamed == 1) {
                this.state = 3;
                this.provisioningManager.provisionRequired(this);
            } else if (i_renamed == 2) {
                doLicense(false);
            } else {
                if (i_renamed != 3) {
                    return;
                }
                onKeysExpired();
            }
        }
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        this.postRequestHandler.post(0, this.currentProvisionRequest, true);
    }

    public void onProvisionCompleted() {
        if (openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(java.lang.Exception exc) {
        onError(exc);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T_renamed getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    private boolean openInternal(boolean z_renamed) {
        if (isOpen()) {
            return true;
        }
        try {
            this.sessionId = this.mediaDrm.openSession();
            this.eventDispatcher.dispatch(new com.google.android.exoplayer2.util.EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$jFcVU4qXZB2nhSZWHXCB9S7MtRI
                @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                public final void sendTo(java.lang.Object obj) {
                    ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj).onDrmSessionAcquired();
                }
            });
            this.mediaCrypto = (T_renamed) this.mediaDrm.createMediaCrypto(this.sessionId);
            this.state = 3;
            return true;
        } catch (android.media.NotProvisionedException e_renamed) {
            if (z_renamed) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e_renamed);
            return false;
        } catch (java.lang.Exception e2) {
            onError(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.currentProvisionRequest) {
            if (this.state == 2 || isOpen()) {
                this.currentProvisionRequest = null;
                if (obj2 instanceof java.lang.Exception) {
                    this.provisioningManager.onProvisionError((java.lang.Exception) obj2);
                    return;
                }
                try {
                    this.mediaDrm.provideProvisionResponse((byte[]) obj2);
                    this.provisioningManager.onProvisionCompleted();
                } catch (java.lang.Exception e_renamed) {
                    this.provisioningManager.onProvisionError(e_renamed);
                }
            }
        }
    }

    private void doLicense(boolean z_renamed) {
        int i_renamed = this.mode;
        if (i_renamed != 0 && i_renamed != 1) {
            if (i_renamed == 2) {
                if (this.offlineLicenseKeySetId == null) {
                    postKeyRequest(2, z_renamed);
                    return;
                } else {
                    if (restoreKeys()) {
                        postKeyRequest(2, z_renamed);
                        return;
                    }
                    return;
                }
            }
            if (i_renamed == 3 && restoreKeys()) {
                postKeyRequest(3, z_renamed);
                return;
            }
            return;
        }
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(1, z_renamed);
            return;
        }
        if (this.state == 4 || restoreKeys()) {
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
            if (this.mode != 0 || licenseDurationRemainingSec > 60) {
                if (licenseDurationRemainingSec <= 0) {
                    onError(new com.google.android.exoplayer2.drm.KeysExpiredException());
                    return;
                } else {
                    this.state = 4;
                    this.eventDispatcher.dispatch(com.google.android.exoplayer2.drm.$$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4.INSTANCE);
                    return;
                }
            }
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
            postKeyRequest(2, z_renamed);
        }
    }

    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (java.lang.Exception e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Error trying to restore Widevine keys.", e_renamed);
            onError(e_renamed);
            return false;
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        android.util.Pair<java.lang.Long, java.lang.Long> licenseDurationRemainingSec = com.google.android.exoplayer2.drm.WidevineUtil.getLicenseDurationRemainingSec(this);
        return java.lang.Math.min(((java.lang.Long) licenseDurationRemainingSec.first).longValue(), ((java.lang.Long) licenseDurationRemainingSec.second).longValue());
    }

    private void postKeyRequest(int i_renamed, boolean z_renamed) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(i_renamed == 3 ? this.offlineLicenseKeySetId : this.sessionId, this.schemeDatas, i_renamed, this.optionalKeyRequestParameters);
            this.postRequestHandler.post(1, this.currentKeyRequest, z_renamed);
        } catch (java.lang.Exception e_renamed) {
            onKeysError(e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (obj2 instanceof java.lang.Exception) {
                onKeysError((java.lang.Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, bArr);
                    this.eventDispatcher.dispatch(com.google.android.exoplayer2.drm.$$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4.INSTANCE);
                    return;
                }
                byte[] bArrProvideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                if ((this.mode == 2 || (this.mode == 0 && this.offlineLicenseKeySetId != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.offlineLicenseKeySetId = bArrProvideKeyResponse;
                }
                this.state = 4;
                this.eventDispatcher.dispatch(new com.google.android.exoplayer2.util.EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$wyKVEWJALn1OyjwryLo2GUxlQ2M
                    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                    public final void sendTo(java.lang.Object obj3) {
                        ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj3).onDrmKeysLoaded();
                    }
                });
            } catch (java.lang.Exception e_renamed) {
                onKeysError(e_renamed);
            }
        }
    }

    private void onKeysExpired() {
        if (this.state == 4) {
            this.state = 3;
            onError(new com.google.android.exoplayer2.drm.KeysExpiredException());
        }
    }

    private void onKeysError(java.lang.Exception exc) {
        if (exc instanceof android.media.NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(exc);
        }
    }

    private void onError(final java.lang.Exception exc) {
        this.lastException = new com.google.android.exoplayer2.drm.DrmSession.DrmSessionException(exc);
        this.eventDispatcher.dispatch(new com.google.android.exoplayer2.util.EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$-nKOJC1w2998gRg4Cg4l2mjlp30
            @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
            public final void sendTo(java.lang.Object obj) {
                ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj).onDrmSessionManagerError(exc);
            }
        });
        if (this.state != 4) {
            this.state = 1;
        }
    }

    private boolean isOpen() {
        int i_renamed = this.state;
        return i_renamed == 3 || i_renamed == 4;
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    private class PostResponseHandler extends android.os.Handler {
        public PostResponseHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.util.Pair pair = (android.util.Pair) message.obj;
            java.lang.Object obj = pair.first;
            java.lang.Object obj2 = pair.second;
            int i_renamed = message.what;
            if (i_renamed == 0) {
                com.google.android.exoplayer2.drm.DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else {
                if (i_renamed != 1) {
                    return;
                }
                com.google.android.exoplayer2.drm.DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    private class PostRequestHandler extends android.os.Handler {
        public PostRequestHandler(android.os.Looper looper) {
            super(looper);
        }

        void post(int i_renamed, java.lang.Object obj, boolean z_renamed) {
            obtainMessage(i_renamed, z_renamed ? 1 : 0, 0, obj).sendToTarget();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.Object obj = message.obj;
            try {
                int i_renamed = message.what;
                if (i_renamed == 0) {
                    e_renamed = com.google.android.exoplayer2.drm.DefaultDrmSession.this.callback.executeProvisionRequest(com.google.android.exoplayer2.drm.DefaultDrmSession.this.uuid, (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) obj);
                } else if (i_renamed == 1) {
                    e_renamed = com.google.android.exoplayer2.drm.DefaultDrmSession.this.callback.executeKeyRequest(com.google.android.exoplayer2.drm.DefaultDrmSession.this.uuid, (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) obj);
                } else {
                    throw new java.lang.RuntimeException();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed = e_renamed;
                if (maybeRetryRequest(message)) {
                    return;
                }
            }
            com.google.android.exoplayer2.drm.DefaultDrmSession.this.postResponseHandler.obtainMessage(message.what, android.util.Pair.create(obj, e_renamed)).sendToTarget();
        }

        private boolean maybeRetryRequest(android.os.Message message) {
            int i_renamed;
            if (!(message.arg1 == 1) || (i_renamed = message.arg2 + 1) > com.google.android.exoplayer2.drm.DefaultDrmSession.this.initialDrmRequestRetryCount) {
                return false;
            }
            android.os.Message messageObtain = android.os.Message.obtain(message);
            messageObtain.arg2 = i_renamed;
            sendMessageDelayed(messageObtain, getRetryDelayMillis(i_renamed));
            return true;
        }

        private long getRetryDelayMillis(int i_renamed) {
            return java.lang.Math.min((i_renamed - 1) * 1000, 5000);
        }
    }
}
