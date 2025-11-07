package com.oplus.ocs.base.common.a_renamed;

/* loaded from: classes2.dex */
public class a_renamed {
    public static java.lang.String a_renamed(int i_renamed) {
        switch (i_renamed) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
                return "CONNECTED";
            case 2:
                return "CONNECTING";
            case 3:
                return "CONNECT_FAILED";
            case 4:
                return "DISCONNECT";
            case 5:
                return "SUCCESS_UNBIND";
            case 6:
                return "CANCELED";
            case 7:
                return "INTERNAL_ERROR";
            case 8:
                return "TASK_NULL";
            case 9:
                return "INTERRUPTED";
            case 10:
                return "TIMEOUT";
            case 11:
                return "API_NOT_CONNECTED";
            case 12:
                return "CLIENT_UNKNOWN";
            case 13:
                return "SERVICE_ABNORMAL_EXIT";
            case 14:
                return "RECONNECTING";
            default:
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
                        return "STATUS_EXCEPTION";
                    case com.heytap.accessory.CommonStatusCodes.PERMISSION_DENIAL /* 1010 */:
                        return "INTERNAL_EXCEPTION";
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
                        sb.append("unknown status code: ");
                        sb.append(i_renamed);
                        return sb.toString();
                }
        }
    }
}
