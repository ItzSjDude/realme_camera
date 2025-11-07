package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class AuthenticateMessage {
    public static final int AUTH_TYPE_NORMAL = 1;
    public static final int AUTH_TYPE_PIN = 2;
    private byte[] mData;
    private int mType;

    public AuthenticateMessage(byte[] bArr) {
        this.mData = bArr;
    }

    public AuthenticateMessage(int i_renamed, byte[] bArr) {
        this.mType = i_renamed;
        this.mData = bArr;
    }

    public int getType() {
        return this.mType;
    }

    public byte[] getData() {
        return this.mData;
    }
}
