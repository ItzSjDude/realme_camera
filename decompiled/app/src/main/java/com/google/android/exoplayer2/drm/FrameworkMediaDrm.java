package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(23)
/* loaded from: classes.dex */
public final class FrameworkMediaDrm implements com.google.android.exoplayer2.drm.ExoMediaDrm<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> {
    private static final java.lang.String CENC_SCHEME_MIME_TYPE = "cenc";
    private final android.media.MediaDrm mediaDrm;
    private final java.util.UUID uuid;

    public static com.google.android.exoplayer2.drm.FrameworkMediaDrm newInstance(java.util.UUID uuid) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        try {
            return new com.google.android.exoplayer2.drm.FrameworkMediaDrm(uuid);
        } catch (android.media.UnsupportedSchemeException e_renamed) {
            throw new com.google.android.exoplayer2.drm.UnsupportedDrmException(1, e_renamed);
        } catch (java.lang.Exception e2) {
            throw new com.google.android.exoplayer2.drm.UnsupportedDrmException(2, e2);
        }
    }

    private FrameworkMediaDrm(java.util.UUID uuid) throws android.media.UnsupportedSchemeException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
        com.google.android.exoplayer2.util.Assertions.checkArgument(!com.google.android.exoplayer2.C_renamed.COMMON_PSSH_UUID.equals(uuid), "Use C_renamed.CLEARKEY_UUID instead");
        this.uuid = uuid;
        this.mediaDrm = new android.media.MediaDrm(adjustUuid(uuid));
        if (com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(uuid) && needsForceWidevineL3Workaround()) {
            forceWidevineL3(this.mediaDrm);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(final com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener<? super com.google.android.exoplayer2.drm.FrameworkMediaCrypto> onEventListener) {
        this.mediaDrm.setOnEventListener(onEventListener == null ? null : new android.media.MediaDrm.OnEventListener() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$FrameworkMediaDrm$zJ3h9UKP9ayPF2iQATh7r7bKJes
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(android.media.MediaDrm mediaDrm, byte[] bArr, int i_renamed, int i2, byte[] bArr2) {
                this.f_renamed$0.lambda$setOnEventListener$0$FrameworkMediaDrm(onEventListener, mediaDrm, bArr, i_renamed, i2, bArr2);
            }
        });
    }

    public /* synthetic */ void lambda$setOnEventListener$0$FrameworkMediaDrm(com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener, android.media.MediaDrm mediaDrm, byte[] bArr, int i_renamed, int i2, byte[] bArr2) {
        onEventListener.onEvent(this, bArr, i_renamed, i2, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(final com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener<? super com.google.android.exoplayer2.drm.FrameworkMediaCrypto> onKeyStatusChangeListener) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            throw new java.lang.UnsupportedOperationException();
        }
        this.mediaDrm.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new android.media.MediaDrm.OnKeyStatusChangeListener() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$FrameworkMediaDrm$WcqXRf-ZlBuRYiaqpRgpL0-wRvg
            @Override // android.media.MediaDrm.OnKeyStatusChangeListener
            public final void onKeyStatusChange(android.media.MediaDrm mediaDrm, byte[] bArr, java.util.List list, boolean z_renamed) {
                this.f_renamed$0.lambda$setOnKeyStatusChangeListener$1$FrameworkMediaDrm(onKeyStatusChangeListener, mediaDrm, bArr, list, z_renamed);
            }
        }, (android.os.Handler) null);
    }

    public /* synthetic */ void lambda$setOnKeyStatusChangeListener$1$FrameworkMediaDrm(com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, android.media.MediaDrm mediaDrm, byte[] bArr, java.util.List list, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            android.media.MediaDrm.KeyStatus keyStatus = (android.media.MediaDrm.KeyStatus) it.next();
            arrayList.add(new com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
        }
        onKeyStatusChangeListener.onKeyStatusChange(this, bArr, arrayList, z_renamed);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws android.media.MediaDrmException {
        return this.mediaDrm.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i_renamed, java.util.HashMap<java.lang.String, java.lang.String> map) throws android.media.NotProvisionedException {
        byte[] bArrAdjustRequestInitData;
        java.lang.String strAdjustRequestMimeType;
        com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = null;
        if (list != null) {
            schemeData = getSchemeData(this.uuid, list);
            bArrAdjustRequestInitData = adjustRequestInitData(this.uuid, schemeData.data);
            strAdjustRequestMimeType = adjustRequestMimeType(this.uuid, schemeData.mimeType);
        } else {
            bArrAdjustRequestInitData = null;
            strAdjustRequestMimeType = null;
        }
        android.media.MediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, bArrAdjustRequestInitData, strAdjustRequestMimeType, i_renamed, map);
        byte[] bArrAdjustRequestData = adjustRequestData(this.uuid, keyRequest.getData());
        java.lang.String defaultUrl = keyRequest.getDefaultUrl();
        if (android.text.TextUtils.isEmpty(defaultUrl) && schemeData != null && !android.text.TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        return new com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest(bArrAdjustRequestData, defaultUrl);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws org.json.JSONException, android.media.DeniedByServerException, android.media.NotProvisionedException {
        if (com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(this.uuid)) {
            bArr2 = com.google.android.exoplayer2.drm.ClearKeyUtil.adjustResponseData(bArr2);
        }
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        android.media.MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws android.media.DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
        this.mediaDrm.release();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.lang.String getPropertyString(java.lang.String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(java.lang.String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(java.lang.String str, java.lang.String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(java.lang.String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws android.media.MediaCryptoException {
        return new com.google.android.exoplayer2.drm.FrameworkMediaCrypto(new android.media.MediaCrypto(adjustUuid(this.uuid), bArr), com.google.android.exoplayer2.util.Util.SDK_INT < 21 && com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(this.uuid) && "L3_renamed".equals(getPropertyString("securityLevel")));
    }

    private static com.google.android.exoplayer2.drm.DrmInitData.SchemeData getSchemeData(java.util.UUID uuid, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        boolean z_renamed;
        if (!com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(uuid)) {
            return list.get(0);
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 28 && list.size() > 1) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = list.get(0);
            int length = 0;
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2 = list.get(i_renamed);
                if (schemeData2.requiresSecureDecryption != schemeData.requiresSecureDecryption || !com.google.android.exoplayer2.util.Util.areEqual(schemeData2.mimeType, schemeData.mimeType) || !com.google.android.exoplayer2.util.Util.areEqual(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.isPsshAtom(schemeData2.data)) {
                    z_renamed = false;
                    break;
                }
                length += schemeData2.data.length;
            }
            z_renamed = true;
            if (z_renamed) {
                byte[] bArr = new byte[length];
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData3 = list.get(i3);
                    int length2 = schemeData3.data.length;
                    java.lang.System.arraycopy(schemeData3.data, 0, bArr, i2, length2);
                    i2 += length2;
                }
                return schemeData.copyWithData(bArr);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData4 = list.get(i4);
            int version = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseVersion(schemeData4.data);
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 && version == 0) {
                return schemeData4;
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23 && version == 1) {
                return schemeData4;
            }
        }
        return list.get(0);
    }

    private static java.util.UUID adjustUuid(java.util.UUID uuid) {
        return (com.google.android.exoplayer2.util.Util.SDK_INT >= 27 || !com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(uuid)) ? uuid : com.google.android.exoplayer2.C_renamed.COMMON_PSSH_UUID;
    }

    private static byte[] adjustRequestInitData(java.util.UUID uuid, byte[] bArr) {
        byte[] schemeSpecificData;
        return (((com.google.android.exoplayer2.util.Util.SDK_INT >= 21 || !com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID.equals(uuid)) && !(com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID.equals(uuid) && "Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && ("AFTB".equals(com.google.android.exoplayer2.util.Util.MODEL) || "AFTS".equals(com.google.android.exoplayer2.util.Util.MODEL) || "AFTM".equals(com.google.android.exoplayer2.util.Util.MODEL)))) || (schemeSpecificData = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(bArr, uuid)) == null) ? bArr : schemeSpecificData;
    }

    private static java.lang.String adjustRequestMimeType(java.util.UUID uuid, java.lang.String str) {
        return (com.google.android.exoplayer2.util.Util.SDK_INT < 26 && com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(uuid) && (com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4.equals(str) || com.google.android.exoplayer2.util.MimeTypes.AUDIO_MP4.equals(str))) ? "cenc" : str;
    }

    private static byte[] adjustRequestData(java.util.UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(uuid) ? com.google.android.exoplayer2.drm.ClearKeyUtil.adjustRequestData(bArr) : bArr;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private static void forceWidevineL3(android.media.MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3_renamed");
    }

    private static boolean needsForceWidevineL3Workaround() {
        return "ASUS_Z00AD".equals(com.google.android.exoplayer2.util.Util.MODEL);
    }
}
