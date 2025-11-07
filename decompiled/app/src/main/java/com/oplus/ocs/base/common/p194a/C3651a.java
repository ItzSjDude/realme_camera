package com.oplus.ocs.base.common.p194a;

import com.heytap.accessory.CommonStatusCodes;

/* renamed from: com.oplus.ocs.base.common.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class C3651a {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25036a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
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
                switch (OplusGLSurfaceView_13) {
                    case CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                        return "AUTHENTICATE_SUCCESS";
                    case 1002:
                        return "AUTHENTICATE_FAIL";
                    case CommonStatusCodes.TIME_EXPIRED /* 1003 */:
                        return "TIME_EXPIRED";
                    case CommonStatusCodes.AUTHCODE_EXPECTED /* 1004 */:
                        return "AUTHCODE_EXPECTED";
                    case CommonStatusCodes.VERSION_INCOMPATIBLE /* 1005 */:
                        return "VERSION_INCOMPATIBLE";
                    case CommonStatusCodes.AUTHCODE_RECYCLE /* 1006 */:
                        return "AUTHCODE_RECYCLE";
                    case CommonStatusCodes.AUTHCODE_INVALID /* 1007 */:
                        return "AUTHCODE_INVALID";
                    case CommonStatusCodes.CAPABILITY_EXCEPTION /* 1008 */:
                        return "CAPABILITY_EXCEPTION";
                    case CommonStatusCodes.INTERNAL_EXCEPTION /* 1009 */:
                        return "STATUS_EXCEPTION";
                    case CommonStatusCodes.PERMISSION_DENIAL /* 1010 */:
                        return "INTERNAL_EXCEPTION";
                    default:
                        StringBuilder sb = new StringBuilder(32);
                        sb.append("unknown status code: ");
                        sb.append(OplusGLSurfaceView_13);
                        return sb.toString();
                }
        }
    }
}
