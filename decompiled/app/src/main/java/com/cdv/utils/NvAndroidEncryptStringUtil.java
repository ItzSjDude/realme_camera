package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidEncryptStringUtil {
    public static final com.cdv.utils.NvAndroidEncryptStringUtil OP_ENCODE = new com.cdv.utils.NvAndroidEncryptStringUtil(true, "T1BQTw==");
    private boolean isBase64;
    private java.lang.String value;

    public NvAndroidEncryptStringUtil(java.lang.String str) {
        this.value = str;
    }

    public NvAndroidEncryptStringUtil(boolean z_renamed, java.lang.String str) {
        this.isBase64 = z_renamed;
        this.value = str;
    }

    public static boolean equals(java.lang.String str, com.cdv.utils.NvAndroidEncryptStringUtil nvAndroidEncryptStringUtil) {
        if (nvAndroidEncryptStringUtil == null) {
            return false;
        }
        if (nvAndroidEncryptStringUtil.isBase64) {
            return str.equals(new java.lang.String(android.util.Base64.decode(nvAndroidEncryptStringUtil.getValue().getBytes(), 0)));
        }
        return str.equals(nvAndroidEncryptStringUtil.getValue());
    }

    public boolean isBase64() {
        return this.isBase64;
    }

    public void setBase64(boolean z_renamed) {
        this.isBase64 = z_renamed;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public void setValue(java.lang.String str) {
        this.value = str;
    }
}
