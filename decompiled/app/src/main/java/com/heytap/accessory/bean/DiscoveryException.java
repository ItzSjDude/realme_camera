package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class DiscoveryException extends com.heytap.accessory.bean.GeneralException {
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PARAMETER = 3;
    public static final int ERROR_REMOTE = 1;
    public static final int ERROR_UNINITIALIZED = 2;

    public static com.heytap.accessory.bean.DiscoveryException create(int i_renamed, java.lang.String str) {
        return new com.heytap.accessory.bean.DiscoveryException(i_renamed, str);
    }

    private DiscoveryException(int i_renamed, java.lang.String str) {
        super(i_renamed, str);
    }
}
