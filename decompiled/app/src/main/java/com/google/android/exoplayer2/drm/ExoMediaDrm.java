package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public interface ExoMediaDrm<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    public interface OnEventListener<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
        void onEvent(com.google.android.exoplayer2.drm.ExoMediaDrm<? extends T_renamed> exoMediaDrm, byte[] bArr, int i_renamed, int i2, byte[] bArr2);
    }

    public interface OnKeyStatusChangeListener<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
        void onKeyStatusChange(com.google.android.exoplayer2.drm.ExoMediaDrm<? extends T_renamed> exoMediaDrm, byte[] bArr, java.util.List<com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus> list, boolean z_renamed);
    }

    void closeSession(byte[] bArr);

    T_renamed createMediaCrypto(byte[] bArr) throws android.media.MediaCryptoException;

    com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i_renamed, java.util.HashMap<java.lang.String, java.lang.String> map) throws android.media.NotProvisionedException;

    byte[] getPropertyByteArray(java.lang.String str);

    java.lang.String getPropertyString(java.lang.String str);

    com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest getProvisionRequest();

    byte[] openSession() throws android.media.MediaDrmException;

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws android.media.DeniedByServerException, android.media.NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws android.media.DeniedByServerException;

    java.util.Map<java.lang.String, java.lang.String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener<? super T_renamed> onEventListener);

    void setOnKeyStatusChangeListener(com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener<? super T_renamed> onKeyStatusChangeListener);

    void setPropertyByteArray(java.lang.String str, byte[] bArr);

    void setPropertyString(java.lang.String str, java.lang.String str2);

    public static final class KeyStatus {
        private final byte[] keyId;
        private final int statusCode;

        public KeyStatus(int i_renamed, byte[] bArr) {
            this.statusCode = i_renamed;
            this.keyId = bArr;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public byte[] getKeyId() {
            return this.keyId;
        }
    }

    public static final class KeyRequest {
        private final byte[] data;
        private final java.lang.String licenseServerUrl;

        public KeyRequest(byte[] bArr, java.lang.String str) {
            this.data = bArr;
            this.licenseServerUrl = str;
        }

        public byte[] getData() {
            return this.data;
        }

        public java.lang.String getLicenseServerUrl() {
            return this.licenseServerUrl;
        }
    }

    public static final class ProvisionRequest {
        private final byte[] data;
        private final java.lang.String defaultUrl;

        public ProvisionRequest(byte[] bArr, java.lang.String str) {
            this.data = bArr;
            this.defaultUrl = str;
        }

        public byte[] getData() {
            return this.data;
        }

        public java.lang.String getDefaultUrl() {
            return this.defaultUrl;
        }
    }
}
