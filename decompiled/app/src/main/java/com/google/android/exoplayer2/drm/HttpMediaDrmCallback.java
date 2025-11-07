package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(18)
/* loaded from: classes.dex */
public final class HttpMediaDrmCallback implements com.google.android.exoplayer2.drm.MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.Factory dataSourceFactory;
    private final java.lang.String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final java.util.Map<java.lang.String, java.lang.String> keyRequestProperties;

    public HttpMediaDrmCallback(java.lang.String str, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    public HttpMediaDrmCallback(java.lang.String str, boolean z_renamed, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z_renamed;
        this.keyRequestProperties = new java.util.HashMap();
    }

    public void setKeyRequestProperty(java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public void clearKeyRequestProperty(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest provisionRequest) throws java.io.IOException {
        return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + com.google.android.exoplayer2.util.Util.fromUtf8Bytes(provisionRequest.getData()), com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY, null);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest keyRequest) throws java.lang.Exception {
        java.lang.String str;
        java.lang.String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.forceDefaultLicenseUrl || android.text.TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.defaultLicenseUrl;
        }
        java.util.HashMap map = new java.util.HashMap();
        if (com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID.equals(uuid)) {
            str = "text/xml";
        } else {
            str = com.google.android.exoplayer2.C_renamed.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        map.put("Content-Type", str);
        if (com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            map.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, licenseServerUrl, keyRequest.getData(), map);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x006c A_renamed[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #1 {all -> 0x004f, blocks: (B_renamed:10:0x0047, B_renamed:17:0x0053, B_renamed:19:0x0059, B_renamed:28:0x006c, B_renamed:33:0x007d, B_renamed:23:0x0062), top: B_renamed:36:0x0047, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0074 A_renamed[LOOP:1: B_renamed:9:0x002e->B_renamed:32:0x0074, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x007d A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] executePost(com.google.android.exoplayer2.upstream.HttpDataSource.Factory r17, java.lang.String r18, byte[] r19, java.util.Map<java.lang.String, java.lang.String> r20) throws java.io.IOException {
        /*
            com.google.android.exoplayer2.upstream.HttpDataSource r1 = r17.createDataSource()
            if (r20 == 0) goto L2a
            java.util.Set r0 = r20.entrySet()
            java.util.Iterator r0 = r0.iterator()
        Le:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.setRequestProperty(r3, r2)
            goto Le
        L2a:
            r2 = 0
            r0 = r18
            r3 = r2
        L2e:
            com.google.android.exoplayer2.upstream.DataSpec r15 = new com.google.android.exoplayer2.upstream.DataSpec
            android.net.Uri r5 = android.net.Uri.parse(r0)
            r7 = 0
            r9 = 0
            r11 = -1
            r13 = 0
            r14 = 1
            r4 = r15
            r6 = r19
            r4.<init>(r5, r6, r7, r9, r11, r13, r14)
            com.google.android.exoplayer2.upstream.DataSourceInputStream r4 = new com.google.android.exoplayer2.upstream.DataSourceInputStream
            r4.<init>(r1, r15)
            byte[] r0 = com.google.android.exoplayer2.util.Util.toByteArray(r4)     // Catch: java.lang.Throwable -> L4f com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException -> L51
            com.google.android.exoplayer2.util.Util.closeQuietly(r4)
            return r0
        L4f:
            r0 = move-exception
            goto L7e
        L51:
            r0 = move-exception
            r5 = r0
            int r0 = r5.responseCode     // Catch: java.lang.Throwable -> L4f
            r6 = 307(0x133, float:4.3E-43)
            if (r0 == r6) goto L62
            int r0 = r5.responseCode     // Catch: java.lang.Throwable -> L4f
            r6 = 308(0x134, float:4.32E-43)
            if (r0 != r6) goto L60
            goto L62
        L60:
            r0 = r3
            goto L69
        L62:
            int r0 = r3 + 1
            r6 = 5
            if (r3 >= r6) goto L69
            r3 = 1
            goto L6a
        L69:
            r3 = r2
        L6a:
            if (r3 == 0) goto L71
            java.lang.String r3 = getRedirectUrl(r5)     // Catch: java.lang.Throwable -> L4f
            goto L72
        L71:
            r3 = 0
        L72:
            if (r3 == 0) goto L7d
            com.google.android.exoplayer2.util.Util.closeQuietly(r4)
            r16 = r3
            r3 = r0
            r0 = r16
            goto L2e
        L7d:
            throw r5     // Catch: java.lang.Throwable -> L4f
        L7e:
            com.google.android.exoplayer2.util.Util.closeQuietly(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.HttpMediaDrmCallback.executePost(com.google.android.exoplayer2.upstream.HttpDataSource$Factory, java.lang.String, byte[], java.util.Map):byte[]");
    }

    private static java.lang.String getRedirectUrl(com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException invalidResponseCodeException) {
        java.util.List<java.lang.String> list;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = invalidResponseCodeException.headerFields;
        if (map == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
