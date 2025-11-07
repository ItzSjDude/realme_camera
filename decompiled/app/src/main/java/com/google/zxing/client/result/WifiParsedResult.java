package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class WifiParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String anonymousIdentity;
    private final java.lang.String eapMethod;
    private final boolean hidden;
    private final java.lang.String identity;
    private final java.lang.String networkEncryption;
    private final java.lang.String password;
    private final java.lang.String phase2Method;
    private final java.lang.String ssid;

    public WifiParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, false);
    }

    public WifiParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed) {
        this(str, str2, str3, z_renamed, null, null, null, null);
    }

    public WifiParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        super(com.google.zxing.client.result.ParsedResultType.WIFI);
        this.ssid = str2;
        this.networkEncryption = str;
        this.password = str3;
        this.hidden = z_renamed;
        this.identity = str4;
        this.anonymousIdentity = str5;
        this.eapMethod = str6;
        this.phase2Method = str7;
    }

    public java.lang.String getSsid() {
        return this.ssid;
    }

    public java.lang.String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public java.lang.String getIdentity() {
        return this.identity;
    }

    public java.lang.String getAnonymousIdentity() {
        return this.anonymousIdentity;
    }

    public java.lang.String getEapMethod() {
        return this.eapMethod;
    }

    public java.lang.String getPhase2Method() {
        return this.phase2Method;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
        maybeAppend(this.ssid, sb);
        maybeAppend(this.networkEncryption, sb);
        maybeAppend(this.password, sb);
        maybeAppend(java.lang.Boolean.toString(this.hidden), sb);
        return sb.toString();
    }
}
