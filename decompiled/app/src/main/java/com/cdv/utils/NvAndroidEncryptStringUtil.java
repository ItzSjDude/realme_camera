package com.cdv.utils;

import android.util.Base64;

/* loaded from: classes.dex */
public class NvAndroidEncryptStringUtil {
    public static final NvAndroidEncryptStringUtil OP_ENCODE = new NvAndroidEncryptStringUtil(true, "T1BQTw==");
    private boolean isBase64;
    private String value;

    public NvAndroidEncryptStringUtil(String str) {
        this.value = str;
    }

    public NvAndroidEncryptStringUtil(boolean z, String str) {
        this.isBase64 = z;
        this.value = str;
    }

    public static boolean equals(String str, NvAndroidEncryptStringUtil nvAndroidEncryptStringUtil) {
        if (nvAndroidEncryptStringUtil == null) {
            return false;
        }
        if (nvAndroidEncryptStringUtil.isBase64) {
            return str.equals(new String(Base64.decode(nvAndroidEncryptStringUtil.getValue().getBytes(), 0)));
        }
        return str.equals(nvAndroidEncryptStringUtil.getValue());
    }

    public boolean isBase64() {
        return this.isBase64;
    }

    public void setBase64(boolean z) {
        this.isBase64 = z;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
