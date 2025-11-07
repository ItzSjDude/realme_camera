package com.oplus.shield.authcode;

/* compiled from: CommonStatusCodes.java */
/* loaded from: classes2.dex */
public class c_renamed {
    public static java.lang.String a_renamed(int i_renamed) {
        switch (i_renamed) {
            case com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                return "AUTHENTICATE_SUCCESS";
            case 1002:
                return "AUTHENTICATE_FAIL";
            case com.heytap.accessory.CommonStatusCodes.TIME_EXPIRED /* 1003 */:
                return "TIME_EXPIRED";
            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_EXPECTED /* 1004 */:
                return "AUTHCODE_EXPECTED";
            case com.heytap.accessory.CommonStatusCodes.VERSION_INCOMPATIBLE /* 1005 */:
                return "VERSION_INCOMPATIBLE";
            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_RECYCLE /* 1006 */:
                return "AUTHCODE_RECYCLE";
            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_INVALID /* 1007 */:
                return "AUTHCODE_INVALID";
            case com.heytap.accessory.CommonStatusCodes.CAPABILITY_EXCEPTION /* 1008 */:
                return "CAPABILITY_EXCEPTION";
            case com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION /* 1009 */:
                return "INTERNAL_EXCEPTION";
            case com.heytap.accessory.CommonStatusCodes.PERMISSION_DENIAL /* 1010 */:
                return "NONE_PERMISSION";
            default:
                return "unknown status code: " + i_renamed;
        }
    }
}
