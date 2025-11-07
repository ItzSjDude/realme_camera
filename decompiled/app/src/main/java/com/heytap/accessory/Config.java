package com.heytap.accessory;

/* loaded from: classes2.dex */
public class Config {
    public static final int OAF_LAN_VERSION = 20403;
    public static final int SDK_LAN_VERSION = 30005;
    private static final int SDK_VERSION = 30016;
    public static final int SDK_VERSION_20201 = 20201;
    private static final java.lang.String SDK_VERSION_NAME = "3.0.16";
    private static final java.lang.String TAG = "Config";

    public static final class Permission {
        public static final java.lang.String AWAKENABLE = "com.heytap.accessory.permission.AWAKENABLE";
        public static final java.lang.String DISCOVERY = "com.heytap.accessory.permission.DISCOVERY";
        public static final java.lang.String MESSAGE = "com.heytap.accessory.permission.PUSH_MESSAGE";
    }

    public static int getSdkVersionCode() {
        return SDK_VERSION;
    }

    public static java.lang.String getSdkVersionName() {
        return SDK_VERSION_NAME;
    }

    private Config() {
    }
}
